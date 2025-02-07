package proguard.classfile.attribute.annotation.visitor;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.Field;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.annotation.Annotation;
import proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute;
import proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute;
import proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute;
import proguard.classfile.attribute.annotation.RuntimeVisibleTypeAnnotationsAttribute;
import proguard.classfile.attribute.annotation.TypeAnnotation;
import proguard.classfile.visitor.ClassVisitor;

class AllAnnotationVisitorDiffblueTest {
  /**
   * Test {@link AllAnnotationVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz, Field,
   * RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code field}, {@code
   * runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AllAnnotationVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz, Field,
   * RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, Field, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'field', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AllAnnotationVisitor.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleAnnotationsAttributeWithClazzFieldRuntimeVisibleAnnotationsAttribute() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    AllAnnotationVisitor allAnnotationVisitor =
        new AllAnnotationVisitor(new AnnotationToAnnotatedClassVisitor(classVisitor));
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act
    allAnnotationVisitor.visitRuntimeVisibleAnnotationsAttribute(
        clazz,
        (Field) field,
        new RuntimeVisibleAnnotationsAttribute(1, 1, new Annotation[] {new Annotation()}));

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link AllAnnotationVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleAnnotationsAttribute)} with {@code clazz}, {@code method}, {@code
   * runtimeVisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AllAnnotationVisitor#visitRuntimeVisibleAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleAnnotationsAttribute(Clazz, Method, RuntimeVisibleAnnotationsAttribute) with 'clazz', 'method', 'runtimeVisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AllAnnotationVisitor.visitRuntimeVisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeVisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleAnnotationsAttributeWithClazzMethodRuntimeVisibleAnnotationsAttribute() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    AllAnnotationVisitor allAnnotationVisitor =
        new AllAnnotationVisitor(new AnnotationToAnnotatedClassVisitor(classVisitor));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    allAnnotationVisitor.visitRuntimeVisibleAnnotationsAttribute(
        clazz,
        (Method) method,
        new RuntimeVisibleAnnotationsAttribute(1, 1, new Annotation[] {new Annotation()}));

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link AllAnnotationVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz, Field,
   * RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code field}, {@code
   * runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AllAnnotationVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz, Field,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, Field, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'field', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AllAnnotationVisitor.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzFieldRuntimeInvisibleAnnotationsAttribute() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    AllAnnotationVisitor allAnnotationVisitor =
        new AllAnnotationVisitor(new AnnotationToAnnotatedClassVisitor(classVisitor));
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act
    allAnnotationVisitor.visitRuntimeInvisibleAnnotationsAttribute(
        clazz,
        (Field) field,
        new RuntimeInvisibleAnnotationsAttribute(1, 1, new Annotation[] {new Annotation()}));

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link AllAnnotationVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleAnnotationsAttribute)} with {@code clazz}, {@code method}, {@code
   * runtimeInvisibleAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AllAnnotationVisitor#visitRuntimeInvisibleAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleAnnotationsAttribute(Clazz, Method, RuntimeInvisibleAnnotationsAttribute) with 'clazz', 'method', 'runtimeInvisibleAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AllAnnotationVisitor.visitRuntimeInvisibleAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeInvisibleAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleAnnotationsAttributeWithClazzMethodRuntimeInvisibleAnnotationsAttribute() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    AllAnnotationVisitor allAnnotationVisitor =
        new AllAnnotationVisitor(new AnnotationToAnnotatedClassVisitor(classVisitor));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    allAnnotationVisitor.visitRuntimeInvisibleAnnotationsAttribute(
        clazz,
        (Method) method,
        new RuntimeInvisibleAnnotationsAttribute(1, 1, new Annotation[] {new Annotation()}));

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link AllAnnotationVisitor#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Field,
   * RuntimeVisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code field}, {@code
   * runtimeVisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AllAnnotationVisitor#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Field,
   * RuntimeVisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Field, RuntimeVisibleTypeAnnotationsAttribute) with 'clazz', 'field', 'runtimeVisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AllAnnotationVisitor.visitRuntimeVisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.annotation.RuntimeVisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleTypeAnnotationsAttributeWithClazzFieldRuntimeVisibleTypeAnnotationsAttribute() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    AllAnnotationVisitor allAnnotationVisitor =
        new AllAnnotationVisitor(new AnnotationToAnnotatedClassVisitor(classVisitor));
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act
    allAnnotationVisitor.visitRuntimeVisibleTypeAnnotationsAttribute(
        clazz,
        (Field) field,
        new RuntimeVisibleTypeAnnotationsAttribute(
            1, 1, new TypeAnnotation[] {new TypeAnnotation()}));

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link AllAnnotationVisitor#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Method,
   * CodeAttribute, RuntimeVisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code method},
   * {@code codeAttribute}, {@code runtimeVisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AllAnnotationVisitor#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Method, CodeAttribute,
   * RuntimeVisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Method, CodeAttribute, RuntimeVisibleTypeAnnotationsAttribute) with 'clazz', 'method', 'codeAttribute', 'runtimeVisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AllAnnotationVisitor.visitRuntimeVisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.annotation.RuntimeVisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleTypeAnnotationsAttributeWithClazzMethodCodeAttributeRuntimeVisibleTypeAnnotationsAttribute() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    AllAnnotationVisitor allAnnotationVisitor =
        new AllAnnotationVisitor(new AnnotationToAnnotatedClassVisitor(classVisitor));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    allAnnotationVisitor.visitRuntimeVisibleTypeAnnotationsAttribute(
        clazz,
        method,
        codeAttribute,
        new RuntimeVisibleTypeAnnotationsAttribute(
            1, 1, new TypeAnnotation[] {new TypeAnnotation()}));

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link AllAnnotationVisitor#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code method}, {@code
   * runtimeVisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AllAnnotationVisitor#visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Method,
   * RuntimeVisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeVisibleTypeAnnotationsAttribute(Clazz, Method, RuntimeVisibleTypeAnnotationsAttribute) with 'clazz', 'method', 'runtimeVisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AllAnnotationVisitor.visitRuntimeVisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeVisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeVisibleTypeAnnotationsAttributeWithClazzMethodRuntimeVisibleTypeAnnotationsAttribute() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    AllAnnotationVisitor allAnnotationVisitor =
        new AllAnnotationVisitor(new AnnotationToAnnotatedClassVisitor(classVisitor));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    allAnnotationVisitor.visitRuntimeVisibleTypeAnnotationsAttribute(
        clazz,
        (Method) method,
        new RuntimeVisibleTypeAnnotationsAttribute(
            1, 1, new TypeAnnotation[] {new TypeAnnotation()}));

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link AllAnnotationVisitor#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Field,
   * RuntimeInvisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code field}, {@code
   * runtimeInvisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AllAnnotationVisitor#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Field,
   * RuntimeInvisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Field, RuntimeInvisibleTypeAnnotationsAttribute) with 'clazz', 'field', 'runtimeInvisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AllAnnotationVisitor.visitRuntimeInvisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleTypeAnnotationsAttributeWithClazzFieldRuntimeInvisibleTypeAnnotationsAttribute() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    AllAnnotationVisitor allAnnotationVisitor =
        new AllAnnotationVisitor(new AnnotationToAnnotatedClassVisitor(classVisitor));
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act
    allAnnotationVisitor.visitRuntimeInvisibleTypeAnnotationsAttribute(
        clazz,
        (Field) field,
        new RuntimeInvisibleTypeAnnotationsAttribute(
            1, 1, new TypeAnnotation[] {new TypeAnnotation()}));

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link AllAnnotationVisitor#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Method,
   * CodeAttribute, RuntimeInvisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code method},
   * {@code codeAttribute}, {@code runtimeInvisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AllAnnotationVisitor#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Method,
   * CodeAttribute, RuntimeInvisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Method, CodeAttribute, RuntimeInvisibleTypeAnnotationsAttribute) with 'clazz', 'method', 'codeAttribute', 'runtimeInvisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AllAnnotationVisitor.visitRuntimeInvisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleTypeAnnotationsAttributeWithClazzMethodCodeAttributeRuntimeInvisibleTypeAnnotationsAttribute() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    AllAnnotationVisitor allAnnotationVisitor =
        new AllAnnotationVisitor(new AnnotationToAnnotatedClassVisitor(classVisitor));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);

    // Act
    allAnnotationVisitor.visitRuntimeInvisibleTypeAnnotationsAttribute(
        clazz,
        method,
        codeAttribute,
        new RuntimeInvisibleTypeAnnotationsAttribute(
            1, 1, new TypeAnnotation[] {new TypeAnnotation()}));

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }

  /**
   * Test {@link AllAnnotationVisitor#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleTypeAnnotationsAttribute)} with {@code clazz}, {@code method}, {@code
   * runtimeInvisibleTypeAnnotationsAttribute}.
   *
   * <p>Method under test: {@link
   * AllAnnotationVisitor#visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Method,
   * RuntimeInvisibleTypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitRuntimeInvisibleTypeAnnotationsAttribute(Clazz, Method, RuntimeInvisibleTypeAnnotationsAttribute) with 'clazz', 'method', 'runtimeInvisibleTypeAnnotationsAttribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.visitor.AllAnnotationVisitor.visitRuntimeInvisibleTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.RuntimeInvisibleTypeAnnotationsAttribute)"
  })
  void
      testVisitRuntimeInvisibleTypeAnnotationsAttributeWithClazzMethodRuntimeInvisibleTypeAnnotationsAttribute() {
    // Arrange
    ClassVisitor classVisitor = mock(ClassVisitor.class);
    doNothing().when(classVisitor).visitLibraryClass(Mockito.<LibraryClass>any());
    AllAnnotationVisitor allAnnotationVisitor =
        new AllAnnotationVisitor(new AnnotationToAnnotatedClassVisitor(classVisitor));
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    allAnnotationVisitor.visitRuntimeInvisibleTypeAnnotationsAttribute(
        clazz,
        (Method) method,
        new RuntimeInvisibleTypeAnnotationsAttribute(
            1, 1, new TypeAnnotation[] {new TypeAnnotation()}));

    // Assert
    verify(classVisitor).visitLibraryClass(isA(LibraryClass.class));
  }
}
