package proguard.classfile.constant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class LongConstantDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LongConstant#LongConstant()}
   *   <li>{@link LongConstant#setValue(long)}
   *   <li>{@link LongConstant#toString()}
   *   <li>{@link LongConstant#getTag()}
   *   <li>{@link LongConstant#getValue()}
   *   <li>{@link LongConstant#isCategory2()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void LongConstant.<init>()",
    "void LongConstant.<init>(long)",
    "int LongConstant.getTag()",
    "long LongConstant.getValue()",
    "boolean LongConstant.isCategory2()",
    "void LongConstant.setValue(long)",
    "String LongConstant.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    LongConstant actualLongConstant = new LongConstant();
    actualLongConstant.setValue(42L);
    String actualToStringResult = actualLongConstant.toString();
    int actualTag = actualLongConstant.getTag();
    long actualValue = actualLongConstant.getValue();
    boolean actualIsCategory2Result = actualLongConstant.isCategory2();

    // Assert
    assertEquals("Long(42)", actualToStringResult);
    assertNull(actualLongConstant.getProcessingInfo());
    assertEquals(0, actualLongConstant.getProcessingFlags());
    assertEquals(42L, actualValue);
    assertEquals(5, actualTag);
    assertTrue(actualIsCategory2Result);
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
   *   <li>{@link LongConstant#LongConstant(long)}
   *   <li>{@link LongConstant#setValue(long)}
   *   <li>{@link LongConstant#toString()}
   *   <li>{@link LongConstant#getTag()}
   *   <li>{@link LongConstant#getValue()}
   *   <li>{@link LongConstant#isCategory2()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void LongConstant.<init>()",
    "void LongConstant.<init>(long)",
    "int LongConstant.getTag()",
    "long LongConstant.getValue()",
    "boolean LongConstant.isCategory2()",
    "void LongConstant.setValue(long)",
    "String LongConstant.toString()"
  })
  public void testGettersAndSetters_whenFortyTwo() {
    // Arrange and Act
    LongConstant actualLongConstant = new LongConstant(42L);
    actualLongConstant.setValue(42L);
    String actualToStringResult = actualLongConstant.toString();
    int actualTag = actualLongConstant.getTag();
    long actualValue = actualLongConstant.getValue();
    boolean actualIsCategory2Result = actualLongConstant.isCategory2();

    // Assert
    assertEquals("Long(42)", actualToStringResult);
    assertNull(actualLongConstant.getProcessingInfo());
    assertEquals(0, actualLongConstant.getProcessingFlags());
    assertEquals(42L, actualValue);
    assertEquals(5, actualTag);
    assertTrue(actualIsCategory2Result);
  }

  /**
   * Test {@link LongConstant#equals(Object)}, and {@link LongConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LongConstant#equals(Object)}
   *   <li>{@link LongConstant#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LongConstant.equals(Object)", "int LongConstant.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LongConstant longConstant = new LongConstant(42L);
    LongConstant longConstant2 = new LongConstant(42L);

    // Act and Assert
    assertEquals(longConstant, longConstant2);
    int expectedHashCodeResult = longConstant.hashCode();
    assertEquals(expectedHashCodeResult, longConstant2.hashCode());
  }

  /**
   * Test {@link LongConstant#equals(Object)}, and {@link LongConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LongConstant#equals(Object)}
   *   <li>{@link LongConstant#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LongConstant.equals(Object)", "int LongConstant.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LongConstant longConstant = new LongConstant(42L);

    // Act and Assert
    assertEquals(longConstant, longConstant);
    int expectedHashCodeResult = longConstant.hashCode();
    assertEquals(expectedHashCodeResult, longConstant.hashCode());
  }

  /**
   * Test {@link LongConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LongConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LongConstant.equals(Object)", "int LongConstant.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LongConstant longConstant = new LongConstant(1L);

    // Act and Assert
    assertNotEquals(longConstant, new LongConstant(42L));
  }

  /**
   * Test {@link LongConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LongConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LongConstant.equals(Object)", "int LongConstant.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LongConstant(42L), null);
  }

  /**
   * Test {@link LongConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LongConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LongConstant.equals(Object)", "int LongConstant.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LongConstant(42L), "Different type to LongConstant");
  }
}
