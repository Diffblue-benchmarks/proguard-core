package proguard.classfile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class LibraryMethodDiffblueTest {
  /**
   * Method under test: {@link LibraryMethod#LibraryMethod()}
   */
  @Test
  public void testNewLibraryMethod() {
    // Arrange and Act
    LibraryMethod actualLibraryMethod = new LibraryMethod();

    // Assert
    assertNull(actualLibraryMethod.getProcessingInfo());
    assertEquals(0, actualLibraryMethod.getAccessFlags());
    assertEquals(0, actualLibraryMethod.getProcessingFlags());
  }

  /**
   * Method under test: {@link LibraryMethod#LibraryMethod(int, String, String)}
   */
  @Test
  public void testNewLibraryMethod2() {
    // Arrange and Act
    LibraryMethod actualLibraryMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Assert
    assertNull(actualLibraryMethod.getProcessingInfo());
    assertEquals(0, actualLibraryMethod.getProcessingFlags());
    assertEquals(1, actualLibraryMethod.getAccessFlags());
  }
}
