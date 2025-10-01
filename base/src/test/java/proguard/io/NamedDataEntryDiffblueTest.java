package proguard.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NamedDataEntry.<init>(DataEntry, String, long, boolean)"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NamedDataEntry.getOriginalName()"})
  void testGetOriginalName() {
    // Arrange
    NamedDataEntry namedDataEntry =
        new NamedDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true);

    // Act and Assert
    assertEquals("Name", namedDataEntry.getOriginalName());
  }

  /**
   * Test {@link NamedDataEntry#getInputStream()}.
   *
   * <p>Method under test: {@link NamedDataEntry#getInputStream()}
   */
  @Test
  @DisplayName("Test getInputStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.InputStream NamedDataEntry.getInputStream()"})
  void testGetInputStream() throws IOException {
    // Arrange
    NamedDataEntry namedDataEntry =
        new NamedDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> namedDataEntry.getInputStream());
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NamedDataEntry.closeInputStream()",
    "String NamedDataEntry.getName()",
    "DataEntry NamedDataEntry.getParent()",
    "long NamedDataEntry.getSize()",
    "boolean NamedDataEntry.isDirectory()",
    "String NamedDataEntry.toString()"
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
