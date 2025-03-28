import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {
    private String nome;
    private int Telefone;
    private String email;
    private String endereco;
    private int idade;
    private int cpf;
    private List<Pedido> pedidos;

    public Usuario(String nome, int telefone, String email, String endereco, int idade, int cpf) {
        this.nome = nome;
        Telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.idade = idade;
        this.cpf = cpf;
        this.pedidos = new ArrayList<>();
    }
    
    public List<Pedido> getPedidos() {
        return pedidos;
    }

}