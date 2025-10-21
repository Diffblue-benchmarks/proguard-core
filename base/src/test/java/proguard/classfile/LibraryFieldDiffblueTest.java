package proguard.classfile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class LibraryFieldDiffblueTest {
  /**
   * Test {@link LibraryField#LibraryField()}.
   *
   * <ul>
   *   <li>Then return AccessFlags is zero.
   * </ul>
   *
   * <p>Method under test: {@link LibraryField#LibraryField()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LibraryField.<init>()", "void LibraryField.<init>(int, String, String)"})
  public void testNewLibraryField_thenReturnAccessFlagsIsZero() {
    // Arrange and Act
    LibraryField actualLibraryField = new LibraryField();

    // Assert
    assertNull(actualLibraryField.getProcessingInfo());
    assertEquals(0, actualLibraryField.getAccessFlags());
    assertEquals(0, actualLibraryField.getProcessingFlags());
  }

  /**
   * Test {@link LibraryField#LibraryField(int, String, String)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return AccessFlags is one.
   * </ul>
   *
   * <p>Method under test: {@link LibraryField#LibraryField(int, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LibraryField.<init>()", "void LibraryField.<init>(int, String, String)"})
  public void testNewLibraryField_whenOne_thenReturnAccessFlagsIsOne() {
    // Arrange and Act
    LibraryField actualLibraryField = new LibraryField(1, "Name", "Descriptor");

    // Assert
    assertNull(actualLibraryField.getProcessingInfo());
    assertEquals(0, actualLibraryField.getProcessingFlags());
    assertEquals(1, actualLibraryField.getAccessFlags());
  }
}
