import java.util.ArrayList;

public class Produto {
    private String nome;
    private String tipo;
    private double valor;
    private int qtd;

     ArrayList<Integer> histQtd = new ArrayList<Integer>();

    //Metodos Gets/Sets


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    @Override
    public String toString() {
        return  "-----------------------------\n" +
                "O Produto: " + nome + "\n" +
                "Do tipo: " + tipo + "\n" +
                "Quantidade no estoque:" + qtd + "\n" +
                "-----------------------------------";
    }

     public int retirada(int valor){
           if(valor <= qtd){
               qtd -= valor;
               histQtd.add(qtd);
               return 1;
           }
                return 0;


     }

    public int adicionar(int valor){
        if(valor >= 0){
            qtd += valor;
            histQtd.add(qtd);
            return 1;
        }
        return 0;
    }
}
