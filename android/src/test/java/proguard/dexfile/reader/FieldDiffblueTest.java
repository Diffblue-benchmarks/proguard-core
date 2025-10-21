package proguard.dexfile.reader;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class FieldDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void Field.<init>(String, String, String)",
    "String Field.getName()",
    "String Field.getOwner()",
    "String Field.getType()",
    "String Field.toString()"
  })
  public void testGettersAndSetters() {
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
