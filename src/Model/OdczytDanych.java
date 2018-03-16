package Model;

import Widok.DialogiZUżytkownikiem;

import java.io.Serializable;
import java.util.Scanner;

public class OdczytDanych implements Serializable{

    private String godnosc;
    private DialogiZUżytkownikiem dialogiZUżytkownikiem = new DialogiZUżytkownikiem();

    public String odczytajPracownika(int i,int a,boolean poprawneDane)
    {
        while(!poprawneDane && a>0) {
            dialogiZUżytkownikiem.wpiszGodnosc(i);
            a--;
            Scanner pracownik = new Scanner(System.in);
            godnosc = pracownik.nextLine();
            poprawneDane=sprawdzCzyTekst(godnosc);
            if(!poprawneDane) dialogiZUżytkownikiem.niepoprawneDane();
        }
        return godnosc;
    }

    public String wczytajImie()
    {
        dialogiZUżytkownikiem.podajImie();
        String imie="";
        try {
            Scanner i=new Scanner(System.in);
            imie=i.nextLine();
            if(!sprawdzCzyTekst(imie))
            {
                dialogiZUżytkownikiem.bledneImie();
            }
        }
        catch(IllegalArgumentException e) {
            dialogiZUżytkownikiem.pojawilSieBlad();
        }
        return imie;
    }
    public String wczytajNazwisko()
    {
        String nazwisko="";
        dialogiZUżytkownikiem.podajNazwisko();
        try{
            Scanner n=new Scanner(System.in);
            nazwisko = n.nextLine();
            if(!sprawdzCzyTekst(nazwisko))
            {
                dialogiZUżytkownikiem.bledneNaziwsko();
            }
        }
        catch (IllegalArgumentException e){
            dialogiZUżytkownikiem.pojawilSieBlad();
        }
        return nazwisko;
    }

    public int wczytajIloscGodzin()
    {
        Scanner wejscie = new Scanner (System.in);
        int iloscH=-1;
        while(iloscH<0 || iloscH>300)
        {
            try{
                System.out.println("\nWpisz ilosc godzin dla pracownika");
                iloscH=Integer.parseInt(wejscie.nextLine());
                if(iloscH<0 || iloscH>300) System.out.println("Niepoprawna ilość godzin. Spróbuj jeszcze raz.");
            }
            catch(NumberFormatException e)
            {
                System.out.println("Niepoprawna ilość godzin. Spróbuj jeszcze raz.");

            }
        }
        return iloscH;
    }

    boolean sprawdzCzyTekst(String tekst)
    {
        char[] znaki = tekst.toCharArray();

        for (char c : znaki)
        {
            if(!Character.isLetter(c)) return false;
        }
        return true;
    }

    public int odczytajWejsciePracownika(){
        Scanner wejscie = new Scanner (System.in);
        int wybor=-1;
        while(wybor<0 || wybor>4)
        {
            try{
                System.out.println("\nWybierz opcje:");
                wybor=Integer.parseInt(wejscie.nextLine());
                if(wybor<0 || wybor>4) System.out.println("Niepoprawny wybór. Spróbuj jeszcze raz.");
            }
            catch(NumberFormatException e)
            {
                System.out.println("Niepoprawny wybór. Spróbuj jeszcze raz.");

            }
        }
        return wybor;

    }

    public int odczytajWejscieAdministratora() {
        Scanner wejscie = new Scanner(System.in);
        int wybor=-1;
        while (wybor<0 || wybor>11) {
            try {
                dialogiZUżytkownikiem.wybierzOpcje();
                wybor = Integer.parseInt(wejscie.nextLine());
                if (wybor < 0 || wybor > 11) dialogiZUżytkownikiem.niepoprawnyWybor();
            } catch (NumberFormatException e) {
                dialogiZUżytkownikiem.niepoprawnyWybor();

            }
        }
        return wybor;
    }

    public String getDzien()
    {
        Scanner in=new Scanner(System.in);
        String dzien;
        dialogiZUżytkownikiem.podajDzien();
        dzien=in.nextLine();
        return dzien;
    }

    public int getZmiane()
    {
        Scanner in=new Scanner(System.in);
        int zmiana=-1;
        int i=3;
        while((zmiana<0 || zmiana>3)&&i>0)
        {
            try{
                dialogiZUżytkownikiem.podajZmiane();
                zmiana=Integer.parseInt(in.nextLine());
                if(zmiana<0 || zmiana>3) dialogiZUżytkownikiem.niepoprawnyWybor();
                else return zmiana;
            }
            catch(NumberFormatException e)
            {
                dialogiZUżytkownikiem.niepoprawnyWybor();

            }
            i++;
        }
        return zmiana;
    }
}
