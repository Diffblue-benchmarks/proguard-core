package proguard.classfile.attribute.annotation.visitor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.Field;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Member;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.annotation.Annotation;
import proguard.classfile.editor.AttributeSorter;
import proguard.classfile.editor.ConstantPoolRemapper;

class AnnotationVisitorDiffblueTest {
  /**
   * Test {@link AnnotationVisitor#visitAnnotation(Clazz, Annotation)} with {@code clazz}, {@code
   * annotation}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationVisitor#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Annotation) with 'clazz', 'annotation'; then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AnnotationVisitor.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzAnnotation_thenThrowUnsupportedOperationException() {
    // Arrange
    AnnotationToAnnotatedMemberVisitor annotationToAnnotatedMemberVisitor =
        new AnnotationToAnnotatedMemberVisitor(new AttributeSorter());
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> annotationToAnnotatedMemberVisitor.visitAnnotation(clazz, new Annotation()));
  }

  /**
   * Test {@link AnnotationVisitor#visitAnnotation(Clazz, Field, Annotation)} with {@code clazz},
   * {@code field}, {@code annotation}.
   *
   * <ul>
   *   <li>Then {@link Annotation#Annotation()} {@link Annotation#u2typeIndex} is one.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationVisitor#visitAnnotation(Clazz, Field, Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Field, Annotation) with 'clazz', 'field', 'annotation'; then Annotation() u2typeIndex is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AnnotationVisitor.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzFieldAnnotation_thenAnnotationU2typeIndexIsOne() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    Annotation annotation = new Annotation();

    // Act
    constantPoolRemapper.visitAnnotation(clazz, (Field) field, annotation);

    // Assert
    assertEquals(1, annotation.u2typeIndex);
  }

  /**
   * Test {@link AnnotationVisitor#visitAnnotation(Clazz, Member, Annotation)} with {@code clazz},
   * {@code member}, {@code annotation}.
   *
   * <p>Method under test: {@link AnnotationVisitor#visitAnnotation(Clazz, Member, Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Member, Annotation) with 'clazz', 'member', 'annotation'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AnnotationVisitor.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.Member, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzMemberAnnotation() {
    // Arrange
    MultiAnnotationVisitor multiAnnotationVisitor =
        new MultiAnnotationVisitor(new AnnotationToAnnotatedMemberVisitor(new AttributeSorter()));
    LibraryClass clazz = new LibraryClass();
    LibraryField member = new LibraryField(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> multiAnnotationVisitor.visitAnnotation(clazz, (Member) member, new Annotation()));
  }

  /**
   * Test {@link AnnotationVisitor#visitAnnotation(Clazz, Method, Annotation)} with {@code clazz},
   * {@code method}, {@code annotation}.
   *
   * <ul>
   *   <li>Then {@link Annotation#Annotation()} {@link Annotation#u2typeIndex} is one.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationVisitor#visitAnnotation(Clazz, Method, Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Method, Annotation) with 'clazz', 'method', 'annotation'; then Annotation() u2typeIndex is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AnnotationVisitor.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzMethodAnnotation_thenAnnotationU2typeIndexIsOne() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    Annotation annotation = new Annotation();

    // Act
    constantPoolRemapper.visitAnnotation(clazz, (Method) method, annotation);

    // Assert
    assertEquals(1, annotation.u2typeIndex);
  }

  /**
   * Test {@link AnnotationVisitor#visitAnnotation(Clazz, Method, CodeAttribute, Annotation)} with
   * {@code clazz}, {@code method}, {@code codeAttribute}, {@code annotation}.
   *
   * <p>Method under test: {@link AnnotationVisitor#visitAnnotation(Clazz, Method, CodeAttribute,
   * Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Method, CodeAttribute, Annotation) with 'clazz', 'method', 'codeAttribute', 'annotation'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AnnotationVisitor.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzMethodCodeAttributeAnnotation() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    Annotation annotation = new Annotation();

    // Act
    constantPoolRemapper.visitAnnotation(clazz, method, codeAttribute, annotation);

    // Assert
    assertEquals(1, annotation.u2typeIndex);
  }

  /**
   * Test {@link AnnotationVisitor#visitAnnotation(Clazz, Method, int, Annotation)} with {@code
   * clazz}, {@code method}, {@code parameterIndex}, {@code annotation}.
   *
   * <p>Method under test: {@link AnnotationVisitor#visitAnnotation(Clazz, Method, int, Annotation)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(Clazz, Method, int, Annotation) with 'clazz', 'method', 'parameterIndex', 'annotation'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AnnotationVisitor.visitAnnotation(proguard.classfile.Clazz, proguard.classfile.Method, int, proguard.classfile.attribute.annotation.Annotation)"
  })
  void testVisitAnnotationWithClazzMethodParameterIndexAnnotation() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    Annotation annotation = new Annotation();

    // Act
    constantPoolRemapper.visitAnnotation(clazz, method, 1, annotation);

    // Assert
    assertEquals(1, annotation.u2typeIndex);
  }
}
