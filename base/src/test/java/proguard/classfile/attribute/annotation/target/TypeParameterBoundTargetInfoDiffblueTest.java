package proguard.classfile.attribute.annotation.target;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import proguard.classfile.attribute.annotation.TypeAnnotation;
import proguard.classfile.attribute.annotation.target.visitor.TargetInfoVisitor;

class TypeParameterBoundTargetInfoDiffblueTest {
  /**
   * Test {@link TypeParameterBoundTargetInfo#TypeParameterBoundTargetInfo()}.
   *
   * <p>Method under test: {@link TypeParameterBoundTargetInfo#TypeParameterBoundTargetInfo()}
   */
  @Test
  @DisplayName("Test new TypeParameterBoundTargetInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.target.TypeParameterBoundTargetInfo.<init>()",
    "void proguard.classfile.attribute.annotation.target.TypeParameterBoundTargetInfo.<init>(byte)",
    "void proguard.classfile.attribute.annotation.target.TypeParameterBoundTargetInfo.<init>(byte, int, int)"
  })
  void testNewTypeParameterBoundTargetInfo() {
    // Arrange, Act and Assert
    assertEquals(
        TargetInfo.TARGET_TYPE_PARAMETER_GENERIC_CLASS,
        (new TypeParameterBoundTargetInfo()).getTargetType());
  }

  /**
   * Test {@link TypeParameterBoundTargetInfo#TypeParameterBoundTargetInfo(byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return TargetType is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link TypeParameterBoundTargetInfo#TypeParameterBoundTargetInfo(byte)}
   */
  @Test
  @DisplayName(
      "Test new TypeParameterBoundTargetInfo(byte); when 'A'; then return TargetType is 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.target.TypeParameterBoundTargetInfo.<init>()",
    "void proguard.classfile.attribute.annotation.target.TypeParameterBoundTargetInfo.<init>(byte)",
    "void proguard.classfile.attribute.annotation.target.TypeParameterBoundTargetInfo.<init>(byte, int, int)"
  })
  void testNewTypeParameterBoundTargetInfo_whenA_thenReturnTargetTypeIsA() {
    // Arrange, Act and Assert
    assertEquals('A', (new TypeParameterBoundTargetInfo((byte) 'A')).getTargetType());
  }

  /**
   * Test {@link TypeParameterBoundTargetInfo#TypeParameterBoundTargetInfo(byte, int, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return TargetType is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link TypeParameterBoundTargetInfo#TypeParameterBoundTargetInfo(byte,
   * int, int)}
   */
  @Test
  @DisplayName(
      "Test new TypeParameterBoundTargetInfo(byte, int, int); when one; then return TargetType is 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.target.TypeParameterBoundTargetInfo.<init>()",
    "void proguard.classfile.attribute.annotation.target.TypeParameterBoundTargetInfo.<init>(byte)",
    "void proguard.classfile.attribute.annotation.target.TypeParameterBoundTargetInfo.<init>(byte, int, int)"
  })
  void testNewTypeParameterBoundTargetInfo_whenOne_thenReturnTargetTypeIsA() {
    // Arrange, Act and Assert
    assertEquals('A', (new TypeParameterBoundTargetInfo((byte) 'A', 1, 1)).getTargetType());
  }

  /**
   * Test {@link TypeParameterBoundTargetInfo#accept(Clazz, Field, TypeAnnotation,
   * TargetInfoVisitor)} with {@code clazz}, {@code field}, {@code typeAnnotation}, {@code
   * targetInfoVisitor}.
   *
   * <p>Method under test: {@link TypeParameterBoundTargetInfo#accept(Clazz, Field, TypeAnnotation,
   * TargetInfoVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Field, TypeAnnotation, TargetInfoVisitor) with 'clazz', 'field', 'typeAnnotation', 'targetInfoVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.target.TypeParameterBoundTargetInfo.accept(proguard.classfile.Clazz, proguard.classfile.Field, proguard.classfile.attribute.annotation.TypeAnnotation, proguard.classfile.attribute.annotation.target.visitor.TargetInfoVisitor)"
  })
  void testAcceptWithClazzFieldTypeAnnotationTargetInfoVisitor() {
    // Arrange
    TypeParameterBoundTargetInfo typeParameterBoundTargetInfo =
        new TypeParameterBoundTargetInfo((byte) 'A');
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    TypeAnnotation typeAnnotation = new TypeAnnotation();
    AnnotationsParser targetInfoVisitor = mock(AnnotationsParser.class);
    doNothing()
        .when(targetInfoVisitor)
        .visitTypeParameterBoundTargetInfo(
            Mockito.<Clazz>any(),
            Mockito.<Field>any(),
            Mockito.<TypeAnnotation>any(),
            Mockito.<TypeParameterBoundTargetInfo>any());

    // Act
    typeParameterBoundTargetInfo.accept(clazz, field, typeAnnotation, targetInfoVisitor);

    // Assert
    verify(targetInfoVisitor)
        .visitTypeParameterBoundTargetInfo(
            isA(Clazz.class),
            isA(Field.class),
            isA(TypeAnnotation.class),
            isA(TypeParameterBoundTargetInfo.class));
  }

  /**
   * Test {@link TypeParameterBoundTargetInfo#accept(Clazz, Method, TypeAnnotation,
   * TargetInfoVisitor)} with {@code clazz}, {@code method}, {@code typeAnnotation}, {@code
   * targetInfoVisitor}.
   *
   * <p>Method under test: {@link TypeParameterBoundTargetInfo#accept(Clazz, Method, TypeAnnotation,
   * TargetInfoVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Method, TypeAnnotation, TargetInfoVisitor) with 'clazz', 'method', 'typeAnnotation', 'targetInfoVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.target.TypeParameterBoundTargetInfo.accept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.TypeAnnotation, proguard.classfile.attribute.annotation.target.visitor.TargetInfoVisitor)"
  })
  void testAcceptWithClazzMethodTypeAnnotationTargetInfoVisitor() {
    // Arrange
    TypeParameterBoundTargetInfo typeParameterBoundTargetInfo =
        new TypeParameterBoundTargetInfo((byte) 'A');
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    TypeAnnotation typeAnnotation = new TypeAnnotation();
    AnnotationsParser targetInfoVisitor = mock(AnnotationsParser.class);
    doNothing()
        .when(targetInfoVisitor)
        .visitTypeParameterBoundTargetInfo(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<TypeAnnotation>any(),
            Mockito.<TypeParameterBoundTargetInfo>any());

    // Act
    typeParameterBoundTargetInfo.accept(clazz, method, typeAnnotation, targetInfoVisitor);

    // Assert
    verify(targetInfoVisitor)
        .visitTypeParameterBoundTargetInfo(
            isA(Clazz.class),
            isA(Method.class),
            isA(TypeAnnotation.class),
            isA(TypeParameterBoundTargetInfo.class));
  }
}
