package aps.Interface.Models;

public class CategoriaAno {

    private String mes;

    public CategoriaAno(String mes) {
        this.mes = mes;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    @Override
    public String toString() {
        return getMes();
    }

}
