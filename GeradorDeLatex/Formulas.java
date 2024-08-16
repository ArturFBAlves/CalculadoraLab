import java.util.ArrayList;

public class Formulas {
    public Formulas(){

    }
    public double calcMedia(ArrayList<Double> valores) {
        double media = 0;
        for (int i = 0; i < valores.size(); i++) {
            media += valores.get(i);
        }
        return media / valores.size();
    }

    public double calcDesvio(ArrayList<Double> valores){
        double media = calcMedia(valores);
        double soma = 0;
        for (int i = 0; i < valores.size(); i++){
            soma += Math.pow(valores.get(i) - media, 2);
        }
        return (float) Math.sqrt(soma / (valores.size() - 1));
    }
    public double calcIncertezaA(ArrayList<Double> valores){
        double desvio = calcDesvio(valores);
        return desvio/Math.sqrt(valores.size());
    }
    public double calcIncertezaC(ArrayList<Double> valores, double incertezaB){
        return Math.sqrt(Math.pow(calcIncertezaA(valores),2) + Math.pow(incertezaB,2));
    }
}

