package proguard.classfile.editor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
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
import proguard.classfile.attribute.LocalVariableTableAttribute;
import proguard.classfile.attribute.LocalVariableTypeInfo;
import proguard.classfile.attribute.LocalVariableTypeTableAttribute;
import proguard.classfile.attribute.visitor.AttributeVisitor;

class VariableCleanerDiffblueTest {
  /**
   * Test {@link VariableCleaner#visitCodeAttribute(Clazz, Method, CodeAttribute)}.
   *
   * <ul>
   *   <li>Then calls {@link CodeAttribute#attributesAccept(Clazz, Method, AttributeVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link VariableCleaner#visitCodeAttribute(Clazz, Method, CodeAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitCodeAttribute(Clazz, Method, CodeAttribute); then calls attributesAccept(Clazz, Method, AttributeVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.VariableCleaner.visitCodeAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute)"
  })
  void testVisitCodeAttribute_thenCallsAttributesAccept() {
    // Arrange
    VariableCleaner variableCleaner = new VariableCleaner();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = mock(CodeAttribute.class);
    doNothing()
        .when(codeAttribute)
        .attributesAccept(
            Mockito.<Clazz>any(), Mockito.<Method>any(), Mockito.<AttributeVisitor>any());

    // Act
    variableCleaner.visitCodeAttribute(clazz, method, codeAttribute);

    // Assert
    verify(codeAttribute)
        .attributesAccept(isA(Clazz.class), isA(Method.class), isA(AttributeVisitor.class));
  }

  /**
   * Test {@link VariableCleaner#visitLocalVariableTableAttribute(Clazz, Method, CodeAttribute,
   * LocalVariableTableAttribute)}.
   *
   * <p>Method under test: {@link VariableCleaner#visitLocalVariableTableAttribute(Clazz, Method,
   * CodeAttribute, LocalVariableTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTableAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.VariableCleaner.visitLocalVariableTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableTableAttribute)"
  })
  void testVisitLocalVariableTableAttribute() throws UnsupportedEncodingException {
    // Arrange
    VariableCleaner variableCleaner = new VariableCleaner();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, "AXAXAXAX".getBytes("UTF-8"));

    LocalVariableInfo localVariableInfo = new LocalVariableInfo(1, 3, 1, 1, 1);

    LocalVariableTableAttribute localVariableTableAttribute =
        new LocalVariableTableAttribute(1, 1, new LocalVariableInfo[] {localVariableInfo});

    // Act
    variableCleaner.visitLocalVariableTableAttribute(
        clazz, method, codeAttribute, localVariableTableAttribute);

    // Assert that nothing has changed
    LocalVariableInfo[] localVariableInfoArray = localVariableTableAttribute.localVariableTable;
    assertEquals(1, localVariableInfoArray.length);
    assertEquals(1, localVariableTableAttribute.u2localVariableTableLength);
    LocalVariableInfo localVariableInfo2 = localVariableInfoArray[0];
    assertEquals(3, localVariableInfo2.u2length);
    assertSame(localVariableInfo, localVariableInfo2);
  }

  /**
   * Test {@link VariableCleaner#visitLocalVariableTableAttribute(Clazz, Method, CodeAttribute,
   * LocalVariableTableAttribute)}.
   *
   * <ul>
   *   <li>Then first element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link VariableCleaner#visitLocalVariableTableAttribute(Clazz, Method,
   * CodeAttribute, LocalVariableTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTableAttribute); then first element is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.VariableCleaner.visitLocalVariableTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableTableAttribute)"
  })
  void testVisitLocalVariableTableAttribute_thenFirstElementIsNull() {
    // Arrange
    VariableCleaner variableCleaner = new VariableCleaner();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableTableAttribute localVariableTableAttribute =
        new LocalVariableTableAttribute(
            1, 1, new LocalVariableInfo[] {new LocalVariableInfo(1, 3, 1, 1, 1)});

    // Act
    variableCleaner.visitLocalVariableTableAttribute(
        clazz, method, codeAttribute, localVariableTableAttribute);

    // Assert
    LocalVariableInfo[] localVariableInfoArray = localVariableTableAttribute.localVariableTable;
    assertNull(localVariableInfoArray[0]);
    assertEquals(0, localVariableTableAttribute.u2localVariableTableLength);
    assertEquals(1, localVariableInfoArray.length);
  }

  /**
   * Test {@link VariableCleaner#visitLocalVariableTableAttribute(Clazz, Method, CodeAttribute,
   * LocalVariableTableAttribute)}.
   *
   * <ul>
   *   <li>Then first element {@link LocalVariableInfo#u2length} is zero.
   * </ul>
   *
   * <p>Method under test: {@link VariableCleaner#visitLocalVariableTableAttribute(Clazz, Method,
   * CodeAttribute, LocalVariableTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTableAttribute); then first element u2length is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.VariableCleaner.visitLocalVariableTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableTableAttribute)"
  })
  void testVisitLocalVariableTableAttribute_thenFirstElementU2lengthIsZero()
      throws UnsupportedEncodingException {
    // Arrange
    VariableCleaner variableCleaner = new VariableCleaner();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, "AXAXAXAX".getBytes("UTF-8"));

    LocalVariableInfo localVariableInfo = new LocalVariableInfo(1, 3, 1, 1, 1);

    LocalVariableInfo localVariableInfo2 = new LocalVariableInfo(1, 3, 1, 1, 1);

    LocalVariableTableAttribute localVariableTableAttribute =
        new LocalVariableTableAttribute(
            1,
            3,
            new LocalVariableInfo[] {
              localVariableInfo, localVariableInfo2, new LocalVariableInfo(1, 3, 1, 1, 1)
            });

    // Act
    variableCleaner.visitLocalVariableTableAttribute(
        clazz, method, codeAttribute, localVariableTableAttribute);

    // Assert
    LocalVariableInfo[] localVariableInfoArray = localVariableTableAttribute.localVariableTable;
    LocalVariableInfo localVariableInfo3 = localVariableInfoArray[0];
    assertEquals(0, localVariableInfo3.u2length);
    assertEquals(0, (localVariableInfoArray[1]).u2length);
    assertEquals(3, localVariableInfoArray.length);
    assertEquals(3, localVariableTableAttribute.u2localVariableTableLength);
    assertSame(localVariableInfo, localVariableInfo3);
  }

  /**
   * Test {@link VariableCleaner#visitLocalVariableTypeTableAttribute(Clazz, Method, CodeAttribute,
   * LocalVariableTypeTableAttribute)}.
   *
   * <p>Method under test: {@link VariableCleaner#visitLocalVariableTypeTableAttribute(Clazz,
   * Method, CodeAttribute, LocalVariableTypeTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTypeTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTypeTableAttribute)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.VariableCleaner.visitLocalVariableTypeTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableTypeTableAttribute)"
  })
  void testVisitLocalVariableTypeTableAttribute() throws UnsupportedEncodingException {
    // Arrange
    VariableCleaner variableCleaner = new VariableCleaner();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, "AXAXAXAX".getBytes("UTF-8"));

    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 1, 1, 1);

    LocalVariableTypeTableAttribute localVariableTypeTableAttribute =
        new LocalVariableTypeTableAttribute(
            1, 1, new LocalVariableTypeInfo[] {localVariableTypeInfo});

    // Act
    variableCleaner.visitLocalVariableTypeTableAttribute(
        clazz, method, codeAttribute, localVariableTypeTableAttribute);

    // Assert that nothing has changed
    LocalVariableTypeInfo[] localVariableTypeInfoArray =
        localVariableTypeTableAttribute.localVariableTypeTable;
    assertEquals(1, localVariableTypeInfoArray.length);
    assertEquals(1, localVariableTypeTableAttribute.u2localVariableTypeTableLength);
    LocalVariableTypeInfo localVariableTypeInfo2 = localVariableTypeInfoArray[0];
    assertEquals(3, localVariableTypeInfo2.u2length);
    assertSame(localVariableTypeInfo, localVariableTypeInfo2);
  }

  /**
   * Test {@link VariableCleaner#visitLocalVariableTypeTableAttribute(Clazz, Method, CodeAttribute,
   * LocalVariableTypeTableAttribute)}.
   *
   * <ul>
   *   <li>Then first element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link VariableCleaner#visitLocalVariableTypeTableAttribute(Clazz,
   * Method, CodeAttribute, LocalVariableTypeTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTypeTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTypeTableAttribute); then first element is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.VariableCleaner.visitLocalVariableTypeTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableTypeTableAttribute)"
  })
  void testVisitLocalVariableTypeTableAttribute_thenFirstElementIsNull() {
    // Arrange
    VariableCleaner variableCleaner = new VariableCleaner();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableTypeTableAttribute localVariableTypeTableAttribute =
        new LocalVariableTypeTableAttribute(
            1, 1, new LocalVariableTypeInfo[] {new LocalVariableTypeInfo(1, 3, 1, 1, 1)});

    // Act
    variableCleaner.visitLocalVariableTypeTableAttribute(
        clazz, method, codeAttribute, localVariableTypeTableAttribute);

    // Assert
    LocalVariableTypeInfo[] localVariableTypeInfoArray =
        localVariableTypeTableAttribute.localVariableTypeTable;
    assertNull(localVariableTypeInfoArray[0]);
    assertEquals(0, localVariableTypeTableAttribute.u2localVariableTypeTableLength);
    assertEquals(1, localVariableTypeInfoArray.length);
  }

  /**
   * Test {@link VariableCleaner#visitLocalVariableTypeTableAttribute(Clazz, Method, CodeAttribute,
   * LocalVariableTypeTableAttribute)}.
   *
   * <ul>
   *   <li>Then first element {@link LocalVariableTypeInfo#u2length} is zero.
   * </ul>
   *
   * <p>Method under test: {@link VariableCleaner#visitLocalVariableTypeTableAttribute(Clazz,
   * Method, CodeAttribute, LocalVariableTypeTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitLocalVariableTypeTableAttribute(Clazz, Method, CodeAttribute, LocalVariableTypeTableAttribute); then first element u2length is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.VariableCleaner.visitLocalVariableTypeTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LocalVariableTypeTableAttribute)"
  })
  void testVisitLocalVariableTypeTableAttribute_thenFirstElementU2lengthIsZero()
      throws UnsupportedEncodingException {
    // Arrange
    VariableCleaner variableCleaner = new VariableCleaner();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1, 3, 3, 3, "AXAXAXAX".getBytes("UTF-8"));

    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 1, 1, 1);

    LocalVariableTypeInfo localVariableTypeInfo2 = new LocalVariableTypeInfo(1, 3, 1, 1, 1);

    LocalVariableTypeTableAttribute localVariableTypeTableAttribute =
        new LocalVariableTypeTableAttribute(
            1,
            3,
            new LocalVariableTypeInfo[] {
              localVariableTypeInfo,
              localVariableTypeInfo2,
              new LocalVariableTypeInfo(1, 3, 1, 1, 1)
            });

    // Act
    variableCleaner.visitLocalVariableTypeTableAttribute(
        clazz, method, codeAttribute, localVariableTypeTableAttribute);

    // Assert
    LocalVariableTypeInfo[] localVariableTypeInfoArray =
        localVariableTypeTableAttribute.localVariableTypeTable;
    LocalVariableTypeInfo localVariableTypeInfo3 = localVariableTypeInfoArray[0];
    assertEquals(0, localVariableTypeInfo3.u2length);
    assertEquals(0, (localVariableTypeInfoArray[1]).u2length);
    assertEquals(3, localVariableTypeInfoArray.length);
    assertEquals(3, localVariableTypeTableAttribute.u2localVariableTypeTableLength);
    assertSame(localVariableTypeInfo, localVariableTypeInfo3);
  }
}
