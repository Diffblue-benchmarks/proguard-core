package proguard.evaluation.value;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import org.junit.Test;
import proguard.evaluation.ParticularReferenceValueFactory;

public class InitialValueFactoryDiffblueTest {
  /**
   * Method under test: {@link InitialValueFactory#createValue(String)}
   */
  @Test
  public void testCreateValue() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new InitialValueFactory(new ParticularReferenceValueFactory())).createValue("Type"));
  }

  /**
   * Method under test: {@link InitialValueFactory#createValue(String)}
   */
  @Test
  public void testCreateValue2() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(valueFactory.INTEGER_VALUE, (new InitialValueFactory(valueFactory)).createValue("Invalid type ["));
  }
}
