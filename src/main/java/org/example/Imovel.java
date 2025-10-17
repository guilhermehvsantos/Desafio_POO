package org.example;

public abstract class Imovel {
    protected String endereco;
    protected String numero;
    protected boolean alugado;
    protected Double valorAluguel;
    protected int mesesContrato;
    Proprietario proprietario;


    public Imovel(String endereco, String numero, Double valorAluguel, Proprietario proprietario, int mesesContrato) {
        this.endereco = endereco;
        this.numero = numero;
        this.alugado = false; // Inicialmente disponivel
        this.valorAluguel = valorAluguel;
        this.mesesContrato = mesesContrato;
        this.proprietario = proprietario;
    }

    //Metodo referente ao atributo
    public boolean isAlugado() {
        return this.alugado;
    }

    //Metodo abstrato para sobrescrever nas subclasses
    public abstract String estaAlugado();

    public String contatoProprietario() {
        return proprietario.toString();
    }

    public Double calcularAluguel(int mesesContrato) {
        if(mesesContrato >= 32){
            return mesesContrato * this.valorAluguel  * 0.85; // Desconto de 15%
        }
        if(mesesContrato >= 24){
            return mesesContrato * this.valorAluguel  * 0.9; // Desconto de 10%
        }
        if(mesesContrato >= 12){
            return mesesContrato * this.valorAluguel * 0.95; // Desconto de 5%
        }
        return mesesContrato * this.valorAluguel;
    }

    //Getters e Setters
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }

    public Double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(Double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }
}
