/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpjava;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;


/**
 *
 * @author leo_a
 */
public class TPJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int op = 0;
        String[] opcoes = { "Cadastrar", "Listar", "Alterar", "Excluir", "Sair"};
        try{
            exibeMenu(op, opcoes);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro na aplicação\n" + ex, "Erro - Destinos Turísticos", JOptionPane.ERROR_MESSAGE);
        }
		
        JOptionPane.showMessageDialog(null, "A aplicação foi encerrada.", "Destinos Turísticos", JOptionPane.INFORMATION_MESSAGE);        
    }
    
    public static void exibeMenu(int op, String buttons[]){
        do{
            op = JOptionPane.showOptionDialog(null, "Bem vindo!\\nInforme uma opção através dos botões abaixo:", "Destinos Turísticos", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, buttons, buttons[4]);
                switch(op){
                    case 0:
                         cadastrarDestino();
                         break;
                    case 1:
                        try {
                            listarDestinos();
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Erro:\n " + e, "Destinos Turísticos", JOptionPane.ERROR_MESSAGE);
                        }
                         break;
                    case 2:
                         try {
                            alterarDestino();
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Erro:\n " + e, "Destinos Turísticos", JOptionPane.ERROR_MESSAGE);
                        }
                         break;
                    case 3:
                        try {
                            excluirDestino();
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Cadastro Erro:\n " + e, "Destinos Turísticos", JOptionPane.ERROR_MESSAGE);
                        }
                         break;
                 }
         }while(op != 4);
    }
    
    public static void cadastrarDestino(){
        try{
            String nome = JOptionPane.showInputDialog(null, "Informe o nome do novo destino turístico no campo abaixo:", "Destinos Turísticos", JOptionPane.INFORMATION_MESSAGE);
            String cidade = JOptionPane.showInputDialog(null, "Informe, no campo abaixo, a cidade em que " + nome + " está localizado(a):", "Destinos Turísticos", JOptionPane.INFORMATION_MESSAGE);
            String estado = JOptionPane.showInputDialog(null, "Informe, no campo abaixo, o estado em que " + nome + " está localizado(a):", "Destinos Turísticos", JOptionPane.INFORMATION_MESSAGE);
            String historia = JOptionPane.showInputDialog(null, "Informe, no campo abaixo, a história em que " + nome + " está localizado(a):", "Destinos Turísticos", JOptionPane.INFORMATION_MESSAGE);
            DestinoTuristico.destinosTuristicos.add(new DestinoTuristico(nome, cidade, estado, historia));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Cadastro Erro:\n " + e, "Destinos Turísticos", JOptionPane.ERROR_MESSAGE);
        }finally{
            JOptionPane.showMessageDialog(null, "Destino Turístico cadastrado com sucesso!", "Destinos Turísticos", JOptionPane.INFORMATION_MESSAGE);
        }        
    }
    
    public static void listarDestinos() throws FileNotFoundException, IOException{
        String conteudo = "";
        try{    
            for (DestinoTuristico dt : DestinoTuristico.destinosTuristicos) {
                conteudo+=
                        "Nome: "+ dt.getNome() + 
                        "\nCidade: " + dt.getCidade() + 
                        "\nEstado: " + dt.getEstado() +
                        "\nHistória: " + dt.getHistoria()+ 
                        "\n\n\n";
            }
            if(conteudo.equals("")){
                JOptionPane.showMessageDialog(null, "Não há dados cadastrados ainda.", "Destinos Turísticos", JOptionPane.INFORMATION_MESSAGE);  
            }else{
                JOptionPane.showMessageDialog(null, conteudo, "Destinos Turísticos", JOptionPane.INFORMATION_MESSAGE);
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Listagem Erro:\n " + ex, "Destinos Turísticos", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void alterarDestino() {
        
    }

    private static void excluirDestino() {
        
    }
}
    