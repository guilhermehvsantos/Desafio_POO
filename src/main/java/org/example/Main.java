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
                    cadastrarImovel(scanner, imoveis);
                    break;
                case 2:
                    // listar
                    if (listaVazia(imoveis)) break;
                    listarImoveis(imoveis);
                    break;
                case 3:
                    // alugar
                    if (listaVazia(imoveis)) break;
                    alugarImovel(scanner, imoveis);
                    break;
                case 4:
                    // liberar imóvel
                    if (listaVazia(imoveis)) break;
                    liberarImovel(scanner, imoveis);
                    break;
                case 5:
                    // calcular valor do aluguel
                    if (listaVazia(imoveis)) break;
                    calcularValorAluguel(scanner, imoveis);
                    break;
                case 6:
                    // descadastrar imóvel
                    if (listaVazia(imoveis)) break;
                    removerImovel(scanner, imoveis);
                    break;
                case 7:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static boolean listaVazia(List<Imovel> imoveis) {
        if (imoveis.isEmpty()) {
            System.out.println("Nenhum imóvel cadastrado.");
            return true;
        }
        return false;
    }

    private static void cadastrarImovel(Scanner scanner, List<Imovel> imoveis) {
        System.out.println("\n=== CADASTRO DE IMÓVEL ===");
        System.out.println("Tipo de imóvel:");
        System.out.println("1 - Casa");
        System.out.println("2 - Apartamento");
        System.out.print("Escolha o tipo: ");
        int tipoImovel = scanner.nextInt();
        scanner.nextLine();
        if (tipoImovel != 1 && tipoImovel != 2) {
            System.out.println("Tipo de imóvel inválido!");
            return;
        }

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        System.out.print("Número: ");
        String numero = scanner.nextLine();

        System.out.print("Valor do aluguel: R$ ");
        double valorAluguel = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("\n--- Dados do Proprietário ---");
        System.out.print("Nome: ");
        String nomeProprietario = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("CPF: ");
        String cpf = scanner.nextLine();

        Proprietario proprietario = new Proprietario(nomeProprietario, telefone, cpf);

        if (tipoImovel == 1) {
            Casa casa = new Casa(endereco, numero, valorAluguel, proprietario, null, 0);
            imoveis.add(casa);
            System.out.println("Casa cadastrada com sucesso!");
        } else {
            System.out.print("Andar: ");
            int andar = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Numero do apartamento: ");
            int numeroApt = scanner.nextInt();
            scanner.nextLine();
            Apartamento apartamento = new Apartamento(endereco, numero, valorAluguel, proprietario, null, 0, andar, numeroApt);
            imoveis.add(apartamento);

            System.out.println("Apartamento cadastrado com sucesso!");
        }
    }

    private static void listarImoveis(List<Imovel> imoveis) {
        if (imoveis.isEmpty()) {
            System.out.println("Nenhum imóvel cadastrado.");
            return;
        }
        imoveis.forEach(imovel -> {
            System.out.println(imovel);
            System.out.println(imovel.contatoProprietario());
            System.out.println("---------------------------");
        });
    }

    private static void alugarImovel(Scanner scanner, List<Imovel> imoveis) {
        System.out.println("\n=== IMÓVEIS DISPONÍVEIS ===");

        boolean temDisponiveis = false;
        for (int i = 0; i < imoveis.size(); i++) {
            if (!imoveis.get(i).isAlugado()) {
                System.out.println((i + 1) + " - " + imoveis.get(i).estaAlugado());
                temDisponiveis = true;
            }
        }

        if (!temDisponiveis) {
            System.out.println("Nenhum imóvel disponível para aluguel.");
            return;
        }

        System.out.print("\nEscolha o número do imóvel: ");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        if (escolha < 1 || escolha > imoveis.size()) {
            System.out.println("Imóvel não encontrado!");
            return;
        }

        Imovel imovelEscolhido = imoveis.get(escolha - 1);

        if (imovelEscolhido.isAlugado()) {
            System.out.println("Este imóvel já está alugado!");
            return;
        }

        System.out.println("\n--- Dados do Inquilino ---");
        System.out.print("Nome: ");
        String nomeInquilino = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefoneInquilino = scanner.nextLine();

        System.out.print("CPF: ");
        String cpfInquilino = scanner.nextLine();

        System.out.print("Meses de contrato: ");
        int mesesContrato = scanner.nextInt();
        scanner.nextLine();

        // Exibe mensagem de desconto baseado nos meses
        String mensagemDesconto = "";
        if (mesesContrato >= 32) {
            mensagemDesconto = "Você tem 15% de desconto pelos " + mesesContrato + " meses!";
        } else if (mesesContrato >= 24) {
            mensagemDesconto = "Você tem 10% de desconto pelos " + mesesContrato + " meses!";
        } else if (mesesContrato >= 12) {
            mensagemDesconto = "Você tem 5% de desconto pelos " + mesesContrato + " meses!";
        } else {
            mensagemDesconto = "Sem desconto para " + mesesContrato + " meses.";
        }
        System.out.println(mensagemDesconto);

        Double valorTotal = imovelEscolhido.calcularAluguel(mesesContrato);
        System.out.printf("Valor total do contrato: R$ %.2f%n", valorTotal);

        Inquilino inquilino = new Inquilino(nomeInquilino, telefoneInquilino, cpfInquilino);
        imovelEscolhido.setInquilino(inquilino);
        imovelEscolhido.setMesesContrato(mesesContrato);

        System.out.println("Imóvel alugado com sucesso!");
    }

    private static void liberarImovel(Scanner scanner, List<Imovel> imoveis) {
        System.out.println("\n=== IMÓVEIS ALUGADOS ===");

        boolean temAlugados = false;
        for (int i = 0; i < imoveis.size(); i++) {
            if (imoveis.get(i).isAlugado()) {
                Imovel imovel = imoveis.get(i);
                System.out.println((i + 1) + " - Inquilino: " + imovel.getInquilino().getNome() +
                        " | CPF: " + imovel.getInquilino().getCPF());
                temAlugados = true;
            }
        }

        if (!temAlugados) {
            System.out.println("Nenhum imóvel alugado.");
            return;
        }

        System.out.print("\nEscolha o número do imóvel para liberar: ");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        if (escolha < 1 || escolha > imoveis.size()) {
            System.out.println("Imóvel não encontrado!");
            return;
        }

        Imovel imovelEscolhido = imoveis.get(escolha - 1);

        if (!imovelEscolhido.isAlugado()) {
            System.out.println("Este imóvel não está alugado!");
            return;
        }

        System.out.print("Deseja liberar o imóvel alugado por " +
                imovelEscolhido.getInquilino().getNome() + "? (S/N): ");
        String confirmacao = scanner.nextLine().trim().toUpperCase();

        if (confirmacao.equals("S")) {
            imovelEscolhido.setInquilino(null);
            imovelEscolhido.setMesesContrato(0);
            System.out.println("Imóvel liberado com sucesso!");
        } else {
            System.out.println("Operação cancelada.");
        }
    }

    private static void calcularValorAluguel(Scanner scanner, List<Imovel> imoveis) {
        System.out.println("\n=== CALCULAR VALOR DO ALUGUEL ===");

        for (int i = 0; i < imoveis.size(); i++) {
            Imovel imovel = imoveis.get(i);
            System.out.println((i + 1) + " - " + imovel.estaAlugado() +
                    " | Valor mensal: R$ " + String.format("%.2f", imovel.getValorAluguel()));
        }

        System.out.print("\nEscolha o número do imóvel: ");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        if (escolha < 1 || escolha > imoveis.size()) {
            System.out.println("Imóvel não encontrado!");
            return;
        }

        Imovel imovelEscolhido = imoveis.get(escolha - 1);

        System.out.print("Quantidade de meses: ");
        int meses = scanner.nextInt();
        scanner.nextLine();

        if (meses <= 0) {
            System.out.println("Quantidade de meses inválida!");
            return;
        }

        Double valorTotal = imovelEscolhido.calcularAluguel(meses);
        Double valorSemDesconto = meses * imovelEscolhido.getValorAluguel();
        Double desconto = valorSemDesconto - valorTotal;

        System.out.println("\n--- SIMULAÇÃO DE ALUGUEL ---");
        System.out.println("Meses: " + meses);
        System.out.printf("Valor sem desconto: R$ %.2f%n", valorSemDesconto);

        if (meses >= 32) {
            System.out.println("Desconto: 15%");
        } else if (meses >= 24) {
            System.out.println("Desconto: 10%");
        } else if (meses >= 12) {
            System.out.println("Desconto: 5%");
        } else {
            System.out.println("Desconto: 0%");
        }

        System.out.printf("Economia: R$ %.2f%n", desconto);
        System.out.printf("Valor total: R$ %.2f%n", valorTotal);
    }

    private static void removerImovel(Scanner scanner, List<Imovel> imoveis) {
        System.out.println("\n=== DESCADASTRAR IMÓVEL ===");

        for (int i = 0; i < imoveis.size(); i++) {
            Imovel imovel = imoveis.get(i);
            String status = imovel.isAlugado() ? "[ALUGADO]" : "[DISPONÍVEL]";
            System.out.println((i + 1) + " - " + imovel.estaAlugado() + " " + status);
        }

        System.out.print("\nEscolha o número do imóvel para remover: ");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        if (escolha < 1 || escolha > imoveis.size()) {
            System.out.println("Imóvel não encontrado!");
            return;
        }

        Imovel imovelEscolhido = imoveis.get(escolha - 1);

        if (imovelEscolhido.isAlugado()) {
            System.out.println("Não é possível remover um imóvel alugado!");
            System.out.println("Libere o imóvel primeiro (opção 4 do menu).");
            return;
        }

        System.out.print("Confirma a remoção do imóvel? (S/N): ");
        String confirmacao = scanner.nextLine().trim().toUpperCase();

        if (confirmacao.equals("S")) {
            imoveis.remove(escolha - 1);
            System.out.println("Imóvel removido com sucesso!");
        } else {
            System.out.println("Operação cancelada.");
        }
    }



}
