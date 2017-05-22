package me.oueslati.fakher.shopifyapisamplerest;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.net.URL;

import me.oueslati.fakher.shopifyapisamplerest.model.Product;
import me.oueslati.fakher.shopifyapisamplerest.model.Products;
import me.oueslati.fakher.shopifyapisamplerest.utils.ShopifyJsonUtils;
import me.oueslati.fakher.shopifyapisamplerest.utils.ShopifyNetworkUtils;

public class MainActivity extends AppCompatActivity {
    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.tv);
    }

    public void makeShopifyGetAllProductsQuery(View view) {
        URL url = ShopifyNetworkUtils.buildURLWithGetAllProducts();
        new ShopifyQueryTask().execute(url);
    }
    public class ShopifyQueryTask extends AsyncTask<URL, Void, Products> {
        @Override
        protected Products doInBackground(URL... params) {
            try {
                String response = ShopifyNetworkUtils.getResponseFromHttpUrl(params[0]);
                return ShopifyJsonUtils.getProductsFromJson(response);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Products products) {
            if (products != null && !products.getProducts().isEmpty()) {
                String title = products.getProducts().get(0).getTitle();
                StringBuilder sb = new StringBuilder();
                for (Product p:products.getProducts()) {
                    sb.append(p.getTitle());
                    sb.append("\n");
                }
                mTextView.setText(sb.toString());
            }

        }
    }
}
