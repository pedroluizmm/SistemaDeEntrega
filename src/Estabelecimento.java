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
    this.pedidos.add(pedido);
  }

 
  public List<Pedido> listarPedidos() {
    return pedidos;
  }

  
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

  public List<Pedido> getPedidos() {
    return pedidos;
  }

  public void setPedidos(List<Pedido> pedidos) {
    this.pedidos = pedidos;
  }
}
