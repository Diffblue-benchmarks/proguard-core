package proguard.classfile.visitor;

import static org.junit.Assert.assertEquals;
import java.util.HashSet;
import org.junit.Test;
import proguard.classfile.ProgramClass;

public class ClassVersionSetterDiffblueTest {
  /**
   * Method under test: {@link ClassVersionSetter#visitProgramClass(ProgramClass)}
   */
  @Test
  public void testVisitProgramClass() {
    // Arrange
    ClassVersionSetter classVersionSetter = new ClassVersionSetter(1);
    ProgramClass programClass = new ProgramClass();

    // Act
    classVersionSetter.visitProgramClass(programClass);

    // Assert
    assertEquals(1, programClass.u4version);
  }

  /**
   * Method under test: {@link ClassVersionSetter#visitProgramClass(ProgramClass)}
   */
  @Test
  public void testVisitProgramClass2() {
    // Arrange
    ClassVersionSetter classVersionSetter = new ClassVersionSetter(-1);
    ProgramClass programClass = new ProgramClass();

    // Act
    classVersionSetter.visitProgramClass(programClass);

    // Assert
    assertEquals(-1, programClass.u4version);
  }

  /**
   * Method under test: {@link ClassVersionSetter#visitProgramClass(ProgramClass)}
   */
  @Test
  public void testVisitProgramClass3() {
    // Arrange
    ClassVersionSetter classVersionSetter = new ClassVersionSetter(-1, new HashSet<>());
    ProgramClass programClass = new ProgramClass();

    // Act
    classVersionSetter.visitProgramClass(programClass);

    // Assert
    assertEquals(-1, programClass.u4version);
  }
}
