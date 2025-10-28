package proguard.classfile.editor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import org.junit.Test;
import proguard.classfile.ClassPool;
import proguard.classfile.ProgramClass;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.kotlin.KotlinConstants;

public class ConstantPoolEditorDiffblueTest {
  /**
   * Method under test: {@link ConstantPoolEditor#getTargetClass()}
   */
  @Test
  public void testGetTargetClass() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act and Assert
    assertSame(targetClass, (new ConstantPoolEditor(targetClass)).getTargetClass());
  }

  /**
   * Method under test: {@link ConstantPoolEditor#addConstant(Constant)}
   */
  @Test
  public void testAddConstant() {
    // Arrange
    ProgramClass targetClass = new ProgramClass(2, 3, new Constant[]{new ClassConstant()}, 2, 2, 2);

    ConstantPoolEditor constantPoolEditor = new ConstantPoolEditor(targetClass);

    // Act and Assert
    assertEquals(3, constantPoolEditor.addConstant(new ClassConstant()));
    assertSame(targetClass, constantPoolEditor.getTargetClass());
  }

  /**
   * Method under test:
   * {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass)}
   */
  @Test
  public void testNewConstantPoolEditor() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act and Assert
    assertSame(targetClass, (new ConstantPoolEditor(targetClass)).getTargetClass());
  }

  /**
   * Method under test:
   * {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass)}
   */
  @Test
  public void testNewConstantPoolEditor2() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    targetClass.u2constantPoolCount = 2;

    // Act and Assert
    assertSame(targetClass, (new ConstantPoolEditor(targetClass)).getTargetClass());
  }

  /**
   * Method under test:
   * {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool, ClassPool)}
   */
  @Test
  public void testNewConstantPoolEditor3() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act and Assert
    assertSame(targetClass,
        (new ConstantPoolEditor(targetClass, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool))
            .getTargetClass());
  }

  /**
   * Method under test:
   * {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool, ClassPool)}
   */
  @Test
  public void testNewConstantPoolEditor4() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    targetClass.u2constantPoolCount = 1;

    // Act and Assert
    assertSame(targetClass,
        (new ConstantPoolEditor(targetClass, null, KotlinConstants.dummyClassPool)).getTargetClass());
  }

  /**
   * Method under test:
   * {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool, ClassPool)}
   */
  @Test
  public void testNewConstantPoolEditor5() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();
    targetClass.u2constantPoolCount = 2;

    // Act and Assert
    assertSame(targetClass,
        (new ConstantPoolEditor(targetClass, null, KotlinConstants.dummyClassPool)).getTargetClass());
  }

  /**
   * Method under test:
   * {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool, ClassPool, boolean)}
   */
  @Test
  public void testNewConstantPoolEditor6() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act and Assert
    assertSame(targetClass,
        (new ConstantPoolEditor(targetClass, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool, true))
            .getTargetClass());
  }

  /**
   * Method under test:
   * {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool, ClassPool, boolean)}
   */
  @Test
  public void testNewConstantPoolEditor7() {
    // Arrange
    ProgramClass targetClass = new ProgramClass();

    // Act and Assert
    assertSame(targetClass,
        (new ConstantPoolEditor(targetClass, null, KotlinConstants.dummyClassPool, false)).getTargetClass());
  }

  /**
   * Method under test:
   * {@link ConstantPoolEditor#ConstantPoolEditor(ProgramClass, ClassPool, ClassPool, boolean)}
   */
  @Test
  public void testNewConstantPoolEditor8() {
    // Arrange
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass targetClass = new ProgramClass(1, 3,
        new Constant[]{classConstant, classConstant2, new ClassConstant()}, 1, 1, 1);

    // Act and Assert
    assertSame(targetClass,
        (new ConstantPoolEditor(targetClass, KotlinConstants.dummyClassPool, KotlinConstants.dummyClassPool, true))
            .getTargetClass());
  }
}
