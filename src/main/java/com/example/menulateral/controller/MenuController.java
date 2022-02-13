package com.example.menulateral.controller;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    @FXML private Button menu,salir,homeButton,info1,info2;
    @FXML private Text nombre,correo,datos;
    @FXML private ImageView imagen;
    @FXML private VBox pantalla1,pantalla2,home;
    @FXML private InfoController informacionAnidadaController;
    @FXML private HomeController homeViewController;

    private final int DURACION_ANIMACION = 200;
    private TranslateTransition animacion,animacion2;
    private boolean abierto = true;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       // menu.getParent().setTranslateX(0-panel1.getParent().getLayoutBounds().getWidth());
        pantalla1.setVisible(false);
        pantalla2.setVisible(false);
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

        info1.setOnMouseClicked(x->{
            System.out.println("boton1");
            if(!pantalla1.isVisible()){
                pantalla2.setVisible(false);
                pantalla1.setVisible(true);
                home.setVisible(false);
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
        home.setOnMouseClicked(x->{
            System.out.println("boton 3");
            pantalla1.setVisible(false);
            pantalla2.setVisible(false);
            home.setVisible(true);
        });

        salir.setOnMouseClicked(x->System.exit(0));
    }

    private void animacion(boolean abrir,int duracion){
        if(abrir){
            animacion = new TranslateTransition(Duration.millis(duracion),menu);
            animacion.setFromX(80);
            animacion.setToX(0);

            animacion2=new TranslateTransition(Duration.millis(duracion),info1.getParent());
            animacion2.setFromX(0);
            animacion2.setToX(-80);

            animacion2.play();
            animacion.play();
        }else{
            animacion = new TranslateTransition(Duration.millis(duracion),menu);
            animacion.setFromX(0);
            animacion.setToX(80);

            animacion2=new TranslateTransition(Duration.millis(duracion),info1.getParent());
            animacion2.setFromX(-80);
            animacion2.setToX(0);

            animacion2.play();
            animacion.play();
        }
    }
}