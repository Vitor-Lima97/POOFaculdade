package model;

import library.EstadoInvalidoException;

import java.util.ArrayList;
import java.util.List;

public class Fornecedor{

    private int codigo;
    private String razaoSocial;
    private String endereco;
    private String cidade;
    private String estado;
    private Contato contato;

    public Fornecedor(){
       this.cidade = "Mogi Mirim";
       this.estado = "SP";
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public void estadoinv(String UF) throws EstadoInvalidoException {
        if (UF.length()!=2 ) {
                throw new EstadoInvalidoException();
        }
        if (eMinuscula(UF)==true){
            throw new EstadoInvalidoException();
        }
        setEstado(UF);
        }

    private boolean eMinuscula(String uf) {

        char[] UFarray = uf.toCharArray();

        for(int i=0; i< UFarray.length; i++){
            if(Character.isLetter(UFarray[i])){
                if(!Character.isUpperCase(UFarray[i]))
                    return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        return "Fornecedor" + '\n' +
                "codigo=" + codigo + "\n" +
                "razaoSocial= " + razaoSocial + '\n' +
                "endereco= " + endereco + "\n" +
                "cidade= " + cidade + '\n' +
                "estado= " + estado + '\n' +
                "contato= " + contato
                ;
    }
}

