package sk.laa.evidence.tools;

import java.util.HashMap;
import java.util.Map;

public class UserTools {
    Tools tools = new Tools();
    Map<String, String> userLogin = new HashMap<>();
    Map<String, String> adminLogin = new HashMap<>();
    private boolean isUser = false;
    private boolean isAdmin = false;

    public boolean isUser() {
        return isUser;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    // ZAPIS NOVEHO POUZIVATELA
    public void addUser() {
        System.out.println("Zadaj meno pouzivatela");
        String input1 = tools.allCharacters();
        System.out.println("Zadaj heslo pouzivatela");
        String input2 = tools.allCharacters();
        System.out.println("""
                ------------------------------------------
                Budde mat uzivatel administratorske prava?
                        [1] - ANO | [2] - NIE
                """);

        // PRIDANIE DO MAPY
        switch (tools.onlyNumber()) {
            case 1 -> {
                //     ADMIN
                if (adminLogin.containsKey(input1)) {
                    System.out.printf("""
                            =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                            Pridanie uzivatela sa nepodarilo.
                            Uzivatel %s je uz v databaze.
                            =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                            """, input1);
                } else {
                    adminLogin.put(input1, input2);
                    System.out.printf("Vytvoreny uzivatel %s", input1);
                }
            }
            case 2 -> {
                //     USER
                if (userLogin.containsKey(input1)) {
                    System.out.printf("""
                            =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                            Pridanie uzivatela sa nepodarilo.
                            Uzivatel %s je uz v databaze.
                            =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                            """, input1);
                } else {
                    userLogin.put(input1, input2);
                    System.out.printf("Vytvoreny uzivatel %s", input1);
                }
            }
            default -> System.out.println("Zadaj cislo podla legendy.");
        }
    }

    // VYTVORENIE PRVEHO ADMINA
    public void firstAdmin() {
        if (adminLogin.isEmpty()) {
            System.out.println("""
                    Aplikacia zatial nema administratora, vytvorime ho.
                    Zadaj login:
                    """);
            String firstLogin = tools.allCharacters();
            System.out.println("Zadaj heslo:");
            String firstPassword = tools.allCharacters();

            adminLogin.put(firstLogin, firstPassword);
        }
    }

    //     VYPIS VSETKYCH ZAZNAMOV
    public void showUsers() {
        System.out.println("List pouzivatelov: ");
        for (String i : (userLogin.keySet())) {
            String j = userLogin.get(i);
            System.out.printf("=-\tUsername: %s , Password: %s\t-=\n", i, j);
        }
        System.out.println("List administratorov: ");
        for (String i : (adminLogin.keySet())) {
            String j = adminLogin.get(i);
            System.out.printf("=-\tUsername: %s , Password: %s\t-=\n", i, j);
        }
    }

    // KONTROLA MENA A HESLA A NASLEDNE UDELENIE PRAV
    public void checkPassword() {
        System.out.println("== Prihlasenie ==");
        System.out.println("Username");
        String inputLogin = tools.allCharacters();
        System.out.println("Password");
        String inputPassword = tools.allCharacters();

        if (userLogin.containsKey(inputLogin) & inputPassword.equals(userLogin.get(inputLogin))) {
            isUser = true;
        }
        if (adminLogin.containsKey(inputLogin) & inputPassword.equals(adminLogin.get(inputLogin))) {
            isAdmin = true;
        }
    }

    // ODHLASENIE UZIVAELA
    public void logout() {
        isUser = false;
        isAdmin = false;
    }

    // ODSTRANENIE USERA
    public void deleteUser() {
        System.out.println("Zadaj login uzivatela na vymazanie.");
        String input = tools.allCharacters();
        if (!userLogin.containsKey(input)) {
            System.out.println("Uzivatel nebol najdeny.");
        } else {
            userLogin.remove(input);
            System.out.printf("Uzivatel %s bol vymazany.\n", input);

        }
    }

    // ODSTRANENIE ADMINA
    public void deleteAdmin() {
        System.out.println("Zadaj login uzivatela na vymazanie.");
        String input = tools.allCharacters();
        if (!adminLogin.containsKey(input)) {
            System.out.println("Uzivatel nebol najdeny.");
        } else {
            adminLogin.remove(input);
            System.out.printf("Uzivatel %s bol vymazany.\n", input);

        }
    }
}