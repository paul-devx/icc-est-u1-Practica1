
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import models.Estudiante;

public class Comparadores {

    // C1: Codigo ascendente usando Comparable
    public static List<Estudiante> C1(List<Estudiante> original) {
        List<Estudiante> copia = new ArrayList<>(original);
        copia.sort(null);
        return copia;
    }

    // C2: Nombre ascendente y codigo ascendente
    public static List<Estudiante> C2(List<Estudiante> original) {
        List<Estudiante> copia = new ArrayList<>(original);

        copia.sort((e1, e2) -> {
            int resultado = e1.getNombre().compareTo(e2.getNombre());

            if (resultado == 0) {
                resultado = e1.getCodigo().compareTo(e2.getCodigo());
            }

            return resultado;
        });

        return copia;
    }

    // C2 alternativa: comparing y thenComparing
    public static List<Estudiante> C2Alternativo(List<Estudiante> original) {
        List<Estudiante> copia = new ArrayList<>(original);

        copia.sort(
            Comparator.comparing(Estudiante::getNombre)
                      .thenComparing(Estudiante::getCodigo)
        );

        return copia;
    }

    // C3: Nota ascendente
    public static List<Estudiante> C3(List<Estudiante> original) {
        List<Estudiante> copia = new ArrayList<>(original);

        copia.sort(Comparator.comparingDouble(Estudiante::getNota));

        return copia;
    }

    // C4: Nota descendente y nombre ascendente
    public static List<Estudiante> C4(List<Estudiante> original) {
        List<Estudiante> copia = new ArrayList<>(original);

        copia.sort(
            Comparator.comparingDouble(Estudiante::getNota)
                      .reversed()
                      .thenComparing(Estudiante::getNombre)
        );

        return copia;
    }

    // C5: Edad ascendente y nombre descendente
    public static List<Estudiante> C5(List<Estudiante> original) {
        List<Estudiante> copia = new ArrayList<>(original);

        copia.sort(
            Comparator.comparingInt(Estudiante::getEdad)
                      .thenComparing(
                          Comparator.comparing(Estudiante::getNombre)
                                    .reversed()
                      )
        );

        return copia;
    }

    // C6: Carrera ascendente, nota descendente,
    // nombre ascendente y codigo ascendente
    public static List<Estudiante> C6(List<Estudiante> original) {
        List<Estudiante> copia = new ArrayList<>(original);

        copia.sort(
            Comparator.comparing(Estudiante::getCarrera)
                      .thenComparing(
                          Comparator.comparingDouble(Estudiante::getNota)
                                    .reversed()
                      )
                      .thenComparing(Estudiante::getNombre)
                      .thenComparing(Estudiante::getCodigo)
        );

        return copia;
    }

    // C7: Nota ajustada descendente,
    // nombre ascendente y codigo ascendente
    public static List<Estudiante> C7(List<Estudiante> original) {
        List<Estudiante> copia = new ArrayList<>(original);

        copia.sort(
            Comparator.comparingDouble(
                (Estudiante e) -> e.getCarrera().equals("Computacion")
                    ? Math.min(10.0, e.getNota() + 0.5)
                    : e.getNota()
            ).reversed()
             .thenComparing(Estudiante::getNombre)
             .thenComparing(Estudiante::getCodigo)
        );

        return copia;
    }
}
