package web.service;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarServiceImp implements CarService {
    private List<Car> carList = new ArrayList<>();

    @Override
    public void addCar(Car car) {
        carList.add(car);
    }

    @Override
    public List<Car> listCarsFromRequest(int count) {
        return carList.subList(0, count);
    }
}
