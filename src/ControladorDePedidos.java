import java.util.List;

public class ControladorDePedidos {

  public Pedido criarPedido(Cliente cliente, Estabelecimento estabelecimento, List<ItemPedido> itens) {
    Pedido pedido = new Pedido(cliente, estabelecimento, itens);
    cliente.adicionarPedido(pedido);
    estabelecimento.registrarPedido(pedido);
    return pedido;
  }

  public void adicionarItem(Pedido pedido, ItemPedido item) {
    pedido.getItens().add(item);
    pedido.calcularTotal();
  }

  public void atualizarStatusPedido(Pedido pedido, String novoStatus) {
    pedido.setStatus(novoStatus);
  }

  public void processarPagamento(Pedido pedido) {
    boolean sucesso = pedido.getCliente()
        .getFormaDePagamento()
        .realizarPagamento(pedido.getValorTotal(), pedido.getCliente().getNome());

    if (sucesso) {
      System.out.println("✅ Pagamento realizado com sucesso!");
    } else {
      System.out.println("❌ Falha no pagamento.");
    }
  }

  public void atribuirEntregador(Pedido pedido, Entregador entregador) {
    if (entregador.estaDisponivel()) {
      entregador.aceitarEntrega(pedido);
      pedido.setEntregador(entregador);
      System.out.println("🚚 Entregador atribuído ao pedido.");
    } else {
      System.out.println("⚠️ Entregador indisponível.");
    }
  }
}
