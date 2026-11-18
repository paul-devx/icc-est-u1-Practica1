
import java.util.ArrayList;
import java.util.List;

import models.Estudiante;

public class App {

    public static void mostrar(String titulo, List<Estudiante> lista) {
        System.out.println("\n-----------------------------------------------------------------------------");
        System.out.println(titulo);
        System.out.println("");

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
        mostrar("C1 - Codigo ascendente",Comparadores.C1(estudiantes));
        mostrar("C2 - Nombre y codigo ascendente",Comparadores.C2(estudiantes));
        mostrar("C2 Alternativo - Nombre y codigo",Comparadores.C2Alternativo(estudiantes));
        mostrar("C3 - Nota ascendente",Comparadores.C3(estudiantes));
        mostrar("C4 - Nota descendente y nombre ascendente",Comparadores.C4(estudiantes));
        mostrar("C5 - Edad ascendente y nombre descendente",Comparadores.C5(estudiantes));
        mostrar("C6 - Carrera, nota, nombre y codigo",Comparadores.C6(estudiantes));
        mostrar("C7 - Nota ajustada descendente",Comparadores.C7(estudiantes));

        // PRUEBAS ADICIONALES
        System.out.println("\n------------- PRUEBAS ADICIONALES -----------");
        
        // 1. Prueba con lista vacía
        System.out.println("\nPrueba 1: Lista vacia");
        List<Estudiante> vacia = new ArrayList<>();
        List<Estudiante> resultadoVacio = Comparadores.C4(vacia);
        System.out.println("Cantidad de estudiantes: " + resultadoVacio.size());

        // 2. Prueba con un solo estudiante
        System.out.println("\nPrueba 2: Lista de un elemento");
        List<Estudiante> unElemento = new ArrayList<>();
        unElemento.add(new Estudiante("E021", "Carlos", 20, 8.5, "Computacion"));
        List<Estudiante> resultadoUnElemento =Comparadores.C4(unElemento);
        for (Estudiante e : resultadoUnElemento) {
                System.out.println(e);
        }

        // 3. Prueba de empate completo en C4
        System.out.println("\nPrueba 3: Empate completo en C4");
        List<Estudiante> empate = new ArrayList<>();
        empate.add(new Estudiante("E014", "Ana", 20, 8.5, "Computacion"));
        empate.add(new Estudiante("E005", "Ana", 19, 8.5, "Computacion"));
        empate.add(new Estudiante("E010", "Ana", 20, 8.5, "Computacion"));

        List<Estudiante> resultadoEmpate =Comparadores.C4(empate);
        for (Estudiante e : resultadoEmpate) {
                System.out.println(e);
        }

        // 4. Prueba propia: estudiantes con el mismo nombre
        System.out.println("\nPrueba 4: Mismo nombre y diferente codigo");
        List<Estudiante> mismoNombre = new ArrayList<>();
        mismoNombre.add(new Estudiante("E030", "Ana", 20, 8.5, "Computacion" ));
        mismoNombre.add(new Estudiante("E025", "Ana", 19, 9.0, "Electronica"));
        mismoNombre.add(new Estudiante("E028", "Ana", 21, 7.5, "Mecatronica"));

        List<Estudiante> resultadoNombre =Comparadores.C2(mismoNombre);
        for (Estudiante e : resultadoNombre) {
                System.out.println(e);
        }

        // 5. Prueba propia: límite de nota en C7
        System.out.println("\nPrueba 5: Limite de nota en C7");
        List<Estudiante> notas = new ArrayList<>();
        notas.add(new Estudiante("E031", "Pedro", 20, 9.8, "Computacion"));
        notas.add(new Estudiante("E032", "Luis", 21, 9.8, "Electronica"));

        List<Estudiante> resultadoNotas =Comparadores.C7(notas);
        for (Estudiante e : resultadoNotas) {
                double notaAjustada = e.getNota();
                if (e.getCarrera().equals("Computacion")) {
                notaAjustada = Math.min(10.0, e.getNota() + 0.5);
        }
        System.out.println(e);
        System.out.println("Nota ajustada: " + notaAjustada);
        }
        System.out.println("\n--------------- FIN DE PRUEBAS ---------------");      

        // Comprobar que la lista original no haya cambiado
        boolean conservaOrden = true;

        for (int i = 0; i < estudiantes.size(); i++) {
            if (!ordenOriginal[i].equals(estudiantes.get(i).getCodigo())) {
                conservaOrden = false;
                break;
            }
        }

        System.out.println("\nLA LISTA ORIGINAL SE CONSERVA: "+ conservaOrden);

        // Comprobar que C2 y C2 alternativo sean iguales
        List<Estudiante> c2 = Comparadores.C2(estudiantes);
        List<Estudiante> c2Alternativo =Comparadores.C2Alternativo(estudiantes);

        boolean iguales = true;

        for (int i = 0; i < c2.size(); i++) {
            if (!c2.get(i).getCodigo().equals(c2Alternativo.get(i).getCodigo())) {
                iguales = false;
                break;
            }
        }

        System.out.println("\nC2 Y C2 ALTERNATIVO SON IGUALES: "+ iguales);
    }
}
