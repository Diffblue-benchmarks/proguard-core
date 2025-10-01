package proguard.evaluation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.evaluation.MethodResult.Builder;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.DoubleValue;
import proguard.evaluation.value.ReferenceValue;
import proguard.evaluation.value.UnknownReferenceValue;
import proguard.evaluation.value.Value;
import proguard.evaluation.value.object.AnalyzedObject;

class MethodResultDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>default or parameterless constructor of {@link Builder}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Builder.<init>()", "MethodResult Builder.build()"})
  void testBuilderBuild() {
    // Arrange
    ReferenceValue updatedInstance = BasicValueFactory.REFERENCE_VALUE;

    // Act
    Builder actualSetUpdatedInstanceResult = new Builder().setUpdatedInstance(updatedInstance);
    ArrayList<Value> updatedParameters = new ArrayList<>();
    MethodResult actualMethodResult =
        actualSetUpdatedInstanceResult.setUpdatedParameters(updatedParameters).build();

    // Assert
    assertFalse(actualMethodResult.isReturnValuePresent());
    List<Value> updatedParameters2 = actualMethodResult.getUpdatedParameters();
    assertTrue(updatedParameters2.isEmpty());
    assertTrue(actualMethodResult.isAnyParameterUpdated());
    assertTrue(actualMethodResult.isInstanceUpdated());
    assertTrue(actualMethodResult.isResultValid());
    assertSame(updatedParameters, updatedParameters2);
    assertSame(updatedInstance, actualMethodResult.getUpdatedInstance());
  }

  /**
   * Test Builder {@link Builder#setReturnValue(Value)}.
   *
   * <p>Method under test: {@link Builder#setReturnValue(Value)}
   */
  @Test
  @DisplayName("Test Builder setReturnValue(Value)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.setReturnValue(Value)"})
  void testBuilderSetReturnValue() {
    // Arrange
    Builder builder = new Builder();
    DoubleValue returnValue = BasicValueFactory.DOUBLE_VALUE;

    // Act
    Builder actualSetReturnValueResult = builder.setReturnValue(returnValue);

    // Assert
    MethodResult methodResult = builder.build();
    assertTrue(methodResult.isReturnValuePresent());
    assertSame(builder, actualSetReturnValueResult);
    assertSame(returnValue, methodResult.getReturnValue());
  }

  /**
   * Test Builder {@link Builder#setUpdatedInstance(ReferenceValue)}.
   *
   * <ul>
   *   <li>Given {@link Builder} (default constructor).
   *   <li>Then {@link Builder} (default constructor) build InstanceUpdated.
   * </ul>
   *
   * <p>Method under test: {@link Builder#setUpdatedInstance(ReferenceValue)}
   */
  @Test
  @DisplayName(
      "Test Builder setUpdatedInstance(ReferenceValue); given Builder (default constructor); then Builder (default constructor) build InstanceUpdated")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.setUpdatedInstance(ReferenceValue)"})
  void testBuilderSetUpdatedInstance_givenBuilder_thenBuilderBuildInstanceUpdated() {
    // Arrange
    Builder builder = new Builder();
    ReferenceValue updatedInstance = BasicValueFactory.REFERENCE_VALUE;

    // Act
    Builder actualSetUpdatedInstanceResult = builder.setUpdatedInstance(updatedInstance);

    // Assert
    MethodResult methodResult = builder.build();
    assertTrue(methodResult.isInstanceUpdated());
    assertSame(builder, actualSetUpdatedInstanceResult);
    assertSame(updatedInstance, methodResult.getUpdatedInstance());
  }

  /**
   * Test Builder {@link Builder#setUpdatedInstance(ReferenceValue)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#setUpdatedInstance(ReferenceValue)}
   */
  @Test
  @DisplayName("Test Builder setUpdatedInstance(ReferenceValue); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.setUpdatedInstance(ReferenceValue)"})
  void testBuilderSetUpdatedInstance_thenThrowIllegalStateException() {
    // Arrange
    Builder builder = new Builder();
    builder.setUpdatedInstance(BasicValueFactory.REFERENCE_VALUE);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> builder.setUpdatedInstance(BasicValueFactory.REFERENCE_VALUE));
  }

  /**
   * Test Builder {@link Builder#setUpdatedParameters(List)}.
   *
   * <ul>
   *   <li>Then {@link Builder} (default constructor) build AnyParameterUpdated.
   * </ul>
   *
   * <p>Method under test: {@link Builder#setUpdatedParameters(List)}
   */
  @Test
  @DisplayName(
      "Test Builder setUpdatedParameters(List); then Builder (default constructor) build AnyParameterUpdated")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.setUpdatedParameters(List)"})
  void testBuilderSetUpdatedParameters_thenBuilderBuildAnyParameterUpdated() {
    // Arrange
    Builder builder = new Builder();
    ArrayList<Value> updatedParameters = new ArrayList<>();

    // Act
    Builder actualSetUpdatedParametersResult = builder.setUpdatedParameters(updatedParameters);

    // Assert
    MethodResult methodResult = builder.build();
    assertTrue(methodResult.isAnyParameterUpdated());
    assertSame(updatedParameters, methodResult.getUpdatedParameters());
    assertSame(builder, actualSetUpdatedParametersResult);
  }

  /**
   * Test Builder {@link Builder#setUpdatedParameters(List)}.
   *
   * <ul>
   *   <li>Then return build UpdatedParameters is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#setUpdatedParameters(List)}
   */
  @Test
  @DisplayName(
      "Test Builder setUpdatedParameters(List); then return build UpdatedParameters is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.setUpdatedParameters(List)"})
  void testBuilderSetUpdatedParameters_thenReturnBuildUpdatedParametersIsArrayList() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<Value> updatedParameters = new ArrayList<>();
    updatedParameters.add(BasicValueFactory.DOUBLE_VALUE);

    // Act and Assert
    assertSame(
        updatedParameters,
        builder.setUpdatedParameters(updatedParameters).build().getUpdatedParameters());
  }

  /**
   * Test Builder {@link Builder#setUpdatedParameters(List)}.
   *
   * <ul>
   *   <li>Then return build UpdatedParameters is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#setUpdatedParameters(List)}
   */
  @Test
  @DisplayName(
      "Test Builder setUpdatedParameters(List); then return build UpdatedParameters is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.setUpdatedParameters(List)"})
  void testBuilderSetUpdatedParameters_thenReturnBuildUpdatedParametersIsArrayList2() {
    // Arrange
    Builder builder = new Builder();

    ArrayList<Value> updatedParameters = new ArrayList<>();
    updatedParameters.add(BasicValueFactory.DOUBLE_VALUE);
    updatedParameters.add(BasicValueFactory.DOUBLE_VALUE);

    // Act and Assert
    assertSame(
        updatedParameters,
        builder.setUpdatedParameters(updatedParameters).build().getUpdatedParameters());
  }

  /**
   * Test Builder {@link Builder#setUpdatedParameters(List)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#setUpdatedParameters(List)}
   */
  @Test
  @DisplayName("Test Builder setUpdatedParameters(List); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.setUpdatedParameters(List)"})
  void testBuilderSetUpdatedParameters_thenThrowIllegalStateException() {
    // Arrange
    Builder builder = new Builder();
    builder.setUpdatedParameters(new ArrayList<>());

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> builder.setUpdatedParameters(new ArrayList<>()));
  }

  /**
   * Test {@link MethodResult#invalidResult()}.
   *
   * <p>Method under test: {@link MethodResult#invalidResult()}
   */
  @Test
  @DisplayName("Test invalidResult()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MethodResult MethodResult.invalidResult()"})
  void testInvalidResult() {
    // Arrange and Act
    MethodResult actualInvalidResultResult = MethodResult.invalidResult();

    // Assert
    assertFalse(actualInvalidResultResult.isAnyParameterUpdated());
    assertFalse(actualInvalidResultResult.isInstanceUpdated());
    assertFalse(actualInvalidResultResult.isResultValid());
    assertFalse(actualInvalidResultResult.isReturnValuePresent());
  }

  /**
   * Test {@link MethodResult#isResultValid()}.
   *
   * <ul>
   *   <li>Given invalidResult.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MethodResult#isResultValid()}
   */
  @Test
  @DisplayName("Test isResultValid(); given invalidResult; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MethodResult.isResultValid()"})
  void testIsResultValid_givenInvalidResult_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(MethodResult.invalidResult().isResultValid());
  }

  /**
   * Test {@link MethodResult#isResultValid()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MethodResult#isResultValid()}
   */
  @Test
  @DisplayName("Test isResultValid(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MethodResult.isResultValid()"})
  void testIsResultValid_thenReturnTrue() {
    // Arrange
    Builder setUpdatedInstanceResult =
        new Builder().setUpdatedInstance(BasicValueFactory.REFERENCE_VALUE);

    // Act and Assert
    assertTrue(
        setUpdatedInstanceResult.setUpdatedParameters(new ArrayList<>()).build().isResultValid());
  }

  /**
   * Test {@link MethodResult#isReturnValuePresent()}.
   *
   * <p>Method under test: {@link MethodResult#isReturnValuePresent()}
   */
  @Test
  @DisplayName("Test isReturnValuePresent()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MethodResult.isReturnValuePresent()"})
  void testIsReturnValuePresent() {
    // Arrange
    Builder setUpdatedInstanceResult =
        new Builder().setUpdatedInstance(BasicValueFactory.REFERENCE_VALUE);

    // Act and Assert
    assertFalse(
        setUpdatedInstanceResult
            .setUpdatedParameters(new ArrayList<>())
            .build()
            .isReturnValuePresent());
  }

  /**
   * Test {@link MethodResult#isInstanceUpdated()}.
   *
   * <ul>
   *   <li>Given invalidResult.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MethodResult#isInstanceUpdated()}
   */
  @Test
  @DisplayName("Test isInstanceUpdated(); given invalidResult; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MethodResult.isInstanceUpdated()"})
  void testIsInstanceUpdated_givenInvalidResult_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(MethodResult.invalidResult().isInstanceUpdated());
  }

  /**
   * Test {@link MethodResult#isInstanceUpdated()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MethodResult#isInstanceUpdated()}
   */
  @Test
  @DisplayName("Test isInstanceUpdated(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MethodResult.isInstanceUpdated()"})
  void testIsInstanceUpdated_thenReturnTrue() {
    // Arrange
    Builder setUpdatedInstanceResult =
        new Builder().setUpdatedInstance(BasicValueFactory.REFERENCE_VALUE);

    // Act and Assert
    assertTrue(
        setUpdatedInstanceResult
            .setUpdatedParameters(new ArrayList<>())
            .build()
            .isInstanceUpdated());
  }

  /**
   * Test {@link MethodResult#isAnyParameterUpdated()}.
   *
   * <ul>
   *   <li>Given invalidResult.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link MethodResult#isAnyParameterUpdated()}
   */
  @Test
  @DisplayName("Test isAnyParameterUpdated(); given invalidResult; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MethodResult.isAnyParameterUpdated()"})
  void testIsAnyParameterUpdated_givenInvalidResult_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(MethodResult.invalidResult().isAnyParameterUpdated());
  }

  /**
   * Test {@link MethodResult#isAnyParameterUpdated()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MethodResult#isAnyParameterUpdated()}
   */
  @Test
  @DisplayName("Test isAnyParameterUpdated(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MethodResult.isAnyParameterUpdated()"})
  void testIsAnyParameterUpdated_thenReturnTrue() {
    // Arrange
    Builder setUpdatedInstanceResult =
        new Builder().setUpdatedInstance(BasicValueFactory.REFERENCE_VALUE);

    // Act and Assert
    assertTrue(
        setUpdatedInstanceResult
            .setUpdatedParameters(new ArrayList<>())
            .build()
            .isAnyParameterUpdated());
  }

  /**
   * Test {@link MethodResult#getReturnValue()}.
   *
   * <p>Method under test: {@link MethodResult#getReturnValue()}
   */
  @Test
  @DisplayName("Test getReturnValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Value MethodResult.getReturnValue()"})
  void testGetReturnValue() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> MethodResult.invalidResult().getReturnValue());
  }

  /**
   * Test {@link MethodResult#getUpdatedInstance()}.
   *
   * <ul>
   *   <li>Given invalidResult.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link MethodResult#getUpdatedInstance()}
   */
  @Test
  @DisplayName("Test getUpdatedInstance(); given invalidResult; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReferenceValue MethodResult.getUpdatedInstance()"})
  void testGetUpdatedInstance_givenInvalidResult_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class, () -> MethodResult.invalidResult().getUpdatedInstance());
  }

  /**
   * Test {@link MethodResult#getUpdatedInstance()}.
   *
   * <ul>
   *   <li>Then return {@link UnknownReferenceValue}.
   * </ul>
   *
   * <p>Method under test: {@link MethodResult#getUpdatedInstance()}
   */
  @Test
  @DisplayName("Test getUpdatedInstance(); then return UnknownReferenceValue")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ReferenceValue MethodResult.getUpdatedInstance()"})
  void testGetUpdatedInstance_thenReturnUnknownReferenceValue() {
    // Arrange
    Builder setUpdatedInstanceResult =
        new Builder().setUpdatedInstance(BasicValueFactory.REFERENCE_VALUE);

    // Act
    ReferenceValue actualUpdatedInstance =
        setUpdatedInstanceResult
            .setUpdatedParameters(new ArrayList<>())
            .build()
            .getUpdatedInstance();

    // Assert
    assertTrue(actualUpdatedInstance instanceof UnknownReferenceValue);
    assertEquals("Ljava/lang/Object;", actualUpdatedInstance.getType());
    AnalyzedObject value = actualUpdatedInstance.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualUpdatedInstance.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualUpdatedInstance.isNotNull());
    assertEquals(0, actualUpdatedInstance.isNull());
    assertFalse(actualUpdatedInstance.isCategory2());
    assertFalse(actualUpdatedInstance.isParticular());
    assertFalse(actualUpdatedInstance.isSpecific());
  }

  /**
   * Test {@link MethodResult#getUpdatedParameters()}.
   *
   * <ul>
   *   <li>Given invalidResult.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link MethodResult#getUpdatedParameters()}
   */
  @Test
  @DisplayName("Test getUpdatedParameters(); given invalidResult; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MethodResult.getUpdatedParameters()"})
  void testGetUpdatedParameters_givenInvalidResult_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class, () -> MethodResult.invalidResult().getUpdatedParameters());
  }

  /**
   * Test {@link MethodResult#getUpdatedParameters()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link MethodResult#getUpdatedParameters()}
   */
  @Test
  @DisplayName("Test getUpdatedParameters(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List MethodResult.getUpdatedParameters()"})
  void testGetUpdatedParameters_thenReturnEmpty() {
    // Arrange
    Builder setUpdatedInstanceResult =
        new Builder().setUpdatedInstance(BasicValueFactory.REFERENCE_VALUE);

    // Act and Assert
    assertTrue(
        setUpdatedInstanceResult
            .setUpdatedParameters(new ArrayList<>())
            .build()
            .getUpdatedParameters()
            .isEmpty());
  }
}
