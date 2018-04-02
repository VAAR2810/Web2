/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.w2.main;

import br.com.w2.dao.ClienteDAO;
import br.com.w2.dao.PersistenceUtil;
import java.util.List;
import java.util.Scanner;
import br.com.w2.model.Cliente;
import br.com.w2.dao.IClienteDAO;
import br.com.w2.dao.ILivroDAO;
import br.com.w2.dao.LivroDAO;
import br.com.w2.model.Livro;

/**
 *
 * @author VAAR
 */
public class HIBERNATE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        IClienteDAO dao = new ClienteDAO();
        ILivroDAO lidao = new LivroDAO();
        Scanner input = new Scanner(System.in);
        String op = "";
        Cliente c = null;
        Livro li = null;
        String idString = "";
        long id = 0;
        String rua = "";
        String numero = "";
        
        
        while (!op.equals("0")) {

            System.out.println("MENU CLIENTE");
            System.out.println("1 - CADASTRAR CLIENTE");
            System.out.println("2 - EDITAR CLIENTE");
            System.out.println("3 - LISTAR CLIENTE");
            System.out.println("4 - EXCLUIR CLIENTE");
            System.out.println("");
            System.out.println("MENU LIVRO");
            System.out.println("5 - CADASTRAR LIVRO");
            System.out.println("6 - EDITAR LIVRO");
            System.out.println("7 - LISTAR LIVRO");
            System.out.println("8 - EXCLUIR LIVRO");
            System.out.println("0 - SAIR");

            op = input.nextLine();

            switch (op) {
                case "1":

                    System.out.println("CADASTRO DE CLIENTE");
                    System.out.println("Nome: ");
                    String nome = input.nextLine();
                    System.out.println("E-mail: ");
                    String email = input.nextLine();
                    System.out.println("Rua: ");
                    rua = input.nextLine();
                    System.out.println("Número: ");
                    numero = input.nextLine();
                    
                    c = new Cliente();
                    c.setNome(nome);
                    c.setEmail(email);
                    c.getEndereco().setRua(rua);
                    c.getEndereco().setNumero(numero);
                    
                    dao.salvar(c);

                    System.out.println("CLIENTE CADASTRADO");
                    break;
                case "2":

                    System.out.println("EDITANDO CLIENTE");
                    System.out.println("Id:");
                    idString = input.nextLine();
                    id = Long.parseLong(idString);

                    c = dao.buscar(id);

                    if (c != null) {

                        System.out.println("Novo Nome: ");
                        String novoNome = input.nextLine();
                        System.out.println("Novo E-mail: ");
                        String novoEmail = input.nextLine();

                        c.setNome(novoNome);
                        c.setEmail(novoEmail);

                        dao.editar(c);
                        System.out.println("CLIENTE EDITADO");

                    } else {
                        System.out.println("CLIENTE NÃO ENCONTRADO");
                    }

                    break;
                case "3":
                    
                    System.out.println("LISTANDO CLIENTES");

                    List<Cliente> lista = dao.listar();

                    for (Cliente ct : lista) {
                        System.out.println(ct);
                    }
                    break;
                case "4":

                    System.out.println("EXCLUINDO CLIENTE");
                    System.out.println("Id:");
                    idString = input.nextLine();
                    id = Long.parseLong(idString);

                    c = dao.buscar(id);

                    if (c != null) {

                        dao.excluir(c);

                        System.out.println("CLIENTE REMOVIDO");
                    } else {
                        System.out.println("CLIENTE NÃO ENCONTRADO");
                    }

                    break;
                case "5":

                    System.out.println("CADASTRO DE LIVRO");
                    System.out.println("Título: ");
                    String titulo = input.nextLine();
                    System.out.println("Autor: ");
                    String autor = input.nextLine();
                    System.out.println("Editora: ");
                    String editora = input.nextLine();
                    System.out.println("Gênero: ");
                    String genero = input.nextLine();
                    
                    li = new Livro();
                    li.setTitulo(titulo);
                    li.setAutor(autor);
                    li.setEditora(editora);
                    li.getSecao().setGenero(genero);

                    lidao.salvar(li);
                    System.out.println("LIVRO CADASTRADO");
                    
                    break;
                case "6":

                    System.out.println("EDITANDO LIVRO");
                    System.out.println("Id:");
                    idString = input.nextLine();
                    id = Long.parseLong(idString);

                    li = lidao.buscar(id);

                    if (li != null) {

                        System.out.println("Título: ");
                        String novoTitulo = input.nextLine();
                        System.out.println("Autor: ");
                        String novoAutor = input.nextLine();
                        System.out.println("Editora: ");
                        String novaEditora = input.nextLine();
                        System.out.println("Gênero: ");
                        String novoGenero = input.nextLine();

                        li.setTitulo(novoTitulo);
                        li.setAutor(novoAutor);
                        li.setEditora(novaEditora);
                        li.getSecao().setGenero(novoGenero);

                        lidao.editar(li);
                        
                        System.out.println("LIVRO EDITADO");

                    } else {
                        System.out.println("LIVRO NÃO ENCONTRADO");
                    }

                    break;
                case "7":
                    
                    System.out.println("LISTAR LIVROS");

                    List<Livro> listalivro = lidao.listar();

                    for (Livro livro : listalivro) {
                        System.out.println(livro);
                    }
                    break;
                case "8":

                    System.out.println("EXCLUINDO LIVRO");
                    System.out.println("Id:");
                    idString = input.nextLine();
                    id = Long.parseLong(idString);

                    li = lidao.buscar(id);

                    if (li != null) {

                        lidao.excluir(li);

                        System.out.println("LIVRO REMOVIDO");
                    } else {
                        System.out.println("LIVRO NÃO ENCONTRADO");
                    }

                    break;
                case "0":

                    System.out.println("XAU");
                    break;
            }
        }
        PersistenceUtil.closeEntityManagerFactory();
    }
}
