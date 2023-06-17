package co.com.restaurant.controllers.client;

import co.com.restaurant.entities.Client;
import co.com.restaurant.structures.File;
import co.com.restaurant.utils.Validations;

import javax.swing.*;

public class ClientFileController {
    private File file;
    private final String FILE_PATH = "Client.txt";
    private final Integer NUMBER_OF_PROPERTIES = 4;

    public ClientFileController() {
        this.file = new File(FILE_PATH);
    }

    public void createClient() {
        Integer response;

        do {
            response = JOptionPane.showConfirmDialog(null, "¿Seguro que deseas agregar un cliente al archivo?", "Archivando...", JOptionPane.YES_NO_OPTION);
            if (response != JOptionPane.YES_OPTION) { return; }

            Client client = new Client();

            if (this.existingClient(client.getClientId())) {
                JOptionPane.showMessageDialog(null, "[ERROR]: Ocurrió un error creando el cliente porque el id que se le generó ya se encontraba en el archivo. Inténtelo nuevamente.");
                return;
            }

            client.fill();
            Client[] clients = getClients();
            Client[] clientsToSave = new Client[clients.length + 1];

            for (int i = 0; i < clients.length ; i++) {
                    clientsToSave[i] = clients[i];
            }

            clientsToSave[clients.length] = client;
            recordClients(clientsToSave);
        } while (response == JOptionPane.YES_OPTION);
    }

    public void showClients() {
        String clients = "";

        try {
            this.file.openFileReaderMode();
            String register[];
            register = this.file.readRegister(NUMBER_OF_PROPERTIES);

            while (register[0] != null) {
                Client client = new Client(register[0], register[1], register[2], register[3]);
                clients += client + "\n";
                register = this.file.readRegister(NUMBER_OF_PROPERTIES);
            }
        }  catch (Exception exception) { System.out.println(exception.getMessage()); }
        this.file.closeFileReaderMode();

        JOptionPane.showMessageDialog(null, clients);
    }

    public Client getClientById(String message) {
        Client client = null;
        String id = Validations.readString(message);

        try {
            this.file.openFileReaderMode();
            String register[];
            register = this.file.readRegister(NUMBER_OF_PROPERTIES);

            while (register[0] != null) {
                if (id.equals(register[0])) {
                    client = new Client(register[0], register[1], register[2], register[3]);
                }

                register = this.file.readRegister(NUMBER_OF_PROPERTIES);
            }
        }  catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        this.file.closeFileReaderMode();
        if (client != null) {
            JOptionPane.showMessageDialog(null, client);
        }
        return client;
    }

    public void updateClient() {
        Client client = getClientById("Ingrese el id del cliente que desea actualizar");
        Client[] clients = getClients();

        if (client == null) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún cliente con ese id.");
            return;
        }

        client.setName(Validations.readStringDefault("Nombre del cliente: ", client.getName()));
        client.setEmail(Validations.readStringDefault("Correo del cliente: ", client.getEmail()));
        client.setAddress(Validations.readStringDefault("Dirección del cliente: ", client.getAddress()));

        for (int i = 0; i < clients.length; i++) {
            if (client.getClientId().equals(clients[i].getClientId())) {
                clients[i] = client;
            }
        }
        recordClients(clients);
    }

    public void deleteClient() {
        Client client = getClientById("Ingrese el id del cliente que desea eliminar:");
        Client[] clients = getClients();

        if (client == null) {
            JOptionPane.showMessageDialog(null, "No se encontró ningún cliente con ese id.");
            return;
        }

        Client[] clientsToSave = new Client[clients.length - 1];

        for (int i = 0; i < clients.length ; i++) {
            if (!client.getClientId().equals(clients[i].getClientId())) {
                clientsToSave[i] = clients[i];
            }
        }

        recordClients(clientsToSave);
    }

    private boolean existingClient(String id) {
        Boolean existingClient = Boolean.FALSE;

        try {
            this.file.openFileReaderMode();
            String register[];
            register = this.file.readRegister(NUMBER_OF_PROPERTIES);

            while (register[0] != null) {
                existingClient = id.equals(register[0]);
                register = this.file.readRegister(NUMBER_OF_PROPERTIES);
            }
        }  catch (Exception exception) { System.out.println(exception.getMessage()); }

        this.file.closeFileReaderMode();
        return existingClient;
    }

    private void recordClients(Client[] clients) {
        try {
            this.file.openFileWriterMode();

            for (Client client : clients) {
                String content = client.getRegisterStructure();
                this.file.writeRegister(content);
            }

            this.file.closeFileWriterMode();
            JOptionPane.showMessageDialog(null, "¡Archivo de clientes actualizado exitosamente!");
        }  catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "[ERROR]: Ocurrió un error mientras se grababa el cliente");
        }
    }

    private Integer quantityRegisters() {
        Integer counter = 0;

        try {
            this.file.openFileReaderMode();
            String register[];
            register = this.file.readRegister(NUMBER_OF_PROPERTIES);

            while (register[0] != null) {
                counter++;
                register = this.file.readRegister(NUMBER_OF_PROPERTIES);
            }
        }  catch (Exception exception) { System.out.println(exception.getMessage()); }
        this.file.closeFileReaderMode();
        return counter;
    }

    private Client[] getClients() {
        Client[] clients = new Client[quantityRegisters()];
        Integer counter = 0;

        try {
            this.file.openFileReaderMode();
            String register[];
            register = this.file.readRegister(NUMBER_OF_PROPERTIES);

            while (register[0] != null) {
                clients[counter] = new Client(register[0], register[1], register[2], register[3]);
                counter ++;
                register = this.file.readRegister(NUMBER_OF_PROPERTIES);
            }
        }  catch (Exception exception) { System.out.println(exception.getMessage()); }
        this.file.closeFileReaderMode();

        return clients;
    }
}
