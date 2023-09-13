package program;

import java.util.Objects;

/**
 * Класс продуктов
 */
public class Product {

  /**
   * Название
   */
  private String name;

  /**
   * Цена
   */
  private int cost;

  /**
   * Конструктор без параметров
   */
  Product() {
    this.name = "default";
    this.cost = 0;
  }

  /**
   * Параметризированный конструктор
   *
   * @param name название
   * @param cost грузоподъемность
   */
  public Product(String name, int cost) {
    this.name = name;
    this.cost = cost;
  }

  /**
   * Метод для строкового представления
   *
   * @return строковое представление экземляра
   */

  @Override
  public String toString() {
    return String.format("Название: %15s, Стоимость: %4d$", name, cost);
  }

  /**
   * Переопределенный метод для сравнения
   *
   * @param obj екземляр, с которым будет происходить сравнение
   * @return являются ли экземпляры эквивалентными
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null || getClass() != obj.getClass())
      return false;
    Product vehicle = (Product) obj;
    return cost == vehicle.cost && name.equals(vehicle.name);
  }

  /**
   * Метод для получения хэш-кода
   *
   * @return хэш
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, cost);
  }


  /**
   * геттер имени
   *
   * @return имя
   */
  public String getName() {
    return name;
  }

  /**
   * сеттер имени
   *
   * @param name имя
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * геттер цены
   *
   * @return цена
   */
  public int getCost() {
    return cost;
  }

  /**
   * сеттер цены
   *
   * @param cost цена
   */
  public void setCost(int cost) {
    if (cost > 0) {
      this.cost = cost;
    } else {
      System.err.println("Цена не может быть отрицательной");
    }
  }
}
