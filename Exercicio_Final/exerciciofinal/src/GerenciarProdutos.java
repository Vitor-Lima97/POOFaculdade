import library.EstadoInvalidoException;
import model.Fornecedor;
import model.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class GerenciarProdutos {

    public List<Produto> produtoList = new ArrayList<>();

    public static void main(String[] args) {
        GerenciarProdutos gp = new GerenciarProdutos();
        Scanner sc = new Scanner(System.in);
        int opcao = 0;
        do{
            opcao = Menu(gp, sc);
        }while(opcao!=5);
    }


    private static int Menu(GerenciarProdutos gp, Scanner sc) {
        int opcao;
        System.out.println("MENU");
        System.out.println("1. Cadastrar Fornecedor");
        System.out.println("2. Cadastrar Produto");
        System.out.println("3. Cadastrar Contato");
        System.out.println("4. Abrir Cesta");
        System.out.println("5. Sair");
        System.out.println("Digite sua opcao: ");
        opcao = Integer.parseInt(sc.nextLine());
        switch (opcao){
            case 1:
                gp.execCadastrarFornecedor(sc);
                break;
            default:
                System.out.println("Opcao invalida");
        }

        return opcao;
    }

    public void execCadastrarFornecedor(Scanner sc) {
        double chosen = 0;
        Fornecedor fornecedor = new Fornecedor();
        do {

            System.out.println("Digite o codigo do fornecedor: ");
            fornecedor.setCodigo(Integer.parseInt(sc.nextLine()));
            System.out.println("Digite a razao social do Fornecedor: ");
            fornecedor.setRazaoSocial(sc.nextLine());
            System.out.println("Digite o endereço do fornecedor: ");
            fornecedor.setEndereco(sc.nextLine());
            System.out.println("Digite a cidade (Padrão: Mogi Mirim) ");
            fornecedor.setCidade(sc.nextLine());
            System.out.println("Digite o Estado (Padrão: SP)");
            teste:
            try {
                String n = sc.nextLine();
                if (n.isEmpty()) {
                    break teste;
                }
                fornecedor.estadoinv(n);
            } catch (EstadoInvalidoException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(fornecedor);
            System.out.println("Gostaria de alterar algum dado:");
            System.out.println("1 - Sim / 2 - Não");
            chosen = Double.parseDouble(sc.nextLine());
        } while (chosen != 2);
        fornecedor.fornecedorList.add(fornecedor);
        System.out.println("Fornecedor cadastrado com sucesso");
    }

    }




