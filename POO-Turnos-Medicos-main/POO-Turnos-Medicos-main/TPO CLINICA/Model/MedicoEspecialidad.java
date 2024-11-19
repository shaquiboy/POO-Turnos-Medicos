
import java.util.*;

class MedicoEspecialidad extends Medico implements Gestionable {
    private Especialidad especialidad;
    private int edadMinima;
    private int edadMaxima;
    private int turnosRechazados;

    public MedicoEspecialidad(String nombre, String apellido, int edad, Boolean genero, List<Turno> turnos,
                              Especialidad especialidad, int edadMinima, int edadMaxima) {
        super(nombre, apellido, edad, genero, turnos);
        this.especialidad = especialidad;
        this.edadMinima = edadMinima;
        this.edadMaxima = edadMaxima;
        this.turnosRechazados = 0;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public int getEdadMaxima() {
        return edadMaxima;
    }

    public int getTurnosRechazados() {
        return turnosRechazados;
    }


    public Especialidad getEspecialidad() {
        return especialidad;
    }


    @Override
    public void agregarTurno(Turno t) throws ExcepcionLimiteTurnos {
        if (getTurnos().size() >= 4) {
            throw new ExcepcionLimiteTurnos("El médico " + getNombreCompleto() + " ya tiene el máximo de 4 turnos.");
        }
        getTurnos().add(t);
    }


    @Override
    public int getCantidadTurnos() {
        return getTurnos().size();
    }

    @Override
    public boolean aceptarTurno(Paciente p) throws ExcepcionEdadNoPermitida {
        int edadPaciente = p.getEdad();
        if (edadPaciente < this.edadMinima || edadPaciente > this.edadMaxima) {
            throw new ExcepcionEdadNoPermitida("El paciente " + p.getNombreCompleto() + " no cumple con la edad permitida para este médico.");
        }
        return true;
    }

    @Override
    public void cancelarTurno(Turno t) {
        getTurnos().remove(t);
    }

    @Override
    public void consultarTurno(Turno t) {
        System.out.println("Detalles del turno: " + t);
    }


}