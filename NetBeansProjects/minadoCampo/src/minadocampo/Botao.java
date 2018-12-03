/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minadocampo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author hz
 */
public class Botao extends JButton{
    String txtPadrao = "txtP";
    BotaoHandler btHand = new BotaoHandler();
    MouseListener eventoM = new MouseListener();
    
    
    
    
    public Botao() { //construtor do botão
        super();
        setText(txtPadrao);
        addActionListener(btHand);
    }
    Botao(String text){
        super();
        setText(text);
        addActionListener(btHand);
        addMouseListener(eventoM);
        
    }
    
  
    
    
    private class BotaoHandler implements ActionListener {
        public void actionPerformed(ActionEvent event){
            System.out.println("Pressinou a porra toda!!");
            //JOptionPane.showMessageDialog(Botao.this, String.format("Donald LINDA %s",event.getActionCommand()));
                    
        }
        
    }
   
    public void MouseCliked (MouseEvent evt){     
            
            switch (evt.getButton()){
                case MouseEvent.BUTTON1:
                    System.out.println("Clik1");
                    break;
                case MouseEvent.BUTTON2:
                    System.out.println("Clik2");
                    break;
                case MouseEvent.BUTTON3:
                    System.out.println("Clik3");
            }
            
        
        
    }
    
}


