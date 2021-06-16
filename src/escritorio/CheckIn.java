package escritorio;

import baseDatos.MySqlConn;

import static escritorio.Escritorio.jDesktopPane1;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class CheckIn extends javax.swing.JInternalFrame {

    MySqlConn conn = new MySqlConn();
    int numero = 0;
    int Hunn1 = 8, Hunn2 = 5;
    int Itza1 = 4, Itza2 = 6;
    int Kauil1 = 3, Kauil2 = 4, totalHab = 30;

    public CheckIn(MySqlConn conn) {
        this.conn = conn;
        initComponents();
    }

    public CheckIn() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldCiudad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNumPersonas = new javax.swing.JTextField();
        jButtonIngresar = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/ayaye_logo.png"));
        Image image = icon.getImage();
        jPanel1 = new javax.swing.JPanel(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        jButtonLimpiar = new javax.swing.JButton();
        jRadioButton1Per = new javax.swing.JRadioButton();
        jRadioButton2Per = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jComboBoxTipoHab = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(102, 102, 102));
        setClosable(true);
        setForeground(new java.awt.Color(255, 255, 153));
        setMaximizable(true);
        setTitle("Check-In");

        jLabel1.setText("Escribe el nombre del huésped:");

        jTextFieldNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreActionPerformed(evt);
            }
        });
        jTextFieldNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNombreKeyTyped(evt);
            }
        });

        jLabel2.setText("Escribe la ciudad de origen del huésped:");

        jTextFieldCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCiudadActionPerformed(evt);
            }
        });
        jTextFieldCiudad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldCiudadKeyTyped(evt);
            }
        });

        jLabel3.setText("Escribe el tipo de habitación a hospedar:");

        jLabel4.setText("Escribe el numero de personas que la ocupan:");

        jTextFieldNumPersonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNumPersonasActionPerformed(evt);
            }
        });
        jTextFieldNumPersonas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNumPersonasKeyTyped(evt);
            }
        });

        jButtonIngresar.setText("Ingresar");
        jButtonIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIngresarActionPerformed(evt);
            }
        });

        jLabel5.setText("Escribe la fecha de ingreso:");

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

        jButtonLimpiar.setText("Limpiar");
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1Per);
        jRadioButton1Per.setText("1 persona extra");
        jRadioButton1Per.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1PerActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2Per);
        jRadioButton2Per.setText("2 personas extra");

        jScrollPane1.setWheelScrollingEnabled(false);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(0, 0, 0));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Hunn (Límite de personas: 1)\nItza (Límite de personas: 2)\nKauil (Límite de personas: 3)");
        jScrollPane1.setViewportView(jTextArea1);

        jComboBoxTipoHab.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Hunn", "Itza", "Kauil" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(580, 580, 580)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(70, 70, 70)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2))
                                    .addGap(25, 25, 25)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTextFieldCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jComboBoxTipoHab, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(72, 72, 72)
                                            .addComponent(jRadioButton1Per)))
                                    .addGap(34, 34, 34)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jRadioButton2Per)
                                            .addGap(76, 76, 76))
                                        .addComponent(jTextFieldNumPersonas))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButtonIngresar)
                                .addGap(132, 132, 132)
                                .addComponent(jButtonLimpiar)
                                .addGap(200, 200, 200)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(52, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComboBoxTipoHab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextFieldNumPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton1Per)
                            .addComponent(jRadioButton2Per))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonIngresar)
                            .addComponent(jButtonLimpiar))
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNumPersonasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNumPersonasKeyTyped
        // TODO add your handling code here:

        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();

            JOptionPane.showMessageDialog(this, "Escribe solamente numeros");
        }

    }//GEN-LAST:event_jTextFieldNumPersonasKeyTyped

    private void jTextFieldNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNombreKeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();

        if (Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();

            JOptionPane.showMessageDialog(this, "Escribe solamente texto");
        }
    }//GEN-LAST:event_jTextFieldNombreKeyTyped

    private void jTextFieldCiudadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCiudadKeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();

        if (Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();

            JOptionPane.showMessageDialog(this, "Escribe solamente texto");
        }
    }//GEN-LAST:event_jTextFieldCiudadKeyTyped

    private void jButtonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIngresarActionPerformed
        // TODO add your handling code here:

        SimpleDateFormat formato = new SimpleDateFormat("YYYY-MM-dd");
        String fechaIngreso = formato.format(this.jDateChooser1.getDate());
        int dias = (int) (Math.random() * (7 - 3 + 1) + 3), numPiso = 0, personasExtra = 0, cuentaTotal = 0, serv = 0;
        int persona1 = 400, persona2 = 800;
        int costoHunn = 2800, costoItza = 3300, costoKauil = 4600;

        String nombre, ciudad, numPersonas, fechaSalida;
        String tipoHab;

        nombre = this.jTextFieldNombre.getText().trim();
        ciudad = this.jTextFieldCiudad.getText().trim();
        numPersonas = this.jTextFieldNumPersonas.getText().trim();
        tipoHab = (String) jComboBoxTipoHab.getSelectedItem();

        SimpleDateFormat Formato = new SimpleDateFormat("dd-MM-YYYY");
        Calendar aux = Calendar.getInstance();

        aux.setTime(this.jDateChooser1.getDate());
        aux.add(Calendar.DATE, dias);

        int numP = Integer.parseInt(numPersonas);

        Set<Integer> generados = new HashSet<>();
        for (int i = 1; i <= 30; i++) {
            int aleatorio = -1;
            boolean generado = false;
            while (!generado) {
                int numHab = (int) (Math.random() * (30 - 1 + 1) + 1);
                if (!generados.contains(numHab)) {
                    generados.add(numHab);
                    aleatorio = numHab;
                    generado = true;
                }
            }
            numero = aleatorio;
        }

        if (numero <= 15) {
            numPiso = 1;
        } else {
            numPiso = 2;
        }

        if ("Hunn".equals(tipoHab)) {

            cuentaTotal += costoHunn;

            if (numP > 3) {
                JOptionPane.showMessageDialog(this, "LA CANTIDAD DE PERSONAS SELECCIONADA NO ES CORRECTA");
                return;

            } else if (numP > 1 && numP <= 3) {

                if (this.jRadioButton1Per.isSelected() == false && this.jRadioButton2Per.isSelected() == false) {
                    JOptionPane.showMessageDialog(this, "POR FAVOR ELIJA PERSONAS EXTRAS");
                    return;
                }

                if (numP == 2) {
                    if (this.jRadioButton1Per.isSelected()) {
                        cuentaTotal += persona1;
                        JOptionPane.showMessageDialog(this, "SE HA CARGADO 1 PERSONA EXTRA");
                    } else if (this.jRadioButton2Per.isSelected()) {
                        cuentaTotal += persona2;
                        JOptionPane.showMessageDialog(this, "SE HAN CARGADO 2 PERSONAS EXTRAS");
                        return;
                    }
                } else if (numP == 3) {
                    if (this.jRadioButton2Per.isSelected()) {
                        cuentaTotal += persona2;
                        JOptionPane.showMessageDialog(this, "SE HAN CARGADO 2 PERSONAS EXTRAS");
                    } else {
                        JOptionPane.showMessageDialog(this, "POR FAVOR ELIJA PERSONAS EXTRAS");
                        return;
                    }
                }

            }

            if (numPiso == 1 && Hunn1 != 0) {
                Hunn1--;
            } else if (Hunn1 == 0) {
                JOptionPane.showMessageDialog(this, "SIN HABITACIONES HUNN EN EL PISO 1");
                return;
            }

            if (numPiso == 2 && Hunn2 != 0) {
                Hunn2--;
            } else if (Hunn2 == 0) {
                JOptionPane.showMessageDialog(this, "SIN HABITACIONES HUNN EN EL PISO 2");
                return;
            }

            if (totalHab == 0) {
                JOptionPane.showMessageDialog(this, "HOTEL LLENO");
            } else {
                totalHab--;
            }

        }

        System.out.println(Hunn1);
        System.out.println(Hunn2);

        if ("Itza".equals(tipoHab)) {

            cuentaTotal += costoItza;

            if (numP > 4) {
                JOptionPane.showMessageDialog(this, "LA CANTIDAD DE PERSONAS SELECCIONADA NO ES CORRECTA");
                return;

            } else if (numP > 2 && numP <= 4) {

                if (this.jRadioButton1Per.isSelected() == false && this.jRadioButton2Per.isSelected() == false) {
                    JOptionPane.showMessageDialog(this, "POR FAVOR ELIJA PERSONAS EXTRAS");
                    return;
                }

                if (numP == 3) {
                    if (this.jRadioButton1Per.isSelected()) {
                        cuentaTotal += persona1;
                        JOptionPane.showMessageDialog(this, "SE HA CARGADO 1 PERSONA EXTRA");
                    } else if (this.jRadioButton2Per.isSelected()) {
                        cuentaTotal += persona2;
                        JOptionPane.showMessageDialog(this, "SE HAN CARGADO 2 PERSONAS EXTRAS");
                        return;
                    }
                } else if (numP == 4) {
                    if (this.jRadioButton2Per.isSelected()) {
                        cuentaTotal += persona2;
                        JOptionPane.showMessageDialog(this, "SE HAN CARGADO 2 PERSONAS EXTRAS");
                    } else {
                        JOptionPane.showMessageDialog(this, "POR FAVOR ELIJA PERSONAS EXTRAS");
                        return;
                    }
                }

            }

            if (numPiso == 1 && Itza1 != 0) {
                Itza1--;
            } else if (Itza1 == 0) {
                JOptionPane.showMessageDialog(this, "SIN HABITACIONES ITZA EN EL PISO 1");
                return;
            }

            if (numPiso == 2 && Itza2 != 0) {
                Itza2--;
            } else if (Itza2 == 0) {
                JOptionPane.showMessageDialog(this, "SIN HABITACIONES ITZA EN EL PISO 2");
                return;
            }

            if (totalHab == 0) {
                JOptionPane.showMessageDialog(this, "HOTEL LLENO");
            } else {
                totalHab--;
            }
        }

        System.out.println(Itza1);
        System.out.println(Itza2);

        if ("Kauil".equals(tipoHab)) {

            cuentaTotal += costoKauil;

            if (numP > 5) {
                JOptionPane.showMessageDialog(this, "LA CANTIDAD DE PERSONAS SELECCIONADA NO ES CORRECTA");
                return;

            } else if (numP > 3 && numP <= 5) {

                if (this.jRadioButton1Per.isSelected() == false && this.jRadioButton2Per.isSelected() == false) {
                    JOptionPane.showMessageDialog(this, "POR FAVOR ELIJA PERSONAS EXTRAS");
                    return;
                }

                if (numP == 4) {
                    if (this.jRadioButton1Per.isSelected()) {
                        cuentaTotal += persona1;
                        JOptionPane.showMessageDialog(this, "SE HA CARGADO 1 PERSONA EXTRA");
                    } else if (this.jRadioButton2Per.isSelected()) {
                        cuentaTotal += persona2;
                        JOptionPane.showMessageDialog(this, "SE HAN CARGADO 2 PERSONAS EXTRAS");
                        return;
                    }
                } else if (numP == 5) {
                    if (this.jRadioButton2Per.isSelected()) {
                        cuentaTotal += persona2;
                        JOptionPane.showMessageDialog(this, "SE HAN CARGADO 2 PERSONAS EXTRAS");
                    } else {
                        JOptionPane.showMessageDialog(this, "POR FAVOR ELIJA PERSONAS EXTRAS");
                        return;
                    }
                }

            }

            if (numPiso == 1 && Kauil1 != 0) {
                Kauil1--;
            } else if (Kauil1 == 0) {
                JOptionPane.showMessageDialog(this, "SIN HABITACIONES KAUIL EN EL PISO 1");
                return;
            }

            if (numPiso == 2 && Kauil2 != 0) {
                Kauil2--;
            } else if (Kauil2 == 0) {
                JOptionPane.showMessageDialog(this, "SIN HABITACIONES KAUIL EN EL PISO 2");
                return;
            }

            if (totalHab == 0) {
                JOptionPane.showMessageDialog(this, "HOTEL LLENO");
            } else {
                totalHab--;
            }
        }

        System.out.println(Kauil1);
        System.out.println(Kauil2);

        String parte1 = "INSERT IGNORE INTO huespedes (nombre, ciudad, fechaE, fechaS, tipoH, numPersonas, cuentaNumPersonas, numPiso, numHab, cuentaServicios, diasHospedaje) VALUES (";
        String parte2 = "'" + nombre + "','" + ciudad + "','" + formato.format(this.jDateChooser1.getDate()) + "','" + formato.format(aux.getTime()) + "','" + tipoHab + "','" + numPersonas
                + "','" + cuentaTotal + "','" + numPiso + "','" + numero + "','" + serv + "','" + dias + "')";
        String query = parte1 + parte2;
        int j = this.conn.Update(query); //Ejecuta accion de alta en la base de datos

        if (j > 0) {
            System.out.println("Numero de registros afectados por la accion: " + j);
            JOptionPane.showMessageDialog(this, "REGISTRO EXITOSO, su numero de habitacion es: " + numero);

            try {

                Registros reg = new Registros();
                Escritorio.jDesktopPane1.add(reg);

                Dimension tamanio = jDesktopPane1.getSize();
                Dimension tamFrame = reg.getSize();
                reg.setLocation((tamanio.width - tamFrame.width) / 2, (tamanio.height - tamFrame.height) / 2);
                reg.show();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e);
            }
        }

    }//GEN-LAST:event_jButtonIngresarActionPerformed

    public int getNumHab() {
        return numero;
    }

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        // TODO add your handling code here:
        this.jTextFieldNombre.setText("");
        this.jTextFieldCiudad.setText("");
        this.jTextFieldNumPersonas.setText("");
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    private void jRadioButton1PerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1PerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1PerActionPerformed

    private void jTextFieldNumPersonasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNumPersonasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNumPersonasActionPerformed

    private void jTextFieldCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCiudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCiudadActionPerformed

    private void jTextFieldNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonIngresar;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JComboBox jComboBoxTipoHab;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1Per;
    private javax.swing.JRadioButton jRadioButton2Per;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextFieldCiudad;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldNumPersonas;
    // End of variables declaration//GEN-END:variables
}
