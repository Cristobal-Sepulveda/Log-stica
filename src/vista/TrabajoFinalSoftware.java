package vista;

import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public class TrabajoFinalSoftware {

    public static void main(String[] args) {
       VentanaPrincipal ven=new VentanaPrincipal();
       ven.setVisible(true);
       ven.setLocationRelativeTo(null);
       ven.setTitle("MENU PRINCIPAL");
       ven.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }
    
}
