package proguard.classfile.attribute.annotation.target.visitor;

import static org.junit.Assert.assertThrows;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.attribute.annotation.TypeAnnotation;
import proguard.classfile.attribute.annotation.target.CatchTargetInfo;
import proguard.classfile.attribute.annotation.target.TargetInfo;
import proguard.classfile.visitor.ClassPrinter;

public class TargetInfoVisitorDiffblueTest {
  /**
   * Method under test:
   * {@link TargetInfoVisitor#visitAnyTargetInfo(Clazz, TypeAnnotation, TargetInfo)}
   */
  @Test
  public void testVisitAnyTargetInfo() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    TypeAnnotation typeAnnotation = new TypeAnnotation();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> classPrinter.visitAnyTargetInfo(clazz, typeAnnotation, new CatchTargetInfo((byte) 'A')));
  }
}
