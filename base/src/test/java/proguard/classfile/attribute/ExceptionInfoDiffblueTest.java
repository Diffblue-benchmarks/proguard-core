package proguard.classfile.attribute;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ExceptionInfoDiffblueTest {
  /**
   * Test {@link ExceptionInfo#ExceptionInfo()}.
   *
   * <p>Method under test: {@link ExceptionInfo#ExceptionInfo()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ExceptionInfo.<init>()",
    "void ExceptionInfo.<init>(int, int, int, int)"
  })
  public void testNewExceptionInfo() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ExceptionInfo.<init>()",
    "void ExceptionInfo.<init>(int, int, int, int)"
  })
  public void testNewExceptionInfo_whenOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExceptionInfo.isApplicable(int)"})
  public void testIsApplicableWithInstructionOffset() {
    // Arrange, Act and Assert
    assertFalse((new ExceptionInfo(3, 3, 1, 1)).isApplicable(1));
  }

  /**
   * Test {@link ExceptionInfo#isApplicable(int)} with {@code instructionOffset}.
   *
   * <p>Method under test: {@link ExceptionInfo#isApplicable(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExceptionInfo.isApplicable(int)"})
  public void testIsApplicableWithInstructionOffset2() {
    // Arrange, Act and Assert
    assertFalse((new ExceptionInfo(1, 1, 1, 1)).isApplicable(1));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExceptionInfo.isApplicable(int)"})
  public void testIsApplicableWithInstructionOffset_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new ExceptionInfo(1, 3, 1, 1)).isApplicable(1));
  }

  /**
   * Test {@link ExceptionInfo#isApplicable(int, int)} with {@code startOffset}, {@code endOffset}.
   *
   * <p>Method under test: {@link ExceptionInfo#isApplicable(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExceptionInfo.isApplicable(int, int)"})
  public void testIsApplicableWithStartOffsetEndOffset() {
    // Arrange, Act and Assert
    assertFalse((new ExceptionInfo(3, 3, 1, 1)).isApplicable(1, 3));
  }

  /**
   * Test {@link ExceptionInfo#isApplicable(int, int)} with {@code startOffset}, {@code endOffset}.
   *
   * <p>Method under test: {@link ExceptionInfo#isApplicable(int, int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExceptionInfo.isApplicable(int, int)"})
  public void testIsApplicableWithStartOffsetEndOffset2() {
    // Arrange, Act and Assert
    assertFalse((new ExceptionInfo(1, 1, 1, 1)).isApplicable(1, 3));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ExceptionInfo.isApplicable(int, int)"})
  public void testIsApplicableWithStartOffsetEndOffset_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new ExceptionInfo(1, 3, 1, 1)).isApplicable(1, 3));
  }
}
