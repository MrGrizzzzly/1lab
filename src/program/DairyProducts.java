package program;

import java.util.Objects;

/**
 * Класс самолета
 */
public class DairyProducts extends Product {

  /**
   * Завод изготовитель
   */
  private String manufacturerName;
  /**
   * Содержание жира
   */
  private int fatContent;


  /**
   * Конструктор по умолчанию
   */
  public DairyProducts() {
    this.manufacturerName = "default";
    this.fatContent = 0;
  }

  /**
   * Параметризированный конструктор
   *
   * @param name              название
   * @param cost              цена
   * @param manufacturerName  завод изготовитель
   * @param fatContent        содержание жира
   */
  public DairyProducts(String name, int cost, String manufacturerName, int fatContent) {
    super(name, cost);
    this.manufacturerName = manufacturerName;
    this.fatContent = fatContent;
  }

  /**
   * Метод для строкового представления
   *
   * @return строковое представление экземляра
   */
  @Override
  public String toString() {
    return
        super.toString() +
                String.format(", Завод изготовитель: %12s, Содержание жира: %2d%%", manufacturerName, fatContent);
  }

  /**
   * Переопределенный метод для сравнения
   *
   * @param obj екземляр, с которым будет происходить сравнение
   * @return являются ли экземпляры эквивалентными
   */
  @Override
  public boolean equals(Object obj) {
    DairyProducts dairprod = (DairyProducts) obj;
    return fatContent == dairprod.fatContent && manufacturerName.equals(
            dairprod.manufacturerName);
  }

  /**
   * Метод для получения хэш-кода
   *
   * @return хэш
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), manufacturerName, fatContent);
  }

  /**
   * геттер завода изготовитель
   *
   * @return завод изготовитель
   */
  public String getManufacturerName() {
    return manufacturerName;
  }

  /**
   * сеттер завода изготовителя
   *
   * @param manufacturerName завод изготовитель
   */
  public void setManufacturerName(String manufacturerName) {
    this.manufacturerName = manufacturerName;
  }

  /**
   * геттер содержания жира
   *
   * @return содержание жира
   */
  public int getFatContent() {
    return fatContent;
  }

  /**
   * сеттер содержания жира
   *
   * @param fatContent содержание жира
   */
  public void setFatContent(int fatContent) {
    if (fatContent > 0)
      this.fatContent = fatContent;
    else
      System.err.println("Должен быть хотя бы 1 двигатель");
  }
}
