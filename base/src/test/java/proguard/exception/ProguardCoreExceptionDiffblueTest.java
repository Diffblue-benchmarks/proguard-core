package proguard.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.exception.ProguardCoreException.Builder;

class ProguardCoreExceptionDiffblueTest {
  /**
   * Test Builder {@link Builder#Builder(String, int)}.
   *
   * <p>Method under test: {@link Builder#Builder(String, int)}
   */
  @Test
  @DisplayName("Test Builder new Builder(String, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Builder.<init>(String, int)"})
  void testBuilderNewBuilder() {
    // Arrange, Act and Assert
    ProguardCoreException proguardCoreException = new Builder("An error occurred", 1).build();
    assertEquals("An error occurred", proguardCoreException.getLocalizedMessage());
    assertEquals("An error occurred", proguardCoreException.getMessage());
    assertNull(proguardCoreException.getCause());
    assertEquals(0, proguardCoreException.getSuppressed().length);
    assertEquals(0, proguardCoreException.getErrorParameters().length);
    assertEquals(1, proguardCoreException.getComponentErrorId());
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
  @DisplayName(
      "Test new ProguardCoreException(int, String, Object[]); then return LocalizedMessage is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProguardCoreException.<init>(int, String, Object[])"})
  void testNewProguardCoreException_thenReturnLocalizedMessageIsAnErrorOccurred() {
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
  @DisplayName(
      "Test new ProguardCoreException(int, Throwable, String, Object[]); then return LocalizedMessage is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProguardCoreException.<init>(int, Throwable, String, Object[])"})
  void testNewProguardCoreException_thenReturnLocalizedMessageIsAnErrorOccurred2() {
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
  @DisplayName(
      "Test new ProguardCoreException(int, String, Object[]); when 'null'; then return LocalizedMessage is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProguardCoreException.<init>(int, String, Object[])"})
  void testNewProguardCoreException_whenNull_thenReturnLocalizedMessageIsNull() {
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
  @DisplayName(
      "Test new ProguardCoreException(int, Throwable, String, Object[]); when 'null'; then return LocalizedMessage is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProguardCoreException.<init>(int, Throwable, String, Object[])"})
  void testNewProguardCoreException_whenNull_thenReturnLocalizedMessageIsNull2() {
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int ProguardCoreException.getComponentErrorId()",
    "Object[] ProguardCoreException.getErrorParameters()"
  })
  void testGettersAndSetters() {
    // Arrange
    ProguardCoreException proguardCoreException =
        new ProguardCoreException(1, "An error occurred", "Error Parameters");

    // Act
    int actualComponentErrorId = proguardCoreException.getComponentErrorId();
    Object[] actualErrorParameters = proguardCoreException.getErrorParameters();

    // Assert
    assertEquals("Error Parameters", actualErrorParameters[0]);
    assertEquals(1, actualComponentErrorId);
    assertEquals(1, actualErrorParameters.length);
  }
}
