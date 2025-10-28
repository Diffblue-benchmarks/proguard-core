package proguard.evaluation.exception;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;

public class PartialEvaluatorExceptionDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PartialEvaluatorException#getClazz()}
   *   <li>{@link PartialEvaluatorException#getMethod()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    Throwable cause = new Throwable();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    PartialEvaluatorException partialEvaluatorException = new PartialEvaluatorException(1, cause, clazz, method,
        "An error occurred", "An error occurred");

    // Act
    Clazz actualClazz = partialEvaluatorException.getClazz();

    // Assert
    assertSame(clazz, actualClazz);
    assertSame(method, partialEvaluatorException.getMethod());
  }

  /**
   * Method under test:
   * {@link PartialEvaluatorException#PartialEvaluatorException(int, Throwable, Clazz, Method, String, String[])}
   */
  @Test
  public void testNewPartialEvaluatorException() {
    // Arrange
    Throwable cause = new Throwable();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    String[] errorParameters = new String[]{"An error occurred"};

    // Act
    PartialEvaluatorException actualPartialEvaluatorException = new PartialEvaluatorException(1, cause, clazz, method,
        "An error occurred", errorParameters);

    // Assert
    Object[] errorParameters2 = actualPartialEvaluatorException.getErrorParameters();
    assertTrue(errorParameters2 instanceof String[]);
    assertEquals("An error occurred", actualPartialEvaluatorException.getLocalizedMessage());
    assertEquals("An error occurred", actualPartialEvaluatorException.getMessage());
    assertEquals(0, actualPartialEvaluatorException.getSuppressed().length);
    assertEquals(1, actualPartialEvaluatorException.getComponentErrorId());
    assertSame(cause, actualPartialEvaluatorException.getCause());
    assertSame(clazz, actualPartialEvaluatorException.getClazz());
    assertSame(method, actualPartialEvaluatorException.getMethod());
    assertSame(errorParameters, errorParameters2);
    assertArrayEquals(new String[]{"An error occurred"}, errorParameters2);
  }
}
