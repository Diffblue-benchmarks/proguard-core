package proguard.classfile.attribute.preverification.visitor;

import static org.junit.Assert.assertThrows;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.preverification.VerificationType;
import proguard.classfile.attribute.preverification.VerificationTypeFactory;
import proguard.classfile.visitor.ClassPrinter;

public class VerificationTypeVisitorDiffblueTest {
  /**
   * Method under test:
   * {@link VerificationTypeVisitor#visitAnyVerificationType(Clazz, Method, CodeAttribute, int, VerificationType)}
   */
  @Test
  public void testVisitAnyVerificationType() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> classPrinter.visitAnyVerificationType(clazz, method,
        codeAttribute, 2, VerificationTypeFactory.createDoubleType()));
  }
}
