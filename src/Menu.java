import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void showMainMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("Elige una opción:");
            System.out.println("1. Administrador");
            System.out.println("2. Empleado");
            System.out.println("3. Adoptante");
            System.out.println("0. Salir");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume la línea en blanco después de nextInt().

            switch (choice) {
                case 1:
                    System.out.println("Elige una opción:");
                    System.out.println("1. Iniciar sesión");
                    System.out.println("2. Registrarse");
                    int adminChoice = scanner.nextInt();

                    if (adminChoice == 1) {
                        // Lógica para iniciar sesión (pedir ID y contraseña)
                        System.out.print("ID: ");
                        int adminId = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el salto de línea
                        System.out.print("Contraseña: ");
                        String adminPassword = scanner.nextLine();

                        Administrador loggedInAdmin = Administrador.loginAdmin(adminId, adminPassword);
                        if (loggedInAdmin != null) {
                            System.out.println("Iniciaste sesión como administrador: " + loggedInAdmin.getName());
                            // Llama a showAdminMenu para mostrar el menú del administrador
                            showAdminMenu(scanner);
                        } else {
                            System.out.println("Inicio de sesión fallido. Verifica ID y contraseña.");
                        }
                    } else if (adminChoice == 2) {
                        // Lógica para registrar un administrador
                        System.out.print("Nombre: ");
                        scanner.nextLine(); // Limpiar el salto de línea
                        Administrador.registerAdmin(scanner);
                    } else {
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                    }
                    break;
                case 2:
                    showEmployeeMenu(scanner);
                    break;
                case 3:
                    showAdopterMenu(scanner);
                    break;
                case 0:
                    System.out.println("Hasta pronto, Esperamos verte de nuevo en peluditos muy felices🐕🐩🐶🐕‍🦺🦮");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (choice != 0);
    }

    public static void showAdminMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("Menú de Administrador:");
            System.out.println("1. Agregar nueva mascota");
            System.out.println("2. Editar una mascota");
            System.out.println("3. Ver lista de animales");
            System.out.println("4. Eliminar animales");
            System.out.println("5. Agregar un empleado");
            System.out.println("6. Regresar al menú anterior");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume la línea vacía después de nextInt().


            switch (choice) {
                case 1:
                    Animal.createAnimal(scanner);
                    break;
                case 2:
                    Animal.editAnimal(scanner);
                    break;
                case 3:
                    Animal.viewAnimals();
                    break;
                case 4:
                    Animal.deleteAnimal(scanner);
                    break;
                case 5:
                    Empleado.createEmpleado(scanner);
                    break;
                case 6:
                    System.out.println("Regresando al menú anterior.");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (choice != 6);
    }


    public static void showEmployeeMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("Menú de Empleado:");
            System.out.println("1. Ver lista de animales disponibles");
            System.out.println("2. Ver lista de adoptantes registrados");
            System.out.println("3. Ver lista de adopciones realizadas");
            System.out.println("4. Regresar al menú anterior");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume la línea vacía después de nextInt().

            switch (choice) {
                case 1:
                    //  logica para ver animales disponibles
                    ProcesoDeAdopcion.verListaAnimalesDisponibles(); // Opción para ver la lista de animales disponibles
                    break;
                case 2:
                    // logica para ver adoptantes registrados
                    ProcesoDeAdopcion.verListaAdoptantes(); // Opción para ver la lista de adoptantes registrados
                    break;
                case 3:
                    // logica para ver adopciones realizadas
                    break;
                case 4:
                    System.out.println("Regresando al menú anterior.");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (choice != 4);
    }

    public static void showAdopterMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("Menú de Adoptante:");
            System.out.println("1. Registrarse");
            System.out.println("2. Ver lista de animales disponibles");
            System.out.println("3. Solicitar un animal");
            System.out.println("4. Regresar al menú anterior");
            choice = scanner.nextInt();

            scanner.nextLine(); // Consume la línea vacía después de nextInt().

            switch (choice) {
                case 1:
                    //  lógica para el registro de adoptantes
                    Adoptante.registerAdoptante(scanner);
                    break;
                case 2:
                    //  lógica para ver animales disponibles
                    ProcesoDeAdopcion.verListaAnimalesDisponibles(); // Opción para ver la lista de animales disponibles
                    break;
                case 3:
                    // lógica para solicitar un animal
                    ProcesoDeAdopcion.solicitarAdopcion(scanner); // Opción para solicitar un animal
                    break;
                case 4:
                    System.out.println("Regresando al menú anterior.");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (choice != 4);
    }
}
