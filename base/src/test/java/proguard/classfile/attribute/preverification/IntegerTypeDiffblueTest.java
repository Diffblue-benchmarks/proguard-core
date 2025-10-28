package proguard.classfile.attribute.preverification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class IntegerTypeDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link IntegerType}
   *   <li>{@link IntegerType#toString()}
   *   <li>{@link IntegerType#getTag()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    IntegerType actualIntegerType = new IntegerType();
    String actualToStringResult = actualIntegerType.toString();
    int actualTag = actualIntegerType.getTag();

    // Assert
    assertEquals("i", actualToStringResult);
    assertNull(actualIntegerType.getProcessingInfo());
    assertEquals(0, actualIntegerType.getProcessingFlags());
    assertEquals(1, actualTag);
  }
}
