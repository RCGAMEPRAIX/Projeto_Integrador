package exception;

public class EstoqueInsuficienteException extends Exception {

    private double saldoDisponivel;

    public EstoqueInsuficienteException(String mensagem, double saldoDisponivel) {
        super(mensagem);
        this.saldoDisponivel = saldoDisponivel;
    }

    public double getSaldoDisponivel() {
        return saldoDisponivel;
    }
}