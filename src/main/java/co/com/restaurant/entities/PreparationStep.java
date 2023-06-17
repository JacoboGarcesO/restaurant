package co.com.restaurant.entities;

import co.com.restaurant.utils.IdGenerator;
import co.com.restaurant.utils.Validations;

public class PreparationStep extends BaseEntity {
    private String preparationStepId;
    private Integer order;
    private String description;
    private String image;

    public PreparationStep() {
    }

    public PreparationStep(String preparationStepId, Integer order, String description, String image) {
        this.preparationStepId = preparationStepId;
        this.order = order;
        this.description = description;
        this.image = image;
    }

    public String getPreparationStepId() {
        return preparationStepId;
    }

    public void setPreparationStepId(String preparationStepId) {
        this.preparationStepId = preparationStepId;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "PreparationStep{" +
                "preparationStepId = " + preparationStepId + '\'' +
                ", order = " + order +
                ", description = " + description + '\'' +
                ", image = " + image +
                '}';
    }

    @Override
    public Object fill() {
        this.preparationStepId = IdGenerator.uuid();
        this.order = Validations.readInteger("Ingrese el la posición de este paso, por favor: ");
        this.description = Validations.readString("Ingrese la descripción del paso, por favor: ");
        this.image = Validations.readString("Ingrese la url de la imagen asociada a este paso, por favor: ");
        return this;
    }

    @Override
    public String getRegisterStructure() {
        return null;
    }
}
