package escritorio;

import baseDatos.MySqlConn;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.apache.commons.codec.digest.DigestUtils;

public class LogIn extends javax.swing.JFrame {

    MySqlConn conn = new MySqlConn();
    int bandera = 0;
    
    public LogIn(MySqlConn conn) {
        this.conn = conn;
        initComponents();
    }
    
    public LogIn() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPasswordFieldContrasena = new javax.swing.JPasswordField();
        jTextFieldNombreUsuario = new javax.swing.JTextField();
        jButtonIniciarSesion = new javax.swing.JButton();
        jButtonLimpiar = new javax.swing.JButton();
        jButtonRegistro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setForeground(new java.awt.Color(153, 153, 153));
        jPanel1.setName(""); // NOI18N

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Log-In");

        jLabel2.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre de usuario:");

        jLabel3.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Contraseña:");

        jButtonIniciarSesion.setBackground(new java.awt.Color(204, 255, 255));
        jButtonIniciarSesion.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        jButtonIniciarSesion.setForeground(new java.awt.Color(0, 0, 0));
        jButtonIniciarSesion.setText("Iniciar sesión");
        jButtonIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarSesionActionPerformed(evt);
            }
        });

        jButtonLimpiar.setBackground(new java.awt.Color(204, 255, 255));
        jButtonLimpiar.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        jButtonLimpiar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonLimpiar.setText("Limpiar");
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });

        jButtonRegistro.setBackground(new java.awt.Color(204, 255, 255));
        jButtonRegistro.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        jButtonRegistro.setForeground(new java.awt.Color(0, 0, 0));
        jButtonRegistro.setText("Registrar cuenta");
        jButtonRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(257, 257, 257))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldNombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                            .addComponent(jPasswordFieldContrasena)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jButtonIniciarSesion)
                        .addGap(38, 38, 38)
                        .addComponent(jButtonRegistro)
                        .addGap(35, 35, 35)
                        .addComponent(jButtonLimpiar)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonIniciarSesion, jButtonLimpiar, jButtonRegistro});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jPasswordFieldContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonIniciarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRegistro)
                    .addComponent(jButtonLimpiar))
                .addGap(52, 52, 52))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPasswordFieldContrasena, jTextFieldNombreUsuario});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonIniciarSesion, jButtonLimpiar, jButtonRegistro});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        this.jTextFieldNombreUsuario.setText("");
        this.jPasswordFieldContrasena.setText("");
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    private void jButtonIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarSesionActionPerformed

        String usuario, contrasena, query;
        usuario = this.jTextFieldNombreUsuario.getText().trim();
        query = "SELECT * FROM usuarios WHERE usuario = " + "'" + usuario + "'";
        this.conn.Consult(query);

        try {
            String contrasenaMySql = this.conn.rs.getString(2);
            char[] passw = this.jPasswordFieldContrasena.getPassword();
            contrasena = new String(passw);

            String contrasenaencriptada = DigestUtils.md5Hex(contrasena);
            if (contrasenaMySql.equals(contrasenaencriptada)) {
                bandera = 1;
                JOptionPane.showMessageDialog(this, "Bienvenido " + this.conn.rs.getString(1) + " al sistema");
            } else {
                bandera = 0;
                JOptionPane.showMessageDialog(this, "Error en la contraseña");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "No existe el usuario");
        }
   
    }//GEN-LAST:event_jButtonIniciarSesionActionPerformed

    private void jButtonRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistroActionPerformed

        String cuenta, contrasena, parte1, parte2, query;
        cuenta = this.jTextFieldNombreUsuario.getText().trim();
        char[] passw = this.jPasswordFieldContrasena.getPassword();

        contrasena = new String(passw);
        parte1 = "INSERT INTO usuarios VALUES (";
        parte2 = "'" + cuenta + "'," + " MD5('" + contrasena + "'))";
        query = parte1 + parte2;
        System.out.println(query);
        int j = this.conn.Update(query);

        if (j > 0) {
            JOptionPane.showMessageDialog(this, "Cuenta registrada!!!");
            System.out.println("Cuenta registrada!!!");
        }
        
    }//GEN-LAST:event_jButtonRegistroActionPerformed

    public int getBandera() {
        return bandera;
    }
    
    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIniciarSesion;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JButton jButtonRegistro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordFieldContrasena;
    private javax.swing.JTextField jTextFieldNombreUsuario;
    // End of variables declaration//GEN-END:variables
}
