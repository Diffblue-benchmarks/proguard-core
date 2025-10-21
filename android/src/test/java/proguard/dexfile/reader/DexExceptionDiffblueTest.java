package proguard.dexfile.reader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.dexfile.ir.expr.Constant;

public class DexExceptionDiffblueTest {
  /**
   * Test {@link DexException#DexException(String, Object[])}.
   *
   * <p>Method under test: {@link DexException#DexException(String, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexException.<init>(String, Object[])"})
  public void testNewDexException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DexException.<init>(Throwable, String, Object[])"})
  public void testNewDexException2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DexException.<init>()",
    "void DexException.<init>(String)",
    "void DexException.<init>(String, Throwable)",
    "void DexException.<init>(Throwable)"
  })
  public void testNewDexException_thenReturnMessageIsNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DexException.<init>()",
    "void DexException.<init>(String)",
    "void DexException.<init>(String, Throwable)",
    "void DexException.<init>(Throwable)"
  })
  public void testNewDexException_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DexException.<init>()",
    "void DexException.<init>(String)",
    "void DexException.<init>(String, Throwable)",
    "void DexException.<init>(Throwable)"
  })
  public void testNewDexException_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DexException.<init>()",
    "void DexException.<init>(String)",
    "void DexException.<init>(String, Throwable)",
    "void DexException.<init>(Throwable)"
  })
  public void testNewDexException_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
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
