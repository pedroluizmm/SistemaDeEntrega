import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
  private int id;
  private Date data; 
  private String status;
  private float valorTotal;
  private Cliente cliente;
  private Estabelecimento estabelecimento;
  private List<ItemPedido> itens;
  private Entregador entregador;

  
  public Pedido(Cliente cliente, Estabelecimento estabelecimento, List<ItemPedido> itens) {
    this.cliente = cliente;
    this.estabelecimento = estabelecimento;
    this.itens = new ArrayList<>(itens);
    this.data = new Date();
    this.status = "Novo";
    this.valorTotal = 0;
  
  }

  public void adicionarItem(ItemPedido item) {
    if (this.itens == null) {
      this.itens = new ArrayList<>();
    }
    this.itens.add(item);
  }

  public float calcularTotal() {
    float total = 0;
    for (ItemPedido item : itens) {
      total += item.calcularSubtotal();
    }
    this.valorTotal = total;
    return this.valorTotal;
  }

  public void atualizarStatus(String novoStatus) {
    this.status = novoStatus;
  }

 
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getData() {
    return data;
  }

  public void setData(Date data) {
    this.data = data;
  }

  public String getStatus() {
    return status;
  }

  public float getValorTotal() {
    return valorTotal;
  }

  public void setValorTotal(float valorTotal) {
    this.valorTotal = valorTotal;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public Estabelecimento getEstabelecimento() {
    return estabelecimento;
  }

  public void setEstabelecimento(Estabelecimento estabelecimento) {
    this.estabelecimento = estabelecimento;
  }

  public List<ItemPedido> getItens() {
    return itens;
  }

  public void setItens(List<ItemPedido> itens) {
    this.itens = itens;
  }

  public Entregador getEntregador() {
    return entregador;
  }

  public void setEntregador(Entregador entregador) {
    this.entregador = entregador;
  }
}
