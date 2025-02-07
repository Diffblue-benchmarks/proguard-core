package proguard.evaluation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.MethodResult$Builder.<init>()",
    "proguard.evaluation.MethodResult proguard.evaluation.MethodResult$Builder.build()"
  })
  void testBuilderBuild() {
    // Arrange
    Builder setUpdatedInstanceResult =
        (new Builder()).setUpdatedInstance(BasicValueFactory.REFERENCE_VALUE);
    ArrayList<Value> updatedParameters = new ArrayList<>();

    // Act
    MethodResult actualBuildResult =
        setUpdatedInstanceResult.setUpdatedParameters(updatedParameters).build();

    // Assert
    assertTrue(actualBuildResult.getUpdatedInstance() instanceof UnknownReferenceValue);
    assertFalse(actualBuildResult.isReturnValuePresent());
    List<Value> updatedParameters2 = actualBuildResult.getUpdatedParameters();
    assertTrue(updatedParameters2.isEmpty());
    assertTrue(actualBuildResult.isAnyParameterUpdated());
    assertTrue(actualBuildResult.isInstanceUpdated());
    assertTrue(actualBuildResult.isResultValid());
    assertSame(updatedParameters, updatedParameters2);
  }

  /**
   * Test Builder {@link Builder#setReturnValue(Value)}.
   *
   * <p>Method under test: {@link Builder#setReturnValue(Value)}
   */
  @Test
  @DisplayName("Test Builder setReturnValue(Value)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult$Builder proguard.evaluation.MethodResult$Builder.setReturnValue(proguard.evaluation.value.Value)"
  })
  void testBuilderSetReturnValue() {
    // Arrange
    Builder builder = new Builder();
    DoubleValue returnValue = BasicValueFactory.DOUBLE_VALUE;

    // Act
    Builder actualSetReturnValueResult = builder.setReturnValue(returnValue);

    // Assert
    MethodResult buildResult = builder.build();
    assertTrue(buildResult.isReturnValuePresent());
    assertSame(builder, actualSetReturnValueResult);
    assertSame(returnValue, buildResult.getReturnValue());
  }

  /**
   * Test Builder {@link Builder#setUpdatedInstance(ReferenceValue)}.
   *
   * <p>Method under test: {@link Builder#setUpdatedInstance(ReferenceValue)}
   */
  @Test
  @DisplayName("Test Builder setUpdatedInstance(ReferenceValue)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult$Builder proguard.evaluation.MethodResult$Builder.setUpdatedInstance(proguard.evaluation.value.ReferenceValue)"
  })
  void testBuilderSetUpdatedInstance() {
    // Arrange
    Builder builder = new Builder();
    ReferenceValue updatedInstance = BasicValueFactory.REFERENCE_VALUE;

    // Act
    Builder actualSetUpdatedInstanceResult = builder.setUpdatedInstance(updatedInstance);

    // Assert
    MethodResult buildResult = builder.build();
    assertTrue(buildResult.isInstanceUpdated());
    assertSame(builder, actualSetUpdatedInstanceResult);
    assertSame(updatedInstance, buildResult.getUpdatedInstance());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult$Builder proguard.evaluation.MethodResult$Builder.setUpdatedParameters(java.util.List)"
  })
  void testBuilderSetUpdatedParameters_thenBuilderBuildAnyParameterUpdated() {
    // Arrange
    Builder builder = new Builder();
    ArrayList<Value> updatedParameters = new ArrayList<>();

    // Act
    Builder actualSetUpdatedParametersResult = builder.setUpdatedParameters(updatedParameters);

    // Assert
    MethodResult buildResult = builder.build();
    assertTrue(buildResult.isAnyParameterUpdated());
    assertSame(updatedParameters, buildResult.getUpdatedParameters());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult$Builder proguard.evaluation.MethodResult$Builder.setUpdatedParameters(java.util.List)"
  })
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult$Builder proguard.evaluation.MethodResult$Builder.setUpdatedParameters(java.util.List)"
  })
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
   * Test {@link MethodResult#invalidResult()}.
   *
   * <p>Method under test: {@link MethodResult#invalidResult()}
   */
  @Test
  @DisplayName("Test invalidResult()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.MethodResult.invalidResult()"
  })
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.MethodResult.isResultValid()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.MethodResult.isResultValid()"})
  void testIsResultValid_thenReturnTrue() {
    // Arrange
    Builder setUpdatedInstanceResult =
        (new Builder()).setUpdatedInstance(BasicValueFactory.REFERENCE_VALUE);
    MethodResult buildResult =
        setUpdatedInstanceResult.setUpdatedParameters(new ArrayList<>()).build();

    // Act and Assert
    assertTrue(buildResult.isResultValid());
  }

  /**
   * Test {@link MethodResult#isReturnValuePresent()}.
   *
   * <p>Method under test: {@link MethodResult#isReturnValuePresent()}
   */
  @Test
  @DisplayName("Test isReturnValuePresent()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.MethodResult.isReturnValuePresent()"})
  void testIsReturnValuePresent() {
    // Arrange
    Builder setUpdatedInstanceResult =
        (new Builder()).setUpdatedInstance(BasicValueFactory.REFERENCE_VALUE);
    MethodResult buildResult =
        setUpdatedInstanceResult.setUpdatedParameters(new ArrayList<>()).build();

    // Act and Assert
    assertFalse(buildResult.isReturnValuePresent());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.MethodResult.isInstanceUpdated()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.MethodResult.isInstanceUpdated()"})
  void testIsInstanceUpdated_thenReturnTrue() {
    // Arrange
    Builder setUpdatedInstanceResult =
        (new Builder()).setUpdatedInstance(BasicValueFactory.REFERENCE_VALUE);
    MethodResult buildResult =
        setUpdatedInstanceResult.setUpdatedParameters(new ArrayList<>()).build();

    // Act and Assert
    assertTrue(buildResult.isInstanceUpdated());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.MethodResult.isAnyParameterUpdated()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean proguard.evaluation.MethodResult.isAnyParameterUpdated()"})
  void testIsAnyParameterUpdated_thenReturnTrue() {
    // Arrange
    Builder setUpdatedInstanceResult =
        (new Builder()).setUpdatedInstance(BasicValueFactory.REFERENCE_VALUE);
    MethodResult buildResult =
        setUpdatedInstanceResult.setUpdatedParameters(new ArrayList<>()).build();

    // Act and Assert
    assertTrue(buildResult.isAnyParameterUpdated());
  }

  /**
   * Test {@link MethodResult#getReturnValue()}.
   *
   * <p>Method under test: {@link MethodResult#getReturnValue()}
   */
  @Test
  @DisplayName("Test getReturnValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.Value proguard.evaluation.MethodResult.getReturnValue()"
  })
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.MethodResult.getUpdatedInstance()"
  })
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.ReferenceValue proguard.evaluation.MethodResult.getUpdatedInstance()"
  })
  void testGetUpdatedInstance_thenReturnUnknownReferenceValue() {
    // Arrange
    Builder setUpdatedInstanceResult =
        (new Builder()).setUpdatedInstance(BasicValueFactory.REFERENCE_VALUE);
    MethodResult buildResult =
        setUpdatedInstanceResult.setUpdatedParameters(new ArrayList<>()).build();

    // Act
    ReferenceValue actualUpdatedInstance = buildResult.getUpdatedInstance();

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List proguard.evaluation.MethodResult.getUpdatedParameters()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List proguard.evaluation.MethodResult.getUpdatedParameters()"})
  void testGetUpdatedParameters_thenReturnEmpty() {
    // Arrange
    Builder setUpdatedInstanceResult =
        (new Builder()).setUpdatedInstance(BasicValueFactory.REFERENCE_VALUE);
    MethodResult buildResult =
        setUpdatedInstanceResult.setUpdatedParameters(new ArrayList<>()).build();

    // Act and Assert
    assertTrue(buildResult.getUpdatedParameters().isEmpty());
  }
}
