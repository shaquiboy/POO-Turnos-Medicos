
import java.io.*;
import java.util.*;

class Turno {
    private Paciente paciente;
    private Medico medico;

    public Turno(Paciente paciente, Medico medico) {
        this.paciente = paciente;
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }


    @Override
    public String toString() {
        return "Turno con " + medico.getNombreCompleto() + " para " + paciente.getNombreCompleto();
    }


}
