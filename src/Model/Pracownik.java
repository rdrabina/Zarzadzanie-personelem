package Model;

import Kontroler.Menu;
import Widok.DialogiZUżytkownikiem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pracownik extends OdczytDanych implements Serializable{
    static final long serialVersionUID=2855542212766513652L;
    String imie;
    String nazwisko;
    private int liczbaGodzin=0;
    private List <Zadanie> listaZadan= new ArrayList<>(10);
    private Grafik grafik = new Grafik();
    private DialogiZUżytkownikiem dialogiZUżytkownikiem=new DialogiZUżytkownikiem();
    private OdczytDanych odczytDanych = new OdczytDanych();


    public Grafik getGrafik() {
        return grafik;
    }



    public Pracownik(String imie, String nazwisko)
    {
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.liczbaGodzin=0;
    }

    public Pracownik(){}

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }


    public String toString()
    {
        return imie + " " + nazwisko + toStringLiczbaGodzin()+"Libcza przepracowanych godzin: "+liczbaGodzin; }

    private String toStringLiczbaGodzin()
    {
        int x=0;
        String liczbaH="";
        for(int i=0;i<imie.length();i++) x++;
        for(int j=0;j<nazwisko.length();j++)x++;
        for(int k=30-x;k>=0;k--)
        {
            liczbaH=liczbaH +" ";
        }
        return liczbaH;
    }

    private void setIloscGodzin(int liczbaGodzin)
        {
            this.liczbaGodzin=liczbaGodzin;
        }

    public int getLiczbeGodzin()
        {
            return liczbaGodzin;
        }

    public void setZadanie(String zadanie)
    {
        Zadanie zad=new Zadanie(zadanie);
        listaZadan.add(zad);
    }
    public List<Zadanie> getZadania()
    {
        return listaZadan;
    }


    public void dodajPracownika()
    {
        String imie="";
        String nazwisko="";
        boolean czyOk=true;
        for(int i=3;i>0&& czyOk;i--) {
            try {
                imie = odczytDanych.wczytajImie();
                if (sprawdzCzyTekst(imie)){
                    break;
                }

                else dialogiZUżytkownikiem.bledneImie();
            } catch (IllegalArgumentException e) {
                dialogiZUżytkownikiem.bledneImie();
            }
            if(i==1)czyOk=false;
        }
        for(int i=3;i>0 && czyOk;i--){
            try
            {
                nazwisko=odczytDanych.wczytajNazwisko();
                if(sprawdzCzyTekst(nazwisko))
                {
                    break;
                }
                dialogiZUżytkownikiem.bledneNaziwsko();

            }
            catch (IllegalArgumentException e)
            {
                dialogiZUżytkownikiem.bledneNaziwsko();
            }
            if(i==1) czyOk=false;
        }

        if(czyOk){
            List<Pracownik> listaPracownikow;
            listaPracownikow = Menu.getListaPracownikow();
            listaPracownikow.add(new Pracownik(imie, nazwisko));
        }
    }

    public void usunPracownika()
    {

        List<Pracownik> listaPracownikow;
        listaPracownikow = Menu.getListaPracownikow();
        Pracownik pracownikUsun=new Pracownik(wczytajImie(),wczytajNazwisko());
        List<Pracownik> doUsuniecia = new ArrayList<>(1);
        for (Pracownik x : listaPracownikow) {
            if (x.getImie().equals(pracownikUsun.getImie()) && x.getNazwisko().equals(pracownikUsun.getNazwisko())) doUsuniecia.add(x);
        }
        listaPracownikow.removeAll(doUsuniecia);
    }

    public static int zwrocIloscGodzin(String imie, String nazwisko) {
        List<Pracownik> listaPracownikow;
        listaPracownikow= Menu.getListaPracownikow();
        for (Pracownik x : listaPracownikow) {
            if (x.getImie().equals(imie) && x.getNazwisko().equals(nazwisko)) return x.getLiczbeGodzin();
        }
        return 0;
    }

    public void ustawIloscGodzin()
    {
        List<Pracownik> listaPracownikow;
        listaPracownikow = Menu.getListaPracownikow();
        Pracownik p=new Pracownik();
        String imie=p.wczytajImie();
        String nazwisko=p.wczytajNazwisko();
        boolean ustawione=false;
        for(Pracownik x: listaPracownikow)
        {
            if(x.getImie().equals(imie) && x.getNazwisko().equals(nazwisko))
            {
                x.setIloscGodzin(new Pracownik().wczytajIloscGodzin());
                ustawione=true;
            }


        }
        if(!ustawione){
            dialogiZUżytkownikiem.nieMaTakiegoPracownika();
        }

        else dialogiZUżytkownikiem.pozytwnaZmianaLiczbyGodzin();
        dialogiZUżytkownikiem.nacisnijKlawisz();
    }


}
