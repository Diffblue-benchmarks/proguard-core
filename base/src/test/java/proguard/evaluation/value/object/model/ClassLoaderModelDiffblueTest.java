package proguard.evaluation.value.object.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import org.junit.Test;
import proguard.evaluation.MethodResult;
import proguard.evaluation.ValueCalculator;
import proguard.evaluation.executor.MethodExecutionInfo;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.Value;
import proguard.evaluation.value.object.model.reflective.ModelHelper;

public class ClassLoaderModelDiffblueTest {
  /**
   * Method under test:
   * {@link ClassLoaderModel#init(MethodExecutionInfo, ValueCalculator)}
   */
  @Test
  public void testInit() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ClassLoaderModel()).init(null, null));
  }

  /**
   * Method under test:
   * {@link ClassLoaderModel#loadClass(ModelHelper.MethodExecutionContext, Value)}
   */
  @Test
  public void testLoadClass() {
    // Arrange
    ClassLoaderModel classLoaderModel = new ClassLoaderModel();

    // Act
    MethodResult actualLoadClassResult = classLoaderModel.loadClass(new ModelHelper.MethodExecutionContext(null, null),
        BasicValueFactory.DOUBLE_VALUE);

    // Assert
    assertFalse(actualLoadClassResult.isAnyParameterUpdated());
    assertFalse(actualLoadClassResult.isInstanceUpdated());
    assertFalse(actualLoadClassResult.isResultValid());
    assertFalse(actualLoadClassResult.isReturnValuePresent());
  }

  /**
   * Method under test:
   * {@link ClassLoaderModel#loadClass(ModelHelper.MethodExecutionContext, Value)}
   */
  @Test
  public void testLoadClass2() {
    // Arrange
    ClassLoaderModel classLoaderModel = new ClassLoaderModel();

    // Act
    MethodResult actualLoadClassResult = classLoaderModel.loadClass(new ModelHelper.MethodExecutionContext(null, null),
        BasicValueFactory.REFERENCE_VALUE);

    // Assert
    assertFalse(actualLoadClassResult.isAnyParameterUpdated());
    assertFalse(actualLoadClassResult.isInstanceUpdated());
    assertFalse(actualLoadClassResult.isResultValid());
    assertFalse(actualLoadClassResult.isReturnValuePresent());
  }

  /**
   * Method under test:
   * {@link ClassLoaderModel#loadClass(ModelHelper.MethodExecutionContext, Value, Value)}
   */
  @Test
  public void testLoadClass3() {
    // Arrange
    ClassLoaderModel classLoaderModel = new ClassLoaderModel();

    // Act
    MethodResult actualLoadClassResult = classLoaderModel.loadClass(new ModelHelper.MethodExecutionContext(null, null),
        BasicValueFactory.DOUBLE_VALUE, BasicValueFactory.DOUBLE_VALUE);

    // Assert
    assertFalse(actualLoadClassResult.isAnyParameterUpdated());
    assertFalse(actualLoadClassResult.isInstanceUpdated());
    assertFalse(actualLoadClassResult.isResultValid());
    assertFalse(actualLoadClassResult.isReturnValuePresent());
  }

  /**
   * Method under test:
   * {@link ClassLoaderModel#loadClass(ModelHelper.MethodExecutionContext, Value, Value)}
   */
  @Test
  public void testLoadClass4() {
    // Arrange
    ClassLoaderModel classLoaderModel = new ClassLoaderModel();

    // Act
    MethodResult actualLoadClassResult = classLoaderModel.loadClass(new ModelHelper.MethodExecutionContext(null, null),
        BasicValueFactory.REFERENCE_VALUE, BasicValueFactory.DOUBLE_VALUE);

    // Assert
    assertFalse(actualLoadClassResult.isAnyParameterUpdated());
    assertFalse(actualLoadClassResult.isInstanceUpdated());
    assertFalse(actualLoadClassResult.isResultValid());
    assertFalse(actualLoadClassResult.isReturnValuePresent());
  }

  /**
   * Method under test:
   * {@link ClassLoaderModel#findLoadedClass(ModelHelper.MethodExecutionContext, Value)}
   */
  @Test
  public void testFindLoadedClass() {
    // Arrange
    ClassLoaderModel classLoaderModel = new ClassLoaderModel();

    // Act
    MethodResult actualFindLoadedClassResult = classLoaderModel
        .findLoadedClass(new ModelHelper.MethodExecutionContext(null, null), BasicValueFactory.DOUBLE_VALUE);

    // Assert
    assertFalse(actualFindLoadedClassResult.isAnyParameterUpdated());
    assertFalse(actualFindLoadedClassResult.isInstanceUpdated());
    assertFalse(actualFindLoadedClassResult.isResultValid());
    assertFalse(actualFindLoadedClassResult.isReturnValuePresent());
  }

  /**
   * Method under test:
   * {@link ClassLoaderModel#findLoadedClass(ModelHelper.MethodExecutionContext, Value)}
   */
  @Test
  public void testFindLoadedClass2() {
    // Arrange and Act
    MethodResult actualFindLoadedClassResult = (new ClassLoaderModel()).findLoadedClass(null,
        BasicValueFactory.DOUBLE_VALUE);

    // Assert
    assertFalse(actualFindLoadedClassResult.isAnyParameterUpdated());
    assertFalse(actualFindLoadedClassResult.isInstanceUpdated());
    assertFalse(actualFindLoadedClassResult.isResultValid());
    assertFalse(actualFindLoadedClassResult.isReturnValuePresent());
  }

  /**
   * Method under test:
   * {@link ClassLoaderModel#findLoadedClass(ModelHelper.MethodExecutionContext, Value)}
   */
  @Test
  public void testFindLoadedClass3() {
    // Arrange
    ClassLoaderModel classLoaderModel = new ClassLoaderModel();

    // Act
    MethodResult actualFindLoadedClassResult = classLoaderModel
        .findLoadedClass(new ModelHelper.MethodExecutionContext(null, null), BasicValueFactory.REFERENCE_VALUE);

    // Assert
    assertFalse(actualFindLoadedClassResult.isAnyParameterUpdated());
    assertFalse(actualFindLoadedClassResult.isInstanceUpdated());
    assertFalse(actualFindLoadedClassResult.isResultValid());
    assertFalse(actualFindLoadedClassResult.isReturnValuePresent());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ClassLoaderModel}
   *   <li>{@link ClassLoaderModel#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Ljava/lang/ClassLoader;", (new ClassLoaderModel()).getType());
  }
}
