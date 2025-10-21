package proguard.classfile.kotlin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.kotlin.KotlinAnnotationArgument.AnnotationValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.ArrayValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.BooleanValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.ByteValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.CharValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.ClassValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.DoubleValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.EnumValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.FloatValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.IntValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.LiteralValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.LongValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.ShortValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.StringValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.UByteValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.UIntValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.ULongValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.UShortValue;
import proguard.classfile.kotlin.KotlinAnnotationArgument.Value;

public class KotlinAnnotationArgumentDiffblueTest {
  /**
   * Test AnnotationValue {@link AnnotationValue#equals(Object)}, and {@link
   * AnnotationValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AnnotationValue#equals(Object)}
   *   <li>{@link AnnotationValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AnnotationValue.equals(Object)", "int AnnotationValue.hashCode()"})
  public void testAnnotationValueEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AnnotationValue annotationValue = new AnnotationValue(new KotlinAnnotation("Class Name"));
    AnnotationValue annotationValue2 = new AnnotationValue(new KotlinAnnotation("Class Name"));

    // Act and Assert
    assertEquals(annotationValue, annotationValue2);
    int expectedHashCodeResult = annotationValue.hashCode();
    assertEquals(expectedHashCodeResult, annotationValue2.hashCode());
  }

  /**
   * Test AnnotationValue {@link AnnotationValue#equals(Object)}, and {@link
   * AnnotationValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AnnotationValue#equals(Object)}
   *   <li>{@link AnnotationValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AnnotationValue.equals(Object)", "int AnnotationValue.hashCode()"})
  public void testAnnotationValueEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AnnotationValue annotationValue = new AnnotationValue(new KotlinAnnotation("Class Name"));

    // Act and Assert
    assertEquals(annotationValue, annotationValue);
    int expectedHashCodeResult = annotationValue.hashCode();
    assertEquals(expectedHashCodeResult, annotationValue.hashCode());
  }

  /**
   * Test AnnotationValue {@link AnnotationValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AnnotationValue.equals(Object)", "int AnnotationValue.hashCode()"})
  public void testAnnotationValueEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AnnotationValue annotationValue =
        new AnnotationValue(new KotlinAnnotation("proguard.classfile.kotlin.KotlinAnnotation"));

    // Act and Assert
    assertNotEquals(annotationValue, new AnnotationValue(new KotlinAnnotation("Class Name")));
  }

  /**
   * Test AnnotationValue {@link AnnotationValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AnnotationValue.equals(Object)", "int AnnotationValue.hashCode()"})
  public void testAnnotationValueEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AnnotationValue(new KotlinAnnotation("Class Name")), null);
  }

  /**
   * Test AnnotationValue {@link AnnotationValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AnnotationValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AnnotationValue.equals(Object)", "int AnnotationValue.hashCode()"})
  public void testAnnotationValueEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new AnnotationValue(new KotlinAnnotation("Class Name")),
        "Different type to AnnotationValue");
  }

  /**
   * Test AnnotationValue getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AnnotationValue#AnnotationValue(KotlinAnnotation)}
   *   <li>{@link AnnotationValue#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void AnnotationValue.<init>(KotlinAnnotation)",
    "String AnnotationValue.toString()"
  })
  public void testAnnotationValueGettersAndSetters() {
    // Arrange and Act
    AnnotationValue actualAnnotationValue = new AnnotationValue(new KotlinAnnotation("Class Name"));

    // Assert
    assertEquals("Class Name()", actualAnnotationValue.toString());
    KotlinAnnotation kotlinAnnotation = actualAnnotationValue.kotlinMetadataAnnotation;
    assertNull(kotlinAnnotation.getProcessingInfo());
    assertEquals(0, kotlinAnnotation.getProcessingFlags());
    assertTrue(kotlinAnnotation.arguments.isEmpty());
  }

  /**
   * Test ArrayValue {@link ArrayValue#equals(Object)}, and {@link ArrayValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ArrayValue#equals(Object)}
   *   <li>{@link ArrayValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArrayValue.equals(Object)", "int ArrayValue.hashCode()"})
  public void testArrayValueEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ArrayValue arrayValue = new ArrayValue(new ArrayList<>());
    ArrayValue arrayValue2 = new ArrayValue(new ArrayList<>());

    // Act and Assert
    assertEquals(arrayValue, arrayValue2);
    int expectedHashCodeResult = arrayValue.hashCode();
    assertEquals(expectedHashCodeResult, arrayValue2.hashCode());
  }

  /**
   * Test ArrayValue {@link ArrayValue#equals(Object)}, and {@link ArrayValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ArrayValue#equals(Object)}
   *   <li>{@link ArrayValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArrayValue.equals(Object)", "int ArrayValue.hashCode()"})
  public void testArrayValueEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ArrayValue arrayValue = new ArrayValue(new ArrayList<>());

    // Act and Assert
    assertEquals(arrayValue, arrayValue);
    int expectedHashCodeResult = arrayValue.hashCode();
    assertEquals(expectedHashCodeResult, arrayValue.hashCode());
  }

  /**
   * Test ArrayValue {@link ArrayValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ArrayValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArrayValue.equals(Object)", "int ArrayValue.hashCode()"})
  public void testArrayValueEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<Value> elements = new ArrayList<>();
    elements.add(new BooleanValue(true));
    ArrayValue arrayValue = new ArrayValue(elements);

    // Act and Assert
    assertNotEquals(arrayValue, new ArrayValue(new ArrayList<>()));
  }

  /**
   * Test ArrayValue {@link ArrayValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ArrayValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArrayValue.equals(Object)", "int ArrayValue.hashCode()"})
  public void testArrayValueEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ArrayList<Value> elements = new ArrayList<>();
    elements.add(new ArrayValue(new ArrayList<>()));
    ArrayValue arrayValue = new ArrayValue(elements);

    ArrayList<Value> elements2 = new ArrayList<>();
    elements2.add(new BooleanValue(true));

    // Act and Assert
    assertNotEquals(arrayValue, new ArrayValue(elements2));
  }

  /**
   * Test ArrayValue {@link ArrayValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ArrayValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArrayValue.equals(Object)", "int ArrayValue.hashCode()"})
  public void testArrayValueEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ArrayValue(new ArrayList<>()), null);
  }

  /**
   * Test ArrayValue {@link ArrayValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ArrayValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ArrayValue.equals(Object)", "int ArrayValue.hashCode()"})
  public void testArrayValueEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ArrayValue(new ArrayList<>()), "Different type to ArrayValue");
  }

  /**
   * Test ArrayValue getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ArrayValue#ArrayValue(List)}
   *   <li>{@link ArrayValue#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ArrayValue.<init>(List)", "String ArrayValue.toString()"})
  public void testArrayValueGettersAndSetters() {
    // Arrange and Act
    ArrayValue actualArrayValue = new ArrayValue(new ArrayList<>());

    // Assert
    assertEquals("[]", actualArrayValue.toString());
    assertTrue(actualArrayValue.elements.isEmpty());
  }

  /**
   * Test BooleanValue {@link BooleanValue#BooleanValue(boolean)}.
   *
   * <p>Method under test: {@link BooleanValue#BooleanValue(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BooleanValue.<init>(boolean)"})
  public void testBooleanValueNewBooleanValue() {
    // Arrange, Act and Assert
    assertTrue((new BooleanValue(true)).value);
  }

  /**
   * Test ByteValue {@link ByteValue#ByteValue(byte)}.
   *
   * <p>Method under test: {@link ByteValue#ByteValue(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ByteValue.<init>(byte)"})
  public void testByteValueNewByteValue() {
    // Arrange, Act and Assert
    assertEquals('A', (new ByteValue((byte) 'A')).value.byteValue());
  }

  /**
   * Test CharValue {@link CharValue#CharValue(char)}.
   *
   * <p>Method under test: {@link CharValue#CharValue(char)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CharValue.<init>(char)"})
  public void testCharValueNewCharValue() {
    // Arrange, Act and Assert
    assertEquals('A', (new CharValue('A')).value.charValue());
  }

  /**
   * Test ClassValue {@link ClassValue#equals(Object)}, and {@link ClassValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ClassValue#equals(Object)}
   *   <li>{@link ClassValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassValue.equals(Object)", "int ClassValue.hashCode()"})
  public void testClassValueEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ClassValue classValue = new ClassValue("Class Name");
    ClassValue classValue2 = new ClassValue("Class Name");

    // Act and Assert
    assertEquals(classValue, classValue2);
    int expectedHashCodeResult = classValue.hashCode();
    assertEquals(expectedHashCodeResult, classValue2.hashCode());
  }

  /**
   * Test ClassValue {@link ClassValue#equals(Object)}, and {@link ClassValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ClassValue#equals(Object)}
   *   <li>{@link ClassValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassValue.equals(Object)", "int ClassValue.hashCode()"})
  public void testClassValueEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ClassValue classValue = new ClassValue("Class Name");

    // Act and Assert
    assertEquals(classValue, classValue);
    int expectedHashCodeResult = classValue.hashCode();
    assertEquals(expectedHashCodeResult, classValue.hashCode());
  }

  /**
   * Test ClassValue {@link ClassValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ClassValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassValue.equals(Object)", "int ClassValue.hashCode()"})
  public void testClassValueEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ClassValue classValue =
        new ClassValue("proguard.classfile.kotlin.KotlinAnnotationArgument$ClassValue");

    // Act and Assert
    assertNotEquals(classValue, new ClassValue("Class Name"));
  }

  /**
   * Test ClassValue {@link ClassValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ClassValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassValue.equals(Object)", "int ClassValue.hashCode()"})
  public void testClassValueEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ClassValue classValue = new ClassValue("Class Name", 3);

    // Act and Assert
    assertNotEquals(classValue, new ClassValue("Class Name"));
  }

  /**
   * Test ClassValue {@link ClassValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ClassValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassValue.equals(Object)", "int ClassValue.hashCode()"})
  public void testClassValueEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ClassValue("Class Name"), null);
  }

  /**
   * Test ClassValue {@link ClassValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ClassValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassValue.equals(Object)", "int ClassValue.hashCode()"})
  public void testClassValueEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ClassValue("Class Name"), "Different type to ClassValue");
  }

  /**
   * Test ClassValue getters and setters.
   *
   * <ul>
   *   <li>When {@code Class Name}.
   *   <li>Then return toString is {@code Class Name}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ClassValue#ClassValue(String)}
   *   <li>{@link ClassValue#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ClassValue.<init>(String)",
    "void ClassValue.<init>(String, int)",
    "String ClassValue.toString()"
  })
  public void testClassValueGettersAndSetters_whenClassName_thenReturnToStringIsClassName() {
    // Arrange, Act and Assert
    assertEquals("Class Name", (new ClassValue("Class Name")).toString());
  }

  /**
   * Test ClassValue getters and setters.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return toString is {@code [[[Class Name}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ClassValue#ClassValue(String, int)}
   *   <li>{@link ClassValue#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void ClassValue.<init>(String)",
    "void ClassValue.<init>(String, int)",
    "String ClassValue.toString()"
  })
  public void testClassValueGettersAndSetters_whenThree_thenReturnToStringIsClassName() {
    // Arrange, Act and Assert
    assertEquals("[[[Class Name", (new ClassValue("Class Name", 3)).toString());
  }

  /**
   * Test DoubleValue {@link DoubleValue#DoubleValue(double)}.
   *
   * <p>Method under test: {@link DoubleValue#DoubleValue(double)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DoubleValue.<init>(double)"})
  public void testDoubleValueNewDoubleValue() {
    // Arrange, Act and Assert
    assertEquals(10.0d, (new DoubleValue(10.0d)).value.doubleValue(), 0.0);
  }

  /**
   * Test EnumValue {@link EnumValue#equals(Object)}, and {@link EnumValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EnumValue#equals(Object)}
   *   <li>{@link EnumValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EnumValue.equals(Object)", "int EnumValue.hashCode()"})
  public void testEnumValueEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EnumValue enumValue = new EnumValue("Class Name", "Enum Entry Name");
    EnumValue enumValue2 = new EnumValue("Class Name", "Enum Entry Name");

    // Act and Assert
    assertEquals(enumValue, enumValue2);
    int expectedHashCodeResult = enumValue.hashCode();
    assertEquals(expectedHashCodeResult, enumValue2.hashCode());
  }

  /**
   * Test EnumValue {@link EnumValue#equals(Object)}, and {@link EnumValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EnumValue#equals(Object)}
   *   <li>{@link EnumValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EnumValue.equals(Object)", "int EnumValue.hashCode()"})
  public void testEnumValueEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EnumValue enumValue = new EnumValue("Class Name", "Enum Entry Name");

    // Act and Assert
    assertEquals(enumValue, enumValue);
    int expectedHashCodeResult = enumValue.hashCode();
    assertEquals(expectedHashCodeResult, enumValue.hashCode());
  }

  /**
   * Test EnumValue {@link EnumValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EnumValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EnumValue.equals(Object)", "int EnumValue.hashCode()"})
  public void testEnumValueEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EnumValue enumValue = new EnumValue("Enum Entry Name", "Enum Entry Name");

    // Act and Assert
    assertNotEquals(enumValue, new EnumValue("Class Name", "Enum Entry Name"));
  }

  /**
   * Test EnumValue {@link EnumValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EnumValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EnumValue.equals(Object)", "int EnumValue.hashCode()"})
  public void testEnumValueEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EnumValue enumValue = new EnumValue("Class Name", "Class Name");

    // Act and Assert
    assertNotEquals(enumValue, new EnumValue("Class Name", "Enum Entry Name"));
  }

  /**
   * Test EnumValue {@link EnumValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EnumValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EnumValue.equals(Object)", "int EnumValue.hashCode()"})
  public void testEnumValueEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EnumValue("Class Name", "Enum Entry Name"), null);
  }

  /**
   * Test EnumValue {@link EnumValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EnumValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EnumValue.equals(Object)", "int EnumValue.hashCode()"})
  public void testEnumValueEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EnumValue("Class Name", "Enum Entry Name"), "Different type to EnumValue");
  }

  /**
   * Test EnumValue getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EnumValue#EnumValue(String, String)}
   *   <li>{@link EnumValue#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EnumValue.<init>(String, String)", "String EnumValue.toString()"})
  public void testEnumValueGettersAndSetters() {
    // Arrange, Act and Assert
    assertEquals(
        "Class Name.Enum Entry Name", (new EnumValue("Class Name", "Enum Entry Name")).toString());
  }

  /**
   * Test FloatValue {@link FloatValue#FloatValue(float)}.
   *
   * <p>Method under test: {@link FloatValue#FloatValue(float)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void FloatValue.<init>(float)"})
  public void testFloatValueNewFloatValue() {
    // Arrange, Act and Assert
    assertEquals(10.0f, (new FloatValue(10.0f)).value.floatValue(), 0.0f);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KotlinAnnotationArgument#KotlinAnnotationArgument(String, Value)}
   *   <li>{@link KotlinAnnotationArgument#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void KotlinAnnotationArgument.<init>(String, Value)",
    "String KotlinAnnotationArgument.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    KotlinAnnotationArgument actualKotlinAnnotationArgument =
        new KotlinAnnotationArgument("Name", new BooleanValue(true));

    // Assert
    assertEquals("Name = true", actualKotlinAnnotationArgument.toString());
    assertNull(actualKotlinAnnotationArgument.getProcessingInfo());
    assertEquals(0, actualKotlinAnnotationArgument.getProcessingFlags());
  }

  /**
   * Test {@link KotlinAnnotationArgument#equals(Object)}, and {@link
   * KotlinAnnotationArgument#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KotlinAnnotationArgument#equals(Object)}
   *   <li>{@link KotlinAnnotationArgument#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean KotlinAnnotationArgument.equals(Object)",
    "int KotlinAnnotationArgument.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    KotlinAnnotationArgument kotlinAnnotationArgument =
        new KotlinAnnotationArgument("Name", new BooleanValue(true));
    KotlinAnnotationArgument kotlinAnnotationArgument2 =
        new KotlinAnnotationArgument("Name", new BooleanValue(true));

    // Act and Assert
    assertEquals(kotlinAnnotationArgument, kotlinAnnotationArgument2);
    int expectedHashCodeResult = kotlinAnnotationArgument.hashCode();
    assertEquals(expectedHashCodeResult, kotlinAnnotationArgument2.hashCode());
  }

  /**
   * Test {@link KotlinAnnotationArgument#equals(Object)}, and {@link
   * KotlinAnnotationArgument#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KotlinAnnotationArgument#equals(Object)}
   *   <li>{@link KotlinAnnotationArgument#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean KotlinAnnotationArgument.equals(Object)",
    "int KotlinAnnotationArgument.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    KotlinAnnotationArgument kotlinAnnotationArgument =
        new KotlinAnnotationArgument("Name", new BooleanValue(true));

    // Act and Assert
    assertEquals(kotlinAnnotationArgument, kotlinAnnotationArgument);
    int expectedHashCodeResult = kotlinAnnotationArgument.hashCode();
    assertEquals(expectedHashCodeResult, kotlinAnnotationArgument.hashCode());
  }

  /**
   * Test {@link KotlinAnnotationArgument#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link KotlinAnnotationArgument#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean KotlinAnnotationArgument.equals(Object)",
    "int KotlinAnnotationArgument.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    KotlinAnnotationArgument kotlinAnnotationArgument =
        new KotlinAnnotationArgument(
            "proguard.classfile.kotlin.KotlinAnnotationArgument", new BooleanValue(true));

    // Act and Assert
    assertNotEquals(
        kotlinAnnotationArgument, new KotlinAnnotationArgument("Name", new BooleanValue(true)));
  }

  /**
   * Test {@link KotlinAnnotationArgument#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link KotlinAnnotationArgument#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean KotlinAnnotationArgument.equals(Object)",
    "int KotlinAnnotationArgument.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    KotlinAnnotationArgument kotlinAnnotationArgument =
        new KotlinAnnotationArgument("Name", new BooleanValue(false));

    // Act and Assert
    assertNotEquals(
        kotlinAnnotationArgument, new KotlinAnnotationArgument("Name", new BooleanValue(true)));
  }

  /**
   * Test {@link KotlinAnnotationArgument#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link KotlinAnnotationArgument#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean KotlinAnnotationArgument.equals(Object)",
    "int KotlinAnnotationArgument.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new KotlinAnnotationArgument("Name", new BooleanValue(true)), null);
  }

  /**
   * Test {@link KotlinAnnotationArgument#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link KotlinAnnotationArgument#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean KotlinAnnotationArgument.equals(Object)",
    "int KotlinAnnotationArgument.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new KotlinAnnotationArgument("Name", new BooleanValue(true)),
        "Different type to KotlinAnnotationArgument");
  }

  /**
   * Test IntValue {@link IntValue#IntValue(int)}.
   *
   * <p>Method under test: {@link IntValue#IntValue(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void IntValue.<init>(int)"})
  public void testIntValueNewIntValue() {
    // Arrange, Act and Assert
    assertEquals(42, (new IntValue(42)).value.intValue());
  }

  /**
   * Test LiteralValue {@link LiteralValue#equals(Object)}, and {@link LiteralValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LiteralValue#equals(Object)}
   *   <li>{@link LiteralValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LiteralValue.equals(Object)", "int LiteralValue.hashCode()"})
  public void testLiteralValueEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LiteralValue<Object> literalValue = new LiteralValue<>("Value");
    LiteralValue<Object> literalValue2 = new LiteralValue<>("Value");

    // Act and Assert
    assertEquals(literalValue, literalValue2);
    int expectedHashCodeResult = literalValue.hashCode();
    assertEquals(expectedHashCodeResult, literalValue2.hashCode());
  }

  /**
   * Test LiteralValue {@link LiteralValue#equals(Object)}, and {@link LiteralValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LiteralValue#equals(Object)}
   *   <li>{@link LiteralValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LiteralValue.equals(Object)", "int LiteralValue.hashCode()"})
  public void testLiteralValueEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LiteralValue<Object> literalValue = new LiteralValue<>("Value");

    // Act and Assert
    assertEquals(literalValue, literalValue);
    int expectedHashCodeResult = literalValue.hashCode();
    assertEquals(expectedHashCodeResult, literalValue.hashCode());
  }

  /**
   * Test LiteralValue {@link LiteralValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LiteralValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LiteralValue.equals(Object)", "int LiteralValue.hashCode()"})
  public void testLiteralValueEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LiteralValue<Object> literalValue = new LiteralValue<>(42);

    // Act and Assert
    assertNotEquals(literalValue, new LiteralValue<>("Value"));
  }

  /**
   * Test LiteralValue {@link LiteralValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LiteralValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LiteralValue.equals(Object)", "int LiteralValue.hashCode()"})
  public void testLiteralValueEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LiteralValue<Object> literalValue = new LiteralValue<>(new BooleanValue(true));

    // Act and Assert
    assertNotEquals(literalValue, new LiteralValue<>("Value"));
  }

  /**
   * Test LiteralValue {@link LiteralValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LiteralValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LiteralValue.equals(Object)", "int LiteralValue.hashCode()"})
  public void testLiteralValueEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LiteralValue<Object> literalValue = new LiteralValue<>("Value");

    // Act and Assert
    assertNotEquals(literalValue, null);
  }

  /**
   * Test LiteralValue {@link LiteralValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LiteralValue#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean LiteralValue.equals(Object)", "int LiteralValue.hashCode()"})
  public void testLiteralValueEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LiteralValue<Object> literalValue = new LiteralValue<>("Value");

    // Act and Assert
    assertNotEquals(literalValue, "Different type to LiteralValue");
  }

  /**
   * Test LiteralValue getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LiteralValue#LiteralValue(Object)}
   *   <li>{@link LiteralValue#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LiteralValue.<init>(Object)", "String LiteralValue.toString()"})
  public void testLiteralValueGettersAndSetters() {
    // Arrange and Act
    LiteralValue<Object> actualLiteralValue = new LiteralValue<>("Value");

    // Assert
    assertSame(actualLiteralValue.value, actualLiteralValue.toString());
  }

  /**
   * Test LongValue {@link LongValue#LongValue(long)}.
   *
   * <p>Method under test: {@link LongValue#LongValue(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void LongValue.<init>(long)"})
  public void testLongValueNewLongValue() {
    // Arrange, Act and Assert
    assertEquals(42L, (new LongValue(42L)).value.longValue());
  }

  /**
   * Test ShortValue {@link ShortValue#ShortValue(short)}.
   *
   * <p>Method under test: {@link ShortValue#ShortValue(short)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ShortValue.<init>(short)"})
  public void testShortValueNewShortValue() {
    // Arrange, Act and Assert
    assertEquals((short) 1, (new ShortValue((short) 1)).value.shortValue());
  }

  /**
   * Test StringValue {@link StringValue#StringValue(String)}.
   *
   * <p>Method under test: {@link StringValue#StringValue(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void StringValue.<init>(String)"})
  public void testStringValueNewStringValue() {
    // Arrange, Act and Assert
    assertEquals("42", (new StringValue("42")).value);
  }

  /**
   * Test UByteValue {@link UByteValue#UByteValue(byte)}.
   *
   * <p>Method under test: {@link UByteValue#UByteValue(byte)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UByteValue.<init>(byte)"})
  public void testUByteValueNewUByteValue() {
    // Arrange, Act and Assert
    assertEquals('A', (new UByteValue((byte) 'A')).value.byteValue());
  }

  /**
   * Test UIntValue {@link UIntValue#UIntValue(int)}.
   *
   * <p>Method under test: {@link UIntValue#UIntValue(int)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UIntValue.<init>(int)"})
  public void testUIntValueNewUIntValue() {
    // Arrange, Act and Assert
    assertEquals(42, (new UIntValue(42)).value.intValue());
  }

  /**
   * Test ULongValue {@link ULongValue#ULongValue(long)}.
   *
   * <p>Method under test: {@link ULongValue#ULongValue(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ULongValue.<init>(long)"})
  public void testULongValueNewULongValue() {
    // Arrange, Act and Assert
    assertEquals(42L, (new ULongValue(42L)).value.longValue());
  }

  /**
   * Test UShortValue {@link UShortValue#UShortValue(short)}.
   *
   * <p>Method under test: {@link UShortValue#UShortValue(short)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UShortValue.<init>(short)"})
  public void testUShortValueNewUShortValue() {
    // Arrange, Act and Assert
    assertEquals((short) 1, (new UShortValue((short) 1)).value.shortValue());
  }
}
