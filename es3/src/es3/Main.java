package es3;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{
            Scanner in=new Scanner(System.in);
            String [] dati = {"Paolo Rossi", "Torino", "13/7/71", "essere ammesso", "12/5/2017"};
            List<Character> num = List.of('1', '2','3','4','5','6','7','8','9','0');

            System.out.println("Inserire il nome del file d'origine: ");
            BufferedReader reader=new BufferedReader(new FileReader("src/es3/"+in.next()));
            System.out.println("Inserire il nome del file d'uscita: ");
            PrintWriter writer=new PrintWriter(new FileWriter("src/es3/"+in.next(),true));
            String next;
            String output;
            while ((next = reader.readLine()) != null) {
                output = "";
                for (int i=0; i<next.length(); i++) { //Scorro in tutte le lettere della parola
                    if (next.charAt(i)=='#') {//se c'è un #
                        String numero = "";
                        while (++i<next.length() && num.contains(next.charAt(i))) { //Salvo tutti i numeri che lo seguono
                            numero = numero + next.charAt(i);
                        }
                        if (Integer.parseInt(numero) >= dati.length) { //Controllo se è nei dati passati
                            if (i<next.length()) //Siamo a fine frase?
                                output = output + "..." + next.charAt(i);
                            else
                                output = output + "...";
                        } else {
                            if (i<next.length()) //Siamo a fine frase?
                                output = output + dati[Integer.parseInt(numero)] + next.charAt(i);
                            else
                                output = output + dati[Integer.parseInt(numero)];

                        }
                    } else {
                        output = output + next.charAt(i);
                    }
                }
                writer.println(output);
            }

            writer.flush();
            in.close();
            reader.close();
            writer.close();
        }catch (RuntimeException e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }catch (IOException e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }catch (Exception e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}