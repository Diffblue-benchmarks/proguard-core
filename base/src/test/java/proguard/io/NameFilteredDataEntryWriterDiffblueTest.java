package proguard.io;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.util.EmptyStringMatcher;
import proguard.util.StringMatcher;

public class NameFilteredDataEntryWriterDiffblueTest {
  /**
   * Test {@link NameFilteredDataEntryWriter#NameFilteredDataEntryWriter(StringMatcher,
   * DataEntryWriter)}.
   *
   * <p>Method under test: {@link
   * NameFilteredDataEntryWriter#NameFilteredDataEntryWriter(StringMatcher, DataEntryWriter)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NameFilteredDataEntryWriter.<init>(StringMatcher, DataEntryWriter)"})
  public void testNewNameFilteredDataEntryWriter() throws IOException {
    // Arrange
    EmptyStringMatcher stringMatcher = new EmptyStringMatcher();

    // Act
    NameFilteredDataEntryWriter actualNameFilteredDataEntryWriter =
        new NameFilteredDataEntryWriter(
            stringMatcher,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NameFilteredDataEntryWriter.<init>(List, DataEntryWriter)"})
  public void testNewNameFilteredDataEntryWriter_given42_whenArrayListAdd42() throws IOException {
    // Arrange
    ArrayList<Object> regularExpressions = new ArrayList<>();
    regularExpressions.add("42");

    // Act
    NameFilteredDataEntryWriter actualNameFilteredDataEntryWriter =
        new NameFilteredDataEntryWriter(
            regularExpressions,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NameFilteredDataEntryWriter.<init>(List, DataEntryWriter)"})
  public void testNewNameFilteredDataEntryWriter_given42_whenArrayListAdd422() throws IOException {
    // Arrange
    ArrayList<Object> regularExpressions = new ArrayList<>();
    regularExpressions.add("42");
    regularExpressions.add("42");

    // Act
    NameFilteredDataEntryWriter actualNameFilteredDataEntryWriter =
        new NameFilteredDataEntryWriter(
            regularExpressions,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NameFilteredDataEntryWriter.<init>(List, DataEntryWriter)"})
  public void testNewNameFilteredDataEntryWriter_whenArrayList() throws IOException {
    // Arrange
    ArrayList<Object> regularExpressions = new ArrayList<>();

    // Act
    NameFilteredDataEntryWriter actualNameFilteredDataEntryWriter =
        new NameFilteredDataEntryWriter(
            regularExpressions,
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NameFilteredDataEntryWriter.<init>(String, DataEntryWriter)"})
  public void testNewNameFilteredDataEntryWriter_whenEmptyString() throws IOException {
    // Arrange and Act
    NameFilteredDataEntryWriter actualNameFilteredDataEntryWriter =
        new NameFilteredDataEntryWriter(
            "",
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NameFilteredDataEntryWriter.<init>(String, DataEntryWriter)"})
  public void testNewNameFilteredDataEntryWriter_whenRegularExpression() throws IOException {
    // Arrange and Act
    NameFilteredDataEntryWriter actualNameFilteredDataEntryWriter =
        new NameFilteredDataEntryWriter(
            "Regular Expression",
            new DirectoryWriter(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Assert
    assertNull(actualNameFilteredDataEntryWriter.createOutputStream(null));
    assertFalse(actualNameFilteredDataEntryWriter.createDirectory(null));
  }
}
