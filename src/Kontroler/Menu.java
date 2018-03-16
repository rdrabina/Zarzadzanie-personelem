package Kontroler;

import Model.Administrator;
import Model.ListaPracownikow;
import Model.Pracownik;
import Widok.DialogiZUżytkownikiem;
import Widok.DrukowanieNaEkranie;
import java.util.List;
import java.util.Scanner;


public class Menu {

    private boolean wyjscie;
    private DrukowanieNaEkranie drukowanieNaEkranie=new DrukowanieNaEkranie();
    private DialogiZUżytkownikiem dialogiZUżytkownikiem = new DialogiZUżytkownikiem();

    public void odpalMenu()
    {
        while(!wyjscie)
        {
            drukowanieNaEkranie.drukujNaglowekMenu();
            drukowanieNaEkranie.drukujMenu();
            int wybor=odczytajWejscie();
            wykonaj(wybor);
        }
    }

    private int odczytajWejscie()
    {
        Scanner wejscie = new Scanner (System.in);
        int wybor=-1;
        while(wybor<0 || wybor>2)
        {
            try{
                dialogiZUżytkownikiem.wybierzOpcje();
               wybor=Integer.parseInt(wejscie.nextLine());
               if(wybor<0 || wybor>2) dialogiZUżytkownikiem.niepoprawnyWybor();
            }
            catch(NumberFormatException e)
            {
                dialogiZUżytkownikiem.niepoprawnyWybor();

            }
        }
        return wybor;
    }
    private void wykonaj(int wybor)
    {
        switch(wybor){
            case 0:
                wyjscie=true;
                dialogiZUżytkownikiem.wylaczProgram();
                break;
            case 1:
                przejdzDoPaneluAdministratora();
                break;
            case 2:
                przejdzDoPaneluPracownika();
                break;
            default:
                dialogiZUżytkownikiem.pojawilSieBlad();
        }

    }
    private void przejdzDoPaneluAdministratora()
    {
        PanelAdministratora sekcjaAdministratora = new PanelAdministratora();
        if(Administrator.sprawdzLoginIHasło()) {
            ListaPracownikow.odczytajListe();
            sekcjaAdministratora.odpalMenu();
        }

    }

    private void przejdzDoPaneluPracownika()
    {
        ListaPracownikow listaPracownikow= new ListaPracownikow();
        boolean czyPracownik=listaPracownikow.sprawdzPracownika();
        String imie = listaPracownikow.getImie();
        String nazwisko = listaPracownikow.getNazwisko();
        if(czyPracownik) {
            PanelPracownika sekcjaPracownika = new PanelPracownika(imie,nazwisko);
            sekcjaPracownika.odpalMenu();
        }
    }

    private static List<Pracownik> listaPracownikow = ListaPracownikow.odczytajListe();

    public static List<Pracownik> getListaPracownikow(){
        return listaPracownikow;
    }

    public static void zapiszListe()
    {
        ListaPracownikow.zapiszListe(listaPracownikow);
    }


}
