package escritorio;

import baseDatos.MySqlConn;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Ocupacion extends javax.swing.JInternalFrame {

    MySqlConn conn = new MySqlConn();

    public Ocupacion(MySqlConn conn) {
        this.conn = conn;
        initComponents();
    }

    public Ocupacion() {
        
        /*
        try {
            llenado();
        } catch (NumberFormatException ex) {
            System.out.println("");
        }
                */
        initComponents();
    }

    //rs.getFetchSize();
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

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Ocupación");

        jButtonGraficar.setText("Graficar");

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

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextArea1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        jButtonMostrar.setText("Mostrar");
        jButtonMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMostrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(228, 228, 228))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(395, 395, 395)
                        .addComponent(jButtonGraficar)
                        .addGap(91, 91, 91)
                        .addComponent(jButtonMostrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 323, Short.MAX_VALUE)))
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGraficar)
                    .addComponent(jButtonMostrar))
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextArea1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextArea1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextArea1MouseClicked

    private void jButtonMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMostrarActionPerformed
        // TODO add your handling code here:
        /*
        PreparedStatement ps = null;
            ResultSet rs = null;
            MySqlConn conn = new MySqlConn();
            Connection con = conn.getConexion();

            String campo = this.jTextFieldBaja.getText().trim();

            String query = "SELECT nombre, ciudad, fechaE, fechaS, tipoH, numPersonas, cuentaNumPersonas, numPiso, numHab, cuentaServicios, diasHospedaje FROM huespedes WHERE numHab = " + "'" + campo + "'";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(query);
            
            rs.first();*/
        
        
        
        
    }//GEN-LAST:event_jButtonMostrarActionPerformed

    public static void llenado() {
        int size = 30;
        char salaCine[][] = new char[size][size];
        salaCine = create(size);
        boolean ban = true; //para ejecutar programa
        do {
            int opcion = (int) Integer.parseInt(JOptionPane.showInputDialog("\nMenu:\n"
                    + "1.- Ver estado de la Sala.\n"
                    + "2.- Asignar lugar disponible\n"
                    + "3.- Seleccionar lugar especifico\n"
                    + "Cualquier otra.- Salir del Sistema"));

            switch (opcion) {
                case 1:
                    display(salaCine);
                    break;
                case 2:
                    salaCine = asignarLugar(salaCine);
                    break;
                case 3:
                    salaCine = escogerLugar(salaCine);
                    break;
                default:
                    ban = false;
            }
        } while (ban);
    }

    public static char[][] create(int size) {
        char matriz[][] = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matriz[i][j] = 'v';
            }
        }
        return matriz;
    }

    public static void display(char mat[][]) {
        String cad = "";
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                cad += mat[i][j] + " ";
            }
            cad += "\n";
        }
        JOptionPane.showMessageDialog(null, cad);
    }

    public static char[][] asignarLugar(char mat[][]) {
        char matriz[][] = mat;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == 'v') {
                    JOptionPane.showMessageDialog(null, "Lugar asignado en la fila " + (i + 1)
                            + " y columna " + (j + 1));
                    matriz[i][j] = 'x';
                    return matriz;
                } else {
                    continue;
                }
            }
        }
        return matriz;
    }

    public static char[][] escogerLugar(char mat[][]) {
        char matriz[][] = mat;
        do {
            int fila = (int) Integer.parseInt(JOptionPane.showInputDialog("Selecciona la fila:"));
            int columna = (int) Integer.parseInt(JOptionPane.showInputDialog("Selecciona la Columna:"));
            if (matriz[fila - 1][columna - 1] == 'x') {
                JOptionPane.showMessageDialog(null, "Vuelve a seleccionar, ese lugar ya se encuentra ocupado");
            } else {
                JOptionPane.showMessageDialog(null, "Lugar asignado a la fila " + fila + " y columna " + columna);
                matriz[fila - 1][columna - 1] = 'x';
                break;
            }
        } while (1 == 1);
        return matriz;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGraficar;
    private javax.swing.JButton jButtonMostrar;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
