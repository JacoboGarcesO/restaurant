package co.com.restaurant.controllers.client;

import co.com.restaurant.entities.Client;
import co.com.restaurant.structures.DoubleList;
import co.com.restaurant.utils.Validations;

import javax.swing.*;

public class ClientDoubleListController {
    private DoubleList doubleList;

    public ClientDoubleListController() {
        this.doubleList = new DoubleList();
    }

    public void create() {
        Integer option = Validations.readIntegerInRange("1. Insertar al inicio.\n2. Insertar al final.", 1, 2);
        Integer response;

        do {
            response = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas agregar un cliente al archivo?", "Archivando...", JOptionPane.YES_NO_OPTION);
            if (response != JOptionPane.YES_OPTION) {
                return;
            }

            Client client = new Client();
            client = client.fill();

            if (option == 1) {
                this.doubleList.insertFromStart(client);
            } else {
                this.doubleList.insertFromEnd(client);
            }

        } while (response == JOptionPane.YES_OPTION);
    }

    public void showFromStart() {
        JOptionPane.showMessageDialog(null, "Lista desde el inicio: " + this.doubleList.showStart(this.doubleList));
    }

    public void showFromEnd() {
        JOptionPane.showMessageDialog(null, "Lista desde el final: " + this.doubleList.showEnd(this.doubleList));
    }

    public void updateClient() {
        String id = Validations.readString("Ingrese el id del cliente que desea actualizar: ");

        if (!this.doubleList.objectInList(this.doubleList, id)) {
            JOptionPane.showMessageDialog(null, "El cliente no existe.");
            return;
        }

        Client client = (Client) this.doubleList.getAuxiliary1().getObject();

        client.setName(Validations.readStringDefault("Nombre del cliente: ", client.getName()));
        client.setEmail(Validations.readStringDefault("Correo del cliente: ", client.getEmail()));
        client.setAddress(Validations.readStringDefault("Dirección del cliente: ", client.getAddress()));

        Integer response = JOptionPane.showConfirmDialog(null, "¿Seguro que desea actualizar al cliente?", "ACTUALIZAR", JOptionPane.YES_NO_OPTION);

        if (response == JOptionPane.YES_NO_OPTION) {
            this.doubleList.getAuxiliary1().setObject(client);
        }
    }

    public void insertBefore() {
        String id = Validations.readString("Ingrese el id del cliente para tomar como referencia: ");

        Client client = new Client().fill();
        this.doubleList = this.doubleList.insertBefore(this.doubleList, client, id);
        JOptionPane.showMessageDialog(null, "El cliente fue insertado con éxito.");
    }

    public void insertAfter() {
        String id = Validations.readString("Ingrese el id del cliente para tomar como referencia: ");

        Client client = new Client().fill();
        this.doubleList = this.doubleList.insertAfter(this.doubleList, client, id);
        JOptionPane.showMessageDialog(null, "El cliente fue insertado con éxito.");
    }

    public void delete() {
        String id = Validations.readString("Ingrese el id del cliente que desea eliminar: ");
        this.doubleList.unlockElement(this.doubleList, id);
        JOptionPane.showMessageDialog(null, "El cliente fue eliminado con éxito.");
    }
}
