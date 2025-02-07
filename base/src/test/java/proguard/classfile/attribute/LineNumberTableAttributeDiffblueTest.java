package proguard.classfile.attribute;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
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

class LineNumberTableAttributeDiffblueTest {
  /**
   * Test {@link LineNumberTableAttribute#LineNumberTableAttribute()}.
   *
   * <p>Method under test: {@link LineNumberTableAttribute#LineNumberTableAttribute()}
   */
  @Test
  @DisplayName("Test new LineNumberTableAttribute()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.LineNumberTableAttribute.<init>()",
    "void proguard.classfile.attribute.LineNumberTableAttribute.<init>(int, int, proguard.classfile.attribute.LineNumberInfo[])"
  })
  void testNewLineNumberTableAttribute() {
    // Arrange and Act
    LineNumberTableAttribute actualLineNumberTableAttribute = new LineNumberTableAttribute();

    // Assert
    assertNull(actualLineNumberTableAttribute.getProcessingInfo());
    assertEquals(0, actualLineNumberTableAttribute.getProcessingFlags());
  }

  /**
   * Test {@link LineNumberTableAttribute#LineNumberTableAttribute(int, int, LineNumberInfo[])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link LineNumberTableAttribute#LineNumberTableAttribute(int, int,
   * LineNumberInfo[])}
   */
  @Test
  @DisplayName("Test new LineNumberTableAttribute(int, int, LineNumberInfo[]); when one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.LineNumberTableAttribute.<init>()",
    "void proguard.classfile.attribute.LineNumberTableAttribute.<init>(int, int, proguard.classfile.attribute.LineNumberInfo[])"
  })
  void testNewLineNumberTableAttribute_whenOne() {
    // Arrange and Act
    LineNumberTableAttribute actualLineNumberTableAttribute =
        new LineNumberTableAttribute(1, 3, new LineNumberInfo[] {new LineNumberInfo(1, 2)});

    // Assert
    assertNull(actualLineNumberTableAttribute.getProcessingInfo());
    assertEquals(0, actualLineNumberTableAttribute.getProcessingFlags());
  }

  /**
   * Test {@link LineNumberTableAttribute#getLineNumber(int)}.
   *
   * <ul>
   *   <li>Given {@link LineNumberTableAttribute#LineNumberTableAttribute()}.
   *   <li>When one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link LineNumberTableAttribute#getLineNumber(int)}
   */
  @Test
  @DisplayName(
      "Test getLineNumber(int); given LineNumberTableAttribute(); when one; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.attribute.LineNumberTableAttribute.getLineNumber(int)"
  })
  void testGetLineNumber_givenLineNumberTableAttribute_whenOne_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new LineNumberTableAttribute()).getLineNumber(1));
  }

  /**
   * Test {@link LineNumberTableAttribute#getLineNumber(int)}.
   *
   * <ul>
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link LineNumberTableAttribute#getLineNumber(int)}
   */
  @Test
  @DisplayName("Test getLineNumber(int); then return two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.attribute.LineNumberTableAttribute.getLineNumber(int)"
  })
  void testGetLineNumber_thenReturnTwo() {
    // Arrange
    LineNumberTableAttribute lineNumberTableAttribute =
        new LineNumberTableAttribute(1, 3, new LineNumberInfo[] {new LineNumberInfo(1, 2)});
    lineNumberTableAttribute.u2lineNumberTableLength = 1;

    // Act and Assert
    assertEquals(2, lineNumberTableAttribute.getLineNumber(1));
  }

  /**
   * Test {@link LineNumberTableAttribute#getLineNumber(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link LineNumberTableAttribute#getLineNumber(int)}
   */
  @Test
  @DisplayName("Test getLineNumber(int); when zero; then return two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.attribute.LineNumberTableAttribute.getLineNumber(int)"
  })
  void testGetLineNumber_whenZero_thenReturnTwo() {
    // Arrange
    LineNumberTableAttribute lineNumberTableAttribute =
        new LineNumberTableAttribute(1, 3, new LineNumberInfo[] {new LineNumberInfo(1, 2)});
    lineNumberTableAttribute.u2lineNumberTableLength = 1;

    // Act and Assert
    assertEquals(2, lineNumberTableAttribute.getLineNumber(0));
  }

  /**
   * Test {@link LineNumberTableAttribute#getSource(int)}.
   *
   * <p>Method under test: {@link LineNumberTableAttribute#getSource(int)}
   */
  @Test
  @DisplayName("Test getSource(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.attribute.LineNumberTableAttribute.getSource(int)"
  })
  void testGetSource() {
    // Arrange
    LineNumberTableAttribute lineNumberTableAttribute =
        new LineNumberTableAttribute(1, 3, new LineNumberInfo[] {new LineNumberInfo(1, 2)});
    lineNumberTableAttribute.u2lineNumberTableLength = 1;

    // Act and Assert
    assertNull(lineNumberTableAttribute.getSource(1));
  }

  /**
   * Test {@link LineNumberTableAttribute#getSource(int)}.
   *
   * <ul>
   *   <li>Given {@link LineNumberTableAttribute#LineNumberTableAttribute()}.
   *   <li>When one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LineNumberTableAttribute#getSource(int)}
   */
  @Test
  @DisplayName(
      "Test getSource(int); given LineNumberTableAttribute(); when one; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.attribute.LineNumberTableAttribute.getSource(int)"
  })
  void testGetSource_givenLineNumberTableAttribute_whenOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new LineNumberTableAttribute()).getSource(1));
  }

  /**
   * Test {@link LineNumberTableAttribute#getSource(int)}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link LineNumberTableAttribute#getSource(int)}
   */
  @Test
  @DisplayName("Test getSource(int); when zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.attribute.LineNumberTableAttribute.getSource(int)"
  })
  void testGetSource_whenZero() {
    // Arrange
    LineNumberTableAttribute lineNumberTableAttribute =
        new LineNumberTableAttribute(1, 3, new LineNumberInfo[] {new LineNumberInfo(1, 2)});
    lineNumberTableAttribute.u2lineNumberTableLength = 1;

    // Act and Assert
    assertNull(lineNumberTableAttribute.getSource(0));
  }

  /**
   * Test {@link LineNumberTableAttribute#getLineNumberInfo(int)}.
   *
   * <p>Method under test: {@link LineNumberTableAttribute#getLineNumberInfo(int)}
   */
  @Test
  @DisplayName("Test getLineNumberInfo(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.attribute.LineNumberInfo proguard.classfile.attribute.LineNumberTableAttribute.getLineNumberInfo(int)"
  })
  void testGetLineNumberInfo() {
    // Arrange
    LineNumberInfo lineNumberInfo = new LineNumberInfo(1, 2);

    LineNumberTableAttribute lineNumberTableAttribute =
        new LineNumberTableAttribute(1, 3, new LineNumberInfo[] {lineNumberInfo});
    lineNumberTableAttribute.u2lineNumberTableLength = 1;

    // Act and Assert
    assertSame(lineNumberInfo, lineNumberTableAttribute.getLineNumberInfo(1));
  }

  /**
   * Test {@link LineNumberTableAttribute#getLineNumberInfo(int)}.
   *
   * <ul>
   *   <li>Given {@link LineNumberTableAttribute#LineNumberTableAttribute()}.
   *   <li>When one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LineNumberTableAttribute#getLineNumberInfo(int)}
   */
  @Test
  @DisplayName(
      "Test getLineNumberInfo(int); given LineNumberTableAttribute(); when one; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.attribute.LineNumberInfo proguard.classfile.attribute.LineNumberTableAttribute.getLineNumberInfo(int)"
  })
  void testGetLineNumberInfo_givenLineNumberTableAttribute_whenOne_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new LineNumberTableAttribute()).getLineNumberInfo(1));
  }

  /**
   * Test {@link LineNumberTableAttribute#getLineNumberInfo(int)}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link LineNumberTableAttribute#getLineNumberInfo(int)}
   */
  @Test
  @DisplayName("Test getLineNumberInfo(int); when zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.attribute.LineNumberInfo proguard.classfile.attribute.LineNumberTableAttribute.getLineNumberInfo(int)"
  })
  void testGetLineNumberInfo_whenZero() {
    // Arrange
    LineNumberInfo lineNumberInfo = new LineNumberInfo(1, 2);

    LineNumberTableAttribute lineNumberTableAttribute =
        new LineNumberTableAttribute(1, 3, new LineNumberInfo[] {lineNumberInfo});
    lineNumberTableAttribute.u2lineNumberTableLength = 1;

    // Act and Assert
    assertSame(lineNumberInfo, lineNumberTableAttribute.getLineNumberInfo(0));
  }

  /**
   * Test {@link LineNumberTableAttribute#getLowestLineNumber()}.
   *
   * <ul>
   *   <li>Given {@link LineNumberTableAttribute#LineNumberTableAttribute()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link LineNumberTableAttribute#getLowestLineNumber()}
   */
  @Test
  @DisplayName("Test getLowestLineNumber(); given LineNumberTableAttribute(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.attribute.LineNumberTableAttribute.getLowestLineNumber()"
  })
  void testGetLowestLineNumber_givenLineNumberTableAttribute_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new LineNumberTableAttribute()).getLowestLineNumber());
  }

  /**
   * Test {@link LineNumberTableAttribute#getLowestLineNumber()}.
   *
   * <ul>
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link LineNumberTableAttribute#getLowestLineNumber()}
   */
  @Test
  @DisplayName("Test getLowestLineNumber(); then return two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.attribute.LineNumberTableAttribute.getLowestLineNumber()"
  })
  void testGetLowestLineNumber_thenReturnTwo() {
    // Arrange, Act and Assert
    assertEquals(
        2,
        (new LineNumberTableAttribute(1, 1, new LineNumberInfo[] {new LineNumberInfo(1, 2)}))
            .getLowestLineNumber());
  }

  /**
   * Test {@link LineNumberTableAttribute#getHighestLineNumber()}.
   *
   * <ul>
   *   <li>Given {@link LineNumberTableAttribute#LineNumberTableAttribute()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link LineNumberTableAttribute#getHighestLineNumber()}
   */
  @Test
  @DisplayName("Test getHighestLineNumber(); given LineNumberTableAttribute(); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "int proguard.classfile.attribute.LineNumberTableAttribute.getHighestLineNumber()"
  })
  void testGetHighestLineNumber_givenLineNumberTableAttribute_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, (new LineNumberTableAttribute()).getHighestLineNumber());
  }

  /**
   * Test {@link LineNumberTableAttribute#accept(Clazz, Method, CodeAttribute, AttributeVisitor)}
   * with {@code clazz}, {@code method}, {@code codeAttribute}, {@code attributeVisitor}.
   *
   * <p>Method under test: {@link LineNumberTableAttribute#accept(Clazz, Method, CodeAttribute,
   * AttributeVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, Method, CodeAttribute, AttributeVisitor) with 'clazz', 'method', 'codeAttribute', 'attributeVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.attribute.LineNumberTableAttribute.accept(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.visitor.AttributeVisitor)"
  })
  void testAcceptWithClazzMethodCodeAttributeAttributeVisitor() {
    // Arrange
    LineNumberTableAttribute lineNumberTableAttribute = new LineNumberTableAttribute();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    AllAttributeVisitor attributeVisitor = mock(AllAttributeVisitor.class);
    doNothing()
        .when(attributeVisitor)
        .visitLineNumberTableAttribute(
            Mockito.<Clazz>any(),
            Mockito.<Method>any(),
            Mockito.<CodeAttribute>any(),
            Mockito.<LineNumberTableAttribute>any());

    // Act
    lineNumberTableAttribute.accept(clazz, method, codeAttribute, attributeVisitor);

    // Assert
    verify(attributeVisitor)
        .visitLineNumberTableAttribute(
            isA(Clazz.class),
            isA(Method.class),
            isA(CodeAttribute.class),
            isA(LineNumberTableAttribute.class));
  }
}
