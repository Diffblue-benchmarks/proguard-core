package proguard.evaluation.util.jsonprinter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ErrorRecordDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ErrorRecord#ErrorRecord(int, String)}
   *   <li>{@link ErrorRecord#getInstructionOffset()}
   *   <li>{@link ErrorRecord#getMessage()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.util.jsonprinter.ErrorRecord.<init>(int, java.lang.String)",
    "int proguard.evaluation.util.jsonprinter.ErrorRecord.getInstructionOffset()",
    "java.lang.String proguard.evaluation.util.jsonprinter.ErrorRecord.getMessage()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ErrorRecord actualErrorRecord = new ErrorRecord(1, "Not all who wander are lost");
    int actualInstructionOffset = actualErrorRecord.getInstructionOffset();

    // Assert
    assertEquals("Not all who wander are lost", actualErrorRecord.getMessage());
    assertEquals(1, actualInstructionOffset);
  }

  /**
   * Test {@link ErrorRecord#toJson(StringBuilder)}.
   *
   * <p>Method under test: {@link ErrorRecord#toJson(StringBuilder)}
   */
  @Test
  @DisplayName("Test toJson(StringBuilder)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.StringBuilder proguard.evaluation.util.jsonprinter.ErrorRecord.toJson(java.lang.StringBuilder)"
  })
  void testToJson() {
    // Arrange
    ErrorRecord errorRecord = new ErrorRecord(1, "Not all who wander are lost");
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualToJsonResult = errorRecord.toJson(builder);

    // Assert
    assertEquals(
        "foo{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"}",
        builder.toString());
    assertSame(builder, actualToJsonResult);
  }
}
