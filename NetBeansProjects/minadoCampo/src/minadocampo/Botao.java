/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minadocampo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author hz
 */
public class Botao extends JButton {
    String txtPadrao = "txtP";
    Boolean ocupado = false;
    private int situacao = 0;
    private boolean marcadorDeMinas = false;
    public final Icon ic_bomba = new javax.swing.ImageIcon(getClass().getResource("bomba.png"));
    public final Icon ic_bandeirinha = new javax.swing.ImageIcon(getClass().getResource("bandeirinha.png"));
    
    public Botao() { //construtor do botão
        super();
        setText(txtPadrao);
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
    
    
    private class MouseHandler extends MouseAdapter {
        public void mouseClicked (MouseEvent evt){
            Botao aux = (Botao) evt.getComponent();
            if(aux.getOcupado() == false){
                switch (evt.getButton()){
                    case MouseEvent.BUTTON1:{System.out.println("direito"); 
                        aux.setText("S");
                        ic_bomba.paintIcon(aux, getGraphics().create(), CENTER, CENTER);
                        aux.setIcon(ic_bomba);
                        
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