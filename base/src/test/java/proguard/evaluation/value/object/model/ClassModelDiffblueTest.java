package proguard.evaluation.value.object.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.evaluation.MethodResult;
import proguard.evaluation.ValueCalculator;
import proguard.evaluation.executor.MethodExecutionInfo;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.Value;
import proguard.evaluation.value.object.model.reflective.ModelHelper;

public class ClassModelDiffblueTest {
  /**
   * Method under test:
   * {@link ClassModel#init(MethodExecutionInfo, ValueCalculator)}
   */
  @Test
  public void testInit() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ClassModel(new LibraryClass())).init(null, null));
  }

  /**
   * Method under test:
   * {@link ClassModel#getName(ModelHelper.MethodExecutionContext)}
   */
  @Test
  public void testGetName() {
    // Arrange
    ClassModel classModel = new ClassModel(null);

    // Act
    MethodResult actualName = classModel.getName(new ModelHelper.MethodExecutionContext(null, null));

    // Assert
    assertFalse(actualName.isAnyParameterUpdated());
    assertFalse(actualName.isInstanceUpdated());
    assertFalse(actualName.isResultValid());
    assertFalse(actualName.isReturnValuePresent());
  }

  /**
   * Method under test:
   * {@link ClassModel#getSimpleName(ModelHelper.MethodExecutionContext)}
   */
  @Test
  public void testGetSimpleName() {
    // Arrange
    ClassModel classModel = new ClassModel(null);

    // Act
    MethodResult actualSimpleName = classModel.getSimpleName(new ModelHelper.MethodExecutionContext(null, null));

    // Assert
    assertFalse(actualSimpleName.isAnyParameterUpdated());
    assertFalse(actualSimpleName.isInstanceUpdated());
    assertFalse(actualSimpleName.isResultValid());
    assertFalse(actualSimpleName.isReturnValuePresent());
  }

  /**
   * Method under test:
   * {@link ClassModel#getCanonicalName(ModelHelper.MethodExecutionContext)}
   */
  @Test
  public void testGetCanonicalName() {
    // Arrange
    ClassModel classModel = new ClassModel(null);

    // Act
    MethodResult actualCanonicalName = classModel.getCanonicalName(new ModelHelper.MethodExecutionContext(null, null));

    // Assert
    assertFalse(actualCanonicalName.isAnyParameterUpdated());
    assertFalse(actualCanonicalName.isInstanceUpdated());
    assertFalse(actualCanonicalName.isResultValid());
    assertFalse(actualCanonicalName.isReturnValuePresent());
  }

  /**
   * Method under test:
   * {@link ClassModel#getPackageName(ModelHelper.MethodExecutionContext)}
   */
  @Test
  public void testGetPackageName() {
    // Arrange
    ClassModel classModel = new ClassModel(null);

    // Act
    MethodResult actualPackageName = classModel.getPackageName(new ModelHelper.MethodExecutionContext(null, null));

    // Assert
    assertFalse(actualPackageName.isAnyParameterUpdated());
    assertFalse(actualPackageName.isInstanceUpdated());
    assertFalse(actualPackageName.isResultValid());
    assertFalse(actualPackageName.isReturnValuePresent());
  }

  /**
   * Method under test:
   * {@link ClassModel#getTypeName(ModelHelper.MethodExecutionContext)}
   */
  @Test
  public void testGetTypeName() {
    // Arrange
    ClassModel classModel = new ClassModel(null);

    // Act
    MethodResult actualTypeName = classModel.getTypeName(new ModelHelper.MethodExecutionContext(null, null));

    // Assert
    assertFalse(actualTypeName.isAnyParameterUpdated());
    assertFalse(actualTypeName.isInstanceUpdated());
    assertFalse(actualTypeName.isResultValid());
    assertFalse(actualTypeName.isReturnValuePresent());
  }

  /**
   * Method under test:
   * {@link ClassModel#forName(ModelHelper.MethodExecutionContext, Value)}
   */
  @Test
  public void testForName() {
    // Arrange
    ClassModel classModel = new ClassModel(new LibraryClass());

    // Act
    MethodResult actualForNameResult = classModel.forName(new ModelHelper.MethodExecutionContext(null, null),
        BasicValueFactory.DOUBLE_VALUE);

    // Assert
    assertFalse(actualForNameResult.isAnyParameterUpdated());
    assertFalse(actualForNameResult.isInstanceUpdated());
    assertFalse(actualForNameResult.isResultValid());
    assertFalse(actualForNameResult.isReturnValuePresent());
  }

  /**
   * Method under test:
   * {@link ClassModel#forName(ModelHelper.MethodExecutionContext, Value)}
   */
  @Test
  public void testForName2() {
    // Arrange
    ClassModel classModel = new ClassModel(new LibraryClass());

    // Act
    MethodResult actualForNameResult = classModel.forName(new ModelHelper.MethodExecutionContext(null, null),
        BasicValueFactory.REFERENCE_VALUE);

    // Assert
    assertFalse(actualForNameResult.isAnyParameterUpdated());
    assertFalse(actualForNameResult.isInstanceUpdated());
    assertFalse(actualForNameResult.isResultValid());
    assertFalse(actualForNameResult.isReturnValuePresent());
  }

  /**
   * Method under test:
   * {@link ClassModel#forName(ModelHelper.MethodExecutionContext, Value, Value, Value)}
   */
  @Test
  public void testForName3() {
    // Arrange
    ClassModel classModel = new ClassModel(new LibraryClass());

    // Act
    MethodResult actualForNameResult = classModel.forName(new ModelHelper.MethodExecutionContext(null, null),
        BasicValueFactory.DOUBLE_VALUE, BasicValueFactory.DOUBLE_VALUE, BasicValueFactory.DOUBLE_VALUE);

    // Assert
    assertFalse(actualForNameResult.isAnyParameterUpdated());
    assertFalse(actualForNameResult.isInstanceUpdated());
    assertFalse(actualForNameResult.isResultValid());
    assertFalse(actualForNameResult.isReturnValuePresent());
  }

  /**
   * Method under test:
   * {@link ClassModel#forName(ModelHelper.MethodExecutionContext, Value, Value, Value)}
   */
  @Test
  public void testForName4() {
    // Arrange
    ClassModel classModel = new ClassModel(new LibraryClass());

    // Act
    MethodResult actualForNameResult = classModel.forName(new ModelHelper.MethodExecutionContext(null, null),
        BasicValueFactory.REFERENCE_VALUE, BasicValueFactory.DOUBLE_VALUE, BasicValueFactory.DOUBLE_VALUE);

    // Assert
    assertFalse(actualForNameResult.isAnyParameterUpdated());
    assertFalse(actualForNameResult.isInstanceUpdated());
    assertFalse(actualForNameResult.isResultValid());
    assertFalse(actualForNameResult.isReturnValuePresent());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ClassModel#equals(Object)}
   *   <li>{@link ClassModel#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ClassModel classModel = new ClassModel(null);
    ClassModel classModel2 = new ClassModel(null);

    // Act and Assert
    assertEquals(classModel, classModel2);
    int expectedHashCodeResult = classModel.hashCode();
    assertEquals(expectedHashCodeResult, classModel2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ClassModel#equals(Object)}
   *   <li>{@link ClassModel#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ClassModel classModel = new ClassModel(new LibraryClass());

    // Act and Assert
    assertEquals(classModel, classModel);
    int expectedHashCodeResult = classModel.hashCode();
    assertEquals(expectedHashCodeResult, classModel.hashCode());
  }

  /**
   * Method under test: {@link ClassModel#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ClassModel classModel = new ClassModel(new LibraryClass());

    // Act and Assert
    assertNotEquals(classModel, new ClassModel(new LibraryClass()));
  }

  /**
   * Method under test: {@link ClassModel#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ClassModel(new LibraryClass()), null);
  }

  /**
   * Method under test: {@link ClassModel#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ClassModel(new LibraryClass()), "Different type to ClassModel");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ClassModel#ClassModel(Clazz)}
   *   <li>{@link ClassModel#toString()}
   *   <li>{@link ClassModel#getClazz()}
   *   <li>{@link ClassModel#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    LibraryClass clazz = new LibraryClass();

    // Act
    ClassModel actualClassModel = new ClassModel(clazz);
    String actualToStringResult = actualClassModel.toString();
    Clazz actualClazz = actualClassModel.getClazz();

    // Assert
    assertEquals("ClassModel{null}", actualToStringResult);
    assertEquals("Ljava/lang/Class;", actualClassModel.getType());
    assertSame(clazz, actualClazz);
  }
}
