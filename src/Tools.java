import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

public class Tools {
    // Ruta del archivo de Excel en el escritorio
    private static final String EXCEL_FILE_PATH = "C:\\Users\\Brayan\\Desktop\\AdopcionAnimales.xlsx";
    // Crear una hoja para animal en Excel
    public static void saveAnimalToExcel(Animal animal) {
        try {
            // Abre el archivo existente o crea uno nuevo si no existe
            Workbook workbook;
            File file = new File(EXCEL_FILE_PATH);

            if (file.exists()) {
                FileInputStream fis = new FileInputStream(EXCEL_FILE_PATH);
                workbook = new XSSFWorkbook(fis);
            } else {
                workbook = new XSSFWorkbook();
            }

            // Obtiene o crea la hoja "Animals"
            Sheet sheet = workbook.getSheet("Animals");
            if (sheet == null) {
                sheet = workbook.createSheet("Animals");
            }

            // Crea un encabezado si la hoja está vacía
            if (sheet.getPhysicalNumberOfRows() == 0) {
                Row headerRow = sheet.createRow(0);
                String[] headers = {"ID", "Nombre", "Edad", "Especie", "Raza", "Estado de Salud", "Descripción"};
                for (int i = 0; i < headers.length; i++) {
                    Cell headerCell = headerRow.createCell(i);
                    headerCell.setCellValue(headers[i]);
                }
            }

            // Crear una nueva fila para el animal
            Row row = sheet.createRow(sheet.getLastRowNum() + 1);

            //código para llenar los datos del animal en la fila

            Cell idCell = row.createCell(0);
            idCell.setCellValue(animal.getId());

            Cell nameCell = row.createCell(1);
            nameCell.setCellValue(animal.getName());

            Cell ageCell = row.createCell(2);
            ageCell.setCellValue(animal.getAge());

            Cell speciesCell = row.createCell(3);
            speciesCell.setCellValue(animal.getSpecies());

            Cell raceCell = row.createCell(4);
            raceCell.setCellValue(animal.getRace());

            Cell healthStatusCell = row.createCell(5);
            healthStatusCell.setCellValue(animal.getHealthStatus());

            Cell descriptionCell = row.createCell(6);
            descriptionCell.setCellValue(animal.getDescription());

            // Guarda el archivo Excel
            FileOutputStream outputStream = new FileOutputStream(EXCEL_FILE_PATH);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Crear una nueva hoja para un empleado en el libro Excel
    public static void createSheetForEmpleado(Empleado empleado) {
        try {
            Workbook workbook;
            Sheet sheet;

            // Verificar si el archivo de Excel ya existe
            File file = new File(EXCEL_FILE_PATH);
            if (file.exists()) {
                FileInputStream inputStream = new FileInputStream(EXCEL_FILE_PATH);
                workbook = WorkbookFactory.create(inputStream);
            } else {
                workbook = new XSSFWorkbook();
            }

            // Obtener el nombre del empleado
            String empleadoName = empleado.getName();

            // Validar que el nombre del empleado no sea nulo ni vacío
            if (empleadoName != null && !empleadoName.trim().isEmpty()) {
                // Crear una nueva hoja con el nombre del empleado
                sheet = workbook.createSheet(empleadoName);

                // Agregar los datos del empleado a la hoja (puedes adaptar esto según tus necesidades)
                Row row = sheet.createRow(0);

                Cell idCell = row.createCell(0);
                idCell.setCellValue(empleado.getId());

                Cell nameCell = row.createCell(1);
                nameCell.setCellValue(empleado.getName());

                Cell rolCell = row.createCell(2);
                rolCell.setCellValue(empleado.getRol());

                Cell dateOfHireCell = row.createCell(3);
                dateOfHireCell.setCellValue(empleado.getDateOfHire().toString());

                // Guardar los cambios en el archivo Excel
                FileOutputStream outputStream = new FileOutputStream(EXCEL_FILE_PATH);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } else {
                System.out.println("Error: El nombre del empleado es nulo o vacío. No se puede crear la hoja.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Crear una nueva hoja para un adoptante en el libro Excel
    public static void createSheetForAdoptante(Adoptante adoptante) {
        try {
            Workbook workbook;
            Sheet sheet;

            // Verificar si el archivo de Excel ya existe
            File file = new File(EXCEL_FILE_PATH);
            if (file.exists()) {
                FileInputStream inputStream = new FileInputStream(EXCEL_FILE_PATH);
                workbook = WorkbookFactory.create(inputStream);
            } else {
                workbook = new XSSFWorkbook();
            }

            // Crear una nueva hoja con el nombre del adoptante
            sheet = workbook.createSheet(adoptante.getName());

            // Agregar los datos del adoptante a la hoja (puedes adaptar esto según tus necesidades)
            Row row = sheet.createRow(0);

            Cell idCell = row.createCell(0);
            idCell.setCellValue(adoptante.getId());

            Cell nameCell = row.createCell(1);
            nameCell.setCellValue(adoptante.getName());

            Cell addressCell = row.createCell(2);
            addressCell.setCellValue(adoptante.getAddress());

            Cell contactNumberCell = row.createCell(3);
            contactNumberCell.setCellValue(adoptante.getContactNumber());

            Cell adoptionPreferencesCell = row.createCell(4);
            adoptionPreferencesCell.setCellValue(adoptante.getAdoptionPreferences());

            // Guardar los cambios en el archivo Excel
            FileOutputStream outputStream = new FileOutputStream(EXCEL_FILE_PATH);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Actualizar el animal en la hoja de Excel
    public static void updateAnimalInExcel(Animal animal) {
        try {
            FileInputStream inputStream = new FileInputStream("animals.xlsx");
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);

            Row row = sheet.getRow(animal.getId() - 1);

            Cell nameCell = row.getCell(1);
            nameCell.setCellValue(animal.getName());

            Cell ageCell = row.getCell(2);
            ageCell.setCellValue(animal.getAge());

            Cell speciesCell = row.getCell(3);
            speciesCell.setCellValue(animal.getSpecies());

            Cell raceCell = row.getCell(4);
            raceCell.setCellValue(animal.getRace());

            Cell healthStatusCell = row.getCell(5);
            healthStatusCell.setCellValue(animal.getHealthStatus());

            Cell descriptionCell = row.getCell(6);
            descriptionCell.setCellValue(animal.getDescription());

            inputStream.close();

            FileOutputStream outputStream = new FileOutputStream("animals.xlsx");
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Eliminar el animal de la hoja de Excel
    public static void deleteAnimalInExcel(Animal animal) {
        try {
            FileInputStream inputStream = new FileInputStream("animals.xlsx");
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);

            Row row = sheet.getRow(animal.getId() - 1);
            sheet.removeRow(row);

            inputStream.close();

            FileOutputStream outputStream = new FileOutputStream("animals.xlsx");
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
