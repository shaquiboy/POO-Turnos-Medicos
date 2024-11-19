
import java.util.*;


abstract class Medico extends Persona {
    private List<Turno> turnos;

    public Medico(String nombre, String apellido, int edad, Boolean genero, List<Turno> turnos) {
        super(nombre, apellido, edad, genero);
        this.turnos = turnos;
    }

    public List<Turno> getTurnos() {
        return turnos;
    }

    public abstract int getCantidadTurnos();
    public abstract boolean aceptarTurno(Paciente t) throws ExcepcionEdadNoPermitida;
    public abstract void agregarTurno(Turno t) throws ExcepcionLimiteTurnos;

    public void cancelarTurno(Turno t) {
        // Eliminar el turno de la lista de turnos del médico
        this.turnos.remove(t);
    }

}