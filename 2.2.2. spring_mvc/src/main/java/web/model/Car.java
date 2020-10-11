package web.model;

public class Car {
    private Integer id;
    private String color;
    private String model;

    public Car(Integer id, String color, String model) {
        this.id = id;
        this.color = color;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
