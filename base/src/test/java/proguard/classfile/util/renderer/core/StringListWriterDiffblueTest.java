package proguard.classfile.util.renderer.core;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class StringListWriterDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StringListWriter#StringListWriter(List)}
   *   <li>{@link StringListWriter#getOutput()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StringListWriter.<init>(List)", "List StringListWriter.getOutput()"})
  public void testGettersAndSetters() {
    // Arrange
    ArrayList<String> output = new ArrayList<>();

    // Act
    List<String> actualOutput = (new StringListWriter(output)).getOutput();

    // Assert
    assertTrue(actualOutput.isEmpty());
    assertSame(output, actualOutput);
  }
}
