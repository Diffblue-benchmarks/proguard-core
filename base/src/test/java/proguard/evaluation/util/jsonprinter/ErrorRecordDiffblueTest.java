package proguard.evaluation.util.jsonprinter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class ErrorRecordDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ErrorRecord#ErrorRecord(int, String)}
   *   <li>{@link ErrorRecord#getInstructionOffset()}
   *   <li>{@link ErrorRecord#getMessage()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ErrorRecord actualErrorRecord = new ErrorRecord(1, "Not all who wander are lost");
    int actualInstructionOffset = actualErrorRecord.getInstructionOffset();

    // Assert
    assertEquals("Not all who wander are lost", actualErrorRecord.getMessage());
    assertEquals(1, actualInstructionOffset);
  }

  /**
   * Method under test: {@link ErrorRecord#toJson(StringBuilder)}
   */
  @Test
  public void testToJson() {
    // Arrange
    ErrorRecord errorRecord = new ErrorRecord(1, "Not all who wander are lost");
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualToJsonResult = errorRecord.toJson(builder);

    // Assert
    assertEquals("foo{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"}", builder.toString());
    assertEquals("foo{\"instructionOffset\":1,\"message\":\"Not all who wander are lost\"}",
        actualToJsonResult.toString());
    assertSame(builder, actualToJsonResult);
  }
}
