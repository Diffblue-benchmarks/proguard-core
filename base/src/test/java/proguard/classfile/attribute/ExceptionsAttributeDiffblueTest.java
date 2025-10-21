package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ExceptionsAttributeDiffblueTest {
  /**
   * Test {@link ExceptionsAttribute#ExceptionsAttribute()}.
   *
   * <p>Method under test: {@link ExceptionsAttribute#ExceptionsAttribute()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ExceptionsAttribute.<init>()",
    "void ExceptionsAttribute.<init>(int, int, int[])"
  })
  public void testNewExceptionsAttribute() {
    // Arrange and Act
    ExceptionsAttribute actualExceptionsAttribute = new ExceptionsAttribute();

    // Assert
    assertNull(actualExceptionsAttribute.getProcessingInfo());
    assertEquals(0, actualExceptionsAttribute.getProcessingFlags());
  }

  /**
   * Test {@link ExceptionsAttribute#ExceptionsAttribute(int, int, int[])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link ExceptionsAttribute#ExceptionsAttribute(int, int, int[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ExceptionsAttribute.<init>()",
    "void ExceptionsAttribute.<init>(int, int, int[])"
  })
  public void testNewExceptionsAttribute_whenOne() {
    // Arrange and Act
    ExceptionsAttribute actualExceptionsAttribute =
        new ExceptionsAttribute(1, 3, new int[] {1, 0, 1, 0});

    // Assert
    assertNull(actualExceptionsAttribute.getProcessingInfo());
    assertEquals(0, actualExceptionsAttribute.getProcessingFlags());
  }
}
