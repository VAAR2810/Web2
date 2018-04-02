/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.w2.dao;

import br.com.w2.model.Livro;
import java.util.List;

/**
 *
 * @author VAAR
 */
public interface ILivroDAO {
    
    public void salvar(Livro li) throws Exception;
    
    public Livro buscar(long id) throws Exception;
    
    public void editar(Livro li) throws Exception;
    
    public List<Livro> listar() throws Exception;
    
    public void excluir(Livro li) throws Exception;
}
