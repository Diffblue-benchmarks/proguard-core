package proguard.classfile.attribute.preverification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class UninitializedThisTypeDiffblueTest {
  /**
   * Method under test: {@link UninitializedThisType#getTag()}
   */
  @Test
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(6, VerificationTypeFactory.UNINITIALIZED_THIS_TYPE.getTag());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link UninitializedThisType}
   *   <li>{@link UninitializedThisType#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    UninitializedThisType actualUninitializedThisType = new UninitializedThisType();

    // Assert
    assertEquals("u:this", actualUninitializedThisType.toString());
    assertNull(actualUninitializedThisType.getProcessingInfo());
    assertEquals(0, actualUninitializedThisType.getProcessingFlags());
  }
}
