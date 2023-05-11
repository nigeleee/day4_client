package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cookie {
    //create arraylist for cookies
    
   List<String> cookiesList = new ArrayList<>();

   public void readCookie(String fileName) throws IOException  {
    
     //read from file
    FileReader fr = new FileReader(fileName);
    BufferedReader br = new BufferedReader(fr);
   
    String cookiesText = "";


    while ((cookiesText = br.readLine()) != null) {
         //store in arraylist
        cookiesList.add(cookiesText);

       
    } 

    br.close();
    fr.close();
}


    //create random cookies method
   public String cookieText() {
    Random random = new Random();
    if (cookiesList == null) {
        return "There is no cookie";

    } else {
        String randomCookie = cookiesList.get(random.nextInt(cookiesList.size()));
        return randomCookie;
    }

   }

   

}   








