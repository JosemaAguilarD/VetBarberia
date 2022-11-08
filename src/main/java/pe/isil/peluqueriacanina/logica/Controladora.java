package pe.isil.peluqueriacanina.logica;

import java.util.List;
import pe.isil.peluqueriacanina.persistencia.ControladoraPersistencia;
import pe.isil.peluqueriacanina.persistencia.exceptions.NonexistentEntityException;

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

    public Mascota traerUnaMascota(int num_cliente) {
        return controlPersis.traerUnaMascota(num_cliente);
    }

//    public void modificar(int num_cliente, String nombreMascota, String raza, String color, String observaciones, String alergico, String atenEspecial, String nombreDuenio, String celDuenio){
//        
//        
//        Duenio duenio = new Duenio();
//        duenio.setNombre(nombreDuenio);
//        duenio.setCelularDuenio(celDuenio);
//        duenio.setId_dueño(traerUnaMascota(num_cliente).getUnDuenio().getId_dueño());
//        
//        Mascota mascota = new Mascota();
//        mascota.setNum_cliente(num_cliente);
//        mascota.setNombre(nombreMascota);
//        mascota.setRaza(raza);
//        mascota.setColor(color);
//        mascota.setObservaciones(observaciones);
//        mascota.setAlergico(alergico);
//        mascota.setAtencion_especial(atenEspecial); 
//        mascota.setUnDuenio(duenio);
//
//        controlPersis.modificar(duenio,mascota); 
//
//    }

    public void modificarMascota(Mascota masco, String nombreMascota, String raza, String color, String observaciones, String alergico, String atenEspecial, String nombreDuenio, String celDuenio) {
        
        masco.setNombre(nombreMascota);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(observaciones);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atenEspecial); 

        //modifico mascota 
        controlPersis.modificarMascota(masco);
        
        //Seteo nuevos valores del dueño 
        Duenio dueno = this.buscarDuenio(masco.getUnDuenio().getId_dueño());
        dueno.setCelularDuenio(celDuenio);
        dueno.setNombre(nombreDuenio);
        
        //Llamar al modificarDueño
        this.modificarDuenio(dueno);
        
    }

    private Duenio buscarDuenio(int id_duenio) {
        return controlPersis.buscarDuenio(id_duenio);
    }

    private void modificarDuenio(Duenio dueno) {
        controlPersis.modificarDuenio(dueno);
    }

   
}
