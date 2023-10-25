import java.util.ArrayList;
import java.util.Scanner;

public class Animal {
    //Atributos de los animales
    private String name;
    private int age;
    private String species;
    private String race;
    private String healthStatus;
    private String description;
    private int id; // Agregar un ID único para cada animal


    //Creacion de  constructor con parametros definidos.

    public Animal(String name, int age, String race, String healthStatus, String description, int id) {
    }

    public Animal() {
        this.name = name;
        this.age = age;
        this.species = species;
        this.race = race;
        this.healthStatus = healthStatus;
        this.description = description;
        this.id= id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static ArrayList<Animal> animalList = new ArrayList<>();

    // Método para crear un nuevo animal
    public static void createAnimal(Scanner scanner) {
        Animal animal = new Animal();
        System.out.print("Nombre del animal: ");
        animal.setName(scanner.nextLine());
        System.out.print("Edad: ");
        animal.setAge(scanner.nextInt());
        scanner.nextLine(); // Limpia el salto de línea
        System.out.print("Especie: ");
        animal.setSpecies(scanner.nextLine());
        System.out.print("Raza: ");
        animal.setRace(scanner.nextLine());
        System.out.print("Estado de salud: ");
        animal.setHealthStatus(scanner.nextLine());
        System.out.print("Descripción: ");
        animal.setDescription(scanner.nextLine());

        // Generar un ID único en secuencia
        animal.setId(animalList.size() + 1);

        // Agregar el animal a la lista
        animalList.add(animal);

        // Guardar el animal en la hoja de Excel
        Tools.saveAnimalToExcel(animal);
    }

    // Método para editar un animal existente
    public static void editAnimal(Scanner scanner) {
        System.out.print("Ingrese el ID del animal a editar: ");
        int idToEdit = scanner.nextInt();
        scanner.nextLine(); // Limpiar el salto de línea

        for (Animal animal : animalList) {
            if (animal.getId() == idToEdit) {
                // Permitir editar las propiedades del animal
                System.out.print("Nuevo nombre: ");
                animal.setName(scanner.nextLine());
                System.out.print("Nueva edad: ");
                animal.setAge(scanner.nextInt());
                scanner.nextLine(); // Limpiar el salto de línea
                System.out.print("Nueva especie: ");
                animal.setSpecies(scanner.nextLine());
                System.out.print("Nueva raza: ");
                animal.setRace(scanner.nextLine());
                System.out.print("Nuevo estado de salud: ");
                animal.setHealthStatus(scanner.nextLine());
                System.out.print("Nueva descripción: ");
                animal.setDescription(scanner.nextLine());

                // Actualizar el animal en la hoja de Excel
                Tools.updateAnimalInExcel(animal);
                System.out.println("Animal editado con éxito.");
                return;
            }
        }
        System.out.println("Animal no encontrado.");
    }

    // Método para ver la lista de animales
    public static void viewAnimals() {
        for (Animal animal : animalList) {
            System.out.println("ID: " + animal.getId());
            System.out.println("Nombre: " + animal.getName());
            System.out.println("Edad: " + animal.getAge());
            System.out.println("Especie: " + animal.getSpecies());
            System.out.println("Raza: " + animal.getRace());
            System.out.println("Estado de salud: " + animal.getHealthStatus());
            System.out.println("Descripción: " + animal.getDescription());
            System.out.println();
        }
    }

    // Método para eliminar un animal
    public static void deleteAnimal(Scanner scanner) {
        System.out.print("Ingrese el ID del animal a eliminar: ");
        int idToDelete = scanner.nextInt();

        for (Animal animal : animalList) {
            if (animal.getId() == idToDelete) {
                animalList.remove(animal);
                // Eliminar el animal de la hoja de Excel
                Tools.deleteAnimalInExcel(animal);
                System.out.println("Animal eliminado con éxito.");
                return;
            }
        }
        System.out.println("Animal no encontrado.");
    }
}
