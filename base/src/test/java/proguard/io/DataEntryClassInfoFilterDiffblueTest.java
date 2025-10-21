package proguard.io;

import static org.junit.Assert.assertFalse;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.kotlin.KotlinConstants;

public class DataEntryClassInfoFilterDiffblueTest {
  /**
   * Test {@link DataEntryClassInfoFilter#accepts(DataEntry)}.
   *
   * <ul>
   *   <li>When {@link ClassPathDataEntry#ClassPathDataEntry(String)} with name is {@code .class}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DataEntryClassInfoFilter#accepts(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataEntryClassInfoFilter.accepts(DataEntry)"})
  public void testAccepts_whenClassPathDataEntryWithNameIsClass_thenReturnFalse() {
    // Arrange
    DataEntryClassInfoFilter dataEntryClassInfoFilter =
        new DataEntryClassInfoFilter(KotlinConstants.dummyClassPool, "Processing Info");

    // Act and Assert
    assertFalse(dataEntryClassInfoFilter.accepts(new ClassPathDataEntry(".class")));
  }

  /**
   * Test {@link DataEntryClassInfoFilter#accepts(DataEntry)}.
   *
   * <ul>
   *   <li>When {@link ClassPathDataEntry#ClassPathDataEntry(String)} with {@code Name}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DataEntryClassInfoFilter#accepts(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataEntryClassInfoFilter.accepts(DataEntry)"})
  public void testAccepts_whenClassPathDataEntryWithName_thenReturnFalse() {
    // Arrange
    DataEntryClassInfoFilter dataEntryClassInfoFilter =
        new DataEntryClassInfoFilter(KotlinConstants.dummyClassPool, "Processing Info");

    // Act and Assert
    assertFalse(dataEntryClassInfoFilter.accepts(new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link DataEntryClassInfoFilter#accepts(DataEntry)}.
   *
   * <ul>
   *   <li>When {@code Object}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DataEntryClassInfoFilter#accepts(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataEntryClassInfoFilter.accepts(DataEntry)"})
  public void testAccepts_whenJavaLangObject_thenReturnFalse() {
    // Arrange
    DataEntryClassInfoFilter dataEntryClassInfoFilter =
        new DataEntryClassInfoFilter(KotlinConstants.dummyClassPool, "Processing Info");
    Class<Object> clazz = Object.class;

    // Act and Assert
    assertFalse(dataEntryClassInfoFilter.accepts(new ClassPathDataEntry(clazz)));
  }
}
