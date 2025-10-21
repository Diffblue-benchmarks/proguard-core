package proguard.io;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.util.CollectionMatcher;
import proguard.util.ConstantMatcher;
import proguard.util.EmptyStringMatcher;

public class DataEntryNameFilterDiffblueTest {
  /**
   * Test {@link DataEntryNameFilter#accepts(DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link CollectionMatcher#CollectionMatcher(Set)} with set is {@link
   *       HashSet#HashSet()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DataEntryNameFilter#accepts(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataEntryNameFilter.accepts(DataEntry)"})
  public void testAccepts_givenCollectionMatcherWithSetIsHashSet_thenReturnFalse() {
    // Arrange
    DataEntryNameFilter dataEntryNameFilter =
        new DataEntryNameFilter(new CollectionMatcher(new HashSet<>()));

    // Act and Assert
    assertFalse(dataEntryNameFilter.accepts(new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link DataEntryNameFilter#accepts(DataEntry)}.
   *
   * <ul>
   *   <li>Given {@link ConstantMatcher#ConstantMatcher(boolean)} with matches is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DataEntryNameFilter#accepts(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataEntryNameFilter.accepts(DataEntry)"})
  public void testAccepts_givenConstantMatcherWithMatchesIsTrue_thenReturnTrue() {
    // Arrange
    DataEntryNameFilter dataEntryNameFilter = new DataEntryNameFilter(new ConstantMatcher(true));

    // Act and Assert
    assertTrue(dataEntryNameFilter.accepts(new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link DataEntryNameFilter#accepts(DataEntry)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DataEntryNameFilter#accepts(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataEntryNameFilter.accepts(DataEntry)"})
  public void testAccepts_thenReturnFalse() {
    // Arrange
    DataEntryNameFilter dataEntryNameFilter = new DataEntryNameFilter(new EmptyStringMatcher());

    // Act and Assert
    assertFalse(dataEntryNameFilter.accepts(new ClassPathDataEntry("Name")));
  }

  /**
   * Test {@link DataEntryNameFilter#accepts(DataEntry)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DataEntryNameFilter#accepts(DataEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DataEntryNameFilter.accepts(DataEntry)"})
  public void testAccepts_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new DataEntryNameFilter(new EmptyStringMatcher())).accepts(null));
  }
}
