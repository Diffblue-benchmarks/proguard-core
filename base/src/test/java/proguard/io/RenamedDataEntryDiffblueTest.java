package proguard.io;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class RenamedDataEntryDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void RenamedDataEntry.<init>(DataEntry, String)",
    "String RenamedDataEntry.getName()",
    "String RenamedDataEntry.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    RenamedDataEntry actualRenamedDataEntry =
        new RenamedDataEntry(new ClassPathDataEntry("Name"), "Name");
    String actualToStringResult = actualRenamedDataEntry.toString();

    // Assert
    assertEquals("Name == Name", actualToStringResult);
    assertEquals("Name", actualRenamedDataEntry.getName());
  }
}
