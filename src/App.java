
import java.util.List;

import models.Estudiante;

public class App {

    public static void mostrar(String titulo, List<Estudiante> lista) {
        System.out.println("\n========================================");
        System.out.println(titulo);
        System.out.println("========================================");

        for (Estudiante e : lista) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

        List<Estudiante> estudiantes = DatosPrueba.crearEstudiantes();

        // Guardar el orden original
        String[] ordenOriginal = new String[estudiantes.size()];

        for (int i = 0; i < estudiantes.size(); i++) {
            ordenOriginal[i] = estudiantes.get(i).getCodigo();
        }

        // Ejecutar las consultas
        mostrar("C1 - Codigo ascendente",
                Comparadores.C1(estudiantes));

        mostrar("C2 - Nombre y codigo ascendente",
                Comparadores.C2(estudiantes));

        mostrar("C2 Alternativo - Nombre y codigo",
                Comparadores.C2Alternativo(estudiantes));

        mostrar("C3 - Nota ascendente",
                Comparadores.C3(estudiantes));

        mostrar("C4 - Nota descendente y nombre ascendente",
                Comparadores.C4(estudiantes));

        mostrar("C5 - Edad ascendente y nombre descendente",
                Comparadores.C5(estudiantes));

        mostrar("C6 - Carrera, nota, nombre y codigo",
                Comparadores.C6(estudiantes));

        mostrar("C7 - Nota ajustada descendente",
                Comparadores.C7(estudiantes));

        // Comprobar que C2 y C2 alternativo sean iguales
        List<Estudiante> c2 = Comparadores.C2(estudiantes);
        List<Estudiante> c2Alternativo =
                Comparadores.C2Alternativo(estudiantes);

        boolean iguales = true;

        for (int i = 0; i < c2.size(); i++) {
            if (!c2.get(i).getCodigo().equals(
                    c2Alternativo.get(i).getCodigo())) {
                iguales = false;
                break;
            }
        }

        System.out.println("\nC2 Y C2 ALTERNATIVO SON IGUALES: "
                + iguales);

        // Comprobar que la lista original no haya cambiado
        boolean conservaOrden = true;

        for (int i = 0; i < estudiantes.size(); i++) {
            if (!ordenOriginal[i].equals(
                    estudiantes.get(i).getCodigo())) {
                conservaOrden = false;
                break;
            }
        }

        System.out.println("LA LISTA ORIGINAL SE CONSERVA: "
                + conservaOrden);
    }
}
