package Model;

public enum DzienTygodnia {
    Poniedziałek(1), Wtorek(2), Środa(3), Czwartek(4), Piątek(5), Sobota(6), Niedziela(7);

    int i;

    DzienTygodnia(int i)
    {
        this.i=i;
    }

    public static String getDzienTygodnia(int i)
    {
        switch(i)
        {
            case 1: return "Poniedziałek";
            case 2: return "Wtorek";
            case 3: return "Środa";
            case 4: return "Czwartek";
            case 5: return "Piątek";
            case 6: return "Sobota";
            case 7: return "Niedziela";
        }
        return "";
    }
    public static int getDzienTygodnia(String dzien)
    {
        switch(dzien){
            case "Poniedziałek": return 1;
            case "Wtorek": return 2;
            case "Środa": return 3;
            case "Czwartek": return 4;
            case "Piątek": return 5;
            case "Sobota": return 6;
            case "Niedziela": return 7;
        }
        return 0;
    }

}
