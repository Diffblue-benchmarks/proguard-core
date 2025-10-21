package proguard.classfile.visitor;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramField;
import proguard.classfile.ProgramMethod;

public class MemberAccessSetterDiffblueTest {
  /**
   * Test {@link MemberAccessSetter#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <ul>
   *   <li>Then {@link ProgramField#ProgramField()} AccessFlags is one.
   * </ul>
   *
   * <p>Method under test: {@link MemberAccessSetter#visitProgramField(ProgramClass, ProgramField)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MemberAccessSetter.visitProgramField(ProgramClass, ProgramField)"})
  public void testVisitProgramField_thenProgramFieldAccessFlagsIsOne() {
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
   * Test {@link MemberAccessSetter#visitProgramField(ProgramClass, ProgramField)}.
   *
   * <ul>
   *   <li>Then {@link ProgramField#ProgramField()} AccessFlags is two.
   * </ul>
   *
   * <p>Method under test: {@link MemberAccessSetter#visitProgramField(ProgramClass, ProgramField)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MemberAccessSetter.visitProgramField(ProgramClass, ProgramField)"})
  public void testVisitProgramField_thenProgramFieldAccessFlagsIsTwo() {
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
   * Test {@link MemberAccessSetter#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>Then {@link ProgramMethod#ProgramMethod()} AccessFlags is one.
   * </ul>
   *
   * <p>Method under test: {@link MemberAccessSetter#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MemberAccessSetter.visitProgramMethod(ProgramClass, ProgramMethod)"})
  public void testVisitProgramMethod_thenProgramMethodAccessFlagsIsOne() {
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
   * Test {@link MemberAccessSetter#visitProgramMethod(ProgramClass, ProgramMethod)}.
   *
   * <ul>
   *   <li>Then {@link ProgramMethod#ProgramMethod()} AccessFlags is two.
   * </ul>
   *
   * <p>Method under test: {@link MemberAccessSetter#visitProgramMethod(ProgramClass,
   * ProgramMethod)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MemberAccessSetter.visitProgramMethod(ProgramClass, ProgramMethod)"})
  public void testVisitProgramMethod_thenProgramMethodAccessFlagsIsTwo() {
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
