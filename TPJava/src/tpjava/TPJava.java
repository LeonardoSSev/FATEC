/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpjava;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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
        }finally{
            JOptionPane.showMessageDialog(null, "A aplicação foi encerrada.", "Destinos Turísticos", JOptionPane.INFORMATION_MESSAGE);
        }        
    }
    
    public static void exibeMenu(int op, String buttons[]){
        do{
            op = JOptionPane.showOptionDialog(null, "Bem vindo!\\nInforme uma opção através dos botões abaixo:", "Destinos Turísticos", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, buttons, buttons[4]);
                switch(op){
                    case 0:
                         cadastrarDestino();
                         break;
                    case 1:
                         listarDestinos();
                         break;
                    case 2:
                         alterarDestino();
                         break;
                    case 3:
                        excluirDestino();
                        break;
                 }
         }while(op != 4);
    }
    
    public static void cadastrarDestino(){
        JOptionPane.showMessageDialog(null, "Cadastrar Destino", "Destinos Turísticos", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void listarDestinos(){
        JOptionPane.showMessageDialog(null, "Listar Destinos", "Destinos Turísticos", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void alterarDestino(){
        JOptionPane.showMessageDialog(null, "Alterar Destino", "Destinos Turísticos", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void excluirDestino(){
        JOptionPane.showMessageDialog(null, "Excluir Destino", "Destinos Turísticos", JOptionPane.INFORMATION_MESSAGE);
    }
    
    
}
