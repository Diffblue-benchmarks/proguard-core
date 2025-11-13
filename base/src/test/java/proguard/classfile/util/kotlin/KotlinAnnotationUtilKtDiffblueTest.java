package proguard.classfile.util.kotlin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.kotlin.KotlinAnnotation;
import proguard.classfile.kotlin.KotlinAnnotationArgument;

class KotlinAnnotationUtilKtDiffblueTest {
  /**
   * Test {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}.
   *
   * <p>Method under test: {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}
   */
  @Test
  @DisplayName("Test convertAnnotation(KmAnnotation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"KotlinAnnotation KotlinAnnotationUtilKt.convertAnnotation(KmAnnotation)"})
  void testConvertAnnotation() {
    // Arrange
    HashMap<String, KmAnnotationArgument> arguments = new HashMap<>();
    KmAnnotation annotation = new KmAnnotation("kmAnnotation", new HashMap<>());
    arguments.put("kmAnnotation", new AnnotationValue(annotation));
    KmAnnotation kmAnnotation = new KmAnnotation("Class Name", arguments);

    // Act and Assert
    List<KotlinAnnotationArgument> kotlinAnnotationArgumentList =
        KotlinAnnotationUtilKt.convertAnnotation(kmAnnotation).arguments;
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
  @DisplayName("Test convertAnnotation(KmAnnotation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"KotlinAnnotation KotlinAnnotationUtilKt.convertAnnotation(KmAnnotation)"})
  void testConvertAnnotation2() {
    // Arrange
    HashMap<String, KmAnnotationArgument> arguments = new HashMap<>();
    arguments.put("kmAnnotation", new ArrayKClassValue("kmAnnotation", 3));
    KmAnnotation kmAnnotation = new KmAnnotation("Class Name", arguments);

    // Act and Assert
    List<KotlinAnnotationArgument> kotlinAnnotationArgumentList =
        KotlinAnnotationUtilKt.convertAnnotation(kmAnnotation).arguments;
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
  @DisplayName("Test convertAnnotation(KmAnnotation)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"KotlinAnnotation KotlinAnnotationUtilKt.convertAnnotation(KmAnnotation)"})
  void testConvertAnnotation3() {
    // Arrange
    HashMap<String, KmAnnotationArgument> arguments = new HashMap<>();
    arguments.put("kmAnnotation", new EnumValue("kmAnnotation", "kmAnnotation"));
    KmAnnotation kmAnnotation = new KmAnnotation("Class Name", arguments);

    // Act and Assert
    List<KotlinAnnotationArgument> kotlinAnnotationArgumentList =
        KotlinAnnotationUtilKt.convertAnnotation(kmAnnotation).arguments;
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
   *   <li>Given {@link ArrayList#ArrayList()} add {@link BooleanValue#BooleanValue(boolean)} with
   *       value is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}
   */
  @Test
  @DisplayName(
      "Test convertAnnotation(KmAnnotation); given ArrayList() add BooleanValue(boolean) with value is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"KotlinAnnotation KotlinAnnotationUtilKt.convertAnnotation(KmAnnotation)"})
  void testConvertAnnotation_givenArrayListAddBooleanValueWithValueIsTrue() {
    // Arrange
    ArrayList<KmAnnotationArgument> elements = new ArrayList<>();
    elements.add(new BooleanValue(true));
    ArrayValue arrayValue = new ArrayValue(elements);

    HashMap<String, KmAnnotationArgument> arguments = new HashMap<>();
    arguments.put("kmAnnotation", arrayValue);
    KmAnnotation kmAnnotation = new KmAnnotation("Class Name", arguments);

    // Act and Assert
    List<KotlinAnnotationArgument> kotlinAnnotationArgumentList =
        KotlinAnnotationUtilKt.convertAnnotation(kmAnnotation).arguments;
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
  @DisplayName("Test convertAnnotation(KmAnnotation); given ArrayList() add 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"KotlinAnnotation KotlinAnnotationUtilKt.convertAnnotation(KmAnnotation)"})
  void testConvertAnnotation_givenArrayListAddNull() {
    // Arrange
    ArrayList<KmAnnotationArgument> elements = new ArrayList<>();
    elements.add(null);
    ArrayValue arrayValue = new ArrayValue(elements);

    HashMap<String, KmAnnotationArgument> arguments = new HashMap<>();
    arguments.put("kmAnnotation", arrayValue);
    KmAnnotation kmAnnotation = new KmAnnotation("Class Name", arguments);

    // Act and Assert
    assertThrows(
        NoWhenBranchMatchedException.class,
        () -> KotlinAnnotationUtilKt.convertAnnotation(kmAnnotation));
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
  @DisplayName(
      "Test convertAnnotation(KmAnnotation); given ArrayValue(List) with elements is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"KotlinAnnotation KotlinAnnotationUtilKt.convertAnnotation(KmAnnotation)"})
  void testConvertAnnotation_givenArrayValueWithElementsIsArrayList() {
    // Arrange
    HashMap<String, KmAnnotationArgument> arguments = new HashMap<>();
    arguments.put("kmAnnotation", new ArrayValue(new ArrayList<>()));
    KmAnnotation kmAnnotation = new KmAnnotation("Class Name", arguments);

    // Act and Assert
    List<KotlinAnnotationArgument> kotlinAnnotationArgumentList =
        KotlinAnnotationUtilKt.convertAnnotation(kmAnnotation).arguments;
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
   *   <li>Given {@link BooleanValue#BooleanValue(boolean)} with value is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}
   */
  @Test
  @DisplayName(
      "Test convertAnnotation(KmAnnotation); given BooleanValue(boolean) with value is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"KotlinAnnotation KotlinAnnotationUtilKt.convertAnnotation(KmAnnotation)"})
  void testConvertAnnotation_givenBooleanValueWithValueIsTrue() {
    // Arrange
    HashMap<String, KmAnnotationArgument> arguments = new HashMap<>();
    arguments.put("kmAnnotation", new BooleanValue(true));
    KmAnnotation kmAnnotation = new KmAnnotation("Class Name", arguments);

    // Act and Assert
    List<KotlinAnnotationArgument> kotlinAnnotationArgumentList =
        KotlinAnnotationUtilKt.convertAnnotation(kmAnnotation).arguments;
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
  @DisplayName("Test convertAnnotation(KmAnnotation); given ByteValue(byte) with value is 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"KotlinAnnotation KotlinAnnotationUtilKt.convertAnnotation(KmAnnotation)"})
  void testConvertAnnotation_givenByteValueWithValueIsA() {
    // Arrange
    HashMap<String, KmAnnotationArgument> arguments = new HashMap<>();
    arguments.put("kmAnnotation", new ByteValue((byte) 'A'));
    KmAnnotation kmAnnotation = new KmAnnotation("Class Name", arguments);

    // Act and Assert
    List<KotlinAnnotationArgument> kotlinAnnotationArgumentList =
        KotlinAnnotationUtilKt.convertAnnotation(kmAnnotation).arguments;
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
  @DisplayName(
      "Test convertAnnotation(KmAnnotation); given CharValue(char) with value is start of heading")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"KotlinAnnotation KotlinAnnotationUtilKt.convertAnnotation(KmAnnotation)"})
  void testConvertAnnotation_givenCharValueWithValueIsStartOfHeading() {
    // Arrange
    HashMap<String, KmAnnotationArgument> arguments = new HashMap<>();
    arguments.put("kmAnnotation", new CharValue('\u0001'));
    KmAnnotation kmAnnotation = new KmAnnotation("Class Name", arguments);

    // Act and Assert
    List<KotlinAnnotationArgument> kotlinAnnotationArgumentList =
        KotlinAnnotationUtilKt.convertAnnotation(kmAnnotation).arguments;
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
   *   <li>Given {@link KmAnnotationArgument.DoubleValue#DoubleValue(double)} with value is ten.
   * </ul>
   *
   * <p>Method under test: {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}
   */
  @Test
  @DisplayName("Test convertAnnotation(KmAnnotation); given DoubleValue(double) with value is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"KotlinAnnotation KotlinAnnotationUtilKt.convertAnnotation(KmAnnotation)"})
  void testConvertAnnotation_givenDoubleValueWithValueIsTen() {
    // Arrange
    HashMap<String, KmAnnotationArgument> arguments = new HashMap<>();
    arguments.put("kmAnnotation", new DoubleValue(10.0d));
    KmAnnotation kmAnnotation = new KmAnnotation("Class Name", arguments);

    // Act and Assert
    List<KotlinAnnotationArgument> kotlinAnnotationArgumentList =
        KotlinAnnotationUtilKt.convertAnnotation(kmAnnotation).arguments;
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
  @DisplayName("Test convertAnnotation(KmAnnotation); given FloatValue(float) with value is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"KotlinAnnotation KotlinAnnotationUtilKt.convertAnnotation(KmAnnotation)"})
  void testConvertAnnotation_givenFloatValueWithValueIsTen() {
    // Arrange
    HashMap<String, KmAnnotationArgument> arguments = new HashMap<>();
    arguments.put("kmAnnotation", new FloatValue(10.0f));
    KmAnnotation kmAnnotation = new KmAnnotation("Class Name", arguments);

    // Act and Assert
    List<KotlinAnnotationArgument> kotlinAnnotationArgumentList =
        KotlinAnnotationUtilKt.convertAnnotation(kmAnnotation).arguments;
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
  @DisplayName("Test convertAnnotation(KmAnnotation); given IntValue(int) with value is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"KotlinAnnotation KotlinAnnotationUtilKt.convertAnnotation(KmAnnotation)"})
  void testConvertAnnotation_givenIntValueWithValueIsFortyTwo() {
    // Arrange
    HashMap<String, KmAnnotationArgument> arguments = new HashMap<>();
    arguments.put("kmAnnotation", new IntValue(42));
    KmAnnotation kmAnnotation = new KmAnnotation("Class Name", arguments);

    // Act and Assert
    List<KotlinAnnotationArgument> kotlinAnnotationArgumentList =
        KotlinAnnotationUtilKt.convertAnnotation(kmAnnotation).arguments;
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
  @DisplayName(
      "Test convertAnnotation(KmAnnotation); given 'null'; when HashMap() 'kmAnnotation' is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"KotlinAnnotation KotlinAnnotationUtilKt.convertAnnotation(KmAnnotation)"})
  void testConvertAnnotation_givenNull_whenHashMapKmAnnotationIsNull() {
    // Arrange
    HashMap<String, KmAnnotationArgument> arguments = new HashMap<>();
    arguments.put("kmAnnotation", null);
    KmAnnotation kmAnnotation = new KmAnnotation("Class Name", arguments);

    // Act and Assert
    assertThrows(
        NoWhenBranchMatchedException.class,
        () -> KotlinAnnotationUtilKt.convertAnnotation(kmAnnotation));
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
  @DisplayName("Test convertAnnotation(KmAnnotation); then return 'Class Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"KotlinAnnotation KotlinAnnotationUtilKt.convertAnnotation(KmAnnotation)"})
  void testConvertAnnotation_thenReturnClassName() {
    // Arrange
    KmAnnotation kmAnnotation = new KmAnnotation("Class Name", new HashMap<>());

    // Act
    KotlinAnnotation actualConvertAnnotationResult =
        KotlinAnnotationUtilKt.convertAnnotation(kmAnnotation);

    // Assert
    assertEquals("Class Name", actualConvertAnnotationResult.className);
    assertNull(actualConvertAnnotationResult.getProcessingInfo());
    assertNull(actualConvertAnnotationResult.referencedAnnotationClass);
    assertEquals(0, actualConvertAnnotationResult.getProcessingFlags());
    assertTrue(actualConvertAnnotationResult.arguments.isEmpty());
  }
}
