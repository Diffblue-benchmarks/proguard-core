package proguard.classfile.util.kotlin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.metadata.KmAnnotation;
import kotlin.metadata.KmAnnotationArgument;
import kotlin.metadata.KmAnnotationArgument.AnnotationValue;
import kotlin.metadata.KmAnnotationArgument.ArrayKClassValue;
import kotlin.metadata.KmAnnotationArgument.ArrayValue;
import kotlin.metadata.KmAnnotationArgument.BooleanValue;
import kotlin.metadata.KmAnnotationArgument.ByteValue;
import kotlin.metadata.KmAnnotationArgument.CharValue;
import kotlin.metadata.KmAnnotationArgument.DoubleValue;
import kotlin.metadata.KmAnnotationArgument.EnumValue;
import kotlin.metadata.KmAnnotationArgument.FloatValue;
import kotlin.metadata.KmAnnotationArgument.IntValue;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.kotlin.KotlinAnnotation;
import proguard.classfile.kotlin.KotlinAnnotationArgument;

public class KotlinAnnotationUtilKtDiffblueTest {
  /**
   * Test {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}.
   *
   * <p>Method under test: {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"KotlinAnnotation KotlinAnnotationUtilKt.convertAnnotation(KmAnnotation)"})
  public void testConvertAnnotation() {
    // Arrange
    HashMap<String, KmAnnotationArgument> arguments = new HashMap<>();
    arguments.put(
        "kmAnnotation", new AnnotationValue(new KmAnnotation("kmAnnotation", new HashMap<>())));

    // Act and Assert
    List<KotlinAnnotationArgument> kotlinAnnotationArgumentList =
        KotlinAnnotationUtilKt.convertAnnotation(new KmAnnotation("Class Name", arguments))
            .arguments;
    assertEquals(1, kotlinAnnotationArgumentList.size());
    KotlinAnnotationArgument getResult = kotlinAnnotationArgumentList.get(0);
    assertEquals("kmAnnotation", getResult.name);
    assertNull(getResult.getProcessingInfo());
    assertNull(getResult.referencedAnnotationMethodClass);
    assertNull(getResult.referencedAnnotationMethod);
    assertEquals(0, getResult.getProcessingFlags());
  }

  /**
   * Test {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}.
   *
   * <p>Method under test: {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"KotlinAnnotation KotlinAnnotationUtilKt.convertAnnotation(KmAnnotation)"})
  public void testConvertAnnotation2() {
    // Arrange
    HashMap<String, KmAnnotationArgument> arguments = new HashMap<>();
    arguments.put("kmAnnotation", new ArrayKClassValue("kmAnnotation", 3));

    // Act and Assert
    List<KotlinAnnotationArgument> kotlinAnnotationArgumentList =
        KotlinAnnotationUtilKt.convertAnnotation(new KmAnnotation("Class Name", arguments))
            .arguments;
    assertEquals(1, kotlinAnnotationArgumentList.size());
    KotlinAnnotationArgument getResult = kotlinAnnotationArgumentList.get(0);
    assertEquals("kmAnnotation", getResult.name);
    assertNull(getResult.getProcessingInfo());
    assertNull(getResult.referencedAnnotationMethodClass);
    assertNull(getResult.referencedAnnotationMethod);
    assertEquals(0, getResult.getProcessingFlags());
  }

  /**
   * Test {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}.
   *
   * <p>Method under test: {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"KotlinAnnotation KotlinAnnotationUtilKt.convertAnnotation(KmAnnotation)"})
  public void testConvertAnnotation3() {
    // Arrange
    HashMap<String, KmAnnotationArgument> arguments = new HashMap<>();
    arguments.put("kmAnnotation", new EnumValue("kmAnnotation", "kmAnnotation"));

    // Act and Assert
    List<KotlinAnnotationArgument> kotlinAnnotationArgumentList =
        KotlinAnnotationUtilKt.convertAnnotation(new KmAnnotation("Class Name", arguments))
            .arguments;
    assertEquals(1, kotlinAnnotationArgumentList.size());
    KotlinAnnotationArgument getResult = kotlinAnnotationArgumentList.get(0);
    assertEquals("kmAnnotation", getResult.name);
    assertNull(getResult.getProcessingInfo());
    assertNull(getResult.referencedAnnotationMethodClass);
    assertNull(getResult.referencedAnnotationMethod);
    assertEquals(0, getResult.getProcessingFlags());
  }

  /**
   * Test {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link
   *       KmAnnotationArgument.BooleanValue#BooleanValue(boolean)} with value is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"KotlinAnnotation KotlinAnnotationUtilKt.convertAnnotation(KmAnnotation)"})
  public void testConvertAnnotation_givenArrayListAddBooleanValueWithValueIsTrue() {
    // Arrange
    ArrayList<KmAnnotationArgument> elements = new ArrayList<>();
    elements.add(new BooleanValue(true));
    ArrayValue arrayValue = new ArrayValue(elements);

    HashMap<String, KmAnnotationArgument> arguments = new HashMap<>();
    arguments.put("kmAnnotation", arrayValue);

    // Act and Assert
    List<KotlinAnnotationArgument> kotlinAnnotationArgumentList =
        KotlinAnnotationUtilKt.convertAnnotation(new KmAnnotation("Class Name", arguments))
            .arguments;
    assertEquals(1, kotlinAnnotationArgumentList.size());
    KotlinAnnotationArgument getResult = kotlinAnnotationArgumentList.get(0);
    assertEquals("kmAnnotation", getResult.name);
    assertNull(getResult.getProcessingInfo());
    assertNull(getResult.referencedAnnotationMethodClass);
    assertNull(getResult.referencedAnnotationMethod);
    assertEquals(0, getResult.getProcessingFlags());
  }

  /**
   * Test {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"KotlinAnnotation KotlinAnnotationUtilKt.convertAnnotation(KmAnnotation)"})
  public void testConvertAnnotation_givenArrayListAddNull() {
    // Arrange
    ArrayList<KmAnnotationArgument> elements = new ArrayList<>();
    elements.add(null);
    ArrayValue arrayValue = new ArrayValue(elements);

    HashMap<String, KmAnnotationArgument> arguments = new HashMap<>();
    arguments.put("kmAnnotation", arrayValue);

    // Act and Assert
    assertThrows(
        NoWhenBranchMatchedException.class,
        () -> KotlinAnnotationUtilKt.convertAnnotation(new KmAnnotation("Class Name", arguments)));
  }

  /**
   * Test {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}.
   *
   * <ul>
   *   <li>Given {@link KmAnnotationArgument.ArrayValue#ArrayValue(List)} with elements is {@link
   *       ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"KotlinAnnotation KotlinAnnotationUtilKt.convertAnnotation(KmAnnotation)"})
  public void testConvertAnnotation_givenArrayValueWithElementsIsArrayList() {
    // Arrange
    HashMap<String, KmAnnotationArgument> arguments = new HashMap<>();
    arguments.put("kmAnnotation", new ArrayValue(new ArrayList<>()));

    // Act and Assert
    List<KotlinAnnotationArgument> kotlinAnnotationArgumentList =
        KotlinAnnotationUtilKt.convertAnnotation(new KmAnnotation("Class Name", arguments))
            .arguments;
    assertEquals(1, kotlinAnnotationArgumentList.size());
    KotlinAnnotationArgument getResult = kotlinAnnotationArgumentList.get(0);
    assertEquals("kmAnnotation", getResult.name);
    assertNull(getResult.getProcessingInfo());
    assertNull(getResult.referencedAnnotationMethodClass);
    assertNull(getResult.referencedAnnotationMethod);
    assertEquals(0, getResult.getProcessingFlags());
  }

  /**
   * Test {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}.
   *
   * <ul>
   *   <li>Given {@link KmAnnotationArgument.BooleanValue#BooleanValue(boolean)} with value is
   *       {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"KotlinAnnotation KotlinAnnotationUtilKt.convertAnnotation(KmAnnotation)"})
  public void testConvertAnnotation_givenBooleanValueWithValueIsTrue() {
    // Arrange
    HashMap<String, KmAnnotationArgument> arguments = new HashMap<>();
    arguments.put("kmAnnotation", new BooleanValue(true));

    // Act and Assert
    List<KotlinAnnotationArgument> kotlinAnnotationArgumentList =
        KotlinAnnotationUtilKt.convertAnnotation(new KmAnnotation("Class Name", arguments))
            .arguments;
    assertEquals(1, kotlinAnnotationArgumentList.size());
    KotlinAnnotationArgument getResult = kotlinAnnotationArgumentList.get(0);
    assertEquals("kmAnnotation", getResult.name);
    assertNull(getResult.getProcessingInfo());
    assertNull(getResult.referencedAnnotationMethodClass);
    assertNull(getResult.referencedAnnotationMethod);
    assertEquals(0, getResult.getProcessingFlags());
  }

  /**
   * Test {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}.
   *
   * <ul>
   *   <li>Given {@link ByteValue#ByteValue(byte)} with value is {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"KotlinAnnotation KotlinAnnotationUtilKt.convertAnnotation(KmAnnotation)"})
  public void testConvertAnnotation_givenByteValueWithValueIsA() {
    // Arrange
    HashMap<String, KmAnnotationArgument> arguments = new HashMap<>();
    arguments.put("kmAnnotation", new ByteValue((byte) 'A'));

    // Act and Assert
    List<KotlinAnnotationArgument> kotlinAnnotationArgumentList =
        KotlinAnnotationUtilKt.convertAnnotation(new KmAnnotation("Class Name", arguments))
            .arguments;
    assertEquals(1, kotlinAnnotationArgumentList.size());
    KotlinAnnotationArgument getResult = kotlinAnnotationArgumentList.get(0);
    assertEquals("kmAnnotation", getResult.name);
    assertNull(getResult.getProcessingInfo());
    assertNull(getResult.referencedAnnotationMethodClass);
    assertNull(getResult.referencedAnnotationMethod);
    assertEquals(0, getResult.getProcessingFlags());
  }

  /**
   * Test {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}.
   *
   * <ul>
   *   <li>Given {@link CharValue#CharValue(char)} with value is start of heading.
   * </ul>
   *
   * <p>Method under test: {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"KotlinAnnotation KotlinAnnotationUtilKt.convertAnnotation(KmAnnotation)"})
  public void testConvertAnnotation_givenCharValueWithValueIsStartOfHeading() {
    // Arrange
    HashMap<String, KmAnnotationArgument> arguments = new HashMap<>();
    arguments.put("kmAnnotation", new CharValue('\u0001'));

    // Act and Assert
    List<KotlinAnnotationArgument> kotlinAnnotationArgumentList =
        KotlinAnnotationUtilKt.convertAnnotation(new KmAnnotation("Class Name", arguments))
            .arguments;
    assertEquals(1, kotlinAnnotationArgumentList.size());
    KotlinAnnotationArgument getResult = kotlinAnnotationArgumentList.get(0);
    assertEquals("kmAnnotation", getResult.name);
    assertNull(getResult.getProcessingInfo());
    assertNull(getResult.referencedAnnotationMethodClass);
    assertNull(getResult.referencedAnnotationMethod);
    assertEquals(0, getResult.getProcessingFlags());
  }

  /**
   * Test {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}.
   *
   * <ul>
   *   <li>Given {@link DoubleValue#DoubleValue(double)} with value is ten.
   * </ul>
   *
   * <p>Method under test: {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"KotlinAnnotation KotlinAnnotationUtilKt.convertAnnotation(KmAnnotation)"})
  public void testConvertAnnotation_givenDoubleValueWithValueIsTen() {
    // Arrange
    HashMap<String, KmAnnotationArgument> arguments = new HashMap<>();
    arguments.put("kmAnnotation", new DoubleValue(10.0d));

    // Act and Assert
    List<KotlinAnnotationArgument> kotlinAnnotationArgumentList =
        KotlinAnnotationUtilKt.convertAnnotation(new KmAnnotation("Class Name", arguments))
            .arguments;
    assertEquals(1, kotlinAnnotationArgumentList.size());
    KotlinAnnotationArgument getResult = kotlinAnnotationArgumentList.get(0);
    assertEquals("kmAnnotation", getResult.name);
    assertNull(getResult.getProcessingInfo());
    assertNull(getResult.referencedAnnotationMethodClass);
    assertNull(getResult.referencedAnnotationMethod);
    assertEquals(0, getResult.getProcessingFlags());
  }

  /**
   * Test {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}.
   *
   * <ul>
   *   <li>Given {@link KmAnnotationArgument.FloatValue#FloatValue(float)} with value is ten.
   * </ul>
   *
   * <p>Method under test: {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"KotlinAnnotation KotlinAnnotationUtilKt.convertAnnotation(KmAnnotation)"})
  public void testConvertAnnotation_givenFloatValueWithValueIsTen() {
    // Arrange
    HashMap<String, KmAnnotationArgument> arguments = new HashMap<>();
    arguments.put("kmAnnotation", new FloatValue(10.0f));

    // Act and Assert
    List<KotlinAnnotationArgument> kotlinAnnotationArgumentList =
        KotlinAnnotationUtilKt.convertAnnotation(new KmAnnotation("Class Name", arguments))
            .arguments;
    assertEquals(1, kotlinAnnotationArgumentList.size());
    KotlinAnnotationArgument getResult = kotlinAnnotationArgumentList.get(0);
    assertEquals("kmAnnotation", getResult.name);
    assertNull(getResult.getProcessingInfo());
    assertNull(getResult.referencedAnnotationMethodClass);
    assertNull(getResult.referencedAnnotationMethod);
    assertEquals(0, getResult.getProcessingFlags());
  }

  /**
   * Test {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}.
   *
   * <ul>
   *   <li>Given {@link KmAnnotationArgument.IntValue#IntValue(int)} with value is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"KotlinAnnotation KotlinAnnotationUtilKt.convertAnnotation(KmAnnotation)"})
  public void testConvertAnnotation_givenIntValueWithValueIsFortyTwo() {
    // Arrange
    HashMap<String, KmAnnotationArgument> arguments = new HashMap<>();
    arguments.put("kmAnnotation", new IntValue(42));

    // Act and Assert
    List<KotlinAnnotationArgument> kotlinAnnotationArgumentList =
        KotlinAnnotationUtilKt.convertAnnotation(new KmAnnotation("Class Name", arguments))
            .arguments;
    assertEquals(1, kotlinAnnotationArgumentList.size());
    KotlinAnnotationArgument getResult = kotlinAnnotationArgumentList.get(0);
    assertEquals("kmAnnotation", getResult.name);
    assertNull(getResult.getProcessingInfo());
    assertNull(getResult.referencedAnnotationMethodClass);
    assertNull(getResult.referencedAnnotationMethod);
    assertEquals(0, getResult.getProcessingFlags());
  }

  /**
   * Test {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link HashMap#HashMap()} {@code kmAnnotation} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"KotlinAnnotation KotlinAnnotationUtilKt.convertAnnotation(KmAnnotation)"})
  public void testConvertAnnotation_givenNull_whenHashMapKmAnnotationIsNull() {
    // Arrange
    HashMap<String, KmAnnotationArgument> arguments = new HashMap<>();
    arguments.put("kmAnnotation", null);

    // Act and Assert
    assertThrows(
        NoWhenBranchMatchedException.class,
        () -> KotlinAnnotationUtilKt.convertAnnotation(new KmAnnotation("Class Name", arguments)));
  }

  /**
   * Test {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}.
   *
   * <ul>
   *   <li>Then return {@code Class Name}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"KotlinAnnotation KotlinAnnotationUtilKt.convertAnnotation(KmAnnotation)"})
  public void testConvertAnnotation_thenReturnClassName() {
    // Arrange and Act
    KotlinAnnotation actualConvertAnnotationResult =
        KotlinAnnotationUtilKt.convertAnnotation(new KmAnnotation("Class Name", new HashMap<>()));

    // Assert
    assertEquals("Class Name", actualConvertAnnotationResult.className);
    assertNull(actualConvertAnnotationResult.getProcessingInfo());
    assertNull(actualConvertAnnotationResult.referencedAnnotationClass);
    assertEquals(0, actualConvertAnnotationResult.getProcessingFlags());
    assertTrue(actualConvertAnnotationResult.arguments.isEmpty());
  }
}
