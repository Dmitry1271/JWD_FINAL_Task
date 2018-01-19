package by.tr.web.entity.appliance;

import java.math.BigDecimal;

/**
 * Created by cplus on 18.01.2018.
 */
public class Microwave extends Appliance {
    private static final long serialVersionUID = 2101183387059691045L;

    private String color;
    private int power;
    private double height;
    private double width;
    private double depth;

    public Microwave() {
    }

    public Microwave(long id, String model, BigDecimal price, int numberAvailable, String imagePath, BigDecimal discount,
                     String color, int power, double height, double width, double depth, String type, double rating) {
        super(id, model, price, numberAvailable, imagePath, discount, type, rating);
        this.color = color;
        this.power = power;
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Microwave microwave = (Microwave) o;

        if (power != microwave.power) return false;
        if (Double.compare(microwave.height, height) != 0) return false;
        if (Double.compare(microwave.width, width) != 0) return false;
        if (Double.compare(microwave.depth, depth) != 0) return false;
        return color != null ? color.equals(microwave.color) : microwave.color == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + power;
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(width);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(depth);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Microwave{" +
                "color='" + color + '\'' +
                ", power=" + power +
                ", height=" + height +
                ", width=" + width +
                ", depth=" + depth +
                '}';
    }
}
