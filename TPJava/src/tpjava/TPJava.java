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
        int op;
        String[] buttons = { "Cadastrar", "Listar", "Alterar", "Excluir", "Sair"};
        
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
         
        JOptionPane.showMessageDialog(null, "A aplicação foi encerrada.", "Destinos Turísticos", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void cadastrarDestino(){
    
    }
    public static void listarDestinos(){
    
    }
    public static void alterarDestino(){
    
    }
    public static void excluirDestino(){
    
    }
    
    
}
