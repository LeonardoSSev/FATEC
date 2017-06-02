package com.fatecpg.data;

import br.com.fatecpg.helpers.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Usuario {

    private Integer _id;
    private String _nome;
    private String _username;
    private String _password;
    private Integer _perfilId;

    // ### CONSTRUTORES ###
    public Usuario(Integer id, String username, String nome, String password, Integer perfilId) {
        this._id = id;
        this._username = username;
        this._nome = nome;
        this._password = password;
        this._perfilId = perfilId;
    }

    public Usuario(String username, String nome, String password, Integer perfilId) {
        this._username = username;
        this._nome = nome;
        this._password = password;
        this._perfilId = perfilId;
    }
    
    public Usuario(String username, String password){
        this._username = username;
        this._password = password;
    }

    // ### GETTERS E SETTERS
    public Integer getId() {
        return _id;
    }

    public String getNome() {
        return _nome;
    }

    public String getUsername() {
        return _username;
    }

    public void setUsername(String _username) {
        this._username = _username;
    }

    public void setNome(String _nome) {
        this._nome = _nome;
    }

    public String getPassword() {
        return _password;
    }

    public void setPassword(String _password) {
        this._password = _password;
    }

    public Integer getPerfilId() {
        return _perfilId;
    }

    public void setPerfilId(Integer perfilId) {
        this._perfilId = perfilId;
    }

    public boolean isAdmin() {
        return this.getPerfil().getDescricao().equals("admin");
    }

    // ### OPERAÇÕES NO BANCO ###
    // ------- CREATE ---------------------
    public boolean store() throws SQLException {
        try (Connection connection = ConnectionFactory.getConnection()) {
            try (Statement statement = connection.createStatement()) {

                String SQL = String.format(
                        "INSERT INTO USUARIO(USERNAME, NOME, SENHA, PERFIL_ID) VALUES('%s', '%s', '%s', %d)",
                        this._username, this._nome, this._password, this._perfilId);

                statement.execute(SQL, Statement.RETURN_GENERATED_KEYS);

                try (ResultSet rs = statement.getGeneratedKeys()) {
                    if (rs.next()) {
                        this._id = rs.getInt(1);
                    }
                } catch (Exception ex) {
                    System.out.println("Erro ao recuperar a GeneratedKey: " + ex.getMessage());
                }

                statement.close();

                if (this._id != null) {
                    return true;
                }
            } catch (Exception ex) {
                System.out.println("Erro ao inserir o Usuário: " + ex.getMessage());
            }
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar ao banco de dados: " + ex.getMessage());
        }
        return false;
    }

    // ------- READ -----------------------
    // Busca um Usuário pelo ID
    public static Usuario find(Integer id) throws SQLException {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement pstatement = connection.prepareStatement(String.format("SELECT * FROM USUARIO WHERE ID = ?"));
            pstatement.setInt(1, id);

            try (ResultSet result = pstatement.executeQuery()) {
                if (result.next()) {
                    return new Usuario(
                            result.getInt("ID"),
                            result.getString("USERNAME"),
                            result.getString("NOME"),
                            result.getString("SENHA"),
                            result.getInt("PERFIL_ID")
                    );
                }
            } catch (Exception ex) {
                System.out.println("Erro ao consultar o Usuário: " + ex.getMessage());
            }

            connection.close();
        } catch (Exception ex) {
            System.out.println("Erro ao obter conexão com o banco de dados: " + ex.getMessage());
        }

        return null;
    }
    
    //Busca um Usuário pelo Username
    public static Usuario findByUsername(String username) throws SQLException {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement pstatement = connection.prepareStatement(String.format("SELECT * FROM USUARIO WHERE USERNAME = ?"));
            pstatement.setString(1, username);

            try (ResultSet result = pstatement.executeQuery()) {
                if (result.next()) {
                    return new Usuario(
                            result.getInt("ID"),
                            result.getString("USERNAME"),
                            result.getString("NOME"),
                            result.getString("SENHA"),
                            result.getInt("PERFIL_ID")
                    );
                }
            } catch (Exception ex) {
                System.out.println("Erro ao consultar o Usuário: " + ex.getMessage());
            }

            connection.close();
        } catch (Exception ex) {
            System.out.println("Erro ao obter conexão com o banco de dados: " + ex.getMessage());
        }

        return null;
    }

    // Retorn todos os registros
    public static ArrayList<Usuario> all() throws SQLException {
        ArrayList<Usuario> usuarios = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM USUARIO");

            while (result.next()) {
                usuarios.add(new Usuario(
                        result.getInt("ID"),
                        result.getString("USERNAME"),
                        result.getString("NOME"),
                        result.getString("SENHA"),
                        result.getInt("PERFIL_ID")
                ));
            }
        } catch (Exception ex) {
            System.out.println("Erro ao obter conexão com o banco de dados: " + ex.getMessage());
        }

        return usuarios;
    }

    // Retorn todos os usuários de um perfil
    public static ArrayList<Usuario> all(int perfilId) throws SQLException {
        ArrayList<Usuario> usuarios = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM USUARIO WHERE PERFIL_ID = " + perfilId);

            while (result.next()) {
                usuarios.add(new Usuario(
                        result.getInt("ID"),
                        result.getString("USERNAME"),
                        result.getString("NOME"),
                        result.getString("SENHA"),
                        result.getInt("PERFIL_ID")
                ));
            }
        } catch (Exception ex) {
            System.out.println("Erro ao obter conexão com o banco de dados: " + ex.getMessage());
        }

        return usuarios;
    }
    
    // ------- UPDATE ---------------------
    public boolean update() throws SQLException {
        try {
            int linhasAlteradas = 0;
            try (Connection connection = ConnectionFactory.getConnection()) {
                String SQL = String.format(
                        "UPDATE USUARIO SET NOME = '%s', USERNAME = '%s', PERFIL_ID = %d WHERE ID = %d",
                        this._nome,
                        this._username,
                        this._perfilId,
                        this._id
                );
                
                try (Statement statement = connection.createStatement()) {
                    linhasAlteradas = statement.executeUpdate(SQL);
                } catch (Exception ex) {
                    System.out.println("Erro ao atualizar Usuário: " + ex.getMessage());
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
            try (PreparedStatement pstatement = connection.prepareStatement("DELETE FROM USUARIO WHERE ID = ?")) {
                pstatement.setInt(1, this._id);
                pstatement.execute();
            } catch (Exception ex) {
                System.out.println("Erro ao excluir o Usuário: " + ex.getMessage());
            }

            connection.close();

            if (Alternativa.find(this._id) == null) {
                return true;
            }
        } catch (Exception ex) {
            System.out.println("Erro ao obter conexão com o banco de dados: " + ex.getMessage());
        }

        return false;
    }
    
    public static boolean hasUsername(String username) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            try (PreparedStatement pstatement = connection.prepareStatement("SELECT * FROM USUARIO WHERE USERNAME = ?")) {
                pstatement.setString(1, username);
                pstatement.execute();
                
                ResultSet rs = pstatement.getResultSet();
                
                if (rs.next()) {
                    return true;
                } 
            } catch (Exception ex) {
                System.out.println("Erro ao buscar usuário: " + ex.getMessage());
            }
            
            connection.close();
        } catch (Exception ex) {
            System.out.println("Erro ao obter conexão com o banco de dados: " + ex.getMessage());
        }

        return false;
    }
    
    //VERIFICA USUÁRIO CADASTRADO
    public static boolean jaCadastrado(String username, String senha){
        try (Connection connection = ConnectionFactory.getConnection()) {
            try (PreparedStatement pstatement = connection.prepareStatement("SELECT * FROM USUARIO WHERE USERNAME = ? AND SENHA = ?")) {
                pstatement.setString(1, username);
                pstatement.setString(2, senha);
                pstatement.execute();
                
                ResultSet rs = pstatement.getResultSet();
                
                if (rs.next()) {
                    return true;
                } 
            } catch (Exception ex) {
                System.out.println("Erro ao buscar usuário: " + ex.getMessage());
            }
            
            connection.close();
        } catch (Exception ex) {
            System.out.println("Erro ao obter conexão com o banco de dados: " + ex.getMessage());
        }

        return false;
    }

    // ### RELACIONAMENTOS ###
    public Perfil getPerfil() {
        try {
            return Perfil.find(this._perfilId);
        } catch (SQLException ex) {
            System.out.println("Erro ao obter Perfil: " + ex.getMessage());
        }
        return null;
    }
    
    public ArrayList<Partida> getPartidas() {
        try {
            return Partida.all(this._id);
        } catch (SQLException ex) {
            System.out.println("Não foi possível carregar as partidas: " + ex.getMessage());
        }
        return null;
    }
}
