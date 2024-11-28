package com.example.telaaa;

import interfaces.Login;
import interfaces.trocaTela;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import obj.Administrador;

public class LoginADMController implements Login, trocaTela {

    @FXML
    private TextField EmailUsuario;
    @FXML
    private PasswordField senhaUsuario;
    @FXML
    private TextField codigoADM;
    @FXML
    private Button btLogin;
    @FXML
    private Hyperlink cadasADM;

    @FXML
    public void initialize() {

        btLogin.setDisable(true);


        EmailUsuario.textProperty().addListener((obs, oldText, newText) -> updateButtonState());
        senhaUsuario.textProperty().addListener((obs, oldText, newText) -> updateButtonState());
        codigoADM.textProperty().addListener((obs, oldText, newText) -> updateButtonState());
    }

    @Override
    public void Logar() {

        String NomeUsuario = EmailUsuario.getText();
        String Senha = senhaUsuario.getText();
        String Codigo = codigoADM.getText().trim();
        Boolean Encontrado = false;


        System.out.println("Dados inseridos: NomeUsuario = " + NomeUsuario + ", Senha = " + Senha + ", Codigo = " + Codigo);


        var administradores = HelloApplication.getInstance().getAdiministradores();

        if (administradores.isEmpty()) {
            System.out.println("Nenhum administrador cadastrado.");
            showAlert("Erro de Login", "Nenhum administrador cadastrado no sistema.");
            return;
        }


        for (Administrador administrador : administradores) {
            System.out.println("Administrador: " + administrador.getNome() + ", Senha: " + administrador.getSenha() + ", Código: " + administrador.getCodigo());
        }


        for (Administrador administrador : administradores) {

            if (NomeUsuario.trim().equalsIgnoreCase(administrador.getNome().trim()) &&
                    Senha.equals(administrador.getSenha()) &&
                    Codigo.equals(String.valueOf(administrador.getCodigo()).trim())) {
                Encontrado = true;
                System.out.println("Administrador encontrado");


                try {
                    HelloApplication.getInstance().Tela5();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Erro ao redirecionar para a tela principal.");
                }
                break;
            }
        }

        if (!Encontrado) {
            showAlert("Erro de Login", "Nome de usuário, senha ou código de administrador incorretos.");
        }
    }

    private void updateButtonState() {
        btLogin.setDisable(
                EmailUsuario.getText().trim().isEmpty() ||
                        senhaUsuario.getText().trim().isEmpty() ||
                        codigoADM.getText().trim().isEmpty()
        );
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    public void handleLogin() {

        Logar();
    }

    @FXML
    public void outraTela() {
        try {
            HelloApplication.getInstance().Tela2();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao abrir a tela de cadastro.");
        }
    }
}
