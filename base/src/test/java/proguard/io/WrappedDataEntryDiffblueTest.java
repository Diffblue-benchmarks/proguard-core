package proguard.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import org.junit.Test;

public class WrappedDataEntryDiffblueTest {
  /**
   * Method under test: {@link WrappedDataEntry#getName()}
   */
  @Test
  public void testGetName() {
    // Arrange, Act and Assert
    assertEquals("Name", (new WrappedDataEntry(new ClassPathDataEntry("Name"))).getName());
    assertEquals("Name", (new WrappedDataEntry(new WrappedDataEntry(new ClassPathDataEntry("Name")))).getName());
  }

  /**
   * Method under test: {@link WrappedDataEntry#getOriginalName()}
   */
  @Test
  public void testGetOriginalName() {
    // Arrange, Act and Assert
    assertEquals("Name", (new WrappedDataEntry(new ClassPathDataEntry("Name"))).getOriginalName());
    assertEquals("Name",
        (new WrappedDataEntry(new RenamedDataEntry(new ClassPathDataEntry("Name"), "Name"))).getOriginalName());
  }

  /**
   * Method under test: {@link WrappedDataEntry#getSize()}
   */
  @Test
  public void testGetSize() {
    // Arrange, Act and Assert
    assertEquals(-1L, (new WrappedDataEntry(new ClassPathDataEntry("Name"))).getSize());
    assertEquals(-1L, (new WrappedDataEntry(new RenamedDataEntry(new ClassPathDataEntry("Name"), "Name"))).getSize());
  }

  /**
   * Method under test: {@link WrappedDataEntry#isDirectory()}
   */
  @Test
  public void testIsDirectory() {
    // Arrange, Act and Assert
    assertFalse((new WrappedDataEntry(new ClassPathDataEntry("Name"))).isDirectory());
    assertTrue(
        (new WrappedDataEntry(new DummyDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true))).isDirectory());
    assertFalse((new WrappedDataEntry(new RenamedDataEntry(new ClassPathDataEntry("Name"), "Name"))).isDirectory());
  }

  /**
   * Method under test: {@link WrappedDataEntry#getInputStream()}
   */
  @Test
  public void testGetInputStream() throws IOException {
    // Arrange, Act and Assert
    assertNull((new WrappedDataEntry(new ClassPathDataEntry("Name"))).getInputStream());
    assertNull((new WrappedDataEntry(new RenamedDataEntry(new ClassPathDataEntry("Name"), "Name"))).getInputStream());
  }

  /**
   * Method under test: {@link WrappedDataEntry#getParent()}
   */
  @Test
  public void testGetParent() {
    // Arrange, Act and Assert
    assertNull((new WrappedDataEntry(new ClassPathDataEntry("Name"))).getParent());
    assertNull((new WrappedDataEntry(new RenamedDataEntry(new ClassPathDataEntry("Name"), "Name"))).getParent());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WrappedDataEntry#WrappedDataEntry(DataEntry)}
   *   <li>{@link WrappedDataEntry#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Name", (new WrappedDataEntry(new ClassPathDataEntry("Name"))).toString());
  }
}
