/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trabalho2;

import Buscas.BuscaProfundidade;
import ColorScale.RainbowScale;
import DesenharGrafo.Edge;
import DesenharGrafo.Graph;
import DesenharGrafo.Vertex;
import Interface.ArvoreGeradoraMinima;
import Interface.BuscaEmLargura;
import notUsed.BuscaEmProfundidade;
import notUsed.CaminhoEntreDoisVertices;
import Interface.CaminhoMinimoEntreVertices;
import Interface.ComponentesConexas;
import Interface.Coloracao;
import Interface.ComponentesConexas;
import Interface.Conectividade;
import grafos.Aresta;
import grafos.Grafo;
import grafos.ListaAdjacencia;
import grafos.MatrizAdjacencia;
import grafos.Utilitarios;
import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Eymar Lima
 */
public class Main extends javax.swing.JFrame {
    private int status;
    
    private static Graph desenho;
    
    public static ListaAdjacencia lista;
    public static MatrizAdjacencia matriz;
    public  ViewPanel view;
    private BufferedImage imageBuffer;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public boolean isMatrizSelected()
    {
        if(jRadioButton1.isSelected()) return(true);
        return(false);
    }
    
    /**
     * Creates new form Main
     */
  
    public Main() {
        view = new ViewPanel();
        
        this.setVisible(true);
        
        status=0;
        initComponents();
        jPanel1.removeAll();
        jPanel1.add(new Start(this.status));
        jPanel1.revalidate();
        jPanel1.repaint();
        
        jRadioButton1.setSelected(true);
        jPanel1.setLayout(new GridLayout(1, 1));
        
        this.setLocationRelativeTo(null);
        try{
            Image icon = Toolkit.getDefaultToolkit().getImage("src/gui/images/mainicon.png");
            setIconImage(icon);
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e, "ERRO", 0);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane(this.view);
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        loadFile = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        jMenu5.setText("File");
        jMenuBar2.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar2.add(jMenu6);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trabalho Prático de Grafos II");
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 138, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Tipo de Estrutura:");

        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton1.setText("Matriz");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton2.setText("Lista");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton1)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton2)
                .addContainerGap(349, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jMenu4.setText("Inicio");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        jMenu1.setText("Arquivo");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        loadFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/loadFile.png"))); // NOI18N
        loadFile.setText("Carregar");
        loadFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadFileActionPerformed(evt);
            }
        });
        jMenu1.add(loadFile);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Funções");

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search2.png"))); // NOI18N
        jMenuItem2.setText("Busca em Largura");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/connection.png"))); // NOI18N
        jMenuItem4.setText("Componentes Conexas (Grafos)");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tree.png"))); // NOI18N
        jMenuItem5.setText("Árvore Geradora Mínima");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/line.png"))); // NOI18N
        jMenuItem6.setText("Caminho Mínimo Entre Vértices");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/redColorWheel.png"))); // NOI18N
        jMenuItem1.setText("Coloração");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/conectivityRed.png"))); // NOI18N
        jMenuItem3.setText("Conectividade (Dígrafo)");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Sobre");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowStateChanged

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
    }//GEN-LAST:event_formWindowOpened

    private void loadFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadFileActionPerformed
        JFileChooser file = new JFileChooser();
        file.setDialogTitle("fodac");
        file.setFileFilter(new FileFilter(){

            @Override
            public boolean accept(File f) {
                return(f.getName().endsWith(".txt") || f.isDirectory());
            }
            
            @Override
            public String getDescription(){
                return "Arquivo de Texto (.txt)";
            }
        });
            
    int opcao = file.showOpenDialog(this);
    
    if(opcao == JFileChooser.APPROVE_OPTION){
        String diretorio = file.getSelectedFile().getAbsolutePath();
        this.status = 1;
        
        Grafo[] grafos;
        
        grafos = Utilitarios.leitura(diretorio);
        
        lista = (ListaAdjacencia) grafos[0];
        matriz = (MatrizAdjacencia) grafos[1];
        
        jPanel1.removeAll();
        jPanel1.add(new Start(this.status));
        jPanel1.revalidate();
        jPanel1.repaint();
        
        //desenho:
        this.desenho = leituraDesenho();
        this.print();
    }
    
    //apartir de agora a string diretorio possui o diretorio do arquivo
    
    }//GEN-LAST:event_loadFileActionPerformed

    private Graph leituraDesenho(){
       Graph grafoDesenho;
       grafoDesenho = new Graph(lista.getNumVertices(),lista.isOrientado());
       PriorityQueue<Aresta> arestas = lista.getArestas();
       
       for(Aresta a : arestas){
            Vertex vS = grafoDesenho.getVertex().get(a.getNodeA());
            Vertex vT = grafoDesenho.getVertex().get(a.getNodeB());
            Edge e = new Edge(vS, vT, a.getValor());
                
            grafoDesenho.addEdge(e);
       }
       return grafoDesenho;
    }
    
    public void print(){
        this.view.setGraph(desenho);
    }
    
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        jPanel1.removeAll();
        jPanel1.add(new BuscaEmLargura(this));
        jPanel1.revalidate();
        jPanel1.repaint();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        jPanel1.removeAll();
        jPanel1.add(new Start(this.status));
        jPanel1.revalidate();
        jPanel1.repaint();
    }//GEN-LAST:event_jMenu4MouseClicked

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        jPanel1.removeAll();
        jPanel1.add(new ComponentesConexas(this));
        jPanel1.revalidate();
        jPanel1.repaint();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        jPanel1.removeAll();
        jPanel1.add(new ArvoreGeradoraMinima(this));
        jPanel1.revalidate();
        jPanel1.repaint();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        jPanel1.removeAll();
        jPanel1.add(new CaminhoMinimoEntreVertices(this));
        jPanel1.revalidate();
        jPanel1.repaint();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        jRadioButton2.setSelected(false);
        jRadioButton1.setSelected(true);
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        jRadioButton1.setSelected(false);
        jRadioButton2.setSelected(true);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
        
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        Sobre s = new Sobre(this, true);
        s.setVisible(true);
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        jPanel1.removeAll();
        jPanel1.add(new Coloracao(this));
        jPanel1.revalidate();
        jPanel1.repaint();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        jPanel1.removeAll();
        jPanel1.add(new Conectividade(this));
        jPanel1.revalidate();
        jPanel1.repaint();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem loadFile;
    // End of variables declaration//GEN-END:variables
    
    public void componentesConexas(){
        Grafo grafo;
        int componentes[];
        
        if(isMatrizSelected()) grafo = matriz;
        else grafo = lista;
        
        
        
        BuscaProfundidade busca = new BuscaProfundidade(grafo);
        busca.buscaProfundidade(0);
        componentes = busca.getComponentes();
        
        int compStep = 255 / componentes.length;
        RainbowScale rbS = new RainbowScale();
        
        for(int i=0;i<componentes.length;i++){
            desenho.getVertex().get(i).setColor(rbS.getColor(componentes[i] * compStep));
        }
        view.cleanImage();
        view.repaint();
    }
    
    
    public class ViewPanel extends JPanel {

        public ViewPanel() {
            this.setBackground(java.awt.Color.WHITE);
            this.setLayout(new FlowLayout(FlowLayout.LEFT));
        }

        @Override
        public void paintComponent(java.awt.Graphics g) {
            super.paintComponent(g);

            java.awt.Graphics2D g2 = (java.awt.Graphics2D) g;
            ////configuração do rendering para obeter melhor qualidade
            g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
            g2.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
            g2.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);

            if (desenho != null && this.imageBuffer == null) {
                this.imageBuffer = new BufferedImage(desenho.getSize().width + 1,
                        desenho.getSize().height + 1, BufferedImage.TYPE_INT_RGB);

                java.awt.Graphics2D g2Buffer = this.imageBuffer.createGraphics();
                g2Buffer.setColor(this.getBackground());
                g2Buffer.fillRect(0, 0, desenho.getSize().width + 1, desenho.getSize().height + 1);

                g2Buffer.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                desenho.draw(g2Buffer);
                g2Buffer.dispose();
            }

            if (this.imageBuffer != null) {
                g2.drawImage(this.imageBuffer, 0, 0, null);
            }
        }

        public void setGraph(Graph graph) {
            if (graph != null) {
                this.setPreferredSize(new Dimension(graph.getSize().width * 2,
                        graph.getSize().height * 2));
                this.setSize(new Dimension(graph.getSize().width * 2,
                        graph.getSize().height * 2));

                this.cleanImage();
                this.repaint();
            }
        }

        public Vertex getMarkedVertex() {
            return markedVertex;
        }

        public void cleanImage() {
            this.imageBuffer = null;
        }

        public void adjustPanel() {
            float iniX = desenho.getVertex().get(0).getX();
            float iniY = desenho.getVertex().get(0).getY();
            float max_x = iniX, max_y = iniX;
            float min_x = iniY, min_y = iniY;
            int zero = desenho.getVertex().get(0).getRay() * 5 + 10;

            for (int i = 1; i < desenho.getVertex().size(); i++) {
                float x = desenho.getVertex().get(i).getX();
                if (max_x < x) {
                    max_x = x;
                } else if (min_x > x) {
                    min_x = x;
                }

                float y = desenho.getVertex().get(i).getY();
                if (max_y < y) {
                    max_y = y;
                } else if (min_y > y) {
                    min_y = y;
                }
            }

            for (Vertex v : desenho.getVertex()) {
                v.setX(v.getX() + zero - min_x);
                v.setY(v.getY() + zero - min_y);
            }

            Dimension d = this.getSize();
            d.width = (int) max_x + zero;
            d.height = (int) max_y + zero;
            this.setSize(d);
            this.setPreferredSize(d);
        }

        public void markVertices(ArrayList<Vertex> vertices) {
            if (vertices != null) {
                this.cleanMarkedVertices(false);

                //change the vertices' colors
                for (Vertex v : vertices) {
                    v.setSelected(true);
                }

                this.cleanImage();
                this.repaint();
            }
        }

        public void cleanMarkedVertices(boolean cleanVertex) {
            if (desenho != null) {
                this.markedVertex = null;

                for (Vertex vertex : desenho.getVertex()) {
                    vertex.setSelected(false);

                }
            }

            this.cleanImage();
            this.repaint();
        }

        @Override
        public void setFont(java.awt.Font font) {
            //
        }

        @Override
        public java.awt.Font getFont() {
            return null;// colocar alguma fonte
        }

        @Override
        public void setBackground(Color bg) {
            super.setBackground(bg);

        }
        private java.awt.Color color = java.awt.Color.RED;
        //Used to color based on a document
        private Vertex markedVertex;
        //Used to move the points
        private Vertex selectedVertex;
        //contain the selected vertices which will be moved
        private ArrayList<Vertex> selectedVertices;
        //The image which will be drawn as a graph
        private BufferedImage imageBuffer;
    }
}


