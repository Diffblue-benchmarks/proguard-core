package proguard.classfile.constant.visitor;

import static org.junit.Assert.assertThrows;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.constant.PrimitiveArrayConstant;
import proguard.classfile.util.PrimitiveArrayConstantReplacer;

public class PrimitiveArrayConstantElementVisitorDiffblueTest {
  /**
   * Test {@link PrimitiveArrayConstantElementVisitor#visitAnyPrimitiveArrayConstantElement(Clazz,
   * PrimitiveArrayConstant, int)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * PrimitiveArrayConstantElementVisitor#visitAnyPrimitiveArrayConstantElement(Clazz,
   * PrimitiveArrayConstant, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void PrimitiveArrayConstantElementVisitor.visitAnyPrimitiveArrayConstantElement(Clazz, PrimitiveArrayConstant, int)"
  })
  public void testVisitAnyPrimitiveArrayConstantElement_thenThrowUnsupportedOperationException() {
    // Arrange
    PrimitiveArrayConstantReplacer primitiveArrayConstantReplacer =
        new PrimitiveArrayConstantReplacer();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            primitiveArrayConstantReplacer.visitAnyPrimitiveArrayConstantElement(
                clazz, new PrimitiveArrayConstant("Values"), 1));
  }
}
