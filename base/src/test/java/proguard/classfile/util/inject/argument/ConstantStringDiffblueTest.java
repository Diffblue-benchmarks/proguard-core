package proguard.classfile.util.inject.argument;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ConstantStringDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ConstantString#ConstantString(String)}
   *   <li>{@link ConstantString#toString()}
   *   <li>{@link ConstantString#getConstant()}
   *   <li>{@link ConstantString#getInternalType()}
   *   <li>{@link ConstantString#getValue()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    ConstantString actualConstantString = new ConstantString("Constant");
    String actualToStringResult = actualConstantString.toString();
    String actualConstant = actualConstantString.getConstant();
    String actualInternalType = actualConstantString.getInternalType();

    // Assert
    assertEquals("Constant", actualConstant);
    assertEquals("Constant", actualConstantString.getValue());
    assertEquals("Ljava/lang/String;", actualInternalType);
    assertEquals("\"Constant\":String", actualToStringResult);
  }
}
