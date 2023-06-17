package co.com.restaurant.entities;

import co.com.restaurant.utils.IdGenerator;
import co.com.restaurant.utils.Validations;

public class Preparation extends BaseEntity {
    private String preparationId;
    private String name;
    private String description;
    private Food portions;
    private String category;
    private PreparationStep preparationSteps;

    public Preparation() {
    }

    public Preparation(String preparationId, String name, String description, Food portions, String category, PreparationStep preparationSteps) {
        this.preparationId = preparationId;
        this.name = name;
        this.description = description;
        this.portions = portions;
        this.category = category;
        this.preparationSteps = preparationSteps;
    }

    public String getPreparationId() {
        return preparationId;
    }

    public void setPreparationId(String preparationId) {
        this.preparationId = preparationId;
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

    public Food getPortions() {
        return portions;
    }

    public void setPortions(Food portions) {
        this.portions = portions;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public PreparationStep getPreparationSteps() {
        return preparationSteps;
    }

    public void setPreparationSteps(PreparationStep preparationSteps) {
        this.preparationSteps = preparationSteps;
    }

    @Override
    public String toString() {
        return "Preparation = {" + '\n' +
                "preparationId = " + preparationId + '\n' +
                ", name = " + name + '\n' +
                ", description = " + description + '\n' +
                ", category = " + category + '\n' +
                ", portions = " + portions.toString() + '\n' +
                ", preparationSteps=" + preparationSteps.toString() + '\n' +
                '}';
    }

    @Override
    public Object fill() {
        this.preparationId = IdGenerator.uuid();
        this.name = Validations.readString("Ingrese el nombre de la preparación, por favor: ");
        this.description = Validations.readString("Ingrese la descripción de la preparación, por favor: ");
        this.category = Validations.readString("Ingrese la categoría de la preparación, por favor: ");
        this.portions = new Food();
        this.preparationSteps = new PreparationStep();
        return this;
    }

    @Override
    public String getRegisterStructure() {
        return null;
    }
}
