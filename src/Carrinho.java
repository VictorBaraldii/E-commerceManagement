import java.util.HashMap;
import java.util.Map;

public class Carrinho {
    private Map<Produto, Integer> itens = new HashMap<>();

    public void adicionarProduto(Produto produto, int quantidade) {
        if (produto.getEstoque() >= quantidade) {
            itens.put(produto, itens.getOrDefault(produto, 0 ) + quantidade);
            produto.setEstoque(produto.getEstoque() - quantidade);
        } else {
            System.out.println("Estoque insuficiente para " + produto.getNome());
        }
    }

    public void removerProduto(Produto produto) {
        if (itens.containsKey(produto)) {
            produto.setEstoque(produto.getEstoque() + itens.get(produto));
            itens.remove(produto);
        }
    }

    public double calcularTotal() {
        return itens.entrySet().stream()
                .mapToDouble(item -> item.getKey().getPreco() * item.getValue())
                .sum();
    }

    public void listarProdutos() {
        itens.forEach((produto, quantidade) -> {
            System.out.println(produto.getNome() + " | Quantidade: " + quantidade + " | Preço: " + produto.getPreco());
        });
    }
}
