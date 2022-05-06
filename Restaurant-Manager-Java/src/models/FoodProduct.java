package models;

import java.math.BigDecimal;
import java.util.Collection;

public class FoodProduct {
    private int _id;
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

    public void setId(int _id) {
        this._id = _id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public String getType() {
        return _type;
    }

    public void setType(String _type) {
        this._type = _type;
    }

    public String getPictureUrl() {
        return _pictureUrl;
    }

    public void setPictureUrl(String _pictureUrl) {
        this._pictureUrl = _pictureUrl;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String _description) {
        this._description = _description;
    }

    public BigDecimal getPrice() {
        return _price;
    }

    public void setPrice(BigDecimal _price) {
        this._price = _price;
    }

    public Boolean getIsEnabled() {
        return _isEnabled;
    }

    public void setIsEnabled(Boolean _isEnabled) {
        this._isEnabled = _isEnabled;
    }

    public Collection<String> getIngredients() {
        return _ingredients;
    }

    public void setIngredients(Collection<String> _ingredients) {
        this._ingredients = _ingredients;
    }
}
