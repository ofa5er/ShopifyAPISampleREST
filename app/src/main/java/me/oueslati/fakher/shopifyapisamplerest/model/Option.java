
package me.oueslati.fakher.shopifyapisamplerest.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Option {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("product_id")
    @Expose
    private Integer productId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("position")
    @Expose
    private Integer position;
    @SerializedName("values")
    @Expose
    private List<String> values = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

}
