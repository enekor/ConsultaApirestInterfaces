package com.example.menulateral.Model;

import com.example.menulateral.Model.restmodel.Person;

import java.util.List;

public class PersonList {
    private List<Persona> personas;

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
}
