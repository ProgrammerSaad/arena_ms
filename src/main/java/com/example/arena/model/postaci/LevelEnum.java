package com.example.arena.model.postaci;

import java.util.Map;

import static com.example.arena.model.postaci.ParametryIstotyEnum.*;
import static com.google.common.collect.ImmutableMap.of;

public enum LevelEnum {

    LEVEL1(0, 100, of(SIŁA, 2, PUNKTY_ZYCIA, 4)),
    LEVEL2(101, 500, of(ZWINNOŚĆ, 2, WYTRZYMAŁOŚĆ, 3)),
    LEVEL3(501, 1000, of(INICJATYWA, 2, SZYBKOŚĆ, 4)),
    LEVEL4(1001, 2000, of(SIŁA, 4, PUNKTY_ZYCIA, 2)),
    LEVEL5(2001, 4000, of(ZWINNOŚĆ, 3, WYTRZYMAŁOŚĆ, 2)),
    LEVEL6(4001, 7000, of(INICJATYWA, 4, SZYBKOŚĆ, 2)),
    LEVEL7(7001, 11000, of(ILOSC_ATAKOW, 1, ILOSC_UNIKOW, 1)),
    LEVEL8(11001, 16000, of(SIŁA, 3, PUNKTY_ZYCIA, 3)),
    LEVEL9(16001, 22000, of(ZWINNOŚĆ, 3, WYTRZYMAŁOŚĆ, 3)),
    LEVEL10(22001, 30000, of(INICJATYWA, 3, SZYBKOŚĆ, 3));

    private int minZakresExp;

    private int maxZakresExp;

    private Map<ParametryIstotyEnum, Integer> ulepszeniaPostaci;

    LevelEnum(int minZakresExp, int maxZakresExp, Map<ParametryIstotyEnum, Integer> ulepszeniaPostaci) {
        this.minZakresExp = minZakresExp;
        this.maxZakresExp = maxZakresExp;
        this.ulepszeniaPostaci = ulepszeniaPostaci;
    }

    public int getMinZakresLev() {
        return minZakresExp;
    }

    public int getMaxZakresLev() {
        return maxZakresExp;
    }

    public Map<ParametryIstotyEnum, Integer> getUlepszeniaPostaci() {
        return ulepszeniaPostaci;
    }

}
