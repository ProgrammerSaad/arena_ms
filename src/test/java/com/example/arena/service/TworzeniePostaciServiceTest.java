package com.example.arena.service;

import com.example.arena.model.postaci.Czlowiek;
import com.example.arena.model.postaci.Humanoid;
import com.example.arena.model.postaci.Istota;
import com.example.arena.model.postaci.TypPostaciEnum;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TworzeniePostaciServiceTest {

    @Test
    public void funkcjaLosowaniaNieZwracaWartosciZprzedzialuPodanegoWparametrach() {
        //given
        int min = 0;
        int max = 5;
        //when
        int wynik = TworzeniePostaciService.losuj(min, max);
        //then
        Assert.assertFalse(wynik < min || wynik > max);
    }

    @Test
    public void funckjaLosowaniaZwracaWartoscZPrzedzialuPodanegoWparametrach() {
        //given
        int min = 0;
        int max = 5;
        //when
        int wynik = TworzeniePostaciService.losuj(min, max);
        //then
        Assert.assertTrue(wynik >= min && wynik <= max);
    }

    @Test
    public void funckjaStworzIstoteZwracaIstote() {
        //given
        TypPostaciEnum typPostaci = TypPostaciEnum.CZLOWIEK;
        TworzeniePostaciService tps = new TworzeniePostaciService();
        //when
        Istota wynik = tps.stworzIstote(typPostaci);
        //then
        Assert.assertNotNull(wynik);
        Assert.assertTrue(wynik instanceof Humanoid);
        Assert.assertTrue(wynik instanceof Czlowiek);
        Assert.assertEquals(TypPostaciEnum.CZLOWIEK, wynik.getTypPostaci());
        Assert.assertNotNull(wynik.getSila());
        Assert.assertNotNull(wynik.getZwinnosc());
        Assert.assertNotNull(wynik.getInicjatywa());
        Assert.assertNotNull(wynik.getWytrzymalosc());
        Assert.assertNotNull(wynik.getSzybkosc());
        Assert.assertNotNull(wynik.getEkwipunekPostaci());
        Assert.assertNotNull(wynik.getIloscAtakow());
        Assert.assertNotNull(wynik.getIloscUnikow());
        Assert.assertNotNull(wynik.getBron());
        Assert.assertNotNull(wynik.getAktywnyPancerz());
        Assert.assertNotNull(wynik.getName());
        Assert.assertNotNull(wynik.getId());

    }

    @Test
    public void CzyTworzaSieWszystkieTypyPostaci() {
        //given
        TworzeniePostaciService tps = new TworzeniePostaciService();
        List<Istota> listaPostaci = new ArrayList<>();
        TypPostaciEnum[] tablicaTypowPostaci = TypPostaciEnum.values();
        List<TypPostaciEnum> typyPostaci = Arrays.asList(tablicaTypowPostaci);
        //when
        for (TypPostaciEnum typyIstoty : typyPostaci) {
            listaPostaci.add(tps.stworzIstote(typyIstoty));
        }
        //then
        for (Istota postac : listaPostaci) {
            Assert.assertTrue(typyPostaci.contains(postac.getTypPostaci()));
        }
        Assert.assertEquals(listaPostaci.size(), typyPostaci.size());
    }

    /*@Test
    public void funkcjaSprawdzaCzyJestBronIPancerzHumanoid() {
        //given
        TworzeniePostaciService tps = new TworzeniePostaciService();
        TypPostaciEnum typPostaci = TypPostaciEnum.ELF;
        Bron bron = new Bron(2,5, BronEnum.MIECZ, TypyBroniEnum.HUM_BIALA_JEDNORECZNA, RodzajAtakuEnum.UDERZENIE);
        //when
        Istota wynik = tps.stworzIstote(typPostaci);
        //then
        Assert.assertNotNull(wynik.getAktywnyPancerz());
        Assert.assertNotNull(wynik.getBron());
        Assert.assertTrue(wynik.getBron().getBronEnum() == BronEnum.MIECZ);
        Assert.assertTrue(wynik.getAktywnyPancerz().contains(PancerzEnum.ZBROJA));
        Assert.assertTrue(wynik.getEkwipunekPostaci().getPancerzEnum().contains(PancerzEnum.ZBROJA));
        Assert.assertTrue(wynik.getEkwipunekPostaci().getListaPosiadanychBroni().contains(bron));
    }*/

    /*@Test
    public void funkcjaSprawdzaCzyJestBronIPancerzZwierzak() {
        //given
        TworzeniePostaciService tps = new TworzeniePostaciService();
        TypPostaciEnum typPostaci = TypPostaciEnum.TYGRYS;
        //when
        Istota wynik = tps.stworzIstote(typPostaci);
        //then
        Assert.assertNotNull(wynik.getAktywnyPancerz());
        Assert.assertNotNull(wynik.getBron());
        Assert.assertTrue(wynik.getBron().getBronEnum() == BronEnum.PAZURY);
        Assert.assertTrue(wynik.getAktywnyPancerz().contains(PancerzEnum.ZBROJASAMURAJSKA));
        Assert.assertTrue(wynik.getEkwipunekPostaci().getPancerzEnum().contains(PancerzEnum.ZBROJASAMURAJSKA));
        Assert.assertTrue(wynik.getEkwipunekPostaci().getListaPosiadanychBroni().contains(BronEnum.PAZURY));
    }*/

}
