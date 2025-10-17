package org.example;

public class Casa extends Imovel{

    public Casa(String endereco, String numero, Double valorAluguel, Proprietario proprietario, int mesesContrato) {
        super(endereco, numero, valorAluguel, proprietario, mesesContrato);
    }

    @Override
    public String estaAlugado() {
        if(isAlugado()){
            return "A casa está alugada";
        }
        return "A casa está disponível";
    }

    @Override
    public String toString() {
        return "Casa | Endereço: " + endereco + " | Número: " + numero + " | Valor Aluguel: R$" + valorAluguel + " | " + estaAlugado() + " | " + contatoProprietario();
    }
}
