package proguard.io;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.HashSet;
import org.junit.Test;
import proguard.util.CollectionMatcher;
import proguard.util.ConstantMatcher;
import proguard.util.EmptyStringMatcher;

public class DataEntryNameFilterDiffblueTest {
  /**
   * Method under test: {@link DataEntryNameFilter#accepts(DataEntry)}
   */
  @Test
  public void testAccepts() {
    // Arrange
    DataEntryNameFilter dataEntryNameFilter = new DataEntryNameFilter(new EmptyStringMatcher());

    // Act and Assert
    assertFalse(dataEntryNameFilter.accepts(new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test: {@link DataEntryNameFilter#accepts(DataEntry)}
   */
  @Test
  public void testAccepts2() {
    // Arrange, Act and Assert
    assertFalse((new DataEntryNameFilter(new EmptyStringMatcher())).accepts(null));
  }

  /**
   * Method under test: {@link DataEntryNameFilter#accepts(DataEntry)}
   */
  @Test
  public void testAccepts3() {
    // Arrange
    DataEntryNameFilter dataEntryNameFilter = new DataEntryNameFilter(new CollectionMatcher(new HashSet<>()));

    // Act and Assert
    assertFalse(dataEntryNameFilter.accepts(new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test: {@link DataEntryNameFilter#accepts(DataEntry)}
   */
  @Test
  public void testAccepts4() {
    // Arrange
    DataEntryNameFilter dataEntryNameFilter = new DataEntryNameFilter(new ConstantMatcher(true));

    // Act and Assert
    assertTrue(dataEntryNameFilter.accepts(new ClassPathDataEntry("Name")));
  }
}
