package competitiveProgramming.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

import utils.ArrayUtils;
import com.google.gson.*;

public class RequestMovies {

    public static void main(String[] args) {
        String[] arr = getResponseList("spiderman");
        System.out.println(arr.length);
        ArrayUtils.printArray(arr);
    }

    private static String[] getResponseList(String title) {
        ArrayList<String> responses = new ArrayList<>();
        boolean hasMore = true;
        int page = 1;
        String response;
        String url = "https://jsonmock.hackerrank.com/api/movies/search/?Title=" + title + "&page=" + page;
        while (hasMore) {
            response = getResponse(url);
            if(response.length() > 0) {
                if(hasMore(response)) {
                    addToList(response, responses);
                    page++;
                    url = "https://jsonmock.hackerrank.com/api/movies/search/?Title=" + title + "&page=" + page;
                } else {
                    hasMore = false;
                }
            } else {
                hasMore = false;
            }
        }

        responses.sort(String::compareTo);
        return responses.toArray(new String[0]);
    }

    private static boolean hasMore(String response) {
        JsonParser parser = new JsonParser();
        JsonObject o = parser.parse(response).getAsJsonObject();
        JsonArray arr = (JsonArray) o.get("data");

        return arr.size() != 0;
    }

    private static void addToList(String response, ArrayList<String> responses) {
        JsonParser parser = new JsonParser();
        JsonObject o = parser.parse(response).getAsJsonObject();
        JsonArray arr = (JsonArray) o.get("data");

        for(int i=0;i<arr.size();i++) {
            JsonObject obj = parser.parse(String.valueOf(arr.get(i))).getAsJsonObject();
            responses.add(String.valueOf(obj.get("Title")));
        }
    }


    public static String getResponse(String url) {
        StringBuffer response = new StringBuffer();
        URL obj = null;
        try {
            obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response.toString();
    }
}
