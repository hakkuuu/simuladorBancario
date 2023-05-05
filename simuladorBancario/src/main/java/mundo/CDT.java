package mundo;

public class CDT {
    //VARIABLES
    private double valorIntertido;

    private double interesMensual;

    private int mesApertura;

    public CDT(double valorIntertido, double interesMensual, int mesApertura) {
        this.valorIntertido = valorIntertido;
        this.interesMensual = interesMensual;
        this.mesApertura = mesApertura;
    }

    public CDT() {
        this.valorIntertido = 0;
        this.interesMensual = 0;
        this.mesApertura = 0;
    }

    public double getValorIntertido() {
        return valorIntertido;
    }

    public void setValorIntertido(double valorIntertido) {
        this.valorIntertido = valorIntertido;
    }

    public double getInteresMensual() {
        return interesMensual;
    }

    public void setInteresMensual(double interesMensual) {
        this.interesMensual = interesMensual;
    }

    public int getMesApertura() {
        return mesApertura;
    }

    public void setMesApertura(int mesApertura) {
        this.mesApertura = mesApertura;
    }

    public void invertir (double valorIntertido, double interesMensual, int mesApertura) {
        this.valorIntertido = valorIntertido;
        this.interesMensual = interesMensual;
        this.mesApertura = mesApertura;
    }

    public double calcularValorPresente(int pMesActual) {
        int mesesTranscurridos = pMesActual - mesApertura;
        return (double) ((valorIntertido + (mesesTranscurridos * interesMensual * valorIntertido)));
    }

    public double cerrar(int pMesActual) {
        double valorCierre = calcularValorPresente(pMesActual);
        valorIntertido = 0;
        interesMensual = 0;
        mesApertura = 0;
        return valorCierre;
    }




}
