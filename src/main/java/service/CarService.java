package service;

import dao.BrandDAO;
import dao.CarDAO;
import dao.ColorDAO;
import lombok.Data;
import model.Brand;
import model.Car;
import model.Color;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;


@Named
@Transactional
@ApplicationScoped
@Data
public class CarService {

    @Inject
    CarDAO carDAO;

    @Inject
    ColorDAO colorDAO;

    @Inject
    BrandDAO brandDAO;

    private final static String[] colors;

    private final static String[] brands;

    static {
        colors = new String[10];

        colors[0] = "Black";
        colors[1] = "White";
        colors[2] = "Green";
        colors[3] = "Red";
        colors[4] = "Blue";
        colors[5] = "Orange";
        colors[6] = "Silver";
        colors[7] = "Yellow";
        colors[8] = "Brown";
        colors[9] = "Maroon";

        brands = new String[10];
        brands[0] = "BMW";
        brands[1] = "Mercedes";
        brands[2] = "Volvo";
        brands[3] = "Audi";
        brands[4] = "Renault";
        brands[5] = "Fiat";
        brands[6] = "Volkswagen";
        brands[7] = "Honda";
        brands[8] = "Jaguar";
        brands[9] = "Ford";
    }

    public void edit(Car car) {
        carDAO.update(car);
    }

    public List<Car> getAllCars() {
        return carDAO.getAllCars();
    }

   public List<String> getColorsdb(){
        List<String> ColorsNames=new ArrayList<>();
        for (Color c:
                colorDAO.getAllColors()) {
            ColorsNames.add(c.getColor());
        }
        return ColorsNames;

    }

    public List<String> getBrandsdb(){
        List<String> BrandsName = new ArrayList<>();
        for (Brand b:
                brandDAO.getAllBrands()) {
            BrandsName.add(b.getBrand());
        }
        return BrandsName;
    }

    public List<String> getColors() {
        return Arrays.asList(colors);
    }

    public List<String> getBrands() {
        return Arrays.asList(brands);
    }

    private String getRandomId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    private int getRandomYear() {
        return (int) (Math.random() * 50 + 1960);
    }

    private String getRandomColor() {
        return colors[(int) (Math.random() * 10)];
    }

    private String getRandomBrand() {
        return brands[(int) (Math.random() * 10)];
    }

    private int getRandomPrice() {
        return (int) (Math.random() * 100000);
    }

    private boolean getRandomSoldState() {
        return (Math.random() > 0.5) ? true : false;
    }
}