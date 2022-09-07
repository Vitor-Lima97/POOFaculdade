package model;

import java.util.ArrayList;
import java.util.List;

public class Produto {
    private int codigo;
    private String nome;
    private double valor;
    private int quantidade;
    private String tipo;

    public List<Integer> historico = new ArrayList<Integer>();

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return  "NOME: " + nome + '\n' +
                "Codigo: " + codigo + '\n' +
                "TIPO: " + tipo + '\n' +
                "Quantidade: " + quantidade + '\n' +
                "Valor Unitario: " + valor + '\n' ;
    }

    public boolean retirar(double valor){
        if(valor<=quantidade){
            quantidade -= valor;
            historico.add(quantidade);
            return true;
        }
        return false;

    }

    public boolean adicionar(double valor){
        if(valor > 0){
            quantidade += valor;
            historico.add(quantidade);
            return true;
        }
        return false;
    }
}
