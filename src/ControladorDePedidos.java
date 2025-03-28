import java.util.List;

public class ControladorDePedidos {

  public Pedido criarPedido(Cliente cliente, Estabelecimento estabelecimento, List<ItemPedido> itens) {
    Pedido pedido = new Pedido(cliente, estabelecimento, itens);
    pedido.calcularTotal();
    estabelecimento.registrarPedido(pedido);
    return pedido;
  }

  public void atualizarStatusPedido(Pedido pedido, String status) {
    pedido.atualizarStatus(status);
  }

  public void atribuirEntregador(Pedido pedido, Entregador entregador) {
    pedido.setEntregador(entregador);
    pedido.atualizarStatus("Em rota");
    entregador.adicionarPedido(pedido);
  }

  public boolean processarPagamento(Pedido pedido, MetodoPagamento pagamento) {
    float valor = pedido.getValorTotal();
    boolean pago = pagamento.processar(valor);
    if (pago) {
      pedido.atualizarStatus("Pago");
    }
    return pago;
  }

  public float calcularTaxaEntrega(Pedido pedido) {
    // Exemplo simples: R$5 fixo
    return 5.0f;
  }
}