import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear instancias
        Especialidad cardiologia = new Especialidad("Cardiología");
        List<Turno> turnos = new ArrayList<>();
        MedicoEspecialidad medico1 = new MedicoEspecialidad("Rodolfo", "Perez", 30, true, turnos, cardiologia, 35, 99);
        MedicoEspecialidad medico2 = new MedicoEspecialidad("Pedro", "Perezo", 47, true, turnos, cardiologia, 18, 99);
        Paciente paciente1 = new Paciente("Juan", "Perez", 25, true, new ArrayList<>());
        Paciente paciente2= new Paciente("Rodrigo","Castro",16,true,new ArrayList<>());
        MedicoGuardia medico3 = new MedicoGuardia("Rosa","Ramirez",24,false,new ArrayList<>());

        // Agregar a la clínica
        Clinica clinica = new Clinica();
        clinica.agregarMedico(medico1);
        clinica.agregarMedico(medico2);
        clinica.agregarPaciente(paciente1);
        clinica.agregarMedico(medico3);
        clinica.agregarPaciente(paciente2);

        // Listar médicos y pacientes
        System.out.print("Lista de medicos:");
        clinica.listarMedicos();
        System.out.print("Lista de pacientes:");
        clinica.listarPacientes();

        // Verificar que el paciente no tiene turnos
        System.out.println("\nTurnos del paciente antes de la reserva:");
        for (Turno t : paciente1.tieneTurno()) {
            System.out.println(t);
        }

        // Verificar que el médico tampoco tiene turnos
        System.out.println("\nTurnos del médico antes de la reserva:");
        for (Turno t : medico1.getTurnos()) {
            System.out.println(t);
        }

        // Buscar médicos de una especialidad
        System.out.println("\nMédicos disponibles para la especialidad " + cardiologia.getNombre() + ":");
        List<Medico> medicosEspecialidad = paciente1.buscarMedicoEspecialidad(cardiologia, clinica);
        for (Medico medico : medicosEspecialidad) {
            System.out.println(medico.getNombreCompleto());
        }

        // El paciente reserva un turno para la especialidad "Cardiología"
        System.out.println("\nPaciente "+paciente1.getNombreCompleto()+" reservando turno...");
        paciente1.reservarTurnoEspecialidad(medico2);

        // Verificar que el turno ha sido agregado
        System.out.println("\nTurnos del paciente después de la reserva:");
        for (Turno t : paciente1.tieneTurno()) {
            System.out.println(t);
        }

        // Verificar que el médico también tiene el turno asignado
        System.out.println("\nTurnos del médico después de la reserva:");
        for (Turno t : medico1.getTurnos()) {
            System.out.println(t);
        }

        // Consultar el turno
        System.out.println("\nConsultando el turno del paciente...");
        for (Turno t : paciente1.tieneTurno()) {
            paciente1.consultarTurno(t);  // Mostrar detalles del turno
        }

        // Cancelar el turno
        System.out.println("\nCancelando el turno...");
        Turno turnoAEliminar = paciente1.tieneTurno().get(0); // Obtener el primer turno del paciente
        paciente1.cancelarTurno(turnoAEliminar);// El paciente cancela el turno


        // Verificar que el turno ha sido cancelado del paciente
        System.out.println("\nTurnos del paciente después de cancelar:");
        for (Turno t : paciente1.tieneTurno()) {
            System.out.println(t);
        }

        // Verificar que el médico también ha cancelado el turno
        System.out.println("\nTurnos del médico después de cancelar:");
        for (Turno t : medico1.getTurnos()) {
            System.out.println(t);
        }


        // Verificar turnos medico de guardia
        System.out.println("\nTurnos del médico antes de la reserva:");
        for (Turno t : medico3.getTurnos()) {
            System.out.println(t);
        }

        //Verificar que medico de guardia acepte el turno

        paciente2.reservarTurnoGuardia(medico3);
        // Consultar el turno de guardia
        System.out.println("\nConsultando el turno del paciente...");
        for (Turno t : paciente2.tieneTurno()) {
            paciente2.consultarTurno(t);  // Mostrar detalles del turno
        }

    }


}
