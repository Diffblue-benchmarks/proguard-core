package proguard.evaluation.value;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.evaluation.ParticularReferenceValueFactory;

public class InitialValueFactoryDiffblueTest {
  /**
   * Test {@link InitialValueFactory#createValue(String)}.
   *
   * <ul>
   *   <li>Then return {@link ParticularReferenceValueFactory} (default constructor) {@link
   *       BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link InitialValueFactory#createValue(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.evaluation.value.Value InitialValueFactory.createValue(String)"})
  public void testCreateValue_thenReturnParticularReferenceValueFactoryInteger_value() {
    // Arrange
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(
        valueFactory.INTEGER_VALUE,
        (new InitialValueFactory(valueFactory)).createValue("Invalid type ["));
  }

  /**
   * Test {@link InitialValueFactory#createValue(String)}.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link InitialValueFactory#createValue(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"proguard.evaluation.value.Value InitialValueFactory.createValue(String)"})
  public void testCreateValue_whenType_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> (new InitialValueFactory(new ParticularReferenceValueFactory())).createValue("Type"));
  }
}
