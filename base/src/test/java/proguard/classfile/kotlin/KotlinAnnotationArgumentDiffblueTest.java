package proguard.classfile.kotlin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class KotlinAnnotationArgumentDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link KotlinAnnotationArgument.AnnotationValue#equals(Object)}
   *   <li>{@link KotlinAnnotationArgument.AnnotationValue#hashCode()}
   * </ul>
   */
  @Test
  public void testAnnotationValueEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    KotlinAnnotationArgument.AnnotationValue annotationValue = new KotlinAnnotationArgument.AnnotationValue(
        new KotlinAnnotation("Class Name"));
    KotlinAnnotationArgument.AnnotationValue annotationValue2 = new KotlinAnnotationArgument.AnnotationValue(
        new KotlinAnnotation("Class Name"));

    // Act and Assert
    assertEquals(annotationValue, annotationValue2);
    int expectedHashCodeResult = annotationValue.hashCode();
    assertEquals(expectedHashCodeResult, annotationValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link KotlinAnnotationArgument.AnnotationValue#equals(Object)}
   *   <li>{@link KotlinAnnotationArgument.AnnotationValue#hashCode()}
   * </ul>
   */
  @Test
  public void testAnnotationValueEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    KotlinAnnotationArgument.AnnotationValue annotationValue = new KotlinAnnotationArgument.AnnotationValue(
        new KotlinAnnotation("Class Name"));

    // Act and Assert
    assertEquals(annotationValue, annotationValue);
    int expectedHashCodeResult = annotationValue.hashCode();
    assertEquals(expectedHashCodeResult, annotationValue.hashCode());
  }

  /**
   * Method under test:
   * {@link KotlinAnnotationArgument.AnnotationValue#equals(Object)}
   */
  @Test
  public void testAnnotationValueEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    KotlinAnnotationArgument.AnnotationValue annotationValue = new KotlinAnnotationArgument.AnnotationValue(
        new KotlinAnnotation("proguard.classfile.kotlin.KotlinAnnotation"));

    // Act and Assert
    assertNotEquals(annotationValue, new KotlinAnnotationArgument.AnnotationValue(new KotlinAnnotation("Class Name")));
  }

  /**
   * Method under test:
   * {@link KotlinAnnotationArgument.AnnotationValue#equals(Object)}
   */
  @Test
  public void testAnnotationValueEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new KotlinAnnotationArgument.AnnotationValue(new KotlinAnnotation("Class Name")), null);
  }

  /**
   * Method under test:
   * {@link KotlinAnnotationArgument.AnnotationValue#equals(Object)}
   */
  @Test
  public void testAnnotationValueEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new KotlinAnnotationArgument.AnnotationValue(new KotlinAnnotation("Class Name")),
        "Different type to AnnotationValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link KotlinAnnotationArgument.AnnotationValue#AnnotationValue(KotlinAnnotation)}
   *   <li>{@link KotlinAnnotationArgument.AnnotationValue#toString()}
   * </ul>
   */
  @Test
  public void testAnnotationValueGettersAndSetters() {
    // Arrange and Act
    KotlinAnnotationArgument.AnnotationValue actualAnnotationValue = new KotlinAnnotationArgument.AnnotationValue(
        new KotlinAnnotation("Class Name"));

    // Assert
    assertEquals("Class Name()", actualAnnotationValue.toString());
    KotlinAnnotation kotlinAnnotation = actualAnnotationValue.kotlinMetadataAnnotation;
    assertNull(kotlinAnnotation.getProcessingInfo());
    assertEquals(0, kotlinAnnotation.getProcessingFlags());
    assertTrue(kotlinAnnotation.arguments.isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link KotlinAnnotationArgument.ArrayValue#equals(Object)}
   *   <li>{@link KotlinAnnotationArgument.ArrayValue#hashCode()}
   * </ul>
   */
  @Test
  public void testArrayValueEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    KotlinAnnotationArgument.ArrayValue arrayValue = new KotlinAnnotationArgument.ArrayValue(new ArrayList<>());
    KotlinAnnotationArgument.ArrayValue arrayValue2 = new KotlinAnnotationArgument.ArrayValue(new ArrayList<>());

    // Act and Assert
    assertEquals(arrayValue, arrayValue2);
    int expectedHashCodeResult = arrayValue.hashCode();
    assertEquals(expectedHashCodeResult, arrayValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link KotlinAnnotationArgument.ArrayValue#equals(Object)}
   *   <li>{@link KotlinAnnotationArgument.ArrayValue#hashCode()}
   * </ul>
   */
  @Test
  public void testArrayValueEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    KotlinAnnotationArgument.ArrayValue arrayValue = new KotlinAnnotationArgument.ArrayValue(new ArrayList<>());

    // Act and Assert
    assertEquals(arrayValue, arrayValue);
    int expectedHashCodeResult = arrayValue.hashCode();
    assertEquals(expectedHashCodeResult, arrayValue.hashCode());
  }

  /**
   * Method under test: {@link KotlinAnnotationArgument.ArrayValue#equals(Object)}
   */
  @Test
  public void testArrayValueEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<KotlinAnnotationArgument.Value> elements = new ArrayList<>();
    elements.add(new KotlinAnnotationArgument.BooleanValue(true));
    KotlinAnnotationArgument.ArrayValue arrayValue = new KotlinAnnotationArgument.ArrayValue(elements);

    // Act and Assert
    assertNotEquals(arrayValue, new KotlinAnnotationArgument.ArrayValue(new ArrayList<>()));
  }

  /**
   * Method under test: {@link KotlinAnnotationArgument.ArrayValue#equals(Object)}
   */
  @Test
  public void testArrayValueEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ArrayList<KotlinAnnotationArgument.Value> elements = new ArrayList<>();
    elements.add(new KotlinAnnotationArgument.ArrayValue(new ArrayList<>()));
    KotlinAnnotationArgument.ArrayValue arrayValue = new KotlinAnnotationArgument.ArrayValue(elements);

    ArrayList<KotlinAnnotationArgument.Value> elements2 = new ArrayList<>();
    elements2.add(new KotlinAnnotationArgument.BooleanValue(true));

    // Act and Assert
    assertNotEquals(arrayValue, new KotlinAnnotationArgument.ArrayValue(elements2));
  }

  /**
   * Method under test: {@link KotlinAnnotationArgument.ArrayValue#equals(Object)}
   */
  @Test
  public void testArrayValueEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new KotlinAnnotationArgument.ArrayValue(new ArrayList<>()), null);
  }

  /**
   * Method under test: {@link KotlinAnnotationArgument.ArrayValue#equals(Object)}
   */
  @Test
  public void testArrayValueEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new KotlinAnnotationArgument.ArrayValue(new ArrayList<>()), "Different type to ArrayValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link KotlinAnnotationArgument.ArrayValue#ArrayValue(List)}
   *   <li>{@link KotlinAnnotationArgument.ArrayValue#toString()}
   * </ul>
   */
  @Test
  public void testArrayValueGettersAndSetters() {
    // Arrange and Act
    KotlinAnnotationArgument.ArrayValue actualArrayValue = new KotlinAnnotationArgument.ArrayValue(new ArrayList<>());

    // Assert
    assertEquals("[]", actualArrayValue.toString());
    assertTrue(actualArrayValue.elements.isEmpty());
  }

  /**
   * Method under test:
   * {@link KotlinAnnotationArgument.BooleanValue#BooleanValue(boolean)}
   */
  @Test
  public void testBooleanValueNewBooleanValue() {
    // Arrange, Act and Assert
    assertTrue((new KotlinAnnotationArgument.BooleanValue(true)).value);
  }

  /**
   * Method under test: {@link KotlinAnnotationArgument.ByteValue#ByteValue(byte)}
   */
  @Test
  public void testByteValueNewByteValue() {
    // Arrange, Act and Assert
    assertEquals('A', (new KotlinAnnotationArgument.ByteValue((byte) 'A')).value.byteValue());
  }

  /**
   * Method under test: {@link KotlinAnnotationArgument.CharValue#CharValue(char)}
   */
  @Test
  public void testCharValueNewCharValue() {
    // Arrange, Act and Assert
    assertEquals('A', (new KotlinAnnotationArgument.CharValue('A')).value.charValue());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link KotlinAnnotationArgument.ClassValue#equals(Object)}
   *   <li>{@link KotlinAnnotationArgument.ClassValue#hashCode()}
   * </ul>
   */
  @Test
  public void testClassValueEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    KotlinAnnotationArgument.ClassValue classValue = new KotlinAnnotationArgument.ClassValue("Class Name");
    KotlinAnnotationArgument.ClassValue classValue2 = new KotlinAnnotationArgument.ClassValue("Class Name");

    // Act and Assert
    assertEquals(classValue, classValue2);
    int expectedHashCodeResult = classValue.hashCode();
    assertEquals(expectedHashCodeResult, classValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link KotlinAnnotationArgument.ClassValue#equals(Object)}
   *   <li>{@link KotlinAnnotationArgument.ClassValue#hashCode()}
   * </ul>
   */
  @Test
  public void testClassValueEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    KotlinAnnotationArgument.ClassValue classValue = new KotlinAnnotationArgument.ClassValue("Class Name");

    // Act and Assert
    assertEquals(classValue, classValue);
    int expectedHashCodeResult = classValue.hashCode();
    assertEquals(expectedHashCodeResult, classValue.hashCode());
  }

  /**
   * Method under test: {@link KotlinAnnotationArgument.ClassValue#equals(Object)}
   */
  @Test
  public void testClassValueEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    KotlinAnnotationArgument.ClassValue classValue = new KotlinAnnotationArgument.ClassValue(
        "proguard.classfile.kotlin.KotlinAnnotationArgument$ClassValue");

    // Act and Assert
    assertNotEquals(classValue, new KotlinAnnotationArgument.ClassValue("Class Name"));
  }

  /**
   * Method under test: {@link KotlinAnnotationArgument.ClassValue#equals(Object)}
   */
  @Test
  public void testClassValueEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    KotlinAnnotationArgument.ClassValue classValue = new KotlinAnnotationArgument.ClassValue("Class Name", 3);

    // Act and Assert
    assertNotEquals(classValue, new KotlinAnnotationArgument.ClassValue("Class Name"));
  }

  /**
   * Method under test: {@link KotlinAnnotationArgument.ClassValue#equals(Object)}
   */
  @Test
  public void testClassValueEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new KotlinAnnotationArgument.ClassValue("Class Name"), null);
  }

  /**
   * Method under test: {@link KotlinAnnotationArgument.ClassValue#equals(Object)}
   */
  @Test
  public void testClassValueEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new KotlinAnnotationArgument.ClassValue("Class Name"), "Different type to ClassValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link KotlinAnnotationArgument.ClassValue#ClassValue(String)}
   *   <li>{@link KotlinAnnotationArgument.ClassValue#toString()}
   * </ul>
   */
  @Test
  public void testClassValueGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Class Name", (new KotlinAnnotationArgument.ClassValue("Class Name")).toString());
    assertEquals("[[[Class Name", (new KotlinAnnotationArgument.ClassValue("Class Name", 3)).toString());
  }

  /**
   * Method under test:
   * {@link KotlinAnnotationArgument.DoubleValue#DoubleValue(double)}
   */
  @Test
  public void testDoubleValueNewDoubleValue() {
    // Arrange, Act and Assert
    assertEquals(10.0d, (new KotlinAnnotationArgument.DoubleValue(10.0d)).value.doubleValue(), 0.0);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link KotlinAnnotationArgument.EnumValue#equals(Object)}
   *   <li>{@link KotlinAnnotationArgument.EnumValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEnumValueEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    KotlinAnnotationArgument.EnumValue enumValue = new KotlinAnnotationArgument.EnumValue("Class Name",
        "Enum Entry Name");
    KotlinAnnotationArgument.EnumValue enumValue2 = new KotlinAnnotationArgument.EnumValue("Class Name",
        "Enum Entry Name");

    // Act and Assert
    assertEquals(enumValue, enumValue2);
    int expectedHashCodeResult = enumValue.hashCode();
    assertEquals(expectedHashCodeResult, enumValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link KotlinAnnotationArgument.EnumValue#equals(Object)}
   *   <li>{@link KotlinAnnotationArgument.EnumValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEnumValueEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    KotlinAnnotationArgument.EnumValue enumValue = new KotlinAnnotationArgument.EnumValue("Class Name",
        "Enum Entry Name");

    // Act and Assert
    assertEquals(enumValue, enumValue);
    int expectedHashCodeResult = enumValue.hashCode();
    assertEquals(expectedHashCodeResult, enumValue.hashCode());
  }

  /**
   * Method under test: {@link KotlinAnnotationArgument.EnumValue#equals(Object)}
   */
  @Test
  public void testEnumValueEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    KotlinAnnotationArgument.EnumValue enumValue = new KotlinAnnotationArgument.EnumValue("Enum Entry Name",
        "Enum Entry Name");

    // Act and Assert
    assertNotEquals(enumValue, new KotlinAnnotationArgument.EnumValue("Class Name", "Enum Entry Name"));
  }

  /**
   * Method under test: {@link KotlinAnnotationArgument.EnumValue#equals(Object)}
   */
  @Test
  public void testEnumValueEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    KotlinAnnotationArgument.EnumValue enumValue = new KotlinAnnotationArgument.EnumValue("Class Name", "Class Name");

    // Act and Assert
    assertNotEquals(enumValue, new KotlinAnnotationArgument.EnumValue("Class Name", "Enum Entry Name"));
  }

  /**
   * Method under test: {@link KotlinAnnotationArgument.EnumValue#equals(Object)}
   */
  @Test
  public void testEnumValueEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new KotlinAnnotationArgument.EnumValue("Class Name", "Enum Entry Name"), null);
  }

  /**
   * Method under test: {@link KotlinAnnotationArgument.EnumValue#equals(Object)}
   */
  @Test
  public void testEnumValueEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new KotlinAnnotationArgument.EnumValue("Class Name", "Enum Entry Name"),
        "Different type to EnumValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link KotlinAnnotationArgument.EnumValue#EnumValue(String, String)}
   *   <li>{@link KotlinAnnotationArgument.EnumValue#toString()}
   * </ul>
   */
  @Test
  public void testEnumValueGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals("Class Name.Enum Entry Name",
        (new KotlinAnnotationArgument.EnumValue("Class Name", "Enum Entry Name")).toString());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link KotlinAnnotationArgument#equals(Object)}
   *   <li>{@link KotlinAnnotationArgument#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    KotlinAnnotationArgument kotlinAnnotationArgument = new KotlinAnnotationArgument("Name",
        new KotlinAnnotationArgument.BooleanValue(true));
    KotlinAnnotationArgument kotlinAnnotationArgument2 = new KotlinAnnotationArgument("Name",
        new KotlinAnnotationArgument.BooleanValue(true));

    // Act and Assert
    assertEquals(kotlinAnnotationArgument, kotlinAnnotationArgument2);
    int expectedHashCodeResult = kotlinAnnotationArgument.hashCode();
    assertEquals(expectedHashCodeResult, kotlinAnnotationArgument2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link KotlinAnnotationArgument#equals(Object)}
   *   <li>{@link KotlinAnnotationArgument#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    KotlinAnnotationArgument kotlinAnnotationArgument = new KotlinAnnotationArgument("Name",
        new KotlinAnnotationArgument.BooleanValue(true));

    // Act and Assert
    assertEquals(kotlinAnnotationArgument, kotlinAnnotationArgument);
    int expectedHashCodeResult = kotlinAnnotationArgument.hashCode();
    assertEquals(expectedHashCodeResult, kotlinAnnotationArgument.hashCode());
  }

  /**
   * Method under test: {@link KotlinAnnotationArgument#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    KotlinAnnotationArgument kotlinAnnotationArgument = new KotlinAnnotationArgument(
        "proguard.classfile.kotlin.KotlinAnnotationArgument", new KotlinAnnotationArgument.BooleanValue(true));

    // Act and Assert
    assertNotEquals(kotlinAnnotationArgument,
        new KotlinAnnotationArgument("Name", new KotlinAnnotationArgument.BooleanValue(true)));
  }

  /**
   * Method under test: {@link KotlinAnnotationArgument#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    KotlinAnnotationArgument kotlinAnnotationArgument = new KotlinAnnotationArgument("Name",
        new KotlinAnnotationArgument.BooleanValue(false));

    // Act and Assert
    assertNotEquals(kotlinAnnotationArgument,
        new KotlinAnnotationArgument("Name", new KotlinAnnotationArgument.BooleanValue(true)));
  }

  /**
   * Method under test: {@link KotlinAnnotationArgument#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new KotlinAnnotationArgument("Name", new KotlinAnnotationArgument.BooleanValue(true)), null);
  }

  /**
   * Method under test: {@link KotlinAnnotationArgument#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new KotlinAnnotationArgument("Name", new KotlinAnnotationArgument.BooleanValue(true)),
        "Different type to KotlinAnnotationArgument");
  }

  /**
   * Method under test:
   * {@link KotlinAnnotationArgument.FloatValue#FloatValue(float)}
   */
  @Test
  public void testFloatValueNewFloatValue() {
    // Arrange, Act and Assert
    assertEquals(10.0f, (new KotlinAnnotationArgument.FloatValue(10.0f)).value.floatValue(), 0.0f);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link KotlinAnnotationArgument#KotlinAnnotationArgument(String, KotlinAnnotationArgument.Value)}
   *   <li>{@link KotlinAnnotationArgument#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    KotlinAnnotationArgument actualKotlinAnnotationArgument = new KotlinAnnotationArgument("Name",
        new KotlinAnnotationArgument.BooleanValue(true));

    // Assert
    assertEquals("Name = true", actualKotlinAnnotationArgument.toString());
    assertNull(actualKotlinAnnotationArgument.getProcessingInfo());
    assertEquals(0, actualKotlinAnnotationArgument.getProcessingFlags());
  }

  /**
   * Method under test: {@link KotlinAnnotationArgument.IntValue#IntValue(int)}
   */
  @Test
  public void testIntValueNewIntValue() {
    // Arrange, Act and Assert
    assertEquals(42, (new KotlinAnnotationArgument.IntValue(42)).value.intValue());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link KotlinAnnotationArgument.LiteralValue#equals(Object)}
   *   <li>{@link KotlinAnnotationArgument.LiteralValue#hashCode()}
   * </ul>
   */
  @Test
  public void testLiteralValueEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    KotlinAnnotationArgument.LiteralValue<Object> literalValue = new KotlinAnnotationArgument.LiteralValue<>("Value");
    KotlinAnnotationArgument.LiteralValue<Object> literalValue2 = new KotlinAnnotationArgument.LiteralValue<>("Value");

    // Act and Assert
    assertEquals(literalValue, literalValue2);
    int expectedHashCodeResult = literalValue.hashCode();
    assertEquals(expectedHashCodeResult, literalValue2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link KotlinAnnotationArgument.LiteralValue#equals(Object)}
   *   <li>{@link KotlinAnnotationArgument.LiteralValue#hashCode()}
   * </ul>
   */
  @Test
  public void testLiteralValueEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    KotlinAnnotationArgument.LiteralValue<Object> literalValue = new KotlinAnnotationArgument.LiteralValue<>("Value");

    // Act and Assert
    assertEquals(literalValue, literalValue);
    int expectedHashCodeResult = literalValue.hashCode();
    assertEquals(expectedHashCodeResult, literalValue.hashCode());
  }

  /**
   * Method under test:
   * {@link KotlinAnnotationArgument.LiteralValue#equals(Object)}
   */
  @Test
  public void testLiteralValueEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    KotlinAnnotationArgument.LiteralValue<Object> literalValue = new KotlinAnnotationArgument.LiteralValue<>(42);

    // Act and Assert
    assertNotEquals(literalValue, new KotlinAnnotationArgument.LiteralValue<>("Value"));
  }

  /**
   * Method under test:
   * {@link KotlinAnnotationArgument.LiteralValue#equals(Object)}
   */
  @Test
  public void testLiteralValueEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    KotlinAnnotationArgument.LiteralValue<Object> literalValue = new KotlinAnnotationArgument.LiteralValue<>(
        new KotlinAnnotationArgument.BooleanValue(true));

    // Act and Assert
    assertNotEquals(literalValue, new KotlinAnnotationArgument.LiteralValue<>("Value"));
  }

  /**
   * Method under test:
   * {@link KotlinAnnotationArgument.LiteralValue#equals(Object)}
   */
  @Test
  public void testLiteralValueEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    KotlinAnnotationArgument.LiteralValue<Object> literalValue = new KotlinAnnotationArgument.LiteralValue<>("Value");

    // Act and Assert
    assertNotEquals(literalValue, null);
  }

  /**
   * Method under test:
   * {@link KotlinAnnotationArgument.LiteralValue#equals(Object)}
   */
  @Test
  public void testLiteralValueEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    KotlinAnnotationArgument.LiteralValue<Object> literalValue = new KotlinAnnotationArgument.LiteralValue<>("Value");

    // Act and Assert
    assertNotEquals(literalValue, "Different type to LiteralValue");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link KotlinAnnotationArgument.LiteralValue#LiteralValue(Object)}
   *   <li>{@link KotlinAnnotationArgument.LiteralValue#toString()}
   * </ul>
   */
  @Test
  public void testLiteralValueGettersAndSetters() {
    // Arrange and Act
    KotlinAnnotationArgument.LiteralValue<Object> actualLiteralValue = new KotlinAnnotationArgument.LiteralValue<>(
        "Value");

    // Assert
    assertSame(actualLiteralValue.value, actualLiteralValue.toString());
  }

  /**
   * Method under test: {@link KotlinAnnotationArgument.LongValue#LongValue(long)}
   */
  @Test
  public void testLongValueNewLongValue() {
    // Arrange, Act and Assert
    assertEquals(42L, (new KotlinAnnotationArgument.LongValue(42L)).value.longValue());
  }

  /**
   * Method under test:
   * {@link KotlinAnnotationArgument.ShortValue#ShortValue(short)}
   */
  @Test
  public void testShortValueNewShortValue() {
    // Arrange, Act and Assert
    assertEquals((short) 1, (new KotlinAnnotationArgument.ShortValue((short) 1)).value.shortValue());
  }

  /**
   * Method under test:
   * {@link KotlinAnnotationArgument.StringValue#StringValue(String)}
   */
  @Test
  public void testStringValueNewStringValue() {
    // Arrange, Act and Assert
    assertEquals("42", (new KotlinAnnotationArgument.StringValue("42")).value);
  }

  /**
   * Method under test:
   * {@link KotlinAnnotationArgument.UByteValue#UByteValue(byte)}
   */
  @Test
  public void testUByteValueNewUByteValue() {
    // Arrange, Act and Assert
    assertEquals('A', (new KotlinAnnotationArgument.UByteValue((byte) 'A')).value.byteValue());
  }

  /**
   * Method under test: {@link KotlinAnnotationArgument.UIntValue#UIntValue(int)}
   */
  @Test
  public void testUIntValueNewUIntValue() {
    // Arrange, Act and Assert
    assertEquals(42, (new KotlinAnnotationArgument.UIntValue(42)).value.intValue());
  }

  /**
   * Method under test:
   * {@link KotlinAnnotationArgument.ULongValue#ULongValue(long)}
   */
  @Test
  public void testULongValueNewULongValue() {
    // Arrange, Act and Assert
    assertEquals(42L, (new KotlinAnnotationArgument.ULongValue(42L)).value.longValue());
  }

  /**
   * Method under test:
   * {@link KotlinAnnotationArgument.UShortValue#UShortValue(short)}
   */
  @Test
  public void testUShortValueNewUShortValue() {
    // Arrange, Act and Assert
    assertEquals((short) 1, (new KotlinAnnotationArgument.UShortValue((short) 1)).value.shortValue());
  }
}
