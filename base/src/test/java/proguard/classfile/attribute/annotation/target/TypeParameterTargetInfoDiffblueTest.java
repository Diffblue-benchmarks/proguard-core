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
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.annotation.TypeAnnotation;
import proguard.classfile.attribute.annotation.target.visitor.TargetInfoVisitor;

class TypeParameterTargetInfoDiffblueTest {
  /**
   * Test {@link TypeParameterTargetInfo#TypeParameterTargetInfo()}.
   *
   * <p>Method under test: {@link TypeParameterTargetInfo#TypeParameterTargetInfo()}
   */
  @Test
  @DisplayName("Test new TypeParameterTargetInfo()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.target.TypeParameterTargetInfo.<init>()",
    "void proguard.classfile.attribute.annotation.target.TypeParameterTargetInfo.<init>(byte)",
    "void proguard.classfile.attribute.annotation.target.TypeParameterTargetInfo.<init>(byte, int)"
  })
  void testNewTypeParameterTargetInfo() {
    // Arrange, Act and Assert
    assertEquals(
        TargetInfo.TARGET_TYPE_PARAMETER_GENERIC_CLASS,
        (new TypeParameterTargetInfo()).getTargetType());
  }

  /**
   * Test {@link TypeParameterTargetInfo#TypeParameterTargetInfo(byte)}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return TargetType is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link TypeParameterTargetInfo#TypeParameterTargetInfo(byte)}
   */
  @Test
  @DisplayName("Test new TypeParameterTargetInfo(byte); when 'A'; then return TargetType is 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.target.TypeParameterTargetInfo.<init>()",
    "void proguard.classfile.attribute.annotation.target.TypeParameterTargetInfo.<init>(byte)",
    "void proguard.classfile.attribute.annotation.target.TypeParameterTargetInfo.<init>(byte, int)"
  })
  void testNewTypeParameterTargetInfo_whenA_thenReturnTargetTypeIsA() {
    // Arrange, Act and Assert
    assertEquals('A', (new TypeParameterTargetInfo((byte) 'A')).getTargetType());
  }

  /**
   * Test {@link TypeParameterTargetInfo#TypeParameterTargetInfo(byte, int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return TargetType is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link TypeParameterTargetInfo#TypeParameterTargetInfo(byte, int)}
   */
  @Test
  @DisplayName(
      "Test new TypeParameterTargetInfo(byte, int); when one; then return TargetType is 'A'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.target.TypeParameterTargetInfo.<init>()",
    "void proguard.classfile.attribute.annotation.target.TypeParameterTargetInfo.<init>(byte)",
    "void proguard.classfile.attribute.annotation.target.TypeParameterTargetInfo.<init>(byte, int)"
  })
  void testNewTypeParameterTargetInfo_whenOne_thenReturnTargetTypeIsA() {
    // Arrange, Act and Assert
    assertEquals('A', (new TypeParameterTargetInfo((byte) 'A', 1)).getTargetType());
  }

  /**
   * Test {@link TypeParameterTargetInfo#accept(Clazz, Method, TypeAnnotation, TargetInfoVisitor)}
   * with {@code clazz}, {@code method}, {@code typeAnnotation}, {@code targetInfoVisitor}.
   *
   * <p>Method under test: {@link TypeParameterTargetInfo#accept(Clazz, Method, TypeAnnotation,
   * TargetInfoVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Method, TypeAnnotation, TargetInfoVisitor) with 'clazz', 'method', 'typeAnnotation', 'targetInfoVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.annotation.target.TypeParameterTargetInfo.accept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.annotation.TypeAnnotation, proguard.classfile.attribute.annotation.target.visitor.TargetInfoVisitor)"
  })
  void testAcceptWithClazzMethodTypeAnnotationTargetInfoVisitor() {
    // Arrange
    TypeParameterTargetInfo typeParameterTargetInfo = new TypeParameterTargetInfo((byte) 'A');
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    TypeAnnotation typeAnnotation = new TypeAnnotation();
    AnnotationsParser targetInfoVisitor = mock(AnnotationsParser.class);
    doNothing()
        .when(targetInfoVisitor)
        .visitTypeParameterTargetInfo(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<TypeAnnotation>any(),
            Mockito.<TypeParameterTargetInfo>any());

    // Act
    typeParameterTargetInfo.accept(clazz, method, typeAnnotation, targetInfoVisitor);

    // Assert
    verify(targetInfoVisitor)
        .visitTypeParameterTargetInfo(
            isA(Clazz.class),
            isA(Method.class),
            isA(TypeAnnotation.class),
            isA(TypeParameterTargetInfo.class));
  }
}
