package proguard.classfile.visitor;

import static org.junit.Assert.assertThrows;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.editor.AccessFixer;

public class BottomClassFilterDiffblueTest {
  /**
   * Test {@link BottomClassFilter#visitAnyClass(Clazz)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass#LibraryClass()}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link BottomClassFilter#visitAnyClass(Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BottomClassFilter.visitAnyClass(Clazz)"})
  public void testVisitAnyClass_whenLibraryClass_thenThrowUnsupportedOperationException() {
    // Arrange
    AccessFixer bottomClassVisitor = new AccessFixer();
    BottomClassFilter bottomClassFilter =
        new BottomClassFilter(bottomClassVisitor, new AccessFixer());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> bottomClassFilter.visitAnyClass(new LibraryClass()));
  }
}
