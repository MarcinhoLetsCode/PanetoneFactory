package br.com.etecia.panetonefactory;

public class Coffe {
    String cafe;
    private String café_preto;

    public Coffe(){}

    public String getCafe() {
        return cafe;
    }

    public void setCafe(String cafe) {
        this.cafe = cafe;
    }

    public String getCafé_preto() {
        return café_preto;
    }

    public void setCafé_preto(String café_preto) {
        this.café_preto = café_preto;
    }

    public Coffe(String café_preto) {
        this.café_preto = café_preto;
    }
}
