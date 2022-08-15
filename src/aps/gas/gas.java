package aps.gas;

import aps.banco.bdGas;
import java.util.ArrayList;

public class gas extends bdGas {

    protected ArrayList<Double> media = new ArrayList();

    private double val;

    private double gas;
    private double horas;

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

    public double calcConsumoGas(double gas, double horas, boolean temGasEncanado) {

        if (temGasEncanado) {
            CalEncanado(gas);//m3 gasto
            setHoras(0);
            return this.val;
        } else {
            setGas(gas);//preço do botijão
            setHoras(horas);

            return (((this.gas / 13) / 5) * this.horas);
        }
    }

    /**
     * @return the gas
     */
    public double getGas() {
        return gas;
    }

    /**
     * @param gas the gas to set
     */
    public void setGas(double gas) {
        this.gas = gas;
    }

    /**
     * @return the horas
     */
    public double getHoras() {
        return horas;
    }

    /**
     * @param horas the horas to set
     */
    public void setHoras(double horas) {
        this.horas = horas;
    }

    private void CalEncanado(double gas) {
        int caso = 0;
        setGas(gas);
        if (this.gas <= 0) {
            caso = 0;
        }
        if (this.gas > 0 && this.gas < 1) {
            caso = 1;
        }
        if (this.gas > 1 && this.gas < 3) {
            caso = 2;
        }
        if (this.gas > 3 && this.gas < 7) {
            caso = 3;
        }
        if (this.gas > 7 && this.gas < 14) {
            caso = 4;
        }
        if (this.gas > 14 && this.gas < 34) {
            caso = 5;
        }
        if (this.gas > 34 && this.gas < 600) {
            caso = 6;
        }
        if (this.gas > 600 && this.gas < 1000) {
            caso = 7;
        }
        if (this.gas > 1000) {
            caso = 8;
        }
        switch (caso) {
            case 0:
                this.val = 0;
                break;
            case 1:
                this.val = 0;
                val = 7.76 + (this.gas * 1.250474);
                break;
            case 2:
                this.val = 0;
                this.val = 1.250474 + 10.14 + ((this.gas - 1) * 6.390850);
                break;
            case 3:
                this.val = 0;
                this.val = 1.250474 + 12.771072 + 10.14 + ((this.gas - 3) * 2.855349);
                break;
            case 4:
                this.val = 0;
                this.val = 1.250474 + 12.771072 + 11.411900 + 11.4 + ((this.gas - 7) * 5.388178);
                break;
            case 5:
                this.val = 0;
                this.val = 1.250474 + 12.771072 + 11.411900 + 37.717246 + 12.67 + ((this.gas - 14) * 6.588202);
                break;
            case 6:
                this.val = 0;
                this.val = 1.250474 + 12.771072 + 11.411900 + 37.717246 + 131.764040 + 12.67 + ((this.gas - 34) * 7.124749);
                break;
            case 7:
                this.val = 0;
                this.val = 1.250474 + 12.771072 + 11.411900 + 37.717246 + 131.764040 + 4032.607934 + 12.67 + ((this.gas - 600) * 6.038274);
                break;
            case 8:
                this.val = 0;
                this.val = 1.250474 + 12.771072 + 11.411900 + 37.717246 + 131.764040 + 4032.607934 + 2414.766155 + 12.67 + ((this.gas - 1000) * 3.975480);
                break;
        }
    }

    public Object[] CalEncanado(Integer valueOf, Integer valueOf0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
