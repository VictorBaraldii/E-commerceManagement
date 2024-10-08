import java.util.ArrayList;
import java.util.List;

public class ControladorEcommerce {
    private List<Produto> produtos = new ArrayList<>();
    private Carrinho carrinho = new Carrinho();

    public void cadastrarProduto(int id, String nome, double preco, int estoque) {
        Produto produto = new Produto(id, nome, preco, estoque);
        produtos.add(produto);
        System.out.println("Produto " + nome + " cadastrado com sucesso.");
    }

    public void listarProdutos() {
        produtos.forEach(produto -> System.out.println(produto.getId() + ": " + produto.getNome() + " - R$" + produto.getPreco()));
    }

    public Produto buscarProduto(int id) {
        return produtos.stream()
                .filter(produto -> produto.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void adicionarAoCarrinho(int idProduto, int quantidade) {
        Produto produto = buscarProduto(idProduto);
        if (produto != null) {
            carrinho.adicionarProduto(produto, quantidade);
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void finalizarCompra() {
        System.out.println("Compra finalizada. Itens:");
        carrinho.listarProdutos();
        System.out.println("Total: R$ " + carrinho.calcularTotal());
    }
}
