package Widok;

import Kontroler.Menu;
import Model.Pracownik;
import java.util.List;

public class Wykres{

    private DialogiZUżytkownikiem dialogiZUżytkownikiem=new DialogiZUżytkownikiem();


    public void rysujWykres(){
        List<Pracownik> lista= Menu.getListaPracownikow();
        int i;
        int dzielnik=1;
        for(Pracownik x: lista)
        {
            i=x.getLiczbeGodzin();
            if(i>100) dzielnik=2;
        }
        for(Pracownik x: lista)
        {
            i=x.getLiczbeGodzin();
            int tmp=i/dzielnik;
            for(int j=i;j>0;j--)
            {
                System.out.print("*");
            }
            for(int j=100-tmp;j>=0;j--) System.out.print(" ");
            System.out.print(tmp);
            System.out.println(" " + x.getImie() + " "+ x.getNazwisko());
        }
        dialogiZUżytkownikiem.nacisnijKlawisz();

    }

}
