package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.evaluation.ParticularReferenceValueFactory;

class InitialValueFactoryDiffblueTest {
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
  @DisplayName(
      "Test createValue(String); then return ParticularReferenceValueFactory (default constructor) INTEGER_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.value.InitialValueFactory.createValue(java.lang.String)"
  })
  void testCreateValue_thenReturnParticularReferenceValueFactoryInteger_value() {
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
  @DisplayName("Test createValue(String); when 'Type'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.value.InitialValueFactory.createValue(java.lang.String)"
  })
  void testCreateValue_whenType_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> (new InitialValueFactory(new ParticularReferenceValueFactory())).createValue("Type"));
  }
}
