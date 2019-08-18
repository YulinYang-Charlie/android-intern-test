package com.charlie.interntest;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Data extends AsyncTask<Void,Void,Void> {

    String data = "";

    int[] id = new int[5000] ;
    String[] url = new String[5000];
    String[] name = new String[5000];
    int[] season = new int[5000];
    int[] number = new int[5000];
    String[] airdate = new String[5000];
    String[] airtime = new String[5000];
    String[] airstamp = new String[5000];
    int[] runtime = new int[5000];
    String[] medium = new String[5000];
    String[] original = new String[5000];
    String[] summary = new String[5000];
    String[] links = new String[5000];

    @Override
    protected Void doInBackground(Void... voids) {

        try {
            URL url1 = new URL("http://api.tvmaze.com/shows/1/episodes");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url1.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line != null)
            {
                line = bufferedReader.readLine();
                data = data + line;
            }

            JSONArray JA= new JSONArray(data);
            JSONObject images;
            for (int i = 0; i < JA.length(); i++) {
                JSONObject JO = JA.getJSONObject(i);
                id[i] = JO.getInt("id");
                url[i] = JO.getString("url");
                name[i] = JO.getString("name");
                season[i] = JO.getInt("season");
                number[i] = JO.getInt("number");
                airdate[i] = JO.getString("airdate");
                airtime[i] = JO.getString("airtime");
                airstamp[i] = JO.getString("airstamp");
                runtime[i] = JO.getInt("runtime");
                images = JO.getJSONObject("image");
                medium[i] = images.getString("medium");
                original[i] = images.getString("original");
                summary[i] = JO.getString("summary");
                links[i] = JO.getJSONObject("_links").getJSONObject("self").getString("href");

            }



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        MainActivity.data.setText(this.data);
    }
}
