package proguard.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DummyDataEntryDiffblueTest {
  /**
   * Test {@link DummyDataEntry#DummyDataEntry(DataEntry, String, long, boolean)}.
   *
   * <p>Method under test: {@link DummyDataEntry#DummyDataEntry(DataEntry, String, long, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DummyDataEntry.<init>(DataEntry, String, long, boolean)"})
  public void testNewDummyDataEntry() {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");

    // Act
    DummyDataEntry actualDummyDataEntry = new DummyDataEntry(parent, "Name", 3L, true);

    // Assert
    assertEquals("Name", actualDummyDataEntry.getName());
    assertEquals("Name", actualDummyDataEntry.getOriginalName());
    assertEquals(3L, actualDummyDataEntry.getSize());
    assertTrue(actualDummyDataEntry.isDirectory());
    assertSame(parent, actualDummyDataEntry.getParent());
  }

  /**
   * Test {@link DummyDataEntry#getOriginalName()}.
   *
   * <p>Method under test: {@link DummyDataEntry#getOriginalName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String DummyDataEntry.getOriginalName()"})
  public void testGetOriginalName() {
    // Arrange, Act and Assert
    assertEquals(
        "Name",
        (new DummyDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true)).getOriginalName());
  }

  /**
   * Test {@link DummyDataEntry#getInputStream()}.
   *
   * <p>Method under test: {@link DummyDataEntry#getInputStream()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.io.InputStream DummyDataEntry.getInputStream()"})
  public void testGetInputStream() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            (new DummyDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true))
                .getInputStream());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DummyDataEntry#closeInputStream()}
   *   <li>{@link DummyDataEntry#toString()}
   *   <li>{@link DummyDataEntry#getName()}
   *   <li>{@link DummyDataEntry#getParent()}
   *   <li>{@link DummyDataEntry#getSize()}
   *   <li>{@link DummyDataEntry#isDirectory()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DummyDataEntry.closeInputStream()",
    "String DummyDataEntry.getName()",
    "DataEntry DummyDataEntry.getParent()",
    "long DummyDataEntry.getSize()",
    "boolean DummyDataEntry.isDirectory()",
    "String DummyDataEntry.toString()"
  })
  public void testGettersAndSetters() throws IOException {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");
    DummyDataEntry dummyDataEntry = new DummyDataEntry(parent, "Name", 3L, true);

    // Act
    dummyDataEntry.closeInputStream();
    String actualToStringResult = dummyDataEntry.toString();
    String actualName = dummyDataEntry.getName();
    DataEntry actualParent = dummyDataEntry.getParent();
    long actualSize = dummyDataEntry.getSize();

    // Assert
    assertEquals("Name", actualName);
    assertEquals("Name:Name", actualToStringResult);
    assertEquals(3L, actualSize);
    assertTrue(dummyDataEntry.isDirectory());
    assertSame(parent, actualParent);
  }
}
