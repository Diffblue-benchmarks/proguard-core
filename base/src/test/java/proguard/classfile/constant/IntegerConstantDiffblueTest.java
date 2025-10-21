package proguard.classfile.constant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class IntegerConstantDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IntegerConstant#IntegerConstant()}
   *   <li>{@link IntegerConstant#setValue(int)}
   *   <li>{@link IntegerConstant#toString()}
   *   <li>{@link IntegerConstant#getTag()}
   *   <li>{@link IntegerConstant#getValue()}
   *   <li>{@link IntegerConstant#isCategory2()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void IntegerConstant.<init>()",
    "void IntegerConstant.<init>(int)",
    "int IntegerConstant.getTag()",
    "int IntegerConstant.getValue()",
    "boolean IntegerConstant.isCategory2()",
    "void IntegerConstant.setValue(int)",
    "String IntegerConstant.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    IntegerConstant actualIntegerConstant = new IntegerConstant();
    actualIntegerConstant.setValue(42);
    String actualToStringResult = actualIntegerConstant.toString();
    int actualTag = actualIntegerConstant.getTag();
    int actualValue = actualIntegerConstant.getValue();
    boolean actualIsCategory2Result = actualIntegerConstant.isCategory2();

    // Assert
    assertEquals("Integer(42)", actualToStringResult);
    assertNull(actualIntegerConstant.getProcessingInfo());
    assertEquals(0, actualIntegerConstant.getProcessingFlags());
    assertEquals(3, actualTag);
    assertEquals(42, actualValue);
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When forty-two.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IntegerConstant#IntegerConstant(int)}
   *   <li>{@link IntegerConstant#setValue(int)}
   *   <li>{@link IntegerConstant#toString()}
   *   <li>{@link IntegerConstant#getTag()}
   *   <li>{@link IntegerConstant#getValue()}
   *   <li>{@link IntegerConstant#isCategory2()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void IntegerConstant.<init>()",
    "void IntegerConstant.<init>(int)",
    "int IntegerConstant.getTag()",
    "int IntegerConstant.getValue()",
    "boolean IntegerConstant.isCategory2()",
    "void IntegerConstant.setValue(int)",
    "String IntegerConstant.toString()"
  })
  public void testGettersAndSetters_whenFortyTwo() {
    // Arrange and Act
    IntegerConstant actualIntegerConstant = new IntegerConstant(42);
    actualIntegerConstant.setValue(42);
    String actualToStringResult = actualIntegerConstant.toString();
    int actualTag = actualIntegerConstant.getTag();
    int actualValue = actualIntegerConstant.getValue();
    boolean actualIsCategory2Result = actualIntegerConstant.isCategory2();

    // Assert
    assertEquals("Integer(42)", actualToStringResult);
    assertNull(actualIntegerConstant.getProcessingInfo());
    assertEquals(0, actualIntegerConstant.getProcessingFlags());
    assertEquals(3, actualTag);
    assertEquals(42, actualValue);
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Test {@link IntegerConstant#equals(Object)}, and {@link IntegerConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IntegerConstant#equals(Object)}
   *   <li>{@link IntegerConstant#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IntegerConstant.equals(Object)", "int IntegerConstant.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    IntegerConstant integerConstant = new IntegerConstant(42);
    IntegerConstant integerConstant2 = new IntegerConstant(42);

    // Act and Assert
    assertEquals(integerConstant, integerConstant2);
    int expectedHashCodeResult = integerConstant.hashCode();
    assertEquals(expectedHashCodeResult, integerConstant2.hashCode());
  }

  /**
   * Test {@link IntegerConstant#equals(Object)}, and {@link IntegerConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link IntegerConstant#equals(Object)}
   *   <li>{@link IntegerConstant#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IntegerConstant.equals(Object)", "int IntegerConstant.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    IntegerConstant integerConstant = new IntegerConstant(42);

    // Act and Assert
    assertEquals(integerConstant, integerConstant);
    int expectedHashCodeResult = integerConstant.hashCode();
    assertEquals(expectedHashCodeResult, integerConstant.hashCode());
  }

  /**
   * Test {@link IntegerConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IntegerConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IntegerConstant.equals(Object)", "int IntegerConstant.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    IntegerConstant integerConstant = new IntegerConstant(1);

    // Act and Assert
    assertNotEquals(integerConstant, new IntegerConstant(42));
  }

  /**
   * Test {@link IntegerConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IntegerConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IntegerConstant.equals(Object)", "int IntegerConstant.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new IntegerConstant(42), null);
  }

  /**
   * Test {@link IntegerConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link IntegerConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean IntegerConstant.equals(Object)", "int IntegerConstant.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new IntegerConstant(42), "Different type to IntegerConstant");
  }
}
