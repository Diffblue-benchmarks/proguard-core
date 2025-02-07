package proguard.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NamedDataEntryDiffblueTest {
  /**
   * Test {@link NamedDataEntry#NamedDataEntry(DataEntry, String, long, boolean)}.
   *
   * <p>Method under test: {@link NamedDataEntry#NamedDataEntry(DataEntry, String, long, boolean)}
   */
  @Test
  @DisplayName("Test new NamedDataEntry(DataEntry, String, long, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.NamedDataEntry.<init>(proguard.io.DataEntry, java.lang.String, long, boolean)"
  })
  void testNewNamedDataEntry() {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");

    // Act
    NamedDataEntry actualNamedDataEntry = new NamedDataEntry(parent, "Name", 3L, true);

    // Assert
    assertEquals("Name", actualNamedDataEntry.getName());
    assertEquals("Name", actualNamedDataEntry.getOriginalName());
    assertEquals(3L, actualNamedDataEntry.getSize());
    assertTrue(actualNamedDataEntry.isDirectory());
    assertSame(parent, actualNamedDataEntry.getParent());
  }

  /**
   * Test {@link NamedDataEntry#getOriginalName()}.
   *
   * <p>Method under test: {@link NamedDataEntry#getOriginalName()}
   */
  @Test
  @DisplayName("Test getOriginalName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String proguard.io.NamedDataEntry.getOriginalName()"})
  void testGetOriginalName() {
    // Arrange, Act and Assert
    assertEquals(
        "Name",
        (new NamedDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true)).getOriginalName());
  }

  /**
   * Test {@link NamedDataEntry#getInputStream()}.
   *
   * <p>Method under test: {@link NamedDataEntry#getInputStream()}
   */
  @Test
  @DisplayName("Test getInputStream()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.io.InputStream proguard.io.NamedDataEntry.getInputStream()"})
  void testGetInputStream() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            (new NamedDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true))
                .getInputStream());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NamedDataEntry#closeInputStream()}
   *   <li>{@link NamedDataEntry#toString()}
   *   <li>{@link NamedDataEntry#getName()}
   *   <li>{@link NamedDataEntry#getParent()}
   *   <li>{@link NamedDataEntry#getSize()}
   *   <li>{@link NamedDataEntry#isDirectory()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.NamedDataEntry.closeInputStream()",
    "java.lang.String proguard.io.NamedDataEntry.getName()",
    "proguard.io.DataEntry proguard.io.NamedDataEntry.getParent()",
    "long proguard.io.NamedDataEntry.getSize()",
    "boolean proguard.io.NamedDataEntry.isDirectory()",
    "java.lang.String proguard.io.NamedDataEntry.toString()"
  })
  void testGettersAndSetters() throws IOException {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");
    NamedDataEntry namedDataEntry = new NamedDataEntry(parent, "Name", 3L, true);

    // Act
    namedDataEntry.closeInputStream();
    String actualToStringResult = namedDataEntry.toString();
    String actualName = namedDataEntry.getName();
    DataEntry actualParent = namedDataEntry.getParent();
    long actualSize = namedDataEntry.getSize();

    // Assert
    assertEquals("Name", actualName);
    assertEquals("Name:Name", actualToStringResult);
    assertEquals(3L, actualSize);
    assertTrue(namedDataEntry.isDirectory());
    assertSame(parent, actualParent);
  }
}
