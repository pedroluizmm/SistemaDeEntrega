public class PagamentoCartao implements MetodoPagamento {
    private String numero;
    private String validade;
    private int cvv;

    public PagamentoCartao(String numero, String validade, int cvv) {
        this.numero = numero;
        this.validade = validade;
        this.cvv = cvv;
    }

    @Override
    public boolean realizarPagamento(float valor, String nomeCliente) {
        System.out.println("Processando pagamento com Cartão de R$" + valor + " para " + nomeCliente);
        return true; // Simula sucesso
    }
}
