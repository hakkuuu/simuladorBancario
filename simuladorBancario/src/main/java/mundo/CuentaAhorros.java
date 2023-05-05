package mundo;

public class CuentaAhorros {

    private double interesMensual;
    private double saldo;

    /** Inicializa la cuenta de ahorros **/
    public CuentaAhorros() {
        saldo = 0;
        interesMensual = 0.006;
    }
    /** Retorna el saldo del cliente **/
    public double getSaldo(){
        return saldo;
    }

    /** Retorna el interes mensual **/
    public double getInteresMensual() {
        return  interesMensual;
    }

    /** Consigna un monto de dinero **/
    public void consignarMonto(double pMonto) {
        saldo = saldo + pMonto;
    }

    /** Retirar una suma de dinero **/
    public void retirarMonto(double pMonto) {
        saldo = saldo - pMonto;
    }

    public void actualizarSaldoPorPasoMes() {
        saldo = saldo + (saldo * interesMensual);
    }

}
