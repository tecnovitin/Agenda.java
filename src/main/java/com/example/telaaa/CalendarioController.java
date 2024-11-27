package com.example.telaaa;

import interfaces.Menu;
import interfaces.trocaTela;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import obj.Administrador;
import obj.Calendario;

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
    private TextField hora;
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

    @FXML
    public void initialize() {

        btAgendar.setDisable(true);
        hora.textProperty().addListener((obs, oldValue, newValue) -> updateButtonState());
        usuarioAnotacao.textProperty().addListener((obs, oldText, newText) -> updateButtonState());

        calendario.setValue(LocalDate.now());


    }
    @Override
    public void config() {





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


        btAgendar.setOnAction(event -> {

            String profissional = admLista.getText();
            boolean opcao1 = cb1.isSelected();
            boolean opcao2 = cb2.isSelected();
            boolean opcao3 = cb3.isSelected();
            LocalDate data = calendario.getValue();
            String horaSelecionada = hora.getText();
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




        });
    }


        private void updateButtonState() {

            btAgendar.setDisable(
                    admLista.getText().isEmpty() ||
                            hora.getText().isEmpty()
            );
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






