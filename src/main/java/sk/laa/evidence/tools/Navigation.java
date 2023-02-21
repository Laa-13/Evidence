package sk.laa.evidence.tools;

public class Navigation {
    Tools tools = new Tools();
    ClientTools clientTools = new ClientTools();
    private final UserTools userTools;

    public Navigation(UserTools userTools) {
        this.userTools = userTools;
    }

    public void mainMenu() {
        String pokracovat = "edit";
        String dalsi = "ano";
        while (userTools.isUser() || userTools.isAdmin()) {
            System.out.println("""
                    ==============================
                        [1] - Pridat zaznam
                        [2] - Zobrazit zaznamy
                        [3] - Vyhladat zaznam
                        [4] - Admin menu
                        [5] - Odhlasit
                        [6] - Konec
                        --------------------
                        [7] - Vytvorenie dtb
                    ==============================
                    """);
            switch (tools.onlyNumber()) {
                case 1 -> {
                    System.out.println("pridaj poistenca");
                    while (pokracovat.equals("edit")) {
                        clientTools.addData();
                        pokracovat = tools.allCharacters().toLowerCase();
                        if (pokracovat.equals("edit")) {
                            System.out.println("oprav hodnoty");
                            clientTools.removeLast();
                        }
                    }
                    pokracovat = "edit";
                }
                case 2 -> {
                    pokracovat = "vymaz";
                    System.out.println("Vypis vsetkych poistencov");
                    while (pokracovat.equals("vymaz")) {
                        clientTools.showData();
                        System.out.println("[Enter] Pokracovat. vymaz = Vymazat zaznam.");
                        pokracovat = tools.allCharacters().toLowerCase();
                        if (pokracovat.equals("vymaz")) {
                            System.out.println("Zadaj ID zaznamu na vymaz.");
                            clientTools.removeData();
                        }
                    }
                    pokracovat = "edit";
                }
                case 3 -> {
                    while (dalsi.equals("ano")) {
                        clientTools.searchData();
                        System.out.println("""
                                Mam hladat dalej?
                                [Enter] - Navrat. ano - Hladat znova.
                                """);
                        dalsi = tools.allCharacters();
                    }
                    dalsi = "ano";
                }
                case 4 -> adminMenu();
                case 5 -> {
                    userTools.logout();
                    userTools.checkPassword();
                }
                case 6 -> userTools.logout();
                case 7 -> clientTools.testSubjects();
            }
        }
    }

    private void adminMenu() {
        boolean menu = true;
        if (!userTools.isAdmin()) {
            System.out.println("Nemas pravo prehliadat tuto sekciu.");
        } else {
            while (menu) {
                System.out.println("""
                        ========================
                            [1] - Pridaj uzivatelov
                            [2] - Zobraz uzivatela
                            [3] - Vymazat uzivatela
                            [4] - Vymazat admina
                            [5] - Navrat do menu
                        """);
                switch (tools.onlyNumber()) {
                    case 1 -> userTools.addUser();
                    case 2 -> userTools.showUsers();
                    case 3 -> userTools.deleteUser();
                    case 4 -> userTools.deleteAdmin();
                    case 5 -> {
                        System.out.println("Navrat do menu!");
                        menu = false;
                    }
                }
            }
        }
    }
}
