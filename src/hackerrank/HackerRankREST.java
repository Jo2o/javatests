package hackerrank;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class HackerRankREST {

    public static void main(String[] args) throws IOException {

        getTotalGoals("Barcelona", 2011);


    }

    static void getTotalGoals(String team, int year) throws IOException {
        String urlBase = "https://jsonmock.hackerrank.com/api/football_matches";
        URL urlHome = new URL(urlBase + "?year=" + year + "&team1=" + team);
        URL urlVisit = new URL(urlBase + "?year=" + year + "&team2=" + team);
        HttpURLConnection conHome = (HttpURLConnection) urlHome.openConnection();
        HttpURLConnection conVisit = (HttpURLConnection) urlVisit.openConnection();
        conHome.setRequestMethod("GET");
        conVisit.setRequestMethod("GET");
        conHome.setRequestProperty("Content-Type", "application/json");
        conVisit.setRequestProperty("Content-Type", "application/json");

        BufferedReader in = new BufferedReader(new InputStreamReader(conHome.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        conHome.disconnect();
        conVisit.disconnect();

    }



}
