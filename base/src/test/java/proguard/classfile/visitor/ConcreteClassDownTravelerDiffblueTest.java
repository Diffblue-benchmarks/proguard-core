package proguard.classfile.visitor;

import static org.junit.Assert.assertThrows;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.editor.AccessFixer;

public class ConcreteClassDownTravelerDiffblueTest {
  /**
   * Test {@link ConcreteClassDownTraveler#visitAnyClass(Clazz)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass#LibraryClass()}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ConcreteClassDownTraveler#visitAnyClass(Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConcreteClassDownTraveler.visitAnyClass(Clazz)"})
  public void testVisitAnyClass_whenLibraryClass_thenThrowUnsupportedOperationException() {
    // Arrange
    ConcreteClassDownTraveler concreteClassDownTraveler =
        new ConcreteClassDownTraveler(new AccessFixer());

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> concreteClassDownTraveler.visitAnyClass(new LibraryClass()));
  }
}
