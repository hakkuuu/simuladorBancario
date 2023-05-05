package mundo;

public class CuentaCorriente {

    private double saldo;

    public CuentaCorriente(){
        saldo = 0;
    }
    public double getSaldo() {
        return saldo;
    }

    public void consignarMonto(double pMonto) {
        saldo = saldo + pMonto;
    }

    public void retirarMonto(double pMonto) {
        saldo = saldo - pMonto;
    }


}
