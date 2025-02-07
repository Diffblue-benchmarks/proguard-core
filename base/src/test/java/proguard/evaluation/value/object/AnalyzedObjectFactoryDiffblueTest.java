package proguard.evaluation.value.object;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.UnknownDoubleValue;
import proguard.evaluation.value.Value;
import proguard.evaluation.value.object.model.ArrayModel;
import proguard.evaluation.value.object.model.ClassLoaderModel;
import proguard.evaluation.value.object.model.Model;

class AnalyzedObjectFactoryDiffblueTest {
  /**
   * Test {@link AnalyzedObjectFactory#create(Object, String, Clazz)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@link NullObject}.
   * </ul>
   *
   * <p>Method under test: {@link AnalyzedObjectFactory#create(Object, String, Clazz)}
   */
  @Test
  @DisplayName("Test create(Object, String, Clazz); when 'null'; then return NullObject")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.object.AnalyzedObject proguard.evaluation.value.object.AnalyzedObjectFactory.create(java.lang.Object, java.lang.String, proguard.classfile.Clazz)"
  })
  void testCreate_whenNull_thenReturnNullObject() {
    // Arrange and Act
    AnalyzedObject actualCreateResult = AnalyzedObjectFactory.create(null, null, null);

    // Assert
    assertTrue(actualCreateResult instanceof NullObject);
    assertNull(actualCreateResult.getPreciseValue());
    assertNull(actualCreateResult.getType());
    assertNull(actualCreateResult.getModeledOrNullValue());
    assertFalse(actualCreateResult.isModeled());
    assertTrue(actualCreateResult.isNull());
    assertTrue(actualCreateResult.isPrecise());
  }

  /**
   * Test {@link AnalyzedObjectFactory#create(Object, String, Clazz)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link AnalyzedObjectFactory#create(Object, String, Clazz)}
   */
  @Test
  @DisplayName("Test create(Object, String, Clazz); when 'null'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.object.AnalyzedObject proguard.evaluation.value.object.AnalyzedObjectFactory.create(java.lang.Object, java.lang.String, proguard.classfile.Clazz)"
  })
  void testCreate_whenNull_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> AnalyzedObjectFactory.create(null, null, new LibraryClass()));
  }

  /**
   * Test {@link AnalyzedObjectFactory#create(Object, String, Clazz)}.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link AnalyzedObjectFactory#create(Object, String, Clazz)}
   */
  @Test
  @DisplayName("Test create(Object, String, Clazz); when 'Type'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.object.AnalyzedObject proguard.evaluation.value.object.AnalyzedObjectFactory.create(java.lang.Object, java.lang.String, proguard.classfile.Clazz)"
  })
  void testCreate_whenType_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> AnalyzedObjectFactory.create("Value", "Type", new LibraryClass()));
  }

  /**
   * Test {@link AnalyzedObjectFactory#create(Object, String, Clazz)}.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link AnalyzedObjectFactory#create(Object, String, Clazz)}
   */
  @Test
  @DisplayName("Test create(Object, String, Clazz); when 'Type'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.object.AnalyzedObject proguard.evaluation.value.object.AnalyzedObjectFactory.create(java.lang.Object, java.lang.String, proguard.classfile.Clazz)"
  })
  void testCreate_whenType_thenThrowIllegalStateException2() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> AnalyzedObjectFactory.create(null, "Type", new LibraryClass()));
  }

  /**
   * Test {@link AnalyzedObjectFactory#create(Object, String, Clazz)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link AnalyzedObjectFactory#create(Object, String, Clazz)}
   */
  @Test
  @DisplayName("Test create(Object, String, Clazz); when 'Value'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.object.AnalyzedObject proguard.evaluation.value.object.AnalyzedObjectFactory.create(java.lang.Object, java.lang.String, proguard.classfile.Clazz)"
  })
  void testCreate_whenValue_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> AnalyzedObjectFactory.create("Value", null, new LibraryClass()));
  }

  /**
   * Test {@link AnalyzedObjectFactory#createPrecise(Object)}.
   *
   * <ul>
   *   <li>When {@link ClassLoaderModel} (default constructor).
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link AnalyzedObjectFactory#createPrecise(Object)}
   */
  @Test
  @DisplayName(
      "Test createPrecise(Object); when ClassLoaderModel (default constructor); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.object.AnalyzedObject proguard.evaluation.value.object.AnalyzedObjectFactory.createPrecise(java.lang.Object)"
  })
  void testCreatePrecise_whenClassLoaderModel_thenThrowIllegalStateException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> AnalyzedObjectFactory.createPrecise(new ClassLoaderModel()));
  }

  /**
   * Test {@link AnalyzedObjectFactory#createPrecise(Object)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then return {@link PreciseObject}.
   * </ul>
   *
   * <p>Method under test: {@link AnalyzedObjectFactory#createPrecise(Object)}
   */
  @Test
  @DisplayName("Test createPrecise(Object); when 'Value'; then return PreciseObject")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.object.AnalyzedObject proguard.evaluation.value.object.AnalyzedObjectFactory.createPrecise(java.lang.Object)"
  })
  void testCreatePrecise_whenValue_thenReturnPreciseObject() {
    // Arrange and Act
    AnalyzedObject actualCreatePreciseResult = AnalyzedObjectFactory.createPrecise("Value");

    // Assert
    assertTrue(actualCreatePreciseResult instanceof PreciseObject);
    assertEquals("Ljava/lang/String;", actualCreatePreciseResult.getType());
    assertEquals("Value", actualCreatePreciseResult.getPreciseValue());
    assertFalse(actualCreatePreciseResult.isModeled());
    assertFalse(actualCreatePreciseResult.isNull());
    assertTrue(actualCreatePreciseResult.isPrecise());
  }

  /**
   * Test {@link AnalyzedObjectFactory#createModeled(Model)}.
   *
   * <ul>
   *   <li>Then return {@link ArrayObject}.
   * </ul>
   *
   * <p>Method under test: {@link AnalyzedObjectFactory#createModeled(Model)}
   */
  @Test
  @DisplayName("Test createModeled(Model); then return ArrayObject")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.object.AnalyzedObject proguard.evaluation.value.object.AnalyzedObjectFactory.createModeled(proguard.evaluation.value.object.model.Model)"
  })
  void testCreateModeled_thenReturnArrayObject() {
    // Arrange
    ArrayModel value = new ArrayModel(new Value[] {BasicValueFactory.DOUBLE_VALUE}, "Type");

    // Act
    AnalyzedObject actualCreateModeledResult = AnalyzedObjectFactory.createModeled(value);

    // Assert
    assertTrue(actualCreateModeledResult instanceof ArrayObject);
    assertEquals("Type", actualCreateModeledResult.getType());
    assertFalse(actualCreateModeledResult.isNull());
    assertFalse(actualCreateModeledResult.isPrecise());
    assertTrue(actualCreateModeledResult.isModeled());
    assertSame(value, actualCreateModeledResult.getModeledOrNullValue());
    assertSame(value, actualCreateModeledResult.getModeledValue());
  }

  /**
   * Test {@link AnalyzedObjectFactory#createModeled(Model)}.
   *
   * <ul>
   *   <li>When {@link ClassLoaderModel} (default constructor).
   *   <li>Then return {@link ModeledObject}.
   * </ul>
   *
   * <p>Method under test: {@link AnalyzedObjectFactory#createModeled(Model)}
   */
  @Test
  @DisplayName(
      "Test createModeled(Model); when ClassLoaderModel (default constructor); then return ModeledObject")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.object.AnalyzedObject proguard.evaluation.value.object.AnalyzedObjectFactory.createModeled(proguard.evaluation.value.object.model.Model)"
  })
  void testCreateModeled_whenClassLoaderModel_thenReturnModeledObject() {
    // Arrange
    ClassLoaderModel value = new ClassLoaderModel();

    // Act
    AnalyzedObject actualCreateModeledResult = AnalyzedObjectFactory.createModeled(value);

    // Assert
    assertTrue(actualCreateModeledResult instanceof ModeledObject);
    Model modeledOrNullValue = actualCreateModeledResult.getModeledOrNullValue();
    assertTrue(modeledOrNullValue instanceof ClassLoaderModel);
    assertEquals("Ljava/lang/ClassLoader;", actualCreateModeledResult.getType());
    assertEquals("Ljava/lang/ClassLoader;", modeledOrNullValue.getType());
    assertFalse(actualCreateModeledResult.isNull());
    assertFalse(actualCreateModeledResult.isPrecise());
    assertTrue(actualCreateModeledResult.isModeled());
    assertSame(value, modeledOrNullValue);
    assertSame(value, actualCreateModeledResult.getModeledValue());
  }

  /**
   * Test {@link AnalyzedObjectFactory#createNullOfType(String)}.
   *
   * <p>Method under test: {@link AnalyzedObjectFactory#createNullOfType(String)}
   */
  @Test
  @DisplayName("Test createNullOfType(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.object.AnalyzedObject proguard.evaluation.value.object.AnalyzedObjectFactory.createNullOfType(java.lang.String)"
  })
  void testCreateNullOfType() {
    // Arrange and Act
    AnalyzedObject actualCreateNullOfTypeResult = AnalyzedObjectFactory.createNullOfType("Type");

    // Assert
    assertTrue(actualCreateNullOfTypeResult instanceof TypedNullObject);
    assertEquals("Type", actualCreateNullOfTypeResult.getType());
    assertNull(actualCreateNullOfTypeResult.getPreciseValue());
    assertNull(actualCreateNullOfTypeResult.getModeledOrNullValue());
    assertFalse(actualCreateNullOfTypeResult.isModeled());
    assertTrue(actualCreateNullOfTypeResult.isNull());
    assertTrue(actualCreateNullOfTypeResult.isPrecise());
  }

  /**
   * Test {@link AnalyzedObjectFactory#createNull()}.
   *
   * <p>Method under test: {@link AnalyzedObjectFactory#createNull()}
   */
  @Test
  @DisplayName("Test createNull()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.object.AnalyzedObject proguard.evaluation.value.object.AnalyzedObjectFactory.createNull()"
  })
  void testCreateNull() {
    // Arrange and Act
    AnalyzedObject actualCreateNullResult = AnalyzedObjectFactory.createNull();

    // Assert
    assertTrue(actualCreateNullResult instanceof NullObject);
    assertNull(actualCreateNullResult.getPreciseValue());
    assertNull(actualCreateNullResult.getType());
    assertNull(actualCreateNullResult.getModeledOrNullValue());
    assertFalse(actualCreateNullResult.isModeled());
    assertTrue(actualCreateNullResult.isNull());
    assertTrue(actualCreateNullResult.isPrecise());
  }

  /**
   * Test {@link AnalyzedObjectFactory#createDetailedArray(Value[], String)}.
   *
   * <p>Method under test: {@link AnalyzedObjectFactory#createDetailedArray(Value[], String)}
   */
  @Test
  @DisplayName("Test createDetailedArray(Value[], String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.evaluation.value.object.AnalyzedObject proguard.evaluation.value.object.AnalyzedObjectFactory.createDetailedArray(proguard.evaluation.value.Value[], java.lang.String)"
  })
  void testCreateDetailedArray() {
    // Arrange and Act
    AnalyzedObject actualCreateDetailedArrayResult =
        AnalyzedObjectFactory.createDetailedArray(
            new Value[] {BasicValueFactory.DOUBLE_VALUE}, "Type");

    // Assert
    Model modeledOrNullValue = actualCreateDetailedArrayResult.getModeledOrNullValue();
    Value[] values = ((ArrayModel) modeledOrNullValue).getValues();
    Value value = values[0];
    assertTrue(value instanceof UnknownDoubleValue);
    assertTrue(actualCreateDetailedArrayResult instanceof ArrayObject);
    assertTrue(modeledOrNullValue instanceof ArrayModel);
    assertEquals("Type", actualCreateDetailedArrayResult.getType());
    assertEquals("Type", modeledOrNullValue.getType());
    assertEquals(1, values.length);
    assertFalse(value.isParticular());
    assertFalse(value.isSpecific());
    assertFalse(actualCreateDetailedArrayResult.isNull());
    assertFalse(actualCreateDetailedArrayResult.isPrecise());
    assertTrue(value.isCategory2());
    assertTrue(actualCreateDetailedArrayResult.isModeled());
    assertSame(modeledOrNullValue, actualCreateDetailedArrayResult.getModeledValue());
  }
}
