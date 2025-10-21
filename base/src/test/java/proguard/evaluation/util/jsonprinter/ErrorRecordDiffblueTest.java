package proguard.evaluation.util.jsonprinter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ErrorRecordDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ErrorRecord.<init>(int, String)",
    "int ErrorRecord.getInstructionOffset()",
    "String ErrorRecord.getMessage()"
  })
  public void testGettersAndSetters() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"StringBuilder ErrorRecord.toJson(StringBuilder)"})
  public void testToJson() {
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
