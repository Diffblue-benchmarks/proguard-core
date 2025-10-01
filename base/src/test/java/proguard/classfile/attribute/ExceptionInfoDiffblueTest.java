package proguard.classfile.attribute;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ExceptionInfoDiffblueTest {
  /**
   * Test {@link ExceptionInfo#ExceptionInfo()}.
   *
   * <p>Method under test: {@link ExceptionInfo#ExceptionInfo()}
   */
  @Test
  @DisplayName("Test new ExceptionInfo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ExceptionInfo.<init>()",
    "void ExceptionInfo.<init>(int, int, int, int)"
  })
  void testNewExceptionInfo() {
    // Arrange and Act
    ExceptionInfo actualExceptionInfo = new ExceptionInfo();

    // Assert
    assertNull(actualExceptionInfo.getProcessingInfo());
    assertEquals(0, actualExceptionInfo.getProcessingFlags());
  }

  /**
   * Test {@link ExceptionInfo#ExceptionInfo(int, int, int, int)}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link ExceptionInfo#ExceptionInfo(int, int, int, int)}
   */
  @Test
  @DisplayName("Test new ExceptionInfo(int, int, int, int); when one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ExceptionInfo.<init>()",
    "void ExceptionInfo.<init>(int, int, int, int)"
  })
  void testNewExceptionInfo_whenOne() {
    // Arrange and Act
    ExceptionInfo actualExceptionInfo = new ExceptionInfo(1, 3, 1, 1);

    // Assert
    assertNull(actualExceptionInfo.getProcessingInfo());
    assertEquals(0, actualExceptionInfo.getProcessingFlags());
  }

  /**
   * Test {@link ExceptionInfo#isApplicable(int)} with {@code instructionOffset}.
   *
   * <p>Method under test: {@link ExceptionInfo#isApplicable(int)}
   */
  @Test
  @DisplayName("Test isApplicable(int) with 'instructionOffset'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ExceptionInfo.isApplicable(int)"})
  void testIsApplicableWithInstructionOffset() {
    // Arrange
    ExceptionInfo exceptionInfo = new ExceptionInfo(3, 3, 1, 1);

    // Act and Assert
    assertFalse(exceptionInfo.isApplicable(1));
  }

  /**
   * Test {@link ExceptionInfo#isApplicable(int)} with {@code instructionOffset}.
   *
   * <p>Method under test: {@link ExceptionInfo#isApplicable(int)}
   */
  @Test
  @DisplayName("Test isApplicable(int) with 'instructionOffset'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ExceptionInfo.isApplicable(int)"})
  void testIsApplicableWithInstructionOffset2() {
    // Arrange
    ExceptionInfo exceptionInfo = new ExceptionInfo(1, 1, 1, 1);

    // Act and Assert
    assertFalse(exceptionInfo.isApplicable(1));
  }

  /**
   * Test {@link ExceptionInfo#isApplicable(int)} with {@code instructionOffset}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ExceptionInfo#isApplicable(int)}
   */
  @Test
  @DisplayName("Test isApplicable(int) with 'instructionOffset'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ExceptionInfo.isApplicable(int)"})
  void testIsApplicableWithInstructionOffset_thenReturnTrue() {
    // Arrange
    ExceptionInfo exceptionInfo = new ExceptionInfo(1, 3, 1, 1);

    // Act and Assert
    assertTrue(exceptionInfo.isApplicable(1));
  }

  /**
   * Test {@link ExceptionInfo#isApplicable(int, int)} with {@code startOffset}, {@code endOffset}.
   *
   * <p>Method under test: {@link ExceptionInfo#isApplicable(int, int)}
   */
  @Test
  @DisplayName("Test isApplicable(int, int) with 'startOffset', 'endOffset'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ExceptionInfo.isApplicable(int, int)"})
  void testIsApplicableWithStartOffsetEndOffset() {
    // Arrange
    ExceptionInfo exceptionInfo = new ExceptionInfo(3, 3, 1, 1);

    // Act and Assert
    assertFalse(exceptionInfo.isApplicable(1, 3));
  }

  /**
   * Test {@link ExceptionInfo#isApplicable(int, int)} with {@code startOffset}, {@code endOffset}.
   *
   * <p>Method under test: {@link ExceptionInfo#isApplicable(int, int)}
   */
  @Test
  @DisplayName("Test isApplicable(int, int) with 'startOffset', 'endOffset'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ExceptionInfo.isApplicable(int, int)"})
  void testIsApplicableWithStartOffsetEndOffset2() {
    // Arrange
    ExceptionInfo exceptionInfo = new ExceptionInfo(1, 1, 1, 1);

    // Act and Assert
    assertFalse(exceptionInfo.isApplicable(1, 3));
  }

  /**
   * Test {@link ExceptionInfo#isApplicable(int, int)} with {@code startOffset}, {@code endOffset}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ExceptionInfo#isApplicable(int, int)}
   */
  @Test
  @DisplayName("Test isApplicable(int, int) with 'startOffset', 'endOffset'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ExceptionInfo.isApplicable(int, int)"})
  void testIsApplicableWithStartOffsetEndOffset_thenReturnTrue() {
    // Arrange
    ExceptionInfo exceptionInfo = new ExceptionInfo(1, 3, 1, 1);

    // Act and Assert
    assertTrue(exceptionInfo.isApplicable(1, 3));
  }
}
