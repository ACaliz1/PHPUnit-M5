package demo.model.operations;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import demo.exceptions.BuildException;

public class checker {
    public static int isNull (String s){
        if (s == null || s == " ") return -1; 
        return 0;
    }

    public static int minLength (int numeral, String s){
        if (s.trim().length() < numeral) return -2;
        return 0;
    }

    public static int maxLenght (int numeral, String s){
        if ((s.trim().length()) > numeral) return -10;
        return 0;
    }

    public static int nonZero (int numeral) {
        if (numeral == 0) return -3;
        return 0;
    }
    public static int nonZero (double numeral) {
        if (numeral == 0) return -3;
        return 0;
    }

    public static int nonNegative (int numeral) {
        if (numeral < 0) return -4;
        return 0;
    }

    public static int nonNegative (double numeral) {
        if (numeral < 0) return -4;
        return 0;
    }
    
    public static int maxValue (int numeral, int numeralMax){
        if (numeral > numeralMax) return -5;
        return 0;
    }

    public static int maxValue (double numeral, double numeralMax){
        if (numeral > numeralMax) return -5;
        return 0;
    }

    public static int minValue (int numeral, int numeralMin){
        if (numeral < numeralMin) return -7;
        return 0;
    }

    public static int minValue (double numeral, double numeralMin){
        if (numeral < numeralMin) return -7;
        return 0;
    }

    public static int minValueCount (int numeral, int numeralMin){
        String numeralToString = Integer.toString(numeral);
        if ((numeralToString.trim().length()) < numeralMin) return -11;
        return 0;
    }

    public static int maxValueCount (int numeral, int numeralMin){
        String numeralToString = Integer.toString(numeral);
        if ((numeralToString.trim().length()) > numeralMin) return -12;
        return 0;
    }

    public static int yesOrNo (String s){
        if (s.equals("yes") == false  && s.equals("no")== false) 
            return -6;
        return 0;
    }

    public static int checkDifficulty (String s){
        if (s != "easy" && s!= "medium" && s!= "hard") return -8;
        return 0;
    }

    public static int comparePrices (double doubleMax, double discount){
        if ( discount > doubleMax ) return -15;
        return 0;
    }

    public static int checkStatus (String s){
        if ( s != "cancelled" && s != "in delivery" && s != "pending" && s != "shipped" && s != "processing" && s != "completed") return -16;
        return 0;
    }

    public static int whichPaymentMethod (String s){
        if (s != "Paypal" && s != "CreditCard" && s != "gift card") return -17;
        return 0;
    }


    public static int isDateTimeGreaterThanToday(String dateTimeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime datetime = LocalDateTime.parse(dateTimeString, formatter);
        LocalDateTime today = LocalDateTime.now();
        if (datetime.isAfter(today)) {
            return 0;
        } else {
            return -9;
        }
    }

    public static int validarCorreo(String correo) {
        String expresionRegular = "^[a-zA-Z0-9._%+-]{5,64}@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
    
        Pattern pattern = Pattern.compile(expresionRegular);
        Matcher matcher = pattern.matcher(correo);
        
        if (!matcher.matches()) {
            return -22; 
        } else {
            return 0; 
        }
    }
    

    public static int checkDNI(String DNI) {
        String patron = "^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKE]$";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(DNI);
        if (!matcher.matches()) {
            return -23;
        }
        String letra = DNI.substring(DNI.length() - 1).toUpperCase();
        String numeros = DNI.substring(0, DNI.length() - 1);
        int resto = Integer.parseInt(numeros) % 23;
        String letras_validas = "TRWAGMYFPDXBNJZSQVHLCKE";

        if (letras_validas.charAt(resto) != letra.charAt(0)) {
            return -23;
        }
        return 0;
    }

