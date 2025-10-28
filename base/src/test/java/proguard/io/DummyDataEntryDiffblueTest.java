package proguard.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import org.junit.Test;

public class DummyDataEntryDiffblueTest {
  /**
   * Method under test: {@link DummyDataEntry#getOriginalName()}
   */
  @Test
  public void testGetOriginalName() {
    // Arrange, Act and Assert
    assertEquals("Name", (new DummyDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true)).getOriginalName());
  }

  /**
   * Method under test: {@link DummyDataEntry#getInputStream()}
   */
  @Test
  public void testGetInputStream() throws IOException {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new DummyDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true)).getInputStream());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DummyDataEntry#closeInputStream()}
   *   <li>{@link DummyDataEntry#toString()}
   *   <li>{@link DummyDataEntry#getName()}
   *   <li>{@link DummyDataEntry#getParent()}
   *   <li>{@link DummyDataEntry#getSize()}
   *   <li>{@link DummyDataEntry#isDirectory()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() throws IOException {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");
    DummyDataEntry dummyDataEntry = new DummyDataEntry(parent, "Name", 3L, true);

    // Act
    dummyDataEntry.closeInputStream();
    String actualToStringResult = dummyDataEntry.toString();
    String actualName = dummyDataEntry.getName();
    DataEntry actualParent = dummyDataEntry.getParent();
    long actualSize = dummyDataEntry.getSize();

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals("Name:Name", actualToStringResult);
    assertEquals(3L, actualSize);
    assertTrue(dummyDataEntry.isDirectory());
    assertSame(parent, actualParent);
  }

  /**
   * Method under test:
   * {@link DummyDataEntry#DummyDataEntry(DataEntry, String, long, boolean)}
   */
  @Test
  public void testNewDummyDataEntry() {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");

    // Act
    DummyDataEntry actualDummyDataEntry = new DummyDataEntry(parent, "Name", 3L, true);

    // Assert
    assertEquals("Name", actualDummyDataEntry.getName());
    assertEquals("Name", actualDummyDataEntry.getOriginalName());
    assertEquals(3L, actualDummyDataEntry.getSize());
    assertTrue(actualDummyDataEntry.isDirectory());
    assertSame(parent, actualDummyDataEntry.getParent());
  }
}
