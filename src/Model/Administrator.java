package Model;

import Widok.DialogiZUżytkownikiem;

import java.util.Scanner;

public class Administrator {
    private static String login="admin";
    private static String hasło="admin123";
    private static DialogiZUżytkownikiem dialogiZUżytkownikiem=new DialogiZUżytkownikiem();

    public static boolean sprawdzLoginIHasło()
    {
        boolean poprawnyLogin=false;
        boolean poprawneHaslo;
        Scanner wejscie = new Scanner (System.in);
        String l="";
        int i=3;
        while(!poprawnyLogin && i>0)
        {
                try{
                    dialogiZUżytkownikiem.podajLogin();
                    l=wejscie.nextLine();
                }
                catch(IllegalArgumentException e)
                {
                    dialogiZUżytkownikiem.pojawilSieBlad();

                }
                poprawneHaslo=sprawdzHasło();
                if(l.equals(login) &&poprawneHaslo) return true;
                else dialogiZUżytkownikiem.niepoprawnyLoginLubHaslo();
                i--;
            }
        return false;
        }

       private static boolean sprawdzHasło()
        {
            Scanner wejscie = new Scanner (System.in);
            String h="";
                try{
                    dialogiZUżytkownikiem.podajHaslo();
                    h=wejscie.nextLine();
                }
                catch(IllegalArgumentException e)
                {
                    dialogiZUżytkownikiem.pojawilSieBlad();

                }
                return h.equals(hasło);
    }


}

