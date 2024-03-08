package de.exxcellent.challenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;

public class Controller {
    String resultWeather;
    String resultFootball;

    public void extractDayMinMax() throws IOException{
        BufferedReader fr = null;
        BufferedWriter fw = null;

        try {
            fr = new BufferedReader(new FileReader("programming-challenge-challenge-weatherdata\\src\\main\\resources\\de\\exxcellent\\challenge\\weather.csv"));
            fw = new BufferedWriter(new FileWriter("programming-challenge-challenge-weatherdata\\src\\main\\resources\\de\\exxcellent\\challenge\\DayMinMax.csv"));
            String Zeile;
            String[] temp;
            Boolean flag = false;
            while ((Zeile = fr.readLine())!=null) {
                temp = Zeile.split(",");
                if (flag)
                    fw.write("\n");
                else
                    flag = true;
                fw.write(temp[0] + ", " + temp[1] + ", " +temp[2]);
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

    public String getDaySmallestSpreadWeather() throws IOException{
        
        int diff;
        int smallestDiff=100;
        BufferedReader fr=null;

        try {
            fr = new BufferedReader(new FileReader("programming-challenge-challenge-weatherdata\\src\\main\\resources\\de\\exxcellent\\challenge\\weather.csv"));
            String str;
            String split[];
            int splitCalc[] = new int[3];

            while((str = fr.readLine())!=null){
                if(!str.contains("Day")){
                    split = str.split(",");
               
                    try {
                        for (int i = 0; i < splitCalc.length; i++) {
                            splitCalc[i]=Integer.parseInt(split[i]);
                        }
                        diff=splitCalc[1]-splitCalc[2];
                        if(diff<smallestDiff){
                            smallestDiff=diff;
                            resultWeather = split[0];
                        }
                        
    
                    } catch (InputMismatchException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            if(fr!=null);
                fr.close();
        }

        return this.resultWeather;
    }

    public void extractInfoFootball() throws IOException{
        BufferedReader fr = null;
        BufferedWriter fw = null;
        
        try {
            fr = new BufferedReader(new FileReader("programming-challenge-challenge-weatherdata\\src\\main\\resources\\de\\exxcellent\\challenge\\football.csv"));
            fw = new BufferedWriter(new FileWriter("programming-challenge-challenge-weatherdata\\src\\main\\resources\\de\\exxcellent\\challenge\\TeamGoalsGoalsallowed.csv"));
            String Zeile;
            String[] temp;
            Boolean flag = false;
            String info1 ="Team", info2 = "Goals", info3 = "Goals Allowed";
            int[] ptr = {0,0,0};
            while ((Zeile = fr.readLine())!=null) {
                temp = Zeile.split(",");
                if (flag)
                    fw.write("\n");
                else{
                    
                    for (int i = 0; i<temp.length;i++) {
                        if(temp[i].equals(info1)){
                            ptr[0]=i;
                        }
                        if(temp[i].equals(info2)){
                            ptr[1]=i;
                        }
                        if(temp[i].equals(info3)){
                            ptr[2]=i;
                        }
                    }
                    flag = true;
                }

                fw.write(temp[ptr[0]] + "," + temp[ptr[1]] + "," +temp[ptr[2]]);
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

    public String getDaySmallestSpreadFootball() throws IOException{
        
        int diff;
        int smallestDiff=100;
        BufferedReader fr=null;

        try {
            fr = new BufferedReader(new FileReader("programming-challenge-challenge-weatherdata\\src\\main\\resources\\de\\exxcellent\\challenge\\TeamGoalsGoalsallowed.csv"));
            String str;
            String split[];
            int splitCalc[] = new int[2];

            while((str = fr.readLine())!=null){
                if(!str.contains("Team")){
                    split = str.split(",");
                    try {
                        for (int i = 0; i < splitCalc.length; i++) {
                            splitCalc[i]=Integer.parseInt(split[i+1]);
                        }
                        if ((diff=splitCalc[0]-splitCalc[1])<0) {
                            if((diff=diff*-1)<smallestDiff){
                                smallestDiff=diff;
                                resultFootball = split[0];
                                
                                System.out.println("Negatives Team "+split[0]+ " mit "+diff);
                            }
                            
                        }else{
                            if(diff<smallestDiff){
                                smallestDiff=diff;
                                resultFootball = split[0];
                                System.out.println("Positives Team "+split[0] + " mit "+diff);
                            }
                        }
                    } catch (InputMismatchException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            if(fr!=null);
                fr.close();
        }

        return this.resultFootball;
    }

}
