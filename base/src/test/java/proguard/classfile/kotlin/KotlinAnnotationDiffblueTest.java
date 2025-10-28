package proguard.classfile.kotlin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class KotlinAnnotationDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link KotlinAnnotation#equals(Object)}
   *   <li>{@link KotlinAnnotation#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    KotlinAnnotation kotlinAnnotation = new KotlinAnnotation("Class Name");
    KotlinAnnotation kotlinAnnotation2 = new KotlinAnnotation("Class Name");

    // Act and Assert
    assertEquals(kotlinAnnotation, kotlinAnnotation2);
    int expectedHashCodeResult = kotlinAnnotation.hashCode();
    assertEquals(expectedHashCodeResult, kotlinAnnotation2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link KotlinAnnotation#equals(Object)}
   *   <li>{@link KotlinAnnotation#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    KotlinAnnotation kotlinAnnotation = new KotlinAnnotation("Class Name");

    // Act and Assert
    assertEquals(kotlinAnnotation, kotlinAnnotation);
    int expectedHashCodeResult = kotlinAnnotation.hashCode();
    assertEquals(expectedHashCodeResult, kotlinAnnotation.hashCode());
  }

  /**
   * Method under test: {@link KotlinAnnotation#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    KotlinAnnotation kotlinAnnotation = new KotlinAnnotation("proguard.classfile.kotlin.KotlinAnnotation");

    // Act and Assert
    assertNotEquals(kotlinAnnotation, new KotlinAnnotation("Class Name"));
  }

  /**
   * Method under test: {@link KotlinAnnotation#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ArrayList<KotlinAnnotationArgument> arguments = new ArrayList<>();
    arguments.add(new KotlinAnnotationArgument("Name", new KotlinAnnotationArgument.BooleanValue(true)));
    KotlinAnnotation kotlinAnnotation = new KotlinAnnotation("Class Name", arguments);

    // Act and Assert
    assertNotEquals(kotlinAnnotation, new KotlinAnnotation("Class Name"));
  }

  /**
   * Method under test: {@link KotlinAnnotation#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new KotlinAnnotation("Class Name"), null);
  }

  /**
   * Method under test: {@link KotlinAnnotation#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new KotlinAnnotation("Class Name"), "Different type to KotlinAnnotation");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link KotlinAnnotation#KotlinAnnotation(String)}
   *   <li>{@link KotlinAnnotation#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    KotlinAnnotation actualKotlinAnnotation = new KotlinAnnotation("Class Name");

    // Assert
    assertEquals("Class Name()", actualKotlinAnnotation.toString());
    assertNull(actualKotlinAnnotation.getProcessingInfo());
    assertEquals(0, actualKotlinAnnotation.getProcessingFlags());
    assertTrue(actualKotlinAnnotation.arguments.isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link KotlinAnnotation#KotlinAnnotation(String, List)}
   *   <li>{@link KotlinAnnotation#toString()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
    // Arrange and Act
    KotlinAnnotation actualKotlinAnnotation = new KotlinAnnotation("Class Name", new ArrayList<>());

    // Assert
    assertEquals("Class Name()", actualKotlinAnnotation.toString());
    assertNull(actualKotlinAnnotation.getProcessingInfo());
    assertEquals(0, actualKotlinAnnotation.getProcessingFlags());
    assertTrue(actualKotlinAnnotation.arguments.isEmpty());
  }
}
