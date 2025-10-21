package proguard.classfile.attribute.preverification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class VerificationTypeFactoryDiffblueTest {
  /**
   * Test {@link VerificationTypeFactory#createUninitializedType(int)}.
   *
   * <p>Method under test: {@link VerificationTypeFactory#createUninitializedType(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UninitializedType VerificationTypeFactory.createUninitializedType(int)"})
  public void testCreateUninitializedType() {
    // Arrange and Act
    UninitializedType actualCreateUninitializedTypeResult =
        VerificationTypeFactory.createUninitializedType(1);

    // Assert
    assertNull(actualCreateUninitializedTypeResult.getProcessingInfo());
    assertEquals(0, actualCreateUninitializedTypeResult.getProcessingFlags());
    assertEquals(1, actualCreateUninitializedTypeResult.u2newInstructionOffset);
    assertEquals(8, actualCreateUninitializedTypeResult.getTag());
  }

  /**
   * Test {@link VerificationTypeFactory#createObjectType(int)}.
   *
   * <p>Method under test: {@link VerificationTypeFactory#createObjectType(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ObjectType VerificationTypeFactory.createObjectType(int)"})
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
