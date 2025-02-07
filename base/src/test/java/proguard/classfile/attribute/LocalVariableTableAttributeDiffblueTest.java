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

class LocalVariableTableAttributeDiffblueTest {
  /**
   * Test {@link LocalVariableTableAttribute#LocalVariableTableAttribute()}.
   *
   * <p>Method under test: {@link LocalVariableTableAttribute#LocalVariableTableAttribute()}
   */
  @Test
  @DisplayName("Test new LocalVariableTableAttribute()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.LocalVariableTableAttribute.<init>()",
    "void proguard.classfile.attribute.LocalVariableTableAttribute.<init>(int, int, proguard.classfile.attribute.LocalVariableInfo[])"
  })
  void testNewLocalVariableTableAttribute() {
    // Arrange and Act
    LocalVariableTableAttribute actualLocalVariableTableAttribute =
        new LocalVariableTableAttribute();

    // Assert
    assertNull(actualLocalVariableTableAttribute.getProcessingInfo());
    assertEquals(0, actualLocalVariableTableAttribute.getProcessingFlags());
  }

  /**
   * Test {@link LocalVariableTableAttribute#LocalVariableTableAttribute(int, int,
   * LocalVariableInfo[])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link LocalVariableTableAttribute#LocalVariableTableAttribute(int, int,
   * LocalVariableInfo[])}
   */
  @Test
  @DisplayName("Test new LocalVariableTableAttribute(int, int, LocalVariableInfo[]); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.LocalVariableTableAttribute.<init>()",
    "void proguard.classfile.attribute.LocalVariableTableAttribute.<init>(int, int, proguard.classfile.attribute.LocalVariableInfo[])"
  })
  void testNewLocalVariableTableAttribute_whenOne() {
    // Arrange and Act
    LocalVariableTableAttribute actualLocalVariableTableAttribute =
        new LocalVariableTableAttribute(
            1, 3, new LocalVariableInfo[] {new LocalVariableInfo(1, 3, 1, 1, 1)});

    // Assert
    assertNull(actualLocalVariableTableAttribute.getProcessingInfo());
    assertEquals(0, actualLocalVariableTableAttribute.getProcessingFlags());
  }

  /**
   * Test {@link LocalVariableTableAttribute#accept(Clazz, Method, CodeAttribute, AttributeVisitor)}
   * with {@code clazz}, {@code method}, {@code codeAttribute}, {@code attributeVisitor}.
   *
   * <p>Method under test: {@link LocalVariableTableAttribute#accept(Clazz, Method, CodeAttribute,
   * AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Method, CodeAttribute, AttributeVisitor) with 'clazz', 'method', 'codeAttribute', 'attributeVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.LocalVariableTableAttribute.accept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzMethodCodeAttributeAttributeVisitor() {
    // Arrange
    LocalVariableTableAttribute localVariableTableAttribute = new LocalVariableTableAttribute();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitLocalVariableTableAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<LocalVariableTableAttribute>any());

    // Act
    localVariableTableAttribute.accept(clazz, method, codeAttribute, attributeVisitor);

    // Assert
    verify(attributeVisitor)
        .visitLocalVariableTableAttribute(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(LocalVariableTableAttribute.class));
  }
}
