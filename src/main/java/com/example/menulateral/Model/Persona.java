package com.example.menulateral.Model;

import javafx.beans.Observable;
import javafx.collections.ObservableArray;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Persona{

    private String name;
    private String gender;
    private String birth;
    private String age;
    private  String phone;
    private String picture;
    private String nationality;

    public String toString2(){
        return "Nombre: "+this.name+
                "\nGenero: "+this.gender+
                "\nFecha de nacimiento"+this.birth+
                "\nEdad: "+this.age+
                "\nNum.Telefono: "+this.phone+
                "\nNacionalidad: "+this.nationality;
    }

    public String toString(){
        return this.name;
    }
}