package proguard.classfile.attribute.preverification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class FloatTypeDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link FloatType}
   *   <li>{@link FloatType#toString()}
   *   <li>{@link FloatType#getTag()}
   * </ul>
   */
  @Test
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
