package proguard.evaluation.value.object.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.evaluation.MethodResult;
import proguard.evaluation.ValueCalculator;
import proguard.evaluation.executor.MethodExecutionInfo;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.Value;
import proguard.evaluation.value.object.model.reflective.ModelHelper;
import proguard.evaluation.value.object.model.reflective.ModelHelper.MethodExecutionContext;

class ClassModelDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ClassModel#ClassModel(Clazz)}
   *   <li>{@link ClassModel#toString()}
   *   <li>{@link ClassModel#getClazz()}
   *   <li>{@link ClassModel#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.evaluation.value.object.model.ClassModel.<init>(proguard.classfile.Clazz)",
    "proguard.classfile.Clazz proguard.evaluation.value.object.model.ClassModel.getClazz()",
    "java.lang.String proguard.evaluation.value.object.model.ClassModel.getType()",
    "java.lang.String proguard.evaluation.value.object.model.ClassModel.toString()"
  })
  void testGettersAndSetters() {
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

  /**
   * Test {@link ClassModel#init(MethodExecutionInfo, ValueCalculator)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassModel#init(MethodExecutionInfo, ValueCalculator)}
   */
  @Test
  @DisplayName(
      "Test init(MethodExecutionInfo, ValueCalculator); when 'null'; then throw UnsupportedOperationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.value.object.model.ClassModel.init(proguard.evaluation.executor.MethodExecutionInfo, proguard.evaluation.ValueCalculator)"
  })
  void testInit_whenNull_thenThrowUnsupportedOperationException() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> (new ClassModel(new LibraryClass())).init(null, mock(ValueCalculator.class)));
  }

  /**
   * Test {@link ClassModel#getName(MethodExecutionContext)}.
   *
   * <ul>
   *   <li>Given {@link ClassModel#ClassModel(Clazz)} with clazz is {@code null}.
   *   <li>Then return not AnyParameterUpdated.
   * </ul>
   *
   * <p>Method under test: {@link ClassModel#getName(ModelHelper.MethodExecutionContext)}
   */
  @Test
  @DisplayName(
      "Test getName(MethodExecutionContext); given ClassModel(Clazz) with clazz is 'null'; then return not AnyParameterUpdated")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.value.object.model.ClassModel.getName(proguard.evaluation.value.object.model.reflective.ModelHelper$MethodExecutionContext)"
  })
  void testGetName_givenClassModelWithClazzIsNull_thenReturnNotAnyParameterUpdated() {
    // Arrange
    ClassModel classModel = new ClassModel(null);

    // Act
    MethodResult actualName =
        classModel.getName(new MethodExecutionContext(null, mock(ValueCalculator.class)));

    // Assert
    assertFalse(actualName.isAnyParameterUpdated());
    assertFalse(actualName.isInstanceUpdated());
    assertFalse(actualName.isResultValid());
    assertFalse(actualName.isReturnValuePresent());
  }

  /**
   * Test {@link ClassModel#getSimpleName(MethodExecutionContext)}.
   *
   * <ul>
   *   <li>Then return not AnyParameterUpdated.
   * </ul>
   *
   * <p>Method under test: {@link ClassModel#getSimpleName(ModelHelper.MethodExecutionContext)}
   */
  @Test
  @DisplayName("Test getSimpleName(MethodExecutionContext); then return not AnyParameterUpdated")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.value.object.model.ClassModel.getSimpleName(proguard.evaluation.value.object.model.reflective.ModelHelper$MethodExecutionContext)"
  })
  void testGetSimpleName_thenReturnNotAnyParameterUpdated() {
    // Arrange
    ClassModel classModel = new ClassModel(null);

    // Act
    MethodResult actualSimpleName =
        classModel.getSimpleName(new MethodExecutionContext(null, mock(ValueCalculator.class)));

    // Assert
    assertFalse(actualSimpleName.isAnyParameterUpdated());
    assertFalse(actualSimpleName.isInstanceUpdated());
    assertFalse(actualSimpleName.isResultValid());
    assertFalse(actualSimpleName.isReturnValuePresent());
  }

  /**
   * Test {@link ClassModel#getCanonicalName(MethodExecutionContext)}.
   *
   * <ul>
   *   <li>Then return not AnyParameterUpdated.
   * </ul>
   *
   * <p>Method under test: {@link ClassModel#getCanonicalName(ModelHelper.MethodExecutionContext)}
   */
  @Test
  @DisplayName("Test getCanonicalName(MethodExecutionContext); then return not AnyParameterUpdated")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.value.object.model.ClassModel.getCanonicalName(proguard.evaluation.value.object.model.reflective.ModelHelper$MethodExecutionContext)"
  })
  void testGetCanonicalName_thenReturnNotAnyParameterUpdated() {
    // Arrange
    ClassModel classModel = new ClassModel(null);

    // Act
    MethodResult actualCanonicalName =
        classModel.getCanonicalName(new MethodExecutionContext(null, mock(ValueCalculator.class)));

    // Assert
    assertFalse(actualCanonicalName.isAnyParameterUpdated());
    assertFalse(actualCanonicalName.isInstanceUpdated());
    assertFalse(actualCanonicalName.isResultValid());
    assertFalse(actualCanonicalName.isReturnValuePresent());
  }

  /**
   * Test {@link ClassModel#getPackageName(MethodExecutionContext)}.
   *
   * <ul>
   *   <li>Then return not AnyParameterUpdated.
   * </ul>
   *
   * <p>Method under test: {@link ClassModel#getPackageName(ModelHelper.MethodExecutionContext)}
   */
  @Test
  @DisplayName("Test getPackageName(MethodExecutionContext); then return not AnyParameterUpdated")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.value.object.model.ClassModel.getPackageName(proguard.evaluation.value.object.model.reflective.ModelHelper$MethodExecutionContext)"
  })
  void testGetPackageName_thenReturnNotAnyParameterUpdated() {
    // Arrange
    ClassModel classModel = new ClassModel(null);

    // Act
    MethodResult actualPackageName =
        classModel.getPackageName(new MethodExecutionContext(null, mock(ValueCalculator.class)));

    // Assert
    assertFalse(actualPackageName.isAnyParameterUpdated());
    assertFalse(actualPackageName.isInstanceUpdated());
    assertFalse(actualPackageName.isResultValid());
    assertFalse(actualPackageName.isReturnValuePresent());
  }

  /**
   * Test {@link ClassModel#getTypeName(MethodExecutionContext)}.
   *
   * <ul>
   *   <li>Given {@link ClassModel#ClassModel(Clazz)} with clazz is {@code null}.
   *   <li>Then return not AnyParameterUpdated.
   * </ul>
   *
   * <p>Method under test: {@link ClassModel#getTypeName(ModelHelper.MethodExecutionContext)}
   */
  @Test
  @DisplayName(
      "Test getTypeName(MethodExecutionContext); given ClassModel(Clazz) with clazz is 'null'; then return not AnyParameterUpdated")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.value.object.model.ClassModel.getTypeName(proguard.evaluation.value.object.model.reflective.ModelHelper$MethodExecutionContext)"
  })
  void testGetTypeName_givenClassModelWithClazzIsNull_thenReturnNotAnyParameterUpdated() {
    // Arrange
    ClassModel classModel = new ClassModel(null);

    // Act
    MethodResult actualTypeName =
        classModel.getTypeName(new MethodExecutionContext(null, mock(ValueCalculator.class)));

    // Assert
    assertFalse(actualTypeName.isAnyParameterUpdated());
    assertFalse(actualTypeName.isInstanceUpdated());
    assertFalse(actualTypeName.isResultValid());
    assertFalse(actualTypeName.isReturnValuePresent());
  }

  /**
   * Test {@link ClassModel#forName(MethodExecutionContext, Value, Value, Value)} with {@code
   * context}, {@code classNameValue}, {@code initializeValue}, {@code classLoaderValue}.
   *
   * <p>Method under test: {@link ClassModel#forName(ModelHelper.MethodExecutionContext, Value,
   * Value, Value)}
   */
  @Test
  @DisplayName(
      "Test forName(MethodExecutionContext, Value, Value, Value) with 'context', 'classNameValue', 'initializeValue', 'classLoaderValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.value.object.model.ClassModel.forName(proguard.evaluation.value.object.model.reflective.ModelHelper$MethodExecutionContext, proguard.evaluation.value.Value, proguard.evaluation.value.Value, proguard.evaluation.value.Value)"
  })
  void testForNameWithContextClassNameValueInitializeValueClassLoaderValue() {
    // Arrange
    ClassModel classModel = new ClassModel(new LibraryClass());

    // Act
    MethodResult actualForNameResult =
        classModel.forName(
            new MethodExecutionContext(null, mock(ValueCalculator.class)),
            BasicValueFactory.DOUBLE_VALUE,
            BasicValueFactory.DOUBLE_VALUE,
            BasicValueFactory.DOUBLE_VALUE);

    // Assert
    assertFalse(actualForNameResult.isAnyParameterUpdated());
    assertFalse(actualForNameResult.isInstanceUpdated());
    assertFalse(actualForNameResult.isResultValid());
    assertFalse(actualForNameResult.isReturnValuePresent());
  }

  /**
   * Test {@link ClassModel#forName(MethodExecutionContext, Value, Value, Value)} with {@code
   * context}, {@code classNameValue}, {@code initializeValue}, {@code classLoaderValue}.
   *
   * <p>Method under test: {@link ClassModel#forName(ModelHelper.MethodExecutionContext, Value,
   * Value, Value)}
   */
  @Test
  @DisplayName(
      "Test forName(MethodExecutionContext, Value, Value, Value) with 'context', 'classNameValue', 'initializeValue', 'classLoaderValue'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.value.object.model.ClassModel.forName(proguard.evaluation.value.object.model.reflective.ModelHelper$MethodExecutionContext, proguard.evaluation.value.Value, proguard.evaluation.value.Value, proguard.evaluation.value.Value)"
  })
  void testForNameWithContextClassNameValueInitializeValueClassLoaderValue2() {
    // Arrange
    ClassModel classModel = new ClassModel(new LibraryClass());

    // Act
    MethodResult actualForNameResult =
        classModel.forName(
            new MethodExecutionContext(null, mock(ValueCalculator.class)),
            BasicValueFactory.REFERENCE_VALUE,
            BasicValueFactory.DOUBLE_VALUE,
            BasicValueFactory.DOUBLE_VALUE);

    // Assert
    assertFalse(actualForNameResult.isAnyParameterUpdated());
    assertFalse(actualForNameResult.isInstanceUpdated());
    assertFalse(actualForNameResult.isResultValid());
    assertFalse(actualForNameResult.isReturnValuePresent());
  }

  /**
   * Test {@link ClassModel#forName(MethodExecutionContext, Value)} with {@code context}, {@code
   * classNameValue}.
   *
   * <ul>
   *   <li>Then return not AnyParameterUpdated.
   * </ul>
   *
   * <p>Method under test: {@link ClassModel#forName(ModelHelper.MethodExecutionContext, Value)}
   */
  @Test
  @DisplayName(
      "Test forName(MethodExecutionContext, Value) with 'context', 'classNameValue'; then return not AnyParameterUpdated")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.value.object.model.ClassModel.forName(proguard.evaluation.value.object.model.reflective.ModelHelper$MethodExecutionContext, proguard.evaluation.value.Value)"
  })
  void testForNameWithContextClassNameValue_thenReturnNotAnyParameterUpdated() {
    // Arrange
    ClassModel classModel = new ClassModel(new LibraryClass());

    // Act
    MethodResult actualForNameResult =
        classModel.forName(
            new MethodExecutionContext(null, mock(ValueCalculator.class)),
            BasicValueFactory.DOUBLE_VALUE);

    // Assert
    assertFalse(actualForNameResult.isAnyParameterUpdated());
    assertFalse(actualForNameResult.isInstanceUpdated());
    assertFalse(actualForNameResult.isResultValid());
    assertFalse(actualForNameResult.isReturnValuePresent());
  }

  /**
   * Test {@link ClassModel#forName(MethodExecutionContext, Value)} with {@code context}, {@code
   * classNameValue}.
   *
   * <ul>
   *   <li>When {@link BasicValueFactory#REFERENCE_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link ClassModel#forName(ModelHelper.MethodExecutionContext, Value)}
   */
  @Test
  @DisplayName(
      "Test forName(MethodExecutionContext, Value) with 'context', 'classNameValue'; when REFERENCE_VALUE")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.MethodResult proguard.evaluation.value.object.model.ClassModel.forName(proguard.evaluation.value.object.model.reflective.ModelHelper$MethodExecutionContext, proguard.evaluation.value.Value)"
  })
  void testForNameWithContextClassNameValue_whenReference_value() {
    // Arrange
    ClassModel classModel = new ClassModel(new LibraryClass());

    // Act
    MethodResult actualForNameResult =
        classModel.forName(
            new MethodExecutionContext(null, mock(ValueCalculator.class)),
            BasicValueFactory.REFERENCE_VALUE);

    // Assert
    assertFalse(actualForNameResult.isAnyParameterUpdated());
    assertFalse(actualForNameResult.isInstanceUpdated());
    assertFalse(actualForNameResult.isResultValid());
    assertFalse(actualForNameResult.isReturnValuePresent());
  }

  /**
   * Test {@link ClassModel#equals(Object)}, and {@link ClassModel#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ClassModel#equals(Object)}
   *   <li>{@link ClassModel#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.object.model.ClassModel.equals(java.lang.Object)",
    "int proguard.evaluation.value.object.model.ClassModel.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ClassModel classModel = new ClassModel(new LibraryClass());

    // Act and Assert
    assertEquals(classModel, classModel);
    int expectedHashCodeResult = classModel.hashCode();
    assertEquals(expectedHashCodeResult, classModel.hashCode());
  }

  /**
   * Test {@link ClassModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ClassModel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.object.model.ClassModel.equals(java.lang.Object)",
    "int proguard.evaluation.value.object.model.ClassModel.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ClassModel classModel = new ClassModel(new LibraryClass());

    // Act and Assert
    assertNotEquals(classModel, new ClassModel(new LibraryClass()));
  }

  /**
   * Test {@link ClassModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ClassModel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.object.model.ClassModel.equals(java.lang.Object)",
    "int proguard.evaluation.value.object.model.ClassModel.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ClassModel(new LibraryClass()), null);
  }

  /**
   * Test {@link ClassModel#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ClassModel#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.evaluation.value.object.model.ClassModel.equals(java.lang.Object)",
    "int proguard.evaluation.value.object.model.ClassModel.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ClassModel(new LibraryClass()), "Different type to ClassModel");
  }
}
