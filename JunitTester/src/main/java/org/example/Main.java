import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Exemplo de caminhos para os arquivos de teste
        String arquivoValido = "sequenciaValida.txt";  // Arquivo com sequência válida
        String arquivoInvalido = "sequenciaInvalida.txt";  // Arquivo com sequência com erros
        String arquivoComFalha = "sequenciaComFalha.txt";  // Arquivo com mais de 10% de erros
        String arquivoNaoExistente = "arquivoNaoExistente.txt";  // Arquivo que não existe

        try {
            // Testa o arquivo válido
            System.out.println("Teste com arquivo válido:");
            int[] resultadoValido = CalculaNucleotideos.calculaNucleotideos(arquivoValido);
            if (resultadoValido != null) {
                System.out.println("Contagem de nucleotídeos: " + Arrays.toString(resultadoValido));
            } else {
                System.out.println("Mais de 10% da sequência é inválida, retornando null.");
            }

            // Testa o arquivo com erros
            System.out.println("\nTeste com arquivo inválido (1 erro):");
            int[] resultadoInvalido = CalculaNucleotideos.calculaNucleotideos(arquivoInvalido);
            if (resultadoInvalido != null) {
                System.out.println("Contagem de nucleotídeos: " + Arrays.toString(resultadoInvalido));
            } else {
                System.out.println("Mais de 10% da sequência é inválida, retornando null.");
            }

            // Testa o arquivo com mais de 10% de erros
            System.out.println("\nTeste com arquivo contendo mais de 10% de erros:");
            int[] resultadoComFalha = CalculaNucleotideos.calculaNucleotideos(arquivoComFalha);
            if (resultadoComFalha != null) {
                System.out.println("Contagem de nucleotídeos: " + Arrays.toString(resultadoComFalha));
            } else {
                System.out.println("Mais de 10% da sequência é inválida, retornando null.");
            }

            // Testa o arquivo não existente
            System.out.println("\nTeste com arquivo não existente:");
            int[] resultadoNaoExistente = CalculaNucleotideos.calculaNucleotideos(arquivoNaoExistente);
            if (resultadoNaoExistente != null) {
                System.out.println("Contagem de nucleotídeos: " + Arrays.toString(resultadoNaoExistente));
            } else {
                System.out.println("Arquivo não encontrado.");
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}

