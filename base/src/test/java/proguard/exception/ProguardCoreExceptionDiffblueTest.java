package proguard.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.exception.ProguardCoreException.Builder;

public class ProguardCoreExceptionDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#cause(Throwable)}
   *   <li>{@link Builder#errorParameters(Object[])}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ProguardCoreException Builder.build()",
    "Builder Builder.cause(Throwable)",
    "Builder Builder.errorParameters(Object[])"
  })
  public void testBuilderBuild() {
    // Arrange
    Builder builder = new Builder("An error occurred", 1);
    Throwable cause = new Throwable();

    // Act
    ProguardCoreException actualBuildResult =
        builder.cause(cause).errorParameters("Error Parameters").build();

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
   * Test Builder {@link Builder#Builder(String, int)}.
   *
   * <p>Method under test: {@link Builder#Builder(String, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Builder.<init>(String, int)"})
  public void testBuilderNewBuilder() {
    // Arrange, Act and Assert
    ProguardCoreException buildResult = (new Builder("An error occurred", 1)).build();
    assertEquals("An error occurred", buildResult.getLocalizedMessage());
    assertEquals("An error occurred", buildResult.getMessage());
    assertNull(buildResult.getCause());
    assertEquals(0, buildResult.getSuppressed().length);
    assertEquals(0, buildResult.getErrorParameters().length);
    assertEquals(1, buildResult.getComponentErrorId());
  }

  /**
   * Test {@link ProguardCoreException#ProguardCoreException(int, String, Object[])}.
   *
   * <ul>
   *   <li>Then return LocalizedMessage is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link ProguardCoreException#ProguardCoreException(int, String,
   * Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProguardCoreException.<init>(int, String, Object[])"})
  public void testNewProguardCoreException_thenReturnLocalizedMessageIsAnErrorOccurred() {
    // Arrange
    Object[] errorParameters = new Object[] {"Error Parameters"};

    // Act
    ProguardCoreException actualProguardCoreException =
        new ProguardCoreException(1, "An error occurred", errorParameters);

    // Assert
    assertEquals("An error occurred", actualProguardCoreException.getLocalizedMessage());
    assertEquals("An error occurred", actualProguardCoreException.getMessage());
    assertNull(actualProguardCoreException.getCause());
    assertEquals(0, actualProguardCoreException.getSuppressed().length);
    assertEquals(1, actualProguardCoreException.getComponentErrorId());
    assertSame(errorParameters, actualProguardCoreException.getErrorParameters());
  }

  /**
   * Test {@link ProguardCoreException#ProguardCoreException(int, Throwable, String, Object[])}.
   *
   * <ul>
   *   <li>Then return LocalizedMessage is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link ProguardCoreException#ProguardCoreException(int, Throwable,
   * String, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProguardCoreException.<init>(int, Throwable, String, Object[])"})
  public void testNewProguardCoreException_thenReturnLocalizedMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();
    Object[] errorParameters = new Object[] {"Error Parameters"};

    // Act
    ProguardCoreException actualProguardCoreException =
        new ProguardCoreException(1, cause, "An error occurred", errorParameters);

    // Assert
    assertEquals("An error occurred", actualProguardCoreException.getLocalizedMessage());
    assertEquals("An error occurred", actualProguardCoreException.getMessage());
    assertEquals(0, actualProguardCoreException.getSuppressed().length);
    assertEquals(1, actualProguardCoreException.getComponentErrorId());
    assertSame(cause, actualProguardCoreException.getCause());
    assertSame(errorParameters, actualProguardCoreException.getErrorParameters());
  }

  /**
   * Test {@link ProguardCoreException#ProguardCoreException(int, String, Object[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return LocalizedMessage is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProguardCoreException#ProguardCoreException(int, String,
   * Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProguardCoreException.<init>(int, String, Object[])"})
  public void testNewProguardCoreException_whenNull_thenReturnLocalizedMessageIsNull() {
    // Arrange
    Object[] errorParameters = new Object[] {"Error Parameters"};

    // Act
    ProguardCoreException actualProguardCoreException =
        new ProguardCoreException(1, null, errorParameters);

    // Assert
    assertNull(actualProguardCoreException.getLocalizedMessage());
    assertNull(actualProguardCoreException.getMessage());
    assertNull(actualProguardCoreException.getCause());
    assertEquals(0, actualProguardCoreException.getSuppressed().length);
    assertEquals(1, actualProguardCoreException.getComponentErrorId());
    assertSame(errorParameters, actualProguardCoreException.getErrorParameters());
  }

  /**
   * Test {@link ProguardCoreException#ProguardCoreException(int, Throwable, String, Object[])}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return LocalizedMessage is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ProguardCoreException#ProguardCoreException(int, Throwable,
   * String, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProguardCoreException.<init>(int, Throwable, String, Object[])"})
  public void testNewProguardCoreException_whenNull_thenReturnLocalizedMessageIsNull2() {
    // Arrange
    Throwable cause = new Throwable();
    Object[] errorParameters = new Object[] {"Error Parameters"};

    // Act
    ProguardCoreException actualProguardCoreException =
        new ProguardCoreException(1, cause, null, errorParameters);

    // Assert
    assertNull(actualProguardCoreException.getLocalizedMessage());
    assertNull(actualProguardCoreException.getMessage());
    assertEquals(0, actualProguardCoreException.getSuppressed().length);
    assertEquals(1, actualProguardCoreException.getComponentErrorId());
    assertSame(cause, actualProguardCoreException.getCause());
    assertSame(errorParameters, actualProguardCoreException.getErrorParameters());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProguardCoreException#getComponentErrorId()}
   *   <li>{@link ProguardCoreException#getErrorParameters()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "int ProguardCoreException.getComponentErrorId()",
    "Object[] ProguardCoreException.getErrorParameters()"
  })
  public void testGettersAndSetters() {
    // Arrange
    Builder builder = new Builder("An error occurred", 1);
    ProguardCoreException buildResult =
        builder.cause(new Throwable()).errorParameters("Error Parameters").build();

    // Act
    int actualComponentErrorId = buildResult.getComponentErrorId();
    Object[] actualErrorParameters = buildResult.getErrorParameters();

    // Assert
    assertEquals("Error Parameters", actualErrorParameters[0]);
    assertEquals(1, actualComponentErrorId);
    assertEquals(1, actualErrorParameters.length);
  }
}
