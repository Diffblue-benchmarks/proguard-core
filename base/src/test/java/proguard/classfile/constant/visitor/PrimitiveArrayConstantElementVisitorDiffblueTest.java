package proguard.classfile.constant.visitor;

import static org.junit.Assert.assertThrows;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.constant.PrimitiveArrayConstant;
import proguard.classfile.util.PrimitiveArrayConstantReplacer;

public class PrimitiveArrayConstantElementVisitorDiffblueTest {
  /**
   * Method under test:
   * {@link PrimitiveArrayConstantElementVisitor#visitAnyPrimitiveArrayConstantElement(Clazz, PrimitiveArrayConstant, int)}
   */
  @Test
  public void testVisitAnyPrimitiveArrayConstantElement() {
    // Arrange
    PrimitiveArrayConstantReplacer primitiveArrayConstantReplacer = new PrimitiveArrayConstantReplacer();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> primitiveArrayConstantReplacer
        .visitAnyPrimitiveArrayConstantElement(clazz, new PrimitiveArrayConstant("Values"), 1));
  }
}
