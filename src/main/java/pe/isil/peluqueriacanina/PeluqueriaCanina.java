package pe.isil.peluqueriacanina;

import pe.isil.peluqueriacanina.igu.Principal;
import pe.isil.peluqueriacanina.logica.Duenio;
import pe.isil.peluqueriacanina.persistencia.DuenioJpaController;

public class PeluqueriaCanina {

    public static void main(String[] args) {
       Principal principal = new Principal();
       //Función para que muestre la pantalla
       principal.setVisible(true);
       //Función para que se muestre en el medio relativo a cualquier tamaño
       principal.setLocationRelativeTo(null);
       
   
    }
}
