package ic.doc;

public class BookSearchBuilder {

  private String name1;
  private String name2;
  private String title;
  private Integer date1;
  private Integer date2;

  // constructor
  private BookSearchBuilder() {
  }

  // function to instantiate a new search request
  public static BookSearchBuilder bookSearch() {
    return new BookSearchBuilder();
  }

  public BookSearchQuery build() {
    return new BookSearchQuery(name1, name2, title, date1, date2);
  }

  public BookSearchBuilder byFirstName(String name1) {
    this.name1 = name1;
    return this;
  }

  public BookSearchBuilder byLastName(String name2) {
    this.name2 = name2;
    return this;
  }

  public BookSearchBuilder byTitleContains(String title) {
    this.title = title;
    return this;
  }

  public BookSearchBuilder byPublishedBefore(Integer date2) {
    this.date2 = date2;
    return this;
  }

  public BookSearchBuilder byPublishedAfter(Integer date1) {
    this.date1 = date1;
    return this;
  }
}