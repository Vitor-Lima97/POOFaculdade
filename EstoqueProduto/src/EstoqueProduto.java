import java.util.Scanner;

public class EstoqueProduto {

    public Produto[] produto = new Produto[5];
    public int n=1, esc=0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op;
        EstoqueProduto ep = new EstoqueProduto();
        do {
            System.out.println("Menu");
            System.out.println("1 - Cadastrar novo produto");
            System.out.println("2 - Adicionar quantidades");
            System.out.println("3 - Retirar produtos");
            System.out.println("4 - Mostrar estoque");
            System.out.println("5 - Historico do produto");
            System.out.println("9 - Sair");
            System.out.println("Digite a opcao desejada:");
            op = Integer.parseInt(sc.nextLine());
            switch (op){
                case 1:
                    ep.execCadastrar();
                    break;
                case 2:
                    ep.execAdicionar();
                    break;
                case 3:
                    ep.execRetirar();
                    break;
                case 4:
                    ep.mostrarEstoque();
                    break;
                case 5:
                    ep.historico();
                    break;
                case 9:
                    System.out.println("Fim");
                    break;
                default:
                    System.out.println("Opcao invalida");
            }
        }while (op != 9);
    }

    public void execCadastrar() {
        if (n < 5) {
            produto[n] = new Produto();
            Scanner sc = new Scanner(System.in);
            System.out.println("Cadastrar um novo produto");
            System.out.println("Digite o nome do produto: ");
            produto[n].setNome(sc.nextLine());
            System.out.println("Digite o tipo de produto: ");
            produto[n].setTipo(sc.nextLine());
            System.out.println("Digite o valor do produto: ");
            produto[n].setValor(Double.parseDouble(sc.nextLine()));
            System.out.println("Digite a quantidade inicial do produto: ");
            produto[n].setQtd(Integer.parseInt(sc.nextLine()));
            produto[n].histQtd.add(produto[n].getQtd());
            System.out.println("PRODUTO CADASTRADO!\n");
            n++;
        } else {
            System.out.println("Quantidade de produtos excede o limite do sistema");
        }
    }
    public void execAdicionar(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual produto deseja adicionar no estoque?");
        for (int i = 1; i < n; i++) {
            System.out.println(i + " - " + produto[i].getNome());
        }

        esc = Integer.parseInt(sc.nextLine());
        System.out.println("Produto selecionado:");
        System.out.println(produto[esc]);
        System.out.println("Qual a quantidade que deseja adicionar do estoque?");
        int valor = Integer.parseInt(sc.nextLine());
        if(produto[esc].adicionar(valor) == 1)
        {
            System.out.println("Adicionado corretamente ao estoque");
            return;
        }
        System.out.println("Adicao invalida");
    }
    public void execRetirar(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual produto deseja retirar?");
        for (int i = 1; i < n; i++) {
            System.out.println(i + " - " + produto[i].getNome());
        }

        esc = Integer.parseInt(sc.nextLine());
        System.out.println("Produto selecionado:");
        System.out.println(produto[esc]);
        System.out.println("Qual a quantidade que deseja tirar do estoque?");
        int valor = Integer.parseInt(sc.nextLine());
        if(produto[esc].retirada(valor) == 1)
        {
            System.out.println("Retirada realizada com sucesso");
            return;
        }
        System.out.println("Retirada invalida");
    }
    public void mostrarEstoque(){
        for (int i = 1; i < n; i++) {
            System.out.println(produto[i]);
        }

    }
    public void historico(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual produto deseja verificar o historico?");
        for (int i = 1; i < n; i++) {
            System.out.println(i + " - " + produto[i].getNome());
        }

        esc = Integer.parseInt(sc.nextLine());
        System.out.println("O Historico do estoque do produto: " + produto[esc].getNome() + "eh: ");
        System.out.println(produto[esc].histQtd);

    }
}