/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minadocampo;

import java.awt.GridLayout;
import javax.swing.JFrame;


public class TelaBotoes extends JFrame {
    private Botao [] plainButton;
    
    
    public TelaBotoes (int aux, int dimensao){
        super ("Testando Bts");
        int qtd = aux;
        if(qtd < 1) {qtd = 9;} else{qtd = qtd*qtd;}
        if(dimensao < 100){dimensao = 700;}
        setSize(dimensao, dimensao);
        plainButton = new Botao[qtd];
       
        setLayout(new GridLayout(aux, aux));
        for(int i =0; i < qtd ; i++){
            plainButton[i] = new Botao("FH");
            super.add(plainButton[i]);
            
        }
       
        
        
  
    
        
    }

    TelaBotoes () {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }
  
    
}

