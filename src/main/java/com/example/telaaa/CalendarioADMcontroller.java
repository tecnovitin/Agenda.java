package com.example.telaaa;

import eu.hansolo.toolbox.observables.ObservableList;
import interfaces.trocaTela;
import javafx.collections.FXCollections;
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

    private ObservableList<Calendario> calendarioList;



    public void initialize() {

        calendarioList = (ObservableList<Calendario>) FXCollections.observableList(new ArrayList<Calendario>());

        Lista.setItems((javafx.collections.ObservableList<Calendario>) calendarioList);
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