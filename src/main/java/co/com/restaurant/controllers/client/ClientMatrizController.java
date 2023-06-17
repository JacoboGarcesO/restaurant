package co.com.restaurant.controllers.client;

import co.com.restaurant.entities.Client;
import co.com.restaurant.structures.Matriz;
import co.com.restaurant.utils.Validations;

import javax.swing.*;

public class ClientMatrizController {
    private Matriz matriz;

    public ClientMatrizController() {
        this.matriz = null;
    }

    public void create() {
        Integer rows = Validations.readInteger("Ingrese las filas de la matriz");
        Integer columns = Validations.readInteger("Ingrese las columnas de la matriz");
        this.matriz = new Matriz(rows, columns);
        JOptionPane.showMessageDialog(null, "Matriz de clientes creada exitosamente, ahora debe proceder el llenado.");
        this.matriz.fill(new Client());
    }

    public void showPerRows() {
        JOptionPane.showMessageDialog(null, this.matriz.showRows());
    }

    public void showPerColumns() {
        JOptionPane.showMessageDialog(null, this.matriz.showColumns());
    }

    public Client getClientById(String message) {
        Client client = null;
        Object[][] clients = this.matriz.getData();
        String id = Validations.readString(message);

        for (int i = 0; i < clients.length; i++) {
            for (int j = 0; j < clients[0].length; j++) {
                if (((Client) clients[i][j]).getClientId().equals(id)) {
                    client = (Client) clients[i][j];
                }
            }
        }

        if (client != null) {
            JOptionPane.showMessageDialog(null, client);
        }
        return client;
    }

    public void updateClient() {
        Client client = this.getClientById("Ingrese el id del cliente a actualizar");

        if (client == null) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún cliente con ese id.");
            return;
        }

        client.setName(Validations.readStringDefault("Nombre del cliente: ", client.getName()));
        client.setEmail(Validations.readStringDefault("Correo del cliente: ", client.getEmail()));
        client.setAddress(Validations.readStringDefault("Dirección del cliente: ", client.getAddress()));

        Object[][] clients = this.matriz.getData();

        for (int i = 0; i < clients.length; i++) {
            for (int j = 0; j < clients[0].length; j++) {
                if (((Client) clients[i][j]).getClientId().equals(client.getClientId())) {
                    clients[i][j] = client;
                }
            }
        }

        JOptionPane.showMessageDialog(null, "Cliente actualizado correctamente.");
    }
}

