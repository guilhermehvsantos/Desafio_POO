package org.example;

public abstract class Imovel {
    protected String endereco;
    protected String numeroImovel;
    protected Double valorAluguel;
    protected int mesesContrato;
    Proprietario proprietario;
    Inquilino inquilino;

    public Imovel(String endereco, String numeroImovel, Double valorAluguel, Proprietario proprietario, Inquilino inquilino, int mesesContrato) {
        this.endereco = endereco;
        this.numeroImovel = numeroImovel;
        this.valorAluguel = valorAluguel;
        this.proprietario = proprietario;
        this.inquilino = inquilino;
        this.mesesContrato = mesesContrato;
    }

    //Metodo referente ao antigo atributo alugado - agora baseado no inquilino
    public boolean isAlugado() {
        return this.inquilino != null;
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

    public String getNumeroImovel() {
        return numeroImovel;
    }

    public void setNumeroImovel(String numeroImovel) {
        this.numeroImovel = numeroImovel;
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

    public int getMesesContrato() {
        return mesesContrato;
    }

    public void setMesesContrato(int mesesContrato) {
        this.mesesContrato = mesesContrato;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }
}
