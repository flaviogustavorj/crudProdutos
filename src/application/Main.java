package application;

import controllers.ProdutoController;

import javax.swing.*;
import java.util.Scanner;

public class Main {

    static void main(String[] args) {

        var Scanner = new Scanner (System.in);

        System.out.println("\nSISTEMA DE CONTROLE DE PRODUTOS:\n");
        System.out.println("(1) - CADASTRAR PRODUTO");
        System.out.println("(2) - ATUALIZAR PRODUTO");
        System.out.println("(3) - EXCLUIR PRODUTO");
        System.out.println("(4) - CONSULTAR PRODUTOS");

        System.out.print("\nInforme a opção desejada: ");
        var opcao = Scanner.nextLine();

        switch(opcao) {
            case "1": ProdutoController.cadastrarProduto(); break;
            case "2": ProdutoController.atualizarProduto();  break;
            case "3": ProdutoController.excluirProduto(); break;
            case "4": ProdutoController.consultarProdutos(); break;
            default:
                System.out.println("\nOpção inválida.");
        }
        Scanner.close();
    }
}
