package br.com.produto.dao;

import br.com.produto.model.Produto;
import br.com.produto.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mateus Scarin
 */
public class ProdutoDAOImpl implements GenericDAO<Produto> {

    private Connection conn;
    private Statement stmt;
    private ResultSet rs;

    public ProdutoDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Produto produto) {
        PreparedStatement stmt = null;
        String sql = "insert into produto(nome, descricao) values (?, ?)";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.execute();
            return Boolean.TRUE;
        } catch (SQLException e) {
            System.out.println("Problema ao cadastrar produto! \n Erro: " + e.getMessage());
            e.printStackTrace();
        } finally {
            closeConnection(conn, stmt, null);
        }
        return Boolean.FALSE;
    }

    @Override
    public List<Object> listar() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Object> resultado = new ArrayList<>();

        String sql = "select * from produto";

        try {
            stmt = conn.prepareCall(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                resultado.add(new Produto(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao")));
            }
        } catch (SQLException e) {
            System.out.println("Problemas ao listar produtos! \nErro: " + e.getMessage());
            e.printStackTrace();
        } finally {
            closeConnection(conn, stmt, rs);
        }
        return resultado;
    }

    @Override
    public void excluir(int idObject) {
        PreparedStatement stmt = null;

        String sql = "delete from produto where id = ?";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao excluir produto! Erro: " + e.getMessage());
            e.printStackTrace();
        } finally {
            closeConnection(conn, stmt, null);
        }
    }

    @Override
    public Object carregar(int idObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean alterar(Produto object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void closeConnection(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        } catch (Exception e) {
            System.out.println("Problema ao fechar conexão! \n Erro: " + e.getMessage());
        }
    }

}
