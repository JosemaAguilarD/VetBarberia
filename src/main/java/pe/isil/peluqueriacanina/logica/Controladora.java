package pe.isil.peluqueriacanina.logica;

import java.util.List;
import pe.isil.peluqueriacanina.persistencia.ControladoraPersistencia;

public class Controladora {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

  
    public void guardar(String nombreMascota, String raza, String color, String observaciones, String alergico, String atenEspecial, String nombreDuenio, String celDuenio) {
        //Creamos el dueño y asignamos sus valores
        Duenio duenio = new Duenio();
        duenio.setNombre(nombreDuenio);
        duenio.setCelularDuenio(celDuenio);
        
        //Creamos la mascota y asignamos sus valores
        Mascota masco = new Mascota();
        masco.setNombre(nombreMascota);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(observaciones);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atenEspecial); 
        masco.setUnDuenio(duenio);
        
        controlPersis.guardar(duenio,masco); }

    public List<Mascota> traerMascota() {
       
        return controlPersis.traerMascotas(); 
        
    }

    public void borrarMascota(int num_cliente) {
        controlPersis.borrarMascotas(num_cliente);
    }

   
}
