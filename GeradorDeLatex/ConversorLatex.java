import java.util.ArrayList;

public class ConversorLatex {
    Formulas formulas = new Formulas();

    public ConversorLatex(){

    }

    public String converterMedia(ArrayList<Double> valores) {
        double media = formulas.calcMedia(valores);
        StringBuilder mensagem1 = new StringBuilder("\\[\\overline{x}=\\frac{");
        StringBuilder mensagem2 = new StringBuilder();

        for (int i = 0; i < valores.size(); i++) {
            mensagem2.append(valores.get(i));
            if (i < valores.size() - 1) {
                mensagem2.append("+");
            }
        }

        mensagem1.append(mensagem2);
        mensagem1.append("}{").append(valores.size()).append("}=%f".formatted(media)); // denominator (number of values)
        mensagem1.append(media).append("\\]");

        return mensagem1.toString();
    }

    public String converterDesvio(ArrayList<Double> valores){
        double media = formulas.calcMedia(valores);
        StringBuilder mensagem1 = new StringBuilder("\\[\\sigma=\\sqrt{\\frac{");
        StringBuilder mensagem2 = new StringBuilder();

        for (int i = 0; i < valores.size(); i++) {
            mensagem2.append("(%f-%f)^2".formatted(valores.get(i),media));
            if (i < valores.size() - 1) {
                mensagem2.append("+");
            }
        }
        mensagem1.append(mensagem2);
        mensagem1.append("}{%d}=%f\\]".formatted(valores.size(),formulas.calcDesvio(valores)));
        return mensagem1.toString();
    }
    public String converterIncertezaA(double desvioPadrao, int n) {
        StringBuilder mensagem = new StringBuilder("\\[\\sigma_{a}=\\frac{");

        mensagem.append(desvioPadrao);

        mensagem.append("}{\\sqrt{").append(n).append("}}");

        double resultado = desvioPadrao / Math.sqrt(n);
        mensagem.append("=").append(resultado).append("\\]");

        return mensagem.toString();
    }
    public String converterIncertezaC(double sigmaA, double sigmaB) {
        StringBuilder mensagem = new StringBuilder("\\[\\sigma_{c}=\\sqrt{");

        mensagem.append(sigmaA).append("^2 + ").append(sigmaB).append("^2}");

        double resultado = Math.sqrt(Math.pow(sigmaA, 2) + Math.pow(sigmaB, 2));
        mensagem.append("=").append(resultado).append("\\]");

        return mensagem.toString();
    }


}
