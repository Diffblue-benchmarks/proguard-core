package proguard.io;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.util.EmptyStringMatcher;
import proguard.util.StringMatcher;

class NameFilteredDataEntryWriterDiffblueTest {
  /**
   * Test {@link NameFilteredDataEntryWriter#NameFilteredDataEntryWriter(StringMatcher,
   * DataEntryWriter)}.
   *
   * <p>Method under test: {@link
   * NameFilteredDataEntryWriter#NameFilteredDataEntryWriter(StringMatcher, DataEntryWriter)}
   */
  @Test
  @DisplayName("Test new NameFilteredDataEntryWriter(StringMatcher, DataEntryWriter)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NameFilteredDataEntryWriter.<init>(StringMatcher, DataEntryWriter)"})
  void testNewNameFilteredDataEntryWriter() throws IOException {
    // Arrange
    EmptyStringMatcher stringMatcher = new EmptyStringMatcher();
    DirectoryWriter acceptedDataEntryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act
    NameFilteredDataEntryWriter actualNameFilteredDataEntryWriter =
        new NameFilteredDataEntryWriter(stringMatcher, acceptedDataEntryWriter);

    // Assert
    assertNull(actualNameFilteredDataEntryWriter.createOutputStream(null));
    assertFalse(actualNameFilteredDataEntryWriter.createDirectory(null));
  }

  /**
   * Test {@link NameFilteredDataEntryWriter#NameFilteredDataEntryWriter(List, DataEntryWriter)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link NameFilteredDataEntryWriter#NameFilteredDataEntryWriter(List,
   * DataEntryWriter)}
   */
  @Test
  @DisplayName(
      "Test new NameFilteredDataEntryWriter(List, DataEntryWriter); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NameFilteredDataEntryWriter.<init>(List, DataEntryWriter)"})
  void testNewNameFilteredDataEntryWriter_given42_whenArrayListAdd42() throws IOException {
    // Arrange
    ArrayList<Object> regularExpressions = new ArrayList<>();
    regularExpressions.add("42");
    DirectoryWriter acceptedDataEntryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act
    NameFilteredDataEntryWriter actualNameFilteredDataEntryWriter =
        new NameFilteredDataEntryWriter(regularExpressions, acceptedDataEntryWriter);

    // Assert
    assertNull(actualNameFilteredDataEntryWriter.createOutputStream(null));
    assertFalse(actualNameFilteredDataEntryWriter.createDirectory(null));
  }

  /**
   * Test {@link NameFilteredDataEntryWriter#NameFilteredDataEntryWriter(List, DataEntryWriter)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link NameFilteredDataEntryWriter#NameFilteredDataEntryWriter(List,
   * DataEntryWriter)}
   */
  @Test
  @DisplayName(
      "Test new NameFilteredDataEntryWriter(List, DataEntryWriter); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NameFilteredDataEntryWriter.<init>(List, DataEntryWriter)"})
  void testNewNameFilteredDataEntryWriter_given42_whenArrayListAdd422() throws IOException {
    // Arrange
    ArrayList<Object> regularExpressions = new ArrayList<>();
    regularExpressions.add("42");
    regularExpressions.add("42");
    DirectoryWriter acceptedDataEntryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act
    NameFilteredDataEntryWriter actualNameFilteredDataEntryWriter =
        new NameFilteredDataEntryWriter(regularExpressions, acceptedDataEntryWriter);

    // Assert
    assertNull(actualNameFilteredDataEntryWriter.createOutputStream(null));
    assertFalse(actualNameFilteredDataEntryWriter.createDirectory(null));
  }

  /**
   * Test {@link NameFilteredDataEntryWriter#NameFilteredDataEntryWriter(List, DataEntryWriter)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link NameFilteredDataEntryWriter#NameFilteredDataEntryWriter(List,
   * DataEntryWriter)}
   */
  @Test
  @DisplayName("Test new NameFilteredDataEntryWriter(List, DataEntryWriter); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NameFilteredDataEntryWriter.<init>(List, DataEntryWriter)"})
  void testNewNameFilteredDataEntryWriter_whenArrayList() throws IOException {
    // Arrange
    ArrayList<Object> regularExpressions = new ArrayList<>();
    DirectoryWriter acceptedDataEntryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act
    NameFilteredDataEntryWriter actualNameFilteredDataEntryWriter =
        new NameFilteredDataEntryWriter(regularExpressions, acceptedDataEntryWriter);

    // Assert
    assertNull(actualNameFilteredDataEntryWriter.createOutputStream(null));
    assertFalse(actualNameFilteredDataEntryWriter.createDirectory(null));
  }

  /**
   * Test {@link NameFilteredDataEntryWriter#NameFilteredDataEntryWriter(String, DataEntryWriter)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link NameFilteredDataEntryWriter#NameFilteredDataEntryWriter(String,
   * DataEntryWriter)}
   */
  @Test
  @DisplayName("Test new NameFilteredDataEntryWriter(String, DataEntryWriter); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NameFilteredDataEntryWriter.<init>(String, DataEntryWriter)"})
  void testNewNameFilteredDataEntryWriter_whenEmptyString() throws IOException {
    // Arrange
    DirectoryWriter acceptedDataEntryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act
    NameFilteredDataEntryWriter actualNameFilteredDataEntryWriter =
        new NameFilteredDataEntryWriter("", acceptedDataEntryWriter);

    // Assert
    assertNull(actualNameFilteredDataEntryWriter.createOutputStream(null));
    assertFalse(actualNameFilteredDataEntryWriter.createDirectory(null));
  }

  /**
   * Test {@link NameFilteredDataEntryWriter#NameFilteredDataEntryWriter(String, DataEntryWriter)}.
   *
   * <ul>
   *   <li>When {@code Regular Expression}.
   * </ul>
   *
   * <p>Method under test: {@link NameFilteredDataEntryWriter#NameFilteredDataEntryWriter(String,
   * DataEntryWriter)}
   */
  @Test
  @DisplayName(
      "Test new NameFilteredDataEntryWriter(String, DataEntryWriter); when 'Regular Expression'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NameFilteredDataEntryWriter.<init>(String, DataEntryWriter)"})
  void testNewNameFilteredDataEntryWriter_whenRegularExpression() throws IOException {
    // Arrange
    DirectoryWriter acceptedDataEntryWriter =
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile());

    // Act
    NameFilteredDataEntryWriter actualNameFilteredDataEntryWriter =
        new NameFilteredDataEntryWriter("Regular Expression", acceptedDataEntryWriter);

    // Assert
    assertNull(actualNameFilteredDataEntryWriter.createOutputStream(null));
    assertFalse(actualNameFilteredDataEntryWriter.createDirectory(null));
  }
}
