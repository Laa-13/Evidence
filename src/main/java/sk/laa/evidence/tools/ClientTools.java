package sk.laa.evidence.tools;

import sk.laa.evidence.enumeration.Gender;
import sk.laa.evidence.source.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientTools {
    private final Tools tools = new Tools();

    List<Client> clientList = new ArrayList<>();

    //     ZAPIS KLIENTA DO DATABAZY
    public void addData() {
        System.out.println("zadaj meno");
        String input1 = tools.onlyText();
        System.out.println("zadaj priezvisko");
        String input2 = tools.onlyText();
        System.out.println("muz / zena ; [Enter] - nechcem uviest");
        Gender input3 = tools.gender();
        System.out.println("zadaj vek");
        Integer input4 = tools.onlyNumber();
        System.out.println("zadaj email");
        String input5 = tools.allCharacters();
        System.out.println("zadaj telefon");
        Integer input6 = tools.onlyNumber();

        clientList.add(new Client(input1, input2, input3, input4, input5, input6));

        //     KONTROLA ZADANIA A POTVRDENIE
        System.out.println("===== Su hodnoty zadane spravne? =====");
        System.out.println(clientList.get(clientList.size() - 1));
        System.out.println("[Enter] Uloz zaznam. edit = Edituj zaznam.");
    }

    //     VYPIS VSETKYCH ZAZNAMOV
    public void showData() {
        for (int i = 0; i <= (clientList.size() - 1); i++) {
            System.out.println("ID:\t" + (i + 1) + " | " + clientList.get(i));
        }
    }

    //      ODSTRANENIE POSLEDNEHO ZAZNAMU
    public void removeLast() {
        clientList.remove(clientList.size() - 1);
    }

    //      ODSTRANENIE ZVOLENEHO ZAZNAMU
    public void removeData() {
        if (clientList.size() == 0) {
            System.out.println("\n Ziadny zaznam na vymazanie. \n");
        } else {
            int id = tools.onlyNumber() - 1;
            if (id > clientList.size() - 1) {
                System.out.println("Zadaj ID podla poctu zaznamov.");
                removeData();
            } else {
                clientList.remove(id);
                System.out.println("Zaznam vymazany.");
            }
        }
    }

    //    VYHLADANIE ZAZNAMU
    public void searchData() {
        System.out.println("""
                Zaznam vyhladam podla:
                    1) Mena
                    2) Priezviska
                    3) Tel. cisla
                    4) Emailu
                """);
        switch (tools.onlyNumber()) {
            case 1 -> {
                System.out.println("Hladam podla mena.");
                String search = tools.allCharacters().toLowerCase();
                clientList.stream()
                        .filter(klient -> klient.getName().toLowerCase().startsWith(search))
                        .toList()
                        .forEach(System.out::println);
            }
            case 2 -> {
                System.out.println("Hladam podla priezviska.");
                String search = tools.allCharacters().toLowerCase();
                clientList.stream()
                        .filter(klient -> klient.getSurname().toLowerCase().startsWith(search))
                        .toList()
                        .forEach(System.out::println);
            }
            case 3 -> {
                System.out.println("Hladam podla tel. cisla.");
                Integer search = Integer.parseInt(tools.allCharacters());
                clientList.stream()
                        .filter(klient -> klient.getTel().equals(search))
                        .toList()
                        .forEach(System.out::println);
            }
            case 4 -> {
                System.out.println("Hladam podla Emailu.");
                String search = tools.allCharacters().toLowerCase();
                clientList.stream()
                        .filter(klient -> klient.getEmail().toLowerCase().startsWith(search))
                        .toList()
                        .forEach(System.out::println);
            }
            default -> System.out.println("Zadaj cislo podla legendy");
        }
    }

    // TEST SUBJECTS
    public void testSubjects() {
        System.out.println("""
                =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                  Vytvaram databazu poistencov, len tak pre radost.
                =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
                """);
        clientList.add(new Client("Janko", "Špánik", Gender.muz, 20, "janko@mail.sk", 123456789));
        clientList.add(new Client("Gabriela", "Úžasná", Gender.zena, 19, "gabriela@mail.sk", 435892743));
        clientList.add(new Client("Jozef", "Brokolica", Gender.muz, 42, "jozef@mail.sk", 759473409));
        clientList.add(new Client("Joris", "Nederland", Gender.muz, 48, "joris@mail.sk", 283625390));
        clientList.add(new Client("Romana", "Stratená", Gender.zena, 19, "romana@mail.sk", 489384002));
        clientList.add(new Client("Boris", "Britva", Gender.muz, 51, "boris@mail.sk", 338924850));
        clientList.add(new Client("Klaudia", "Ostrá", Gender.zena, 16, "klaudia@mail.sk", 994012012));
        clientList.add(new Client("Martina", "Neverná", Gender.zena, 18, "martina@mail.sk", 743002232));
        clientList.add(new Client("Pegy", "Nestabilná", Gender.zena, 17, "pegy@mail.sk", 840378448));
        clientList.add(new Client("Sergej", "Britva", Gender.muz, 53, "sergej@mail.sk", 490487443));
        clientList.add(new Client("Kristina", "Obláčiková", Gender.zena, 18, "kristina@mail.sk", 478477421));
        clientList.add(new Client("Brandon", "Walsh", Gender.muz, 74, "brandon@mail.sk", 902100000));
        clientList.add(new Client("Arnold", "Terminátor", Gender.muz, 81, "arnold@mail.sk", 644203345));
        clientList.add(new Client("James", "Bond", Gender.muz, 61, "007@mail.sk", 007007007));
        clientList.add(new Client("Eliška", "Zdravá", Gender.zena, 16, "eliska@mail.sk", 843234054));
        clientList.add(new Client("Ondrej", "Perník", Gender.muz, 35, "pernik@mail.sk", 393939393));
        clientList.add(new Client("Maggie", "Opilá", Gender.zena, 13, "maggie@mail.sk", 760443876));
        clientList.add(new Client("Peter", "Labilný", Gender.muz, 30, "peter@mail.sk", 859403456));
        clientList.add(new Client("Kitty", "Drzá", Gender.zena, 13, "kitty@mail.sk", 757484943));
        clientList.add(new Client("Peter", "Ďalší", Gender.muz, 78, "peter.next@mail.sk", 753008751));
        clientList.add(new Client("Gunter", "Kominár", Gender.muz, 54, "gunter@mail.sk", 879684032));
    }
}
