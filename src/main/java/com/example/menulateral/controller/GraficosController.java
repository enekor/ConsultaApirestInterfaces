package com.example.menulateral.controller;

import com.example.menulateral.Model.PersonList;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;

import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class GraficosController implements Initializable {
    @FXML PieChart edadPie,nacionalidadPie;
    @FXML ChoiceBox<String> spinner;
    @FXML Button find;
    private ObservableList<PieChart.Data> edad;
    private ObservableList<PieChart.Data> region;

    public void initData(){
        System.out.println("estoy en los graficos");
        List<String> edades;
        List<String> regiones;

        edades = PersonList.getInstance().getPersons().stream().map(v->v.getAge()).collect(Collectors.toList());
        regiones = PersonList.getInstance().getPersons().stream().map(v->v.getNationality()).collect(Collectors.toList());


        edad =  toCountMap(edades);
        region =  toCountMap(regiones);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        edadPie.setVisible(false);
        nacionalidadPie.setVisible(false);
        setSpinner();
        find.setOnMouseClicked(v->click());
    }

    private ObservableList<PieChart.Data> toCountMap(List<String> lista){
        Set<String> dataSet = new HashSet<>(lista);
        System.out.println(dataSet);
        ObservableList<PieChart.Data> returner = FXCollections.observableArrayList();

        dataSet.forEach(v->{
            returner.add(new PieChart.Data(v,lista.stream().filter(w->w.equals(v)).count()));
        });
        return returner;
    }

    private void setSpinner(){
        ObservableList<String> elecciones = FXCollections.observableArrayList();
        elecciones.add("Edades");
        elecciones.add("nacionalidades");
        spinner.setItems(elecciones);
    }

    private void click(){

        if(spinner.getValue().equalsIgnoreCase("edades")){
            edadPie.setVisible(true);
            nacionalidadPie.setVisible(false);
            edadPie.setData(edad);
        }
        else if(spinner.getValue().equalsIgnoreCase("nacionalidades")){
            edadPie.setVisible(false);
            nacionalidadPie.setVisible(true);
            nacionalidadPie.setData(region);
        }
    }

}
