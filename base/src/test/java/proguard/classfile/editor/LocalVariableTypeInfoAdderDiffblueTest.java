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
import proguard.classfile.attribute.LocalVariableTypeInfo;
import proguard.classfile.attribute.LocalVariableTypeTableAttribute;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;

class LocalVariableTypeInfoAdderDiffblueTest {
  /**
   * Test {@link LocalVariableTypeInfoAdder#LocalVariableTypeInfoAdder(ProgramClass,
   * LocalVariableTypeTableAttribute)}.
   *
   * <p>Method under test: {@link
   * LocalVariableTypeInfoAdder#LocalVariableTypeInfoAdder(ProgramClass,
   * LocalVariableTypeTableAttribute)}
   */
  @Test
  @DisplayName("Test new LocalVariableTypeInfoAdder(ProgramClass, LocalVariableTypeTableAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LocalVariableTypeInfoAdder.<init>(ProgramClass, LocalVariableTypeTableAttribute)"
  })
  void testNewLocalVariableTypeInfoAdder() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    LocalVariableTypeTableAttribute targetLocalVariableTypeTableAttribute =
        new LocalVariableTypeTableAttribute();

    // Act
    new LocalVariableTypeInfoAdder(targetClass, targetLocalVariableTypeTableAttribute);

    // Assert that nothing has changed
    assertEquals(0, targetClass.getAccessFlags());
    assertEquals(0, targetClass.getInterfaceCount());
    assertEquals(0, targetClass.getProcessingFlags());
    assertEquals(0, targetLocalVariableTypeTableAttribute.getProcessingFlags());
    assertEquals(0, targetClass.subClasses.length);
    assertEquals(0, targetClass.subClassCount);
    assertEquals(0, targetClass.u2attributesCount);
    assertEquals(0, targetClass.u2constantPoolCount);
    assertEquals(0, targetClass.u2fieldsCount);
    assertEquals(0, targetClass.u2methodsCount);
    assertEquals(0, targetClass.u2superClass);
    assertEquals(0, targetClass.u2thisClass);
    assertEquals(0, targetClass.u4version);
    assertEquals(0, targetLocalVariableTypeTableAttribute.u2attributeNameIndex);
    assertEquals(0, targetLocalVariableTypeTableAttribute.u2localVariableTypeTableLength);
    assertTrue(targetClass.getExtraFeatureNames().isEmpty());
  }

  /**
   * Test {@link LocalVariableTypeInfoAdder#LocalVariableTypeInfoAdder(ProgramClass,
   * LocalVariableTypeTableAttribute)}.
   *
   * <p>Method under test: {@link
   * LocalVariableTypeInfoAdder#LocalVariableTypeInfoAdder(ProgramClass,
   * LocalVariableTypeTableAttribute)}
   */
  @Test
  @DisplayName("Test new LocalVariableTypeInfoAdder(ProgramClass, LocalVariableTypeTableAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LocalVariableTypeInfoAdder.<init>(ProgramClass, LocalVariableTypeTableAttribute)"
  })
  void testNewLocalVariableTypeInfoAdder2() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 2, constantPool, 1, 1, 1);
    LocalVariableTypeTableAttribute targetLocalVariableTypeTableAttribute =
        new LocalVariableTypeTableAttribute();

    // Act
    new LocalVariableTypeInfoAdder(targetClass, targetLocalVariableTypeTableAttribute);

    // Assert that nothing has changed
    assertEquals(0, targetClass.getInterfaceCount());
    assertEquals(0, targetClass.getProcessingFlags());
    assertEquals(0, targetLocalVariableTypeTableAttribute.getProcessingFlags());
    assertEquals(0, targetClass.attributes.length);
    assertEquals(0, targetClass.fields.length);
    assertEquals(0, targetClass.methods.length);
    assertEquals(0, targetClass.subClasses.length);
    assertEquals(0, targetClass.subClassCount);
    assertEquals(0, targetClass.u2attributesCount);
    assertEquals(0, targetClass.u2fieldsCount);
    assertEquals(0, targetClass.u2methodsCount);
    assertEquals(0, targetLocalVariableTypeTableAttribute.u2attributeNameIndex);
    assertEquals(0, targetLocalVariableTypeTableAttribute.u2localVariableTypeTableLength);
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
   * Test {@link LocalVariableTypeInfoAdder#LocalVariableTypeInfoAdder(ProgramClass,
   * LocalVariableTypeTableAttribute)}.
   *
   * <p>Method under test: {@link
   * LocalVariableTypeInfoAdder#LocalVariableTypeInfoAdder(ProgramClass,
   * LocalVariableTypeTableAttribute)}
   */
  @Test
  @DisplayName("Test new LocalVariableTypeInfoAdder(ProgramClass, LocalVariableTypeTableAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LocalVariableTypeInfoAdder.<init>(ProgramClass, LocalVariableTypeTableAttribute)"
  })
  void testNewLocalVariableTypeInfoAdder3() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 1, 1, 1);
    LocalVariableTypeInfo[] localVariableTypeTable =
        new LocalVariableTypeInfo[] {localVariableTypeInfo};
    LocalVariableTypeTableAttribute targetLocalVariableTypeTableAttribute =
        new LocalVariableTypeTableAttribute(1, 3, localVariableTypeTable);

    // Act
    LocalVariableTypeInfoAdder actualLocalVariableTypeInfoAdder =
        new LocalVariableTypeInfoAdder(targetClass, targetLocalVariableTypeTableAttribute);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableTypeInfo localVariableTypeInfo2 = new LocalVariableTypeInfo(1, 3, 1, 1, 1);
    actualLocalVariableTypeInfoAdder.visitLocalVariableTypeInfo(
        clazz, method, codeAttribute, localVariableTypeInfo2);

    // Assert
    assertEquals("Descriptor", method.descriptor);
    assertEquals("Name", method.name);
    assertNull(targetClass.u2interfaces);
    assertNull(clazz.getProcessingInfo());
    assertNull(method.getProcessingInfo());
    assertNull(targetClass.getProcessingInfo());
    assertNull(codeAttribute.getProcessingInfo());
    assertNull(localVariableTypeInfo2.getProcessingInfo());
    assertNull(targetLocalVariableTypeTableAttribute.getProcessingInfo());
    assertNull(clazz.getName());
    assertNull(clazz.getSuperName());
    assertNull(targetClass.getSuperName());
    assertNull(clazz.getFeatureName());
    assertNull(targetClass.getFeatureName());
    assertNull(clazz.interfaceNames);
    assertNull(clazz.getSuperClass());
    assertNull(targetClass.getSuperClass());
    assertNull(method.referencedClasses);
    assertNull(localVariableTypeInfo2.referencedClasses);
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
    assertEquals(0, localVariableTypeInfo2.getProcessingFlags());
    assertEquals(0, targetLocalVariableTypeTableAttribute.getProcessingFlags());
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
    assertEquals(1, targetLocalVariableTypeTableAttribute.u2attributeNameIndex);
    assertEquals(1, localVariableTypeInfo2.u2index);
    assertEquals(1, localVariableTypeInfo2.u2nameIndex);
    assertEquals(1, localVariableTypeInfo2.u2signatureIndex);
    assertEquals(1, localVariableTypeInfo2.u2startPC);
    assertEquals(3, localVariableTypeInfo2.u2length);
    assertEquals(4, targetLocalVariableTypeTableAttribute.localVariableTypeTable.length);
    assertEquals(4, targetLocalVariableTypeTableAttribute.u2localVariableTypeTableLength);
    assertTrue(clazz.getExtraFeatureNames().isEmpty());
    assertTrue(targetClass.getExtraFeatureNames().isEmpty());
    assertArrayEquals(new byte[] {}, codeAttribute.code);
  }

  /**
   * Test {@link LocalVariableTypeInfoAdder#LocalVariableTypeInfoAdder(ProgramClass,
   * LocalVariableTypeTableAttribute)}.
   *
   * <p>Method under test: {@link
   * LocalVariableTypeInfoAdder#LocalVariableTypeInfoAdder(ProgramClass,
   * LocalVariableTypeTableAttribute)}
   */
  @Test
  @DisplayName("Test new LocalVariableTypeInfoAdder(ProgramClass, LocalVariableTypeTableAttribute)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LocalVariableTypeInfoAdder.<init>(ProgramClass, LocalVariableTypeTableAttribute)"
  })
  void testNewLocalVariableTypeInfoAdder4() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    LocalVariableTypeInfo localVariableTypeInfo = new LocalVariableTypeInfo(1, 3, 1, 1, 1);
    LocalVariableTypeInfo[] localVariableTypeTable =
        new LocalVariableTypeInfo[] {localVariableTypeInfo};
    LocalVariableTypeTableAttribute targetLocalVariableTypeTableAttribute =
        new LocalVariableTypeTableAttribute(1, 0, localVariableTypeTable);

    // Act
    LocalVariableTypeInfoAdder actualLocalVariableTypeInfoAdder =
        new LocalVariableTypeInfoAdder(targetClass, targetLocalVariableTypeTableAttribute);
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    CodeAttribute codeAttribute = new CodeAttribute(1);
    LocalVariableTypeInfo localVariableTypeInfo2 = new LocalVariableTypeInfo(1, 3, 1, 1, 1);
    actualLocalVariableTypeInfoAdder.visitLocalVariableTypeInfo(
        clazz, method, codeAttribute, localVariableTypeInfo2);

    // Assert
    assertEquals("Descriptor", method.descriptor);
    assertEquals("Name", method.name);
    assertNull(targetClass.u2interfaces);
    assertNull(clazz.getProcessingInfo());
    assertNull(method.getProcessingInfo());
    assertNull(targetClass.getProcessingInfo());
    assertNull(codeAttribute.getProcessingInfo());
    assertNull(localVariableTypeInfo2.getProcessingInfo());
    assertNull(targetLocalVariableTypeTableAttribute.getProcessingInfo());
    assertNull(clazz.getName());
    assertNull(clazz.getSuperName());
    assertNull(targetClass.getSuperName());
    assertNull(clazz.getFeatureName());
    assertNull(targetClass.getFeatureName());
    assertNull(clazz.interfaceNames);
    assertNull(clazz.getSuperClass());
    assertNull(targetClass.getSuperClass());
    assertNull(method.referencedClasses);
    assertNull(localVariableTypeInfo2.referencedClasses);
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
    assertEquals(0, localVariableTypeInfo2.getProcessingFlags());
    assertEquals(0, targetLocalVariableTypeTableAttribute.getProcessingFlags());
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
    assertEquals(1, targetLocalVariableTypeTableAttribute.localVariableTypeTable.length);
    assertEquals(1, codeAttribute.u2attributeNameIndex);
    assertEquals(1, targetLocalVariableTypeTableAttribute.u2attributeNameIndex);
    assertEquals(1, localVariableTypeInfo2.u2index);
    assertEquals(1, localVariableTypeInfo2.u2nameIndex);
    assertEquals(1, localVariableTypeInfo2.u2signatureIndex);
    assertEquals(1, localVariableTypeInfo2.u2startPC);
    assertEquals(1, targetLocalVariableTypeTableAttribute.u2localVariableTypeTableLength);
    assertEquals(3, localVariableTypeInfo2.u2length);
    assertTrue(clazz.getExtraFeatureNames().isEmpty());
    assertTrue(targetClass.getExtraFeatureNames().isEmpty());
    assertArrayEquals(new byte[] {}, codeAttribute.code);
  }
}
