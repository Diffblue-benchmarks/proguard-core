package proguard.classfile.editor;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.LocalVariableInfo;
import proguard.classfile.attribute.LocalVariableTypeInfo;
import proguard.classfile.attribute.MethodParametersAttribute;
import proguard.classfile.attribute.annotation.TypeAnnotation;
import proguard.classfile.attribute.annotation.target.LocalVariableTargetElement;
import proguard.classfile.attribute.annotation.target.LocalVariableTargetInfo;

public class VariableRemapperDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void VariableRemapper.visitMethodParametersAttribute(Clazz, Method, MethodParametersAttribute)"
  })
  public void testVisitMethodParametersAttribute_thenArrayLengthIsZero() {
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
   * Test {@link VariableRemapper#visitLocalVariableInfo(Clazz, Method, CodeAttribute,
   * LocalVariableInfo)}.
   *
   * <p>Method under test: {@link VariableRemapper#visitLocalVariableInfo(Clazz, Method,
   * CodeAttribute, LocalVariableInfo)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void VariableRemapper.visitLocalVariableInfo(Clazz, Method, CodeAttribute, LocalVariableInfo)"
  })
  public void testVisitLocalVariableInfo() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void VariableRemapper.visitLocalVariableTypeInfo(Clazz, Method, CodeAttribute, LocalVariableTypeInfo)"
  })
  public void testVisitLocalVariableTypeInfo() {
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
   * Test {@link VariableRemapper#visitLocalVariableTargetElement(Clazz, Method, CodeAttribute,
   * TypeAnnotation, LocalVariableTargetInfo, LocalVariableTargetElement)}.
   *
   * <p>Method under test: {@link VariableRemapper#visitLocalVariableTargetElement(Clazz, Method,
   * CodeAttribute, TypeAnnotation, LocalVariableTargetInfo, LocalVariableTargetElement)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void VariableRemapper.visitLocalVariableTargetElement(Clazz, Method, CodeAttribute, TypeAnnotation, LocalVariableTargetInfo, LocalVariableTargetElement)"
  })
  public void testVisitLocalVariableTargetElement() {
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
