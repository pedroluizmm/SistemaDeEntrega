import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private static int contadorId = 1;
    private int id;
    private LocalDateTime data;
    private String status;
    private float valorTotal;
    private Cliente cliente;
    private Estabelecimento estabelecimento;
    private List<ItemPedido> itens;
    private Entregador entregador;

    public Pedido(Cliente cliente, Estabelecimento estabelecimento, List<ItemPedido> itens) {
        this.id = contadorId++;
        this.data = LocalDateTime.now();
        this.status = "Em aberto";
        this.cliente = cliente;
        this.estabelecimento = estabelecimento;
        this.itens = new ArrayList<>(itens);
        this.valorTotal = calcularTotal();
    }

    public float calcularTotal() {
        float total = 0;
        for (ItemPedido item : itens) {
            total += item.calcularSubtotal();
        }
        this.valorTotal = total;
        return total;
    }

    public boolean processarPagamento(MetodoPagamento metodo) {
        return metodo.realizarPagamento(valorTotal, cliente.getNome());
    }

    public void atualizarStatus(String novoStatus) {
        this.status = novoStatus;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public Entregador getEntregador() {
        return entregador;
    }

    public void setEntregador(Entregador entregador) {
        this.entregador = entregador;
    }
}
