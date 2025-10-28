package proguard.classfile.attribute.preverification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class NullTypeDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link NullType}
   *   <li>{@link NullType#toString()}
   *   <li>{@link NullType#getTag()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    NullType actualNullType = new NullType();
    String actualToStringResult = actualNullType.toString();
    int actualTag = actualNullType.getTag();

    // Assert
    assertEquals("n", actualToStringResult);
    assertNull(actualNullType.getProcessingInfo());
    assertEquals(0, actualNullType.getProcessingFlags());
    assertEquals(5, actualTag);
  }
}
