package proguard.classfile.attribute.preverification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class DoubleTypeDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DoubleType}
   *   <li>{@link DoubleType#toString()}
   *   <li>{@link DoubleType#getTag()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    DoubleType actualDoubleType = new DoubleType();
    String actualToStringResult = actualDoubleType.toString();
    int actualTag = actualDoubleType.getTag();

    // Assert
    assertEquals("d", actualToStringResult);
    assertNull(actualDoubleType.getProcessingInfo());
    assertEquals(0, actualDoubleType.getProcessingFlags());
    assertEquals(3, actualTag);
  }
}
