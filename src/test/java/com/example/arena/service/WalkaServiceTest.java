package com.example.arena.service;

import com.example.arena.model.postaci.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Saad on 2018-03-17.
 */
public class WalkaServiceTest {

    @Test
    public void funkcjaSprawdzaPoprawnoscZwyciezcy() {
        //given
        TworzeniePostaciService tps = new TworzeniePostaciService();
        WalkaService ws = new WalkaService();
        List<Istota> listaP = tps.generujListeNowychPostaci(2);
        TypPostaciEnum[] tablicaTypowPostaci = TypPostaciEnum.values();
        List<TypPostaciEnum> typyPostaci = Arrays.asList(tablicaTypowPostaci);
        //when
        Istota zwyciezca = ws.zwyciezca(listaP);
        //then
        Assert.assertNotNull(zwyciezca);
        Assert.assertTrue(typyPostaci.contains(zwyciezca.getTypPostaci()));
    }

    @Test
    public void funkcjaSprawdzaCzyDoZwyciezcyNiePrzychodziPustaLista() {
        //given
        TworzeniePostaciService tps = new TworzeniePostaciService();
        WalkaService ws = new WalkaService();
        List<Istota> pustaLista = new ArrayList<>();
        //when
        Istota zwyciezca = ws.zwyciezca(pustaLista);
        //then
        Assert.assertNull(zwyciezca);
    }

    @Test
    public void funkcjaSprawdzaPoprawnoscTurnieju() {
        //given
        TworzeniePostaciService tps = new TworzeniePostaciService();
        WalkaService ws = new WalkaService();
        List<Istota> listaP = tps.generujListeNowychPostaci(2);
        //when
        Istota zwyciezcaTurnieju = ws.turniej(listaP);
        //then
        Assert.assertNotNull(zwyciezcaTurnieju);
    }

    @Test
    public void funkcjaSprawdzaWylosowanegoWojownika() {
        //given
        TworzeniePostaciService tps = new TworzeniePostaciService();
        WalkaService ws = new WalkaService();
        List<Istota> listaP = tps.generujListeNowychPostaci(2);
        TypPostaciEnum[] tablicaTypowPostaci = TypPostaciEnum.values();
        List<TypPostaciEnum> typyPostaci = Arrays.asList(tablicaTypowPostaci);
        //when
        Istota wylosowany = ws.wylosujWojownika(listaP);
        //then
        Assert.assertNotNull(wylosowany);
        Assert.assertTrue(typyPostaci.contains(wylosowany.getTypPostaci()));
    }

    //Mockito - Czy RundaWalki działa popawnie - atakujacy i ofiara dostaja obrazenia i zadaja cios

    @Test
    public void funkcjaSprawdzaRundeWalki() {
        //given
        TworzeniePostaciService tps = new TworzeniePostaciService();
        WalkaService ws = new WalkaService();
        Istota atakujacy = tps.stworzIstote(TypPostaciEnum.CZLOWIEK);
        Istota ofiara = tps.stworzIstote(TypPostaciEnum.ORK);
        //when
        ws.rundaWalki(atakujacy, ofiara);
        //then
        Assert.assertNotNull(atakujacy);
        Assert.assertNotNull(ofiara);
        Assert.assertTrue(atakujacy.getIloscAtakow() >= 0);
        Assert.assertTrue(atakujacy.getPunktyZycia() >= 0);
        Assert.assertTrue(ofiara.getIloscAtakow() >= 0);
        Assert.assertTrue(ofiara.getPunktyZycia() >= 0);
        Assert.assertTrue(atakujacy.getIloscAtakow() == 1);
        Assert.assertTrue(atakujacy.getIloscUnikow() == 1);
    }

    @Test
    public void funkcjaSprawdzaRundeWalkiOfiaraMaZeroZycia() {
        //given
        TworzeniePostaciService tps = new TworzeniePostaciService();
        WalkaService ws = new WalkaService();
        WynikUderzenia wu = new WynikUderzenia(100, CzesciCialaEnum.GLOWA);
        Humanoid atakujacy = (Humanoid) tps.stworzIstote(TypPostaciEnum.CZLOWIEK);
        Istota ofiara = tps.stworzIstote(TypPostaciEnum.ORK);
        atakujacy.uderz(ofiara);
        //when
        ws.rundaWalki(atakujacy, ofiara);
        //then
        //Mockito - umiesz... sprawdzasz
    }

    @Test
    public void funkcjaSprawdzaWalke() {
        //given
        TworzeniePostaciService tps = new TworzeniePostaciService();
        WalkaService ws = new WalkaService();
        Istota atakujacy = tps.generujListeNowychPostaci(1).get(0);
        Istota ofiara = tps.generujListeNowychPostaci(1).get(0);
        //when
        ws.walka(atakujacy, ofiara);
        //then
        Assert.assertNotNull(atakujacy);
        Assert.assertNotNull(ofiara);
        Assert.assertTrue(atakujacy.getPunktyZycia() >= 0);
        Assert.assertTrue(ofiara.getPunktyZycia() >= 0);
        Assert.assertFalse(atakujacy.getId().equals(ofiara.getId()));
    }
}
