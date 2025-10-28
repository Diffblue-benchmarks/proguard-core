package proguard.classfile.util.kotlin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.metadata.KmAnnotation;
import kotlin.metadata.KmAnnotationArgument;
import org.junit.Test;
import proguard.classfile.kotlin.KotlinAnnotation;
import proguard.classfile.kotlin.KotlinAnnotationArgument;

public class KotlinAnnotationUtilKtDiffblueTest {
  /**
   * Method under test:
   * {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}
   */
  @Test
  public void testConvertAnnotation() {
    // Arrange and Act
    KotlinAnnotation actualConvertAnnotationResult = KotlinAnnotationUtilKt
        .convertAnnotation(new KmAnnotation("Class Name", new HashMap<>()));

    // Assert
    assertEquals("Class Name", actualConvertAnnotationResult.className);
    assertNull(actualConvertAnnotationResult.getProcessingInfo());
    assertNull(actualConvertAnnotationResult.referencedAnnotationClass);
    assertEquals(0, actualConvertAnnotationResult.getProcessingFlags());
    assertTrue(actualConvertAnnotationResult.arguments.isEmpty());
  }

  /**
   * Method under test:
   * {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}
   */
  @Test
  public void testConvertAnnotation2() {
    // Arrange
    HashMap<String, KmAnnotationArgument> arguments = new HashMap<>();
    arguments.put("kmAnnotation", new KmAnnotationArgument.BooleanValue(true));

    // Act
    KotlinAnnotation actualConvertAnnotationResult = KotlinAnnotationUtilKt
        .convertAnnotation(new KmAnnotation("Class Name", arguments));

    // Assert
    assertEquals("Class Name", actualConvertAnnotationResult.className);
    List<KotlinAnnotationArgument> kotlinAnnotationArgumentList = actualConvertAnnotationResult.arguments;
    assertEquals(1, kotlinAnnotationArgumentList.size());
    KotlinAnnotationArgument getResult = kotlinAnnotationArgumentList.get(0);
    assertEquals("kmAnnotation", getResult.name);
    assertNull(getResult.getProcessingInfo());
    assertNull(actualConvertAnnotationResult.getProcessingInfo());
    assertNull(actualConvertAnnotationResult.referencedAnnotationClass);
    assertNull(getResult.referencedAnnotationMethodClass);
    assertNull(getResult.referencedAnnotationMethod);
    assertEquals(0, getResult.getProcessingFlags());
    assertEquals(0, actualConvertAnnotationResult.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}
   */
  @Test
  public void testConvertAnnotation3() {
    // Arrange
    HashMap<String, KmAnnotationArgument> arguments = new HashMap<>();
    arguments.put("kmAnnotation",
        new KmAnnotationArgument.AnnotationValue(new KmAnnotation("kmAnnotation", new HashMap<>())));

    // Act
    KotlinAnnotation actualConvertAnnotationResult = KotlinAnnotationUtilKt
        .convertAnnotation(new KmAnnotation("Class Name", arguments));

    // Assert
    assertEquals("Class Name", actualConvertAnnotationResult.className);
    List<KotlinAnnotationArgument> kotlinAnnotationArgumentList = actualConvertAnnotationResult.arguments;
    assertEquals(1, kotlinAnnotationArgumentList.size());
    KotlinAnnotationArgument getResult = kotlinAnnotationArgumentList.get(0);
    assertEquals("kmAnnotation", getResult.name);
    assertNull(getResult.getProcessingInfo());
    assertNull(actualConvertAnnotationResult.getProcessingInfo());
    assertNull(actualConvertAnnotationResult.referencedAnnotationClass);
    assertNull(getResult.referencedAnnotationMethodClass);
    assertNull(getResult.referencedAnnotationMethod);
    assertEquals(0, getResult.getProcessingFlags());
    assertEquals(0, actualConvertAnnotationResult.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}
   */
  @Test
  public void testConvertAnnotation4() {
    // Arrange
    HashMap<String, KmAnnotationArgument> arguments = new HashMap<>();
    arguments.put("kmAnnotation", null);

    // Act and Assert
    assertThrows(NoWhenBranchMatchedException.class,
        () -> KotlinAnnotationUtilKt.convertAnnotation(new KmAnnotation("Class Name", arguments)));
  }

  /**
   * Method under test:
   * {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}
   */
  @Test
  public void testConvertAnnotation5() {
    // Arrange
    HashMap<String, KmAnnotationArgument> arguments = new HashMap<>();
    arguments.put("kmAnnotation", new KmAnnotationArgument.ByteValue((byte) 'A'));

    // Act
    KotlinAnnotation actualConvertAnnotationResult = KotlinAnnotationUtilKt
        .convertAnnotation(new KmAnnotation("Class Name", arguments));

    // Assert
    assertEquals("Class Name", actualConvertAnnotationResult.className);
    List<KotlinAnnotationArgument> kotlinAnnotationArgumentList = actualConvertAnnotationResult.arguments;
    assertEquals(1, kotlinAnnotationArgumentList.size());
    KotlinAnnotationArgument getResult = kotlinAnnotationArgumentList.get(0);
    assertEquals("kmAnnotation", getResult.name);
    assertNull(getResult.getProcessingInfo());
    assertNull(actualConvertAnnotationResult.getProcessingInfo());
    assertNull(actualConvertAnnotationResult.referencedAnnotationClass);
    assertNull(getResult.referencedAnnotationMethodClass);
    assertNull(getResult.referencedAnnotationMethod);
    assertEquals(0, getResult.getProcessingFlags());
    assertEquals(0, actualConvertAnnotationResult.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}
   */
  @Test
  public void testConvertAnnotation6() {
    // Arrange
    HashMap<String, KmAnnotationArgument> arguments = new HashMap<>();
    arguments.put("kmAnnotation", new KmAnnotationArgument.CharValue('\u0001'));

    // Act
    KotlinAnnotation actualConvertAnnotationResult = KotlinAnnotationUtilKt
        .convertAnnotation(new KmAnnotation("Class Name", arguments));

    // Assert
    assertEquals("Class Name", actualConvertAnnotationResult.className);
    List<KotlinAnnotationArgument> kotlinAnnotationArgumentList = actualConvertAnnotationResult.arguments;
    assertEquals(1, kotlinAnnotationArgumentList.size());
    KotlinAnnotationArgument getResult = kotlinAnnotationArgumentList.get(0);
    assertEquals("kmAnnotation", getResult.name);
    assertNull(getResult.getProcessingInfo());
    assertNull(actualConvertAnnotationResult.getProcessingInfo());
    assertNull(actualConvertAnnotationResult.referencedAnnotationClass);
    assertNull(getResult.referencedAnnotationMethodClass);
    assertNull(getResult.referencedAnnotationMethod);
    assertEquals(0, getResult.getProcessingFlags());
    assertEquals(0, actualConvertAnnotationResult.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}
   */
  @Test
  public void testConvertAnnotation7() {
    // Arrange
    HashMap<String, KmAnnotationArgument> arguments = new HashMap<>();
    arguments.put("kmAnnotation", new KmAnnotationArgument.IntValue(42));

    // Act
    KotlinAnnotation actualConvertAnnotationResult = KotlinAnnotationUtilKt
        .convertAnnotation(new KmAnnotation("Class Name", arguments));

    // Assert
    assertEquals("Class Name", actualConvertAnnotationResult.className);
    List<KotlinAnnotationArgument> kotlinAnnotationArgumentList = actualConvertAnnotationResult.arguments;
    assertEquals(1, kotlinAnnotationArgumentList.size());
    KotlinAnnotationArgument getResult = kotlinAnnotationArgumentList.get(0);
    assertEquals("kmAnnotation", getResult.name);
    assertNull(getResult.getProcessingInfo());
    assertNull(actualConvertAnnotationResult.getProcessingInfo());
    assertNull(actualConvertAnnotationResult.referencedAnnotationClass);
    assertNull(getResult.referencedAnnotationMethodClass);
    assertNull(getResult.referencedAnnotationMethod);
    assertEquals(0, getResult.getProcessingFlags());
    assertEquals(0, actualConvertAnnotationResult.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}
   */
  @Test
  public void testConvertAnnotation8() {
    // Arrange
    HashMap<String, KmAnnotationArgument> arguments = new HashMap<>();
    arguments.put("kmAnnotation", new KmAnnotationArgument.FloatValue(10.0f));

    // Act
    KotlinAnnotation actualConvertAnnotationResult = KotlinAnnotationUtilKt
        .convertAnnotation(new KmAnnotation("Class Name", arguments));

    // Assert
    assertEquals("Class Name", actualConvertAnnotationResult.className);
    List<KotlinAnnotationArgument> kotlinAnnotationArgumentList = actualConvertAnnotationResult.arguments;
    assertEquals(1, kotlinAnnotationArgumentList.size());
    KotlinAnnotationArgument getResult = kotlinAnnotationArgumentList.get(0);
    assertEquals("kmAnnotation", getResult.name);
    assertNull(getResult.getProcessingInfo());
    assertNull(actualConvertAnnotationResult.getProcessingInfo());
    assertNull(actualConvertAnnotationResult.referencedAnnotationClass);
    assertNull(getResult.referencedAnnotationMethodClass);
    assertNull(getResult.referencedAnnotationMethod);
    assertEquals(0, getResult.getProcessingFlags());
    assertEquals(0, actualConvertAnnotationResult.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}
   */
  @Test
  public void testConvertAnnotation9() {
    // Arrange
    HashMap<String, KmAnnotationArgument> arguments = new HashMap<>();
    arguments.put("kmAnnotation", new KmAnnotationArgument.DoubleValue(10.0d));

    // Act
    KotlinAnnotation actualConvertAnnotationResult = KotlinAnnotationUtilKt
        .convertAnnotation(new KmAnnotation("Class Name", arguments));

    // Assert
    assertEquals("Class Name", actualConvertAnnotationResult.className);
    List<KotlinAnnotationArgument> kotlinAnnotationArgumentList = actualConvertAnnotationResult.arguments;
    assertEquals(1, kotlinAnnotationArgumentList.size());
    KotlinAnnotationArgument getResult = kotlinAnnotationArgumentList.get(0);
    assertEquals("kmAnnotation", getResult.name);
    assertNull(getResult.getProcessingInfo());
    assertNull(actualConvertAnnotationResult.getProcessingInfo());
    assertNull(actualConvertAnnotationResult.referencedAnnotationClass);
    assertNull(getResult.referencedAnnotationMethodClass);
    assertNull(getResult.referencedAnnotationMethod);
    assertEquals(0, getResult.getProcessingFlags());
    assertEquals(0, actualConvertAnnotationResult.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}
   */
  @Test
  public void testConvertAnnotation10() {
    // Arrange
    HashMap<String, KmAnnotationArgument> arguments = new HashMap<>();
    arguments.put("kmAnnotation", new KmAnnotationArgument.ArrayKClassValue("kmAnnotation", 3));

    // Act
    KotlinAnnotation actualConvertAnnotationResult = KotlinAnnotationUtilKt
        .convertAnnotation(new KmAnnotation("Class Name", arguments));

    // Assert
    assertEquals("Class Name", actualConvertAnnotationResult.className);
    List<KotlinAnnotationArgument> kotlinAnnotationArgumentList = actualConvertAnnotationResult.arguments;
    assertEquals(1, kotlinAnnotationArgumentList.size());
    KotlinAnnotationArgument getResult = kotlinAnnotationArgumentList.get(0);
    assertEquals("kmAnnotation", getResult.name);
    assertNull(getResult.getProcessingInfo());
    assertNull(actualConvertAnnotationResult.getProcessingInfo());
    assertNull(actualConvertAnnotationResult.referencedAnnotationClass);
    assertNull(getResult.referencedAnnotationMethodClass);
    assertNull(getResult.referencedAnnotationMethod);
    assertEquals(0, getResult.getProcessingFlags());
    assertEquals(0, actualConvertAnnotationResult.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}
   */
  @Test
  public void testConvertAnnotation11() {
    // Arrange
    HashMap<String, KmAnnotationArgument> arguments = new HashMap<>();
    arguments.put("kmAnnotation", new KmAnnotationArgument.ArrayValue(new ArrayList<>()));

    // Act
    KotlinAnnotation actualConvertAnnotationResult = KotlinAnnotationUtilKt
        .convertAnnotation(new KmAnnotation("Class Name", arguments));

    // Assert
    assertEquals("Class Name", actualConvertAnnotationResult.className);
    List<KotlinAnnotationArgument> kotlinAnnotationArgumentList = actualConvertAnnotationResult.arguments;
    assertEquals(1, kotlinAnnotationArgumentList.size());
    KotlinAnnotationArgument getResult = kotlinAnnotationArgumentList.get(0);
    assertEquals("kmAnnotation", getResult.name);
    assertNull(getResult.getProcessingInfo());
    assertNull(actualConvertAnnotationResult.getProcessingInfo());
    assertNull(actualConvertAnnotationResult.referencedAnnotationClass);
    assertNull(getResult.referencedAnnotationMethodClass);
    assertNull(getResult.referencedAnnotationMethod);
    assertEquals(0, getResult.getProcessingFlags());
    assertEquals(0, actualConvertAnnotationResult.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}
   */
  @Test
  public void testConvertAnnotation12() {
    // Arrange
    HashMap<String, KmAnnotationArgument> arguments = new HashMap<>();
    arguments.put("kmAnnotation", new KmAnnotationArgument.EnumValue("kmAnnotation", "kmAnnotation"));

    // Act
    KotlinAnnotation actualConvertAnnotationResult = KotlinAnnotationUtilKt
        .convertAnnotation(new KmAnnotation("Class Name", arguments));

    // Assert
    assertEquals("Class Name", actualConvertAnnotationResult.className);
    List<KotlinAnnotationArgument> kotlinAnnotationArgumentList = actualConvertAnnotationResult.arguments;
    assertEquals(1, kotlinAnnotationArgumentList.size());
    KotlinAnnotationArgument getResult = kotlinAnnotationArgumentList.get(0);
    assertEquals("kmAnnotation", getResult.name);
    assertNull(getResult.getProcessingInfo());
    assertNull(actualConvertAnnotationResult.getProcessingInfo());
    assertNull(actualConvertAnnotationResult.referencedAnnotationClass);
    assertNull(getResult.referencedAnnotationMethodClass);
    assertNull(getResult.referencedAnnotationMethod);
    assertEquals(0, getResult.getProcessingFlags());
    assertEquals(0, actualConvertAnnotationResult.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}
   */
  @Test
  public void testConvertAnnotation13() {
    // Arrange
    ArrayList<KmAnnotationArgument> elements = new ArrayList<>();
    elements.add(new KmAnnotationArgument.BooleanValue(true));
    KmAnnotationArgument.ArrayValue arrayValue = new KmAnnotationArgument.ArrayValue(elements);

    HashMap<String, KmAnnotationArgument> arguments = new HashMap<>();
    arguments.put("kmAnnotation", arrayValue);

    // Act
    KotlinAnnotation actualConvertAnnotationResult = KotlinAnnotationUtilKt
        .convertAnnotation(new KmAnnotation("Class Name", arguments));

    // Assert
    assertEquals("Class Name", actualConvertAnnotationResult.className);
    List<KotlinAnnotationArgument> kotlinAnnotationArgumentList = actualConvertAnnotationResult.arguments;
    assertEquals(1, kotlinAnnotationArgumentList.size());
    KotlinAnnotationArgument getResult = kotlinAnnotationArgumentList.get(0);
    assertEquals("kmAnnotation", getResult.name);
    assertNull(getResult.getProcessingInfo());
    assertNull(actualConvertAnnotationResult.getProcessingInfo());
    assertNull(actualConvertAnnotationResult.referencedAnnotationClass);
    assertNull(getResult.referencedAnnotationMethodClass);
    assertNull(getResult.referencedAnnotationMethod);
    assertEquals(0, getResult.getProcessingFlags());
    assertEquals(0, actualConvertAnnotationResult.getProcessingFlags());
  }

  /**
   * Method under test:
   * {@link KotlinAnnotationUtilKt#convertAnnotation(KmAnnotation)}
   */
  @Test
  public void testConvertAnnotation14() {
    // Arrange
    ArrayList<KmAnnotationArgument> elements = new ArrayList<>();
    elements.add(null);
    KmAnnotationArgument.ArrayValue arrayValue = new KmAnnotationArgument.ArrayValue(elements);

    HashMap<String, KmAnnotationArgument> arguments = new HashMap<>();
    arguments.put("kmAnnotation", arrayValue);

    // Act and Assert
    assertThrows(NoWhenBranchMatchedException.class,
        () -> KotlinAnnotationUtilKt.convertAnnotation(new KmAnnotation("Class Name", arguments)));
  }
}
