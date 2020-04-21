package ic.doc;

import static ic.doc.BookSearchBuilder.bookSearch;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import ic.doc.catalogues.Catalogue;
import java.util.Arrays;
import java.util.List;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class BookSearchQueryTest {

  private static final Object BOOKS =
      Arrays.asList(new Book("A Christmas Carol", "Charles Dickens", 1766));
  @Rule public JUnitRuleMockery context = new JUnitRuleMockery();

  // create a mock object for any type of catalogue
  final Catalogue catalogue = context.mock(Catalogue.class);

  @Test
  public void searchesForBooksInLibraryCatalogueByAuthorSurname() {
    context.checking(
        new Expectations() {
          {
            oneOf(catalogue).searchFor("LASTNAME='dickens' ");
            will(returnValue(BOOKS));
          }
        });

    List<Book> books = bookSearch().byLastName("dickens").build().execute(catalogue);
    assertThat(books, is(BOOKS));
  }

  @Test
  public void searchesForBooksInLibraryCatalogueByAuthorFirstname() {
    context.checking(
        new Expectations() {
          {
            oneOf(catalogue).searchFor("FIRSTNAME='Jane' ");
          }
        });

    bookSearch().byFirstName("Jane").build().execute(catalogue);
  }

  @Test
  public void searchesForBooksInLibraryCatalogueByTitle() {
    context.checking(
        new Expectations() {
          {
            oneOf(catalogue).searchFor("TITLECONTAINS(Two Cities) ");
          }
        });

    bookSearch().byTitleContains("Two Cities").build().execute(catalogue);
  }

  @Test
  public void searchesForBooksInLibraryCatalogueBeforeGivenPublicationYear() {
    context.checking(
        new Expectations() {
          {
            oneOf(catalogue).searchFor("PUBLISHEDBEFORE(1700) ");
          }
        });

    bookSearch().byPublishedBefore(1700).build().execute(catalogue);
  }

  @Test
  public void searchesForBooksInLibraryCatalogueAfterGivenPublicationYear() {
    context.checking(
        new Expectations() {
          {
            oneOf(catalogue).searchFor("PUBLISHEDAFTER(1950) ");
          }
        });

    bookSearch().byPublishedAfter(1950).build().execute(catalogue);
  }

  @Test
  public void searchesForBooksInLibraryCatalogueWithCombinationOfParameters() {
    context.checking(
        new Expectations() {
          {
            oneOf(catalogue).searchFor("LASTNAME='dickens' PUBLISHEDBEFORE(1840) ");
          }
        });

    bookSearch().byLastName("dickens").byPublishedBefore(1840).build().execute(catalogue);
  }

  @Test
  public void searchesForBooksInLibraryCatalogueWithCombinationOfTitleAndOtherParameters() {
    context.checking(
        new Expectations() {
          {
            oneOf(catalogue)
                .searchFor("TITLECONTAINS(of) PUBLISHEDAFTER(1800) " + "PUBLISHEDBEFORE(2000) ");
          }
        });

    bookSearch()
        .byTitleContains("of")
        .byPublishedBefore(2000)
        .byPublishedAfter(1800)
        .build()
        .execute(catalogue);
  }
}
