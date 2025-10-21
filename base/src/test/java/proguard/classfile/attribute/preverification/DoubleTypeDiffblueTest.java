package proguard.classfile.attribute.preverification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DoubleTypeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link DoubleType}
   *   <li>{@link DoubleType#toString()}
   *   <li>{@link DoubleType#getTag()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DoubleType.<init>()",
    "int DoubleType.getTag()",
    "String DoubleType.toString()"
  })
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
