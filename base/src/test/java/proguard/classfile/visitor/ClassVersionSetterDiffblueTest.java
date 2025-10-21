package proguard.classfile.visitor;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.ProgramClass;

public class ClassVersionSetterDiffblueTest {
  /**
   * Test {@link ClassVersionSetter#visitProgramClass(ProgramClass)}.
   *
   * <p>Method under test: {@link ClassVersionSetter#visitProgramClass(ProgramClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassVersionSetter.visitProgramClass(ProgramClass)"})
  public void testVisitProgramClass() {
    // Arrange
    ClassVersionSetter classVersionSetter = new ClassVersionSetter(-1, new HashSet<>());
    ProgramClass programClass = new ProgramClass();

    // Act
    classVersionSetter.visitProgramClass(programClass);

    // Assert
    assertEquals(-1, programClass.u4version);
  }

  /**
   * Test {@link ClassVersionSetter#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Given {@link ClassVersionSetter#ClassVersionSetter(int)} with classVersion is minus one.
   * </ul>
   *
   * <p>Method under test: {@link ClassVersionSetter#visitProgramClass(ProgramClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassVersionSetter.visitProgramClass(ProgramClass)"})
  public void testVisitProgramClass_givenClassVersionSetterWithClassVersionIsMinusOne() {
    // Arrange
    ClassVersionSetter classVersionSetter = new ClassVersionSetter(-1);
    ProgramClass programClass = new ProgramClass();

    // Act
    classVersionSetter.visitProgramClass(programClass);

    // Assert
    assertEquals(-1, programClass.u4version);
  }

  /**
   * Test {@link ClassVersionSetter#visitProgramClass(ProgramClass)}.
   *
   * <ul>
   *   <li>Then {@link ProgramClass#ProgramClass()} {@link ProgramClass#u4version} is one.
   * </ul>
   *
   * <p>Method under test: {@link ClassVersionSetter#visitProgramClass(ProgramClass)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassVersionSetter.visitProgramClass(ProgramClass)"})
  public void testVisitProgramClass_thenProgramClassU4versionIsOne() {
    // Arrange
    ClassVersionSetter classVersionSetter = new ClassVersionSetter(1);
    ProgramClass programClass = new ProgramClass();

    // Act
    classVersionSetter.visitProgramClass(programClass);

    // Assert
    assertEquals(1, programClass.u4version);
  }
}
