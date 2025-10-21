package proguard.classfile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class LibraryMethodDiffblueTest {
  /**
   * Test {@link LibraryMethod#LibraryMethod()}.
   *
   * <ul>
   *   <li>Then return AccessFlags is zero.
   * </ul>
   *
   * <p>Method under test: {@link LibraryMethod#LibraryMethod()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void LibraryMethod.<init>()",
    "void LibraryMethod.<init>(int, String, String)"
  })
  public void testNewLibraryMethod_thenReturnAccessFlagsIsZero() {
    // Arrange and Act
    LibraryMethod actualLibraryMethod = new LibraryMethod();

    // Assert
    assertNull(actualLibraryMethod.getProcessingInfo());
    assertEquals(0, actualLibraryMethod.getAccessFlags());
    assertEquals(0, actualLibraryMethod.getProcessingFlags());
  }

  /**
   * Test {@link LibraryMethod#LibraryMethod(int, String, String)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return AccessFlags is one.
   * </ul>
   *
   * <p>Method under test: {@link LibraryMethod#LibraryMethod(int, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void LibraryMethod.<init>()",
    "void LibraryMethod.<init>(int, String, String)"
  })
  public void testNewLibraryMethod_whenOne_thenReturnAccessFlagsIsOne() {
    // Arrange and Act
    LibraryMethod actualLibraryMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Assert
    assertNull(actualLibraryMethod.getProcessingInfo());
    assertEquals(0, actualLibraryMethod.getProcessingFlags());
    assertEquals(1, actualLibraryMethod.getAccessFlags());
  }
}
