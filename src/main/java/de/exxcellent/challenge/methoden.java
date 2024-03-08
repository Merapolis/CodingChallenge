package de.exxcellent.challenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;

public class methoden {
    
    public void sortieren(String filepath, int Spalte1, int Spalte2, int Spalte3) throws IOException{
        BufferedReader fr = null;
        BufferedWriter fw = null;

        try {
            fr = new BufferedReader(new FileReader(filepath));
            fw = new BufferedWriter(new FileWriter("programming-challenge-challenge-weatherdata\\src\\main\\resources\\de\\exxcellent\\challenge\\temp.csv"));
            String Zeile;
            String[] temp;
            Boolean flag = false;
            while ((Zeile = fr.readLine())!=null) {
                temp = Zeile.split(",");
                if (flag)
                    fw.write("\n");
                else
                    flag = true;
                fw.write(temp[Spalte1] + "," + temp[Spalte2] + "," +temp[Spalte3]);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally{
            if(fr!=null)
                fr.close();
            if(fw!=null)
                fw.close();
        }
    }


    public String smallestDiff(String filter) throws IOException{
        BufferedReader fr = null;
        int smallestDiff=100;
        String primaryKey="";
        try {
            fr = new BufferedReader(new FileReader("programming-challenge-challenge-weatherdata\\src\\main\\resources\\de\\exxcellent\\challenge\\temp.csv"));

            String Zeile;
            String[] temp;
            int diff;

            while ((Zeile = fr.readLine())!=null) {
                temp = Zeile.split(",");
                if(!temp[0].matches(filter)){
                    diff=Integer.parseInt(temp[1])-Integer.parseInt(temp[2]);
                    if (Math.abs(diff)<smallestDiff) {
                        smallestDiff=Math.abs(diff);
                        primaryKey = temp[0];
                    }
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        catch(InputMismatchException e){
            System.out.println(e.getMessage());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            if(fr!=null)
                fr.close();
        }

        return primaryKey;
    }
}
