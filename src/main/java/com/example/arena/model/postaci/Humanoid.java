package com.example.arena.model.postaci;

import com.example.arena.model.wyposazenie.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Created by Saad on 2018-02-28.
 */
public abstract class Humanoid extends Istota implements FunkcjeHumanoida {

    private Bron aktywnaBron = new Bron(0, 2, BronEnum.PIESC, TypyBroniEnum.HUM_BIALA_JEDNORECZNA, RodzajAtakuEnum.UDERZENIE);

    public Humanoid(Integer sila, Integer zwinnosc, Integer wytrzymalosc, Integer szybkosc, Integer inicjatywa, TypPostaciEnum typPostaci, Integer nowaIloscAtakow, Integer nowailoscUnikow,
                    Integer nowePunktyZycia, List<Bron> bronList, List<Pancerz> pancerzList) {
        super(sila, zwinnosc, wytrzymalosc, szybkosc, inicjatywa, typPostaci, nowaIloscAtakow, nowailoscUnikow, nowePunktyZycia, bronList, pancerzList);

        setEkwipunekPostaci(new EkwipunekPostaci(bronList, pancerzList, Collections.emptyList()));

        if (!bronList.isEmpty()) {
            ustawBron(bronList.stream().findAny().get().getBronEnum());
        }

        List<PancerzEnum> listaPancerzyNazwa = new ArrayList<>();
        for (Pancerz pancerz : pancerzList) {
            listaPancerzyNazwa.add(pancerz.getPancerzEnum());
        }

        zalozPancerz(listaPancerzyNazwa);
    }

    @Override
    public void ustawBron(BronEnum aktywowanaBron) {
        Bron bron = getEkwipunekPostaci().wyjmijBroń(aktywowanaBron);
        if (Objects.isNull(bron)) {
            bron = new Bron(0, 2, BronEnum.PIESC, TypyBroniEnum.HUM_BIALA_JEDNORECZNA, RodzajAtakuEnum.UDERZENIE);
        }
        this.aktywnaBron = bron;
    }

    @Override
    public WynikUderzenia atak(Istota ofiara) {
        WynikUderzenia rezultatUderzenia = null;
        if (getAktywnaBron().getRodzajAtaku() == RodzajAtakuEnum.UDERZENIE) {
            rezultatUderzenia = uderz(ofiara);
            if (rezultatUderzenia.getSumaObrazen() > 0) {
                ofiara.unik(this, rezultatUderzenia);
            }
        }
        if (getAktywnaBron().getRodzajAtaku() == RodzajAtakuEnum.STRZAL) {
            rezultatUderzenia = strzel(ofiara, null);
            if (rezultatUderzenia.getSumaObrazen() > 0) {
                ofiara.unik(this, rezultatUderzenia);
            }
        }
        return rezultatUderzenia;
    }

    @Override
    public WynikUderzenia uderz(Istota targetInnaIstota) {
        WynikUderzenia wynikUderzenia;
        if (getIloscAtakow() > 0) {
            if (getId().equals(targetInnaIstota.getId())) {
                System.out.println("Nie moge sam siebie uderzyc");
                wynikUderzenia = new WynikUderzenia(0, CzesciCialaEnum.GLOWA);
            } else {
                int sumaObrazen = atakPrzeciwnika(targetInnaIstota, getAktywnaBron());
                CzesciCialaEnum trafioneMiejsce = trafioneMiejsce();
                wynikUderzenia = new WynikUderzenia(sumaObrazen, trafioneMiejsce);
            }
        } else {
            System.out.println("Postac " + getName() + " nie posiada atakow");
            wynikUderzenia = new WynikUderzenia(0, CzesciCialaEnum.GLOWA);
        }
        return wynikUderzenia;
    }

    public Bron getAktywnaBron() {
        return aktywnaBron;
    }

    @Override
    public WynikUderzenia strzel(Istota targetInnaIstota, Bron bronStrzelecka) {
        WynikUderzenia wynikUderzenia;
        if (getIloscAtakow() > 0) {
            if (getId().equals(targetInnaIstota.getId())) {
                System.out.println("Nie moge sam do siebie strzelić");
                wynikUderzenia = new WynikUderzenia(0, CzesciCialaEnum.GLOWA);
            } else {
                int sumaObrazen = atakPrzeciwnika(targetInnaIstota, getAktywnaBron());
                CzesciCialaEnum trafioneMiejsce = trafioneMiejsce();
                wynikUderzenia = new WynikUderzenia(sumaObrazen, trafioneMiejsce);
            }
        } else {
            System.out.println("Postac " + getName() + " nie posiada atakow");
            wynikUderzenia = new WynikUderzenia(0, CzesciCialaEnum.GLOWA);
        }
        return wynikUderzenia;
    }
}
