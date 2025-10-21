package proguard.classfile.editor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;

public class SubclassAdderDiffblueTest {
  /**
   * Test {@link SubclassAdder#visitAnyClass(Clazz)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass#LibraryClass()}.
   *   <li>Then array length is one.
   * </ul>
   *
   * <p>Method under test: {@link SubclassAdder#visitAnyClass(Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SubclassAdder.visitAnyClass(Clazz)"})
  public void testVisitAnyClass_whenLibraryClass_thenArrayLengthIsOne() {
    // Arrange
    LibraryClass subclass = new LibraryClass();
    SubclassAdder subclassAdder = new SubclassAdder(subclass);
    LibraryClass clazz = new LibraryClass();

    // Act
    subclassAdder.visitAnyClass(clazz);

    // Assert
    Clazz[] clazzArray = clazz.subClasses;
    assertEquals(1, clazzArray.length);
    assertEquals(1, clazz.subClassCount);
    assertSame(subclass, clazzArray[0]);
  }
}
