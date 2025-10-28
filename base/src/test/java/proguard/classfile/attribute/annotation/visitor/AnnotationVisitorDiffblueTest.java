package proguard.classfile.attribute.annotation.visitor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;
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

public class AnnotationVisitorDiffblueTest {
  /**
   * Method under test:
   * {@link AnnotationVisitor#visitAnnotation(Clazz, Annotation)}
   */
  @Test
  public void testVisitAnnotation() {
    // Arrange
    AnnotationToAnnotatedMemberVisitor annotationToAnnotatedMemberVisitor = new AnnotationToAnnotatedMemberVisitor(
        new AttributeSorter());
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> annotationToAnnotatedMemberVisitor.visitAnnotation(clazz, new Annotation()));
  }

  /**
   * Method under test:
   * {@link AnnotationVisitor#visitAnnotation(Clazz, Member, Annotation)}
   */
  @Test
  public void testVisitAnnotation2() {
    // Arrange
    MultiAnnotationVisitor multiAnnotationVisitor = new MultiAnnotationVisitor(
        new AnnotationToAnnotatedMemberVisitor(new AttributeSorter()));
    LibraryClass clazz = new LibraryClass();
    LibraryField member = new LibraryField(1, "Name", "Descriptor");

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> multiAnnotationVisitor.visitAnnotation(clazz, (Member) member, new Annotation()));
  }

  /**
   * Method under test:
   * {@link AnnotationVisitor#visitAnnotation(Clazz, Field, Annotation)}
   */
  @Test
  public void testVisitAnnotation3() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    Annotation annotation = new Annotation();

    // Act
    constantPoolRemapper.visitAnnotation(clazz, (Field) field, annotation);

    // Assert
    assertEquals(1, annotation.u2typeIndex);
  }

  /**
   * Method under test:
   * {@link AnnotationVisitor#visitAnnotation(Clazz, Method, int, Annotation)}
   */
  @Test
  public void testVisitAnnotation4() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    Annotation annotation = new Annotation();

    // Act
    constantPoolRemapper.visitAnnotation(clazz, method, 1, annotation);

    // Assert
    assertEquals(1, annotation.u2typeIndex);
  }

  /**
   * Method under test:
   * {@link AnnotationVisitor#visitAnnotation(Clazz, Method, CodeAttribute, Annotation)}
   */
  @Test
  public void testVisitAnnotation5() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
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
   * Method under test:
   * {@link AnnotationVisitor#visitAnnotation(Clazz, Method, Annotation)}
   */
  @Test
  public void testVisitAnnotation6() {
    // Arrange
    ConstantPoolRemapper constantPoolRemapper = new ConstantPoolRemapper();
    constantPoolRemapper.setConstantIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    Annotation annotation = new Annotation();

    // Act
    constantPoolRemapper.visitAnnotation(clazz, (Method) method, annotation);

    // Assert
    assertEquals(1, annotation.u2typeIndex);
  }
}
