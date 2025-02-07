package proguard.classfile.attribute;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
import proguard.classfile.attribute.visitor.AllAttributeVisitor;
import proguard.classfile.attribute.visitor.AttributeVisitor;

class LocalVariableTypeTableAttributeDiffblueTest {
  /**
   * Test {@link LocalVariableTypeTableAttribute#LocalVariableTypeTableAttribute()}.
   *
   * <p>Method under test: {@link LocalVariableTypeTableAttribute#LocalVariableTypeTableAttribute()}
   */
  @Test
  @DisplayName("Test new LocalVariableTypeTableAttribute()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.LocalVariableTypeTableAttribute.<init>()",
    "void proguard.classfile.attribute.LocalVariableTypeTableAttribute.<init>(int, int, proguard.classfile.attribute.LocalVariableTypeInfo[])"
  })
  void testNewLocalVariableTypeTableAttribute() {
    // Arrange and Act
    LocalVariableTypeTableAttribute actualLocalVariableTypeTableAttribute =
        new LocalVariableTypeTableAttribute();

    // Assert
    assertNull(actualLocalVariableTypeTableAttribute.getProcessingInfo());
    assertEquals(0, actualLocalVariableTypeTableAttribute.getProcessingFlags());
  }

  /**
   * Test {@link LocalVariableTypeTableAttribute#LocalVariableTypeTableAttribute(int, int,
   * LocalVariableTypeInfo[])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link
   * LocalVariableTypeTableAttribute#LocalVariableTypeTableAttribute(int, int,
   * LocalVariableTypeInfo[])}
   */
  @Test
  @DisplayName(
      "Test new LocalVariableTypeTableAttribute(int, int, LocalVariableTypeInfo[]); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.LocalVariableTypeTableAttribute.<init>()",
    "void proguard.classfile.attribute.LocalVariableTypeTableAttribute.<init>(int, int, proguard.classfile.attribute.LocalVariableTypeInfo[])"
  })
  void testNewLocalVariableTypeTableAttribute_whenOne() {
    // Arrange and Act
    LocalVariableTypeTableAttribute actualLocalVariableTypeTableAttribute =
        new LocalVariableTypeTableAttribute(
            1, 3, new LocalVariableTypeInfo[] {new LocalVariableTypeInfo(1, 3, 1, 1, 1)});

    // Assert
    assertNull(actualLocalVariableTypeTableAttribute.getProcessingInfo());
    assertEquals(0, actualLocalVariableTypeTableAttribute.getProcessingFlags());
  }

  /**
   * Test {@link LocalVariableTypeTableAttribute#accept(Clazz, Method, CodeAttribute,
   * AttributeVisitor)} with {@code clazz}, {@code method}, {@code codeAttribute}, {@code
   * attributeVisitor}.
   *
   * <p>Method under test: {@link LocalVariableTypeTableAttribute#accept(Clazz, Method,
   * CodeAttribute, AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Method, CodeAttribute, AttributeVisitor) with 'clazz', 'method', 'codeAttribute', 'attributeVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.LocalVariableTypeTableAttribute.accept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzMethodCodeAttributeAttributeVisitor() {
    // Arrange
    LocalVariableTypeTableAttribute localVariableTypeTableAttribute =
        new LocalVariableTypeTableAttribute();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitLocalVariableTypeTableAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<LocalVariableTypeTableAttribute>any());

    // Act
    localVariableTypeTableAttribute.accept(clazz, method, codeAttribute, attributeVisitor);

    // Assert
    verify(attributeVisitor)
        .visitLocalVariableTypeTableAttribute(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(LocalVariableTypeTableAttribute.class));
  }
}
