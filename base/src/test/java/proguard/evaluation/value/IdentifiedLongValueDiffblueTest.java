package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import proguard.evaluation.ParticularReferenceValueFactory;

public class IdentifiedLongValueDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link IdentifiedLongValue#equals(Object)}
   *   <li>{@link IdentifiedLongValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    IdentifiedLongValue identifiedLongValue = new IdentifiedLongValue(new ParticularReferenceValueFactory(), 1);

    // Act and Assert
    assertEquals(identifiedLongValue, identifiedLongValue);
    int expectedHashCodeResult = identifiedLongValue.hashCode();
    assertEquals(expectedHashCodeResult, identifiedLongValue.hashCode());
  }

  /**
   * Method under test: {@link IdentifiedLongValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    IdentifiedLongValue identifiedLongValue = new IdentifiedLongValue(new ParticularReferenceValueFactory(), 1);

    // Act and Assert
    assertNotEquals(identifiedLongValue, new IdentifiedLongValue(new ParticularReferenceValueFactory(), 1));
  }

  /**
   * Method under test: {@link IdentifiedLongValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new IdentifiedLongValue(new ParticularReferenceValueFactory(), 1), null);
  }

  /**
   * Method under test: {@link IdentifiedLongValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new IdentifiedLongValue(new ParticularReferenceValueFactory(), 1),
        "Different type to IdentifiedLongValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link IdentifiedLongValue#IdentifiedLongValue(ValueFactory, int)}
   *   <li>{@link IdentifiedLongValue#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("l1", (new IdentifiedLongValue(new ParticularReferenceValueFactory(), 1)).toString());
  }
}
