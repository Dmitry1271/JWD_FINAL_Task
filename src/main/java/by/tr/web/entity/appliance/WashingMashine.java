package by.tr.web.entity.appliance;

import java.math.BigDecimal;

/**
 * Created by cplus on 18.01.2018.
 */
public class WashingMashine extends Appliance {
    private static final long serialVersionUID = -8191041882083702994L;

    private String color;
    private double height;
    private double width;
    private double depth;
    private int velocity;

    public WashingMashine() {
    }

    public WashingMashine(long id, String model, BigDecimal price, int numberAvailable, String imagePath, BigDecimal discount,
                          String color, double height, double width, double depth, int velocity, String type, double rating) {
        super(id, model, price, numberAvailable, imagePath, discount, type, rating);
        this.color = color;
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.velocity = velocity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        WashingMashine that = (WashingMashine) o;

        if (Double.compare(that.height, height) != 0) return false;
        if (Double.compare(that.width, width) != 0) return false;
        if (Double.compare(that.depth, depth) != 0) return false;
        if (velocity != that.velocity) return false;
        return color != null ? color.equals(that.color) : that.color == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(width);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(depth);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + velocity;
        return result;
    }

    @Override
    public String toString() {
        return "WashingMashine{" +
                "color='" + color + '\'' +
                ", height=" + height +
                ", width=" + width +
                ", depth=" + depth +
                ", velocity=" + velocity +
                '}';
    }
}
