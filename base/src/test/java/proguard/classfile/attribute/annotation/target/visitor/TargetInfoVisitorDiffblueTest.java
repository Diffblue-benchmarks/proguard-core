package proguard.classfile.attribute.annotation.target.visitor;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.attribute.annotation.TypeAnnotation;
import proguard.classfile.attribute.annotation.target.CatchTargetInfo;
import proguard.classfile.attribute.annotation.target.TargetInfo;
import proguard.classfile.visitor.ClassPrinter;

class TargetInfoVisitorDiffblueTest {
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
  @DisplayName(
      "Test visitAnyTargetInfo(Clazz, TypeAnnotation, TargetInfo); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TargetInfoVisitor.visitAnyTargetInfo(Clazz, TypeAnnotation, TargetInfo)"
  })
  void testVisitAnyTargetInfo_thenThrowUnsupportedOperationException() {
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
