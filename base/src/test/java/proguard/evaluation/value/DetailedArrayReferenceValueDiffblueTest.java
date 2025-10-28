package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.Optional;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.evaluation.ParticularReferenceValueFactory;
import proguard.evaluation.value.object.AnalyzedObject;
import proguard.evaluation.value.object.model.ArrayModel;
import proguard.evaluation.value.object.model.Model;

public class DetailedArrayReferenceValueDiffblueTest {
  /**
   * Method under test:
   * {@link DetailedArrayReferenceValue#create(String, Clazz, boolean, IntegerValue, ValueFactory, int)}
   */
  @Test
  public void testCreate() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act
    Optional<DetailedArrayReferenceValue> actualCreateResult = DetailedArrayReferenceValue.create("Type",
        referencedClass, true, BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1);

    // Assert
    assertFalse(actualCreateResult.isPresent());
  }

  /**
   * Method under test:
   * {@link DetailedArrayReferenceValue#create(String, Clazz, boolean, IntegerValue, ValueFactory, int)}
   */
  @Test
  public void testCreate2() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act
    Optional<DetailedArrayReferenceValue> actualCreateResult = DetailedArrayReferenceValue.create("Type",
        referencedClass, true, BasicValueFactory.INTEGER_VALUE, new ParticularReferenceValueFactory(), 1);

    // Assert
    assertFalse(actualCreateResult.isPresent());
  }

  /**
   * Method under test:
   * {@link DetailedArrayReferenceValue#create(String, Clazz, boolean, IntegerValue, ValueFactory, int)}
   */
  @Test
  public void testCreate3() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IntegerValue arrayLength = ParticularValueFactory.INTEGER_VALUE_0;
    ParticularReferenceValueFactory valuefactory = new ParticularReferenceValueFactory();

    // Act
    Optional<DetailedArrayReferenceValue> actualCreateResult = DetailedArrayReferenceValue.create("Type",
        referencedClass, true, arrayLength, valuefactory, 1);

    // Assert
    DetailedArrayReferenceValue getResult = actualCreateResult.get();
    ValueFactory valueFactory = getResult.valuefactory;
    assertTrue(valueFactory instanceof ParticularReferenceValueFactory);
    AnalyzedObject value = getResult.getValue();
    Model modeledOrNullValue = value.getModeledOrNullValue();
    assertTrue(modeledOrNullValue instanceof ArrayModel);
    assertEquals("Type", getResult.getType());
    assertEquals("Type", modeledOrNullValue.getType());
    assertEquals(0, ((ArrayModel) modeledOrNullValue).getValues().length);
    assertEquals(1, getResult.isNotNull());
    assertEquals(1, getResult.id);
    assertFalse(getResult.isCategory2());
    assertFalse(getResult.mayBeNull);
    assertTrue(actualCreateResult.isPresent());
    assertTrue(getResult.isParticular());
    assertTrue(getResult.isSpecific());
    assertTrue(getResult.mayBeExtension());
    assertTrue(getResult.mayBeExtension);
    assertEquals(Value.NEVER, getResult.isNull());
    assertSame(referencedClass, getResult.getReferencedClass());
    assertSame(valuefactory, valueFactory);
    assertSame(arrayLength, getResult.arrayLength);
    assertSame(modeledOrNullValue, value.getModeledValue());
  }

  /**
   * Method under test:
   * {@link DetailedArrayReferenceValue#create(String, Clazz, boolean, IntegerValue, ValueFactory, int)}
   */
  @Test
  public void testCreate4() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();

    // Act
    Optional<DetailedArrayReferenceValue> actualCreateResult = DetailedArrayReferenceValue.create("Type",
        referencedClass, true, ParticularValueFactory.INTEGER_VALUE_M1, new ParticularReferenceValueFactory(), 1);

    // Assert
    assertFalse(actualCreateResult.isPresent());
  }

  /**
   * Method under test:
   * {@link DetailedArrayReferenceValue#create(String, Clazz, boolean, IntegerValue, ValueFactory, int)}
   */
  @Test
  public void testCreate5() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IntegerValue arrayLength = ParticularValueFactory.INTEGER_VALUE_0;
    ParticularReferenceValueFactory valuefactory = new ParticularReferenceValueFactory();

    // Act
    Optional<DetailedArrayReferenceValue> actualCreateResult = DetailedArrayReferenceValue.create("", referencedClass,
        true, arrayLength, valuefactory, 1);

    // Assert
    DetailedArrayReferenceValue getResult = actualCreateResult.get();
    ValueFactory valueFactory = getResult.valuefactory;
    assertTrue(valueFactory instanceof ParticularReferenceValueFactory);
    AnalyzedObject value = getResult.getValue();
    Model modeledOrNullValue = value.getModeledOrNullValue();
    assertTrue(modeledOrNullValue instanceof ArrayModel);
    assertEquals("", getResult.getType());
    assertEquals("", modeledOrNullValue.getType());
    assertEquals(0, ((ArrayModel) modeledOrNullValue).getValues().length);
    assertEquals(1, getResult.isNotNull());
    assertEquals(1, getResult.id);
    assertFalse(getResult.isCategory2());
    assertFalse(getResult.mayBeNull);
    assertTrue(actualCreateResult.isPresent());
    assertTrue(getResult.isParticular());
    assertTrue(getResult.isSpecific());
    assertTrue(getResult.mayBeExtension());
    assertTrue(getResult.mayBeExtension);
    assertEquals(Value.NEVER, getResult.isNull());
    assertSame(referencedClass, getResult.getReferencedClass());
    assertSame(valuefactory, valueFactory);
    assertSame(arrayLength, getResult.arrayLength);
    assertSame(modeledOrNullValue, value.getModeledValue());
  }

  /**
   * Method under test:
   * {@link DetailedArrayReferenceValue#create(String, Clazz, boolean, IntegerValue, ValueFactory, int)}
   */
  @Test
  public void testCreate6() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    IntegerValue arrayLength = ParticularValueFactory.INTEGER_VALUE_1;
    ParticularReferenceValueFactory valuefactory = new ParticularReferenceValueFactory();

    // Act
    Optional<DetailedArrayReferenceValue> actualCreateResult = DetailedArrayReferenceValue.create("Invalid type [",
        referencedClass, true, arrayLength, valuefactory, 1);

    // Assert
    DetailedArrayReferenceValue getResult = actualCreateResult.get();
    ValueFactory valueFactory = getResult.valuefactory;
    assertTrue(valueFactory instanceof ParticularReferenceValueFactory);
    AnalyzedObject value = getResult.getValue();
    Model modeledOrNullValue = value.getModeledOrNullValue();
    assertTrue(modeledOrNullValue instanceof ArrayModel);
    assertEquals("Invalid type [", getResult.getType());
    assertEquals("Invalid type [", modeledOrNullValue.getType());
    assertEquals(1, getResult.isNotNull());
    Value[] values = ((ArrayModel) modeledOrNullValue).getValues();
    assertEquals(1, values.length);
    assertEquals(1, getResult.id);
    assertFalse(getResult.isCategory2());
    assertFalse(getResult.isParticular());
    assertFalse(getResult.mayBeNull);
    assertTrue(actualCreateResult.isPresent());
    assertTrue(getResult.isSpecific());
    assertTrue(getResult.mayBeExtension());
    assertTrue(getResult.mayBeExtension);
    assertEquals(Value.NEVER, getResult.isNull());
    assertSame(referencedClass, getResult.getReferencedClass());
    assertSame(valuefactory, valueFactory);
    assertSame(valuefactory.INTEGER_VALUE, values[0]);
    assertSame(arrayLength, getResult.arrayLength);
    assertSame(modeledOrNullValue, value.getModeledValue());
  }
}
