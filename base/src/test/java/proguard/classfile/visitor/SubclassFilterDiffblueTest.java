package proguard.classfile.visitor;

import static org.junit.Assert.assertThrows;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.editor.AccessFixer;

public class SubclassFilterDiffblueTest {
  /**
   * Test {@link SubclassFilter#visitAnyClass(Clazz)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass#LibraryClass()}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link SubclassFilter#visitAnyClass(Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SubclassFilter.visitAnyClass(Clazz)"})
  public void testVisitAnyClass_whenLibraryClass_thenThrowUnsupportedOperationException() {
    // Arrange
    LibraryClass subclass = new LibraryClass();
    SubclassFilter subclassFilter = new SubclassFilter(subclass, new AccessFixer());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> subclassFilter.visitAnyClass(new LibraryClass()));
  }
}
