package Kontroler;

import Model.ListaPracownikow;
import Model.OdczytDanych;
import Model.Pracownik;
import Widok.*;

public class PanelPracownika {

    private String imie;
    private String nazwisko;
    private boolean wyjscie;
    private DrukowanieNaEkranie drukowanieNaEkranie=new DrukowanieNaEkranie();
    private DialogiZUżytkownikiem dialogiZUżytkownikiem=new DialogiZUżytkownikiem();
    private OdczytDanych odczytDanych = new OdczytDanych();

    public PanelPracownika(String imie, String nazwisko)
    {
        this.imie=imie;
        this.nazwisko=nazwisko;
    }

    public void odpalMenu()
    {
        while(!wyjscie)
        {
            drukowanieNaEkranie.drukujNaglowekMenuPracownika();
            drukowanieNaEkranie.drukujMenuPracownika();
            int wybor=odczytDanych.odczytajWejsciePracownika();
            wykonaj(wybor);
        }
    }


    private void wykonaj(int wybor){
        switch(wybor){
            case 0:
                wyjscie=true;
                break;
            case 1:
                zobaczLiczbePrzepracowanychGodzin();
                break;
            case 2:
                zobaczZadania();
                break;
            case 3:
                zobaczGrafik();
                break;
            case 4:
                zobaczWykres();
                break;
            default:
                dialogiZUżytkownikiem.pojawilSieBlad();
        }


    }

    private void zobaczLiczbePrzepracowanychGodzin()
    {
        System.out.println("Posiadasz przepracowanych "+ Pracownik.zwrocIloscGodzin(imie,nazwisko)+"h w tym miesiącu.");
        dialogiZUżytkownikiem.nacisnijKlawisz();
    }

    private void zobaczZadania(){
        WyswietlanieZadan zadaniaPracownika=new WyswietlanieZadan();
        zadaniaPracownika.wyswietlZadaniaPracownik(imie,nazwisko);

    }

    private void zobaczGrafik(){
        WyswietlanieGrafiku wyswietlanieGrafiku=new WyswietlanieGrafiku();
        wyswietlanieGrafiku.wyswietlGrafikPracownika(imie,nazwisko);
    }

    private void zobaczWykres(){
        Wykres wykres = new Wykres();
        wykres.rysujWykres();
    }


}
