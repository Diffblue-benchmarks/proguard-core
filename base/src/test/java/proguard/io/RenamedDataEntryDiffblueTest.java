package proguard.io;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RenamedDataEntryDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RenamedDataEntry#RenamedDataEntry(DataEntry, String)}
   *   <li>{@link RenamedDataEntry#toString()}
   *   <li>{@link RenamedDataEntry#getName()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    RenamedDataEntry actualRenamedDataEntry = new RenamedDataEntry(new ClassPathDataEntry("Name"), "Name");
    String actualToStringResult = actualRenamedDataEntry.toString();

    // Assert
    assertEquals("Name == Name", actualToStringResult);
    assertEquals("Name", actualRenamedDataEntry.getName());
  }
}
