package com.example.arena.model.postaci;

import com.example.arena.model.wyposazenie.*;
import com.example.arena.service.TworzeniePostaciService;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

/**
 * Created by Saad on 2018-02-28.
 */
public class Pies extends Zwierzę {

    public Pies() {
        super(TworzeniePostaciService.losuj(1, 2), TworzeniePostaciService.losuj(3, 5), TworzeniePostaciService.losuj(2, 4), TworzeniePostaciService.losuj(2, 5), TworzeniePostaciService.losuj(2, 4),
                TypPostaciEnum.PIES, 1, 1, TworzeniePostaciService.losuj(2, 4), ImmutableList.of(new Bron(1, 3, BronEnum.PAZURY, TypyBroniEnum.ZWIERZECA, RodzajAtakuEnum.UDERZENIE)),
                ImmutableList.of(new Pancerz(1, PancerzEnum.HELM, TypPancerzaEnum.ZWIERZECY_PANCERZ, ImmutableSet.of(CzesciCialaEnum.GLOWA))));
    }
}

//losuj(1, 2), losuj(3, 5), losuj(2, 4), losuj(2, 5), losuj(2, 4), losuj(2, 4),