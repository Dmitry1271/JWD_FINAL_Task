package by.tr.web.entity.appliance;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by cplus on 17.01.2018.
 */
public class Appliance implements Serializable {
    private static final long serialVersionUID = -323378061018204242L;

    private long id;
    private String model;
    private BigDecimal price;
    private int numberAvailable;
    private String imagePath;
    private BigDecimal discount;
    private String type;
    private double rating;

    public Appliance() {
    }

    public Appliance(long id, String model, BigDecimal price, int numberAvailable, String imagePath, BigDecimal discount, String type, double rating) {
        this.id = id;
        this.model = model;
        this.price = price;
        this.numberAvailable = numberAvailable;
        this.imagePath = imagePath;
        this.discount = discount;
        this.type = type;
        this.rating = rating;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getNumberAvailable() {
        return numberAvailable;
    }

    public void setNumberAvailable(int numberAvailable) {
        this.numberAvailable = numberAvailable;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Appliance appliance = (Appliance) o;

        if (id != appliance.id) return false;
        if (numberAvailable != appliance.numberAvailable) return false;
        if (Double.compare(appliance.rating, rating) != 0) return false;
        if (model != null ? !model.equals(appliance.model) : appliance.model != null) return false;
        if (price != null ? !price.equals(appliance.price) : appliance.price != null) return false;
        if (imagePath != null ? !imagePath.equals(appliance.imagePath) : appliance.imagePath != null) return false;
        if (discount != null ? !discount.equals(appliance.discount) : appliance.discount != null) return false;
        return type != null ? type.equals(appliance.type) : appliance.type == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + numberAvailable;
        result = 31 * result + (imagePath != null ? imagePath.hashCode() : 0);
        result = 31 * result + (discount != null ? discount.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        temp = Double.doubleToLongBits(rating);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Appliance{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", numberAvailable=" + numberAvailable +
                ", imagePath='" + imagePath + '\'' +
                ", discount=" + discount +
                ", type='" + type + '\'' +
                ", rating=" + rating +
                '}';
    }
}
