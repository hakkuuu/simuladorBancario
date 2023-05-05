package com.example.prueba;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import mundo.SimuladorBancario;

import java.net.URL;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import java.lang.Double;


public class AppController implements Initializable {
    public TextField txtnombre;
    public TextField txtcedula;
    public Label lbltipocliente;
    public Button btnconsignarAhorros;
    public Button btnretirarAhorros;
    public TextField txtsaldoAhorros;
    public Label lblpuntos;
    public TextField txtsaldoCorriente;
    public Button btnconsignarCorriente;
    public Button btnretirarCorriente;
    public TextField txtsaldoCDT;
    public Button btnabrirCDT;
    public Button btncerrarCDT;
    public TextField txtmes;
    public Button btnavanzarMes;
    public TextField txttotal;
    public Button btnopcion1;
    public Button btnopcion2;
    public AnchorPane PanelImagen;
    public AnchorPane PanelInfo;

    public SimuladorBancario cuenta;

    public void btnconsignarAhorros_click(ActionEvent actionEvent) {
        try{
            String strvalor = JOptionPane.showInputDialog("Ingrese el monto a consignar");
            if (strvalor != null) {
                double monto = Double.parseDouble(strvalor);
                if (monto > 0){
                    cuenta.consignarCuentaAhorros(monto);
                    actualizar();
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Caracter invalido!");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Caracter invalido!");

        }
    }

    public void btnretirarAhorros_click(ActionEvent actionEvent) {
        try{
            String strValor = JOptionPane.showInputDialog("Ingrese el monto a retirar");
            if (strValor != null) {
                double monto = Double.parseDouble(strValor);

                if ((cuenta.getAhorros().getSaldo() - monto) > 0){
                    cuenta.retirarCuentaAhorros(monto);
                    actualizar();
                } else {
                    JOptionPane.showMessageDialog(null, "No tiene saldo suficiente ");
                }
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Caracter invalido!");

        }
    }

    public void btnconsignarCorriente_click(ActionEvent actionEvent) {
        try{
            String strvalor = JOptionPane.showInputDialog("Ingrese el monto a consignar");
            if (strvalor != null) {
                double monto = Double.parseDouble(strvalor);
                if (monto > 0){
                    cuenta.consignarCuentaCorriente(monto);
                    actualizar();
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Caracter invalido!");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Caracter invalido!");

        }
    }

    public void btnretirarCorriente_click(ActionEvent actionEvent) {
        try{
            String strValor = JOptionPane.showInputDialog("Ingrese el monto a retirar");
            if (strValor != null) {
                double monto = Double.parseDouble(strValor);

                if ((cuenta.getCorriente().getSaldo() - monto) > 0){
                    cuenta.retirarCuentaCorriente(monto);
                    actualizar();
                } else {
                    JOptionPane.showMessageDialog(null, "No tiene saldo suficiente ");
                }
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Caracter invalido!");

        }
    }

    public void btnabrirCDT_click(ActionEvent actionEvent) {
        try{
            String strValor = JOptionPane.showInputDialog(null, "Ingrese el monto a invertir");
            String strInteres = JOptionPane.showInputDialog(null,"Introduzca el interes pactado");
            String strMes = JOptionPane.showInputDialog(null,"Introduzca el mes de apertura");
            if ((strValor != null) && (strInteres != null) && (strMes != null)) {
                double monto = Double.parseDouble(strValor);
                double interes = Double.parseDouble(strInteres);
                int mes = Integer.parseInt(strMes);

                if ((monto > 0) && (mes >= 1 && mes <= 12)) {
                    cuenta.invertirCDT(monto, interes, mes);
                    actualizar();
                } else {
                    JOptionPane.showMessageDialog(null, "Verifique que los datos ingresados sean validos ");
                }
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Caracter invalido!");

        }
    }


    public void btncerrarCDT_click(ActionEvent actionEvent) {
    }

    public void btnavanzarMes_click(ActionEvent actionEvent) {
    }

    public void actualizar(){
        String nombre = cuenta.getNombre();
        String cedula = cuenta.getCedula();

        txtnombre.setText(nombre);
        txtcedula.setText(cedula);
        txtmes.setText("" + cuenta.getMesActual());
        txttotal.setText(formatearValor( cuenta.calcularSaldoTotal( ) ));
        txtsaldoCorriente.setText(formatearValor(cuenta.getCorriente().getSaldo()));
        txtsaldoAhorros.setText(formatearValor(cuenta.getAhorros().getSaldo()) + " ["+(cuenta.getAhorros().getInteresMensual()*100)+ "%]");
        txtsaldoCDT.setText(formatearValor( cuenta.getInversion().calcularValorPresente( cuenta.getMesActual( ) ) ) + "   [" + ( cuenta.getInversion().getInteresMensual() * 100 ) + "%]" );
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("View is nos loaded!");
        actualizar();
    }


    public AppController (){
        LocalDate fecact = LocalDate.now();
        int mes = fecact.getMonthValue();
        cuenta = new SimuladorBancario( "50.152.468", "Sergio Lopez");
    }

    /** Utilidad de formateo de valores */
    private String formatearValor( double pValor )
    {
        DecimalFormat df = ( DecimalFormat ) NumberFormat.getInstance( );
        df.applyPattern( "$ ###,###.##" );
        df.setMinimumFractionDigits( 2 );
        return df.format( pValor );
    }

}
