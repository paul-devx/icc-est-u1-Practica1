
import java.util.ArrayList;
import java.util.List;

import models.Estudiante;

public class DatosPrueba {

    public static List<Estudiante> crearEstudiantes() {

        //Lista de estudiantes
        List<Estudiante> estudiantes = new ArrayList<>(List.of(
            new Estudiante("E014", "Ana",    20, 8.5, "Computacion"),
            new Estudiante("E003", "Luis",   19, 7.8, "Electronica"),
            new Estudiante("E018", "Maria",  21, 9.2, "Computacion"),
            new Estudiante("E007", "Pedro",  20, 8.5, "Mecatronica"),
            new Estudiante("E001", "Sofia",  18, 9.5, "Computacion"),
            new Estudiante("E012", "Diego",  22, 6.8, "Electronica"),
            new Estudiante("E005", "Ana",    19, 8.5, "Computacion"),
            new Estudiante("E020", "Carlos", 21, 7.8, "Mecatronica"),
            new Estudiante("E009", "Lucia",  20, 9.2, "Electronica"),
            new Estudiante("E016", "Mateo",  18, 7.0, "Computacion"),
            new Estudiante("E002", "Elena",  22, 8.0, "Mecatronica"),
            new Estudiante("E011", "Pablo",  21, 9.5, "Electronica"),
            new Estudiante("E006", "Sara",   19, 6.8, "Computacion"),
            new Estudiante("E019", "Juan",   20, 8.0, "Mecatronica"),
            new Estudiante("E004", "Diana",  18, 9.2, "Electronica"),
            new Estudiante("E015", "Bruno",  22, 7.0, "Computacion"),
            new Estudiante("E008", "Carla",  21, 8.5, "Mecatronica"),
            new Estudiante("E017", "Andres", 19, 9.5, "Electronica"),
            new Estudiante("E010", "Ana",    20, 8.5, "Computacion"),
            new Estudiante("E013", "Luis",   19, 7.8, "Electronica")
        ));
        // Validar que los códigos sean únicos
        validarCodigosUnicos(estudiantes);
        return estudiantes;
    }

    // Método privado para validar que los códigos de los estudiantes sean únicos
    private static void validarCodigosUnicos(List<Estudiante> estudiantes) {
        for (int i = 0; i < estudiantes.size(); i++) {
            for (int j = i + 1; j < estudiantes.size(); j++) {
                // Comparar los códigos de los estudiantes
                if (estudiantes.get(i).getCodigo().equals(estudiantes.get(j).getCodigo())) {
                    throw new IllegalArgumentException(
                            "Codigo duplicado: " + estudiantes.get(i).getCodigo());
                }
            }
        }
    }
}
