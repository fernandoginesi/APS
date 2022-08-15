package aps.eletrecidade;

import aps.banco.bdEletrecidade;
import java.util.ArrayList;

public class Eletrecidade extends bdEletrecidade {

    protected ArrayList<Double> media = new ArrayList();

    private int watts;
    private int horas;
    private int dias;
    private double tarifa;

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

    public double calcConsumo(int watts, int horas, int dias, double tarifa) {
        setWatts(watts);
        setHoras(horas);
        setDias(dias);
        setTarifa(tarifa);
        return (((this.watts * this.horas) * this.dias) / 1000) * this.tarifa;
    }

    /**
     * @return the whatts
     */
    public double getWatts() {
        return watts;
    }

    /**
     * @param watts the whatts to set
     */
    public void setWatts(int watts) {
        this.watts = watts;
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
    public void setHoras(int horas) {
        this.horas = horas;
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

    /**
     * @return the tarifa
     */
    public double getTarifa() {
        return tarifa;
    }

    /**
     * @param tarifa the tarifa to set
     */
    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }
}
