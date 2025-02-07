package proguard.classfile.attribute.annotation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import com.guardsquare.proguard.assembler.AnnotationsParser;
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
import proguard.classfile.attribute.annotation.target.CatchTargetInfo;
import proguard.classfile.attribute.annotation.target.TargetInfo;
import proguard.classfile.attribute.annotation.visitor.TypePathInfoVisitor;

class TypeAnnotationDiffblueTest {
  /**
   * Test {@link TypeAnnotation#TypeAnnotation()}.
   *
   * <p>Method under test: {@link TypeAnnotation#TypeAnnotation()}
   */
  @Test
  @DisplayName("Test new TypeAnnotation()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.TypeAnnotation.<init>()",
    "void proguard.classfile.attribute.annotation.TypeAnnotation.<init>(int, int, proguard.classfile.attribute.annotation.ElementValue[], proguard.classfile.attribute.annotation.target.TargetInfo, proguard.classfile.attribute.annotation.TypePathInfo[])"
  })
  void testNewTypeAnnotation() {
    // Arrange and Act
    TypeAnnotation actualTypeAnnotation = new TypeAnnotation();

    // Assert
    assertNull(actualTypeAnnotation.getProcessingInfo());
    assertEquals(0, actualTypeAnnotation.getProcessingFlags());
  }

  /**
   * Test {@link TypeAnnotation#TypeAnnotation(int, int, ElementValue[], TargetInfo,
   * TypePathInfo[])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link TypeAnnotation#TypeAnnotation(int, int, ElementValue[],
   * TargetInfo, TypePathInfo[])}
   */
  @Test
  @DisplayName(
      "Test new TypeAnnotation(int, int, ElementValue[], TargetInfo, TypePathInfo[]); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.TypeAnnotation.<init>()",
    "void proguard.classfile.attribute.annotation.TypeAnnotation.<init>(int, int, proguard.classfile.attribute.annotation.ElementValue[], proguard.classfile.attribute.annotation.target.TargetInfo, proguard.classfile.attribute.annotation.TypePathInfo[])"
  })
  void testNewTypeAnnotation_whenOne() {
    // Arrange
    CatchTargetInfo targetInfo = new CatchTargetInfo((byte) 'A');

    // Act
    TypeAnnotation actualTypeAnnotation =
        new TypeAnnotation(
            1,
            3,
            new ElementValue[] {new AnnotationElementValue()},
            targetInfo,
            new TypePathInfo[] {new TypePathInfo(1, 1)});

    // Assert
    assertNull(actualTypeAnnotation.getProcessingInfo());
    assertEquals(0, actualTypeAnnotation.getProcessingFlags());
  }

  /**
   * Test {@link TypeAnnotation#typePathInfosAccept(Clazz, Field, TypePathInfoVisitor)} with {@code
   * clazz}, {@code field}, {@code typePathVisitor}.
   *
   * <ul>
   *   <li>Then calls {@link TypePathInfoVisitor#visitTypePathInfo(Clazz, Field, TypeAnnotation,
   *       TypePathInfo)}.
   * </ul>
   *
   * <p>Method under test: {@link TypeAnnotation#typePathInfosAccept(Clazz, Field,
   * TypePathInfoVisitor)}
   */
  @Test
  @DisplayName(
      "Test typePathInfosAccept(Clazz, Field, TypePathInfoVisitor) with 'clazz', 'field', 'typePathVisitor'; then calls visitTypePathInfo(Clazz, Field, TypeAnnotation, TypePathInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.TypeAnnotation.typePathInfosAccept(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.annotation.visitor.TypePathInfoVisitor)"
  })
  void testTypePathInfosAcceptWithClazzFieldTypePathVisitor_thenCallsVisitTypePathInfo() {
    // Arrange
    CatchTargetInfo targetInfo = new CatchTargetInfo((byte) 'A');
    TypeAnnotation typeAnnotation =
        new TypeAnnotation(
            1,
            3,
            new ElementValue[] {new AnnotationElementValue()},
            targetInfo,
            new TypePathInfo[] {new TypePathInfo(1, 1)});
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    AnnotationsParser typePathVisitor = mock(AnnotationsParser.class);
    doNothing()
        .when(typePathVisitor)
        .visitTypePathInfo(
            Mockito.<Clazz>any(),
            Mockito.<Field>any(),
            Mockito.<TypeAnnotation>any(),
            Mockito.<TypePathInfo>any());

    // Act
    typeAnnotation.typePathInfosAccept(clazz, field, typePathVisitor);

    // Assert
    verify(typePathVisitor)
        .visitTypePathInfo(
            isA(Clazz.class), isA(Field.class), isA(TypeAnnotation.class), isA(TypePathInfo.class));
  }

  /**
   * Test {@link TypeAnnotation#typePathInfosAccept(Clazz, Method, CodeAttribute, TypeAnnotation,
   * TypePathInfoVisitor)} with {@code clazz}, {@code method}, {@code codeAttribute}, {@code
   * typeAnnotation}, {@code typePathVisitor}.
   *
   * <p>Method under test: {@link TypeAnnotation#typePathInfosAccept(Clazz, Method, CodeAttribute,
   * TypeAnnotation, TypePathInfoVisitor)}
   */
  @Test
  @DisplayName(
      "Test typePathInfosAccept(Clazz, Method, CodeAttribute, TypeAnnotation, TypePathInfoVisitor) with 'clazz', 'method', 'codeAttribute', 'typeAnnotation', 'typePathVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.TypeAnnotation.typePathInfosAccept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.annotation.TypeAnnotation, proguard.classfile.attribute.annotation.visitor.TypePathInfoVisitor)"
  })
  void testTypePathInfosAcceptWithClazzMethodCodeAttributeTypeAnnotationTypePathVisitor() {
    // Arrange
    CatchTargetInfo targetInfo = new CatchTargetInfo((byte) 'A');
    TypeAnnotation typeAnnotation =
        new TypeAnnotation(
            1,
            3,
            new ElementValue[] {new AnnotationElementValue()},
            targetInfo,
            new TypePathInfo[] {new TypePathInfo(1, 1)});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    TypeAnnotation typeAnnotation2 = new TypeAnnotation();
    AnnotationsParser typePathVisitor = mock(AnnotationsParser.class);
    doNothing()
        .when(typePathVisitor)
        .visitTypePathInfo(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<TypeAnnotation>any(),
            Mockito.<TypePathInfo>any());

    // Act
    typeAnnotation.typePathInfosAccept(
        clazz, method, codeAttribute, typeAnnotation2, typePathVisitor);

    // Assert
    verify(typePathVisitor)
        .visitTypePathInfo(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(TypeAnnotation.class),
            isA(TypePathInfo.class));
  }

  /**
   * Test {@link TypeAnnotation#typePathInfosAccept(Clazz, Method, TypePathInfoVisitor)} with {@code
   * clazz}, {@code method}, {@code typePathVisitor}.
   *
   * <ul>
   *   <li>Then calls {@link TypePathInfoVisitor#visitTypePathInfo(Clazz, Method, TypeAnnotation,
   *       TypePathInfo)}.
   * </ul>
   *
   * <p>Method under test: {@link TypeAnnotation#typePathInfosAccept(Clazz, Method,
   * TypePathInfoVisitor)}
   */
  @Test
  @DisplayName(
      "Test typePathInfosAccept(Clazz, Method, TypePathInfoVisitor) with 'clazz', 'method', 'typePathVisitor'; then calls visitTypePathInfo(Clazz, Method, TypeAnnotation, TypePathInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.TypeAnnotation.typePathInfosAccept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.visitor.TypePathInfoVisitor)"
  })
  void testTypePathInfosAcceptWithClazzMethodTypePathVisitor_thenCallsVisitTypePathInfo() {
    // Arrange
    CatchTargetInfo targetInfo = new CatchTargetInfo((byte) 'A');
    TypeAnnotation typeAnnotation =
        new TypeAnnotation(
            1,
            3,
            new ElementValue[] {new AnnotationElementValue()},
            targetInfo,
            new TypePathInfo[] {new TypePathInfo(1, 1)});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    AnnotationsParser typePathVisitor = mock(AnnotationsParser.class);
    doNothing()
        .when(typePathVisitor)
        .visitTypePathInfo(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<TypeAnnotation>any(),
            Mockito.<TypePathInfo>any());

    // Act
    typeAnnotation.typePathInfosAccept(clazz, method, typePathVisitor);

    // Assert
    verify(typePathVisitor)
        .visitTypePathInfo(
            isA(Clazz.class),
            isA(Method.class),
            isA(TypeAnnotation.class),
            isA(TypePathInfo.class));
  }
}
