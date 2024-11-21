package com.example.telaaa;


import interfaces.Cadastro;
import interfaces.ListaCadastro;
import interfaces.trocaDeDados;
import interfaces.trocaTela;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import jdk.swing.interop.SwingInterOpUtils;
import kotlin.contracts.Returns;
import obj.Usuario;


import java.util.ArrayList;

 public class cadastroControle implements Cadastro, trocaTela  {



     @FXML
     private Button btCadastro;
     @FXML
     private TextField nomeUsuario;
     @FXML
     private TextField emailUsuario;
     @FXML
     private PasswordField senhaUsuario;
     @FXML
     private PasswordField confirmaSenha;
     @FXML
     private Hyperlink hyper;








     @Override
     public void Cadastro() {

      btCadastro.setDisable(true);

         nomeUsuario.textProperty().addListener((obs, oldText, newText) -> updateButtonState(nomeUsuario, emailUsuario, senhaUsuario, confirmaSenha));
         emailUsuario.textProperty().addListener((obs, oldText, newText) -> updateButtonState(nomeUsuario, emailUsuario, senhaUsuario, confirmaSenha));
         confirmaSenha.textProperty().addListener((obs, oldText, newText) -> updateButtonState(nomeUsuario, emailUsuario, senhaUsuario, confirmaSenha));
         senhaUsuario.textProperty().addListener((obs, oldText, newText) -> updateButtonState(nomeUsuario, emailUsuario, senhaUsuario, confirmaSenha));


         btCadastro.setOnAction(actionEvent -> {
             String nome = nomeUsuario.getText();
             String email = emailUsuario.getText();
             String senha = senhaUsuario.getText();
             String Csenha = confirmaSenha.getText();
             if(!senha.equals(Csenha)){
                 System.out.println("A SENHA TEM QUE SER A MESMA");
                 return;
             }

             var cadastro = HelloApplication.getInstance().usuarios;


             Usuario Cliente = new Usuario(nome, email, senha, Csenha);
                cadastro.add(Cliente);
             System.out.println("Cliente adicionado com sucesso!");
                try {
                    HelloApplication.getInstance().Tela3();

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }


         });
     }

     private void updateButtonState(TextField nomeUsuario, TextField emailUsuario, PasswordField senhaUsuario, PasswordField confirmaSenha) {
         btCadastro.setDisable(nomeUsuario.getText().isEmpty() || emailUsuario.getText().isEmpty() || senhaUsuario.getText().isEmpty() || confirmaSenha.getText().isEmpty());
     }
  @Override
  public void outraTela() {
        hyper.setOnAction(actionEvent -> {
             try {
                 HelloApplication.getInstance().Tela2();

                 } catch (Exception e) {
                 throw new RuntimeException(e);
             }
    });

     }



 }








