package proguard.dexfile.reader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.ir.expr.Constant;

class DexExceptionDiffblueTest {
  /**
   * Test {@link DexException#DexException(String, Object[])}.
   *
   * <p>Method under test: {@link DexException#DexException(String, Object[])}
   */
  @Test
  @DisplayName("Test new DexException(String, Object[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.DexException.<init>(java.lang.String, java.lang.Object[])"
  })
  void testNewDexException() {
    // Arrange and Act
    DexException actualDexException = new DexException("An error occurred", Constant.Null);

    // Assert
    assertEquals("An error occurred", actualDexException.getLocalizedMessage());
    assertEquals("An error occurred", actualDexException.getMessage());
    assertNull(actualDexException.getCause());
    assertEquals(0, actualDexException.getSuppressed().length);
  }

  /**
   * Test {@link DexException#DexException(Throwable, String, Object[])}.
   *
   * <p>Method under test: {@link DexException#DexException(Throwable, String, Object[])}
   */
  @Test
  @DisplayName("Test new DexException(Throwable, String, Object[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.DexException.<init>(java.lang.Throwable, java.lang.String, java.lang.Object[])"
  })
  void testNewDexException2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    DexException actualDexException = new DexException(cause, "An error occurred", Constant.Null);

    // Assert
    assertEquals("An error occurred", actualDexException.getLocalizedMessage());
    assertEquals("An error occurred", actualDexException.getMessage());
    assertEquals(0, actualDexException.getSuppressed().length);
    assertSame(cause, actualDexException.getCause());
  }

  /**
   * Test {@link DexException#DexException()}.
   *
   * <ul>
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DexException#DexException()}
   */
  @Test
  @DisplayName("Test new DexException(); then return Message is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.DexException.<init>()",
    "void proguard.dexfile.reader.DexException.<init>(java.lang.String)",
    "void proguard.dexfile.reader.DexException.<init>(java.lang.String, java.lang.Throwable)",
    "void proguard.dexfile.reader.DexException.<init>(java.lang.Throwable)"
  })
  void testNewDexException_thenReturnMessageIsNull() {
    // Arrange and Act
    DexException actualDexException = new DexException();

    // Assert
    assertNull(actualDexException.getMessage());
    assertNull(actualDexException.getCause());
    assertEquals(0, actualDexException.getSuppressed().length);
  }

  /**
   * Test {@link DexException#DexException(String)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link DexException#DexException(String)}
   */
  @Test
  @DisplayName(
      "Test new DexException(String); when 'An error occurred'; then return Message is 'An error occurred'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.DexException.<init>()",
    "void proguard.dexfile.reader.DexException.<init>(java.lang.String)",
    "void proguard.dexfile.reader.DexException.<init>(java.lang.String, java.lang.Throwable)",
    "void proguard.dexfile.reader.DexException.<init>(java.lang.Throwable)"
  })
  void testNewDexException_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    DexException actualDexException = new DexException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualDexException.getMessage());
    assertNull(actualDexException.getCause());
    assertEquals(0, actualDexException.getSuppressed().length);
  }

  /**
   * Test {@link DexException#DexException(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link DexException#DexException(String, Throwable)}
   */
  @Test
  @DisplayName(
      "Test new DexException(String, Throwable); when 'An error occurred'; then return Message is 'An error occurred'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.DexException.<init>()",
    "void proguard.dexfile.reader.DexException.<init>(java.lang.String)",
    "void proguard.dexfile.reader.DexException.<init>(java.lang.String, java.lang.Throwable)",
    "void proguard.dexfile.reader.DexException.<init>(java.lang.Throwable)"
  })
  void testNewDexException_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    DexException actualDexException = new DexException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualDexException.getMessage());
    assertEquals(0, actualDexException.getSuppressed().length);
    assertSame(cause, actualDexException.getCause());
  }

  /**
   * Test {@link DexException#DexException(Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Message is {@code Throwable}.
   * </ul>
   *
   * <p>Method under test: {@link DexException#DexException(Throwable)}
   */
  @Test
  @DisplayName(
      "Test new DexException(Throwable); when Throwable(); then return Message is 'java.lang.Throwable'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.DexException.<init>()",
    "void proguard.dexfile.reader.DexException.<init>(java.lang.String)",
    "void proguard.dexfile.reader.DexException.<init>(java.lang.String, java.lang.Throwable)",
    "void proguard.dexfile.reader.DexException.<init>(java.lang.Throwable)"
  })
  void testNewDexException_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    DexException actualDexException = new DexException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualDexException.getMessage());
    assertEquals(0, actualDexException.getSuppressed().length);
    assertSame(cause, actualDexException.getCause());
  }
}
