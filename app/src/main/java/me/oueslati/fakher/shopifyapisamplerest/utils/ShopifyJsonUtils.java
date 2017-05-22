package me.oueslati.fakher.shopifyapisamplerest.utils;

import com.google.gson.Gson;

import me.oueslati.fakher.shopifyapisamplerest.model.Products;

/**
 * Created by Fakher Oueslati on 5/21/2017.
 */

public class ShopifyJsonUtils {

    public static Products getProductsFromJson(String json) {
        return new Gson().fromJson(json, Products.class);
    }
}
