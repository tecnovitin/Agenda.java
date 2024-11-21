package obj;

import java.time.LocalDate;

public class Calendario {
    private String profissional;
    private LocalDate data;
    private String hora;
    private String anotacoes;
    private boolean opcao1;
    private boolean opcao2;
    private boolean opcao3;


    public Calendario(String profissional, LocalDate data, String hora, String anotacoes, boolean opcao1, boolean opcao2, boolean opcao3) {
        this.profissional = profissional;
        this.data = data;
        this.hora = hora;
        this.anotacoes = anotacoes;
        this.opcao1 = opcao1;
        this.opcao2 = opcao2;
        this.opcao3 = opcao3;


    }
    public String getProfissional() {
        return profissional;
    }

    public LocalDate getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public String getAnotacoes() {
        return anotacoes;
    }

    public boolean isOpcao1() {
        return opcao1;
    }

    public boolean isOpcao2() {
        return opcao2;
    }

    public boolean isOpcao3() {
        return opcao3;
    }

    @Override
    public String toString() {
        return "Agendamendo"+
                "profissional:" +profissional+'/'
                + "data:" + data + '/'
                + "hora:" + hora + '/'
                + "anotacoes:" + anotacoes + '/'
                + "opcao1:" + opcao1 + '/'
                + "opcao2:" + opcao2 + '/'
                + "opcao3:" + opcao3;
    }
}
