package proguard.classfile.editor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.ProgramClass;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;

class ConstantPoolSorterDiffblueTest {
  /**
   * Test {@link ConstantPoolSorter#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ConstantPoolSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  @DisplayName("Test visitProgramClass(ProgramClass)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.editor.ConstantPoolSorter.visitProgramClass(proguard.classfile.ProgramClass)"
  })
  void testVisitProgramClass() {
    // Arrange
    ConstantPoolSorter constantPoolSorter = new ConstantPoolSorter();
    ProgramClass programClass =
        new ProgramClass(
            ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE,
            1,
            new Constant[] {new ClassConstant()},
            ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE,
            1,
            1);

    // Act
    constantPoolSorter.visitProgramClass(programClass);

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
