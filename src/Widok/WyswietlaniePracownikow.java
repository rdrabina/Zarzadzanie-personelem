package Widok;

import Kontroler.Menu;
import Model.ListaPracownikow;
import Model.Pracownik;
import java.util.List;

public class WyswietlaniePracownikow {

    private DialogiZUżytkownikiem dialogiZUżytkownikiem=new DialogiZUżytkownikiem();

    public void wyswietlListe()
    {
        ListaPracownikow l = new ListaPracownikow();
        List<Pracownik> lista= Menu.getListaPracownikow();
        l.wyswietlListe(lista);
        System.out.println("");
        dialogiZUżytkownikiem.nacisnijKlawisz();
    }
}
