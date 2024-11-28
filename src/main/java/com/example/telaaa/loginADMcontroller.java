package com.example.telaaa;

import interfaces.Login;
import interfaces.trocaTela;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import obj.Administrador;

public class loginADMcontroller implements Login, trocaTela {

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
        // Desabilitar o botão de login até que todos os campos estejam preenchidos
        btLogin.setDisable(true);

        // Adicionando listeners para os campos de texto, desabilitando o botão quando estiverem vazios
        EmailUsuario.textProperty().addListener((obs, oldText, newText) -> updateButtonState());
        senhaUsuario.textProperty().addListener((obs, oldText, newText) -> updateButtonState());
        codigoADM.textProperty().addListener((obs, oldText, newText) -> updateButtonState());
    }

    @Override
    public void Logar() {
        btLogin.setOnAction(actionEvent -> {
            String NomeUsuario = EmailUsuario.getText();
            String Senha = senhaUsuario.getText();
            String Codigo = codigoADM.getText();
            Boolean Encontrado = false;

            // Obtém a lista de administradores cadastrados
            var administradores = HelloApplication.getInstance().getAdiministradores();

            if (administradores.isEmpty()) {
                System.out.println("Nenhum administrador cadastrado.");
                return;
            }

            // Verifica se o login e senha correspondem a algum administrador
            for (Administrador administrador : administradores) {
                if (NomeUsuario.equals(administrador.getNome()) && Senha.equals(administrador.getSenha()) && Codigo.equals(String.valueOf(administrador.getCodigo()))) {
                    Encontrado = true;
                    System.out.println("Administrador encontrado");

                    // Redireciona para a tela principal
                    try {
                        HelloApplication.getInstance().Tela3();
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Erro ao Login");
                    }
                    break;
                }
            }

            if (!Encontrado) {
                showAlert("Erro de Login", "Nome de usuário, senha ou código de administrador incorretos.");
            }
        });
    }

    // Atualiza o estado do botão de login
    private void updateButtonState() {
        btLogin.setDisable(EmailUsuario.getText().isEmpty() || senhaUsuario.getText().isEmpty() || codigoADM.getText().isEmpty());
    }

    // Exibe uma mensagem de erro
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @Override
    public void outraTela() {
        // Redireciona para a tela de cadastro de administrador
        cadasADM.setOnAction(actionEvent -> {
            try {
                HelloApplication.getInstance().Tela4();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
