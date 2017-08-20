package com.car_race;
import java.net.*;
import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

public class ReadUrl {
    private static List<String> car_names;

    public ReadUrl()  throws Exception{
        car_names = otherread();
    }

    public static List otherread() throws Exception {
        URLConnection connection = new URL("http://www.fantasynamegenerators.com/scripts/carNames.js").openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
        connection.connect();

        BufferedReader r  = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("UTF-8")));

        StringBuilder sb = new StringBuilder();
        String line;
        int count= 0;
        while ((line = r.readLine()) != null) {
            if(count == 0) {
                sb.append(line);
                count++;
                break;
            }
        }
        String variable_string = sb.toString().substring(11);
        String[] every_car_name = variable_string.substring(0,variable_string.length()-2).replaceAll("\"", "").split(",");
        car_names = Arrays.asList(every_car_name);
        return  car_names;
    }

    public List getCar_names() {
        return car_names;
    }
}