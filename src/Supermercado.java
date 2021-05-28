import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Supermercado {

    public static void excluiGravacao() {
        boolean a, b, c;
        File nameFile = new File("save\\nome.txt");
        File codeFile = new File("save\\codigos.txt");
        File valueFile = new File("save\\valores.txt");

        a = nameFile.delete();
        b = codeFile.delete();
        c = valueFile.delete();

        if (a && b && c) {
            System.out.println("Lista excluida com sucesso");
        } else {
            System.out.println("Nao existe lista a ser excluida");
        }

    }

    public static void gravacao(Produtos[] vetor) throws IOException {
        SalvaArquivo save = new SalvaArquivo(vetor);
        save.salvar(vetor);
    }

    public static void leitura(Produtos[] vetor) {
        LeArquivo ler = new LeArquivo(vetor);
        ler.lerArquivo(vetor);

    }

    public static void excluiPeloCodigo(Produtos[] vetor) {
        String codigo;
        int i, achou = 0;

        System.out.println("Digite o codigo do produto a ser excluido: ");
        codigo = new Scanner(System.in).nextLine();

        for (i = 0; i < vetor.length; i++) {
            if (vetor[i] != null) {
                if (vetor[i].getCodigoDeBarras().equals(codigo)) {
                    vetor[i] = null;
                    achou = 1;
                }
            }

        }
        if (achou == 1) System.out.println("Produto excluido");
        else System.out.println("Nenhum produto com esse codigo foi encontrado");
    }

    public static void excluiPeloNome(Produtos[] vetor) {
        String nome;
        int i, achou = 0;

        System.out.println("Digite o nome do produto a ser excluido: ");

        nome = new Scanner(System.in).nextLine();

        for (i = 0; i < vetor.length; i++) {

            if (vetor[i] != null) {
                if (vetor[i].getNome().equals(nome)) {
                    vetor[i] = null;
                    achou = 1;
                }
            }

        }
        if (achou == 1) System.out.println("Produto excluido");
        else System.out.println("Nenhum produto com esse nome foi encontrado");
    }

    public static void excluiProdutoMenu(Produtos[] vetor) {
        int op;
        System.out.println("Digite 1 para excluir pelo nome e\n" +
                "2 para excluir pelo codigo \n");
        op = new Scanner(System.in).nextInt();

        if (op == 1) excluiPeloNome(vetor);
        else if (op == 2) excluiPeloCodigo(vetor);
        else System.out.println("Opcao invalida");

    }

    public static void listaProdutos(Produtos[] vetor) {
        int i;
        boolean foi = false;
        System.out.println("===================================");
        for (i = 0; i < vetor.length; i++) {


            if (vetor[i] != null) {
                System.out.println("Produto: " + vetor[i].getNome());
                System.out.println("Valor: R$ " + vetor[i].getValor());
                System.out.println("Codigo: " + vetor[i].getCodigoDeBarras());
                System.out.println("===================================");
                foi = true;
            }
        }
        if (!foi) {

            System.out.println("Nenhum produto foi encontrado");
            System.out.println("===================================");

        }


    }

    public static void resetaLista(Produtos[] vetor) {
        int i;
        for (i = 0; i < vetor.length; i++) {
            if (vetor[i] != null) {
                vetor[i] = null;
            }
        }
    }

    public static void cadastroProduto(Produtos[] vetor) {
        int i = 0;
        while (true) {
            if (i > vetor.length) {
                System.out.println("Vetor cheio, limpe o vetor antes de cadastrar mais produtos");
            }

            if (vetor[i] == null) {
                Produtos novoProduto = new Produtos();
                System.out.println("Digite o nome do produto");
                novoProduto.setNome(new Scanner(System.in).nextLine());

                System.out.println("Digite o valor do produto");
                novoProduto.setValor(new Scanner(System.in).nextLine());

                System.out.println("Digite o codigo do produto");
                novoProduto.setCodigoDeBarras(new Scanner(System.in).nextLine());

                vetor[i] = novoProduto;

                System.out.println("Produto cadastrado");
                break;
            } else i++;

        }
    }

    public static void menuSave(Produtos[] vetor) throws IOException {

        int op;
        System.out.println("Digite 1 para salvar a lista,\n" +
                "2 para recuperar a lista salva e\n" +
                "3 para excluir a lista salva");
        op = new Scanner(System.in).nextInt();

        switch (op) {
            case 1:
                gravacao(vetor);
                break;
            case 2:
                leitura(vetor);
                break;
            case 3:
                excluiGravacao();
                break;
            default:
                System.out.println("Opcao indisponivel");
        }

    }

    public static void main(String[] args) throws IOException {

        Produtos[] vetor = new Produtos[1024];
        int op;
        while (true) {

            System.out.println("Digite: \n" +
                    "1 para cadastrar, \n" +
                    "2 para mostrar os produtos cadastrados, \n" +
                    "3 para menu de save, \n" +
                    "4 para excluir um produto da lista, \n" +
                    "5 para excluir a lista de produtos e \n" +
                    "6 para sair");

            op = new Scanner(System.in).nextInt();

            switch (op) {
                case 1:
                    cadastroProduto(vetor);
                    break;
                case 2:
                    listaProdutos(vetor);
                    break;
                case 3:
                    menuSave(vetor);
                    break;
                case 4:
                    excluiProdutoMenu(vetor);
                    break;
                case 5:
                    resetaLista(vetor);
                    break;
                case 6:
                    System.exit(1);
                default:
                    System.out.println("Opcao invalida");
            }
        }

    }
}
