package proguard.classfile.constant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DoubleConstantDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DoubleConstant#DoubleConstant()}
   *   <li>{@link DoubleConstant#setValue(double)}
   *   <li>{@link DoubleConstant#toString()}
   *   <li>{@link DoubleConstant#getValue()}
   *   <li>{@link DoubleConstant#isCategory2()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DoubleConstant.<init>()",
    "void DoubleConstant.<init>(double)",
    "double DoubleConstant.getValue()",
    "boolean DoubleConstant.isCategory2()",
    "void DoubleConstant.setValue(double)",
    "String DoubleConstant.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    DoubleConstant actualDoubleConstant = new DoubleConstant();
    actualDoubleConstant.setValue(10.0d);
    String actualToStringResult = actualDoubleConstant.toString();
    double actualValue = actualDoubleConstant.getValue();
    boolean actualIsCategory2Result = actualDoubleConstant.isCategory2();

    // Assert
    assertEquals("Double(10.0)", actualToStringResult);
    assertNull(actualDoubleConstant.getProcessingInfo());
    assertEquals(0, actualDoubleConstant.getProcessingFlags());
    assertEquals(10.0d, actualValue, 0.0);
    assertTrue(actualIsCategory2Result);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When ten.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DoubleConstant#DoubleConstant(double)}
   *   <li>{@link DoubleConstant#setValue(double)}
   *   <li>{@link DoubleConstant#toString()}
   *   <li>{@link DoubleConstant#getValue()}
   *   <li>{@link DoubleConstant#isCategory2()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DoubleConstant.<init>()",
    "void DoubleConstant.<init>(double)",
    "double DoubleConstant.getValue()",
    "boolean DoubleConstant.isCategory2()",
    "void DoubleConstant.setValue(double)",
    "String DoubleConstant.toString()"
  })
  public void testGettersAndSetters_whenTen() {
    // Arrange and Act
    DoubleConstant actualDoubleConstant = new DoubleConstant(10.0d);
    actualDoubleConstant.setValue(10.0d);
    String actualToStringResult = actualDoubleConstant.toString();
    double actualValue = actualDoubleConstant.getValue();
    boolean actualIsCategory2Result = actualDoubleConstant.isCategory2();

    // Assert
    assertEquals("Double(10.0)", actualToStringResult);
    assertNull(actualDoubleConstant.getProcessingInfo());
    assertEquals(0, actualDoubleConstant.getProcessingFlags());
    assertEquals(10.0d, actualValue, 0.0);
    assertTrue(actualIsCategory2Result);
  }

  /**
   * Test {@link DoubleConstant#getTag()}.
   *
   * <p>Method under test: {@link DoubleConstant#getTag()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int DoubleConstant.getTag()"})
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(6, (new DoubleConstant(10.0d)).getTag());
  }

  /**
   * Test {@link DoubleConstant#equals(Object)}, and {@link DoubleConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DoubleConstant#equals(Object)}
   *   <li>{@link DoubleConstant#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DoubleConstant.equals(Object)", "int DoubleConstant.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);
    DoubleConstant doubleConstant2 = new DoubleConstant(10.0d);

    // Act and Assert
    assertEquals(doubleConstant, doubleConstant2);
    int expectedHashCodeResult = doubleConstant.hashCode();
    assertEquals(expectedHashCodeResult, doubleConstant2.hashCode());
  }

  /**
   * Test {@link DoubleConstant#equals(Object)}, and {@link DoubleConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DoubleConstant#equals(Object)}
   *   <li>{@link DoubleConstant#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DoubleConstant.equals(Object)", "int DoubleConstant.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DoubleConstant doubleConstant = new DoubleConstant(10.0d);

    // Act and Assert
    assertEquals(doubleConstant, doubleConstant);
    int expectedHashCodeResult = doubleConstant.hashCode();
    assertEquals(expectedHashCodeResult, doubleConstant.hashCode());
  }

  /**
   * Test {@link DoubleConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DoubleConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DoubleConstant.equals(Object)", "int DoubleConstant.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DoubleConstant doubleConstant = new DoubleConstant(0.5d);

    // Act and Assert
    assertNotEquals(doubleConstant, new DoubleConstant(10.0d));
  }

  /**
   * Test {@link DoubleConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DoubleConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DoubleConstant.equals(Object)", "int DoubleConstant.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DoubleConstant(10.0d), null);
  }

  /**
   * Test {@link DoubleConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DoubleConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DoubleConstant.equals(Object)", "int DoubleConstant.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DoubleConstant(10.0d), "Different type to DoubleConstant");
  }
}
