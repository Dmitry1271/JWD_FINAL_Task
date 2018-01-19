package by.tr.web.entity.appliance;

import java.math.BigDecimal;

/**
 * Created by cplus on 18.01.2018.
 */
public class Televisor extends Appliance {
    private static final long serialVersionUID = 8314974542557352118L;

    private double height;
    private double width;
    private String quality;

    public Televisor() {
    }

    public Televisor(long id, String model, BigDecimal price, int numberAvailable, String imagePath, BigDecimal discount,
                     double height, double width, String quality, String type, double rating) {
        super(id, model, price, numberAvailable, imagePath, discount, type, rating);
        this.height = height;
        this.width = width;
        this.quality = quality;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Televisor televisor = (Televisor) o;

        if (Double.compare(televisor.height, height) != 0) return false;
        if (Double.compare(televisor.width, width) != 0) return false;
        return quality != null ? quality.equals(televisor.quality) : televisor.quality == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(width);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (quality != null ? quality.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Televisor{" +
                "height=" + height +
                ", width=" + width +
                ", quality='" + quality + '\'' +
                '}';
    }
}
