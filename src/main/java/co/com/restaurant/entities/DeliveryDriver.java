package co.com.restaurant.entities;

import co.com.restaurant.utils.IdGenerator;

public class DeliveryDriver extends BaseEntity {
    private String deliveryDriverId;
    private Boolean deliveriesCompleted;
    private Menu menu;

    public DeliveryDriver() {
    }

    public DeliveryDriver(String deliveryDriverId, Boolean deliveriesCompleted, Menu menu) {
        this.deliveryDriverId = deliveryDriverId;
        this.deliveriesCompleted = deliveriesCompleted;
        this.menu = menu;
    }

    public String getDeliveryDriverId() {
        return deliveryDriverId;
    }

    public void setDeliveryDriverId(String deliveryDriverId) {
        this.deliveryDriverId = deliveryDriverId;
    }

    public Boolean getDeliveriesCompleted() {
        return deliveriesCompleted;
    }

    public void setDeliveriesCompleted(Boolean deliveriesCompleted) {
        this.deliveriesCompleted = deliveriesCompleted;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "DeliveryDriver = {" + '\n' +
                "deliveryDriverId = " + deliveryDriverId + '\n' +
                ", deliveriesCompleted = " + deliveriesCompleted + '\n' +
                ", menu = " + menu.getName() + '\n' +
                '}';
    }

    @Override
    public DeliveryDriver fill() {
        this.deliveryDriverId = IdGenerator.uuid();
        this.deliveriesCompleted = Boolean.FALSE;
        this.menu = new Menu();
        return this;
    }

    @Override
    public String getRegisterStructure() {
        return null;
    }
}
