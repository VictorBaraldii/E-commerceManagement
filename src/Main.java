import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ControladorEcommerce controlador =  new ControladorEcommerce();

        controlador.cadastrarProduto(1, "Notebook", 2500.00, 10);
        controlador.cadastrarProduto(2, "Smartphone", 1500.00, 20);
        controlador.cadastrarProduto(3, "Fone de Ouvido", 200.00, 50);

        while (true) {
            System.out.println("\n1. Listar produtos");
            System.out.println("\n2. Adicionar produto ao carrinho");
            System.out.println("\n3. Finalizar compra");
            System.out.println("\n4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    controlador.listarProdutos();
                    break;
                case 2:
                    System.out.print("Digite o ID do produto: ");
                    int id = scanner.nextInt();
                    System.out.print("Digite a quantidade: ");
                    int quantidade = scanner.nextInt();
                    controlador.adicionarAoCarrinho(id, quantidade);
                    break;
                case 3:
                    controlador.finalizarCompra();
                    break;
                case 4:
                    System.out.println("Encerrando o sistema...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
