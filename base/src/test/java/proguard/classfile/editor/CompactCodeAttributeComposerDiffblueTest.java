package proguard.classfile.editor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.ClassPool;
import proguard.classfile.Clazz;
import proguard.classfile.Field;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Member;
import proguard.classfile.Method;
import proguard.classfile.ProgramClass;
import proguard.classfile.attribute.Attribute;
import proguard.classfile.attribute.BootstrapMethodsAttribute;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.constant.DoubleConstant;
import proguard.classfile.constant.FieldrefConstant;
import proguard.classfile.constant.FloatConstant;
import proguard.classfile.constant.LongConstant;
import proguard.classfile.constant.MethodrefConstant;
import proguard.classfile.constant.NameAndTypeConstant;
import proguard.classfile.constant.Utf8Constant;
import proguard.classfile.instruction.BranchInstruction;
import proguard.classfile.instruction.ConstantInstruction;
import proguard.classfile.instruction.Instruction;
import proguard.classfile.instruction.LookUpSwitchInstruction;
import proguard.classfile.instruction.SimpleInstruction;
import proguard.classfile.instruction.TableSwitchInstruction;
import proguard.classfile.instruction.VariableInstruction;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.resources.file.ResourceFile;

public class CompactCodeAttributeComposerDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CompactCodeAttributeComposer#CompactCodeAttributeComposer(ConstantPoolEditor,
   *       CodeAttributeComposer)}
   *   <li>{@link CompactCodeAttributeComposer#visitAnyAttribute(Clazz, Attribute)}
   *   <li>{@link CompactCodeAttributeComposer#getConstantPoolEditor()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void CompactCodeAttributeComposer.<init>(ConstantPoolEditor, CodeAttributeComposer)",
    "ConstantPoolEditor CompactCodeAttributeComposer.getConstantPoolEditor()",
    "void CompactCodeAttributeComposer.visitAnyAttribute(Clazz, Attribute)"
  })
  public void testGettersAndSetters() {
    // Arrange
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualCompactCodeAttributeComposer =
        new CompactCodeAttributeComposer(constantPoolEditor, new CodeAttributeComposer());
    LibraryClass clazz = new LibraryClass();
    actualCompactCodeAttributeComposer.visitAnyAttribute(clazz, new BootstrapMethodsAttribute());

    // Assert
    assertSame(constantPoolEditor, actualCompactCodeAttributeComposer.getConstantPoolEditor());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#CompactCodeAttributeComposer(ConstantPoolEditor,
   * boolean, boolean, boolean)}.
   *
   * <p>Method under test: {@link
   * CompactCodeAttributeComposer#CompactCodeAttributeComposer(ConstantPoolEditor, boolean, boolean,
   * boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void CompactCodeAttributeComposer.<init>(ConstantPoolEditor, boolean, boolean, boolean)"
  })
  public void testNewCompactCodeAttributeComposer() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act
    CompactCodeAttributeComposer actualCompactCodeAttributeComposer =
        new CompactCodeAttributeComposer(constantPoolEditor, true, true, true);

    // Assert
    assertEquals(0, actualCompactCodeAttributeComposer.getCodeLength());
    assertSame(targetClass, actualCompactCodeAttributeComposer.getTargetClass());
    assertSame(constantPoolEditor, actualCompactCodeAttributeComposer.getConstantPoolEditor());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass, ClassPool,
   * ClassPool)}.
   *
   * <ul>
   *   <li>Given one.
   * </ul>
   *
   * <p>Method under test: {@link
   * CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass, ClassPool, ClassPool)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void CompactCodeAttributeComposer.<init>(ProgramClass, ClassPool, ClassPool)"
  })
  public void testNewCompactCodeAttributeComposer_givenOne() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    targetClass.u2constantPoolCount = 1;

    // Act
    CompactCodeAttributeComposer actualCompactCodeAttributeComposer =
        new CompactCodeAttributeComposer(targetClass, null, KotlinConstants.dummyClassPool);

    // Assert
    assertEquals(0, actualCompactCodeAttributeComposer.getCodeLength());
    assertSame(targetClass, actualCompactCodeAttributeComposer.getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass, boolean,
   * boolean, boolean, ClassPool, ClassPool)}.
   *
   * <ul>
   *   <li>Given one.
   * </ul>
   *
   * <p>Method under test: {@link
   * CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass, boolean, boolean,
   * boolean, ClassPool, ClassPool)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void CompactCodeAttributeComposer.<init>(ProgramClass, boolean, boolean, boolean, ClassPool, ClassPool)"
  })
  public void testNewCompactCodeAttributeComposer_givenOne2() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    targetClass.u2constantPoolCount = 1;

    // Act
    CompactCodeAttributeComposer actualCompactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            targetClass, true, true, true, null, KotlinConstants.dummyClassPool);

    // Assert
    assertEquals(0, actualCompactCodeAttributeComposer.getCodeLength());
    assertSame(targetClass, actualCompactCodeAttributeComposer.getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass)}.
   *
   * <ul>
   *   <li>Given two.
   * </ul>
   *
   * <p>Method under test: {@link
   * CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CompactCodeAttributeComposer.<init>(ProgramClass)"})
  public void testNewCompactCodeAttributeComposer_givenTwo() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    targetClass.u2constantPoolCount = 2;

    // Act
    CompactCodeAttributeComposer actualCompactCodeAttributeComposer =
        new CompactCodeAttributeComposer(targetClass);

    // Assert
    assertEquals(0, actualCompactCodeAttributeComposer.getCodeLength());
    assertSame(targetClass, actualCompactCodeAttributeComposer.getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass, ClassPool,
   * ClassPool)}.
   *
   * <ul>
   *   <li>Given two.
   * </ul>
   *
   * <p>Method under test: {@link
   * CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass, ClassPool, ClassPool)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void CompactCodeAttributeComposer.<init>(ProgramClass, ClassPool, ClassPool)"
  })
  public void testNewCompactCodeAttributeComposer_givenTwo2() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    targetClass.u2constantPoolCount = 2;

    // Act
    CompactCodeAttributeComposer actualCompactCodeAttributeComposer =
        new CompactCodeAttributeComposer(targetClass, null, KotlinConstants.dummyClassPool);

    // Assert
    assertEquals(0, actualCompactCodeAttributeComposer.getCodeLength());
    assertSame(targetClass, actualCompactCodeAttributeComposer.getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass, boolean,
   * boolean, boolean)}.
   *
   * <ul>
   *   <li>Given two.
   * </ul>
   *
   * <p>Method under test: {@link
   * CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass, boolean, boolean,
   * boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void CompactCodeAttributeComposer.<init>(ProgramClass, boolean, boolean, boolean)"
  })
  public void testNewCompactCodeAttributeComposer_givenTwo3() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    targetClass.u2constantPoolCount = 2;

    // Act
    CompactCodeAttributeComposer actualCompactCodeAttributeComposer =
        new CompactCodeAttributeComposer(targetClass, true, true, true);

    // Assert
    assertEquals(0, actualCompactCodeAttributeComposer.getCodeLength());
    assertSame(targetClass, actualCompactCodeAttributeComposer.getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass, boolean,
   * boolean, boolean, ClassPool, ClassPool)}.
   *
   * <ul>
   *   <li>Given two.
   * </ul>
   *
   * <p>Method under test: {@link
   * CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass, boolean, boolean,
   * boolean, ClassPool, ClassPool)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void CompactCodeAttributeComposer.<init>(ProgramClass, boolean, boolean, boolean, ClassPool, ClassPool)"
  })
  public void testNewCompactCodeAttributeComposer_givenTwo4() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    targetClass.u2constantPoolCount = 2;

    // Act
    CompactCodeAttributeComposer actualCompactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            targetClass, true, true, true, null, KotlinConstants.dummyClassPool);

    // Assert
    assertEquals(0, actualCompactCodeAttributeComposer.getCodeLength());
    assertSame(targetClass, actualCompactCodeAttributeComposer.getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass)}.
   *
   * <ul>
   *   <li>When {@link ProgramClass#ProgramClass()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CompactCodeAttributeComposer.<init>(ProgramClass)"})
  public void testNewCompactCodeAttributeComposer_whenProgramClass() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act
    CompactCodeAttributeComposer actualCompactCodeAttributeComposer =
        new CompactCodeAttributeComposer(targetClass);

    // Assert
    assertEquals(0, actualCompactCodeAttributeComposer.getCodeLength());
    assertSame(targetClass, actualCompactCodeAttributeComposer.getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass, ClassPool,
   * ClassPool)}.
   *
   * <ul>
   *   <li>When {@link ProgramClass#ProgramClass()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass, ClassPool, ClassPool)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void CompactCodeAttributeComposer.<init>(ProgramClass, ClassPool, ClassPool)"
  })
  public void testNewCompactCodeAttributeComposer_whenProgramClass2() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act
    CompactCodeAttributeComposer actualCompactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            targetClass, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);

    // Assert
    assertEquals(0, actualCompactCodeAttributeComposer.getCodeLength());
    assertSame(targetClass, actualCompactCodeAttributeComposer.getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass, boolean,
   * boolean, boolean)}.
   *
   * <ul>
   *   <li>When {@link ProgramClass#ProgramClass()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass, boolean, boolean,
   * boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void CompactCodeAttributeComposer.<init>(ProgramClass, boolean, boolean, boolean)"
  })
  public void testNewCompactCodeAttributeComposer_whenProgramClass3() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act
    CompactCodeAttributeComposer actualCompactCodeAttributeComposer =
        new CompactCodeAttributeComposer(targetClass, true, true, true);

    // Assert
    assertEquals(0, actualCompactCodeAttributeComposer.getCodeLength());
    assertSame(targetClass, actualCompactCodeAttributeComposer.getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass, boolean,
   * boolean, boolean, ClassPool, ClassPool)}.
   *
   * <ul>
   *   <li>When {@link ProgramClass#ProgramClass()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass, boolean, boolean,
   * boolean, ClassPool, ClassPool)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void CompactCodeAttributeComposer.<init>(ProgramClass, boolean, boolean, boolean, ClassPool, ClassPool)"
  })
  public void testNewCompactCodeAttributeComposer_whenProgramClass4() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act
    CompactCodeAttributeComposer actualCompactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            targetClass,
            true,
            true,
            true,
            KotlinConstants.dummyClassPool,
            KotlinConstants.dummyClassPool);

    // Assert
    assertEquals(0, actualCompactCodeAttributeComposer.getCodeLength());
    assertSame(targetClass, actualCompactCodeAttributeComposer.getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#getTargetClass()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#getTargetClass()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProgramClass CompactCodeAttributeComposer.getTargetClass()"})
  public void testGetTargetClass() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act and Assert
    assertSame(targetClass, (new CompactCodeAttributeComposer(targetClass)).getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#getCodeLength()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#getCodeLength()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int CompactCodeAttributeComposer.getCodeLength()"})
  public void testGetCodeLength() {
    // Arrange, Act and Assert
    assertEquals(0, (new CompactCodeAttributeComposer(new ProgramClass())).getCodeLength());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#convertToTargetType(String, String)}.
   *
   * <ul>
   *   <li>Then eighth element return {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#convertToTargetType(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.convertToTargetType(String, String)"
  })
  public void testConvertToTargetType_thenEighthElementReturnClassConstant() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(90, 1, new Constant[] {new ClassConstant()}, 90, 90, 90));
    compactCodeAttributeComposer.putstatic("java/lang/Short", "java/lang/Short", "java/lang/Short");
    compactCodeAttributeComposer.putstatic(
        "(S)Ljava/lang/Short;", "(S)Ljava/lang/Short;", "(S)Ljava/lang/Short;");

    // Act
    CompactCodeAttributeComposer actualConvertToTargetTypeResult =
        compactCodeAttributeComposer.convertToTargetType("Source Type", "Target Type");

    // Assert
    ProgramClass targetClass = actualConvertToTargetTypeResult.getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[7] instanceof ClassConstant);
    assertTrue(constantArray[8] instanceof FieldrefConstant);
    assertTrue(constantArray[11] instanceof MethodrefConstant);
    assertTrue(constantArray[10] instanceof NameAndTypeConstant);
    assertTrue(constantArray[9] instanceof Utf8Constant);
    assertEquals(12, targetClass.u2constantPoolCount);
    assertEquals(17, constantArray.length);
    assertEquals(9, compactCodeAttributeComposer.getCodeLength());
    assertEquals(9, actualConvertToTargetTypeResult.getCodeLength());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#convertToTargetType(String, String)}.
   *
   * <ul>
   *   <li>Then fifth element return {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#convertToTargetType(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.convertToTargetType(String, String)"
  })
  public void testConvertToTargetType_thenFifthElementReturnClassConstant() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(90, 1, new Constant[] {new ClassConstant()}, 90, 90, 90));
    compactCodeAttributeComposer.putstatic(
        "(S)Ljava/lang/Short;", "valueOf", "(S)Ljava/lang/Short;");

    // Act and Assert
    Constant[] constantArray =
        compactCodeAttributeComposer
            .convertToTargetType("Source Type", "Target Type")
            .getTargetClass()
            .constantPool;
    assertTrue(constantArray[4] instanceof ClassConstant);
    assertTrue(constantArray[5] instanceof FieldrefConstant);
    assertTrue(constantArray[8] instanceof MethodrefConstant);
    assertTrue(constantArray[2] instanceof Utf8Constant);
    assertTrue(constantArray[6] instanceof Utf8Constant);
    assertEquals(17, constantArray.length);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#convertToTargetType(String, String)}.
   *
   * <ul>
   *   <li>Then ninth element return {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#convertToTargetType(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.convertToTargetType(String, String)"
  })
  public void testConvertToTargetType_thenNinthElementReturnClassConstant() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(90, 1, new Constant[] {new ClassConstant()}, 90, 90, 90));
    compactCodeAttributeComposer.putstatic(
        "(S)Ljava/lang/Short;", "(S)Ljava/lang/Short;", "(S)Ljava/lang/Short;");

    // Act and Assert
    ProgramClass targetClass =
        compactCodeAttributeComposer
            .convertToTargetType("Source Type", "Target Type")
            .getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[8] instanceof ClassConstant);
    assertTrue(constantArray[9] instanceof MethodrefConstant);
    assertTrue(constantArray[7] instanceof Utf8Constant);
    assertEquals(10, targetClass.u2constantPoolCount);
    assertEquals(17, constantArray.length);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#convertToTargetType(String, String)}.
   *
   * <ul>
   *   <li>Then sixth element return {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#convertToTargetType(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.convertToTargetType(String, String)"
  })
  public void testConvertToTargetType_thenSixthElementReturnClassConstant() {
    // Arrange, Act and Assert
    ProgramClass targetClass =
        (new CompactCodeAttributeComposer(
                new ProgramClass(90, 1, new Constant[] {new ClassConstant()}, 90, 90, 90)))
            .convertToTargetType("Source Type", "Target Type")
            .getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[5] instanceof ClassConstant);
    assertTrue(constantArray[6] instanceof MethodrefConstant);
    assertNull(constantArray[7]);
    assertNull(constantArray[8]);
    assertEquals(17, constantArray.length);
    assertEquals(7, targetClass.u2constantPoolCount);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#convertToTargetType(String, String)}.
   *
   * <ul>
   *   <li>Then sixth element return {@link NameAndTypeConstant}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#convertToTargetType(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.convertToTargetType(String, String)"
  })
  public void testConvertToTargetType_thenSixthElementReturnNameAndTypeConstant() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ClassConstant classConstant3 = new ClassConstant();

    // Act
    CompactCodeAttributeComposer actualConvertToTargetTypeResult =
        (new CompactCodeAttributeComposer(
                new ProgramClass(
                    90,
                    3,
                    new Constant[] {classConstant, classConstant2, classConstant3},
                    90,
                    90,
                    90)))
            .convertToTargetType("Source Type", "Target Type");

    // Assert
    ProgramClass targetClass = actualConvertToTargetTypeResult.getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[5] instanceof NameAndTypeConstant);
    assertTrue(constantArray[3] instanceof Utf8Constant);
    assertNull(constantArray[17]);
    assertNull(constantArray[18]);
    assertEquals(19, constantArray.length);
    assertSame(classConstant2, constantArray[1]);
    assertSame(classConstant3, constantArray[2]);
    assertSame(
        targetClass, actualConvertToTargetTypeResult.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#convertToTargetType(String, String)}.
   *
   * <ul>
   *   <li>When {@code java/lang/Short}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#convertToTargetType(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.convertToTargetType(String, String)"
  })
  public void testConvertToTargetType_whenJavaLangShort() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(90, 3, new Constant[] {new ClassConstant()}, 90, 90, 90));

    // Act
    CompactCodeAttributeComposer actualConvertToTargetTypeResult =
        compactCodeAttributeComposer.convertToTargetType("java/lang/Short", "Target Type");

    // Assert
    assertEquals(0, compactCodeAttributeComposer.getCodeLength());
    assertEquals(0, actualConvertToTargetTypeResult.getCodeLength());
    ProgramClass targetClass = actualConvertToTargetTypeResult.getTargetClass();
    assertEquals(1, targetClass.constantPool.length);
    assertEquals(3, targetClass.u2constantPoolCount);
    assertSame(
        targetClass, actualConvertToTargetTypeResult.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#convertToTargetType(String, String)}.
   *
   * <ul>
   *   <li>When {@code (S)Ljava/lang/Short;}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#convertToTargetType(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.convertToTargetType(String, String)"
  })
  public void testConvertToTargetType_whenSLjavaLangShort() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(90, 3, new Constant[] {new ClassConstant()}, 90, 90, 90));

    // Act
    CompactCodeAttributeComposer actualConvertToTargetTypeResult =
        compactCodeAttributeComposer.convertToTargetType("(S)Ljava/lang/Short;", "Target Type");

    // Assert
    assertEquals(0, compactCodeAttributeComposer.getCodeLength());
    assertEquals(0, actualConvertToTargetTypeResult.getCodeLength());
    ProgramClass targetClass = actualConvertToTargetTypeResult.getTargetClass();
    assertEquals(1, targetClass.constantPool.length);
    assertEquals(3, targetClass.u2constantPoolCount);
    assertSame(
        targetClass, actualConvertToTargetTypeResult.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#boxPrimitiveType(char)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#boxPrimitiveType(char)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.boxPrimitiveType(char)"
  })
  public void testBoxPrimitiveType() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.boxPrimitiveType('A'));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.convertPrimitiveType(char, char)"
  })
  public void testConvertPrimitiveType() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualConvertPrimitiveTypeResult =
        compactCodeAttributeComposer.convertPrimitiveType('A', 'A');

    // Assert
    assertEquals(0, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertPrimitiveTypeResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.convertPrimitiveType(char, char)"
  })
  public void testConvertPrimitiveType2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualConvertPrimitiveTypeResult =
        compactCodeAttributeComposer.convertPrimitiveType('S', 'A');

    // Assert
    assertEquals(0, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertPrimitiveTypeResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.convertPrimitiveType(char, char)"
  })
  public void testConvertPrimitiveType3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualConvertPrimitiveTypeResult =
        compactCodeAttributeComposer.convertPrimitiveType('S', 'S');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertPrimitiveTypeResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}.
   *
   * <ul>
   *   <li>When {@code B}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.convertPrimitiveType(char, char)"
  })
  public void testConvertPrimitiveType_whenB() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualConvertPrimitiveTypeResult =
        compactCodeAttributeComposer.convertPrimitiveType('B', 'A');

    // Assert
    assertEquals(0, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertPrimitiveTypeResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}.
   *
   * <ul>
   *   <li>When {@code B}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.convertPrimitiveType(char, char)"
  })
  public void testConvertPrimitiveType_whenB2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualConvertPrimitiveTypeResult =
        compactCodeAttributeComposer.convertPrimitiveType('S', 'B');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertPrimitiveTypeResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}.
   *
   * <ul>
   *   <li>When {@code C}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.convertPrimitiveType(char, char)"
  })
  public void testConvertPrimitiveType_whenC() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualConvertPrimitiveTypeResult =
        compactCodeAttributeComposer.convertPrimitiveType('C', 'A');

    // Assert
    assertEquals(0, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertPrimitiveTypeResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}.
   *
   * <ul>
   *   <li>When {@code C}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.convertPrimitiveType(char, char)"
  })
  public void testConvertPrimitiveType_whenC2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualConvertPrimitiveTypeResult =
        compactCodeAttributeComposer.convertPrimitiveType('S', 'C');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertPrimitiveTypeResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}.
   *
   * <ul>
   *   <li>When {@code D}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.convertPrimitiveType(char, char)"
  })
  public void testConvertPrimitiveType_whenD() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualConvertPrimitiveTypeResult =
        compactCodeAttributeComposer.convertPrimitiveType('D', 'A');

    // Assert
    assertEquals(0, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertPrimitiveTypeResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}.
   *
   * <ul>
   *   <li>When {@code D}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.convertPrimitiveType(char, char)"
  })
  public void testConvertPrimitiveType_whenD2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualConvertPrimitiveTypeResult =
        compactCodeAttributeComposer.convertPrimitiveType('S', 'D');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertPrimitiveTypeResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}.
   *
   * <ul>
   *   <li>When {@code F}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.convertPrimitiveType(char, char)"
  })
  public void testConvertPrimitiveType_whenF() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualConvertPrimitiveTypeResult =
        compactCodeAttributeComposer.convertPrimitiveType('F', 'A');

    // Assert
    assertEquals(0, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertPrimitiveTypeResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}.
   *
   * <ul>
   *   <li>When {@code F}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.convertPrimitiveType(char, char)"
  })
  public void testConvertPrimitiveType_whenF2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualConvertPrimitiveTypeResult =
        compactCodeAttributeComposer.convertPrimitiveType('S', 'F');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertPrimitiveTypeResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}.
   *
   * <ul>
   *   <li>When {@code J}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.convertPrimitiveType(char, char)"
  })
  public void testConvertPrimitiveType_whenJ() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualConvertPrimitiveTypeResult =
        compactCodeAttributeComposer.convertPrimitiveType('J', 'A');

    // Assert
    assertEquals(0, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertPrimitiveTypeResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}.
   *
   * <ul>
   *   <li>When {@code J}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#convertPrimitiveType(char, char)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.convertPrimitiveType(char, char)"
  })
  public void testConvertPrimitiveType_whenJ2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualConvertPrimitiveTypeResult =
        compactCodeAttributeComposer.convertPrimitiveType('S', 'J');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualConvertPrimitiveTypeResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#unboxPrimitiveType(String, String)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#unboxPrimitiveType(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.unboxPrimitiveType(String, String)"
  })
  public void testUnboxPrimitiveType() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.unboxPrimitiveType("Source Type", "Target Type"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#unboxPrimitiveType(String, String)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#unboxPrimitiveType(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.unboxPrimitiveType(String, String)"
  })
  public void testUnboxPrimitiveType2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(66, 1, new Constant[] {new ClassConstant()}, 66, 66, 66));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.unboxPrimitiveType("Source Type", "Source Type"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#unboxPrimitiveType(String, String)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#unboxPrimitiveType(String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.unboxPrimitiveType(String, String)"
  })
  public void testUnboxPrimitiveType3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                66,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                66,
                66,
                66));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.unboxPrimitiveType("Source Type", "Source Type"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#reset()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#reset()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.reset()"})
  public void testReset() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.reset());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#beginCodeFragment(int)}.
   *
   * <ul>
   *   <li>When three.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#beginCodeFragment(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.beginCodeFragment(int)"
  })
  public void testBeginCodeFragment_whenThree() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.beginCodeFragment(3));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#beginCodeFragment(int)}.
   *
   * <ul>
   *   <li>When {@link ClassEstimates#TYPICAL_CODE_LENGTH}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#beginCodeFragment(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.beginCodeFragment(int)"
  })
  public void testBeginCodeFragment_whenTypical_code_length() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.beginCodeFragment(ClassEstimates.TYPICAL_CODE_LENGTH));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendInstructions(Instruction[])}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.appendInstructions(Instruction[])"
  })
  public void testAppendInstructions() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());
    Instruction[] instructions = new Instruction[] {new BranchInstruction((byte) 'A', 1)};

    // Act
    CompactCodeAttributeComposer actualAppendInstructionsResult =
        compactCodeAttributeComposer.appendInstructions(instructions);

    // Assert
    Instruction instruction = instructions[0];
    assertTrue(instruction instanceof BranchInstruction);
    assertEquals("lstore_2", instruction.getName());
    assertEquals(1, instructions.length);
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertEquals(3, actualAppendInstructionsResult.getCodeLength());
    assertEquals('A', ((BranchInstruction) instruction).opcode);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendInstructions(Instruction[])}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.appendInstructions(Instruction[])"
  })
  public void testAppendInstructions2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());
    Instruction[] instructions = new Instruction[] {new VariableInstruction((byte) 'A')};

    // Act
    CompactCodeAttributeComposer actualAppendInstructionsResult =
        compactCodeAttributeComposer.appendInstructions(instructions);

    // Assert
    Instruction instruction = instructions[0];
    assertTrue(instruction instanceof VariableInstruction);
    assertEquals("lstore_2", instruction.getName());
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertEquals(1, actualAppendInstructionsResult.getCodeLength());
    assertEquals(1, instructions.length);
    assertEquals('A', ((VariableInstruction) instruction).opcode);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendInstructions(Instruction[])}.
   *
   * <ul>
   *   <li>Then first element {@link ConstantInstruction}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.appendInstructions(Instruction[])"
  })
  public void testAppendInstructions_thenFirstElementConstantInstruction() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());
    Instruction[] instructions = new Instruction[] {new ConstantInstruction((byte) 'A', 1)};

    // Act
    CompactCodeAttributeComposer actualAppendInstructionsResult =
        compactCodeAttributeComposer.appendInstructions(instructions);

    // Assert
    Instruction instruction = instructions[0];
    assertTrue(instruction instanceof ConstantInstruction);
    assertEquals("lstore_2", instruction.getName());
    assertEquals(1, instructions.length);
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertEquals(3, actualAppendInstructionsResult.getCodeLength());
    assertEquals('A', ((ConstantInstruction) instruction).opcode);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendInstructions(Instruction[])}.
   *
   * <ul>
   *   <li>Then first element {@link LookUpSwitchInstruction}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.appendInstructions(Instruction[])"
  })
  public void testAppendInstructions_thenFirstElementLookUpSwitchInstruction() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());
    Instruction[] instructions =
        new Instruction[] {
          new LookUpSwitchInstruction((byte) 'A', 1, new int[] {1, 2, 1, 2}, new int[] {1, 2, 1, 2})
        };

    // Act
    CompactCodeAttributeComposer actualAppendInstructionsResult =
        compactCodeAttributeComposer.appendInstructions(instructions);

    // Assert
    Instruction instruction = instructions[0];
    assertTrue(instruction instanceof LookUpSwitchInstruction);
    assertEquals("lstore_2", instruction.getName());
    assertEquals(1, instructions.length);
    assertEquals(44, compactCodeAttributeComposer.getCodeLength());
    assertEquals(44, actualAppendInstructionsResult.getCodeLength());
    assertEquals('A', ((LookUpSwitchInstruction) instruction).opcode);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendInstructions(Instruction[])}.
   *
   * <ul>
   *   <li>Then first element Name is {@code goto_w}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.appendInstructions(Instruction[])"
  })
  public void testAppendInstructions_thenFirstElementNameIsGotoW() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());
    Instruction[] instructions =
        new Instruction[] {new BranchInstruction((byte) -89, Integer.MIN_VALUE)};

    // Act
    CompactCodeAttributeComposer actualAppendInstructionsResult =
        compactCodeAttributeComposer.appendInstructions(instructions);

    // Assert
    Instruction instruction = instructions[0];
    assertTrue(instruction instanceof BranchInstruction);
    assertEquals("goto_w", instruction.getName());
    assertEquals((byte) -56, ((BranchInstruction) instruction).opcode);
    assertEquals(1, instructions.length);
    assertEquals(5, compactCodeAttributeComposer.getCodeLength());
    assertEquals(5, actualAppendInstructionsResult.getCodeLength());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendInstructions(Instruction[])}.
   *
   * <ul>
   *   <li>Then first element Name is {@code nop}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.appendInstructions(Instruction[])"
  })
  public void testAppendInstructions_thenFirstElementNameIsNop() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());
    Instruction[] instructions = new Instruction[] {new VariableInstruction()};

    // Act
    CompactCodeAttributeComposer actualAppendInstructionsResult =
        compactCodeAttributeComposer.appendInstructions(instructions);

    // Assert
    Instruction instruction = instructions[0];
    assertTrue(instruction instanceof VariableInstruction);
    assertEquals("nop", instruction.getName());
    assertEquals((byte) 0, ((VariableInstruction) instruction).opcode);
    assertEquals(1, instructions.length);
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertEquals(2, actualAppendInstructionsResult.getCodeLength());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendInstructions(Instruction[])}.
   *
   * <ul>
   *   <li>Then first element {@link SimpleInstruction}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.appendInstructions(Instruction[])"
  })
  public void testAppendInstructions_thenFirstElementSimpleInstruction() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());
    Instruction[] instructions = new Instruction[] {new SimpleInstruction((byte) 'A')};

    // Act
    CompactCodeAttributeComposer actualAppendInstructionsResult =
        compactCodeAttributeComposer.appendInstructions(instructions);

    // Assert
    Instruction instruction = instructions[0];
    assertTrue(instruction instanceof SimpleInstruction);
    assertEquals("lstore_2", instruction.getName());
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertEquals(1, actualAppendInstructionsResult.getCodeLength());
    assertEquals(1, instructions.length);
    assertEquals('A', ((SimpleInstruction) instruction).opcode);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendInstructions(Instruction[])}.
   *
   * <ul>
   *   <li>Then first element {@link TableSwitchInstruction}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendInstructions(Instruction[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.appendInstructions(Instruction[])"
  })
  public void testAppendInstructions_thenFirstElementTableSwitchInstruction() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());
    Instruction[] instructions =
        new Instruction[] {new TableSwitchInstruction((byte) 'A', 1, 1, 1, new int[] {1, 2, 1, 2})};

    // Act
    CompactCodeAttributeComposer actualAppendInstructionsResult =
        compactCodeAttributeComposer.appendInstructions(instructions);

    // Assert
    Instruction instruction = instructions[0];
    assertTrue(instruction instanceof TableSwitchInstruction);
    assertEquals("lstore_2", instruction.getName());
    assertEquals(1, instructions.length);
    assertEquals(20, compactCodeAttributeComposer.getCodeLength());
    assertEquals(20, actualAppendInstructionsResult.getCodeLength());
    assertEquals('A', ((TableSwitchInstruction) instruction).opcode);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendInstruction(Instruction)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.appendInstruction(Instruction)"
  })
  public void testAppendInstruction() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());
    BranchInstruction instruction = new BranchInstruction((byte) 'A', 1);

    // Act
    CompactCodeAttributeComposer actualAppendInstructionResult =
        compactCodeAttributeComposer.appendInstruction(instruction);

    // Assert
    assertEquals("lstore_2", instruction.getName());
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertEquals(3, actualAppendInstructionResult.getCodeLength());
    assertEquals('A', instruction.opcode);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendInstruction(Instruction)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.appendInstruction(Instruction)"
  })
  public void testAppendInstruction2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());
    ConstantInstruction instruction = new ConstantInstruction((byte) 'A', 1);

    // Act
    CompactCodeAttributeComposer actualAppendInstructionResult =
        compactCodeAttributeComposer.appendInstruction(instruction);

    // Assert
    assertEquals("lstore_2", instruction.getName());
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertEquals(3, actualAppendInstructionResult.getCodeLength());
    assertEquals('A', instruction.opcode);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendInstruction(Instruction)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.appendInstruction(Instruction)"
  })
  public void testAppendInstruction3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());
    LookUpSwitchInstruction instruction =
        new LookUpSwitchInstruction((byte) 'A', 1, new int[] {1, 2, 1, 2}, new int[] {1, 2, 1, 2});

    // Act
    CompactCodeAttributeComposer actualAppendInstructionResult =
        compactCodeAttributeComposer.appendInstruction(instruction);

    // Assert
    assertEquals("lstore_2", instruction.getName());
    assertEquals(44, compactCodeAttributeComposer.getCodeLength());
    assertEquals(44, actualAppendInstructionResult.getCodeLength());
    assertEquals('A', instruction.opcode);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendInstruction(Instruction)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.appendInstruction(Instruction)"
  })
  public void testAppendInstruction4() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());
    TableSwitchInstruction instruction =
        new TableSwitchInstruction((byte) 'A', 1, 1, 1, new int[] {1, 2, 1, 2});

    // Act
    CompactCodeAttributeComposer actualAppendInstructionResult =
        compactCodeAttributeComposer.appendInstruction(instruction);

    // Assert
    assertEquals("lstore_2", instruction.getName());
    assertEquals(20, compactCodeAttributeComposer.getCodeLength());
    assertEquals(20, actualAppendInstructionResult.getCodeLength());
    assertEquals('A', instruction.opcode);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendInstruction(Instruction)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.appendInstruction(Instruction)"
  })
  public void testAppendInstruction5() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());
    BranchInstruction instruction = new BranchInstruction((byte) -89, Integer.MIN_VALUE);

    // Act
    CompactCodeAttributeComposer actualAppendInstructionResult =
        compactCodeAttributeComposer.appendInstruction(instruction);

    // Assert
    assertEquals("goto_w", instruction.getName());
    assertEquals((byte) -56, instruction.opcode);
    assertEquals(5, compactCodeAttributeComposer.getCodeLength());
    assertEquals(5, actualAppendInstructionResult.getCodeLength());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendInstruction(Instruction)}.
   *
   * <ul>
   *   <li>Then {@link SimpleInstruction#SimpleInstruction(byte)} with opcode is {@code A} Name is
   *       {@code lstore_2}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.appendInstruction(Instruction)"
  })
  public void testAppendInstruction_thenSimpleInstructionWithOpcodeIsANameIsLstore2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());
    SimpleInstruction instruction = new SimpleInstruction((byte) 'A');

    // Act
    CompactCodeAttributeComposer actualAppendInstructionResult =
        compactCodeAttributeComposer.appendInstruction(instruction);

    // Assert
    assertEquals("lstore_2", instruction.getName());
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertEquals(1, actualAppendInstructionResult.getCodeLength());
    assertEquals('A', instruction.opcode);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendInstruction(Instruction)}.
   *
   * <ul>
   *   <li>Then {@link VariableInstruction#VariableInstruction(byte)} with opcode is {@code A} Name
   *       is {@code lstore_2}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.appendInstruction(Instruction)"
  })
  public void testAppendInstruction_thenVariableInstructionWithOpcodeIsANameIsLstore2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());
    VariableInstruction instruction = new VariableInstruction((byte) 'A');

    // Act
    CompactCodeAttributeComposer actualAppendInstructionResult =
        compactCodeAttributeComposer.appendInstruction(instruction);

    // Assert
    assertEquals("lstore_2", instruction.getName());
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertEquals(1, actualAppendInstructionResult.getCodeLength());
    assertEquals('A', instruction.opcode);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendInstruction(Instruction)}.
   *
   * <ul>
   *   <li>When {@link VariableInstruction#VariableInstruction()}.
   *   <li>Then {@link VariableInstruction#VariableInstruction()} Name is {@code nop}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendInstruction(Instruction)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.appendInstruction(Instruction)"
  })
  public void testAppendInstruction_whenVariableInstruction_thenVariableInstructionNameIsNop() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());
    VariableInstruction instruction = new VariableInstruction();

    // Act
    CompactCodeAttributeComposer actualAppendInstructionResult =
        compactCodeAttributeComposer.appendInstruction(instruction);

    // Assert
    assertEquals("nop", instruction.getName());
    assertEquals((byte) 0, instruction.opcode);
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertEquals(2, actualAppendInstructionResult.getCodeLength());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#nop()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#nop()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.nop()"})
  public void testNop() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualNopResult = compactCodeAttributeComposer.nop();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualNopResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#aconst_null()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#aconst_null()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.aconst_null()"})
  public void testAconst_null() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAconst_nullResult =
        compactCodeAttributeComposer.aconst_null();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAconst_nullResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iconst(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iconst(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.iconst(int)"})
  public void testIconst() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIconstResult = compactCodeAttributeComposer.iconst(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIconstResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iconst(int)}.
   *
   * <ul>
   *   <li>When minus one hundred twenty-eight.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iconst(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.iconst(int)"})
  public void testIconst_whenMinusOneHundredTwentyEight() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIconstResult = compactCodeAttributeComposer.iconst(-128);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIconstResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iconst(int)}.
   *
   * <ul>
   *   <li>When six.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iconst(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.iconst(int)"})
  public void testIconst_whenSix() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIconstResult = compactCodeAttributeComposer.iconst(6);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIconstResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iconst_m1()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iconst_m1()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.iconst_m1()"})
  public void testIconst_m1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIconst_m1Result = compactCodeAttributeComposer.iconst_m1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIconst_m1Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iconst_0()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iconst_0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.iconst_0()"})
  public void testIconst_0() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIconst_0Result = compactCodeAttributeComposer.iconst_0();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIconst_0Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iconst_1()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iconst_1()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.iconst_1()"})
  public void testIconst_1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIconst_1Result = compactCodeAttributeComposer.iconst_1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIconst_1Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iconst_2()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iconst_2()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.iconst_2()"})
  public void testIconst_2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIconst_2Result = compactCodeAttributeComposer.iconst_2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIconst_2Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iconst_3()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iconst_3()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.iconst_3()"})
  public void testIconst_3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIconst_3Result = compactCodeAttributeComposer.iconst_3();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIconst_3Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iconst_4()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iconst_4()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.iconst_4()"})
  public void testIconst_4() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIconst_4Result = compactCodeAttributeComposer.iconst_4();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIconst_4Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iconst_5()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iconst_5()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.iconst_5()"})
  public void testIconst_5() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIconst_5Result = compactCodeAttributeComposer.iconst_5();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIconst_5Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lconst(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lconst(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.lconst(int)"})
  public void testLconst() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLconstResult = compactCodeAttributeComposer.lconst(7);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLconstResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lconst(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lconst(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.lconst(int)"})
  public void testLconst2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLconstResult = compactCodeAttributeComposer.lconst(8);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLconstResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lconst(int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lconst(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.lconst(int)"})
  public void testLconst_whenOne() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLconstResult = compactCodeAttributeComposer.lconst(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLconstResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lconst(int)}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lconst(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.lconst(int)"})
  public void testLconst_whenZero() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLconstResult = compactCodeAttributeComposer.lconst(0);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLconstResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lconst_0()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lconst_0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.lconst_0()"})
  public void testLconst_0() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLconst_0Result = compactCodeAttributeComposer.lconst_0();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLconst_0Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lconst_1()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lconst_1()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.lconst_1()"})
  public void testLconst_1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLconst_1Result = compactCodeAttributeComposer.lconst_1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLconst_1Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fconst(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fconst(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.fconst(int)"})
  public void testFconst() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFconstResult = compactCodeAttributeComposer.fconst(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFconstResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fconst(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fconst(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.fconst(int)"})
  public void testFconst2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFconstResult = compactCodeAttributeComposer.fconst(5);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFconstResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fconst(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fconst(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.fconst(int)"})
  public void testFconst3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFconstResult = compactCodeAttributeComposer.fconst(6);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFconstResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fconst_0()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fconst_0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.fconst_0()"})
  public void testFconst_0() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFconst_0Result = compactCodeAttributeComposer.fconst_0();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFconst_0Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fconst_1()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fconst_1()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.fconst_1()"})
  public void testFconst_1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFconst_1Result = compactCodeAttributeComposer.fconst_1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFconst_1Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fconst_2()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fconst_2()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.fconst_2()"})
  public void testFconst_2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFconst_2Result = compactCodeAttributeComposer.fconst_2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFconst_2Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dconst(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dconst(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.dconst(int)"})
  public void testDconst() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDconstResult = compactCodeAttributeComposer.dconst(2);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDconstResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dconst(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dconst(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.dconst(int)"})
  public void testDconst2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDconstResult = compactCodeAttributeComposer.dconst(3);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDconstResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dconst(int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dconst(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.dconst(int)"})
  public void testDconst_whenOne() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDconstResult = compactCodeAttributeComposer.dconst(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDconstResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dconst(int)}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dconst(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.dconst(int)"})
  public void testDconst_whenZero() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDconstResult = compactCodeAttributeComposer.dconst(0);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDconstResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dconst_0()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dconst_0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.dconst_0()"})
  public void testDconst_0() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDconst_0Result = compactCodeAttributeComposer.dconst_0();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDconst_0Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dconst_1()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dconst_1()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.dconst_1()"})
  public void testDconst_1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDconst_1Result = compactCodeAttributeComposer.dconst_1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDconst_1Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#bipush(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#bipush(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.bipush(int)"})
  public void testBipush() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualBipushResult = compactCodeAttributeComposer.bipush(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualBipushResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#bipush(int)}.
   *
   * <ul>
   *   <li>When minus one hundred twenty-eight.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#bipush(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.bipush(int)"})
  public void testBipush_whenMinusOneHundredTwentyEight() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualBipushResult = compactCodeAttributeComposer.bipush(-128);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualBipushResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#bipush(int)}.
   *
   * <ul>
   *   <li>When {@link ClassEstimates#TYPICAL_BOOTSTRAP_METHODS_ATTRIBUTE_SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#bipush(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.bipush(int)"})
  public void testBipush_whenTypical_bootstrap_methods_attribute_size() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualBipushResult =
        compactCodeAttributeComposer.bipush(
            ClassEstimates.TYPICAL_BOOTSTRAP_METHODS_ATTRIBUTE_SIZE);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualBipushResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#sipush(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#sipush(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.sipush(int)"})
  public void testSipush() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualSipushResult = compactCodeAttributeComposer.sipush(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualSipushResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#sipush(int)}.
   *
   * <ul>
   *   <li>When minus one hundred twenty-eight.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#sipush(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.sipush(int)"})
  public void testSipush_whenMinusOneHundredTwentyEight() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualSipushResult = compactCodeAttributeComposer.sipush(-128);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualSipushResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#sipush(int)}.
   *
   * <ul>
   *   <li>When seventeen.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#sipush(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.sipush(int)"})
  public void testSipush_whenSeventeen() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualSipushResult = compactCodeAttributeComposer.sipush(17);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualSipushResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc(Clazz)} with {@code Clazz}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc(Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc(Clazz)"})
  public void testLdcWithClazz() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act
    CompactCodeAttributeComposer actualLdcResult =
        compactCodeAttributeComposer.ldc((Clazz) new LibraryClass());

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdcResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc(Clazz, Member)} with {@code Clazz}, {@code
   * Member}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc(Clazz, Member)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc(Clazz, Member)"
  })
  public void testLdcWithClazzMember() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc(clazz, new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc(Clazz, Member)} with {@code Clazz}, {@code
   * Member}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc(Clazz, Member)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc(Clazz, Member)"
  })
  public void testLdcWithClazzMember2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc(clazz, new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc(float)} with {@code float}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc(float)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc(float)"})
  public void testLdcWithFloat() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(4, 1, new Constant[] {new ClassConstant()}, 4, 4, 4));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.ldc(10.0f));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc(float)} with {@code float}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc(float)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc(float)"})
  public void testLdcWithFloat2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(4, 0, new Constant[] {new ClassConstant()}, 4, 4, 4));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.ldc(10.0f));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc(float)} with {@code float}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc(float)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc(float)"})
  public void testLdcWithFloat3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                4,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                4,
                4,
                4));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.ldc(10.0f));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc(int)} with {@code int}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc(int)"})
  public void testLdcWithInt() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(3, 1, new Constant[] {new ClassConstant()}, 3, 3, 3));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.ldc(42));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc(int)} with {@code int}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc(int)"})
  public void testLdcWithInt2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(3, 0, new Constant[] {new ClassConstant()}, 3, 3, 3));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.ldc(42));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc(int)} with {@code int}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc(int)"})
  public void testLdcWithInt3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                3,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                3,
                3,
                3));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.ldc(42));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc(Object)} with {@code Object}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc(Object)"})
  public void testLdcWithObject() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(99, 1, new Constant[] {new ClassConstant()}, 99, 99, 99));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer, compactCodeAttributeComposer.ldc((Object) "Primitive Array"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc(Object)} with {@code Object}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc(Object)"})
  public void testLdcWithObject2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(99, 0, new Constant[] {new ClassConstant()}, 99, 99, 99));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer, compactCodeAttributeComposer.ldc((Object) "Primitive Array"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc(Object)} with {@code Object}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc(Object)"})
  public void testLdcWithObject3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                99,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                99,
                99,
                99));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer, compactCodeAttributeComposer.ldc((Object) "Primitive Array"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc(ResourceFile)} with {@code ResourceFile}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc(ResourceFile)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc(ResourceFile)"})
  public void testLdcWithResourceFile() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc(new ResourceFile("foo.txt", 3L)));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc(ResourceFile)} with {@code ResourceFile}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc(ResourceFile)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc(ResourceFile)"})
  public void testLdcWithResourceFile2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc(new ResourceFile("foo.txt", 3L)));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc(String)} with {@code String}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc(String)"})
  public void testLdcWithString() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.ldc("String"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc(String)} with {@code String}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc(String)"})
  public void testLdcWithString2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.ldc("String"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc(String, Clazz)} with {@code String}, {@code
   * Clazz}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc(String, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc(String, Clazz)"
  })
  public void testLdcWithStringClazz() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc("Type Name", new LibraryClass()));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc(String, Clazz)} with {@code String}, {@code
   * Clazz}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc(String, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc(String, Clazz)"
  })
  public void testLdcWithStringClazz2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc("Type Name", new LibraryClass()));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc(String, Clazz, Member)} with {@code String},
   * {@code Clazz}, {@code Member}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc(String, Clazz, Member)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc(String, Clazz, Member)"
  })
  public void testLdcWithStringClazzMember() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc(
            "String", referencedClass, new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc(String, Clazz, Member)} with {@code String},
   * {@code Clazz}, {@code Member}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc(String, Clazz, Member)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc(String, Clazz, Member)"
  })
  public void testLdcWithStringClazzMember2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc(
            "String", referencedClass, new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc(String, ResourceFile)} with {@code String}, {@code
   * ResourceFile}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc(String, ResourceFile)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc(String, ResourceFile)"
  })
  public void testLdcWithStringResourceFile() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc("String", new ResourceFile("foo.txt", 3L)));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc(String, ResourceFile)} with {@code String}, {@code
   * ResourceFile}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc(String, ResourceFile)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc(String, ResourceFile)"
  })
  public void testLdcWithStringResourceFile2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc("String", new ResourceFile("foo.txt", 3L)));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc_(int)"})
  public void testLdc_() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLdc_Result = compactCodeAttributeComposer.ldc_(1);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdc_Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc_(int)"})
  public void testLdc_2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLdc_Result =
        compactCodeAttributeComposer.ldc_(ClassEstimates.TYPICAL_CODE_LENGTH);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdc_Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w(Clazz)} with {@code Clazz}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w(Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc_w(Clazz)"})
  public void testLdc_wWithClazz() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act
    CompactCodeAttributeComposer actualLdc_wResult =
        compactCodeAttributeComposer.ldc_w((Clazz) new LibraryClass());

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdc_wResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w(Clazz, Member)} with {@code Clazz}, {@code
   * Member}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w(Clazz, Member)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc_w(Clazz, Member)"
  })
  public void testLdc_wWithClazzMember() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc_w(clazz, new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w(Clazz, Member)} with {@code Clazz}, {@code
   * Member}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w(Clazz, Member)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc_w(Clazz, Member)"
  })
  public void testLdc_wWithClazzMember2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc_w(clazz, new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w(float)} with {@code float}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w(float)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc_w(float)"})
  public void testLdc_wWithFloat() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(4, 1, new Constant[] {new ClassConstant()}, 4, 4, 4));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.ldc_w(10.0f));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w(float)} with {@code float}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w(float)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc_w(float)"})
  public void testLdc_wWithFloat2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(4, 0, new Constant[] {new ClassConstant()}, 4, 4, 4));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.ldc_w(10.0f));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w(float)} with {@code float}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w(float)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc_w(float)"})
  public void testLdc_wWithFloat3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                4,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                4,
                4,
                4));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.ldc_w(10.0f));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w(int)} with {@code int}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc_w(int)"})
  public void testLdc_wWithInt() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(3, 1, new Constant[] {new ClassConstant()}, 3, 3, 3));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.ldc_w(42));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w(int)} with {@code int}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc_w(int)"})
  public void testLdc_wWithInt2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(3, 0, new Constant[] {new ClassConstant()}, 3, 3, 3));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.ldc_w(42));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w(int)} with {@code int}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc_w(int)"})
  public void testLdc_wWithInt3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                3,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                3,
                3,
                3));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.ldc_w(42));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w(Object)} with {@code Object}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc_w(Object)"})
  public void testLdc_wWithObject() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(99, 1, new Constant[] {new ClassConstant()}, 99, 99, 99));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc_w((Object) "Primitive Array"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w(Object)} with {@code Object}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc_w(Object)"})
  public void testLdc_wWithObject2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(99, 0, new Constant[] {new ClassConstant()}, 99, 99, 99));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc_w((Object) "Primitive Array"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w(Object)} with {@code Object}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc_w(Object)"})
  public void testLdc_wWithObject3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                99,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                99,
                99,
                99));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc_w((Object) "Primitive Array"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w(ResourceFile)} with {@code ResourceFile}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w(ResourceFile)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc_w(ResourceFile)"
  })
  public void testLdc_wWithResourceFile() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc_w(new ResourceFile("foo.txt", 3L)));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w(ResourceFile)} with {@code ResourceFile}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w(ResourceFile)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc_w(ResourceFile)"
  })
  public void testLdc_wWithResourceFile2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc_w(new ResourceFile("foo.txt", 3L)));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w(String)} with {@code String}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc_w(String)"})
  public void testLdc_wWithString() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.ldc_w("String"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w(String)} with {@code String}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc_w(String)"})
  public void testLdc_wWithString2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.ldc_w("String"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w(String, Clazz)} with {@code String}, {@code
   * Clazz}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w(String, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc_w(String, Clazz)"
  })
  public void testLdc_wWithStringClazz() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc_w("Type Name", new LibraryClass()));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w(String, Clazz)} with {@code String}, {@code
   * Clazz}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w(String, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc_w(String, Clazz)"
  })
  public void testLdc_wWithStringClazz2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc_w("Type Name", new LibraryClass()));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w(String, Clazz, Member)} with {@code String},
   * {@code Clazz}, {@code Member}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w(String, Clazz, Member)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc_w(String, Clazz, Member)"
  })
  public void testLdc_wWithStringClazzMember() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc_w(
            "String", referencedClass, new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w(String, Clazz, Member)} with {@code String},
   * {@code Clazz}, {@code Member}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w(String, Clazz, Member)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc_w(String, Clazz, Member)"
  })
  public void testLdc_wWithStringClazzMember2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc_w(
            "String", referencedClass, new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w(String, ResourceFile)} with {@code String},
   * {@code ResourceFile}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w(String, ResourceFile)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc_w(String, ResourceFile)"
  })
  public void testLdc_wWithStringResourceFile() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc_w("String", new ResourceFile("foo.txt", 3L)));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w(String, ResourceFile)} with {@code String},
   * {@code ResourceFile}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w(String, ResourceFile)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc_w(String, ResourceFile)"
  })
  public void testLdc_wWithStringResourceFile2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.ldc_w("String", new ResourceFile("foo.txt", 3L)));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w_(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w_(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc_w_(int)"})
  public void testLdc_w_() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLdc_w_Result = compactCodeAttributeComposer.ldc_w_(1);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdc_w_Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc_w_(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc_w_(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc_w_(int)"})
  public void testLdc_w_2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLdc_w_Result =
        compactCodeAttributeComposer.ldc_w_(ClassEstimates.TYPICAL_CODE_LENGTH);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdc_w_Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc2_w(double)} with {@code double}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc2_w(double)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc2_w(double)"})
  public void testLdc2_wWithDouble() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(6, 1, new Constant[] {new ClassConstant()}, 6, 6, 6));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.ldc2_w(10.0d));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc2_w(double)} with {@code double}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc2_w(double)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc2_w(double)"})
  public void testLdc2_wWithDouble2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                6,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                6,
                6,
                6));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.ldc2_w(10.0d));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc2_w(int)} with {@code int}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc2_w(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc2_w(int)"})
  public void testLdc2_wWithInt() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLdc2_wResult = compactCodeAttributeComposer.ldc2_w(1);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdc2_wResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc2_w(long)} with {@code long}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc2_w(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc2_w(long)"})
  public void testLdc2_wWithLong() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(5, 1, new Constant[] {new ClassConstant()}, 5, 5, 5));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.ldc2_w(42L));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldc2_w(long)} with {@code long}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldc2_w(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ldc2_w(long)"})
  public void testLdc2_wWithLong2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                5,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                5,
                5,
                5));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.ldc2_w(42L));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iload(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iload(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.iload(int)"})
  public void testIload() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIloadResult = compactCodeAttributeComposer.iload(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIloadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iload(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iload(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.iload(int)"})
  public void testIload2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIloadResult = compactCodeAttributeComposer.iload(21);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIloadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lload(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lload(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.lload(int)"})
  public void testLload() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLloadResult = compactCodeAttributeComposer.lload(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLloadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lload(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lload(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.lload(int)"})
  public void testLload2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLloadResult = compactCodeAttributeComposer.lload(22);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLloadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fload(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fload(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.fload(int)"})
  public void testFload() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFloadResult = compactCodeAttributeComposer.fload(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFloadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fload(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fload(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.fload(int)"})
  public void testFload2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFloadResult = compactCodeAttributeComposer.fload(23);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFloadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dload(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dload(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.dload(int)"})
  public void testDload() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDloadResult = compactCodeAttributeComposer.dload(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDloadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dload(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dload(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.dload(int)"})
  public void testDload2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDloadResult = compactCodeAttributeComposer.dload(24);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDloadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#aload(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#aload(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.aload(int)"})
  public void testAload() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAloadResult = compactCodeAttributeComposer.aload(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAloadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#aload(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#aload(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.aload(int)"})
  public void testAload2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAloadResult = compactCodeAttributeComposer.aload(25);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAloadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iload_0()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iload_0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.iload_0()"})
  public void testIload_0() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIload_0Result = compactCodeAttributeComposer.iload_0();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIload_0Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iload_1()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iload_1()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.iload_1()"})
  public void testIload_1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIload_1Result = compactCodeAttributeComposer.iload_1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIload_1Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iload_2()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iload_2()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.iload_2()"})
  public void testIload_2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIload_2Result = compactCodeAttributeComposer.iload_2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIload_2Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iload_3()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iload_3()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.iload_3()"})
  public void testIload_3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIload_3Result = compactCodeAttributeComposer.iload_3();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIload_3Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lload_0()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lload_0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.lload_0()"})
  public void testLload_0() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLload_0Result = compactCodeAttributeComposer.lload_0();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLload_0Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lload_1()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lload_1()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.lload_1()"})
  public void testLload_1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLload_1Result = compactCodeAttributeComposer.lload_1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLload_1Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lload_2()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lload_2()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.lload_2()"})
  public void testLload_2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLload_2Result = compactCodeAttributeComposer.lload_2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLload_2Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lload_3()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lload_3()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.lload_3()"})
  public void testLload_3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLload_3Result = compactCodeAttributeComposer.lload_3();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLload_3Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fload_0()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fload_0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.fload_0()"})
  public void testFload_0() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFload_0Result = compactCodeAttributeComposer.fload_0();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFload_0Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fload_1()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fload_1()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.fload_1()"})
  public void testFload_1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFload_1Result = compactCodeAttributeComposer.fload_1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFload_1Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fload_2()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fload_2()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.fload_2()"})
  public void testFload_2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFload_2Result = compactCodeAttributeComposer.fload_2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFload_2Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fload_3()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fload_3()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.fload_3()"})
  public void testFload_3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFload_3Result = compactCodeAttributeComposer.fload_3();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFload_3Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dload_0()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dload_0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.dload_0()"})
  public void testDload_0() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDload_0Result = compactCodeAttributeComposer.dload_0();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDload_0Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dload_1()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dload_1()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.dload_1()"})
  public void testDload_1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDload_1Result = compactCodeAttributeComposer.dload_1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDload_1Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dload_2()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dload_2()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.dload_2()"})
  public void testDload_2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDload_2Result = compactCodeAttributeComposer.dload_2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDload_2Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dload_3()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dload_3()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.dload_3()"})
  public void testDload_3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDload_3Result = compactCodeAttributeComposer.dload_3();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDload_3Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#aload_0()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#aload_0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.aload_0()"})
  public void testAload_0() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAload_0Result = compactCodeAttributeComposer.aload_0();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAload_0Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#aload_1()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#aload_1()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.aload_1()"})
  public void testAload_1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAload_1Result = compactCodeAttributeComposer.aload_1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAload_1Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#aload_2()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#aload_2()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.aload_2()"})
  public void testAload_2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAload_2Result = compactCodeAttributeComposer.aload_2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAload_2Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#aload_3()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#aload_3()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.aload_3()"})
  public void testAload_3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAload_3Result = compactCodeAttributeComposer.aload_3();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAload_3Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iaload()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iaload()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.iaload()"})
  public void testIaload() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIaloadResult = compactCodeAttributeComposer.iaload();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIaloadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#laload()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#laload()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.laload()"})
  public void testLaload() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLaloadResult = compactCodeAttributeComposer.laload();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLaloadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#faload()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#faload()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.faload()"})
  public void testFaload() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFaloadResult = compactCodeAttributeComposer.faload();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFaloadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#daload()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#daload()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.daload()"})
  public void testDaload() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDaloadResult = compactCodeAttributeComposer.daload();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDaloadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#aaload()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#aaload()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.aaload()"})
  public void testAaload() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAaloadResult = compactCodeAttributeComposer.aaload();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAaloadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#baload()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#baload()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.baload()"})
  public void testBaload() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualBaloadResult = compactCodeAttributeComposer.baload();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualBaloadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#caload()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#caload()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.caload()"})
  public void testCaload() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualCaloadResult = compactCodeAttributeComposer.caload();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualCaloadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#saload()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#saload()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.saload()"})
  public void testSaload() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualSaloadResult = compactCodeAttributeComposer.saload();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualSaloadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#istore(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#istore(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.istore(int)"})
  public void testIstore() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIstoreResult = compactCodeAttributeComposer.istore(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIstoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#istore(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#istore(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.istore(int)"})
  public void testIstore2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIstoreResult = compactCodeAttributeComposer.istore(54);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIstoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lstore(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lstore(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.lstore(int)"})
  public void testLstore() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLstoreResult = compactCodeAttributeComposer.lstore(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLstoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lstore(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lstore(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.lstore(int)"})
  public void testLstore2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLstoreResult = compactCodeAttributeComposer.lstore(55);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLstoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fstore(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fstore(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.fstore(int)"})
  public void testFstore() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFstoreResult = compactCodeAttributeComposer.fstore(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFstoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fstore(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fstore(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.fstore(int)"})
  public void testFstore2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFstoreResult = compactCodeAttributeComposer.fstore(56);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFstoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dstore(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dstore(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.dstore(int)"})
  public void testDstore() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDstoreResult = compactCodeAttributeComposer.dstore(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDstoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dstore(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dstore(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.dstore(int)"})
  public void testDstore2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDstoreResult = compactCodeAttributeComposer.dstore(57);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDstoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#astore(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#astore(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.astore(int)"})
  public void testAstore() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAstoreResult = compactCodeAttributeComposer.astore(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAstoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#astore(int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#astore(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.astore(int)"})
  public void testAstore2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAstoreResult = compactCodeAttributeComposer.astore(58);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAstoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#istore_0()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#istore_0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.istore_0()"})
  public void testIstore_0() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIstore_0Result = compactCodeAttributeComposer.istore_0();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIstore_0Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#istore_1()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#istore_1()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.istore_1()"})
  public void testIstore_1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIstore_1Result = compactCodeAttributeComposer.istore_1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIstore_1Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#istore_2()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#istore_2()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.istore_2()"})
  public void testIstore_2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIstore_2Result = compactCodeAttributeComposer.istore_2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIstore_2Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#istore_3()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#istore_3()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.istore_3()"})
  public void testIstore_3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIstore_3Result = compactCodeAttributeComposer.istore_3();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIstore_3Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lstore_0()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lstore_0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.lstore_0()"})
  public void testLstore_0() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLstore_0Result = compactCodeAttributeComposer.lstore_0();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLstore_0Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lstore_1()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lstore_1()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.lstore_1()"})
  public void testLstore_1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLstore_1Result = compactCodeAttributeComposer.lstore_1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLstore_1Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lstore_2()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lstore_2()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.lstore_2()"})
  public void testLstore_2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLstore_2Result = compactCodeAttributeComposer.lstore_2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLstore_2Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lstore_3()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lstore_3()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.lstore_3()"})
  public void testLstore_3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLstore_3Result = compactCodeAttributeComposer.lstore_3();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLstore_3Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fstore_0()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fstore_0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.fstore_0()"})
  public void testFstore_0() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFstore_0Result = compactCodeAttributeComposer.fstore_0();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFstore_0Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fstore_1()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fstore_1()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.fstore_1()"})
  public void testFstore_1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFstore_1Result = compactCodeAttributeComposer.fstore_1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFstore_1Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fstore_2()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fstore_2()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.fstore_2()"})
  public void testFstore_2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFstore_2Result = compactCodeAttributeComposer.fstore_2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFstore_2Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fstore_3()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fstore_3()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.fstore_3()"})
  public void testFstore_3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFstore_3Result = compactCodeAttributeComposer.fstore_3();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFstore_3Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dstore_0()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dstore_0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.dstore_0()"})
  public void testDstore_0() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDstore_0Result = compactCodeAttributeComposer.dstore_0();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDstore_0Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dstore_1()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dstore_1()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.dstore_1()"})
  public void testDstore_1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDstore_1Result = compactCodeAttributeComposer.dstore_1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDstore_1Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dstore_2()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dstore_2()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.dstore_2()"})
  public void testDstore_2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDstore_2Result = compactCodeAttributeComposer.dstore_2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDstore_2Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dstore_3()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dstore_3()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.dstore_3()"})
  public void testDstore_3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDstore_3Result = compactCodeAttributeComposer.dstore_3();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDstore_3Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#astore_0()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#astore_0()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.astore_0()"})
  public void testAstore_0() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAstore_0Result = compactCodeAttributeComposer.astore_0();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAstore_0Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#astore_1()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#astore_1()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.astore_1()"})
  public void testAstore_1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAstore_1Result = compactCodeAttributeComposer.astore_1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAstore_1Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#astore_2()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#astore_2()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.astore_2()"})
  public void testAstore_2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAstore_2Result = compactCodeAttributeComposer.astore_2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAstore_2Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#astore_3()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#astore_3()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.astore_3()"})
  public void testAstore_3() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAstore_3Result = compactCodeAttributeComposer.astore_3();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAstore_3Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iastore()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iastore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.iastore()"})
  public void testIastore() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIastoreResult = compactCodeAttributeComposer.iastore();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIastoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lastore()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lastore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.lastore()"})
  public void testLastore() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLastoreResult = compactCodeAttributeComposer.lastore();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLastoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fastore()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fastore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.fastore()"})
  public void testFastore() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFastoreResult = compactCodeAttributeComposer.fastore();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFastoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dastore()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dastore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.dastore()"})
  public void testDastore() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDastoreResult = compactCodeAttributeComposer.dastore();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDastoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#aastore()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#aastore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.aastore()"})
  public void testAastore() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAastoreResult = compactCodeAttributeComposer.aastore();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAastoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#bastore()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#bastore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.bastore()"})
  public void testBastore() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualBastoreResult = compactCodeAttributeComposer.bastore();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualBastoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#castore()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#castore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.castore()"})
  public void testCastore() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualCastoreResult = compactCodeAttributeComposer.castore();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualCastoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#sastore()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#sastore()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.sastore()"})
  public void testSastore() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualSastoreResult = compactCodeAttributeComposer.sastore();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualSastoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pop()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pop()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.pop()"})
  public void testPop() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualPopResult = compactCodeAttributeComposer.pop();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPopResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pop2()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pop2()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.pop2()"})
  public void testPop2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualPop2Result = compactCodeAttributeComposer.pop2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPop2Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dup()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dup()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.dup()"})
  public void testDup() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDupResult = compactCodeAttributeComposer.dup();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDupResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dup_x1()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dup_x1()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.dup_x1()"})
  public void testDup_x1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDup_x1Result = compactCodeAttributeComposer.dup_x1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDup_x1Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dup_x2()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dup_x2()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.dup_x2()"})
  public void testDup_x2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDup_x2Result = compactCodeAttributeComposer.dup_x2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDup_x2Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dup2()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dup2()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.dup2()"})
  public void testDup2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDup2Result = compactCodeAttributeComposer.dup2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDup2Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dup2_x1()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dup2_x1()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.dup2_x1()"})
  public void testDup2_x1() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDup2_x1Result = compactCodeAttributeComposer.dup2_x1();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDup2_x1Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dup2_x2()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dup2_x2()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.dup2_x2()"})
  public void testDup2_x2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDup2_x2Result = compactCodeAttributeComposer.dup2_x2();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDup2_x2Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#swap()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#swap()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.swap()"})
  public void testSwap() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualSwapResult = compactCodeAttributeComposer.swap();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualSwapResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iadd()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iadd()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.iadd()"})
  public void testIadd() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIaddResult = compactCodeAttributeComposer.iadd();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIaddResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ladd()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ladd()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ladd()"})
  public void testLadd() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLaddResult = compactCodeAttributeComposer.ladd();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLaddResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fadd()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fadd()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.fadd()"})
  public void testFadd() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFaddResult = compactCodeAttributeComposer.fadd();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFaddResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dadd()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dadd()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.dadd()"})
  public void testDadd() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDaddResult = compactCodeAttributeComposer.dadd();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDaddResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#isub()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#isub()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.isub()"})
  public void testIsub() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIsubResult = compactCodeAttributeComposer.isub();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIsubResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lsub()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lsub()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.lsub()"})
  public void testLsub() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLsubResult = compactCodeAttributeComposer.lsub();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLsubResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fsub()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fsub()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.fsub()"})
  public void testFsub() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFsubResult = compactCodeAttributeComposer.fsub();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFsubResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dsub()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dsub()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.dsub()"})
  public void testDsub() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDsubResult = compactCodeAttributeComposer.dsub();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDsubResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#imul()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#imul()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.imul()"})
  public void testImul() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualImulResult = compactCodeAttributeComposer.imul();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualImulResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lmul()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lmul()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.lmul()"})
  public void testLmul() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLmulResult = compactCodeAttributeComposer.lmul();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLmulResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fmul()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fmul()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.fmul()"})
  public void testFmul() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFmulResult = compactCodeAttributeComposer.fmul();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFmulResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dmul()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dmul()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.dmul()"})
  public void testDmul() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDmulResult = compactCodeAttributeComposer.dmul();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDmulResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#idiv()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#idiv()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.idiv()"})
  public void testIdiv() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIdivResult = compactCodeAttributeComposer.idiv();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIdivResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ldiv()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ldiv()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ldiv()"})
  public void testLdiv() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLdivResult = compactCodeAttributeComposer.ldiv();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLdivResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fdiv()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fdiv()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.fdiv()"})
  public void testFdiv() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFdivResult = compactCodeAttributeComposer.fdiv();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFdivResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ddiv()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ddiv()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ddiv()"})
  public void testDdiv() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDdivResult = compactCodeAttributeComposer.ddiv();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDdivResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#irem()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#irem()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.irem()"})
  public void testIrem() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIremResult = compactCodeAttributeComposer.irem();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIremResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lrem()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lrem()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.lrem()"})
  public void testLrem() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLremResult = compactCodeAttributeComposer.lrem();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLremResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#frem()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#frem()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.frem()"})
  public void testFrem() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFremResult = compactCodeAttributeComposer.frem();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFremResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#drem()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#drem()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.drem()"})
  public void testDrem() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDremResult = compactCodeAttributeComposer.drem();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDremResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ineg()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ineg()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ineg()"})
  public void testIneg() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualInegResult = compactCodeAttributeComposer.ineg();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInegResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lneg()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lneg()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.lneg()"})
  public void testLneg() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLnegResult = compactCodeAttributeComposer.lneg();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLnegResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fneg()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fneg()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.fneg()"})
  public void testFneg() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFnegResult = compactCodeAttributeComposer.fneg();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFnegResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dneg()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dneg()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.dneg()"})
  public void testDneg() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDnegResult = compactCodeAttributeComposer.dneg();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDnegResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ishl()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ishl()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ishl()"})
  public void testIshl() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIshlResult = compactCodeAttributeComposer.ishl();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIshlResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lshl()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lshl()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.lshl()"})
  public void testLshl() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLshlResult = compactCodeAttributeComposer.lshl();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLshlResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ishr()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ishr()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ishr()"})
  public void testIshr() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIshrResult = compactCodeAttributeComposer.ishr();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIshrResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lshr()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lshr()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.lshr()"})
  public void testLshr() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLshrResult = compactCodeAttributeComposer.lshr();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLshrResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iushr()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iushr()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.iushr()"})
  public void testIushr() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIushrResult = compactCodeAttributeComposer.iushr();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIushrResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lushr()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lushr()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.lushr()"})
  public void testLushr() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLushrResult = compactCodeAttributeComposer.lushr();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLushrResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iand()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iand()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.iand()"})
  public void testIand() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIandResult = compactCodeAttributeComposer.iand();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIandResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#land()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#land()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.land()"})
  public void testLand() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLandResult = compactCodeAttributeComposer.land();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLandResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ior()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ior()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ior()"})
  public void testIor() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIorResult = compactCodeAttributeComposer.ior();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIorResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lor()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.lor()"})
  public void testLor() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLorResult = compactCodeAttributeComposer.lor();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLorResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ixor()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ixor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ixor()"})
  public void testIxor() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIxorResult = compactCodeAttributeComposer.ixor();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIxorResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lxor()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lxor()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.lxor()"})
  public void testLxor() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLxorResult = compactCodeAttributeComposer.lxor();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLxorResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iinc(int, int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iinc(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.iinc(int, int)"})
  public void testIinc() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIincResult = compactCodeAttributeComposer.iinc(1, 1);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIincResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#iinc(int, int)}.
   *
   * <ul>
   *   <li>When twenty-six.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#iinc(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.iinc(int, int)"})
  public void testIinc_whenTwentySix() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIincResult = compactCodeAttributeComposer.iinc(26, 1);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIincResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#i2l()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#i2l()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.i2l()"})
  public void testI2l() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualI2lResult = compactCodeAttributeComposer.i2l();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualI2lResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#i2f()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#i2f()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.i2f()"})
  public void testI2f() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualI2fResult = compactCodeAttributeComposer.i2f();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualI2fResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#i2d()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#i2d()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.i2d()"})
  public void testI2d() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualI2dResult = compactCodeAttributeComposer.i2d();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualI2dResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#l2i()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#l2i()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.l2i()"})
  public void testL2i() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualL2iResult = compactCodeAttributeComposer.l2i();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualL2iResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#l2f()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#l2f()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.l2f()"})
  public void testL2f() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualL2fResult = compactCodeAttributeComposer.l2f();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualL2fResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#l2d()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#l2d()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.l2d()"})
  public void testL2d() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualL2dResult = compactCodeAttributeComposer.l2d();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualL2dResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#f2i()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#f2i()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.f2i()"})
  public void testF2i() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualF2iResult = compactCodeAttributeComposer.f2i();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualF2iResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#f2l()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#f2l()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.f2l()"})
  public void testF2l() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualF2lResult = compactCodeAttributeComposer.f2l();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualF2lResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#f2d()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#f2d()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.f2d()"})
  public void testF2d() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualF2dResult = compactCodeAttributeComposer.f2d();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualF2dResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#d2i()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#d2i()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.d2i()"})
  public void testD2i() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualD2iResult = compactCodeAttributeComposer.d2i();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualD2iResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#d2l()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#d2l()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.d2l()"})
  public void testD2l() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualD2lResult = compactCodeAttributeComposer.d2l();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualD2lResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#d2f()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#d2f()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.d2f()"})
  public void testD2f() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualD2fResult = compactCodeAttributeComposer.d2f();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualD2fResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#i2b()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#i2b()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.i2b()"})
  public void testI2b() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualI2bResult = compactCodeAttributeComposer.i2b();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualI2bResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#i2c()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#i2c()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.i2c()"})
  public void testI2c() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualI2cResult = compactCodeAttributeComposer.i2c();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualI2cResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#i2s()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#i2s()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.i2s()"})
  public void testI2s() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualI2sResult = compactCodeAttributeComposer.i2s();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualI2sResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lcmp()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lcmp()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.lcmp()"})
  public void testLcmp() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLcmpResult = compactCodeAttributeComposer.lcmp();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLcmpResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fcmpl()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fcmpl()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.fcmpl()"})
  public void testFcmpl() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFcmplResult = compactCodeAttributeComposer.fcmpl();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFcmplResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#fcmpg()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#fcmpg()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.fcmpg()"})
  public void testFcmpg() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFcmpgResult = compactCodeAttributeComposer.fcmpg();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFcmpgResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dcmpl()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dcmpl()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.dcmpl()"})
  public void testDcmpl() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDcmplResult = compactCodeAttributeComposer.dcmpl();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDcmplResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dcmpg()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dcmpg()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.dcmpg()"})
  public void testDcmpg() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDcmpgResult = compactCodeAttributeComposer.dcmpg();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDcmpgResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ret(int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ret(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ret(int)"})
  public void testRet_whenOne() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualRetResult = compactCodeAttributeComposer.ret(1);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualRetResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ret(int)}.
   *
   * <ul>
   *   <li>When twenty-six.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ret(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ret(int)"})
  public void testRet_whenTwentySix() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualRetResult = compactCodeAttributeComposer.ret(26);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualRetResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#ireturn()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#ireturn()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.ireturn()"})
  public void testIreturn() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualIreturnResult = compactCodeAttributeComposer.ireturn();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualIreturnResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#lreturn()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#lreturn()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.lreturn()"})
  public void testLreturn() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLreturnResult = compactCodeAttributeComposer.lreturn();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLreturnResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#freturn()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#freturn()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.freturn()"})
  public void testFreturn() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualFreturnResult = compactCodeAttributeComposer.freturn();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualFreturnResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#dreturn()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#dreturn()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.dreturn()"})
  public void testDreturn() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualDreturnResult = compactCodeAttributeComposer.dreturn();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualDreturnResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#areturn()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#areturn()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.areturn()"})
  public void testAreturn() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAreturnResult = compactCodeAttributeComposer.areturn();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAreturnResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#return_()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#return_()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.return_()"})
  public void testReturn_() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualReturn_Result = compactCodeAttributeComposer.return_();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualReturn_Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#return_(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code ()I}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#return_(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.return_(String)"})
  public void testReturn_WithString_whenI() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualReturn_Result = compactCodeAttributeComposer.return_("()I");

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualReturn_Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#return_(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code Internal Type}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#return_(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.return_(String)"})
  public void testReturn_WithString_whenInternalType() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualReturn_Result =
        compactCodeAttributeComposer.return_("Internal Type");

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualReturn_Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#getstatic(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#getstatic(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.getstatic(String, String, String)"
  })
  public void testGetstaticWithClassNameNameDescriptor() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.getstatic("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#getstatic(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#getstatic(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.getstatic(String, String, String)"
  })
  public void testGetstaticWithClassNameNameDescriptor2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.getstatic("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#getstatic(String, String, String, Clazz, Field)} with
   * {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedField}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#getstatic(String, String, String,
   * Clazz, Field)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.getstatic(String, String, String, Clazz, Field)"
  })
  public void testGetstaticWithClassNameNameDescriptorReferencedClassReferencedField() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.getstatic(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#getstatic(String, String, String, Clazz, Field)} with
   * {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedField}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#getstatic(String, String, String,
   * Clazz, Field)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.getstatic(String, String, String, Clazz, Field)"
  })
  public void testGetstaticWithClassNameNameDescriptorReferencedClassReferencedField2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.getstatic(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#getstatic(int)} with {@code constantIndex}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#getstatic(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.getstatic(int)"})
  public void testGetstaticWithConstantIndex() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualGetstaticResult = compactCodeAttributeComposer.getstatic(1);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualGetstaticResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#putstatic(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#putstatic(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.putstatic(String, String, String)"
  })
  public void testPutstaticWithClassNameNameDescriptor() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.putstatic("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#putstatic(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#putstatic(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.putstatic(String, String, String)"
  })
  public void testPutstaticWithClassNameNameDescriptor2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.putstatic("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#putstatic(String, String, String, Clazz, Field)} with
   * {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedField}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#putstatic(String, String, String,
   * Clazz, Field)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.putstatic(String, String, String, Clazz, Field)"
  })
  public void testPutstaticWithClassNameNameDescriptorReferencedClassReferencedField() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.putstatic(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#putstatic(String, String, String, Clazz, Field)} with
   * {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedField}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#putstatic(String, String, String,
   * Clazz, Field)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.putstatic(String, String, String, Clazz, Field)"
  })
  public void testPutstaticWithClassNameNameDescriptorReferencedClassReferencedField2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.putstatic(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#putstatic(int)} with {@code constantIndex}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#putstatic(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.putstatic(int)"})
  public void testPutstaticWithConstantIndex() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualPutstaticResult = compactCodeAttributeComposer.putstatic(1);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPutstaticResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#getfield(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#getfield(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.getfield(String, String, String)"
  })
  public void testGetfieldWithClassNameNameDescriptor() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.getfield("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#getfield(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#getfield(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.getfield(String, String, String)"
  })
  public void testGetfieldWithClassNameNameDescriptor2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.getfield("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#getfield(String, String, String, Clazz, Field)} with
   * {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedField}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#getfield(String, String, String,
   * Clazz, Field)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.getfield(String, String, String, Clazz, Field)"
  })
  public void testGetfieldWithClassNameNameDescriptorReferencedClassReferencedField() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.getfield(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#getfield(String, String, String, Clazz, Field)} with
   * {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedField}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#getfield(String, String, String,
   * Clazz, Field)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.getfield(String, String, String, Clazz, Field)"
  })
  public void testGetfieldWithClassNameNameDescriptorReferencedClassReferencedField2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.getfield(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#getfield(int)} with {@code constantIndex}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#getfield(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.getfield(int)"})
  public void testGetfieldWithConstantIndex() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualGetfieldResult = compactCodeAttributeComposer.getfield(1);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualGetfieldResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#putfield(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#putfield(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.putfield(String, String, String)"
  })
  public void testPutfieldWithClassNameNameDescriptor() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.putfield("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#putfield(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#putfield(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.putfield(String, String, String)"
  })
  public void testPutfieldWithClassNameNameDescriptor2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.putfield("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#putfield(String, String, String, Clazz, Field)} with
   * {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedField}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#putfield(String, String, String,
   * Clazz, Field)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.putfield(String, String, String, Clazz, Field)"
  })
  public void testPutfieldWithClassNameNameDescriptorReferencedClassReferencedField() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.putfield(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#putfield(String, String, String, Clazz, Field)} with
   * {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedField}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#putfield(String, String, String,
   * Clazz, Field)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.putfield(String, String, String, Clazz, Field)"
  })
  public void testPutfieldWithClassNameNameDescriptorReferencedClassReferencedField2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.putfield(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryField(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#putfield(int)} with {@code constantIndex}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#putfield(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.putfield(int)"})
  public void testPutfieldWithConstantIndex() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualPutfieldResult = compactCodeAttributeComposer.putfield(1);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPutfieldResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokevirtual(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokevirtual(String, String,
   * String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.invokevirtual(String, String, String)"
  })
  public void testInvokevirtualWithClassNameNameDescriptor() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.invokevirtual("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokevirtual(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokevirtual(String, String,
   * String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.invokevirtual(String, String, String)"
  })
  public void testInvokevirtualWithClassNameNameDescriptor2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.invokevirtual("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokevirtual(String, String, String, Clazz, Method)}
   * with {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedMethod}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokevirtual(String, String, String,
   * Clazz, Method)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.invokevirtual(String, String, String, Clazz, Method)"
  })
  public void testInvokevirtualWithClassNameNameDescriptorReferencedClassReferencedMethod() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.invokevirtual(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryMethod(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokevirtual(String, String, String, Clazz, Method)}
   * with {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedMethod}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokevirtual(String, String, String,
   * Clazz, Method)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.invokevirtual(String, String, String, Clazz, Method)"
  })
  public void testInvokevirtualWithClassNameNameDescriptorReferencedClassReferencedMethod2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.invokevirtual(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryMethod(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokevirtual(int)} with {@code constantIndex}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokevirtual(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.invokevirtual(int)"
  })
  public void testInvokevirtualWithConstantIndex() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualInvokevirtualResult =
        compactCodeAttributeComposer.invokevirtual(1);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInvokevirtualResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokespecial(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokespecial(String, String,
   * String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.invokespecial(String, String, String)"
  })
  public void testInvokespecialWithClassNameNameDescriptor() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.invokespecial("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokespecial(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokespecial(String, String,
   * String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.invokespecial(String, String, String)"
  })
  public void testInvokespecialWithClassNameNameDescriptor2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.invokespecial("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokespecial(String, String, String, Clazz, Method)}
   * with {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedMethod}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokespecial(String, String, String,
   * Clazz, Method)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.invokespecial(String, String, String, Clazz, Method)"
  })
  public void testInvokespecialWithClassNameNameDescriptorReferencedClassReferencedMethod() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.invokespecial(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryMethod(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokespecial(String, String, String, Clazz, Method)}
   * with {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedMethod}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokespecial(String, String, String,
   * Clazz, Method)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.invokespecial(String, String, String, Clazz, Method)"
  })
  public void testInvokespecialWithClassNameNameDescriptorReferencedClassReferencedMethod2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.invokespecial(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryMethod(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokespecial(int)} with {@code constantIndex}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokespecial(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.invokespecial(int)"
  })
  public void testInvokespecialWithConstantIndex() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualInvokespecialResult =
        compactCodeAttributeComposer.invokespecial(1);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInvokespecialResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokestatic(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokestatic(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.invokestatic(String, String, String)"
  })
  public void testInvokestaticWithClassNameNameDescriptor() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.invokestatic("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokestatic(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokestatic(String, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.invokestatic(String, String, String)"
  })
  public void testInvokestaticWithClassNameNameDescriptor2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.invokestatic("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokestatic(String, String, String, Clazz, Method)}
   * with {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedMethod}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokestatic(String, String, String,
   * Clazz, Method)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.invokestatic(String, String, String, Clazz, Method)"
  })
  public void testInvokestaticWithClassNameNameDescriptorReferencedClassReferencedMethod() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.invokestatic(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryMethod(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokestatic(String, String, String, Clazz, Method)}
   * with {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedMethod}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokestatic(String, String, String,
   * Clazz, Method)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.invokestatic(String, String, String, Clazz, Method)"
  })
  public void testInvokestaticWithClassNameNameDescriptorReferencedClassReferencedMethod2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.invokestatic(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryMethod(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokestatic(int)} with {@code constantIndex}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokestatic(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.invokestatic(int)"})
  public void testInvokestaticWithConstantIndex() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualInvokestaticResult =
        compactCodeAttributeComposer.invokestatic(1);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInvokestaticResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokestatic_interface(String, String, String)} with
   * {@code className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokestatic_interface(String,
   * String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.invokestatic_interface(String, String, String)"
  })
  public void testInvokestatic_interfaceWithClassNameNameDescriptor() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.invokestatic_interface("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokestatic_interface(String, String, String)} with
   * {@code className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokestatic_interface(String,
   * String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.invokestatic_interface(String, String, String)"
  })
  public void testInvokestatic_interfaceWithClassNameNameDescriptor2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.invokestatic_interface("Class Name", "Name", "Descriptor"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokestatic_interface(String, String, String, Clazz,
   * Method)} with {@code className}, {@code name}, {@code descriptor}, {@code referencedClass},
   * {@code referencedMethod}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokestatic_interface(String,
   * String, String, Clazz, Method)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.invokestatic_interface(String, String, String, Clazz, Method)"
  })
  public void
      testInvokestatic_interfaceWithClassNameNameDescriptorReferencedClassReferencedMethod() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.invokestatic_interface(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryMethod(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokestatic_interface(String, String, String, Clazz,
   * Method)} with {@code className}, {@code name}, {@code descriptor}, {@code referencedClass},
   * {@code referencedMethod}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokestatic_interface(String,
   * String, String, Clazz, Method)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.invokestatic_interface(String, String, String, Clazz, Method)"
  })
  public void
      testInvokestatic_interfaceWithClassNameNameDescriptorReferencedClassReferencedMethod2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.invokestatic_interface(
            "Class Name",
            "Name",
            "Descriptor",
            referencedClass,
            new LibraryMethod(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokeinterface(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokeinterface(String, String,
   * String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.invokeinterface(String, String, String)"
  })
  public void testInvokeinterfaceWithClassNameNameDescriptor() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.invokeinterface("Class Name", "Name", "()I"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokeinterface(String, String, String)} with {@code
   * className}, {@code name}, {@code descriptor}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokeinterface(String, String,
   * String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.invokeinterface(String, String, String)"
  })
  public void testInvokeinterfaceWithClassNameNameDescriptor2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.invokeinterface("Class Name", "Name", "()I"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokeinterface(String, String, String, Clazz,
   * Method)} with {@code className}, {@code name}, {@code descriptor}, {@code referencedClass},
   * {@code referencedMethod}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokeinterface(String, String,
   * String, Clazz, Method)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.invokeinterface(String, String, String, Clazz, Method)"
  })
  public void testInvokeinterfaceWithClassNameNameDescriptorReferencedClassReferencedMethod() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.invokeinterface(
            "Class Name",
            "Name",
            "()I",
            referencedClass,
            new LibraryMethod(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokeinterface(String, String, String, Clazz,
   * Method)} with {@code className}, {@code name}, {@code descriptor}, {@code referencedClass},
   * {@code referencedMethod}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokeinterface(String, String,
   * String, Clazz, Method)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.invokeinterface(String, String, String, Clazz, Method)"
  })
  public void testInvokeinterfaceWithClassNameNameDescriptorReferencedClassReferencedMethod2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.invokeinterface(
            "Class Name",
            "Name",
            "()I",
            referencedClass,
            new LibraryMethod(1, "Name", "Descriptor")));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokeinterface(int, int)} with {@code constantIndex},
   * {@code constant}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokeinterface(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.invokeinterface(int, int)"
  })
  public void testInvokeinterfaceWithConstantIndexConstant() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualInvokeinterfaceResult =
        compactCodeAttributeComposer.invokeinterface(1, 1);

    // Assert
    assertEquals(5, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInvokeinterfaceResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokeinterface(int, int)} with {@code constantIndex},
   * {@code constant}.
   *
   * <ul>
   *   <li>When {@link ClassEstimates#TYPICAL_CODE_LENGTH}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokeinterface(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.invokeinterface(int, int)"
  })
  public void testInvokeinterfaceWithConstantIndexConstant_whenTypical_code_length() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualInvokeinterfaceResult =
        compactCodeAttributeComposer.invokeinterface(ClassEstimates.TYPICAL_CODE_LENGTH, 1);

    // Assert
    assertEquals(5, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInvokeinterfaceResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokedynamic(int, String, String, Clazz[])} with
   * {@code bootStrapMethodIndex}, {@code name}, {@code descriptor}, {@code referencedClasses}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokedynamic(int, String, String,
   * Clazz[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.invokedynamic(int, String, String, Clazz[])"
  })
  public void testInvokedynamicWithBootStrapMethodIndexNameDescriptorReferencedClasses() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.invokedynamic(
            1, "Name", "Descriptor", new Clazz[] {new LibraryClass()}));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokedynamic(int, String, String, Clazz[])} with
   * {@code bootStrapMethodIndex}, {@code name}, {@code descriptor}, {@code referencedClasses}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokedynamic(int, String, String,
   * Clazz[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.invokedynamic(int, String, String, Clazz[])"
  })
  public void testInvokedynamicWithBootStrapMethodIndexNameDescriptorReferencedClasses2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.invokedynamic(
            1, "Name", "Descriptor", new Clazz[] {new LibraryClass()}));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokedynamic(int)} with {@code constantIndex}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokedynamic(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.invokedynamic(int)"
  })
  public void testInvokedynamicWithConstantIndex_whenOne() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualInvokedynamicResult =
        compactCodeAttributeComposer.invokedynamic(1);

    // Assert
    assertEquals(5, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInvokedynamicResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#invokedynamic(int)} with {@code constantIndex}.
   *
   * <ul>
   *   <li>When {@link ClassEstimates#TYPICAL_CODE_LENGTH}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#invokedynamic(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.invokedynamic(int)"
  })
  public void testInvokedynamicWithConstantIndex_whenTypical_code_length() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualInvokedynamicResult =
        compactCodeAttributeComposer.invokedynamic(ClassEstimates.TYPICAL_CODE_LENGTH);

    // Assert
    assertEquals(5, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInvokedynamicResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#new_(String)} with {@code className}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#new_(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.new_(String)"})
  public void testNew_WithClassName() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.new_("Class Name"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#new_(String)} with {@code className}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#new_(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.new_(String)"})
  public void testNew_WithClassName2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.new_("Class Name"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#new_(String, Clazz)} with {@code className}, {@code
   * referencedClass}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#new_(String, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.new_(String, Clazz)"
  })
  public void testNew_WithClassNameReferencedClass() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.new_("Class Name", new LibraryClass()));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#new_(String, Clazz)} with {@code className}, {@code
   * referencedClass}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#new_(String, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.new_(String, Clazz)"
  })
  public void testNew_WithClassNameReferencedClass2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.new_("Class Name", new LibraryClass()));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#new_(Clazz)} with {@code clazz}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#new_(Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.new_(Clazz)"})
  public void testNew_WithClazz() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act
    CompactCodeAttributeComposer actualNew_Result =
        compactCodeAttributeComposer.new_(new LibraryClass());

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualNew_Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#new_(int)} with {@code constantIndex}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#new_(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.new_(int)"})
  public void testNew_WithConstantIndex() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualNew_Result = compactCodeAttributeComposer.new_(1);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualNew_Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#newarray(int)}.
   *
   * <ul>
   *   <li>When minus sixty-eight.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#newarray(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.newarray(int)"})
  public void testNewarray_whenMinusSixtyEight() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualNewarrayResult = compactCodeAttributeComposer.newarray(-68);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualNewarrayResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#newarray(int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#newarray(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.newarray(int)"})
  public void testNewarray_whenOne() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualNewarrayResult = compactCodeAttributeComposer.newarray(1);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualNewarrayResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#newarray(int)}.
   *
   * <ul>
   *   <li>When six.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#newarray(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.newarray(int)"})
  public void testNewarray_whenSix() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualNewarrayResult = compactCodeAttributeComposer.newarray(6);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualNewarrayResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#anewarray(String, Clazz)} with {@code className},
   * {@code referencedClass}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#anewarray(String, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.anewarray(String, Clazz)"
  })
  public void testAnewarrayWithClassNameReferencedClass() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.anewarray("Class Name", new LibraryClass()));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#anewarray(String, Clazz)} with {@code className},
   * {@code referencedClass}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#anewarray(String, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.anewarray(String, Clazz)"
  })
  public void testAnewarrayWithClassNameReferencedClass2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.anewarray("Class Name", new LibraryClass()));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#anewarray(int)} with {@code constantIndex}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#anewarray(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.anewarray(int)"})
  public void testAnewarrayWithConstantIndex() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAnewarrayResult = compactCodeAttributeComposer.anewarray(1);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAnewarrayResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#arraylength()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#arraylength()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.arraylength()"})
  public void testArraylength() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualArraylengthResult =
        compactCodeAttributeComposer.arraylength();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualArraylengthResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#athrow()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#athrow()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.athrow()"})
  public void testAthrow() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualAthrowResult = compactCodeAttributeComposer.athrow();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualAthrowResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#checkcast(String)} with {@code className}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#checkcast(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.checkcast(String)"})
  public void testCheckcastWithClassName() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.checkcast("Class Name"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#checkcast(String)} with {@code className}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#checkcast(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.checkcast(String)"})
  public void testCheckcastWithClassName2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.checkcast("Class Name"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#checkcast(String, Clazz)} with {@code className},
   * {@code referencedClass}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#checkcast(String, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.checkcast(String, Clazz)"
  })
  public void testCheckcastWithClassNameReferencedClass() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.checkcast("Class Name", new LibraryClass()));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#checkcast(String, Clazz)} with {@code className},
   * {@code referencedClass}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#checkcast(String, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.checkcast(String, Clazz)"
  })
  public void testCheckcastWithClassNameReferencedClass2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.checkcast("Class Name", new LibraryClass()));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#checkcast(int)} with {@code constantIndex}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#checkcast(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.checkcast(int)"})
  public void testCheckcastWithConstantIndex() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualCheckcastResult = compactCodeAttributeComposer.checkcast(1);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualCheckcastResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#instanceof_(String, Clazz)} with {@code className},
   * {@code referencedClass}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#instanceof_(String, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.instanceof_(String, Clazz)"
  })
  public void testInstanceof_WithClassNameReferencedClass() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.instanceof_("Class Name", new LibraryClass()));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#instanceof_(String, Clazz)} with {@code className},
   * {@code referencedClass}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#instanceof_(String, Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.instanceof_(String, Clazz)"
  })
  public void testInstanceof_WithClassNameReferencedClass2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.instanceof_("Class Name", new LibraryClass()));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#instanceof_(int)} with {@code constantIndex}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#instanceof_(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.instanceof_(int)"})
  public void testInstanceof_WithConstantIndex() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualInstanceof_Result =
        compactCodeAttributeComposer.instanceof_(1);

    // Assert
    assertEquals(3, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualInstanceof_Result);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#monitorenter()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#monitorenter()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.monitorenter()"})
  public void testMonitorenter() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualMonitorenterResult =
        compactCodeAttributeComposer.monitorenter();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualMonitorenterResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#monitorexit()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#monitorexit()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.monitorexit()"})
  public void testMonitorexit() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualMonitorexitResult =
        compactCodeAttributeComposer.monitorexit();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualMonitorexitResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#wide()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#wide()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.wide()"})
  public void testWide() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualWideResult = compactCodeAttributeComposer.wide();

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualWideResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#multianewarray(String, Clazz, int)} with {@code
   * className}, {@code referencedClass}, {@code dimensions}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#multianewarray(String, Clazz, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.multianewarray(String, Clazz, int)"
  })
  public void testMultianewarrayWithClassNameReferencedClassDimensions() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.multianewarray("Class Name", new LibraryClass(), 1));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#multianewarray(String, Clazz, int)} with {@code
   * className}, {@code referencedClass}, {@code dimensions}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#multianewarray(String, Clazz, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.multianewarray(String, Clazz, int)"
  })
  public void testMultianewarrayWithClassNameReferencedClassDimensions2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.multianewarray("Class Name", new LibraryClass(), 1));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#multianewarray(int, int)} with {@code constantIndex},
   * {@code dimensions}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#multianewarray(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.multianewarray(int, int)"
  })
  public void testMultianewarrayWithConstantIndexDimensions() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualMultianewarrayResult =
        compactCodeAttributeComposer.multianewarray(1, 1);

    // Assert
    assertEquals(4, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualMultianewarrayResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#multianewarray(int, int)} with {@code constantIndex},
   * {@code dimensions}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#multianewarray(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.multianewarray(int, int)"
  })
  public void testMultianewarrayWithConstantIndexDimensions2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualMultianewarrayResult =
        compactCodeAttributeComposer.multianewarray(ClassEstimates.TYPICAL_CODE_LENGTH, 1);

    // Assert
    assertEquals(4, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualMultianewarrayResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushPrimitive(Object, char)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushPrimitive(Object, char)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.pushPrimitive(Object, char)"
  })
  public void testPushPrimitive() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            (new CompactCodeAttributeComposer(new ProgramClass())).pushPrimitive("Primitive", 'A'));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushInt(int)}.
   *
   * <ul>
   *   <li>When five.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushInt(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.pushInt(int)"})
  public void testPushInt_whenFive() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualPushIntResult = compactCodeAttributeComposer.pushInt(5);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPushIntResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushInt(int)}.
   *
   * <ul>
   *   <li>When forty-two.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushInt(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.pushInt(int)"})
  public void testPushInt_whenFortyTwo() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualPushIntResult = compactCodeAttributeComposer.pushInt(42);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPushIntResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushInt(int)}.
   *
   * <ul>
   *   <li>When four.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushInt(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.pushInt(int)"})
  public void testPushInt_whenFour() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualPushIntResult = compactCodeAttributeComposer.pushInt(4);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPushIntResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushInt(int)}.
   *
   * <ul>
   *   <li>When minus one.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushInt(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.pushInt(int)"})
  public void testPushInt_whenMinusOne() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualPushIntResult = compactCodeAttributeComposer.pushInt(-1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPushIntResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushInt(int)}.
   *
   * <ul>
   *   <li>When minus one hundred twenty-eight.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushInt(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.pushInt(int)"})
  public void testPushInt_whenMinusOneHundredTwentyEight() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualPushIntResult = compactCodeAttributeComposer.pushInt(-128);

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPushIntResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushInt(int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushInt(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.pushInt(int)"})
  public void testPushInt_whenOne() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualPushIntResult = compactCodeAttributeComposer.pushInt(1);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPushIntResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushInt(int)}.
   *
   * <ul>
   *   <li>When three.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushInt(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.pushInt(int)"})
  public void testPushInt_whenThree() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualPushIntResult = compactCodeAttributeComposer.pushInt(3);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPushIntResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushInt(int)}.
   *
   * <ul>
   *   <li>When two.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushInt(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.pushInt(int)"})
  public void testPushInt_whenTwo() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualPushIntResult = compactCodeAttributeComposer.pushInt(2);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPushIntResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushInt(int)}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushInt(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.pushInt(int)"})
  public void testPushInt_whenZero() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualPushIntResult = compactCodeAttributeComposer.pushInt(0);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualPushIntResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushFloat(float)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushFloat(float)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.pushFloat(float)"})
  public void testPushFloat() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.pushFloat(10.0f));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushFloat(float)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushFloat(float)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.pushFloat(float)"})
  public void testPushFloat2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 0, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.pushFloat(10.0f));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushFloat(float)}.
   *
   * <ul>
   *   <li>Then fourth element return {@link FloatConstant}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushFloat(float)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.pushFloat(float)"})
  public void testPushFloat_thenFourthElementReturnFloatConstant() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ClassConstant classConstant3 = new ClassConstant();

    // Act
    CompactCodeAttributeComposer actualPushFloatResult =
        (new CompactCodeAttributeComposer(
                new ProgramClass(
                    1, 3, new Constant[] {classConstant, classConstant2, classConstant3}, 1, 1, 1)))
            .pushFloat(10.0f);

    // Assert
    ProgramClass targetClass = actualPushFloatResult.getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    Constant constant = constantArray[3];
    assertTrue(constant instanceof FloatConstant);
    assertNull(constant.getProcessingInfo());
    assertNull(targetClass.getSuperClass());
    assertNull(constantArray[17]);
    assertNull(constantArray[18]);
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(10.0f, ((FloatConstant) constant).getValue(), 0.0f);
    assertEquals(19, constantArray.length);
    assertEquals(4, constant.getTag());
    assertEquals(4, targetClass.u2constantPoolCount);
    assertFalse(constant.isCategory2());
    assertSame(classConstant2, constantArray[1]);
    assertSame(classConstant3, constantArray[2]);
    assertSame(targetClass, actualPushFloatResult.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushFloat(float)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushFloat(float)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.pushFloat(float)"})
  public void testPushFloat_whenOne() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 3, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualPushFloatResult =
        compactCodeAttributeComposer.pushFloat(1.0f);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertEquals(1, actualPushFloatResult.getCodeLength());
    ProgramClass targetClass = actualPushFloatResult.getTargetClass();
    assertEquals(3, targetClass.u2constantPoolCount);
    assertSame(targetClass, actualPushFloatResult.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushFloat(float)}.
   *
   * <ul>
   *   <li>When two.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushFloat(float)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.pushFloat(float)"})
  public void testPushFloat_whenTwo() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 3, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualPushFloatResult =
        compactCodeAttributeComposer.pushFloat(2.0f);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertEquals(1, actualPushFloatResult.getCodeLength());
    ProgramClass targetClass = actualPushFloatResult.getTargetClass();
    assertEquals(3, targetClass.u2constantPoolCount);
    assertSame(targetClass, actualPushFloatResult.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushFloat(float)}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushFloat(float)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.pushFloat(float)"})
  public void testPushFloat_whenZero() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 3, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualPushFloatResult =
        compactCodeAttributeComposer.pushFloat(0.0f);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertEquals(1, actualPushFloatResult.getCodeLength());
    ProgramClass targetClass = actualPushFloatResult.getTargetClass();
    assertEquals(3, targetClass.u2constantPoolCount);
    assertSame(targetClass, actualPushFloatResult.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushLong(long)}.
   *
   * <ul>
   *   <li>Then fourth element return {@link LongConstant}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushLong(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.pushLong(long)"})
  public void testPushLong_thenFourthElementReturnLongConstant() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ClassConstant classConstant3 = new ClassConstant();

    // Act
    CompactCodeAttributeComposer actualPushLongResult =
        (new CompactCodeAttributeComposer(
                new ProgramClass(
                    42,
                    3,
                    new Constant[] {classConstant, classConstant2, classConstant3},
                    42,
                    42,
                    42)))
            .pushLong(42L);

    // Assert
    ProgramClass targetClass = actualPushLongResult.getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    Constant constant = constantArray[3];
    assertTrue(constant instanceof LongConstant);
    assertNull(constant.getProcessingInfo());
    assertNull(constantArray[17]);
    assertNull(constantArray[18]);
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(19, constantArray.length);
    assertEquals(42L, ((LongConstant) constant).getValue());
    assertEquals(5, constant.getTag());
    assertEquals(5, targetClass.u2constantPoolCount);
    assertTrue(constant.isCategory2());
    assertSame(classConstant2, constantArray[1]);
    assertSame(classConstant3, constantArray[2]);
    assertSame(targetClass, actualPushLongResult.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushLong(long)}.
   *
   * <ul>
   *   <li>Then return {@link
   *       CompactCodeAttributeComposer#CompactCodeAttributeComposer(ProgramClass)} with targetClass
   *       is {@link ProgramClass#ProgramClass(int, int, Constant[], int, int, int)}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushLong(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.pushLong(long)"})
  public void testPushLong_thenReturnCompactCodeAttributeComposerWithTargetClassIsProgramClass() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(42, 1, new Constant[] {new ClassConstant()}, 42, 42, 42));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.pushLong(42L));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushLong(long)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushLong(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.pushLong(long)"})
  public void testPushLong_whenOne() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(42, 3, new Constant[] {new ClassConstant()}, 42, 42, 42));

    // Act
    CompactCodeAttributeComposer actualPushLongResult = compactCodeAttributeComposer.pushLong(1L);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertEquals(1, actualPushLongResult.getCodeLength());
    ProgramClass targetClass = actualPushLongResult.getTargetClass();
    assertEquals(1, targetClass.constantPool.length);
    assertSame(targetClass, actualPushLongResult.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushLong(long)}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushLong(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.pushLong(long)"})
  public void testPushLong_whenZero() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(42, 3, new Constant[] {new ClassConstant()}, 42, 42, 42));

    // Act
    CompactCodeAttributeComposer actualPushLongResult = compactCodeAttributeComposer.pushLong(0L);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertEquals(1, actualPushLongResult.getCodeLength());
    ProgramClass targetClass = actualPushLongResult.getTargetClass();
    assertEquals(1, targetClass.constantPool.length);
    assertSame(targetClass, actualPushLongResult.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushDouble(double)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushDouble(double)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.pushDouble(double)"
  })
  public void testPushDouble() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(compactCodeAttributeComposer, compactCodeAttributeComposer.pushDouble(10.0d));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushDouble(double)}.
   *
   * <ul>
   *   <li>Then fourth element return {@link DoubleConstant}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushDouble(double)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.pushDouble(double)"
  })
  public void testPushDouble_thenFourthElementReturnDoubleConstant() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ClassConstant classConstant3 = new ClassConstant();

    // Act
    CompactCodeAttributeComposer actualPushDoubleResult =
        (new CompactCodeAttributeComposer(
                new ProgramClass(
                    1, 3, new Constant[] {classConstant, classConstant2, classConstant3}, 1, 1, 1)))
            .pushDouble(10.0d);

    // Assert
    ProgramClass targetClass = actualPushDoubleResult.getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    Constant constant = constantArray[3];
    assertTrue(constant instanceof DoubleConstant);
    assertNull(constant.getProcessingInfo());
    assertNull(targetClass.getSuperClass());
    assertNull(constantArray[17]);
    assertNull(constantArray[18]);
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(10.0d, ((DoubleConstant) constant).getValue(), 0.0);
    assertEquals(19, constantArray.length);
    assertEquals(5, targetClass.u2constantPoolCount);
    assertEquals(6, constant.getTag());
    assertTrue(constant.isCategory2());
    assertSame(classConstant2, constantArray[1]);
    assertSame(classConstant3, constantArray[2]);
    assertSame(targetClass, actualPushDoubleResult.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushDouble(double)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushDouble(double)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.pushDouble(double)"
  })
  public void testPushDouble_whenOne() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 3, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualPushDoubleResult =
        compactCodeAttributeComposer.pushDouble(1.0d);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertEquals(1, actualPushDoubleResult.getCodeLength());
    ProgramClass targetClass = actualPushDoubleResult.getTargetClass();
    assertEquals(1, targetClass.constantPool.length);
    assertSame(targetClass, actualPushDoubleResult.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushDouble(double)}.
   *
   * <ul>
   *   <li>When zero.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushDouble(double)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.pushDouble(double)"
  })
  public void testPushDouble_whenZero() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 3, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act
    CompactCodeAttributeComposer actualPushDoubleResult =
        compactCodeAttributeComposer.pushDouble(0.0d);

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertEquals(1, actualPushDoubleResult.getCodeLength());
    ProgramClass targetClass = actualPushDoubleResult.getTargetClass();
    assertEquals(1, targetClass.constantPool.length);
    assertSame(targetClass, actualPushDoubleResult.getConstantPoolEditor().getTargetClass());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushNewArray(String, int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushNewArray(String, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.pushNewArray(String, int)"
  })
  public void testPushNewArray() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(-1, 1, new Constant[] {new ClassConstant()}, -1, -1, -1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.pushNewArray("Element Type Or Class Name", 3));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#pushNewArray(String, int)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#pushNewArray(String, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.pushNewArray(String, int)"
  })
  public void testPushNewArray2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                -1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                -1,
                -1,
                -1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.pushNewArray("Element Type Or Class Name", 3));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#load(int, char)} with {@code int}, {@code char}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#load(int, char)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.load(int, char)"})
  public void testLoadWithIntChar() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLoadResult = compactCodeAttributeComposer.load(66, 'A');

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLoadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#load(int, char)} with {@code int}, {@code char}.
   *
   * <ul>
   *   <li>When {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#load(int, char)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.load(int, char)"})
  public void testLoadWithIntChar_whenA() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLoadResult = compactCodeAttributeComposer.load(1, 'A');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLoadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#load(int, char)} with {@code int}, {@code char}.
   *
   * <ul>
   *   <li>When {@code B}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#load(int, char)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.load(int, char)"})
  public void testLoadWithIntChar_whenB() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLoadResult = compactCodeAttributeComposer.load(1, 'B');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLoadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#load(int, char)} with {@code int}, {@code char}.
   *
   * <ul>
   *   <li>When {@code D}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#load(int, char)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.load(int, char)"})
  public void testLoadWithIntChar_whenD() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLoadResult = compactCodeAttributeComposer.load(1, 'D');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLoadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#load(int, char)} with {@code int}, {@code char}.
   *
   * <ul>
   *   <li>When {@code F}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#load(int, char)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.load(int, char)"})
  public void testLoadWithIntChar_whenF() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLoadResult = compactCodeAttributeComposer.load(1, 'F');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLoadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#load(int, char)} with {@code int}, {@code char}.
   *
   * <ul>
   *   <li>When {@code J}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#load(int, char)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.load(int, char)"})
  public void testLoadWithIntChar_whenJ() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLoadResult = compactCodeAttributeComposer.load(1, 'J');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLoadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#load(int, String)} with {@code int}, {@code String}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#load(int, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.load(int, String)"})
  public void testLoadWithIntString() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLoadResult =
        compactCodeAttributeComposer.load(1, "Internal Type");

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLoadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#load(int, String)} with {@code int}, {@code String}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#load(int, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.load(int, String)"})
  public void testLoadWithIntString2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLoadResult =
        compactCodeAttributeComposer.load(66, "Internal Type");

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLoadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#load(int, String)} with {@code int}, {@code String}.
   *
   * <ul>
   *   <li>When {@code ()I}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#load(int, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.load(int, String)"})
  public void testLoadWithIntString_whenI() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualLoadResult = compactCodeAttributeComposer.load(1, "()I");

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualLoadResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#store(int, char)} with {@code int}, {@code char}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#store(int, char)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.store(int, char)"})
  public void testStoreWithIntChar() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualStoreResult = compactCodeAttributeComposer.store(66, 'A');

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualStoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#store(int, char)} with {@code int}, {@code char}.
   *
   * <ul>
   *   <li>When {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#store(int, char)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.store(int, char)"})
  public void testStoreWithIntChar_whenA() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualStoreResult = compactCodeAttributeComposer.store(1, 'A');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualStoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#store(int, char)} with {@code int}, {@code char}.
   *
   * <ul>
   *   <li>When {@code B}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#store(int, char)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.store(int, char)"})
  public void testStoreWithIntChar_whenB() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualStoreResult = compactCodeAttributeComposer.store(1, 'B');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualStoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#store(int, char)} with {@code int}, {@code char}.
   *
   * <ul>
   *   <li>When {@code D}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#store(int, char)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.store(int, char)"})
  public void testStoreWithIntChar_whenD() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualStoreResult = compactCodeAttributeComposer.store(1, 'D');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualStoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#store(int, char)} with {@code int}, {@code char}.
   *
   * <ul>
   *   <li>When {@code F}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#store(int, char)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.store(int, char)"})
  public void testStoreWithIntChar_whenF() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualStoreResult = compactCodeAttributeComposer.store(1, 'F');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualStoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#store(int, char)} with {@code int}, {@code char}.
   *
   * <ul>
   *   <li>When {@code J}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#store(int, char)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CompactCodeAttributeComposer CompactCodeAttributeComposer.store(int, char)"})
  public void testStoreWithIntChar_whenJ() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualStoreResult = compactCodeAttributeComposer.store(1, 'J');

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualStoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#store(int, String)} with {@code int}, {@code String}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#store(int, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.store(int, String)"
  })
  public void testStoreWithIntString() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualStoreResult =
        compactCodeAttributeComposer.store(1, "Internal Type");

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualStoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#store(int, String)} with {@code int}, {@code String}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#store(int, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.store(int, String)"
  })
  public void testStoreWithIntString2() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualStoreResult =
        compactCodeAttributeComposer.store(66, "Internal Type");

    // Assert
    assertEquals(2, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualStoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#store(int, String)} with {@code int}, {@code String}.
   *
   * <ul>
   *   <li>When {@code ()I}.
   * </ul>
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#store(int, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.store(int, String)"
  })
  public void testStoreWithIntString_whenI() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualStoreResult = compactCodeAttributeComposer.store(1, "()I");

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualStoreResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#storeToArray(String)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#storeToArray(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.storeToArray(String)"
  })
  public void testStoreToArray() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(new ProgramClass());

    // Act
    CompactCodeAttributeComposer actualStoreToArrayResult =
        compactCodeAttributeComposer.storeToArray("Element Type");

    // Assert
    assertEquals(1, compactCodeAttributeComposer.getCodeLength());
    assertSame(compactCodeAttributeComposer, actualStoreToArrayResult);
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintIntegerInstructions()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendPrintIntegerInstructions()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.appendPrintIntegerInstructions()"
  })
  public void testAppendPrintIntegerInstructions() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(89, 1, new Constant[] {new ClassConstant()}, 89, 89, 89));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.appendPrintIntegerInstructions());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintIntegerInstructions()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendPrintIntegerInstructions()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.appendPrintIntegerInstructions()"
  })
  public void testAppendPrintIntegerInstructions2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                89,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                89,
                89,
                89));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.appendPrintIntegerInstructions());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintIntegerInstructions(String)} with {@code
   * String}.
   *
   * <p>Method under test: {@link
   * CompactCodeAttributeComposer#appendPrintIntegerInstructions(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.appendPrintIntegerInstructions(String)"
  })
  public void testAppendPrintIntegerInstructionsWithString() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.appendPrintIntegerInstructions("Not all who wander are lost"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintIntegerInstructions(String)} with {@code
   * String}.
   *
   * <p>Method under test: {@link
   * CompactCodeAttributeComposer#appendPrintIntegerInstructions(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.appendPrintIntegerInstructions(String)"
  })
  public void testAppendPrintIntegerInstructionsWithString2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.appendPrintIntegerInstructions("Not all who wander are lost"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintIntegerHexInstructions()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendPrintIntegerHexInstructions()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.appendPrintIntegerHexInstructions()"
  })
  public void testAppendPrintIntegerHexInstructions() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(89, 1, new Constant[] {new ClassConstant()}, 89, 89, 89));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.appendPrintIntegerHexInstructions());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintIntegerHexInstructions()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendPrintIntegerHexInstructions()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.appendPrintIntegerHexInstructions()"
  })
  public void testAppendPrintIntegerHexInstructions2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                89,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                89,
                89,
                89));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.appendPrintIntegerHexInstructions());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintIntegerHexInstructions(String)} with {@code
   * String}.
   *
   * <p>Method under test: {@link
   * CompactCodeAttributeComposer#appendPrintIntegerHexInstructions(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.appendPrintIntegerHexInstructions(String)"
  })
  public void testAppendPrintIntegerHexInstructionsWithString() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.appendPrintIntegerHexInstructions("0123456789ABCDEF"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintIntegerHexInstructions(String)} with {@code
   * String}.
   *
   * <p>Method under test: {@link
   * CompactCodeAttributeComposer#appendPrintIntegerHexInstructions(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.appendPrintIntegerHexInstructions(String)"
  })
  public void testAppendPrintIntegerHexInstructionsWithString2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.appendPrintIntegerHexInstructions("0123456789ABCDEF"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintLongInstructions()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendPrintLongInstructions()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.appendPrintLongInstructions()"
  })
  public void testAppendPrintLongInstructions() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(92, 1, new Constant[] {new ClassConstant()}, 92, 92, 92));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer, compactCodeAttributeComposer.appendPrintLongInstructions());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintLongInstructions()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendPrintLongInstructions()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.appendPrintLongInstructions()"
  })
  public void testAppendPrintLongInstructions2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                92,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                92,
                92,
                92));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer, compactCodeAttributeComposer.appendPrintLongInstructions());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintLongInstructions(String)} with {@code
   * String}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendPrintLongInstructions(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.appendPrintLongInstructions(String)"
  })
  public void testAppendPrintLongInstructionsWithString() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.appendPrintLongInstructions("Not all who wander are lost"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintLongInstructions(String)} with {@code
   * String}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendPrintLongInstructions(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.appendPrintLongInstructions(String)"
  })
  public void testAppendPrintLongInstructionsWithString2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.appendPrintLongInstructions("Not all who wander are lost"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintStringInstructions()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendPrintStringInstructions()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.appendPrintStringInstructions()"
  })
  public void testAppendPrintStringInstructions() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(89, 1, new Constant[] {new ClassConstant()}, 89, 89, 89));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer, compactCodeAttributeComposer.appendPrintStringInstructions());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintStringInstructions()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendPrintStringInstructions()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.appendPrintStringInstructions()"
  })
  public void testAppendPrintStringInstructions2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                89,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                89,
                89,
                89));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer, compactCodeAttributeComposer.appendPrintStringInstructions());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintStringInstructions(String)} with {@code
   * String}.
   *
   * <p>Method under test: {@link
   * CompactCodeAttributeComposer#appendPrintStringInstructions(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.appendPrintStringInstructions(String)"
  })
  public void testAppendPrintStringInstructionsWithString() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.appendPrintStringInstructions("Not all who wander are lost"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintStringInstructions(String)} with {@code
   * String}.
   *
   * <p>Method under test: {@link
   * CompactCodeAttributeComposer#appendPrintStringInstructions(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.appendPrintStringInstructions(String)"
  })
  public void testAppendPrintStringInstructionsWithString2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.appendPrintStringInstructions("Not all who wander are lost"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintObjectInstructions()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendPrintObjectInstructions()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.appendPrintObjectInstructions()"
  })
  public void testAppendPrintObjectInstructions() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(89, 1, new Constant[] {new ClassConstant()}, 89, 89, 89));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer, compactCodeAttributeComposer.appendPrintObjectInstructions());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintObjectInstructions()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendPrintObjectInstructions()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.appendPrintObjectInstructions()"
  })
  public void testAppendPrintObjectInstructions2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                89,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                89,
                89,
                89));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer, compactCodeAttributeComposer.appendPrintObjectInstructions());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintObjectInstructions(String)} with {@code
   * String}.
   *
   * <p>Method under test: {@link
   * CompactCodeAttributeComposer#appendPrintObjectInstructions(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.appendPrintObjectInstructions(String)"
  })
  public void testAppendPrintObjectInstructionsWithString() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.appendPrintObjectInstructions("Not all who wander are lost"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintObjectInstructions(String)} with {@code
   * String}.
   *
   * <p>Method under test: {@link
   * CompactCodeAttributeComposer#appendPrintObjectInstructions(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.appendPrintObjectInstructions(String)"
  })
  public void testAppendPrintObjectInstructionsWithString2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.appendPrintObjectInstructions("Not all who wander are lost"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintStackTraceInstructions()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendPrintStackTraceInstructions()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.appendPrintStackTraceInstructions()"
  })
  public void testAppendPrintStackTraceInstructions() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(89, 1, new Constant[] {new ClassConstant()}, 89, 89, 89));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.appendPrintStackTraceInstructions());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintStackTraceInstructions()}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendPrintStackTraceInstructions()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.appendPrintStackTraceInstructions()"
  })
  public void testAppendPrintStackTraceInstructions2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                89,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                89,
                89,
                89));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.appendPrintStackTraceInstructions());
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintStackTraceInstructions(String)} with {@code
   * String}.
   *
   * <p>Method under test: {@link
   * CompactCodeAttributeComposer#appendPrintStackTraceInstructions(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.appendPrintStackTraceInstructions(String)"
  })
  public void testAppendPrintStackTraceInstructionsWithString() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.appendPrintStackTraceInstructions(
            "Not all who wander are lost"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintStackTraceInstructions(String)} with {@code
   * String}.
   *
   * <p>Method under test: {@link
   * CompactCodeAttributeComposer#appendPrintStackTraceInstructions(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.appendPrintStackTraceInstructions(String)"
  })
  public void testAppendPrintStackTraceInstructionsWithString2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.appendPrintStackTraceInstructions(
            "Not all who wander are lost"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintInstructions(String)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendPrintInstructions(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.appendPrintInstructions(String)"
  })
  public void testAppendPrintInstructions() {
    // Arrange
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.appendPrintInstructions("Not all who wander are lost"));
  }

  /**
   * Test {@link CompactCodeAttributeComposer#appendPrintInstructions(String)}.
   *
   * <p>Method under test: {@link CompactCodeAttributeComposer#appendPrintInstructions(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "CompactCodeAttributeComposer CompactCodeAttributeComposer.appendPrintInstructions(String)"
  })
  public void testAppendPrintInstructions2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    CompactCodeAttributeComposer compactCodeAttributeComposer =
        new CompactCodeAttributeComposer(
            new ProgramClass(
                1,
                3,
                new Constant[] {classConstant, classConstant2, new ClassConstant()},
                1,
                1,
                1));

    // Act and Assert
    assertSame(
        compactCodeAttributeComposer,
        compactCodeAttributeComposer.appendPrintInstructions("Not all who wander are lost"));
  }
}
