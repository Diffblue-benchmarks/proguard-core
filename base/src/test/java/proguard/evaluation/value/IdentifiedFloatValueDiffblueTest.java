package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import proguard.evaluation.ParticularReferenceValueFactory;

public class IdentifiedFloatValueDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link IdentifiedFloatValue#equals(Object)}
   *   <li>{@link IdentifiedFloatValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    IdentifiedFloatValue identifiedFloatValue = new IdentifiedFloatValue(new ParticularReferenceValueFactory(), 1);

    // Act and Assert
    assertEquals(identifiedFloatValue, identifiedFloatValue);
    int expectedHashCodeResult = identifiedFloatValue.hashCode();
    assertEquals(expectedHashCodeResult, identifiedFloatValue.hashCode());
  }

  /**
   * Method under test: {@link IdentifiedFloatValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    IdentifiedFloatValue identifiedFloatValue = new IdentifiedFloatValue(new ParticularReferenceValueFactory(), 1);

    // Act and Assert
    assertNotEquals(identifiedFloatValue, new IdentifiedFloatValue(new ParticularReferenceValueFactory(), 1));
  }

  /**
   * Method under test: {@link IdentifiedFloatValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new IdentifiedFloatValue(new ParticularReferenceValueFactory(), 1), null);
  }

  /**
   * Method under test: {@link IdentifiedFloatValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new IdentifiedFloatValue(new ParticularReferenceValueFactory(), 1),
        "Different type to IdentifiedFloatValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link IdentifiedFloatValue#IdentifiedFloatValue(ValueFactory, int)}
   *   <li>{@link IdentifiedFloatValue#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("f1", (new IdentifiedFloatValue(new ParticularReferenceValueFactory(), 1)).toString());
  }
}
