package com.example.menulateral.rest;

import com.example.menulateral.Model.PersonList;
import com.example.menulateral.Model.Persona;
import com.example.menulateral.Model.restmodel.Person;
import com.example.menulateral.mapper.PersonaMapper;
import retrofit2.Response;

public class RestToModel {

    private PersonaMapper mapper = new PersonaMapper();
    private CrudRest crud = Config.getService();

    public Persona getPerson() throws Exception {
        Persona person = null;
        Response<Person> res = crud.getPerson().execute();
        if(res.body() != null) {
            System.out.println("Persona adquirida de la DeepWeb, precio: "+(int)(Math.random()*10)+1+" kebaps");
            person = mapper.resultToPerson(res.body().results.get(0));
        }else{
            throw new Exception("fallo al recuperar informacion de la api");
        }
        return person;
    }
}