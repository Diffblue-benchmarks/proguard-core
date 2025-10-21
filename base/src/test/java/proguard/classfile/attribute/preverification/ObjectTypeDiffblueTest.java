package proguard.classfile.attribute.preverification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ObjectTypeDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return toString is {@code a:0}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ObjectType#ObjectType()}
   *   <li>{@link ObjectType#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ObjectType.<init>()",
    "void ObjectType.<init>(int)",
    "java.lang.String ObjectType.toString()"
  })
  public void testGettersAndSetters_thenReturnToStringIsA0() {
    // Arrange and Act
    ObjectType actualObjectType = new ObjectType();

    // Assert
    assertEquals("a:0", actualObjectType.toString());
    assertNull(actualObjectType.getProcessingInfo());
    assertEquals(0, actualObjectType.getProcessingFlags());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return toString is {@code a:1}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ObjectType#ObjectType(int)}
   *   <li>{@link ObjectType#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ObjectType.<init>()",
    "void ObjectType.<init>(int)",
    "java.lang.String ObjectType.toString()"
  })
  public void testGettersAndSetters_whenOne_thenReturnToStringIsA1() {
    // Arrange and Act
    ObjectType actualObjectType = new ObjectType(1);

    // Assert
    assertEquals("a:1", actualObjectType.toString());
    assertNull(actualObjectType.getProcessingInfo());
    assertEquals(0, actualObjectType.getProcessingFlags());
  }

  /**
   * Test {@link ObjectType#getTag()}.
   *
   * <p>Method under test: {@link ObjectType#getTag()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int ObjectType.getTag()"})
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(7, VerificationTypeFactory.createObjectType(1).getTag());
  }

  /**
   * Test {@link ObjectType#equals(Object)}, and {@link ObjectType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ObjectType#equals(Object)}
   *   <li>{@link ObjectType#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ObjectType.equals(Object)", "int ObjectType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ObjectType createObjectTypeResult = VerificationTypeFactory.createObjectType(1);
    ObjectType createObjectTypeResult2 = VerificationTypeFactory.createObjectType(1);

    // Act and Assert
    assertEquals(createObjectTypeResult, createObjectTypeResult2);
    int expectedHashCodeResult = createObjectTypeResult.hashCode();
    assertEquals(expectedHashCodeResult, createObjectTypeResult2.hashCode());
  }

  /**
   * Test {@link ObjectType#equals(Object)}, and {@link ObjectType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ObjectType#equals(Object)}
   *   <li>{@link ObjectType#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ObjectType.equals(Object)", "int ObjectType.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ObjectType createObjectTypeResult = VerificationTypeFactory.createObjectType(1);

    // Act and Assert
    assertEquals(createObjectTypeResult, createObjectTypeResult);
    int expectedHashCodeResult = createObjectTypeResult.hashCode();
    assertEquals(expectedHashCodeResult, createObjectTypeResult.hashCode());
  }

  /**
   * Test {@link ObjectType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ObjectType#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ObjectType.equals(Object)", "int ObjectType.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ObjectType createObjectTypeResult = VerificationTypeFactory.createObjectType(0);

    // Act and Assert
    assertNotEquals(createObjectTypeResult, VerificationTypeFactory.createObjectType(1));
  }

  /**
   * Test {@link ObjectType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ObjectType#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ObjectType.equals(Object)", "int ObjectType.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(VerificationTypeFactory.createObjectType(1), null);
  }

  /**
   * Test {@link ObjectType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ObjectType#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ObjectType.equals(Object)", "int ObjectType.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(VerificationTypeFactory.createObjectType(1), "Different type to ObjectType");
  }
}
