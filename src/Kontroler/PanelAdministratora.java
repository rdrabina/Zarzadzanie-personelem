package Kontroler;

import Model.*;
import Widok.*;

import java.util.Scanner;

public class PanelAdministratora {

    private DrukowanieNaEkranie drukowanieNaEkranie=new DrukowanieNaEkranie();
    private boolean wyjscie;
    private DialogiZUżytkownikiem dialogiZUżytkownikiem=new DialogiZUżytkownikiem();
    private OdczytDanych odczytDanych=new OdczytDanych();

    public void odpalMenu()
    {
        while(!wyjscie)
        {
            drukowanieNaEkranie.drukujNaglowekMenuAdministratora();
            drukowanieNaEkranie.drukujMenuAdministratora();
            int wybor= odczytDanych.odczytajWejscieAdministratora();
            wykonaj(wybor);
        }
    }

    private void wykonaj(int wybor){
        switch(wybor){
            case 0:
                wyjscie=true;
                Menu.zapiszListe();
                break;
            case 1:
                zobaczLiczbePrzepracowanychGodzin();
                break;
            case 2:
                zobaczZadania();
                break;
            case 3:
                dodajZadanie();
                break;
            case 4:
                usuńZadanie();
                break;
            case 5:
                zobaczGrafik();
                break;
            case 6:
                dodajPracownika();
                break;
            case 7:
                usuńPracownika();
                break;
            case 8:
                wyświetlListePracowników();
                break;
            case 9:
                zmieńLiczbePrzepracowanychGodzin();
                break;
            case 10:
                losujGrafik();
                break;
            case 11:
                ustawGrafik();
                break;
            default:
                dialogiZUżytkownikiem.pojawilSieBlad();
        }

    }

    private void zobaczLiczbePrzepracowanychGodzin()
    {
        Wykres wykres = new Wykres();
        wykres.rysujWykres();
    }

    private void zobaczZadania()
    {
        WyswietlanieZadan wyswietl=new WyswietlanieZadan();
        wyswietl.wyswietlZadaniaAdministrator();
    }
    private void dodajZadanie()
    {
        Zadanie zadanie = new Zadanie();
        zadanie.dodajZadanie();
    }
    private void usuńZadanie()
    {
        Pracownik prac=new Pracownik("","");
        Pracownik pracownik=new Pracownik(prac.wczytajImie(), prac.wczytajNazwisko());
        Zadanie zad = new Zadanie();
        zad.usunZadaniePracownika(pracownik,zad.wpiszZadanie(pracownik.getImie(), pracownik.getNazwisko()));

    }
    private void zobaczGrafik()
    {
        WyswietlanieGrafiku wyswietlanieGrafiku = new WyswietlanieGrafiku();
        wyswietlanieGrafiku.wyswietlGrafik();
    }
    private void dodajPracownika()
    {
        Pracownik pracownik=new Pracownik();
        pracownik.dodajPracownika();
    }
    private void usuńPracownika()
    {
        Pracownik pracownik = new Pracownik();
        pracownik.usunPracownika();
    }
    private void wyświetlListePracowników()
    {
        WyswietlaniePracownikow w=new WyswietlaniePracownikow();
        w.wyswietlListe();
    }

    private void zmieńLiczbePrzepracowanychGodzin()
    {
        Pracownik pracownik=new Pracownik();
        pracownik.ustawIloscGodzin();
    }

    private void losujGrafik()
    {
        Grafik grafik=new Grafik();
        grafik.losujGrafikOdczytujacPracownika();
    }

    private void ustawGrafik()
    {
        Grafik grafik=new Grafik();
        grafik.ustawGrafik(odczytDanych.wczytajImie(),odczytDanych.wczytajNazwisko(),odczytDanych.getDzien(),odczytDanych.getZmiane());
    }
}
