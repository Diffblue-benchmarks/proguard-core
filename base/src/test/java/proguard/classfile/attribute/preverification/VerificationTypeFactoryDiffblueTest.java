package proguard.classfile.attribute.preverification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class VerificationTypeFactoryDiffblueTest {
  /**
   * Test {@link VerificationTypeFactory#createUninitializedType(int)}.
   *
   * <p>Method under test: {@link VerificationTypeFactory#createUninitializedType(int)}
   */
  @Test
  @DisplayName("Test createUninitializedType(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.attribute.preverification.UninitializedType proguard.classfile.attribute.preverification.VerificationTypeFactory.createUninitializedType(int)"
  })
  void testCreateUninitializedType() {
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
  @DisplayName("Test createObjectType(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.attribute.preverification.ObjectType proguard.classfile.attribute.preverification.VerificationTypeFactory.createObjectType(int)"
  })
  void testCreateObjectType() {
    // Arrange and Act
    ObjectType actualCreateObjectTypeResult = VerificationTypeFactory.createObjectType(1);

    // Assert
    assertNull(actualCreateObjectTypeResult.getProcessingInfo());
    assertEquals(0, actualCreateObjectTypeResult.getProcessingFlags());
    assertEquals(1, actualCreateObjectTypeResult.u2classIndex);
    assertEquals(7, actualCreateObjectTypeResult.getTag());
  }
}
