package proguard.evaluation.util.jsonprinter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class ExceptionHandlerRecordDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ExceptionHandlerRecord#ExceptionHandlerRecord(int, int, int, String)}
   *   <li>{@link ExceptionHandlerRecord#getCatchEndOffset()}
   *   <li>{@link ExceptionHandlerRecord#getCatchStartOffset()}
   *   <li>{@link ExceptionHandlerRecord#getCatchType()}
   *   <li>{@link ExceptionHandlerRecord#getHandlerStartOffset()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ExceptionHandlerRecord actualExceptionHandlerRecord = new ExceptionHandlerRecord(1, 1, 1, "Catch Type");
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
   * Method under test: {@link ExceptionHandlerRecord#toJson(StringBuilder)}
   */
  @Test
  public void testToJson() {
    // Arrange
    ExceptionHandlerRecord exceptionHandlerRecord = new ExceptionHandlerRecord(1, 1, 1, "Catch Type");
    StringBuilder builder = new StringBuilder("foo");

    // Act
    StringBuilder actualToJsonResult = exceptionHandlerRecord.toJson(builder);

    // Assert
    assertEquals(
        "foo{\"catchStartOffset\":1,\"catchEndOffset\":1,\"handlerStartOffset\":1,\"catchType\":\"Catch Type\"}",
        builder.toString());
    assertEquals(
        "foo{\"catchStartOffset\":1,\"catchEndOffset\":1,\"handlerStartOffset\":1,\"catchType\":\"Catch Type\"}",
        actualToJsonResult.toString());
    assertSame(builder, actualToJsonResult);
  }
}
