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
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    int id;
    String nome;

    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;

    }

    public void exibir() {
        System.out.println("ID:" + id);
        System.out.println("Nome:" + nome);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;

    }
}
