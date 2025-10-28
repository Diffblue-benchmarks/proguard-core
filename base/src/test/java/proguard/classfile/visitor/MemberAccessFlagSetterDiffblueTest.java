package proguard.classfile.visitor;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramField;
import proguard.classfile.ProgramMethod;

public class MemberAccessFlagSetterDiffblueTest {
  /**
   * Method under test:
   * {@link MemberAccessFlagSetter#visitProgramField(ProgramClass, ProgramField)}
   */
  @Test
  public void testVisitProgramField() {
    // Arrange
    MemberAccessFlagSetter memberAccessFlagSetter = new MemberAccessFlagSetter(1);
    ProgramClass programClass = new ProgramClass();
    ProgramField programField = new ProgramField();

    // Act
    memberAccessFlagSetter.visitProgramField(programClass, programField);

    // Assert
    assertEquals(1, programField.getAccessFlags());
  }

  /**
   * Method under test:
   * {@link MemberAccessFlagSetter#visitProgramMethod(ProgramClass, ProgramMethod)}
   */
  @Test
  public void testVisitProgramMethod() {
    // Arrange
    MemberAccessFlagSetter memberAccessFlagSetter = new MemberAccessFlagSetter(1);
    ProgramClass programClass = new ProgramClass();
    ProgramMethod programMethod = new ProgramMethod();

    // Act
    memberAccessFlagSetter.visitProgramMethod(programClass, programMethod);

    // Assert
    assertEquals(1, programMethod.getAccessFlags());
  }
}
