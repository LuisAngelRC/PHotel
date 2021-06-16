package escritorio;

import baseDatos.MySqlConn;
import com.mysql.jdbc.Statement;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Servicios extends javax.swing.JInternalFrame {

    MySqlConn conn = new MySqlConn();

    int cuentaTot = 0;
    int banderaServicios = 0;
    Statement oSt = null;
    ResultSet oRs = null;

    public Servicios(MySqlConn conn) {
        this.conn = conn;
        initComponents();
    }

    public Servicios() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButtonBuscar = new javax.swing.JButton();
        jTextFieldNumeroHab = new javax.swing.JTextField();
        jCheckBoxRoom = new javax.swing.JCheckBox();
        jCheckBoxBar = new javax.swing.JCheckBox();
        jCheckBoxSPA = new javax.swing.JCheckBox();
        jCheckBoxExGui = new javax.swing.JCheckBox();
        jCheckBoxBuceo = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButtonAgregarCostos = new javax.swing.JButton();
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/ayaye_logo.png"));
        Image image = icon.getImage();
        jPanel4 = new javax.swing.JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Servicios");

        jLabel1.setText("Escribe el numero de habitación:");

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jTextFieldNumeroHab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNumeroHabKeyTyped(evt);
            }
        });

        jCheckBoxRoom.setText("Room Service");

        jCheckBoxBar.setText("Bar");

        jCheckBoxSPA.setText("SPA");

        jCheckBoxExGui.setText("Excursión guiada ");

        jCheckBoxBuceo.setText("Buceo");

        jLabel2.setText("Costo fijo: $1000");

        jLabel3.setText("Costo fijo: $600");

        jLabel4.setText("Costo fijo: $1500");

        jButtonAgregarCostos.setText("Agregar");
        jButtonAgregarCostos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarCostosActionPerformed(evt);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldNumeroHab, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonBuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxBar)
                            .addComponent(jCheckBoxRoom)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBoxSPA)
                                    .addComponent(jCheckBoxExGui)
                                    .addComponent(jCheckBoxBuceo))
                                .addGap(65, 65, 65)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(27, 27, 27)
                                                .addComponent(jButtonAgregarCostos)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNumeroHab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscar))
                .addGap(18, 18, 18)
                .addComponent(jCheckBoxRoom)
                .addGap(18, 18, 18)
                .addComponent(jCheckBoxBar)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxSPA)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxExGui)
                    .addComponent(jLabel3)
                    .addComponent(jButtonAgregarCostos))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBoxBuceo)
                    .addComponent(jLabel4))
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private int TotalSrev() {

        if (this.jCheckBoxRoom.isSelected()) {
            cuentaTot += (int) (Math.random() * (2000 - 500 + 1) + 500);
        }

        if (this.jCheckBoxBar.isSelected()) {
            cuentaTot += (int) (Math.random() * (10000 - 1000 + 1) + 1000);
        }

        if (this.jCheckBoxSPA.isSelected()) {
            cuentaTot += 1000;
        }

        if (this.jCheckBoxExGui.isSelected()) {
            cuentaTot += 600;
        }

        if (this.jCheckBoxBuceo.isSelected()) {
            cuentaTot += 1500;
        }

        return cuentaTot;
    }

    private void jTextFieldNumeroHabKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNumeroHabKeyTyped

        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();

            JOptionPane.showMessageDialog(this, "Escribe solamente numeros");
        }

    }//GEN-LAST:event_jTextFieldNumeroHabKeyTyped

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed

        boolean dbexisteRegistro = false;
        String numhab = "";

        String habitacion = this.jTextFieldNumeroHab.getText().trim();
        String where = "";

        if (habitacion.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Esta vacio, ingrese una habitacion");
        }

        if (!habitacion.isEmpty()) {
            where = "WHERE numHab = " + "'" + Integer.parseInt(habitacion) + "'";
            try {
                String query = "SELECT numHab FROM huespedes " + where;
                oSt = (Statement) conn.conn.createStatement();
                oRs = oSt.executeQuery(query);

                if (oRs.next()) {
                    if (oRs.getRow() > 0) {
                        dbexisteRegistro = true;
                    }
                }

                if (oSt != null) {
                    oSt.close();
                    oSt = null;
                }
                
                if (oRs != null) {
                    oRs.close();
                    oRs = null;
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al entrar a la base de datos!!!");
                dbexisteRegistro = false;
            }
        }

        if (dbexisteRegistro == true) {
            JOptionPane.showMessageDialog(this, "Si existe la habitacion");
            banderaServicios = 1;
        } else {
            JOptionPane.showMessageDialog(this, "No existe la habitacion");
            banderaServicios = 0;
        }

    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonAgregarCostosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarCostosActionPerformed

        int cuentaServicios = TotalSrev();
        if (banderaServicios == 1) {
            String query = "UPDATE huespedes SET cuentaServicios = " + "'" + cuentaServicios + "'" + " WHERE numHab = " + "'" + Integer.parseInt(this.jTextFieldNumeroHab.getText().trim()) + "'";

            try {
                conn.Update(query);
            } catch (Exception ex) {
                System.err.println(ex);
                JOptionPane.showMessageDialog(this, "No entró a la base");
            }
            JOptionPane.showMessageDialog(this, "Total de la suma de los servicios: " + cuentaServicios);
        } else {
            JOptionPane.showMessageDialog(this, "No hay habitaciones con ese numero!!");
        }

    }//GEN-LAST:event_jButtonAgregarCostosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregarCostos;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JCheckBox jCheckBoxBar;
    private javax.swing.JCheckBox jCheckBoxBuceo;
    private javax.swing.JCheckBox jCheckBoxExGui;
    private javax.swing.JCheckBox jCheckBoxRoom;
    private javax.swing.JCheckBox jCheckBoxSPA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextFieldNumeroHab;
    // End of variables declaration//GEN-END:variables
}
