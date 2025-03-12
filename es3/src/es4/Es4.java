package es4;

import java.util.*;
import java.io.*;

public class Es4 {
    public static void main(String[] args){
        try{
            Scanner in=new Scanner(System.in);
            System.out.println("Inserire il nome del file d'origine: ");
            BufferedReader reader=new BufferedReader(new FileReader("src/es4/"+in.next()));
            String next;
            int index=-1;
            double [][] matrice = null;
            while ((next= reader.readLine())!=null){
                String [] numeri=next.split("\\s+");
                if (index==-1 && numeri.length>=2)
                    matrice = new double[Integer.parseInt(numeri[0])][Integer.parseInt(numeri[1])];
                else{
                    for (int i=0;i<matrice[0].length;i++)
                        matrice[index][i] = Double.parseDouble(numeri[i]);

                }
                index++;
            }
            reader.close();
            in.close();
            PrintWriter writer=new PrintWriter(new FileWriter("src/es4/trasposta.dat",false));
            for (int i=0;i<matrice[0].length;i++){
                for (int p=0;p< matrice.length;p++){
                    writer.print(matrice[p][i]+"  ");
                }
                writer.println();
            }
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
