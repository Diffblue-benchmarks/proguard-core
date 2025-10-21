package proguard.classfile.attribute.preverification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TopTypeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TopType}
   *   <li>{@link TopType#toString()}
   *   <li>{@link TopType#getTag()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TopType.<init>()", "int TopType.getTag()", "String TopType.toString()"})
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
