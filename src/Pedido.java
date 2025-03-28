import java.util.List;

public class Pedido {

    private int id;
    private int data;
    private int quantidadePedido;
    private String status;
    private float valorTotal;
    private Usuario cliente;
    private Estabelecimento estabelecimento;
    private List<ItemPedido> itens;
    private Entregador entregador;

    public Pedido(List<ItemPedido> itens) {

    }
}
