package proguard.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ClassPathDataEntryDiffblueTest {
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ClassPathDataEntry.<init>(String)",
    "String ClassPathDataEntry.getName()",
    "String ClassPathDataEntry.getOriginalName()",
    "DataEntry ClassPathDataEntry.getParent()",
    "long ClassPathDataEntry.getSize()",
    "boolean ClassPathDataEntry.isDirectory()",
    "String ClassPathDataEntry.toString()"
  })
  void testGettersAndSetters() {
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
  @DisplayName(
      "Test getInputStream(); given ClassPathDataEntry(String) with 'Name'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.InputStream ClassPathDataEntry.getInputStream()"})
  void testGetInputStream_givenClassPathDataEntryWithName_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(new ClassPathDataEntry("Name").getInputStream());
  }
}
