/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minadocampo;

import java.awt.GridLayout;
import java.util.Random;
import javax.swing.Icon;

/**
 *
 * @author hz
 */
public class JanelaPrincipalJogo extends javax.swing.JFrame {
    final int BF = 3;
    final int BM = 6;
    final int BD = 9;
    
    private static int clike =0;
    final int NLINCOL = 5;
    
    private int nBombas = NLINCOL;
  
    private static Botao [][] matBotoes;
    
    public JanelaPrincipalJogo() {
        
        initComponents();
        this.fazBotoes(NLINCOL);
        
        
        
    }
    public void fazBotoes(int qtd){
        
        matBotoes = new Botao[qtd][qtd];
        jBotoes.setLayout(new GridLayout(qtd, qtd));
        for(int i=0; i < matBotoes.length; i++){
            for(int j=0; j<matBotoes.length; j++){
                Random bf = new Random();
            int n = bf.nextInt(10);                       
            matBotoes[i][j] = new Botao();
            matBotoes[i][j].setPosicao(i, j);
            if(n < 5 && nBombas > 0){
                matBotoes[i][j].temBomba = true;        
                nBombas--;
            }
            jBotoes.add(matBotoes[i][j]);
            matBotoes[i][j].setVisible(true);
            
                
            }
            
        }
    
    jBotoes.setVisible(true);
        
    }
    
    public static void varreMostraBomba(Icon ic_bomba){
        for (int i=0; i< matBotoes.length; i++) {
            for(int j=0; j<matBotoes.length; j++){
                if (matBotoes[i][j].temBomba) {
                    matBotoes[i][j].setIcon(ic_bomba);
                }
            }
            
        }
    }
    public static void addClike(){
        clike++;
    }
    public static int getClike(){
        return clike;
    }
    
    private void contaBombasRedor(int qtd){
        for(int i=0; i < matBotoes.length; i++){
            for(int j=0; j<matBotoes.length; j++){
                //VER BOMBA!!!!!!! ANTES DE ENTRAR NOS IFS pq se ele é uma bomba nao precisa de contar quantas tao em volta
                if(!matBotoes[i][j].temBomba){
                    if((i-1>=0) && (j-1>=0)){               //vizinho Noroeste
                        if(!matBotoes[i-1][j-1].temBomba){
                            matBotoes[i][j].bombasEmVolta++;
                        }
                    }
                    if(i-1>=0){                             //vizinho Norte
                        if(!matBotoes[i-1][j].temBomba){
                            matBotoes[i][j].bombasEmVolta++;
                        }
                    }
                    if((i+1<qtd) && (j+1<qtd)){             //vizinho Nordeste
                        if(!matBotoes[i+1][j+1].temBomba){
                            matBotoes[i][j].bombasEmVolta++;
                        }
                    }
                    if(j-1>=0){                            //vizinho Oeste
                        if(!matBotoes[i][j-1].temBomba){
                            matBotoes[i][j].bombasEmVolta++;
                        }
                    }                              
                    if(j+1<qtd){                            //vizinho Leste
                        if(!matBotoes[i][j+1].temBomba){
                            matBotoes[i][j].bombasEmVolta++;
                        }
                    }
                    if((i+1<qtd)&&(j-1>=0)){                //vizinho Sudoeste
                        if(!matBotoes[i+1][j-1].temBomba){
                            matBotoes[i][j].bombasEmVolta++;
                        }
                    }
                    if(i+1<qtd){                           //vizinho Sul
                        if(!matBotoes[i+1][j].temBomba){
                            matBotoes[i][j].bombasEmVolta++;
                        }
                    }
                    if((i+1<qtd)&&(j+1<qtd)){              //vizinho Sudeste
                        if(!matBotoes[i+1][j+1].temBomba){
                            matBotoes[i][j].bombasEmVolta++;
                        }
                    }

                }    
            }
     
        }
    
    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInformacoes = new javax.swing.JDesktopPane();
        jBotoes = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInformacoes.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 0, 204)));

        javax.swing.GroupLayout jInformacoesLayout = new javax.swing.GroupLayout(jInformacoes);
        jInformacoes.setLayout(jInformacoesLayout);
        jInformacoesLayout.setHorizontalGroup(
            jInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInformacoesLayout.setVerticalGroup(
            jInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 58, Short.MAX_VALUE)
        );

        jBotoes.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 0, 51)));

        javax.swing.GroupLayout jBotoesLayout = new javax.swing.GroupLayout(jBotoes);
        jBotoes.setLayout(jBotoesLayout);
        jBotoesLayout.setHorizontalGroup(
            jBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 415, Short.MAX_VALUE)
        );
        jBotoesLayout.setVerticalGroup(
            jBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 195, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jInformacoes)
                    .addComponent(jBotoes))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jInformacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBotoes)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipalJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipalJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipalJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipalJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JanelaPrincipalJogo janela = new JanelaPrincipalJogo();                
                janela.setLocationRelativeTo(null);
                janela.setSize(600, 450);
                janela.setVisible(true);
            }
        });
    }
    
    /**
     *
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jBotoes;
    private javax.swing.JDesktopPane jInformacoes;
    // End of variables declaration//GEN-END:variables
}
