package proguard.classfile.attribute.preverification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class UninitializedTypeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return toString is {@code u:0}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UninitializedType#UninitializedType()}
   *   <li>{@link UninitializedType#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void UninitializedType.<init>()",
    "void UninitializedType.<init>(int)",
    "java.lang.String UninitializedType.toString()"
  })
  public void testGettersAndSetters_thenReturnToStringIsU0() {
    // Arrange and Act
    UninitializedType actualUninitializedType = new UninitializedType();

    // Assert
    assertEquals("u:0", actualUninitializedType.toString());
    assertNull(actualUninitializedType.getProcessingInfo());
    assertEquals(0, actualUninitializedType.getProcessingFlags());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return toString is {@code u:1}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UninitializedType#UninitializedType(int)}
   *   <li>{@link UninitializedType#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void UninitializedType.<init>()",
    "void UninitializedType.<init>(int)",
    "java.lang.String UninitializedType.toString()"
  })
  public void testGettersAndSetters_whenOne_thenReturnToStringIsU1() {
    // Arrange and Act
    UninitializedType actualUninitializedType = new UninitializedType(1);

    // Assert
    assertEquals("u:1", actualUninitializedType.toString());
    assertNull(actualUninitializedType.getProcessingInfo());
    assertEquals(0, actualUninitializedType.getProcessingFlags());
  }

  /**
   * Test {@link UninitializedType#getTag()}.
   *
   * <p>Method under test: {@link UninitializedType#getTag()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int UninitializedType.getTag()"})
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(8, VerificationTypeFactory.createUninitializedType(1).getTag());
  }

  /**
   * Test {@link UninitializedType#equals(Object)}, and {@link UninitializedType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UninitializedType#equals(Object)}
   *   <li>{@link UninitializedType#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean UninitializedType.equals(Object)",
    "int UninitializedType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UninitializedType createUninitializedTypeResult =
        VerificationTypeFactory.createUninitializedType(1);
    UninitializedType createUninitializedTypeResult2 =
        VerificationTypeFactory.createUninitializedType(1);

    // Act and Assert
    assertEquals(createUninitializedTypeResult, createUninitializedTypeResult2);
    int expectedHashCodeResult = createUninitializedTypeResult.hashCode();
    assertEquals(expectedHashCodeResult, createUninitializedTypeResult2.hashCode());
  }

  /**
   * Test {@link UninitializedType#equals(Object)}, and {@link UninitializedType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link UninitializedType#equals(Object)}
   *   <li>{@link UninitializedType#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean UninitializedType.equals(Object)",
    "int UninitializedType.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UninitializedType createUninitializedTypeResult =
        VerificationTypeFactory.createUninitializedType(1);

    // Act and Assert
    assertEquals(createUninitializedTypeResult, createUninitializedTypeResult);
    int expectedHashCodeResult = createUninitializedTypeResult.hashCode();
    assertEquals(expectedHashCodeResult, createUninitializedTypeResult.hashCode());
  }

  /**
   * Test {@link UninitializedType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UninitializedType#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean UninitializedType.equals(Object)",
    "int UninitializedType.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UninitializedType createUninitializedTypeResult =
        VerificationTypeFactory.createUninitializedType(0);

    // Act and Assert
    assertNotEquals(
        createUninitializedTypeResult, VerificationTypeFactory.createUninitializedType(1));
  }

  /**
   * Test {@link UninitializedType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UninitializedType#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean UninitializedType.equals(Object)",
    "int UninitializedType.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(VerificationTypeFactory.createUninitializedType(1), null);
  }

  /**
   * Test {@link UninitializedType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link UninitializedType#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean UninitializedType.equals(Object)",
    "int UninitializedType.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        VerificationTypeFactory.createUninitializedType(1), "Different type to UninitializedType");
  }
}
