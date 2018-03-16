package Model;
import Kontroler.Menu;
import Widok.DialogiZUżytkownikiem;

import java.io.*;
import java.util.*;


public class ListaPracownikow implements Serializable {
    private List<Pracownik> listaPracownikow = Menu.getListaPracownikow();
    static final long serialVersionUID=6023719538895836351L;
    private DialogiZUżytkownikiem dialogiZUżytkownikiem=new DialogiZUżytkownikiem();
    private boolean czyPracownik;
    private OdczytDanych odczytDanych = new OdczytDanych();
    private String imie;
    private String nazwisko;

    public static void zapiszListe(List<Pracownik> lista) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("listaPracowników.txt"))) {
            outputStream.writeObject(lista);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Pracownik> odczytajListe() {
        List<Pracownik> lista = new ArrayList<>(100);
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("listaPracowników.txt"))) {
            lista = (ArrayList) inputStream.readObject();
            inputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e)
        {
            e.printStackTrace();
        }
        return lista;
    }

    public void wyswietlListe(List<Pracownik> lista) {
        for (Pracownik x : lista) {
            System.out.println(x.toString());
        }
    }


    private boolean sprawdzCzyPracownik(String imie, String nazwisko) {
        for (Pracownik x : listaPracownikow) {
            if (x.getImie().equals(imie) && x.getNazwisko().equals(nazwisko)) return true;
        }
        return false;
    }


    public boolean sprawdzPracownika() {
        int a=3;
        boolean poprawneDane=false;
        String im;
        String na;
        while (!czyPracownik && a>0) {
            im = odczytDanych.odczytajPracownika(1,a,poprawneDane);
            poprawneDane = false;
            na = odczytDanych.odczytajPracownika(2,a,poprawneDane);
            poprawneDane = false;
            czyPracownik = sprawdzCzyPracownik(im, na);
            if(czyPracownik)
            {
                imie=im;
                nazwisko=na;
            }
            else dialogiZUżytkownikiem.nieMaTakiegoPracownika();
            a--;
        }
        return czyPracownik;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }
}


