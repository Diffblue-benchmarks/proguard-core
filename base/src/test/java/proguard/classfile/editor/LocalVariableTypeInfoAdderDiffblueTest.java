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
import proguard.classfile.attribute.LocalVariableTypeInfo;
import proguard.classfile.attribute.LocalVariableTypeTableAttribute;

public class LocalVariableTypeInfoAdderDiffblueTest {
  /**
   * Test {@link LocalVariableTypeInfoAdder#LocalVariableTypeInfoAdder(ProgramClass,
   * LocalVariableTypeTableAttribute)}.
   *
   * <ul>
   *   <li>Then first element {@link LocalVariableTypeInfo#u2nameIndex} is zero.
   * </ul>
   *
   * <p>Method under test: {@link
   * LocalVariableTypeInfoAdder#LocalVariableTypeInfoAdder(ProgramClass,
   * LocalVariableTypeTableAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void LocalVariableTypeInfoAdder.<init>(ProgramClass, LocalVariableTypeTableAttribute)"
  })
  public void testNewLocalVariableTypeInfoAdder_thenFirstElementU2nameIndexIsZero() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    LocalVariableTypeTableAttribute targetLocalVariableTypeTableAttribute =
        new LocalVariableTypeTableAttribute(
            1, 0, new LocalVariableTypeInfo[] {new LocalVariableTypeInfo(1, 3, 1, 1, 1)});

    // Act
    LocalVariableTypeInfoAdder actualLocalVariableTypeInfoAdder =
        new LocalVariableTypeInfoAdder(targetClass, targetLocalVariableTypeTableAttribute);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    actualLocalVariableTypeInfoAdder.visitLocalVariableTypeInfo(
        clazz, method, codeAttribute, new LocalVariableTypeInfo(1, 3, 1, 1, 1));

    // Assert
    LocalVariableTypeInfo[] localVariableTypeInfoArray =
        targetLocalVariableTypeTableAttribute.localVariableTypeTable;
    LocalVariableTypeInfo localVariableTypeInfo = localVariableTypeInfoArray[0];
    assertEquals(0, localVariableTypeInfo.u2nameIndex);
    assertEquals(0, localVariableTypeInfo.u2signatureIndex);
    assertEquals(1, localVariableTypeInfoArray.length);
    assertEquals(1, targetLocalVariableTypeTableAttribute.u2localVariableTypeTableLength);
  }

  /**
   * Test {@link LocalVariableTypeInfoAdder#LocalVariableTypeInfoAdder(ProgramClass,
   * LocalVariableTypeTableAttribute)}.
   *
   * <ul>
   *   <li>Then fourth element {@link LocalVariableTypeInfo#referencedClasses} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * LocalVariableTypeInfoAdder#LocalVariableTypeInfoAdder(ProgramClass,
   * LocalVariableTypeTableAttribute)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void LocalVariableTypeInfoAdder.<init>(ProgramClass, LocalVariableTypeTableAttribute)"
  })
  public void testNewLocalVariableTypeInfoAdder_thenFourthElementReferencedClassesIsNull() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    LocalVariableTypeTableAttribute targetLocalVariableTypeTableAttribute =
        new LocalVariableTypeTableAttribute(
            1, 3, new LocalVariableTypeInfo[] {new LocalVariableTypeInfo(1, 3, 1, 1, 1)});

    // Act
    LocalVariableTypeInfoAdder actualLocalVariableTypeInfoAdder =
        new LocalVariableTypeInfoAdder(targetClass, targetLocalVariableTypeTableAttribute);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    CodeAttribute codeAttribute = new CodeAttribute(1);
    actualLocalVariableTypeInfoAdder.visitLocalVariableTypeInfo(
        clazz, method, codeAttribute, new LocalVariableTypeInfo(1, 3, 1, 1, 1));

    // Assert
    LocalVariableTypeInfo[] localVariableTypeInfoArray =
        targetLocalVariableTypeTableAttribute.localVariableTypeTable;
    LocalVariableTypeInfo localVariableTypeInfo = localVariableTypeInfoArray[3];
    assertNull(localVariableTypeInfo.referencedClasses);
    assertNull(localVariableTypeInfo.getProcessingInfo());
    assertNull(localVariableTypeInfoArray[1]);
    assertNull(localVariableTypeInfoArray[2]);
    assertEquals(0, localVariableTypeInfo.getProcessingFlags());
    assertEquals(0, localVariableTypeInfo.u2nameIndex);
    assertEquals(0, localVariableTypeInfo.u2signatureIndex);
    assertEquals(1, localVariableTypeInfo.u2index);
    assertEquals(1, localVariableTypeInfo.u2startPC);
    assertEquals(3, localVariableTypeInfo.u2length);
    assertEquals(4, localVariableTypeInfoArray.length);
    assertEquals(4, targetLocalVariableTypeTableAttribute.u2localVariableTypeTableLength);
  }
}
