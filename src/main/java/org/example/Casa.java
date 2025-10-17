package org.example;

public class Casa extends Imovel{

    public Casa(String endereco, String numeroImovel, Double valorAluguel, Proprietario proprietario,Inquilino inquilino , int mesesContrato) {
        super(endereco, numeroImovel, valorAluguel, proprietario,inquilino, mesesContrato);
    }

    @Override
    public String estaAlugado() {
        if(isAlugado()){
            return "A casa está alugada " + numeroImovel;
        }
        return "A casa está disponível " + numeroImovel;
    }

    @Override
    public String toString() {
        return "Casa | Endereço: " + endereco + " | Número: " + numeroImovel + " | Valor Aluguel: R$" + valorAluguel + " | " + estaAlugado() + " | ";
    }
}
