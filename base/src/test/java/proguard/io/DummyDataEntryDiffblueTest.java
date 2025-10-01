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

class DummyDataEntryDiffblueTest {
  /**
   * Test {@link DummyDataEntry#DummyDataEntry(DataEntry, String, long, boolean)}.
   *
   * <p>Method under test: {@link DummyDataEntry#DummyDataEntry(DataEntry, String, long, boolean)}
   */
  @Test
  @DisplayName("Test new DummyDataEntry(DataEntry, String, long, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DummyDataEntry.<init>(DataEntry, String, long, boolean)"})
  void testNewDummyDataEntry() {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");

    // Act
    DummyDataEntry actualDummyDataEntry = new DummyDataEntry(parent, "Name", 3L, true);

    // Assert
    assertEquals("Name", actualDummyDataEntry.getName());
    assertEquals("Name", actualDummyDataEntry.getOriginalName());
    assertEquals(3L, actualDummyDataEntry.getSize());
    assertTrue(actualDummyDataEntry.isDirectory());
    assertSame(parent, actualDummyDataEntry.getParent());
  }

  /**
   * Test {@link DummyDataEntry#getOriginalName()}.
   *
   * <p>Method under test: {@link DummyDataEntry#getOriginalName()}
   */
  @Test
  @DisplayName("Test getOriginalName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String DummyDataEntry.getOriginalName()"})
  void testGetOriginalName() {
    // Arrange
    DummyDataEntry dummyDataEntry =
        new DummyDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true);

    // Act and Assert
    assertEquals("Name", dummyDataEntry.getOriginalName());
  }

  /**
   * Test {@link DummyDataEntry#getInputStream()}.
   *
   * <p>Method under test: {@link DummyDataEntry#getInputStream()}
   */
  @Test
  @DisplayName("Test getInputStream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.InputStream DummyDataEntry.getInputStream()"})
  void testGetInputStream() throws IOException {
    // Arrange
    DummyDataEntry dummyDataEntry =
        new DummyDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> dummyDataEntry.getInputStream());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DummyDataEntry#closeInputStream()}
   *   <li>{@link DummyDataEntry#toString()}
   *   <li>{@link DummyDataEntry#getName()}
   *   <li>{@link DummyDataEntry#getParent()}
   *   <li>{@link DummyDataEntry#getSize()}
   *   <li>{@link DummyDataEntry#isDirectory()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DummyDataEntry.closeInputStream()",
    "String DummyDataEntry.getName()",
    "DataEntry DummyDataEntry.getParent()",
    "long DummyDataEntry.getSize()",
    "boolean DummyDataEntry.isDirectory()",
    "String DummyDataEntry.toString()"
  })
  void testGettersAndSetters() throws IOException {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");
    DummyDataEntry dummyDataEntry = new DummyDataEntry(parent, "Name", 3L, true);

    // Act
    dummyDataEntry.closeInputStream();
    String actualToStringResult = dummyDataEntry.toString();
    String actualName = dummyDataEntry.getName();
    DataEntry actualParent = dummyDataEntry.getParent();
    long actualSize = dummyDataEntry.getSize();

    // Assert
    assertEquals("Name", actualName);
    assertEquals("Name:Name", actualToStringResult);
    assertEquals(3L, actualSize);
    assertTrue(dummyDataEntry.isDirectory());
    assertSame(parent, actualParent);
  }
}
