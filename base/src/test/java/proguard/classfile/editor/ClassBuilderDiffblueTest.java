package proguard.classfile.editor;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.analysis.PartialEvaluatorErrorsTestKt;
import proguard.classfile.ClassPool;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramField;
import proguard.classfile.ProgramMember;
import proguard.classfile.ProgramMethod;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.constant.Utf8Constant;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.classfile.visitor.MemberVisitor;

class ClassBuilderDiffblueTest {
  /**
   * Test {@link ClassBuilder#ClassBuilder(ProgramClass)}.
   *
   * <p>Method under test: {@link ClassBuilder#ClassBuilder(ProgramClass)}
   */
  @Test
  @DisplayName("Test new ClassBuilder(ProgramClass)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassBuilder.<init>(ProgramClass)"})
  void testNewClassBuilder() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass programClass = new ProgramClass(1, 2, constantPool, 1, 1, 1);

    // Act
    ClassBuilder actualClassBuilder = new ClassBuilder(programClass);

    // Assert
    assertSame(programClass, actualClassBuilder.getProgramClass());
    assertSame(programClass, actualClassBuilder.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Test {@link ClassBuilder#ClassBuilder(ProgramClass, ClassPool, ClassPool)}.
   *
   * <p>Method under test: {@link ClassBuilder#ClassBuilder(ProgramClass, ClassPool, ClassPool)}
   */
  @Test
  @DisplayName("Test new ClassBuilder(ProgramClass, ClassPool, ClassPool)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassBuilder.<init>(ProgramClass, ClassPool, ClassPool)"})
  void testNewClassBuilder2() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass programClass = new ProgramClass(1, 1, constantPool, 1, 1, 1);

    // Act
    ClassBuilder actualClassBuilder =
        new ClassBuilder(programClass, null, KotlinConstants.dummyClassPool);

    // Assert
    assertSame(programClass, actualClassBuilder.getProgramClass());
    assertSame(programClass, actualClassBuilder.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Test {@link ClassBuilder#ClassBuilder(ProgramClass, ClassPool, ClassPool)}.
   *
   * <p>Method under test: {@link ClassBuilder#ClassBuilder(ProgramClass, ClassPool, ClassPool)}
   */
  @Test
  @DisplayName("Test new ClassBuilder(ProgramClass, ClassPool, ClassPool)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassBuilder.<init>(ProgramClass, ClassPool, ClassPool)"})
  void testNewClassBuilder3() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass programClass = new ProgramClass(1, 2, constantPool, 1, 1, 1);

    // Act
    ClassBuilder actualClassBuilder =
        new ClassBuilder(programClass, null, KotlinConstants.dummyClassPool);

    // Assert
    assertSame(programClass, actualClassBuilder.getProgramClass());
    assertSame(programClass, actualClassBuilder.getConstantPoolEditor().getTargetClass());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassBuilder.<init>(int, int, String, String)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassBuilder.<init>(int, int, String, String, String, int, Object)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassBuilder.<init>(int, int, String, String)"})
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
    assertArrayEquals("Class Name".getBytes("UTF-8"), ((Utf8Constant) constant2).getBytes());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassBuilder.<init>(int, int, String, String, String, int, Object)"})
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
    assertArrayEquals("Class Name".getBytes("UTF-8"), ((Utf8Constant) constant2).getBytes());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassBuilder.<init>(ProgramClass)"})
  void testNewClassBuilder_whenProgramClass_thenReturnProgramClassIsProgramClass() {
    // Arrange
    ProgramClass programClass = new ProgramClass();

    // Act
    ClassBuilder actualClassBuilder = new ClassBuilder(programClass);

    // Assert
    assertSame(programClass, actualClassBuilder.getProgramClass());
    assertSame(programClass, actualClassBuilder.getConstantPoolEditor().getTargetClass());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassBuilder.<init>(ProgramClass, ClassPool, ClassPool)"})
  void testNewClassBuilder_whenProgramClass_thenReturnProgramClassIsProgramClass2() {
    // Arrange
    ProgramClass programClass = new ProgramClass();

    // Act
    ClassBuilder actualClassBuilder =
        new ClassBuilder(
            programClass, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);

    // Assert
    assertSame(programClass, actualClassBuilder.getProgramClass());
    assertSame(programClass, actualClassBuilder.getConstantPoolEditor().getTargetClass());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ClassBuilder.<init>(int, int, String, String)"})
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
    Clazz actualSuperClass = programClass.getSuperClass();
    assertSame(programClass, actualSuperClass);
    assertSame(programClass, actualClassBuilder.getConstantPoolEditor().getTargetClass());
    assertSame(programClass, ((ClassConstant) constant).referencedClass);
    assertArrayEquals("Test.class".getBytes("UTF-8"), ((Utf8Constant) constant2).getBytes());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ConstantPoolEditor ClassBuilder.getConstantPoolEditor()",
    "ProgramClass ClassBuilder.getProgramClass()"
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addInterface(Clazz)"})
  void testAddInterfaceWithInterfaceClass() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ClassBuilder classBuilder =
        new ClassBuilder(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act
    ClassBuilder actualAddInterfaceResult = classBuilder.addInterface(new LibraryClass());

    // Assert
    assertSame(classBuilder, actualAddInterfaceResult);
  }

  /**
   * Test {@link ClassBuilder#addInterface(Clazz)} with {@code interfaceClass}.
   *
   * <p>Method under test: {@link ClassBuilder#addInterface(Clazz)}
   */
  @Test
  @DisplayName("Test addInterface(Clazz) with 'interfaceClass'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addInterface(Clazz)"})
  void testAddInterfaceWithInterfaceClass2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassBuilder classBuilder =
        new ClassBuilder(
            new ProgramClass(
                1, 3, new Constant[] {classConstant, null, new ClassConstant()}, 1, 1, 1));

    // Act
    ClassBuilder actualAddInterfaceResult = classBuilder.addInterface(new LibraryClass());

    // Assert
    assertSame(classBuilder, actualAddInterfaceResult);
  }

  /**
   * Test {@link ClassBuilder#addInterface(Clazz)} with {@code interfaceClass}.
   *
   * <ul>
   *   <li>Then return buildClass.
   * </ul>
   *
   * <p>Method under test: {@link ClassBuilder#addInterface(Clazz)}
   */
  @Test
  @DisplayName("Test addInterface(Clazz) with 'interfaceClass'; then return buildClass")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addInterface(Clazz)"})
  void testAddInterfaceWithInterfaceClass_thenReturnBuildClass() {
    // Arrange
    ClassBuilder buildClassResult = PartialEvaluatorErrorsTestKt.buildClass();
    LibraryClass interfaceClass = new LibraryClass(5, "This Class Name", "Super Class Name");

    // Act
    ClassBuilder actualAddInterfaceResult = buildClassResult.addInterface(interfaceClass);

    // Assert
    assertSame(buildClassResult, actualAddInterfaceResult);
  }

  /**
   * Test {@link ClassBuilder#addInterface(String)} with {@code interfaceName}.
   *
   * <p>Method under test: {@link ClassBuilder#addInterface(String)}
   */
  @Test
  @DisplayName("Test addInterface(String) with 'interfaceName'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addInterface(String)"})
  void testAddInterfaceWithInterfaceName() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    ProgramClass programClass =
        PartialEvaluatorErrorsTestKt.buildClass().addInterface("Interface Name").getProgramClass();
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof Utf8Constant);
    Constant constant2 = constantArray[3];
    assertTrue(constant2 instanceof Utf8Constant);
    Constant constant3 = constantArray[5];
    assertTrue(constant3 instanceof Utf8Constant);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    assertArrayEquals("Interface Name".getBytes("UTF-8"), ((Utf8Constant) constant3).getBytes());
    assertArrayEquals(
        "PartialEvaluatorDummy".getBytes("UTF-8"), ((Utf8Constant) constant).getBytes());
    assertArrayEquals("java/lang/Object".getBytes("UTF-8"), ((Utf8Constant) constant2).getBytes());
    assertArrayEquals(new int[] {6}, programClass.u2interfaces);
  }

  /**
   * Test {@link ClassBuilder#addInterface(String)} with {@code interfaceName}.
   *
   * <p>Method under test: {@link ClassBuilder#addInterface(String)}
   */
  @Test
  @DisplayName("Test addInterface(String) with 'interfaceName'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addInterface(String)"})
  void testAddInterfaceWithInterfaceName2() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ClassBuilder classBuilder = new ClassBuilder(new ProgramClass(1, 1, constantPool, 1, 1, 1));

    // Act
    ClassBuilder actualAddInterfaceResult = classBuilder.addInterface("Interface Name");

    // Assert
    assertSame(classBuilder, actualAddInterfaceResult);
  }

  /**
   * Test {@link ClassBuilder#addInterface(String)} with {@code interfaceName}.
   *
   * <p>Method under test: {@link ClassBuilder#addInterface(String)}
   */
  @Test
  @DisplayName("Test addInterface(String) with 'interfaceName'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addInterface(String)"})
  void testAddInterfaceWithInterfaceName3() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ClassBuilder classBuilder = new ClassBuilder(new ProgramClass(1, 0, constantPool, 1, 1, 1));

    // Act
    ClassBuilder actualAddInterfaceResult = classBuilder.addInterface("Interface Name");

    // Assert
    assertSame(classBuilder, actualAddInterfaceResult);
  }

  /**
   * Test {@link ClassBuilder#addInterface(String)} with {@code interfaceName}.
   *
   * <p>Method under test: {@link ClassBuilder#addInterface(String)}
   */
  @Test
  @DisplayName("Test addInterface(String) with 'interfaceName'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addInterface(String)"})
  void testAddInterfaceWithInterfaceName4() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ClassBuilder classBuilder =
        new ClassBuilder(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act
    ClassBuilder actualAddInterfaceResult = classBuilder.addInterface("Interface Name");

    // Assert
    assertSame(classBuilder, actualAddInterfaceResult);
  }

  /**
   * Test {@link ClassBuilder#addInterface(String)} with {@code interfaceName}.
   *
   * <p>Method under test: {@link ClassBuilder#addInterface(String)}
   */
  @Test
  @DisplayName("Test addInterface(String) with 'interfaceName'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addInterface(String)"})
  void testAddInterfaceWithInterfaceName5() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassBuilder classBuilder =
        new ClassBuilder(
            new ProgramClass(
                1, 3, new Constant[] {classConstant, null, new ClassConstant()}, 1, 1, 1));

    // Act
    ClassBuilder actualAddInterfaceResult = classBuilder.addInterface("Interface Name");

    // Assert
    assertSame(classBuilder, actualAddInterfaceResult);
  }

  /**
   * Test {@link ClassBuilder#addInterface(String, Clazz)} with {@code interfaceName}, {@code
   * referencedInterface}.
   *
   * <p>Method under test: {@link ClassBuilder#addInterface(String, Clazz)}
   */
  @Test
  @DisplayName("Test addInterface(String, Clazz) with 'interfaceName', 'referencedInterface'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addInterface(String, Clazz)"})
  void testAddInterfaceWithInterfaceNameReferencedInterface() throws UnsupportedEncodingException {
    // Arrange
    ClassBuilder buildClassResult = PartialEvaluatorErrorsTestKt.buildClass();
    LibraryClass referencedInterface = new LibraryClass();

    // Act and Assert
    ProgramClass programClass =
        buildClassResult.addInterface("Interface Name", referencedInterface).getProgramClass();
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
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    assertSame(referencedInterface, clazz);
    assertArrayEquals("Interface Name".getBytes("UTF-8"), ((Utf8Constant) constant4).getBytes());
    assertArrayEquals(
        "PartialEvaluatorDummy".getBytes("UTF-8"), ((Utf8Constant) constant2).getBytes());
    assertArrayEquals("java/lang/Object".getBytes("UTF-8"), ((Utf8Constant) constant3).getBytes());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addInterface(String, Clazz)"})
  void testAddInterfaceWithInterfaceNameReferencedInterface2() throws UnsupportedEncodingException {
    // Arrange
    ClassBuilder buildClassResult = PartialEvaluatorErrorsTestKt.buildClass();
    buildClassResult.addInterface("Interface Name");

    // Act and Assert
    ProgramClass programClass =
        buildClassResult.addInterface("Interface Name", new LibraryClass()).getProgramClass();
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
    assertArrayEquals("Interface Name".getBytes("UTF-8"), ((Utf8Constant) constant4).getBytes());
    assertArrayEquals(
        "PartialEvaluatorDummy".getBytes("UTF-8"), ((Utf8Constant) constant2).getBytes());
    assertArrayEquals("java/lang/Object".getBytes("UTF-8"), ((Utf8Constant) constant3).getBytes());
    assertArrayEquals(new int[] {6, 6}, programClass.u2interfaces);
  }

  /**
   * Test {@link ClassBuilder#addInterface(String, Clazz)} with {@code interfaceName}, {@code
   * referencedInterface}.
   *
   * <p>Method under test: {@link ClassBuilder#addInterface(String, Clazz)}
   */
  @Test
  @DisplayName("Test addInterface(String, Clazz) with 'interfaceName', 'referencedInterface'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addInterface(String, Clazz)"})
  void testAddInterfaceWithInterfaceNameReferencedInterface3() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ClassBuilder classBuilder = new ClassBuilder(new ProgramClass(1, 1, constantPool, 1, 1, 1));

    // Act
    ClassBuilder actualAddInterfaceResult =
        classBuilder.addInterface("Interface Name", new LibraryClass());

    // Assert
    assertSame(classBuilder, actualAddInterfaceResult);
  }

  /**
   * Test {@link ClassBuilder#addInterface(String, Clazz)} with {@code interfaceName}, {@code
   * referencedInterface}.
   *
   * <p>Method under test: {@link ClassBuilder#addInterface(String, Clazz)}
   */
  @Test
  @DisplayName("Test addInterface(String, Clazz) with 'interfaceName', 'referencedInterface'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addInterface(String, Clazz)"})
  void testAddInterfaceWithInterfaceNameReferencedInterface4() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ClassBuilder classBuilder = new ClassBuilder(new ProgramClass(1, 0, constantPool, 1, 1, 1));

    // Act
    ClassBuilder actualAddInterfaceResult =
        classBuilder.addInterface("Interface Name", new LibraryClass());

    // Assert
    assertSame(classBuilder, actualAddInterfaceResult);
  }

  /**
   * Test {@link ClassBuilder#addInterface(String, Clazz)} with {@code interfaceName}, {@code
   * referencedInterface}.
   *
   * <p>Method under test: {@link ClassBuilder#addInterface(String, Clazz)}
   */
  @Test
  @DisplayName("Test addInterface(String, Clazz) with 'interfaceName', 'referencedInterface'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addInterface(String, Clazz)"})
  void testAddInterfaceWithInterfaceNameReferencedInterface5() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ClassBuilder classBuilder =
        new ClassBuilder(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act
    ClassBuilder actualAddInterfaceResult =
        classBuilder.addInterface("Interface Name", new LibraryClass());

    // Assert
    assertSame(classBuilder, actualAddInterfaceResult);
  }

  /**
   * Test {@link ClassBuilder#addInterface(String, Clazz)} with {@code interfaceName}, {@code
   * referencedInterface}.
   *
   * <p>Method under test: {@link ClassBuilder#addInterface(String, Clazz)}
   */
  @Test
  @DisplayName("Test addInterface(String, Clazz) with 'interfaceName', 'referencedInterface'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addInterface(String, Clazz)"})
  void testAddInterfaceWithInterfaceNameReferencedInterface6() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassBuilder classBuilder =
        new ClassBuilder(
            new ProgramClass(
                1, 3, new Constant[] {classConstant, null, new ClassConstant()}, 1, 1, 1));

    // Act
    ClassBuilder actualAddInterfaceResult =
        classBuilder.addInterface("Interface Name", new LibraryClass());

    // Assert
    assertSame(classBuilder, actualAddInterfaceResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addInterface(String)"})
  void testAddInterfaceWithInterfaceName_thenReturnProgramClassInterfaceCountIsTwo()
      throws UnsupportedEncodingException {
    // Arrange
    ClassBuilder buildClassResult = PartialEvaluatorErrorsTestKt.buildClass();
    buildClassResult.addInterface("Interface Name");

    // Act and Assert
    ProgramClass programClass = buildClassResult.addInterface("Interface Name").getProgramClass();
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof Utf8Constant);
    Constant constant2 = constantArray[3];
    assertTrue(constant2 instanceof Utf8Constant);
    Constant constant3 = constantArray[5];
    assertTrue(constant3 instanceof Utf8Constant);
    assertEquals(2, programClass.getInterfaceCount());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    assertArrayEquals("Interface Name".getBytes("UTF-8"), ((Utf8Constant) constant3).getBytes());
    assertArrayEquals(
        "PartialEvaluatorDummy".getBytes("UTF-8"), ((Utf8Constant) constant).getBytes());
    assertArrayEquals("java/lang/Object".getBytes("UTF-8"), ((Utf8Constant) constant2).getBytes());
    assertArrayEquals(new int[] {6, 6}, programClass.u2interfaces);
  }

  /**
   * Test {@link ClassBuilder#addField(int, String, String)} with {@code u2accessFlags}, {@code
   * fieldName}, {@code fieldDescriptor}.
   *
   * <p>Method under test: {@link ClassBuilder#addField(int, String, String)}
   */
  @Test
  @DisplayName(
      "Test addField(int, String, String) with 'u2accessFlags', 'fieldName', 'fieldDescriptor'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addField(int, String, String)"})
  void testAddFieldWithU2accessFlagsFieldNameFieldDescriptor() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    Constant[] constantArray =
        PartialEvaluatorErrorsTestKt.buildClass()
            .addField(2, "Field Name", "Field Descriptor")
            .getProgramClass()
            .constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof Utf8Constant);
    Constant constant2 = constantArray[3];
    assertTrue(constant2 instanceof Utf8Constant);
    Constant constant3 = constantArray[5];
    assertTrue(constant3 instanceof Utf8Constant);
    Constant constant4 = constantArray[6];
    assertTrue(constant4 instanceof Utf8Constant);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    assertArrayEquals("Field Descriptor".getBytes("UTF-8"), ((Utf8Constant) constant4).getBytes());
    assertArrayEquals("Field Name".getBytes("UTF-8"), ((Utf8Constant) constant3).getBytes());
    assertArrayEquals(
        "PartialEvaluatorDummy".getBytes("UTF-8"), ((Utf8Constant) constant).getBytes());
    assertArrayEquals("java/lang/Object".getBytes("UTF-8"), ((Utf8Constant) constant2).getBytes());
  }

  /**
   * Test {@link ClassBuilder#addField(int, String, String)} with {@code u2accessFlags}, {@code
   * fieldName}, {@code fieldDescriptor}.
   *
   * <p>Method under test: {@link ClassBuilder#addField(int, String, String)}
   */
  @Test
  @DisplayName(
      "Test addField(int, String, String) with 'u2accessFlags', 'fieldName', 'fieldDescriptor'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addField(int, String, String)"})
  void testAddFieldWithU2accessFlagsFieldNameFieldDescriptor2() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ClassBuilder classBuilder = new ClassBuilder(new ProgramClass(1, 1, constantPool, 1, 1, 1));

    // Act
    ClassBuilder actualAddFieldResult = classBuilder.addField(2, "Field Name", "Field Descriptor");

    // Assert
    assertSame(classBuilder, actualAddFieldResult);
  }

  /**
   * Test {@link ClassBuilder#addField(int, String, String)} with {@code u2accessFlags}, {@code
   * fieldName}, {@code fieldDescriptor}.
   *
   * <p>Method under test: {@link ClassBuilder#addField(int, String, String)}
   */
  @Test
  @DisplayName(
      "Test addField(int, String, String) with 'u2accessFlags', 'fieldName', 'fieldDescriptor'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addField(int, String, String)"})
  void testAddFieldWithU2accessFlagsFieldNameFieldDescriptor3() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ClassBuilder classBuilder = new ClassBuilder(new ProgramClass(1, 0, constantPool, 1, 1, 1));

    // Act
    ClassBuilder actualAddFieldResult = classBuilder.addField(2, "Field Name", "Field Descriptor");

    // Assert
    assertSame(classBuilder, actualAddFieldResult);
  }

  /**
   * Test {@link ClassBuilder#addField(int, String, String)} with {@code u2accessFlags}, {@code
   * fieldName}, {@code fieldDescriptor}.
   *
   * <p>Method under test: {@link ClassBuilder#addField(int, String, String)}
   */
  @Test
  @DisplayName(
      "Test addField(int, String, String) with 'u2accessFlags', 'fieldName', 'fieldDescriptor'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addField(int, String, String)"})
  void testAddFieldWithU2accessFlagsFieldNameFieldDescriptor4() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ClassBuilder classBuilder =
        new ClassBuilder(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act
    ClassBuilder actualAddFieldResult = classBuilder.addField(2, "Field Name", "Field Descriptor");

    // Assert
    assertSame(classBuilder, actualAddFieldResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addField(int, String, String, MemberVisitor)"})
  void testAddFieldWithU2accessFlagsFieldNameFieldDescriptorExtraMemberVisitor()
      throws UnsupportedEncodingException {
    // Arrange
    ClassBuilder buildClassResult = PartialEvaluatorErrorsTestKt.buildClass();

    // Act and Assert
    Constant[] constantArray =
        buildClassResult
            .addField(2, "Field Name", "Field Descriptor", new AttributeSorter())
            .getProgramClass()
            .constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof Utf8Constant);
    Constant constant2 = constantArray[3];
    assertTrue(constant2 instanceof Utf8Constant);
    Constant constant3 = constantArray[5];
    assertTrue(constant3 instanceof Utf8Constant);
    Constant constant4 = constantArray[6];
    assertTrue(constant4 instanceof Utf8Constant);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    assertArrayEquals("Field Descriptor".getBytes("UTF-8"), ((Utf8Constant) constant4).getBytes());
    assertArrayEquals("Field Name".getBytes("UTF-8"), ((Utf8Constant) constant3).getBytes());
    assertArrayEquals(
        "PartialEvaluatorDummy".getBytes("UTF-8"), ((Utf8Constant) constant).getBytes());
    assertArrayEquals("java/lang/Object".getBytes("UTF-8"), ((Utf8Constant) constant2).getBytes());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addField(int, String, String, MemberVisitor)"})
  void testAddFieldWithU2accessFlagsFieldNameFieldDescriptorExtraMemberVisitor2()
      throws UnsupportedEncodingException {
    // Arrange and Act
    ClassBuilder actualAddFieldResult =
        PartialEvaluatorErrorsTestKt.buildClass()
            .addField(2, "Field Name", "Field Descriptor", null);

    // Assert
    ProgramClass programClass = actualAddFieldResult.getProgramClass();
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[2];
    assertTrue(constant instanceof ClassConstant);
    Constant constant2 = constantArray[1];
    assertTrue(constant2 instanceof Utf8Constant);
    Constant constant3 = constantArray[3];
    assertTrue(constant3 instanceof Utf8Constant);
    Constant constant4 = constantArray[5];
    assertTrue(constant4 instanceof Utf8Constant);
    Constant constant5 = constantArray[6];
    assertTrue(constant5 instanceof Utf8Constant);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    assertSame(programClass, actualAddFieldResult.getConstantPoolEditor().getTargetClass());
    assertSame(programClass, ((ClassConstant) constant).referencedClass);
    assertArrayEquals("Field Descriptor".getBytes("UTF-8"), ((Utf8Constant) constant5).getBytes());
    assertArrayEquals("Field Name".getBytes("UTF-8"), ((Utf8Constant) constant4).getBytes());
    assertArrayEquals(
        "PartialEvaluatorDummy".getBytes("UTF-8"), ((Utf8Constant) constant2).getBytes());
    assertArrayEquals("java/lang/Object".getBytes("UTF-8"), ((Utf8Constant) constant3).getBytes());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addField(int, String, String, MemberVisitor)"})
  void testAddFieldWithU2accessFlagsFieldNameFieldDescriptorExtraMemberVisitor3() {
    // Arrange
    ClassBuilder buildClassResult = PartialEvaluatorErrorsTestKt.buildClass();
    buildClassResult.addField(2, "Field Name", "Field Descriptor");

    // Act and Assert
    ProgramClass programClass =
        buildClassResult
            .addField(2, "Field Name", "Field Descriptor", new AttributeSorter())
            .getProgramClass();
    Constant[] constantArray = programClass.constantPool;
    assertTrue(constantArray[5] instanceof Utf8Constant);
    assertTrue(constantArray[6] instanceof Utf8Constant);
    assertEquals(2, programClass.fields.length);
    assertEquals(2, programClass.u2fieldsCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addField(int, String, String, MemberVisitor)"})
  void testAddFieldWithU2accessFlagsFieldNameFieldDescriptorExtraMemberVisitor4() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ClassBuilder classBuilder = new ClassBuilder(new ProgramClass(1, 1, constantPool, 1, 1, 1));

    // Act
    ClassBuilder actualAddFieldResult =
        classBuilder.addField(2, "Field Name", "Field Descriptor", new AttributeSorter());

    // Assert
    assertSame(classBuilder, actualAddFieldResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addField(int, String, String, MemberVisitor)"})
  void testAddFieldWithU2accessFlagsFieldNameFieldDescriptorExtraMemberVisitor5() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ClassBuilder classBuilder = new ClassBuilder(new ProgramClass(1, 0, constantPool, 1, 1, 1));

    // Act
    ClassBuilder actualAddFieldResult =
        classBuilder.addField(2, "Field Name", "Field Descriptor", new AttributeSorter());

    // Assert
    assertSame(classBuilder, actualAddFieldResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addField(int, String, String, MemberVisitor)"})
  void testAddFieldWithU2accessFlagsFieldNameFieldDescriptorExtraMemberVisitor6() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ClassBuilder classBuilder =
        new ClassBuilder(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act
    ClassBuilder actualAddFieldResult =
        classBuilder.addField(2, "Field Name", "Field Descriptor", new AttributeSorter());

    // Assert
    assertSame(classBuilder, actualAddFieldResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addField(int, String, String)"})
  void testAddFieldWithU2accessFlagsFieldNameFieldDescriptor_thenReturnArrayLengthIsTwo() {
    // Arrange
    ClassBuilder buildClassResult = PartialEvaluatorErrorsTestKt.buildClass();
    buildClassResult.addField(2, "Field Name", "Field Descriptor");

    // Act and Assert
    ProgramClass programClass =
        buildClassResult.addField(2, "Field Name", "Field Descriptor").getProgramClass();
    Constant[] constantArray = programClass.constantPool;
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
   *   <li>Given buildClass.
   *   <li>Then sixth element {@link Utf8Constant}.
   * </ul>
   *
   * <p>Method under test: {@link ClassBuilder#addAndReturnField(int, String, String)}
   */
  @Test
  @DisplayName(
      "Test addAndReturnField(int, String, String); given buildClass; then sixth element Utf8Constant")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ProgramField ClassBuilder.addAndReturnField(int, String, String)"})
  void testAddAndReturnField_givenBuildClass_thenSixthElementUtf8Constant()
      throws UnsupportedEncodingException {
    // Arrange
    ClassBuilder buildClassResult = PartialEvaluatorErrorsTestKt.buildClass();

    // Act
    buildClassResult.addAndReturnField(2, "Field Name", "Field Descriptor");

    // Assert
    ProgramClass programClass = buildClassResult.getProgramClass();
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[5];
    assertTrue(constant instanceof Utf8Constant);
    Constant constant2 = constantArray[6];
    assertTrue(constant2 instanceof Utf8Constant);
    assertEquals("Field Descriptor", ((Utf8Constant) constant2).getString());
    assertEquals("Field Name", ((Utf8Constant) constant).getString());
    assertNull(constant.getProcessingInfo());
    assertNull(constant2.getProcessingInfo());
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(0, constant2.getProcessingFlags());
    assertEquals(1, constant.getTag());
    assertEquals(1, constant2.getTag());
    assertEquals(7, programClass.u2constantPoolCount);
    assertFalse(constant.isCategory2());
    assertFalse(constant2.isCategory2());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    assertArrayEquals("Field Descriptor".getBytes("UTF-8"), ((Utf8Constant) constant2).getBytes());
    assertArrayEquals("Field Name".getBytes("UTF-8"), ((Utf8Constant) constant).getBytes());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ProgramField ClassBuilder.addAndReturnField(int, String, String)"})
  void testAddAndReturnField_thenArrayLengthIsTwo() {
    // Arrange
    ClassBuilder buildClassResult = PartialEvaluatorErrorsTestKt.buildClass();
    buildClassResult.addField(2, "Field Name", "Field Descriptor");

    // Act
    ProgramField actualAddAndReturnFieldResult =
        buildClassResult.addAndReturnField(2, "Field Name", "Field Descriptor");

    // Assert
    ProgramClass programClass = buildClassResult.getProgramClass();
    ProgramField[] programFieldArray = programClass.fields;
    assertEquals(2, programFieldArray.length);
    assertEquals(2, programClass.u2fieldsCount);
    assertEquals(7, programClass.u2constantPoolCount);
    assertSame(actualAddAndReturnFieldResult.attributes, programFieldArray[0].attributes);
  }

  /**
   * Test {@link ClassBuilder#addAndReturnField(int, String, String)}.
   *
   * <ul>
   *   <li>Then return {@link ProgramMember#u2nameIndex} is one.
   * </ul>
   *
   * <p>Method under test: {@link ClassBuilder#addAndReturnField(int, String, String)}
   */
  @Test
  @DisplayName("Test addAndReturnField(int, String, String); then return u2nameIndex is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ProgramField ClassBuilder.addAndReturnField(int, String, String)"})
  void testAddAndReturnField_thenReturnU2nameIndexIsOne() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass programClass = new ProgramClass(1, 1, constantPool, 1, 1, 1);
    ClassBuilder classBuilder = new ClassBuilder(programClass);

    // Act
    ProgramField actualAddAndReturnFieldResult =
        classBuilder.addAndReturnField(2, "Field Name", "Field Descriptor");

    // Assert
    assertEquals(1, actualAddAndReturnFieldResult.u2nameIndex);
    assertEquals(2, actualAddAndReturnFieldResult.u2descriptorIndex);
    ProgramClass programClass2 = classBuilder.getProgramClass();
    assertEquals(3, programClass2.u2constantPoolCount);
    assertSame(programClass.constantPool, programClass2.constantPool);
  }

  /**
   * Test {@link ClassBuilder#addAndReturnField(int, String, String)}.
   *
   * <ul>
   *   <li>Then return {@link ProgramMember#u2nameIndex} is three.
   * </ul>
   *
   * <p>Method under test: {@link ClassBuilder#addAndReturnField(int, String, String)}
   */
  @Test
  @DisplayName("Test addAndReturnField(int, String, String); then return u2nameIndex is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ProgramField ClassBuilder.addAndReturnField(int, String, String)"})
  void testAddAndReturnField_thenReturnU2nameIndexIsThree() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass programClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 1, 1, 1);
    ClassBuilder classBuilder = new ClassBuilder(programClass);

    // Act
    ProgramField actualAddAndReturnFieldResult =
        classBuilder.addAndReturnField(2, "Field Name", "Field Descriptor");

    // Assert
    assertEquals(3, actualAddAndReturnFieldResult.u2nameIndex);
    assertEquals(4, actualAddAndReturnFieldResult.u2descriptorIndex);
    ProgramClass programClass2 = classBuilder.getProgramClass();
    assertEquals(5, programClass2.u2constantPoolCount);
    assertSame(programClass.constantPool, programClass2.constantPool);
  }

  /**
   * Test {@link ClassBuilder#addAndReturnField(int, String, String)}.
   *
   * <ul>
   *   <li>Then return {@link ProgramMember#u2nameIndex} is zero.
   * </ul>
   *
   * <p>Method under test: {@link ClassBuilder#addAndReturnField(int, String, String)}
   */
  @Test
  @DisplayName("Test addAndReturnField(int, String, String); then return u2nameIndex is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ProgramField ClassBuilder.addAndReturnField(int, String, String)"})
  void testAddAndReturnField_thenReturnU2nameIndexIsZero() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass programClass = new ProgramClass(1, 0, constantPool, 1, 1, 1);
    ClassBuilder classBuilder = new ClassBuilder(programClass);

    // Act
    ProgramField actualAddAndReturnFieldResult =
        classBuilder.addAndReturnField(2, "Field Name", "Field Descriptor");

    // Assert
    assertEquals(0, actualAddAndReturnFieldResult.u2nameIndex);
    assertEquals(1, actualAddAndReturnFieldResult.u2descriptorIndex);
    ProgramClass programClass2 = classBuilder.getProgramClass();
    assertEquals(2, programClass2.u2constantPoolCount);
    assertSame(programClass.constantPool, programClass2.constantPool);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addMethod(int, String, String)"})
  void testAddMethodWithU2accessFlagsMethodNameMethodDescriptor()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    Constant[] constantArray =
        PartialEvaluatorErrorsTestKt.buildClass()
            .addMethod(2, "Method Name", "Method Descriptor")
            .getProgramClass()
            .constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof Utf8Constant);
    Constant constant2 = constantArray[3];
    assertTrue(constant2 instanceof Utf8Constant);
    Constant constant3 = constantArray[5];
    assertTrue(constant3 instanceof Utf8Constant);
    Constant constant4 = constantArray[6];
    assertTrue(constant4 instanceof Utf8Constant);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    assertArrayEquals("Method Descriptor".getBytes("UTF-8"), ((Utf8Constant) constant4).getBytes());
    assertArrayEquals("Method Name".getBytes("UTF-8"), ((Utf8Constant) constant3).getBytes());
    assertArrayEquals(
        "PartialEvaluatorDummy".getBytes("UTF-8"), ((Utf8Constant) constant).getBytes());
    assertArrayEquals("java/lang/Object".getBytes("UTF-8"), ((Utf8Constant) constant2).getBytes());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addMethod(int, String, String)"})
  void testAddMethodWithU2accessFlagsMethodNameMethodDescriptor2() {
    // Arrange
    ClassBuilder buildClassResult = PartialEvaluatorErrorsTestKt.buildClass();
    buildClassResult.addMethod(2, "Method Name", "Method Descriptor");

    // Act and Assert
    ProgramClass programClass =
        buildClassResult.addMethod(2, "Method Name", "Method Descriptor").getProgramClass();
    Constant[] constantArray = programClass.constantPool;
    assertTrue(constantArray[5] instanceof Utf8Constant);
    assertTrue(constantArray[6] instanceof Utf8Constant);
    assertEquals(2, programClass.methods.length);
    assertEquals(2, programClass.u2methodsCount);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addMethod(int, String, String)"})
  void testAddMethodWithU2accessFlagsMethodNameMethodDescriptor3() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ClassBuilder classBuilder = new ClassBuilder(new ProgramClass(1, 1, constantPool, 1, 1, 1));

    // Act
    ClassBuilder actualAddMethodResult =
        classBuilder.addMethod(2, "Method Name", "Method Descriptor");

    // Assert
    assertSame(classBuilder, actualAddMethodResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addMethod(int, String, String)"})
  void testAddMethodWithU2accessFlagsMethodNameMethodDescriptor4() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ClassBuilder classBuilder = new ClassBuilder(new ProgramClass(1, 0, constantPool, 1, 1, 1));

    // Act
    ClassBuilder actualAddMethodResult =
        classBuilder.addMethod(2, "Method Name", "Method Descriptor");

    // Assert
    assertSame(classBuilder, actualAddMethodResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addMethod(int, String, String)"})
  void testAddMethodWithU2accessFlagsMethodNameMethodDescriptor5() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ClassBuilder classBuilder =
        new ClassBuilder(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act
    ClassBuilder actualAddMethodResult =
        classBuilder.addMethod(2, "Method Name", "Method Descriptor");

    // Assert
    assertSame(classBuilder, actualAddMethodResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addMethod(int, String, String, MemberVisitor)"})
  void testAddMethodWithU2accessFlagsMethodNameMethodDescriptorExtraMemberVisitor()
      throws UnsupportedEncodingException {
    // Arrange
    ClassBuilder buildClassResult = PartialEvaluatorErrorsTestKt.buildClass();

    // Act and Assert
    Constant[] constantArray =
        buildClassResult
            .addMethod(2, "Method Name", "Method Descriptor", new AttributeSorter())
            .getProgramClass()
            .constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof Utf8Constant);
    Constant constant2 = constantArray[3];
    assertTrue(constant2 instanceof Utf8Constant);
    Constant constant3 = constantArray[5];
    assertTrue(constant3 instanceof Utf8Constant);
    Constant constant4 = constantArray[6];
    assertTrue(constant4 instanceof Utf8Constant);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    assertArrayEquals("Method Descriptor".getBytes("UTF-8"), ((Utf8Constant) constant4).getBytes());
    assertArrayEquals("Method Name".getBytes("UTF-8"), ((Utf8Constant) constant3).getBytes());
    assertArrayEquals(
        "PartialEvaluatorDummy".getBytes("UTF-8"), ((Utf8Constant) constant).getBytes());
    assertArrayEquals("java/lang/Object".getBytes("UTF-8"), ((Utf8Constant) constant2).getBytes());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addMethod(int, String, String, MemberVisitor)"})
  void testAddMethodWithU2accessFlagsMethodNameMethodDescriptorExtraMemberVisitor2() {
    // Arrange
    ClassBuilder buildClassResult = PartialEvaluatorErrorsTestKt.buildClass();
    buildClassResult.addMethod(2, "Method Name", "Method Descriptor");

    // Act and Assert
    ProgramClass programClass =
        buildClassResult
            .addMethod(2, "Method Name", "Method Descriptor", new AttributeSorter())
            .getProgramClass();
    Constant[] constantArray = programClass.constantPool;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addMethod(int, String, String, MemberVisitor)"})
  void testAddMethodWithU2accessFlagsMethodNameMethodDescriptorExtraMemberVisitor3() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ClassBuilder classBuilder = new ClassBuilder(new ProgramClass(1, 1, constantPool, 1, 1, 1));

    // Act
    ClassBuilder actualAddMethodResult =
        classBuilder.addMethod(2, "Method Name", "Method Descriptor", new AttributeSorter());

    // Assert
    assertSame(classBuilder, actualAddMethodResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addMethod(int, String, String, MemberVisitor)"})
  void testAddMethodWithU2accessFlagsMethodNameMethodDescriptorExtraMemberVisitor4() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ClassBuilder classBuilder = new ClassBuilder(new ProgramClass(1, 0, constantPool, 1, 1, 1));

    // Act
    ClassBuilder actualAddMethodResult =
        classBuilder.addMethod(2, "Method Name", "Method Descriptor", new AttributeSorter());

    // Assert
    assertSame(classBuilder, actualAddMethodResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addMethod(int, String, String, MemberVisitor)"})
  void testAddMethodWithU2accessFlagsMethodNameMethodDescriptorExtraMemberVisitor5() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ClassBuilder classBuilder =
        new ClassBuilder(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act
    ClassBuilder actualAddMethodResult =
        classBuilder.addMethod(2, "Method Name", "Method Descriptor", new AttributeSorter());

    // Assert
    assertSame(classBuilder, actualAddMethodResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ProgramMethod ClassBuilder.addAndReturnMethod(int, String, String)"})
  void testAddAndReturnMethodWithU2accessFlagsMethodNameMethodDescriptor()
      throws UnsupportedEncodingException {
    // Arrange
    ClassBuilder buildClassResult = PartialEvaluatorErrorsTestKt.buildClass();

    // Act
    buildClassResult.addAndReturnMethod(2, "Method Name", "Method Descriptor");

    // Assert
    ProgramClass programClass = buildClassResult.getProgramClass();
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[5];
    assertTrue(constant instanceof Utf8Constant);
    Constant constant2 = constantArray[6];
    assertTrue(constant2 instanceof Utf8Constant);
    assertEquals("Method Descriptor", ((Utf8Constant) constant2).getString());
    assertEquals("Method Name", ((Utf8Constant) constant).getString());
    assertNull(constant.getProcessingInfo());
    assertNull(constant2.getProcessingInfo());
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(0, constant2.getProcessingFlags());
    assertEquals(1, constant.getTag());
    assertEquals(1, constant2.getTag());
    assertEquals(7, programClass.u2constantPoolCount);
    assertFalse(constant.isCategory2());
    assertFalse(constant2.isCategory2());
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
    assertArrayEquals("Method Descriptor".getBytes("UTF-8"), ((Utf8Constant) constant2).getBytes());
    assertArrayEquals("Method Name".getBytes("UTF-8"), ((Utf8Constant) constant).getBytes());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ProgramMethod ClassBuilder.addAndReturnMethod(int, String, String)"})
  void testAddAndReturnMethodWithU2accessFlagsMethodNameMethodDescriptor2() {
    // Arrange
    ClassBuilder buildClassResult = PartialEvaluatorErrorsTestKt.buildClass();
    buildClassResult.addMethod(2, "Method Name", "Method Descriptor");

    // Act
    ProgramMethod actualAddAndReturnMethodResult =
        buildClassResult.addAndReturnMethod(2, "Method Name", "Method Descriptor");

    // Assert
    ProgramClass programClass = buildClassResult.getProgramClass();
    ProgramMethod[] programMethodArray = programClass.methods;
    assertEquals(2, programMethodArray.length);
    assertEquals(2, programClass.u2methodsCount);
    assertEquals(7, programClass.u2constantPoolCount);
    assertSame(actualAddAndReturnMethodResult.attributes, programMethodArray[0].attributes);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ProgramMethod ClassBuilder.addAndReturnMethod(int, String, String)"})
  void testAddAndReturnMethodWithU2accessFlagsMethodNameMethodDescriptor3() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass programClass = new ProgramClass(1, 1, constantPool, 1, 1, 1);
    ClassBuilder classBuilder = new ClassBuilder(programClass);

    // Act
    ProgramMethod actualAddAndReturnMethodResult =
        classBuilder.addAndReturnMethod(2, "Method Name", "Method Descriptor");

    // Assert
    assertEquals(1, actualAddAndReturnMethodResult.u2nameIndex);
    assertEquals(2, actualAddAndReturnMethodResult.u2descriptorIndex);
    ProgramClass programClass2 = classBuilder.getProgramClass();
    assertEquals(3, programClass2.u2constantPoolCount);
    assertSame(programClass.constantPool, programClass2.constantPool);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ProgramMethod ClassBuilder.addAndReturnMethod(int, String, String)"})
  void testAddAndReturnMethodWithU2accessFlagsMethodNameMethodDescriptor4() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass programClass = new ProgramClass(1, 0, constantPool, 1, 1, 1);
    ClassBuilder classBuilder = new ClassBuilder(programClass);

    // Act
    ProgramMethod actualAddAndReturnMethodResult =
        classBuilder.addAndReturnMethod(2, "Method Name", "Method Descriptor");

    // Assert
    assertEquals(0, actualAddAndReturnMethodResult.u2nameIndex);
    assertEquals(1, actualAddAndReturnMethodResult.u2descriptorIndex);
    ProgramClass programClass2 = classBuilder.getProgramClass();
    assertEquals(2, programClass2.u2constantPoolCount);
    assertSame(programClass.constantPool, programClass2.constantPool);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ProgramMethod ClassBuilder.addAndReturnMethod(int, String, String)"})
  void testAddAndReturnMethodWithU2accessFlagsMethodNameMethodDescriptor5() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass programClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 1, 1, 1);
    ClassBuilder classBuilder = new ClassBuilder(programClass);

    // Act
    ProgramMethod actualAddAndReturnMethodResult =
        classBuilder.addAndReturnMethod(2, "Method Name", "Method Descriptor");

    // Assert
    assertEquals(3, actualAddAndReturnMethodResult.u2nameIndex);
    assertEquals(4, actualAddAndReturnMethodResult.u2descriptorIndex);
    ProgramClass programClass2 = classBuilder.getProgramClass();
    assertEquals(5, programClass2.u2constantPoolCount);
    assertSame(programClass.constantPool, programClass2.constantPool);
  }
}
