package com.example.arena.model.postaci;

import com.example.arena.model.wyposazenie.Bron;
import com.example.arena.model.wyposazenie.EkwipunekPostaci;
import com.example.arena.model.wyposazenie.Pancerz;
import com.example.arena.model.wyposazenie.PancerzEnum;
import com.example.arena.service.TworzeniePostaciService;

import java.util.*;
import java.util.stream.Collectors;

import static com.example.arena.model.postaci.ParametryIstotyEnum.*;
import static com.example.arena.service.TworzeniePostaciService.losuj;

public abstract class Istota implements FunkcjeIstoty {

    private Map<ParametryIstotyEnum, Integer> parametryIstoty = Arrays.stream(ParametryIstotyEnum.values()).collect(HashMap<ParametryIstotyEnum, Integer>::new,
            (m, c) -> m.put(c, 0),
            (m, u) -> {
            });

    private String id = UUID.randomUUID().toString();

    private TypPostaciEnum typPostaci;

    private List<Bron> bronList;

    private List<Pancerz> pancerzList;

    private String name;

    private LevelEnum levelPostaci = LevelEnum.LEVEL1;

    private int doswiadczenie;

    private List<Pancerz> aktywnyPancerz = new ArrayList<>();

    private EkwipunekPostaci ekwipunekPostaci;

