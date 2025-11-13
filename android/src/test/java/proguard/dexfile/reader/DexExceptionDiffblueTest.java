package proguard.dexfile.reader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexException.<init>(String, Object[])"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexException.<init>(Throwable, String, Object[])"})
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
}
