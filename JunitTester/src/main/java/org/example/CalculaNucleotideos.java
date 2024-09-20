import java.io.*;

public class CalculaNucleotideos {

    /**
     * Método que calcula a contagem de nucleotídeos A, C, G, T e erros.
     *
     * @param caminhoArquivo Caminho para o arquivo de texto que contém a sequência de DNA.
     * @return Array de inteiros com a contagem de A, C, G, T e erros (índice 4).
     *         Retorna null se mais de 10% da sequência for inválida.
     * @throws IOException Caso o arquivo não seja encontrado.
     */
    public static int[] calculaNucleotideos(String caminhoArquivo) throws IOException {
        File arquivo = new File(caminhoArquivo);
        if (!arquivo.exists()) {
            throw new IOException("Arquivo não encontrado");
        }

        BufferedReader reader = new BufferedReader(new FileReader(arquivo));
        String linha = reader.readLine().toUpperCase();
        reader.close();

        int[] contagem = new int[5]; // [A, C, G, T, Erros]
        int totalCaracteres = linha.length();

        for (char nucleotideo : linha.toCharArray()) {
            switch (nucleotideo) {
                case 'A': contagem[0]++; break;
                case 'C': contagem[1]++; break;
                case 'G': contagem[2]++; break;
                case 'T': contagem[3]++; break;
                default: contagem[4]++; break;  // Qualquer outro caractere é considerado um erro
            }
        }

        // Verifica se mais de 10% dos caracteres são inválidos
        if ((double) contagem[4] / totalCaracteres > 0.1) {
            return null;
        }

        return contagem;
    }
}
