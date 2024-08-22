import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        double valor;
        int opcao = -1;
        int cont = 1;
        String resp = "S";
        String unidade;

        // Declaração dos objetos
        ArrayList<Dados> listaDeValores = new ArrayList<>();
        Scanner leitura = new Scanner(System.in);
        Formulas formulas = new Formulas();
        ConversorLatex conversorLatex = new ConversorLatex();
        List<List<Double>> listas = LeitorBlocoNotas.lerBlocoDeNotas("D:\\Estudos\\UFS\\Lab_Física\\15.txt");

        // Processa os valores lidos do arquivo
        for (List<Double> lista : listas) {
            Dados experimento = new Dados(); // Cria uma nova instância de Dados para cada experimento

            for (double item : lista) {
                experimento.setValores(item); // Adiciona cada valor na lista de valores do experimento
            }

            listaDeValores.add(experimento); // Adiciona o experimento completo à lista de experimentos
        }

        // Exibe a lista de valores lida do arquivo
        System.out.println(listaDeValores);

        System.out.println("==================");
        System.out.println("Digite os valores");
        System.out.println("==================");

        while (!resp.equals("N")) {
            Dados experimento = new Dados(); // Cria uma nova instância de Dados para cada experimento manualmente adicionado

            while (true) {
                System.out.printf("%dº medida:", cont);
                valor = leitura.nextDouble();
                cont++;
                if (valor == -1) {
                    break;
                }

                experimento.setValores(valor); // Adiciona o valor à lista de valores do experimento
            }

            // Cadastro da unidade
            System.out.println("Qual é a unidade usada nesse experimento: ");
            leitura.nextLine(); // Consumir a linha restante
            unidade = leitura.nextLine();
            experimento.setUnidade(unidade); // Define a unidade do experimento

            // Adição do experimento à lista
            listaDeValores.add(experimento);

            // Condição para quebra do loop
            System.out.println("Gostaria de cadastrar um outro experimento [S/N]:");
            resp = leitura.nextLine();

            if (resp.equals("S")) cont = 1;
        }

        System.out.println(listaDeValores);

        while (opcao != 0) {
            System.out.println("Com qual experimento você gostaria de trabalhar: ");
            cont = leitura.nextInt();

            System.out.println("=========================");
            System.out.println("Qual operação será feita:");
            System.out.println("=========================");
            System.out.println("1 - Média\n");
            System.out.println("2 - Desvio Padrão\n");
            System.out.println("3 - Incerteza Tipo A\n");
            System.out.println("4 - Incerteza Tipo C\n");

            opcao = leitura.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println(conversorLatex.converterMedia(listaDeValores.get(cont)));
                    break;
                case 2:
                    System.out.println(conversorLatex.converterDesvio(listaDeValores.get(cont)));
                    break;
                case 3:
                    System.out.println(conversorLatex.converterIncertezaA(listaDeValores.get(cont)));
                    break;
                case 4:
                    System.out.println("Digite o valor da incerteza do tipo B:\n");
                    listaDeValores.get(cont).setIncertezaB(leitura.nextDouble());
                    System.out.println(conversorLatex.converterIncertezaC(listaDeValores.get(cont)));
            }
        }
    }
}
