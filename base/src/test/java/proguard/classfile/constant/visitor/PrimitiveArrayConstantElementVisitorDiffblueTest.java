package proguard.classfile.constant.visitor;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.constant.PrimitiveArrayConstant;
import proguard.classfile.util.PrimitiveArrayConstantReplacer;

class PrimitiveArrayConstantElementVisitorDiffblueTest {
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
  @DisplayName(
      "Test visitAnyPrimitiveArrayConstantElement(Clazz, PrimitiveArrayConstant, int); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.visitor.PrimitiveArrayConstantElementVisitor.visitAnyPrimitiveArrayConstantElement(proguard.classfile.Clazz, proguard.classfile.constant.PrimitiveArrayConstant, int)"
  })
  void testVisitAnyPrimitiveArrayConstantElement_thenThrowUnsupportedOperationException() {
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
