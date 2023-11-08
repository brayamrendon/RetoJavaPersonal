import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProcesoDeAdopcion {
    private static List<SolicitudAdopcion> solicitudesAceptadas = new ArrayList<>(); // Nueva lista para las solicitudes aceptadas
    public static void verListaAnimalesDisponibles() {
        System.out.println("Lista de animales disponibles:");

        for (Animal animal : Animal.animalList) {
            if (animal.getHealthStatus().equalsIgnoreCase("disponible")) {
                // Si el estado de salud es "Disponible," muestra el animal
                System.out.println("Nombre: " + animal.getName());
                System.out.println("Especie: " + animal.getSpecies());
                System.out.println("Raza: " + animal.getRace());
                System.out.println("Descripción: " + animal.getDescription());
                System.out.println();
            }
        }
    }

    /* Este metodo solicitarAdopcion muestra una lista de animales disponibles y permite al adoptante seleccionar
    el animal que desean adoptar. Luego, actualiza el estado del animal a "Solicitado".*/
    public static void solicitarAdopcion(Scanner scanner) {
        System.out.println("Lista de animales disponibles para adopción:");
        int index = 1;

        for (Animal animal : Animal.animalList) {
            if (animal.getHealthStatus().equalsIgnoreCase("disponible")) {
                System.out.println(index + ". " + animal.getName());
                index++;
            }
        }

        if (index == 1) {
            System.out.println("No hay animales disponibles para adopción en este momento.");
            return;
        }

        System.out.print("Seleccione el número del animal que desea adoptar: ");
        int selection = scanner.nextInt();

        if (selection >= 1 && selection < index) {
            Animal selectedAnimal = null;
            int selectedIndex = 0;

            for (Animal animal : Animal.animalList) {
                if (animal.getHealthStatus().equalsIgnoreCase("disponible")) {
                    selectedIndex++;
                    if (selectedIndex == selection) {
                        selectedAnimal = animal;
                        break;
                    }
                }
            }

            if (selectedAnimal != null) {
                // Crear una nueva solicitud de adopción
                SolicitudAdopcion solicitud = new SolicitudAdopcion(obtenerAdoptanteValido(), selectedAnimal);
                ProcesoDeAdopcion.getSolicitudesAdopcion().add(solicitud);

                // Marcar el animal como "Solicitado"
                selectedAnimal.setHealthStatus("Solicitado");
                System.out.println(selectedAnimal.getName() + " ha sido solicitado para adopción.");
            } else {
                System.out.println("No se pudo encontrar el animal seleccionado.");
            }
        } else {
            System.out.println("Selección no válida. Por favor, elija un número de animal válido.");
        }
    }

    /*metodo en la clase ProcesoDeAdopcion que maneje esta solicitud solo los empleados*/
    public static void verListaAdoptantes() {
        System.out.println("Lista de adoptantes registrados:");

        for (Adoptante adoptante : Adoptante.adoptanteList) {
            System.out.println("Nombre: " + adoptante.getName());
            System.out.println("Dirección: " + adoptante.getAddress());
            System.out.println("Número de contacto: " + adoptante.getContactNumber());
            System.out.println("Preferencias de adopción: " + adoptante.getAdoptionPreferences());

            // Mostrar el estado de las solicitudes del adoptante
            System.out.println("Solicitudes de adopción:");
            List<SolicitudAdopcion> solicitudes = ProcesoDeAdopcion.getSolicitudesAdopcion();
            for (SolicitudAdopcion solicitud : solicitudes) {
                if (solicitud.getAdoptante() == adoptante) {
                    System.out.println("- " + solicitud.getAnimal().getName() + " (" + solicitud.getEstado() + ")");
                }
            }

            System.out.println();
        }
    }

    private static List<SolicitudAdopcion> solicitudesAdopcion = new ArrayList<>();

    public static List<SolicitudAdopcion> getSolicitudesAdopcion() {

        return solicitudesAdopcion;
    }

    public static void aceptarSolicitud(Scanner scanner) {
        // Muestra las solicitudes pendientes y permite al empleado seleccionar una para aceptar
        //List<SolicitudAdopcion> solicitudesPendientes = solicitudesAdopcion;
        List<SolicitudAdopcion> solicitudesPendientes = ProcesoDeAdopcion.getSolicitudesAdopcion();

        if (solicitudesPendientes.isEmpty()) {
            System.out.println("No hay solicitudes de adopción pendientes.");
            return;
        }

        System.out.println("Solicitudes de adopción pendientes:");
        int index = 1;

        for (SolicitudAdopcion solicitud : solicitudesPendientes) {
            Adoptante adoptante = solicitud.getAdoptante();
            Animal animal = solicitud.getAnimal();
            System.out.println(index + ". " + adoptante.getName() + " desea adoptar " + animal.getName());
            index++;
        }

        System.out.print("Seleccione el numero de solicitud que desea aceptar: ");
        int selection = scanner.nextInt();

        if (selection >= 1 && selection < index) {
            SolicitudAdopcion solicitudAceptada = solicitudesPendientes.get(selection - 1);
            solicitudAceptada.setEstado("Aceptada");
            solicitudesPendientes.remove(solicitudAceptada);
            solicitudesAceptadas.add(solicitudAceptada); // Agregar a la lista de solicitudes aceptadas
            System.out.println("Solicitud de adopción aceptada.");
        } else {
            System.out.println("Selección no válida. Por favor, elija un número de solicitud válido.");
        }
    }

    // Método para buscar un adoptante en Adoptante.adoptanteList por nombre
    private static Adoptante buscarAdoptantePorNombre(String nombre) {
        for (Adoptante adoptante : Adoptante.adoptanteList) {
            if (adoptante.getName().equalsIgnoreCase(nombre)) {
                return adoptante;
            }
        }
        return null; // Devuelve null si no se encuentra un adoptante con el nombre proporcionado
    }

    // Método para obtener un adoptante válido
    private static Adoptante obtenerAdoptanteValido() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del adoptante: ");
        String nombreAdoptante = scanner.nextLine();

        Adoptante adoptante = buscarAdoptantePorNombre(nombreAdoptante);

        if (adoptante != null) {
            System.out.println("Adoptante encontrado: " + adoptante.getName());
            return adoptante;
        } else {
            System.out.println("No se encontró un adoptante con ese nombre.");
            return null;
        }
    }

    // Método para mostrar las solicitudes aceptadas
    public static void verSolicitudesAceptadas() {
        System.out.println("Solicitudes de adopción aceptadas:");
        for (SolicitudAdopcion solicitud : solicitudesAceptadas) {
            Adoptante adoptante = solicitud.getAdoptante();
            Animal animal = solicitud.getAnimal();
            System.out.println(adoptante.getName() + " ha adoptado a " + animal.getName());
        }
    }

    // Método para mostrar la lista de animales adoptados
    public static void verAnimalesAdoptados() {
        System.out.println("Animales adoptados:");
        for (SolicitudAdopcion solicitud : solicitudesAceptadas) {
            Animal animal = solicitud.getAnimal();
            System.out.println(animal.getName());
        }
    }

}