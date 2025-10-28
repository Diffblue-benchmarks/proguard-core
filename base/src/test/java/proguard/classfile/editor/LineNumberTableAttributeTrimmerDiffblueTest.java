package proguard.classfile.editor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.LineNumberInfo;
import proguard.classfile.attribute.LineNumberTableAttribute;

public class LineNumberTableAttributeTrimmerDiffblueTest {
  /**
   * Method under test:
   * {@link LineNumberTableAttributeTrimmer#visitLineNumberTableAttribute(Clazz, Method, CodeAttribute, LineNumberTableAttribute)}
   */
  @Test
  public void testVisitLineNumberTableAttribute() {
    // Arrange
    LineNumberTableAttributeTrimmer lineNumberTableAttributeTrimmer = new LineNumberTableAttributeTrimmer();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    LineNumberTableAttribute lineNumberTableAttribute = new LineNumberTableAttribute(1, 1,
        new LineNumberInfo[]{new LineNumberInfo(1, 2)});

    // Act
    lineNumberTableAttributeTrimmer.visitLineNumberTableAttribute(clazz, method, codeAttribute,
        lineNumberTableAttribute);

    // Assert
    LineNumberInfo[] lineNumberInfoArray = lineNumberTableAttribute.lineNumberTable;
    assertNull(lineNumberInfoArray[0]);
    assertEquals(0, lineNumberTableAttribute.getHighestLineNumber());
    assertEquals(0, lineNumberTableAttribute.getLowestLineNumber());
    assertEquals(0, lineNumberTableAttribute.u2lineNumberTableLength);
    assertEquals(1, lineNumberInfoArray.length);
  }
}
