package program;

import java.util.Objects;

/**
 * Класс Мясо
 */
public class Meat extends Product {

  /**
   * Классификация по виду убитого животного
   */
  private String typeOfKilledAnimal;

  /**
   * Содержание углеводов
   */
  private int carbohydrates;

  /**
   * Конструктор без параметров
   */
  public Meat() {
    this.typeOfKilledAnimal = "default";
    this.carbohydrates = 0;
  }

  /**
   * Параметризированный конструктор
   *
   * @param name               название
   * @param cost               цена
   * @param typeOfKilledAnimal классификация по виду убитого животного
   * @param carbohydrates      содержание углеводов
   */
  public Meat(String name, int cost, String typeOfKilledAnimal, int carbohydrates) {
    super(name, cost);
    this.typeOfKilledAnimal = typeOfKilledAnimal;
    this.carbohydrates = carbohydrates;
  }


  /**
   * Метод для строкового представления
   *
   * @return строковое представление экземляра
   */
  @Override
  public String toString() {
    return super.toString()
            + String.format(", Классификация по виду убитого животного: %12s, Содержание углеводов: %2d%%", typeOfKilledAnimal, carbohydrates);
  }

  /**
   * Переопределенный метод для сравнения
   *
   * @param obj екземляр, с которым будет происходить сравнение
   * @return являются ли экземпляры эквивалентными
   */
  @Override
  public boolean equals(Object obj) {
    Meat meat = (Meat) obj;
    return carbohydrates == meat.carbohydrates && Objects.equals(typeOfKilledAnimal, meat.typeOfKilledAnimal);
  }

  /**
   * Метод для получения хэш-кода
   *
   * @return хэш
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), typeOfKilledAnimal, carbohydrates);
  }

  /**
   * геттер классификации
   *
   * @return тип классификации
   */
  public String getTypeOfKilledAnimal() {
    return typeOfKilledAnimal;
  }

  /**
   * сеттер типа классификации
   *
   * @param typeOfKilledAnimal тип классификации
   */
  public void setTypeOfKilledAnimal(String typeOfKilledAnimal) {
    this.typeOfKilledAnimal = typeOfKilledAnimal;
  }

  /**
   * геттер содержания жира
   *
   * @return содержания жира
   */
  public int getCarbohydrates() {
    return carbohydrates;
  }

  /**
   * сеттер содержания жира
   *
   * @param carbohydrates содержания жира
   */
  public void setCarbohydrates(int carbohydrates) {
    if (carbohydrates < 0) {
      this.carbohydrates = carbohydrates;
    } else {
      System.err.println("Не может быть отрицательным");
    }
  }
}
