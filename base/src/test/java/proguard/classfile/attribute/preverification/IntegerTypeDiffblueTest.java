package proguard.classfile.attribute.preverification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class IntegerTypeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link IntegerType}
   *   <li>{@link IntegerType#toString()}
   *   <li>{@link IntegerType#getTag()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void IntegerType.<init>()",
    "int IntegerType.getTag()",
    "String IntegerType.toString()"
  })
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
