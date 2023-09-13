package program;

import java.util.Objects;

/**
 * Класс фрукта
 */
public class Fruit extends Product {

  /**
   * Категория фруктов
   */
  private String fruitCategory;

  /**
   * Содержание кислоты
   */
  private int acidContent;

  /**
   * Конструктор без параметров
   */
  public Fruit() {
    this.fruitCategory = "default";
    this.acidContent = 0;
  }

  /**
   * Параметризированный конструктор
   *
   * @param name          название
   * @param cost          цена
   * @param acidContent   содержание кислоты
   * @param fruitCategory категория фруктов
   */
  public Fruit(String name, int cost, String fruitCategory, int acidContent) {
    super(name, cost);
    this.fruitCategory = fruitCategory;
    this.acidContent = acidContent;

  }

  /**
   * Метод для строкового представления
   *
   * @return строковое представление экземляра
   */
  @Override
  public String toString() {
    return super.toString()
            + String.format(", Категория фруктов: %12s, Содержание кислоты: %2d%%", fruitCategory, acidContent);
  }

  /**
   * Переопределенный метод для сравнения
   *
   * @param obj екземляр, с которым будет происходить сравнение
   * @return являются ли экземпляры эквивалентными
   */
  @Override
  public boolean equals(Object obj) {
    Fruit fruit = (Fruit) obj;
    return acidContent == fruit.acidContent && Objects.equals(fruitCategory, fruit.fruitCategory);
  }

  /**
   * Метод для получения хэш-кода
   *
   * @return хэш
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), fruitCategory, acidContent);
  }

  /**
   * геттер категории фруктов
   *
   * @return тип категории фруктов
   */
  public String getFruitCategory() {
    return fruitCategory;
  }

  /**
   * сеттер категории фруктов
   *
   * @param fruitCategory категория фруктов
   */
  public void setFruitCategory(String fruitCategory) {
    this.fruitCategory = fruitCategory;
  }

  /**
   * геттер содержания кислоты
   *
   * @return содержания кислоты
   */
  public int getAcidContent() {
    return acidContent;
  }

  /**
   * сеттер содержания кислоты
   *
   * @param acidContent содержания кислоты
   */
  public void setAcidContent(int acidContent) {
    if (acidContent < 0) {
      this.acidContent = acidContent;
    } else {
      System.err.println("Не может быть отрицательным");
    }
  }
}

