package proguard.classfile.util.renderer.core;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class StringListWriterDiffblueTest {
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.renderer.core.StringListWriter.<init>(java.util.List)",
    "java.util.List proguard.classfile.util.renderer.core.StringListWriter.getOutput()"
  })
  void testGettersAndSetters() {
    // Arrange
    ArrayList<String> output = new ArrayList<>();

    // Act
    List<String> actualOutput = (new StringListWriter(output)).getOutput();

    // Assert
    assertTrue(actualOutput.isEmpty());
    assertSame(output, actualOutput);
  }
}
