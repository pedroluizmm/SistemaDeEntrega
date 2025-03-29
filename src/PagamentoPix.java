public class PagamentoPix implements MetodoPagamento {
    private String chavePix;
    private String titular;

    public PagamentoPix(String chavePix, String titular) {
        this.chavePix = chavePix;
        this.titular = titular;
    }

    @Override
    public boolean realizarPagamento(float valor, String nomeCliente) {
        System.out.println("Processando pagamento PIX de R$" + valor + " para " + nomeCliente);
        return true; // Simula sucesso
    }
}
