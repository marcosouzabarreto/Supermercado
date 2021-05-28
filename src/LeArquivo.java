import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class LeArquivo {

    Produtos[] vetor;
    public LeArquivo (Produtos[] vetor) {
        this.vetor = vetor;
    }

    public void lerArquivo(Produtos[] vetor) {
        int i;

        try {
            FileReader arqNome = new FileReader("save\\nome.txt");
            FileReader arqCodigo = new FileReader("save\\codigos.txt");
            FileReader arqValor = new FileReader("save\\valores.txt");

            BufferedReader lerArqNome = new BufferedReader(arqNome);
            BufferedReader lerArqCodigo = new BufferedReader(arqCodigo);
            BufferedReader lerArqValor = new BufferedReader(arqValor);

            String linhaNome = lerArqNome.readLine();
            String linhaCodigo = lerArqCodigo.readLine();
            String linhaValor = lerArqValor.readLine();

            for (i=0; i< vetor.length; i++){
                Produtos novoProduto = new Produtos();

                if ((linhaNome!=null)&&(linhaCodigo!=null)&&(linhaValor!=null)){
                    novoProduto.setNome(linhaNome);
                    novoProduto.setCodigoDeBarras(linhaCodigo);
                    novoProduto.setValor(linhaValor);

                    vetor[i] = novoProduto;

                    linhaNome = lerArqNome.readLine();
                    linhaCodigo = lerArqCodigo.readLine();
                    linhaValor = lerArqValor.readLine();
                }
            }

            arqNome.close();
            arqCodigo.close();
            arqValor.close();

        } catch (FileNotFoundException e){
            System.out.println("Nao existe lista a ser recuperada");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
