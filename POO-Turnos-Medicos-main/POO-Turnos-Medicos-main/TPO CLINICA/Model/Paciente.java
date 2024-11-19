
import java.util.*;

class Paciente extends Persona implements Gestionable {
    private List<Turno> turnos;

    public Paciente(String nombre, String apellido, int edad, Boolean genero, List<Turno> turnos) {
        super(nombre, apellido, edad, genero);
        this.turnos = turnos;
    }




    public List<Turno> listarTurnosPaciente() {
        try {
            // Intentamos obtener los turnos del paciente
            if (turnos.isEmpty()) {
                throw new ExcepcionNoHayTurnos("No hay turnos agendados.");
            }
            return turnos;  // Si hay turnos, los devolvemos
        } catch (ExcepcionNoHayTurnos e) {
            // Si no hay turnos, capturamos la excepción y mostramos el mensaje
            System.out.println(e.getMessage());
            return new ArrayList<>();  // Devolvemos una lista vacía para evitar errores
        }
    }


    public List<Medico> buscarMedicoEspecialidad(Especialidad e, Clinica clinica) {

        return (clinica.buscarMedicosPorEspecialidad(e));
    }

    public void reservarTurnoEspecialidad(MedicoEspecialidad medico) {
        try {
            if (medico.aceptarTurno(this)) {
                Turno turno = new Turno(this, medico);
                medico.agregarTurno(turno);
                this.turnos.add(turno);
                System.out.println("Turno reservado con éxito.");
            }
        } catch (ExcepcionLimiteTurnos e) {
            System.out.println("El medico " + medico.getNombreCompleto() + " ya tiene el maximo de 4 turnos");
        } catch (ExcepcionEdadNoPermitida e) {
            System.out.println("El paciente no cumple con la edad requerida para atenderse con el medico " + medico.getNombreCompleto());
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
        try {
            // Intentamos cancelar el turno
            if (turnos.isEmpty()) {
                throw new ExcepcionNoHayTurnos("No hay turnos agendados para cancelar.");
            }

            turnos.remove(t);  // Cancelamos el turno si hay turnos agendados
            System.out.println("Turno cancelado con éxito.");

            // También se debe cancelar el turno en el médico
            if (t.getMedico() != null) {
                t.getMedico().cancelarTurno(t);  // Llamamos al método cancelarTurno del médico
            }
        } catch (ExcepcionNoHayTurnos e) {
            // Manejamos la excepción internamente
            System.out.println(e.getMessage());
        }
    }




    @Override
    public void consultarTurno(Turno t) {
        System.out.println("Detalles del turno: " + t);
    }
}
