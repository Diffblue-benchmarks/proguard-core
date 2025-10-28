package proguard.evaluation.value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.evaluation.ParticularReferenceValueFactory;
import proguard.evaluation.value.object.AnalyzedObject;

public class MultiTypedReferenceValueDiffblueTest {
  /**
   * Method under test: {@link MultiTypedReferenceValue#generalize(Set)}
   */
  @Test
  public void testGeneralize() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Act and Assert
    assertSame(typedReferenceValue, multiTypedReferenceValue.generalize(potentialTypes2));
  }

  /**
   * Method under test: {@link MultiTypedReferenceValue#generalize(Set)}
   */
  @Test
  public void testGeneralize2() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue(null, new LibraryClass(), true, true);

    potentialTypes2.add(typedReferenceValue);

    // Act and Assert
    assertSame(typedReferenceValue, multiTypedReferenceValue.generalize(potentialTypes2));
  }

  /**
   * Method under test: {@link MultiTypedReferenceValue#generalize(Set)}
   */
  @Test
  public void testGeneralize3() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("", new LibraryClass(), true, true);

    potentialTypes2.add(typedReferenceValue);

    // Act and Assert
    assertSame(typedReferenceValue, multiTypedReferenceValue.generalize(potentialTypes2));
  }

  /**
   * Method under test: {@link MultiTypedReferenceValue#generalize(Set)}
   */
  @Test
  public void testGeneralize4() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), false, true);

    potentialTypes2.add(typedReferenceValue);

    // Act and Assert
    assertSame(typedReferenceValue, multiTypedReferenceValue.generalize(potentialTypes2));
  }

  /**
   * Method under test: {@link MultiTypedReferenceValue#generalize(Set)}
   */
  @Test
  public void testGeneralize5() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), true, false);

    potentialTypes2.add(typedReferenceValue);

    // Act and Assert
    assertSame(typedReferenceValue, multiTypedReferenceValue.generalize(potentialTypes2));
  }

  /**
   * Method under test: {@link MultiTypedReferenceValue#generalize(Set)}
   */
  @Test
  public void testGeneralize6() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));
    potentialTypes2.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Act and Assert
    assertSame(typedReferenceValue, multiTypedReferenceValue.generalize(potentialTypes2));
  }

  /**
   * Method under test: {@link MultiTypedReferenceValue#generalize(Set)}
   */
  @Test
  public void testGeneralize7() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes
        .add(new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes2.add(typedReferenceValue);

    // Act and Assert
    assertSame(typedReferenceValue, multiTypedReferenceValue.generalize(potentialTypes2));
  }

  /**
   * Method under test: {@link MultiTypedReferenceValue#generalize(Set)}
   */
  @Test
  public void testGeneralize8() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue(null, new LibraryClass(), true, true);

    potentialTypes2.add(typedReferenceValue);

    // Act and Assert
    assertSame(typedReferenceValue, multiTypedReferenceValue.generalize(potentialTypes2));
  }

  /**
   * Method under test: {@link MultiTypedReferenceValue#generalize(Set)}
   */
  @Test
  public void testGeneralize9() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue(null, new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue(null, new LibraryClass(), true, true));

    // Act and Assert
    assertSame(typedReferenceValue, multiTypedReferenceValue.generalize(potentialTypes2));
  }

  /**
   * Method under test: {@link MultiTypedReferenceValue#generalize(Set)}
   */
  @Test
  public void testGeneralize10() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    potentialTypes2.add(new TypedReferenceValue(null, new LibraryClass(), true, true));

    // Act and Assert
    assertSame(typedReferenceValue, multiTypedReferenceValue.generalize(potentialTypes2));
  }

  /**
   * Method under test: {@link MultiTypedReferenceValue#generalize(Set)}
   */
  @Test
  public void testGeneralize11() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("42", new LibraryClass(), true, true);

    potentialTypes2.add(typedReferenceValue);
    potentialTypes2.add(new TypedReferenceValue(null, new LibraryClass(), true, true));

    // Act and Assert
    assertSame(typedReferenceValue, multiTypedReferenceValue.generalize(potentialTypes2));
  }

  /**
   * Method under test: {@link MultiTypedReferenceValue#generalize(Set)}
   */
  @Test
  public void testGeneralize12() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue("Type", new LibraryClass(), true, false));
    potentialTypes2.add(new TypedReferenceValue(null, new LibraryClass(), true, true));

    // Act and Assert
    assertSame(typedReferenceValue, multiTypedReferenceValue.generalize(potentialTypes2));
  }

  /**
   * Method under test: {@link MultiTypedReferenceValue#generalize(Set)}
   */
  @Test
  public void testGeneralize13() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue("Type", new LibraryClass(), true, false));
    potentialTypes2.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));

    // Act and Assert
    assertSame(typedReferenceValue, multiTypedReferenceValue.generalize(potentialTypes2));
  }

  /**
   * Method under test: {@link MultiTypedReferenceValue#generalize(Set)}
   */
  @Test
  public void testGeneralize14() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue("", null, true, true));
    potentialTypes2.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Act
    TypedReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(potentialTypes2);

    // Assert
    assertEquals("Ljava/lang/Object;", actualGeneralizeResult.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualGeneralizeResult.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.mayBeExtension());
    assertTrue(actualGeneralizeResult.mayBeExtension);
    assertTrue(actualGeneralizeResult.mayBeNull);
  }

  /**
   * Method under test: {@link MultiTypedReferenceValue#generalize(Set)}
   */
  @Test
  public void testGeneralize15() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue("", new LibraryClass(), true, true));
    potentialTypes2.add(new TypedReferenceValue("Type", null, true, true));

    // Act
    TypedReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(potentialTypes2);

    // Assert
    assertEquals("Ljava/lang/Object;", actualGeneralizeResult.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualGeneralizeResult.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, actualGeneralizeResult.isNull());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(actualGeneralizeResult.mayBeExtension());
    assertTrue(actualGeneralizeResult.mayBeExtension);
    assertTrue(actualGeneralizeResult.mayBeNull);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(MultiTypedReferenceValue)}
   */
  @Test
  public void testGeneralize16() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Act and Assert
    assertSame(multiTypedReferenceValue,
        multiTypedReferenceValue.generalize(new MultiTypedReferenceValue(potentialTypes2, true)));
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(MultiTypedReferenceValue)}
   */
  @Test
  public void testGeneralize17() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue(null, new LibraryClass(), true, true));

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue
        .generalize(new MultiTypedReferenceValue(potentialTypes2, true));

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(MultiTypedReferenceValue)}
   */
  @Test
  public void testGeneralize18() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue
        .generalize(new MultiTypedReferenceValue(potentialTypes2, true));

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(MultiTypedReferenceValue)}
   */
  @Test
  public void testGeneralize19() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue("Type", new LibraryClass(), true, false));

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue
        .generalize(new MultiTypedReferenceValue(potentialTypes2, true));

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(MultiTypedReferenceValue)}
   */
  @Test
  public void testGeneralize20() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));
    potentialTypes2.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue
        .generalize(new MultiTypedReferenceValue(potentialTypes2, true));

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(MultiTypedReferenceValue)}
   */
  @Test
  public void testGeneralize21() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, false);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue other = new MultiTypedReferenceValue(potentialTypes2, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(MultiTypedReferenceValue)}
   */
  @Test
  public void testGeneralize22() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue(null, new LibraryClass(), true, true));

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue
        .generalize(new MultiTypedReferenceValue(potentialTypes2, true));

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(MultiTypedReferenceValue)}
   */
  @Test
  public void testGeneralize23() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    LibraryClass referencedClass = new LibraryClass();
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", referencedClass, true, true);

    potentialTypes.add(typedReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, false);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue(null, new LibraryClass(), true, true));

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue
        .generalize(new MultiTypedReferenceValue(potentialTypes2, true));

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualGeneralizeResult).getPotentialTypes().size());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(((MultiTypedReferenceValue) actualGeneralizeResult).mayBeUnknown);
    assertEquals(typedReferenceValue, ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(MultiTypedReferenceValue)}
   */
  @Test
  public void testGeneralize24() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", null, true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue("", new LibraryClass(), true, true));

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue
        .generalize(new MultiTypedReferenceValue(potentialTypes2, true));

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals("Ljava/lang/Object;", actualGeneralizeResult.getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType();
    assertEquals("Ljava/lang/Object;", generalizedType.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualGeneralizeResult.getReferencedClass());
    assertNull(generalizedType.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(2, ((MultiTypedReferenceValue) actualGeneralizeResult).getPotentialTypes().size());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertFalse(generalizedType.isSpecific());
    assertTrue(generalizedType.mayBeExtension());
    assertTrue(((MultiTypedReferenceValue) actualGeneralizeResult).mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension);
    assertTrue(generalizedType.mayBeNull);
    assertSame(value, generalizedType.getValue());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(MultiTypedReferenceValue)}
   */
  @Test
  public void testGeneralize25() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue("", null, true, true));

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue
        .generalize(new MultiTypedReferenceValue(potentialTypes2, true));

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals("Ljava/lang/Object;", actualGeneralizeResult.getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType();
    assertEquals("Ljava/lang/Object;", generalizedType.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualGeneralizeResult.getReferencedClass());
    assertNull(generalizedType.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(2, ((MultiTypedReferenceValue) actualGeneralizeResult).getPotentialTypes().size());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertFalse(generalizedType.isSpecific());
    assertTrue(generalizedType.mayBeExtension());
    assertTrue(((MultiTypedReferenceValue) actualGeneralizeResult).mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension);
    assertTrue(generalizedType.mayBeNull);
    assertSame(value, generalizedType.getValue());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(MultiTypedReferenceValue)}
   */
  @Test
  public void testGeneralize26() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes
        .add(new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue("Type", new LibraryClass(), true, false));
    MultiTypedReferenceValue other = new MultiTypedReferenceValue(potentialTypes2, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(other, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize27() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(BasicValueFactory.REFERENCE_VALUE);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize28() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue(null, new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(BasicValueFactory.REFERENCE_VALUE);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize29() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(BasicValueFactory.REFERENCE_VALUE);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize30() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, false));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(BasicValueFactory.REFERENCE_VALUE);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize31() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(BasicValueFactory.REFERENCE_VALUE);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize32() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, false));
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(BasicValueFactory.REFERENCE_VALUE);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize33() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes
        .add(new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(BasicValueFactory.REFERENCE_VALUE);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize34() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue
        .generalize(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize35() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    ReferenceValue other = TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL;

    // Act
    ReferenceValue actualGeneralizeResult = (new MultiTypedReferenceValue(potentialTypes, true)).generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals("Ljava/lang/Object;", actualGeneralizeResult.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualGeneralizeResult.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(2, ((MultiTypedReferenceValue) actualGeneralizeResult).getPotentialTypes().size());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(((MultiTypedReferenceValue) actualGeneralizeResult).mayBeUnknown);
    assertSame(other, ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize36() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Act
    ReferenceValue actualGeneralizeResult = (new MultiTypedReferenceValue(potentialTypes, true))
        .generalize(TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_NOT_NULL);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals("Ljava/lang/Object;", actualGeneralizeResult.getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType();
    assertEquals("Ljava/lang/Object;", generalizedType.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualGeneralizeResult.getReferencedClass());
    assertNull(generalizedType.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(2, ((MultiTypedReferenceValue) actualGeneralizeResult).getPotentialTypes().size());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertFalse(generalizedType.isSpecific());
    assertTrue(generalizedType.mayBeExtension());
    assertTrue(((MultiTypedReferenceValue) actualGeneralizeResult).mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension);
    assertTrue(generalizedType.mayBeNull);
    assertSame(value, generalizedType.getValue());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize37() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue
        .generalize((ReferenceValue) new ArrayReferenceValue("Type", new LibraryClass(), true,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize38() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue
        .generalize((ReferenceValue) new IdentifiedArrayReferenceValue("Type", referencedClass, true,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1));

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize39() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue
        .generalize((ReferenceValue) new IdentifiedReferenceValue("Type", referencedClass, true, true,
            new ParticularReferenceValueFactory(), "Id"));

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize40() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue
        .generalize((ReferenceValue) new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize41() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);
    MultiTypedReferenceValue other = new MultiTypedReferenceValue(
        new TypedReferenceValue("Type", new LibraryClass(), true, true), true);

    // Act and Assert
    assertSame(other, multiTypedReferenceValue.generalize((ReferenceValue) other));
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize42() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    potentialTypes.add(new TypedReferenceValue(null, new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(BasicValueFactory.REFERENCE_VALUE);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize43() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("", new LibraryClass(), true, true));
    potentialTypes.add(new TypedReferenceValue(null, new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(BasicValueFactory.REFERENCE_VALUE);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize44() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("42", new LibraryClass(), true, true));
    potentialTypes.add(new TypedReferenceValue(null, new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(BasicValueFactory.REFERENCE_VALUE);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize45() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, false));
    potentialTypes.add(new TypedReferenceValue(null, new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(BasicValueFactory.REFERENCE_VALUE);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize46() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue(null, new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue
        .generalize(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize47() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, false));
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(BasicValueFactory.REFERENCE_VALUE);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize48() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue
        .generalize(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize49() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, false));
    ReferenceValue other = TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_NOT_NULL;

    // Act
    ReferenceValue actualGeneralizeResult = (new MultiTypedReferenceValue(potentialTypes, true)).generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals("Ljava/lang/Object;", actualGeneralizeResult.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualGeneralizeResult.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualGeneralizeResult.isNotNull());
    assertEquals(2, ((MultiTypedReferenceValue) actualGeneralizeResult).getPotentialTypes().size());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(((MultiTypedReferenceValue) actualGeneralizeResult).mayBeUnknown);
    assertSame(other, ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize50() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, false));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue
        .generalize((ReferenceValue) new ArrayReferenceValue("Type", new LibraryClass(), true,
            BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize51() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes
        .add(new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(BasicValueFactory.REFERENCE_VALUE);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize52() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(null);
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(BasicValueFactory.REFERENCE_VALUE);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize53() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    LibraryClass referencedClass = new LibraryClass();
    potentialTypes.add(new TypedReferenceValue("Type", referencedClass, false, true));
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);

    // Act
    ReferenceValue actualGeneralizeResult = (new MultiTypedReferenceValue(potentialTypes, true))
        .generalize(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualGeneralizeResult).getPotentialTypes().size());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(((MultiTypedReferenceValue) actualGeneralizeResult).mayBeUnknown);
    assertEquals(typedReferenceValue, ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize54() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, false));
    LibraryClass referencedClass = new LibraryClass();
    potentialTypes.add(
        new IdentifiedReferenceValue("Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(BasicValueFactory.REFERENCE_VALUE);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize55() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, false);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue
        .generalize(PrimitiveTypedReferenceValueFactory.REFERENCE_VALUE_NULL);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(ReferenceValue)}
   */
  @Test
  public void testGeneralize56() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("", new LibraryClass(), true, true));
    ReferenceValue other = TypedReferenceValueFactory.REFERENCE_VALUE_JAVA_LANG_OBJECT_MAYBE_NULL;

    // Act
    ReferenceValue actualGeneralizeResult = (new MultiTypedReferenceValue(potentialTypes, true)).generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals("Ljava/lang/Object;", actualGeneralizeResult.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualGeneralizeResult.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(2, ((MultiTypedReferenceValue) actualGeneralizeResult).getPotentialTypes().size());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(((MultiTypedReferenceValue) actualGeneralizeResult).mayBeUnknown);
    assertSame(other, ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  public void testGeneralize57() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue
        .generalize(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  public void testGeneralize58() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue(null, new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);
    LibraryClass referencedClass = new LibraryClass();
    TypedReferenceValue other = new TypedReferenceValue("Type", referencedClass, true, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualGeneralizeResult).getPotentialTypes().size());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(((MultiTypedReferenceValue) actualGeneralizeResult).mayBeUnknown);
    assertEquals(other, ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  public void testGeneralize59() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue
        .generalize(new TypedReferenceValue("Type", referencedClass, true, true));

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualGeneralizeResult).getPotentialTypes().size());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(((MultiTypedReferenceValue) actualGeneralizeResult).mayBeUnknown);
    assertEquals(typedReferenceValue, ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  public void testGeneralize60() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, false));
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue
        .generalize(new TypedReferenceValue("Type", referencedClass, true, true));

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualGeneralizeResult).getPotentialTypes().size());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(((MultiTypedReferenceValue) actualGeneralizeResult).mayBeUnknown);
    assertEquals(typedReferenceValue, ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  public void testGeneralize61() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, false);

    // Act and Assert
    assertSame(multiTypedReferenceValue,
        multiTypedReferenceValue.generalize(new TypedReferenceValue("Type", new LibraryClass(), true, true)));
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  public void testGeneralize62() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue
        .generalize(new TypedReferenceValue("Type", new LibraryClass(), false, true));

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  public void testGeneralize63() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue
        .generalize(new TypedReferenceValue("Type", new LibraryClass(), true, false));

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  public void testGeneralize64() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue(null, new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, false);
    LibraryClass referencedClass = new LibraryClass();
    TypedReferenceValue other = new TypedReferenceValue("Type", referencedClass, true, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualGeneralizeResult).getPotentialTypes().size());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualGeneralizeResult).mayBeUnknown);
    assertEquals(other, ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  public void testGeneralize65() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue(null, new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);
    LibraryClass referencedClass = new LibraryClass();
    TypedReferenceValue other = new TypedReferenceValue("Type", referencedClass, false, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualGeneralizeResult).getPotentialTypes().size());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(((MultiTypedReferenceValue) actualGeneralizeResult).mayBeUnknown);
    assertEquals(other, ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  public void testGeneralize66() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("", null, true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue
        .generalize(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals("Ljava/lang/Object;", actualGeneralizeResult.getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType();
    assertEquals("Ljava/lang/Object;", generalizedType.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualGeneralizeResult.getReferencedClass());
    assertNull(generalizedType.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(2, ((MultiTypedReferenceValue) actualGeneralizeResult).getPotentialTypes().size());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertFalse(generalizedType.isSpecific());
    assertTrue(generalizedType.mayBeExtension());
    assertTrue(((MultiTypedReferenceValue) actualGeneralizeResult).mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension);
    assertTrue(generalizedType.mayBeNull);
    assertSame(value, generalizedType.getValue());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  public void testGeneralize67() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue
        .generalize(new TypedReferenceValue("Type", null, true, true));

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals("Ljava/lang/Object;", actualGeneralizeResult.getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType();
    assertEquals("Ljava/lang/Object;", generalizedType.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualGeneralizeResult.getReferencedClass());
    assertNull(generalizedType.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(2, ((MultiTypedReferenceValue) actualGeneralizeResult).getPotentialTypes().size());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertFalse(generalizedType.isSpecific());
    assertTrue(generalizedType.mayBeExtension());
    assertTrue(((MultiTypedReferenceValue) actualGeneralizeResult).mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension);
    assertTrue(generalizedType.mayBeNull);
    assertSame(value, generalizedType.getValue());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  public void testGeneralize68() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, false);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue
        .generalize(new TypedReferenceValue("Type", referencedClass, true, true));

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualGeneralizeResult).getPotentialTypes().size());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertFalse(((MultiTypedReferenceValue) actualGeneralizeResult).mayBeUnknown);
    assertEquals(typedReferenceValue, ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(TypedReferenceValue)}
   */
  @Test
  public void testGeneralize69() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, false));
    potentialTypes
        .add(new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);
    LibraryClass referencedClass = new LibraryClass();
    TypedReferenceValue other = new TypedReferenceValue("Type", referencedClass, true, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(other);

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals("Type", actualGeneralizeResult.getType());
    AnalyzedObject value = actualGeneralizeResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualGeneralizeResult.isNotNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualGeneralizeResult).getPotentialTypes().size());
    assertFalse(actualGeneralizeResult.isCategory2());
    assertFalse(actualGeneralizeResult.isParticular());
    assertFalse(actualGeneralizeResult.isSpecific());
    assertTrue(((MultiTypedReferenceValue) actualGeneralizeResult).mayBeUnknown);
    assertEquals(other, ((MultiTypedReferenceValue) actualGeneralizeResult).getGeneralizedType());
    assertSame(referencedClass, actualGeneralizeResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  public void testGeneralize70() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(new UnknownReferenceValue());

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  public void testGeneralize71() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue(null, new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(new UnknownReferenceValue());

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  public void testGeneralize72() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(new UnknownReferenceValue());

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  public void testGeneralize73() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, false));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(new UnknownReferenceValue());

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  public void testGeneralize74() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(new UnknownReferenceValue());

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  public void testGeneralize75() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, false));
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(new UnknownReferenceValue());

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  public void testGeneralize76() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes
        .add(new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(new UnknownReferenceValue());

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  public void testGeneralize77() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    potentialTypes.add(new TypedReferenceValue(null, new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(new UnknownReferenceValue());

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  public void testGeneralize78() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("", new LibraryClass(), true, true));
    potentialTypes.add(new TypedReferenceValue(null, new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(new UnknownReferenceValue());

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  public void testGeneralize79() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("42", new LibraryClass(), true, true));
    potentialTypes.add(new TypedReferenceValue(null, new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(new UnknownReferenceValue());

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  public void testGeneralize80() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, false));
    potentialTypes.add(new TypedReferenceValue(null, new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(new UnknownReferenceValue());

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  public void testGeneralize81() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, false));
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(new UnknownReferenceValue());

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  public void testGeneralize82() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes
        .add(new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(new UnknownReferenceValue());

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  public void testGeneralize83() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(null);
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(new UnknownReferenceValue());

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  public void testGeneralize84() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));
    LibraryClass referencedClass = new LibraryClass();
    potentialTypes.add(
        new IdentifiedReferenceValue("Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(new UnknownReferenceValue());

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  public void testGeneralize85() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, false));
    potentialTypes
        .add(new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(new UnknownReferenceValue());

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  public void testGeneralize86() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, false));
    LibraryClass referencedClass = new LibraryClass();
    potentialTypes.add(
        new IdentifiedReferenceValue("Type", referencedClass, true, true, new ParticularReferenceValueFactory(), "Id"));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(new UnknownReferenceValue());

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#generalize(UnknownReferenceValue)}
   */
  @Test
  public void testGeneralize87() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    LibraryClass referencedClass = new LibraryClass();
    potentialTypes.add(new IdentifiedArrayReferenceValue("Type", referencedClass, true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualGeneralizeResult = multiTypedReferenceValue.generalize(new UnknownReferenceValue());

    // Assert
    assertTrue(actualGeneralizeResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualGeneralizeResult);
  }

  /**
   * Method under test: {@link MultiTypedReferenceValue#getType()}
   */
  @Test
  public void testGetType() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Act and Assert
    assertEquals("Type", (new MultiTypedReferenceValue(potentialTypes, true)).getType());
  }

  /**
   * Method under test: {@link MultiTypedReferenceValue#getReferencedClass()}
   */
  @Test
  public void testGetReferencedClass() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);

    // Act and Assert
    assertSame(typedReferenceValue.referencedClass,
        (new MultiTypedReferenceValue(potentialTypes, true)).getReferencedClass());
  }

  /**
   * Method under test: {@link MultiTypedReferenceValue#mayBeExtension()}
   */
  @Test
  public void testMayBeExtension() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Act and Assert
    assertTrue((new MultiTypedReferenceValue(potentialTypes, true)).mayBeExtension());
  }

  /**
   * Method under test: {@link MultiTypedReferenceValue#mayBeExtension()}
   */
  @Test
  public void testMayBeExtension2() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));

    // Act and Assert
    assertFalse((new MultiTypedReferenceValue(potentialTypes, true)).mayBeExtension());
  }

  /**
   * Method under test: {@link MultiTypedReferenceValue#mayBeExtension()}
   */
  @Test
  public void testMayBeExtension3() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, false));
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));

    // Act and Assert
    assertTrue((new MultiTypedReferenceValue(potentialTypes, true)).mayBeExtension());
  }

  /**
   * Method under test: {@link MultiTypedReferenceValue#isNull()}
   */
  @Test
  public void testIsNull() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Act and Assert
    assertEquals(0, (new MultiTypedReferenceValue(potentialTypes, true)).isNull());
  }

  /**
   * Method under test: {@link MultiTypedReferenceValue#isNull()}
   */
  @Test
  public void testIsNull2() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, false));

    // Act and Assert
    assertEquals(Value.NEVER, (new MultiTypedReferenceValue(potentialTypes, true)).isNull());
  }

  /**
   * Method under test: {@link MultiTypedReferenceValue#isNull()}
   */
  @Test
  public void testIsNull3() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Act and Assert
    assertEquals(0, (new MultiTypedReferenceValue(potentialTypes, true)).isNull());
  }

  /**
   * Method under test: {@link MultiTypedReferenceValue#isNull()}
   */
  @Test
  public void testIsNull4() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, false));
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Act and Assert
    assertEquals(0, (new MultiTypedReferenceValue(potentialTypes, true)).isNull());
  }

  /**
   * Method under test: {@link MultiTypedReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  public void testInstanceOf() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act and Assert
    assertEquals(Value.NEVER, multiTypedReferenceValue.instanceOf("Other Type", new LibraryClass()));
  }

  /**
   * Method under test: {@link MultiTypedReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  public void testInstanceOf2() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Other Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act and Assert
    assertEquals(0, multiTypedReferenceValue.instanceOf("Other Type", new LibraryClass()));
  }

  /**
   * Method under test: {@link MultiTypedReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  public void testInstanceOf3() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act and Assert
    assertEquals(Value.NEVER, multiTypedReferenceValue.instanceOf("Other Type", new LibraryClass()));
  }

  /**
   * Method under test: {@link MultiTypedReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  public void testInstanceOf4() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act and Assert
    assertEquals(Value.NEVER, multiTypedReferenceValue.instanceOf("Other Type", new LibraryClass()));
  }

  /**
   * Method under test: {@link MultiTypedReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  public void testInstanceOf5() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(Short.SIZE, "Type", "Type"), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act and Assert
    assertEquals(Value.NEVER, multiTypedReferenceValue.instanceOf("Other Type", new LibraryClass()));
  }

  /**
   * Method under test: {@link MultiTypedReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  public void testInstanceOf6() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", null, true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act and Assert
    assertEquals(0, multiTypedReferenceValue.instanceOf("Other Type", new LibraryClass()));
  }

  /**
   * Method under test: {@link MultiTypedReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  public void testInstanceOf7() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act and Assert
    assertEquals(0, multiTypedReferenceValue.instanceOf("Ljava/lang/Object;", new LibraryClass()));
  }

  /**
   * Method under test: {@link MultiTypedReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  public void testInstanceOf8() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Act and Assert
    assertEquals(0, (new MultiTypedReferenceValue(potentialTypes, true)).instanceOf("Other Type", null));
  }

  /**
   * Method under test: {@link MultiTypedReferenceValue#instanceOf(String, Clazz)}
   */
  @Test
  public void testInstanceOf9() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Other Type", new LibraryClass(), true, false));
    potentialTypes.add(new TypedReferenceValue("Other Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act and Assert
    assertEquals(0, multiTypedReferenceValue.instanceOf("Other Type", new LibraryClass()));
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  public void testCast() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCastResult = multiTypedReferenceValue.cast("Type", referencedClass,
        new ParticularReferenceValueFactory(), true);

    // Assert
    assertTrue(actualCastResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualCastResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  public void testCast2() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCastResult = multiTypedReferenceValue.cast("Type", referencedClass,
        new ParticularReferenceValueFactory(), true);

    // Assert
    assertTrue(actualCastResult instanceof MultiTypedReferenceValue);
    assertEquals("Type", actualCastResult.getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) actualCastResult).getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
    AnalyzedObject value = actualCastResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCastResult.isNotNull());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualCastResult).getPotentialTypes().size());
    assertFalse(actualCastResult.isCategory2());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(actualCastResult.isParticular());
    assertFalse(actualCastResult.isSpecific());
    assertFalse(generalizedType.isSpecific());
    assertTrue(generalizedType.mayBeExtension());
    assertTrue(((MultiTypedReferenceValue) actualCastResult).mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension);
    assertTrue(generalizedType.mayBeNull);
    assertSame(referencedClass, actualCastResult.getReferencedClass());
    assertSame(referencedClass, generalizedType.getReferencedClass());
    assertSame(value, generalizedType.getValue());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  public void testCast3() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCastResult = multiTypedReferenceValue.cast("Type", referencedClass,
        new ParticularReferenceValueFactory(), true);

    // Assert
    assertTrue(actualCastResult instanceof MultiTypedReferenceValue);
    assertEquals(multiTypedReferenceValue, actualCastResult);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  public void testCast4() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, false));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);
    LibraryClass referencedClass = new LibraryClass();

    // Act and Assert
    assertSame(multiTypedReferenceValue,
        multiTypedReferenceValue.cast("Type", referencedClass, new ParticularReferenceValueFactory(), true));
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  public void testCast5() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCastResult = multiTypedReferenceValue.cast("Type", referencedClass,
        new ParticularReferenceValueFactory(), true);

    // Assert
    assertTrue(actualCastResult instanceof MultiTypedReferenceValue);
    assertEquals("Type", actualCastResult.getType());
    AnalyzedObject value = actualCastResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCastResult.isNotNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualCastResult).getPotentialTypes().size());
    assertFalse(actualCastResult.isCategory2());
    assertFalse(actualCastResult.isParticular());
    assertFalse(actualCastResult.isSpecific());
    assertTrue(((MultiTypedReferenceValue) actualCastResult).mayBeUnknown);
    assertEquals(typedReferenceValue, ((MultiTypedReferenceValue) actualCastResult).getGeneralizedType());
    assertSame(referencedClass, actualCastResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  public void testCast6() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, false));
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", new LibraryClass(), true, true);

    potentialTypes.add(typedReferenceValue);
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCastResult = multiTypedReferenceValue.cast("Type", referencedClass,
        new ParticularReferenceValueFactory(), true);

    // Assert
    assertTrue(actualCastResult instanceof MultiTypedReferenceValue);
    assertEquals("Type", actualCastResult.getType());
    AnalyzedObject value = actualCastResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCastResult.isNotNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualCastResult).getPotentialTypes().size());
    assertFalse(actualCastResult.isCategory2());
    assertFalse(actualCastResult.isParticular());
    assertFalse(actualCastResult.isSpecific());
    assertTrue(((MultiTypedReferenceValue) actualCastResult).mayBeUnknown);
    assertEquals(typedReferenceValue, ((MultiTypedReferenceValue) actualCastResult).getGeneralizedType());
    assertSame(referencedClass, actualCastResult.getReferencedClass());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  public void testCast7() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("", null, true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCastResult = multiTypedReferenceValue.cast("Type", referencedClass,
        new ParticularReferenceValueFactory(), true);

    // Assert
    assertTrue(actualCastResult instanceof MultiTypedReferenceValue);
    assertEquals("Type", actualCastResult.getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) actualCastResult).getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
    AnalyzedObject value = actualCastResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCastResult.isNotNull());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualCastResult).getPotentialTypes().size());
    assertFalse(actualCastResult.isCategory2());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(actualCastResult.isParticular());
    assertFalse(actualCastResult.isSpecific());
    assertFalse(generalizedType.isSpecific());
    assertTrue(generalizedType.mayBeExtension());
    assertTrue(((MultiTypedReferenceValue) actualCastResult).mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension);
    assertTrue(generalizedType.mayBeNull);
    assertSame(referencedClass, actualCastResult.getReferencedClass());
    assertSame(referencedClass, generalizedType.getReferencedClass());
    assertSame(value, generalizedType.getValue());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  public void testCast8() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("", new LibraryClass(), true, false));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCastResult = multiTypedReferenceValue.cast("Type", referencedClass,
        new ParticularReferenceValueFactory(), true);

    // Assert
    assertTrue(actualCastResult instanceof MultiTypedReferenceValue);
    assertEquals("Type", actualCastResult.getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) actualCastResult).getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
    AnalyzedObject value = actualCastResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, ((MultiTypedReferenceValue) actualCastResult).getPotentialTypes().size());
    assertEquals(1, actualCastResult.isNotNull());
    assertEquals(1, generalizedType.isNotNull());
    assertFalse(actualCastResult.isCategory2());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(actualCastResult.isParticular());
    assertFalse(actualCastResult.isSpecific());
    assertFalse(generalizedType.isSpecific());
    assertFalse(generalizedType.mayBeNull);
    assertTrue(generalizedType.mayBeExtension());
    assertTrue(((MultiTypedReferenceValue) actualCastResult).mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension);
    assertEquals(Value.NEVER, generalizedType.isNull());
    assertSame(referencedClass, actualCastResult.getReferencedClass());
    assertSame(referencedClass, generalizedType.getReferencedClass());
    assertSame(value, generalizedType.getValue());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  public void testCast9() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act
    ReferenceValue actualCastResult = multiTypedReferenceValue.cast("Type", null, new ParticularReferenceValueFactory(),
        true);

    // Assert
    assertTrue(actualCastResult instanceof MultiTypedReferenceValue);
    assertEquals("Type", actualCastResult.getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) actualCastResult).getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
    AnalyzedObject value = actualCastResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualCastResult.getReferencedClass());
    assertNull(generalizedType.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCastResult.isNotNull());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualCastResult).getPotentialTypes().size());
    assertFalse(actualCastResult.isCategory2());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(actualCastResult.isParticular());
    assertFalse(actualCastResult.isSpecific());
    assertFalse(generalizedType.isSpecific());
    assertTrue(generalizedType.mayBeExtension());
    assertTrue(((MultiTypedReferenceValue) actualCastResult).mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension);
    assertTrue(generalizedType.mayBeNull);
    assertSame(value, generalizedType.getValue());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#cast(String, Clazz, ValueFactory, boolean)}
   */
  @Test
  public void testCast10() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, false));
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);
    LibraryClass referencedClass = new LibraryClass();

    // Act
    ReferenceValue actualCastResult = multiTypedReferenceValue.cast("Type", referencedClass,
        new ParticularReferenceValueFactory(), true);

    // Assert
    assertTrue(actualCastResult instanceof MultiTypedReferenceValue);
    assertEquals("Type", actualCastResult.getType());
    TypedReferenceValue generalizedType = ((MultiTypedReferenceValue) actualCastResult).getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
    AnalyzedObject value = actualCastResult.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualCastResult.isNotNull());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertEquals(1, ((MultiTypedReferenceValue) actualCastResult).getPotentialTypes().size());
    assertFalse(actualCastResult.isCategory2());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(actualCastResult.isParticular());
    assertFalse(actualCastResult.isSpecific());
    assertFalse(generalizedType.isSpecific());
    assertTrue(generalizedType.mayBeExtension());
    assertTrue(((MultiTypedReferenceValue) actualCastResult).mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension);
    assertTrue(generalizedType.mayBeNull);
    assertSame(referencedClass, actualCastResult.getReferencedClass());
    assertSame(referencedClass, generalizedType.getReferencedClass());
    assertSame(value, generalizedType.getValue());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#referenceArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  public void testReferenceArrayLoad() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(valueFactory.REFERENCE_VALUE,
        multiTypedReferenceValue.referenceArrayLoad(BasicRangeValueFactory.INTEGER_VALUE_BYTE, valueFactory));
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#referenceArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  public void testReferenceArrayLoad2() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(valueFactory.REFERENCE_VALUE,
        multiTypedReferenceValue.referenceArrayLoad(BasicRangeValueFactory.INTEGER_VALUE_BYTE, valueFactory));
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#referenceArrayLoad(IntegerValue, ValueFactory)}
   */
  @Test
  public void testReferenceArrayLoad3() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);
    ParticularReferenceValueFactory valueFactory = new ParticularReferenceValueFactory();

    // Act and Assert
    assertSame(valueFactory.REFERENCE_VALUE,
        multiTypedReferenceValue.referenceArrayLoad(BasicRangeValueFactory.INTEGER_VALUE_BYTE, valueFactory));
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#equal(MultiTypedReferenceValue)}
   */
  @Test
  public void testEqual() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Act and Assert
    assertEquals(0, multiTypedReferenceValue.equal(new MultiTypedReferenceValue(potentialTypes2, true)));
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#equal(MultiTypedReferenceValue)}
   */
  @Test
  public void testEqual2() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Act and Assert
    assertEquals(0, multiTypedReferenceValue.equal(new MultiTypedReferenceValue(potentialTypes2, true)));
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#equal(MultiTypedReferenceValue)}
   */
  @Test
  public void testEqual3() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));

    // Act and Assert
    assertEquals(0, multiTypedReferenceValue.equal(new MultiTypedReferenceValue(potentialTypes2, true)));
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#equal(MultiTypedReferenceValue)}
   */
  @Test
  public void testEqual4() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), false, true));
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue("", new LibraryClass(), false, true));

    // Act and Assert
    assertEquals(0, multiTypedReferenceValue.equal(new MultiTypedReferenceValue(potentialTypes2, true)));
  }

  /**
   * Method under test: {@link MultiTypedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual5() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Act and Assert
    assertEquals(0, (new MultiTypedReferenceValue(potentialTypes, true)).equal(BasicValueFactory.REFERENCE_VALUE));
  }

  /**
   * Method under test: {@link MultiTypedReferenceValue#equal(ReferenceValue)}
   */
  @Test
  public void testEqual6() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Act and Assert
    assertEquals(0, multiTypedReferenceValue.equal((ReferenceValue) new MultiTypedReferenceValue(
        new TypedReferenceValue("Type", new LibraryClass(), true, true), true)));
  }

  /**
   * Method under test: {@link MultiTypedReferenceValue#internalType()}
   */
  @Test
  public void testInternalType() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Act and Assert
    assertEquals("Type", (new MultiTypedReferenceValue(potentialTypes, true)).internalType());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MultiTypedReferenceValue#equals(Object)}
   *   <li>{@link MultiTypedReferenceValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue2 = new MultiTypedReferenceValue(potentialTypes2, true);

    // Act and Assert
    assertEquals(multiTypedReferenceValue, multiTypedReferenceValue2);
    int expectedHashCodeResult = multiTypedReferenceValue.hashCode();
    assertEquals(expectedHashCodeResult, multiTypedReferenceValue2.hashCode());
  }

  /**
   * Method under test: {@link MultiTypedReferenceValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue(null, new LibraryClass(), true, true));

    // Act and Assert
    assertNotEquals(multiTypedReferenceValue, new MultiTypedReferenceValue(potentialTypes2, true));
  }

  /**
   * Method under test: {@link MultiTypedReferenceValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    MultiTypedReferenceValue multiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, false);

    HashSet<TypedReferenceValue> potentialTypes2 = new HashSet<>();
    potentialTypes2.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Act and Assert
    assertNotEquals(multiTypedReferenceValue, new MultiTypedReferenceValue(potentialTypes2, true));
  }

  /**
   * Method under test: {@link MultiTypedReferenceValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Act and Assert
    assertNotEquals(new MultiTypedReferenceValue(potentialTypes, true), 1);
  }

  /**
   * Method under test: {@link MultiTypedReferenceValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));

    // Act and Assert
    assertNotEquals(new MultiTypedReferenceValue(potentialTypes, true), null);
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}
   */
  @Test
  public void testNewMultiTypedReferenceValue() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new MultiTypedReferenceValue(new HashSet<>(), true));

  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}
   */
  @Test
  public void testNewMultiTypedReferenceValue2() {
    // Arrange
    LinkedHashSet<TypedReferenceValue> potentialTypes = new LinkedHashSet<>();
    LibraryClass referencedClass = new LibraryClass();
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", referencedClass, true, true);

    potentialTypes.add(typedReferenceValue);

    // Act
    MultiTypedReferenceValue actualMultiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Assert
    assertEquals("Type", actualMultiTypedReferenceValue.getType());
    AnalyzedObject value = actualMultiTypedReferenceValue.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualMultiTypedReferenceValue.isNotNull());
    assertEquals(1, actualMultiTypedReferenceValue.getPotentialTypes().size());
    assertFalse(actualMultiTypedReferenceValue.isCategory2());
    assertFalse(actualMultiTypedReferenceValue.isParticular());
    assertFalse(actualMultiTypedReferenceValue.isSpecific());
    assertTrue(actualMultiTypedReferenceValue.mayBeUnknown);
    assertSame(referencedClass, actualMultiTypedReferenceValue.getReferencedClass());
    assertSame(typedReferenceValue, actualMultiTypedReferenceValue.getGeneralizedType());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}
   */
  @Test
  public void testNewMultiTypedReferenceValue3() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    LibraryClass referencedClass = new LibraryClass();
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue(
        "MultiTypedReferenceValue created with an empty set of types as its input. This is unexpected and the"
            + " code would crash if not fixed.",
        referencedClass, false, true);

    potentialTypes.add(typedReferenceValue);

    // Act
    MultiTypedReferenceValue actualMultiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Assert
    assertEquals("MultiTypedReferenceValue created with an empty set of types as its input. This is unexpected and the"
        + " code would crash if not fixed.", actualMultiTypedReferenceValue.getType());
    AnalyzedObject value = actualMultiTypedReferenceValue.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualMultiTypedReferenceValue.isNotNull());
    assertEquals(1, actualMultiTypedReferenceValue.getPotentialTypes().size());
    assertFalse(actualMultiTypedReferenceValue.isCategory2());
    assertFalse(actualMultiTypedReferenceValue.isParticular());
    assertFalse(actualMultiTypedReferenceValue.isSpecific());
    assertTrue(actualMultiTypedReferenceValue.mayBeUnknown);
    assertSame(referencedClass, actualMultiTypedReferenceValue.getReferencedClass());
    assertSame(typedReferenceValue, actualMultiTypedReferenceValue.getGeneralizedType());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}
   */
  @Test
  public void testNewMultiTypedReferenceValue4() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    LibraryClass referencedClass = new LibraryClass();
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue(
        "MultiTypedReferenceValue created with an empty set of types as its input. This is unexpected and the"
            + " code would crash if not fixed.",
        referencedClass, true, false);

    potentialTypes.add(typedReferenceValue);

    // Act
    MultiTypedReferenceValue actualMultiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Assert
    assertEquals("MultiTypedReferenceValue created with an empty set of types as its input. This is unexpected and the"
        + " code would crash if not fixed.", actualMultiTypedReferenceValue.getType());
    AnalyzedObject value = actualMultiTypedReferenceValue.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualMultiTypedReferenceValue.getPotentialTypes().size());
    assertEquals(1, actualMultiTypedReferenceValue.isNotNull());
    assertFalse(actualMultiTypedReferenceValue.isCategory2());
    assertFalse(actualMultiTypedReferenceValue.isParticular());
    assertFalse(actualMultiTypedReferenceValue.isSpecific());
    assertTrue(actualMultiTypedReferenceValue.mayBeUnknown);
    assertSame(referencedClass, actualMultiTypedReferenceValue.getReferencedClass());
    assertSame(typedReferenceValue, actualMultiTypedReferenceValue.getGeneralizedType());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}
   */
  @Test
  public void testNewMultiTypedReferenceValue5() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    LibraryClass referencedClass = new LibraryClass();
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue(null, referencedClass, false, true);

    potentialTypes.add(typedReferenceValue);

    // Act
    MultiTypedReferenceValue actualMultiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Assert
    AnalyzedObject value = actualMultiTypedReferenceValue.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualMultiTypedReferenceValue.getType());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualMultiTypedReferenceValue.getPotentialTypes().size());
    assertFalse(actualMultiTypedReferenceValue.isCategory2());
    assertFalse(actualMultiTypedReferenceValue.isParticular());
    assertFalse(actualMultiTypedReferenceValue.isSpecific());
    assertTrue(actualMultiTypedReferenceValue.mayBeUnknown);
    assertEquals(Value.NEVER, actualMultiTypedReferenceValue.isNotNull());
    assertSame(referencedClass, actualMultiTypedReferenceValue.getReferencedClass());
    assertSame(typedReferenceValue, actualMultiTypedReferenceValue.getGeneralizedType());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}
   */
  @Test
  public void testNewMultiTypedReferenceValue6() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    LibraryClass referencedClass = new LibraryClass();
    ArrayReferenceValue arrayReferenceValue = new ArrayReferenceValue("Type", referencedClass, true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE);

    potentialTypes.add(arrayReferenceValue);

    // Act
    MultiTypedReferenceValue actualMultiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Assert
    assertEquals("Type", actualMultiTypedReferenceValue.getType());
    AnalyzedObject value = actualMultiTypedReferenceValue.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualMultiTypedReferenceValue.getPotentialTypes().size());
    assertEquals(1, actualMultiTypedReferenceValue.isNotNull());
    assertFalse(actualMultiTypedReferenceValue.isCategory2());
    assertFalse(actualMultiTypedReferenceValue.isParticular());
    assertFalse(actualMultiTypedReferenceValue.isSpecific());
    assertTrue(actualMultiTypedReferenceValue.mayBeUnknown);
    assertSame(referencedClass, actualMultiTypedReferenceValue.getReferencedClass());
    assertSame(arrayReferenceValue, actualMultiTypedReferenceValue.getGeneralizedType());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}
   */
  @Test
  public void testNewMultiTypedReferenceValue7() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", null, true, true));
    potentialTypes.add(new TypedReferenceValue(
        "MultiTypedReferenceValue created with an empty set of types as its input. This is unexpected and the"
            + " code would crash if not fixed.",
        new LibraryClass(), false, true));

    // Act
    MultiTypedReferenceValue actualMultiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Assert
    assertEquals("Ljava/lang/Object;", actualMultiTypedReferenceValue.getType());
    TypedReferenceValue generalizedType = actualMultiTypedReferenceValue.getGeneralizedType();
    assertEquals("Ljava/lang/Object;", generalizedType.getType());
    AnalyzedObject value = actualMultiTypedReferenceValue.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualMultiTypedReferenceValue.getReferencedClass());
    assertNull(generalizedType.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualMultiTypedReferenceValue.isNotNull());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertFalse(actualMultiTypedReferenceValue.isCategory2());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(actualMultiTypedReferenceValue.isParticular());
    assertFalse(actualMultiTypedReferenceValue.isSpecific());
    assertFalse(generalizedType.isSpecific());
    assertTrue(generalizedType.mayBeExtension());
    assertTrue(actualMultiTypedReferenceValue.mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension);
    assertTrue(generalizedType.mayBeNull);
    assertEquals(potentialTypes, actualMultiTypedReferenceValue.getPotentialTypes());
    assertSame(value, generalizedType.getValue());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}
   */
  @Test
  public void testNewMultiTypedReferenceValue8() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(null);
    LibraryClass referencedClass = new LibraryClass();
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue(
        "MultiTypedReferenceValue created with an empty set of types as its input. This is unexpected and the"
            + " code would crash if not fixed.",
        referencedClass, false, true);

    potentialTypes.add(typedReferenceValue);

    // Act
    MultiTypedReferenceValue actualMultiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Assert
    assertEquals("MultiTypedReferenceValue created with an empty set of types as its input. This is unexpected and the"
        + " code would crash if not fixed.", actualMultiTypedReferenceValue.getType());
    AnalyzedObject value = actualMultiTypedReferenceValue.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertFalse(actualMultiTypedReferenceValue.isCategory2());
    assertFalse(actualMultiTypedReferenceValue.isParticular());
    assertFalse(actualMultiTypedReferenceValue.isSpecific());
    assertTrue(actualMultiTypedReferenceValue.mayBeUnknown);
    assertEquals(potentialTypes, actualMultiTypedReferenceValue.getPotentialTypes());
    assertSame(referencedClass, actualMultiTypedReferenceValue.getReferencedClass());
    assertSame(typedReferenceValue, actualMultiTypedReferenceValue.getGeneralizedType());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}
   */
  @Test
  public void testNewMultiTypedReferenceValue9() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", new LibraryClass(), true, true));
    potentialTypes.add(new TypedReferenceValue(
        "MultiTypedReferenceValue created with an empty set of types as its input. This is unexpected and the"
            + " code would crash if not fixed.",
        null, false, true));

    // Act
    MultiTypedReferenceValue actualMultiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Assert
    assertEquals("Ljava/lang/Object;", actualMultiTypedReferenceValue.getType());
    TypedReferenceValue generalizedType = actualMultiTypedReferenceValue.getGeneralizedType();
    assertEquals("Ljava/lang/Object;", generalizedType.getType());
    AnalyzedObject value = actualMultiTypedReferenceValue.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualMultiTypedReferenceValue.getReferencedClass());
    assertNull(generalizedType.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualMultiTypedReferenceValue.isNotNull());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertFalse(actualMultiTypedReferenceValue.isCategory2());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(actualMultiTypedReferenceValue.isParticular());
    assertFalse(actualMultiTypedReferenceValue.isSpecific());
    assertFalse(generalizedType.isSpecific());
    assertTrue(generalizedType.mayBeExtension());
    assertTrue(actualMultiTypedReferenceValue.mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension);
    assertTrue(generalizedType.mayBeNull);
    assertEquals(potentialTypes, actualMultiTypedReferenceValue.getPotentialTypes());
    assertSame(value, generalizedType.getValue());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}
   */
  @Test
  public void testNewMultiTypedReferenceValue10() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    LibraryClass referencedClass = new LibraryClass();
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", referencedClass, true, true);

    potentialTypes.add(typedReferenceValue);
    potentialTypes
        .add(new ArrayReferenceValue("Type", new LibraryClass(), true, BasicRangeValueFactory.INTEGER_VALUE_BYTE));

    // Act
    MultiTypedReferenceValue actualMultiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Assert
    assertEquals("Type", actualMultiTypedReferenceValue.getType());
    AnalyzedObject value = actualMultiTypedReferenceValue.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualMultiTypedReferenceValue.isNotNull());
    assertFalse(actualMultiTypedReferenceValue.isCategory2());
    assertFalse(actualMultiTypedReferenceValue.isParticular());
    assertFalse(actualMultiTypedReferenceValue.isSpecific());
    assertTrue(actualMultiTypedReferenceValue.mayBeUnknown);
    assertEquals(potentialTypes, actualMultiTypedReferenceValue.getPotentialTypes());
    assertSame(referencedClass, actualMultiTypedReferenceValue.getReferencedClass());
    assertSame(typedReferenceValue, actualMultiTypedReferenceValue.getGeneralizedType());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}
   */
  @Test
  public void testNewMultiTypedReferenceValue11() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    LibraryClass referencedClass = new LibraryClass();
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", referencedClass, true, true);

    potentialTypes.add(typedReferenceValue);
    potentialTypes.add(new TypedReferenceValue(null, new LibraryClass(), false, true));

    // Act
    MultiTypedReferenceValue actualMultiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Assert
    assertEquals("Type", actualMultiTypedReferenceValue.getType());
    AnalyzedObject value = actualMultiTypedReferenceValue.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualMultiTypedReferenceValue.isNotNull());
    assertFalse(actualMultiTypedReferenceValue.isCategory2());
    assertFalse(actualMultiTypedReferenceValue.isParticular());
    assertFalse(actualMultiTypedReferenceValue.isSpecific());
    assertTrue(actualMultiTypedReferenceValue.mayBeUnknown);
    assertEquals(potentialTypes, actualMultiTypedReferenceValue.getPotentialTypes());
    assertSame(referencedClass, actualMultiTypedReferenceValue.getReferencedClass());
    assertSame(typedReferenceValue, actualMultiTypedReferenceValue.getGeneralizedType());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}
   */
  @Test
  public void testNewMultiTypedReferenceValue12() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    LibraryClass referencedClass = new LibraryClass();
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("", referencedClass, true, true);

    potentialTypes.add(typedReferenceValue);
    potentialTypes.add(new TypedReferenceValue(null, new LibraryClass(), false, true));

    // Act
    MultiTypedReferenceValue actualMultiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Assert
    assertEquals("", actualMultiTypedReferenceValue.getType());
    AnalyzedObject value = actualMultiTypedReferenceValue.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualMultiTypedReferenceValue.isNotNull());
    assertFalse(actualMultiTypedReferenceValue.isCategory2());
    assertFalse(actualMultiTypedReferenceValue.isParticular());
    assertFalse(actualMultiTypedReferenceValue.isSpecific());
    assertTrue(actualMultiTypedReferenceValue.mayBeUnknown);
    assertEquals(potentialTypes, actualMultiTypedReferenceValue.getPotentialTypes());
    assertSame(referencedClass, actualMultiTypedReferenceValue.getReferencedClass());
    assertSame(typedReferenceValue, actualMultiTypedReferenceValue.getGeneralizedType());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}
   */
  @Test
  public void testNewMultiTypedReferenceValue13() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    LibraryClass referencedClass = new LibraryClass();
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("42", referencedClass, true, true);

    potentialTypes.add(typedReferenceValue);
    potentialTypes.add(new TypedReferenceValue(null, new LibraryClass(), false, true));

    // Act
    MultiTypedReferenceValue actualMultiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Assert
    assertEquals("42", actualMultiTypedReferenceValue.getType());
    AnalyzedObject value = actualMultiTypedReferenceValue.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualMultiTypedReferenceValue.isNotNull());
    assertFalse(actualMultiTypedReferenceValue.isCategory2());
    assertFalse(actualMultiTypedReferenceValue.isParticular());
    assertFalse(actualMultiTypedReferenceValue.isSpecific());
    assertTrue(actualMultiTypedReferenceValue.mayBeUnknown);
    assertEquals(potentialTypes, actualMultiTypedReferenceValue.getPotentialTypes());
    assertSame(referencedClass, actualMultiTypedReferenceValue.getReferencedClass());
    assertSame(typedReferenceValue, actualMultiTypedReferenceValue.getGeneralizedType());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}
   */
  @Test
  public void testNewMultiTypedReferenceValue14() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    LibraryClass referencedClass = new LibraryClass();
    potentialTypes.add(new TypedReferenceValue("Type", referencedClass, true, false));
    potentialTypes.add(new TypedReferenceValue(null, new LibraryClass(), false, true));

    // Act
    MultiTypedReferenceValue actualMultiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Assert
    assertEquals("Type", actualMultiTypedReferenceValue.getType());
    TypedReferenceValue generalizedType = actualMultiTypedReferenceValue.getGeneralizedType();
    assertEquals("Type", generalizedType.getType());
    AnalyzedObject value = actualMultiTypedReferenceValue.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualMultiTypedReferenceValue.isNotNull());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertFalse(actualMultiTypedReferenceValue.isCategory2());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(actualMultiTypedReferenceValue.isParticular());
    assertFalse(actualMultiTypedReferenceValue.isSpecific());
    assertFalse(generalizedType.isSpecific());
    assertTrue(generalizedType.mayBeExtension());
    assertTrue(actualMultiTypedReferenceValue.mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension);
    assertTrue(generalizedType.mayBeNull);
    assertEquals(potentialTypes, actualMultiTypedReferenceValue.getPotentialTypes());
    assertSame(referencedClass, actualMultiTypedReferenceValue.getReferencedClass());
    assertSame(referencedClass, generalizedType.getReferencedClass());
    assertSame(value, generalizedType.getValue());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}
   */
  @Test
  public void testNewMultiTypedReferenceValue15() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Ljava/lang/Object;", null, true, true);

    potentialTypes.add(typedReferenceValue);
    potentialTypes.add(new TypedReferenceValue(
        "MultiTypedReferenceValue created with an empty set of types as its input. This is unexpected and the"
            + " code would crash if not fixed.",
        new LibraryClass(), false, true));

    // Act
    MultiTypedReferenceValue actualMultiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Assert
    assertEquals("Ljava/lang/Object;", actualMultiTypedReferenceValue.getType());
    AnalyzedObject value = actualMultiTypedReferenceValue.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualMultiTypedReferenceValue.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualMultiTypedReferenceValue.isNotNull());
    assertFalse(actualMultiTypedReferenceValue.isCategory2());
    assertFalse(actualMultiTypedReferenceValue.isParticular());
    assertFalse(actualMultiTypedReferenceValue.isSpecific());
    assertTrue(actualMultiTypedReferenceValue.mayBeUnknown);
    assertEquals(potentialTypes, actualMultiTypedReferenceValue.getPotentialTypes());
    assertSame(typedReferenceValue, actualMultiTypedReferenceValue.getGeneralizedType());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}
   */
  @Test
  public void testNewMultiTypedReferenceValue16() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    potentialTypes.add(new TypedReferenceValue("Type", null, false, true));
    potentialTypes.add(new TypedReferenceValue(
        "MultiTypedReferenceValue created with an empty set of types as its input. This is unexpected and the"
            + " code would crash if not fixed.",
        new LibraryClass(), false, true));

    // Act
    MultiTypedReferenceValue actualMultiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Assert
    assertEquals("Ljava/lang/Object;", actualMultiTypedReferenceValue.getType());
    TypedReferenceValue generalizedType = actualMultiTypedReferenceValue.getGeneralizedType();
    assertEquals("Ljava/lang/Object;", generalizedType.getType());
    AnalyzedObject value = actualMultiTypedReferenceValue.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualMultiTypedReferenceValue.getReferencedClass());
    assertNull(generalizedType.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualMultiTypedReferenceValue.isNotNull());
    assertEquals(0, generalizedType.isNotNull());
    assertEquals(0, generalizedType.isNull());
    assertFalse(actualMultiTypedReferenceValue.isCategory2());
    assertFalse(generalizedType.isCategory2());
    assertFalse(generalizedType.isParticular());
    assertFalse(actualMultiTypedReferenceValue.isParticular());
    assertFalse(actualMultiTypedReferenceValue.isSpecific());
    assertFalse(generalizedType.isSpecific());
    assertTrue(generalizedType.mayBeExtension());
    assertTrue(actualMultiTypedReferenceValue.mayBeUnknown);
    assertTrue(generalizedType.mayBeExtension);
    assertTrue(generalizedType.mayBeNull);
    assertEquals(potentialTypes, actualMultiTypedReferenceValue.getPotentialTypes());
    assertSame(value, generalizedType.getValue());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#MultiTypedReferenceValue(Set, boolean)}
   */
  @Test
  public void testNewMultiTypedReferenceValue17() {
    // Arrange
    HashSet<TypedReferenceValue> potentialTypes = new HashSet<>();
    TypedReferenceValue typedReferenceValue = new TypedReferenceValue("Type", null, true, true);

    potentialTypes.add(typedReferenceValue);
    LibraryClass referencedClass = new LibraryClass();
    potentialTypes.add(new IdentifiedArrayReferenceValue("Type", referencedClass, true,
        BasicRangeValueFactory.INTEGER_VALUE_BYTE, new ParticularReferenceValueFactory(), 1));

    // Act
    MultiTypedReferenceValue actualMultiTypedReferenceValue = new MultiTypedReferenceValue(potentialTypes, true);

    // Assert
    assertEquals("Type", actualMultiTypedReferenceValue.getType());
    AnalyzedObject value = actualMultiTypedReferenceValue.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualMultiTypedReferenceValue.getReferencedClass());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualMultiTypedReferenceValue.isNotNull());
    assertFalse(actualMultiTypedReferenceValue.isCategory2());
    assertFalse(actualMultiTypedReferenceValue.isParticular());
    assertFalse(actualMultiTypedReferenceValue.isSpecific());
    assertTrue(actualMultiTypedReferenceValue.mayBeUnknown);
    assertEquals(potentialTypes, actualMultiTypedReferenceValue.getPotentialTypes());
    assertSame(typedReferenceValue, actualMultiTypedReferenceValue.getGeneralizedType());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#MultiTypedReferenceValue(TypedReferenceValue, boolean)}
   */
  @Test
  public void testNewMultiTypedReferenceValue18() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    TypedReferenceValue type = new TypedReferenceValue("Type", referencedClass, true, true);

    // Act
    MultiTypedReferenceValue actualMultiTypedReferenceValue = new MultiTypedReferenceValue(type, true);

    // Assert
    assertEquals("Type", actualMultiTypedReferenceValue.getType());
    AnalyzedObject value = actualMultiTypedReferenceValue.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualMultiTypedReferenceValue.isNotNull());
    assertEquals(1, actualMultiTypedReferenceValue.getPotentialTypes().size());
    assertFalse(actualMultiTypedReferenceValue.isCategory2());
    assertFalse(actualMultiTypedReferenceValue.isParticular());
    assertFalse(actualMultiTypedReferenceValue.isSpecific());
    assertTrue(actualMultiTypedReferenceValue.mayBeUnknown);
    assertSame(referencedClass, actualMultiTypedReferenceValue.getReferencedClass());
    assertSame(type, actualMultiTypedReferenceValue.getGeneralizedType());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#MultiTypedReferenceValue(TypedReferenceValue, boolean)}
   */
  @Test
  public void testNewMultiTypedReferenceValue19() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    TypedReferenceValue type = new TypedReferenceValue("Type", referencedClass, false, true);

    // Act
    MultiTypedReferenceValue actualMultiTypedReferenceValue = new MultiTypedReferenceValue(type, true);

    // Assert
    assertEquals("Type", actualMultiTypedReferenceValue.getType());
    AnalyzedObject value = actualMultiTypedReferenceValue.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(0, actualMultiTypedReferenceValue.isNotNull());
    assertEquals(1, actualMultiTypedReferenceValue.getPotentialTypes().size());
    assertFalse(actualMultiTypedReferenceValue.isCategory2());
    assertFalse(actualMultiTypedReferenceValue.isParticular());
    assertFalse(actualMultiTypedReferenceValue.isSpecific());
    assertTrue(actualMultiTypedReferenceValue.mayBeUnknown);
    assertSame(referencedClass, actualMultiTypedReferenceValue.getReferencedClass());
    assertSame(type, actualMultiTypedReferenceValue.getGeneralizedType());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#MultiTypedReferenceValue(TypedReferenceValue, boolean)}
   */
  @Test
  public void testNewMultiTypedReferenceValue20() {
    // Arrange
    LibraryClass referencedClass = new LibraryClass();
    TypedReferenceValue type = new TypedReferenceValue("Type", referencedClass, true, false);

    // Act
    MultiTypedReferenceValue actualMultiTypedReferenceValue = new MultiTypedReferenceValue(type, true);

    // Assert
    assertEquals("Type", actualMultiTypedReferenceValue.getType());
    AnalyzedObject value = actualMultiTypedReferenceValue.getValue();
    assertNull(value.getPreciseValue());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualMultiTypedReferenceValue.getPotentialTypes().size());
    assertEquals(1, actualMultiTypedReferenceValue.isNotNull());
    assertFalse(actualMultiTypedReferenceValue.isCategory2());
    assertFalse(actualMultiTypedReferenceValue.isParticular());
    assertFalse(actualMultiTypedReferenceValue.isSpecific());
    assertTrue(actualMultiTypedReferenceValue.mayBeUnknown);
    assertSame(referencedClass, actualMultiTypedReferenceValue.getReferencedClass());
    assertSame(type, actualMultiTypedReferenceValue.getGeneralizedType());
  }

  /**
   * Method under test:
   * {@link MultiTypedReferenceValue#MultiTypedReferenceValue(TypedReferenceValue, boolean)}
   */
  @Test
  public void testNewMultiTypedReferenceValue21() {
    // Arrange and Act
    MultiTypedReferenceValue actualMultiTypedReferenceValue = new MultiTypedReferenceValue((TypedReferenceValue) null,
        true);

    // Assert
    AnalyzedObject value = actualMultiTypedReferenceValue.getValue();
    assertNull(value.getPreciseValue());
    assertNull(actualMultiTypedReferenceValue.getGeneralizedType());
    assertNull(value.getModeledOrNullValue());
    assertEquals(1, actualMultiTypedReferenceValue.getPotentialTypes().size());
    assertFalse(actualMultiTypedReferenceValue.isCategory2());
    assertFalse(actualMultiTypedReferenceValue.isParticular());
    assertFalse(actualMultiTypedReferenceValue.isSpecific());
    assertTrue(actualMultiTypedReferenceValue.mayBeUnknown);
  }
}
