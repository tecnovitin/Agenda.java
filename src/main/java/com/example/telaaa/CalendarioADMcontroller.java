package com.example.telaaa;

import interfaces.trocaTela;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import obj.Calendario;

import java.io.IOException;
import java.util.ArrayList;

public class CalendarioADMcontroller implements trocaTela {

    @FXML
    private Label nomeadm;

    @FXML
    private ListView<Calendario> Lista;

    @FXML
    private Button btVoltar;

    @FXML
    private ObservableList<Calendario> calendarioList;



    public void initialize() {

        calendarioList = FXCollections.observableList(new ArrayList<Calendario>());

        Lista.setItems(calendarioList);
    }

    public void outraTela() {
        btVoltar.setOnAction(actionEvent -> {
            try {
                HelloApplication.getInstance().Tela0(); // Redireciona para a tela inicial
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }
}