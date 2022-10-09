import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
       System.out.println(calc(readStr()));
    }

    public static String calc(String input) {
        String result = " ";
        if (isCorrectStr(input)) {
            String[] splitLine = input.split(" ");
            int a = 0;
            int b = 0;
            String operand = splitLine[1];
            if (isArabicNumber(splitLine[0])) {
                a = Integer.parseInt(splitLine[0]);
                b = Integer.parseInt(splitLine[2]);
                result = arithmeticOperation(a, b, operand);
            } else {
                a = conversionToArabicNumber(splitLine[0]);
                b = conversionToArabicNumber(splitLine[2]);
                if (Integer.parseInt(arithmeticOperation(a, b, operand)) <= 0) {
                    try {
                        throw new Exception();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    result = conversionToRomanNumber(arithmeticOperation(a, b, operand));
                }
            }
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static String readStr()  {
        String str = null;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            str = reader.readLine();
        } catch (IOException  | NullPointerException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static boolean isCorrectStr(String str) {
        String[] splitLine = str.split(" ");
        return (splitLine.length == 3) &&
                ((splitLine[0].matches("^([1-9]|10)$") && splitLine[2].matches("^([1-9]|10)$")) ||
                (splitLine[0].matches("^(I{1,3}|IV|IX|VI{0,3}|X)$") && splitLine[2].matches("^(I{1,3}|IV|IX|VI{0,3}|X)$"))) &&
                        (splitLine[1].matches("^(-|\\+|\\*|\\/)$"));


    }


    public static boolean isArabicNumber(String number) {

        return number.matches("^([1-9]|10)$");
    }

    public static int conversionToArabicNumber(String number) {
        int arabicNumber = 0;
        switch (number) {
            case "I" -> arabicNumber = 1;
            case "II" -> arabicNumber = 2;
            case "III" -> arabicNumber = 3;
            case "IV" -> arabicNumber = 4;
            case "V" -> arabicNumber = 5;
            case "VI" -> arabicNumber = 6;
            case "VII" -> arabicNumber = 7;
            case "VIII" -> arabicNumber = 8;
            case "IX" -> arabicNumber = 9;
            case "X" -> arabicNumber = 10;
        }
        return arabicNumber;
    }

    public static String conversionToRomanNumber(String number) {
        String romanNumber = null;
        switch (number) {
            case "1" -> romanNumber = "I";
            case "2" -> romanNumber = "II";
            case "3" -> romanNumber = "III";
            case "4" -> romanNumber = "IV";
            case "5" -> romanNumber = "V";
            case "6" -> romanNumber = "VI";
            case "7" -> romanNumber = "VII";
            case "8" -> romanNumber = "VIII";
            case "9" -> romanNumber = "IX";
            case "10" -> romanNumber = "X";
        }
        return romanNumber;
    }



    public static String arithmeticOperation(int operator1, int operator2, String operand) {
        String resultOfOperation = null;
            switch (operand) {
                case "+" -> resultOfOperation = String.valueOf(operator1 + operator2);
                case "-" -> resultOfOperation = String.valueOf(operator1 - operator2);
                case "*" -> resultOfOperation = String.valueOf(operator1 * operator2);
                case "/" -> resultOfOperation = String.valueOf(operator1 / operator2);
            }
        return resultOfOperation;
    }
}
