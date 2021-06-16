package escritorio;

import baseDatos.MySqlConn;
import static escritorio.Escritorio.jDesktopPane1;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Ocupacion extends javax.swing.JInternalFrame {

    MySqlConn conn = new MySqlConn();
    int Hunn1 = 8, Hunn2 = 5, hunn = 13;
    int Itza1 = 4, Itza2 = 6, itza = 10;
    int Kauil1 = 3, Kauil2 = 4, kauil = 7, totalHab = 30;
    boolean bandera = false;

    public Ocupacion(MySqlConn conn) {
        this.conn = conn;
        initComponents();
        this.jLabelHab.setEnabled(false);
    }

    public Ocupacion() {
        initComponents();
        this.jLabelHab.setEnabled(false);
    }

    public void paint(Graphics g) {

        super.paint(g);
        if (bandera == true) {

            int total_votos = hunn + itza + kauil;

            int grados_rojo = hunn * 360 / total_votos;
            int grados_verde = itza * 360 / total_votos;
            int grados_azul = kauil * 360 / total_votos;

            g.setColor(new Color(255, 0, 0));
            g.fillArc(25, 80, 200, 200, 0, grados_rojo);
            g.fillRect(250, 120, 20, 20);
            g.drawString("Habitaciones Hunn", 275, 135);

            g.setColor(new Color(0, 130, 0));
            g.fillArc(25, 80, 200, 200, grados_rojo, grados_verde);
            g.fillRect(250, 150, 20, 20);
            g.drawString("Habitaciones Itza", 275, 165);

            g.setColor(new Color(0, 0, 255));
            g.fillArc(25, 80, 200, 200, grados_rojo + grados_verde, grados_azul);
            g.fillRect(250, 180, 20, 20);
            g.drawString("Habitaciones Kauil", 275, 195);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonGraficar = new javax.swing.JButton();
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/ayaye_logo.png"));
        Image image = icon.getImage();
        jPanel4 = new javax.swing.JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButtonMostrar = new javax.swing.JButton();
        jButtonCostos = new javax.swing.JButton();
        jLabelHab = new javax.swing.JLabel();
        jButtonBuscar = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Ocupación");

        jButtonGraficar.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        jButtonGraficar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonGraficar.setText("Graficar");
        jButtonGraficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGraficarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 165, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButtonMostrar.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        jButtonMostrar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonMostrar.setText("Mostrar");
        jButtonMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMostrarActionPerformed(evt);
            }
        });

        jButtonCostos.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        jButtonCostos.setForeground(new java.awt.Color(0, 0, 0));
        jButtonCostos.setText("Costos");
        jButtonCostos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCostosActionPerformed(evt);
            }
        });

        jLabelHab.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        jLabelHab.setForeground(new java.awt.Color(0, 0, 0));
        jLabelHab.setText("Habitaciones");

        jButtonBuscar.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        jButtonBuscar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonBuscar.setText("Buscar disponibilidad");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabelHab))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonCostos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonBuscar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonGraficar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(jButtonMostrar)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonBuscar, jButtonCostos, jButtonGraficar, jButtonMostrar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelHab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonGraficar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonMostrar))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonCostos)
                            .addComponent(jButtonBuscar))
                        .addGap(45, 45, 45))))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonBuscar, jButtonCostos, jButtonGraficar, jButtonMostrar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMostrarActionPerformed

        this.jTextArea1.setText("");
        this.jTextArea1.append("\nTotal de habitaciones: " + totalHab);
        this.jTextArea1.append("\nTotal de habitaciones Hunn: " + hunn);
        this.jTextArea1.append("\nTotal de habitaciones Itza: " + itza);
        this.jTextArea1.append("\nTotal de habitaciones Kauil: " + kauil);

        this.jTextArea1.append("\n\nPISO 1\n");
        this.jTextArea1.append("\nHunn: " + Hunn1 + " habitaciones");
        this.jTextArea1.append("\nItza: " + Itza1 + " habitaciones");
        this.jTextArea1.append("\nKauil: " + Kauil1 + " habitaciones");

        this.jTextArea1.append("\n\nPISO 2\n");
        this.jTextArea1.append("\nHunn: " + Hunn2 + " habitaciones");
        this.jTextArea1.append("\nItza: " + Itza2 + " habitaciones");
        this.jTextArea1.append("\nKauil: " + Kauil2 + " habitaciones");

    }//GEN-LAST:event_jButtonMostrarActionPerformed

    private void jButtonCostosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCostosActionPerformed

        this.jTextArea1.setText("");

        this.jTextArea1.append("\nCOSTOS\n");
        this.jTextArea1.append("\nHabitación tipo Hunn: " + 2800);
        this.jTextArea1.append("\nHabitación tipo Itza: " + 3300);
        this.jTextArea1.append("\nHabitación tipo Kauil: " + 4600);

        this.jTextArea1.append("\n\nCOSTOS EXTRA\n");
        this.jTextArea1.append("\n1 persona extra: " + 400);
        this.jTextArea1.append("\n2 personas extra: " + 800);

    }//GEN-LAST:event_jButtonCostosActionPerformed

    private void jButtonGraficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGraficarActionPerformed

        bandera = true;
        repaint();

        this.jLabelHab.setEnabled(true);

    }//GEN-LAST:event_jButtonGraficarActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed

        try {
            Registros reg = new Registros();
            Escritorio.jDesktopPane1.add(reg);

            Dimension tamanio = jDesktopPane1.getSize();
            Dimension tamFrame = reg.getSize();
            reg.setLocation((tamanio.width - tamFrame.width) / 2, (tamanio.height - tamFrame.height) / 2);
            reg.show();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al abrir el panel Registros");
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCostos;
    private javax.swing.JButton jButtonGraficar;
    private javax.swing.JButton jButtonMostrar;
    private javax.swing.JLabel jLabelHab;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
