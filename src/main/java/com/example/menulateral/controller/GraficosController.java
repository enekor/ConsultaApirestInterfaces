package com.example.menulateral.controller;

import com.example.menulateral.Model.PersonList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class GraficosController implements Initializable {
    @FXML PieChart pie1,pie2;

    public void initData(){
        System.out.println("estoy en los graficos");
        List<String> edades;
        List<String> regiones;

        edades = PersonList.getInstance().getPersons().stream().map(v->v.getAge()).collect(Collectors.toList());
        regiones = PersonList.getInstance().getPersons().stream().map(v->v.getNationality()).collect(Collectors.toList());


        ObservableList<PieChart.Data> edad =  toCountMap(edades);
        ObservableList<PieChart.Data> region =  toCountMap(regiones);

        pie1.setData(edad);
        pie2.setData(region);

        //https://www.youtube.com/watch?v=bpHmrgvpEDQ
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

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
}
