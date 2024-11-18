package obj;

public class Usuario {

    String nome;
    String email;
    private String senha;
    private String confirmaSenha;
  public Usuario(String nome, String email, String senha, String confirmaSenha){
      this.nome = nome;
      this.email = email;
      this.senha = senha;
      this.confirmaSenha = confirmaSenha;
  }

    public String getSenha() {
        return senha;
  }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }

    @Override
    public String toString() {
        return nome;
    }
}
