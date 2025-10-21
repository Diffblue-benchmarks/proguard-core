package proguard.classfile.attribute.preverification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class UninitializedThisTypeDiffblueTest {
  /**
   * Test {@link UninitializedThisType#getTag()}.
   *
   * <p>Method under test: {@link UninitializedThisType#getTag()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int UninitializedThisType.getTag()"})
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(6, VerificationTypeFactory.UNINITIALIZED_THIS_TYPE.getTag());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link UninitializedThisType}
   *   <li>{@link UninitializedThisType#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void UninitializedThisType.<init>()",
    "java.lang.String UninitializedThisType.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    UninitializedThisType actualUninitializedThisType = new UninitializedThisType();

    // Assert
    assertEquals("u:this", actualUninitializedThisType.toString());
    assertNull(actualUninitializedThisType.getProcessingInfo());
    assertEquals(0, actualUninitializedThisType.getProcessingFlags());
  }
}
