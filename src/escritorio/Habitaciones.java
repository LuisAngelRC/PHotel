package escritorio;

import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Habitaciones extends javax.swing.JInternalFrame {
    AudioClip Musica;
    
    private static final Color COLOR_APP = new Color(50, 50, 50);
    private JFrame ventana;
    private ArrayList<Lamina> listImg;
    private JPanel nav;
    private JPanel contendorBotones;
    private Lamina foto;
    
    public Habitaciones() {
        
        initComponents();
        
        listImg = new ArrayList<Lamina>();
        configuracionVentana();
        configuracionConponentes();
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    private void configuracionVentana() {
        ventana = new JFrame();
        ventana.setSize(1200, 600);
        ventana.setTitle("Habitaciones");
        ventana.setResizable(false);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.getContentPane().setBackground(COLOR_APP);
        ventana.setExtendedState(MAXIMIZED_BOTH);
    }
    
private void configuracionConponentes() {
        
        contendorBotones = new JPanel(new GridLayout(5, 1));
        JScrollPane scrol = new JScrollPane(contendorBotones);
        
        Musica = java.applet.Applet.newAudioClip(getClass().getResource("/musica/Coro_Coral.wav"));
        JButton botonHunn = new JButton();
        botonHunn.setBackground(Color.decode("#d7d7a8"));
        botonHunn.setText("Tipo Hunn");
        botonHunn.setForeground(Color.decode("#804000"));
        ///*---->Evento Local<------ */
        botonHunn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                foto.cambiarImagen("src/imagenes/habitacionHunn.jpg");
                ventana.paintComponents(ventana.getGraphics());
            }
        });
        contendorBotones.add(botonHunn);
        
        JButton botonItza = new JButton();
        botonItza.setBackground(Color.decode("#d7d7a8"));
        botonItza.setText("Tipo Itza");
        botonItza.setForeground(Color.decode("#804000"));
        ///*---->Evento Local<------ */
        botonItza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                foto.cambiarImagen("src/imagenes/habitacionItza.jpg");
                ventana.paintComponents(ventana.getGraphics());
            }
        });
        contendorBotones.add(botonItza);
        
        JButton botonKauil = new JButton();
        botonKauil.setBackground(Color.decode("#d7d7a8"));
        botonKauil.setText("Tipo Kauil");
        botonKauil.setForeground(Color.decode("#804000"));
        ///*---->Evento Local<------ */
        botonKauil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                foto.cambiarImagen("src/imagenes/habitacionKauil.jpg");
                ventana.paintComponents(ventana.getGraphics());
            }
        });
        contendorBotones.add(botonKauil);
        
        ventana.add(scrol, BorderLayout.LINE_START);
        
        foto = new Lamina("src/imagenes/ayaye_grande.png");
        foto.setBorder(BorderFactory.createMatteBorder(15, 15, 15, 15, COLOR_APP));
        ventana.add(foto, BorderLayout.CENTER);

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

class Lamina extends JPanel {
    
    private Image img = null;
    private ImageIcon icono;
// Metodo constructor

    public Lamina(String urlFondo) {
        icono = new ImageIcon(urlFondo);
        img = icono.getImage();
    }
    
    public void cambiarImagen(String urlFondo) {
        icono = new ImageIcon(urlFondo);
        img = icono.getImage();
    }
    
    protected void paintComponent(Graphics g) {
        g.drawImage(img, 1, 1, getWidth(), getHeight(), this);
        setOpaque(false);
    }
}

class Controller2 {
    
    private Habitaciones window;
    
    public Controller2() {
        window = new Habitaciones();
    }
    
    public static void main(String[] args) {
        new Controller2();
    }
}