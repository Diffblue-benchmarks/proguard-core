package proguard.dexfile.reader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;
import proguard.dexfile.ir.expr.Constant;

public class DexExceptionDiffblueTest {
  /**
   * Method under test: {@link DexException#DexException()}
   */
  @Test
  public void testNewDexException() {
    // Arrange and Act
    DexException actualDexException = new DexException();

    // Assert
    assertNull(actualDexException.getMessage());
    assertNull(actualDexException.getCause());
    assertEquals(0, actualDexException.getSuppressed().length);
  }

  /**
   * Method under test: {@link DexException#DexException(String)}
   */
  @Test
  public void testNewDexException2() {
    // Arrange and Act
    DexException actualDexException = new DexException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualDexException.getMessage());
    assertNull(actualDexException.getCause());
    assertEquals(0, actualDexException.getSuppressed().length);
  }

  /**
   * Method under test: {@link DexException#DexException(String, Throwable)}
   */
  @Test
  public void testNewDexException3() {
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
   * Method under test: {@link DexException#DexException(Throwable)}
   */
  @Test
  public void testNewDexException4() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    DexException actualDexException = new DexException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualDexException.getMessage());
    assertEquals(0, actualDexException.getSuppressed().length);
    assertSame(cause, actualDexException.getCause());
  }

  /**
   * Method under test: {@link DexException#DexException(String, Object[])}
   */
  @Test
  public void testNewDexException5() {
    // Arrange and Act
    DexException actualDexException = new DexException("An error occurred", Constant.Null);

    // Assert
    assertEquals("An error occurred", actualDexException.getLocalizedMessage());
    assertEquals("An error occurred", actualDexException.getMessage());
    assertNull(actualDexException.getCause());
    assertEquals(0, actualDexException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link DexException#DexException(Throwable, String, Object[])}
   */
  @Test
  public void testNewDexException6() {
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
