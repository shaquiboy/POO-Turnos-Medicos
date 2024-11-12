
import java.io.*;
import java.util.*;

public class Clinica {

    private List<Paciente> pacientes;
    private List<Medico> medicos;
    private List<Especialidad> especialidades;

     public Clinica() {
        this.pacientes = new ArrayList<>();
        this.medicos = new ArrayList<>();
        this.especialidades = new ArrayList<>();
    }

    public void agregarPaciente(Paciente p) {
        pacientes.add(p);
    }

    public void agregarMedico(Medico m) {
        medicos.add(m);
    }

    public void listarPacientes() {
        for (Paciente p : pacientes) {
            System.out.println(p.getNombreCompleto());
        }
    }

    public void listarMedicos() {
        for (Medico m : medicos) {
            System.out.println(m.getNombreCompleto());
        }
    }

    public List<Medico> buscarMedicosPorEspecialidad(Especialidad e) {
        List<Medico> medicosEspecialidad = new ArrayList<>();
        for (Medico m : medicos) {
            if (m instanceof MedicoEspecialidad) {
                if (((MedicoEspecialidad) m).getEspecialidad().getNombre().equals(e.getNombre())) {
                    medicosEspecialidad.add(m);
                }
            }
        }
        return medicosEspecialidad;
    }

    public void agregarEspecialidad(Especialidad e) {
        especialidades.add(e);
    }

    public void listarEspecialidades() {
        for (Especialidad e : especialidades) {
            System.out.println(e.getNombre());
        }
    }
}
