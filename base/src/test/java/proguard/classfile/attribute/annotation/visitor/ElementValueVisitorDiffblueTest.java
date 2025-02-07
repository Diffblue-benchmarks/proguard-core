package proguard.classfile.attribute.annotation.visitor;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.attribute.annotation.Annotation;
import proguard.classfile.attribute.annotation.AnnotationElementValue;
import proguard.classfile.attribute.annotation.ElementValue;
import proguard.classfile.editor.ConstantPoolRemapper;

class ElementValueVisitorDiffblueTest {
  /**
   * Test {@link ElementValueVisitor#visitAnyElementValue(Clazz, Annotation, ElementValue)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ElementValueVisitor#visitAnyElementValue(Clazz, Annotation,
   * ElementValue)}
   */
  @Test
  @DisplayName(
      "Test visitAnyElementValue(Clazz, Annotation, ElementValue); then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.ElementValueVisitor.visitAnyElementValue(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation, proguard.classfile.attribute.annotation.ElementValue)"
  })
  void testVisitAnyElementValue_thenThrowUnsupportedOperationException() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    LibraryClass clazz = new LibraryClass();
    Annotation annotation = new Annotation();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            constantPoolRemapper.visitAnyElementValue(
                clazz, annotation, new AnnotationElementValue()));
  }
}
