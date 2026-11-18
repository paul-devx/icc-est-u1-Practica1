
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import models.Estudiante;

public class Comparadores {

    // C1: Codigo ascendente usando Comparable
    public static List<Estudiante> C1(List<Estudiante> original) {
        List<Estudiante> copia = new ArrayList<>(original);
        // Usamos el método sort de la lista, que utiliza el método compareTo de la clase Estudiante
        copia.sort(null);
        return copia;
    }

    // C2: Nombre ascendente y codigo ascendente
    public static List<Estudiante> C2(List<Estudiante> original) {
        List<Estudiante> copia = new ArrayList<>(original);
        // Usamos un comparador lambda para ordenar por nombre y luego por código
        copia.sort((e1, e2) -> {int resultado = e1.getNombre().compareTo(e2.getNombre());
            if (resultado == 0) {
                resultado = e1.getCodigo().compareTo(e2.getCodigo());}
            return resultado;
        });
        
        return copia;
    }

    // C2 alternativa: comparing y thenComparing
    public static List<Estudiante> C2Alternativo(List<Estudiante> original) {
        List<Estudiante> copia = new ArrayList<>(original);
        // Usamos Comparator.comparing y thenComparing para ordenar por nombre y luego por código
        copia.sort(Comparator.comparing(Estudiante::getNombre).thenComparing(Estudiante::getCodigo)
        );

        return copia;
    }

    // C3: Nota ascendente
    public static List<Estudiante> C3(List<Estudiante> original) {
        List<Estudiante> copia = new ArrayList<>(original);
        // Usamos Comparator.comparingDouble para comparar la nota
        copia.sort(Comparator.comparingDouble(Estudiante::getNota));

        return copia;
    }

    // C4: Nota descendente y nombre ascendente
    public static List<Estudiante> C4(List<Estudiante> original) {
        List<Estudiante> copia = new ArrayList<>(original);
        // Usamos Comparator.comparingDouble para comparar la nota en orden descendente y luego por nombre en orden ascendente
        copia.sort(Comparator.comparingDouble(Estudiante::getNota)
                    .reversed().thenComparing(Estudiante::getNombre));
        return copia;
    }

    // C5: Edad ascendente y nombre descendente
    public static List<Estudiante> C5(List<Estudiante> original) {
        List<Estudiante> copia = new ArrayList<>(original);
        // Usamos Comparator.comparingInt para comparar la edad en orden ascendente y luego por nombre en orden descendente
        copia.sort(Comparator.comparingInt(Estudiante::getEdad)
                      .thenComparing(Comparator.comparing(Estudiante::getNombre)
                      .reversed()
                      )
        );

        return copia;
    }

    // C6: Carrera ascendente, nota descendente,
    // nombre ascendente y codigo ascendente
    public static List<Estudiante> C6(List<Estudiante> original) {
        List<Estudiante> copia = new ArrayList<>(original);
        // Usamos Comparator.comparing para comparar la carrera en orden ascendente, luego por nota en orden descendente, luego por nombre en orden ascendente y finalmente por código en orden ascendente
        copia.sort(Comparator.comparing(Estudiante::getCarrera)
                    .thenComparing(Comparator.comparingDouble(Estudiante::getNota)
                    .reversed())
                    .thenComparing(Estudiante::getNombre)
                    .thenComparing(Estudiante::getCodigo)
        );

        return copia;
    }

    // C7: Nota ajustada descendente,
    // nombre ascendente y codigo ascendente
    public static List<Estudiante> C7(List<Estudiante> original) {
        List<Estudiante> copia = new ArrayList<>(original);
        // Usamos Comparator.comparingDouble para comparar la nota ajustada en orden descendente, 
        // luego por nombre en orden ascendente y finalmente por código en orden ascendente
        copia.sort(Comparator.comparingDouble((Estudiante e) -> {
                    double nota = e.getNota();
                    // Ajustamos la nota si el estudiante es de la carrera de Computacion
                    if (e.getCarrera().equals("Computacion")) {
                        nota = Math.min(10.0, nota + 0.5);
                    }
                    return nota;
                }
            ).reversed()
            .thenComparing(Estudiante::getNombre)
            .thenComparing(Estudiante::getCodigo)
        );

        return copia;
    }
}
