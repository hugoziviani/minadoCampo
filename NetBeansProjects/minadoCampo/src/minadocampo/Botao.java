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
   
    protected boolean desocupado = true;
    protected boolean temBomba = false;
    protected int bombasEmVolta = 0;
    private boolean clicado = false;
    private boolean marcadoDeMina = false;

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
    public boolean getDesocupado(){
        return desocupado;
    }
    public void setDesocupado(boolean x){
        this.desocupado = x;
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
            
                switch (evt.getButton()){
                    case MouseEvent.BUTTON1:{System.out.println("direito");
                        JanelaPrincipalJogo.addClike();
                        if(aux.marcadoDeMina)break;
                        if(aux.temBomba){
                            aux.setIcon(ic_bomba);//seta ic_bomba
                            JanelaPrincipalJogo.varreMostraBomba(ic_bomba);
                            
                            JOptionPane.showMessageDialog(null,"Fim de jogo - Você perdeu com apenas "+JanelaPrincipalJogo.getClike() +" cliks");
                            
                            // Partida.nova();
                        }else{ 
                            if(aux.getBombasEmVolta()==0){
                            aux.setBackground(new Color(0, 0, 250));
                            aux.setForeground(new Color(0, 0, 0));
                            aux.setText(Integer.toString(aux.getBombasEmVolta()));
                            aux.setDesocupado(false);//fica desocupado
                            }
                            if(aux.getBombasEmVolta()!=0){
                                //mostra o número de bombas
                                aux.setBackground(new Color(0, 250, 0));
                                aux.setFont(new Font("Arial", Font.BOLD, 18));
                                aux.setForeground(new Color(0, 0, 0));
                                aux.setText(Integer.toString(aux.getBombasEmVolta()));
                                aux.setDesocupado(false);//fica desocupado
                            }
                        }
                        
                        break;
                    }
                    case MouseEvent.BUTTON3:{System.out.println("esquerdo");
                        if(aux.getDesocupado() == true ){
                            aux.setIcon(ic_bandeirinha);
                            aux.setDesocupado(false);//coloca ele ocupado
                            aux.marcadoDeMina = true;
                            break;
                        }
                        if(aux.getDesocupado()){
                            aux.setIcon(null);
                            aux.setDesocupado(true);
                            aux.marcadoDeMina = false;
                        
                            break;
                        }
                            
                    }
                        
                
                
                        
                        
            }
        }
    }

}