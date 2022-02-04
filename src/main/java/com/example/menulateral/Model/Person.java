package com.example.menulateral.Model;

import javafx.beans.property.*;
import javafx.scene.image.Image;

public class Person {

    private StringProperty nombre;
    private IntegerProperty edad;
    private ObjectProperty<Image> imagen;

    public String getNombre() {
        return nombre.get();
    }

    public String nombreProperty() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public Integer getEdad() {
        return edad.get();
    }

    public IntegerProperty edadProperty() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad.set(edad);
    }

    public Image getImagen() {
        return imagen.get();
    }

    public ObjectProperty<Image> imagenProperty() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen.set(imagen);
    }

    public Person(String nombre, Integer edad) {
        this.nombre = new SimpleStringProperty(nombre);
        this.edad = new SimpleIntegerProperty(edad);
        this.imagen = null;
    }



    public Person(){}
}
