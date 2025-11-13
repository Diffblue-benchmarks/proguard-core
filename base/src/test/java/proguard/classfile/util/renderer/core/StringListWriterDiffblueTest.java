package proguard.classfile.util.renderer.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StringListWriter.<init>(List)", "List StringListWriter.getOutput()"})
  void testGettersAndSetters() {
    // Arrange
    ArrayList<String> output = new ArrayList<>();

    // Act
    List<String> actualOutput = new StringListWriter(output).getOutput();

    // Assert
    assertTrue(actualOutput.isEmpty());
    assertSame(output, actualOutput);
  }

  /**
   * Test {@link StringListWriter#write(String)} with {@code str}.
   *
   * <ul>
   *   <li>Then {@link StringListWriter#StringListWriter(List)} with output is {@link
   *       ArrayList#ArrayList()} Output first is {@code Str}.
   * </ul>
   *
   * <p>Method under test: {@link StringListWriter#write(String)}
   */
  @Test
  @DisplayName(
      "Test write(String) with 'str'; then StringListWriter(List) with output is ArrayList() Output first is 'Str'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StringListWriter.write(String)"})
  void testWriteWithStr_thenStringListWriterWithOutputIsArrayListOutputFirstIsStr()
      throws IOException {
    // Arrange
    ArrayList<String> output = new ArrayList<>();
    StringListWriter stringListWriter = new StringListWriter(output);

    // Act
    stringListWriter.write("Str");

    // Assert
    List<String> output2 = stringListWriter.getOutput();
    assertEquals(1, output2.size());
    assertEquals("Str", output2.get(0));
    assertSame(output, output2);
  }

  /**
   * Test {@link StringListWriter#write(String)} with {@code str}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link StringListWriter#write(String)}
   */
  @Test
  @DisplayName("Test write(String) with 'str'; when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StringListWriter.write(String)"})
  void testWriteWithStr_whenEmptyString() throws IOException {
    // Arrange
    ArrayList<String> output = new ArrayList<>();
    StringListWriter stringListWriter = new StringListWriter(output);

    // Act
    stringListWriter.write("");

    // Assert
    List<String> output2 = stringListWriter.getOutput();
    assertEquals(1, output2.size());
    assertEquals("", output2.get(0));
    assertSame(output, output2);
  }

  /**
   * Test {@link StringListWriter#write(String)} with {@code str}.
   *
   * <ul>
   *   <li>When lf.
   * </ul>
   *
   * <p>Method under test: {@link StringListWriter#write(String)}
   */
  @Test
  @DisplayName("Test write(String) with 'str'; when lf")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StringListWriter.write(String)"})
  void testWriteWithStr_whenLf() throws IOException {
    // Arrange
    ArrayList<String> output = new ArrayList<>();
    StringListWriter stringListWriter = new StringListWriter(output);

    // Act
    stringListWriter.write("\n");

    // Assert
    List<String> output2 = stringListWriter.getOutput();
    assertEquals(1, output2.size());
    assertEquals("", output2.get(0));
    assertSame(output, output2);
  }

  /**
   * Test {@link StringListWriter#flush()}.
   *
   * <ul>
   *   <li>Then {@link StringListWriter#StringListWriter(List)} with output is {@link
   *       ArrayList#ArrayList()} Output size is one.
   * </ul>
   *
   * <p>Method under test: {@link StringListWriter#flush()}
   */
  @Test
  @DisplayName(
      "Test flush(); then StringListWriter(List) with output is ArrayList() Output size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StringListWriter.flush()"})
  void testFlush_thenStringListWriterWithOutputIsArrayListOutputSizeIsOne() throws IOException {
    // Arrange
    ArrayList<String> output = new ArrayList<>();
    StringListWriter stringListWriter = new StringListWriter(output);

    // Act
    stringListWriter.flush();

    // Assert
    List<String> output2 = stringListWriter.getOutput();
    assertEquals(1, output2.size());
    assertEquals("", output2.get(0));
    assertSame(output, output2);
  }

  /**
   * Test {@link StringListWriter#close()}.
   *
   * <ul>
   *   <li>Then {@link StringListWriter#StringListWriter(List)} with output is {@link
   *       ArrayList#ArrayList()} Output size is one.
   * </ul>
   *
   * <p>Method under test: {@link StringListWriter#close()}
   */
  @Test
  @DisplayName(
      "Test close(); then StringListWriter(List) with output is ArrayList() Output size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void StringListWriter.close()"})
  void testClose_thenStringListWriterWithOutputIsArrayListOutputSizeIsOne() throws IOException {
    // Arrange
    ArrayList<String> output = new ArrayList<>();
    StringListWriter stringListWriter = new StringListWriter(output);

    // Act
    stringListWriter.close();

    // Assert
    List<String> output2 = stringListWriter.getOutput();
    assertEquals(1, output2.size());
    assertEquals("", output2.get(0));
    assertSame(output, output2);
  }
}
