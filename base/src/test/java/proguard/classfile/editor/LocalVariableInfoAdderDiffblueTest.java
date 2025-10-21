package proguard.classfile.editor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.ProgramClass;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.LocalVariableInfo;
import proguard.classfile.attribute.LocalVariableTableAttribute;

public class LocalVariableInfoAdderDiffblueTest {
  /**
   * Test {@link LocalVariableInfoAdder#LocalVariableInfoAdder(ProgramClass,
   * LocalVariableTableAttribute)}.
   *
   * <ul>
   *   <li>Then fourth element ProcessingInfo is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link LocalVariableInfoAdder#LocalVariableInfoAdder(ProgramClass,
   * LocalVariableTableAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void LocalVariableInfoAdder.<init>(ProgramClass, LocalVariableTableAttribute)"
  })
  public void testNewLocalVariableInfoAdder_thenFourthElementProcessingInfoIsNull() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    LocalVariableTableAttribute targetLocalVariableTableAttribute =
        new LocalVariableTableAttribute(
            1, 3, new LocalVariableInfo[] {new LocalVariableInfo(1, 3, 1, 1, 1)});

    // Act
    LocalVariableInfoAdder actualLocalVariableInfoAdder =
        new LocalVariableInfoAdder(targetClass, targetLocalVariableTableAttribute);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    actualLocalVariableInfoAdder.visitLocalVariableInfo(
        clazz, method, codeAttribute, new LocalVariableInfo(1, 3, 1, 1, 1));

    // Assert
    LocalVariableInfo[] localVariableInfoArray =
        targetLocalVariableTableAttribute.localVariableTable;
    LocalVariableInfo localVariableInfo = localVariableInfoArray[3];
    assertNull(localVariableInfo.getProcessingInfo());
    assertNull(localVariableInfo.referencedClass);
    assertNull(localVariableInfoArray[1]);
    assertNull(localVariableInfoArray[2]);
    assertEquals(0, localVariableInfo.getProcessingFlags());
    assertEquals(0, localVariableInfo.u2descriptorIndex);
    assertEquals(0, localVariableInfo.u2nameIndex);
    assertEquals(1, localVariableInfo.u2index);
    assertEquals(1, localVariableInfo.u2startPC);
    assertEquals(3, localVariableInfo.u2length);
    assertEquals(4, localVariableInfoArray.length);
    assertEquals(4, targetLocalVariableTableAttribute.u2localVariableTableLength);
  }
}
