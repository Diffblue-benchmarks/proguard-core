package proguard.classfile.editor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.ProgramClass;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.constant.DynamicConstant;
import proguard.classfile.constant.FieldrefConstant;

public class ClassElementSorterDiffblueTest {
  /**
   * Method under test: {@link ClassElementSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  public void testVisitProgramClass() {
    // Arrange
    ClassElementSorter classElementSorter = new ClassElementSorter();
    ProgramClass programClass = new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1);

    // Act
    classElementSorter.visitProgramClass(programClass);

    // Assert
    assertNull(programClass.getSuperName());
    assertNull(programClass.getSuperClass());
    Constant[] constantArray = programClass.constantPool;
    assertNull(constantArray[0]);
    assertEquals(0, programClass.u2superClass);
    assertEquals(0, programClass.u2thisClass);
    assertEquals(1, constantArray.length);
  }

  /**
   * Method under test: {@link ClassElementSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  public void testVisitProgramClass2() {
    // Arrange
    ClassElementSorter classElementSorter = new ClassElementSorter(true, true, true, true);
    ProgramClass programClass = new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1);

    // Act
    classElementSorter.visitProgramClass(programClass);

    // Assert
    assertNull(programClass.getSuperName());
    assertNull(programClass.getSuperClass());
    Constant[] constantArray = programClass.constantPool;
    assertNull(constantArray[0]);
    assertEquals(0, programClass.u2superClass);
    assertEquals(0, programClass.u2thisClass);
    assertEquals(1, constantArray.length);
  }

  /**
   * Method under test: {@link ClassElementSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  public void testVisitProgramClass3() {
    // Arrange
    ClassElementSorter classElementSorter = new ClassElementSorter();
    ClassConstant classConstant = new ClassConstant();
    ProgramClass programClass = new ProgramClass(1, 2, new Constant[]{classConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    classElementSorter.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    assertNull(constantArray[0]);
    assertEquals(2, constantArray.length);
  }

  /**
   * Method under test: {@link ClassElementSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  public void testVisitProgramClass4() {
    // Arrange
    ClassElementSorter classElementSorter = new ClassElementSorter();
    ClassConstant classConstant = new ClassConstant();
    DynamicConstant dynamicConstant = new DynamicConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass programClass = new ProgramClass(1, 3, new Constant[]{classConstant, dynamicConstant, classConstant2},
        1, 1, 1);

    // Act
    classElementSorter.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    assertNull(constantArray[0]);
    assertEquals(2, programClass.u2superClass);
    assertEquals(2, programClass.u2thisClass);
    assertEquals(3, constantArray.length);
    assertSame(classConstant2, constantArray[1]);
    assertSame(dynamicConstant, constantArray[2]);
  }

  /**
   * Method under test: {@link ClassElementSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  public void testVisitProgramClass5() {
    // Arrange
    ClassElementSorter classElementSorter = new ClassElementSorter();
    ClassConstant classConstant = new ClassConstant();
    FieldrefConstant fieldrefConstant = new FieldrefConstant();
    ClassConstant classConstant2 = new ClassConstant();
    ProgramClass programClass = new ProgramClass(1, 3, new Constant[]{classConstant, fieldrefConstant, classConstant2},
        1, 1, 1);

    // Act
    classElementSorter.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    assertNull(constantArray[0]);
    assertEquals(2, programClass.u2superClass);
    assertEquals(2, programClass.u2thisClass);
    assertEquals(3, constantArray.length);
    assertSame(classConstant2, constantArray[1]);
    assertSame(fieldrefConstant, constantArray[2]);
  }

  /**
   * Method under test: {@link ClassElementSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  public void testVisitProgramClass6() {
    // Arrange
    ClassElementSorter classElementSorter = new ClassElementSorter(false, true, true, true);
    ProgramClass programClass = new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1);

    // Act
    classElementSorter.visitProgramClass(programClass);

    // Assert
    assertNull(programClass.getSuperName());
    assertNull(programClass.getSuperClass());
    Constant[] constantArray = programClass.constantPool;
    assertNull(constantArray[0]);
    assertEquals(0, programClass.u2superClass);
    assertEquals(0, programClass.u2thisClass);
    assertEquals(1, constantArray.length);
  }

  /**
   * Method under test: {@link ClassElementSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  public void testVisitProgramClass7() {
    // Arrange
    ClassElementSorter classElementSorter = new ClassElementSorter(true, false, true, true);
    ClassConstant classConstant = new ClassConstant();
    ProgramClass programClass = new ProgramClass(1, 1, new Constant[]{classConstant}, 1, 1, 1);

    // Act
    classElementSorter.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    Constant constant = constantArray[0];
    assertTrue(constant instanceof ClassConstant);
    assertEquals(1, constantArray.length);
    assertEquals(1, programClass.u2superClass);
    assertEquals(1, programClass.u2thisClass);
    assertSame(classConstant, constant);
  }

  /**
   * Method under test: {@link ClassElementSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  public void testVisitProgramClass8() {
    // Arrange
    ClassElementSorter classElementSorter = new ClassElementSorter(true, true, true, false);
    ProgramClass programClass = new ProgramClass(1, 1, new Constant[]{new ClassConstant()}, 1, 1, 1);

    // Act
    classElementSorter.visitProgramClass(programClass);

    // Assert
    assertNull(programClass.getSuperName());
    assertNull(programClass.getSuperClass());
    Constant[] constantArray = programClass.constantPool;
    assertNull(constantArray[0]);
    assertEquals(0, programClass.u2superClass);
    assertEquals(0, programClass.u2thisClass);
    assertEquals(1, constantArray.length);
  }
}
