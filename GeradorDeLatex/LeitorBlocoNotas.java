import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.File;
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


    public static String abrirSeletorDeArquivo() {
        // Cria uma instância de JFileChooser
        JFileChooser seletor = new JFileChooser();

        // Define o seletor para selecionar apenas diretórios
        seletor.setFileSelectionMode(JFileChooser.FILES_ONLY);

        // Abre o diálogo e espera a ação do usuário
        int resultado = seletor.showOpenDialog(null);

        // Verifica se o usuário clicou no botão "Abrir"
        if (resultado == JFileChooser.APPROVE_OPTION) {
            // Obtém o arquivo selecionado
            File diretorioSelecionado = seletor.getSelectedFile();

            // Retorna o caminho do diretório
            return diretorioSelecionado.getAbsolutePath();
        }

        // Retorna null se o usuário cancelar a seleção
        return null;
    }

    public static String abrirSeletorDeDiretorio() {
        // Cria uma instância de JFileChooser
        JFileChooser seletor = new JFileChooser();

        // Define o seletor para selecionar apenas diretórios
        seletor.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        // Abre o diálogo e espera a ação do usuário
        int resultado = seletor.showOpenDialog(null);

        // Verifica se o usuário clicou no botão "Abrir"
        if (resultado == JFileChooser.APPROVE_OPTION) {
            // Obtém o arquivo selecionado
            File diretorioSelecionado = seletor.getSelectedFile();

            // Retorna o caminho do diretório
            return diretorioSelecionado.getAbsolutePath();
        }

        // Retorna null se o usuário cancelar a seleção
        return null;
    }
    public static void criarArquivo(String caminho) throws IOException {
        Path path = Path.of(caminho);
        Files.createFile(path);
    }

    public static void escreverNoArquivo(String caminho, String menssagem) throws IOException {
        Files.writeString(Path.of(caminho), menssagem);
    }
}