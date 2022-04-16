import java.util.*;

class Main {

    private static void numExcep(int num1, int num2) throws Exception {
        if (num1 < 1 || num1 > 10 || num2 < 1 || num2 > 10)

            throw new Exception("Число не входит в диапазон допустимых!!");
    }

    public static String calc(String inputString) throws Exception {
        int res;
        String result;
        String[] expression = inputString.split(" ");
        String[] ret = new String[1];
        if (expression.length != 3)
            throw new Exception("Недопустимое количество операндов");
        try {
            int num1 = Integer.parseInt(expression[0]);
            int num2 = Integer.parseInt(expression[2]);
            numExcep(num1, num2);
            switch (expression[1]) {
                case ("+"):
                    res = num1 + num2;
                    result = Integer.toString(res);
                    ret = result.split(" ");
                    break;
                case ("-"):
                    res = num1 - num2;
                    result = Integer.toString(res);
                    ret = result.split(" ");
                    break;
                case ("/"):
                    res = num1 / num2;
                    result = Integer.toString(res);
                    ret = result.split(" ");
                    break;
                case ("*"):
                    res = num1 * num2;
                    result = Integer.toString(res);
                    ret = result.split(" ");
                    break;
                default:
                    throw new Exception("Неверный знак!");

            }
        }
        catch (NumberFormatException e) {
            int numx = romeNum.romanToArabic(expression[0]);
            int numy = romeNum.romanToArabic(expression[2]);
            numExcep(numx, numy);
            switch (expression[1]) {
                case ("+"):
                    res = numx + numy;
                    result = arabNextRome.arabRome(res);
                    ret = result.split(" ");
                    break;
                case ("-"):
                    res = numx - numy;
                    result = arabNextRome.arabRome(res);
                    ret = result.split(" ");
                    break;
                case ("/"):
                    res = numx / numy;
                    result = arabNextRome.arabRome(res);
                    ret = result.split(" ");
                    break;
                case ("*"):
                    res = numx * numy;
                    result = arabNextRome.arabRome(res);
                    ret = result.split(" ");
                    break;
                default:
                    throw new Exception("Неверный знак!");
            }
            if (res < 1) throw new Exception("Недопустимый формат ввода!!!");
        }

        return ret[0];
    }

    public static void main(String[] args) {
        System.out.println("Введите выражение: ");
        Scanner sc = new Scanner(System.in);
        String scan = sc.nextLine();
        sc.close();
        try {
            System.out.print(Main.calc(scan));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class romeNum {
    static int romanToArabic(String roman) throws Exception {
        return switch (roman) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> throw new Exception("Неверный диапазон ввода данных!!");
        };
    }
}

class arabNextRome {
    static String arabRome(int rome) {
        int[] arabNum = new int[]{100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanNum = new String[]{"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder res = new StringBuilder();
        int x = arabNum.length;
        for (int a = 0; a < x; a += 1) {
            while (rome >= arabNum[a]) {
                rome -= arabNum[a];
                res.append(romanNum[a]);
            }
        }
        return String.valueOf(res);
    }
}