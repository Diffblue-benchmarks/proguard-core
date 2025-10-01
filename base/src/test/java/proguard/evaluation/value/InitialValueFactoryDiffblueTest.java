package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.diffblue.cover.annotations.ManagedByDiffblue;
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
   *   <li>When {@code Invalid type [}.
   *   <li>Then return {@link BasicValueFactory#INTEGER_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link InitialValueFactory#createValue(String)}
   */
  @Test
  @DisplayName("Test createValue(String); when 'Invalid type ['; then return INTEGER_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"proguard.evaluation.value.Value InitialValueFactory.createValue(String)"})
  void testCreateValue_whenInvalidType_thenReturnInteger_value() {
    // Arrange, Act and Assert
    assertSame(
        BasicValueFactory.INTEGER_VALUE,
        new InitialValueFactory(new ParticularReferenceValueFactory())
            .createValue("Invalid type ["));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"proguard.evaluation.value.Value InitialValueFactory.createValue(String)"})
  void testCreateValue_whenType_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> new InitialValueFactory(new ParticularReferenceValueFactory()).createValue("Type"));
  }
}
