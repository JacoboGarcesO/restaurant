package co.com.restaurant.utils;

import javax.swing.*;
import java.util.Calendar;

public class Validations {
    /*
    * Descripción: Método para leer un número mayor o igual que 0 (se implementó recursividad).
    * Parámetros: {message} -> mensaje que se muestra al usuario para solicitar el número.
    * Retorno: Un número entero mayor o igual que 0.
    * */
    public static Integer readInteger(String message) {
        Integer number = 0;
        try {
            number = Integer.parseInt(JOptionPane.showInputDialog(message));

            if (numberIsLessThanToZero(number)) {
                JOptionPane.showMessageDialog(null,"[ERROR]: El número debe ser superior o igual que 0.");
                readInteger(message);
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null,"[ERROR]: " + exception);
            readInteger(message);
        }

        return number;
    }

    /*
     * Descripción: Método para leer un número dentro de un rango.
     * Parámetros: {message} -> Mensaje que se muestra al usuario para solicitar el número.
     *             {lowerLimit} -> Limite inferior del rango al que debe pertener el número.
     *             {upperLimit} -> Limite superior del rango al que debe pertener el número
     * Retorno: Un número entero que esté entre los límites establecidos.
     * */
    public static Integer readIntegerInRange(String message, Integer lowerLimit, Integer upperLimit) {
        Integer number = 0;
        try {
            number = Integer.parseInt(JOptionPane.showInputDialog(message));

            if (numberIsInRange(number, lowerLimit, upperLimit)) {
                JOptionPane.showMessageDialog(null,"[ERROR]: El número debe ser mayor o igual que " + lowerLimit + " y debe ser menor o igual que " + upperLimit + ".");
                readIntegerInRange(message, lowerLimit, upperLimit);
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null,"[ERROR]: " + exception);
            readIntegerInRange(message, lowerLimit, upperLimit);
        }

        return number;
    }

    /*
     * Descripción: Método para leer un número que sea igual a 1 o a 2.
     * Parámetros: {message} -> mensaje que se muestra al usuario para solicitar el número.
     * Retorno: Un número que sea igual a 1 o a 2.
     * */
    public static Integer readOneOrTwo(String message) {
        Integer number = 0;
        try {
            number = Integer.parseInt(JOptionPane.showInputDialog(message));

            if (numberIsDifferentToOneOrTwo(number)) {
                JOptionPane.showMessageDialog(null,"[ERROR]: El número debe ser superior a 0.");
                readOneOrTwo(message);
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null,"[ERROR]: " + exception);
            readOneOrTwo(message);
        }

        return number;
    }

    public static String readString(String message) {
        String text = "";
        try {
            text = JOptionPane.showInputDialog(message);

            if (text.trim().equals("")) {
                JOptionPane.showMessageDialog(null,"[ERROR]: El texto ingresado no puede esta vacío.");
                readString(message);
            }
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null,"[ERROR]: " + exception);
            readString(message);
        }

        return text.trim();
    }

    public static Integer getActualYear() {
        Calendar date = Calendar.getInstance();
        return date.get(Calendar.YEAR);
    }

    /*
     * Descripción: Método para saber si un número es diferente de 1 y de 2.
     * Parámetros: {number} -> número a validar.
     * Retorno: Dato lógico verdadero si el número es diferente de 1 y de 2. Dato lógico falso si el número es igual a 1 o a 2.
     * */
    private static boolean numberIsDifferentToOneOrTwo(Integer number) {
        return number != 1 && number != 2;
    }

    /*
     * Descripción: Método para saber si un número es menor.
     * Parámetros: {number} -> número a validar.
     * Retorno: Dato lógico verdadero si el número es menor. Dato lógico falso si el número es mayor o igual que 0.
     * */
    private static boolean numberIsLessThanToZero(Integer number) {
        return number < 0;
    }

    /*
     * Descripción: Método para saber si un número es menor.
     * Parámetros: {number} -> número a validar.
     * Retorno: Dato lógico verdadero si el número es menor. Dato lógico falso si el número es mayor o igual que 0.
     * */
    private static boolean numberIsInRange(Integer number, Integer lowerLimit, Integer upperLimit) {
        return number < lowerLimit || number > upperLimit;
    }
}
