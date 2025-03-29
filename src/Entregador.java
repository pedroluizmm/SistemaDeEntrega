import java.util.ArrayList;
import java.util.List;

public class Entregador extends Usuario {
    private String veiculo;
    private String rg;
    private String cnh;
    private boolean seguroVeiculo;
    private String contaBancaria;
    private boolean status; 
    private List<Pedido> pedidos;

    public Entregador(String nome, String telefone, String email, String endereco, int idade, String cpf,
                      String veiculo, String rg, String cnh, boolean seguroVeiculo, String contaBancaria) {
        super(nome, telefone, email, endereco, idade, cpf);
        this.veiculo = veiculo;
        this.rg = rg;
        this.cnh = cnh;
        this.seguroVeiculo = seguroVeiculo;
        this.contaBancaria = contaBancaria;
        this.status = true;
        this.pedidos = new ArrayList<>();
    }

    public boolean estaDisponivel() {
        return status;
    }

    public void atualizarDisponibilidade(boolean status) {
        this.status = status;
    }

    public void aceitarEntrega(Pedido pedido) {
        pedidos.add(pedido);
        pedido.setEntregador(this);
    }

    public void atualizarStatusEntrega(Pedido pedido, String novoStatus) {
        pedido.setStatus(novoStatus);
    }

    public List<Pedido> listarPedidosEntregador() {
        return pedidos;
    }

    public float calcularTaxaEntrega(Pedido pedido) {
        return 10.0f; 
    }

    public String getVeiculo() {
        return veiculo;
    }

    public String getRg() {
        return rg;
    }

    public String getCnh() {
        return cnh;
    }

    public boolean isSeguroVeiculo() {
        return seguroVeiculo;
    }

    public String getContaBancaria() {
        return contaBancaria;
    }

    public boolean isStatus() {
        return status;
    }
}
