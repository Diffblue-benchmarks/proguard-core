package proguard.evaluation.util.jsonprinter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ExceptionHandlerRecordDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ExceptionHandlerRecord#ExceptionHandlerRecord(int, int, int, String)}
   *   <li>{@link ExceptionHandlerRecord#getCatchEndOffset()}
   *   <li>{@link ExceptionHandlerRecord#getCatchStartOffset()}
   *   <li>{@link ExceptionHandlerRecord#getCatchType()}
   *   <li>{@link ExceptionHandlerRecord#getHandlerStartOffset()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ExceptionHandlerRecord.<init>(int, int, int, String)",
    "int ExceptionHandlerRecord.getCatchEndOffset()",
    "int ExceptionHandlerRecord.getCatchStartOffset()",
    "String ExceptionHandlerRecord.getCatchType()",
    "int ExceptionHandlerRecord.getHandlerStartOffset()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ExceptionHandlerRecord actualExceptionHandlerRecord =
        new ExceptionHandlerRecord(1, 1, 1, "Catch Type");
    int actualCatchEndOffset = actualExceptionHandlerRecord.getCatchEndOffset();
    int actualCatchStartOffset = actualExceptionHandlerRecord.getCatchStartOffset();
    String actualCatchType = actualExceptionHandlerRecord.getCatchType();

    // Assert
    assertEquals("Catch Type", actualCatchType);
    assertEquals(1, actualCatchEndOffset);
    assertEquals(1, actualCatchStartOffset);
    assertEquals(1, actualExceptionHandlerRecord.getHandlerStartOffset());
  }

  /**
   * Test {@link ExceptionHandlerRecord#toJson(StringBuilder)}.
   *
   * <p>Method under test: {@link ExceptionHandlerRecord#toJson(StringBuilder)}
   */
  @Test
  @DisplayName("Test toJson(StringBuilder)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"StringBuilder ExceptionHandlerRecord.toJson(StringBuilder)"})
  void testToJson() {
    // Arrange
    ExceptionHandlerRecord exceptionHandlerRecord =
        new ExceptionHandlerRecord(1, 1, 1, "Catch Type");
    StringBuilder builder = new StringBuilder("Str");

    // Act
    StringBuilder actualToJsonResult = exceptionHandlerRecord.toJson(builder);

    // Assert
    assertEquals(
        "Str{\"catchStartOffset\":1,\"catchEndOffset\":1,\"handlerStartOffset\":1,\"catchType\":\"Catch Type\"}",
        builder.toString());
    assertSame(builder, actualToJsonResult);
  }
}
