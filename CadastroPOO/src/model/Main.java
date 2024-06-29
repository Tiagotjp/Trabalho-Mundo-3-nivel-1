/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.IOException;

/**
 *
 * @author TiagodeJesus
 */
public class Main {

    public static void main(String[] args) {
        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
        repo1.inserir(new PessoaFisica(1, " Julia", "33344455566", 40));
        repo1.inserir(new PessoaFisica(2, " Mario", "66677788899", 36));

        try {
            repo1.persistir("pessoas_fisicas.dat");
            System.out.println("Dados de Pessoa Física Armazenados.");
        } catch (IOException e) {
            System.out.println("Erro ao persistir dados de pessoas físicas: " + e.getMessage());
        }

        PessoaFisicaRepo repo2 = null;
        try {
            repo2 = PessoaFisicaRepo.recuperar("pessoas_fisicas.dat");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao recuperar dados de pessoas físicas: " + e.getMessage());
        }

        if (repo2 != null) {
            System.out.println("Dados de pessoa física recuperada.");
            for (PessoaFisica pessoa : repo2.obterTodos()) {
                pessoa.exibir();
            }
        }

        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
        repo3.inserir(new PessoaJuridica(3, " Empresa XPTO Sales", "11109876543210"));
        repo3.inserir(new PessoaJuridica(4, " Empresa XPTO Solutions", "01234567891011"));

        try {
            repo3.persistir("pessoas_juridicas.dat");
            System.out.println("Dados de Pessoa Jurídica Armazenados.");
        } catch (IOException e) {
            System.out.println("Erro ao persistir dados de pessoas jurídicas: " + e.getMessage());
        }

        PessoaJuridicaRepo repo4 = null;
        try {
            repo4 = PessoaJuridicaRepo.recuperar("pessoas_juridicas.dat");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao recuperar dados de pessoas jurídicas: " + e.getMessage());
        }

        if (repo4 != null) {
            System.out.println("Pessoas Jurídicas Recuperadas.");
            for (PessoaJuridica pessoa : repo4.obterTodos()) {
                pessoa.exibir();

            }
        }
    }
}
