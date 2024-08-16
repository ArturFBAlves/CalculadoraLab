import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double valor = 0;
        int opcao = -1;
        ArrayList<Double> listaDeValores = new ArrayList<Double>();
        Scanner leitura = new Scanner(System.in);
        Formulas formulas = new Formulas();
        ConversorLatex conversorLatex = new ConversorLatex();
        System.out.println("Digite os valores:\n");

        while (true) {
            System.out.println("Digite: ");
            valor = leitura.nextDouble();
            if (valor == -1) {
                break;
            }
            listaDeValores.add(valor);
        }
        while (opcao!=0){
        System.out.println("=========================");
        System.out.println("Qual operação sera feita:");
        System.out.println("=========================");
        System.out.println("1 - Média\n");
        System.out.println("2 - Desvio Padrão\n");
        System.out.println("3 - Incerteza Tipo A\n");
        System.out.println("4 - Incerteza Tipo C\n");
        opcao = leitura.nextInt();
        switch (opcao){
            case 1:
                System.out.println(conversorLatex.converterMedia(listaDeValores));
                break;
            case 2:
                System.out.println(conversorLatex.converterDesvio(listaDeValores));
                break;
            case 3:
                System.out.println(conversorLatex.converterIncertezaA(formulas.calcDesvio(listaDeValores), listaDeValores.size() ));
                break;
            case 4:
                System.out.println("Digite o valor da incerteza do tipo B:\n");
                double incertezaB = leitura.nextDouble();
                System.out.println(conversorLatex.converterIncertezaC(formulas.calcIncertezaA(listaDeValores),incertezaB ));
            }
        }
    }


}
