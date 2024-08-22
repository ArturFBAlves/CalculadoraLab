import java.util.ArrayList;

public class ConversorLatex {
    Formulas formulas = new Formulas();

    public ConversorLatex(){

    }

    public String converterMedia(Dados experimento) {
        ArrayList<Double> valores = experimento.getValores();
        StringBuilder mensagem1 = new StringBuilder("\\[\\overline{x}=\\frac{");
        StringBuilder mensagem2 = new StringBuilder();
        formulas.calcMedia(experimento);
        for (int i = 0; i < valores.size(); i++) {
            mensagem2.append(valores.get(i));
            if (i < valores.size() - 1) {
                mensagem2.append("+");
            }
        }

        mensagem1.append(mensagem2);
        mensagem1.append("}{").append(valores.size()).append("}=%f".formatted(experimento.getMedia())); // denominator (number of values)
        mensagem1.append(experimento.getMedia()).append("%s\\]".formatted(experimento.getUnidade()));

        return mensagem1.toString();
    }

    public String converterDesvio(Dados experimento){
        ArrayList<Double> valores = experimento.getValores();
        StringBuilder mensagem1 = new StringBuilder("\\[\\sigma=\\sqrt{\\frac{");
        StringBuilder mensagem2 = new StringBuilder();
        formulas.calcDesvio(experimento);
        for (int i = 0; i < valores.size(); i++) {
            mensagem2.append("(%f-%f)^2".formatted(valores.get(i),experimento.getMedia()));
            if (i < valores.size() - 1) {
                mensagem2.append("+");
            }
        }
        mensagem1.append(mensagem2);
        mensagem1.append("}{%d}=%f\\]".formatted(valores.size(),experimento.getDesvio()));
        return mensagem1.toString();
    }
    public String converterIncertezaA(Dados experimento) {
        StringBuilder mensagem = new StringBuilder("\\[\\sigma_{a}=\\frac{");
        formulas.calcIncertezaA(experimento);
        mensagem.append(experimento.getDesvio());

        mensagem.append("}{\\sqrt{").append(experimento.getValores().size()).append("}}");

        double resultado = experimento.getDesvio() / Math.sqrt(experimento.getValores().size());
        mensagem.append("=").append(resultado).append("\\]");

        return mensagem.toString();
    }
    public String converterIncertezaC(Dados experimento) {
        ArrayList<Double> valores = experimento.getValores();
        StringBuilder mensagem = new StringBuilder("\\[\\sigma_{c}=\\sqrt{");
        formulas.calcIncertezaC(experimento);
        mensagem.append(experimento.getIncertezaA()).append("^2 + ").append(experimento.getIncertezaB()).append("^2}");

        double resultado = Math.sqrt(Math.pow(experimento.getIncertezaA(), 2) + Math.pow(experimento.getIncertezaB(), 2));
        mensagem.append("=").append(resultado).append("\\]");

        return mensagem.toString();
    }


}
