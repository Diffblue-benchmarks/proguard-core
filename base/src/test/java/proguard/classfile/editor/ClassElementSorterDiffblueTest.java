package proguard.classfile.editor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.ProgramClass;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.constant.DynamicConstant;
import proguard.classfile.constant.FieldrefConstant;

public class ClassElementSorterDiffblueTest {
  /**
   * Test {@link ClassElementSorter#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ClassElementSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassElementSorter.visitProgramClass(ProgramClass)"})
  public void testVisitProgramClass() {
    // Arrange
    ClassElementSorter classElementSorter = new ClassElementSorter();
    ProgramClass programClass =
        new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1);

    // Act
    classElementSorter.visitProgramClass(programClass);

    // Assert
    assertNull(programClass.getSuperName());
    assertNull(programClass.getSuperClass());
    assertEquals(0, programClass.u2superClass);
    assertEquals(0, programClass.u2thisClass);
  }

  /**
   * Test {@link ClassElementSorter#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ClassElementSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassElementSorter.visitProgramClass(ProgramClass)"})
  public void testVisitProgramClass2() {
    // Arrange
    ClassElementSorter classElementSorter = new ClassElementSorter(true, true, true, true);
    ProgramClass programClass =
        new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1);

    // Act
    classElementSorter.visitProgramClass(programClass);

    // Assert
    assertNull(programClass.getSuperName());
    assertNull(programClass.getSuperClass());
    assertEquals(0, programClass.u2superClass);
    assertEquals(0, programClass.u2thisClass);
  }

  /**
   * Test {@link ClassElementSorter#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ClassElementSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassElementSorter.visitProgramClass(ProgramClass)"})
  public void testVisitProgramClass3() {
    // Arrange
    ClassElementSorter classElementSorter = new ClassElementSorter();
    ClassConstant classConstant = new ClassConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass programClass =
        new ProgramClass(1, 2, new Constant[] {classConstant, classConstant2}, 1, 1, 1);

    // Act
    classElementSorter.visitProgramClass(programClass);

    // Assert that nothing has changed
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof ClassConstant);
    assertEquals(1, programClass.u2superClass);
    assertEquals(1, programClass.u2thisClass);
    assertEquals(2, constantArray.length);
    assertEquals(classConstant, constant);
    assertSame(classConstant2, constant);
  }

  /**
   * Test {@link ClassElementSorter#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ClassElementSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassElementSorter.visitProgramClass(ProgramClass)"})
  public void testVisitProgramClass4() {
    // Arrange
    ClassElementSorter classElementSorter = new ClassElementSorter(false, true, true, true);
    ProgramClass programClass =
        new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1);

    // Act
    classElementSorter.visitProgramClass(programClass);

    // Assert
    assertNull(programClass.getSuperName());
    assertNull(programClass.getSuperClass());
    assertEquals(0, programClass.u2superClass);
    assertEquals(0, programClass.u2thisClass);
  }

  /**
   * Test {@link ClassElementSorter#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ClassElementSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassElementSorter.visitProgramClass(ProgramClass)"})
  public void testVisitProgramClass5() {
    // Arrange
    ClassElementSorter classElementSorter = new ClassElementSorter(true, false, true, true);
    ProgramClass programClass =
        new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1);

    // Act
    classElementSorter.visitProgramClass(programClass);

    // Assert that nothing has changed
    assertEquals(1, programClass.u2superClass);
    assertEquals(1, programClass.u2thisClass);
  }

  /**
   * Test {@link ClassElementSorter#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ClassElementSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassElementSorter.visitProgramClass(ProgramClass)"})
  public void testVisitProgramClass6() {
    // Arrange
    ClassElementSorter classElementSorter = new ClassElementSorter(true, true, true, false);
    ProgramClass programClass =
        new ProgramClass(1, 1, new Constant[] {new ClassConstant()}, 1, 1, 1);

    // Act
    classElementSorter.visitProgramClass(programClass);

    // Assert
    assertNull(programClass.getSuperName());
    assertNull(programClass.getSuperClass());
    assertEquals(0, programClass.u2superClass);
    assertEquals(0, programClass.u2thisClass);
  }

  /**
   * Test {@link ClassElementSorter#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then second element {@link ClassConstant#referencedClass} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ClassElementSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassElementSorter.visitProgramClass(ProgramClass)"})
  public void testVisitProgramClass_thenSecondElementReferencedClassIsNull() {
    // Arrange
    ClassElementSorter classElementSorter = new ClassElementSorter();
    ClassConstant classConstant = new ClassConstant();
    DynamicConstant dynamicConstant = new DynamicConstant();
    ProgramClass programClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, dynamicConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    classElementSorter.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[1];
    assertTrue(constant instanceof ClassConstant);
    assertNull(((ClassConstant) constant).referencedClass);
    assertEquals(3, constantArray.length);
    assertSame(dynamicConstant, constantArray[2]);
  }

  /**
   * Test {@link ClassElementSorter#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then third element is {@link FieldrefConstant#FieldrefConstant()}.
   * </ul>
   *
   * <p>Method under test: {@link ClassElementSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassElementSorter.visitProgramClass(ProgramClass)"})
  public void testVisitProgramClass_thenThirdElementIsFieldrefConstant() {
    // Arrange
    ClassElementSorter classElementSorter = new ClassElementSorter();
    ClassConstant classConstant = new ClassConstant();
    FieldrefConstant fieldrefConstant = new FieldrefConstant();
    ProgramClass programClass =
        new ProgramClass(
            1, 3, new Constant[] {classConstant, fieldrefConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    classElementSorter.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    assertEquals(3, constantArray.length);
    assertSame(fieldrefConstant, constantArray[2]);
  }
}
