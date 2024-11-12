
import java.util.*;

class Paciente extends Persona implements Gestionable {
    private List<Turno> turnos;

    public Paciente(String nombre, String apellido, int edad, Boolean genero, List<Turno> turnos) {
        super(nombre, apellido, edad, genero);
        this.turnos = turnos;
    }

    public List<Turno> tieneTurno() {
        return turnos;
    }

    public List<Medico> buscarMedicoEspecialidad(Especialidad e, Clinica clinica) {

        return (clinica.buscarMedicosPorEspecialidad(e));
    }

    public void reservarTurnoEspecialidad(MedicoEspecialidad medico) {
        if (medico.aceptarTurno(this)) {  // Llamamos a aceptarTurno para verificar la edad
            Turno turno = new Turno(this, medico);
            medico.agregarTurno(turno);
            this.turnos.add(turno);
            System.out.println("Turno reservado con éxito.");
        } else {
            System.out.println("Turno rechazado: el paciente no cumple con la edad requerida.");
        }
    }

    public void reservarTurnoGuardia(MedicoGuardia medico) {
        if (medico.aceptarTurno(this)) {
            Turno turno = new Turno(this, medico);
            medico.agregarTurno(turno);
            this.turnos.add(turno);
            System.out.println("Turno reservado con éxito.");
        }
    }

    @Override
    public void cancelarTurno(Turno t) {
        turnos.remove(t);
        System.out.println("Turno cancelado con éxito.");
        // También se debe cancelar el turno en el médico
        if (t.getMedico() != null) {
            t.getMedico().cancelarTurno(t);  // Llamamos al método cancelarTurno del médico
        }
    }

    @Override
    public void consultarTurno(Turno t) {
        System.out.println("Detalles del turno: " + t);
    }
}
