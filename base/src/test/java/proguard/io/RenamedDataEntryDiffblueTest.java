package proguard.io;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.io.RenamedDataEntry.<init>(proguard.io.DataEntry, java.lang.String)",
    "java.lang.String proguard.io.RenamedDataEntry.getName()",
    "java.lang.String proguard.io.RenamedDataEntry.toString()"
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
