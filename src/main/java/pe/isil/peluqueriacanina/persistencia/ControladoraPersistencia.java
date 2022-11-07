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

}
