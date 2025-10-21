package proguard.classfile.constant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class NameAndTypeConstantDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NameAndTypeConstant#NameAndTypeConstant()}
   *   <li>{@link NameAndTypeConstant#setDescriptorIndex(int)}
   *   <li>{@link NameAndTypeConstant#setNameIndex(int)}
   *   <li>{@link NameAndTypeConstant#toString()}
   *   <li>{@link NameAndTypeConstant#getDescriptorIndex()}
   *   <li>{@link NameAndTypeConstant#getNameIndex()}
   *   <li>{@link NameAndTypeConstant#isCategory2()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void NameAndTypeConstant.<init>()",
    "void NameAndTypeConstant.<init>(int, int)",
    "int NameAndTypeConstant.getDescriptorIndex()",
    "int NameAndTypeConstant.getNameIndex()",
    "boolean NameAndTypeConstant.isCategory2()",
    "void NameAndTypeConstant.setDescriptorIndex(int)",
    "void NameAndTypeConstant.setNameIndex(int)",
    "String NameAndTypeConstant.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    NameAndTypeConstant actualNameAndTypeConstant = new NameAndTypeConstant();
    actualNameAndTypeConstant.setDescriptorIndex(1);
    actualNameAndTypeConstant.setNameIndex(1);
    String actualToStringResult = actualNameAndTypeConstant.toString();
    int actualDescriptorIndex = actualNameAndTypeConstant.getDescriptorIndex();
    int actualNameIndex = actualNameAndTypeConstant.getNameIndex();
    boolean actualIsCategory2Result = actualNameAndTypeConstant.isCategory2();

    // Assert
    assertEquals("NameAndType(1,1)", actualToStringResult);
    assertNull(actualNameAndTypeConstant.getProcessingInfo());
    assertEquals(0, actualNameAndTypeConstant.getProcessingFlags());
    assertEquals(1, actualDescriptorIndex);
    assertEquals(1, actualNameIndex);
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NameAndTypeConstant#NameAndTypeConstant(int, int)}
   *   <li>{@link NameAndTypeConstant#setDescriptorIndex(int)}
   *   <li>{@link NameAndTypeConstant#setNameIndex(int)}
   *   <li>{@link NameAndTypeConstant#toString()}
   *   <li>{@link NameAndTypeConstant#getDescriptorIndex()}
   *   <li>{@link NameAndTypeConstant#getNameIndex()}
   *   <li>{@link NameAndTypeConstant#isCategory2()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void NameAndTypeConstant.<init>()",
    "void NameAndTypeConstant.<init>(int, int)",
    "int NameAndTypeConstant.getDescriptorIndex()",
    "int NameAndTypeConstant.getNameIndex()",
    "boolean NameAndTypeConstant.isCategory2()",
    "void NameAndTypeConstant.setDescriptorIndex(int)",
    "void NameAndTypeConstant.setNameIndex(int)",
    "String NameAndTypeConstant.toString()"
  })
  public void testGettersAndSetters_whenOne() {
    // Arrange and Act
    NameAndTypeConstant actualNameAndTypeConstant = new NameAndTypeConstant(1, 1);
    actualNameAndTypeConstant.setDescriptorIndex(1);
    actualNameAndTypeConstant.setNameIndex(1);
    String actualToStringResult = actualNameAndTypeConstant.toString();
    int actualDescriptorIndex = actualNameAndTypeConstant.getDescriptorIndex();
    int actualNameIndex = actualNameAndTypeConstant.getNameIndex();
    boolean actualIsCategory2Result = actualNameAndTypeConstant.isCategory2();

    // Assert
    assertEquals("NameAndType(1,1)", actualToStringResult);
    assertNull(actualNameAndTypeConstant.getProcessingInfo());
    assertEquals(0, actualNameAndTypeConstant.getProcessingFlags());
    assertEquals(1, actualDescriptorIndex);
    assertEquals(1, actualNameIndex);
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Test {@link NameAndTypeConstant#getTag()}.
   *
   * <p>Method under test: {@link NameAndTypeConstant#getTag()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int NameAndTypeConstant.getTag()"})
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(Constant.NAME_AND_TYPE, (new NameAndTypeConstant(1, 1)).getTag());
  }

  /**
   * Test {@link NameAndTypeConstant#equals(Object)}, and {@link NameAndTypeConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NameAndTypeConstant#equals(Object)}
   *   <li>{@link NameAndTypeConstant#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NameAndTypeConstant.equals(Object)",
    "int NameAndTypeConstant.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NameAndTypeConstant nameAndTypeConstant = new NameAndTypeConstant(1, 1);
    NameAndTypeConstant nameAndTypeConstant2 = new NameAndTypeConstant(1, 1);

    // Act and Assert
    assertEquals(nameAndTypeConstant, nameAndTypeConstant2);
    int expectedHashCodeResult = nameAndTypeConstant.hashCode();
    assertEquals(expectedHashCodeResult, nameAndTypeConstant2.hashCode());
  }

  /**
   * Test {@link NameAndTypeConstant#equals(Object)}, and {@link NameAndTypeConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NameAndTypeConstant#equals(Object)}
   *   <li>{@link NameAndTypeConstant#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NameAndTypeConstant.equals(Object)",
    "int NameAndTypeConstant.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NameAndTypeConstant nameAndTypeConstant = new NameAndTypeConstant(1, 1);

    // Act and Assert
    assertEquals(nameAndTypeConstant, nameAndTypeConstant);
    int expectedHashCodeResult = nameAndTypeConstant.hashCode();
    assertEquals(expectedHashCodeResult, nameAndTypeConstant.hashCode());
  }

  /**
   * Test {@link NameAndTypeConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NameAndTypeConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NameAndTypeConstant.equals(Object)",
    "int NameAndTypeConstant.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NameAndTypeConstant nameAndTypeConstant = new NameAndTypeConstant(0, 1);

    // Act and Assert
    assertNotEquals(nameAndTypeConstant, new NameAndTypeConstant(1, 1));
  }

  /**
   * Test {@link NameAndTypeConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NameAndTypeConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NameAndTypeConstant.equals(Object)",
    "int NameAndTypeConstant.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NameAndTypeConstant nameAndTypeConstant = new NameAndTypeConstant(1, 0);

    // Act and Assert
    assertNotEquals(nameAndTypeConstant, new NameAndTypeConstant(1, 1));
  }

  /**
   * Test {@link NameAndTypeConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NameAndTypeConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NameAndTypeConstant.equals(Object)",
    "int NameAndTypeConstant.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NameAndTypeConstant(1, 1), null);
  }

  /**
   * Test {@link NameAndTypeConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NameAndTypeConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NameAndTypeConstant.equals(Object)",
    "int NameAndTypeConstant.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NameAndTypeConstant(1, 1), "Different type to NameAndTypeConstant");
  }
}
