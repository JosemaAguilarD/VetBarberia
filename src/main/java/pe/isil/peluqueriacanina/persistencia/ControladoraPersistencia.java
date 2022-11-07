package pe.isil.peluqueriacanina.persistencia;

import pe.isil.peluqueriacanina.logica.Duenio;
import pe.isil.peluqueriacanina.logica.Mascota;

public class ControladoraPersistencia {
    DuenioJpaController duenioJPA = new DuenioJpaController();
    MascotaJpaController mascotaJPA = new MascotaJpaController();

    public void guardar(Duenio duenio, Mascota masco) {
        //Creamos primero el dueño porque mascota lo necesita
        duenioJPA.create(duenio);
        mascotaJPA.create(masco);
    }

}
