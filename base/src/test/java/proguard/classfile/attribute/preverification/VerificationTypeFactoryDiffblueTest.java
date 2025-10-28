package proguard.classfile.attribute.preverification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class VerificationTypeFactoryDiffblueTest {
  /**
   * Method under test:
   * {@link VerificationTypeFactory#createUninitializedType(int)}
   */
  @Test
  public void testCreateUninitializedType() {
    // Arrange and Act
    UninitializedType actualCreateUninitializedTypeResult = VerificationTypeFactory.createUninitializedType(1);

    // Assert
    assertNull(actualCreateUninitializedTypeResult.getProcessingInfo());
    assertEquals(0, actualCreateUninitializedTypeResult.getProcessingFlags());
    assertEquals(1, actualCreateUninitializedTypeResult.u2newInstructionOffset);
    assertEquals(8, actualCreateUninitializedTypeResult.getTag());
  }

  /**
   * Method under test: {@link VerificationTypeFactory#createObjectType(int)}
   */
  @Test
  public void testCreateObjectType() {
    // Arrange and Act
    ObjectType actualCreateObjectTypeResult = VerificationTypeFactory.createObjectType(1);

    // Assert
    assertNull(actualCreateObjectTypeResult.getProcessingInfo());
    assertEquals(0, actualCreateObjectTypeResult.getProcessingFlags());
    assertEquals(1, actualCreateObjectTypeResult.u2classIndex);
    assertEquals(7, actualCreateObjectTypeResult.getTag());
  }
}
