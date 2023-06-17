package co.com.restaurant.structures;

import co.com.restaurant.entities.BaseEntity;

public class Matriz {
    private Object data[][];

    public Matriz(Integer rows, Integer columns) {
        this.data = new Object[rows][columns];
    }

    public void fill(BaseEntity castingObject) {
        for (int i = 0; i < this.data.length; i++) {
            for (int j = 0; j < this.data[0].length; j++) {
                this.data[i][j] = castingObject.fill();
            }
        }
    }

    public String showRows()
    {
        String text = "";
        for (int i = 0; i < this.data.length; i++) {
            for (int j = 0; j < this.data[0].length; j++) {
                text = text + "( "+this.data[i][j].toString()+" )\n";
            }
        }

        return text;
    }

    public String showColumns()
    {
        String text = "";
        for (int i = 0; i < this.data[0].length; i++) {
            for (int j = 0; j < this.data.length; j++) {
                text = text + "( "+this.data[j][i].toString()+" )\n";
            }
        }

        return text;
    }

    public Object[][] getData() {
        return data;
    }
}
