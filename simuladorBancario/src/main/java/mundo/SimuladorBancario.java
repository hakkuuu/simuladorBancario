package mundo;

public class SimuladorBancario {
    private String cedula;
    private String nombre;
    private int mesActual;

    private CuentaCorriente corriente;
    private CDT inversion;
    private CuentaAhorros ahorros;

    public SimuladorBancario(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;

        corriente = new CuentaCorriente();
        ahorros = new CuentaAhorros();
        inversion = new CDT();
    }


    /** GETTERS **/
    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public int getMesActual() {
        return mesActual;
    }

    public CuentaCorriente getCorriente() {
        return corriente;
    }

    public CDT getInversion() {
        return inversion;
    }

    public CuentaAhorros getAhorros() {
        return ahorros;
    }

    /** Calcula y retorna el Saldo Total de las cuentas del Cliente */
    public double calcularSaldoTotal() {
        return corriente.getSaldo() + ahorros.getSaldo() + inversion.calcularValorPresente(mesActual);
    }

    /** Invertir en un CDT */
    public void invertirCDT(double pMonto, double pInteresMensual, int pmesActual) {
        inversion.invertir(pMonto, pInteresMensual,pmesActual);
    }

    /** Consignar en cuenta corriente */
    public void consignarCuentaCorriente(double pMonto) {
        corriente.consignarMonto(pMonto);
    }

    /** ConsignarCuenta de ahorros  */
    public void consignarCuentaAhorros(double pMonto) {
        ahorros.consignarMonto(pMonto);
    }

    /** Retirar de la Cuenta Corriente */
    public void retirarCuentaCorriente(double pMonto) {
        corriente.retirarMonto(pMonto);
    }

    /** Retirar un nonto de la cuenta de ahorros */
    public void retirarCuentaAhorros(double pMonto) {
        ahorros.retirarMonto(pMonto);
    }

    /** Simulacion de la inversion */

    public void avanzarMesSimulacion() {
        mesActual += 1;
        ahorros.actualizarSaldoPorPasoMes();
    }

    /** Cerrar CDT */
    public void cerrarCDT() {
        double valorCierreCDT = inversion.cerrar(mesActual);
        ahorros.consignarMonto(valorCierreCDT);
    }

}


