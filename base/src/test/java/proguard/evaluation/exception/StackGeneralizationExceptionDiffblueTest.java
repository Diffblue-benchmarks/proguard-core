package proguard.evaluation.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.evaluation.TracedStack;

class StackGeneralizationExceptionDiffblueTest {
  /**
   * Test {@link StackGeneralizationException#StackGeneralizationException(Throwable, TracedStack,
   * TracedStack)}.
   *
   * <p>Method under test: {@link
   * StackGeneralizationException#StackGeneralizationException(Throwable, TracedStack, TracedStack)}
   */
  @Test
  @DisplayName("Test new StackGeneralizationException(Throwable, TracedStack, TracedStack)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StackGeneralizationException.<init>(Throwable, TracedStack, TracedStack)"
  })
  void testNewStackGeneralizationException() {
    // Arrange
    Throwable cause = new Throwable();
    TracedStack first = new TracedStack(3);
    TracedStack second = new TracedStack(3);

    // Act
    StackGeneralizationException actualStackGeneralizationException =
        new StackGeneralizationException(cause, first, second);

    // Assert
    Object[] errorParameters = actualStackGeneralizationException.getErrorParameters();
    assertTrue(errorParameters instanceof String[]);
    assertEquals(
        "Could not generalize stacks  and  because: \"null\".",
        actualStackGeneralizationException.getLocalizedMessage());
    assertEquals(
        "Could not generalize stacks  and  because: \"null\".",
        actualStackGeneralizationException.getMessage());
    assertNull(actualStackGeneralizationException.getClazz());
    assertNull(actualStackGeneralizationException.getMethod());
    assertEquals(0, actualStackGeneralizationException.getSuppressed().length);
    assertEquals(1011, actualStackGeneralizationException.getComponentErrorId());
    assertEquals(3, errorParameters.length);
    assertSame(cause, actualStackGeneralizationException.getCause());
    assertSame(first, actualStackGeneralizationException.getFirst());
    assertSame(second, actualStackGeneralizationException.getSecond());
  }

  /**
   * Test {@link StackGeneralizationException#StackGeneralizationException(Clazz, Method, Throwable,
   * TracedStack, TracedStack)}.
   *
   * <p>Method under test: {@link StackGeneralizationException#StackGeneralizationException(Clazz,
   * Method, Throwable, TracedStack, TracedStack)}
   */
  @Test
  @DisplayName(
      "Test new StackGeneralizationException(Clazz, Method, Throwable, TracedStack, TracedStack)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StackGeneralizationException.<init>(Clazz, Method, Throwable, TracedStack, TracedStack)"
  })
  void testNewStackGeneralizationException2() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");
    Throwable cause = new Throwable();
    TracedStack first = new TracedStack(3);
    TracedStack second = new TracedStack(3);

    // Act
    StackGeneralizationException actualStackGeneralizationException =
        new StackGeneralizationException(clazz, method, cause, first, second);

    // Assert
    Object[] errorParameters = actualStackGeneralizationException.getErrorParameters();
    assertTrue(errorParameters instanceof String[]);
    Clazz clazz2 = actualStackGeneralizationException.getClazz();
    assertTrue(clazz2 instanceof LibraryClass);
    Method method2 = actualStackGeneralizationException.getMethod();
    assertTrue(method2 instanceof LibraryMethod);
    assertEquals(
        "Could not generalize stacks  and  because: \"null\".",
        actualStackGeneralizationException.getLocalizedMessage());
    assertEquals(
        "Could not generalize stacks  and  because: \"null\".",
        actualStackGeneralizationException.getMessage());
    assertEquals(0, actualStackGeneralizationException.getSuppressed().length);
    assertEquals(1011, actualStackGeneralizationException.getComponentErrorId());
    assertEquals(3, errorParameters.length);
    assertSame(cause, actualStackGeneralizationException.getCause());
    assertSame(clazz, clazz2);
    assertSame(method, method2);
    assertSame(first, actualStackGeneralizationException.getFirst());
    assertSame(second, actualStackGeneralizationException.getSecond());
  }
}
