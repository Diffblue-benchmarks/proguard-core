package proguard.evaluation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.DoubleValue;
import proguard.evaluation.value.ReferenceValue;
import proguard.evaluation.value.UnknownReferenceValue;
import proguard.evaluation.value.Value;

public class MethodResultDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MethodResult.Builder#build()}
   *   <li>default or parameterless constructor of {@link MethodResult.Builder}
   * </ul>
   */
  @Test
  public void testBuilderBuild() {
    // Arrange
    MethodResult.Builder setUpdatedInstanceResult = (new MethodResult.Builder())
        .setUpdatedInstance(BasicValueFactory.REFERENCE_VALUE);
    ArrayList<Value> updatedParameters = new ArrayList<>();

    // Act
    MethodResult actualBuildResult = setUpdatedInstanceResult.setUpdatedParameters(updatedParameters).build();

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
   * Method under test: {@link MethodResult.Builder#setReturnValue(Value)}
   */
  @Test
  public void testBuilderSetReturnValue() {
    // Arrange
    MethodResult.Builder builder = new MethodResult.Builder();
    DoubleValue returnValue = BasicValueFactory.DOUBLE_VALUE;

    // Act
    MethodResult.Builder actualSetReturnValueResult = builder.setReturnValue(returnValue);

    // Assert
    MethodResult buildResult = builder.build();
    assertTrue(buildResult.isReturnValuePresent());
    assertSame(builder, actualSetReturnValueResult);
    assertSame(returnValue, buildResult.getReturnValue());
  }

  /**
   * Method under test:
   * {@link MethodResult.Builder#setUpdatedInstance(ReferenceValue)}
   */
  @Test
  public void testBuilderSetUpdatedInstance() {
    // Arrange
    MethodResult.Builder builder = new MethodResult.Builder();
    ReferenceValue updatedInstance = BasicValueFactory.REFERENCE_VALUE;

    // Act
    MethodResult.Builder actualSetUpdatedInstanceResult = builder.setUpdatedInstance(updatedInstance);

    // Assert
    MethodResult buildResult = builder.build();
    assertTrue(buildResult.isInstanceUpdated());
    assertSame(builder, actualSetUpdatedInstanceResult);
    assertSame(updatedInstance, buildResult.getUpdatedInstance());
  }

  /**
   * Method under test: {@link MethodResult.Builder#setUpdatedParameters(List)}
   */
  @Test
  public void testBuilderSetUpdatedParameters() {
    // Arrange
    MethodResult.Builder builder = new MethodResult.Builder();
    ArrayList<Value> updatedParameters = new ArrayList<>();

    // Act
    MethodResult.Builder actualSetUpdatedParametersResult = builder.setUpdatedParameters(updatedParameters);

    // Assert
    MethodResult buildResult = builder.build();
    assertTrue(buildResult.isAnyParameterUpdated());
    assertSame(updatedParameters, buildResult.getUpdatedParameters());
    assertSame(builder, actualSetUpdatedParametersResult);
  }

  /**
   * Method under test: {@link MethodResult.Builder#setUpdatedParameters(List)}
   */
  @Test
  public void testBuilderSetUpdatedParameters2() {
    // Arrange
    MethodResult.Builder builder = new MethodResult.Builder();

    ArrayList<Value> updatedParameters = new ArrayList<>();
    updatedParameters.add(BasicValueFactory.DOUBLE_VALUE);

    // Act
    MethodResult.Builder actualSetUpdatedParametersResult = builder.setUpdatedParameters(updatedParameters);

    // Assert
    MethodResult buildResult = builder.build();
    assertTrue(buildResult.isAnyParameterUpdated());
    assertSame(updatedParameters, buildResult.getUpdatedParameters());
    assertSame(builder, actualSetUpdatedParametersResult);
  }

  /**
   * Method under test: {@link MethodResult.Builder#setUpdatedParameters(List)}
   */
  @Test
  public void testBuilderSetUpdatedParameters3() {
    // Arrange
    MethodResult.Builder builder = new MethodResult.Builder();

    ArrayList<Value> updatedParameters = new ArrayList<>();
    updatedParameters.add(BasicValueFactory.DOUBLE_VALUE);
    updatedParameters.add(BasicValueFactory.DOUBLE_VALUE);

    // Act
    MethodResult.Builder actualSetUpdatedParametersResult = builder.setUpdatedParameters(updatedParameters);

    // Assert
    MethodResult buildResult = builder.build();
    assertTrue(buildResult.isAnyParameterUpdated());
    assertSame(updatedParameters, buildResult.getUpdatedParameters());
    assertSame(builder, actualSetUpdatedParametersResult);
  }

  /**
   * Method under test: {@link MethodResult#invalidResult()}
   */
  @Test
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
   * Method under test: {@link MethodResult#isResultValid()}
   */
  @Test
  public void testIsResultValid() {
    // Arrange, Act and Assert
    assertFalse(MethodResult.invalidResult().isResultValid());
  }

  /**
   * Method under test: {@link MethodResult#isReturnValuePresent()}
   */
  @Test
  public void testIsReturnValuePresent() {
    // Arrange, Act and Assert
    assertFalse(MethodResult.invalidResult().isReturnValuePresent());
  }

  /**
   * Method under test: {@link MethodResult#isInstanceUpdated()}
   */
  @Test
  public void testIsInstanceUpdated() {
    // Arrange, Act and Assert
    assertFalse(MethodResult.invalidResult().isInstanceUpdated());
  }

  /**
   * Method under test: {@link MethodResult#isAnyParameterUpdated()}
   */
  @Test
  public void testIsAnyParameterUpdated() {
    // Arrange, Act and Assert
    assertFalse(MethodResult.invalidResult().isAnyParameterUpdated());
  }

  /**
   * Method under test: {@link MethodResult#getReturnValue()}
   */
  @Test
  public void testGetReturnValue() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> MethodResult.invalidResult().getReturnValue());
  }

  /**
   * Method under test: {@link MethodResult#getUpdatedInstance()}
   */
  @Test
  public void testGetUpdatedInstance() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> MethodResult.invalidResult().getUpdatedInstance());
  }

  /**
   * Method under test: {@link MethodResult#getUpdatedParameters()}
   */
  @Test
  public void testGetUpdatedParameters() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> MethodResult.invalidResult().getUpdatedParameters());
  }
}
