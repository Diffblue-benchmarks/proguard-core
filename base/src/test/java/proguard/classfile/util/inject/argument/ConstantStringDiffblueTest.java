package proguard.classfile.util.inject.argument;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ConstantStringDiffblueTest {
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ConstantString.<init>(String)",
    "String ConstantString.getConstant()",
    "String ConstantString.getInternalType()",
    "java.lang.Object ConstantString.getValue()",
    "String ConstantString.toString()"
  })
  void testGettersAndSetters() {
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
