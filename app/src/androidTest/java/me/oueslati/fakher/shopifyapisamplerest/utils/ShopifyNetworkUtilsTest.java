package me.oueslati.fakher.shopifyapisamplerest.utils;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Created by Fakher Oueslati on 5/21/2017.
 */
@RunWith(AndroidJUnit4.class)
public class ShopifyNetworkUtilsTest {

        @Test
        public void buildURLWithGetAllProducts_isCorrect(){
            String expectedURLString =
                    "https://d1945bb9449364f31894409218672bdc:3c74e4899f104065a304996d5e8d2e53@ftvsotre.myshopify.com/admin/products.json";
            String actualURLString = "";
            actualURLString = ShopifyNetworkUtils.buildURLWithGetAllProducts().toString();
            assertEquals(expectedURLString, actualURLString);
        }
}
