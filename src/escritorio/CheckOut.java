package escritorio;

import baseDatos.MySqlConn;
import com.mysql.jdbc.Statement;
import baseDatos.MySqlConn;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
//import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Date;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CheckOut extends javax.swing.JInternalFrame {

    String rutaLogo = "src\\imagenes\\ayaye_grande.png";
    String rutaFirma = "src\\imagenes\\firma.png";
    Font tipoLetra = new Font(Font.FontFamily.TIMES_ROMAN, 10);//tipoletra

    MySqlConn conn = new MySqlConn();

    public CheckOut(MySqlConn conn) {
        this.conn = conn;
        initComponents();
    }

    public CheckOut() {
        initComponents();
    }

    public void generar(String nombre) throws FileNotFoundException, DocumentException, SQLException {
        if (!(this.jTextFieldBaja.getText().isEmpty())) {

            FileOutputStream archivo = new FileOutputStream(nombre + ".pdf");
            Document documento = new Document();
            documento.setMargins(60, 60, 0, 50); // (izq, der, arriba, abajo)

            PdfWriter.getInstance(documento, archivo);
            documento.open();

            com.itextpdf.text.Image logo = null;

            try {
                logo = com.itextpdf.text.Image.getInstance(rutaLogo);//carga imagen
                logo.scaleAbsolute(160, 160);//cambia tamaño
                logo.setAlignment(1);
                //image.setAbsolutePosition(150, 100);//coloca imagen en la posicion
            } catch (Exception e) {
                System.out.println("LA IMAGEN NO SE CARGÓ CORRECTAMENTE");
            }
            documento.add(logo);//agrega la imagen al documento

            Paragraph parrafo = new Paragraph("Ubicación: Tulum, Quintana Roo, Calle Grulla Sin Numero, Esq. Con Av, Calle Simón Bolivar KM 2.2, 77796 Francisco Uh May, Q.R.");
            parrafo.setFont(tipoLetra);
            parrafo.setAlignment(1);
            documento.add(parrafo);

            Paragraph parrafo2 = new Paragraph("\n" + "*** RECIBO DEL HOTEL ***");
            parrafo2.setFont(tipoLetra);
            parrafo2.setAlignment(1);
            documento.add(parrafo2);

            PreparedStatement ps = null;
            ResultSet rs = null;
            MySqlConn conn = new MySqlConn();
            Connection con = conn.getConexion();

            String campo = this.jTextFieldBaja.getText().trim();

            String query = "SELECT nombre, ciudad, fechaE, fechaS, tipoH, numPersonas, cuentaNumPersonas, numPiso, numHab, cuentaServicios, diasHospedaje FROM huespedes WHERE numHab = " + "'" + campo + "'";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(query);

            rs.first();

            SimpleDateFormat Formato = new SimpleDateFormat("dd-MM-YYYY");
            Calendar aux = Calendar.getInstance();

            String fecha = Formato.format(aux.getTime());

            String nombreH = rs.getString(1);

            String ciudad = rs.getString(2);

            Date fechaI = rs.getDate(3);

            Date fechaS = rs.getDate(4);

            String tipoHab = rs.getString(5);

            int numPersonas = rs.getInt(6);
            String personas = numPersonas + "";

            int pagosinCargos = rs.getInt(7);
            String pagosNormales = pagosinCargos + "";

            int numP = rs.getInt(8);
            String numPiso = numP + "";

            int numH = rs.getInt(9);
            String numHab = numH + "";

            int pagoconCargos = rs.getInt(10);
            String pagoCargos = pagoconCargos + "";

            int dia = rs.getInt(11);
            String dias = dia + "";

            int costoHab = 0;

            if ("Hunn".equals(tipoHab)) {
                costoHab = 2800;
            }

            if ("Itza".equals(tipoHab)) {
                costoHab = 3300;
            }

            if ("Kauil".equals(tipoHab)) {
                costoHab = 4600;
            }

            int aux2 = pagosinCargos * dia;
            String pagoDias = aux2 + "";

            int aux3 = aux2 + pagoconCargos;
            String pagoTotal = aux3 + "";

            String costo = costoHab + "";

            documento.add(new Paragraph("\n" + "Fecha del día de hoy: " + fecha, tipoLetra));
            documento.add(new Paragraph("\n" + "Nombre del huésped: " + nombreH, tipoLetra));
            documento.add(new Paragraph("\n" + "Ciudad: " + ciudad, tipoLetra));
            documento.add(new Paragraph("\n" + "Fecha de ingreso: " + fechaI, tipoLetra));
            documento.add(new Paragraph("\n" + "Fecha de salida: " + fechaS, tipoLetra));
            documento.add(new Paragraph("\n" + "Tipo de habitación: " + tipoHab, tipoLetra));
            documento.add(new Paragraph("\n" + "Número de personas: " + personas, tipoLetra));
            documento.add(new Paragraph("\n" + "Número de piso: " + numPiso, tipoLetra));
            documento.add(new Paragraph("\n" + "Numero de habitación: " + numHab, tipoLetra));
            documento.add(new Paragraph("\n" + "Costo base de la habitación: " + costo, tipoLetra));
            documento.add(new Paragraph("\n" + "Días de estancia en el hotel: " + dias, tipoLetra));
            documento.add(new Paragraph("\n" + "Total a pagar sin cargos extra: " + pagoDias, tipoLetra));
            documento.add(new Paragraph("\n" + "Total a pagar con cargos extra: " + pagoTotal, tipoLetra));

            com.itextpdf.text.Image firma = null;
            try {
                firma = com.itextpdf.text.Image.getInstance(rutaFirma);//carga imagen
                firma.scaleAbsolute(135, 135);//cambia tamaño
                //firma.setAlignment(4);
                firma.setAbsolutePosition(230, 100);//coloca imagen en la posicion
            } catch (Exception e) {
                System.out.println("LA IMAGEN NO SE CARGÓ CORRECTAMENTE");
            }
            documento.add(firma);//agrega la imagen al documento

            Paragraph parrafoFirma = new Paragraph("\n\n\n\n\n\n\n\n\nFIRMA DEL GERENTE");
            parrafoFirma.setAlignment(1);
            parrafoFirma.setFont(tipoLetra);
            documento.add(parrafoFirma);

            Paragraph parrafo3 = new Paragraph("\n***GRACIAS POR VISITAR AL HOTEL AYAYE, BUEN DIA!!!***");
            parrafo3.setFont(tipoLetra);
            parrafo3.setAlignment(1);
            documento.add(parrafo3);

            documento.close();
            JOptionPane.showMessageDialog(null, "ARCHIVO PDF CREADO CORRECTAMENTE", "Informacion", 1);
        } else {
            JOptionPane.showMessageDialog(null, "SE DEBEN LLENAR TODOS LOS CAMPOS", "Atencion", 2);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldBaja = new javax.swing.JTextField();
        jButtonCerrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/ayaye_logo.png"));
        Image image = icon.getImage();
        jPanel1 = new javax.swing.JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        jTextFieldSalida = new javax.swing.JTextField();
        jButtonTicket = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Check-Out");

        jLabel1.setText("Escribe el numero de la habitación para salir:");

        jTextFieldBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBajaActionPerformed(evt);
            }
        });
        jTextFieldBaja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldBajaKeyTyped(evt);
            }
        });

        jButtonCerrar.setText("Cerrar cuenta");
        jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarActionPerformed(evt);
            }
        });

        jLabel2.setText("Fecha de salida:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 165, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTextFieldSalida.setEditable(false);
        jTextFieldSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSalidaActionPerformed(evt);
            }
        });

        jButtonTicket.setText("Generar recibo");
        jButtonTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTicketActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(43, 43, 43)
                                .addComponent(jTextFieldSalida))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(jButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117)
                        .addComponent(jButtonTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldBaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBajaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBajaActionPerformed

    private void jTextFieldBajaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBajaKeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();

            JOptionPane.showMessageDialog(this, "Escribe solamente numeros");
        }
    }//GEN-LAST:event_jTextFieldBajaKeyTyped

    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed
        // TODO add your handling code here:

        ResultSet resultados = null;
        PreparedStatement ps = null;
        Statement estado = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-dd");
        String fechaS = "";
        String hab = this.jTextFieldBaja.getText().trim();

        try {

            if (hab.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Numero de habitacion vacio");
            } else {
                String query = "SELECT * FROM huespedes WHERE numHab=  " + "'" + fechaS + "'";
                String query2 = "DELETE FROM huespedes WHERE numHab = " + "'" + hab + "'";

                int j = this.conn.Update(query2);
                if (j > 0) {
                    JOptionPane.showMessageDialog(this, "Baja realizada");
                } else {
                    JOptionPane.showMessageDialog(this, "La baja no se pudo realizar");
                }

                estado = (Statement) this.conn.conn.createStatement();
                resultados = estado.executeQuery(query);

                while (resultados.next()) {

                    fechaS = resultados.getString("fechaS");
                    this.jTextFieldSalida.setText(fechaS);

                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error en la base de datos" + ex);

        }


    }//GEN-LAST:event_jButtonCerrarActionPerformed

    private void jTextFieldSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSalidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSalidaActionPerformed

    private void jButtonTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTicketActionPerformed
        // TODO add your handling code here:
        try {
            generar("Hotel");
        } catch (FileNotFoundException | DocumentException ex) {
            System.out.println("ERROR CON EL ARCHIVO");
        } catch (SQLException ex) {
            Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButtonTicketActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JButton jButtonTicket;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldBaja;
    private javax.swing.JTextField jTextFieldSalida;
    // End of variables declaration//GEN-END:variables
}
