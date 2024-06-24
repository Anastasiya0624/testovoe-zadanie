import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение (например, 2 + 2):");
        String input = scanner.nextLine();
        String result = calc(input);
        System.out.println("Результат: " + result);
    }

    static String calc(String input) {
        String[] parts = input.split(" ");
        String num1 = parts[0].trim();
        String operator = parts[1].trim();
        String num2 = parts[2].trim();

        if (!isValidInput(num1) || !isValidInput(num2)) {
            throw new IllegalArgumentException("Неподходящие числа");
        }

        int operand1 = convertToNumber(num1);
        int operand2 = convertToNumber(num2);
        int result = 0;

        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                if (operand2 == 0) {
                    throw new ArithmeticException("Деление на ноль");
                }
                result = operand1 / operand2;
                break;
            default:
                throw new IllegalArgumentException("Неверный оператор");
        }

        if (isRomanNumeral(num1) && isRomanNumeral(num2)) {
            if (result <= 0) {
                throw new IllegalArgumentException("Результат меньше единицы");
            }
            return convertToRomanNumeral(result);
        } else {
            return String.valueOf(result);
        }
    }

    static boolean isValidInput(String input) {
        return input.matches("[IVXLCDM]+") || input.matches("[0-9]+");
    }

    static boolean isRomanNumeral(String input) {
        return input.matches("[IVXLCDM]+");
    }

    static int convertToNumber(String input) {
        if (isRomanNumeral(input)) {
            return RomanNumeralConverter.romanToArabic(input);
        } else {
            return Integer.parseInt(input);
        }
    }

    static String convertToRomanNumeral(int number) {
        return RomanNumeralConverter.arabicToRoman(number);
    }
}


      /*  String welcome = "Hello World!";  строки


        System.out.println(welcome);*/


