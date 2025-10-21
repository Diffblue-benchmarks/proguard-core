package proguard.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ClassPathDataEntryDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ClassPathDataEntry#ClassPathDataEntry(String)}
   *   <li>{@link ClassPathDataEntry#toString()}
   *   <li>{@link ClassPathDataEntry#getName()}
   *   <li>{@link ClassPathDataEntry#getOriginalName()}
   *   <li>{@link ClassPathDataEntry#getParent()}
   *   <li>{@link ClassPathDataEntry#getSize()}
   *   <li>{@link ClassPathDataEntry#isDirectory()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ClassPathDataEntry.<init>(String)",
    "String ClassPathDataEntry.getName()",
    "String ClassPathDataEntry.getOriginalName()",
    "DataEntry ClassPathDataEntry.getParent()",
    "long ClassPathDataEntry.getSize()",
    "boolean ClassPathDataEntry.isDirectory()",
    "String ClassPathDataEntry.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    ClassPathDataEntry actualClassPathDataEntry = new ClassPathDataEntry("Name");
    String actualToStringResult = actualClassPathDataEntry.toString();
    String actualName = actualClassPathDataEntry.getName();
    String actualOriginalName = actualClassPathDataEntry.getOriginalName();
    DataEntry actualParent = actualClassPathDataEntry.getParent();
    long actualSize = actualClassPathDataEntry.getSize();

    // Assert
    assertEquals("Name", actualName);
    assertEquals("Name", actualOriginalName);
    assertEquals("Name", actualToStringResult);
    assertNull(actualParent);
    assertEquals(-1L, actualSize);
    assertFalse(actualClassPathDataEntry.isDirectory());
  }

  /**
   * Test {@link ClassPathDataEntry#getInputStream()}.
   *
   * <ul>
   *   <li>Given {@link ClassPathDataEntry#ClassPathDataEntry(String)} with {@code Name}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ClassPathDataEntry#getInputStream()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.io.InputStream ClassPathDataEntry.getInputStream()"})
  public void testGetInputStream_givenClassPathDataEntryWithName_thenReturnNull()
      throws IOException {
    // Arrange, Act and Assert
    assertNull((new ClassPathDataEntry("Name")).getInputStream());
  }
}
