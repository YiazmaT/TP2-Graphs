/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Buscas.BuscaProfundidade;
import Trabalho2.Main;
import grafos.Grafo;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Eymar Lima
 */
public class VerificarSeUmGrafoEConexo extends javax.swing.JPanel {
    
    Main pai;
    public VerificarSeUmGrafoEConexo(Main pai) {
        initComponents();
        this.pai = pai;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jButton1 = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Verificar se Um Grafo é Conexo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/connectionBlack.png"))); // NOI18N
        jButton1.setText("Verificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(0, 143, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Grafo grafo;
       if(pai.isMatrizSelected()) grafo = Main.matriz;
       else grafo = Main.lista;
       
       if(grafo.isOrientado() == true){
           JOptionPane.showMessageDialog(null, "O grafo carregado é orientado!");
           return;
       }
       
       BuscaProfundidade busca = new BuscaProfundidade(grafo);
       busca.buscaProfundidade(0);
       
       if(grafo == null){
           JOptionPane.showMessageDialog(null, "Nenhum grafo foi carregado!");
           return;
       }
       /*
       if(busca.grafoConexo()) jTextArea1.setText("O grafo é conexo !!");
       else
       {
           jTextArea1.setText("O grafo não é conexo !!");
           int[] componentes = busca.getComponentes();
           for(int i = 0; i < grafo.getNumVertices(); i++)
               jTextArea1.append("\nO vertice " + i + " pertence ao componente " + componentes[i]);
       }*/
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    // End of variables declaration//GEN-END:variables
}
