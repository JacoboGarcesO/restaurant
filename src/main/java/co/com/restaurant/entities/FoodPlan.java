package co.com.restaurant.entities;

import co.com.restaurant.utils.IdGenerator;
import co.com.restaurant.utils.Validations;

public class FoodPlan extends BaseEntity {
    private String foodPlanId;
    private Integer tickets;
    private String deliveries;

    public FoodPlan() {
    }

    public FoodPlan(String foodPlanId, Integer tickets, String deliveries) {
        this.foodPlanId = foodPlanId;
        this.tickets = tickets;
        this.deliveries = deliveries;
    }

    public String getFoodPlanId() {
        return foodPlanId;
    }

    public void setFoodPlanId(String foodPlanId) {
        this.foodPlanId = foodPlanId;
    }

    public Integer getTickets() {
        return tickets;
    }

    public void setTickets(Integer tickets) {
        this.tickets = tickets;
    }

    public String getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(String deliveries) {
        this.deliveries = deliveries;
    }

    @Override
    public String toString() {
        return "FoodPlan = {" + '\n' +
                "foodPlanId = " + foodPlanId + '\n' +
                ", tickets = " + tickets + '\n' +
                ", deliveries = " + deliveries + '\n' +
                '}';
    }

    @Override
    public Object fill() {
        this.foodPlanId = IdGenerator.uuid();
        this.tickets = Validations.readInteger("Ingrese el número de tiquetes, por favor: ");
        this.deliveries = Validations.readString("Ingrese las fechas en las que se debe enviar el menú, por favor: ");
        return this;
    }

    @Override
    public String getRegisterStructure() {
        return null;
    }
}
