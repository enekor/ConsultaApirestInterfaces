package com.example.menulateral.Model;

import java.util.ArrayList;
import java.util.List;

public class PersonList {
    private List<Persona> personas = new ArrayList<>();

    private static PersonList list = null;
    private PersonList(){}

    public static PersonList getInstance(){
        if (list==null){
            list = new PersonList();
        }
        return list;
    }

    public List<Persona> addPerson(Persona persona){
        this.personas.add(persona);
        return this.personas;
    }

    public List<Persona> getPersons(){
        return this.personas;
    }

    public void clearList(){
        this.personas.clear();
    }
}