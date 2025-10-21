package proguard.evaluation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.evaluation.MethodResult.Builder;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.DoubleValue;
import proguard.evaluation.value.ReferenceValue;
import proguard.evaluation.value.UnknownReferenceValue;
import proguard.evaluation.value.Value;
import proguard.evaluation.value.object.AnalyzedObject;

public class MethodResultDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Builder.<init>()", "MethodResult Builder.build()"})
  public void testBuilderBuild() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Builder Builder.setReturnValue(Value)"})
  public void testBuilderSetReturnValue() {
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
   * <ul>
   *   <li>Given {@link Builder} (default constructor).
   *   <li>Then {@link Builder} (default constructor) build InstanceUpdated.
   * </ul>
   *
   * <p>Method under test: {@link Builder#setUpdatedInstance(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Builder Builder.setUpdatedInstance(ReferenceValue)"})
  public void testBuilderSetUpdatedInstance_givenBuilder_thenBuilderBuildInstanceUpdated() {
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
   * Test Builder {@link Builder#setUpdatedInstance(ReferenceValue)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#setUpdatedInstance(ReferenceValue)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Builder Builder.setUpdatedInstance(ReferenceValue)"})
  public void testBuilderSetUpdatedInstance_thenThrowIllegalStateException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Builder Builder.setUpdatedParameters(List)"})
  public void testBuilderSetUpdatedParameters_thenBuilderBuildAnyParameterUpdated() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Builder Builder.setUpdatedParameters(List)"})
  public void testBuilderSetUpdatedParameters_thenReturnBuildUpdatedParametersIsArrayList() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Builder Builder.setUpdatedParameters(List)"})
  public void testBuilderSetUpdatedParameters_thenReturnBuildUpdatedParametersIsArrayList2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodResult MethodResult.invalidResult()"})
  public void testInvalidResult() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MethodResult.isResultValid()"})
  public void testIsResultValid_givenInvalidResult_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MethodResult.isResultValid()"})
  public void testIsResultValid_thenReturnTrue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MethodResult.isReturnValuePresent()"})
  public void testIsReturnValuePresent() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MethodResult.isInstanceUpdated()"})
  public void testIsInstanceUpdated_givenInvalidResult_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MethodResult.isInstanceUpdated()"})
  public void testIsInstanceUpdated_thenReturnTrue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MethodResult.isAnyParameterUpdated()"})
  public void testIsAnyParameterUpdated_givenInvalidResult_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MethodResult.isAnyParameterUpdated()"})
  public void testIsAnyParameterUpdated_thenReturnTrue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Value MethodResult.getReturnValue()"})
  public void testGetReturnValue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MethodResult.getUpdatedInstance()"})
  public void testGetUpdatedInstance_givenInvalidResult_thenThrowIllegalStateException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ReferenceValue MethodResult.getUpdatedInstance()"})
  public void testGetUpdatedInstance_thenReturnUnknownReferenceValue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MethodResult.getUpdatedParameters()"})
  public void testGetUpdatedParameters_givenInvalidResult_thenThrowIllegalStateException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List MethodResult.getUpdatedParameters()"})
  public void testGetUpdatedParameters_thenReturnEmpty() {
    // Arrange
    Builder setUpdatedInstanceResult =
        (new Builder()).setUpdatedInstance(BasicValueFactory.REFERENCE_VALUE);
    MethodResult buildResult =
        setUpdatedInstanceResult.setUpdatedParameters(new ArrayList<>()).build();

    // Act and Assert
    assertTrue(buildResult.getUpdatedParameters().isEmpty());
  }
}
