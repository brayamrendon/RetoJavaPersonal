import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Empleado {
    private int id;
    private String name;
    private String rol;
   private LocalDate dateOfHire;

    public Empleado() {
        this.id = id;
        this.name = name;
        this.rol = rol;
        this.dateOfHire = dateOfHire;
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

    public LocalDate getDateOfHire() {
        return dateOfHire;
    }

    public void setDateOfHire(LocalDate dateOfHire) {
        this.dateOfHire = dateOfHire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Lista para almacenar empleados
    private static List<Empleado> empleadoList = new ArrayList<>();

    public static void createEmpleado(Scanner scanner) {
        Empleado empleado = new Empleado();
        System.out.println("Creación de Empleado:");

        // Solicitar información del empleado al usuario
        System.out.print("Nombre del empleado: ");
        empleado.setName  (scanner.nextLine());
        System.out.print("Rol del empleado: ");
        empleado.setRol (scanner.nextLine());
        System.out.print("Fecha de contratación (YYYY-MM-DD): ");
        String dateOfHireString = scanner.nextLine();

        // Convertir la cadena de fecha a LocalDate
        LocalDate.parse(dateOfHireString);

        // Genera un ID único en secuencia (puedes implementar tu propia lógica)
        empleado.setId(empleadoList.size() + 1);

        empleadoList.add(empleado);
        System.out.println("Empleado registrado con éxito.");

        // Llama al método para crear una nueva hoja en el archivo Excel
        Tools.createSheetForEmpleado(empleado);
    }
}
