package proguard.classfile.attribute.preverification.visitor;

import static org.junit.Assert.assertThrows;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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
   * Test {@link VerificationTypeVisitor#visitAnyVerificationType(Clazz, Method, CodeAttribute, int,
   * VerificationType)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link VerificationTypeVisitor#visitAnyVerificationType(Clazz, Method,
   * CodeAttribute, int, VerificationType)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void VerificationTypeVisitor.visitAnyVerificationType(Clazz, Method, CodeAttribute, int, VerificationType)"
  })
  public void testVisitAnyVerificationType_thenThrowUnsupportedOperationException() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            classPrinter.visitAnyVerificationType(
                clazz, method, codeAttribute, 2, VerificationTypeFactory.createDoubleType()));
  }
}
