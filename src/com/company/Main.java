package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {


        List<Lekarze> lekarzeList = new ArrayList<>();

        try {
            File fileLekarze = new File("src/com/company/pliki/lekarze (1).txt");
            Scanner readerLekarze = new Scanner(fileLekarze);
            readerLekarze.nextLine();
            while (readerLekarze.hasNextLine()) {
                String[] data = readerLekarze.nextLine().trim().split("\t+");
                lekarzeList.add(new Lekarze(Integer.parseInt(data[0]), data[1], data[2], data[3], new SimpleDateFormat("yyyy-MM-dd").parse(data[4]), data[5], data[6]));
            }
            readerLekarze.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error File Lekarze");
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


        List<Pacjenci> pacjenciList = new ArrayList<>();

        try {
            File pacjenciFile = new File("src/com/company/pliki/pacjenci.txt");
            Scanner readerPacjenci = new Scanner(pacjenciFile);
            readerPacjenci.nextLine();
            while (readerPacjenci.hasNextLine()) {
                String[] data = readerPacjenci.nextLine().trim().split("\t");
                pacjenciList.add(new Pacjenci(Integer.parseInt(data[0]), data[1], data[2], data[3], new SimpleDateFormat("yyyy-MM-dd").parse(data[4])));
            }
            readerPacjenci.close();


        } catch (FileNotFoundException e) {
            System.out.println("Error File Pacjenci");
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


        List<Wizyty> wizytyList = new ArrayList<>();

        try {
            File fileWizyty = new File("src/com/company/pliki/wizyty.txt");
            Scanner readerWizyty = new Scanner(fileWizyty);
            readerWizyty.nextLine();
            while (readerWizyty.hasNextLine()) {
                String[] data = readerWizyty.nextLine().trim().split("\t");

                Optional<Lekarze> lekarze = lekarzeList.stream()
                        .filter(l -> l.getIdLekarza() == Integer.parseInt(data[0]))
                        .findFirst();

                Optional<Pacjenci> pacjenci = pacjenciList.stream()
                        .filter(l -> l.getIdPacjenta() == Integer.parseInt(data[1]))
                        .findFirst();


                Wizyty wizyta = new Wizyty(lekarze.get(), pacjenci.get(), new SimpleDateFormat("yyyy-MM-dd").parse(data[2]));

                lekarze.get().addWizytaLekarz(wizyta);

                pacjenci.get().addWizytaPacjenci(wizyta);

                wizytyList.add(wizyta);
            }
            readerWizyty.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error File Wizyty");
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        zadanie1(lekarzeList);
        System.out.println();
        zadanie2(pacjenciList);
        System.out.println();
        zadanie3(wizytyList);
        System.out.println();
        zadanie4(wizytyList);
        System.out.println();
        zadanie5(lekarzeList);
        System.out.println();
        zadanie6(wizytyList);
        System.out.println();
        zadanie7(wizytyList);


    }

    private static void zadanie1(List<Lekarze> lekarze) {
        System.out.println("Zadanie1");
        lekarze.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(System.out::println);
    }

    private static void zadanie2(List<Pacjenci> pacjenci) {
        System.out.println("Zadanie2");
        pacjenci.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(System.out::println);
    }

    private static void zadanie3(List<Wizyty> wizyty) {
        System.out.println("Zadanie3");
        wizyty.stream()
                .map(Wizyty::getLekarze)
                .map(Lekarze::getSpecjalnosc)
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(System.out::println);
    }

    private static void zadanie4(List<Wizyty> wizyty) {
        System.out.println("Zadanie4");
        wizyty.stream()
                .map(Wizyty::getDataWizyty)
                .map(e -> e.getYear() + 1900)
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(System.out::println);
    }

    private static void zadanie5(List<Lekarze> lekarze) {

        System.out.println("Zadanie5");
        lekarze.stream()
                .sorted(Comparator.comparing(Lekarze::getDataUrodzenia, Comparator.nullsLast(Comparator.naturalOrder())))
                .limit(5)
                .forEach(System.out::println);
    }

    private static void zadanie6(List<Wizyty> wizyty) {
        System.out.println("Zadanie6");
        AtomicBoolean checked = new AtomicBoolean(false);
        for (Wizyty w : wizyty) {
            Set<Integer> idLekarzy = wizyty.stream()
                    .filter(e -> w.getPacjenci().getIdPacjenta() == e.getPacjenci().getIdPacjenta())
                    .map(Wizyty::getLekarze)
                    .map(e -> e.getIdLekarza())
                    .collect(Collectors.toSet());
            if (idLekarzy.size() > 5) {
                System.out.println("S¹ pacjenci, którzy mieli wizyty u wiêcej ni¿ 5 lekarzy");
                checked.set(true);
            }
            if (checked.get()) {
                break;
            }
        }
        if (!checked.get()) {
            System.out.println("Nie ma takich pacjentów");
        }
    }

    private static void zadanie7(List<Wizyty> wizyty) {
        System.out.println("Zadanie7");
        for (Wizyty w : wizyty) {
            Set<Integer> pacjent = wizyty.stream()
                    .filter(e -> w.getLekarze().getIdLekarza() == e.getLekarze().getIdLekarza())
                    .map(Wizyty::getPacjenci)
                    .map(e -> e.getIdPacjenta())
                    .collect(Collectors.toSet());
            if (pacjent.size() <= 1) {
                System.out.println("Jest taki pacjent");
                break;
            } else
                System.out.println("Nie ma takiego lekarza");
            break;


        }
    }
}

