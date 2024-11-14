package obj;

public class ADM  extends Usuario {
    private String senhaAdm;
   public ADM(String nome, String email, String senha, String confrimaSenha, String senhaAdm) {
        super(nome, email, senha,confrimaSenha);
        this.senhaAdm = senhaAdm;
    }

    public void setSenhaAdm(String senhaAdm) {
        this.senhaAdm = senhaAdm;
    }

    public String getSenhaAdm() {
        return senhaAdm;
    }
}
