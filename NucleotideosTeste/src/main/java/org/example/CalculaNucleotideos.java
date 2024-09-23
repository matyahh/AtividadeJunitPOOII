/*                                                                                                      23/09/24
@Author: Mateus Henrique de Jesus Oliveira && Rithiellen Kariny Alves Maxima
            "Classe que tem o método que recebe uma String
                                 do Arquivo txt"
 */


package org.example;
import java.io.*;
import java.util.*;

public class CalculaNucleotideos {

    public static int[] calculaNucleotideos(String caminhoArquivo) throws IOException {
        File arquivo = new File(caminhoArquivo);
        if (!arquivo.exists()) {
            throw new IOException("Arquivo não encontrado");
        }

        BufferedReader reader = new BufferedReader(new FileReader(arquivo));
        String linha = reader.readLine().toUpperCase();
        reader.close();

        int[] contagem = new int[5]; // A, C, G, T, Erros
        int totalCaracteres = linha.length();

        for (char nucleotideo : linha.toCharArray()) {
            switch (nucleotideo) {
                case 'A': contagem[0]++; break;
                case 'C': contagem[1]++; break;
                case 'G': contagem[2]++; break;
                case 'T': contagem[3]++; break;
                default: contagem[4]++; break;
            }
        }

        if ((double) contagem[4] / totalCaracteres > 0.1) {
            return null;
        }

        return contagem;
    }
}
