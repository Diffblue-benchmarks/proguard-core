package proguard.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class WrappedDataEntryDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WrappedDataEntry#WrappedDataEntry(DataEntry)}
   *   <li>{@link WrappedDataEntry#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void WrappedDataEntry.<init>(DataEntry)",
    "java.lang.String WrappedDataEntry.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Name", (new WrappedDataEntry(new ClassPathDataEntry("Name"))).toString());
  }

  /**
   * Test {@link WrappedDataEntry#getName()}.
   *
   * <ul>
   *   <li>Given {@link ClassPathDataEntry#ClassPathDataEntry(String)} with {@code Name}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link WrappedDataEntry#getName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String WrappedDataEntry.getName()"})
  public void testGetName_givenClassPathDataEntryWithName_thenReturnName() {
    // Arrange, Act and Assert
    assertEquals("Name", (new WrappedDataEntry(new ClassPathDataEntry("Name"))).getName());
  }

  /**
   * Test {@link WrappedDataEntry#getName()}.
   *
   * <ul>
   *   <li>Given {@link WrappedDataEntry#WrappedDataEntry(DataEntry)} with wrappedEntry is {@link
   *       WrappedDataEntry#WrappedDataEntry(DataEntry)}.
   * </ul>
   *
   * <p>Method under test: {@link WrappedDataEntry#getName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String WrappedDataEntry.getName()"})
  public void testGetName_givenWrappedDataEntryWithWrappedEntryIsWrappedDataEntry() {
    // Arrange, Act and Assert
    assertEquals(
        "Name",
        (new WrappedDataEntry(new WrappedDataEntry(new ClassPathDataEntry("Name")))).getName());
  }

  /**
   * Test {@link WrappedDataEntry#getOriginalName()}.
   *
   * <p>Method under test: {@link WrappedDataEntry#getOriginalName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String WrappedDataEntry.getOriginalName()"})
  public void testGetOriginalName() {
    // Arrange, Act and Assert
    assertEquals(
        "Name",
        (new WrappedDataEntry(new RenamedDataEntry(new ClassPathDataEntry("Name"), "Name")))
            .getOriginalName());
  }

  /**
   * Test {@link WrappedDataEntry#getOriginalName()}.
   *
   * <ul>
   *   <li>Given {@link WrappedDataEntry#WrappedDataEntry(DataEntry)} with wrappedEntry is {@link
   *       ClassPathDataEntry#ClassPathDataEntry(String)}.
   * </ul>
   *
   * <p>Method under test: {@link WrappedDataEntry#getOriginalName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String WrappedDataEntry.getOriginalName()"})
  public void testGetOriginalName_givenWrappedDataEntryWithWrappedEntryIsClassPathDataEntry() {
    // Arrange, Act and Assert
    assertEquals("Name", (new WrappedDataEntry(new ClassPathDataEntry("Name"))).getOriginalName());
  }

  /**
   * Test {@link WrappedDataEntry#getSize()}.
   *
   * <ul>
   *   <li>Given {@link RenamedDataEntry#RenamedDataEntry(DataEntry, String)} with dataEntry is
   *       {@link ClassPathDataEntry#ClassPathDataEntry(String)} and {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link WrappedDataEntry#getSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long WrappedDataEntry.getSize()"})
  public void testGetSize_givenRenamedDataEntryWithDataEntryIsClassPathDataEntryAndName() {
    // Arrange, Act and Assert
    assertEquals(
        -1L,
        (new WrappedDataEntry(new RenamedDataEntry(new ClassPathDataEntry("Name"), "Name")))
            .getSize());
  }

  /**
   * Test {@link WrappedDataEntry#getSize()}.
   *
   * <ul>
   *   <li>Given {@link WrappedDataEntry#WrappedDataEntry(DataEntry)} with wrappedEntry is {@link
   *       ClassPathDataEntry#ClassPathDataEntry(String)}.
   * </ul>
   *
   * <p>Method under test: {@link WrappedDataEntry#getSize()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"long WrappedDataEntry.getSize()"})
  public void testGetSize_givenWrappedDataEntryWithWrappedEntryIsClassPathDataEntry() {
    // Arrange, Act and Assert
    assertEquals(-1L, (new WrappedDataEntry(new ClassPathDataEntry("Name"))).getSize());
  }

  /**
   * Test {@link WrappedDataEntry#isDirectory()}.
   *
   * <ul>
   *   <li>Given {@link RenamedDataEntry#RenamedDataEntry(DataEntry, String)} with dataEntry is
   *       {@link ClassPathDataEntry#ClassPathDataEntry(String)} and {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link WrappedDataEntry#isDirectory()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WrappedDataEntry.isDirectory()"})
  public void testIsDirectory_givenRenamedDataEntryWithDataEntryIsClassPathDataEntryAndName() {
    // Arrange, Act and Assert
    assertFalse(
        (new WrappedDataEntry(new RenamedDataEntry(new ClassPathDataEntry("Name"), "Name")))
            .isDirectory());
  }

  /**
   * Test {@link WrappedDataEntry#isDirectory()}.
   *
   * <ul>
   *   <li>Given {@link WrappedDataEntry#WrappedDataEntry(DataEntry)} with wrappedEntry is {@link
   *       ClassPathDataEntry#ClassPathDataEntry(String)}.
   * </ul>
   *
   * <p>Method under test: {@link WrappedDataEntry#isDirectory()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WrappedDataEntry.isDirectory()"})
  public void testIsDirectory_givenWrappedDataEntryWithWrappedEntryIsClassPathDataEntry() {
    // Arrange, Act and Assert
    assertFalse((new WrappedDataEntry(new ClassPathDataEntry("Name"))).isDirectory());
  }

  /**
   * Test {@link WrappedDataEntry#isDirectory()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link WrappedDataEntry#isDirectory()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WrappedDataEntry.isDirectory()"})
  public void testIsDirectory_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        (new WrappedDataEntry(new DummyDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true)))
            .isDirectory());
  }

  /**
   * Test {@link WrappedDataEntry#getInputStream()}.
   *
   * <ul>
   *   <li>Given {@link RenamedDataEntry#RenamedDataEntry(DataEntry, String)} with dataEntry is
   *       {@link ClassPathDataEntry#ClassPathDataEntry(String)} and {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link WrappedDataEntry#getInputStream()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.io.InputStream WrappedDataEntry.getInputStream()"})
  public void testGetInputStream_givenRenamedDataEntryWithDataEntryIsClassPathDataEntryAndName()
      throws IOException {
    // Arrange, Act and Assert
    assertNull(
        (new WrappedDataEntry(new RenamedDataEntry(new ClassPathDataEntry("Name"), "Name")))
            .getInputStream());
  }

  /**
   * Test {@link WrappedDataEntry#getInputStream()}.
   *
   * <ul>
   *   <li>Given {@link WrappedDataEntry#WrappedDataEntry(DataEntry)} with wrappedEntry is {@link
   *       ClassPathDataEntry#ClassPathDataEntry(String)}.
   * </ul>
   *
   * <p>Method under test: {@link WrappedDataEntry#getInputStream()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.io.InputStream WrappedDataEntry.getInputStream()"})
  public void testGetInputStream_givenWrappedDataEntryWithWrappedEntryIsClassPathDataEntry()
      throws IOException {
    // Arrange, Act and Assert
    assertNull((new WrappedDataEntry(new ClassPathDataEntry("Name"))).getInputStream());
  }

  /**
   * Test {@link WrappedDataEntry#getParent()}.
   *
   * <ul>
   *   <li>Given {@link RenamedDataEntry#RenamedDataEntry(DataEntry, String)} with dataEntry is
   *       {@link ClassPathDataEntry#ClassPathDataEntry(String)} and {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link WrappedDataEntry#getParent()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataEntry WrappedDataEntry.getParent()"})
  public void testGetParent_givenRenamedDataEntryWithDataEntryIsClassPathDataEntryAndName() {
    // Arrange, Act and Assert
    assertNull(
        (new WrappedDataEntry(new RenamedDataEntry(new ClassPathDataEntry("Name"), "Name")))
            .getParent());
  }

  /**
   * Test {@link WrappedDataEntry#getParent()}.
   *
   * <ul>
   *   <li>Given {@link WrappedDataEntry#WrappedDataEntry(DataEntry)} with wrappedEntry is {@link
   *       ClassPathDataEntry#ClassPathDataEntry(String)}.
   * </ul>
   *
   * <p>Method under test: {@link WrappedDataEntry#getParent()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DataEntry WrappedDataEntry.getParent()"})
  public void testGetParent_givenWrappedDataEntryWithWrappedEntryIsClassPathDataEntry() {
    // Arrange, Act and Assert
    assertNull((new WrappedDataEntry(new ClassPathDataEntry("Name"))).getParent());
  }
}
