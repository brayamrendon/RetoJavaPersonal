import java.util.ArrayList;
import java.util.Scanner;

public class Adoptante {
    private int id;
    private String name;
    private String address;
    private String contactNumber;
    private String adoptionPreferences;

    public Adoptante() {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
        this.adoptionPreferences = adoptionPreferences;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAdoptionPreferences() {
        return adoptionPreferences;
    }

    public void setAdoptionPreferences(String adoptionPreferences) {
        this.adoptionPreferences = adoptionPreferences;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public static ArrayList<Adoptante> adoptanteList = new ArrayList<>();

    // Método para registrar un nuevo adoptante
    public static void registerAdoptante(Scanner scanner) {
        Adoptante adoptante = new Adoptante();
        System.out.print("Nombre: ");
        adoptante.setName(scanner.nextLine());
        System.out.print("Dirección: ");
        adoptante.setAddress(scanner.nextLine());
        System.out.print("Número de contacto: ");
        adoptante.setContactNumber(scanner.nextLine());
        System.out.print("Preferencias de adopción: ");
        adoptante.setAdoptionPreferences(scanner.nextLine());

        // Generar un ID único en secuencia
        adoptante.setId(adoptanteList.size() + 1);

        adoptanteList.add(adoptante);
        System.out.println("Adoptante registrado con éxito.");

        // Llama al método para crear una nueva hoja en el archivo Excel
        Tools.createSheetForAdoptante(adoptante);
    }
}

