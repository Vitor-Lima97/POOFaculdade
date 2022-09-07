package cli;

import model.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciarInventario {
 int n =1;
    public List<Produto> lista = new ArrayList<>();

    public static void main(String[] args) {
        GerenciarInventario gi = new GerenciarInventario();
        Scanner sc = new Scanner(System.in);
        int opc = 0;
        do{
            opc = Menu(gi,sc);
        }while(opc!=9);
    }
    private static int Menu(GerenciarInventario gi, Scanner sc) {
        int opc;
        System.out.println("MENU");
        System.out.println("1. Cadastrar Novo Produto");
        System.out.println("2. Retirar do Estoque");
        System.out.println("3. Adicionar no Estoque");
        System.out.println("4. Mostrar todos os produtos");
        System.out.println("5. Valor total do Inventario");
        System.out.println("6. Excluir produto do inventario");
        System.out.println("7. Historico do produto");
        System.out.println("9. Sair");
        System.out.println("Digite sua opcao: ");
        opc = Integer.parseInt(sc.nextLine());
        switch (opc){
            case 1:
                gi.execCadastro(sc);
                break;
            case 2:
                gi.execRetirar(sc);
                break;
            case 3:
                gi.execAdicionar(sc);
                break;
            case 4:
                gi.execMostrarProdutos();
                break;
            case 5:
                gi.execValorTotal();
                break;
            case 6:
                gi.execExcluir(sc);
                break;
            case 7:
                gi.Historico(sc);
                break;
            case 9:
                System.out.println("Fim");
                break;
            default:
                System.out.println("Opção Invalida");

        }
        return opc;
    }
    public void execCadastro(Scanner sc){
        Produto produto = new Produto();
        produto.setCodigo(n);
        n++;
        System.out.println("Digite o nome do produto: ");
        produto.setNome(sc.nextLine());
        System.out.println("Digite o valor do produto: ");
        produto.setValor(Double.parseDouble(sc.nextLine()));
        System.out.println("Digite o tipo do produto: ");
        produto.setTipo(sc.nextLine());
        System.out.println("Digite a quantidade atual do produto: ");
        produto.setQuantidade(Integer.parseInt(sc.nextLine()));
        lista.add(produto);
        System.out.println("Produto Cadastrado com Sucesso!!");
        produto.historico.add(produto.getQuantidade());
    }
    public void execRetirar(Scanner sc){
        for (Produto produto : lista){
            System.out.println(produto.toString());
        }
        System.out.println("Selecione qual produto quer retirar do estoque");
        Produto produto = buscarProduto(sc);
        if(produto!=null){
            System.out.println("Digite a quantidade que deseja retirar: ");
            boolean ok = produto.retirar(Double.parseDouble(sc.nextLine()));
            if(ok){
                System.out.println("Quantidade retirada do estoque");
            }else{
                System.out.println("Não há produto para retirada");
            }
        }else{
                System.out.println("Produto nao encontrado");
        }
    }
    private Produto buscarProduto(Scanner sc) {
        int proc = Integer.parseInt(sc.nextLine());
        Produto produto = null;
        for(Produto p : lista){
            if(p.getCodigo()==proc) {
                produto = p;
                break;
            }
        }
        return produto;
    }
    public void execAdicionar(Scanner sc){

        for (Produto produto : lista){
            System.out.println(produto.toString());
        }
        System.out.println("Selecione qual produto quer adicionar ao estoque");
        Produto produto = buscarProduto(sc);
        if(produto!=null){
            System.out.println("Digite a quantidade que deseja adicionar: ");
            boolean ok = produto.adicionar(Double.parseDouble(sc.nextLine()));
            if(ok){
                System.out.println("Quantidade adicionada do estoque");
            }else{
                System.out.println("Quantidade para adicionar nao pode ser menor ou igual a ZERO");
            }
        }else{
            System.out.println("Produto nao encontrado");
        }


    }
    public void execMostrarProdutos() {
        if (n != 1) {
            for (Produto p : lista) {
                System.out.println(p.toString());
            }
        } else {
            System.out.println("Nenhum produto cadastrado!");
        }
    }
    public void execValorTotal(){
        double total = 0;
        for(Produto p: lista){
            total += (p.getValor() * p.getQuantidade());
        }
        System.out.println("O Total de todas as contas eh : " + total);

    }
    public void execExcluir(Scanner sc){
        for (Produto produto : lista){
            System.out.println(produto.toString());
        }
        System.out.println("Selecione qual produto deseja excluir do estoque");
        Produto produto = buscarProduto(sc);
        lista.remove(produto);
        System.out.println("Produto retirado com sucesso!!");
    }
    public void Historico (Scanner sc){
        for (Produto produto : lista){
            System.out.println(produto.toString());
        }
        System.out.println("Selecione qual produto deseja verificar o historico");
        Produto produto = buscarProduto(sc);
        System.out.println(produto.historico + "\n");
    }

}