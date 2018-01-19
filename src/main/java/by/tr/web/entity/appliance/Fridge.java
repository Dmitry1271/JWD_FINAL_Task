package by.tr.web.entity.appliance;

import java.math.BigDecimal;

/**
 * Created by cplus on 17.01.2018.
 */
public class Fridge extends Appliance{
    private static final long serialVersionUID = 628560058863426567L;

    private String color;
    private double width;
    private double height;
    private double depth;

    public Fridge() {
    }

    public Fridge(long id, String model, BigDecimal price, int numberAvailable, String imagePath, BigDecimal discount,
                  String color, double width, double height, double depth, String type, double rating) {
        super(id, model, price, numberAvailable, imagePath, discount, type, rating);
        this.color = color;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getDepth() {
        return depth;
    }

    public void setDepth(double depth) {
        this.depth = depth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Fridge fridge = (Fridge) o;

        if (Double.compare(fridge.width, width) != 0) return false;
        if (Double.compare(fridge.height, height) != 0) return false;
        if (Double.compare(fridge.depth, depth) != 0) return false;
        return color != null ? color.equals(fridge.color) : fridge.color == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        temp = Double.doubleToLongBits(width);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(depth);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Fridge{" +
                "color='" + color + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", depth=" + depth +
                '}';
    }
}
