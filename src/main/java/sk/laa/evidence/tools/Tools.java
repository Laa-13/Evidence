package sk.laa.evidence.tools;

import sk.laa.evidence.enumeration.Gender;

import java.util.Scanner;

public class Tools {
    // SCANNER
    Scanner scanner = new Scanner(System.in);

    // PRE NEPOSLUSNYCH LUDI
    public int onlyNumber() {
        int num = 0;
        while (num == 0) {
            String s = scanner.nextLine();
            try {
                num = Integer.parseInt(s);
            } catch (Exception e) {
                System.out.println("Vstup musi byt cislo!");
            }
        }
        return num;
    }

    // IBA ABECEDA
    public String onlyText() {
        String abc = scanner.nextLine().trim();
        while (!abc.matches("[a-zA-ZěĚšŠčČřŘžŽýÝáÁíÍéÉůúÚťŤ]*")) {
            System.out.println("Vstup musi obsahovat iba znaky abecedy!");
            abc = scanner.nextLine().trim();
        }
        return abc;
    }

    // VSETKO DOKOPY
    public String allCharacters() {
        return scanner.nextLine().trim();
    }

    // POMOC S ENUMOM
    public Gender gender() {
        switch (onlyText()) {
            case "muz" -> {
                return Gender.muz;
            }
            case "zena" -> {
                return Gender.zena;
            }
            default -> {
                System.out.println("Pohlavie nechcem uviest");
                return Gender.tajne;
            }
        }
    }
}
