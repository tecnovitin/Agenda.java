package obj;



public class Adiministrador extends Usuario{
    private float Codigo;
    private String CPF;
   public Adiministrador(String nome, String email, String senha, String confrimaSenha, float Codigo , String CPF) {
        super(nome, email, senha,confrimaSenha);
        this.Codigo = Codigo;
        this.CPF = CPF;
    }

    public void setCodigo(float codigo) {
        Codigo = codigo;
    }

    public float getCodigo() {
        return Codigo;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
}
