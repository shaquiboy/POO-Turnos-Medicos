import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear instancias
        Especialidad cardiologia = new Especialidad("Cardiología");
        List<Turno> turnos = new ArrayList<>();
        MedicoEspecialidad medico1 = new MedicoEspecialidad("Rodolfo", "Perez", 24, true, turnos, cardiologia, 24, 99);
        MedicoEspecialidad medico2 = new MedicoEspecialidad("Pedro", "Perezo", 47, true, turnos, cardiologia, 18, 99);
        Paciente paciente1 = new Paciente("Juan", "Perez", 12, true, new ArrayList<>());
        Paciente paciente2= new Paciente("Rodrigo","Castro",16,true,new ArrayList<>());
        Paciente paciente3= new Paciente("Pedro","Gonzalez",25,true,new ArrayList<>());
        Paciente paciente4= new Paciente("Paciente","4",25,true,new ArrayList<>());
        Paciente paciente5= new Paciente("Paciente","5",25,true,new ArrayList<>());
        Paciente paciente6= new Paciente("Paciente","6",25,true,new ArrayList<>());
        Paciente paciente7= new Paciente("Paciente","7",25,true,new ArrayList<>());
        MedicoGuardia medico3 = new MedicoGuardia("Rosa","Ramirez",24,false,new ArrayList<>());

        // Agregar a la clínica
        Clinica clinica = new Clinica();
        clinica.agregarMedico(medico1);
        clinica.agregarMedico(medico2);
        clinica.agregarPaciente(paciente1);
        clinica.agregarMedico(medico3);
        clinica.agregarPaciente(paciente2);
        clinica.agregarPaciente(paciente3);
        clinica.agregarPaciente(paciente4);
        clinica.agregarPaciente(paciente5);
        clinica.agregarPaciente(paciente6);
        clinica.agregarPaciente(paciente7);


        // Listar médicos y pacientes
        System.out.print("Lista de medicos:");
        clinica.listarMedicos();
        System.out.print("Lista de pacientes:");
        clinica.listarPacientes();

        // Verificar que el paciente no tiene turnos
        System.out.println("\nTurnos del paciente antes de la reserva:");
        for (Turno t : paciente1.listarTurnosPaciente()) {
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
        paciente1.reservarTurnoEspecialidad(medico1);

        // Verificar que el turno ha sido agregado
        System.out.println("\nTurnos del paciente después de la reserva:");
        for (Turno t : paciente1.listarTurnosPaciente()) {
            System.out.println(t);
        }

        // Verificar que el médico también tiene el turno asignado
        System.out.println("\nTurnos del médico después de la reserva:");
        for (Turno t : medico1.getTurnos()) {
            System.out.println(t);
        }

        // Consultar el turno
        System.out.println("\nConsultando el turno del paciente...");
        for (Turno t : paciente1.listarTurnosPaciente()) {
            paciente1.consultarTurno(t);  // Mostrar detalles del turno
        }

        // Cancelar el turno
        System.out.println("\nCancelando el turno...");
        List<Turno> turnosPaciente = paciente1.listarTurnosPaciente();
        if (!turnosPaciente.isEmpty()) {
            Turno turnoAEliminar = turnosPaciente.get(0); // Obtener el primer turno si la lista no está vacía
            paciente1.cancelarTurno(turnoAEliminar);  // El paciente cancela el turno
        }


        // Verificar que el turno ha sido cancelado del paciente
        System.out.println("\nTurnos del paciente después de cancelar:");
        for (Turno t : paciente1.listarTurnosPaciente()) {
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
        for (Turno t : paciente2.listarTurnosPaciente()) {
            paciente2.consultarTurno(t);  // Mostrar detalles del turno
        }


        // Probamos la excepcion LimiteTurnos

        System.out.println("\nProbamos la excepcion LimiteTurnos...");

        paciente3.reservarTurnoEspecialidad(medico1);
        paciente4.reservarTurnoEspecialidad(medico1);
        paciente5.reservarTurnoEspecialidad(medico1);
        paciente6.reservarTurnoEspecialidad(medico1);

        System.out.println("\nPaciente "+paciente7.getNombreCompleto()+" reservando turno...");
        paciente7.reservarTurnoEspecialidad(medico1);

    }


}
