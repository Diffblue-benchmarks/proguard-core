package proguard.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import org.junit.Test;

public class NamedDataEntryDiffblueTest {
  /**
   * Method under test: {@link NamedDataEntry#getOriginalName()}
   */
  @Test
  public void testGetOriginalName() {
    // Arrange, Act and Assert
    assertEquals("Name", (new NamedDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true)).getOriginalName());
  }

  /**
   * Method under test: {@link NamedDataEntry#getInputStream()}
   */
  @Test
  public void testGetInputStream() throws IOException {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new NamedDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true)).getInputStream());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NamedDataEntry#closeInputStream()}
   *   <li>{@link NamedDataEntry#toString()}
   *   <li>{@link NamedDataEntry#getName()}
   *   <li>{@link NamedDataEntry#getParent()}
   *   <li>{@link NamedDataEntry#getSize()}
   *   <li>{@link NamedDataEntry#isDirectory()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws IOException {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");
    NamedDataEntry namedDataEntry = new NamedDataEntry(parent, "Name", 3L, true);

    // Act
    namedDataEntry.closeInputStream();
    String actualToStringResult = namedDataEntry.toString();
    String actualName = namedDataEntry.getName();
    DataEntry actualParent = namedDataEntry.getParent();
    long actualSize = namedDataEntry.getSize();

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals("Name:Name", actualToStringResult);
    assertEquals(3L, actualSize);
    assertTrue(namedDataEntry.isDirectory());
    assertSame(parent, actualParent);
  }

  /**
   * Method under test:
   * {@link NamedDataEntry#NamedDataEntry(DataEntry, String, long, boolean)}
   */
  @Test
  public void testNewNamedDataEntry() {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");

    // Act
    NamedDataEntry actualNamedDataEntry = new NamedDataEntry(parent, "Name", 3L, true);

    // Assert
    assertEquals("Name", actualNamedDataEntry.getName());
    assertEquals("Name", actualNamedDataEntry.getOriginalName());
    assertEquals(3L, actualNamedDataEntry.getSize());
    assertTrue(actualNamedDataEntry.isDirectory());
    assertSame(parent, actualNamedDataEntry.getParent());
  }
}
