package com.example.menulateral.rest;

import com.example.menulateral.Model.PersonList;
import com.example.menulateral.Model.Persona;
import com.example.menulateral.Model.restmodel.Person;
import com.example.menulateral.mapper.PersonaMapper;
import retrofit2.Response;

public class RestToModel {

    private PersonaMapper mapper = new PersonaMapper();
    private CrudRest crud = Config.getService();

    private Persona getPerson() throws Exception {
        Persona person = null;
        Response<Person> res = crud.getPerson().execute();
        if(res.body() != null) {
            System.out.println("hola");
            person = mapper.resultToPerson(res.body().results.get(0));
        }else{
            throw new Exception("fallo al recuperar informacion de la api");
        }
        return person;
    }

    public void setPersons(){
        PersonList lista = PersonList.getInstance();
        for (int i = 0;i<10;i++){
            try {
                lista.addPerson(getPerson());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        try {
            System.out.println(new RestToModel().getPerson());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}