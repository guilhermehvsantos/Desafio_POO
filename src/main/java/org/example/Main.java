package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Imovel> imoveis = new ArrayList<>();

        while (true) {
            System.out.println("\n===== MENU IMOBILIÁRIA =====");
            System.out.println("1 - Cadastrar imóvel");
            System.out.println("2 - Listar imóveis");
            System.out.println("3 - Alugar imóvel");
            System.out.println("4 - Disponibilizar imóvel");
            System.out.println("5 - Calcular valor do aluguel");
            System.out.println("6 - Remover imóvel");
            System.out.println("7 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    // cadastrar
                    Casa casa1 = new Casa("Rua A", "123", 1500.0, new Proprietario("João", "99999-9999", "123.456.789-00"), 12);
                    Apartamento apt1 = new Apartamento("Av. Central", "789", 1800.0, new Proprietario("Carlos", "77777-7777", "111.222.333-44"), 6);
                    imoveis.add(casa1);
                    imoveis.add(apt1);
                    System.out.println("Imóveis cadastrados com sucesso!");

                    break;
                case 2:
                    // listar
                    if (imoveis.isEmpty()) {
                        System.out.println("Nenhum imóvel cadastrado.");
                        break;
                    }
                    imoveis.forEach(imovel -> {
                        System.out.println(imovel);
                        System.out.println(imovel.estaAlugado());
                        System.out.println(imovel.contatoProprietario());
                        System.out.println("---------------------------");
                    });
                    break;
                case 3:
                    // alugar
                    if (imoveis.isEmpty()) {
                        System.out.println("Nenhum imóvel cadastrado.");
                        break;
                    }

                    break;
                case 4:
                    // liberar imóvel
                    if (imoveis.isEmpty()) {
                        System.out.println("Nenhum imóvel cadastrado.");
                        break;
                    }

                    break;
                case 5:
                    // calcular
                    if (imoveis.isEmpty()) {
                        System.out.println("Nenhum imóvel cadastrado.");
                        break;
                    }

                    break;
                case 6:
                    // remover
                    if (imoveis.isEmpty()) {
                        System.out.println("Nenhum imóvel cadastrado.");
                        break;
                    }

                    break;
                case 7:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
