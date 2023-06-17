package co.com.restaurant;

import co.com.restaurant.controllers.client.ClientFileController;
import co.com.restaurant.controllers.optionsMenu.OptionsMenuFileController;
import co.com.restaurant.utils.Validations;
import co.com.restaurant.utils.constants.OptionsMenuType;

import javax.swing.*;
import java.util.Map;

public class Restaurant {

    private OptionsMenuFileController optionsMenuFileController;
    private ClientFileController clientFileController;

    public Restaurant() {
        this.optionsMenuFileController = new OptionsMenuFileController();
        this.clientFileController = new ClientFileController();
    }

    public void startApplication() {
        Integer option;
        do {
            option = Validations.readIntegerInRange(this.getOptionsMainMenu(1), 1, 7);
            switch (option) {
                case 1:
                    this.launchFilesOptions();
                    break;
                case 2:
                    this.launchMatricesOptions();
                    break;
                case 3:
                    this.launchDoubleListsOptions();
                    break;
                case 4:
                    this.launchStacksOptions();
                    break;
                case 5:
                    this.launchQueueOptions();
                    break;
                case 6:
                    this.launchCombinedOptions();
                    break;
            }
        } while (option != 7);
        JOptionPane.showMessageDialog(null, "¡Vuelve pronto!");
    }

    private void launchFilesOptions() {
        Integer option;
        Integer caseOption;
        do {
            option = Validations.readIntegerInRange(this.getOptionsMainMenu(2), 1, 7);
            switch (option) {
                case 1:
                    do {
                        caseOption = Validations.readIntegerInRange(this.getOptionsFilesMenu(1), 1, 6);
                        switch (caseOption) {
                            case 1:
                                this.clientFileController.createClient();
                                break;
                            case 2:
                                this.clientFileController.showClients();
                                break;
                            case 3:
                                this.clientFileController.getClientById("Ingresa el id del cliente que deseas buscar");
                                break;
                            case 4:
                                this.clientFileController.updateClient();
                                break;
                            case 5:
                                this.clientFileController.deleteClient();
                                break;
                        }
                    } while (caseOption != 6);
                    break;
                case 2:
                    do {
                        caseOption = Validations.readIntegerInRange(this.getOptionsFilesMenu(2), 1, 6);
                        switch (caseOption) {
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                        }
                    } while (caseOption != 5);
                    break;
                case 3:
                    do {
                        caseOption = Validations.readIntegerInRange(this.getOptionsFilesMenu(3), 1, 6);
                        switch (caseOption) {
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                        }
                    } while (caseOption != 5);
                    break;
                case 4:
                    do {
                        caseOption = Validations.readIntegerInRange(this.getOptionsFilesMenu(4), 1, 6);
                        switch (caseOption) {
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                        }
                    } while (caseOption != 5);
                    break;
                case 5:
                    do {
                        caseOption = Validations.readIntegerInRange(this.getOptionsFilesMenu(5), 1, 6);
                        switch (caseOption) {
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                        }
                    } while (caseOption != 5);
                    break;
                case 6:
                    do {
                        caseOption = Validations.readIntegerInRange(this.getOptionsFilesMenu(6), 1, 6);
                        switch (caseOption) {
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                        }
                    } while (caseOption != 5);
                    break;
            }
        } while (option != 7);
    }

