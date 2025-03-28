public class PagamentoCartao implements MetodoPagamento {
  private String numeroCartao;
  private String validade;
  private int cvv;

  public PagamentoCartao(String numeroCartao, String validade, int cvv) {
      this.numeroCartao = numeroCartao;
      this.validade = validade;
      this.cvv = cvv;
  }

  @Override
  public boolean processar(float valor) {
      
      System.out.println("Processando pagamento CARTÃO de R$" + valor + " no cartão " + numeroCartao);
      return true; 
  }

  
  public String getNumeroCartao() {
      return numeroCartao;
  }
  public void setNumeroCartao(String numeroCartao) {
      this.numeroCartao = numeroCartao;
  }

  public String getValidade() {
      return validade;
  }
  public void setValidade(String validade) {
      this.validade = validade;
  }

  public int getCvv() {
      return cvv;
  }
  public void setCvv(int cvv) {
      this.cvv = cvv;
  }
}