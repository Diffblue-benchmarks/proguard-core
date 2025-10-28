package proguard.dexfile.reader;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FieldDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Field#Field(String, String, String)}
   *   <li>{@link Field#toString()}
   *   <li>{@link Field#getName()}
   *   <li>{@link Field#getOwner()}
   *   <li>{@link Field#getType()}
   * </ul>
   */
  @Test
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
