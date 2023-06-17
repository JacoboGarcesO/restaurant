package co.com.restaurant.entities;

import co.com.restaurant.utils.IdGenerator;
import co.com.restaurant.utils.Validations;

public class Food extends BaseEntity {
    private String foodId;
    private Integer quantity;
    private String name;

    public Food() {
    }

    public Food(String foodId, Integer quantity, String name) {
        this.foodId = foodId;
        this.quantity = quantity;
        this.name = name;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Food = {" + '\n' +
                "foodId = " + foodId + '\n' +
                ", quantity = " + quantity + '\n' +
                ", name = " + name + '\n' +
                '}';
    }

    @Override
    public Food fill() {
        this.foodId = IdGenerator.uuid();
        this.name = Validations.readString("Ingrese el nombre del alimento, por favor: ");
        this.quantity = Validations.readInteger("Ingrese la cantidad de este alimento, por favor: ");
        return this;
    }

    @Override
    public String getRegisterStructure() {
        return null;
    }
}
