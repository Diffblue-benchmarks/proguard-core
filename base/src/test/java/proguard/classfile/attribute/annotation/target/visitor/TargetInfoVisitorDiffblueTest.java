package proguard.classfile.attribute.annotation.target.visitor;

import static org.junit.Assert.assertThrows;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.attribute.annotation.TypeAnnotation;
import proguard.classfile.attribute.annotation.target.CatchTargetInfo;
import proguard.classfile.attribute.annotation.target.TargetInfo;
import proguard.classfile.visitor.ClassPrinter;

public class TargetInfoVisitorDiffblueTest {
  /**
   * Test {@link TargetInfoVisitor#visitAnyTargetInfo(Clazz, TypeAnnotation, TargetInfo)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link TargetInfoVisitor#visitAnyTargetInfo(Clazz, TypeAnnotation,
   * TargetInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void TargetInfoVisitor.visitAnyTargetInfo(Clazz, TypeAnnotation, TargetInfo)"
  })
  public void testVisitAnyTargetInfo_thenThrowUnsupportedOperationException() {
    // Arrange
    ClassPrinter classPrinter = new ClassPrinter();
    LibraryClass clazz = new LibraryClass();
    TypeAnnotation typeAnnotation = new TypeAnnotation();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            classPrinter.visitAnyTargetInfo(
                clazz, typeAnnotation, new CatchTargetInfo((byte) 'A')));
  }
}
