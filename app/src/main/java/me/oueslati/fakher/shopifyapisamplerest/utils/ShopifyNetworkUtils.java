package me.oueslati.fakher.shopifyapisamplerest.utils;

import android.net.Uri;
import android.util.Base64;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Fakher Oueslati on 5/21/2017.
 */

public class ShopifyNetworkUtils {
    private static String TAG = ShopifyNetworkUtils.class.getSimpleName();
    private static String API_KEY = "e9f6024ba5acc7f290b4d43ffc779396";
    private static String API_SECRET = "6eb6f31a9d39284b835af4484b10d45a";
    private static String BASE_URL = "https://ftvsotre.myshopify.com";

    private static String GET_ALL_PRODUCTS_END_POINT = "admin/products.json";
    public static URL buildURLWithGetAllProducts() {

        Uri queryUri = Uri.parse(BASE_URL).buildUpon()
                .appendEncodedPath(GET_ALL_PRODUCTS_END_POINT)
                .build();
        try {
            return new URL(queryUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getResponseFromHttpUrl(URL url) throws IOException {

        String credentials = API_KEY + ":" + API_SECRET;
        String credBase64 =
                "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestProperty("Authorization", credBase64);
        Log.v(TAG, "getResponseFromHttpUrl - URL:" + url.toString());
        InputStream in = urlConnection.getInputStream();
        Scanner scanner = new Scanner(in);
        scanner.useDelimiter("\\A");
        boolean hasInput = scanner.hasNext();
        String response = null;
        if (hasInput) {
            response = scanner.next();
        }
        Log.v(TAG, "getResponseFromHttpUrl - Response: " + response);
        return response;
    }
}
