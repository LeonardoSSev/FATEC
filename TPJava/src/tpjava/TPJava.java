/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpjava;

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
            op = JOptionPane.showOptionDialog(null, "Bem vindo!\nInforme uma opção através dos botões abaixo:", "Destinos Turísticos", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, buttons, buttons[4]);
                switch(op){
                    case 0:
                         cadastrarDestino();
                         break;
                    case 1:
                        String conteudo = listarDestinos();
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
        boolean flag = false;
        String metodo = "cadastrado";
        try{
            String nome = JOptionPane.showInputDialog(null, "Informe o nome do novo destino turístico no campo abaixo:", "Destinos Turísticos", JOptionPane.INFORMATION_MESSAGE);
            String cidade = JOptionPane.showInputDialog(null, "Informe, no campo abaixo, a cidade em que " + nome + " está localizado(a):", "Destinos Turísticos", JOptionPane.INFORMATION_MESSAGE);
            String estado = JOptionPane.showInputDialog(null, "Informe, no campo abaixo, o estado em que " + nome + " está localizado(a):", "Destinos Turísticos", JOptionPane.INFORMATION_MESSAGE);
            String historia = JOptionPane.showInputDialog(null, "Informe, no campo abaixo, a história de " + nome + ":", "Destinos Turísticos", JOptionPane.INFORMATION_MESSAGE);
            
            if(nome.isEmpty() || cidade.isEmpty() || estado.isEmpty() || historia.isEmpty()){
                JOptionPane.showMessageDialog(null, "Dados não aceitos para cadastro!", "Destinos Turísticos", JOptionPane.ERROR_MESSAGE);
            }else{
                DestinoTuristico.destinosTuristicos.add(new DestinoTuristico(nome, cidade, estado, historia));
                JOptionPane.showMessageDialog(null, "Destino Turístico cadastrado com sucesso!", "Destinos Turísticos", JOptionPane.INFORMATION_MESSAGE);
                flag = true;
            }
            verificaFlag(flag, metodo);
            
        }catch(Exception e){
            getMensagemErro("Cadastrar", e);
        }
    }
    
    public static String listarDestinos(){
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
            if(conteudo.isEmpty()){
                JOptionPane.showMessageDialog(null, "Não há dados cadastrados ainda.", "Destinos Turísticos", JOptionPane.INFORMATION_MESSAGE);  
            }else{
                JOptionPane.showMessageDialog(null, conteudo, "Destinos Turísticos", JOptionPane.INFORMATION_MESSAGE);
            }
            
        }catch(Exception e){
            getMensagemErro("Listar", e);
        }
        
        return conteudo;
    }

    private static void alterarDestino() {
        String listagem = listarDestinos();
        String metodo = "alterado";
        
        if(!listagem.isEmpty()){
            String conteudo = "";
            String[] dados = buscarDestino();
            
            boolean flag = false;

            try{
                for (DestinoTuristico dt : DestinoTuristico.destinosTuristicos) {
                    if((dt.getNome().equalsIgnoreCase(dados[0])) && (dt.getCidade().equalsIgnoreCase(dados[1]))){
                        conteudo+=
                            "Nome: "+ dt.getNome() + 
                            "\nCidade: " + dt.getCidade() + 
                            "\nEstado: " + dt.getEstado() +
                            "\nHistória: " + dt.getHistoria()+ 
                            "\n\n\n";

                        JOptionPane.showMessageDialog(null, conteudo, "Destinos Turísticos", JOptionPane.INFORMATION_MESSAGE);
                        dt.setNome(JOptionPane.showInputDialog(null, "Informe o novo nome para "+dt.getNome()+" no campo abaixo:", "Destinos Turísticos", JOptionPane.INFORMATION_MESSAGE));
                        dt.setCidade(JOptionPane.showInputDialog(null, "Informe, no campo abaixo, a cidade em que " + dt.getNome() + " está localizado(a):", "Destinos Turísticos", JOptionPane.INFORMATION_MESSAGE));
                        dt.setEstado(JOptionPane.showInputDialog(null, "Informe, no campo abaixo, o estado em que " + dt.getNome() + " está localizado(a):", "Destinos Turísticos", JOptionPane.INFORMATION_MESSAGE));
                        dt.setHistoria(JOptionPane.showInputDialog(null, "Informe, no campo abaixo, a história de " + dt.getNome() + ":", "Destinos Turísticos", JOptionPane.INFORMATION_MESSAGE));
                        flag = true;
                    }
                }
                if(flag){
                    JOptionPane.showMessageDialog(null, "Destino alterado com sucesso!", "Destinos Turísticos", JOptionPane.INFORMATION_MESSAGE);
                } else{
                    getMensagemFalha(metodo);
                }
            }catch(Exception e){
                getMensagemErro("Alterar", e);
            }
            verificaFlag(flag, metodo);
        }

    }

    private static void excluirDestino() {
        String listagem = listarDestinos();
        String metodo = "excluído";
        String conteudo = "";
        boolean flag = false;
        if(!listagem.isEmpty()){
            String[] dados = buscarDestino();
            try{
                for (int i = 0; i < DestinoTuristico.destinosTuristicos.size(); i++) {
                    if((DestinoTuristico.destinosTuristicos.get(i).getNome().equalsIgnoreCase(dados[0])) && (DestinoTuristico.destinosTuristicos.get(i).getCidade().equalsIgnoreCase(dados[1]))){
                        DestinoTuristico dt = DestinoTuristico.destinosTuristicos.get(i);
                        conteudo+=
                            "Nome: "+ dt.getNome() + 
                            "\nCidade: " + dt.getCidade() + 
                            "\nEstado: " + dt.getEstado() +
                            "\nHistória: " + dt.getHistoria()+ 
                            "\n\n\n";

                        int excluir = JOptionPane.showConfirmDialog (null, conteudo, "Destinos Turísticos", JOptionPane.INFORMATION_MESSAGE);
                        if(excluir == JOptionPane.YES_OPTION){
                            DestinoTuristico.destinosTuristicos.remove(i);
                            flag = true;
                            JOptionPane.showMessageDialog(null, "Destino excluído com sucesso!", "Destinos Turísticos", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
                
                
            }catch(Exception e){
                getMensagemErro("Excluir", e);
            }
            verificaFlag(flag, metodo);
        }
        
    }
    
    private static String[] buscarDestino(){
        String[] dados = new String[2];
        dados[0] = JOptionPane.showInputDialog(null, "Informe, no campo abaixo, o nome do destino que você deseja alterar:", "Destinos Turísticos", JOptionPane.INFORMATION_MESSAGE);
        dados[1] = JOptionPane.showInputDialog(null, "Informe, no campo abaixo, a cidade do destino que você deseja alterar:", "Destinos Turísticos", JOptionPane.INFORMATION_MESSAGE);
        return dados;
    }
    
    private static void verificaFlag(boolean flag, String metodo){
        if(flag){
                getMensagemSucesso(metodo);
            } else{
                getMensagemFalha(metodo);
            }
    }
    
    private static void getMensagemSucesso(String metodo){
        JOptionPane.showMessageDialog(null, "Destino " + metodo + "  com sucesso!", "Destinos Turísticos", JOptionPane.INFORMATION_MESSAGE);
    }
    private static void getMensagemFalha(String metodo){
        JOptionPane.showMessageDialog(null, "Destino não " + metodo +"!", "Destinos Turísticos", JOptionPane.ERROR_MESSAGE);
    }
    private static void getMensagemErro(String metodo, Exception e){
         JOptionPane.showMessageDialog(null, "Erro ao " + metodo + ":\n " + e, "Destinos Turísticos", JOptionPane.ERROR_MESSAGE);
    }
}
    