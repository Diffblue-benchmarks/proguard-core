package proguard.evaluation.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class InstructionOffsetValueDiffblueTest {
  /**
   * Test {@link InstructionOffsetValue#InstructionOffsetValue(int)}.
   *
   * <p>Method under test: {@link InstructionOffsetValue#InstructionOffsetValue(int)}
   */
  @Test
  @DisplayName("Test new InstructionOffsetValue(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InstructionOffsetValue.<init>(int)"})
  void testNewInstructionOffsetValue() {
    // Arrange and Act
    InstructionOffsetValue actualInstructionOffsetValue = new InstructionOffsetValue(42);

    // Assert
    assertFalse(actualInstructionOffsetValue.isCategory2());
    assertTrue(actualInstructionOffsetValue.isParticular());
    assertTrue(actualInstructionOffsetValue.isSpecific());
  }

  /**
   * Test {@link InstructionOffsetValue#InstructionOffsetValue(int[])}.
   *
   * <p>Method under test: {@link InstructionOffsetValue#InstructionOffsetValue(int[])}
   */
  @Test
  @DisplayName("Test new InstructionOffsetValue(int[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void InstructionOffsetValue.<init>(int[])"})
  void testNewInstructionOffsetValue2() {
    // Arrange and Act
    InstructionOffsetValue actualInstructionOffsetValue =
        new InstructionOffsetValue(new int[] {42, 1, 42, 1});

    // Assert
    assertFalse(actualInstructionOffsetValue.isCategory2());
    assertTrue(actualInstructionOffsetValue.isParticular());
    assertTrue(actualInstructionOffsetValue.isSpecific());
  }

  /**
   * Test {@link InstructionOffsetValue#instructionOffsetCount()}.
   *
   * <p>Method under test: {@link InstructionOffsetValue#instructionOffsetCount()}
   */
  @Test
  @DisplayName("Test instructionOffsetCount()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InstructionOffsetValue.instructionOffsetCount()"})
  void testInstructionOffsetCount() {
    // Arrange, Act and Assert
    assertEquals(0, InstructionOffsetValue.EMPTY_VALUE.instructionOffsetCount());
  }

  /**
   * Test {@link InstructionOffsetValue#instructionOffset(int)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#instructionOffset(int)}
   */
  @Test
  @DisplayName("Test instructionOffset(int); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InstructionOffsetValue.instructionOffset(int)"})
  void testInstructionOffset_thenReturnOne() {
    // Arrange
    InstructionOffsetValue instructionOffsetValue =
        new InstructionOffsetValue(new int[] {42, 1, 42, 1});

    // Act and Assert
    assertEquals(1, instructionOffsetValue.instructionOffset(1));
  }

  /**
   * Test {@link InstructionOffsetValue#contains(int)}.
   *
   * <ul>
   *   <li>Given {@link InstructionOffsetValue#EMPTY_VALUE}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#contains(int)}
   */
  @Test
  @DisplayName("Test contains(int); given EMPTY_VALUE; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InstructionOffsetValue.contains(int)"})
  void testContains_givenEmpty_value_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(InstructionOffsetValue.EMPTY_VALUE.contains(42));
  }

  /**
   * Test {@link InstructionOffsetValue#contains(int)}.
   *
   * <ul>
   *   <li>Given {@link InstructionOffsetValue#InstructionOffsetValue(int)} with value is forty-two.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#contains(int)}
   */
  @Test
  @DisplayName(
      "Test contains(int); given InstructionOffsetValue(int) with value is forty-two; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InstructionOffsetValue.contains(int)"})
  void testContains_givenInstructionOffsetValueWithValueIsFortyTwo_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(new InstructionOffsetValue(42).contains(42));
  }

  /**
   * Test {@link InstructionOffsetValue#contains(int)}.
   *
   * <ul>
   *   <li>Given {@link InstructionOffsetValue#InstructionOffsetValue(int)} with value is one.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#contains(int)}
   */
  @Test
  @DisplayName(
      "Test contains(int); given InstructionOffsetValue(int) with value is one; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InstructionOffsetValue.contains(int)"})
  void testContains_givenInstructionOffsetValueWithValueIsOne_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new InstructionOffsetValue(1).contains(42));
  }

  /**
   * Test {@link InstructionOffsetValue#minimumValue()}.
   *
   * <p>Method under test: {@link InstructionOffsetValue#minimumValue()}
   */
  @Test
  @DisplayName("Test minimumValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InstructionOffsetValue.minimumValue()"})
  void testMinimumValue() {
    // Arrange
    InstructionOffsetValue instructionOffsetValue =
        new InstructionOffsetValue(new int[] {42, Integer.MAX_VALUE, 42, Integer.MAX_VALUE});

    // Act and Assert
    assertEquals(42, instructionOffsetValue.minimumValue());
  }

  /**
   * Test {@link InstructionOffsetValue#minimumValue()}.
   *
   * <ul>
   *   <li>Given {@link InstructionOffsetValue#EMPTY_VALUE}.
   *   <li>Then return {@link Integer#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#minimumValue()}
   */
  @Test
  @DisplayName("Test minimumValue(); given EMPTY_VALUE; then return MAX_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InstructionOffsetValue.minimumValue()"})
  void testMinimumValue_givenEmpty_value_thenReturnMax_value() {
    // Arrange, Act and Assert
    assertEquals(Integer.MAX_VALUE, InstructionOffsetValue.EMPTY_VALUE.minimumValue());
  }

  /**
   * Test {@link InstructionOffsetValue#minimumValue()}.
   *
   * <ul>
   *   <li>Given {@link InstructionOffsetValue#InstructionOffsetValue(int)} with value is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#minimumValue()}
   */
  @Test
  @DisplayName("Test minimumValue(); given InstructionOffsetValue(int) with value is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InstructionOffsetValue.minimumValue()"})
  void testMinimumValue_givenInstructionOffsetValueWithValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42, new InstructionOffsetValue(42).minimumValue());
  }

  /**
   * Test {@link InstructionOffsetValue#maximumValue()}.
   *
   * <p>Method under test: {@link InstructionOffsetValue#maximumValue()}
   */
  @Test
  @DisplayName("Test maximumValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InstructionOffsetValue.maximumValue()"})
  void testMaximumValue() {
    // Arrange
    InstructionOffsetValue instructionOffsetValue =
        new InstructionOffsetValue(new int[] {42, Integer.MIN_VALUE, 42, Integer.MIN_VALUE});

    // Act and Assert
    assertEquals(42, instructionOffsetValue.maximumValue());
  }

  /**
   * Test {@link InstructionOffsetValue#maximumValue()}.
   *
   * <ul>
   *   <li>Given {@link InstructionOffsetValue#EMPTY_VALUE}.
   *   <li>Then return {@link Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#maximumValue()}
   */
  @Test
  @DisplayName("Test maximumValue(); given EMPTY_VALUE; then return MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InstructionOffsetValue.maximumValue()"})
  void testMaximumValue_givenEmpty_value_thenReturnMin_value() {
    // Arrange, Act and Assert
    assertEquals(Integer.MIN_VALUE, InstructionOffsetValue.EMPTY_VALUE.maximumValue());
  }

  /**
   * Test {@link InstructionOffsetValue#maximumValue()}.
   *
   * <ul>
   *   <li>Given {@link InstructionOffsetValue#InstructionOffsetValue(int)} with value is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#maximumValue()}
   */
  @Test
  @DisplayName("Test maximumValue(); given InstructionOffsetValue(int) with value is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InstructionOffsetValue.maximumValue()"})
  void testMaximumValue_givenInstructionOffsetValueWithValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42, new InstructionOffsetValue(42).maximumValue());
  }

  /**
   * Test {@link InstructionOffsetValue#isMethodParameter(int)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#isMethodParameter(int)}
   */
  @Test
  @DisplayName("Test isMethodParameter(int); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InstructionOffsetValue.isMethodParameter(int)"})
  void testIsMethodParameter_thenReturnFalse() {
    // Arrange
    InstructionOffsetValue instructionOffsetValue =
        new InstructionOffsetValue(new int[] {42, 1, 42, 1});

    // Act and Assert
    assertFalse(instructionOffsetValue.isMethodParameter(1));
  }

  /**
   * Test {@link InstructionOffsetValue#isMethodParameter(int)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#isMethodParameter(int)}
   */
  @Test
  @DisplayName("Test isMethodParameter(int); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InstructionOffsetValue.isMethodParameter(int)"})
  void testIsMethodParameter_thenReturnTrue() {
    // Arrange
    InstructionOffsetValue instructionOffsetValue =
        new InstructionOffsetValue(
            new int[] {
              42,
              InstructionOffsetValue.METHOD_PARAMETER,
              42,
              InstructionOffsetValue.METHOD_PARAMETER,
              42,
              InstructionOffsetValue.METHOD_PARAMETER,
              42,
              InstructionOffsetValue.METHOD_PARAMETER
            });

    // Act and Assert
    assertTrue(instructionOffsetValue.isMethodParameter(1));
  }

  /**
   * Test {@link InstructionOffsetValue#methodParameter(int)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#methodParameter(int)}
   */
  @Test
  @DisplayName("Test methodParameter(int); then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InstructionOffsetValue.methodParameter(int)"})
  void testMethodParameter_thenReturnOne() {
    // Arrange
    InstructionOffsetValue instructionOffsetValue =
        new InstructionOffsetValue(new int[] {42, 1, 42, 1});

    // Act and Assert
    assertEquals(1, instructionOffsetValue.methodParameter(1));
  }

  /**
   * Test {@link InstructionOffsetValue#isMethodReturnValue(int)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#isMethodReturnValue(int)}
   */
  @Test
  @DisplayName("Test isMethodReturnValue(int); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InstructionOffsetValue.isMethodReturnValue(int)"})
  void testIsMethodReturnValue_thenReturnFalse() {
    // Arrange
    InstructionOffsetValue instructionOffsetValue =
        new InstructionOffsetValue(new int[] {42, 1, 42, 1});

    // Act and Assert
    assertFalse(instructionOffsetValue.isMethodReturnValue(1));
  }

  /**
   * Test {@link InstructionOffsetValue#isMethodReturnValue(int)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#isMethodReturnValue(int)}
   */
  @Test
  @DisplayName("Test isMethodReturnValue(int); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InstructionOffsetValue.isMethodReturnValue(int)"})
  void testIsMethodReturnValue_thenReturnTrue() {
    // Arrange
    InstructionOffsetValue instructionOffsetValue =
        new InstructionOffsetValue(
            new int[] {
              42,
              InstructionOffsetValue.METHOD_RETURN_VALUE,
              42,
              InstructionOffsetValue.METHOD_RETURN_VALUE,
              42,
              InstructionOffsetValue.METHOD_RETURN_VALUE,
              42,
              InstructionOffsetValue.METHOD_RETURN_VALUE
            });

    // Act and Assert
    assertTrue(instructionOffsetValue.isMethodReturnValue(1));
  }

  /**
   * Test {@link InstructionOffsetValue#isFieldValue(int)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#isFieldValue(int)}
   */
  @Test
  @DisplayName("Test isFieldValue(int); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InstructionOffsetValue.isFieldValue(int)"})
  void testIsFieldValue_thenReturnFalse() {
    // Arrange
    InstructionOffsetValue instructionOffsetValue =
        new InstructionOffsetValue(new int[] {42, 1, 42, 1});

    // Act and Assert
    assertFalse(instructionOffsetValue.isFieldValue(1));
  }

  /**
   * Test {@link InstructionOffsetValue#isFieldValue(int)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#isFieldValue(int)}
   */
  @Test
  @DisplayName("Test isFieldValue(int); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InstructionOffsetValue.isFieldValue(int)"})
  void testIsFieldValue_thenReturnTrue() {
    // Arrange
    InstructionOffsetValue instructionOffsetValue =
        new InstructionOffsetValue(
            new int[] {
              42,
              InstructionOffsetValue.FIELD_VALUE,
              42,
              InstructionOffsetValue.FIELD_VALUE,
              42,
              InstructionOffsetValue.FIELD_VALUE,
              42,
              InstructionOffsetValue.FIELD_VALUE
            });

    // Act and Assert
    assertTrue(instructionOffsetValue.isFieldValue(1));
  }

  /**
   * Test {@link InstructionOffsetValue#isNewinstance(int)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#isNewinstance(int)}
   */
  @Test
  @DisplayName("Test isNewinstance(int); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InstructionOffsetValue.isNewinstance(int)"})
  void testIsNewinstance_thenReturnFalse() {
    // Arrange
    InstructionOffsetValue instructionOffsetValue =
        new InstructionOffsetValue(new int[] {42, 1, 42, 1});

    // Act and Assert
    assertFalse(instructionOffsetValue.isNewinstance(1));
  }

  /**
   * Test {@link InstructionOffsetValue#isNewinstance(int)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#isNewinstance(int)}
   */
  @Test
  @DisplayName("Test isNewinstance(int); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InstructionOffsetValue.isNewinstance(int)"})
  void testIsNewinstance_thenReturnTrue() {
    // Arrange
    InstructionOffsetValue instructionOffsetValue =
        new InstructionOffsetValue(
            new int[] {
              42,
              InstructionOffsetValue.NEW_INSTANCE,
              42,
              InstructionOffsetValue.NEW_INSTANCE,
              42,
              InstructionOffsetValue.NEW_INSTANCE,
              42,
              InstructionOffsetValue.NEW_INSTANCE
            });

    // Act and Assert
    assertTrue(instructionOffsetValue.isNewinstance(1));
  }

  /**
   * Test {@link InstructionOffsetValue#isCast(int)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#isCast(int)}
   */
  @Test
  @DisplayName("Test isCast(int); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InstructionOffsetValue.isCast(int)"})
  void testIsCast_thenReturnFalse() {
    // Arrange
    InstructionOffsetValue instructionOffsetValue =
        new InstructionOffsetValue(new int[] {42, 1, 42, 1});

    // Act and Assert
    assertFalse(instructionOffsetValue.isCast(1));
  }

  /**
   * Test {@link InstructionOffsetValue#isCast(int)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#isCast(int)}
   */
  @Test
  @DisplayName("Test isCast(int); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InstructionOffsetValue.isCast(int)"})
  void testIsCast_thenReturnTrue() {
    // Arrange
    InstructionOffsetValue instructionOffsetValue =
        new InstructionOffsetValue(
            new int[] {
              42,
              InstructionOffsetValue.CAST,
              42,
              InstructionOffsetValue.CAST,
              42,
              InstructionOffsetValue.CAST,
              42,
              InstructionOffsetValue.CAST
            });

    // Act and Assert
    assertTrue(instructionOffsetValue.isCast(1));
  }

  /**
   * Test {@link InstructionOffsetValue#isExceptionHandler(int)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#isExceptionHandler(int)}
   */
  @Test
  @DisplayName("Test isExceptionHandler(int); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InstructionOffsetValue.isExceptionHandler(int)"})
  void testIsExceptionHandler_thenReturnFalse() {
    // Arrange
    InstructionOffsetValue instructionOffsetValue =
        new InstructionOffsetValue(new int[] {42, 1, 42, 1});

    // Act and Assert
    assertFalse(instructionOffsetValue.isExceptionHandler(1));
  }

  /**
   * Test {@link InstructionOffsetValue#isExceptionHandler(int)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#isExceptionHandler(int)}
   */
  @Test
  @DisplayName("Test isExceptionHandler(int); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean InstructionOffsetValue.isExceptionHandler(int)"})
  void testIsExceptionHandler_thenReturnTrue() {
    // Arrange
    InstructionOffsetValue instructionOffsetValue =
        new InstructionOffsetValue(
            new int[] {
              42,
              InstructionOffsetValue.EXCEPTION_HANDLER,
              42,
              InstructionOffsetValue.EXCEPTION_HANDLER,
              42,
              InstructionOffsetValue.EXCEPTION_HANDLER,
              42,
              InstructionOffsetValue.EXCEPTION_HANDLER
            });

    // Act and Assert
    assertTrue(instructionOffsetValue.isExceptionHandler(1));
  }

  /**
   * Test {@link InstructionOffsetValue#add(int)}.
   *
   * <ul>
   *   <li>Given {@link InstructionOffsetValue#EMPTY_VALUE}.
   *   <li>Then return not Category2.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#add(int)}
   */
  @Test
  @DisplayName("Test add(int); given EMPTY_VALUE; then return not Category2")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InstructionOffsetValue InstructionOffsetValue.add(int)"})
  void testAdd_givenEmpty_value_thenReturnNotCategory2() {
    // Arrange and Act
    InstructionOffsetValue actualAddResult = InstructionOffsetValue.EMPTY_VALUE.add(42);

    // Assert
    assertFalse(actualAddResult.isCategory2());
    assertTrue(actualAddResult.isParticular());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Test {@link InstructionOffsetValue#add(int)}.
   *
   * <ul>
   *   <li>Given {@link InstructionOffsetValue#InstructionOffsetValue(int)} with value is one.
   *   <li>Then return not Category2.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#add(int)}
   */
  @Test
  @DisplayName(
      "Test add(int); given InstructionOffsetValue(int) with value is one; then return not Category2")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InstructionOffsetValue InstructionOffsetValue.add(int)"})
  void testAdd_givenInstructionOffsetValueWithValueIsOne_thenReturnNotCategory2() {
    // Arrange and Act
    InstructionOffsetValue actualAddResult = new InstructionOffsetValue(1).add(42);

    // Assert
    assertFalse(actualAddResult.isCategory2());
    assertTrue(actualAddResult.isParticular());
    assertTrue(actualAddResult.isSpecific());
  }

  /**
   * Test {@link InstructionOffsetValue#add(int)}.
   *
   * <ul>
   *   <li>Then return {@link InstructionOffsetValue#InstructionOffsetValue(int)} with value is
   *       forty-two.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#add(int)}
   */
  @Test
  @DisplayName("Test add(int); then return InstructionOffsetValue(int) with value is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InstructionOffsetValue InstructionOffsetValue.add(int)"})
  void testAdd_thenReturnInstructionOffsetValueWithValueIsFortyTwo() {
    // Arrange
    InstructionOffsetValue instructionOffsetValue = new InstructionOffsetValue(42);

    // Act
    InstructionOffsetValue actualAddResult = instructionOffsetValue.add(42);

    // Assert
    assertSame(instructionOffsetValue, actualAddResult);
  }

  /**
   * Test {@link InstructionOffsetValue#remove(int)}.
   *
   * <ul>
   *   <li>Given {@link InstructionOffsetValue#EMPTY_VALUE}.
   *   <li>Then return {@link InstructionOffsetValue#EMPTY_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#remove(int)}
   */
  @Test
  @DisplayName("Test remove(int); given EMPTY_VALUE; then return EMPTY_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InstructionOffsetValue InstructionOffsetValue.remove(int)"})
  void testRemove_givenEmpty_value_thenReturnEmpty_value() {
    // Arrange, Act and Assert
    assertSame(InstructionOffsetValue.EMPTY_VALUE, InstructionOffsetValue.EMPTY_VALUE.remove(42));
  }

  /**
   * Test {@link InstructionOffsetValue#remove(int)}.
   *
   * <ul>
   *   <li>Given {@link InstructionOffsetValue#InstructionOffsetValue(int)} with value is forty-two.
   *   <li>Then return {@link InstructionOffsetValue#EMPTY_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#remove(int)}
   */
  @Test
  @DisplayName(
      "Test remove(int); given InstructionOffsetValue(int) with value is forty-two; then return EMPTY_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InstructionOffsetValue InstructionOffsetValue.remove(int)"})
  void testRemove_givenInstructionOffsetValueWithValueIsFortyTwo_thenReturnEmpty_value() {
    // Arrange, Act and Assert
    assertEquals(InstructionOffsetValue.EMPTY_VALUE, new InstructionOffsetValue(42).remove(42));
  }

  /**
   * Test {@link InstructionOffsetValue#remove(int)}.
   *
   * <ul>
   *   <li>Then return {@link InstructionOffsetValue#InstructionOffsetValue(int)} with value is one.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#remove(int)}
   */
  @Test
  @DisplayName("Test remove(int); then return InstructionOffsetValue(int) with value is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InstructionOffsetValue InstructionOffsetValue.remove(int)"})
  void testRemove_thenReturnInstructionOffsetValueWithValueIsOne() {
    // Arrange
    InstructionOffsetValue instructionOffsetValue = new InstructionOffsetValue(1);

    // Act
    InstructionOffsetValue actualRemoveResult = instructionOffsetValue.remove(42);

    // Assert
    assertSame(instructionOffsetValue, actualRemoveResult);
  }

  /**
   * Test {@link InstructionOffsetValue#generalize(InstructionOffsetValue)} with {@code
   * InstructionOffsetValue}.
   *
   * <p>Method under test: {@link InstructionOffsetValue#generalize(InstructionOffsetValue)}
   */
  @Test
  @DisplayName("Test generalize(InstructionOffsetValue) with 'InstructionOffsetValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "InstructionOffsetValue InstructionOffsetValue.generalize(InstructionOffsetValue)"
  })
  void testGeneralizeWithInstructionOffsetValue() {
    // Arrange
    InstructionOffsetValue instructionOffsetValue = new InstructionOffsetValue(42);

    // Act
    InstructionOffsetValue actualGeneralizeResult =
        instructionOffsetValue.generalize(InstructionOffsetValue.EMPTY_VALUE);

    // Assert
    assertSame(instructionOffsetValue, actualGeneralizeResult);
  }

  /**
   * Test {@link InstructionOffsetValue#generalize(InstructionOffsetValue)} with {@code
   * InstructionOffsetValue}.
   *
   * <p>Method under test: {@link InstructionOffsetValue#generalize(InstructionOffsetValue)}
   */
  @Test
  @DisplayName("Test generalize(InstructionOffsetValue) with 'InstructionOffsetValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "InstructionOffsetValue InstructionOffsetValue.generalize(InstructionOffsetValue)"
  })
  void testGeneralizeWithInstructionOffsetValue2() {
    // Arrange
    InstructionOffsetValue instructionOffsetValue = new InstructionOffsetValue(42);
    InstructionOffsetValue other = new InstructionOffsetValue(42);

    // Act
    InstructionOffsetValue actualGeneralizeResult = instructionOffsetValue.generalize(other);

    // Assert
    assertSame(other, actualGeneralizeResult);
  }

  /**
   * Test {@link InstructionOffsetValue#generalize(InstructionOffsetValue)} with {@code
   * InstructionOffsetValue}.
   *
   * <p>Method under test: {@link InstructionOffsetValue#generalize(InstructionOffsetValue)}
   */
  @Test
  @DisplayName("Test generalize(InstructionOffsetValue) with 'InstructionOffsetValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "InstructionOffsetValue InstructionOffsetValue.generalize(InstructionOffsetValue)"
  })
  void testGeneralizeWithInstructionOffsetValue3() {
    // Arrange
    InstructionOffsetValue instructionOffsetValue = new InstructionOffsetValue(1);

    // Act
    InstructionOffsetValue actualGeneralizeResult =
        instructionOffsetValue.generalize(new InstructionOffsetValue(42));

    // Assert
    assertFalse(actualGeneralizeResult.isCategory2());
    assertTrue(actualGeneralizeResult.isParticular());
    assertTrue(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link InstructionOffsetValue#generalize(InstructionOffsetValue)} with {@code
   * InstructionOffsetValue}.
   *
   * <p>Method under test: {@link InstructionOffsetValue#generalize(InstructionOffsetValue)}
   */
  @Test
  @DisplayName("Test generalize(InstructionOffsetValue) with 'InstructionOffsetValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "InstructionOffsetValue InstructionOffsetValue.generalize(InstructionOffsetValue)"
  })
  void testGeneralizeWithInstructionOffsetValue4() {
    // Arrange
    InstructionOffsetValue instructionOffsetValue =
        new InstructionOffsetValue(new int[] {42, 1, 42, 42});

    // Act
    InstructionOffsetValue actualGeneralizeResult =
        instructionOffsetValue.generalize(new InstructionOffsetValue(42));

    // Assert
    assertSame(instructionOffsetValue, actualGeneralizeResult);
  }

  /**
   * Test {@link InstructionOffsetValue#generalize(InstructionOffsetValue)} with {@code
   * InstructionOffsetValue}.
   *
   * <ul>
   *   <li>Given {@link InstructionOffsetValue#EMPTY_VALUE}.
   *   <li>Then return {@link InstructionOffsetValue#EMPTY_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#generalize(InstructionOffsetValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(InstructionOffsetValue) with 'InstructionOffsetValue'; given EMPTY_VALUE; then return EMPTY_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "InstructionOffsetValue InstructionOffsetValue.generalize(InstructionOffsetValue)"
  })
  void testGeneralizeWithInstructionOffsetValue_givenEmpty_value_thenReturnEmpty_value() {
    // Arrange, Act and Assert
    assertSame(
        InstructionOffsetValue.EMPTY_VALUE,
        InstructionOffsetValue.EMPTY_VALUE.generalize(InstructionOffsetValue.EMPTY_VALUE));
  }

  /**
   * Test {@link InstructionOffsetValue#generalize(InstructionOffsetValue)} with {@code
   * InstructionOffsetValue}.
   *
   * <ul>
   *   <li>Then return not Category2.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#generalize(InstructionOffsetValue)}
   */
  @Test
  @DisplayName(
      "Test generalize(InstructionOffsetValue) with 'InstructionOffsetValue'; then return not Category2")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "InstructionOffsetValue InstructionOffsetValue.generalize(InstructionOffsetValue)"
  })
  void testGeneralizeWithInstructionOffsetValue_thenReturnNotCategory2() {
    // Arrange
    InstructionOffsetValue instructionOffsetValue =
        new InstructionOffsetValue(new int[] {42, 1, 42, 1});

    // Act
    InstructionOffsetValue actualGeneralizeResult =
        instructionOffsetValue.generalize(new InstructionOffsetValue(42));

    // Assert
    assertFalse(actualGeneralizeResult.isCategory2());
    assertTrue(actualGeneralizeResult.isParticular());
    assertTrue(actualGeneralizeResult.isSpecific());
  }

  /**
   * Test {@link InstructionOffsetValue#generalize(Value)} with {@code Value}.
   *
   * <p>Method under test: {@link InstructionOffsetValue#generalize(Value)}
   */
  @Test
  @DisplayName("Test generalize(Value) with 'Value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value InstructionOffsetValue.generalize(Value)"})
  void testGeneralizeWithValue() {
    // Arrange
    InstructionOffsetValue instructionOffsetValue =
        new InstructionOffsetValue(new int[] {42, 1, 42, 1});

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            instructionOffsetValue.generalize(
                new ComparisonValue(
                    InstructionOffsetValue.EMPTY_VALUE, InstructionOffsetValue.EMPTY_VALUE)));
  }

  /**
   * Test {@link InstructionOffsetValue#generalize(Value)} with {@code Value}.
   *
   * <ul>
   *   <li>Given {@link InstructionOffsetValue#EMPTY_VALUE}.
   *   <li>When {@link InstructionOffsetValue#EMPTY_VALUE}.
   *   <li>Then return {@link InstructionOffsetValue#EMPTY_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#generalize(Value)}
   */
  @Test
  @DisplayName(
      "Test generalize(Value) with 'Value'; given EMPTY_VALUE; when EMPTY_VALUE; then return EMPTY_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value InstructionOffsetValue.generalize(Value)"})
  void testGeneralizeWithValue_givenEmpty_value_whenEmpty_value_thenReturnEmpty_value() {
    // Arrange and Act
    Value actualGeneralizeResult =
        InstructionOffsetValue.EMPTY_VALUE.generalize((Value) InstructionOffsetValue.EMPTY_VALUE);

    // Assert
    assertSame(
        ((InstructionOffsetValue) actualGeneralizeResult).EMPTY_VALUE, actualGeneralizeResult);
  }

  /**
   * Test {@link InstructionOffsetValue#generalize(Value)} with {@code Value}.
   *
   * <ul>
   *   <li>Then return {@link InstructionOffsetValue#InstructionOffsetValue(int)} with value is
   *       forty-two.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#generalize(Value)}
   */
  @Test
  @DisplayName(
      "Test generalize(Value) with 'Value'; then return InstructionOffsetValue(int) with value is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value InstructionOffsetValue.generalize(Value)"})
  void testGeneralizeWithValue_thenReturnInstructionOffsetValueWithValueIsFortyTwo() {
    // Arrange
    InstructionOffsetValue instructionOffsetValue = new InstructionOffsetValue(42);

    // Act
    Value actualGeneralizeResult =
        instructionOffsetValue.generalize((Value) InstructionOffsetValue.EMPTY_VALUE);

    // Assert
    assertSame(instructionOffsetValue, actualGeneralizeResult);
  }

  /**
   * Test {@link InstructionOffsetValue#generalize(Value)} with {@code Value}.
   *
   * <ul>
   *   <li>When {@link BasicRangeValueFactory#INTEGER_VALUE_BYTE}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#generalize(Value)}
   */
  @Test
  @DisplayName(
      "Test generalize(Value) with 'Value'; when INTEGER_VALUE_BYTE; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value InstructionOffsetValue.generalize(Value)"})
  void testGeneralizeWithValue_whenInteger_value_byte_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            InstructionOffsetValue.EMPTY_VALUE.generalize(
                BasicRangeValueFactory.INTEGER_VALUE_BYTE));
  }

  /**
   * Test {@link InstructionOffsetValue#generalize(Value)} with {@code Value}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#UNKNOWN_VALUE}.
   *   <li>Then return {@link BasicValueFactory#UNKNOWN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#generalize(Value)}
   */
  @Test
  @DisplayName("Test generalize(Value) with 'Value'; when UNKNOWN_VALUE; then return UNKNOWN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value InstructionOffsetValue.generalize(Value)"})
  void testGeneralizeWithValue_whenUnknown_value_thenReturnUnknown_value() {
    // Arrange
    UnknownValue other = BasicValueFactory.UNKNOWN_VALUE;

    // Act
    Value actualGeneralizeResult = InstructionOffsetValue.EMPTY_VALUE.generalize(other);

    // Assert
    assertSame(other, actualGeneralizeResult);
  }

  /**
   * Test {@link InstructionOffsetValue#instructionOffsetValue()}.
   *
   * <p>Method under test: {@link InstructionOffsetValue#instructionOffsetValue()}
   */
  @Test
  @DisplayName("Test instructionOffsetValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"InstructionOffsetValue InstructionOffsetValue.instructionOffsetValue()"})
  void testInstructionOffsetValue() {
    // Arrange, Act and Assert
    assertSame(
        InstructionOffsetValue.EMPTY_VALUE,
        InstructionOffsetValue.EMPTY_VALUE.instructionOffsetValue());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InstructionOffsetValue#isParticular()}
   *   <li>{@link InstructionOffsetValue#isSpecific()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean InstructionOffsetValue.isParticular()",
    "boolean InstructionOffsetValue.isSpecific()"
  })
  void testGettersAndSetters() {
    // Arrange
    InstructionOffsetValue instructionOffsetValue = new InstructionOffsetValue(42);

    // Act
    boolean actualIsParticularResult = instructionOffsetValue.isParticular();

    // Assert
    assertTrue(actualIsParticularResult);
    assertTrue(instructionOffsetValue.isSpecific());
  }

  /**
   * Test {@link InstructionOffsetValue#computationalType()}.
   *
   * <p>Method under test: {@link InstructionOffsetValue#computationalType()}
   */
  @Test
  @DisplayName("Test computationalType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int InstructionOffsetValue.computationalType()"})
  void testComputationalType() {
    // Arrange, Act and Assert
    assertEquals(6, InstructionOffsetValue.EMPTY_VALUE.computationalType());
  }

  /**
   * Test {@link InstructionOffsetValue#internalType()}.
   *
   * <p>Method under test: {@link InstructionOffsetValue#internalType()}
   */
  @Test
  @DisplayName("Test internalType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String InstructionOffsetValue.internalType()"})
  void testInternalType() {
    // Arrange, Act and Assert
    assertEquals("I", InstructionOffsetValue.EMPTY_VALUE.internalType());
  }

  /**
   * Test {@link InstructionOffsetValue#equals(Object)}, and {@link
   * InstructionOffsetValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InstructionOffsetValue#equals(Object)}
   *   <li>{@link InstructionOffsetValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean InstructionOffsetValue.equals(Object)",
    "int InstructionOffsetValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    InstructionOffsetValue instructionOffsetValue = InstructionOffsetValue.EMPTY_VALUE;
    InstructionOffsetValue instructionOffsetValue2 = InstructionOffsetValue.EMPTY_VALUE;

    // Act and Assert
    assertEquals(instructionOffsetValue, instructionOffsetValue2);
    assertEquals(instructionOffsetValue.hashCode(), instructionOffsetValue2.hashCode());
  }

  /**
   * Test {@link InstructionOffsetValue#equals(Object)}, and {@link
   * InstructionOffsetValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InstructionOffsetValue#equals(Object)}
   *   <li>{@link InstructionOffsetValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean InstructionOffsetValue.equals(Object)",
    "int InstructionOffsetValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    InstructionOffsetValue instructionOffsetValue = new InstructionOffsetValue(42);
    InstructionOffsetValue instructionOffsetValue2 = new InstructionOffsetValue(42);

    // Act and Assert
    assertEquals(instructionOffsetValue, instructionOffsetValue2);
    assertEquals(instructionOffsetValue.hashCode(), instructionOffsetValue2.hashCode());
  }

  /**
   * Test {@link InstructionOffsetValue#equals(Object)}, and {@link
   * InstructionOffsetValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link InstructionOffsetValue#equals(Object)}
   *   <li>{@link InstructionOffsetValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean InstructionOffsetValue.equals(Object)",
    "int InstructionOffsetValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    InstructionOffsetValue instructionOffsetValue = InstructionOffsetValue.EMPTY_VALUE;

    // Act and Assert
    assertEquals(instructionOffsetValue, instructionOffsetValue);
    int expectedHashCodeResult = instructionOffsetValue.hashCode();
    assertEquals(expectedHashCodeResult, instructionOffsetValue.hashCode());
  }

  /**
   * Test {@link InstructionOffsetValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean InstructionOffsetValue.equals(Object)",
    "int InstructionOffsetValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new InstructionOffsetValue(42), InstructionOffsetValue.EMPTY_VALUE);
  }

  /**
   * Test {@link InstructionOffsetValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean InstructionOffsetValue.equals(Object)",
    "int InstructionOffsetValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    InstructionOffsetValue instructionOffsetValue = new InstructionOffsetValue(1);

    // Act and Assert
    assertNotEquals(instructionOffsetValue, new InstructionOffsetValue(42));
  }

  /**
   * Test {@link InstructionOffsetValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean InstructionOffsetValue.equals(Object)",
    "int InstructionOffsetValue.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(InstructionOffsetValue.EMPTY_VALUE, null);
  }

  /**
   * Test {@link InstructionOffsetValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean InstructionOffsetValue.equals(Object)",
    "int InstructionOffsetValue.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(InstructionOffsetValue.EMPTY_VALUE, "Different type to InstructionOffsetValue");
  }

  /**
   * Test {@link InstructionOffsetValue#toString()}.
   *
   * <ul>
   *   <li>Given {@link InstructionOffsetValue#EMPTY_VALUE}.
   *   <li>Then return {@code :}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#toString()}
   */
  @Test
  @DisplayName("Test toString(); given EMPTY_VALUE; then return ':'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String InstructionOffsetValue.toString()"})
  void testToString_givenEmpty_value_thenReturnColon() {
    // Arrange, Act and Assert
    assertEquals(":", InstructionOffsetValue.EMPTY_VALUE.toString());
  }

  /**
   * Test {@link InstructionOffsetValue#toString()}.
   *
   * <ul>
   *   <li>Given {@link InstructionOffsetValue#InstructionOffsetValue(int)} with value is {@link
   *       InstructionOffsetValue#CAST}.
   *   <li>Then return {@code C0:}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given InstructionOffsetValue(int) with value is CAST; then return 'C0:'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String InstructionOffsetValue.toString()"})
  void testToString_givenInstructionOffsetValueWithValueIsCast_thenReturnC0() {
    // Arrange, Act and Assert
    assertEquals("C0:", new InstructionOffsetValue(InstructionOffsetValue.CAST).toString());
  }

  /**
   * Test {@link InstructionOffsetValue#toString()}.
   *
   * <ul>
   *   <li>Given {@link InstructionOffsetValue#InstructionOffsetValue(int)} with value is {@link
   *       InstructionOffsetValue#FIELD_VALUE}.
   *   <li>Then return {@code F0:}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given InstructionOffsetValue(int) with value is FIELD_VALUE; then return 'F0:'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String InstructionOffsetValue.toString()"})
  void testToString_givenInstructionOffsetValueWithValueIsField_value_thenReturnF0() {
    // Arrange, Act and Assert
    assertEquals("F0:", new InstructionOffsetValue(InstructionOffsetValue.FIELD_VALUE).toString());
  }

  /**
   * Test {@link InstructionOffsetValue#toString()}.
   *
   * <ul>
   *   <li>Given {@link InstructionOffsetValue#InstructionOffsetValue(int)} with value is forty-two.
   *   <li>Then return {@code 42:}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given InstructionOffsetValue(int) with value is forty-two; then return '42:'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String InstructionOffsetValue.toString()"})
  void testToString_givenInstructionOffsetValueWithValueIsFortyTwo_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42:", new InstructionOffsetValue(42).toString());
  }

  /**
   * Test {@link InstructionOffsetValue#toString()}.
   *
   * <ul>
   *   <li>Given {@link InstructionOffsetValue#InstructionOffsetValue(int)} with value is {@link
   *       InstructionOffsetValue#METHOD_PARAMETER}.
   *   <li>Then return {@code P0:}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given InstructionOffsetValue(int) with value is METHOD_PARAMETER; then return 'P0:'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String InstructionOffsetValue.toString()"})
  void testToString_givenInstructionOffsetValueWithValueIsMethod_parameter_thenReturnP0() {
    // Arrange, Act and Assert
    assertEquals(
        "P0:", new InstructionOffsetValue(InstructionOffsetValue.METHOD_PARAMETER).toString());
  }

  /**
   * Test {@link InstructionOffsetValue#toString()}.
   *
   * <ul>
   *   <li>Given {@link InstructionOffsetValue#InstructionOffsetValue(int)} with value is {@link
   *       Value#NEVER}.
   *   <li>Then return {@code -1:}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given InstructionOffsetValue(int) with value is NEVER; then return '-1:'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String InstructionOffsetValue.toString()"})
  void testToString_givenInstructionOffsetValueWithValueIsNever_thenReturn1() {
    // Arrange, Act and Assert
    assertEquals("-1:", new InstructionOffsetValue(Value.NEVER).toString());
  }

  /**
   * Test {@link InstructionOffsetValue#toString()}.
   *
   * <ul>
   *   <li>Given {@link InstructionOffsetValue#InstructionOffsetValue(int)} with value is {@link
   *       InstructionOffsetValue#NEW_INSTANCE}.
   *   <li>Then return {@code N0:}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#toString()}
   */
  @Test
  @DisplayName(
      "Test toString(); given InstructionOffsetValue(int) with value is NEW_INSTANCE; then return 'N0:'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String InstructionOffsetValue.toString()"})
  void testToString_givenInstructionOffsetValueWithValueIsNew_instance_thenReturnN0() {
    // Arrange, Act and Assert
    assertEquals("N0:", new InstructionOffsetValue(InstructionOffsetValue.NEW_INSTANCE).toString());
  }

  /**
   * Test {@link InstructionOffsetValue#toString()}.
   *
   * <ul>
   *   <li>Then return {@code 42,58,42,58:}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return '42,58,42,58:'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String InstructionOffsetValue.toString()"})
  void testToString_thenReturn42584258() {
    // Arrange
    InstructionOffsetValue instructionOffsetValue =
        new InstructionOffsetValue(new int[] {42, 58, 42, 58});

    // Act and Assert
    assertEquals("42,58,42,58:", instructionOffsetValue.toString());
  }

  /**
   * Test {@link InstructionOffsetValue#toString()}.
   *
   * <ul>
   *   <li>Then return {@code E0:}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'E0:'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String InstructionOffsetValue.toString()"})
  void testToString_thenReturnE0() {
    // Arrange, Act and Assert
    assertEquals(
        "E0:", new InstructionOffsetValue(InstructionOffsetValue.EXCEPTION_HANDLER).toString());
  }

  /**
   * Test {@link InstructionOffsetValue#toString()}.
   *
   * <ul>
   *   <li>Then return {@code M0:}.
   * </ul>
   *
   * <p>Method under test: {@link InstructionOffsetValue#toString()}
   */
  @Test
  @DisplayName("Test toString(); then return 'M0:'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String InstructionOffsetValue.toString()"})
  void testToString_thenReturnM0() {
    // Arrange, Act and Assert
    assertEquals(
        "M0:", new InstructionOffsetValue(InstructionOffsetValue.METHOD_RETURN_VALUE).toString());
  }
}
