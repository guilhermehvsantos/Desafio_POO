package org.example;

public class Apartamento extends Imovel{

    public Apartamento(String endereco, String numero, Double valorAluguel, Proprietario proprietario, int mesesContrato) {
        super(endereco, numero, valorAluguel, proprietario, mesesContrato);
    }

    @Override
    public String estaAlugado() {
        if(isAlugado()){
            return "O apartamento de número " + numero + " está alugado";
        }
        return "O apartamento de número " + numero + " está disponivel";
    }


    @Override
    public String toString() {
        return "Apartamento | Endereço: " + endereco + " | Número: " + numero + " | Valor Aluguel: R$" + valorAluguel + " | " + estaAlugado() + " | " + contatoProprietario();
    }
}
