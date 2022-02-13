package com.example.menulateral.Model;

public class Intercambio {

    private static Intercambio instance;
    private Intercambio(){}

    public static  Intercambio getInstance(){
        if(instance==null){
            instance = new Intercambio();
        }
        return instance;
    }

    private Persona persona;

    public void setPersona(Persona p){
        this.persona = p;
    }

    public Persona getPersona(){
        return persona;
    }
}
