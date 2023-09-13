package program;

import java.util.ArrayList;
import static java.lang.System.err;
import static java.lang.System.out;

/**
 * Класс тектового интерфейса
 */
public class TUI {

  /**
   * Метод меню, выполняющийся при начале работы
   */
  public static void menu() {
    ArrayList<Product> list = new ArrayList<>();
    //Демонстационные данные
    list.add(new Meat("Мясное изделие", 500, "Свинина", 35));
    list.add(new Meat("Мясная тушка", 50, "Говядина", 20));
    list.add(new Fruit("Яблоко", 500, "Семечковые", 35));
    list.add(new Fruit("Авокадо", 50, "Косточковые", 20));
    list.add(new DairyProducts("Молоко", 500, "Простоквашино", 1));
    list.add(new DairyProducts("Кефир", 50, "Простоквашино", 3));
    while (true){
      menuOutput();
      switch (Input.intInput()) {
        case 1 -> chooseCreateMode(list);
        case 2 -> deleteVehicle(list);
        case 3 -> printAllVehicles(list);
        case 4 -> compareVehicles(list);
        case 5 -> {return;}
        default -> err.println("Использована неизвестная команда");
      }
    }
  }

  /**
   * Метод для выбора режима создания 1 - с заполнением полей 2 - с полями по умолчанию
   *
   * @param list список с транспортными средствами
   */
  private static void chooseCreateMode(ArrayList<Product> list) {
    createInfo();
    while (true){
      switch (Input.intInput()) {
        case 1 -> {addTransport(list); return;}
        case 2 -> {addClearTransport(list); return;}
        case 3 -> {return;}
        default -> err.println("Выберите действие из предложенных");
      }
    }
  }

  /**
   * Метод для выбора типа транспота для создания с заполнением полей
   *
   * @param list список с транспортными средствами
   */
  private static void addTransport(ArrayList<Product> list) {
    typesOutput();
    while (true){
      switch (Input.intInput()) {
        case 1 -> {list.add(vehicleMakerInput()); return;}
        case 2 -> {list.add(fruitMakerInput()); return;}
        case 3 -> {list.add(meatMakerInput()); return;}
        case 4 -> {list.add(dairyProductsMakerInput()); return;}
        case 5 -> {return;}
        default -> err.println("Использована неизвестная команда");
     }
    }
  }

  /**
   * Метод для выбора создаваемого средства без полей
   *
   * @param list список с транспортными средствами
   */
  private static void addClearTransport(ArrayList<Product> list) {
    typesOutput();
    while (true) {
      switch (Input.intInput()) {
        case 1 -> {list.add(new Product()); return;}
        case 2 -> {list.add(new Fruit()); return;}
        case 3 -> {list.add(new Meat()); return;}
        case 4 -> {list.add(new DairyProducts()); return;}
        case 5 -> {return;}
        default -> err.println("Использована неизвестная команда");
      }
    }
  }

  /**
   * Метод для создания транспортного средства с полями
   *
   * @return экземляр класса TransportVehicle
   */
  private static Product vehicleMakerInput() {
    String name;
    int cost;
    out.println("Название:");
    name = Input.stringInput();
    out.println("Стоимость:");
    cost = Input.naturalIntInput();
    return new Product(name, cost);
  }

  /**
   * Метод для создания автомобиля с полями
   *
   * @return экземляр класса Car
   */
  private static Fruit fruitMakerInput() {
    String name;
    String fruitCategory;
    int cost;
    int acidContent;
    out.println("Название:");
    name = Input.stringInput();
    out.println("Стоимость:");
    cost = Input.naturalIntInput();
    out.println("Категория фруктов:");
    fruitCategory = Input.stringInput();
    out.println("Содержание кислоты:");
    acidContent = Input.naturalIntInput();
    return new Fruit(name, cost, fruitCategory, acidContent);
  }

  /**
   * Метод для создания поезда с полями
   *
   * @return экземляр класса Car
   */
  private static Meat meatMakerInput() {
    String name;
    String typeOfKilledAnimal;
    int cost;
    int carbohydrates;
    out.println("Название:");
    name = Input.stringInput();
    out.println("Стоимость:");
    cost = Input.naturalIntInput();
    out.println("Классификация по виду убитого животного:");
    typeOfKilledAnimal = Input.stringInput();
    out.println("Содержание углеводов:");
    carbohydrates = Input.naturalIntInput();
    return new Meat(name, cost, typeOfKilledAnimal, carbohydrates);
  }

  /**
   * Метод для создания экспресса с полями
   *
   * @return экземляр класса Express
   */
  private static DairyProducts dairyProductsMakerInput() {
    String name;
    String manufacturerName;
    int cost;
    int fatContent;
    out.println("Название:");
    name = Input.stringInput();
    out.println("Стоимость:");
    cost = Input.naturalIntInput();
    out.println("Завод изготовитель:");
    manufacturerName = Input.stringInput();
    out.println("Содержание жира:");
    fatContent = Input.naturalIntInput();
    return new DairyProducts(name, cost, manufacturerName, fatContent);
  }

  /**
   * Метод для вывода всех транспортных средств из списка
   *
   * @param list список с транспортными средствами
   */
  private static void printAllVehicles(ArrayList<Product> list) {
    if (list.isEmpty()) {
      err.println("Продуктов нету");
    } else {
      list.forEach(out::println);
    }
  }

  /**
   * Метод для удаления транспорта из списка
   *
   * @param list список с транспортными средствами
   */
  private static void deleteVehicle(ArrayList<Product> list) {
    if (list.isEmpty()) {
      err.println("Продуктов нету");
    } else {
      out.println("Введите номер элемента для удаления:");
      try {
        list.remove(Input.naturalIntInput() - 1);
      } catch (IndexOutOfBoundsException e) {
        err.println("Выбран несуществующий элемент");
      }
    }
  }

  /**
   * Метод для сравнения 2-х экземпляров
   *
   * @param list список с транспортными средствами
   */
  private static void compareVehicles(ArrayList<Product> list) {
    int firstVehicleNumber, secondVehicleNumber;
    if (list.size() < 2) {
      out.println("продуктов недостаточно");
    } else {
      out.println("Введите номер продукта:");
      firstVehicleNumber = Input.naturalIntInput();
      out.println("Введите номер продукта для сравнения:");
      secondVehicleNumber = Input.naturalIntInput();
      try {
        if (list.get(firstVehicleNumber - 1).hashCode() == list.get(secondVehicleNumber - 1)
                .hashCode() &&
                list.get(firstVehicleNumber - 1).equals(list.get(secondVehicleNumber - 1))) {
          out.println("Продукты эквивалентны");
        } else {
          out.println("Продукты средства различаются");
        }
      } catch (IndexOutOfBoundsException e) {
        err.println("Выбраны несуществующие индексы");
      }
    }
  }

  /**
   * Метод для вывода типов транспотных средств
   */
  private static void typesOutput() {
    out.println("1. Продукт");
    out.println("2. Фрукт");
    out.println("3. Мясо");
    out.println("4. Молочная продукция");
    out.println("5. Выход");
  }

  /**
   * Метод для вывода пунктов меню
   */
  private static void menuOutput() {
    out.println("1. Добавить продукт");
    out.println("2. Удалить продукт");
    out.println("3. Вывод всех продуктов");
    out.println("4. Сравнение продуктов");
    out.println("5. Выход");
  }

  /**
   * Метод для вывода меню создания
   */
  private static void createInfo() {
    out.println("1. Заполнить данные о продукте");
    out.println("2. Создать продукт без данных");
    out.println("3. Назад");
  }
}
