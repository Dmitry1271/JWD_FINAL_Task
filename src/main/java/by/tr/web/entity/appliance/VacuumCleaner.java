package by.tr.web.entity.appliance;

import java.math.BigDecimal;

/**
 * Created by cplus on 18.01.2018.
 */
public class VacuumCleaner extends Appliance {
    private static final long serialVersionUID = -7375655417074054130L;

    private String color;
    private int power;
    private String cleaningType;

    public VacuumCleaner() {
    }

    public VacuumCleaner(long id, String model, BigDecimal price, int numberAvailable, String imagePath, BigDecimal discount,
                         String color, int power, String cleaningType, String type, double rating) {
        super(id, model, price, numberAvailable, imagePath, discount, type, rating);
        this.color = color;
        this.power = power;
        this.cleaningType = cleaningType;
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

    public String getCleaningType() {
        return cleaningType;
    }

    public void setCleaningType(String cleaningType) {
        this.cleaningType = cleaningType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        VacuumCleaner that = (VacuumCleaner) o;

        if (power != that.power) return false;
        if (color != null ? !color.equals(that.color) : that.color != null) return false;
        return cleaningType != null ? cleaningType.equals(that.cleaningType) : that.cleaningType == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + power;
        result = 31 * result + (cleaningType != null ? cleaningType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "VacuumCleaner{" +
                "color='" + color + '\'' +
                ", power=" + power +
                ", cleaningType='" + cleaningType + '\'' +
                '}';
    }
}
