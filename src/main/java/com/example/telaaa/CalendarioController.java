package com.example.telaaa;

import interfaces.Buttom;
import interfaces.Menu;
import interfaces.trocaTela;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import obj.Administrador;
import obj.Calendario;
import org.controlsfx.control.action.Action;

import java.io.IOException;
import java.time.LocalDate;

public class CalendarioController implements trocaTela, Menu {

    @FXML
    private Button btAgendar;
    @FXML
    private Button btLog;
    @FXML
    private SplitMenuButton admLista;
    @FXML
    private ComboBox<String> hora;
    @FXML
    private DatePicker calendario;
    @FXML
    private TextField usuarioAnotacao;
    @FXML
    private CheckBox cb1;
    @FXML
    private CheckBox cb2;
    @FXML
    private CheckBox cb3;


    @Override
    public void config() {
        btAgendar.setDisable(true);

        calendario.setValue(LocalDate.now());
        data();
        validateFields();

        var adms = HelloApplication.getInstance().getAdiministradores();
        admLista.getItems().clear();
        if(adms !=null)

        {
            for (Administrador ad : adms) {
                MenuItem item = new MenuItem(ad.getNome());
                item.setOnAction(event -> admLista.setText(ad.getNome()));
                admLista.getItems().add(item);
            }
        }

        hora.valueProperty().addListener((obs, oldValue, newValue) -> validateFields());
        usuarioAnotacao.textProperty().addListener((obs, oldText, newText) -> validateFields());
        cb1.selectedProperty().addListener((obs, oldValue, newValue) -> validateFields());
        cb2.selectedProperty().addListener((obs, oldValue, newValue) -> validateFields());
        cb3.selectedProperty().addListener((obs, oldValue, newValue) -> validateFields());
        btAgendar.setOnAction(event -> {

            String profissional = admLista.getText().equals("Selecione um profissional")? null : admLista.getText();
            boolean opcao1 = cb1.isSelected();
            boolean opcao2 = cb2.isSelected();
            boolean opcao3 = cb3.isSelected();
            LocalDate data = calendario.getValue();
            String horaSelecionada = hora.getValue();
            String anotacoes = usuarioAnotacao.getText();
           if (data == null|| horaSelecionada ==null || profissional==null ) {
               System.out.println("coloca tudo");
                    return;
           }

            Calendario ageds = new Calendario(profissional, data, horaSelecionada, anotacoes, opcao1, opcao2, opcao3);
           HelloApplication.getInstance().agendamentos.add(ageds);
            System.out.println("Agendamento realizado: " + ageds);

        });
        calendario.valueProperty().addListener((obs,oldDate,newDate) -> {

            data();

            validateFields();
        });
    }

    private void validateFields() {
        Platform.runLater(()-> {
            boolean allFieldsValid = calendario.getValue() != null
                    && hora.getValue() != null
                    && !admLista.getText().equals("Selecione um profissional")
                    && !usuarioAnotacao.getText().trim().isEmpty();
            btAgendar.setDisable(!allFieldsValid);
        });
    }
    @Override
    public void data() {

        hora.getItems().clear();
        for (int i = 8; i <= 18; i++) {
            String horario = String.format("%02d:00", i);
            hora.getItems().add(horario);
        }
        System.out.println("Horários preenchidos para a data: " + hora.getItems());




}

    @Override
    public void outraTela() {
        btLog.setOnAction(event -> {
            try {

                HelloApplication.getInstance().Tela0();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        });

    }


}






