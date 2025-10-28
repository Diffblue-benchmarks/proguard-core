package proguard.io;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import java.io.IOException;
import org.junit.Test;

public class ClassPathDataEntryDiffblueTest {
  /**
   * Method under test: {@link ClassPathDataEntry#getInputStream()}
   */
  @Test
  public void testGetInputStream() throws IOException {
    // Arrange, Act and Assert
    assertNull((new ClassPathDataEntry("Name")).getInputStream());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ClassPathDataEntry#ClassPathDataEntry(String)}
   *   <li>{@link ClassPathDataEntry#toString()}
   *   <li>{@link ClassPathDataEntry#getName()}
   *   <li>{@link ClassPathDataEntry#getOriginalName()}
   *   <li>{@link ClassPathDataEntry#getParent()}
   *   <li>{@link ClassPathDataEntry#getSize()}
   *   <li>{@link ClassPathDataEntry#isDirectory()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ClassPathDataEntry actualClassPathDataEntry = new ClassPathDataEntry("Name");
    String actualToStringResult = actualClassPathDataEntry.toString();
    String actualName = actualClassPathDataEntry.getName();
    String actualOriginalName = actualClassPathDataEntry.getOriginalName();
    DataEntry actualParent = actualClassPathDataEntry.getParent();
    long actualSize = actualClassPathDataEntry.getSize();

    // Assert
    assertEquals("Name", actualName);
    assertEquals("Name", actualOriginalName);
    assertEquals("Name", actualToStringResult);
    assertNull(actualParent);
    assertEquals(-1L, actualSize);
    assertFalse(actualClassPathDataEntry.isDirectory());
  }

  /**
   * Method under test: {@link ClassPathDataEntry#ClassPathDataEntry(Class)}
   */
  @Test
  public void testNewClassPathDataEntry() throws IOException {
    // Arrange
    Class<Object> clazz = Object.class;

    // Act
    ClassPathDataEntry actualClassPathDataEntry = new ClassPathDataEntry(clazz);

    // Assert
    assertEquals("java/lang/Object.class", actualClassPathDataEntry.getName());
    assertEquals("java/lang/Object.class", actualClassPathDataEntry.getOriginalName());
    assertNull(actualClassPathDataEntry.getParent());
    assertEquals(-1L, actualClassPathDataEntry.getSize());
    byte[] byteArray = new byte[51];
    assertEquals(51, actualClassPathDataEntry.getInputStream().read(byteArray));
    assertFalse(actualClassPathDataEntry.isDirectory());
    assertArrayEquals(new byte[]{-54, -2, -70, -66, 0, 0, 0, '7', 0, '\\', 7, 0, '?', '\n', 0, 1, 0, '@', '\n', 0, 17,
        0, 'A', '\n', 0, 'B', 0, 'C', '\n', 0, 1, 0, 'D', '\b', 0, 'E', '\n', 0, 17, 0, 'F', '\n', 0, 'G', 0, 'H', '\n',
        0, 1, 0, 'I'}, byteArray);
  }
}
