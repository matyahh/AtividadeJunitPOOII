import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

public class CalculaNucleotideosTest {

    // Criação dos arquivos de teste
    @BeforeEach
    void setup() throws IOException {
        criaArquivo("sequenciaValida.txt", "AAAGTCTGAC");  // [4, 2, 2, 2, 0]
        criaArquivo("sequenciaInvalida.txt", "AACTGTCGBA"); // [3, 2, 2, 2, 1]
        criaArquivo("sequenciaComFalha.txt", "ABC TEM FALHA"); // null
    }

    // Exclusão dos arquivos de teste
    @AfterEach
    void cleanup() {
        removeArquivo("sequenciaValida.txt");
        removeArquivo("sequenciaInvalida.txt");
        removeArquivo("sequenciaComFalha.txt");
    }

    // Método auxiliar para criar arquivos
    private void criaArquivo(String nomeArquivo, String conteudo) throws IOException {
        FileWriter writer = new FileWriter(nomeArquivo);
        writer.write(conteudo);
        writer.close();
    }

    // Método auxiliar para remover arquivos
    private void removeArquivo(String nomeArquivo) {
        File arquivo = new File(nomeArquivo);
        arquivo.delete();
    }

    // Caso de teste para sequência válida
    @Test
    @DisplayName("Verifica se a contagem de nucleotídeos está correta para sequência válida")
    void testSequenciaValida() throws IOException {
        int[] resultado = CalculaNucleotideos.calculaNucleotideos("sequenciaValida.txt");
        assertArrayEquals(new int[]{4, 2, 2, 2, 0}, resultado);
    }

    // Caso de teste para sequência com erros
    @Test
    @DisplayName("Verifica se o método detecta corretamente um caractere inválido")
    void testSequenciaInvalidaComErro() throws IOException {
        int[] resultado = CalculaNucleotideos.calculaNucleotideos("sequenciaInvalida.txt");
        assertArrayEquals(new int[]{3, 2, 2, 2, 1}, resultado);
    }

    // Caso de teste para sequência inválida (mais de 10% de erros)
    @Test
    @DisplayName("Verifica se o retorno é null quando mais de 10% dos caracteres são inválidos")
    void testSequenciaComFalha() throws IOException {
        int[] resultado = CalculaNucleotideos.calculaNucleotideos("sequenciaComFalha.txt");
        assertNull(resultado);
    }

    // Caso de teste para arquivo inexistente
    @Test
    @DisplayName("Verifica se uma exceção é lançada quando o arquivo não é encontrado")
    void testArquivoNaoEncontrado() {
        Exception exception = assertThrows(IOException.class, () -> {
            CalculaNucleotideos.calculaNucleotideos("arquivoNaoExistente.txt");
        });
        assertEquals("Arquivo não encontrado", exception.getMessage());
    }
}
