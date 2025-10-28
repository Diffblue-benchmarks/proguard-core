package proguard.evaluation.exception;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;
import proguard.evaluation.TracedStack;

public class StackGeneralizationExceptionDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StackGeneralizationException#getFirst()}
   *   <li>{@link StackGeneralizationException#getSecond()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Throwable cause = new Throwable();
    TracedStack first = new TracedStack(3);
    TracedStack second = new TracedStack(3);
    StackGeneralizationException stackGeneralizationException = new StackGeneralizationException(cause, first, second);

    // Act
    TracedStack actualFirst = stackGeneralizationException.getFirst();

    // Assert
    assertSame(first, actualFirst);
    assertSame(second, stackGeneralizationException.getSecond());
  }

  /**
   * Method under test:
   * {@link StackGeneralizationException#StackGeneralizationException(Throwable, TracedStack, TracedStack)}
   */
  @Test
  public void testNewStackGeneralizationException() {
    // Arrange
    Throwable cause = new Throwable();
    TracedStack first = new TracedStack(3);
    TracedStack second = new TracedStack(3);

    // Act
    StackGeneralizationException actualStackGeneralizationException = new StackGeneralizationException(cause, first,
        second);

    // Assert
    Object[] errorParameters = actualStackGeneralizationException.getErrorParameters();
    assertTrue(errorParameters instanceof String[]);
    assertEquals("Could not generalize stacks  and  because: \"null\".",
        actualStackGeneralizationException.getLocalizedMessage());
    assertEquals("Could not generalize stacks  and  because: \"null\".",
        actualStackGeneralizationException.getMessage());
    assertNull(actualStackGeneralizationException.getClazz());
    assertNull(actualStackGeneralizationException.getMethod());
    assertEquals(0, actualStackGeneralizationException.getSuppressed().length);
    assertEquals(1011, actualStackGeneralizationException.getComponentErrorId());
    assertSame(cause, actualStackGeneralizationException.getCause());
    assertSame(first, actualStackGeneralizationException.getFirst());
    assertSame(second, actualStackGeneralizationException.getSecond());
    assertArrayEquals(new String[]{"", "", null}, errorParameters);
  }

  /**
   * Method under test:
   * {@link StackGeneralizationException#StackGeneralizationException(Clazz, Method, Throwable, TracedStack, TracedStack)}
   */
  @Test
  public void testNewStackGeneralizationException2() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    Throwable cause = new Throwable();
    TracedStack first = new TracedStack(3);
    TracedStack second = new TracedStack(3);

    // Act
    StackGeneralizationException actualStackGeneralizationException = new StackGeneralizationException(clazz, method,
        cause, first, second);

    // Assert
    Object[] errorParameters = actualStackGeneralizationException.getErrorParameters();
    assertTrue(errorParameters instanceof String[]);
    assertEquals("Could not generalize stacks  and  because: \"null\".",
        actualStackGeneralizationException.getLocalizedMessage());
    assertEquals("Could not generalize stacks  and  because: \"null\".",
        actualStackGeneralizationException.getMessage());
    assertEquals(0, actualStackGeneralizationException.getSuppressed().length);
    assertEquals(1011, actualStackGeneralizationException.getComponentErrorId());
    assertSame(cause, actualStackGeneralizationException.getCause());
    assertSame(clazz, actualStackGeneralizationException.getClazz());
    assertSame(method, actualStackGeneralizationException.getMethod());
    assertSame(first, actualStackGeneralizationException.getFirst());
    assertSame(second, actualStackGeneralizationException.getSecond());
    assertArrayEquals(new String[]{"", "", null}, errorParameters);
  }
}
