package Widok;

import Kontroler.Menu;
import Model.ListaPracownikow;
import Model.Pracownik;
import Model.Zadanie;
import java.util.List;

public class WyswietlanieZadan {

    private DialogiZUżytkownikiem dialogiZUżytkownikiem=new DialogiZUżytkownikiem();

    public void wyswietlZadaniaAdministrator()
    {
        ListaPracownikow l = new ListaPracownikow();
        List<Pracownik> lista= Menu.getListaPracownikow();
        int i=1;
        int j=1;
        for(Pracownik x: lista)
        {
            System.out.println(i+". "+x.getImie()+" "+x.getNazwisko());
            for(Zadanie y: x.getZadania())
            {
                System.out.println("         "+j+". "+y.getZadanie());
                j++;
            }
            j=1;
            i++;
        }
        dialogiZUżytkownikiem.nacisnijKlawisz();
    }

    public void wyswietlZadaniaPracownik(String imie,String nazwisko)
    {
        List<Pracownik> lista=Menu.getListaPracownikow();
        int i=1;
        for(Pracownik x: lista) {
            if (x.getImie().equals(imie) && x.getNazwisko().equals(nazwisko)) {
                System.out.println(imie + " " + nazwisko);
                for (Zadanie y : x.getZadania()) {
                    System.out.println("         " + i + ". " + y.getZadanie());
                    i++;
                }
                dialogiZUżytkownikiem.nacisnijKlawisz();
            }
        }

    }
}
