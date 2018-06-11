package com.example.arena.model.wyposazenie;

import com.example.arena.model.postaci.CzesciCialaEnum;

import java.util.Set;

public class Pancerz {

    private int punktyPancerza;

    private Set<CzesciCialaEnum> chronioneMiejsce;

    private TypPancerzaEnum typyPancerza;

    private PancerzEnum nazwaPancerza;

    public Pancerz(int punktyPancerza, PancerzEnum nazwaPancerza, TypPancerzaEnum typPancerza, Set<CzesciCialaEnum> chronioneMiejsce) {
        this.punktyPancerza = punktyPancerza;
        this.chronioneMiejsce = chronioneMiejsce;
        this.typyPancerza = typPancerza;
        this.nazwaPancerza = nazwaPancerza;
    }

    public int getPunktyPancerza() {
        return punktyPancerza;
    }

    public Set<CzesciCialaEnum> getChronioneMiejsce() {
        return chronioneMiejsce;
    }

    public TypPancerzaEnum getTypyPancerza() {
        return typyPancerza;
    }

    public PancerzEnum getPancerzEnum() {
        return nazwaPancerza;
    }
}
