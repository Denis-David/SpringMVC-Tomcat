package web.service;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;

public class ServiceCarImpl implements ServiceCar {
    private List<Car> cars = new ArrayList<>();
    public static String[] models = {"BMV", "Audi", "Mers", "Lada", "Honda"};

    @Override
    public List<Car> findSome() {
        return findThreeCar();
    }

    private List<Car> findThreeCar() {


        String[] colors = {"black", "White", "Yellow", "Синяя", "Красная"};
        for (int i = 0; i < models.length; i++) {
            cars.add(new Car(i, colors[i], models[i]));
        }
        return cars;
    }
}
