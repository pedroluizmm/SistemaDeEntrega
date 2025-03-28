import java.util.List;

class Cliente extends Usuario{
    private MetodoPagamento formaDePagamento;

    public Cliente(String nome, int telefone, String email, String endereco, int idade, int cpf, MetodoPagamento formaDePagamento) {
        super(nome, telefone, email, endereco, idade, cpf);
        this.formaDePagamento = formaDePagamento;
    }
    
    public Pedido fazerPedido(List<ItemPedido> itens) {
        Pedido novoPedido = new Pedido(itens);
        getPedidos().add(novoPedido);
        return novoPedido;
    }
}