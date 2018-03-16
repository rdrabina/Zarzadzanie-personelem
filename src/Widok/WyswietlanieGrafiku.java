package Widok;

import Kontroler.Menu;
import Model.*;

import java.util.List;

public class WyswietlanieGrafiku {

    private DialogiZUżytkownikiem dialogiZUżytkownikiem=new DialogiZUżytkownikiem();

    public void wyswietlGrafik()
    {
        List<Pracownik> lista= Menu.getListaPracownikow();
        int i=1;
        for(Pracownik x: lista) {
            System.out.println(i+". "+x.getImie()+" "+x.getNazwisko());
                for (int j = 0; j < x.getGrafik().getGrafikTab().length; j++) {
                    System.out.print("         " + DzienTygodnia.getDzienTygodnia(j + 1) + ": ");
                    System.out.println(x.getGrafik().getGrafikTab()[j]);
                }
                i++;
                System.out.println("");
            }
        dialogiZUżytkownikiem.nacisnijKlawisz();

    }

    public void wyswietlGrafikPracownika(String imie, String nazwisko)
    {
        List<Pracownik> lista=Menu.getListaPracownikow();
        for(Pracownik x: lista) {
                if(x.getImie().equals(imie) &&x.getNazwisko().equals(nazwisko)) {
                    for (int j = 0; j < x.getGrafik().getGrafikTab().length; j++) {
                      System.out.print("         " + DzienTygodnia.getDzienTygodnia(j + 1) + ": ");
                        System.out.println(x.getGrafik().getGrafikTab()[j]);
                    }
                    System.out.println("");
                }
        }
        dialogiZUżytkownikiem.nacisnijKlawisz();

    }
}
