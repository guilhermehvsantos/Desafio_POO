package org.example;

public class Inquilino {
    private String nome;
    private String telefone;
    private String CPF;

    public Inquilino(String nome, String telefone, String CPF) {
        this.nome = nome;
        this.telefone = telefone;
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    @Override
    public String toString() {
        return "Inquilino: " + nome + " | Tel: " + telefone;
    }
}
