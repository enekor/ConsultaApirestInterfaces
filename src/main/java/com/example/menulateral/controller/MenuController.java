package com.example.menulateral.controller;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    @FXML private Button menu,salir,homeButton,info1,info2;
    @FXML private VBox menuLateral;
    @FXML private AnchorPane pantalla1,pantalla2,home;
    @FXML private InfoController informacionAnidadaController;
    @FXML private HomeController homeviewController;

    private final int DURACION_ANIMACION = 200;
    private TranslateTransition animacion;
    private boolean abierto = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pantalla1.setVisible(false);
        pantalla2.setVisible(false);
        setOnClick();
    }

    private void setOnClick() {
        menu.setOnMouseClicked(x->animacion());

        info1.setOnMouseClicked(x->{
            System.out.println("boton1");
            if(!pantalla1.isVisible()){
                pantalla2.setVisible(false);
                pantalla1.setVisible(true);
                home.setVisible(false);
                informacionAnidadaController.initInfo();
            }
        });
        info2.setOnMouseClicked(x->{
            System.out.println("boton2");
            if(!pantalla2.isVisible()){
                pantalla1.setVisible(false);
                pantalla2.setVisible(true);
                home.setVisible(false);
            }
        });
        homeButton.setOnMouseClicked(x->{
            System.out.println("boton 3");
            pantalla1.setVisible(false);
            pantalla2.setVisible(false);
            home.setVisible(true);
        });

        salir.setOnMouseClicked(x->System.exit(0));
    }

    private void animacion(){
        if(abierto){
            animacion = new TranslateTransition(Duration.millis(DURACION_ANIMACION),menuLateral.getParent());
            animacion.setFromX(menuLateral.getMaxWidth());
            animacion.setToX(0);
            animacion.play();
        }else{
            animacion = new TranslateTransition(Duration.millis(DURACION_ANIMACION),menuLateral.getParent());
            animacion.setFromX(0);
            animacion.setToX(menuLateral.getMaxWidth());
            animacion.play();
        }
        abierto = !abierto;
    }
}