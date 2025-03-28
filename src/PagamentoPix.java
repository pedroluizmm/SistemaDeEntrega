public class PagamentoPix implements MetodoPagamento {
  private String chavePix;
  private String titular;

  public PagamentoPix(String chavePix, String titular) {
      this.chavePix = chavePix;
      this.titular = titular;
  }

  @Override
  public boolean processar(float valor) {
      
      System.out.println("Processando pagamento PIX de R$" + valor + " para " + titular);
      return true; 
  }

 
  public String getChavePix() {
      return chavePix;
  }
  public void setChavePix(String chavePix) {
      this.chavePix = chavePix;
  }

  public String getTitular() {
      return titular;
  }
  public void setTitular(String titular) {
      this.titular = titular;
  }
}