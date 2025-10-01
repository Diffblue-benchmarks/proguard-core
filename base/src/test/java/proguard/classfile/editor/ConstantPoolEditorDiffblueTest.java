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
import proguard.classfile.ClassPool;
import proguard.classfile.Clazz;
import proguard.classfile.Field;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Member;
import proguard.classfile.Method;
import proguard.classfile.ProgramClass;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.constant.DoubleConstant;
import proguard.classfile.constant.DynamicConstant;
import proguard.classfile.constant.FieldrefConstant;
import proguard.classfile.constant.InterfaceMethodrefConstant;
import proguard.classfile.constant.InvokeDynamicConstant;
import proguard.classfile.constant.LongConstant;
import proguard.classfile.constant.MethodTypeConstant;
import proguard.classfile.constant.MethodrefConstant;
import proguard.classfile.constant.ModuleConstant;
import proguard.classfile.constant.NameAndTypeConstant;
import proguard.classfile.constant.PackageConstant;
import proguard.classfile.constant.PrimitiveArrayConstant;
import proguard.classfile.constant.Utf8Constant;
import proguard.classfile.kotlin.KotlinConstants;
import proguard.resources.file.ResourceFile;
import proguard.testutils.cpa.NamedClass;

class ConstantPoolEditorDiffblueTest {
  /**
   * Test {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass)}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass)}
   */
  @Test
  @DisplayName("Test new ConstantPoolEditor(ProgramClass)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolEditor.<init>(ProgramClass)"})
  void testNewConstantPoolEditor() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 2, constantPool, 1, 1, 1);

    // Act and Assert
    assertSame(targetClass, new ConstantPoolEditor(targetClass).getTargetClass());
  }

  /**
   * Test {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool, ClassPool)}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool,
   * ClassPool)}
   */
  @Test
  @DisplayName("Test new ConstantPoolEditor(ProgramClass, ClassPool, ClassPool)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolEditor.<init>(ProgramClass, ClassPool, ClassPool)"})
  void testNewConstantPoolEditor2() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 1, constantPool, 1, 1, 1);

    // Act
    ConstantPoolEditor actualConstantPoolEditor =
        new ConstantPoolEditor(targetClass, null, KotlinConstants.dummyClassPool);

    // Assert
    assertSame(targetClass, actualConstantPoolEditor.getTargetClass());
  }

  /**
   * Test {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool, ClassPool)}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool,
   * ClassPool)}
   */
  @Test
  @DisplayName("Test new ConstantPoolEditor(ProgramClass, ClassPool, ClassPool)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolEditor.<init>(ProgramClass, ClassPool, ClassPool)"})
  void testNewConstantPoolEditor3() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 2, constantPool, 1, 1, 1);

    // Act
    ConstantPoolEditor actualConstantPoolEditor =
        new ConstantPoolEditor(targetClass, null, KotlinConstants.dummyClassPool);

    // Assert
    assertSame(targetClass, actualConstantPoolEditor.getTargetClass());
  }

  /**
   * Test {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool, ClassPool,
   * boolean)}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool,
   * ClassPool, boolean)}
   */
  @Test
  @DisplayName("Test new ConstantPoolEditor(ProgramClass, ClassPool, ClassPool, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolEditor.<init>(ProgramClass, ClassPool, ClassPool, boolean)"})
  void testNewConstantPoolEditor4() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 1, 1, 1);

    // Act
    ConstantPoolEditor actualConstantPoolEditor =
        new ConstantPoolEditor(
            targetClass, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool, true);

    // Assert
    assertSame(targetClass, actualConstantPoolEditor.getTargetClass());
  }

  /**
   * Test {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool, ClassPool,
   * boolean)}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool,
   * ClassPool, boolean)}
   */
  @Test
  @DisplayName("Test new ConstantPoolEditor(ProgramClass, ClassPool, ClassPool, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolEditor.<init>(ProgramClass, ClassPool, ClassPool, boolean)"})
  void testNewConstantPoolEditor5() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(1, 3, new Constant[] {classConstant, null, new ClassConstant()}, 1, 1, 1);

    // Act
    ConstantPoolEditor actualConstantPoolEditor =
        new ConstantPoolEditor(
            targetClass, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool, true);

    // Assert
    assertSame(targetClass, actualConstantPoolEditor.getTargetClass());
  }

  /**
   * Test {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool, ClassPool,
   * boolean)}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool,
   * ClassPool, boolean)}
   */
  @Test
  @DisplayName("Test new ConstantPoolEditor(ProgramClass, ClassPool, ClassPool, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolEditor.<init>(ProgramClass, ClassPool, ClassPool, boolean)"})
  void testNewConstantPoolEditor6() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    DoubleConstant doubleConstant = new DoubleConstant();
    ProgramClass targetClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, doubleConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    ConstantPoolEditor actualConstantPoolEditor =
        new ConstantPoolEditor(
            targetClass, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool, true);

    // Assert
    assertSame(targetClass, actualConstantPoolEditor.getTargetClass());
  }

  /**
   * Test {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool, ClassPool,
   * boolean)}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool,
   * ClassPool, boolean)}
   */
  @Test
  @DisplayName("Test new ConstantPoolEditor(ProgramClass, ClassPool, ClassPool, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolEditor.<init>(ProgramClass, ClassPool, ClassPool, boolean)"})
  void testNewConstantPoolEditor7() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    DynamicConstant dynamicConstant = new DynamicConstant();
    ProgramClass targetClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, dynamicConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    ConstantPoolEditor actualConstantPoolEditor =
        new ConstantPoolEditor(
            targetClass, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool, true);

    // Assert
    assertSame(targetClass, actualConstantPoolEditor.getTargetClass());
  }

  /**
   * Test {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool, ClassPool,
   * boolean)}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool,
   * ClassPool, boolean)}
   */
  @Test
  @DisplayName("Test new ConstantPoolEditor(ProgramClass, ClassPool, ClassPool, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolEditor.<init>(ProgramClass, ClassPool, ClassPool, boolean)"})
  void testNewConstantPoolEditor8() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    DynamicConstant dynamicConstant = new DynamicConstant();
    ProgramClass targetClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, dynamicConstant, new DynamicConstant()}, 1, 1, 1);

    // Act
    ConstantPoolEditor actualConstantPoolEditor =
        new ConstantPoolEditor(
            targetClass, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool, true);

    // Assert
    assertSame(targetClass, actualConstantPoolEditor.getTargetClass());
  }

  /**
   * Test {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool, ClassPool,
   * boolean)}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool,
   * ClassPool, boolean)}
   */
  @Test
  @DisplayName("Test new ConstantPoolEditor(ProgramClass, ClassPool, ClassPool, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolEditor.<init>(ProgramClass, ClassPool, ClassPool, boolean)"})
  void testNewConstantPoolEditor9() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(
            1, 2, new Constant[] {classConstant, new InvokeDynamicConstant()}, 1, 1, 1);

    // Act
    ConstantPoolEditor actualConstantPoolEditor =
        new ConstantPoolEditor(
            targetClass, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool, true);

    // Assert
    assertSame(targetClass, actualConstantPoolEditor.getTargetClass());
  }

  /**
   * Test {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool, ClassPool,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return TargetClass is {@link ProgramClass#ProgramClass()}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool,
   * ClassPool, boolean)}
   */
  @Test
  @DisplayName(
      "Test new ConstantPoolEditor(ProgramClass, ClassPool, ClassPool, boolean); when 'false'; then return TargetClass is ProgramClass()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolEditor.<init>(ProgramClass, ClassPool, ClassPool, boolean)"})
  void testNewConstantPoolEditor_whenFalse_thenReturnTargetClassIsProgramClass() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act
    ConstantPoolEditor actualConstantPoolEditor =
        new ConstantPoolEditor(targetClass, null, KotlinConstants.dummyClassPool, false);

    // Assert
    assertSame(targetClass, actualConstantPoolEditor.getTargetClass());
  }

  /**
   * Test {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass)}.
   *
   * <ul>
   *   <li>When {@link ProgramClass#ProgramClass()}.
   *   <li>Then return TargetClass is {@link ProgramClass#ProgramClass()}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass)}
   */
  @Test
  @DisplayName(
      "Test new ConstantPoolEditor(ProgramClass); when ProgramClass(); then return TargetClass is ProgramClass()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolEditor.<init>(ProgramClass)"})
  void testNewConstantPoolEditor_whenProgramClass_thenReturnTargetClassIsProgramClass() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act and Assert
    assertSame(targetClass, new ConstantPoolEditor(targetClass).getTargetClass());
  }

  /**
   * Test {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool, ClassPool)}.
   *
   * <ul>
   *   <li>When {@link ProgramClass#ProgramClass()}.
   *   <li>Then return TargetClass is {@link ProgramClass#ProgramClass()}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool,
   * ClassPool)}
   */
  @Test
  @DisplayName(
      "Test new ConstantPoolEditor(ProgramClass, ClassPool, ClassPool); when ProgramClass(); then return TargetClass is ProgramClass()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolEditor.<init>(ProgramClass, ClassPool, ClassPool)"})
  void testNewConstantPoolEditor_whenProgramClass_thenReturnTargetClassIsProgramClass2() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act
    ConstantPoolEditor actualConstantPoolEditor =
        new ConstantPoolEditor(
            targetClass, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool);

    // Assert
    assertSame(targetClass, actualConstantPoolEditor.getTargetClass());
  }

  /**
   * Test {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool, ClassPool,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@link ProgramClass#ProgramClass()}.
   *   <li>Then return TargetClass is {@link ProgramClass#ProgramClass()}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool,
   * ClassPool, boolean)}
   */
  @Test
  @DisplayName(
      "Test new ConstantPoolEditor(ProgramClass, ClassPool, ClassPool, boolean); when ProgramClass(); then return TargetClass is ProgramClass()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolEditor.<init>(ProgramClass, ClassPool, ClassPool, boolean)"})
  void testNewConstantPoolEditor_whenProgramClass_thenReturnTargetClassIsProgramClass3() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act
    ConstantPoolEditor actualConstantPoolEditor =
        new ConstantPoolEditor(
            targetClass, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool, true);

    // Assert
    assertSame(targetClass, actualConstantPoolEditor.getTargetClass());
  }

  /**
   * Test {@link ConstantPoolEditor#getTargetClass()}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#getTargetClass()}
   */
  @Test
  @DisplayName("Test getTargetClass()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ProgramClass ConstantPoolEditor.getTargetClass()"})
  void testGetTargetClass() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act and Assert
    assertSame(targetClass, new ConstantPoolEditor(targetClass).getTargetClass());
  }

  /**
   * Test {@link ConstantPoolEditor#addIntegerConstant(int)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addIntegerConstant(int)}
   */
  @Test
  @DisplayName("Test addIntegerConstant(int); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addIntegerConstant(int)"})
  void testAddIntegerConstant_thenReturnOne() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(3, 1, constantPool, 3, 3, 3);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(1, constantPoolEditor.addIntegerConstant(42));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(2, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addIntegerConstant(int)}.
   *
   * <ul>
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addIntegerConstant(int)}
   */
  @Test
  @DisplayName("Test addIntegerConstant(int); then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addIntegerConstant(int)"})
  void testAddIntegerConstant_thenReturnThree() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(
            3, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 3, 3, 3);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(3, constantPoolEditor.addIntegerConstant(42));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(4, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addIntegerConstant(int)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addIntegerConstant(int)}
   */
  @Test
  @DisplayName("Test addIntegerConstant(int); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addIntegerConstant(int)"})
  void testAddIntegerConstant_thenReturnZero() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(3, 0, constantPool, 3, 3, 3);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(0, constantPoolEditor.addIntegerConstant(42));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(1, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addLongConstant(long)}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addLongConstant(long)}
   */
  @Test
  @DisplayName("Test addLongConstant(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addLongConstant(long)"})
  void testAddLongConstant() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(5, 1, constantPool, 5, 5, 5);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act
    constantPoolEditor.addLongConstant(42L);

    // Assert
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(3, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addLongConstant(long)}.
   *
   * <ul>
   *   <li>Then fifth element {@link LongConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addLongConstant(long)}
   */
  @Test
  @DisplayName("Test addLongConstant(long); then fifth element LongConstant")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addLongConstant(long)"})
  void testAddLongConstant_thenFifthElementLongConstant() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};

    ConstantPoolEditor constantPoolEditor =
        new ConstantPoolEditor(new ProgramClass(5, 3, constantPool, 5, 5, 5));
    constantPoolEditor.addConstant(new ClassConstant());

    // Act
    int actualAddLongConstantResult = constantPoolEditor.addLongConstant(42L);

    // Assert
    ProgramClass targetClass = constantPoolEditor.getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    Constant constant = constantArray[4];
    assertTrue(constant instanceof LongConstant);
    assertNull(constant.getProcessingInfo());
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(19, constantArray.length);
    assertEquals(4, actualAddLongConstantResult);
    assertEquals(42L, ((LongConstant) constant).getValue());
    assertEquals(5, constant.getTag());
    assertEquals(6, targetClass.u2constantPoolCount);
    assertTrue(constant.isCategory2());
  }

  /**
   * Test {@link ConstantPoolEditor#addLongConstant(long)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addLongConstant(long)}
   */
  @Test
  @DisplayName("Test addLongConstant(long); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addLongConstant(long)"})
  void testAddLongConstant_thenReturnOne() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(5, 1, constantPool, 5, 5, 5);

    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    constantPoolEditor.addLongConstant(42L);

    // Act and Assert
    assertEquals(1, constantPoolEditor.addLongConstant(42L));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(3, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addLongConstant(long)}.
   *
   * <ul>
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addLongConstant(long)}
   */
  @Test
  @DisplayName("Test addLongConstant(long); then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addLongConstant(long)"})
  void testAddLongConstant_thenReturnThree() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(
            5, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 5, 5, 5);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(3, constantPoolEditor.addLongConstant(42L));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(5, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addLongConstant(long)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addLongConstant(long)}
   */
  @Test
  @DisplayName("Test addLongConstant(long); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addLongConstant(long)"})
  void testAddLongConstant_thenReturnZero() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(5, 0, constantPool, 5, 5, 5);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(0, constantPoolEditor.addLongConstant(42L));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(2, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addFloatConstant(float)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addFloatConstant(float)}
   */
  @Test
  @DisplayName("Test addFloatConstant(float); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addFloatConstant(float)"})
  void testAddFloatConstant_thenReturnOne() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(4, 1, constantPool, 4, 4, 4);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(1, constantPoolEditor.addFloatConstant(10.0f));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(2, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addFloatConstant(float)}.
   *
   * <ul>
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addFloatConstant(float)}
   */
  @Test
  @DisplayName("Test addFloatConstant(float); then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addFloatConstant(float)"})
  void testAddFloatConstant_thenReturnThree() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(
            4, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 4, 4, 4);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(3, constantPoolEditor.addFloatConstant(10.0f));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(4, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addFloatConstant(float)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addFloatConstant(float)}
   */
  @Test
  @DisplayName("Test addFloatConstant(float); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addFloatConstant(float)"})
  void testAddFloatConstant_thenReturnZero() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(4, 0, constantPool, 4, 4, 4);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(0, constantPoolEditor.addFloatConstant(10.0f));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(1, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addDoubleConstant(double)}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addDoubleConstant(double)}
   */
  @Test
  @DisplayName("Test addDoubleConstant(double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addDoubleConstant(double)"})
  void testAddDoubleConstant() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(6, 1, constantPool, 6, 6, 6);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act
    constantPoolEditor.addDoubleConstant(10.0d);

    // Assert
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(3, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addDoubleConstant(double)}.
   *
   * <ul>
   *   <li>Then fifth element {@link DoubleConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addDoubleConstant(double)}
   */
  @Test
  @DisplayName("Test addDoubleConstant(double); then fifth element DoubleConstant")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addDoubleConstant(double)"})
  void testAddDoubleConstant_thenFifthElementDoubleConstant() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};

    ConstantPoolEditor constantPoolEditor =
        new ConstantPoolEditor(new ProgramClass(6, 3, constantPool, 6, 6, 6));
    constantPoolEditor.addConstant(new ClassConstant());

    // Act
    int actualAddDoubleConstantResult = constantPoolEditor.addDoubleConstant(10.0d);

    // Assert
    ProgramClass targetClass = constantPoolEditor.getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    Constant constant = constantArray[4];
    assertTrue(constant instanceof DoubleConstant);
    assertNull(constant.getProcessingInfo());
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(10.0d, ((DoubleConstant) constant).getValue());
    assertEquals(19, constantArray.length);
    assertEquals(4, actualAddDoubleConstantResult);
    assertEquals(6, constant.getTag());
    assertEquals(6, targetClass.u2constantPoolCount);
    assertTrue(constant.isCategory2());
  }

  /**
   * Test {@link ConstantPoolEditor#addDoubleConstant(double)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addDoubleConstant(double)}
   */
  @Test
  @DisplayName("Test addDoubleConstant(double); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addDoubleConstant(double)"})
  void testAddDoubleConstant_thenReturnOne() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(6, 1, constantPool, 6, 6, 6);

    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    constantPoolEditor.addDoubleConstant(10.0d);

    // Act and Assert
    assertEquals(1, constantPoolEditor.addDoubleConstant(10.0d));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(3, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addDoubleConstant(double)}.
   *
   * <ul>
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addDoubleConstant(double)}
   */
  @Test
  @DisplayName("Test addDoubleConstant(double); then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addDoubleConstant(double)"})
  void testAddDoubleConstant_thenReturnThree() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(
            6, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 6, 6, 6);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(3, constantPoolEditor.addDoubleConstant(10.0d));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(5, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addDoubleConstant(double)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addDoubleConstant(double)}
   */
  @Test
  @DisplayName("Test addDoubleConstant(double); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addDoubleConstant(double)"})
  void testAddDoubleConstant_thenReturnZero() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(6, 0, constantPool, 6, 6, 6);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(0, constantPoolEditor.addDoubleConstant(10.0d));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(2, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addPrimitiveArrayConstant(Object)}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addPrimitiveArrayConstant(Object)}
   */
  @Test
  @DisplayName("Test addPrimitiveArrayConstant(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addPrimitiveArrayConstant(Object)"})
  void testAddPrimitiveArrayConstant() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(99, 1, constantPool, 99, 99, 99);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act
    constantPoolEditor.addPrimitiveArrayConstant("Values");

    // Assert
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(2, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addPrimitiveArrayConstant(Object)}.
   *
   * <ul>
   *   <li>Then first element {@link PrimitiveArrayConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addPrimitiveArrayConstant(Object)}
   */
  @Test
  @DisplayName("Test addPrimitiveArrayConstant(Object); then first element PrimitiveArrayConstant")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addPrimitiveArrayConstant(Object)"})
  void testAddPrimitiveArrayConstant_thenFirstElementPrimitiveArrayConstant() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ConstantPoolEditor constantPoolEditor =
        new ConstantPoolEditor(new ProgramClass(99, 0, constantPool, 99, 99, 99));

    // Act
    int actualAddPrimitiveArrayConstantResult =
        constantPoolEditor.addPrimitiveArrayConstant("Values");

    // Assert
    ProgramClass targetClass = constantPoolEditor.getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    Constant constant = constantArray[0];
    assertTrue(constant instanceof PrimitiveArrayConstant);
    assertEquals("Values", ((PrimitiveArrayConstant) constant).getValues());
    assertEquals('\u0000', ((PrimitiveArrayConstant) constant).getPrimitiveType());
    assertEquals(0, ((PrimitiveArrayConstant) constant).getLength());
    assertEquals(0, actualAddPrimitiveArrayConstantResult);
    assertEquals(1, constantArray.length);
    assertEquals(1, targetClass.u2constantPoolCount);
    assertEquals(99, constant.getTag());
    assertFalse(constant.isCategory2());
  }

  /**
   * Test {@link ConstantPoolEditor#addPrimitiveArrayConstant(Object)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addPrimitiveArrayConstant(Object)}
   */
  @Test
  @DisplayName("Test addPrimitiveArrayConstant(Object); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addPrimitiveArrayConstant(Object)"})
  void testAddPrimitiveArrayConstant_thenReturnOne() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(99, 1, constantPool, 99, 99, 99);

    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    constantPoolEditor.addPrimitiveArrayConstant("Values");

    // Act and Assert
    assertEquals(1, constantPoolEditor.addPrimitiveArrayConstant("Values"));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(2, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addPrimitiveArrayConstant(Object)}.
   *
   * <ul>
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addPrimitiveArrayConstant(Object)}
   */
  @Test
  @DisplayName("Test addPrimitiveArrayConstant(Object); then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addPrimitiveArrayConstant(Object)"})
  void testAddPrimitiveArrayConstant_thenReturnThree() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(
            99, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 99, 99, 99);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(3, constantPoolEditor.addPrimitiveArrayConstant("Values"));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(4, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addStringConstant(String, Clazz, Member, int, ResourceFile)}
   * with {@code string}, {@code referencedClass}, {@code referencedMember}, {@code resourceFileId},
   * {@code resourceFile}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addStringConstant(String, Clazz, Member, int,
   * ResourceFile)}
   */
  @Test
  @DisplayName(
      "Test addStringConstant(String, Clazz, Member, int, ResourceFile) with 'string', 'referencedClass', 'referencedMember', 'resourceFileId', 'resourceFile'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addStringConstant(String, Clazz, Member, int, ResourceFile)"
  })
  void testAddStringConstantWithStringReferencedClassReferencedMemberResourceFileIdResourceFile() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 1, constantPool, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();
    LibraryField referencedMember = new LibraryField(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(
        2,
        constantPoolEditor.addStringConstant(
            "String", referencedClass, referencedMember, 1, new ResourceFile("foo.txt", 3L)));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(3, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addStringConstant(String, Clazz, Member, int, ResourceFile)}
   * with {@code string}, {@code referencedClass}, {@code referencedMember}, {@code resourceFileId},
   * {@code resourceFile}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addStringConstant(String, Clazz, Member, int,
   * ResourceFile)}
   */
  @Test
  @DisplayName(
      "Test addStringConstant(String, Clazz, Member, int, ResourceFile) with 'string', 'referencedClass', 'referencedMember', 'resourceFileId', 'resourceFile'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addStringConstant(String, Clazz, Member, int, ResourceFile)"
  })
  void testAddStringConstantWithStringReferencedClassReferencedMemberResourceFileIdResourceFile2() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 0, constantPool, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();
    LibraryField referencedMember = new LibraryField(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(
        1,
        constantPoolEditor.addStringConstant(
            "String", referencedClass, referencedMember, 1, new ResourceFile("foo.txt", 3L)));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(2, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addStringConstant(String, Clazz, Member, int, ResourceFile)}
   * with {@code string}, {@code referencedClass}, {@code referencedMember}, {@code resourceFileId},
   * {@code resourceFile}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addStringConstant(String, Clazz, Member, int,
   * ResourceFile)}
   */
  @Test
  @DisplayName(
      "Test addStringConstant(String, Clazz, Member, int, ResourceFile) with 'string', 'referencedClass', 'referencedMember', 'resourceFileId', 'resourceFile'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addStringConstant(String, Clazz, Member, int, ResourceFile)"
  })
  void testAddStringConstantWithStringReferencedClassReferencedMemberResourceFileIdResourceFile3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();
    LibraryField referencedMember = new LibraryField(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(
        4,
        constantPoolEditor.addStringConstant(
            "String", referencedClass, referencedMember, 1, new ResourceFile("foo.txt", 3L)));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(5, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addStringConstant(String, Clazz, Member)} with {@code string},
   * {@code referencedClass}, {@code referencedMember}.
   *
   * <ul>
   *   <li>Then return four.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addStringConstant(String, Clazz, Member)}
   */
  @Test
  @DisplayName(
      "Test addStringConstant(String, Clazz, Member) with 'string', 'referencedClass', 'referencedMember'; then return four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addStringConstant(String, Clazz, Member)"})
  void testAddStringConstantWithStringReferencedClassReferencedMember_thenReturnFour() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();
    LibraryField referencedMember = new LibraryField(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(
        4, constantPoolEditor.addStringConstant("String", referencedClass, referencedMember));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(5, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addStringConstant(String, Clazz, Member)} with {@code string},
   * {@code referencedClass}, {@code referencedMember}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addStringConstant(String, Clazz, Member)}
   */
  @Test
  @DisplayName(
      "Test addStringConstant(String, Clazz, Member) with 'string', 'referencedClass', 'referencedMember'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addStringConstant(String, Clazz, Member)"})
  void testAddStringConstantWithStringReferencedClassReferencedMember_thenReturnOne() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 0, constantPool, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();
    LibraryField referencedMember = new LibraryField(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(
        1, constantPoolEditor.addStringConstant("String", referencedClass, referencedMember));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(2, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addStringConstant(String, Clazz, Member)} with {@code string},
   * {@code referencedClass}, {@code referencedMember}.
   *
   * <ul>
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addStringConstant(String, Clazz, Member)}
   */
  @Test
  @DisplayName(
      "Test addStringConstant(String, Clazz, Member) with 'string', 'referencedClass', 'referencedMember'; then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addStringConstant(String, Clazz, Member)"})
  void testAddStringConstantWithStringReferencedClassReferencedMember_thenReturnTwo() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 1, constantPool, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();
    LibraryField referencedMember = new LibraryField(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(
        2, constantPoolEditor.addStringConstant("String", referencedClass, referencedMember));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(3, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addStringConstant(String, ResourceFile)} with {@code string},
   * {@code referencedResourceFile}.
   *
   * <ul>
   *   <li>Then return four.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addStringConstant(String, ResourceFile)}
   */
  @Test
  @DisplayName(
      "Test addStringConstant(String, ResourceFile) with 'string', 'referencedResourceFile'; then return four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addStringConstant(String, ResourceFile)"})
  void testAddStringConstantWithStringReferencedResourceFile_thenReturnFour() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(
        4, constantPoolEditor.addStringConstant("String", new ResourceFile("foo.txt", 3L)));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(5, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addStringConstant(String, ResourceFile)} with {@code string},
   * {@code referencedResourceFile}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addStringConstant(String, ResourceFile)}
   */
  @Test
  @DisplayName(
      "Test addStringConstant(String, ResourceFile) with 'string', 'referencedResourceFile'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addStringConstant(String, ResourceFile)"})
  void testAddStringConstantWithStringReferencedResourceFile_thenReturnOne() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 0, constantPool, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(
        1, constantPoolEditor.addStringConstant("String", new ResourceFile("foo.txt", 3L)));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(2, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addStringConstant(String, ResourceFile)} with {@code string},
   * {@code referencedResourceFile}.
   *
   * <ul>
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addStringConstant(String, ResourceFile)}
   */
  @Test
  @DisplayName(
      "Test addStringConstant(String, ResourceFile) with 'string', 'referencedResourceFile'; then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addStringConstant(String, ResourceFile)"})
  void testAddStringConstantWithStringReferencedResourceFile_thenReturnTwo() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 1, constantPool, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(
        2, constantPoolEditor.addStringConstant("String", new ResourceFile("foo.txt", 3L)));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(3, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addStringConstant(String)} with {@code string}.
   *
   * <ul>
   *   <li>Then return four.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addStringConstant(String)}
   */
  @Test
  @DisplayName("Test addStringConstant(String) with 'string'; then return four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addStringConstant(String)"})
  void testAddStringConstantWithString_thenReturnFour() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(4, constantPoolEditor.addStringConstant("String"));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(5, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addStringConstant(String)} with {@code string}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addStringConstant(String)}
   */
  @Test
  @DisplayName("Test addStringConstant(String) with 'string'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addStringConstant(String)"})
  void testAddStringConstantWithString_thenReturnOne() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 0, constantPool, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(1, constantPoolEditor.addStringConstant("String"));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(2, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addStringConstant(String)} with {@code string}.
   *
   * <ul>
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addStringConstant(String)}
   */
  @Test
  @DisplayName("Test addStringConstant(String) with 'string'; then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addStringConstant(String)"})
  void testAddStringConstantWithString_thenReturnTwo() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 1, constantPool, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(2, constantPoolEditor.addStringConstant("String"));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(3, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addStringConstant(int, Clazz, Member, int, ResourceFile)} with
   * {@code utf8index}, {@code referencedClass}, {@code referencedMember}, {@code resourceFileId},
   * {@code resourceFile}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addStringConstant(int, Clazz, Member, int,
   * ResourceFile)}
   */
  @Test
  @DisplayName(
      "Test addStringConstant(int, Clazz, Member, int, ResourceFile) with 'utf8index', 'referencedClass', 'referencedMember', 'resourceFileId', 'resourceFile'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addStringConstant(int, Clazz, Member, int, ResourceFile)"
  })
  void
      testAddStringConstantWithUtf8indexReferencedClassReferencedMemberResourceFileIdResourceFile() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(8, 1, constantPool, 8, 8, 8);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();
    LibraryField referencedMember = new LibraryField(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(
        1,
        constantPoolEditor.addStringConstant(
            1, referencedClass, referencedMember, 1, new ResourceFile("foo.txt", 3L)));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(2, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addStringConstant(int, Clazz, Member, int, ResourceFile)} with
   * {@code utf8index}, {@code referencedClass}, {@code referencedMember}, {@code resourceFileId},
   * {@code resourceFile}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addStringConstant(int, Clazz, Member, int,
   * ResourceFile)}
   */
  @Test
  @DisplayName(
      "Test addStringConstant(int, Clazz, Member, int, ResourceFile) with 'utf8index', 'referencedClass', 'referencedMember', 'resourceFileId', 'resourceFile'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addStringConstant(int, Clazz, Member, int, ResourceFile)"
  })
  void
      testAddStringConstantWithUtf8indexReferencedClassReferencedMemberResourceFileIdResourceFile2() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(8, 0, constantPool, 8, 8, 8);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();
    LibraryField referencedMember = new LibraryField(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(
        0,
        constantPoolEditor.addStringConstant(
            1, referencedClass, referencedMember, 1, new ResourceFile("foo.txt", 3L)));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(1, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addStringConstant(int, Clazz, Member, int, ResourceFile)} with
   * {@code utf8index}, {@code referencedClass}, {@code referencedMember}, {@code resourceFileId},
   * {@code resourceFile}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addStringConstant(int, Clazz, Member, int,
   * ResourceFile)}
   */
  @Test
  @DisplayName(
      "Test addStringConstant(int, Clazz, Member, int, ResourceFile) with 'utf8index', 'referencedClass', 'referencedMember', 'resourceFileId', 'resourceFile'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addStringConstant(int, Clazz, Member, int, ResourceFile)"
  })
  void
      testAddStringConstantWithUtf8indexReferencedClassReferencedMemberResourceFileIdResourceFile3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(
            8, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 8, 8, 8);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();
    LibraryField referencedMember = new LibraryField(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(
        3,
        constantPoolEditor.addStringConstant(
            1, referencedClass, referencedMember, 1, new ResourceFile("foo.txt", 3L)));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(4, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addInvokeDynamicConstant(int, int, Clazz[])} with {@code
   * bootstrapMethodIndex}, {@code nameAndTypeIndex}, {@code referencedClasses}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addInvokeDynamicConstant(int, int, Clazz[])}
   */
  @Test
  @DisplayName(
      "Test addInvokeDynamicConstant(int, int, Clazz[]) with 'bootstrapMethodIndex', 'nameAndTypeIndex', 'referencedClasses'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addInvokeDynamicConstant(int, int, Clazz[])"})
  void testAddInvokeDynamicConstantWithBootstrapMethodIndexNameAndTypeIndexReferencedClasses() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(18, 1, constantPool, 18, 18, 18);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act
    constantPoolEditor.addInvokeDynamicConstant(1, 1, new Clazz[] {new LibraryClass()});

    // Assert
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(2, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addInvokeDynamicConstant(int, int, Clazz[])} with {@code
   * bootstrapMethodIndex}, {@code nameAndTypeIndex}, {@code referencedClasses}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addInvokeDynamicConstant(int, int, Clazz[])}
   */
  @Test
  @DisplayName(
      "Test addInvokeDynamicConstant(int, int, Clazz[]) with 'bootstrapMethodIndex', 'nameAndTypeIndex', 'referencedClasses'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addInvokeDynamicConstant(int, int, Clazz[])"})
  void testAddInvokeDynamicConstantWithBootstrapMethodIndexNameAndTypeIndexReferencedClasses2() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ConstantPoolEditor constantPoolEditor =
        new ConstantPoolEditor(new ProgramClass(18, 0, constantPool, 18, 18, 18));
    Clazz[] referencedClasses = new Clazz[] {new LibraryClass()};

    // Act
    int actualAddInvokeDynamicConstantResult =
        constantPoolEditor.addInvokeDynamicConstant(1, 1, referencedClasses);

    // Assert
    ProgramClass targetClass = constantPoolEditor.getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    Constant constant = constantArray[0];
    assertTrue(constant instanceof InvokeDynamicConstant);
    assertEquals(0, actualAddInvokeDynamicConstantResult);
    assertEquals(1, ((InvokeDynamicConstant) constant).getBootstrapMethodAttributeIndex());
    assertEquals(1, ((InvokeDynamicConstant) constant).getNameAndTypeIndex());
    assertEquals(1, constantArray.length);
    assertEquals(1, targetClass.u2constantPoolCount);
    assertEquals(18, constant.getTag());
    assertFalse(constant.isCategory2());
    assertSame(referencedClasses, ((InvokeDynamicConstant) constant).referencedClasses);
  }

  /**
   * Test {@link ConstantPoolEditor#addInvokeDynamicConstant(int, int, Clazz[])} with {@code
   * bootstrapMethodIndex}, {@code nameAndTypeIndex}, {@code referencedClasses}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addInvokeDynamicConstant(int, int, Clazz[])}
   */
  @Test
  @DisplayName(
      "Test addInvokeDynamicConstant(int, int, Clazz[]) with 'bootstrapMethodIndex', 'nameAndTypeIndex', 'referencedClasses'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addInvokeDynamicConstant(int, int, Clazz[])"})
  void testAddInvokeDynamicConstantWithBootstrapMethodIndexNameAndTypeIndexReferencedClasses3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(
            18, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 18, 18, 18);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(
        3, constantPoolEditor.addInvokeDynamicConstant(1, 1, new Clazz[] {new LibraryClass()}));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(4, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addInvokeDynamicConstant(int, int, Clazz[])} with {@code
   * bootstrapMethodIndex}, {@code nameAndTypeIndex}, {@code referencedClasses}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addInvokeDynamicConstant(int, int, Clazz[])}
   */
  @Test
  @DisplayName(
      "Test addInvokeDynamicConstant(int, int, Clazz[]) with 'bootstrapMethodIndex', 'nameAndTypeIndex', 'referencedClasses'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addInvokeDynamicConstant(int, int, Clazz[])"})
  void testAddInvokeDynamicConstantWithBootstrapMethodIndexNameAndTypeIndexReferencedClasses4() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};

    ConstantPoolEditor constantPoolEditor =
        new ConstantPoolEditor(new ProgramClass(18, 3, constantPool, 18, 18, 18));
    constantPoolEditor.addConstant(new ClassConstant());
    Clazz[] referencedClasses = new Clazz[] {new LibraryClass()};

    // Act
    int actualAddInvokeDynamicConstantResult =
        constantPoolEditor.addInvokeDynamicConstant(1, 1, referencedClasses);

    // Assert
    ProgramClass targetClass = constantPoolEditor.getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    Constant constant = constantArray[4];
    assertTrue(constant instanceof InvokeDynamicConstant);
    assertNull(constant.getProcessingInfo());
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(1, ((InvokeDynamicConstant) constant).getBootstrapMethodAttributeIndex());
    assertEquals(1, ((InvokeDynamicConstant) constant).getNameAndTypeIndex());
    assertEquals(18, constant.getTag());
    assertEquals(19, constantArray.length);
    assertEquals(4, actualAddInvokeDynamicConstantResult);
    assertEquals(5, targetClass.u2constantPoolCount);
    assertFalse(constant.isCategory2());
    assertSame(referencedClasses, ((InvokeDynamicConstant) constant).referencedClasses);
  }

  /**
   * Test {@link ConstantPoolEditor#addInvokeDynamicConstant(int, int, Clazz[])} with {@code
   * bootstrapMethodIndex}, {@code nameAndTypeIndex}, {@code referencedClasses}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addInvokeDynamicConstant(int, int, Clazz[])}
   */
  @Test
  @DisplayName(
      "Test addInvokeDynamicConstant(int, int, Clazz[]) with 'bootstrapMethodIndex', 'nameAndTypeIndex', 'referencedClasses'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addInvokeDynamicConstant(int, int, Clazz[])"})
  void testAddInvokeDynamicConstantWithBootstrapMethodIndexNameAndTypeIndexReferencedClasses5() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};

    ConstantPoolEditor constantPoolEditor =
        new ConstantPoolEditor(new ProgramClass(18, 1, constantPool, 18, 18, 18));
    constantPoolEditor.addInvokeDynamicConstant(1, 1, new Clazz[] {new LibraryClass()});

    // Act
    int actualAddInvokeDynamicConstantResult =
        constantPoolEditor.addInvokeDynamicConstant(1, 1, new Clazz[] {new LibraryClass()});

    // Assert
    ProgramClass targetClass = constantPoolEditor.getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[1] instanceof InvokeDynamicConstant);
    assertNull(constantArray[3]);
    assertEquals(1, actualAddInvokeDynamicConstantResult);
    assertEquals(17, constantArray.length);
    assertEquals(2, targetClass.u2constantPoolCount);
  }

  /**
   * Test {@link ConstantPoolEditor#addInvokeDynamicConstant(int, String, String, Clazz[])} with
   * {@code bootstrapMethodIndex}, {@code name}, {@code descriptor}, {@code referencedClasses}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addInvokeDynamicConstant(int, String, String,
   * Clazz[])}
   */
  @Test
  @DisplayName(
      "Test addInvokeDynamicConstant(int, String, String, Clazz[]) with 'bootstrapMethodIndex', 'name', 'descriptor', 'referencedClasses'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addInvokeDynamicConstant(int, String, String, Clazz[])"
  })
  void testAddInvokeDynamicConstantWithBootstrapMethodIndexNameDescriptorReferencedClasses() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 1, constantPool, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act
    constantPoolEditor.addInvokeDynamicConstant(
        1, "Name", "Descriptor", new Clazz[] {new LibraryClass()});

    // Assert
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(5, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addInvokeDynamicConstant(int, String, String, Clazz[])} with
   * {@code bootstrapMethodIndex}, {@code name}, {@code descriptor}, {@code referencedClasses}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addInvokeDynamicConstant(int, String, String,
   * Clazz[])}
   */
  @Test
  @DisplayName(
      "Test addInvokeDynamicConstant(int, String, String, Clazz[]) with 'bootstrapMethodIndex', 'name', 'descriptor', 'referencedClasses'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addInvokeDynamicConstant(int, String, String, Clazz[])"
  })
  void testAddInvokeDynamicConstantWithBootstrapMethodIndexNameDescriptorReferencedClasses2() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 0, constantPool, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(
        3,
        constantPoolEditor.addInvokeDynamicConstant(
            1, "Name", "Descriptor", new Clazz[] {new LibraryClass()}));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(4, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addInvokeDynamicConstant(int, String, String, Clazz[])} with
   * {@code bootstrapMethodIndex}, {@code name}, {@code descriptor}, {@code referencedClasses}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addInvokeDynamicConstant(int, String, String,
   * Clazz[])}
   */
  @Test
  @DisplayName(
      "Test addInvokeDynamicConstant(int, String, String, Clazz[]) with 'bootstrapMethodIndex', 'name', 'descriptor', 'referencedClasses'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addInvokeDynamicConstant(int, String, String, Clazz[])"
  })
  void testAddInvokeDynamicConstantWithBootstrapMethodIndexNameDescriptorReferencedClasses3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(
        6,
        constantPoolEditor.addInvokeDynamicConstant(
            1, "Name", "Descriptor", new Clazz[] {new LibraryClass()}));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(7, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addInvokeDynamicConstant(int, String, String, Clazz[])} with
   * {@code bootstrapMethodIndex}, {@code name}, {@code descriptor}, {@code referencedClasses}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addInvokeDynamicConstant(int, String, String,
   * Clazz[])}
   */
  @Test
  @DisplayName(
      "Test addInvokeDynamicConstant(int, String, String, Clazz[]) with 'bootstrapMethodIndex', 'name', 'descriptor', 'referencedClasses'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addInvokeDynamicConstant(int, String, String, Clazz[])"
  })
  void testAddInvokeDynamicConstantWithBootstrapMethodIndexNameDescriptorReferencedClasses4() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};

    ConstantPoolEditor constantPoolEditor =
        new ConstantPoolEditor(new ProgramClass(1, 3, constantPool, 1, 1, 1));
    constantPoolEditor.addConstant(new ClassConstant());

    // Act
    int actualAddInvokeDynamicConstantResult =
        constantPoolEditor.addInvokeDynamicConstant(
            1, "Name", "Descriptor", new Clazz[] {new LibraryClass()});

    // Assert
    ProgramClass targetClass = constantPoolEditor.getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[7] instanceof InvokeDynamicConstant);
    assertTrue(constantArray[6] instanceof NameAndTypeConstant);
    assertTrue(constantArray[5] instanceof Utf8Constant);
    assertEquals(19, constantArray.length);
    assertEquals(7, actualAddInvokeDynamicConstantResult);
    assertEquals(8, targetClass.u2constantPoolCount);
  }

  /**
   * Test {@link ConstantPoolEditor#addInvokeDynamicConstant(int, String, String, Clazz[])} with
   * {@code bootstrapMethodIndex}, {@code name}, {@code descriptor}, {@code referencedClasses}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addInvokeDynamicConstant(int, String, String,
   * Clazz[])}
   */
  @Test
  @DisplayName(
      "Test addInvokeDynamicConstant(int, String, String, Clazz[]) with 'bootstrapMethodIndex', 'name', 'descriptor', 'referencedClasses'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addInvokeDynamicConstant(int, String, String, Clazz[])"
  })
  void testAddInvokeDynamicConstantWithBootstrapMethodIndexNameDescriptorReferencedClasses5() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};

    ConstantPoolEditor constantPoolEditor =
        new ConstantPoolEditor(new ProgramClass(1, 1, constantPool, 1, 1, 1));
    constantPoolEditor.addInvokeDynamicConstant(
        1, "Name", "Descriptor", new Clazz[] {new LibraryClass()});

    // Act
    constantPoolEditor.addInvokeDynamicConstant(
        1, "Name", "Descriptor", new Clazz[] {new LibraryClass()});

    // Assert that nothing has changed
    ProgramClass targetClass = constantPoolEditor.getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[4] instanceof InvokeDynamicConstant);
    assertTrue(constantArray[3] instanceof NameAndTypeConstant);
    assertEquals(17, constantArray.length);
    assertEquals(5, targetClass.u2constantPoolCount);
  }

  /**
   * Test {@link ConstantPoolEditor#addMethodHandleConstant(int, int)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addMethodHandleConstant(int, int)}
   */
  @Test
  @DisplayName("Test addMethodHandleConstant(int, int); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addMethodHandleConstant(int, int)"})
  void testAddMethodHandleConstant_thenReturnOne() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(15, 1, constantPool, 15, 15, 15);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(1, constantPoolEditor.addMethodHandleConstant(2, 1));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(2, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addMethodHandleConstant(int, int)}.
   *
   * <ul>
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addMethodHandleConstant(int, int)}
   */
  @Test
  @DisplayName("Test addMethodHandleConstant(int, int); then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addMethodHandleConstant(int, int)"})
  void testAddMethodHandleConstant_thenReturnThree() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(
            15, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 15, 15, 15);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(3, constantPoolEditor.addMethodHandleConstant(2, 1));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(4, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addMethodHandleConstant(int, int)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addMethodHandleConstant(int, int)}
   */
  @Test
  @DisplayName("Test addMethodHandleConstant(int, int); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addMethodHandleConstant(int, int)"})
  void testAddMethodHandleConstant_thenReturnZero() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(15, 0, constantPool, 15, 15, 15);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(0, constantPoolEditor.addMethodHandleConstant(2, 1));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(1, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addModuleConstant(int)} with {@code nameIndex}.
   *
   * <ul>
   *   <li>Then first element {@link ModuleConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addModuleConstant(int)}
   */
  @Test
  @DisplayName("Test addModuleConstant(int) with 'nameIndex'; then first element ModuleConstant")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addModuleConstant(int)"})
  void testAddModuleConstantWithNameIndex_thenFirstElementModuleConstant() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ConstantPoolEditor constantPoolEditor =
        new ConstantPoolEditor(new ProgramClass(19, 0, constantPool, 19, 19, 19));

    // Act
    int actualAddModuleConstantResult = constantPoolEditor.addModuleConstant(1);

    // Assert
    ProgramClass targetClass = constantPoolEditor.getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    Constant constant = constantArray[0];
    assertTrue(constant instanceof ModuleConstant);
    assertEquals(0, actualAddModuleConstantResult);
    assertEquals(1, constantArray.length);
    assertEquals(1, targetClass.u2constantPoolCount);
    assertEquals(1, ((ModuleConstant) constant).u2nameIndex);
    assertEquals(19, constant.getTag());
    assertFalse(constant.isCategory2());
  }

  /**
   * Test {@link ConstantPoolEditor#addModuleConstant(int)} with {@code nameIndex}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addModuleConstant(int)}
   */
  @Test
  @DisplayName("Test addModuleConstant(int) with 'nameIndex'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addModuleConstant(int)"})
  void testAddModuleConstantWithNameIndex_thenReturnOne() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(19, 1, constantPool, 19, 19, 19);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(1, constantPoolEditor.addModuleConstant(1));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(2, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addModuleConstant(int)} with {@code nameIndex}.
   *
   * <ul>
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addModuleConstant(int)}
   */
  @Test
  @DisplayName("Test addModuleConstant(int) with 'nameIndex'; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addModuleConstant(int)"})
  void testAddModuleConstantWithNameIndex_thenReturnThree() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(
            19, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 19, 19, 19);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(3, constantPoolEditor.addModuleConstant(1));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(4, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addModuleConstant(int)} with {@code nameIndex}.
   *
   * <ul>
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addModuleConstant(int)}
   */
  @Test
  @DisplayName("Test addModuleConstant(int) with 'nameIndex'; then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addModuleConstant(int)"})
  void testAddModuleConstantWithNameIndex_thenReturnTwo() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(19, 1, constantPool, 19, 19, 19);

    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    constantPoolEditor.addModuleConstant("42");

    // Act and Assert
    assertEquals(2, constantPoolEditor.addModuleConstant(1));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(3, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addModuleConstant(String)} with {@code name}.
   *
   * <ul>
   *   <li>Then return four.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addModuleConstant(String)}
   */
  @Test
  @DisplayName("Test addModuleConstant(String) with 'name'; then return four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addModuleConstant(String)"})
  void testAddModuleConstantWithName_thenReturnFour() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(4, constantPoolEditor.addModuleConstant("Name"));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(5, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addModuleConstant(String)} with {@code name}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addModuleConstant(String)}
   */
  @Test
  @DisplayName("Test addModuleConstant(String) with 'name'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addModuleConstant(String)"})
  void testAddModuleConstantWithName_thenReturnOne() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 0, constantPool, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(1, constantPoolEditor.addModuleConstant("Name"));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(2, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addModuleConstant(String)} with {@code name}.
   *
   * <ul>
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addModuleConstant(String)}
   */
  @Test
  @DisplayName("Test addModuleConstant(String) with 'name'; then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addModuleConstant(String)"})
  void testAddModuleConstantWithName_thenReturnTwo() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 1, constantPool, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(2, constantPoolEditor.addModuleConstant("Name"));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(3, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addPackageConstant(int)} with {@code nameIndex}.
   *
   * <ul>
   *   <li>Then first element {@link PackageConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addPackageConstant(int)}
   */
  @Test
  @DisplayName("Test addPackageConstant(int) with 'nameIndex'; then first element PackageConstant")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addPackageConstant(int)"})
  void testAddPackageConstantWithNameIndex_thenFirstElementPackageConstant() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ConstantPoolEditor constantPoolEditor =
        new ConstantPoolEditor(new ProgramClass(20, 0, constantPool, 20, 20, 20));

    // Act
    int actualAddPackageConstantResult = constantPoolEditor.addPackageConstant(1);

    // Assert
    ProgramClass targetClass = constantPoolEditor.getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    Constant constant = constantArray[0];
    assertTrue(constant instanceof PackageConstant);
    assertEquals(0, actualAddPackageConstantResult);
    assertEquals(1, constantArray.length);
    assertEquals(1, targetClass.u2constantPoolCount);
    assertEquals(1, ((PackageConstant) constant).u2nameIndex);
    assertEquals(20, constant.getTag());
    assertFalse(constant.isCategory2());
  }

  /**
   * Test {@link ConstantPoolEditor#addPackageConstant(int)} with {@code nameIndex}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addPackageConstant(int)}
   */
  @Test
  @DisplayName("Test addPackageConstant(int) with 'nameIndex'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addPackageConstant(int)"})
  void testAddPackageConstantWithNameIndex_thenReturnOne() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(20, 1, constantPool, 20, 20, 20);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(1, constantPoolEditor.addPackageConstant(1));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(2, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addPackageConstant(int)} with {@code nameIndex}.
   *
   * <ul>
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addPackageConstant(int)}
   */
  @Test
  @DisplayName("Test addPackageConstant(int) with 'nameIndex'; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addPackageConstant(int)"})
  void testAddPackageConstantWithNameIndex_thenReturnThree() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(
            20, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 20, 20, 20);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(3, constantPoolEditor.addPackageConstant(1));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(4, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addPackageConstant(int)} with {@code nameIndex}.
   *
   * <ul>
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addPackageConstant(int)}
   */
  @Test
  @DisplayName("Test addPackageConstant(int) with 'nameIndex'; then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addPackageConstant(int)"})
  void testAddPackageConstantWithNameIndex_thenReturnTwo() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(20, 1, constantPool, 20, 20, 20);

    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    constantPoolEditor.addPackageConstant("42");

    // Act and Assert
    assertEquals(2, constantPoolEditor.addPackageConstant(1));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(3, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addPackageConstant(String)} with {@code name}.
   *
   * <ul>
   *   <li>Then return four.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addPackageConstant(String)}
   */
  @Test
  @DisplayName("Test addPackageConstant(String) with 'name'; then return four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addPackageConstant(String)"})
  void testAddPackageConstantWithName_thenReturnFour() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(4, constantPoolEditor.addPackageConstant("Name"));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(5, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addPackageConstant(String)} with {@code name}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addPackageConstant(String)}
   */
  @Test
  @DisplayName("Test addPackageConstant(String) with 'name'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addPackageConstant(String)"})
  void testAddPackageConstantWithName_thenReturnOne() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 0, constantPool, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(1, constantPoolEditor.addPackageConstant("Name"));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(2, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addPackageConstant(String)} with {@code name}.
   *
   * <ul>
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addPackageConstant(String)}
   */
  @Test
  @DisplayName("Test addPackageConstant(String) with 'name'; then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addPackageConstant(String)"})
  void testAddPackageConstantWithName_thenReturnTwo() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 1, constantPool, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(2, constantPoolEditor.addPackageConstant("Name"));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(3, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addDynamicConstant(int, int, Clazz[])}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addDynamicConstant(int, int, Clazz[])}
   */
  @Test
  @DisplayName("Test addDynamicConstant(int, int, Clazz[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addDynamicConstant(int, int, Clazz[])"})
  void testAddDynamicConstant() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(17, 1, constantPool, 17, 17, 17);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act
    constantPoolEditor.addDynamicConstant(1, 1, new Clazz[] {new LibraryClass()});

    // Assert
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(2, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addDynamicConstant(int, int, Clazz[])}.
   *
   * <ul>
   *   <li>Then fifth element {@link DynamicConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addDynamicConstant(int, int, Clazz[])}
   */
  @Test
  @DisplayName("Test addDynamicConstant(int, int, Clazz[]); then fifth element DynamicConstant")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addDynamicConstant(int, int, Clazz[])"})
  void testAddDynamicConstant_thenFifthElementDynamicConstant() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};

    ConstantPoolEditor constantPoolEditor =
        new ConstantPoolEditor(new ProgramClass(17, 3, constantPool, 17, 17, 17));
    constantPoolEditor.addConstant(new ClassConstant());
    Clazz[] referencedClasses = new Clazz[] {new LibraryClass()};

    // Act
    int actualAddDynamicConstantResult =
        constantPoolEditor.addDynamicConstant(1, 1, referencedClasses);

    // Assert
    ProgramClass targetClass = constantPoolEditor.getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    Constant constant = constantArray[4];
    assertTrue(constant instanceof DynamicConstant);
    assertNull(constant.getProcessingInfo());
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(1, ((DynamicConstant) constant).getBootstrapMethodAttributeIndex());
    assertEquals(1, ((DynamicConstant) constant).getNameAndTypeIndex());
    assertEquals(17, constant.getTag());
    assertEquals(19, constantArray.length);
    assertEquals(4, actualAddDynamicConstantResult);
    assertEquals(5, targetClass.u2constantPoolCount);
    assertFalse(constant.isCategory2());
    assertSame(referencedClasses, ((DynamicConstant) constant).referencedClasses);
  }

  /**
   * Test {@link ConstantPoolEditor#addDynamicConstant(int, int, Clazz[])}.
   *
   * <ul>
   *   <li>Then first element {@link DynamicConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addDynamicConstant(int, int, Clazz[])}
   */
  @Test
  @DisplayName("Test addDynamicConstant(int, int, Clazz[]); then first element DynamicConstant")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addDynamicConstant(int, int, Clazz[])"})
  void testAddDynamicConstant_thenFirstElementDynamicConstant() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ConstantPoolEditor constantPoolEditor =
        new ConstantPoolEditor(new ProgramClass(17, 0, constantPool, 17, 17, 17));
    Clazz[] referencedClasses = new Clazz[] {new LibraryClass()};

    // Act
    int actualAddDynamicConstantResult =
        constantPoolEditor.addDynamicConstant(1, 1, referencedClasses);

    // Assert
    ProgramClass targetClass = constantPoolEditor.getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    Constant constant = constantArray[0];
    assertTrue(constant instanceof DynamicConstant);
    assertEquals(0, actualAddDynamicConstantResult);
    assertEquals(1, ((DynamicConstant) constant).getBootstrapMethodAttributeIndex());
    assertEquals(1, ((DynamicConstant) constant).getNameAndTypeIndex());
    assertEquals(1, constantArray.length);
    assertEquals(1, targetClass.u2constantPoolCount);
    assertEquals(17, constant.getTag());
    assertFalse(constant.isCategory2());
    assertSame(referencedClasses, ((DynamicConstant) constant).referencedClasses);
  }

  /**
   * Test {@link ConstantPoolEditor#addDynamicConstant(int, int, Clazz[])}.
   *
   * <ul>
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addDynamicConstant(int, int, Clazz[])}
   */
  @Test
  @DisplayName("Test addDynamicConstant(int, int, Clazz[]); then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addDynamicConstant(int, int, Clazz[])"})
  void testAddDynamicConstant_thenReturnThree() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(
            17, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 17, 17, 17);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(3, constantPoolEditor.addDynamicConstant(1, 1, new Clazz[] {new LibraryClass()}));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(4, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addDynamicConstant(int, int, Clazz[])}.
   *
   * <ul>
   *   <li>Then second element {@link DynamicConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addDynamicConstant(int, int, Clazz[])}
   */
  @Test
  @DisplayName("Test addDynamicConstant(int, int, Clazz[]); then second element DynamicConstant")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addDynamicConstant(int, int, Clazz[])"})
  void testAddDynamicConstant_thenSecondElementDynamicConstant() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};

    ConstantPoolEditor constantPoolEditor =
        new ConstantPoolEditor(new ProgramClass(17, 1, constantPool, 17, 17, 17));
    constantPoolEditor.addDynamicConstant(1, 1, new Clazz[] {new LibraryClass()});

    // Act
    int actualAddDynamicConstantResult =
        constantPoolEditor.addDynamicConstant(1, 1, new Clazz[] {new LibraryClass()});

    // Assert
    ProgramClass targetClass = constantPoolEditor.getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[1] instanceof DynamicConstant);
    assertNull(constantArray[3]);
    assertEquals(1, actualAddDynamicConstantResult);
    assertEquals(17, constantArray.length);
    assertEquals(2, targetClass.u2constantPoolCount);
  }

  /**
   * Test {@link ConstantPoolEditor#addFieldrefConstant(int, int, Clazz, Field)} with {@code
   * classIndex}, {@code nameAndTypeIndex}, {@code referencedClass}, {@code referencedField}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addFieldrefConstant(int, int, Clazz, Field)}
   */
  @Test
  @DisplayName(
      "Test addFieldrefConstant(int, int, Clazz, Field) with 'classIndex', 'nameAndTypeIndex', 'referencedClass', 'referencedField'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addFieldrefConstant(int, int, Clazz, Field)"})
  void testAddFieldrefConstantWithClassIndexNameAndTypeIndexReferencedClassReferencedField() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(9, 1, constantPool, 9, 9, 9);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();
    LibraryField referencedField = new LibraryField(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(1, constantPoolEditor.addFieldrefConstant(1, 1, referencedClass, referencedField));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(2, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addFieldrefConstant(int, int, Clazz, Field)} with {@code
   * classIndex}, {@code nameAndTypeIndex}, {@code referencedClass}, {@code referencedField}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addFieldrefConstant(int, int, Clazz, Field)}
   */
  @Test
  @DisplayName(
      "Test addFieldrefConstant(int, int, Clazz, Field) with 'classIndex', 'nameAndTypeIndex', 'referencedClass', 'referencedField'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addFieldrefConstant(int, int, Clazz, Field)"})
  void testAddFieldrefConstantWithClassIndexNameAndTypeIndexReferencedClassReferencedField2() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(9, 0, constantPool, 9, 9, 9);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();
    LibraryField referencedField = new LibraryField(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(0, constantPoolEditor.addFieldrefConstant(1, 1, referencedClass, referencedField));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(1, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addFieldrefConstant(int, int, Clazz, Field)} with {@code
   * classIndex}, {@code nameAndTypeIndex}, {@code referencedClass}, {@code referencedField}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addFieldrefConstant(int, int, Clazz, Field)}
   */
  @Test
  @DisplayName(
      "Test addFieldrefConstant(int, int, Clazz, Field) with 'classIndex', 'nameAndTypeIndex', 'referencedClass', 'referencedField'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addFieldrefConstant(int, int, Clazz, Field)"})
  void testAddFieldrefConstantWithClassIndexNameAndTypeIndexReferencedClassReferencedField3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(
            9, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 9, 9, 9);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();
    LibraryField referencedField = new LibraryField(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(3, constantPoolEditor.addFieldrefConstant(1, 1, referencedClass, referencedField));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(4, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addFieldrefConstant(int, String, String, Clazz, Field)} with
   * {@code classIndex}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedField}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addFieldrefConstant(int, String, String, Clazz,
   * Field)}
   */
  @Test
  @DisplayName(
      "Test addFieldrefConstant(int, String, String, Clazz, Field) with 'classIndex', 'name', 'descriptor', 'referencedClass', 'referencedField'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addFieldrefConstant(int, String, String, Clazz, Field)"
  })
  void testAddFieldrefConstantWithClassIndexNameDescriptorReferencedClassReferencedField() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 1, constantPool, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();
    LibraryField referencedField = new LibraryField(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(
        4,
        constantPoolEditor.addFieldrefConstant(
            1, "Name", "Descriptor", referencedClass, referencedField));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(5, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addFieldrefConstant(int, String, String, Clazz, Field)} with
   * {@code classIndex}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedField}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addFieldrefConstant(int, String, String, Clazz,
   * Field)}
   */
  @Test
  @DisplayName(
      "Test addFieldrefConstant(int, String, String, Clazz, Field) with 'classIndex', 'name', 'descriptor', 'referencedClass', 'referencedField'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addFieldrefConstant(int, String, String, Clazz, Field)"
  })
  void testAddFieldrefConstantWithClassIndexNameDescriptorReferencedClassReferencedField2() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 0, constantPool, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();
    LibraryField referencedField = new LibraryField(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(
        3,
        constantPoolEditor.addFieldrefConstant(
            1, "Name", "Descriptor", referencedClass, referencedField));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(4, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addFieldrefConstant(int, String, String, Clazz, Field)} with
   * {@code classIndex}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedField}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addFieldrefConstant(int, String, String, Clazz,
   * Field)}
   */
  @Test
  @DisplayName(
      "Test addFieldrefConstant(int, String, String, Clazz, Field) with 'classIndex', 'name', 'descriptor', 'referencedClass', 'referencedField'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addFieldrefConstant(int, String, String, Clazz, Field)"
  })
  void testAddFieldrefConstantWithClassIndexNameDescriptorReferencedClassReferencedField3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();
    LibraryField referencedField = new LibraryField(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(
        6,
        constantPoolEditor.addFieldrefConstant(
            1, "Name", "Descriptor", referencedClass, referencedField));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(7, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addFieldrefConstant(String, int, Clazz, Field)} with {@code
   * className}, {@code nameAndTypeIndex}, {@code referencedClass}, {@code referencedField}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addFieldrefConstant(String, int, Clazz, Field)}
   */
  @Test
  @DisplayName(
      "Test addFieldrefConstant(String, int, Clazz, Field) with 'className', 'nameAndTypeIndex', 'referencedClass', 'referencedField'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addFieldrefConstant(String, int, Clazz, Field)"})
  void testAddFieldrefConstantWithClassNameNameAndTypeIndexReferencedClassReferencedField() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 1, constantPool, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();
    LibraryField referencedField = new LibraryField(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(
        3,
        constantPoolEditor.addFieldrefConstant("Class Name", 1, referencedClass, referencedField));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(4, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addFieldrefConstant(String, int, Clazz, Field)} with {@code
   * className}, {@code nameAndTypeIndex}, {@code referencedClass}, {@code referencedField}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addFieldrefConstant(String, int, Clazz, Field)}
   */
  @Test
  @DisplayName(
      "Test addFieldrefConstant(String, int, Clazz, Field) with 'className', 'nameAndTypeIndex', 'referencedClass', 'referencedField'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addFieldrefConstant(String, int, Clazz, Field)"})
  void testAddFieldrefConstantWithClassNameNameAndTypeIndexReferencedClassReferencedField2() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 0, constantPool, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();
    LibraryField referencedField = new LibraryField(1, "Name", "Descriptor");

    // Act
    int actualAddFieldrefConstantResult =
        constantPoolEditor.addFieldrefConstant("Class Name", 1, referencedClass, referencedField);

    // Assert
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals("Class Name", targetClass2.getName());
    assertEquals("Class Name", targetClass2.getSuperName());
    assertEquals(2, actualAddFieldrefConstantResult);
    assertEquals(3, targetClass2.u2constantPoolCount);
    assertSame(referencedClass, targetClass2.getSuperClass());
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addFieldrefConstant(String, int, Clazz, Field)} with {@code
   * className}, {@code nameAndTypeIndex}, {@code referencedClass}, {@code referencedField}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addFieldrefConstant(String, int, Clazz, Field)}
   */
  @Test
  @DisplayName(
      "Test addFieldrefConstant(String, int, Clazz, Field) with 'className', 'nameAndTypeIndex', 'referencedClass', 'referencedField'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addFieldrefConstant(String, int, Clazz, Field)"})
  void testAddFieldrefConstantWithClassNameNameAndTypeIndexReferencedClassReferencedField3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();
    LibraryField referencedField = new LibraryField(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(
        5,
        constantPoolEditor.addFieldrefConstant("Class Name", 1, referencedClass, referencedField));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(6, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addFieldrefConstant(String, int, Clazz, Field)} with {@code
   * className}, {@code nameAndTypeIndex}, {@code referencedClass}, {@code referencedField}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addFieldrefConstant(String, int, Clazz, Field)}
   */
  @Test
  @DisplayName(
      "Test addFieldrefConstant(String, int, Clazz, Field) with 'className', 'nameAndTypeIndex', 'referencedClass', 'referencedField'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addFieldrefConstant(String, int, Clazz, Field)"})
  void testAddFieldrefConstantWithClassNameNameAndTypeIndexReferencedClassReferencedField4() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};

    ConstantPoolEditor constantPoolEditor =
        new ConstantPoolEditor(new ProgramClass(1, 3, constantPool, 1, 1, 1));
    constantPoolEditor.addConstant(new ClassConstant());
    LibraryClass referencedClass = new LibraryClass();
    LibraryField referencedField = new LibraryField(1, "Name", "Descriptor");

    // Act
    int actualAddFieldrefConstantResult =
        constantPoolEditor.addFieldrefConstant("Class Name", 1, referencedClass, referencedField);

    // Assert
    ProgramClass targetClass = constantPoolEditor.getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[5] instanceof ClassConstant);
    assertTrue(constantArray[6] instanceof FieldrefConstant);
    assertTrue(constantArray[4] instanceof Utf8Constant);
    assertEquals(19, constantArray.length);
    assertEquals(6, actualAddFieldrefConstantResult);
    assertEquals(7, targetClass.u2constantPoolCount);
  }

  /**
   * Test {@link ConstantPoolEditor#addFieldrefConstant(String, int, Clazz, Field)} with {@code
   * className}, {@code nameAndTypeIndex}, {@code referencedClass}, {@code referencedField}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addFieldrefConstant(String, int, Clazz, Field)}
   */
  @Test
  @DisplayName(
      "Test addFieldrefConstant(String, int, Clazz, Field) with 'className', 'nameAndTypeIndex', 'referencedClass', 'referencedField'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addFieldrefConstant(String, int, Clazz, Field)"})
  void testAddFieldrefConstantWithClassNameNameAndTypeIndexReferencedClassReferencedField5() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};

    ConstantPoolEditor constantPoolEditor =
        new ConstantPoolEditor(new ProgramClass(1, 1, constantPool, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();
    LibraryField referencedField = new LibraryField(1, "Name", "Descriptor");

    constantPoolEditor.addFieldrefConstant(
        "Class Name", "Name", "Descriptor", referencedClass, referencedField);
    LibraryClass referencedClass2 = new LibraryClass();
    LibraryField referencedField2 = new LibraryField(1, "Name", "Descriptor");

    // Act
    int actualAddFieldrefConstantResult =
        constantPoolEditor.addFieldrefConstant("Class Name", 1, referencedClass2, referencedField2);

    // Assert
    ProgramClass targetClass = constantPoolEditor.getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    Constant constant = constantArray[7];
    assertTrue(constant instanceof FieldrefConstant);
    assertNull(constant.getProcessingInfo());
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(1, ((FieldrefConstant) constant).getNameAndTypeIndex());
    assertEquals(17, constantArray.length);
    assertEquals(5, ((FieldrefConstant) constant).getClassIndex());
    assertEquals(7, actualAddFieldrefConstantResult);
    assertEquals(8, targetClass.u2constantPoolCount);
    assertEquals(9, constant.getTag());
    assertFalse(constant.isCategory2());
    assertSame(referencedClass2, ((FieldrefConstant) constant).referencedClass);
    assertSame(referencedField2, ((FieldrefConstant) constant).referencedField);
  }

  /**
   * Test {@link ConstantPoolEditor#addFieldrefConstant(String, String, String, Clazz, Field)} with
   * {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedField}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addFieldrefConstant(String, String, String,
   * Clazz, Field)}
   */
  @Test
  @DisplayName(
      "Test addFieldrefConstant(String, String, String, Clazz, Field) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedField'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addFieldrefConstant(String, String, String, Clazz, Field)"
  })
  void testAddFieldrefConstantWithClassNameNameDescriptorReferencedClassReferencedField() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 1, constantPool, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();
    LibraryField referencedField = new LibraryField(1, "Name", "Descriptor");

    // Act
    constantPoolEditor.addFieldrefConstant(
        "Class Name", "Name", "Descriptor", referencedClass, referencedField);

    // Assert
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(7, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addFieldrefConstant(String, String, String, Clazz, Field)} with
   * {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedField}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addFieldrefConstant(String, String, String,
   * Clazz, Field)}
   */
  @Test
  @DisplayName(
      "Test addFieldrefConstant(String, String, String, Clazz, Field) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedField'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addFieldrefConstant(String, String, String, Clazz, Field)"
  })
  void testAddFieldrefConstantWithClassNameNameDescriptorReferencedClassReferencedField2() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 0, constantPool, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();
    LibraryField referencedField = new LibraryField(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(
        5,
        constantPoolEditor.addFieldrefConstant(
            "Class Name", "Name", "Descriptor", referencedClass, referencedField));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(6, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addFieldrefConstant(String, String, String, Clazz, Field)} with
   * {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedField}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addFieldrefConstant(String, String, String,
   * Clazz, Field)}
   */
  @Test
  @DisplayName(
      "Test addFieldrefConstant(String, String, String, Clazz, Field) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedField'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addFieldrefConstant(String, String, String, Clazz, Field)"
  })
  void testAddFieldrefConstantWithClassNameNameDescriptorReferencedClassReferencedField3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();
    LibraryField referencedField = new LibraryField(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(
        8,
        constantPoolEditor.addFieldrefConstant(
            "Class Name", "Name", "Descriptor", referencedClass, referencedField));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(9, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addFieldrefConstant(String, String, String, Clazz, Field)} with
   * {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedField}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addFieldrefConstant(String, String, String,
   * Clazz, Field)}
   */
  @Test
  @DisplayName(
      "Test addFieldrefConstant(String, String, String, Clazz, Field) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedField'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addFieldrefConstant(String, String, String, Clazz, Field)"
  })
  void testAddFieldrefConstantWithClassNameNameDescriptorReferencedClassReferencedField4() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};

    ConstantPoolEditor constantPoolEditor =
        new ConstantPoolEditor(new ProgramClass(1, 3, constantPool, 1, 1, 1));
    constantPoolEditor.addConstant(new ClassConstant());
    LibraryClass referencedClass = new LibraryClass();
    LibraryField referencedField = new LibraryField(1, "Name", "Descriptor");

    // Act
    int actualAddFieldrefConstantResult =
        constantPoolEditor.addFieldrefConstant(
            "Class Name", "Name", "Descriptor", referencedClass, referencedField);

    // Assert
    ProgramClass targetClass = constantPoolEditor.getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[8] instanceof ClassConstant);
    assertTrue(constantArray[9] instanceof FieldrefConstant);
    assertTrue(constantArray[6] instanceof NameAndTypeConstant);
    assertTrue(constantArray[7] instanceof Utf8Constant);
    assertEquals(10, targetClass.u2constantPoolCount);
    assertEquals(19, constantArray.length);
    assertEquals(9, actualAddFieldrefConstantResult);
  }

  /**
   * Test {@link ConstantPoolEditor#addFieldrefConstant(String, String, String, Clazz, Field)} with
   * {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedField}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addFieldrefConstant(String, String, String,
   * Clazz, Field)}
   */
  @Test
  @DisplayName(
      "Test addFieldrefConstant(String, String, String, Clazz, Field) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedField'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addFieldrefConstant(String, String, String, Clazz, Field)"
  })
  void testAddFieldrefConstantWithClassNameNameDescriptorReferencedClassReferencedField5()
      throws UnsupportedEncodingException {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};

    ConstantPoolEditor constantPoolEditor =
        new ConstantPoolEditor(new ProgramClass(1, 1, constantPool, 1, 1, 1));
    constantPoolEditor.addInvokeDynamicConstant(
        1, "Name", "Descriptor", new Clazz[] {new LibraryClass()});
    LibraryClass referencedClass = new LibraryClass();
    LibraryField referencedField = new LibraryField(1, "Name", "Descriptor");

    // Act
    int actualAddFieldrefConstantResult =
        constantPoolEditor.addFieldrefConstant(
            "Class Name", "Name", "Descriptor", referencedClass, referencedField);

    // Assert
    ProgramClass targetClass = constantPoolEditor.getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    Constant constant = constantArray[6];
    assertTrue(constant instanceof ClassConstant);
    Constant constant2 = constantArray[7];
    assertTrue(constant2 instanceof FieldrefConstant);
    Constant constant3 = constantArray[5];
    assertTrue(constant3 instanceof Utf8Constant);
    assertEquals("Class Name", ((Utf8Constant) constant3).getString());
    assertNull(((ClassConstant) constant).javaLangClassClass);
    assertEquals(17, constantArray.length);
    assertEquals(3, ((FieldrefConstant) constant2).getNameAndTypeIndex());
    assertEquals(5, ((ClassConstant) constant).u2nameIndex);
    assertEquals(6, ((FieldrefConstant) constant2).getClassIndex());
    assertEquals(7, constant.getTag());
    assertEquals(7, actualAddFieldrefConstantResult);
    assertEquals(8, targetClass.u2constantPoolCount);
    assertEquals(9, constant2.getTag());
    assertFalse(constant.isCategory2());
    assertFalse(constant2.isCategory2());
    assertSame(referencedField, ((FieldrefConstant) constant2).referencedField);
    assertArrayEquals("Class Name".getBytes("UTF-8"), ((Utf8Constant) constant3).getBytes());
  }

  /**
   * Test {@link ConstantPoolEditor#addFieldrefConstant(String, String, String, Clazz, Field)} with
   * {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedField}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addFieldrefConstant(String, String, String,
   * Clazz, Field)}
   */
  @Test
  @DisplayName(
      "Test addFieldrefConstant(String, String, String, Clazz, Field) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedField'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addFieldrefConstant(String, String, String, Clazz, Field)"
  })
  void testAddFieldrefConstantWithClassNameNameDescriptorReferencedClassReferencedField6() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};

    ConstantPoolEditor constantPoolEditor =
        new ConstantPoolEditor(new ProgramClass(1, 1, constantPool, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();
    LibraryField referencedField = new LibraryField(1, "Name", "Descriptor");

    constantPoolEditor.addFieldrefConstant(
        "Class Name", "Name", "Descriptor", referencedClass, referencedField);
    LibraryClass referencedClass2 = new LibraryClass();
    LibraryField referencedField2 = new LibraryField(1, "Name", "Descriptor");

    // Act
    constantPoolEditor.addFieldrefConstant(
        "Class Name", "Name", "Descriptor", referencedClass2, referencedField2);

    // Assert that nothing has changed
    ProgramClass targetClass = constantPoolEditor.getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[5] instanceof ClassConstant);
    assertTrue(constantArray[6] instanceof FieldrefConstant);
    assertEquals(17, constantArray.length);
    assertEquals(7, targetClass.u2constantPoolCount);
  }

  /**
   * Test {@link ConstantPoolEditor#addFieldrefConstant(Clazz, Field)} with {@code referencedClass},
   * {@code referencedField}.
   *
   * <ul>
   *   <li>Then return six.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addFieldrefConstant(Clazz, Field)}
   */
  @Test
  @DisplayName(
      "Test addFieldrefConstant(Clazz, Field) with 'referencedClass', 'referencedField'; then return six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addFieldrefConstant(Clazz, Field)"})
  void testAddFieldrefConstantWithReferencedClassReferencedField_thenReturnSix() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 1, constantPool, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass(1, "This Class Name", "Super Class Name");
    LibraryField referencedField = new LibraryField(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(6, constantPoolEditor.addFieldrefConstant(referencedClass, referencedField));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(7, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addInterfaceMethodrefConstant(int, int, Clazz, Method)} with
   * {@code classIndex}, {@code nameAndTypeIndex}, {@code referencedClass}, {@code
   * referencedMethod}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addInterfaceMethodrefConstant(int, int, Clazz,
   * Method)}
   */
  @Test
  @DisplayName(
      "Test addInterfaceMethodrefConstant(int, int, Clazz, Method) with 'classIndex', 'nameAndTypeIndex', 'referencedClass', 'referencedMethod'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addInterfaceMethodrefConstant(int, int, Clazz, Method)"
  })
  void
      testAddInterfaceMethodrefConstantWithClassIndexNameAndTypeIndexReferencedClassReferencedMethod() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(11, 1, constantPool, 11, 11, 11);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();
    LibraryMethod referencedMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(
        1,
        constantPoolEditor.addInterfaceMethodrefConstant(1, 1, referencedClass, referencedMethod));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(2, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addInterfaceMethodrefConstant(int, int, Clazz, Method)} with
   * {@code classIndex}, {@code nameAndTypeIndex}, {@code referencedClass}, {@code
   * referencedMethod}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addInterfaceMethodrefConstant(int, int, Clazz,
   * Method)}
   */
  @Test
  @DisplayName(
      "Test addInterfaceMethodrefConstant(int, int, Clazz, Method) with 'classIndex', 'nameAndTypeIndex', 'referencedClass', 'referencedMethod'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addInterfaceMethodrefConstant(int, int, Clazz, Method)"
  })
  void
      testAddInterfaceMethodrefConstantWithClassIndexNameAndTypeIndexReferencedClassReferencedMethod2() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(11, 0, constantPool, 11, 11, 11);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();
    LibraryMethod referencedMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(
        0,
        constantPoolEditor.addInterfaceMethodrefConstant(1, 1, referencedClass, referencedMethod));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(1, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addInterfaceMethodrefConstant(int, int, Clazz, Method)} with
   * {@code classIndex}, {@code nameAndTypeIndex}, {@code referencedClass}, {@code
   * referencedMethod}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addInterfaceMethodrefConstant(int, int, Clazz,
   * Method)}
   */
  @Test
  @DisplayName(
      "Test addInterfaceMethodrefConstant(int, int, Clazz, Method) with 'classIndex', 'nameAndTypeIndex', 'referencedClass', 'referencedMethod'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addInterfaceMethodrefConstant(int, int, Clazz, Method)"
  })
  void
      testAddInterfaceMethodrefConstantWithClassIndexNameAndTypeIndexReferencedClassReferencedMethod3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(
            11, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 11, 11, 11);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();
    LibraryMethod referencedMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(
        3,
        constantPoolEditor.addInterfaceMethodrefConstant(1, 1, referencedClass, referencedMethod));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(4, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addInterfaceMethodrefConstant(int, String, String, Clazz,
   * Method)} with {@code classIndex}, {@code name}, {@code descriptor}, {@code referencedClass},
   * {@code referencedMethod}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addInterfaceMethodrefConstant(int, String,
   * String, Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test addInterfaceMethodrefConstant(int, String, String, Clazz, Method) with 'classIndex', 'name', 'descriptor', 'referencedClass', 'referencedMethod'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addInterfaceMethodrefConstant(int, String, String, Clazz, Method)"
  })
  void
      testAddInterfaceMethodrefConstantWithClassIndexNameDescriptorReferencedClassReferencedMethod() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 1, constantPool, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();
    LibraryMethod referencedMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(
        4,
        constantPoolEditor.addInterfaceMethodrefConstant(
            1, "Name", "Descriptor", referencedClass, referencedMethod));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(5, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addInterfaceMethodrefConstant(int, String, String, Clazz,
   * Method)} with {@code classIndex}, {@code name}, {@code descriptor}, {@code referencedClass},
   * {@code referencedMethod}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addInterfaceMethodrefConstant(int, String,
   * String, Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test addInterfaceMethodrefConstant(int, String, String, Clazz, Method) with 'classIndex', 'name', 'descriptor', 'referencedClass', 'referencedMethod'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addInterfaceMethodrefConstant(int, String, String, Clazz, Method)"
  })
  void
      testAddInterfaceMethodrefConstantWithClassIndexNameDescriptorReferencedClassReferencedMethod2() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 0, constantPool, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();
    LibraryMethod referencedMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(
        3,
        constantPoolEditor.addInterfaceMethodrefConstant(
            1, "Name", "Descriptor", referencedClass, referencedMethod));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(4, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addInterfaceMethodrefConstant(int, String, String, Clazz,
   * Method)} with {@code classIndex}, {@code name}, {@code descriptor}, {@code referencedClass},
   * {@code referencedMethod}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addInterfaceMethodrefConstant(int, String,
   * String, Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test addInterfaceMethodrefConstant(int, String, String, Clazz, Method) with 'classIndex', 'name', 'descriptor', 'referencedClass', 'referencedMethod'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addInterfaceMethodrefConstant(int, String, String, Clazz, Method)"
  })
  void
      testAddInterfaceMethodrefConstantWithClassIndexNameDescriptorReferencedClassReferencedMethod3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();
    LibraryMethod referencedMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(
        6,
        constantPoolEditor.addInterfaceMethodrefConstant(
            1, "Name", "Descriptor", referencedClass, referencedMethod));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(7, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addInterfaceMethodrefConstant(String, int, Clazz, Method)} with
   * {@code className}, {@code nameAndTypeIndex}, {@code referencedClass}, {@code referencedMethod}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addInterfaceMethodrefConstant(String, int,
   * Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test addInterfaceMethodrefConstant(String, int, Clazz, Method) with 'className', 'nameAndTypeIndex', 'referencedClass', 'referencedMethod'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addInterfaceMethodrefConstant(String, int, Clazz, Method)"
  })
  void
      testAddInterfaceMethodrefConstantWithClassNameNameAndTypeIndexReferencedClassReferencedMethod() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 1, constantPool, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();
    LibraryMethod referencedMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(
        3,
        constantPoolEditor.addInterfaceMethodrefConstant(
            "Class Name", 1, referencedClass, referencedMethod));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(4, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addInterfaceMethodrefConstant(String, int, Clazz, Method)} with
   * {@code className}, {@code nameAndTypeIndex}, {@code referencedClass}, {@code referencedMethod}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addInterfaceMethodrefConstant(String, int,
   * Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test addInterfaceMethodrefConstant(String, int, Clazz, Method) with 'className', 'nameAndTypeIndex', 'referencedClass', 'referencedMethod'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addInterfaceMethodrefConstant(String, int, Clazz, Method)"
  })
  void
      testAddInterfaceMethodrefConstantWithClassNameNameAndTypeIndexReferencedClassReferencedMethod2() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 0, constantPool, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();
    LibraryMethod referencedMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    int actualAddInterfaceMethodrefConstantResult =
        constantPoolEditor.addInterfaceMethodrefConstant(
            "Class Name", 1, referencedClass, referencedMethod);

    // Assert
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals("Class Name", targetClass2.getName());
    assertEquals("Class Name", targetClass2.getSuperName());
    assertEquals(2, actualAddInterfaceMethodrefConstantResult);
    assertEquals(3, targetClass2.u2constantPoolCount);
    assertSame(referencedClass, targetClass2.getSuperClass());
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addInterfaceMethodrefConstant(String, int, Clazz, Method)} with
   * {@code className}, {@code nameAndTypeIndex}, {@code referencedClass}, {@code referencedMethod}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addInterfaceMethodrefConstant(String, int,
   * Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test addInterfaceMethodrefConstant(String, int, Clazz, Method) with 'className', 'nameAndTypeIndex', 'referencedClass', 'referencedMethod'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addInterfaceMethodrefConstant(String, int, Clazz, Method)"
  })
  void
      testAddInterfaceMethodrefConstantWithClassNameNameAndTypeIndexReferencedClassReferencedMethod3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();
    LibraryMethod referencedMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(
        5,
        constantPoolEditor.addInterfaceMethodrefConstant(
            "Class Name", 1, referencedClass, referencedMethod));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(6, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addInterfaceMethodrefConstant(String, int, Clazz, Method)} with
   * {@code className}, {@code nameAndTypeIndex}, {@code referencedClass}, {@code referencedMethod}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addInterfaceMethodrefConstant(String, int,
   * Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test addInterfaceMethodrefConstant(String, int, Clazz, Method) with 'className', 'nameAndTypeIndex', 'referencedClass', 'referencedMethod'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addInterfaceMethodrefConstant(String, int, Clazz, Method)"
  })
  void
      testAddInterfaceMethodrefConstantWithClassNameNameAndTypeIndexReferencedClassReferencedMethod4() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};

    ConstantPoolEditor constantPoolEditor =
        new ConstantPoolEditor(new ProgramClass(1, 3, constantPool, 1, 1, 1));
    constantPoolEditor.addConstant(new ClassConstant());
    LibraryClass referencedClass = new LibraryClass();
    LibraryMethod referencedMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    int actualAddInterfaceMethodrefConstantResult =
        constantPoolEditor.addInterfaceMethodrefConstant(
            "Class Name", 1, referencedClass, referencedMethod);

    // Assert
    ProgramClass targetClass = constantPoolEditor.getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[5] instanceof ClassConstant);
    assertTrue(constantArray[6] instanceof InterfaceMethodrefConstant);
    assertTrue(constantArray[4] instanceof Utf8Constant);
    assertEquals(19, constantArray.length);
    assertEquals(6, actualAddInterfaceMethodrefConstantResult);
    assertEquals(7, targetClass.u2constantPoolCount);
  }

  /**
   * Test {@link ConstantPoolEditor#addInterfaceMethodrefConstant(String, int, Clazz, Method)} with
   * {@code className}, {@code nameAndTypeIndex}, {@code referencedClass}, {@code referencedMethod}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addInterfaceMethodrefConstant(String, int,
   * Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test addInterfaceMethodrefConstant(String, int, Clazz, Method) with 'className', 'nameAndTypeIndex', 'referencedClass', 'referencedMethod'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addInterfaceMethodrefConstant(String, int, Clazz, Method)"
  })
  void
      testAddInterfaceMethodrefConstantWithClassNameNameAndTypeIndexReferencedClassReferencedMethod5() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};

    ConstantPoolEditor constantPoolEditor =
        new ConstantPoolEditor(new ProgramClass(1, 1, constantPool, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();
    LibraryField referencedField = new LibraryField(1, "Name", "Descriptor");

    constantPoolEditor.addFieldrefConstant(
        "Class Name", "Name", "Descriptor", referencedClass, referencedField);
    LibraryClass referencedClass2 = new LibraryClass();
    LibraryMethod referencedMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    int actualAddInterfaceMethodrefConstantResult =
        constantPoolEditor.addInterfaceMethodrefConstant(
            "Class Name", 1, referencedClass2, referencedMethod);

    // Assert
    ProgramClass targetClass = constantPoolEditor.getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    Constant constant = constantArray[7];
    assertTrue(constant instanceof InterfaceMethodrefConstant);
    assertNull(constant.getProcessingInfo());
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(1, ((InterfaceMethodrefConstant) constant).getNameAndTypeIndex());
    assertEquals(11, constant.getTag());
    assertEquals(17, constantArray.length);
    assertEquals(5, ((InterfaceMethodrefConstant) constant).getClassIndex());
    assertEquals(7, actualAddInterfaceMethodrefConstantResult);
    assertEquals(8, targetClass.u2constantPoolCount);
    assertFalse(constant.isCategory2());
    assertSame(referencedClass2, ((InterfaceMethodrefConstant) constant).referencedClass);
    assertSame(referencedMethod, ((InterfaceMethodrefConstant) constant).referencedMethod);
  }

  /**
   * Test {@link ConstantPoolEditor#addInterfaceMethodrefConstant(String, String, String, Clazz,
   * Method)} with {@code className}, {@code name}, {@code descriptor}, {@code referencedClass},
   * {@code referencedMethod}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addInterfaceMethodrefConstant(String, String,
   * String, Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test addInterfaceMethodrefConstant(String, String, String, Clazz, Method) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedMethod'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addInterfaceMethodrefConstant(String, String, String, Clazz, Method)"
  })
  void
      testAddInterfaceMethodrefConstantWithClassNameNameDescriptorReferencedClassReferencedMethod() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 1, constantPool, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();
    LibraryMethod referencedMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(
        6,
        constantPoolEditor.addInterfaceMethodrefConstant(
            "Class Name", "Name", "Descriptor", referencedClass, referencedMethod));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(7, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addInterfaceMethodrefConstant(String, String, String, Clazz,
   * Method)} with {@code className}, {@code name}, {@code descriptor}, {@code referencedClass},
   * {@code referencedMethod}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addInterfaceMethodrefConstant(String, String,
   * String, Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test addInterfaceMethodrefConstant(String, String, String, Clazz, Method) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedMethod'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addInterfaceMethodrefConstant(String, String, String, Clazz, Method)"
  })
  void
      testAddInterfaceMethodrefConstantWithClassNameNameDescriptorReferencedClassReferencedMethod2() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 0, constantPool, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();
    LibraryMethod referencedMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(
        5,
        constantPoolEditor.addInterfaceMethodrefConstant(
            "Class Name", "Name", "Descriptor", referencedClass, referencedMethod));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(6, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addInterfaceMethodrefConstant(String, String, String, Clazz,
   * Method)} with {@code className}, {@code name}, {@code descriptor}, {@code referencedClass},
   * {@code referencedMethod}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addInterfaceMethodrefConstant(String, String,
   * String, Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test addInterfaceMethodrefConstant(String, String, String, Clazz, Method) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedMethod'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addInterfaceMethodrefConstant(String, String, String, Clazz, Method)"
  })
  void
      testAddInterfaceMethodrefConstantWithClassNameNameDescriptorReferencedClassReferencedMethod3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();
    LibraryMethod referencedMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(
        8,
        constantPoolEditor.addInterfaceMethodrefConstant(
            "Class Name", "Name", "Descriptor", referencedClass, referencedMethod));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(9, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addInterfaceMethodrefConstant(String, String, String, Clazz,
   * Method)} with {@code className}, {@code name}, {@code descriptor}, {@code referencedClass},
   * {@code referencedMethod}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addInterfaceMethodrefConstant(String, String,
   * String, Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test addInterfaceMethodrefConstant(String, String, String, Clazz, Method) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedMethod'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addInterfaceMethodrefConstant(String, String, String, Clazz, Method)"
  })
  void
      testAddInterfaceMethodrefConstantWithClassNameNameDescriptorReferencedClassReferencedMethod4() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};

    ConstantPoolEditor constantPoolEditor =
        new ConstantPoolEditor(new ProgramClass(1, 3, constantPool, 1, 1, 1));
    constantPoolEditor.addConstant(new ClassConstant());
    LibraryClass referencedClass = new LibraryClass();
    LibraryMethod referencedMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    int actualAddInterfaceMethodrefConstantResult =
        constantPoolEditor.addInterfaceMethodrefConstant(
            "Class Name", "Name", "Descriptor", referencedClass, referencedMethod);

    // Assert
    ProgramClass targetClass = constantPoolEditor.getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[8] instanceof ClassConstant);
    assertTrue(constantArray[9] instanceof InterfaceMethodrefConstant);
    assertTrue(constantArray[6] instanceof NameAndTypeConstant);
    assertTrue(constantArray[7] instanceof Utf8Constant);
    assertEquals(10, targetClass.u2constantPoolCount);
    assertEquals(19, constantArray.length);
    assertEquals(9, actualAddInterfaceMethodrefConstantResult);
  }

  /**
   * Test {@link ConstantPoolEditor#addInterfaceMethodrefConstant(String, String, String, Clazz,
   * Method)} with {@code className}, {@code name}, {@code descriptor}, {@code referencedClass},
   * {@code referencedMethod}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addInterfaceMethodrefConstant(String, String,
   * String, Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test addInterfaceMethodrefConstant(String, String, String, Clazz, Method) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedMethod'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addInterfaceMethodrefConstant(String, String, String, Clazz, Method)"
  })
  void
      testAddInterfaceMethodrefConstantWithClassNameNameDescriptorReferencedClassReferencedMethod5()
          throws UnsupportedEncodingException {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};

    ConstantPoolEditor constantPoolEditor =
        new ConstantPoolEditor(new ProgramClass(1, 1, constantPool, 1, 1, 1));
    constantPoolEditor.addInvokeDynamicConstant(
        1, "Name", "Descriptor", new Clazz[] {new LibraryClass()});
    LibraryClass referencedClass = new LibraryClass();
    LibraryMethod referencedMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    constantPoolEditor.addInterfaceMethodrefConstant(
        "Class Name", "Name", "Descriptor", referencedClass, referencedMethod);

    // Assert
    Constant[] constantArray = constantPoolEditor.getTargetClass().constantPool;
    Constant constant = constantArray[6];
    assertTrue(constant instanceof ClassConstant);
    Constant constant2 = constantArray[7];
    assertTrue(constant2 instanceof InterfaceMethodrefConstant);
    Constant constant3 = constantArray[5];
    assertTrue(constant3 instanceof Utf8Constant);
    assertEquals("Class Name", ((Utf8Constant) constant3).getString());
    assertNull(((ClassConstant) constant).javaLangClassClass);
    assertEquals(17, constantArray.length);
    assertEquals(5, ((ClassConstant) constant).u2nameIndex);
    assertEquals(6, ((InterfaceMethodrefConstant) constant2).getClassIndex());
    assertEquals(7, constant.getTag());
    assertFalse(constant.isCategory2());
    assertArrayEquals("Class Name".getBytes("UTF-8"), ((Utf8Constant) constant3).getBytes());
  }

  /**
   * Test {@link ConstantPoolEditor#addInterfaceMethodrefConstant(String, String, String, Clazz,
   * Method)} with {@code className}, {@code name}, {@code descriptor}, {@code referencedClass},
   * {@code referencedMethod}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addInterfaceMethodrefConstant(String, String,
   * String, Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test addInterfaceMethodrefConstant(String, String, String, Clazz, Method) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedMethod'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addInterfaceMethodrefConstant(String, String, String, Clazz, Method)"
  })
  void
      testAddInterfaceMethodrefConstantWithClassNameNameDescriptorReferencedClassReferencedMethod6() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};

    ConstantPoolEditor constantPoolEditor =
        new ConstantPoolEditor(new ProgramClass(1, 1, constantPool, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();
    LibraryField referencedField = new LibraryField(1, "Name", "Descriptor");

    constantPoolEditor.addFieldrefConstant(
        "Class Name", "Name", "Descriptor", referencedClass, referencedField);
    LibraryClass referencedClass2 = new LibraryClass();
    LibraryMethod referencedMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    constantPoolEditor.addInterfaceMethodrefConstant(
        "Class Name", "Name", "Descriptor", referencedClass2, referencedMethod);

    // Assert
    Constant[] constantArray = constantPoolEditor.getTargetClass().constantPool;
    assertTrue(constantArray[5] instanceof ClassConstant);
    assertTrue(constantArray[6] instanceof FieldrefConstant);
    Constant constant = constantArray[7];
    assertTrue(constant instanceof InterfaceMethodrefConstant);
    assertEquals(17, constantArray.length);
    assertEquals(5, ((InterfaceMethodrefConstant) constant).getClassIndex());
  }

  /**
   * Test {@link ConstantPoolEditor#addInterfaceMethodrefConstant(Clazz, Method)} with {@code
   * referencedClass}, {@code referencedMethod}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addInterfaceMethodrefConstant(Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test addInterfaceMethodrefConstant(Clazz, Method) with 'referencedClass', 'referencedMethod'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addInterfaceMethodrefConstant(Clazz, Method)"})
  void testAddInterfaceMethodrefConstantWithReferencedClassReferencedMethod() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 1, constantPool, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass(1, "This Class Name", "Super Class Name");
    LibraryMethod referencedMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(
        6, constantPoolEditor.addInterfaceMethodrefConstant(referencedClass, referencedMethod));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(7, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addMethodrefConstant(int, int, Clazz, Method)} with {@code
   * classIndex}, {@code nameAndTypeIndex}, {@code referencedClass}, {@code referencedMethod}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addMethodrefConstant(int, int, Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test addMethodrefConstant(int, int, Clazz, Method) with 'classIndex', 'nameAndTypeIndex', 'referencedClass', 'referencedMethod'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addMethodrefConstant(int, int, Clazz, Method)"})
  void testAddMethodrefConstantWithClassIndexNameAndTypeIndexReferencedClassReferencedMethod() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(10, 1, constantPool, 10, 10, 10);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();
    LibraryMethod referencedMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(
        1, constantPoolEditor.addMethodrefConstant(1, 1, referencedClass, referencedMethod));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(2, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addMethodrefConstant(int, int, Clazz, Method)} with {@code
   * classIndex}, {@code nameAndTypeIndex}, {@code referencedClass}, {@code referencedMethod}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addMethodrefConstant(int, int, Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test addMethodrefConstant(int, int, Clazz, Method) with 'classIndex', 'nameAndTypeIndex', 'referencedClass', 'referencedMethod'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addMethodrefConstant(int, int, Clazz, Method)"})
  void testAddMethodrefConstantWithClassIndexNameAndTypeIndexReferencedClassReferencedMethod2() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(10, 0, constantPool, 10, 10, 10);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();
    LibraryMethod referencedMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(
        0, constantPoolEditor.addMethodrefConstant(1, 1, referencedClass, referencedMethod));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(1, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addMethodrefConstant(int, int, Clazz, Method)} with {@code
   * classIndex}, {@code nameAndTypeIndex}, {@code referencedClass}, {@code referencedMethod}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addMethodrefConstant(int, int, Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test addMethodrefConstant(int, int, Clazz, Method) with 'classIndex', 'nameAndTypeIndex', 'referencedClass', 'referencedMethod'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addMethodrefConstant(int, int, Clazz, Method)"})
  void testAddMethodrefConstantWithClassIndexNameAndTypeIndexReferencedClassReferencedMethod3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(
            10, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 10, 10, 10);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();
    LibraryMethod referencedMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(
        3, constantPoolEditor.addMethodrefConstant(1, 1, referencedClass, referencedMethod));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(4, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addMethodrefConstant(int, String, String, Clazz, Method)} with
   * {@code classIndex}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedMethod}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addMethodrefConstant(int, String, String,
   * Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test addMethodrefConstant(int, String, String, Clazz, Method) with 'classIndex', 'name', 'descriptor', 'referencedClass', 'referencedMethod'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addMethodrefConstant(int, String, String, Clazz, Method)"
  })
  void testAddMethodrefConstantWithClassIndexNameDescriptorReferencedClassReferencedMethod() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 1, constantPool, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();
    LibraryMethod referencedMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(
        4,
        constantPoolEditor.addMethodrefConstant(
            1, "Name", "Descriptor", referencedClass, referencedMethod));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(5, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addMethodrefConstant(int, String, String, Clazz, Method)} with
   * {@code classIndex}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedMethod}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addMethodrefConstant(int, String, String,
   * Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test addMethodrefConstant(int, String, String, Clazz, Method) with 'classIndex', 'name', 'descriptor', 'referencedClass', 'referencedMethod'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addMethodrefConstant(int, String, String, Clazz, Method)"
  })
  void testAddMethodrefConstantWithClassIndexNameDescriptorReferencedClassReferencedMethod2() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 0, constantPool, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();
    LibraryMethod referencedMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(
        3,
        constantPoolEditor.addMethodrefConstant(
            1, "Name", "Descriptor", referencedClass, referencedMethod));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(4, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addMethodrefConstant(int, String, String, Clazz, Method)} with
   * {@code classIndex}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedMethod}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addMethodrefConstant(int, String, String,
   * Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test addMethodrefConstant(int, String, String, Clazz, Method) with 'classIndex', 'name', 'descriptor', 'referencedClass', 'referencedMethod'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addMethodrefConstant(int, String, String, Clazz, Method)"
  })
  void testAddMethodrefConstantWithClassIndexNameDescriptorReferencedClassReferencedMethod3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();
    LibraryMethod referencedMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(
        6,
        constantPoolEditor.addMethodrefConstant(
            1, "Name", "Descriptor", referencedClass, referencedMethod));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(7, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addMethodrefConstant(String, int, Clazz, Method)} with {@code
   * className}, {@code nameAndTypeIndex}, {@code referencedClass}, {@code referencedMethod}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addMethodrefConstant(String, int, Clazz,
   * Method)}
   */
  @Test
  @DisplayName(
      "Test addMethodrefConstant(String, int, Clazz, Method) with 'className', 'nameAndTypeIndex', 'referencedClass', 'referencedMethod'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addMethodrefConstant(String, int, Clazz, Method)"})
  void testAddMethodrefConstantWithClassNameNameAndTypeIndexReferencedClassReferencedMethod() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 1, constantPool, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();
    LibraryMethod referencedMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(
        3,
        constantPoolEditor.addMethodrefConstant(
            "Class Name", 1, referencedClass, referencedMethod));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(4, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addMethodrefConstant(String, int, Clazz, Method)} with {@code
   * className}, {@code nameAndTypeIndex}, {@code referencedClass}, {@code referencedMethod}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addMethodrefConstant(String, int, Clazz,
   * Method)}
   */
  @Test
  @DisplayName(
      "Test addMethodrefConstant(String, int, Clazz, Method) with 'className', 'nameAndTypeIndex', 'referencedClass', 'referencedMethod'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addMethodrefConstant(String, int, Clazz, Method)"})
  void testAddMethodrefConstantWithClassNameNameAndTypeIndexReferencedClassReferencedMethod2() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 0, constantPool, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();
    LibraryMethod referencedMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    int actualAddMethodrefConstantResult =
        constantPoolEditor.addMethodrefConstant("Class Name", 1, referencedClass, referencedMethod);

    // Assert
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals("Class Name", targetClass2.getName());
    assertEquals("Class Name", targetClass2.getSuperName());
    assertEquals(2, actualAddMethodrefConstantResult);
    assertEquals(3, targetClass2.u2constantPoolCount);
    assertSame(referencedClass, targetClass2.getSuperClass());
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addMethodrefConstant(String, int, Clazz, Method)} with {@code
   * className}, {@code nameAndTypeIndex}, {@code referencedClass}, {@code referencedMethod}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addMethodrefConstant(String, int, Clazz,
   * Method)}
   */
  @Test
  @DisplayName(
      "Test addMethodrefConstant(String, int, Clazz, Method) with 'className', 'nameAndTypeIndex', 'referencedClass', 'referencedMethod'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addMethodrefConstant(String, int, Clazz, Method)"})
  void testAddMethodrefConstantWithClassNameNameAndTypeIndexReferencedClassReferencedMethod3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();
    LibraryMethod referencedMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(
        5,
        constantPoolEditor.addMethodrefConstant(
            "Class Name", 1, referencedClass, referencedMethod));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(6, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addMethodrefConstant(String, int, Clazz, Method)} with {@code
   * className}, {@code nameAndTypeIndex}, {@code referencedClass}, {@code referencedMethod}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addMethodrefConstant(String, int, Clazz,
   * Method)}
   */
  @Test
  @DisplayName(
      "Test addMethodrefConstant(String, int, Clazz, Method) with 'className', 'nameAndTypeIndex', 'referencedClass', 'referencedMethod'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addMethodrefConstant(String, int, Clazz, Method)"})
  void testAddMethodrefConstantWithClassNameNameAndTypeIndexReferencedClassReferencedMethod4() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};

    ConstantPoolEditor constantPoolEditor =
        new ConstantPoolEditor(new ProgramClass(1, 3, constantPool, 1, 1, 1));
    constantPoolEditor.addConstant(new ClassConstant());
    LibraryClass referencedClass = new LibraryClass();
    LibraryMethod referencedMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    int actualAddMethodrefConstantResult =
        constantPoolEditor.addMethodrefConstant("Class Name", 1, referencedClass, referencedMethod);

    // Assert
    ProgramClass targetClass = constantPoolEditor.getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[5] instanceof ClassConstant);
    assertTrue(constantArray[6] instanceof MethodrefConstant);
    assertTrue(constantArray[4] instanceof Utf8Constant);
    assertEquals(19, constantArray.length);
    assertEquals(6, actualAddMethodrefConstantResult);
    assertEquals(7, targetClass.u2constantPoolCount);
  }

  /**
   * Test {@link ConstantPoolEditor#addMethodrefConstant(String, int, Clazz, Method)} with {@code
   * className}, {@code nameAndTypeIndex}, {@code referencedClass}, {@code referencedMethod}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addMethodrefConstant(String, int, Clazz,
   * Method)}
   */
  @Test
  @DisplayName(
      "Test addMethodrefConstant(String, int, Clazz, Method) with 'className', 'nameAndTypeIndex', 'referencedClass', 'referencedMethod'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addMethodrefConstant(String, int, Clazz, Method)"})
  void testAddMethodrefConstantWithClassNameNameAndTypeIndexReferencedClassReferencedMethod5() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};

    ConstantPoolEditor constantPoolEditor =
        new ConstantPoolEditor(new ProgramClass(1, 1, constantPool, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();
    LibraryField referencedField = new LibraryField(1, "Name", "Descriptor");

    constantPoolEditor.addFieldrefConstant(
        "Class Name", "Name", "Descriptor", referencedClass, referencedField);
    LibraryClass referencedClass2 = new LibraryClass();
    LibraryMethod referencedMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    int actualAddMethodrefConstantResult =
        constantPoolEditor.addMethodrefConstant(
            "Class Name", 1, referencedClass2, referencedMethod);

    // Assert
    ProgramClass targetClass = constantPoolEditor.getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    Constant constant = constantArray[7];
    assertTrue(constant instanceof MethodrefConstant);
    assertNull(constant.getProcessingInfo());
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(1, ((MethodrefConstant) constant).getNameAndTypeIndex());
    assertEquals(10, constant.getTag());
    assertEquals(17, constantArray.length);
    assertEquals(5, ((MethodrefConstant) constant).getClassIndex());
    assertEquals(7, actualAddMethodrefConstantResult);
    assertEquals(8, targetClass.u2constantPoolCount);
    assertFalse(constant.isCategory2());
    assertSame(referencedClass2, ((MethodrefConstant) constant).referencedClass);
    assertSame(referencedMethod, ((MethodrefConstant) constant).referencedMethod);
  }

  /**
   * Test {@link ConstantPoolEditor#addMethodrefConstant(String, String, String, Clazz, Method)}
   * with {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedMethod}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addMethodrefConstant(String, String, String,
   * Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test addMethodrefConstant(String, String, String, Clazz, Method) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedMethod'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addMethodrefConstant(String, String, String, Clazz, Method)"
  })
  void testAddMethodrefConstantWithClassNameNameDescriptorReferencedClassReferencedMethod() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 1, constantPool, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();
    LibraryMethod referencedMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(
        6,
        constantPoolEditor.addMethodrefConstant(
            "Class Name", "Name", "Descriptor", referencedClass, referencedMethod));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(7, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addMethodrefConstant(String, String, String, Clazz, Method)}
   * with {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedMethod}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addMethodrefConstant(String, String, String,
   * Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test addMethodrefConstant(String, String, String, Clazz, Method) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedMethod'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addMethodrefConstant(String, String, String, Clazz, Method)"
  })
  void testAddMethodrefConstantWithClassNameNameDescriptorReferencedClassReferencedMethod2() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 0, constantPool, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();
    LibraryMethod referencedMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(
        5,
        constantPoolEditor.addMethodrefConstant(
            "Class Name", "Name", "Descriptor", referencedClass, referencedMethod));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(6, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addMethodrefConstant(String, String, String, Clazz, Method)}
   * with {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedMethod}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addMethodrefConstant(String, String, String,
   * Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test addMethodrefConstant(String, String, String, Clazz, Method) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedMethod'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addMethodrefConstant(String, String, String, Clazz, Method)"
  })
  void testAddMethodrefConstantWithClassNameNameDescriptorReferencedClassReferencedMethod3() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();
    LibraryMethod referencedMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(
        8,
        constantPoolEditor.addMethodrefConstant(
            "Class Name", "Name", "Descriptor", referencedClass, referencedMethod));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(9, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addMethodrefConstant(String, String, String, Clazz, Method)}
   * with {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedMethod}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addMethodrefConstant(String, String, String,
   * Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test addMethodrefConstant(String, String, String, Clazz, Method) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedMethod'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addMethodrefConstant(String, String, String, Clazz, Method)"
  })
  void testAddMethodrefConstantWithClassNameNameDescriptorReferencedClassReferencedMethod4() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};

    ConstantPoolEditor constantPoolEditor =
        new ConstantPoolEditor(new ProgramClass(1, 3, constantPool, 1, 1, 1));
    constantPoolEditor.addConstant(new ClassConstant());
    LibraryClass referencedClass = new LibraryClass();
    LibraryMethod referencedMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    int actualAddMethodrefConstantResult =
        constantPoolEditor.addMethodrefConstant(
            "Class Name", "Name", "Descriptor", referencedClass, referencedMethod);

    // Assert
    ProgramClass targetClass = constantPoolEditor.getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[8] instanceof ClassConstant);
    assertTrue(constantArray[9] instanceof MethodrefConstant);
    assertTrue(constantArray[6] instanceof NameAndTypeConstant);
    assertTrue(constantArray[7] instanceof Utf8Constant);
    assertEquals(10, targetClass.u2constantPoolCount);
    assertEquals(19, constantArray.length);
    assertEquals(9, actualAddMethodrefConstantResult);
  }

  /**
   * Test {@link ConstantPoolEditor#addMethodrefConstant(String, String, String, Clazz, Method)}
   * with {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedMethod}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addMethodrefConstant(String, String, String,
   * Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test addMethodrefConstant(String, String, String, Clazz, Method) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedMethod'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addMethodrefConstant(String, String, String, Clazz, Method)"
  })
  void testAddMethodrefConstantWithClassNameNameDescriptorReferencedClassReferencedMethod5()
      throws UnsupportedEncodingException {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};

    ConstantPoolEditor constantPoolEditor =
        new ConstantPoolEditor(new ProgramClass(1, 1, constantPool, 1, 1, 1));
    constantPoolEditor.addInvokeDynamicConstant(
        1, "Name", "Descriptor", new Clazz[] {new LibraryClass()});
    LibraryClass referencedClass = new LibraryClass();
    LibraryMethod referencedMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    constantPoolEditor.addMethodrefConstant(
        "Class Name", "Name", "Descriptor", referencedClass, referencedMethod);

    // Assert
    Constant[] constantArray = constantPoolEditor.getTargetClass().constantPool;
    Constant constant = constantArray[6];
    assertTrue(constant instanceof ClassConstant);
    Constant constant2 = constantArray[7];
    assertTrue(constant2 instanceof MethodrefConstant);
    Constant constant3 = constantArray[5];
    assertTrue(constant3 instanceof Utf8Constant);
    assertEquals("Class Name", ((Utf8Constant) constant3).getString());
    assertNull(((ClassConstant) constant).javaLangClassClass);
    assertEquals(17, constantArray.length);
    assertEquals(5, ((ClassConstant) constant).u2nameIndex);
    assertEquals(6, ((MethodrefConstant) constant2).getClassIndex());
    assertEquals(7, constant.getTag());
    assertFalse(constant.isCategory2());
    assertArrayEquals("Class Name".getBytes("UTF-8"), ((Utf8Constant) constant3).getBytes());
  }

  /**
   * Test {@link ConstantPoolEditor#addMethodrefConstant(String, String, String, Clazz, Method)}
   * with {@code className}, {@code name}, {@code descriptor}, {@code referencedClass}, {@code
   * referencedMethod}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addMethodrefConstant(String, String, String,
   * Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test addMethodrefConstant(String, String, String, Clazz, Method) with 'className', 'name', 'descriptor', 'referencedClass', 'referencedMethod'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ConstantPoolEditor.addMethodrefConstant(String, String, String, Clazz, Method)"
  })
  void testAddMethodrefConstantWithClassNameNameDescriptorReferencedClassReferencedMethod6() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};

    ConstantPoolEditor constantPoolEditor =
        new ConstantPoolEditor(new ProgramClass(1, 1, constantPool, 1, 1, 1));
    LibraryClass referencedClass = new LibraryClass();
    LibraryField referencedField = new LibraryField(1, "Name", "Descriptor");

    constantPoolEditor.addFieldrefConstant(
        "Class Name", "Name", "Descriptor", referencedClass, referencedField);
    LibraryClass referencedClass2 = new LibraryClass();
    LibraryMethod referencedMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Act
    constantPoolEditor.addMethodrefConstant(
        "Class Name", "Name", "Descriptor", referencedClass2, referencedMethod);

    // Assert
    Constant[] constantArray = constantPoolEditor.getTargetClass().constantPool;
    assertTrue(constantArray[5] instanceof ClassConstant);
    assertTrue(constantArray[6] instanceof FieldrefConstant);
    Constant constant = constantArray[7];
    assertTrue(constant instanceof MethodrefConstant);
    assertEquals(17, constantArray.length);
    assertEquals(5, ((MethodrefConstant) constant).getClassIndex());
  }

  /**
   * Test {@link ConstantPoolEditor#addMethodrefConstant(Clazz, Method)} with {@code
   * referencedClass}, {@code referencedMethod}.
   *
   * <ul>
   *   <li>Then return six.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addMethodrefConstant(Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test addMethodrefConstant(Clazz, Method) with 'referencedClass', 'referencedMethod'; then return six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addMethodrefConstant(Clazz, Method)"})
  void testAddMethodrefConstantWithReferencedClassReferencedMethod_thenReturnSix() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 1, constantPool, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass(1, "This Class Name", "Super Class Name");
    LibraryMethod referencedMethod = new LibraryMethod(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(6, constantPoolEditor.addMethodrefConstant(referencedClass, referencedMethod));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(7, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addClassConstant(int, Clazz)} with {@code nameIndex}, {@code
   * referencedClass}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addClassConstant(int, Clazz)}
   */
  @Test
  @DisplayName("Test addClassConstant(int, Clazz) with 'nameIndex', 'referencedClass'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addClassConstant(int, Clazz)"})
  void testAddClassConstantWithNameIndexReferencedClass() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};

    ConstantPoolEditor constantPoolEditor =
        new ConstantPoolEditor(new ProgramClass(7, 1, constantPool, 7, 7, 7));
    LibraryClass referencedClass = new LibraryClass();
    LibraryField referencedField = new LibraryField(1, "Name", "Descriptor");

    constantPoolEditor.addFieldrefConstant("Class Name", 1, referencedClass, referencedField);

    // Act
    int actualAddClassConstantResult = constantPoolEditor.addClassConstant(1, new LibraryClass());

    // Assert
    ProgramClass targetClass = constantPoolEditor.getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[3] instanceof FieldrefConstant);
    assertTrue(constantArray[1] instanceof Utf8Constant);
    assertEquals(17, constantArray.length);
    assertEquals(2, actualAddClassConstantResult);
    assertEquals(4, targetClass.u2constantPoolCount);
  }

  /**
   * Test {@link ConstantPoolEditor#addClassConstant(int, Clazz)} with {@code nameIndex}, {@code
   * referencedClass}.
   *
   * <ul>
   *   <li>Then fifth element {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addClassConstant(int, Clazz)}
   */
  @Test
  @DisplayName(
      "Test addClassConstant(int, Clazz) with 'nameIndex', 'referencedClass'; then fifth element ClassConstant")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addClassConstant(int, Clazz)"})
  void testAddClassConstantWithNameIndexReferencedClass_thenFifthElementClassConstant() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};

    ConstantPoolEditor constantPoolEditor =
        new ConstantPoolEditor(new ProgramClass(7, 3, constantPool, 7, 7, 7));
    constantPoolEditor.addConstant(new ClassConstant());
    LibraryClass referencedClass = new LibraryClass();

    // Act
    int actualAddClassConstantResult = constantPoolEditor.addClassConstant(1, referencedClass);

    // Assert
    ProgramClass targetClass = constantPoolEditor.getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    Constant constant = constantArray[4];
    assertTrue(constant instanceof ClassConstant);
    assertNull(constant.getProcessingInfo());
    assertNull(((ClassConstant) constant).javaLangClassClass);
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(1, ((ClassConstant) constant).u2nameIndex);
    assertEquals(19, constantArray.length);
    assertEquals(4, actualAddClassConstantResult);
    assertEquals(5, targetClass.u2constantPoolCount);
    assertEquals(7, constant.getTag());
    assertFalse(constant.isCategory2());
    assertSame(referencedClass, ((ClassConstant) constant).referencedClass);
  }

  /**
   * Test {@link ConstantPoolEditor#addClassConstant(int, Clazz)} with {@code nameIndex}, {@code
   * referencedClass}.
   *
   * <ul>
   *   <li>Then first element {@link ClassConstant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addClassConstant(int, Clazz)}
   */
  @Test
  @DisplayName(
      "Test addClassConstant(int, Clazz) with 'nameIndex', 'referencedClass'; then first element ClassConstant")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addClassConstant(int, Clazz)"})
  void testAddClassConstantWithNameIndexReferencedClass_thenFirstElementClassConstant() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ConstantPoolEditor constantPoolEditor =
        new ConstantPoolEditor(new ProgramClass(7, 0, constantPool, 7, 7, 7));
    LibraryClass referencedClass = new LibraryClass();

    // Act
    int actualAddClassConstantResult = constantPoolEditor.addClassConstant(1, referencedClass);

    // Assert
    ProgramClass targetClass = constantPoolEditor.getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    Constant constant = constantArray[0];
    assertTrue(constant instanceof ClassConstant);
    assertEquals(0, actualAddClassConstantResult);
    assertEquals(1, constantArray.length);
    assertEquals(1, targetClass.u2constantPoolCount);
    assertEquals(1, ((ClassConstant) constant).u2nameIndex);
    assertSame(referencedClass, ((ClassConstant) constant).referencedClass);
  }

  /**
   * Test {@link ConstantPoolEditor#addClassConstant(int, Clazz)} with {@code nameIndex}, {@code
   * referencedClass}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addClassConstant(int, Clazz)}
   */
  @Test
  @DisplayName(
      "Test addClassConstant(int, Clazz) with 'nameIndex', 'referencedClass'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addClassConstant(int, Clazz)"})
  void testAddClassConstantWithNameIndexReferencedClass_thenReturnOne() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(7, 1, constantPool, 7, 7, 7);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(1, constantPoolEditor.addClassConstant(1, new LibraryClass()));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(2, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addClassConstant(int, Clazz)} with {@code nameIndex}, {@code
   * referencedClass}.
   *
   * <ul>
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addClassConstant(int, Clazz)}
   */
  @Test
  @DisplayName(
      "Test addClassConstant(int, Clazz) with 'nameIndex', 'referencedClass'; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addClassConstant(int, Clazz)"})
  void testAddClassConstantWithNameIndexReferencedClass_thenReturnThree() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(
            7, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 7, 7, 7);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(3, constantPoolEditor.addClassConstant(1, new LibraryClass()));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(4, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addClassConstant(String, Clazz)} with {@code name}, {@code
   * referencedClass}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addClassConstant(String, Clazz)}
   */
  @Test
  @DisplayName("Test addClassConstant(String, Clazz) with 'name', 'referencedClass'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addClassConstant(String, Clazz)"})
  void testAddClassConstantWithNameReferencedClass() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 1, constantPool, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act
    constantPoolEditor.addClassConstant("Name", new LibraryClass());

    // Assert
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(3, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addClassConstant(String, Clazz)} with {@code name}, {@code
   * referencedClass}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addClassConstant(String, Clazz)}
   */
  @Test
  @DisplayName("Test addClassConstant(String, Clazz) with 'name', 'referencedClass'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addClassConstant(String, Clazz)"})
  void testAddClassConstantWithNameReferencedClass2() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 0, constantPool, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    int actualAddClassConstantResult = constantPoolEditor.addClassConstant("Name", referencedClass);

    // Assert
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals("Name", targetClass2.getName());
    assertEquals("Name", targetClass2.getSuperName());
    assertEquals(1, actualAddClassConstantResult);
    assertEquals(2, targetClass2.u2constantPoolCount);
    assertSame(referencedClass, targetClass2.getSuperClass());
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addClassConstant(String, Clazz)} with {@code name}, {@code
   * referencedClass}.
   *
   * <ul>
   *   <li>Then fifth element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addClassConstant(String, Clazz)}
   */
  @Test
  @DisplayName(
      "Test addClassConstant(String, Clazz) with 'name', 'referencedClass'; then fifth element is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addClassConstant(String, Clazz)"})
  void testAddClassConstantWithNameReferencedClass_thenFifthElementIsNull() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};

    ConstantPoolEditor constantPoolEditor =
        new ConstantPoolEditor(new ProgramClass(1, 1, constantPool, 1, 1, 1));
    constantPoolEditor.addClassConstant("Name", new LibraryClass());

    // Act
    int actualAddClassConstantResult =
        constantPoolEditor.addClassConstant("Name", new LibraryClass());

    // Assert
    ProgramClass targetClass = constantPoolEditor.getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertNull(constantArray[4]);
    assertEquals(17, constantArray.length);
    assertEquals(2, actualAddClassConstantResult);
    assertEquals(3, targetClass.u2constantPoolCount);
  }

  /**
   * Test {@link ConstantPoolEditor#addClassConstant(String, Clazz)} with {@code name}, {@code
   * referencedClass}.
   *
   * <ul>
   *   <li>Then fifth element {@link Utf8Constant}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addClassConstant(String, Clazz)}
   */
  @Test
  @DisplayName(
      "Test addClassConstant(String, Clazz) with 'name', 'referencedClass'; then fifth element Utf8Constant")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addClassConstant(String, Clazz)"})
  void testAddClassConstantWithNameReferencedClass_thenFifthElementUtf8Constant()
      throws UnsupportedEncodingException {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};

    ConstantPoolEditor constantPoolEditor =
        new ConstantPoolEditor(new ProgramClass(1, 3, constantPool, 1, 1, 1));
    constantPoolEditor.addConstant(new ClassConstant());

    // Act
    constantPoolEditor.addClassConstant("Name", new LibraryClass());

    // Assert
    Constant[] constantArray = constantPoolEditor.getTargetClass().constantPool;
    Constant constant = constantArray[5];
    assertTrue(constant instanceof ClassConstant);
    Constant constant2 = constantArray[4];
    assertTrue(constant2 instanceof Utf8Constant);
    assertEquals("Name", ((Utf8Constant) constant2).getString());
    assertEquals(1, constant2.getTag());
    assertEquals(19, constantArray.length);
    assertEquals(4, ((ClassConstant) constant).u2nameIndex);
    assertFalse(constant2.isCategory2());
    assertArrayEquals("Name".getBytes("UTF-8"), ((Utf8Constant) constant2).getBytes());
  }

  /**
   * Test {@link ConstantPoolEditor#addClassConstant(String, Clazz)} with {@code name}, {@code
   * referencedClass}.
   *
   * <ul>
   *   <li>Then return four.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addClassConstant(String, Clazz)}
   */
  @Test
  @DisplayName(
      "Test addClassConstant(String, Clazz) with 'name', 'referencedClass'; then return four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addClassConstant(String, Clazz)"})
  void testAddClassConstantWithNameReferencedClass_thenReturnFour() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(4, constantPoolEditor.addClassConstant("Name", new LibraryClass()));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(5, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addClassConstant(String, Clazz)} with {@code name}, {@code
   * referencedClass}.
   *
   * <ul>
   *   <li>Then sixth element ProcessingInfo is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addClassConstant(String, Clazz)}
   */
  @Test
  @DisplayName(
      "Test addClassConstant(String, Clazz) with 'name', 'referencedClass'; then sixth element ProcessingInfo is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addClassConstant(String, Clazz)"})
  void testAddClassConstantWithNameReferencedClass_thenSixthElementProcessingInfoIsNull() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};

    ConstantPoolEditor constantPoolEditor =
        new ConstantPoolEditor(new ProgramClass(1, 1, constantPool, 1, 1, 1));
    constantPoolEditor.addInvokeDynamicConstant(
        1, "Name", "Descriptor", new Clazz[] {new LibraryClass()});
    LibraryClass referencedClass = new LibraryClass();

    // Act
    int actualAddClassConstantResult = constantPoolEditor.addClassConstant("Name", referencedClass);

    // Assert
    ProgramClass targetClass = constantPoolEditor.getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    Constant constant = constantArray[5];
    assertTrue(constant instanceof ClassConstant);
    assertNull(constant.getProcessingInfo());
    assertNull(((ClassConstant) constant).javaLangClassClass);
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(1, ((ClassConstant) constant).u2nameIndex);
    assertEquals(17, constantArray.length);
    assertEquals(5, actualAddClassConstantResult);
    assertEquals(6, targetClass.u2constantPoolCount);
    assertEquals(7, constant.getTag());
    assertFalse(constant.isCategory2());
    assertSame(referencedClass, ((ClassConstant) constant).referencedClass);
  }

  /**
   * Test {@link ConstantPoolEditor#addClassConstant(Clazz)} with {@code referencedClass}.
   *
   * <ul>
   *   <li>Then return five.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addClassConstant(Clazz)}
   */
  @Test
  @DisplayName("Test addClassConstant(Clazz) with 'referencedClass'; then return five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addClassConstant(Clazz)"})
  void testAddClassConstantWithReferencedClass_thenReturnFive() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 3, constantPool, 1, 1, 1);

    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    constantPoolEditor.addConstant(new ClassConstant());

    // Act and Assert
    assertEquals(5, constantPoolEditor.addClassConstant(new LibraryClass()));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(6, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addClassConstant(Clazz)} with {@code referencedClass}.
   *
   * <ul>
   *   <li>Then return four.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addClassConstant(Clazz)}
   */
  @Test
  @DisplayName("Test addClassConstant(Clazz) with 'referencedClass'; then return four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addClassConstant(Clazz)"})
  void testAddClassConstantWithReferencedClass_thenReturnFour() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(4, constantPoolEditor.addClassConstant(new LibraryClass()));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(5, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addClassConstant(Clazz)} with {@code referencedClass}.
   *
   * <ul>
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addClassConstant(Clazz)}
   */
  @Test
  @DisplayName("Test addClassConstant(Clazz) with 'referencedClass'; then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addClassConstant(Clazz)"})
  void testAddClassConstantWithReferencedClass_thenReturnTwo() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 1, constantPool, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    LibraryClass referencedClass = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act
    int actualAddClassConstantResult = constantPoolEditor.addClassConstant(referencedClass);

    // Assert
    assertEquals(2, actualAddClassConstantResult);
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(3, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addClassConstant(Clazz)} with {@code referencedClass}.
   *
   * <ul>
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addClassConstant(Clazz)}
   */
  @Test
  @DisplayName("Test addClassConstant(Clazz) with 'referencedClass'; then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addClassConstant(Clazz)"})
  void testAddClassConstantWithReferencedClass_thenReturnTwo2() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 1, constantPool, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act
    int actualAddClassConstantResult =
        constantPoolEditor.addClassConstant(new NamedClass("Member Name"));

    // Assert
    assertEquals(2, actualAddClassConstantResult);
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(3, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addMethodTypeConstant(int, Clazz[])} with {@code
   * descriptorIndex}, {@code referencedClasses}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addMethodTypeConstant(int, Clazz[])}
   */
  @Test
  @DisplayName(
      "Test addMethodTypeConstant(int, Clazz[]) with 'descriptorIndex', 'referencedClasses'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addMethodTypeConstant(int, Clazz[])"})
  void testAddMethodTypeConstantWithDescriptorIndexReferencedClasses() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ConstantPoolEditor constantPoolEditor =
        new ConstantPoolEditor(
            new ProgramClass(
                ClassEstimates.TYPICAL_BOOTSTRAP_METHODS_ATTRIBUTE_SIZE,
                0,
                constantPool,
                ClassEstimates.TYPICAL_BOOTSTRAP_METHODS_ATTRIBUTE_SIZE,
                ClassEstimates.TYPICAL_BOOTSTRAP_METHODS_ATTRIBUTE_SIZE,
                ClassEstimates.TYPICAL_BOOTSTRAP_METHODS_ATTRIBUTE_SIZE));
    Clazz[] referencedClasses = new Clazz[] {new LibraryClass()};

    // Act
    int actualAddMethodTypeConstantResult =
        constantPoolEditor.addMethodTypeConstant(1, referencedClasses);

    // Assert
    ProgramClass targetClass = constantPoolEditor.getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    Constant constant = constantArray[0];
    assertTrue(constant instanceof MethodTypeConstant);
    assertNull(((MethodTypeConstant) constant).javaLangInvokeMethodTypeClass);
    assertEquals(0, actualAddMethodTypeConstantResult);
    assertEquals(1, ((MethodTypeConstant) constant).getDescriptorIndex());
    assertEquals(1, constantArray.length);
    assertEquals(1, targetClass.u2constantPoolCount);
    assertFalse(constant.isCategory2());
    assertEquals(ClassEstimates.TYPICAL_BOOTSTRAP_METHODS_ATTRIBUTE_SIZE, constant.getTag());
    assertSame(referencedClasses, ((MethodTypeConstant) constant).referencedClasses);
  }

  /**
   * Test {@link ConstantPoolEditor#addMethodTypeConstant(int, Clazz[])} with {@code
   * descriptorIndex}, {@code referencedClasses}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addMethodTypeConstant(int, Clazz[])}
   */
  @Test
  @DisplayName(
      "Test addMethodTypeConstant(int, Clazz[]) with 'descriptorIndex', 'referencedClasses'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addMethodTypeConstant(int, Clazz[])"})
  void testAddMethodTypeConstantWithDescriptorIndexReferencedClasses2() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};

    ConstantPoolEditor constantPoolEditor =
        new ConstantPoolEditor(
            new ProgramClass(
                ClassEstimates.TYPICAL_BOOTSTRAP_METHODS_ATTRIBUTE_SIZE,
                3,
                constantPool,
                ClassEstimates.TYPICAL_BOOTSTRAP_METHODS_ATTRIBUTE_SIZE,
                ClassEstimates.TYPICAL_BOOTSTRAP_METHODS_ATTRIBUTE_SIZE,
                ClassEstimates.TYPICAL_BOOTSTRAP_METHODS_ATTRIBUTE_SIZE));
    constantPoolEditor.addConstant(new ClassConstant());
    Clazz[] referencedClasses = new Clazz[] {new LibraryClass()};

    // Act
    int actualAddMethodTypeConstantResult =
        constantPoolEditor.addMethodTypeConstant(1, referencedClasses);

    // Assert
    ProgramClass targetClass = constantPoolEditor.getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    Constant constant = constantArray[4];
    assertTrue(constant instanceof MethodTypeConstant);
    assertNull(constant.getProcessingInfo());
    assertNull(((MethodTypeConstant) constant).javaLangInvokeMethodTypeClass);
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(1, ((MethodTypeConstant) constant).getDescriptorIndex());
    assertEquals(19, constantArray.length);
    assertEquals(4, actualAddMethodTypeConstantResult);
    assertEquals(5, targetClass.u2constantPoolCount);
    assertFalse(constant.isCategory2());
    assertEquals(ClassEstimates.TYPICAL_BOOTSTRAP_METHODS_ATTRIBUTE_SIZE, constant.getTag());
    assertSame(referencedClasses, ((MethodTypeConstant) constant).referencedClasses);
  }

  /**
   * Test {@link ConstantPoolEditor#addMethodTypeConstant(int, Clazz[])} with {@code
   * descriptorIndex}, {@code referencedClasses}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addMethodTypeConstant(int, Clazz[])}
   */
  @Test
  @DisplayName(
      "Test addMethodTypeConstant(int, Clazz[]) with 'descriptorIndex', 'referencedClasses'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addMethodTypeConstant(int, Clazz[])"})
  void testAddMethodTypeConstantWithDescriptorIndexReferencedClasses3() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};

    ConstantPoolEditor constantPoolEditor =
        new ConstantPoolEditor(
            new ProgramClass(
                ClassEstimates.TYPICAL_BOOTSTRAP_METHODS_ATTRIBUTE_SIZE,
                1,
                constantPool,
                ClassEstimates.TYPICAL_BOOTSTRAP_METHODS_ATTRIBUTE_SIZE,
                ClassEstimates.TYPICAL_BOOTSTRAP_METHODS_ATTRIBUTE_SIZE,
                ClassEstimates.TYPICAL_BOOTSTRAP_METHODS_ATTRIBUTE_SIZE));
    constantPoolEditor.addMethodTypeConstant("Descriptor", new Clazz[] {new LibraryClass()});

    // Act
    int actualAddMethodTypeConstantResult =
        constantPoolEditor.addMethodTypeConstant(1, new Clazz[] {new LibraryClass()});

    // Assert
    ProgramClass targetClass = constantPoolEditor.getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertTrue(constantArray[1] instanceof Utf8Constant);
    assertNull(constantArray[3]);
    assertEquals(17, constantArray.length);
    assertEquals(2, actualAddMethodTypeConstantResult);
    assertEquals(3, targetClass.u2constantPoolCount);
  }

  /**
   * Test {@link ConstantPoolEditor#addMethodTypeConstant(int, Clazz[])} with {@code
   * descriptorIndex}, {@code referencedClasses}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addMethodTypeConstant(int, Clazz[])}
   */
  @Test
  @DisplayName(
      "Test addMethodTypeConstant(int, Clazz[]) with 'descriptorIndex', 'referencedClasses'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addMethodTypeConstant(int, Clazz[])"})
  void testAddMethodTypeConstantWithDescriptorIndexReferencedClasses_thenReturnOne() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass =
        new ProgramClass(
            ClassEstimates.TYPICAL_BOOTSTRAP_METHODS_ATTRIBUTE_SIZE,
            1,
            constantPool,
            ClassEstimates.TYPICAL_BOOTSTRAP_METHODS_ATTRIBUTE_SIZE,
            ClassEstimates.TYPICAL_BOOTSTRAP_METHODS_ATTRIBUTE_SIZE,
            ClassEstimates.TYPICAL_BOOTSTRAP_METHODS_ATTRIBUTE_SIZE);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(1, constantPoolEditor.addMethodTypeConstant(1, new Clazz[] {new LibraryClass()}));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(2, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addMethodTypeConstant(int, Clazz[])} with {@code
   * descriptorIndex}, {@code referencedClasses}.
   *
   * <ul>
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addMethodTypeConstant(int, Clazz[])}
   */
  @Test
  @DisplayName(
      "Test addMethodTypeConstant(int, Clazz[]) with 'descriptorIndex', 'referencedClasses'; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addMethodTypeConstant(int, Clazz[])"})
  void testAddMethodTypeConstantWithDescriptorIndexReferencedClasses_thenReturnThree() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(
            ClassEstimates.TYPICAL_BOOTSTRAP_METHODS_ATTRIBUTE_SIZE,
            3,
            new Constant[] {classConstant, classConstant2, new ClassConstant()},
            ClassEstimates.TYPICAL_BOOTSTRAP_METHODS_ATTRIBUTE_SIZE,
            ClassEstimates.TYPICAL_BOOTSTRAP_METHODS_ATTRIBUTE_SIZE,
            ClassEstimates.TYPICAL_BOOTSTRAP_METHODS_ATTRIBUTE_SIZE);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(3, constantPoolEditor.addMethodTypeConstant(1, new Clazz[] {new LibraryClass()}));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(4, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addMethodTypeConstant(String, Clazz[])} with {@code descriptor},
   * {@code referencedClasses}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addMethodTypeConstant(String, Clazz[])}
   */
  @Test
  @DisplayName("Test addMethodTypeConstant(String, Clazz[]) with 'descriptor', 'referencedClasses'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addMethodTypeConstant(String, Clazz[])"})
  void testAddMethodTypeConstantWithDescriptorReferencedClasses() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 1, constantPool, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act
    constantPoolEditor.addMethodTypeConstant("Descriptor", new Clazz[] {new LibraryClass()});

    // Assert
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(3, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addMethodTypeConstant(String, Clazz[])} with {@code descriptor},
   * {@code referencedClasses}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addMethodTypeConstant(String, Clazz[])}
   */
  @Test
  @DisplayName("Test addMethodTypeConstant(String, Clazz[]) with 'descriptor', 'referencedClasses'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addMethodTypeConstant(String, Clazz[])"})
  void testAddMethodTypeConstantWithDescriptorReferencedClasses2()
      throws UnsupportedEncodingException {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};

    ConstantPoolEditor constantPoolEditor =
        new ConstantPoolEditor(new ProgramClass(1, 3, constantPool, 1, 1, 1));
    constantPoolEditor.addConstant(new ClassConstant());

    // Act
    constantPoolEditor.addMethodTypeConstant("Descriptor", new Clazz[] {new LibraryClass()});

    // Assert
    Constant[] constantArray = constantPoolEditor.getTargetClass().constantPool;
    Constant constant = constantArray[5];
    assertTrue(constant instanceof MethodTypeConstant);
    Constant constant2 = constantArray[4];
    assertTrue(constant2 instanceof Utf8Constant);
    assertEquals("Descriptor", ((Utf8Constant) constant2).getString());
    assertEquals(1, constant2.getTag());
    assertEquals(19, constantArray.length);
    assertEquals(4, ((MethodTypeConstant) constant).getDescriptorIndex());
    assertFalse(constant2.isCategory2());
    assertArrayEquals("Descriptor".getBytes("UTF-8"), ((Utf8Constant) constant2).getBytes());
  }

  /**
   * Test {@link ConstantPoolEditor#addMethodTypeConstant(String, Clazz[])} with {@code descriptor},
   * {@code referencedClasses}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addMethodTypeConstant(String, Clazz[])}
   */
  @Test
  @DisplayName("Test addMethodTypeConstant(String, Clazz[]) with 'descriptor', 'referencedClasses'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addMethodTypeConstant(String, Clazz[])"})
  void testAddMethodTypeConstantWithDescriptorReferencedClasses3() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};

    ConstantPoolEditor constantPoolEditor =
        new ConstantPoolEditor(new ProgramClass(1, 1, constantPool, 1, 1, 1));
    constantPoolEditor.addInvokeDynamicConstant(
        1, "Name", "Descriptor", new Clazz[] {new LibraryClass()});
    Clazz[] referencedClasses = new Clazz[] {new LibraryClass()};

    // Act
    int actualAddMethodTypeConstantResult =
        constantPoolEditor.addMethodTypeConstant("Descriptor", referencedClasses);

    // Assert
    ProgramClass targetClass = constantPoolEditor.getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    Constant constant = constantArray[5];
    assertTrue(constant instanceof MethodTypeConstant);
    assertNull(constant.getProcessingInfo());
    assertNull(((MethodTypeConstant) constant).javaLangInvokeMethodTypeClass);
    assertEquals(0, constant.getProcessingFlags());
    assertEquals(17, constantArray.length);
    assertEquals(2, ((MethodTypeConstant) constant).getDescriptorIndex());
    assertEquals(5, actualAddMethodTypeConstantResult);
    assertEquals(6, targetClass.u2constantPoolCount);
    assertFalse(constant.isCategory2());
    assertEquals(ClassEstimates.TYPICAL_BOOTSTRAP_METHODS_ATTRIBUTE_SIZE, constant.getTag());
    assertSame(referencedClasses, ((MethodTypeConstant) constant).referencedClasses);
  }

  /**
   * Test {@link ConstantPoolEditor#addMethodTypeConstant(String, Clazz[])} with {@code descriptor},
   * {@code referencedClasses}.
   *
   * <ul>
   *   <li>Then fifth element is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addMethodTypeConstant(String, Clazz[])}
   */
  @Test
  @DisplayName(
      "Test addMethodTypeConstant(String, Clazz[]) with 'descriptor', 'referencedClasses'; then fifth element is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addMethodTypeConstant(String, Clazz[])"})
  void testAddMethodTypeConstantWithDescriptorReferencedClasses_thenFifthElementIsNull() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};

    ConstantPoolEditor constantPoolEditor =
        new ConstantPoolEditor(new ProgramClass(1, 1, constantPool, 1, 1, 1));
    constantPoolEditor.addMethodTypeConstant("Descriptor", new Clazz[] {new LibraryClass()});

    // Act
    int actualAddMethodTypeConstantResult =
        constantPoolEditor.addMethodTypeConstant("Descriptor", new Clazz[] {new LibraryClass()});

    // Assert
    ProgramClass targetClass = constantPoolEditor.getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    assertNull(constantArray[4]);
    assertEquals(17, constantArray.length);
    assertEquals(2, actualAddMethodTypeConstantResult);
    assertEquals(3, targetClass.u2constantPoolCount);
  }

  /**
   * Test {@link ConstantPoolEditor#addMethodTypeConstant(String, Clazz[])} with {@code descriptor},
   * {@code referencedClasses}.
   *
   * <ul>
   *   <li>Then return four.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addMethodTypeConstant(String, Clazz[])}
   */
  @Test
  @DisplayName(
      "Test addMethodTypeConstant(String, Clazz[]) with 'descriptor', 'referencedClasses'; then return four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addMethodTypeConstant(String, Clazz[])"})
  void testAddMethodTypeConstantWithDescriptorReferencedClasses_thenReturnFour() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(
        4,
        constantPoolEditor.addMethodTypeConstant("Descriptor", new Clazz[] {new LibraryClass()}));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(5, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addMethodTypeConstant(String, Clazz[])} with {@code descriptor},
   * {@code referencedClasses}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addMethodTypeConstant(String, Clazz[])}
   */
  @Test
  @DisplayName(
      "Test addMethodTypeConstant(String, Clazz[]) with 'descriptor', 'referencedClasses'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addMethodTypeConstant(String, Clazz[])"})
  void testAddMethodTypeConstantWithDescriptorReferencedClasses_thenReturnOne() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 0, constantPool, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(
        1,
        constantPoolEditor.addMethodTypeConstant("Descriptor", new Clazz[] {new LibraryClass()}));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(2, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addNameAndTypeConstant(String, String)} with {@code name},
   * {@code descriptor}.
   *
   * <ul>
   *   <li>Then return five.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addNameAndTypeConstant(String, String)}
   */
  @Test
  @DisplayName(
      "Test addNameAndTypeConstant(String, String) with 'name', 'descriptor'; then return five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addNameAndTypeConstant(String, String)"})
  void testAddNameAndTypeConstantWithNameDescriptor_thenReturnFive() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(5, constantPoolEditor.addNameAndTypeConstant("Name", "Descriptor"));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(6, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addNameAndTypeConstant(String, String)} with {@code name},
   * {@code descriptor}.
   *
   * <ul>
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addNameAndTypeConstant(String, String)}
   */
  @Test
  @DisplayName(
      "Test addNameAndTypeConstant(String, String) with 'name', 'descriptor'; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addNameAndTypeConstant(String, String)"})
  void testAddNameAndTypeConstantWithNameDescriptor_thenReturnThree() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 1, constantPool, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(3, constantPoolEditor.addNameAndTypeConstant("Name", "Descriptor"));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(4, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addNameAndTypeConstant(String, String)} with {@code name},
   * {@code descriptor}.
   *
   * <ul>
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addNameAndTypeConstant(String, String)}
   */
  @Test
  @DisplayName(
      "Test addNameAndTypeConstant(String, String) with 'name', 'descriptor'; then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addNameAndTypeConstant(String, String)"})
  void testAddNameAndTypeConstantWithNameDescriptor_thenReturnTwo() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 0, constantPool, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(2, constantPoolEditor.addNameAndTypeConstant("Name", "Descriptor"));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(3, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addNameAndTypeConstant(int, int)} with {@code nameIndex}, {@code
   * descriptorIndex}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#addNameAndTypeConstant(int, int)}
   */
  @Test
  @DisplayName("Test addNameAndTypeConstant(int, int) with 'nameIndex', 'descriptorIndex'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addNameAndTypeConstant(int, int)"})
  void testAddNameAndTypeConstantWithNameIndexDescriptorIndex() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ConstantPoolEditor constantPoolEditor =
        new ConstantPoolEditor(new ProgramClass(12, 0, constantPool, 12, 12, 12));

    // Act
    int actualAddNameAndTypeConstantResult = constantPoolEditor.addNameAndTypeConstant(1, 1);

    // Assert
    ProgramClass targetClass = constantPoolEditor.getTargetClass();
    Constant[] constantArray = targetClass.constantPool;
    Constant constant = constantArray[0];
    assertTrue(constant instanceof NameAndTypeConstant);
    assertEquals(0, actualAddNameAndTypeConstantResult);
    assertEquals(1, constantArray.length);
    assertEquals(1, targetClass.u2constantPoolCount);
    assertEquals(12, constant.getTag());
    assertFalse(constant.isCategory2());
  }

  /**
   * Test {@link ConstantPoolEditor#addNameAndTypeConstant(int, int)} with {@code nameIndex}, {@code
   * descriptorIndex}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addNameAndTypeConstant(int, int)}
   */
  @Test
  @DisplayName(
      "Test addNameAndTypeConstant(int, int) with 'nameIndex', 'descriptorIndex'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addNameAndTypeConstant(int, int)"})
  void testAddNameAndTypeConstantWithNameIndexDescriptorIndex_thenReturnOne() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(12, 1, constantPool, 12, 12, 12);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(1, constantPoolEditor.addNameAndTypeConstant(1, 1));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(2, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addNameAndTypeConstant(int, int)} with {@code nameIndex}, {@code
   * descriptorIndex}.
   *
   * <ul>
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addNameAndTypeConstant(int, int)}
   */
  @Test
  @DisplayName(
      "Test addNameAndTypeConstant(int, int) with 'nameIndex', 'descriptorIndex'; then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addNameAndTypeConstant(int, int)"})
  void testAddNameAndTypeConstantWithNameIndexDescriptorIndex_thenReturnThree() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(
            12, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 12, 12, 12);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(3, constantPoolEditor.addNameAndTypeConstant(1, 1));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(4, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addNameAndTypeConstant(int, int)} with {@code nameIndex}, {@code
   * descriptorIndex}.
   *
   * <ul>
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addNameAndTypeConstant(int, int)}
   */
  @Test
  @DisplayName(
      "Test addNameAndTypeConstant(int, int) with 'nameIndex', 'descriptorIndex'; then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addNameAndTypeConstant(int, int)"})
  void testAddNameAndTypeConstantWithNameIndexDescriptorIndex_thenReturnTwo() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(12, 1, constantPool, 12, 12, 12);

    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    constantPoolEditor.addInvokeDynamicConstant(12, "42", "42", new Clazz[] {new LibraryClass()});

    // Act and Assert
    assertEquals(2, constantPoolEditor.addNameAndTypeConstant(1, 1));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(4, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addUtf8Constant(String)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addUtf8Constant(String)}
   */
  @Test
  @DisplayName("Test addUtf8Constant(String); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addUtf8Constant(String)"})
  void testAddUtf8Constant_thenReturnOne() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 1, constantPool, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(1, constantPoolEditor.addUtf8Constant("String"));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(2, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addUtf8Constant(String)}.
   *
   * <ul>
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addUtf8Constant(String)}
   */
  @Test
  @DisplayName("Test addUtf8Constant(String); then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addUtf8Constant(String)"})
  void testAddUtf8Constant_thenReturnThree() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(3, constantPoolEditor.addUtf8Constant("String"));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(4, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addUtf8Constant(String)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addUtf8Constant(String)}
   */
  @Test
  @DisplayName("Test addUtf8Constant(String); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addUtf8Constant(String)"})
  void testAddUtf8Constant_thenReturnZero() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(1, 0, constantPool, 1, 1, 1);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(0, constantPoolEditor.addUtf8Constant("String"));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(1, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#findOrAddConstant(Constant)}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#findOrAddConstant(Constant)}
   */
  @Test
  @DisplayName("Test findOrAddConstant(Constant)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.findOrAddConstant(Constant)"})
  void testFindOrAddConstant() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(7, 1, constantPool, 7, 7, 7);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act
    constantPoolEditor.findOrAddConstant(new ClassConstant());

    // Assert
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(2, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#findOrAddConstant(Constant)}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#findOrAddConstant(Constant)}
   */
  @Test
  @DisplayName("Test findOrAddConstant(Constant)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.findOrAddConstant(Constant)"})
  void testFindOrAddConstant2() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(7, 3, new Constant[] {classConstant, new ClassConstant()}, 7, 7, 7);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act
    constantPoolEditor.findOrAddConstant(new ClassConstant());

    // Assert that nothing has changed
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(3, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#findOrAddConstant(Constant)}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#findOrAddConstant(Constant)}
   */
  @Test
  @DisplayName("Test findOrAddConstant(Constant)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.findOrAddConstant(Constant)"})
  void testFindOrAddConstant3() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(7, 1, constantPool, 7, 7, 7);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act
    constantPoolEditor.findOrAddConstant(new DoubleConstant());

    // Assert
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(3, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#findOrAddConstant(Constant)}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#findOrAddConstant(Constant)}
   */
  @Test
  @DisplayName("Test findOrAddConstant(Constant)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.findOrAddConstant(Constant)"})
  void testFindOrAddConstant4() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(7, 1, constantPool, 7, 7, 7);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act
    constantPoolEditor.findOrAddConstant(new DynamicConstant());

    // Assert
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(2, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#findOrAddConstant(Constant)}.
   *
   * <ul>
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#findOrAddConstant(Constant)}
   */
  @Test
  @DisplayName("Test findOrAddConstant(Constant); then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.findOrAddConstant(Constant)"})
  void testFindOrAddConstant_thenReturnThree() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(7, 3, constantPool, 7, 7, 7);

    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);
    constantPoolEditor.addConstant(new ClassConstant());

    // Act and Assert
    assertEquals(3, constantPoolEditor.findOrAddConstant(new ClassConstant()));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(4, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#findOrAddConstant(Constant)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#findOrAddConstant(Constant)}
   */
  @Test
  @DisplayName("Test findOrAddConstant(Constant); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.findOrAddConstant(Constant)"})
  void testFindOrAddConstant_thenReturnZero() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(7, 0, constantPool, 7, 7, 7);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(0, constantPoolEditor.findOrAddConstant(new ClassConstant()));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    Constant[] constantArray = targetClass2.constantPool;
    assertEquals(1, constantArray.length);
    assertEquals(1, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, constantArray);
  }

  /**
   * Test {@link ConstantPoolEditor#addConstant(Constant)}.
   *
   * <ul>
   *   <li>Then return three.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addConstant(Constant)}
   */
  @Test
  @DisplayName("Test addConstant(Constant); then return three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addConstant(Constant)"})
  void testAddConstant_thenReturnThree() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(2, 3, constantPool, 2, 2, 2);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(3, constantPoolEditor.addConstant(new ClassConstant()));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(4, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }

  /**
   * Test {@link ConstantPoolEditor#addConstant(Constant)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#addConstant(Constant)}
   */
  @Test
  @DisplayName("Test addConstant(Constant); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ConstantPoolEditor.addConstant(Constant)"})
  void testAddConstant_thenReturnZero() {
    // Arrange
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass targetClass = new ProgramClass(2, 0, constantPool, 2, 2, 2);
    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(0, constantPoolEditor.addConstant(new ClassConstant()));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    Constant[] constantArray = targetClass2.constantPool;
    assertEquals(1, constantArray.length);
    assertEquals(1, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, constantArray);
  }
}
