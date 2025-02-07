package proguard.classfile.editor;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.LocalVariableInfo;
import proguard.classfile.attribute.LocalVariableTypeInfo;
import proguard.classfile.attribute.MethodParametersAttribute;
import proguard.classfile.attribute.annotation.TypeAnnotation;
import proguard.classfile.attribute.annotation.TypeAnnotationsAttribute;
import proguard.classfile.attribute.annotation.target.LocalVariableTargetElement;
import proguard.classfile.attribute.annotation.target.LocalVariableTargetInfo;
import proguard.classfile.attribute.annotation.target.visitor.TargetInfoVisitor;
import proguard.classfile.attribute.annotation.visitor.TypeAnnotationVisitor;

class VariableRemapperDiffblueTest {
  /**
   * Test {@link VariableRemapper#visitMethodParametersAttribute(Clazz, Method,
   * MethodParametersAttribute)}.
   *
   * <ul>
   *   <li>Then array length is zero.
   * </ul>
   *
   * <p>Method under test: {@link VariableRemapper#visitMethodParametersAttribute(Clazz, Method,
   * MethodParametersAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitMethodParametersAttribute(Clazz, Method, MethodParametersAttribute); then array length is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.VariableRemapper.visitMethodParametersAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.MethodParametersAttribute)"
  })
  void testVisitMethodParametersAttribute_thenArrayLengthIsZero() {
    // Arrange
    VariableRemapper variableRemapper = new VariableRemapper();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    MethodParametersAttribute methodParametersAttribute = new MethodParametersAttribute();

    // Act
    variableRemapper.visitMethodParametersAttribute(clazz, method, methodParametersAttribute);

    // Assert
    assertEquals(0, methodParametersAttribute.parameters.length);
  }

  /**
   * Test {@link VariableRemapper#visitAnyTypeAnnotationsAttribute(Clazz,
   * TypeAnnotationsAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link TypeAnnotationsAttribute#typeAnnotationsAccept(Clazz,
   *       TypeAnnotationVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link VariableRemapper#visitAnyTypeAnnotationsAttribute(Clazz,
   * TypeAnnotationsAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitAnyTypeAnnotationsAttribute(Clazz, TypeAnnotationsAttribute); then calls typeAnnotationsAccept(Clazz, TypeAnnotationVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.VariableRemapper.visitAnyTypeAnnotationsAttribute(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.TypeAnnotationsAttribute)"
  })
  void testVisitAnyTypeAnnotationsAttribute_thenCallsTypeAnnotationsAccept() {
    // Arrange
    VariableRemapper variableRemapper = new VariableRemapper();
    LibraryClass clazz = new LibraryClass();
    TypeAnnotationsAttribute typeAnnotationsAttribute = mock(TypeAnnotationsAttribute.class);
    doNothing()
        .when(typeAnnotationsAttribute)
        .typeAnnotationsAccept(Mockito.<Clazz>any(), Mockito.<TypeAnnotationVisitor>any());

    // Act
    variableRemapper.visitAnyTypeAnnotationsAttribute(clazz, typeAnnotationsAttribute);

    // Assert
    verify(typeAnnotationsAttribute)
        .typeAnnotationsAccept(isA(Clazz.class), isA(TypeAnnotationVisitor.class));
  }

  /**
   * Test {@link VariableRemapper#visitLocalVariableInfo(Clazz, Method, CodeAttribute,
   * LocalVariableInfo)}.
   *
   * <p>Method under test: {@link VariableRemapper#visitLocalVariableInfo(Clazz, Method,
   * CodeAttribute, LocalVariableInfo)}
   */
  @Test
  @DisplayName("Test visitLocalVariableInfo(Clazz, Method, CodeAttribute, LocalVariableInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.VariableRemapper.visitLocalVariableInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableInfo)"
  })
  void testVisitLocalVariableInfo() {
    // Arrange
    VariableRemapper variableRemapper = new VariableRemapper();
    variableRemapper.setVariableMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableInfo localVariableInfo = new LocalVariableInfo(1, 3, 1, 1, 1);

    // Act
    variableRemapper.visitLocalVariableInfo(clazz, method, codeAttribute, localVariableInfo);

    // Assert
    assertEquals(0, localVariableInfo.u2index);
  }

  /**
   * Test {@link VariableRemapper#visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute,
   * LocalVariableTypeInfo)}.
   *
   * <p>Method under test: {@link VariableRemapper#visitLocalVariableTypeInfo(Clazz, Method,
   * CodeAttribute, LocalVariableTypeInfo)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute, LocalVariableTypeInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.VariableRemapper.visitLocalVariableTypeInfo(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableTypeInfo)"
  })
  void testVisitLocalVariableTypeInfo() {
    // Arrange
    VariableRemapper variableRemapper = new VariableRemapper();
    variableRemapper.setVariableMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 1, 1, 1);

    // Act
    variableRemapper.visitLocalVariableTypeInfo(
        clazz, method, codeAttribute, localVariableTypeInfo);

    // Assert
    assertEquals(0, localVariableTypeInfo.u2index);
  }

  /**
   * Test {@link VariableRemapper#visitTypeAnnotation(Clazz, TypeAnnotation)} with {@code clazz},
   * {@code typeAnnotation}.
   *
   * <ul>
   *   <li>Then calls {@link TypeAnnotation#targetInfoAccept(Clazz, TargetInfoVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link VariableRemapper#visitTypeAnnotation(Clazz, TypeAnnotation)}
   */
  @Test
  @DisplayName(
      "Test visitTypeAnnotation(Clazz, TypeAnnotation) with 'clazz', 'typeAnnotation'; then calls targetInfoAccept(Clazz, TargetInfoVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.VariableRemapper.visitTypeAnnotation(proguard.classfile.Clazz, proguard.classfile.attribute.annotation.TypeAnnotation)"
  })
  void testVisitTypeAnnotationWithClazzTypeAnnotation_thenCallsTargetInfoAccept() {
    // Arrange
    VariableRemapper variableRemapper = new VariableRemapper();
    LibraryClass clazz = new LibraryClass();
    TypeAnnotation typeAnnotation = mock(TypeAnnotation.class);
    doNothing()
        .when(typeAnnotation)
        .targetInfoAccept(Mockito.<Clazz>any(), Mockito.<TargetInfoVisitor>any());

    // Act
    variableRemapper.visitTypeAnnotation(clazz, typeAnnotation);

    // Assert
    verify(typeAnnotation).targetInfoAccept(isA(Clazz.class), isA(TargetInfoVisitor.class));
  }

  /**
   * Test {@link VariableRemapper#visitLocalVariableTargetElement(Clazz, Method, CodeAttribute,
   * TypeAnnotation, LocalVariableTargetInfo, LocalVariableTargetElement)}.
   *
   * <p>Method under test: {@link VariableRemapper#visitLocalVariableTargetElement(Clazz, Method,
   * CodeAttribute, TypeAnnotation, LocalVariableTargetInfo, LocalVariableTargetElement)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTargetElement(Clazz, Method, CodeAttribute, TypeAnnotation, LocalVariableTargetInfo, LocalVariableTargetElement)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.VariableRemapper.visitLocalVariableTargetElement(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.annotation.TypeAnnotation, proguard.classfile.attribute.annotation.target.LocalVariableTargetInfo, proguard.classfile.attribute.annotation.target.LocalVariableTargetElement)"
  })
  void testVisitLocalVariableTargetElement() {
    // Arrange
    VariableRemapper variableRemapper = new VariableRemapper();
    variableRemapper.setVariableMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    TypeAnnotation typeAnnotation = new TypeAnnotation();
    LocalVariableTargetInfo localVariableTargetInfo = new LocalVariableTargetInfo((byte) 'A');
    LocalVariableTargetElement localVariableTargetElement = new LocalVariableTargetElement(1, 3, 1);

    // Act
    variableRemapper.visitLocalVariableTargetElement(
        clazz,
        method,
        codeAttribute,
        typeAnnotation,
        localVariableTargetInfo,
        localVariableTargetElement);

    // Assert
    assertEquals(0, localVariableTargetElement.u2index);
  }
}
