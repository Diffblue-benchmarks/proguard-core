package proguard.classfile.attribute.preverification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FloatTypeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link FloatType}
   *   <li>{@link FloatType#toString()}
   *   <li>{@link FloatType#getTag()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void FloatType.<init>()",
    "int FloatType.getTag()",
    "String FloatType.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    FloatType actualFloatType = new FloatType();
    String actualToStringResult = actualFloatType.toString();
    int actualTag = actualFloatType.getTag();

    // Assert
    assertEquals("f", actualToStringResult);
    assertNull(actualFloatType.getProcessingInfo());
    assertEquals(0, actualFloatType.getProcessingFlags());
    assertEquals(2, actualTag);
  }
}
