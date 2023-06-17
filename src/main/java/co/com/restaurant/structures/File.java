package co.com.restaurant.structures;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class File {
    private String path;
    private java.io.File file;
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private FileWriter fileWriter;
    private PrintWriter printWriter;

    public File(String path) {
        this.path = path;
    }

    public String openFileReaderMode() {
        String message = "¡Se abrió en modo lectura!";

        try {
            this.file = new java.io.File(this.path);
            this.fileReader = new FileReader(this.file);
            this.bufferedReader = new BufferedReader(this.fileReader);
        } catch (Exception exception) { message = exception.getMessage(); }

        return message;
    }

    public String closeFileReaderMode() {
        String message = "¡Se cerró en modo lectura!";

        try {
            this.bufferedReader.close();
        } catch (Exception exception) { message = exception.getMessage(); }

        return message;
    }

    public String openFileWriterMode() {
        String message = "¡Se abrió en modo escritura!";

        try {
            this.file = new java.io.File(this.path);
            this.fileWriter = new FileWriter(this.file);
            this.printWriter = new PrintWriter(this.fileWriter);
        } catch (Exception exception) { message = exception.getMessage(); }

        return message;
    }

    public String closeFileWriterMode() {
        String message = "¡Se cerró en modo escritura!";

        try {
            this.printWriter.close();
        } catch (Exception exception) { message = exception.getMessage(); }

        return message;
    }

    public String[] readRegister(int numberProperties) {
        String vector[] = new String[numberProperties];
        try {
            vector = this.bufferedReader.readLine().split(",");
        } catch (Exception exception) { System.out.println(exception); }

        return vector;
    }

    public String writeRegister(String register) {
        String message = "¡Se grabó un registro!";
        try{
            this.printWriter.println(register);
        } catch (Exception exception) { message = exception.getMessage(); }

        return message;
    }
}
