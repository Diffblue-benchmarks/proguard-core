package proguard.classfile.util.inject;

import static org.junit.Assert.assertSame;
import org.junit.Test;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramMethod;
import proguard.classfile.util.inject.location.FirstBlock;
import proguard.classfile.util.inject.location.InjectStrategy;

public class CodeInjectorDiffblueTest {
  /**
   * Method under test: {@link CodeInjector#into(ProgramClass, ProgramMethod)}
   */
  @Test
  public void testInto() {
    // Arrange
    CodeInjector codeInjector = new CodeInjector();
    ProgramClass programClass = new ProgramClass();

    // Act and Assert
    assertSame(codeInjector, codeInjector.into(programClass, new ProgramMethod()));
  }

  /**
   * Method under test: {@link CodeInjector#at(InjectStrategy)}
   */
  @Test
  public void testAt() {
    // Arrange
    CodeInjector codeInjector = new CodeInjector();

    // Act and Assert
    assertSame(codeInjector, codeInjector.at(new FirstBlock()));
  }
}
