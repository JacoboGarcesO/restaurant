package co.com.restaurant.entities;

import co.com.restaurant.utils.IdGenerator;
import co.com.restaurant.utils.Validations;

public class Order extends BaseEntity {
    private String orderId;
    private Integer paymentType;
    private Menu menu;

    public Order() {
    }

    public Order(String orderId, Integer paymentType, Menu menu) {
        this.orderId = orderId;
        this.paymentType = paymentType;
        this.menu = menu;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "Order = {" + '\n' +
                "orderId = " + orderId + '\n' +
                ", paymentType = " + paymentType + '\n' +
                ", menu = " + menu.toString() + '\n' +
                '}';
    }

    @Override
    public Object fill() {
        this.orderId = IdGenerator.uuid();
        this.paymentType = Validations.readOneOrTwo(
                "Ingrese el método de pago con que desea pagar la orden:\n" +
                        "1. Efectivo.\n" +
                        "2. Transferencia."
        );
        this.menu = new Menu();
        return this;
    }

    @Override
    public String getRegisterStructure() {
        return null;
    }
}
