package controllers;

import entities.Produto;
import repositories.ProdutoRepository;
import java.util.Scanner;


public class ProdutoController {

    //Método para capturar os dados do produto
    public static void cadastrarProduto() {

        System.out.println("\nCADASTRO DE PRODUTO:\n");

        try (var scanner = new Scanner(System.in)) {

            //Criando um objeto da classe Produto
            var produto = new Produto();

            System.out.print("Informe o nome do produto...: ");
            produto.setNome(scanner.nextLine());

            System.out.print("Informe o preço.............: ");
            produto.setPreco(Double.parseDouble(scanner.nextLine()));

            System.out.print("Informe a quantidade........: ");
            produto.setQuantidade(Integer.parseInt(scanner.nextLine()));

            //Objeto da classe Produto criado com os dados informados
            var produtorepository = new ProdutoRepository();
            var id = produtorepository.create(produto);

            System.out.println("\nProduto cadastrado com sucesso!");
            System.out.println("ID do produto cadastrado: " + id);


        }
        catch(Exception e) {
            System.out.println("\nErro: " + e.getMessage());
        }
    }

        //Método para atualizar os dados do produto
    public static void atualizarProduto() {

        System.out.println("\nATUALIZAÇÃO DE PRODUTO:\n");

        try (var scanner = new Scanner(System.in)) {

            //Criando um objeto da classe Produto
            var produto = new Produto();

            System.out.print("Informe o id do produto...: ");
            produto.setId(Integer.parseInt(scanner.nextLine()));

            System.out.print("Informe o nome do produto...: ");
            produto.setNome(scanner.nextLine());

            System.out.print("Informe o preço.............: ");
            produto.setPreco(Double.parseDouble(scanner.nextLine()));

            System.out.print("Informe a quantidade........: ");
            produto.setQuantidade(Integer.parseInt(scanner.nextLine()));

            //Objeto da classe Produto criado com os dados informados
            var produtoRespository = new ProdutoRepository();

            if (produtoRespository.update(produto)) {
                System.out.println("\nProduto atualizado com sucesso!");
            } else {
                System.out.println("\nProduto não encontrado. Verifique o ID informado!");
            }

        }
        catch(Exception e) {
            System.out.println("\nErro: " + e.getMessage());
        }
    }

    //Método para excluir um produto do banco de dados
    public static void excluirProduto() {

        System.out.println("\nEXCLUSÃO DE PRODUTO:\n");

        try (var scanner = new Scanner(System.in)) {

            System.out.print("Informe o id do produto...: ");
            var id = Integer.parseInt(scanner.nextLine());

            var produtoRespository = new ProdutoRepository();

            if (produtoRespository.delete(id)) {
                System.out.println("\nProduto excluído com sucesso!");
            } else {
                System.out.println("\nProduto não encontrado. Verifique o ID informado!");
            }

        }
        catch(Exception e) {
            System.out.println("\nErro: " + e.getMessage());
        }
    }

    //Método para consultar os produtos no banco de dados
    public static void consultarProdutos() {

        System.out.println("\nCONSULTA DE PRODUTOS:\n");

        try {
            var produtoRespository = new ProdutoRepository();
            produtoRespository.findAll();
        }
        catch(Exception e) {
            System.out.println("\nErro: " + e.getMessage());
        }
    }
}