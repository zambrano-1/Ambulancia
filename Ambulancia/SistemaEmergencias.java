import java.util.ArrayList;
import java.util.Scanner;

public class SistemaEmergencias {
    private static final int MAX_PACIENTES = 100;
    private static final int MAX_CONDUCTORES = 10;
    private static final int MAX_AMBULANCIAS = 15;

    private final ArrayList<Paciente> pacientes = new ArrayList<>();
    private final ArrayList<Conductor> conductores = new ArrayList<>();
    private final ArrayList<Ambulancia> ambulancias = new ArrayList<>();
    private final ArrayList<Clinica> clinica = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new SistemaEmergencias().iniciar();
    }

    public void iniciar() {
        while (true) {
            mostrarMenuPrincipal();
            System.out.print("Seleccione una opción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1": registrarPaciente(); break;
                case "2": registrarConductor(); break;
                case "3": registrarAmbulancia(); break;
                case "4": marcarFallecido(); break;
                case "5": generarReporte(); break;
                case "6": registrarClinica(); break;
                case "7": solicitarAmbulancia(); break; 
                case "8": mostrarPacientesNoMovidos(); break;
                case "9": resumenAmbulancias(); break;
                case "10": System.out.println("Saliendo..."); return;
                default: System.out.println("Opción inválida.");
            }
        }
    }

    private void mostrarMenuPrincipal() {
        System.out.println("\n=== SISTEMA DE EMERGENCIAS ===");
        System.out.println("1. Registrar paciente");
        System.out.println("2. Registrar conductor");
        System.out.println("3. Registrar ambulancia");
        System.out.println("4. Marcar fallecido");
        System.out.println("5. Generar reporte");
        System.out.println("6. Registrar clinica");
        System.out.println("7. Solicitar ambulancia");
        System.out.println("8. Mostrar los pacientes que no fueron movidos");
        System.out.println("9. Resumen de las ambulancias");
        System.out.println("10. Salir");
    }

    private void registrarPaciente() {
        if (pacientes.size() >= MAX_PACIENTES) {
            System.out.println("No se pueden registrar más pacientes.");
            return;
        }
        System.out.print("Nombre del paciente: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido del paciente: ");
        String apellido = scanner.nextLine();
        System.out.print("ID del paciente: ");
        String id = scanner.nextLine();
        pacientes.add(new Paciente(nombre, apellido, id));
        System.out.println("Paciente registrado con éxito.");
    }

    private void registrarConductor() {
        if (conductores.size() >= MAX_CONDUCTORES) {
            System.out.println("No se pueden registrar más conductores.");
            return;
        }
        System.out.print("Nombre del conductor: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido del conductor: ");
        String apellido = scanner.nextLine();
        System.out.print("Licencia del conductor: ");
        String licencia = scanner.nextLine();
        conductores.add(new Conductor(nombre, apellido, licencia));
        System.out.println("Conductor registrado con éxito.");
    }

    private void registrarAmbulancia() {
        if (ambulancias.size() >= MAX_AMBULANCIAS) {
            System.out.println("No se pueden registrar más ambulancias.");
            return;
        }
        System.out.print("ID de la ambulancia: ");
        String id = scanner.nextLine();
        System.out.print("Licencia del conductor asignado: ");
        String licencia = scanner.nextLine();
        ambulancias.add(new Ambulancia(id, licencia));
        System.out.println("Ambulancia registrada con éxito.");
    }

private void registrarClinica() {
    if (clinica.size() > 3) {
        System.out.println("No se pueden registrar más clinicas.");
        return;
    }
    System.out.print("Nombre de la clinica: "); 
    String nombre = scanner.nextLine();
    System.out.print("Distancia de la ambulancia : ");
    int distancia = scanner.nextInt();
    scanner.nextLine(); 
    clinica.add(new Clinica(nombre, distancia));
    System.out.println("Clinica registrada con éxito.");
}

    private void marcarFallecido() {
        System.out.print("Ingrese el ID del paciente fallecido: ");
        String id = scanner.nextLine();
        pacientes.removeIf(paciente -> paciente.getId().equals(id));
        System.out.println("Paciente marcado como fallecido.");
    }

    private void generarReporte() {
        System.out.println("\n=== Reporte de Pacientes ===");
        for (Paciente paciente : pacientes) {
            System.out.println("ID: " + paciente.getId() + ", Nombre: " + paciente.getNombre() + " " + paciente.getApellido());
        }
    }

    public void solicitarAmbulancia(Clinica clinica) {
    
    for (Ambulancia ambulancia : ambulancias) {
        if (ambulancia.getNumeroRecorridos() < 8 && ambulancia.getRecorridoTotal() < 400) {
            ambulancia.agregarRecorrido(clinica.getDistancia());
            System.out.println("Ambulancia asignada a " + clinica.getNombre());
            return;
        }
    }
    System.out.println("No hay ambulancias disponibles.");
}


    public void mostrarPacientesNoMovidos() {
    for (Paciente paciente : pacientes) {
        if (!paciente.isMovido()) {
            System.out.println("Paciente no movido: " + paciente.getNombre());
        }
    }


   
}

public void mostrarResumenAmbulancias() {
    for (Ambulancia ambulancia : ambulancias) {
        System.out.println("Ambulancia: " + ambulancia.getId() +
                           ", Recorrido Total: " + ambulancia.getRecorridoTotal() +
                           ", Número de Recorridos: " + ambulancia.getNumeroRecorridos());
    }
}

}






   
