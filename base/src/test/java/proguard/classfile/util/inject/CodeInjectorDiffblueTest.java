package proguard.classfile.util.inject;

import static org.junit.jupiter.api.Assertions.assertSame;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramMethod;
import proguard.classfile.util.inject.location.FirstBlock;
import proguard.classfile.util.inject.location.InjectStrategy;

class CodeInjectorDiffblueTest {
  /**
   * Test {@link CodeInjector#injectInvokeStatic(Clazz, Method)} with {@code clazz}, {@code method}.
   *
   * <ul>
   *   <li>Then return {@link CodeInjector} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CodeInjector#injectInvokeStatic(Clazz, Method)}
   */
  @Test
  @DisplayName(
      "Test injectInvokeStatic(Clazz, Method) with 'clazz', 'method'; then return CodeInjector (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CodeInjector CodeInjector.injectInvokeStatic(Clazz, Method)"})
  void testInjectInvokeStaticWithClazzMethod_thenReturnCodeInjector() {
    // Arrange
    CodeInjector codeInjector = new CodeInjector();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(8, "Name", "Descriptor");

    // Act
    CodeInjector actualInjectInvokeStaticResult = codeInjector.injectInvokeStatic(clazz, method);

    // Assert
    assertSame(codeInjector, actualInjectInvokeStaticResult);
  }

  /**
   * Test {@link CodeInjector#into(ProgramClass, ProgramMethod)}.
   *
   * <p>Method under test: {@link CodeInjector#into(ProgramClass, ProgramMethod)}
   */
  @Test
  @DisplayName("Test into(ProgramClass, ProgramMethod)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CodeInjector CodeInjector.into(ProgramClass, ProgramMethod)"})
  void testInto() {
    // Arrange
    CodeInjector codeInjector = new CodeInjector();
    ProgramClass programClass = new ProgramClass();

    // Act
    CodeInjector actualIntoResult = codeInjector.into(programClass, new ProgramMethod());

    // Assert
    assertSame(codeInjector, actualIntoResult);
  }

  /**
   * Test {@link CodeInjector#at(InjectStrategy)}.
   *
   * <p>Method under test: {@link CodeInjector#at(InjectStrategy)}
   */
  @Test
  @DisplayName("Test at(InjectStrategy)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"CodeInjector CodeInjector.at(InjectStrategy)"})
  void testAt() {
    // Arrange
    CodeInjector codeInjector = new CodeInjector();

    // Act
    CodeInjector actualAtResult = codeInjector.at(new FirstBlock());

    // Assert
    assertSame(codeInjector, actualAtResult);
  }
}
