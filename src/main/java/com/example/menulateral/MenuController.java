package com.example.menulateral;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.util.Duration;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    @FXML private Button panel1,panel2,menu;
    private final int DURACION_ANIMACION = 200;
    private TranslateTransition animacion,animacion2;
    private boolean abierto = true;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       // menu.getParent().setTranslateX(0-panel1.getParent().getLayoutBounds().getWidth());
        setOnClick();
    }

    private void setOnClick() {
        menu.setOnMouseClicked(x->{
            if(!abierto){
                abierto = true;
                animacion(true,DURACION_ANIMACION);
            }else{
                abierto = false;
                animacion(false,DURACION_ANIMACION);
            }
        });
    }

    private void animacion(boolean abrir,int duracion){
        if(abrir){
            animacion = new TranslateTransition(Duration.millis(duracion),panel1.getParent().getParent());
            animacion.setFromX(0+panel1.getParent().getLayoutBounds().getWidth());
            animacion.setToX(0);
            animacion.play();
        }else{
            animacion2 = new TranslateTransition(Duration.millis(duracion),panel1.getParent().getParent());
            animacion2.setFromX(0);
            animacion2.setToX(0+panel1.getParent().getLayoutBounds().getWidth());
            animacion2.play();
        }
    }
}