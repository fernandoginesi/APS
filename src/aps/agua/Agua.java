package aps.agua;

import aps.banco.bdAgua;
import java.util.ArrayList;

public class Agua extends bdAgua {

    protected ArrayList<Double> media = new ArrayList();
    private String mesConta;
    private double valorConta;
    private double valorCal;
    private double valorAgua;
    private double valorEsgoto;
    private double valorTotal;

    private int litros;
    private double horas;
    private int dias;

    public double mediaConsumo() {
        this.media = this.select();
        double somaValores = 0;

        for (int i = 0; i < this.media.size(); i++) {
            try {
                somaValores += this.media.get(i);
            } catch (Exception e) {
            }
        }
        return somaValores / (this.media.size() / 2);
    }

    public void setMesValorConta(String mes, double valorConta) {
        setMesConta(mes);
        setValorConta(valorConta);
    }

    public double calcConsumo(int litros) {
        setLitros(litros);
        setValorAgua(getValorAgua());
        setValorEsgoto(getValorEsgoto());
        setValorCal(valorCal);
        setValorTotal(valorTotal);

        //0 a 10 mil litros
        if (this.litros >= 0 && this.litros <= 10) {
            this.valorAgua = 24.79;
            this.valorEsgoto = this.getValorAgua() * 0.8;
            this.valorTotal = this.getValorAgua() + this.getValorEsgoto();
        }
        //11 a 20 mil litros
        if (this.litros >= 11 && this.litros <= 20) {
            this.valorAgua = 24.79 + this.litros * 3.10;
            this.valorEsgoto = this.getValorAgua() * 0.8;
            this.valorTotal = this.getValorAgua() + this.getValorEsgoto();
        }

        //21 a 30 litros
        if (this.litros >= 21 && this.litros <= 30) {
            this.valorAgua = 24.79 + 31 + this.litros * 4;
            this.valorEsgoto = this.getValorAgua() * 0.8;
            this.valorTotal = this.getValorAgua() + this.getValorEsgoto();
        }

        //31 a 50 litros
        if (this.litros >= 31 && this.litros <= 50) {
            this.valorAgua = 24.79 + 31 + 40 + this.litros * 5.40;
            this.valorEsgoto = this.getValorAgua() * 0.8;
            this.valorTotal = this.getValorAgua() + this.getValorEsgoto();
        }

        //51 a 100 litros
        if (this.litros >= 51 && this.litros <= 100) {
            this.valorAgua = 24.79 + 31 + this.litros * 4;
            this.valorEsgoto = this.getValorAgua() * 0.8;
            this.valorTotal = this.getValorAgua() + this.getValorEsgoto();
        }

        return valorTotal;

    }

    /**
     * @return the mesConta
     */
    public String getMesConta() {
        return mesConta;
    }

    /**
     * @param mesConta the mesConta to add
     */
    public void setMesConta(String mesConta) {
        this.mesConta = mesConta;
    }

    /**
     * @return the valorConta
     */
    public double getValorConta() {
        return valorConta;
    }

    /**
     * @param valorConta the valorConta to add
     */
    public void setValorConta(double valorConta) {
        this.valorConta = valorConta;
    }

    /**
     * @return the whatts
     */
    public int getLitros() {
        return litros;
    }

    /**
     * @param litros the whatts to set
     */
    public void setLitros(int litros) {
        this.litros = litros;
    }

    /**
     * @return the dias
     */
    public int getDias() {
        return dias;
    }

    /**
     * @param dias the dias to set
     */
    public void setDias(int dias) {
        this.dias = dias;
    }

    public double getValorTotal(double valorTotal) {
        return valorTotal;
    }

    void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    private void setValorAgua(double valorAgua) {
        this.valorAgua = valorAgua;
    }

    private void setValorEsgoto(double valorEsgoto) {
        this.valorEsgoto = valorEsgoto;
    }

    private void setValorCal(double valorCal) {
        this.valorCal = valorCal;
    }

    /**
     * @return the valorEsgoto
     */
    public double getValorEsgoto() {
        return valorEsgoto;
    }

    /**
     * @return the valorAgua
     */
    public double getValorAgua() {
        return valorAgua;
    }

}
