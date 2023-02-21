package sk.laa.evidence;

import sk.laa.evidence.tools.Navigation;
import sk.laa.evidence.tools.UserTools;

public class Main {

    public static void main(String[] args) {

        UserTools userTools = new UserTools();
        Navigation navigation = new Navigation(userTools);


        System.out.print("""
                                    
                =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                Aplikacia : Evidencia poistencov - jednoducha verzia.
                                
                Aplikacia vytvorena ako projekt ku zaverecnej skuske
                rekvalifikacneho kurzu ITnetwork. Program dokaze
                ulozit novy zaznam poistenca, zobrazit existujuci
                zaznam poistenca, vypisat list vsetkch poistencov
                a mazat existujuce zaznamy podla potreby. Program
                funguje na principe uzivatel / administrator. Po
                spusteni je potrebne registrovat admina na obsluhu
                aplikacie a vytvaranie novych uzivatelov s roznymi
                pravami.
                                    
                Dakujem. Janko
                =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                                    
                                    
                """);

        userTools.firstAdmin();
        userTools.checkPassword();
        navigation.mainMenu();


    }
}
