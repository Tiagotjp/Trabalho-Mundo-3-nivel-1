/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author TiagodeJesus
 */
public class PessoaJuridica extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    String cnpj;

    public PessoaJuridica(int id, String nome, String cnpj) {
        super(id, nome);
        this.cnpj = cnpj;
    }

    @Override
    public void exibir() {
        super.exibir();
        System.out.println("CNPJ: " + cnpj + "\n");
    }

    public String getcnpj() {
        return cnpj;
    }

    public void setcnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
