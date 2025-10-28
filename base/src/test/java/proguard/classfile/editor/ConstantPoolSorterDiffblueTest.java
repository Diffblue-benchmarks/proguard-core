package proguard.classfile.editor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import proguard.classfile.ProgramClass;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;

public class ConstantPoolSorterDiffblueTest {
  /**
   * Method under test: {@link ConstantPoolSorter#visitProgramClass(ProgramClass)}
   */
  @Test
  public void testVisitProgramClass() {
    // Arrange
    ConstantPoolSorter constantPoolSorter = new ConstantPoolSorter();
    ProgramClass programClass = new ProgramClass(ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, 1,
        new Constant[]{new ClassConstant()}, ClassEstimates.TYPICAL_CONSTANT_POOL_SIZE, 1, 1);

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
