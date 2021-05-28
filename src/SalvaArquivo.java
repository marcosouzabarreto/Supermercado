import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class SalvaArquivo {
    Produtos[] vetor;

    public SalvaArquivo(Produtos[] vetor) {
        this.vetor = vetor;
    }

    public void salvar (Produtos[] vetor) throws IOException {
        int i;
        String[] nomes = new String[vetor.length];
        String[] codigos = new String[vetor.length];
        String[] valor = new String[vetor.length];

        for (i = 0; i < vetor.length; i++) {
            if (vetor[i] != null) {
                nomes[i] = vetor[i].getNome();
                codigos[i] = vetor[i].getCodigoDeBarras();
                valor[i] = vetor[i].getValor();
            }
        }

        FileWriter arqNomes = new FileWriter("save\\nome.txt", true);
        FileWriter arqCodigos = new FileWriter("save\\codigos.txt", true);
        FileWriter arqValores = new FileWriter("save\\valores.txt", true);

        PrintWriter gravarNomes = new PrintWriter(arqNomes);
        PrintWriter gravarCodigos = new PrintWriter(arqCodigos);
        PrintWriter gravarValores = new PrintWriter(arqValores);

        for (i = 0; i < nomes.length; i++){
            if (nomes[i] != null) gravarNomes.println(nomes[i]);
        }
        for (i = 0; i < codigos.length; i++){
            if (codigos[i] != null) gravarCodigos.println(codigos[i]);
        }
        for (i = 0; i < valor.length; i++){
            if (valor[i] != null) gravarValores.println(valor[i]);
        }
        arqNomes.close();
        arqCodigos.close();
        arqValores.close();

    }

}
