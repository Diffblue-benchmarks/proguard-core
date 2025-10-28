package proguard.classfile.attribute.preverification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class LongTypeDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link LongType}
   *   <li>{@link LongType#toString()}
   *   <li>{@link LongType#getTag()}
   * </ul>
   */
  @Test
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
