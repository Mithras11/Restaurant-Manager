package models;

import java.math.BigDecimal;
import java.util.Collection;

public class FoodProduct {
    private final int _id;
    private String _name;
    private String _type;
    private String _pictureUrl;
    private String _description;
    private BigDecimal _price;
    private Boolean _isEnabled;
    private Collection<String> _ingredients;

    public FoodProduct(
            int id, String name, String type, String pictureUrl,
            String description, BigDecimal price,
            Boolean isEnabled, Collection<String> ingredients) {
        _id = id;
        _name = name;
        _type = type;
        _pictureUrl = pictureUrl;
        _description = description;
        _price = price;
        _isEnabled = isEnabled;
        _ingredients = ingredients;
    }

    public int getId() {
        return _id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getType() {
        return _type;
    }

    public void setType(String type) {
        _type = type;
    }

    public String getPictureUrl() {
        return _pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        _pictureUrl = pictureUrl;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public BigDecimal getPrice() {
        return _price;
    }

    public void setPrice(BigDecimal price) {
        _price = price;
    }

    public Boolean getIsEnabled() {
        return _isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        _isEnabled = isEnabled;
    }

    public Collection<String> getIngredients() {
        return _ingredients;
    }

    public void setIngredients(Collection<String> ingredients) {
        _ingredients = ingredients;
    }
}
