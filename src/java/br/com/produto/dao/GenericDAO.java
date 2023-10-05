package br.com.produto.dao;

import java.util.List;

/**
 *
 * @author Mateus Scarin
 * @param <T>
 */
public interface GenericDAO<T> {

    public Boolean cadastrar(T object);

    public List<Object> listar();

    public void excluir(int idObject);

    public Object carregar(int idObject);

    public Boolean alterar(T object);

}
