package proguard.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class ProguardCoreExceptionDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProguardCoreException.Builder#build()}
   *   <li>{@link ProguardCoreException.Builder#cause(Throwable)}
   *   <li>{@link ProguardCoreException.Builder#errorParameters(Object[])}
   * </ul>
   */
  @Test
  public void testBuilderBuild() {
    // Arrange
    ProguardCoreException.Builder builder = new ProguardCoreException.Builder("An error occurred", 1);
    Throwable cause = new Throwable();

    // Act
    ProguardCoreException actualBuildResult = builder.cause(cause).errorParameters("Error Parameters").build();

    // Assert
    assertEquals("An error occurred", actualBuildResult.getLocalizedMessage());
    assertEquals("An error occurred", actualBuildResult.getMessage());
    Object[] errorParameters = actualBuildResult.getErrorParameters();
    assertEquals("Error Parameters", errorParameters[0]);
    assertEquals(0, actualBuildResult.getSuppressed().length);
    assertEquals(1, actualBuildResult.getComponentErrorId());
    assertEquals(1, errorParameters.length);
    assertSame(cause, actualBuildResult.getCause());
  }

  /**
   * Method under test: {@link ProguardCoreException.Builder#Builder(String, int)}
   */
  @Test
  public void testBuilderNewBuilder() {
    // Arrange, Act and Assert
    ProguardCoreException buildResult = (new ProguardCoreException.Builder("An error occurred", 1)).build();
    assertEquals("An error occurred", buildResult.getLocalizedMessage());
    assertEquals("An error occurred", buildResult.getMessage());
    assertNull(buildResult.getCause());
    assertEquals(0, buildResult.getSuppressed().length);
    assertEquals(0, buildResult.getErrorParameters().length);
    assertEquals(1, buildResult.getComponentErrorId());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProguardCoreException#getComponentErrorId()}
   *   <li>{@link ProguardCoreException#getErrorParameters()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ProguardCoreException proguardCoreException = new ProguardCoreException(1, "An error occurred", "Error Parameters");

    // Act
    int actualComponentErrorId = proguardCoreException.getComponentErrorId();
    Object[] actualErrorParameters = proguardCoreException.getErrorParameters();

    // Assert
    assertEquals("Error Parameters", actualErrorParameters[0]);
    assertEquals(1, actualComponentErrorId);
    assertEquals(1, actualErrorParameters.length);
  }

  /**
   * Method under test:
   * {@link ProguardCoreException#ProguardCoreException(int, String, Object[])}
   */
  @Test
  public void testNewProguardCoreException() {
    // Arrange
    Object[] errorParameters = new Object[]{"Error Parameters"};

    // Act
    ProguardCoreException actualProguardCoreException = new ProguardCoreException(1, "An error occurred",
        errorParameters);

    // Assert
    assertEquals("An error occurred", actualProguardCoreException.getLocalizedMessage());
    assertEquals("An error occurred", actualProguardCoreException.getMessage());
    Object[] errorParameters2 = actualProguardCoreException.getErrorParameters();
    assertEquals("Error Parameters", errorParameters2[0]);
    assertNull(actualProguardCoreException.getCause());
    assertEquals(0, actualProguardCoreException.getSuppressed().length);
    assertEquals(1, actualProguardCoreException.getComponentErrorId());
    assertEquals(1, errorParameters2.length);
    assertSame(errorParameters, errorParameters2);
  }

  /**
   * Method under test:
   * {@link ProguardCoreException#ProguardCoreException(int, String, Object[])}
   */
  @Test
  public void testNewProguardCoreException2() {
    // Arrange
    Object[] errorParameters = new Object[]{"Error Parameters"};

    // Act
    ProguardCoreException actualProguardCoreException = new ProguardCoreException(1, null, errorParameters);

    // Assert
    Object[] errorParameters2 = actualProguardCoreException.getErrorParameters();
    assertEquals("Error Parameters", errorParameters2[0]);
    assertNull(actualProguardCoreException.getLocalizedMessage());
    assertNull(actualProguardCoreException.getMessage());
    assertNull(actualProguardCoreException.getCause());
    assertEquals(0, actualProguardCoreException.getSuppressed().length);
    assertEquals(1, actualProguardCoreException.getComponentErrorId());
    assertEquals(1, errorParameters2.length);
    assertSame(errorParameters, errorParameters2);
  }

  /**
   * Method under test:
   * {@link ProguardCoreException#ProguardCoreException(int, Throwable, String, Object[])}
   */
  @Test
  public void testNewProguardCoreException3() {
    // Arrange
    Throwable cause = new Throwable();
    Object[] errorParameters = new Object[]{"Error Parameters"};

    // Act
    ProguardCoreException actualProguardCoreException = new ProguardCoreException(1, cause, "An error occurred",
        errorParameters);

    // Assert
    assertEquals("An error occurred", actualProguardCoreException.getLocalizedMessage());
    assertEquals("An error occurred", actualProguardCoreException.getMessage());
    Object[] errorParameters2 = actualProguardCoreException.getErrorParameters();
    assertEquals("Error Parameters", errorParameters2[0]);
    assertEquals(0, actualProguardCoreException.getSuppressed().length);
    assertEquals(1, actualProguardCoreException.getComponentErrorId());
    assertEquals(1, errorParameters2.length);
    assertSame(cause, actualProguardCoreException.getCause());
    assertSame(errorParameters, errorParameters2);
  }

  /**
   * Method under test:
   * {@link ProguardCoreException#ProguardCoreException(int, Throwable, String, Object[])}
   */
  @Test
  public void testNewProguardCoreException4() {
    // Arrange
    Throwable cause = new Throwable();
    Object[] errorParameters = new Object[]{"Error Parameters"};

    // Act
    ProguardCoreException actualProguardCoreException = new ProguardCoreException(1, cause, null, errorParameters);

    // Assert
    Object[] errorParameters2 = actualProguardCoreException.getErrorParameters();
    assertEquals("Error Parameters", errorParameters2[0]);
    assertNull(actualProguardCoreException.getLocalizedMessage());
    assertNull(actualProguardCoreException.getMessage());
    assertEquals(0, actualProguardCoreException.getSuppressed().length);
    assertEquals(1, actualProguardCoreException.getComponentErrorId());
    assertEquals(1, errorParameters2.length);
    assertSame(cause, actualProguardCoreException.getCause());
    assertSame(errorParameters, errorParameters2);
  }
}
