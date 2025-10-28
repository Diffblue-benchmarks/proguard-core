package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import proguard.evaluation.ParticularReferenceValueFactory;

public class IdentifiedIntegerValueDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link IdentifiedIntegerValue#equals(Object)}
   *   <li>{@link IdentifiedIntegerValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    IdentifiedIntegerValue identifiedIntegerValue = new IdentifiedIntegerValue(new ParticularReferenceValueFactory(),
        1);

    // Act and Assert
    assertEquals(identifiedIntegerValue, identifiedIntegerValue);
    int expectedHashCodeResult = identifiedIntegerValue.hashCode();
    assertEquals(expectedHashCodeResult, identifiedIntegerValue.hashCode());
  }

  /**
   * Method under test: {@link IdentifiedIntegerValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    IdentifiedIntegerValue identifiedIntegerValue = new IdentifiedIntegerValue(new ParticularReferenceValueFactory(),
        1);

    // Act and Assert
    assertNotEquals(identifiedIntegerValue, new IdentifiedIntegerValue(new ParticularReferenceValueFactory(), 1));
  }

  /**
   * Method under test: {@link IdentifiedIntegerValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new IdentifiedIntegerValue(new ParticularReferenceValueFactory(), 1), null);
  }

  /**
   * Method under test: {@link IdentifiedIntegerValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new IdentifiedIntegerValue(new ParticularReferenceValueFactory(), 1),
        "Different type to IdentifiedIntegerValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link IdentifiedIntegerValue#IdentifiedIntegerValue(ValueFactory, int)}
   *   <li>{@link IdentifiedIntegerValue#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("i1", (new IdentifiedIntegerValue(new ParticularReferenceValueFactory(), 1)).toString());
  }
}
