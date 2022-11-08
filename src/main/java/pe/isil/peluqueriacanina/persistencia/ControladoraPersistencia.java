package pe.isil.peluqueriacanina.persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.isil.peluqueriacanina.logica.Duenio;
import pe.isil.peluqueriacanina.logica.Mascota;
import pe.isil.peluqueriacanina.persistencia.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {
    DuenioJpaController duenioJPA = new DuenioJpaController();
    MascotaJpaController mascotaJPA = new MascotaJpaController();

    public void guardar(Duenio duenio, Mascota masco) {
        //Creamos primero el dueño porque mascota lo necesita
        duenioJPA.create(duenio);
        mascotaJPA.create(masco);
    }

    public List<Mascota> traerMascotas() {
        return  mascotaJPA.findMascotaEntities();
    }

    public void borrarMascotas(int num_cliente) {
        try {
            mascotaJPA.destroy(num_cliente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     public Mascota traerUnaMascota(int num_cliente)  {
           return mascotaJPA.findMascota(num_cliente);
       }
     
//       public void modificar(Duenio duenio, Mascota mascota) {
//           
//           try {
//                  duenioJPA.edit(duenio);
//                  mascotaJPA.edit(mascota);
//        } catch (Exception ex) {
//            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
//        }
//       }

    public void modificarMascota(Mascota masco) {
        try {
            mascotaJPA.edit(masco);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Duenio buscarDuenio(int id_duenio) {
        return duenioJPA.findDuenio(id_duenio);
    }      

    public void modificarDuenio(Duenio dueno) {
        try {
            duenioJPA.edit(dueno);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
}
