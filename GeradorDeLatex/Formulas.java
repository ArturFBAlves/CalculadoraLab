import java.util.ArrayList;

public class Formulas {

    public Formulas(){

    }


    public void calcMedia(Dados experimento) {
        double media = 0;
        ArrayList<Double> valores = experimento.getValores();
        for (int i = 0; i < valores.size(); i++) {
            media += valores.get(i);
        }
        experimento.setMedia(media/valores.size());

    }

    public void calcDesvio(Dados experimento){
        ArrayList<Double> valores = experimento.getValores();
        double media = experimento.getMedia();
        double soma = 0;
        double desvio = 0;
        for (int i = 0; i < valores.size(); i++){
            soma += Math.pow(valores.get(i) - media, 2);
        }
        desvio = (float) Math.sqrt(soma / (valores.size() - 1));
        experimento.setDesvio(desvio);

    }
    public void calcIncertezaA(Dados experimento){
        ArrayList<Double> valores = experimento.getValores();
        double desvio = experimento.getDesvio();
        experimento.setIncertezaA(desvio/Math.sqrt(valores.size()));
    }
    public void calcIncertezaC(Dados experimento){
        experimento.setIncertezaC(Math.sqrt(Math.pow(experimento.getIncertezaA(), 2) + Math.pow(experimento.getIncertezaB(), 2)));
    }
}

