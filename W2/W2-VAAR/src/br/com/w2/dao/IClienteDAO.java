/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.w2.dao;

import br.com.w2.model.Cliente;
import java.util.List;

/**
 *
 * @author VAAR
 */
public interface IClienteDAO {
    
    public void salvar(Cliente c) throws Exception;
    
    public Cliente buscar(long id) throws Exception;
    
    public void editar(Cliente c) throws Exception;
    
    public List<Cliente> listar() throws Exception;
    
    public void excluir(Cliente c) throws Exception;
}
