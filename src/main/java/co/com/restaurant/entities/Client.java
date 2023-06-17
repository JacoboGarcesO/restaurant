package co.com.restaurant.entities;


import co.com.restaurant.utils.IdGenerator;
import co.com.restaurant.utils.Validations;

public class Client extends BaseEntity {
    private String clientId;
    private String name;
    private String email;
    private String address;
    private Food preferences;
    private Food restrictions;

    public Client() {
        this.clientId = IdGenerator.uuid();
    }

    public Client(String clientId, String name, String email, String address) {
        this.clientId = clientId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.preferences = new Food();
        this.restrictions = new Food();
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Food getPreferences() {
        return preferences;
    }

    public void setPreferences(Food preferences) {
        this.preferences = preferences;
    }

    public Food getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(Food restrictions) {
        this.restrictions = restrictions;
    }

    @Override
    public String toString() {
        return "Cliente = {" + '\n' +
                " Id: " + clientId + '\n' +
                " Nombre: " + name + '\n' +
                " Correo: " + email + '\n' +
                " Dirección: " + address + '\n' +
                '}';
    }

    @Override
    public Client fill() {
        this.name = Validations.readString("Ingrese el nombre del cliente, por favor: ");
        this.email = Validations.readString("Ingrese el correo del cliente, por favor: ");
        this.address = Validations.readString("Ingrese la dirección del cliente, por favor: ");
        this.preferences = new Food();
        this.restrictions = new Food();
        return this;
    }

    @Override
    public String getRegisterStructure() {
        return String.join(",", new String[]{this.clientId, this.name, this.email, this.address});
    }
}
