
import java.io.*;
import java.util.*;

abstract class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private Boolean genero;

    public Persona(String nombre, String apellido, int edad, Boolean genero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public int getEdad() {
        return edad;
    }

    public Boolean getGenero() {
        return genero;
    }
}