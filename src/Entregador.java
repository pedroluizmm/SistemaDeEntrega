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

    public List<Pedido> listarPedidosEntregador() {
        return pedidos;
    }

    public void adicionarPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }

   
    public String getVeiculo() {
        return veiculo;
    }
    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getRg() {
        return rg;
    }
    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCnh() {
        return cnh;
    }
    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public boolean isSeguroVeiculo() {
        return seguroVeiculo;
    }
    public void setSeguroVeiculo(boolean seguroVeiculo) {
        this.seguroVeiculo = seguroVeiculo;
    }

    public String getContaBancaria() {
        return contaBancaria;
    }
    public void setContaBancaria(String contaBancaria) {
        this.contaBancaria = contaBancaria;
    }

    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
}
