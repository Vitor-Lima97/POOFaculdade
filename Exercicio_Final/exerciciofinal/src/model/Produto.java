package model;

import library.NaoPositivoException;

public class Produto extends Fornecedor{

    private int codigo;
    private String descricao;
    private double preco;
    private int quantidade;
    private Fornecedor fornecedor;


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public void negativos(double n) throws NaoPositivoException {
        if(n < 0 ){
            throw new NaoPositivoException();
        }
    }

    @Override
    public String toString() {
        return  "Produto " + '\n' +
                "codigo=" + codigo + '\n' +
                "descricao= " + descricao + '\n' +
                "preco=" + preco + '\n' +
                "quantidade=" + quantidade + '\n' +
                "fornecedor=" + fornecedor.getRazaoSocial() +'\n';
    }
}

