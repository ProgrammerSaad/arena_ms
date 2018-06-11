package com.example.arena.model.postaci;

import com.example.arena.model.wyposazenie.*;
import com.example.arena.service.TworzeniePostaciService;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

/**
 * Created by Saad on 2018-03-02.
 */
public class Tygrys extends Zwierzę {

    public Tygrys() {
        super(TworzeniePostaciService.losuj(3, 4), TworzeniePostaciService.losuj(4, 5), TworzeniePostaciService.losuj(3, 5), TworzeniePostaciService.losuj(3, 6), TworzeniePostaciService.losuj(3, 4),
                TypPostaciEnum.TYGRYS, 1, 1, TworzeniePostaciService.losuj(3, 6), ImmutableList.of(new Bron(1, 3, BronEnum.PAZURY, TypyBroniEnum.ZWIERZECA, RodzajAtakuEnum.UDERZENIE)),
                ImmutableList.of(new Pancerz(1, PancerzEnum.HELM, TypPancerzaEnum.ZWIERZECY_PANCERZ, ImmutableSet.of(CzesciCialaEnum.GLOWA))));
    }
}

//losuj(3, 4), losuj(4, 5), losuj(3, 5), losuj(3, 6), losuj(3, 4), losuj(3, 6),