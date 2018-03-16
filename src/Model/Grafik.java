package Model;

import Kontroler.Menu;
import Widok.DialogiZUżytkownikiem;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

public class Grafik implements Serializable
{
    static final long serialVersionUID=-8375356084358143971L;
    private int grafik[]=new int[7];
    private DialogiZUżytkownikiem dialogiZUżytkownikiem=new DialogiZUżytkownikiem();

    private void losujGrafik()
    {
        Random generator = new Random();
        for(int i=0;i<5;i++)
        {
            grafik[i] = generator.nextInt(3)+1;

        }
    }
    public int[] getGrafikTab()
    {
        return grafik;
    }

    public void ustawGrafik(String imie,String nazwisko,String dzien,int zmiana)
    {
        List<Pracownik> listaPracownikow;
        listaPracownikow = Menu.getListaPracownikow();
        int i=DzienTygodnia.getDzienTygodnia(dzien);
        System.out.println("Dzien tygodnia"+i + " "+zmiana+imie+nazwisko);
        for(Pracownik x: listaPracownikow)
        {
            if(x.getImie().equals(imie) && x.getNazwisko().equals(nazwisko))
            {
                if(i>0 &&i<6)
                {
                    if(zmiana>=0 && zmiana<4)
                    {
                        x.getGrafik().getGrafikTab()[i-1]=zmiana;
                    }
                    else dialogiZUżytkownikiem.blednaZmiana();
                }else  dialogiZUżytkownikiem.blednyDzienGrafiku();
            }
        }

    }

    public void setGrafik(int dzien, int zmiana)
    {
        grafik[dzien]=zmiana;
    }

    public void losujGrafikOdczytujacPracownika()
    {
        List<Pracownik> listaPracownikow;
        listaPracownikow = Menu.getListaPracownikow();
        for(Pracownik x: listaPracownikow)
        {
            x.getGrafik().losujGrafik();
        }
    }

}
