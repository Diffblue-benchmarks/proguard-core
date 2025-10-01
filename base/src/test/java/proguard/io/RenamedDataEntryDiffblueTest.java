package proguard.io;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RenamedDataEntryDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RenamedDataEntry#RenamedDataEntry(DataEntry, String)}
   *   <li>{@link RenamedDataEntry#toString()}
   *   <li>{@link RenamedDataEntry#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RenamedDataEntry.<init>(DataEntry, String)",
    "String RenamedDataEntry.getName()",
    "String RenamedDataEntry.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    RenamedDataEntry actualRenamedDataEntry =
        new RenamedDataEntry(new ClassPathDataEntry("Name"), "Name");
    String actualToStringResult = actualRenamedDataEntry.toString();

    // Assert
    assertEquals("Name == Name", actualToStringResult);
    assertEquals("Name", actualRenamedDataEntry.getName());
  }
}
