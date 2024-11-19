package com.example.telaaa;

import interfaces.ListaCadastro;
import interfaces.Login;
import interfaces.trocaTela;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import obj.Usuario;

import java.io.IOException;
import java.util.ArrayList;


public class Logincontroller implements trocaTela, Login, ListaCadastro {


    @Override
    public void setLista(ArrayList<Usuario> lista) {
        this.listCliente = lista;
    }

    private ArrayList<Usuario> listCliente;
    @FXML
    private TextField UsuarioLogin;
    @FXML
    private PasswordField SenhaUsuario;
    @FXML
    private Button btLogin;
    @FXML
    private Button btClique;
    @FXML
    private Hyperlink cadas;

    @Override
    public void Logar() {
   String NomeUsuario = UsuarioLogin.getText();
   String Senha = SenhaUsuario.getText();


   for (Usuario usuario : listCliente) {
       if(NomeUsuario.contains((CharSequence) listCliente) && Senha.contains((CharSequence) listCliente)){
           btLogin.setOnAction(ActionEvent -> {
                   try {
                       HelloApplication.getInstance().Tela3();
                   } catch (Exception e) {
                       throw new RuntimeException(e);
                   }


           });
       }
   }





    }

    @Override
    public void outraTela() {
        cadas.setOnAction(actionEvent -> {
            try {
                HelloApplication.getInstance().Tela1();
            } catch (IOException e) {
                throw new RuntimeException(e);

            }
        });

    }


}