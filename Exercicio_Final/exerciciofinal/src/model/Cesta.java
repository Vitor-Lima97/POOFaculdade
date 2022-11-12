package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cesta {
    Scanner sc = new Scanner(System.in);

    private List<Produto> itens = new ArrayList<>();

    public void adicionarItem(Produto p) {
        Produto produto = new Produto();
        System.out.println("Digite o codigo do produto: ");
        produto.setCodigo(Integer.parseInt(sc.nextLine()));
        System.out.println("Digite a descricao do produto: ");
        produto.setDescricao(sc.nextLine());
        System.out.println("Digite o preco do produto: ");
        produto.setPreco(Double.parseDouble(sc.nextLine()));
        System.out.println("Digite a quantidade inicial do produto em estoque: ");
        produto.setQuantidade(Integer.parseInt(sc.nextLine()));

        itens.add(produto);
        System.out.println("Produto cadastrado com sucesso!");

    }

    public void getItens() {
        for (Produto p : itens) {
            System.out.println(p.toString());

        }

    }

    public double calcularTotal() {
        double total = 0;
        for (Produto p : itens) {

            total += p.getPreco();
        }
        return total;
    }
}

