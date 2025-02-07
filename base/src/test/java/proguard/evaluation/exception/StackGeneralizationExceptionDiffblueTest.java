package proguard.evaluation.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.exception.StackGeneralizationException.<init>(java.lang.Throwable, proguard.evaluation.TracedStack, proguard.evaluation.TracedStack)"
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.exception.StackGeneralizationException.<init>(proguard.classfile.Clazz, proguard.classfile.Method, java.lang.Throwable, proguard.evaluation.TracedStack, proguard.evaluation.TracedStack)"
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

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StackGeneralizationException#getFirst()}
   *   <li>{@link StackGeneralizationException#getSecond()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.TracedStack proguard.evaluation.exception.StackGeneralizationException.getFirst()",
    "proguard.evaluation.TracedStack proguard.evaluation.exception.StackGeneralizationException.getSecond()"
  })
  void testGettersAndSetters() {
    // Arrange
    Throwable cause = new Throwable();
    TracedStack first = new TracedStack(3);
    TracedStack second = new TracedStack(3);
    StackGeneralizationException stackGeneralizationException =
        new StackGeneralizationException(cause, first, second);

    // Act
    TracedStack actualFirst = stackGeneralizationException.getFirst();

    // Assert
    assertSame(first, actualFirst);
    assertSame(second, stackGeneralizationException.getSecond());
  }
}
