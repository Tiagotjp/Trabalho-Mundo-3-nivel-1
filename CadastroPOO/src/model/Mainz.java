/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author TiagodeJesus
 */
public class Mainz {

    private static Scanner scanner = new Scanner(System.in);
    private static PessoaFisicaRepo repoPessoaFisica = new PessoaFisicaRepo();
    private static PessoaJuridicaRepo repoPessoaJuridica = new PessoaJuridicaRepo();

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("=========================");
            System.out.println("Opções:");
            System.out.println("1. Incluir Pessoa");
            System.out.println("2. Alterar Pessoa");
            System.out.println("3. Excluir Pessoa");
            System.out.println("4. Exibir Por ID");
            System.out.println("5. Exibir Todos");
            System.out.println("6. Salvar Dados");
            System.out.println("7. Recuperar Dados");
            System.out.println("0. Finalizar Execução");
            System.out.println("=========================");

            opcao = lerInteiro("Digite a opção desejada: ");

            switch (opcao) {
                case 1:
                    incluir();
                    break;
                case 2:
                    alterar();
                    break;
                case 3:
                    excluir();
                    break;
                case 4:
                    exibirPorId();
                    break;
                case 5:
                    exibirTodos();
                    break;
                case 6:
                    salvarDados();
                    break;
                case 7:
                    recuperarDados();
                    break;
                case 0:
                    System.out.println("Finalizando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void incluir() {
        String tipo = lerString("Escolha o tipo (F para Pessoa Física, J para Pessoa Jurídica): ");
        if (tipo.equalsIgnoreCase("F")) {
            incluirPessoaFisica();
        } else if (tipo.equalsIgnoreCase("J")) {
            incluirPessoaJuridica();
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private static void incluirPessoaFisica() {
        int id = lerInteiro("Digite o ID: ");
        String nome = lerString("Digite o nome: ");
        String cpf = lerString("Digite o CPF: ");
        int idade = lerInteiro("Digite a idade: ");
        repoPessoaFisica.inserir(new PessoaFisica(id, nome, cpf, idade));
    }

    private static void incluirPessoaJuridica() {
        int id = lerInteiro("Digite o ID: ");
        String nome = lerString("Digite o nome: ");
        String cnpj = lerString("Digite o CNPJ: ");
        repoPessoaJuridica.inserir(new PessoaJuridica(id, nome, cnpj));
    }

    private static void alterar() {
        String tipo = lerString("Escolha o tipo (F para Pessoa Física, J para Pessoa Jurídica): ");
        int id = lerInteiro("Digite o ID: ");
        if (tipo.equalsIgnoreCase("F")) {
            PessoaFisica pessoa = repoPessoaFisica.obter(id);
            if (pessoa != null) {
                System.out.println("Dados atuais da pessoa física:");
                pessoa.exibir();
                System.out.println("Digite os novos dados:");
                incluirPessoaFisica();
            } else {
                System.out.println("Pessoa física não encontrada.");
            }
        } else if (tipo.equalsIgnoreCase("J")) {
            PessoaJuridica pessoa = repoPessoaJuridica.obter(id);
            if (pessoa != null) {
                System.out.println("Dados atuais da pessoa jurídica:");
                pessoa.exibir();
                System.out.println("Digite os novos dados:");
                incluirPessoaJuridica();
            } else {
                System.out.println("Pessoa jurídica não encontrada.");
            }
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private static void excluir() {
        String tipo = lerString("Escolha o tipo (F para Pessoa Física, J para Pessoa Jurídica): ");
        int id = lerInteiro("Digite o ID: ");
        if (tipo.equalsIgnoreCase("F")) {
            repoPessoaFisica.excluir(id);
        } else if (tipo.equalsIgnoreCase("J")) {
            repoPessoaJuridica.excluir(id);
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private static void exibirPorId() {
        String tipo = lerString("Escolha o tipo (F para Pessoa Física, J para Pessoa Jurídica): ");
        int id = lerInteiro("Digite o ID: ");
        if (tipo.equalsIgnoreCase("F")) {
            PessoaFisica pessoa = repoPessoaFisica.obter(id);
            if (pessoa != null) {
                pessoa.exibir();
            } else {
                System.out.println("Pessoa física não encontrada.");
            }
        } else if (tipo.equalsIgnoreCase("J")) {
            PessoaJuridica pessoa = repoPessoaJuridica.obter(id);
            if (pessoa != null) {
                pessoa.exibir();
            } else {
                System.out.println("Pessoa jurídica não encontrada.");
            }
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private static void exibirTodos() {
        String tipo = lerString("Escolha o tipo (F para Pessoa Física, J para Pessoa Jurídica): ");
        if (tipo.equalsIgnoreCase("F")) {
            for (PessoaFisica pessoa : repoPessoaFisica.obterTodos()) {
                pessoa.exibir();
                System.out.println();
            }
        } else if (tipo.equalsIgnoreCase("J")) {
            for (PessoaJuridica pessoa : repoPessoaJuridica.obterTodos()) {
                pessoa.exibir();
                System.out.println();
            }
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private static void salvarDados() {
        String prefixo = lerString("Digite o prefixo dos arquivos: ");
        try {
            repoPessoaFisica.persistir(prefixo + ".fisica.bin");
            repoPessoaJuridica.persistir(prefixo + ".juridica.bin");
            System.out.println("Dados salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    private static void recuperarDados() {
        String prefixo = lerString("Digite o prefixo dos arquivos: ");
        try {
            repoPessoaFisica = PessoaFisicaRepo.recuperar(prefixo + ".fisica.bin");
            repoPessoaJuridica = PessoaJuridicaRepo.recuperar(prefixo + ".juridica.bin");
            System.out.println("Dados recuperados com sucesso.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao recuperar dados: " + e.getMessage());
        }
    }

    private static int lerInteiro(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextInt();
    }

    private static String lerString(String mensagem) {
        System.out.print(mensagem);
        return scanner.next();
    }
}
