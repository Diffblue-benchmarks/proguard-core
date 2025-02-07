package proguard.classfile.editor;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.ClassPool;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramField;
import proguard.classfile.ProgramMethod;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.constant.Utf8Constant;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.classfile.visitor.MemberVisitor;

class ClassBuilderDiffblueTest {
  /**
   * Test {@link ClassBuilder#ClassBuilder(ProgramClass, ClassPool, ClassPool)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ProgramClass#ProgramClass()} {@link ProgramClass#u2constantPoolCount} is one.
   * </ul>
   *
   * <p>Method under test: {@link ClassBuilder#ClassBuilder(ProgramClass, ClassPool, ClassPool)}
   */
  @Test
  @DisplayName(
      "Test new ClassBuilder(ProgramClass, ClassPool, ClassPool); given one; when ProgramClass() u2constantPoolCount is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassBuilder.<init>(proguard.classfile.ProgramClass, proguard.classfile.ClassPool, proguard.classfile.ClassPool)"
  })
  void testNewClassBuilder_givenOne_whenProgramClassU2constantPoolCountIsOne() {
    // Arrange
    ProgramClass programClass = new ProgramClass();
    programClass.u2constantPoolCount = 1;

    // Act and Assert
    assertSame(
        programClass,
        (new ClassBuilder(programClass, null, KotlinConstants.dummyClassPool)).getProgramClass());
  }

  /**
   * Test {@link ClassBuilder#ClassBuilder(ProgramClass)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link ProgramClass#ProgramClass()} {@link ProgramClass#u2constantPoolCount} is two.
   * </ul>
   *
   * <p>Method under test: {@link ClassBuilder#ClassBuilder(ProgramClass)}
   */
  @Test
  @DisplayName(
      "Test new ClassBuilder(ProgramClass); given two; when ProgramClass() u2constantPoolCount is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassBuilder.<init>(proguard.classfile.ProgramClass)"
  })
  void testNewClassBuilder_givenTwo_whenProgramClassU2constantPoolCountIsTwo() {
    // Arrange
    ProgramClass programClass = new ProgramClass();
    programClass.u2constantPoolCount = 2;

    // Act and Assert
    assertSame(programClass, (new ClassBuilder(programClass)).getProgramClass());
  }

  /**
   * Test {@link ClassBuilder#ClassBuilder(ProgramClass, ClassPool, ClassPool)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link ProgramClass#ProgramClass()} {@link ProgramClass#u2constantPoolCount} is two.
   * </ul>
   *
   * <p>Method under test: {@link ClassBuilder#ClassBuilder(ProgramClass, ClassPool, ClassPool)}
   */
  @Test
  @DisplayName(
      "Test new ClassBuilder(ProgramClass, ClassPool, ClassPool); given two; when ProgramClass() u2constantPoolCount is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassBuilder.<init>(proguard.classfile.ProgramClass, proguard.classfile.ClassPool, proguard.classfile.ClassPool)"
  })
  void testNewClassBuilder_givenTwo_whenProgramClassU2constantPoolCountIsTwo2() {
    // Arrange
    ProgramClass programClass = new ProgramClass();
    programClass.u2constantPoolCount = 2;

    // Act and Assert
    assertSame(
        programClass,
        (new ClassBuilder(programClass, null, KotlinConstants.dummyClassPool)).getProgramClass());
  }

  /**
   * Test {@link ClassBuilder#ClassBuilder(int, int, String, String)}.
   *
   * <ul>
   *   <li>When {@code Class Name}.
   *   <li>Then fifth element return {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ClassBuilder#ClassBuilder(int, int, String, String)}
   */
  @Test
  @DisplayName(
      "Test new ClassBuilder(int, int, String, String); when 'Class Name'; then fifth element return ClassConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassBuilder.<init>(int, int, java.lang.String, java.lang.String)"
  })
  void testNewClassBuilder_whenClassName_thenFifthElementReturnClassConstant() {
    // Arrange and Act
    ClassBuilder actualClassBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");

    // Assert
    ProgramClass programClass = actualClassBuilder.getProgramClass();
    Constant[] constantArray = programClass.constantPool;
    assertTrue(constantArray[4] instanceof ClassConstant);
    assertTrue(constantArray[3] instanceof Utf8Constant);
    assertEquals("Superclass Name", programClass.getSuperName());
    assertEquals(4, programClass.u2superClass);
    assertEquals(5, programClass.u2constantPoolCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    assertSame(programClass, actualClassBuilder.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Test {@link ClassBuilder#ClassBuilder(int, int, String, String, String, int, Object)}.
   *
   * <ul>
   *   <li>When {@code Class Name}.
   *   <li>Then fifth element return {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ClassBuilder#ClassBuilder(int, int, String, String, String, int,
   * Object)}
   */
  @Test
  @DisplayName(
      "Test new ClassBuilder(int, int, String, String, String, int, Object); when 'Class Name'; then fifth element return ClassConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassBuilder.<init>(int, int, java.lang.String, java.lang.String, java.lang.String, int, java.lang.Object)"
  })
  void testNewClassBuilder_whenClassName_thenFifthElementReturnClassConstant2() {
    // Arrange and Act
    ClassBuilder actualClassBuilder =
        new ClassBuilder(
            1, 1, "Class Name", "Superclass Name", "Feature Name", 1, "Processing Info");

    // Assert
    ProgramClass programClass = actualClassBuilder.getProgramClass();
    Constant[] constantArray = programClass.constantPool;
    assertTrue(constantArray[4] instanceof ClassConstant);
    assertTrue(constantArray[3] instanceof Utf8Constant);
    assertEquals("Superclass Name", programClass.getSuperName());
    assertEquals(4, programClass.u2superClass);
    assertEquals(5, programClass.u2constantPoolCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    assertSame(programClass, actualClassBuilder.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Test {@link ClassBuilder#ClassBuilder(int, int, String, String)}.
   *
   * <ul>
   *   <li>When {@code Class Name}.
   *   <li>Then return ProgramClass SuperName is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ClassBuilder#ClassBuilder(int, int, String, String)}
   */
  @Test
  @DisplayName(
      "Test new ClassBuilder(int, int, String, String); when 'Class Name'; then return ProgramClass SuperName is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassBuilder.<init>(int, int, java.lang.String, java.lang.String)"
  })
  void testNewClassBuilder_whenClassName_thenReturnProgramClassSuperNameIsNull()
      throws UnsupportedEncodingException {
    // Arrange and Act
    ClassBuilder actualClassBuilder = new ClassBuilder(1, 1, "Class Name", null);

    // Assert
    ProgramClass programClass = actualClassBuilder.getProgramClass();
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[2];
    assertTrue(constant instanceof ClassConstant);
    Constant constant2 = constantArray[1];
    assertTrue(constant2 instanceof Utf8Constant);
    assertNull(programClass.getSuperName());
    assertEquals(0, programClass.u2superClass);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    assertSame(programClass, actualClassBuilder.getConstantPoolEditor().getTargetClass());
    assertSame(programClass, ((ClassConstant) constant).referencedClass);
    byte[] expectedBytes = "Class Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
  }

  /**
   * Test {@link ClassBuilder#ClassBuilder(int, int, String, String, String, int, Object)}.
   *
   * <ul>
   *   <li>When {@code Class Name}.
   *   <li>Then third element return {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ClassBuilder#ClassBuilder(int, int, String, String, String, int,
   * Object)}
   */
  @Test
  @DisplayName(
      "Test new ClassBuilder(int, int, String, String, String, int, Object); when 'Class Name'; then third element return ClassConstant")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassBuilder.<init>(int, int, java.lang.String, java.lang.String, java.lang.String, int, java.lang.Object)"
  })
  void testNewClassBuilder_whenClassName_thenThirdElementReturnClassConstant()
      throws UnsupportedEncodingException {
    // Arrange and Act
    ClassBuilder actualClassBuilder =
        new ClassBuilder(1, 1, "Class Name", null, "Feature Name", 1, "Processing Info");

    // Assert
    ProgramClass programClass = actualClassBuilder.getProgramClass();
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[2];
    assertTrue(constant instanceof ClassConstant);
    Constant constant2 = constantArray[1];
    assertTrue(constant2 instanceof Utf8Constant);
    assertNull(programClass.getSuperName());
    assertNull(constantArray[3]);
    assertNull(constantArray[4]);
    assertEquals(0, programClass.u2superClass);
    assertEquals(3, programClass.u2constantPoolCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    assertSame(programClass, actualClassBuilder.getConstantPoolEditor().getTargetClass());
    assertSame(programClass, ((ClassConstant) constant).referencedClass);
    byte[] expectedBytes = "Class Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
  }

  /**
   * Test {@link ClassBuilder#ClassBuilder(ProgramClass)}.
   *
   * <ul>
   *   <li>When {@link ProgramClass#ProgramClass()}.
   *   <li>Then return ProgramClass is {@link ProgramClass#ProgramClass()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassBuilder#ClassBuilder(ProgramClass)}
   */
  @Test
  @DisplayName(
      "Test new ClassBuilder(ProgramClass); when ProgramClass(); then return ProgramClass is ProgramClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassBuilder.<init>(proguard.classfile.ProgramClass)"
  })
  void testNewClassBuilder_whenProgramClass_thenReturnProgramClassIsProgramClass() {
    // Arrange
    ProgramClass programClass = new ProgramClass();

    // Act and Assert
    assertSame(programClass, (new ClassBuilder(programClass)).getProgramClass());
  }

  /**
   * Test {@link ClassBuilder#ClassBuilder(ProgramClass, ClassPool, ClassPool)}.
   *
   * <ul>
   *   <li>When {@link ProgramClass#ProgramClass()}.
   *   <li>Then return ProgramClass is {@link ProgramClass#ProgramClass()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassBuilder#ClassBuilder(ProgramClass, ClassPool, ClassPool)}
   */
  @Test
  @DisplayName(
      "Test new ClassBuilder(ProgramClass, ClassPool, ClassPool); when ProgramClass(); then return ProgramClass is ProgramClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassBuilder.<init>(proguard.classfile.ProgramClass, proguard.classfile.ClassPool, proguard.classfile.ClassPool)"
  })
  void testNewClassBuilder_whenProgramClass_thenReturnProgramClassIsProgramClass2() {
    // Arrange
    ProgramClass programClass = new ProgramClass();

    // Act and Assert
    assertSame(
        programClass,
        (new ClassBuilder(
                programClass, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool))
            .getProgramClass());
  }

  /**
   * Test {@link ClassBuilder#ClassBuilder(int, int, String, String)}.
   *
   * <ul>
   *   <li>When {@code Test.class}.
   *   <li>Then return ProgramClass Name is {@code Test.class}.
   * </ul>
   *
   * <p>Method under test: {@link ClassBuilder#ClassBuilder(int, int, String, String)}
   */
  @Test
  @DisplayName(
      "Test new ClassBuilder(int, int, String, String); when 'Test.class'; then return ProgramClass Name is 'Test.class'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ClassBuilder.<init>(int, int, java.lang.String, java.lang.String)"
  })
  void testNewClassBuilder_whenTestClass_thenReturnProgramClassNameIsTestClass()
      throws UnsupportedEncodingException {
    // Arrange and Act
    ClassBuilder actualClassBuilder = new ClassBuilder(1, 1, "Test.class", "Test.class");

    // Assert
    ProgramClass programClass = actualClassBuilder.getProgramClass();
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[2];
    assertTrue(constant instanceof ClassConstant);
    Constant constant2 = constantArray[1];
    assertTrue(constant2 instanceof Utf8Constant);
    assertEquals("Test.class", programClass.getName());
    assertEquals("Test.class", programClass.getSuperName());
    assertEquals("Test.class", ((Utf8Constant) constant2).getString());
    assertEquals(2, programClass.u2superClass);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    assertSame(programClass, programClass.getSuperClass());
    assertSame(programClass, actualClassBuilder.getConstantPoolEditor().getTargetClass());
    assertSame(programClass, ((ClassConstant) constant).referencedClass);
    byte[] expectedBytes = "Test.class".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ClassBuilder#getConstantPoolEditor()}
   *   <li>{@link ClassBuilder#getProgramClass()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.ConstantPoolEditor proguard.classfile.editor.ClassBuilder.getConstantPoolEditor()",
    "proguard.classfile.ProgramClass proguard.classfile.editor.ClassBuilder.getProgramClass()"
  })
  void testGettersAndSetters() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");

    // Act
    ConstantPoolEditor actualConstantPoolEditor = classBuilder.getConstantPoolEditor();
    ProgramClass actualProgramClass = classBuilder.getProgramClass();

    // Assert
    ProgramClass targetClass = actualConstantPoolEditor.getTargetClass();
    assertEquals("Class Name", targetClass.getName());
    assertEquals("Superclass Name", targetClass.getSuperName());
    assertNull(targetClass.getProcessingInfo());
    assertNull(targetClass.getFeatureName());
    assertNull(targetClass.getSuperClass());
    assertNull(targetClass.kotlinMetadata);
    assertEquals(0, targetClass.getInterfaceCount());
    assertEquals(0, targetClass.getProcessingFlags());
    Attribute[] attributeArray = targetClass.attributes;
    assertEquals(0, attributeArray.length);
    ProgramField[] programFieldArray = targetClass.fields;
    assertEquals(0, programFieldArray.length);
    ProgramMethod[] programMethodArray = targetClass.methods;
    assertEquals(0, programMethodArray.length);
    Clazz[] clazzArray = targetClass.subClasses;
    assertEquals(0, clazzArray.length);
    assertEquals(0, targetClass.subClassCount);
    assertEquals(0, targetClass.u2attributesCount);
    assertEquals(0, targetClass.u2fieldsCount);
    assertEquals(0, targetClass.u2methodsCount);
    assertEquals(1, targetClass.getAccessFlags());
    assertEquals(1, targetClass.u4version);
    assertEquals(2, targetClass.u2thisClass);
    assertEquals(4, targetClass.u2superClass);
    assertEquals(5, targetClass.u2constantPoolCount);
    assertTrue(targetClass.getExtraFeatureNames().isEmpty());
    assertSame(targetClass, actualProgramClass);
    assertSame(actualProgramClass.attributes, attributeArray);
    assertSame(actualProgramClass.constantPool, targetClass.constantPool);
    assertSame(actualProgramClass.fields, programFieldArray);
    assertSame(actualProgramClass.methods, programMethodArray);
    assertSame(actualProgramClass.subClasses, clazzArray);
    int[] intArray = targetClass.u2interfaces;
    assertSame(actualProgramClass.u2interfaces, intArray);
    assertArrayEquals(new int[] {}, intArray);
  }

  /**
   * Test {@link ClassBuilder#addInterface(Clazz)} with {@code interfaceClass}.
   *
   * <p>Method under test: {@link ClassBuilder#addInterface(Clazz)}
   */
  @Test
  @DisplayName("Test addInterface(Clazz) with 'interfaceClass'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.ClassBuilder proguard.classfile.editor.ClassBuilder.addInterface(proguard.classfile.Clazz)"
  })
  void testAddInterfaceWithInterfaceClass() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");

    // Act and Assert
    assertSame(
        classBuilder,
        classBuilder.addInterface(new LibraryClass(5, "This Class Name", "Super Class Name")));
  }

  /**
   * Test {@link ClassBuilder#addInterface(String, Clazz)} with {@code interfaceName}, {@code
   * referencedInterface}.
   *
   * <p>Method under test: {@link ClassBuilder#addInterface(String, Clazz)}
   */
  @Test
  @DisplayName("Test addInterface(String, Clazz) with 'interfaceName', 'referencedInterface'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.ClassBuilder proguard.classfile.editor.ClassBuilder.addInterface(java.lang.String, proguard.classfile.Clazz)"
  })
  void testAddInterfaceWithInterfaceNameReferencedInterface() throws UnsupportedEncodingException {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");
    LibraryClass referencedInterface = new LibraryClass();

    // Act and Assert
    ProgramClass programClass =
        classBuilder.addInterface("Interface Name", referencedInterface).getProgramClass();
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[6];
    Clazz clazz = ((ClassConstant) constant).referencedClass;
    assertTrue(clazz instanceof LibraryClass);
    assertTrue(constant instanceof ClassConstant);
    Constant constant2 = constantArray[1];
    assertTrue(constant2 instanceof Utf8Constant);
    Constant constant3 = constantArray[3];
    assertTrue(constant3 instanceof Utf8Constant);
    Constant constant4 = constantArray[5];
    assertTrue(constant4 instanceof Utf8Constant);
    assertEquals(1, programClass.getInterfaceCount());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    assertSame(referencedInterface, clazz);
    byte[] expectedBytes = "Class Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
    byte[] expectedBytes2 = "Interface Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant4).getBytes());
    byte[] expectedBytes3 = "Superclass Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes3, ((Utf8Constant) constant3).getBytes());
    assertArrayEquals(new int[] {6}, programClass.u2interfaces);
  }

  /**
   * Test {@link ClassBuilder#addInterface(String, Clazz)} with {@code interfaceName}, {@code
   * referencedInterface}.
   *
   * <p>Method under test: {@link ClassBuilder#addInterface(String, Clazz)}
   */
  @Test
  @DisplayName("Test addInterface(String, Clazz) with 'interfaceName', 'referencedInterface'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.ClassBuilder proguard.classfile.editor.ClassBuilder.addInterface(java.lang.String, proguard.classfile.Clazz)"
  })
  void testAddInterfaceWithInterfaceNameReferencedInterface2() throws UnsupportedEncodingException {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");
    classBuilder.addInterface("Interface Name");

    // Act and Assert
    ProgramClass programClass =
        classBuilder.addInterface("Interface Name", new LibraryClass()).getProgramClass();
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[6];
    assertTrue(constant instanceof ClassConstant);
    Constant constant2 = constantArray[1];
    assertTrue(constant2 instanceof Utf8Constant);
    Constant constant3 = constantArray[3];
    assertTrue(constant3 instanceof Utf8Constant);
    Constant constant4 = constantArray[5];
    assertTrue(constant4 instanceof Utf8Constant);
    assertNull(((ClassConstant) constant).referencedClass);
    assertEquals(2, programClass.getInterfaceCount());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    byte[] expectedBytes = "Class Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
    byte[] expectedBytes2 = "Interface Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant4).getBytes());
    byte[] expectedBytes3 = "Superclass Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes3, ((Utf8Constant) constant3).getBytes());
    assertArrayEquals(new int[] {6, 6}, programClass.u2interfaces);
  }

  /**
   * Test {@link ClassBuilder#addInterface(String)} with {@code interfaceName}.
   *
   * <ul>
   *   <li>Then return ProgramClass InterfaceCount is one.
   * </ul>
   *
   * <p>Method under test: {@link ClassBuilder#addInterface(String)}
   */
  @Test
  @DisplayName(
      "Test addInterface(String) with 'interfaceName'; then return ProgramClass InterfaceCount is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.ClassBuilder proguard.classfile.editor.ClassBuilder.addInterface(java.lang.String)"
  })
  void testAddInterfaceWithInterfaceName_thenReturnProgramClassInterfaceCountIsOne()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    ProgramClass programClass =
        (new ClassBuilder(1, 1, "Class Name", "Superclass Name"))
            .addInterface("Interface Name")
            .getProgramClass();
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof Utf8Constant);
    Constant constant2 = constantArray[3];
    assertTrue(constant2 instanceof Utf8Constant);
    Constant constant3 = constantArray[5];
    assertTrue(constant3 instanceof Utf8Constant);
    assertEquals(1, programClass.getInterfaceCount());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    byte[] expectedBytes = "Class Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant).getBytes());
    byte[] expectedBytes2 = "Interface Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant3).getBytes());
    byte[] expectedBytes3 = "Superclass Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes3, ((Utf8Constant) constant2).getBytes());
    assertArrayEquals(new int[] {6}, programClass.u2interfaces);
  }

  /**
   * Test {@link ClassBuilder#addInterface(String)} with {@code interfaceName}.
   *
   * <ul>
   *   <li>Then return ProgramClass InterfaceCount is two.
   * </ul>
   *
   * <p>Method under test: {@link ClassBuilder#addInterface(String)}
   */
  @Test
  @DisplayName(
      "Test addInterface(String) with 'interfaceName'; then return ProgramClass InterfaceCount is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.ClassBuilder proguard.classfile.editor.ClassBuilder.addInterface(java.lang.String)"
  })
  void testAddInterfaceWithInterfaceName_thenReturnProgramClassInterfaceCountIsTwo()
      throws UnsupportedEncodingException {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");
    classBuilder.addInterface("Interface Name");

    // Act and Assert
    ProgramClass programClass = classBuilder.addInterface("Interface Name").getProgramClass();
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof Utf8Constant);
    Constant constant2 = constantArray[3];
    assertTrue(constant2 instanceof Utf8Constant);
    Constant constant3 = constantArray[5];
    assertTrue(constant3 instanceof Utf8Constant);
    assertEquals(2, programClass.getInterfaceCount());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    byte[] expectedBytes = "Class Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant).getBytes());
    byte[] expectedBytes2 = "Interface Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant3).getBytes());
    byte[] expectedBytes3 = "Superclass Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes3, ((Utf8Constant) constant2).getBytes());
    assertArrayEquals(new int[] {6, 6}, programClass.u2interfaces);
  }

  /**
   * Test {@link ClassBuilder#addField(int, String, String, MemberVisitor)} with {@code
   * u2accessFlags}, {@code fieldName}, {@code fieldDescriptor}, {@code extraMemberVisitor}.
   *
   * <p>Method under test: {@link ClassBuilder#addField(int, String, String, MemberVisitor)}
   */
  @Test
  @DisplayName(
      "Test addField(int, String, String, MemberVisitor) with 'u2accessFlags', 'fieldName', 'fieldDescriptor', 'extraMemberVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.ClassBuilder proguard.classfile.editor.ClassBuilder.addField(int, java.lang.String, java.lang.String, proguard.classfile.visitor.MemberVisitor)"
  })
  void testAddFieldWithU2accessFlagsFieldNameFieldDescriptorExtraMemberVisitor()
      throws UnsupportedEncodingException {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");

    // Act and Assert
    ProgramClass programClass =
        classBuilder
            .addField(2, "Field Name", "Field Descriptor", new AttributeSorter())
            .getProgramClass();
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof Utf8Constant);
    Constant constant2 = constantArray[3];
    assertTrue(constant2 instanceof Utf8Constant);
    Constant constant3 = constantArray[5];
    assertTrue(constant3 instanceof Utf8Constant);
    Constant constant4 = constantArray[6];
    assertTrue(constant4 instanceof Utf8Constant);
    assertEquals(1, programClass.fields.length);
    assertEquals(1, programClass.u2fieldsCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    byte[] expectedBytes = "Class Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant).getBytes());
    byte[] expectedBytes2 = "Field Descriptor".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant4).getBytes());
    byte[] expectedBytes3 = "Field Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes3, ((Utf8Constant) constant3).getBytes());
    byte[] expectedBytes4 = "Superclass Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes4, ((Utf8Constant) constant2).getBytes());
  }

  /**
   * Test {@link ClassBuilder#addField(int, String, String, MemberVisitor)} with {@code
   * u2accessFlags}, {@code fieldName}, {@code fieldDescriptor}, {@code extraMemberVisitor}.
   *
   * <p>Method under test: {@link ClassBuilder#addField(int, String, String, MemberVisitor)}
   */
  @Test
  @DisplayName(
      "Test addField(int, String, String, MemberVisitor) with 'u2accessFlags', 'fieldName', 'fieldDescriptor', 'extraMemberVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.ClassBuilder proguard.classfile.editor.ClassBuilder.addField(int, java.lang.String, java.lang.String, proguard.classfile.visitor.MemberVisitor)"
  })
  void testAddFieldWithU2accessFlagsFieldNameFieldDescriptorExtraMemberVisitor2() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");
    classBuilder.addField(2, "Field Name", "Field Descriptor");

    // Act and Assert
    ProgramClass programClass =
        classBuilder
            .addField(2, "Field Name", "Field Descriptor", new AttributeSorter())
            .getProgramClass();
    Constant[] constantArray = programClass.constantPool;
    assertTrue(constantArray[1] instanceof Utf8Constant);
    assertTrue(constantArray[3] instanceof Utf8Constant);
    assertTrue(constantArray[5] instanceof Utf8Constant);
    assertTrue(constantArray[6] instanceof Utf8Constant);
    assertEquals(2, programClass.fields.length);
    assertEquals(2, programClass.u2fieldsCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link ClassBuilder#addField(int, String, String)} with {@code u2accessFlags}, {@code
   * fieldName}, {@code fieldDescriptor}.
   *
   * <ul>
   *   <li>Then return array length is one.
   * </ul>
   *
   * <p>Method under test: {@link ClassBuilder#addField(int, String, String)}
   */
  @Test
  @DisplayName(
      "Test addField(int, String, String) with 'u2accessFlags', 'fieldName', 'fieldDescriptor'; then return array length is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.ClassBuilder proguard.classfile.editor.ClassBuilder.addField(int, java.lang.String, java.lang.String)"
  })
  void testAddFieldWithU2accessFlagsFieldNameFieldDescriptor_thenReturnArrayLengthIsOne()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    ProgramClass programClass =
        (new ClassBuilder(1, 1, "Class Name", "Superclass Name"))
            .addField(2, "Field Name", "Field Descriptor")
            .getProgramClass();
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof Utf8Constant);
    Constant constant2 = constantArray[3];
    assertTrue(constant2 instanceof Utf8Constant);
    Constant constant3 = constantArray[5];
    assertTrue(constant3 instanceof Utf8Constant);
    Constant constant4 = constantArray[6];
    assertTrue(constant4 instanceof Utf8Constant);
    assertEquals(1, programClass.fields.length);
    assertEquals(1, programClass.u2fieldsCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    byte[] expectedBytes = "Class Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant).getBytes());
    byte[] expectedBytes2 = "Field Descriptor".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant4).getBytes());
    byte[] expectedBytes3 = "Field Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes3, ((Utf8Constant) constant3).getBytes());
    byte[] expectedBytes4 = "Superclass Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes4, ((Utf8Constant) constant2).getBytes());
  }

  /**
   * Test {@link ClassBuilder#addField(int, String, String)} with {@code u2accessFlags}, {@code
   * fieldName}, {@code fieldDescriptor}.
   *
   * <ul>
   *   <li>Then return array length is two.
   * </ul>
   *
   * <p>Method under test: {@link ClassBuilder#addField(int, String, String)}
   */
  @Test
  @DisplayName(
      "Test addField(int, String, String) with 'u2accessFlags', 'fieldName', 'fieldDescriptor'; then return array length is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.ClassBuilder proguard.classfile.editor.ClassBuilder.addField(int, java.lang.String, java.lang.String)"
  })
  void testAddFieldWithU2accessFlagsFieldNameFieldDescriptor_thenReturnArrayLengthIsTwo() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");
    classBuilder.addField(2, "Field Name", "Field Descriptor");

    // Act and Assert
    ProgramClass programClass =
        classBuilder.addField(2, "Field Name", "Field Descriptor").getProgramClass();
    Constant[] constantArray = programClass.constantPool;
    assertTrue(constantArray[1] instanceof Utf8Constant);
    assertTrue(constantArray[3] instanceof Utf8Constant);
    assertTrue(constantArray[5] instanceof Utf8Constant);
    assertTrue(constantArray[6] instanceof Utf8Constant);
    assertEquals(2, programClass.fields.length);
    assertEquals(2, programClass.u2fieldsCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link ClassBuilder#addAndReturnField(int, String, String)}.
   *
   * <ul>
   *   <li>Then array length is one.
   * </ul>
   *
   * <p>Method under test: {@link ClassBuilder#addAndReturnField(int, String, String)}
   */
  @Test
  @DisplayName("Test addAndReturnField(int, String, String); then array length is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ProgramField proguard.classfile.editor.ClassBuilder.addAndReturnField(int, java.lang.String, java.lang.String)"
  })
  void testAddAndReturnField_thenArrayLengthIsOne() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");

    // Act
    classBuilder.addAndReturnField(2, "Field Name", "Field Descriptor");

    // Assert
    ProgramClass programClass = classBuilder.getProgramClass();
    Constant[] constantArray = programClass.constantPool;
    assertTrue(constantArray[5] instanceof Utf8Constant);
    assertTrue(constantArray[6] instanceof Utf8Constant);
    assertEquals(1, programClass.fields.length);
    assertEquals(1, programClass.u2fieldsCount);
    assertEquals(7, programClass.u2constantPoolCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link ClassBuilder#addAndReturnField(int, String, String)}.
   *
   * <ul>
   *   <li>Then array length is two.
   * </ul>
   *
   * <p>Method under test: {@link ClassBuilder#addAndReturnField(int, String, String)}
   */
  @Test
  @DisplayName("Test addAndReturnField(int, String, String); then array length is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ProgramField proguard.classfile.editor.ClassBuilder.addAndReturnField(int, java.lang.String, java.lang.String)"
  })
  void testAddAndReturnField_thenArrayLengthIsTwo() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");
    classBuilder.addField(2, "Field Name", "Field Descriptor");

    // Act
    classBuilder.addAndReturnField(2, "Field Name", "Field Descriptor");

    // Assert
    ProgramClass programClass = classBuilder.getProgramClass();
    Constant[] constantArray = programClass.constantPool;
    assertTrue(constantArray[5] instanceof Utf8Constant);
    assertTrue(constantArray[6] instanceof Utf8Constant);
    assertEquals(2, programClass.fields.length);
    assertEquals(2, programClass.u2fieldsCount);
    assertEquals(7, programClass.u2constantPoolCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link ClassBuilder#addMethod(int, String, String)} with {@code u2accessFlags}, {@code
   * methodName}, {@code methodDescriptor}.
   *
   * <p>Method under test: {@link ClassBuilder#addMethod(int, String, String)}
   */
  @Test
  @DisplayName(
      "Test addMethod(int, String, String) with 'u2accessFlags', 'methodName', 'methodDescriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.ClassBuilder proguard.classfile.editor.ClassBuilder.addMethod(int, java.lang.String, java.lang.String)"
  })
  void testAddMethodWithU2accessFlagsMethodNameMethodDescriptor()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    ProgramClass programClass =
        (new ClassBuilder(1, 1, "Class Name", "Superclass Name"))
            .addMethod(2, "Method Name", "Method Descriptor")
            .getProgramClass();
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof Utf8Constant);
    Constant constant2 = constantArray[3];
    assertTrue(constant2 instanceof Utf8Constant);
    Constant constant3 = constantArray[5];
    assertTrue(constant3 instanceof Utf8Constant);
    Constant constant4 = constantArray[6];
    assertTrue(constant4 instanceof Utf8Constant);
    assertEquals(1, programClass.methods.length);
    assertEquals(1, programClass.u2methodsCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    byte[] expectedBytes = "Class Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant).getBytes());
    byte[] expectedBytes2 = "Method Descriptor".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant4).getBytes());
    byte[] expectedBytes3 = "Method Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes3, ((Utf8Constant) constant3).getBytes());
    byte[] expectedBytes4 = "Superclass Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes4, ((Utf8Constant) constant2).getBytes());
  }

  /**
   * Test {@link ClassBuilder#addMethod(int, String, String)} with {@code u2accessFlags}, {@code
   * methodName}, {@code methodDescriptor}.
   *
   * <p>Method under test: {@link ClassBuilder#addMethod(int, String, String)}
   */
  @Test
  @DisplayName(
      "Test addMethod(int, String, String) with 'u2accessFlags', 'methodName', 'methodDescriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.ClassBuilder proguard.classfile.editor.ClassBuilder.addMethod(int, java.lang.String, java.lang.String)"
  })
  void testAddMethodWithU2accessFlagsMethodNameMethodDescriptor2() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");
    classBuilder.addMethod(2, "Method Name", "Method Descriptor");

    // Act and Assert
    ProgramClass programClass =
        classBuilder.addMethod(2, "Method Name", "Method Descriptor").getProgramClass();
    Constant[] constantArray = programClass.constantPool;
    assertTrue(constantArray[1] instanceof Utf8Constant);
    assertTrue(constantArray[3] instanceof Utf8Constant);
    assertTrue(constantArray[5] instanceof Utf8Constant);
    assertTrue(constantArray[6] instanceof Utf8Constant);
    assertEquals(2, programClass.methods.length);
    assertEquals(2, programClass.u2methodsCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link ClassBuilder#addMethod(int, String, String, MemberVisitor)} with {@code
   * u2accessFlags}, {@code methodName}, {@code methodDescriptor}, {@code extraMemberVisitor}.
   *
   * <p>Method under test: {@link ClassBuilder#addMethod(int, String, String, MemberVisitor)}
   */
  @Test
  @DisplayName(
      "Test addMethod(int, String, String, MemberVisitor) with 'u2accessFlags', 'methodName', 'methodDescriptor', 'extraMemberVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.ClassBuilder proguard.classfile.editor.ClassBuilder.addMethod(int, java.lang.String, java.lang.String, proguard.classfile.visitor.MemberVisitor)"
  })
  void testAddMethodWithU2accessFlagsMethodNameMethodDescriptorExtraMemberVisitor()
      throws UnsupportedEncodingException {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");

    // Act and Assert
    ProgramClass programClass =
        classBuilder
            .addMethod(2, "Method Name", "Method Descriptor", new AttributeSorter())
            .getProgramClass();
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof Utf8Constant);
    Constant constant2 = constantArray[3];
    assertTrue(constant2 instanceof Utf8Constant);
    Constant constant3 = constantArray[5];
    assertTrue(constant3 instanceof Utf8Constant);
    Constant constant4 = constantArray[6];
    assertTrue(constant4 instanceof Utf8Constant);
    assertEquals(1, programClass.methods.length);
    assertEquals(1, programClass.u2methodsCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    byte[] expectedBytes = "Class Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant).getBytes());
    byte[] expectedBytes2 = "Method Descriptor".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant4).getBytes());
    byte[] expectedBytes3 = "Method Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes3, ((Utf8Constant) constant3).getBytes());
    byte[] expectedBytes4 = "Superclass Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes4, ((Utf8Constant) constant2).getBytes());
  }

  /**
   * Test {@link ClassBuilder#addMethod(int, String, String, MemberVisitor)} with {@code
   * u2accessFlags}, {@code methodName}, {@code methodDescriptor}, {@code extraMemberVisitor}.
   *
   * <p>Method under test: {@link ClassBuilder#addMethod(int, String, String, MemberVisitor)}
   */
  @Test
  @DisplayName(
      "Test addMethod(int, String, String, MemberVisitor) with 'u2accessFlags', 'methodName', 'methodDescriptor', 'extraMemberVisitor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.editor.ClassBuilder proguard.classfile.editor.ClassBuilder.addMethod(int, java.lang.String, java.lang.String, proguard.classfile.visitor.MemberVisitor)"
  })
  void testAddMethodWithU2accessFlagsMethodNameMethodDescriptorExtraMemberVisitor2() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");
    classBuilder.addMethod(2, "Method Name", "Method Descriptor");

    // Act and Assert
    ProgramClass programClass =
        classBuilder
            .addMethod(2, "Method Name", "Method Descriptor", new AttributeSorter())
            .getProgramClass();
    Constant[] constantArray = programClass.constantPool;
    assertTrue(constantArray[1] instanceof Utf8Constant);
    assertTrue(constantArray[3] instanceof Utf8Constant);
    assertTrue(constantArray[5] instanceof Utf8Constant);
    assertTrue(constantArray[6] instanceof Utf8Constant);
    assertEquals(2, programClass.methods.length);
    assertEquals(2, programClass.u2methodsCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link ClassBuilder#addAndReturnMethod(int, String, String)} with {@code u2accessFlags},
   * {@code methodName}, {@code methodDescriptor}.
   *
   * <p>Method under test: {@link ClassBuilder#addAndReturnMethod(int, String, String)}
   */
  @Test
  @DisplayName(
      "Test addAndReturnMethod(int, String, String) with 'u2accessFlags', 'methodName', 'methodDescriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ProgramMethod proguard.classfile.editor.ClassBuilder.addAndReturnMethod(int, java.lang.String, java.lang.String)"
  })
  void testAddAndReturnMethodWithU2accessFlagsMethodNameMethodDescriptor() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");

    // Act
    classBuilder.addAndReturnMethod(2, "Method Name", "Method Descriptor");

    // Assert
    ProgramClass programClass = classBuilder.getProgramClass();
    Constant[] constantArray = programClass.constantPool;
    assertTrue(constantArray[5] instanceof Utf8Constant);
    assertTrue(constantArray[6] instanceof Utf8Constant);
    assertEquals(1, programClass.methods.length);
    assertEquals(1, programClass.u2methodsCount);
    assertEquals(7, programClass.u2constantPoolCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link ClassBuilder#addAndReturnMethod(int, String, String)} with {@code u2accessFlags},
   * {@code methodName}, {@code methodDescriptor}.
   *
   * <p>Method under test: {@link ClassBuilder#addAndReturnMethod(int, String, String)}
   */
  @Test
  @DisplayName(
      "Test addAndReturnMethod(int, String, String) with 'u2accessFlags', 'methodName', 'methodDescriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.ProgramMethod proguard.classfile.editor.ClassBuilder.addAndReturnMethod(int, java.lang.String, java.lang.String)"
  })
  void testAddAndReturnMethodWithU2accessFlagsMethodNameMethodDescriptor2() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");
    classBuilder.addMethod(2, "Method Name", "Method Descriptor");

    // Act
    classBuilder.addAndReturnMethod(2, "Method Name", "Method Descriptor");

    // Assert
    ProgramClass programClass = classBuilder.getProgramClass();
    Constant[] constantArray = programClass.constantPool;
    assertTrue(constantArray[5] instanceof Utf8Constant);
    assertTrue(constantArray[6] instanceof Utf8Constant);
    assertEquals(2, programClass.methods.length);
    assertEquals(2, programClass.u2methodsCount);
    assertEquals(7, programClass.u2constantPoolCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }
}