    private void launchMatricesOptions() {
        Integer option;
        do {
            option = Validations.readIntegerInRange(this.getOptionsMainMenu(3), 1, 7);
            switch (option) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
            }
        } while (option != 7);
    }

    private void launchDoubleListsOptions() {
        Integer option;
        do {
            option = Validations.readIntegerInRange(this.getOptionsMainMenu(4), 1, 7);
            switch (option) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
            }
        } while (option != 7);
    }

    private void launchStacksOptions() {
        Integer option;
        do {
            option = Validations.readIntegerInRange(this.getOptionsMainMenu(5), 1, 7);
            switch (option) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
            }
        } while (option != 7);
    }

    private void launchQueueOptions() {
        Integer option;
        do {
            option = Validations.readIntegerInRange(this.getOptionsMainMenu(6), 1, 7);
            switch (option) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
            }
        } while (option != 7);
    }

    private void launchCombinedOptions() {
        Integer option;
        do {
            option = Validations.readIntegerInRange(this.getOptionsMainMenu(7), 1, 7);
            switch (option) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
            }
        } while (option != 7);
    }

    private String getOptionsMainMenu(Integer optionsMenuNumber) {
        Map<Integer, OptionsMenuType> optionsMenus = Map.of(
                1, OptionsMenuType.PRINCIPAL,
                2, OptionsMenuType.ARCHIVOS,
                3, OptionsMenuType.MATRICES,
                4, OptionsMenuType.LISTAS_DOBLES,
                5, OptionsMenuType.PILAS,
                6, OptionsMenuType.COLAS,
                7, OptionsMenuType.COMBINADAS
        );
        return optionsMenuFileController.getOptionsMenuById(optionsMenus.get(optionsMenuNumber).toString()).getText();
    }

    private String getOptionsFilesMenu(Integer optionsMenuNumber) {
        Map<Integer, OptionsMenuType> optionsMenus = Map.of(
                1, OptionsMenuType.ARCHIVOS_CLIENTES,
                2, OptionsMenuType.ARCHIVOS_REPARTIDORES,
                3, OptionsMenuType.ARCHIVOS_PLATOS,
                4, OptionsMenuType.ARCHIVOS_PLANES,
                5, OptionsMenuType.ARCHIVOS_MENUS,
                6, OptionsMenuType.ARCHIVOS_PREPARACIONES
        );
        return optionsMenuFileController.getOptionsMenuById(optionsMenus.get(optionsMenuNumber).toString()).getText();
    }

    private String getOptionsMatricesMenu(Integer optionsMenuNumber) {
        Map<Integer, OptionsMenuType> optionsMenus = Map.of(
                1, OptionsMenuType.MATRICES_CLIENTES,
                2, OptionsMenuType.MATRICES_REPARTIDORES,
                3, OptionsMenuType.MATRICES_PLATOS,
                4, OptionsMenuType.MATRICES_PLANES,
                5, OptionsMenuType.MATRICES_MENUS,
                6, OptionsMenuType.MATRICES_PREPARACIONES
        );
        return optionsMenuFileController.getOptionsMenuById(optionsMenus.get(optionsMenuNumber).toString()).getText();
    }

    private String getOptionsDoubleListsMenu(Integer optionsMenuNumber) {
        Map<Integer, OptionsMenuType> optionsMenus = Map.of(
                1, OptionsMenuType.LISTAS_DOBLES_CLIENTES,
                2, OptionsMenuType.LISTAS_DOBLES_REPARTIDORES,
                3, OptionsMenuType.LISTAS_DOBLES_PLATOS,
                4, OptionsMenuType.LISTAS_DOBLES_PLANES,
                5, OptionsMenuType.LISTAS_DOBLES_MENUS,
                6, OptionsMenuType.LISTAS_DOBLES_PREPARACIONES
        );
        return optionsMenuFileController.getOptionsMenuById(optionsMenus.get(optionsMenuNumber).toString()).getText();
    }

    private String getOptionsStacksMenu(Integer optionsMenuNumber) {
        Map<Integer, OptionsMenuType> optionsMenus = Map.of(
                1, OptionsMenuType.PILAS_CLIENTES,
                2, OptionsMenuType.PILAS_REPARTIDORES,
                3, OptionsMenuType.PILAS_PLATOS,
                4, OptionsMenuType.PILAS_PLANES,
                5, OptionsMenuType.PILAS_MENUS,
                6, OptionsMenuType.PILAS_PREPARACIONES
        );
        return optionsMenuFileController.getOptionsMenuById(optionsMenus.get(optionsMenuNumber).toString()).getText();
    }

    private String getOptionsQueuesMenu(Integer optionsMenuNumber) {
        Map<Integer, OptionsMenuType> optionsMenus = Map.of(
                1, OptionsMenuType.COLAS_CLIENTES,
                2, OptionsMenuType.COLAS_REPARTIDORES,
                3, OptionsMenuType.COLAS_PLATOS,
                4, OptionsMenuType.COLAS_PLANES,
                5, OptionsMenuType.COLAS_MENUS,
                6, OptionsMenuType.COLAS_PREPARACIONES
        );
        return optionsMenuFileController.getOptionsMenuById(optionsMenus.get(optionsMenuNumber).toString()).getText();
    }
}

