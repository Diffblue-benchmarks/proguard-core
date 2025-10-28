package proguard.io;

import static org.junit.Assert.assertFalse;
import org.junit.Test;
import proguard.classfile.kotlin.KotlinConstants;

public class DataEntryClassInfoFilterDiffblueTest {
  /**
   * Method under test: {@link DataEntryClassInfoFilter#accepts(DataEntry)}
   */
  @Test
  public void testAccepts() {
    // Arrange
    DataEntryClassInfoFilter dataEntryClassInfoFilter = new DataEntryClassInfoFilter(KotlinConstants.dummyClassPool,
        "Processing Info");

    // Act and Assert
    assertFalse(dataEntryClassInfoFilter.accepts(new ClassPathDataEntry("Name")));
  }

  /**
   * Method under test: {@link DataEntryClassInfoFilter#accepts(DataEntry)}
   */
  @Test
  public void testAccepts2() {
    // Arrange
    DataEntryClassInfoFilter dataEntryClassInfoFilter = new DataEntryClassInfoFilter(KotlinConstants.dummyClassPool,
        "Processing Info");

    // Act and Assert
    assertFalse(dataEntryClassInfoFilter.accepts(new ClassPathDataEntry(".class")));
  }

  /**
   * Method under test: {@link DataEntryClassInfoFilter#accepts(DataEntry)}
   */
  @Test
  public void testAccepts3() {
    // Arrange
    DataEntryClassInfoFilter dataEntryClassInfoFilter = new DataEntryClassInfoFilter(KotlinConstants.dummyClassPool,
        "Processing Info");
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(dataEntryClassInfoFilter.accepts(new ClassPathDataEntry(clazz)));
  }
}
