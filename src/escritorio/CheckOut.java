package escritorio;

import com.mysql.jdbc.Statement;
import baseDatos.MySqlConn;
import com.itextpdf.text.BadElementException;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class CheckOut extends javax.swing.JInternalFrame {

    String rutaLogo = "src\\imagenes\\ayaye_grande.png";
    String rutaFirma = "src\\imagenes\\firma.png";
    Font tipoLetra = new Font(Font.FontFamily.TIMES_ROMAN, 10);
    int ingHotel = 0;

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
            documento.setMargins(60, 60, 0, 50);

            PdfWriter.getInstance(documento, archivo);
            documento.open();

            com.itextpdf.text.Image logo = null;

            try {
                logo = com.itextpdf.text.Image.getInstance(rutaLogo);
                logo.scaleAbsolute(160, 160);
                logo.setAlignment(1);
            } catch (BadElementException | IOException e) {
                System.out.println("LA IMAGEN NO SE CARGÓ CORRECTAMENTE");
            }
            documento.add(logo);

            Paragraph parrafo = new Paragraph("Ubicación: Tulum, Quintana Roo, Calle Grulla Sin Numero, Esq. Con Av, Calle Simón Bolivar KM 2.2, 77796 Francisco Uh May, Q.R.");
            parrafo.setFont(tipoLetra);
            parrafo.setAlignment(1);
            documento.add(parrafo);

            Paragraph parrafo2 = new Paragraph("\n" + "*** RECIBO DEL HOTEL ***");
            parrafo2.setFont(tipoLetra);
            parrafo2.setAlignment(1);
            documento.add(parrafo2);

            ResultSet resultados = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            Statement estado = null;
            MySqlConn conn = new MySqlConn();
            Connection con = conn.getConexion();
            int auxIng = 0;

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

            String query2 = "SELECT ingresosHotel FROM ingresos";
            ps = con.prepareStatement(query2);
            rs = ps.executeQuery(query2);
            rs.first();
            ingHotel = rs.getInt(1);
            ingHotel += aux3;
            String query3 = "UPDATE ingresos SET ingresosHotel = " + "'" + ingHotel + "'";

            try {
                conn.Update(query3);
            } catch (Exception ex) {
                System.err.println(ex);
                JOptionPane.showMessageDialog(this, "No entro a la base");
            }

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
                firma = com.itextpdf.text.Image.getInstance(rutaFirma);
                firma.scaleAbsolute(135, 135);
                firma.setAbsolutePosition(230, 100);
            } catch (BadElementException | IOException e) {
                System.out.println("LA IMAGEN NO SE CARGÓ CORRECTAMENTE");
            }
            documento.add(firma);

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
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/ayaye_logo.png"));
        Image image = icon.getImage();
        jPanel1 = new javax.swing.JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        jButtonTicket = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Check-Out");

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        jLabel1.setText("Escribe el número de la habitación para salir:");

        jTextFieldBaja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldBajaKeyTyped(evt);
            }
        });

        jButtonCerrar.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        jButtonCerrar.setForeground(new java.awt.Color(153, 0, 51));
        jButtonCerrar.setText("Cerrar cuenta");
        jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarActionPerformed(evt);
            }
        });

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

        jButtonTicket.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        jButtonTicket.setForeground(new java.awt.Color(0, 0, 0));
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
                        .addGap(273, 273, 273)
                        .addComponent(jButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(54, 54, 54)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldBaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 391, Short.MAX_VALUE)
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

    private void jTextFieldBajaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBajaKeyTyped

        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();

            JOptionPane.showMessageDialog(this, "Escribe solamente numeros");
        }

    }//GEN-LAST:event_jTextFieldBajaKeyTyped

    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed

        ResultSet resultados = null;
        PreparedStatement ps = null;
        Statement estado = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-dd");
        String fechaS = "";
        String hab = this.jTextFieldBaja.getText().trim();

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
        }

    }//GEN-LAST:event_jButtonCerrarActionPerformed

    private void jButtonTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTicketActionPerformed

        try {
            generar("ReciboHotel");
        } catch (FileNotFoundException | DocumentException ex) {
            System.out.println("ERROR CON EL ARCHIVO");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "No se pudo encontrar la habitacion");
        }

    }//GEN-LAST:event_jButtonTicketActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JButton jButtonTicket;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldBaja;
    // End of variables declaration//GEN-END:variables
}
