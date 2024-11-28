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
        // Desabilitar o botão de login até que todos os campos estejam preenchidos
        btLogin.setDisable(true);

        // Adicionando listeners para os campos de texto, desabilitando o botão quando estiverem vazios
        EmailUsuario.textProperty().addListener((obs, oldText, newText) -> updateButtonState());
        senhaUsuario.textProperty().addListener((obs, oldText, newText) -> updateButtonState());
        codigoADM.textProperty().addListener((obs, oldText, newText) -> updateButtonState());
    }

    @Override
    public void Logar() {
        // Obtém os dados inseridos
        String NomeUsuario = EmailUsuario.getText();
        String Senha = senhaUsuario.getText();
        String Codigo = codigoADM.getText().trim(); // Remover espaços extras no código do administrador
        Boolean Encontrado = false;

        // Exibe os dados inseridos pelo usuário
        System.out.println("Dados inseridos: NomeUsuario = " + NomeUsuario + ", Senha = " + Senha + ", Codigo = " + Codigo);

        // Obtém a lista de administradores cadastrados
        var administradores = HelloApplication.getInstance().getAdiministradores();

        if (administradores.isEmpty()) {
            System.out.println("Nenhum administrador cadastrado.");
            showAlert("Erro de Login", "Nenhum administrador cadastrado no sistema.");
            return;
        }

        // Exibe os administradores cadastrados
        for (Administrador administrador : administradores) {
            System.out.println("Administrador: " + administrador.getNome() + ", Senha: " + administrador.getSenha() + ", Código: " + administrador.getCodigo());
        }

        // Valida os dados de login
        for (Administrador administrador : administradores) {
            // Comparando corretamente o código, convertendo para String se necessário
            if (NomeUsuario.trim().equalsIgnoreCase(administrador.getNome().trim()) &&
                    Senha.equals(administrador.getSenha()) &&
                    Codigo.equals(String.valueOf(administrador.getCodigo()).trim())) { // Converte o código para String e compara
                Encontrado = true;
                System.out.println("Administrador encontrado");

                // Redireciona para a tela principal
                try {
                    HelloApplication.getInstance().Tela3();
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

    // Atualiza o estado do botão de login
    private void updateButtonState() {
        btLogin.setDisable(
                EmailUsuario.getText().trim().isEmpty() ||
                        senhaUsuario.getText().trim().isEmpty() ||
                        codigoADM.getText().trim().isEmpty()
        );
    }

    // Exibe uma mensagem de erro
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    public void handleLogin() {
        // Chamando o método Logar() para centralizar a lógica de login
        Logar();
    }

    @FXML
    public void outraTela() {
        try {
            HelloApplication.getInstance().Tela2(); // Redireciona para a tela de cadastro de administrador
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao abrir a tela de cadastro.");
        }
    }
}
