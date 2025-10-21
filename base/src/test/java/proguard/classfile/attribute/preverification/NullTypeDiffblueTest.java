package proguard.classfile.attribute.preverification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class NullTypeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link NullType}
   *   <li>{@link NullType#toString()}
   *   <li>{@link NullType#getTag()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void NullType.<init>()",
    "int NullType.getTag()",
    "String NullType.toString()"
  })
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
