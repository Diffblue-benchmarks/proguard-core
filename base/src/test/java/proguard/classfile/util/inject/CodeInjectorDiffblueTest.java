package proguard.classfile.util.inject;

import static org.junit.Assert.assertSame;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramMethod;
import proguard.classfile.util.inject.location.FirstBlock;
import proguard.classfile.util.inject.location.InjectStrategy;

public class CodeInjectorDiffblueTest {
  /**
   * Test {@link CodeInjector#into(ProgramClass, ProgramMethod)}.
   *
   * <p>Method under test: {@link CodeInjector#into(ProgramClass, ProgramMethod)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CodeInjector CodeInjector.into(ProgramClass, ProgramMethod)"})
  public void testInto() {
    // Arrange
    CodeInjector codeInjector = new CodeInjector();
    ProgramClass programClass = new ProgramClass();

    // Act and Assert
    assertSame(codeInjector, codeInjector.into(programClass, new ProgramMethod()));
  }

  /**
   * Test {@link CodeInjector#at(InjectStrategy)}.
   *
   * <p>Method under test: {@link CodeInjector#at(InjectStrategy)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"CodeInjector CodeInjector.at(InjectStrategy)"})
  public void testAt() {
    // Arrange
    CodeInjector codeInjector = new CodeInjector();

    // Act and Assert
    assertSame(codeInjector, codeInjector.at(new FirstBlock()));
  }
}
