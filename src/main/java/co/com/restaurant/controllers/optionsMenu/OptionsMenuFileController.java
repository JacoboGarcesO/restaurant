package co.com.restaurant.controllers.optionsMenu;

import co.com.restaurant.entities.OptionsMenu;
import co.com.restaurant.structures.File;

public class OptionsMenuFileController {
    private File file;
    private final String FILE_PATH = "OptionsMenu.txt";
    private final Integer NUMBER_OF_PROPERTIES = 2;

    public OptionsMenuFileController() {
        this.file = new File(FILE_PATH);
    }

    public OptionsMenu getOptionsMenuById(String id) {
        OptionsMenu optionsMenu = null;

        try {
            this.file.openFileReaderMode();
            String register[];
            register = this.file.readRegister(NUMBER_OF_PROPERTIES);

            while (register[0] != null) {
                if (id.equals(register[0])) {
                    String options = String.join("\n", register[1].split("\\|"));
                    optionsMenu = new OptionsMenu(register[0], options);
                }

                register = this.file.readRegister(NUMBER_OF_PROPERTIES);
            }
        }  catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        this.file.closeFileReaderMode();
        return optionsMenu;
    }
}
