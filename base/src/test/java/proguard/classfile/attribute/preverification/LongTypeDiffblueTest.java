package proguard.classfile.attribute.preverification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class LongTypeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link LongType}
   *   <li>{@link LongType#toString()}
   *   <li>{@link LongType#getTag()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void LongType.<init>()",
    "int LongType.getTag()",
    "String LongType.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    LongType actualLongType = new LongType();
    String actualToStringResult = actualLongType.toString();
    int actualTag = actualLongType.getTag();

    // Assert
    assertEquals("l", actualToStringResult);
    assertNull(actualLongType.getProcessingInfo());
    assertEquals(0, actualLongType.getProcessingFlags());
    assertEquals(4, actualTag);
  }
}
