import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
    private MetodoPagamento formaDePagamento;
    private List<Pedido> pedidos;

    public Cliente(String nome, String telefone, String email, String endereco, int idade, String cpf,
                   MetodoPagamento formaDePagamento) {
        super(nome, telefone, email, endereco, idade, cpf);
        this.formaDePagamento = formaDePagamento;
        this.pedidos = new ArrayList<>();
    }

    public Pedido fazerPedido(List<ItemPedido> itens, Estabelecimento estabelecimento) {
        Pedido pedido = new Pedido(this, estabelecimento, itens);
        pedidos.add(pedido);
        estabelecimento.registrarPedido(pedido);
        return pedido;
    }

    public List<Pedido> listarPedidos() {
        return pedidos;
    }

    public void adicionarPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public MetodoPagamento getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(MetodoPagamento formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }
}
