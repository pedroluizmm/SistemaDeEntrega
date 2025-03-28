class Entregador extends Usuario{

    private String veiculo;
    private String rg;
    private String cnh;
    private boolean seguroVeiculo;
    private String contaBancaria;
    private Boolean status;

    public Entregador(String nome, int telefone, String email, String endereco, int idade, int cpf, String veiculo, String rg, String cnh, boolean seguroVeiculo, String contaBancaria, boolean status) {
        super(nome, telefone, email, endereco, idade, cpf);
        this.veiculo = veiculo;
        this.rg = rg;
        this.cnh = cnh;
        this.seguroVeiculo = seguroVeiculo;
        this.contaBancaria = contaBancaria;
        this.status = status;
    }
}
