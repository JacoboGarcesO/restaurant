package co.com.restaurant.entities;

import co.com.restaurant.utils.IdGenerator;
import co.com.restaurant.utils.Validations;

public class Menu extends BaseEntity {
    private String menuId;
    private String name;
    private String description;
    private Food plates;

    public Menu() {
    }

    public Menu(String menuId, String name, String description, Food plates) {
        this.menuId = menuId;
        this.name = name;
        this.description = description;
        this.plates = plates;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Food getPlates() {
        return plates;
    }

    public void setPlates(Food plates) {
        this.plates = plates;
    }

    @Override
    public String toString() {
        return "Menu = {" + '\n' +
                "menuId = " + menuId + '\n' +
                ", name = " + name + '\n' +
                ", description = " + description + '\n' +
                ", plates = " + plates.toString() + '\n' +
                '}';
    }

    @Override
    public Object fill() {
        this.menuId = IdGenerator.uuid();
        this.name = Validations.readString("Ingrese el nombre del menú, por favor: ");
        this.description = Validations.readString("Ingrese la descripción del menú, por favor: ");
        this.plates = new Food();
        return this;
    }

    @Override
    public String getRegisterStructure() {
        return null;
    }
}
