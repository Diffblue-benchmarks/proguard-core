package proguard.classfile.visitor;

import static org.junit.Assert.assertThrows;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;

public class MemberAccessFlagCleanerDiffblueTest {
  /**
   * Test {@link MemberAccessFlagCleaner#visitAnyClass(Clazz)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass#LibraryClass()}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link MemberAccessFlagCleaner#visitAnyClass(Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MemberAccessFlagCleaner.visitAnyClass(Clazz)"})
  public void testVisitAnyClass_whenLibraryClass_thenThrowUnsupportedOperationException() {
    // Arrange
    MemberAccessFlagCleaner memberAccessFlagCleaner = new MemberAccessFlagCleaner(1);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> memberAccessFlagCleaner.visitAnyClass(new LibraryClass()));
  }
}
