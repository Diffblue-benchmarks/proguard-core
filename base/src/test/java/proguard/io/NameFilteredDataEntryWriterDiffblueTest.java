package proguard.io;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import proguard.util.EmptyStringMatcher;
import proguard.util.StringMatcher;

public class NameFilteredDataEntryWriterDiffblueTest {
  /**
   * Method under test:
   * {@link NameFilteredDataEntryWriter#NameFilteredDataEntryWriter(String, DataEntryWriter)}
   */
  @Test
  public void testNewNameFilteredDataEntryWriter() throws IOException {
    // Arrange and Act
    NameFilteredDataEntryWriter actualNameFilteredDataEntryWriter = new NameFilteredDataEntryWriter(
        "Regular Expression",
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Assert
    assertNull(actualNameFilteredDataEntryWriter.createOutputStream(null));
    assertFalse(actualNameFilteredDataEntryWriter.createDirectory(null));
  }

  /**
   * Method under test:
   * {@link NameFilteredDataEntryWriter#NameFilteredDataEntryWriter(String, DataEntryWriter)}
   */
  @Test
  public void testNewNameFilteredDataEntryWriter2() throws IOException {
    // Arrange and Act
    NameFilteredDataEntryWriter actualNameFilteredDataEntryWriter = new NameFilteredDataEntryWriter("",
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Assert
    assertNull(actualNameFilteredDataEntryWriter.createOutputStream(null));
    assertFalse(actualNameFilteredDataEntryWriter.createDirectory(null));
  }

  /**
   * Method under test:
   * {@link NameFilteredDataEntryWriter#NameFilteredDataEntryWriter(List, DataEntryWriter)}
   */
  @Test
  public void testNewNameFilteredDataEntryWriter3() throws IOException {
    // Arrange
    ArrayList<Object> regularExpressions = new ArrayList<>();

    // Act
    NameFilteredDataEntryWriter actualNameFilteredDataEntryWriter = new NameFilteredDataEntryWriter(regularExpressions,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Assert
    assertNull(actualNameFilteredDataEntryWriter.createOutputStream(null));
    assertFalse(actualNameFilteredDataEntryWriter.createDirectory(null));
  }

  /**
   * Method under test:
   * {@link NameFilteredDataEntryWriter#NameFilteredDataEntryWriter(List, DataEntryWriter)}
   */
  @Test
  public void testNewNameFilteredDataEntryWriter4() throws IOException {
    // Arrange
    ArrayList<Object> regularExpressions = new ArrayList<>();
    regularExpressions.add("42");

    // Act
    NameFilteredDataEntryWriter actualNameFilteredDataEntryWriter = new NameFilteredDataEntryWriter(regularExpressions,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Assert
    assertNull(actualNameFilteredDataEntryWriter.createOutputStream(null));
    assertFalse(actualNameFilteredDataEntryWriter.createDirectory(null));
  }

  /**
   * Method under test:
   * {@link NameFilteredDataEntryWriter#NameFilteredDataEntryWriter(List, DataEntryWriter)}
   */
  @Test
  public void testNewNameFilteredDataEntryWriter5() throws IOException {
    // Arrange
    ArrayList<Object> regularExpressions = new ArrayList<>();
    regularExpressions.add("42");
    regularExpressions.add("42");

    // Act
    NameFilteredDataEntryWriter actualNameFilteredDataEntryWriter = new NameFilteredDataEntryWriter(regularExpressions,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Assert
    assertNull(actualNameFilteredDataEntryWriter.createOutputStream(null));
    assertFalse(actualNameFilteredDataEntryWriter.createDirectory(null));
  }

  /**
   * Method under test:
   * {@link NameFilteredDataEntryWriter#NameFilteredDataEntryWriter(StringMatcher, DataEntryWriter)}
   */
  @Test
  public void testNewNameFilteredDataEntryWriter6() throws IOException {
    // Arrange
    EmptyStringMatcher stringMatcher = new EmptyStringMatcher();

    // Act
    NameFilteredDataEntryWriter actualNameFilteredDataEntryWriter = new NameFilteredDataEntryWriter(stringMatcher,
        new DirectoryWriter(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));

    // Assert
    assertNull(actualNameFilteredDataEntryWriter.createOutputStream(null));
    assertFalse(actualNameFilteredDataEntryWriter.createDirectory(null));
  }
}
