package com.fatecpg.data;

import br.com.fatecpg.helpers.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Alternativa {
    private Integer _id;
    private String _texto;
    private boolean _correta;
    private int _questaoId;
    
    // ### CONSTRUTORES ###
    public Alternativa(String texto, boolean correta, int questionId) {
        this._texto = texto;
        this._correta = correta;
        this._questaoId = questionId;
    }

    public Alternativa(Integer id, String texto, boolean correta, int questionId) {
        this._id = id;
        this._texto = texto;
        this._correta = correta;
        this._questaoId = questionId;
    }

    // ### GETTERS E SETTERS ###
    public int getId() {
        return _id;
    }

    public String getTexto() {
        return _texto;
    }

    public void setTexto(String texto) {
        this._texto = texto;
    }

    public boolean isCorreta() {
        return _correta;
    }

    public void setCorreta(boolean correta) {
        this._correta = correta;
    }

    public int getQuestaoId() {
        return _questaoId;
    }

    public void setQuestaoId(int _questaoId) {
        this._questaoId = _questaoId;
    }

    // ### OPERAÇÕES NO BANCO ###
    // ------- CREATE ---------------------
    // Insere o registro no banco de dados de acordo com os atributos do objeto
    public boolean store() throws SQLException {
        try (Connection connection = ConnectionFactory.getConnection()) {
            try {
                Statement statement = connection.createStatement();
                String SQL = String.format("INSERT INTO ALTERNATIVA(TEXTO, CORRETA, QUESTAO_ID) VALUES('%s', %b, %d)", this._texto, this._correta, this._questaoId);

                statement.execute(SQL, Statement.RETURN_GENERATED_KEYS);

                ResultSet rs = statement.getGeneratedKeys();

                if (rs.next()) {
                    this._id = rs.getInt(1);
                }

                rs.close();

                if (this._id != null) {
                    return true;
                }
            } catch (SQLException ex) {
                throw ex;
            }
            connection.close();
        }
        return false;
    }
    
    // ------- READ -----------------------
    // Busca uma alternativa pelo ID
    public static Alternativa find(Integer id) throws SQLException {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement pstatement = connection.prepareStatement(String.format("SELECT * FROM ALTERNATIVA WHERE ID = ?"));
            pstatement.setInt(1, id);
            
            try (ResultSet result = pstatement.executeQuery()) {
                if (result.next()) {
                    return new Alternativa(
                            result.getInt("ID"),
                            result.getString("TEXTO"),
                            result.getBoolean("CORRETA"),
                            result.getInt("QUESTAO_ID")
                    );
                }
            } catch (Exception ex) {
                System.out.println("Erro ao consultar a Alternativa: "  + ex.getMessage());
            }
            
            connection.close();
        } catch (Exception ex) {
            System.out.println("Erro ao obter conexão com o banco de dados: "  + ex.getMessage());
        }

        return null;
    }
    
    // Retorna todas as alternativas
    public static ArrayList<Alternativa> all() throws SQLException {
        ArrayList<Alternativa> alternativas = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM ALTERNATIVA");

            while (result.next()) {
                alternativas.add(new Alternativa(
                        result.getInt("ID"),
                        result.getString("TEXTO"),
                        result.getBoolean("CORRETA"),
                        result.getInt("QUESTAO_ID")
                ));
            }
        } catch (Exception ex) {
            System.out.println("Erro ao obter conexão com o banco de dados: "  + ex.getMessage());
        }

        return alternativas;
    }
    
    // Retorna todas alternativas da Questão informada pelo ID
    public static ArrayList<Alternativa> all(int questaoId) throws SQLException {
        ArrayList<Alternativa> alternativas = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM ALTERNATIVA WHERE QUESTAO_ID = " + questaoId);

            while (result.next()) {
                alternativas.add(new Alternativa(
                        result.getInt("ID"),
                        result.getString("TEXTO"),
                        result.getBoolean("CORRETA"),
                        result.getInt("QUESTAO_ID")
                ));
            }
        } catch (Exception ex) {
            System.out.println("Erro ao obter conexão com o banco de dados: "  + ex.getMessage());
        }

        return alternativas;
    }
    
    // ------- UPDATE ---------------------
    // Atualiza o registro no banco de acordo com as modificações feitas no objeto
    public boolean update() throws SQLException {
        try {
            int linhasAlteradas = 0;
            try (Connection connection = ConnectionFactory.getConnection()) {
                String SQL = String.format(
                        "UPDATE ALTERNATIVA SET TEXTO = '%s', CORRETA = %b, QUESTAO_ID = %d WHERE ID = %d",
                        this._texto,
                        this._correta,
                        this._questaoId,
                        this._id
                );
                
                try (Statement statement = connection.createStatement()) {
                    linhasAlteradas = statement.executeUpdate(SQL);
                } catch (Exception ex) {
                    System.out.println("Erro ao atualizar Alternativa: " + ex.getMessage());
                }
            }
            
            return linhasAlteradas > 0;
        } catch (SQLException ex) {
            System.out.println("Erro ao obter conexão com o banco de dados: "  + ex.getMessage());
        }
        return false;
    }
    
    // ------- DELETE ---------------------
    // Remove registro do banco de dados
    public boolean delete() throws SQLException {
        try (Connection connection = ConnectionFactory.getConnection()) {
            try (PreparedStatement pstatement = connection.prepareStatement("DELETE FROM ALTERNATIVA WHERE ID = ?")) {
                pstatement.setInt(1, this._id);
                pstatement.execute();
            } catch (Exception ex) {
                System.out.println("Erro ao excluir a Alternativa: "  + ex.getMessage());
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
    
    // ------- RELACIONAMENTO -------------
    // Retorna a Questão da qual a alternativa pertence
    public Questao getQuestao() {
        try {
            return Questao.find(this._questaoId);
        } catch (SQLException ex) {
            System.out.println("Não foi possível carregar a Questão: " + ex.getMessage());
        }
        return null;
    }
}