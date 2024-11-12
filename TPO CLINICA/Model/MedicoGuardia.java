import java.util.List;

class MedicoGuardia extends Medico {

    public MedicoGuardia(String nombre, String apellido, int edad, Boolean genero, List<Turno> turnos) {
        super(nombre, apellido, edad, genero, turnos);
    }

    @Override
    public int getCantidadTurnos() {
        return getTurnos().size();
    }

    @Override
    public boolean aceptarTurno(Paciente p) {
        return true;
    }

    @Override
    public void agregarTurno(Turno t) {
        getTurnos().add(t);
    }
}