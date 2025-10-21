package proguard.classfile.editor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.ClassPool;
import proguard.classfile.ProgramClass;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.kotlin.KotlinConstants;

public class ConstantPoolEditorDiffblueTest {
  /**
   * Test {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool, ClassPool,
   * boolean)}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool,
   * ClassPool, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolEditor.<init>(ProgramClass, ClassPool, ClassPool, boolean)"})
  public void testNewConstantPoolEditor() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass targetClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, classConstant2, new ClassConstant()}, 1, 1, 1);

    // Act and Assert
    assertSame(
        targetClass,
        (new ConstantPoolEditor(
                targetClass, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool, true))
            .getTargetClass());
  }

  /**
   * Test {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool, ClassPool)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ProgramClass#ProgramClass()} {@link ProgramClass#u2constantPoolCount} is one.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool,
   * ClassPool)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolEditor.<init>(ProgramClass, ClassPool, ClassPool)"})
  public void testNewConstantPoolEditor_givenOne_whenProgramClassU2constantPoolCountIsOne() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    targetClass.u2constantPoolCount = 1;

    // Act and Assert
    assertSame(
        targetClass,
        (new ConstantPoolEditor(targetClass, null, KotlinConstants.dummyClassPool))
            .getTargetClass());
  }

  /**
   * Test {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link ProgramClass#ProgramClass()} {@link ProgramClass#u2constantPoolCount} is two.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolEditor.<init>(ProgramClass)"})
  public void testNewConstantPoolEditor_givenTwo_whenProgramClassU2constantPoolCountIsTwo() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    targetClass.u2constantPoolCount = 2;

    // Act and Assert
    assertSame(targetClass, (new ConstantPoolEditor(targetClass)).getTargetClass());
  }

  /**
   * Test {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool, ClassPool)}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>When {@link ProgramClass#ProgramClass()} {@link ProgramClass#u2constantPoolCount} is two.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool,
   * ClassPool)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolEditor.<init>(ProgramClass, ClassPool, ClassPool)"})
  public void testNewConstantPoolEditor_givenTwo_whenProgramClassU2constantPoolCountIsTwo2() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    targetClass.u2constantPoolCount = 2;

    // Act and Assert
    assertSame(
        targetClass,
        (new ConstantPoolEditor(targetClass, null, KotlinConstants.dummyClassPool))
            .getTargetClass());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolEditor.<init>(ProgramClass, ClassPool, ClassPool, boolean)"})
  public void testNewConstantPoolEditor_whenFalse_thenReturnTargetClassIsProgramClass() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act and Assert
    assertSame(
        targetClass,
        (new ConstantPoolEditor(targetClass, null, KotlinConstants.dummyClassPool, false))
            .getTargetClass());
  }

  /**
   * Test {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass)}.
   *
   * <ul>
   *   <li>When {@link ProgramClass#ProgramClass()}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolEditor.<init>(ProgramClass)"})
  public void testNewConstantPoolEditor_whenProgramClass() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act and Assert
    assertSame(targetClass, (new ConstantPoolEditor(targetClass)).getTargetClass());
  }

  /**
   * Test {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool, ClassPool)}.
   *
   * <ul>
   *   <li>When {@link ProgramClass#ProgramClass()}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool,
   * ClassPool)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolEditor.<init>(ProgramClass, ClassPool, ClassPool)"})
  public void testNewConstantPoolEditor_whenProgramClass2() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act and Assert
    assertSame(
        targetClass,
        (new ConstantPoolEditor(
                targetClass, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool))
            .getTargetClass());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ConstantPoolEditor.<init>(ProgramClass, ClassPool, ClassPool, boolean)"})
  public void testNewConstantPoolEditor_whenProgramClass_thenReturnTargetClassIsProgramClass() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act and Assert
    assertSame(
        targetClass,
        (new ConstantPoolEditor(
                targetClass, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool, true))
            .getTargetClass());
  }

  /**
   * Test {@link ConstantPoolEditor#getTargetClass()}.
   *
   * <p>Method under test: {@link ConstantPoolEditor#getTargetClass()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProgramClass ConstantPoolEditor.getTargetClass()"})
  public void testGetTargetClass() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act and Assert
    assertSame(targetClass, (new ConstantPoolEditor(targetClass)).getTargetClass());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ConstantPoolEditor.addConstant(Constant)"})
  public void testAddConstant_thenReturnThree() {
    // Arrange
    ProgramClass targetClass =
        new ProgramClass(2, 3, new Constant[] {new ClassConstant()}, 2, 2, 2);

    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(3, constantPoolEditor.addConstant(new ClassConstant()));
    ProgramClass targetClass2 = constantPoolEditor.getTargetClass();
    assertEquals(4, targetClass2.u2constantPoolCount);
    assertSame(targetClass.constantPool, targetClass2.constantPool);
  }
}
