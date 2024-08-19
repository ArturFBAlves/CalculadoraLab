package out.production.GeradorDeLatex;

import java.util.ArrayList;

public class Dados {
    ArrayList valores = new ArrayList<>();
    String unidade;
    double media;
    double desvio;
    double incertezaA;
    double incertezaB;
    double incertezaC;

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public void setValores(double valor) {
        valores.add(valor);
    }

    public void setDesvio(double desvio) {
        this.desvio = desvio;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public void setIncertezaA(double incertezaA) {
        this.incertezaA = incertezaA;
    }

    public void setIncertezaB(double incertezaB) {
        this.incertezaB = incertezaB;
    }

    public void setIncertezaC(double incertezaC) {
        this.incertezaC = incertezaC;
    }

    public ArrayList getValores() {
        return valores;
    }

    public double getDesvio() {
        return desvio;
    }

    public double getMedia() {
        return media;
    }

    public double getIncertezaA() {
        return incertezaA;
    }

    public double getIncertezaB() {
        return incertezaB;
    }

    public double getIncertezaC() {
        return incertezaC;
    }

    public String getUnidade() {
        return unidade;
    }

    @Override
    public String toString() {
        return valores +
                "\nUnidade: " +
                unidade;
    }
}