    public static int validateISBN13(String isbn) {
        String patron = "^97[0-9]{1}-[0-9]{1}-[0-9]{2}-[0-9]{6}-[0-9]$";
        
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(isbn);
        
        if (!matcher.matches()) {
            return -24;
        }
    
        String isbnComprobar = isbn.replace("-", "").replace(" ", "");
    
        if (isbnComprobar.length() != 13) {
            return -24;
        }
    
        if (!isbnComprobar.chars().allMatch(Character::isDigit)) {
            return -24;
        }
    
        if (!isbnComprobar.startsWith("97")) {
            return -24;
        }
    
        int sum = 0;
        for (int i = 0; i < 12; i++) {
            int digit = Character.getNumericValue(isbnComprobar.charAt(i));
            sum += (i % 2 == 0) ? digit : digit * 3;
        }
    
        int checkDigit = (10 - (sum % 10)) % 10;
    
        int lastDigit = Character.getNumericValue(isbnComprobar.charAt(12));
        if (checkDigit != lastDigit) {
            return -24;
        }
    
        return 0;
    }

    public static LocalDate checkDate2(String data) throws BuildException {

        if (data == null) {
            throw new BuildException("La fecha no puede ser nula");
        }
        String patron = "^(?:\\d{2}-\\d{2}-\\d{4}|\\d{4}-\\d{2}-\\d{2})$";
    
        if (!data.matches(patron)) {
            throw new BuildException("La fecha no tiene las separaciones correctas o no sigue el formato");
        }
    
        if (data.charAt(4) == '-') {
            data = data.substring(8, 10) + "-" + data.substring(5, 7) + "-" + data.substring(0, 4);
        }
    
        int day = Integer.parseInt(data.substring(0, 2));
        int month = Integer.parseInt(data.substring(3, 5));
        int year = Integer.parseInt(data.substring(6));
    
        if (day < 1 || day > 31) {
            throw new BuildException("El día de la fecha no es válido");
        }
        if (month < 1 || month > 12) {
            throw new BuildException("El mes de la fecha no es válido");
        }
        if (year < 1800 || year > 2200) {
            throw new BuildException("El año de la fecha no es válido");
        }
    
        if ((month == 4 || month == 6 || month == 9 || month == 11) && day == 31) {
            throw new BuildException("El día 31 no es válido para el mes especificado");
        }
    
        if (month == 2) {
            if (day > 29) {
                throw new BuildException("Febrero no puede tener más de 29 días");
            }
            if (day == 29 && !(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))) {
                throw new BuildException("El año no es bisiesto, febrero no puede tener 29 días");
            }
        }
    
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            return LocalDate.parse(data, formatter);
        } catch (DateTimeParseException e) {
            throw new BuildException("La fecha es inválida");
        }
    }
    


    public static LocalDateTime checkDateAndTime(String data) throws BuildException {
        if (data == null) {
            throw new BuildException("La fecha no puede ser nula");
        }

        String patron = "^(?:\\d{2}[-/]\\d{2}[-/]\\d{4} \\d{2}:\\d{2}:\\d{2}|\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2})$";
    
        if (!data.matches(patron)) {
            throw new BuildException("La fecha y hora no tienen el formato adecuado");
        }
    
        if (data.charAt(4) == '-' ) {
            data = data.substring(8, 10) + "-" + data.substring(5, 7) + "-" + data.substring(0, 4) + data.substring(10);
        }
        if (data.charAt(4) == '/') {
            data = data.substring(8, 10) + "/" + data.substring(5, 7) + "/" + data.substring(0, 4) + data.substring(10);
        }
    
        String day = data.substring(0, 2);
        String month = data.substring(3, 5);
        String year = data.substring(6, 10);
        String hour = data.substring(11, 13);
        String minute = data.substring(14, 16);
        String second = data.substring(17, 19);
    
        checkDate2(day + "-" + month + "-" + year);
    
        int h = Integer.parseInt(hour);
        int m = Integer.parseInt(minute);
        int s = Integer.parseInt(second);
    
        if (h < 0 || h > 23) {
            throw new BuildException("La hora no es válida");
        }
        if (m < 0 || m > 59) {
            throw new BuildException("Los minutos no son válidos");
        }
        if (s < 0 || s > 59) {
            throw new BuildException("Los segundos no son válidos");
        }
    
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            return LocalDateTime.parse(data, formatter);
        } catch (DateTimeParseException e) {
            throw new BuildException("La fecha y hora son inválidas");
        }
    }
    

    

}
