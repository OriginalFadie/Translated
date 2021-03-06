package net.ureshi.translated.deepl.request;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static net.ureshi.translated.Translated.*;

public class Pro extends Event {

    private static final HandlerList HANDLERS = new HandlerList();


    public Pro() throws IOException {
        //Creates a URL connection to the Professional DeepL api
        URL url = new URL("https://api.deepl.com/v2/translate");
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        http.setRequestMethod("POST");
        http.setDoOutput(true);
        http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        //Constructs the URL to be as the user desires
        String data = "auth_key=" + auth + "&text=" + originalText + "&target_lang=JA" + format + split + format;

        byte[] out = data.getBytes(StandardCharsets.UTF_8);

        OutputStream stream = http.getOutputStream();
        stream.write(out);

        try (BufferedReader in = new BufferedReader(new InputStreamReader(http.getInputStream()))) {

            StringBuilder response = new StringBuilder();

            for(String line; (line = in.readLine()) != null; ) {
                // process the line.
                if(line.contains("text")){
                    response.append(line);
                }
            }

            //Extracts only the text that the user sent, but translated
            String[] arrSplit = response.toString().split(":");
            String temp1 = arrSplit[3];
            String temp2 = temp1.substring(0, temp1.length()-4);
            translatedText = temp2.replaceFirst("\"", "");

        }
        System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
        http.disconnect();

    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS;
    }
}
