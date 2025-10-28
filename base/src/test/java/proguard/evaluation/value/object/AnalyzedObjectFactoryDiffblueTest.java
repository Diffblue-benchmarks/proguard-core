package proguard.evaluation.value.object;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.evaluation.value.BasicValueFactory;
import proguard.evaluation.value.UnknownDoubleValue;
import proguard.evaluation.value.Value;
import proguard.evaluation.value.object.model.ArrayModel;
import proguard.evaluation.value.object.model.ClassLoaderModel;
import proguard.evaluation.value.object.model.Model;

public class AnalyzedObjectFactoryDiffblueTest {
  /**
   * Method under test:
   * {@link AnalyzedObjectFactory#create(Object, String, Clazz)}
   */
  @Test
  public void testCreate() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> AnalyzedObjectFactory.create("Value", "Type", new LibraryClass()));
    assertThrows(IllegalStateException.class, () -> AnalyzedObjectFactory.create(null, "Type", new LibraryClass()));
    assertThrows(IllegalStateException.class, () -> AnalyzedObjectFactory.create("Value", null, new LibraryClass()));
    assertThrows(IllegalStateException.class, () -> AnalyzedObjectFactory.create(null, null, new LibraryClass()));
  }

  /**
   * Method under test:
   * {@link AnalyzedObjectFactory#create(Object, String, Clazz)}
   */
  @Test
  public void testCreate2() {
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
   * Method under test: {@link AnalyzedObjectFactory#createPrecise(Object)}
   */
  @Test
  public void testCreatePrecise() {
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
   * Method under test: {@link AnalyzedObjectFactory#createPrecise(Object)}
   */
  @Test
  public void testCreatePrecise2() {
    // Arrange, Act and Assert
    assertThrows(IllegalStateException.class, () -> AnalyzedObjectFactory.createPrecise(new ClassLoaderModel()));
  }

  /**
   * Method under test: {@link AnalyzedObjectFactory#createModeled(Model)}
   */
  @Test
  public void testCreateModeled() {
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
   * Method under test: {@link AnalyzedObjectFactory#createModeled(Model)}
   */
  @Test
  public void testCreateModeled2() {
    // Arrange
    ArrayModel value = new ArrayModel(new Value[]{BasicValueFactory.DOUBLE_VALUE}, "Type");

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
   * Method under test: {@link AnalyzedObjectFactory#createNullOfType(String)}
   */
  @Test
  public void testCreateNullOfType() {
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
   * Method under test: {@link AnalyzedObjectFactory#createNull()}
   */
  @Test
  public void testCreateNull() {
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
   * Method under test:
   * {@link AnalyzedObjectFactory#createDetailedArray(Value[], String)}
   */
  @Test
  public void testCreateDetailedArray() {
    // Arrange and Act
    AnalyzedObject actualCreateDetailedArrayResult = AnalyzedObjectFactory
        .createDetailedArray(new Value[]{BasicValueFactory.DOUBLE_VALUE}, "Type");

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
