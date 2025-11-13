package proguard.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ClassPathDataEntryDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ClassPathDataEntry#ClassPathDataEntry(String)}
   *   <li>{@link ClassPathDataEntry#toString()}
   *   <li>{@link ClassPathDataEntry#getName()}
   *   <li>{@link ClassPathDataEntry#getOriginalName()}
   *   <li>{@link ClassPathDataEntry#getParent()}
   *   <li>{@link ClassPathDataEntry#getSize()}
   *   <li>{@link ClassPathDataEntry#isDirectory()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ClassPathDataEntry.<init>(String)",
    "String ClassPathDataEntry.getName()",
    "String ClassPathDataEntry.getOriginalName()",
    "DataEntry ClassPathDataEntry.getParent()",
    "long ClassPathDataEntry.getSize()",
    "boolean ClassPathDataEntry.isDirectory()",
    "String ClassPathDataEntry.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ClassPathDataEntry actualClassPathDataEntry = new ClassPathDataEntry("Name");
    String actualToStringResult = actualClassPathDataEntry.toString();
    String actualName = actualClassPathDataEntry.getName();
    String actualOriginalName = actualClassPathDataEntry.getOriginalName();
    DataEntry actualParent = actualClassPathDataEntry.getParent();
    long actualSize = actualClassPathDataEntry.getSize();

    // Assert
    assertEquals("Name", actualName);
    assertEquals("Name", actualOriginalName);
    assertEquals("Name", actualToStringResult);
    assertNull(actualParent);
    assertEquals(-1L, actualSize);
    assertFalse(actualClassPathDataEntry.isDirectory());
  }
}
