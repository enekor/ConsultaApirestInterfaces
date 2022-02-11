package com.example.menulateral.mapper;

import com.example.menulateral.Model.Persona;
import com.example.menulateral.Model.restmodel.Result;

public class PersonaMapper {

    public Persona resultToPerson(Result res){
        Persona person = new Persona();
        person.setName(res.name.first);
        person.setGender(res.gender);
        person.setBirth(res.dob.date.toString());
        person.setAge(String.valueOf(res.dob.age));
        person.setPhone(res.phone);
        person.setPicture(res.picture.medium);
        person.setNationality(res.nat);
        return  person;
    }
}
