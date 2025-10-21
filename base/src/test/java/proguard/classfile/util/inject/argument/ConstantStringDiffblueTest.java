package proguard.classfile.util.inject.argument;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ConstantStringDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ConstantString#ConstantString(String)}
   *   <li>{@link ConstantString#toString()}
   *   <li>{@link ConstantString#getConstant()}
   *   <li>{@link ConstantString#getInternalType()}
   *   <li>{@link ConstantString#getValue()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ConstantString.<init>(String)",
    "String ConstantString.getConstant()",
    "String ConstantString.getInternalType()",
    "java.lang.Object ConstantString.getValue()",
    "String ConstantString.toString()"
  })
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
