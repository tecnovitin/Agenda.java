package obj;

public class Administrador {
    private String nome;
    private String email;
    private String senha;
    private String confirmaSenha;
    private int codigo; // Alterado para int
    private String cpf;

    // Construtor
    public Administrador(String nome, String email, String senha, String confirmaSenha, int codigo, String cpf) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.confirmaSenha = confirmaSenha;
        this.codigo = codigo;
        this.cpf = cpf;
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
