package Model;

import Kontroler.Menu;
import Widok.DialogiZUżytkownikiem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zadanie implements Serializable  {
    private String zadanie = "";
    DialogiZUżytkownikiem dialogiZUżytkownikiem=new DialogiZUżytkownikiem();

    Zadanie(String zadanie)
    {
        this.zadanie=zadanie;
    }
    public Zadanie()
    {

    }

    public String getZadanie() {
        return zadanie;
    }



    public void dodajZadanie() {
        List<Pracownik> listaPracownikow;
        ListaPracownikow lista = new ListaPracownikow();
        listaPracownikow = Menu.getListaPracownikow();
        boolean wyjscie = false;
        boolean czyPracownik = lista.sprawdzPracownika();
        String imie = lista.getImie();
        String nazwisko = lista.getNazwisko();
        while (!wyjscie) {
            if (czyPracownik) {
                for (Pracownik x : listaPracownikow) {
                    if (x.imie.equals(imie) && x.nazwisko.equals(nazwisko)) {
                        try {
                            dialogiZUżytkownikiem.podajZadanie();
                            Scanner zad = new Scanner(System.in);
                            String zadanie = zad.nextLine();
                            x.setZadanie(zadanie);
                            wyjscie = true;
                        } catch (IllegalArgumentException e) {
                            dialogiZUżytkownikiem.pojawilSieBlad();
                        }
                    }
                }
            } else break;

        }
    }

    public void usunZadaniePracownika(Pracownik p, String zadanie) {
        List<Pracownik> listaPracownikow;
        listaPracownikow = Menu.getListaPracownikow();
        List<Zadanie> doUsuniecia = new ArrayList<>(1);
        for (Pracownik x : listaPracownikow) {
            if (x.getImie().equals(p.getImie()) && x.getNazwisko().equals(p.getNazwisko())) {
                for (Zadanie y : x.getZadania()) {
                    if (y.getZadanie().equals(zadanie)) doUsuniecia.add(y);
                }
                x.getZadania().removeAll(doUsuniecia);
            }
        }
    }

    public String wpiszZadanie(String imie,String nazwisko)
    {
        int a=3;
        String zadanie;
        boolean czyZadanie=false;
        while (!czyZadanie && a>0) {
            zadanie = odczytajZadanie();
            czyZadanie = sprawdzCzyZadanie(zadanie,imie,nazwisko);
            if(!czyZadanie) dialogiZUżytkownikiem.pojawilSieBlad();
            else
            {
                return zadanie;
            }
            a--;
        }
        return "";
    }
    private String odczytajZadanie()
    {
            dialogiZUżytkownikiem.podajZadanie();
            Scanner pracownik = new Scanner(System.in);
            zadanie = pracownik.nextLine();
        return zadanie;
    }

    private boolean sprawdzCzyZadanie(String zadanie, String imie, String nazwisko) {
        List<Pracownik> listaPracownikow;
        listaPracownikow = Menu.getListaPracownikow();
        Pracownik p = new Pracownik(imie, nazwisko);
        for (Pracownik x : listaPracownikow) {
            if (x.getImie().equals(p.getImie()) && x.getNazwisko().equals(p.getNazwisko())) {
                for (Zadanie y : x.getZadania()) {
                    if (y.getZadanie().equals(zadanie)) return true;
                }
            }
        }
        return false;

    }

}