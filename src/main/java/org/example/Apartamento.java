package org.example;

public class Apartamento extends Imovel {

    private final int andar;
    private final int numeroApt;

    public Apartamento(String endereco, String numeroImovel, Double valorAluguel, Proprietario proprietario, Inquilino inquilino, int mesesContrato, int andar, int numeroApt) {
        super(endereco, numeroImovel, valorAluguel, proprietario, inquilino, mesesContrato);
        this.andar = andar;
        this.numeroApt = numeroApt;
    }

    @Override
    public String estaAlugado() {
        if(isAlugado()){
            return "O apartamento de número " + numeroApt + " no andar " + andar + " está alugado";
        }
        return "O apartamento de número " + numeroApt + " no andar " + andar + " está disponível";
    }

    @Override
    public String toString() {
        return "Apartamento | Endereço: " + endereco + " | Número: " + numeroImovel + " | Andar: " + andar + " | Apt: " + numeroApt + " | Valor Aluguel: R$" + valorAluguel + " | " + estaAlugado() + " | ";
    }
}