    public Istota(int sila, int zwinnosc, int wytrzymalosc, int szybkosc, int inicjatywa, TypPostaciEnum nowyTypPostaci, int iloscAtakow,
                  int iloscUnikow, int punktyZycia, List<Bron> bronList, List<Pancerz> pancerzList) {
        setSila(sila);
        setZwinnosc(zwinnosc);
        setWytrzymalosc(wytrzymalosc);
        setSzybkosc(szybkosc);
        setInicjatywa(inicjatywa);
        this.typPostaci = nowyTypPostaci;
        setIloscAtakow(iloscAtakow);
        setIloscUnikow(iloscUnikow);
        setPunktyZycia(punktyZycia);
        this.bronList = bronList;
        this.pancerzList = pancerzList;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Bron> getBron() {
        return bronList;
    }

    public List<Pancerz> getPancerz() {
        return pancerzList;
    }

    @Override
    public String toString() {
        return "name: " + name + " sila: " + getSila() + " zwinnosc: " + getZwinnosc() + " wytrzymalosc: " + getWytrzymalosc() + " szybkosc: " + getSzybkosc()
                + " inicjatywa: " + getInicjatywa() + " punkty zycia " + getPunktyZycia() + " Typ postaci: " + getTypPostaci() + " Posiadane typy broni:" + getEkwipunekPostaci()
                .getListaPosiadanychBroni().stream().map(Bron::getBronEnum).collect(Collectors.toList()) + " Posiadane typy pancerza" + getEkwipunekPostaci().getlistaPosiadanychPancerzy().stream().map(Pancerz::getPancerzEnum).collect(Collectors.toList()) + " Posiadane inne przedmioty" + getEkwipunekPostaci().getlistaPosiadanychPrzedmiotow() + " level postaci: " +
                getLevelPostaci() + " doświadczenie postaci: " + getDoswiadczenie();
    }

    public int getSila() {
        return parametryIstoty.get(SIŁA);
    }

    private void setSila(int sila) {
        parametryIstoty.replace(SIŁA, sila);
    }

    public int getZwinnosc() {
        return parametryIstoty.get(ZWINNOŚĆ);
    }

    private void setZwinnosc(int zwinnosc) {
        parametryIstoty.replace(ZWINNOŚĆ, zwinnosc);
    }

    public int getWytrzymalosc() {
        return parametryIstoty.get(WYTRZYMAŁOŚĆ);
    }

    private void setWytrzymalosc(int wytrzymalosc) {
        parametryIstoty.replace(WYTRZYMAŁOŚĆ, wytrzymalosc);
    }

    public int getSzybkosc() {
        return parametryIstoty.get(SZYBKOŚĆ);
    }

    private void setSzybkosc(int szybkosc) {
        parametryIstoty.replace(SZYBKOŚĆ, szybkosc);
    }

    public int getInicjatywa() {
        return parametryIstoty.get(INICJATYWA);
    }

    private void setInicjatywa(int inicjatywa) {
        parametryIstoty.replace(INICJATYWA, inicjatywa);
    }

    public int getPunktyZycia() {
        return parametryIstoty.get(PUNKTY_ZYCIA);
    }

    private void setPunktyZycia(int punktyZycia) {
        parametryIstoty.replace(PUNKTY_ZYCIA, punktyZycia);
    }

    public TypPostaciEnum getTypPostaci() {
        return typPostaci;
    }

    public EkwipunekPostaci getEkwipunekPostaci() {
        return ekwipunekPostaci;
    }

    public LevelEnum getLevelPostaci() {
        return levelPostaci;
    }

    public int getDoswiadczenie() {
        return doswiadczenie;
    }

    protected void setEkwipunekPostaci(EkwipunekPostaci ekwipunekPostaci) {
        this.ekwipunekPostaci = ekwipunekPostaci;
    }

    int atakPrzeciwnika(Istota targetInnaIstota, Bron bronAtakujacego) {
        int sumaObrazen = 0;
        System.out.println("Postac " + getName() + " atakuje " + targetInnaIstota.getName() + " za pomocą " + bronAtakujacego.getBronEnum().name());
        if (getZwinnosc() >= losuj(0, 9)) {
            int obrazenia = losuj(bronAtakujacego.getObrazeniaMin(), bronAtakujacego.getObrazeniaMax());
            sumaObrazen = obrazenia + getSila();
        } else {
            System.out.println("Postac " + getName() + " nie wykonałą ataku w stronę " + targetInnaIstota.getName());
        }
        redukcjaAtakow();
        return sumaObrazen;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    private void redukcjaAtakow() {
        setIloscAtakow(getIloscAtakow() - 1);
    }

    public int getIloscAtakow() {
        return parametryIstoty.get(ILOSC_ATAKOW);
    }

    private void setIloscAtakow(int iloscAtakow) {
        parametryIstoty.replace(ILOSC_ATAKOW, iloscAtakow);
    }

    @Override
    public void unik(Istota atakujacaIstota, WynikUderzenia wynikUderzenia) {
        if (getIloscUnikow() != 0) {
            System.out.println("Postac " + getName() + " posiada " + getIloscUnikow() + " unikow wiec postara sie uniknac ciosu od " + atakujacaIstota.getName());
            if (getInicjatywa() > losuj(0, 9)) {
                System.out.println("Postac " + getName() + " uniknela ataku ze strony " + atakujacaIstota.getName());
                redukcjaUnikow();
            } else {
                System.out.println("Unik postaci " + getName() + " nie udal sie");
                rezultatObrazen(atakujacaIstota, wynikUderzenia);
                redukcjaUnikow();
            }
        } else {
            System.out.println("Postac " + getName() + " nie posiada unikow");
            rezultatObrazen(atakujacaIstota, wynikUderzenia);
        }
    }

    public int getIloscUnikow() {
        return parametryIstoty.get(ILOSC_UNIKOW);
    }

    private void setIloscUnikow(int iloscUnikow) {
        parametryIstoty.replace(ILOSC_UNIKOW, iloscUnikow);
    }

    private void redukcjaUnikow() {
        if (getPunktyZycia() > 0) {
            setIloscUnikow(getIloscUnikow() - 1);
            System.out.println("Postac " + getName() + " pozostalo " + getIloscUnikow() + " unikow");
        }
    }

    private void rezultatObrazen(Istota atakujacaIstota, WynikUderzenia wynikUderzenia) {
        System.out.println("Postac " + getName() + " posiada założony pancerz: " + getAktywnyPancerz());
        int zadaneObrazenia = wynikUderzenia.getSumaObrazen() - getWytrzymalosc() - sumaOchronyPancerza(wynikUderzenia.getMiejsceTrafienia());
        if (zadaneObrazenia > 0) {
            System.out.println("Postac " + getName() + " otrzymała " + zadaneObrazenia + " punktów obrazen w " + wynikUderzenia.getMiejsceTrafienia().name());
            redukcjaPunktowZycia(zadaneObrazenia);
            System.out.println("W wyniku poniesionych obrazen postaci " + getName() + " pozostalo " + getPunktyZycia() + " punktow zycia");
        } else {
            System.out.println("Dzieki wytrzymalosci postac " + getName() + " odparla atak ze strony " + atakujacaIstota.getName());
        }
        if (getPunktyZycia() <= 0) {
            System.out.println("Postac " + atakujacaIstota.getName() + " smiertelnie ranila " + getName());
        }
    }

    public List<Pancerz> getAktywnyPancerz() {
        return aktywnyPancerz;
    }

    private int sumaOchronyPancerza(CzesciCialaEnum trafioneMiejsce) {
        int sumaPancerza = 0;
        for (Pancerz anAktywnyPancerz : aktywnyPancerz) {
            Set<CzesciCialaEnum> listaMiejscChronionychSet = anAktywnyPancerz.getChronioneMiejsce();
            List<CzesciCialaEnum> listaMiejscChronionychList = new ArrayList<>(listaMiejscChronionychSet);
            for (CzesciCialaEnum chronioneMiejsceCiala : listaMiejscChronionychList) {
                if (chronioneMiejsceCiala.equals(trafioneMiejsce)) {
                    sumaPancerza += anAktywnyPancerz.getPunktyPancerza();
                }
            }
        }
        System.out.println("Suma pancerza dla " + trafioneMiejsce + " wynosi " + sumaPancerza);
        System.out.println("Punkty pancerza postaci " + getName() + ": " + sumaPancerza);
        return sumaPancerza;
    }

    private void redukcjaPunktowZycia(int zadaneObrazenia) {
        setPunktyZycia(getPunktyZycia() - zadaneObrazenia);
        if (getPunktyZycia() < 0) {
            setPunktyZycia(0);
        }
    }

    @Override
    public void zalozPancerz(List<PancerzEnum> aktywowanePancerze) {
        aktywowanePancerze.forEach(pancerz -> aktywnyPancerz.add(getEkwipunekPostaci().wyjmijPancerz(pancerz)));

    }

    public void resetAtakowUnikow() {
        resetIlosciAtakow();
        resetIlosciUnikow();
    }

    private void resetIlosciAtakow() {
        setIloscAtakow(1);
    }

    private void resetIlosciUnikow() {
        setIloscUnikow(1);
    }

    public CzesciCialaEnum trafioneMiejsce() {
        CzesciCialaEnum trafioneMiejsce = null;
        CzesciCialaEnum[] tablicaCzesciCiala = CzesciCialaEnum.values();
        List<CzesciCialaEnum> miejscaDoTrafienia = Arrays.asList(tablicaCzesciCiala);
        int wylosowaneMiejsce = losowanieTrafienia();
        for (CzesciCialaEnum potencjalneMiejsce : miejscaDoTrafienia) {
            if (potencjalneMiejsce.getMinWartTraf() <= wylosowaneMiejsce && potencjalneMiejsce.getMaxWartTraf() >= wylosowaneMiejsce) {
                trafioneMiejsce = potencjalneMiejsce;
                break;
            }
        }
        return trafioneMiejsce;
    }

    private int losowanieTrafienia() {
        return TworzeniePostaciService.losuj(0, 99);
    }

    public void ustawDoswiadczenie(int doswiadczenie) {
        this.doswiadczenie = this.doswiadczenie + doswiadczenie;
        LevelEnum potencjalnyLevel = jakiLevel(this.doswiadczenie);
        if (getLevelPostaci() != potencjalnyLevel) {
            this.levelPostaci = potencjalnyLevel;
            Map<ParametryIstotyEnum, Integer> ulepszenia = potencjalnyLevel.getUlepszeniaPostaci();
            for (Map.Entry<ParametryIstotyEnum, Integer> entry : ulepszenia.entrySet()) {
                if (entry.getKey().equals(SIŁA)) {
                    setSila(getSila() + entry.getValue());
                }
                if (entry.getKey().equals(ZWINNOŚĆ)) {
                    setZwinnosc(getZwinnosc() + entry.getValue());
                }
                if (entry.getKey().equals(WYTRZYMAŁOŚĆ)) {
                    setWytrzymalosc(getWytrzymalosc() + entry.getValue());
                }
                if (entry.getKey().equals(SZYBKOŚĆ)) {
                    setSzybkosc(getSzybkosc() + entry.getValue());
                }
                if (entry.getKey().equals(INICJATYWA)) {
                    setInicjatywa(getInicjatywa() + entry.getValue());
                }
                if (entry.getKey().equals(ILOSC_ATAKOW)) {
                    setIloscAtakow(getIloscAtakow() + entry.getValue());
                }
                if (entry.getKey().equals(ILOSC_UNIKOW)) {
                    setIloscUnikow(getIloscUnikow() + entry.getValue());
                }
                if (entry.getKey().equals(PUNKTY_ZYCIA)) {
                    setPunktyZycia(getPunktyZycia() + entry.getValue());
                }
            }
        }
    }

    private LevelEnum jakiLevel(int mojeDoswiadczenie) {
        LevelEnum potencjalnyLevel = null;
        LevelEnum[] tablicaLeveli = LevelEnum.values();
        List<LevelEnum> listaLeveli = Arrays.asList(tablicaLeveli);
        for (LevelEnum level : listaLeveli) {
            if (level.getMaxZakresLev() >= mojeDoswiadczenie && level.getMinZakresLev() <= mojeDoswiadczenie) {
                potencjalnyLevel = level;
                break;
            }
        }
        return potencjalnyLevel;
    }

}




