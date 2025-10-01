package proguard.classfile.editor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.ProgramClass;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.constant.DynamicConstant;
import proguard.classfile.constant.FieldrefConstant;
import proguard.classfile.constant.FloatConstant;
import proguard.classfile.constant.IntegerConstant;
import proguard.classfile.constant.InterfaceMethodrefConstant;
import proguard.classfile.constant.InvokeDynamicConstant;

class ConstantPoolSorterDiffblueTest {
  /**
   * Test {@link ConstantPoolSorter#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ConstantPoolSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolSorter.visitProgramClass(ProgramClass)"})
  void testVisitProgramClass() {
    // Arrange
    ConstantPoolSorter constantPoolSorter = new ConstantPoolSorter();
    Constant[] constantPool = new Constant[] {new ClassConstant()};
    ProgramClass programClass = new ProgramClass(1, 1, constantPool, 1, 1, 1);

    // Act
    constantPoolSorter.visitProgramClass(programClass);

    // Assert
    assertNull(programClass.getSuperName());
    assertNull(programClass.getSuperClass());
    assertEquals(0, programClass.u2superClass);
    assertEquals(0, programClass.u2thisClass);
  }

  /**
   * Test {@link ConstantPoolSorter#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ConstantPoolSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolSorter.visitProgramClass(ProgramClass)"})
  void testVisitProgramClass2() {
    // Arrange
    ConstantPoolSorter constantPoolSorter = new ConstantPoolSorter();
    ClassConstant classConstant = new ClassConstant();
    ProgramClass programClass =
        new ProgramClass(1, 2, new Constant[] {classConstant, new ClassConstant()}, 1, 1, 1);

    // Act
    constantPoolSorter.visitProgramClass(programClass);

    // Assert that nothing has changed
    assertEquals(1, programClass.u2superClass);
    assertEquals(1, programClass.u2thisClass);
    assertEquals(2, programClass.u2constantPoolCount);
  }

  /**
   * Test {@link ConstantPoolSorter#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ConstantPoolSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolSorter.visitProgramClass(ProgramClass)"})
  void testVisitProgramClass3() {
    // Arrange
    ConstantPoolSorter constantPoolSorter = new ConstantPoolSorter();
    ProgramClass programClass =
        new ProgramClass(1, 2, new Constant[] {new ClassConstant(), null}, 1, 1, 1);

    // Act
    constantPoolSorter.visitProgramClass(programClass);

    // Assert
    assertNull(programClass.getSuperName());
    assertNull(programClass.getSuperClass());
    assertEquals(0, programClass.u2superClass);
    assertEquals(0, programClass.u2thisClass);
    assertEquals(1, programClass.u2constantPoolCount);
  }

  /**
   * Test {@link ConstantPoolSorter#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ConstantPoolSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolSorter.visitProgramClass(ProgramClass)"})
  void testVisitProgramClass4() {
    // Arrange
    ConstantPoolSorter constantPoolSorter = new ConstantPoolSorter();
    ClassConstant classConstant = new ClassConstant();
    ProgramClass programClass =
        new ProgramClass(1, 2, new Constant[] {classConstant, new DynamicConstant()}, 1, 1, 1);

    // Act
    constantPoolSorter.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    assertNull(constantArray[0]);
    assertEquals(1, programClass.u2superClass);
    assertEquals(1, programClass.u2thisClass);
    assertEquals(2, constantArray.length);
    assertEquals(2, programClass.u2constantPoolCount);
  }

  /**
   * Test {@link ConstantPoolSorter#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ConstantPoolSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolSorter.visitProgramClass(ProgramClass)"})
  void testVisitProgramClass5() {
    // Arrange
    ConstantPoolSorter constantPoolSorter = new ConstantPoolSorter();
    ClassConstant classConstant = new ClassConstant();
    ProgramClass programClass =
        new ProgramClass(1, 2, new Constant[] {classConstant, new FieldrefConstant()}, 1, 1, 1);

    // Act
    constantPoolSorter.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    assertNull(constantArray[0]);
    assertEquals(1, programClass.u2superClass);
    assertEquals(1, programClass.u2thisClass);
    assertEquals(2, constantArray.length);
    assertEquals(2, programClass.u2constantPoolCount);
  }

  /**
   * Test {@link ConstantPoolSorter#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ConstantPoolSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolSorter.visitProgramClass(ProgramClass)"})
  void testVisitProgramClass6() {
    // Arrange
    ConstantPoolSorter constantPoolSorter = new ConstantPoolSorter();
    ClassConstant classConstant = new ClassConstant();
    ProgramClass programClass =
        new ProgramClass(1, 2, new Constant[] {classConstant, new FloatConstant(10.0f)}, 1, 1, 1);

    // Act
    constantPoolSorter.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    assertNull(constantArray[0]);
    assertEquals(1, programClass.u2superClass);
    assertEquals(1, programClass.u2thisClass);
    assertEquals(2, constantArray.length);
    assertEquals(2, programClass.u2constantPoolCount);
  }

  /**
   * Test {@link ConstantPoolSorter#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ConstantPoolSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolSorter.visitProgramClass(ProgramClass)"})
  void testVisitProgramClass7() {
    // Arrange
    ConstantPoolSorter constantPoolSorter = new ConstantPoolSorter();
    ClassConstant classConstant = new ClassConstant();
    ProgramClass programClass =
        new ProgramClass(1, 2, new Constant[] {classConstant, new IntegerConstant(42)}, 1, 1, 1);

    // Act
    constantPoolSorter.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    assertNull(constantArray[0]);
    assertEquals(1, programClass.u2superClass);
    assertEquals(1, programClass.u2thisClass);
    assertEquals(2, constantArray.length);
    assertEquals(2, programClass.u2constantPoolCount);
  }

  /**
   * Test {@link ConstantPoolSorter#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ConstantPoolSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolSorter.visitProgramClass(ProgramClass)"})
  void testVisitProgramClass8() {
    // Arrange
    ConstantPoolSorter constantPoolSorter = new ConstantPoolSorter();
    ClassConstant classConstant = new ClassConstant();
    ProgramClass programClass =
        new ProgramClass(
            1, 2, new Constant[] {classConstant, new InterfaceMethodrefConstant()}, 1, 1, 1);

    // Act
    constantPoolSorter.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    assertNull(constantArray[0]);
    assertEquals(1, programClass.u2superClass);
    assertEquals(1, programClass.u2thisClass);
    assertEquals(2, constantArray.length);
    assertEquals(2, programClass.u2constantPoolCount);
  }

  /**
   * Test {@link ConstantPoolSorter#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ConstantPoolSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ConstantPoolSorter.visitProgramClass(ProgramClass)"})
  void testVisitProgramClass9() {
    // Arrange
    ConstantPoolSorter constantPoolSorter = new ConstantPoolSorter();
    ClassConstant classConstant = new ClassConstant();
    ProgramClass programClass =
        new ProgramClass(
            1, 2, new Constant[] {classConstant, new InvokeDynamicConstant()}, 1, 1, 1);

    // Act
    constantPoolSorter.visitProgramClass(programClass);

    // Assert
    Constant[] constantArray = programClass.constantPool;
    assertNull(constantArray[0]);
    assertEquals(1, programClass.u2superClass);
    assertEquals(1, programClass.u2thisClass);
    assertEquals(2, constantArray.length);
    assertEquals(2, programClass.u2constantPoolCount);
  }
}
