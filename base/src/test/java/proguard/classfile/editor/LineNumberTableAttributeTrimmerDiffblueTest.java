package proguard.classfile.editor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.LineNumberInfo;
import proguard.classfile.attribute.LineNumberTableAttribute;

class LineNumberTableAttributeTrimmerDiffblueTest {
  /**
   * Test {@link LineNumberTableAttributeTrimmer#visitLineNumberTableAttribute(Clazz, Method,
   * CodeAttribute, LineNumberTableAttribute)}.
   *
   * <ul>
   *   <li>Then first element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LineNumberTableAttributeTrimmer#visitLineNumberTableAttribute(Clazz, Method, CodeAttribute,
   * LineNumberTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test visitLineNumberTableAttribute(Clazz, Method, CodeAttribute, LineNumberTableAttribute); then first element is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.LineNumberTableAttributeTrimmer.visitLineNumberTableAttribute(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.attribute.CodeAttribute, proguard.classfile.attribute.LineNumberTableAttribute)"
  })
  void testVisitLineNumberTableAttribute_thenFirstElementIsNull() {
    // Arrange
    LineNumberTableAttributeTrimmer lineNumberTableAttributeTrimmer =
        new LineNumberTableAttributeTrimmer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LineNumberTableAttribute lineNumberTableAttribute =
        new LineNumberTableAttribute(1, 1, new LineNumberInfo[] {new LineNumberInfo(1, 2)});

    // Act
    lineNumberTableAttributeTrimmer.visitLineNumberTableAttribute(
        clazz, method, codeAttribute, lineNumberTableAttribute);

    // Assert
    LineNumberInfo[] lineNumberInfoArray = lineNumberTableAttribute.lineNumberTable;
    assertNull(lineNumberInfoArray[0]);
    assertEquals(0, lineNumberTableAttribute.getHighestLineNumber());
    assertEquals(0, lineNumberTableAttribute.getLowestLineNumber());
    assertEquals(0, lineNumberTableAttribute.u2lineNumberTableLength);
    assertEquals(1, lineNumberInfoArray.length);
  }
}
