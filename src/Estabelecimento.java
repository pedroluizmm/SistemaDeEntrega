import java.util.ArrayList;
import java.util.List;

public class Estabelecimento {
  private String nome;
  private String cnpj;
  private String categoria;
  private List<Pedido> pedidos;

  public Estabelecimento(String nome, String cnpj, String categoria) {
    this.nome = nome;
    this.cnpj = cnpj;
    this.categoria = categoria;
    this.pedidos = new ArrayList<>();
  }

  public void registrarPedido(Pedido pedido) {
    pedidos.add(pedido);
  }

  public List<Pedido> getPedidos() {
    return pedidos;
  }

  public void listarPedidosDetalhado() {
    if (pedidos.isEmpty()) {
      System.out.println("Nenhum pedido registrado.");
      return;
    }

    for (int i = 0; i < pedidos.size(); i++) {
      Pedido p = pedidos.get(i);
      System.out.println("[" + (i + 1) + "] Pedido ID: " + p.getId() +
          ", Cliente: " + p.getCliente().getNome() +
          ", Total: R$ " + p.getValorTotal() +
          ", Status: " + p.getStatus());
    }
  }

  // Getters e Setters
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }
}
