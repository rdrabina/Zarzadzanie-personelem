package Widok;

import java.io.Serializable;
import java.util.Scanner;

public class DialogiZUżytkownikiem implements Serializable{

    static final long serialVersionUID=-6241003272292378644L;
    public void wybierzOpcje()
    {
        System.out.println("\nWybierz opcje:");
    }

    public void niepoprawnyWybor()
    {
        System.out.println("Niepoprawny wybór. Spróbuj jeszcze raz.");
    }

    public void pojawilSieBlad()
    {
        System.out.println("Pojawił się nieoczekiwany błąd.");
    }

    public void wylaczProgram()
    {
        System.out.println("Nastąpi wyłączenie programu.");
    }

    public void nacisnijKlawisz()
    {
        System.out.println("");
        System.out.println("Naciśnij dowolny klawisz, aby kontynuować.");
        Scanner in=new Scanner(System.in);
        String input=in.nextLine();
    }

    public void podajHaslo()
    {
        System.out.println("\nHasło:");
    }

    public void podajLogin()
    {
        System.out.println("\nLogin:");
    }

    public void niepoprawnyLoginLubHaslo()
    {
        System.out.println("Niepoprawny login lub hasło. Spróbuj jeszcze raz");
    }

    public void blednyDzienGrafiku()
    {
        System.out.println("Podano błędny dzień");
    }

    public void blednaZmiana()
    {
        System.out.println("Podano błędną zmianę");
    }

    public void nieMaTakiegoPracownika()
    {
        System.out.println("Nie ma takiego pracownika");
    }

    public void pozytwnaZmianaLiczbyGodzin()
    {
        System.out.println("Pozytywnie zmieniono liczbe godzin pracownika\n");
    }

    public void wpiszGodnosc(int i)
    {
        System.out.println("Wpisz "+i+" człon godności:");
    }

    public void podajImie()
    {
        System.out.println("Podaj imie pracownika");
    }

    public void podajNazwisko()
    {
        System.out.println("Podaj nazwisko pracownika");
    }

    public void bledneImie()
    {
        System.out.println("Podano błędne imię");
    }

    public void bledneNaziwsko()
    {
        System.out.println("Podano błędne nazwisko");
    }

    public void niepoprawneDane()
    {
        System.out.println("Niepoprawne dane. Spróbuj jeszcze raz");
    }

    public void podajDzien()
    {
        System.out.println("Prosze podac dzien tygodnia");
    }

    public void podajZmiane()
    {
        System.out.println("Prosze podac zmiane");
    }

    public void podajZadanie()
    {
        System.out.println("Podaj zadanie");

    }
}

