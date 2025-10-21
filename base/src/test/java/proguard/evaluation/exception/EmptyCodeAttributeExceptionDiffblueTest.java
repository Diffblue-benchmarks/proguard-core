package proguard.evaluation.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class EmptyCodeAttributeExceptionDiffblueTest {
  /**
   * Test {@link EmptyCodeAttributeException#EmptyCodeAttributeException(String)}.
   *
   * <ul>
   *   <li>Then return LocalizedMessage is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link EmptyCodeAttributeException#EmptyCodeAttributeException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EmptyCodeAttributeException.<init>(String)"})
  public void testNewEmptyCodeAttributeException_thenReturnLocalizedMessageIsAnErrorOccurred() {
    // Arrange and Act
    EmptyCodeAttributeException actualEmptyCodeAttributeException =
        new EmptyCodeAttributeException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualEmptyCodeAttributeException.getLocalizedMessage());
    assertEquals("An error occurred", actualEmptyCodeAttributeException.getMessage());
    assertNull(actualEmptyCodeAttributeException.getCause());
    assertEquals(0, actualEmptyCodeAttributeException.getSuppressed().length);
    assertEquals(0, actualEmptyCodeAttributeException.getErrorParameters().length);
    assertEquals(1005, actualEmptyCodeAttributeException.getComponentErrorId());
  }

  /**
   * Test {@link EmptyCodeAttributeException#EmptyCodeAttributeException(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return LocalizedMessage is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EmptyCodeAttributeException#EmptyCodeAttributeException(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EmptyCodeAttributeException.<init>(String)"})
  public void testNewEmptyCodeAttributeException_whenNull_thenReturnLocalizedMessageIsNull() {
    // Arrange and Act
    EmptyCodeAttributeException actualEmptyCodeAttributeException =
        new EmptyCodeAttributeException(null);

    // Assert
    assertNull(actualEmptyCodeAttributeException.getLocalizedMessage());
    assertNull(actualEmptyCodeAttributeException.getMessage());
    assertNull(actualEmptyCodeAttributeException.getCause());
    assertEquals(0, actualEmptyCodeAttributeException.getSuppressed().length);
    assertEquals(0, actualEmptyCodeAttributeException.getErrorParameters().length);
    assertEquals(1005, actualEmptyCodeAttributeException.getComponentErrorId());
  }
}
