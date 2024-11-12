
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
    public void agregarTurno(Turno t) {
        getTurnos().add(t);
    }

    @Override
    public int getCantidadTurnos() {
        return getTurnos().size();
    }

    @Override
    public boolean aceptarTurno(Paciente p) {
        int edadPaciente = p.getEdad();

        if (edadPaciente >= this.edadMinima && edadPaciente <= this.edadMaxima) {
            // Edad del paciente está dentro del rango permitido
            return true;
        } else {
            // Edad del paciente está fuera del rango permitido
            this.turnosRechazados++;
            return false;
        }
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