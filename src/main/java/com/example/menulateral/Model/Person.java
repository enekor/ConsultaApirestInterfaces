package com.example.menulateral.Model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

public class Person {

    private StringProperty nombre;
    private StringProperty edad;
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

    public String getEdad() {
        return edad.get();
    }

    public StringProperty edadProperty() {
        return edad;
    }

    public void setEdad(String edad) {
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

    public Person(String nombre, String edad) {
        this.nombre = new SimpleStringProperty(nombre);
        this.edad = new SimpleStringProperty(edad);
        this.imagen = null;
    }



    public Person(){}
}
