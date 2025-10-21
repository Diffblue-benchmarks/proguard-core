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

public class NamedDataEntryDiffblueTest {
  /**
   * Test {@link NamedDataEntry#NamedDataEntry(DataEntry, String, long, boolean)}.
   *
   * <p>Method under test: {@link NamedDataEntry#NamedDataEntry(DataEntry, String, long, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NamedDataEntry.<init>(DataEntry, String, long, boolean)"})
  public void testNewNamedDataEntry() {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");

    // Act
    NamedDataEntry actualNamedDataEntry = new NamedDataEntry(parent, "Name", 3L, true);

    // Assert
    assertEquals("Name", actualNamedDataEntry.getName());
    assertEquals("Name", actualNamedDataEntry.getOriginalName());
    assertEquals(3L, actualNamedDataEntry.getSize());
    assertTrue(actualNamedDataEntry.isDirectory());
    assertSame(parent, actualNamedDataEntry.getParent());
  }

  /**
   * Test {@link NamedDataEntry#getOriginalName()}.
   *
   * <p>Method under test: {@link NamedDataEntry#getOriginalName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String NamedDataEntry.getOriginalName()"})
  public void testGetOriginalName() {
    // Arrange, Act and Assert
    assertEquals(
        "Name",
        (new NamedDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true)).getOriginalName());
  }

  /**
   * Test {@link NamedDataEntry#getInputStream()}.
   *
   * <p>Method under test: {@link NamedDataEntry#getInputStream()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.io.InputStream NamedDataEntry.getInputStream()"})
  public void testGetInputStream() throws IOException {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            (new NamedDataEntry(new ClassPathDataEntry("Name"), "Name", 3L, true))
                .getInputStream());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NamedDataEntry#closeInputStream()}
   *   <li>{@link NamedDataEntry#toString()}
   *   <li>{@link NamedDataEntry#getName()}
   *   <li>{@link NamedDataEntry#getParent()}
   *   <li>{@link NamedDataEntry#getSize()}
   *   <li>{@link NamedDataEntry#isDirectory()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void NamedDataEntry.closeInputStream()",
    "String NamedDataEntry.getName()",
    "DataEntry NamedDataEntry.getParent()",
    "long NamedDataEntry.getSize()",
    "boolean NamedDataEntry.isDirectory()",
    "String NamedDataEntry.toString()"
  })
  public void testGettersAndSetters() throws IOException {
    // Arrange
    ClassPathDataEntry parent = new ClassPathDataEntry("Name");
    NamedDataEntry namedDataEntry = new NamedDataEntry(parent, "Name", 3L, true);

    // Act
    namedDataEntry.closeInputStream();
    String actualToStringResult = namedDataEntry.toString();
    String actualName = namedDataEntry.getName();
    DataEntry actualParent = namedDataEntry.getParent();
    long actualSize = namedDataEntry.getSize();

    // Assert
    assertEquals("Name", actualName);
    assertEquals("Name:Name", actualToStringResult);
    assertEquals(3L, actualSize);
    assertTrue(namedDataEntry.isDirectory());
    assertSame(parent, actualParent);
  }
}
