package com.example.arena.model.postaci;

public enum CzesciCialaEnum {

    GLOWA(0, 14),
    KORPUS(55, 74),
    NOGA_LEWA(75, 84),
    NOGA_PRAWA(85, 99),
    REKA_PRAWA(15, 34),
    REKA_LEWA(35, 54);

    private int minWartTraf;

    private int maxWartTraf;

    CzesciCialaEnum(int minWartTraf, int maxWartTraf) {
        this.minWartTraf = minWartTraf;
        this.maxWartTraf = maxWartTraf;
    }

    public int getMinWartTraf() {
        return minWartTraf;
    }

    public int getMaxWartTraf() {
        return maxWartTraf;
    }

}
