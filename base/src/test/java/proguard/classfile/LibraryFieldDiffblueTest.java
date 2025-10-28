package proguard.classfile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class LibraryFieldDiffblueTest {
  /**
   * Method under test: {@link LibraryField#LibraryField()}
   */
  @Test
  public void testNewLibraryField() {
    // Arrange and Act
    LibraryField actualLibraryField = new LibraryField();

    // Assert
    assertNull(actualLibraryField.getProcessingInfo());
    assertEquals(0, actualLibraryField.getAccessFlags());
    assertEquals(0, actualLibraryField.getProcessingFlags());
  }

  /**
   * Method under test: {@link LibraryField#LibraryField(int, String, String)}
   */
  @Test
  public void testNewLibraryField2() {
    // Arrange and Act
    LibraryField actualLibraryField = new LibraryField(1, "Name", "Descriptor");

    // Assert
    assertNull(actualLibraryField.getProcessingInfo());
    assertEquals(0, actualLibraryField.getProcessingFlags());
    assertEquals(1, actualLibraryField.getAccessFlags());
  }
}
