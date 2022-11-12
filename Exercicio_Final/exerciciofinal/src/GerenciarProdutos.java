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
            case 2:
                gp.execCadastrarProduto(sc);
                break;
            case 3:
                gp.execVisualizarListas(sc);
                break;
            default:
                System.out.println("Opcao invalida");
        }

        return opcao;
    }

    public void execCadastrarFornecedor(Scanner sc) {
        int chosen = 0;
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
            nulo:
            try {
                String n = sc.nextLine();
                if (n.isEmpty()) {
                    break nulo;
                }
                fornecedor.estadoinv(n);
            } catch (EstadoInvalidoException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(fornecedor);
            System.out.println("Gostaria de alterar algum dado:");
            System.out.println("1 - Sim / 2 - Não");
            chosen = Integer.parseInt(sc.nextLine());
            if(fornecedor.getEndereco().isEmpty()==true  || fornecedor.getRazaoSocial().isEmpty()==true){
                System.out.println("Valores vazios invalidos, favor entrar com valores validos");
                chosen = 1;
            }
        } while (chosen != 2);
        fornecedor.fornecedorList.add(fornecedor);
        System.out.println("Fornecedor cadastrado com sucesso");
    }

    public void execCadastrarProduto(Scanner sc){
        int chosen = 0;
        Produto produto = new Produto();
        do {
            System.out.println("Digite o codigo do produto: ");
            produto.setCodigo(Integer.parseInt(sc.nextLine()));
            System.out.println("Digite a descrição do produto: ");
            produto.setDescricao(sc.nextLine());
            System.out.println("Digite o valor do produto: ");
            produto.setPreco(Double.parseDouble(sc.nextLine()));
            System.out.println("Digite a quantidade do produto: ");
            produto.setQuantidade(Integer.parseInt(sc.nextLine()));
            System.out.println(produto);
            System.out.println("Gostaria de alterar algum dado:");
            System.out.println("1 - Sim / 2 - Não");
            chosen = Integer.parseInt(sc.nextLine());
        } while (chosen != 2);
        produtoList.add(produto);
        System.out.println("Produto cadastrado com sucesso");

    }

    public void execVisualizarListas(Scanner sc){
        for (Produto p: produtoList) {
            System.out.println(p.toString());
            
        }
    }

    }




