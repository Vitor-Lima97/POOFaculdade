package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cesta {
    Scanner sc = new Scanner(System.in);

    private List<Produto> itens = new ArrayList<>();

    public void adicionarItem(Produto p) {
        itens.add(p);
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

