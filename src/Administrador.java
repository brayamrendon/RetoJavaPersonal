import java.util.ArrayList;
import java.util.Scanner;

public class Administrador {
    private int id;
    private String name;
    private String rol;
    private String password;

    // Constructor y métodos getters y setters


    public Administrador() {
        this.id = id;
        this.name = name;
        this.rol = rol;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static ArrayList<Administrador> adminList = new ArrayList<>();

    public static void registerAdmin(Scanner scanner) {
        Administrador admin = new Administrador();
        admin.setName(scanner.nextLine());
        admin.setRol("Administrador"); // Puedes establecer el rol como "Administrador" automáticamente
        System.out.print("Contraseña: ");
        admin.setPassword(scanner.nextLine());

        // Genera un ID único en secuencia automática
        admin.setId(adminList.size() + 1);

        adminList.add(admin);
        System.out.println("Administrador registrado con éxito.");
    }



    public static Administrador loginAdmin(int id, String password) {
        for (Administrador admin : adminList) {
            if (admin.getId() == id && admin.getPassword().equals(password)) {
                return admin;
            }
        }
        return null; // Retorna null si no se encuentra un administrador con el ID y contraseña proporcionados
    }
}

