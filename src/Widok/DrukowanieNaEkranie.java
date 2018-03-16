package Widok;

public class DrukowanieNaEkranie {
    public void drukujMenu()
    {
        System.out.println("Proszę dokonać wyboru.");
        System.out.println("0) Wyjście");
        System.out.println("1) Panel dla administratora");
        System.out.println("2) Panel pracownika");
        System.out.println("");
        System.out.println("------------------------------------------");
        System.out.println("");
    }

    public void drukujNaglowekMenu()
    {
        System.out.println("******************************************");
        System.out.println("              Witaj w naszym");
        System.out.println("                    MENU");
        System.out.println("******************************************");
        System.out.println("");
    }

    public void drukujMenuAdministratora(){
        System.out.println("Proszę dokonać wyboru.");
        System.out.println("0) Wyjście");
        System.out.println("1) Liczba przepracowanych godzin każdego pracownikaw miesiącu. Wykres");
        System.out.println("2) Zobacz zadania");
        System.out.println("3) Dodaj zadanie");
        System.out.println("4) Usuń zadanie");
        System.out.println("5) Zobacz grafik");
        System.out.println("6) Dodaj pracownika");
        System.out.println("7) Usuń pracownika");
        System.out.println("8) Lista pracowników");
        System.out.println("9) Zmien liczbe przepracowanych godzin pracownika");
        System.out.println("10) Losuj grafik");
        System.out.println("11) Ustaw grafik");
        System.out.println("------------------------------------------");
        System.out.println("");

    }

    public void drukujNaglowekMenuAdministratora(){
        System.out.println("******************************************");
        System.out.println("                 Witaj w ");
        System.out.println("            MENU ADMINISTRATORA");
        System.out.println("******************************************");
        System.out.println("");

    }

    public void drukujMenuPracownika(){
        System.out.println("Proszę dokonać wyboru.");
        System.out.println("0) Wyjście");
        System.out.println("1) Liczba przepracowanych godzin");
        System.out.println("2) Zobacz zadania");
        System.out.println("3) Zobacz grafik");
        System.out.println("4) Wykres godzin w obecnym miesiącu");
        System.out.println("");
        System.out.println("------------------------------------------");
        System.out.println("");

    }

    public void drukujNaglowekMenuPracownika(){
        System.out.println("******************************************");
        System.out.println("                 Witaj w ");
        System.out.println("              MENU PRACOWNIKA");
        System.out.println("******************************************");
        System.out.println("");

    }
}
