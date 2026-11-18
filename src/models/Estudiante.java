package models;

public class Estudiante implements Comparable<Estudiante> {
    //Atributos de la clase Estudiante
    private String codigo;
    private String nombre;
    private int edad;
    private double nota;
    private final String carrera;

    //Constructor de la clase Estudiante pasando sus atributos como parámetros
    public Estudiante(String codigo, String nombre, int edad,
                      double nota, String carrera) {

        //Validacion de los parámetros de entrada solicitados en el enunciado
        if (codigo == null || nombre == null || carrera == null) {
            throw new IllegalArgumentException("Los textos no pueden ser nulos.");
        }
        if (codigo.isEmpty() || nombre.isEmpty() || carrera.isEmpty()) {
            throw new IllegalArgumentException("Los textos no pueden estar vacios.");
        }
        if (edad <= 0) {
            throw new IllegalArgumentException("La edad debe ser positiva.");
        }
        if (!Double.isFinite(nota) || nota < 0.0 || nota > 10.0) {
            throw new IllegalArgumentException("La nota debe ser finita y estar entre 0 y 10.");
        }

        this.codigo = codigo;
        this.nombre = nombre;
        this.edad = edad;
        this.nota = nota;
        this.carrera = carrera;
    }

    //Getters y setters de los atributos de la clase Estudiante
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getCarrera() {
        return carrera;
    }

    @Override
    public int compareTo(Estudiante otro) {
        return this.codigo.compareTo(otro.codigo);
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo + " | Nombre: " + nombre + " | Edad: " + edad + " | Nota: " + nota + " | Carrera: " + carrera;
    }
}
