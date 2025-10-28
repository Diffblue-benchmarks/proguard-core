package proguard.classfile.attribute.preverification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class TopTypeDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TopType}
   *   <li>{@link TopType#toString()}
   *   <li>{@link TopType#getTag()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    TopType actualTopType = new TopType();
    String actualToStringResult = actualTopType.toString();
    int actualTag = actualTopType.getTag();

    // Assert
    assertEquals("T", actualToStringResult);
    assertNull(actualTopType.getProcessingInfo());
    assertEquals(0, actualTag);
    assertEquals(0, actualTopType.getProcessingFlags());
  }
}
