package proguard.classfile.editor;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.ProgramClass;
import proguard.classfile.attribute.CodeAttribute;
import proguard.classfile.attribute.LocalVariableInfo;
import proguard.classfile.attribute.LocalVariableTableAttribute;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;

class LocalVariableInfoAdderDiffblueTest {
  /**
   * Test {@link LocalVariableInfoAdder#LocalVariableInfoAdder(ProgramClass,
   * LocalVariableTableAttribute)}.
   *
   * <p>Method under test: {@link LocalVariableInfoAdder#LocalVariableInfoAdder(ProgramClass,
   * LocalVariableTableAttribute)}
   */
  @Test
  @DisplayName("Test new LocalVariableInfoAdder(ProgramClass, LocalVariableTableAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LocalVariableInfoAdder.<init>(ProgramClass, LocalVariableTableAttribute)"
  })
  void testNewLocalVariableInfoAdder() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 2, constantPool, 1, 1, 1);
    LocalVariableTableAttribute targetLocalVariableTableAttribute =
        new LocalVariableTableAttribute();

    // Act
    new LocalVariableInfoAdder(targetClass, targetLocalVariableTableAttribute);

    // Assert that nothing has changed
    assertEquals(0, targetClass.getInterfaceCount());
    assertEquals(0, targetClass.getProcessingFlags());
    assertEquals(0, targetLocalVariableTableAttribute.getProcessingFlags());
    assertEquals(0, targetClass.attributes.length);
    assertEquals(0, targetClass.fields.length);
    assertEquals(0, targetClass.methods.length);
    assertEquals(0, targetClass.subClasses.length);
    assertEquals(0, targetClass.subClassCount);
    assertEquals(0, targetClass.u2attributesCount);
    assertEquals(0, targetClass.u2fieldsCount);
    assertEquals(0, targetClass.u2methodsCount);
    assertEquals(0, targetLocalVariableTableAttribute.u2attributeNameIndex);
    assertEquals(0, targetLocalVariableTableAttribute.u2localVariableTableLength);
    assertEquals(1, targetClass.getAccessFlags());
    assertEquals(1, targetClass.constantPool.length);
    assertEquals(1, targetClass.u2superClass);
    assertEquals(1, targetClass.u2thisClass);
    assertEquals(1, targetClass.u4version);
    assertEquals(2, targetClass.u2constantPoolCount);
    assertTrue(targetClass.getExtraFeatureNames().isEmpty());
    assertArrayEquals(new int[] {}, targetClass.u2interfaces);
  }

  /**
   * Test {@link LocalVariableInfoAdder#LocalVariableInfoAdder(ProgramClass,
   * LocalVariableTableAttribute)}.
   *
   * <p>Method under test: {@link LocalVariableInfoAdder#LocalVariableInfoAdder(ProgramClass,
   * LocalVariableTableAttribute)}
   */
  @Test
  @DisplayName("Test new LocalVariableInfoAdder(ProgramClass, LocalVariableTableAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LocalVariableInfoAdder.<init>(ProgramClass, LocalVariableTableAttribute)"
  })
  void testNewLocalVariableInfoAdder2() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    LocalVariableInfo localVariableInfo = new LocalVariableInfo(1, 3, 1, 1, 1);
    LocalVariableInfo[] localVariableTable = new LocalVariableInfo[] {localVariableInfo};
    LocalVariableTableAttribute targetLocalVariableTableAttribute =
        new LocalVariableTableAttribute(1, 3, localVariableTable);

    // Act
    LocalVariableInfoAdder actualLocalVariableInfoAdder =
        new LocalVariableInfoAdder(targetClass, targetLocalVariableTableAttribute);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableInfo localVariableInfo2 = new LocalVariableInfo(1, 3, 1, 1, 1);
    actualLocalVariableInfoAdder.visitLocalVariableInfo(
        clazz, method, codeAttribute, localVariableInfo2);

    // Assert
    assertEquals("Descriptor", method.descriptor);
    assertEquals("Name", method.name);
    assertNull(targetClass.u2interfaces);
    assertNull(clazz.getProcessingInfo());
    assertNull(method.getProcessingInfo());
    assertNull(targetClass.getProcessingInfo());
    assertNull(codeAttribute.getProcessingInfo());
    assertNull(localVariableInfo2.getProcessingInfo());
    assertNull(targetLocalVariableTableAttribute.getProcessingInfo());
    assertNull(clazz.getName());
    assertNull(clazz.getSuperName());
    assertNull(targetClass.getSuperName());
    assertNull(clazz.getFeatureName());
    assertNull(targetClass.getFeatureName());
    assertNull(clazz.interfaceNames);
    assertNull(clazz.getSuperClass());
    assertNull(targetClass.getSuperClass());
    assertNull(localVariableInfo2.referencedClass);
    assertNull(method.referencedClasses);
    assertNull(clazz.fields);
    assertNull(clazz.methods);
    assertNull(targetClass.fields);
    assertNull(targetClass.methods);
    assertNull(targetClass.attributes);
    assertNull(targetClass.constantPool);
    assertNull(clazz.kotlinMetadata);
    assertNull(targetClass.kotlinMetadata);
    assertEquals(0, clazz.getAccessFlags());
    assertEquals(0, clazz.getInterfaceCount());
    assertEquals(0, targetClass.getAccessFlags());
    assertEquals(0, targetClass.getInterfaceCount());
    assertEquals(0, clazz.getProcessingFlags());
    assertEquals(0, method.getProcessingFlags());
    assertEquals(0, targetClass.getProcessingFlags());
    assertEquals(0, codeAttribute.getProcessingFlags());
    assertEquals(0, localVariableInfo2.getProcessingFlags());
    assertEquals(0, targetLocalVariableTableAttribute.getProcessingFlags());
    assertEquals(0, clazz.interfaceClasses.length);
    assertEquals(0, clazz.subClasses.length);
    assertEquals(0, targetClass.subClasses.length);
    assertEquals(0, codeAttribute.attributes.length);
    assertEquals(0, codeAttribute.exceptionTable.length);
    assertEquals(0, clazz.subClassCount);
    assertEquals(0, targetClass.subClassCount);
    assertEquals(0, targetClass.u2attributesCount);
    assertEquals(0, targetClass.u2constantPoolCount);
    assertEquals(0, targetClass.u2fieldsCount);
    assertEquals(0, targetClass.u2methodsCount);
    assertEquals(0, targetClass.u2superClass);
    assertEquals(0, targetClass.u2thisClass);
    assertEquals(0, targetClass.u4version);
    assertEquals(0, codeAttribute.u2attributesCount);
    assertEquals(0, codeAttribute.u2exceptionTableLength);
    assertEquals(0, codeAttribute.u2maxLocals);
    assertEquals(0, codeAttribute.u2maxStack);
    assertEquals(0, codeAttribute.u4codeLength);
    assertEquals(1, method.getAccessFlags());
    assertEquals(1, codeAttribute.u2attributeNameIndex);
    assertEquals(1, targetLocalVariableTableAttribute.u2attributeNameIndex);
    assertEquals(1, localVariableInfo2.u2descriptorIndex);
    assertEquals(1, localVariableInfo2.u2index);
    assertEquals(1, localVariableInfo2.u2nameIndex);
    assertEquals(1, localVariableInfo2.u2startPC);
    assertEquals(3, localVariableInfo2.u2length);
    assertEquals(4, targetLocalVariableTableAttribute.localVariableTable.length);
    assertEquals(4, targetLocalVariableTableAttribute.u2localVariableTableLength);
    assertTrue(clazz.getExtraFeatureNames().isEmpty());
    assertTrue(targetClass.getExtraFeatureNames().isEmpty());
    assertArrayEquals(new byte[] {}, codeAttribute.code);
  }

  /**
   * Test {@link LocalVariableInfoAdder#LocalVariableInfoAdder(ProgramClass,
   * LocalVariableTableAttribute)}.
   *
   * <ul>
   *   <li>When {@link ProgramClass#ProgramClass()}.
   *   <li>Then {@link ProgramClass#ProgramClass()} AccessFlags is zero.
   * </ul>
   *
   * <p>Method under test: {@link LocalVariableInfoAdder#LocalVariableInfoAdder(ProgramClass,
   * LocalVariableTableAttribute)}
   */
  @Test
  @DisplayName(
      "Test new LocalVariableInfoAdder(ProgramClass, LocalVariableTableAttribute); when ProgramClass(); then ProgramClass() AccessFlags is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LocalVariableInfoAdder.<init>(ProgramClass, LocalVariableTableAttribute)"
  })
  void testNewLocalVariableInfoAdder_whenProgramClass_thenProgramClassAccessFlagsIsZero() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    LocalVariableTableAttribute targetLocalVariableTableAttribute =
        new LocalVariableTableAttribute();

    // Act
    new LocalVariableInfoAdder(targetClass, targetLocalVariableTableAttribute);

    // Assert that nothing has changed
    assertEquals(0, targetClass.getAccessFlags());
    assertEquals(0, targetClass.getInterfaceCount());
    assertEquals(0, targetClass.getProcessingFlags());
    assertEquals(0, targetLocalVariableTableAttribute.getProcessingFlags());
    assertEquals(0, targetClass.subClasses.length);
    assertEquals(0, targetClass.subClassCount);
    assertEquals(0, targetClass.u2attributesCount);
    assertEquals(0, targetClass.u2constantPoolCount);
    assertEquals(0, targetClass.u2fieldsCount);
    assertEquals(0, targetClass.u2methodsCount);
    assertEquals(0, targetClass.u2superClass);
    assertEquals(0, targetClass.u2thisClass);
    assertEquals(0, targetClass.u4version);
    assertEquals(0, targetLocalVariableTableAttribute.u2attributeNameIndex);
    assertEquals(0, targetLocalVariableTableAttribute.u2localVariableTableLength);
    assertTrue(targetClass.getExtraFeatureNames().isEmpty());
  }
}
