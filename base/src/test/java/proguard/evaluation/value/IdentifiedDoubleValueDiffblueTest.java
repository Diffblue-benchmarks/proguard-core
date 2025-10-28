package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import proguard.evaluation.ParticularReferenceValueFactory;

public class IdentifiedDoubleValueDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link IdentifiedDoubleValue#equals(Object)}
   *   <li>{@link IdentifiedDoubleValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    IdentifiedDoubleValue identifiedDoubleValue = new IdentifiedDoubleValue(new ParticularReferenceValueFactory(), 1);

    // Act and Assert
    assertEquals(identifiedDoubleValue, identifiedDoubleValue);
    int expectedHashCodeResult = identifiedDoubleValue.hashCode();
    assertEquals(expectedHashCodeResult, identifiedDoubleValue.hashCode());
  }

  /**
   * Method under test: {@link IdentifiedDoubleValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    IdentifiedDoubleValue identifiedDoubleValue = new IdentifiedDoubleValue(new ParticularReferenceValueFactory(), 1);

    // Act and Assert
    assertNotEquals(identifiedDoubleValue, new IdentifiedDoubleValue(new ParticularReferenceValueFactory(), 1));
  }

  /**
   * Method under test: {@link IdentifiedDoubleValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new IdentifiedDoubleValue(new ParticularReferenceValueFactory(), 1), null);
  }

  /**
   * Method under test: {@link IdentifiedDoubleValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new IdentifiedDoubleValue(new ParticularReferenceValueFactory(), 1),
        "Different type to IdentifiedDoubleValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link IdentifiedDoubleValue#IdentifiedDoubleValue(ValueFactory, int)}
   *   <li>{@link IdentifiedDoubleValue#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("d1", (new IdentifiedDoubleValue(new ParticularReferenceValueFactory(), 1)).toString());
  }
}
