package proguard.classfile.visitor;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramField;
import proguard.classfile.ProgramMethod;

public class MemberAccessSetterDiffblueTest {
  /**
   * Method under test:
   * {@link MemberAccessSetter#visitProgramField(ProgramClass, ProgramField)}
   */
  @Test
  public void testVisitProgramField() {
    // Arrange
    MemberAccessSetter memberAccessSetter = new MemberAccessSetter(1);
    ProgramClass programClass = new ProgramClass();
    ProgramField programField = new ProgramField();

    // Act
    memberAccessSetter.visitProgramField(programClass, programField);

    // Assert
    assertEquals(1, programField.getAccessFlags());
  }

  /**
   * Method under test:
   * {@link MemberAccessSetter#visitProgramField(ProgramClass, ProgramField)}
   */
  @Test
  public void testVisitProgramField2() {
    // Arrange
    MemberAccessSetter memberAccessSetter = new MemberAccessSetter(2);
    ProgramClass programClass = new ProgramClass();
    ProgramField programField = new ProgramField();

    // Act
    memberAccessSetter.visitProgramField(programClass, programField);

    // Assert
    assertEquals(2, programField.getAccessFlags());
  }

  /**
   * Method under test:
   * {@link MemberAccessSetter#visitProgramMethod(ProgramClass, ProgramMethod)}
   */
  @Test
  public void testVisitProgramMethod() {
    // Arrange
    MemberAccessSetter memberAccessSetter = new MemberAccessSetter(1);
    ProgramClass programClass = new ProgramClass();
    ProgramMethod programMethod = new ProgramMethod();

    // Act
    memberAccessSetter.visitProgramMethod(programClass, programMethod);

    // Assert
    assertEquals(1, programMethod.getAccessFlags());
  }

  /**
   * Method under test:
   * {@link MemberAccessSetter#visitProgramMethod(ProgramClass, ProgramMethod)}
   */
  @Test
  public void testVisitProgramMethod2() {
    // Arrange
    MemberAccessSetter memberAccessSetter = new MemberAccessSetter(2);
    ProgramClass programClass = new ProgramClass();
    ProgramMethod programMethod = new ProgramMethod();

    // Act
    memberAccessSetter.visitProgramMethod(programClass, programMethod);

    // Assert
    assertEquals(2, programMethod.getAccessFlags());
  }
}
