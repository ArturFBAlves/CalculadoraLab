import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeitorBlocoNotas {

    public static List<List<Double>> lerBlocoDeNotas(String caminhoArquivo) {
        List<List<Double>> listaDeListas = new ArrayList<>();
        List<Double> listaAtual = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                if (linha.trim().equals("@")) {
                    if (!listaAtual.isEmpty()) {
                        listaDeListas.add(new ArrayList<>(listaAtual));
                        listaAtual.clear();
                    }
                } else {
                    try {
                        // Converte a linha para double e adiciona à lista atual
                        double valor = Double.parseDouble(linha.trim());
                        listaAtual.add(valor);
                    } catch (NumberFormatException e) {
                        System.out.println("Valor inválido encontrado: " + linha);
                    }
                }
            }

            // Adiciona a última lista ao final do arquivo
            if (!listaAtual.isEmpty()) {
                listaDeListas.add(listaAtual);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaDeListas;
    }
}