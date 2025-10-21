package proguard.io;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DataEntryReaderFactoryDiffblueTest {
  /**
   * Test {@link DataEntryReaderFactory#getFilterExcludingVersionedClasses(ClassPathEntry)}.
   *
   * <p>Method under test: {@link
   * DataEntryReaderFactory#getFilterExcludingVersionedClasses(ClassPathEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "List DataEntryReaderFactory.getFilterExcludingVersionedClasses(ClassPathEntry)"
  })
  public void testGetFilterExcludingVersionedClasses() {
    // Arrange and Act
    List<String> actualFilterExcludingVersionedClasses =
        DataEntryReaderFactory.getFilterExcludingVersionedClasses(
            new ClassPathEntry(
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true));

    // Assert
    assertEquals(1, actualFilterExcludingVersionedClasses.size());
    assertEquals("!META-INF/versions/**", actualFilterExcludingVersionedClasses.get(0));
  }

  /**
   * Test {@link DataEntryReaderFactory#getFilterExcludingVersionedClasses(ClassPathEntry)}.
   *
   * <ul>
   *   <li>Then return first is {@code META-INF/versions}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DataEntryReaderFactory#getFilterExcludingVersionedClasses(ClassPathEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "List DataEntryReaderFactory.getFilterExcludingVersionedClasses(ClassPathEntry)"
  })
  public void testGetFilterExcludingVersionedClasses_thenReturnFirstIsMetaInfVersions() {
    // Arrange
    ArrayList<String> filter = new ArrayList<>();
    filter.add("META-INF/versions");

    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);
    classPathEntry.setFilter(filter);

    // Act
    List<String> actualFilterExcludingVersionedClasses =
        DataEntryReaderFactory.getFilterExcludingVersionedClasses(classPathEntry);

    // Assert
    assertEquals(1, actualFilterExcludingVersionedClasses.size());
    assertEquals("META-INF/versions", actualFilterExcludingVersionedClasses.get(0));
  }

  /**
   * Test {@link DataEntryReaderFactory#getFilterExcludingVersionedClasses(ClassPathEntry)}.
   *
   * <ul>
   *   <li>Then return second is {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DataEntryReaderFactory#getFilterExcludingVersionedClasses(ClassPathEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "List DataEntryReaderFactory.getFilterExcludingVersionedClasses(ClassPathEntry)"
  })
  public void testGetFilterExcludingVersionedClasses_thenReturnSecondIsFoo() {
    // Arrange
    ArrayList<String> filter = new ArrayList<>();
    filter.add("foo");

    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);
    classPathEntry.setFilter(filter);

    // Act
    List<String> actualFilterExcludingVersionedClasses =
        DataEntryReaderFactory.getFilterExcludingVersionedClasses(classPathEntry);

    // Assert
    assertEquals(2, actualFilterExcludingVersionedClasses.size());
    assertEquals("!META-INF/versions/**", actualFilterExcludingVersionedClasses.get(0));
    assertEquals("foo", actualFilterExcludingVersionedClasses.get(1));
  }

  /**
   * Test {@link DataEntryReaderFactory#getFilterExcludingVersionedClasses(ClassPathEntry)}.
   *
   * <ul>
   *   <li>Then return second is {@code META-INF/versions}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DataEntryReaderFactory#getFilterExcludingVersionedClasses(ClassPathEntry)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "List DataEntryReaderFactory.getFilterExcludingVersionedClasses(ClassPathEntry)"
  })
  public void testGetFilterExcludingVersionedClasses_thenReturnSecondIsMetaInfVersions() {
    // Arrange
    ArrayList<String> filter = new ArrayList<>();
    filter.add("foo");
    filter.add("META-INF/versions");

    ClassPathEntry classPathEntry =
        new ClassPathEntry(
            Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile(), true);
    classPathEntry.setFilter(filter);

    // Act
    List<String> actualFilterExcludingVersionedClasses =
        DataEntryReaderFactory.getFilterExcludingVersionedClasses(classPathEntry);

    // Assert
    assertEquals(2, actualFilterExcludingVersionedClasses.size());
    assertEquals("META-INF/versions", actualFilterExcludingVersionedClasses.get(1));
    assertEquals("foo", actualFilterExcludingVersionedClasses.get(0));
  }
}
