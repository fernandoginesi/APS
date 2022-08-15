package aps.Interface.Models;

import java.util.Random;
import java.util.Timer;

public class Temporizador {

    public Timer getTimer() {
        return timer;
    }

    private Timer timer;
    private String frase = "";

    public String frases() {
        Random random = new Random();
        int r = random.nextInt(3);
        String[] frases = {"ÁGUA\nNão esqueça de fechar a torneira ao escovar os dentes ou ensaboar as louças, reaproveitar a água da chuva ou da máquina de lavar pode ajudar a economizar água, sempre feche totalmente as torneiras, fique de olho e corrija vazamentos, tente não gastar muito tempo tomando banho, use vassoura em vez de mangueira para limpar o quintal e Lave o carro com balde",
            "ENERGIA\nDesligue as luzes durante o dia, Não passe roupas todos os dias, junte e passe todas de uma vez, Troque as lâmpadas incandescentes por lâmpadas de LED, Evite abrir a porta da geladeira sem necessidade, Eletrodomésticos muito antigos tendem a gastar muita energia, Mantenha as geladeiras o mais afastado possível de uma fonte de calor, Desligue os aparelhos que não estiver usando, Quando usar o ar-condicionado, feche as portas e janelas",
            "GÁS\nCozinhe alimentos duros na panela de pressão, Evite usar o forno várias vezes, sempre aproveite para assar várias comidas de uma vez, Verifique e corrija vazamentos de gás, Verifique se a borracha de vedação do forno está em bom estado, Feche as portas e janelas para que o vento não atrapalhe as chamas do fogão",};
        return frases[r];
    }

    public void timerOpen() {
        timer = new java.util.Timer();
    }

    public void timerClose() {
        getTimer().cancel();
    }

    /* @
    return the frase

     */
    public String getFrase() {
        return frase;
    }

    /**
     * @param frase the frase to set
     */
    public void setFrase(String frase) {
        this.frase = frase;
    }

}
