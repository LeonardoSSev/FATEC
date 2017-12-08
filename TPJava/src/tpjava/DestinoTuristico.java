/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpjava;

import java.util.ArrayList;

/**
 *
 * @author leo_a
 */
public class DestinoTuristico {
    private String nome;
    private String cidade;
    private String estado;
    private String historia;    
    public static ArrayList<DestinoTuristico> destinosTuristicos = new ArrayList<DestinoTuristico>();
    
    public DestinoTuristico(String nome, String cidade, String estado, String historia){
        this.nome = nome;
        this.cidade = cidade;
        this.estado = estado;
        this.historia = historia;
    }

    public static ArrayList<DestinoTuristico> getDestinos() {
        return destinosTuristicos;
    }

    public static void setDestinoTuristico(DestinoTuristico dt) {
        destinosTuristicos.add(dt);
    }
  
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }
    
}
