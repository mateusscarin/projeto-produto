package br.com.produto.dao;

import br.com.produto.model.Produto;
import br.com.produto.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int idObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
