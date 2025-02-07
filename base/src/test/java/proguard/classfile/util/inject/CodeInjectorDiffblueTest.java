package proguard.classfile.util.inject;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.classfile.ProgramClass;
import proguard.classfile.ProgramMethod;
import proguard.classfile.util.inject.argument.ConstantString;
import proguard.classfile.util.inject.argument.InjectedArgument;
import proguard.classfile.util.inject.location.FirstBlock;
import proguard.classfile.util.inject.location.InjectStrategy;

class CodeInjectorDiffblueTest {
  /**
   * Test {@link CodeInjector#injectInvokeStatic(Clazz, Method, InjectedArgument[])} with {@code
   * clazz}, {@code method}, {@code arguments}.
   *
   * <ul>
   *   <li>Then return {@link CodeInjector} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CodeInjector#injectInvokeStatic(Clazz, Method,
   * InjectedArgument[])}
   */
  @Test
  @DisplayName(
      "Test injectInvokeStatic(Clazz, Method, InjectedArgument[]) with 'clazz', 'method', 'arguments'; then return CodeInjector (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.util.inject.CodeInjector proguard.classfile.util.inject.CodeInjector.injectInvokeStatic(proguard.classfile.Clazz, proguard.classfile.Method, proguard.classfile.util.inject.argument.InjectedArgument[])"
  })
  void testInjectInvokeStaticWithClazzMethodArguments_thenReturnCodeInjector() {
    // Arrange
    CodeInjector codeInjector = new CodeInjector();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).addSubClass(Mockito.<Clazz>any());
    clazz.addSubClass(new LibraryClass());
    LibraryMethod method = new LibraryMethod(8, "Name", "Ljava/lang/String;");

    // Act
    CodeInjector actualInjectInvokeStaticResult =
        codeInjector.injectInvokeStatic(clazz, method, new ConstantString("Constant"));

    // Assert
    verify(clazz).addSubClass(isA(Clazz.class));
    assertSame(codeInjector, actualInjectInvokeStaticResult);
  }

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.util.inject.CodeInjector proguard.classfile.util.inject.CodeInjector.injectInvokeStatic(proguard.classfile.Clazz, proguard.classfile.Method)"
  })
  void testInjectInvokeStaticWithClazzMethod_thenReturnCodeInjector() {
    // Arrange
    CodeInjector codeInjector = new CodeInjector();
    LibraryClass clazz = mock(LibraryClass.class);
    doNothing().when(clazz).addSubClass(Mockito.<Clazz>any());
    clazz.addSubClass(new LibraryClass());

    // Act
    CodeInjector actualInjectInvokeStaticResult =
        codeInjector.injectInvokeStatic(clazz, new LibraryMethod(8, "Name", "Descriptor"));

    // Assert
    verify(clazz).addSubClass(isA(Clazz.class));
    assertSame(codeInjector, actualInjectInvokeStaticResult);
  }

  /**
   * Test {@link CodeInjector#into(ProgramClass, ProgramMethod)}.
   *
   * <p>Method under test: {@link CodeInjector#into(ProgramClass, ProgramMethod)}
   */
  @Test
  @DisplayName("Test into(ProgramClass, ProgramMethod)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.util.inject.CodeInjector proguard.classfile.util.inject.CodeInjector.into(proguard.classfile.ProgramClass, proguard.classfile.ProgramMethod)"
  })
  void testInto() {
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
  @DisplayName("Test at(InjectStrategy)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.util.inject.CodeInjector proguard.classfile.util.inject.CodeInjector.at(proguard.classfile.util.inject.location.InjectStrategy)"
  })
  void testAt() {
    // Arrange
    CodeInjector codeInjector = new CodeInjector();

    // Act and Assert
    assertSame(codeInjector, codeInjector.at(new FirstBlock()));
  }
}
