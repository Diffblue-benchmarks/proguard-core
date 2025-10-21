package proguard.evaluation.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.Method;

public class PartialEvaluatorExceptionDiffblueTest {
  /**
   * Test {@link PartialEvaluatorException#PartialEvaluatorException(int, Throwable, Clazz, Method,
   * String, String[])}.
   *
   * <p>Method under test: {@link PartialEvaluatorException#PartialEvaluatorException(int,
   * Throwable, Clazz, Method, String, String[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void PartialEvaluatorException.<init>(int, Throwable, Clazz, Method, String, String[])"
  })
  public void testNewPartialEvaluatorException() {
    // Arrange
    Throwable cause = new Throwable();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    String[] errorParameters = new String[] {"An error occurred"};

    // Act
    PartialEvaluatorException actualPartialEvaluatorException =
        new PartialEvaluatorException(
            1, cause, clazz, method, "An error occurred", errorParameters);

    // Assert
    Object[] errorParameters2 = actualPartialEvaluatorException.getErrorParameters();
    assertTrue(errorParameters2 instanceof String[]);
    Clazz clazz2 = actualPartialEvaluatorException.getClazz();
    assertTrue(clazz2 instanceof LibraryClass);
    Method method2 = actualPartialEvaluatorException.getMethod();
    assertTrue(method2 instanceof LibraryMethod);
    assertEquals("An error occurred", actualPartialEvaluatorException.getLocalizedMessage());
    assertEquals("An error occurred", actualPartialEvaluatorException.getMessage());
    assertEquals(0, actualPartialEvaluatorException.getSuppressed().length);
    assertEquals(1, actualPartialEvaluatorException.getComponentErrorId());
    assertEquals(1, errorParameters2.length);
    assertSame(cause, actualPartialEvaluatorException.getCause());
    assertSame(clazz, clazz2);
    assertSame(method, method2);
    assertSame(errorParameters, errorParameters2);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PartialEvaluatorException#getClazz()}
   *   <li>{@link PartialEvaluatorException#getMethod()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Clazz PartialEvaluatorException.getClazz()",
    "Method PartialEvaluatorException.getMethod()"
  })
  public void testGettersAndSetters() {
    // Arrange
    Throwable cause = new Throwable();
    LibraryClass clazz = new LibraryClass();
    LibraryMethod method = new LibraryMethod(1, "Name", "Descriptor");

    PartialEvaluatorException partialEvaluatorException =
        new PartialEvaluatorException(
            1, cause, clazz, method, "An error occurred", "An error occurred");

    // Act
    Clazz actualClazz = partialEvaluatorException.getClazz();

    // Assert
    assertSame(clazz, actualClazz);
    assertSame(method, partialEvaluatorException.getMethod());
  }
}
