package proguard.classfile.editor;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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
import proguard.classfile.editor.ClassBuilder.CodeBuilder;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.classfile.visitor.MemberVisitor;

public class ClassBuilderDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassBuilder.<init>(ProgramClass, ClassPool, ClassPool)"})
  public void testNewClassBuilder_givenOne_whenProgramClassU2constantPoolCountIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassBuilder.<init>(ProgramClass)"})
  public void testNewClassBuilder_givenTwo_whenProgramClassU2constantPoolCountIsTwo() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassBuilder.<init>(ProgramClass, ClassPool, ClassPool)"})
  public void testNewClassBuilder_givenTwo_whenProgramClassU2constantPoolCountIsTwo2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassBuilder.<init>(int, int, String, String)"})
  public void testNewClassBuilder_whenClassName_thenFifthElementReturnClassConstant() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassBuilder.<init>(int, int, String, String, String, int, Object)"})
  public void testNewClassBuilder_whenClassName_thenFifthElementReturnClassConstant2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassBuilder.<init>(int, int, String, String)"})
  public void testNewClassBuilder_whenClassName_thenReturnProgramClassSuperNameIsNull()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassBuilder.<init>(int, int, String, String, String, int, Object)"})
  public void testNewClassBuilder_whenClassName_thenThirdElementReturnClassConstant()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassBuilder.<init>(ProgramClass)"})
  public void testNewClassBuilder_whenProgramClass_thenReturnProgramClassIsProgramClass() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassBuilder.<init>(ProgramClass, ClassPool, ClassPool)"})
  public void testNewClassBuilder_whenProgramClass_thenReturnProgramClassIsProgramClass2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassBuilder.<init>(int, int, String, String)"})
  public void testNewClassBuilder_whenTestClass_thenReturnProgramClassNameIsTestClass()
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ConstantPoolEditor ClassBuilder.getConstantPoolEditor()",
    "ProgramClass ClassBuilder.getProgramClass()"
  })
  public void testGettersAndSetters() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addInterface(Clazz)"})
  public void testAddInterfaceWithInterfaceClass() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");

    // Act and Assert
    assertSame(
        classBuilder,
        classBuilder.addInterface(new LibraryClass(5, "This Class Name", "Super Class Name")));
  }

  /**
   * Test {@link ClassBuilder#addInterface(Clazz)} with {@code interfaceClass}.
   *
   * <p>Method under test: {@link ClassBuilder#addInterface(Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addInterface(Clazz)"})
  public void testAddInterfaceWithInterfaceClass2() {
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

    // Act and Assert
    assertSame(classBuilder, classBuilder.addInterface(new LibraryClass()));
  }

  /**
   * Test {@link ClassBuilder#addInterface(String)} with {@code interfaceName}.
   *
   * <p>Method under test: {@link ClassBuilder#addInterface(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addInterface(String)"})
  public void testAddInterfaceWithInterfaceName() throws UnsupportedEncodingException {
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
   * <p>Method under test: {@link ClassBuilder#addInterface(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addInterface(String)"})
  public void testAddInterfaceWithInterfaceName2() {
    // Arrange
    ClassBuilder classBuilder =
        new ClassBuilder(new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(classBuilder, classBuilder.addInterface("Interface Name"));
  }

  /**
   * Test {@link ClassBuilder#addInterface(String)} with {@code interfaceName}.
   *
   * <p>Method under test: {@link ClassBuilder#addInterface(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addInterface(String)"})
  public void testAddInterfaceWithInterfaceName3() {
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

    // Act and Assert
    assertSame(classBuilder, classBuilder.addInterface("Interface Name"));
  }

  /**
   * Test {@link ClassBuilder#addInterface(String, Clazz)} with {@code interfaceName}, {@code
   * referencedInterface}.
   *
   * <p>Method under test: {@link ClassBuilder#addInterface(String, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addInterface(String, Clazz)"})
  public void testAddInterfaceWithInterfaceNameReferencedInterface()
      throws UnsupportedEncodingException {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addInterface(String, Clazz)"})
  public void testAddInterfaceWithInterfaceNameReferencedInterface2()
      throws UnsupportedEncodingException {
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
   * Test {@link ClassBuilder#addInterface(String, Clazz)} with {@code interfaceName}, {@code
   * referencedInterface}.
   *
   * <p>Method under test: {@link ClassBuilder#addInterface(String, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addInterface(String, Clazz)"})
  public void testAddInterfaceWithInterfaceNameReferencedInterface3() {
    // Arrange
    ClassBuilder classBuilder =
        new ClassBuilder(new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(classBuilder, classBuilder.addInterface("Interface Name", new LibraryClass()));
  }

  /**
   * Test {@link ClassBuilder#addInterface(String, Clazz)} with {@code interfaceName}, {@code
   * referencedInterface}.
   *
   * <p>Method under test: {@link ClassBuilder#addInterface(String, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addInterface(String, Clazz)"})
  public void testAddInterfaceWithInterfaceNameReferencedInterface4() {
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

    // Act and Assert
    assertSame(classBuilder, classBuilder.addInterface("Interface Name", new LibraryClass()));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addInterface(String)"})
  public void testAddInterfaceWithInterfaceName_thenReturnProgramClassInterfaceCountIsTwo()
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
   * Test {@link ClassBuilder#addField(int, String, String)} with {@code u2accessFlags}, {@code
   * fieldName}, {@code fieldDescriptor}.
   *
   * <p>Method under test: {@link ClassBuilder#addField(int, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addField(int, String, String)"})
  public void testAddFieldWithU2accessFlagsFieldNameFieldDescriptor()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    Constant[] constantArray =
        (new ClassBuilder(1, 1, "Class Name", "Superclass Name"))
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
   * <p>Method under test: {@link ClassBuilder#addField(int, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addField(int, String, String)"})
  public void testAddFieldWithU2accessFlagsFieldNameFieldDescriptor2() {
    // Arrange
    ClassBuilder classBuilder =
        new ClassBuilder(new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(classBuilder, classBuilder.addField(2, "Field Name", "Field Descriptor"));
  }

  /**
   * Test {@link ClassBuilder#addField(int, String, String)} with {@code u2accessFlags}, {@code
   * fieldName}, {@code fieldDescriptor}.
   *
   * <p>Method under test: {@link ClassBuilder#addField(int, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addField(int, String, String)"})
  public void testAddFieldWithU2accessFlagsFieldNameFieldDescriptor3() {
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

    // Act and Assert
    assertSame(classBuilder, classBuilder.addField(2, "Field Name", "Field Descriptor"));
  }

  /**
   * Test {@link ClassBuilder#addField(int, String, String, MemberVisitor)} with {@code
   * u2accessFlags}, {@code fieldName}, {@code fieldDescriptor}, {@code extraMemberVisitor}.
   *
   * <p>Method under test: {@link ClassBuilder#addField(int, String, String, MemberVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addField(int, String, String, MemberVisitor)"})
  public void testAddFieldWithU2accessFlagsFieldNameFieldDescriptorExtraMemberVisitor()
      throws UnsupportedEncodingException {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");

    // Act and Assert
    Constant[] constantArray =
        classBuilder
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addField(int, String, String, MemberVisitor)"})
  public void testAddFieldWithU2accessFlagsFieldNameFieldDescriptorExtraMemberVisitor2() {
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
   * Test {@link ClassBuilder#addField(int, String, String, MemberVisitor)} with {@code
   * u2accessFlags}, {@code fieldName}, {@code fieldDescriptor}, {@code extraMemberVisitor}.
   *
   * <p>Method under test: {@link ClassBuilder#addField(int, String, String, MemberVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addField(int, String, String, MemberVisitor)"})
  public void testAddFieldWithU2accessFlagsFieldNameFieldDescriptorExtraMemberVisitor3()
      throws UnsupportedEncodingException {
    // Arrange and Act
    ClassBuilder actualAddFieldResult =
        (new ClassBuilder(1, 1, "Class Name", "Superclass Name"))
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
    byte[] expectedBytes = "Class Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
    byte[] expectedBytes2 = "Field Descriptor".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant5).getBytes());
    byte[] expectedBytes3 = "Field Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes3, ((Utf8Constant) constant4).getBytes());
    byte[] expectedBytes4 = "Superclass Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes4, ((Utf8Constant) constant3).getBytes());
  }

  /**
   * Test {@link ClassBuilder#addField(int, String, String, MemberVisitor)} with {@code
   * u2accessFlags}, {@code fieldName}, {@code fieldDescriptor}, {@code extraMemberVisitor}.
   *
   * <p>Method under test: {@link ClassBuilder#addField(int, String, String, MemberVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addField(int, String, String, MemberVisitor)"})
  public void testAddFieldWithU2accessFlagsFieldNameFieldDescriptorExtraMemberVisitor4()
      throws UnsupportedEncodingException {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");

    // Act
    ClassBuilder actualAddFieldResult =
        classBuilder.addField(2, "Field Name", "Field Descriptor", new ConstantPoolShrinker());

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
    byte[] expectedBytes = "Class Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
    byte[] expectedBytes2 = "Field Descriptor".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant5).getBytes());
    byte[] expectedBytes3 = "Field Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes3, ((Utf8Constant) constant4).getBytes());
    byte[] expectedBytes4 = "Superclass Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes4, ((Utf8Constant) constant3).getBytes());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addField(int, String, String)"})
  public void testAddFieldWithU2accessFlagsFieldNameFieldDescriptor_thenReturnArrayLengthIsTwo() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");
    classBuilder.addField(2, "Field Name", "Field Descriptor");

    // Act and Assert
    ProgramClass programClass =
        classBuilder.addField(2, "Field Name", "Field Descriptor").getProgramClass();
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
   *   <li>Then array length is two.
   * </ul>
   *
   * <p>Method under test: {@link ClassBuilder#addAndReturnField(int, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProgramField ClassBuilder.addAndReturnField(int, String, String)"})
  public void testAddAndReturnField_thenArrayLengthIsTwo() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");
    classBuilder.addField(2, "Field Name", "Field Descriptor");

    // Act
    ProgramField actualAddAndReturnFieldResult =
        classBuilder.addAndReturnField(2, "Field Name", "Field Descriptor");

    // Assert
    ProgramClass programClass = classBuilder.getProgramClass();
    ProgramField[] programFieldArray = programClass.fields;
    assertEquals(2, programFieldArray.length);
    assertEquals(2, programClass.u2fieldsCount);
    assertEquals(7, programClass.u2constantPoolCount);
    assertSame(actualAddAndReturnFieldResult.attributes, (programFieldArray[0]).attributes);
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProgramField ClassBuilder.addAndReturnField(int, String, String)"})
  public void testAddAndReturnField_thenReturnU2nameIndexIsOne() {
    // Arrange
    ProgramClass programClass =
        new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1);

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProgramField ClassBuilder.addAndReturnField(int, String, String)"})
  public void testAddAndReturnField_thenReturnU2nameIndexIsThree() {
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
   *   <li>Then sixth element {@link Utf8Constant}.
   * </ul>
   *
   * <p>Method under test: {@link ClassBuilder#addAndReturnField(int, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProgramField ClassBuilder.addAndReturnField(int, String, String)"})
  public void testAddAndReturnField_thenSixthElementUtf8Constant()
      throws UnsupportedEncodingException {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");

    // Act
    classBuilder.addAndReturnField(2, "Field Name", "Field Descriptor");

    // Assert
    ProgramClass programClass = classBuilder.getProgramClass();
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
    byte[] expectedBytes = "Field Descriptor".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
    byte[] expectedBytes2 = "Field Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant).getBytes());
  }

  /**
   * Test {@link ClassBuilder#addMethod(int, String, String)} with {@code u2accessFlags}, {@code
   * methodName}, {@code methodDescriptor}.
   *
   * <p>Method under test: {@link ClassBuilder#addMethod(int, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addMethod(int, String, String)"})
  public void testAddMethodWithU2accessFlagsMethodNameMethodDescriptor()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    Constant[] constantArray =
        (new ClassBuilder(1, 1, "Class Name", "Superclass Name"))
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addMethod(int, String, String)"})
  public void testAddMethodWithU2accessFlagsMethodNameMethodDescriptor2() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");
    classBuilder.addMethod(2, "Method Name", "Method Descriptor");

    // Act and Assert
    ProgramClass programClass =
        classBuilder.addMethod(2, "Method Name", "Method Descriptor").getProgramClass();
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addMethod(int, String, String)"})
  public void testAddMethodWithU2accessFlagsMethodNameMethodDescriptor3() {
    // Arrange
    ClassBuilder classBuilder =
        new ClassBuilder(new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(classBuilder, classBuilder.addMethod(2, "Method Name", "Method Descriptor"));
  }

  /**
   * Test {@link ClassBuilder#addMethod(int, String, String)} with {@code u2accessFlags}, {@code
   * methodName}, {@code methodDescriptor}.
   *
   * <p>Method under test: {@link ClassBuilder#addMethod(int, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addMethod(int, String, String)"})
  public void testAddMethodWithU2accessFlagsMethodNameMethodDescriptor4() {
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

    // Act and Assert
    assertSame(classBuilder, classBuilder.addMethod(2, "Method Name", "Method Descriptor"));
  }

  /**
   * Test {@link ClassBuilder#addMethod(int, String, String, MemberVisitor)} with {@code
   * u2accessFlags}, {@code methodName}, {@code methodDescriptor}, {@code extraMemberVisitor}.
   *
   * <p>Method under test: {@link ClassBuilder#addMethod(int, String, String, MemberVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addMethod(int, String, String, MemberVisitor)"})
  public void testAddMethodWithU2accessFlagsMethodNameMethodDescriptorExtraMemberVisitor()
      throws UnsupportedEncodingException {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");

    // Act and Assert
    Constant[] constantArray =
        classBuilder
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addMethod(int, String, String, MemberVisitor)"})
  public void testAddMethodWithU2accessFlagsMethodNameMethodDescriptorExtraMemberVisitor2() {
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
   * Test {@link ClassBuilder#addMethod(int, String, String, MemberVisitor)} with {@code
   * u2accessFlags}, {@code methodName}, {@code methodDescriptor}, {@code extraMemberVisitor}.
   *
   * <p>Method under test: {@link ClassBuilder#addMethod(int, String, String, MemberVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addMethod(int, String, String, MemberVisitor)"})
  public void testAddMethodWithU2accessFlagsMethodNameMethodDescriptorExtraMemberVisitor3()
      throws UnsupportedEncodingException {
    // Arrange and Act
    ClassBuilder actualAddMethodResult =
        (new ClassBuilder(1, 1, "Class Name", "Superclass Name"))
            .addMethod(2, "Method Name", "Method Descriptor", null);

    // Assert
    ProgramClass programClass = actualAddMethodResult.getProgramClass();
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
    assertSame(programClass, actualAddMethodResult.getConstantPoolEditor().getTargetClass());
    assertSame(programClass, ((ClassConstant) constant).referencedClass);
    byte[] expectedBytes = "Class Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
    byte[] expectedBytes2 = "Method Descriptor".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant5).getBytes());
    byte[] expectedBytes3 = "Method Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes3, ((Utf8Constant) constant4).getBytes());
    byte[] expectedBytes4 = "Superclass Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes4, ((Utf8Constant) constant3).getBytes());
  }

  /**
   * Test {@link ClassBuilder#addMethod(int, String, String, MemberVisitor)} with {@code
   * u2accessFlags}, {@code methodName}, {@code methodDescriptor}, {@code extraMemberVisitor}.
   *
   * <p>Method under test: {@link ClassBuilder#addMethod(int, String, String, MemberVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addMethod(int, String, String, MemberVisitor)"})
  public void testAddMethodWithU2accessFlagsMethodNameMethodDescriptorExtraMemberVisitor4()
      throws UnsupportedEncodingException {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");

    // Act
    ClassBuilder actualAddMethodResult =
        classBuilder.addMethod(
            2, "Method Name", "Method Descriptor", new BootstrapMethodsAttributeShrinker());

    // Assert
    ProgramClass programClass = actualAddMethodResult.getProgramClass();
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
    assertSame(programClass, actualAddMethodResult.getConstantPoolEditor().getTargetClass());
    assertSame(programClass, ((ClassConstant) constant).referencedClass);
    byte[] expectedBytes = "Class Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
    byte[] expectedBytes2 = "Method Descriptor".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant5).getBytes());
    byte[] expectedBytes3 = "Method Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes3, ((Utf8Constant) constant4).getBytes());
    byte[] expectedBytes4 = "Superclass Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes4, ((Utf8Constant) constant3).getBytes());
  }

  /**
   * Test {@link ClassBuilder#addMethod(int, String, String, MemberVisitor)} with {@code
   * u2accessFlags}, {@code methodName}, {@code methodDescriptor}, {@code extraMemberVisitor}.
   *
   * <p>Method under test: {@link ClassBuilder#addMethod(int, String, String, MemberVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addMethod(int, String, String, MemberVisitor)"})
  public void testAddMethodWithU2accessFlagsMethodNameMethodDescriptorExtraMemberVisitor5()
      throws UnsupportedEncodingException {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");

    // Act
    ClassBuilder actualAddMethodResult =
        classBuilder.addMethod(2, "Method Name", "Method Descriptor", new BridgeMethodFixer());

    // Assert
    ProgramClass programClass = actualAddMethodResult.getProgramClass();
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
    assertSame(programClass, actualAddMethodResult.getConstantPoolEditor().getTargetClass());
    assertSame(programClass, ((ClassConstant) constant).referencedClass);
    byte[] expectedBytes = "Class Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
    byte[] expectedBytes2 = "Method Descriptor".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant5).getBytes());
    byte[] expectedBytes3 = "Method Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes3, ((Utf8Constant) constant4).getBytes());
    byte[] expectedBytes4 = "Superclass Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes4, ((Utf8Constant) constant3).getBytes());
  }

  /**
   * Test {@link ClassBuilder#addMethod(int, String, String, MemberVisitor)} with {@code
   * u2accessFlags}, {@code methodName}, {@code methodDescriptor}, {@code extraMemberVisitor}.
   *
   * <p>Method under test: {@link ClassBuilder#addMethod(int, String, String, MemberVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addMethod(int, String, String, MemberVisitor)"})
  public void testAddMethodWithU2accessFlagsMethodNameMethodDescriptorExtraMemberVisitor6()
      throws UnsupportedEncodingException {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");

    // Act
    ClassBuilder actualAddMethodResult =
        classBuilder.addMethod(2, "Method Name", "Method Descriptor", new ConstantPoolShrinker());

    // Assert
    ProgramClass programClass = actualAddMethodResult.getProgramClass();
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
    assertSame(programClass, actualAddMethodResult.getConstantPoolEditor().getTargetClass());
    assertSame(programClass, ((ClassConstant) constant).referencedClass);
    byte[] expectedBytes = "Class Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
    byte[] expectedBytes2 = "Method Descriptor".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant5).getBytes());
    byte[] expectedBytes3 = "Method Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes3, ((Utf8Constant) constant4).getBytes());
    byte[] expectedBytes4 = "Superclass Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes4, ((Utf8Constant) constant3).getBytes());
  }

  /**
   * Test {@link ClassBuilder#addMethod(int, String, String, int, CodeBuilder)} with {@code
   * u2accessFlags}, {@code methodName}, {@code methodDescriptor}, {@code maxCodeFragmentLength},
   * {@code codeBuilder}.
   *
   * <p>Method under test: {@link ClassBuilder#addMethod(int, String, String, int, CodeBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addMethod(int, String, String, int, CodeBuilder)"})
  public void
      testAddMethodWithU2accessFlagsMethodNameMethodDescriptorMaxCodeFragmentLengthCodeBuilder()
          throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    Constant[] constantArray =
        (new ClassBuilder(1, 1, "Class Name", "Superclass Name"))
            .addMethod(2, "Method Name", "Method Descriptor", 3, null)
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
   * Test {@link ClassBuilder#addMethod(int, String, String, int, CodeBuilder)} with {@code
   * u2accessFlags}, {@code methodName}, {@code methodDescriptor}, {@code maxCodeFragmentLength},
   * {@code codeBuilder}.
   *
   * <p>Method under test: {@link ClassBuilder#addMethod(int, String, String, int, CodeBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addMethod(int, String, String, int, CodeBuilder)"})
  public void
      testAddMethodWithU2accessFlagsMethodNameMethodDescriptorMaxCodeFragmentLengthCodeBuilder2() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");
    classBuilder.addMethod(2, "Method Name", "Method Descriptor");

    // Act and Assert
    ProgramClass programClass =
        classBuilder.addMethod(2, "Method Name", "Method Descriptor", 3, null).getProgramClass();
    Constant[] constantArray = programClass.constantPool;
    assertTrue(constantArray[5] instanceof Utf8Constant);
    assertTrue(constantArray[6] instanceof Utf8Constant);
    assertEquals(2, programClass.methods.length);
    assertEquals(2, programClass.u2methodsCount);
    assertEquals(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, constantArray.length);
  }

  /**
   * Test {@link ClassBuilder#addMethod(int, String, String, int, CodeBuilder)} with {@code
   * u2accessFlags}, {@code methodName}, {@code methodDescriptor}, {@code maxCodeFragmentLength},
   * {@code codeBuilder}.
   *
   * <p>Method under test: {@link ClassBuilder#addMethod(int, String, String, int, CodeBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addMethod(int, String, String, int, CodeBuilder)"})
  public void
      testAddMethodWithU2accessFlagsMethodNameMethodDescriptorMaxCodeFragmentLengthCodeBuilder3() {
    // Arrange
    ClassBuilder classBuilder =
        new ClassBuilder(new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        classBuilder, classBuilder.addMethod(2, "Method Name", "Method Descriptor", 3, null));
  }

  /**
   * Test {@link ClassBuilder#addMethod(int, String, String, int, CodeBuilder)} with {@code
   * u2accessFlags}, {@code methodName}, {@code methodDescriptor}, {@code maxCodeFragmentLength},
   * {@code codeBuilder}.
   *
   * <p>Method under test: {@link ClassBuilder#addMethod(int, String, String, int, CodeBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassBuilder ClassBuilder.addMethod(int, String, String, int, CodeBuilder)"})
  public void
      testAddMethodWithU2accessFlagsMethodNameMethodDescriptorMaxCodeFragmentLengthCodeBuilder4() {
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

    // Act and Assert
    assertSame(
        classBuilder, classBuilder.addMethod(2, "Method Name", "Method Descriptor", 3, null));
  }

  /**
   * Test {@link ClassBuilder#addMethod(int, String, String, int, CodeBuilder, MemberVisitor)} with
   * {@code u2accessFlags}, {@code methodName}, {@code methodDescriptor}, {@code
   * maxCodeFragmentLength}, {@code codeBuilder}, {@code extraMemberVisitor}.
   *
   * <p>Method under test: {@link ClassBuilder#addMethod(int, String, String, int, CodeBuilder,
   * MemberVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ClassBuilder ClassBuilder.addMethod(int, String, String, int, CodeBuilder, MemberVisitor)"
  })
  public void
      testAddMethodWithU2accessFlagsMethodNameMethodDescriptorMaxCodeFragmentLengthCodeBuilderExtraMemberVisitor()
          throws UnsupportedEncodingException {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");

    // Act and Assert
    Constant[] constantArray =
        classBuilder
            .addMethod(2, "Method Name", "Method Descriptor", 3, null, new AttributeSorter())
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
   * Test {@link ClassBuilder#addMethod(int, String, String, int, CodeBuilder, MemberVisitor)} with
   * {@code u2accessFlags}, {@code methodName}, {@code methodDescriptor}, {@code
   * maxCodeFragmentLength}, {@code codeBuilder}, {@code extraMemberVisitor}.
   *
   * <p>Method under test: {@link ClassBuilder#addMethod(int, String, String, int, CodeBuilder,
   * MemberVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ClassBuilder ClassBuilder.addMethod(int, String, String, int, CodeBuilder, MemberVisitor)"
  })
  public void
      testAddMethodWithU2accessFlagsMethodNameMethodDescriptorMaxCodeFragmentLengthCodeBuilderExtraMemberVisitor2() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");
    classBuilder.addMethod(2, "Method Name", "Method Descriptor");

    // Act and Assert
    ProgramClass programClass =
        classBuilder
            .addMethod(2, "Method Name", "Method Descriptor", 3, null, new AttributeSorter())
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
   * Test {@link ClassBuilder#addMethod(int, String, String, int, CodeBuilder, MemberVisitor)} with
   * {@code u2accessFlags}, {@code methodName}, {@code methodDescriptor}, {@code
   * maxCodeFragmentLength}, {@code codeBuilder}, {@code extraMemberVisitor}.
   *
   * <p>Method under test: {@link ClassBuilder#addMethod(int, String, String, int, CodeBuilder,
   * MemberVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ClassBuilder ClassBuilder.addMethod(int, String, String, int, CodeBuilder, MemberVisitor)"
  })
  public void
      testAddMethodWithU2accessFlagsMethodNameMethodDescriptorMaxCodeFragmentLengthCodeBuilderExtraMemberVisitor3()
          throws UnsupportedEncodingException {
    // Arrange and Act
    ClassBuilder actualAddMethodResult =
        (new ClassBuilder(1, 1, "Class Name", "Superclass Name"))
            .addMethod(2, "Method Name", "Method Descriptor", 3, null, null);

    // Assert
    ProgramClass programClass = actualAddMethodResult.getProgramClass();
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
    assertSame(programClass, actualAddMethodResult.getConstantPoolEditor().getTargetClass());
    assertSame(programClass, ((ClassConstant) constant).referencedClass);
    byte[] expectedBytes = "Class Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
    byte[] expectedBytes2 = "Method Descriptor".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant5).getBytes());
    byte[] expectedBytes3 = "Method Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes3, ((Utf8Constant) constant4).getBytes());
    byte[] expectedBytes4 = "Superclass Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes4, ((Utf8Constant) constant3).getBytes());
  }

  /**
   * Test {@link ClassBuilder#addMethod(int, String, String, int, CodeBuilder, MemberVisitor)} with
   * {@code u2accessFlags}, {@code methodName}, {@code methodDescriptor}, {@code
   * maxCodeFragmentLength}, {@code codeBuilder}, {@code extraMemberVisitor}.
   *
   * <p>Method under test: {@link ClassBuilder#addMethod(int, String, String, int, CodeBuilder,
   * MemberVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ClassBuilder ClassBuilder.addMethod(int, String, String, int, CodeBuilder, MemberVisitor)"
  })
  public void
      testAddMethodWithU2accessFlagsMethodNameMethodDescriptorMaxCodeFragmentLengthCodeBuilderExtraMemberVisitor4()
          throws UnsupportedEncodingException {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");

    // Act
    ClassBuilder actualAddMethodResult =
        classBuilder.addMethod(
            2,
            "Method Name",
            "Method Descriptor",
            3,
            null,
            new BootstrapMethodsAttributeShrinker());

    // Assert
    ProgramClass programClass = actualAddMethodResult.getProgramClass();
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
    assertSame(programClass, actualAddMethodResult.getConstantPoolEditor().getTargetClass());
    assertSame(programClass, ((ClassConstant) constant).referencedClass);
    byte[] expectedBytes = "Class Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
    byte[] expectedBytes2 = "Method Descriptor".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant5).getBytes());
    byte[] expectedBytes3 = "Method Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes3, ((Utf8Constant) constant4).getBytes());
    byte[] expectedBytes4 = "Superclass Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes4, ((Utf8Constant) constant3).getBytes());
  }

  /**
   * Test {@link ClassBuilder#addMethod(int, String, String, int, CodeBuilder, MemberVisitor)} with
   * {@code u2accessFlags}, {@code methodName}, {@code methodDescriptor}, {@code
   * maxCodeFragmentLength}, {@code codeBuilder}, {@code extraMemberVisitor}.
   *
   * <p>Method under test: {@link ClassBuilder#addMethod(int, String, String, int, CodeBuilder,
   * MemberVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ClassBuilder ClassBuilder.addMethod(int, String, String, int, CodeBuilder, MemberVisitor)"
  })
  public void
      testAddMethodWithU2accessFlagsMethodNameMethodDescriptorMaxCodeFragmentLengthCodeBuilderExtraMemberVisitor5()
          throws UnsupportedEncodingException {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");

    // Act
    ClassBuilder actualAddMethodResult =
        classBuilder.addMethod(
            2, "Method Name", "Method Descriptor", 3, null, new BridgeMethodFixer());

    // Assert
    ProgramClass programClass = actualAddMethodResult.getProgramClass();
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
    assertSame(programClass, actualAddMethodResult.getConstantPoolEditor().getTargetClass());
    assertSame(programClass, ((ClassConstant) constant).referencedClass);
    byte[] expectedBytes = "Class Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
    byte[] expectedBytes2 = "Method Descriptor".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant5).getBytes());
    byte[] expectedBytes3 = "Method Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes3, ((Utf8Constant) constant4).getBytes());
    byte[] expectedBytes4 = "Superclass Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes4, ((Utf8Constant) constant3).getBytes());
  }

  /**
   * Test {@link ClassBuilder#addMethod(int, String, String, int, CodeBuilder, MemberVisitor)} with
   * {@code u2accessFlags}, {@code methodName}, {@code methodDescriptor}, {@code
   * maxCodeFragmentLength}, {@code codeBuilder}, {@code extraMemberVisitor}.
   *
   * <p>Method under test: {@link ClassBuilder#addMethod(int, String, String, int, CodeBuilder,
   * MemberVisitor)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ClassBuilder ClassBuilder.addMethod(int, String, String, int, CodeBuilder, MemberVisitor)"
  })
  public void
      testAddMethodWithU2accessFlagsMethodNameMethodDescriptorMaxCodeFragmentLengthCodeBuilderExtraMemberVisitor6()
          throws UnsupportedEncodingException {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");

    // Act
    ClassBuilder actualAddMethodResult =
        classBuilder.addMethod(
            2, "Method Name", "Method Descriptor", 3, null, new ConstantPoolShrinker());

    // Assert
    ProgramClass programClass = actualAddMethodResult.getProgramClass();
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
    assertSame(programClass, actualAddMethodResult.getConstantPoolEditor().getTargetClass());
    assertSame(programClass, ((ClassConstant) constant).referencedClass);
    byte[] expectedBytes = "Class Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
    byte[] expectedBytes2 = "Method Descriptor".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant5).getBytes());
    byte[] expectedBytes3 = "Method Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes3, ((Utf8Constant) constant4).getBytes());
    byte[] expectedBytes4 = "Superclass Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes4, ((Utf8Constant) constant3).getBytes());
  }

  /**
   * Test {@link ClassBuilder#addAndReturnMethod(int, String, String)} with {@code u2accessFlags},
   * {@code methodName}, {@code methodDescriptor}.
   *
   * <p>Method under test: {@link ClassBuilder#addAndReturnMethod(int, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProgramMethod ClassBuilder.addAndReturnMethod(int, String, String)"})
  public void testAddAndReturnMethodWithU2accessFlagsMethodNameMethodDescriptor()
      throws UnsupportedEncodingException {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");

    // Act
    classBuilder.addAndReturnMethod(2, "Method Name", "Method Descriptor");

    // Assert
    ProgramClass programClass = classBuilder.getProgramClass();
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
    byte[] expectedBytes = "Method Descriptor".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
    byte[] expectedBytes2 = "Method Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant).getBytes());
  }

  /**
   * Test {@link ClassBuilder#addAndReturnMethod(int, String, String)} with {@code u2accessFlags},
   * {@code methodName}, {@code methodDescriptor}.
   *
   * <p>Method under test: {@link ClassBuilder#addAndReturnMethod(int, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProgramMethod ClassBuilder.addAndReturnMethod(int, String, String)"})
  public void testAddAndReturnMethodWithU2accessFlagsMethodNameMethodDescriptor2() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");
    classBuilder.addMethod(2, "Method Name", "Method Descriptor");

    // Act
    ProgramMethod actualAddAndReturnMethodResult =
        classBuilder.addAndReturnMethod(2, "Method Name", "Method Descriptor");

    // Assert
    ProgramClass programClass = classBuilder.getProgramClass();
    ProgramMethod[] programMethodArray = programClass.methods;
    assertEquals(2, programMethodArray.length);
    assertEquals(2, programClass.u2methodsCount);
    assertEquals(7, programClass.u2constantPoolCount);
    assertSame(actualAddAndReturnMethodResult.attributes, (programMethodArray[0]).attributes);
  }

  /**
   * Test {@link ClassBuilder#addAndReturnMethod(int, String, String)} with {@code u2accessFlags},
   * {@code methodName}, {@code methodDescriptor}.
   *
   * <p>Method under test: {@link ClassBuilder#addAndReturnMethod(int, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProgramMethod ClassBuilder.addAndReturnMethod(int, String, String)"})
  public void testAddAndReturnMethodWithU2accessFlagsMethodNameMethodDescriptor3() {
    // Arrange
    ProgramClass programClass =
        new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1);

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProgramMethod ClassBuilder.addAndReturnMethod(int, String, String)"})
  public void testAddAndReturnMethodWithU2accessFlagsMethodNameMethodDescriptor4() {
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

  /**
   * Test {@link ClassBuilder#addAndReturnMethod(int, String, String, int, CodeBuilder)} with {@code
   * u2accessFlags}, {@code methodName}, {@code methodDescriptor}, {@code maxCodeFragmentLength},
   * {@code codeBuilder}.
   *
   * <p>Method under test: {@link ClassBuilder#addAndReturnMethod(int, String, String, int,
   * CodeBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ProgramMethod ClassBuilder.addAndReturnMethod(int, String, String, int, CodeBuilder)"
  })
  public void
      testAddAndReturnMethodWithU2accessFlagsMethodNameMethodDescriptorMaxCodeFragmentLengthCodeBuilder()
          throws UnsupportedEncodingException {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");

    // Act
    classBuilder.addAndReturnMethod(2, "Method Name", "Method Descriptor", 3, null);

    // Assert
    ProgramClass programClass = classBuilder.getProgramClass();
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
    byte[] expectedBytes = "Method Descriptor".getBytes("UTF-8");
    assertArrayEquals(expectedBytes, ((Utf8Constant) constant2).getBytes());
    byte[] expectedBytes2 = "Method Name".getBytes("UTF-8");
    assertArrayEquals(expectedBytes2, ((Utf8Constant) constant).getBytes());
  }

  /**
   * Test {@link ClassBuilder#addAndReturnMethod(int, String, String, int, CodeBuilder)} with {@code
   * u2accessFlags}, {@code methodName}, {@code methodDescriptor}, {@code maxCodeFragmentLength},
   * {@code codeBuilder}.
   *
   * <p>Method under test: {@link ClassBuilder#addAndReturnMethod(int, String, String, int,
   * CodeBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ProgramMethod ClassBuilder.addAndReturnMethod(int, String, String, int, CodeBuilder)"
  })
  public void
      testAddAndReturnMethodWithU2accessFlagsMethodNameMethodDescriptorMaxCodeFragmentLengthCodeBuilder2() {
    // Arrange
    ClassBuilder classBuilder = new ClassBuilder(1, 1, "Class Name", "Superclass Name");
    classBuilder.addMethod(2, "Method Name", "Method Descriptor");

    // Act
    ProgramMethod actualAddAndReturnMethodResult =
        classBuilder.addAndReturnMethod(2, "Method Name", "Method Descriptor", 3, null);

    // Assert
    ProgramClass programClass = classBuilder.getProgramClass();
    ProgramMethod[] programMethodArray = programClass.methods;
    assertEquals(2, programMethodArray.length);
    assertEquals(2, programClass.u2methodsCount);
    assertEquals(7, programClass.u2constantPoolCount);
    assertSame(actualAddAndReturnMethodResult.attributes, (programMethodArray[0]).attributes);
  }

  /**
   * Test {@link ClassBuilder#addAndReturnMethod(int, String, String, int, CodeBuilder)} with {@code
   * u2accessFlags}, {@code methodName}, {@code methodDescriptor}, {@code maxCodeFragmentLength},
   * {@code codeBuilder}.
   *
   * <p>Method under test: {@link ClassBuilder#addAndReturnMethod(int, String, String, int,
   * CodeBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ProgramMethod ClassBuilder.addAndReturnMethod(int, String, String, int, CodeBuilder)"
  })
  public void
      testAddAndReturnMethodWithU2accessFlagsMethodNameMethodDescriptorMaxCodeFragmentLengthCodeBuilder3() {
    // Arrange
    ProgramClass programClass =
        new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1);

    ClassBuilder classBuilder = new ClassBuilder(programClass);

    // Act
    ProgramMethod actualAddAndReturnMethodResult =
        classBuilder.addAndReturnMethod(2, "Method Name", "Method Descriptor", 3, null);

    // Assert
    assertEquals(1, actualAddAndReturnMethodResult.u2nameIndex);
    assertEquals(2, actualAddAndReturnMethodResult.u2descriptorIndex);
    ProgramClass programClass2 = classBuilder.getProgramClass();
    assertEquals(3, programClass2.u2constantPoolCount);
    assertSame(programClass.constantPool, programClass2.constantPool);
  }

  /**
   * Test {@link ClassBuilder#addAndReturnMethod(int, String, String, int, CodeBuilder)} with {@code
   * u2accessFlags}, {@code methodName}, {@code methodDescriptor}, {@code maxCodeFragmentLength},
   * {@code codeBuilder}.
   *
   * <p>Method under test: {@link ClassBuilder#addAndReturnMethod(int, String, String, int,
   * CodeBuilder)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ProgramMethod ClassBuilder.addAndReturnMethod(int, String, String, int, CodeBuilder)"
  })
  public void
      testAddAndReturnMethodWithU2accessFlagsMethodNameMethodDescriptorMaxCodeFragmentLengthCodeBuilder4() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass programClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 1, 1, 1);

    ClassBuilder classBuilder = new ClassBuilder(programClass);

    // Act
    ProgramMethod actualAddAndReturnMethodResult =
        classBuilder.addAndReturnMethod(2, "Method Name", "Method Descriptor", 3, null);

    // Assert
    assertEquals(3, actualAddAndReturnMethodResult.u2nameIndex);
    assertEquals(4, actualAddAndReturnMethodResult.u2descriptorIndex);
    ProgramClass programClass2 = classBuilder.getProgramClass();
    assertEquals(5, programClass2.u2constantPoolCount);
    assertSame(programClass.constantPool, programClass2.constantPool);
  }
}
