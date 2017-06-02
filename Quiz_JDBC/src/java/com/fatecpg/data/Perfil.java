package com.fatecpg.data;

import br.com.fatecpg.helpers.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Perfil {
    private Integer _id;
    private String _descricao;
    
    // ### CONSTRUTORES ###
    public Perfil(String papel) {
        this._descricao = papel;
    }

    public Perfil(Integer id, String papel) {
        this._id = id;
        this._descricao = papel;
    }
    
    // ### GETTERS E SETTERS
    public int getId() {
        return _id;
    }

    public String getDescricao() {
        return _descricao;
    }

    public void setDescricao(String papel) {
        this._descricao = papel;
    }

    // ### OPERAÇÕES NO BANCO ###
    // ------- CREATE ---------------------
    public boolean store() throws SQLException {
        try (Connection connection = ConnectionFactory.getConnection()) {
            try (Statement statement = connection.createStatement()){
                
                String SQL = String.format("INSERT INTO PERFIL(DESCRICAO) VALUES('%s')", this._descricao);

                statement.execute(SQL, Statement.RETURN_GENERATED_KEYS);

                try (ResultSet rs = statement.getGeneratedKeys()) {
                    if (rs.next()) {
                        this._id = rs.getInt(1);
                    }
                } catch (Exception ex) {
                    System.out.println("Erro ao recuperar a GeneratedKey: "  + ex.getMessage());
                }
                
                statement.close();

                if (this._id != null) {
                    return true;
                }
            } catch (Exception ex) {
                System.out.println("Erro ao inserir o Perfil: "  + ex.getMessage());
            }
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar ao banco de dados: "  + ex.getMessage());
        }
        return false;
    }
    
    // ------- READ -----------------------
    // Busca uma Questão pelo ID
    public static Perfil find(Integer id) throws SQLException {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement pstatement = connection.prepareStatement(String.format("SELECT * FROM PERFIL WHERE ID = ?"));
            pstatement.setInt(1, id);
            
            try (ResultSet result = pstatement.executeQuery()) {
                if (result.next()) {
                    return new Perfil(
                            result.getInt("ID"),
                            result.getString("DESCRICAO")
                    );
                }
            } catch (Exception ex) {
                System.out.println("Erro ao consultar o Perfil: "  + ex.getMessage());
            }
            
            connection.close();
        } catch (Exception ex) {
            System.out.println("Erro ao obter conexão com o banco de dados: "  + ex.getMessage());
        }

        return null;
    }
    
    // Retorn todos os registros
    public static ArrayList<Perfil> all() throws SQLException {
        ArrayList<Perfil> perfis = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM PERFIL");

            while (result.next()) {
                perfis.add(new Perfil(
                        result.getInt("ID"),
                        result.getString("TEXTO")
                ));
            }
        } catch (Exception ex) {
            System.out.println("Erro ao obter conexão com o banco de dados: "  + ex.getMessage());
        }

        return perfis;
    }
    
    // ------- UPDATE ---------------------
    public boolean update() throws SQLException {
        try {
            int linhasAlteradas = 0;
            try (Connection connection = ConnectionFactory.getConnection()) {
                String SQL = String.format(
                        "UPDATE PERFIL SET DESCRICAO = '%s' WHERE ID = %d",
                        this._descricao,
                        this._id
                );
                
                try (Statement statement = connection.createStatement()) {
                    linhasAlteradas = statement.executeUpdate(SQL);
                } catch (Exception ex) {
                    System.out.println("Erro ao atualizar Perfil: " + ex.getMessage());
                }
            }
            
            return linhasAlteradas > 0;
        } catch (SQLException ex) {
            System.out.println("Erro ao obter conexão com o banco de dados: "  + ex.getMessage());
        }
        return false;
    }
    
    // ------- DELETE ---------------------
    public boolean delete() throws SQLException {   
        try (Connection connection = ConnectionFactory.getConnection()) {
            try (PreparedStatement pstatement = connection.prepareStatement("DELETE FROM PERFIL WHERE ID = ?")) {
                pstatement.setInt(1, this._id);
                pstatement.execute();
            } catch (Exception ex) {
                System.out.println("Erro ao excluir o Perfil: "  + ex.getMessage());
            }
            
            connection.close();
            
            if (Alternativa.find(this._id) == null) { 
                return true;
            }
        } catch (Exception ex) {
            System.out.println("Erro ao obter conexão com o banco de dados: "  + ex.getMessage());
        }

        return false;
    }
    
    // ### RELACIONAMENTOS ###
    public ArrayList<Usuario> getUsuarios() {
        try {
            return Usuario.all(this._id);
        } catch (SQLException ex) {
            System.out.println("Erro ao obter Usuários: "  + ex.getMessage());
        }
        return null;
    }
}
