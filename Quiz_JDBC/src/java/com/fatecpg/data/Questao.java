package com.fatecpg.data;

import br.com.fatecpg.helpers.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

public class Questao {
    private Integer _id;
    private String _texto;
    
    // ### CONSTRUTORES ###
    public Questao(int id, String texto) {
        this._id = id;
        this._texto = texto;
    }

    public Questao(String texto) {
        this._texto = texto;
    }
    
    // ### GETTERS E SETTERS ###
    public Integer getId() {
        return _id;
    }

    public String getTexto() {
        return _texto;
    }

    public void setTexto(String texto) {
        this._texto = texto;
    }
    
    // ### OPERAÇÕES NO BANCO ###
    // ------- CREATE ---------------------
    public boolean store() throws SQLException {
        try (Connection connection = ConnectionFactory.getConnection()) {
            try (Statement statement = connection.createStatement()){
                
                String SQL = String.format("INSERT INTO QUESTAO(TEXTO) VALUES('%s')", this._texto);

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
                System.out.println("Erro ao consultar a Questão: "  + ex.getMessage());
            }
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar ao banco de dados: "  + ex.getMessage());
        }
        return false;
    }
    
    // ------- READ -----------------------
    // Busca uma Questão pelo ID
    public static Questao find(Integer id) throws SQLException {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement pstatement = connection.prepareStatement(String.format("SELECT * FROM QUESTAO WHERE ID = ?"));
            pstatement.setInt(1, id);
            
            try (ResultSet result = pstatement.executeQuery()) {
                if (result.next()) {
                    return new Questao(
                            result.getInt("ID"),
                            result.getString("TEXTO")
                    );
                }
            } catch (Exception ex) {
                System.out.println("Erro ao consultar a Questão: "  + ex.getMessage());
            }
            
            connection.close();
        } catch (Exception ex) {
            System.out.println("Erro ao obter conexão com o banco de dados: "  + ex.getMessage());
        }

        return null;
    }
    
    // Retorna todos os registros
    public static ArrayList<Questao> all() throws SQLException {
        ArrayList<Questao> questoes = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM QUESTAO");

            while (result.next()) {
                questoes.add(new Questao(
                        result.getInt("ID"),
                        result.getString("TEXTO")
                ));
            }
        } catch (Exception ex) {
            System.out.println("Erro ao obter conexão com o banco de dados: "  + ex.getMessage());
        }

        return questoes;
    }
    
    public static ArrayList<Questao> getRandom() throws SQLException {
        ArrayList<Questao> questoes = Questao.all();
        
        Collections.shuffle(questoes);
        
        return questoes; 
    }
    
    // ------- UPDATE ---------------------
    public boolean update() throws SQLException {
        try {
            int linhasAlteradas = 0;
            try (Connection connection = ConnectionFactory.getConnection()) {
                String SQL = String.format(
                        "UPDATE QUESTAO SET TEXTO = '%s' WHERE ID = %d",
                        this._texto,
                        this._id
                );
                
                try (Statement statement = connection.createStatement()) {
                    linhasAlteradas = statement.executeUpdate(SQL);
                } catch (Exception ex) {
                    System.out.println("Erro ao atualizar Questão: " + ex.getMessage());
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
            try (PreparedStatement pstatement = connection.prepareStatement("DELETE FROM QUESTAO WHERE ID = ?")) {
                pstatement.setInt(1, this._id);
                pstatement.execute();
            } catch (Exception ex) {
                System.out.println("Erro ao excluir a Questão: "  + ex.getMessage());
            }
            
            connection.close();
            
            if (Questao.find(this._id) == null) { 
                return true;
            }
        } catch (Exception ex) {
            System.out.println("Erro ao obter conexão com o banco de dados: "  + ex.getMessage());
        }

        return false;
    }

    // ------- RELACIONAMENTO -------------
    public ArrayList<Alternativa> getAlternativas() {
        try {
            return Alternativa.all(this._id);
        } catch (SQLException ex) {
            System.out.println("Não foi possível carregar as alternativas: " + ex.getMessage());
        }
        return null;
    }
}
