package program;

import java.util.Scanner;

/**
 * Класс для ввода в консоль
 */
public class Input {

  /**
   * Метод для ввода и проверки вводимых значений типа int
   *
   * @return Значение int
   */
  public static int intInput() {
    int value;
    Scanner in = new Scanner(System.in);
    while (true) {
      String str = in.nextLine();
      // Преобразование строки в число
      try{
        value = Integer.parseInt(str);
        return value;
      }catch (NumberFormatException ex){
        // Если не число выводим соотвестующие сообщение
        System.err.println("Необходимо ввести число");
      }
    }
  }

  /**
   * Метод для проверки принадлежности числа типа int к натуральным числам
   *
   * @return положитлеьное число типа int
   */
    public static int naturalIntInput() {
    int num;
    do {
      num = intInput();
      if (num <= 0)
        System.err.println("Число должно быть положительным");
    } while (num <= 0);
    return num;
  }

  /**
   * Метод для ввода строки и проверки на пустоту
   *
   * @return строка
   */
  public static String stringInput() {
    String string;
    Scanner in = new Scanner(System.in);
    do {
      string = in.nextLine();
      if (string.length() == 0)
        System.err.println("Строка не может быть пустой");
    }
    while (string.length() == 0);

    return string;
  }
}