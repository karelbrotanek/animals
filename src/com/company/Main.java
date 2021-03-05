package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("animals.csv"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("ukol1.txt"));
        BufferedReader br2 = new BufferedReader(new FileReader("animal_types.csv"));
        String line;
        Map<String, String> typ = new HashMap<String, String>();
        while ((line = br2.readLine()) != null){
            String[] pole = line.split(";");
            typ.put(pole[0], pole[1]);
        }
        String firstline = br.readLine();
        System.out.println(firstline);
        bw.write("JMÉNO_ZVÍŘETE;TYP_ZVÍŘETE;GENDER");
        bw.newLine();
        while ((line = br.readLine()) != null){// doku není na konci souboru
            String[] pole = line.split(";");
            if (pole[5].equals("Y")){
                System.out.println(line);
                bw.write(pole[2] + ";" + typ.get(pole[1]) + ";" + pole[4]);
                bw.newLine();
            }
        }
        /*
        2. část úkolu spočívá v uložení (např. do `ukol2.txt`) všech osob s počtem vlastněných zvířat.
                Jedna řádka by měla vypadat tak to (samozřejmě výsledný `txt` soubor bude mít víc řádků):
        JMÉNO;PŘÍJMENÍ;POČET_VLASTNĚNÝCH_ZVÍŘAT
        */
        //BufferedReader br3 = new BufferedReader(new FileReader(""));
        /*
        3. část úkol spočívá v nalezení nevalidních relací mezi zvířetem a osobo. Zvíře smí mít právě
        jednoho „vlastníka“. Bohužel pár záznamů jsou nekorektní. Kolik jich je? Výsledek stačí
        vypsat.
        4. část úkol spočívá v uložení (např. do ukol4.txt) výpočet průměrného věku mazlíčků, který
        daná osoba vlastní. Výstup by měl vypadat tak to:
        JMÉNO_VLASTNÍKA;PRŮMĚRNÝ_VĚK_ZVÍŘAT
        5. část úkol spočívá ve rozdělení všech zvířat. Výstup by měl být 10 různých souborů (např.
                Dog.txt, Cat.txt atd.). V každém souboru budou vyfiltrované zvířata správného typu.
         */
    }
}