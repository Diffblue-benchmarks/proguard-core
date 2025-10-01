package proguard.dexfile.reader;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class FieldDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Field#Field(String, String, String)}
   *   <li>{@link Field#toString()}
   *   <li>{@link Field#getName()}
   *   <li>{@link Field#getOwner()}
   *   <li>{@link Field#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void Field.<init>(String, String, String)",
    "String Field.getName()",
    "String Field.getOwner()",
    "String Field.getType()",
    "String Field.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    Field actualField = new Field("Owner", "Name", "Type");
    String actualToStringResult = actualField.toString();
    String actualName = actualField.getName();
    String actualOwner = actualField.getOwner();

    // Assert
    assertEquals("Name", actualName);
    assertEquals("Owner", actualOwner);
    assertEquals("Owner->Name:Type", actualToStringResult);
    assertEquals("Type", actualField.getType());
  }
}
