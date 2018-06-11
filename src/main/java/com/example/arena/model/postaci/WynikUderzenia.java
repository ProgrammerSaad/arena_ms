package com.example.arena.model.postaci;

public class WynikUderzenia {

    private int sumaObrazen;

    private CzesciCialaEnum miejsceTrafienia;

    public WynikUderzenia(int sumaObrazen, CzesciCialaEnum miejsceTrafienia) {
        this.sumaObrazen = sumaObrazen;
        this.miejsceTrafienia = miejsceTrafienia;
    }

    public int getSumaObrazen() {
        return sumaObrazen;
    }

    public CzesciCialaEnum getMiejsceTrafienia() {
        return miejsceTrafienia;
    }
}
