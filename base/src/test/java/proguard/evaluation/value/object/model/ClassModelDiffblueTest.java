package proguard.evaluation.value.object.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.evaluation.MethodResult;
import proguard.evaluation.ValueCalculator;
import proguard.evaluation.executor.MethodExecutionInfo;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.Value;
import proguard.evaluation.value.object.model.reflective.ModelHelper;
import proguard.evaluation.value.object.model.reflective.ModelHelper.MethodExecutionContext;

public class ClassModelDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ClassModel.<init>(Clazz)",
    "Clazz ClassModel.getClazz()",
    "String ClassModel.getType()",
    "String ClassModel.toString()"
  })
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodResult ClassModel.init(MethodExecutionInfo, ValueCalculator)"})
  public void testInit_whenNull_thenThrowUnsupportedOperationException() {
    // Arrange, Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> (new ClassModel(new LibraryClass())).init(null, null));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodResult ClassModel.getName(ModelHelper.MethodExecutionContext)"})
  public void testGetName_givenClassModelWithClazzIsNull_thenReturnNotAnyParameterUpdated() {
    // Arrange
    ClassModel classModel = new ClassModel(null);

    // Act
    MethodResult actualName = classModel.getName(new MethodExecutionContext(null, null));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodResult ClassModel.getSimpleName(ModelHelper.MethodExecutionContext)"})
  public void testGetSimpleName_thenReturnNotAnyParameterUpdated() {
    // Arrange
    ClassModel classModel = new ClassModel(null);

    // Act
    MethodResult actualSimpleName =
        classModel.getSimpleName(new MethodExecutionContext(null, null));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "MethodResult ClassModel.getCanonicalName(ModelHelper.MethodExecutionContext)"
  })
  public void testGetCanonicalName_thenReturnNotAnyParameterUpdated() {
    // Arrange
    ClassModel classModel = new ClassModel(null);

    // Act
    MethodResult actualCanonicalName =
        classModel.getCanonicalName(new MethodExecutionContext(null, null));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodResult ClassModel.getPackageName(ModelHelper.MethodExecutionContext)"})
  public void testGetPackageName_thenReturnNotAnyParameterUpdated() {
    // Arrange
    ClassModel classModel = new ClassModel(null);

    // Act
    MethodResult actualPackageName =
        classModel.getPackageName(new MethodExecutionContext(null, null));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodResult ClassModel.getTypeName(ModelHelper.MethodExecutionContext)"})
  public void testGetTypeName_givenClassModelWithClazzIsNull_thenReturnNotAnyParameterUpdated() {
    // Arrange
    ClassModel classModel = new ClassModel(null);

    // Act
    MethodResult actualTypeName = classModel.getTypeName(new MethodExecutionContext(null, null));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "MethodResult ClassModel.forName(ModelHelper.MethodExecutionContext, Value, Value, Value)"
  })
  public void testForNameWithContextClassNameValueInitializeValueClassLoaderValue() {
    // Arrange
    ClassModel classModel = new ClassModel(new LibraryClass());

    // Act
    MethodResult actualForNameResult =
        classModel.forName(
            new MethodExecutionContext(null, null),
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "MethodResult ClassModel.forName(ModelHelper.MethodExecutionContext, Value, Value, Value)"
  })
  public void testForNameWithContextClassNameValueInitializeValueClassLoaderValue2() {
    // Arrange
    ClassModel classModel = new ClassModel(new LibraryClass());

    // Act
    MethodResult actualForNameResult =
        classModel.forName(
            new MethodExecutionContext(null, null),
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodResult ClassModel.forName(ModelHelper.MethodExecutionContext, Value)"})
  public void testForNameWithContextClassNameValue_thenReturnNotAnyParameterUpdated() {
    // Arrange
    ClassModel classModel = new ClassModel(new LibraryClass());

    // Act
    MethodResult actualForNameResult =
        classModel.forName(new MethodExecutionContext(null, null), BasicValueFactory.DOUBLE_VALUE);

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MethodResult ClassModel.forName(ModelHelper.MethodExecutionContext, Value)"})
  public void testForNameWithContextClassNameValue_whenReference_value() {
    // Arrange
    ClassModel classModel = new ClassModel(new LibraryClass());

    // Act
    MethodResult actualForNameResult =
        classModel.forName(
            new MethodExecutionContext(null, null), BasicValueFactory.REFERENCE_VALUE);

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
   *   <li>When other is equal.
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassModel.equals(Object)", "int ClassModel.hashCode()"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassModel.equals(Object)", "int ClassModel.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassModel.equals(Object)", "int ClassModel.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassModel.equals(Object)", "int ClassModel.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassModel.equals(Object)", "int ClassModel.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ClassModel(new LibraryClass()), "Different type to ClassModel");
  }
}
