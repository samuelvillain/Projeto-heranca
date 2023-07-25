package application;

import entities.ProdutoImportado;
import entities.Produto;
import entities.ProdutoUsado;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");

        Scanner sc = new Scanner(System.in);

        List<Produto> cadastro = new ArrayList<>();
        int opcao;
        do {
            System.out.println("1 - Cadastro produto ");
            System.out.println("2 - Listar produtos ");
            System.out.println("3 - Fim cadastro ");
            System.out.print("Qual a opção desejada?");
            //System.out.print("Entre com a quantidade de produtos para cadastro: ");
            opcao = sc.nextInt();

            //for (int i = 1; i <= n; i++) {
            //System.out.println("Product #" + i + " data:");
            if (opcao == 1) {
                System.out.print("Qual o tipo do produto (M)anufaturado, (U)sado, (I)mportado)?");
                char tipo = sc.next().charAt(0);
                System.out.print("Nome produto: ");
                String nomeProduto = sc.next();
                System.out.print("Preço produto: ");
                double precoProduto = sc.nextDouble();
                if (tipo == 'm') {
                    cadastro.add(new Produto(nomeProduto, precoProduto));
                } else if (tipo == 'i') {
                    System.out.print("Calculando taxas para importado: ");
                    double taxa = sc.nextDouble();
                    cadastro.add(new ProdutoImportado(nomeProduto, precoProduto, taxa));
                } else if (tipo == 'u') {
                    System.out.print("Qual a data fabricação produto (DD/MM/YYYY): ");
                    Date dataFabricacao = fmt.parse(sc.next());
                    cadastro.add(new ProdutoUsado(nomeProduto, precoProduto, dataFabricacao));
                }

                System.out.println("X");
            } else if (opcao == 2) {
                System.out.println();
                System.out.println("PRICE TAGS:");
                for (Produto produto : cadastro) {
                    System.out.println(produto.princeTag());
                }
            }

        } while (opcao != 3);

        sc.close();
    }
}