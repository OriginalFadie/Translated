package net.ureshi.translated.deepl.request;

import com.jayway.jsonpath.JsonPath;
import net.ureshi.translated.Translated;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.checkerframework.checker.units.qual.A;
import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Free extends Event {

    private static final HandlerList HANDLERS = new HandlerList();
    public String text;

    public Free(Translated translated) throws IOException {
        URL url = new URL("https://api-free.deepl.com/v2/translate");
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        http.setRequestMethod("POST");
        http.setDoOutput(true);
        http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        String data = "auth_key=" + translated.auth + "&text=Hello, world!&target_lang=DE";

        byte[] out = data.getBytes(StandardCharsets.UTF_8);

        OutputStream stream = http.getOutputStream();
        stream.write(out);

        try (BufferedReader in = new BufferedReader(new InputStreamReader(http.getInputStream()))) {

            String line;
            StringBuilder response = new StringBuilder();

            while ((line = in.readLine()) != null) {
                response.append(line);
            }

            Map<String, String> body = new HashMap<>();

            for (int i = 0; i <response.length();)
            {
                body.put(response.substring(i, ++i), response.substring(i, ++i));
            }
            ArrayList<String> arrayList = new ArrayList<>();

            for (int j = 1; j <= body.size(); j++)
                arrayList.add(body.get(j));

            JSONObject json = new JSONObject(response.toString());


            text = JsonPath.read(json, "$.translations[0].text");

        } catch (ParseException e) {
            e.printStackTrace();
        }


        System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
        http.disconnect();


    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }

}
