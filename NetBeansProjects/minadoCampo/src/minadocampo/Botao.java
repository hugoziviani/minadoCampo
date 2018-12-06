/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minadocampo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JOptionPane;


/**
 *
 * @author hz
 */
public class Botao extends JButton {
   
    protected boolean ocupado = false;
    protected boolean temBomba = false;
    protected int bombasEmVolta = 0;
    boolean clicado = false;
    private boolean marcadorDeMinas = false;
    private int i, j;

    public int getI() {
        return i;
    }
    public int getJ() {
        return j;
    }
    public void setPosicao(int i, int j){
        this.i=i;
        this.j=j;
        
    }
    
    
    
    public final Icon ic_bomba = new javax.swing.ImageIcon(getClass().getResource("bomba.png"));
    public final Icon ic_bandeirinha = new javax.swing.ImageIcon(getClass().getResource("bandeirinha.png"));
    
    public Botao() { //construtor do botão
        super();
        setText("");
        //addActionListener(btHand);
        this.addMouseListener(new MouseHandler());
        
    }
    Botao(String text){
        super();
        setText(text);
        //addActionListener(btHand);
        this.addMouseListener(new MouseHandler());
        
        
        
    }
    public boolean getOcupado(){
        return ocupado;
    }
    public void setOcupado(boolean x){
        this.ocupado = x;
    }

    public int getBombasEmVolta() {
        return bombasEmVolta;
    }

    public void setBombasEmVolta(int bombasEmVolta) {
        this.bombasEmVolta = bombasEmVolta;
    }
    
    
    
    private class MouseHandler extends MouseAdapter {
        public void mouseClicked (MouseEvent evt){
            Botao aux = (Botao) evt.getComponent();
            if(aux.getOcupado() == false){
                switch (evt.getButton()){
                    case MouseEvent.BUTTON1:{System.out.println("direito");
                        JanelaPrincipalJogo.addClike();
                        
                        if(aux.temBomba && !aux.getOcupado()){
                            aux.setIcon(ic_bomba);//seta ic_bomba
                            JanelaPrincipalJogo.varreMostraBomba(ic_bomba);
                            
                            JOptionPane.showMessageDialog(null,"Fim de jogo - Você perdeu com apenas "+JanelaPrincipalJogo.getClike() +" cliks");
                            // Partida.nova();
                        }
                        if(aux.getBombasEmVolta()!=0 && !aux.getOcupado()){
                            //mostra o número de bombas
                            aux.setBackground(new Color(0, 100, 0));
                            aux.setFont(new Font("Arial", Font.BOLD, 18));
                            aux.setForeground(new Color(0, 0, 0));
                            aux.setText(Integer.toString(aux.getBombasEmVolta()));
                            aux.setOcupado(true);//fica ocupado
                        }else{
                            aux.setBackground(new Color(0, 100, 0));
                            aux.setForeground(new Color(0, 0, 0));
                            aux.setText(Integer.toString(aux.getBombasEmVolta()));
                            aux.setOcupado(true);//fica ocupado
                        }
                       
                        
                        
                        break;
                    }
                    case MouseEvent.BUTTON3:{System.out.println("esquerdo");
                        aux.setIcon(ic_bandeirinha);
                        break;
                    }
                        
                
                }
                        
                        
            }
        }
    }

}