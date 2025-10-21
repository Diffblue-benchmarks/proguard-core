package proguard.classfile.kotlin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.kotlin.KotlinAnnotationArgument.BooleanValue;

public class KotlinAnnotationDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KotlinAnnotation#KotlinAnnotation(String, List)}
   *   <li>{@link KotlinAnnotation#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void KotlinAnnotation.<init>(String)",
    "void KotlinAnnotation.<init>(String, List)",
    "String KotlinAnnotation.toString()"
  })
  public void testGettersAndSetters_whenArrayList() {
    // Arrange and Act
    KotlinAnnotation actualKotlinAnnotation = new KotlinAnnotation("Class Name", new ArrayList<>());

    // Assert
    assertEquals("Class Name()", actualKotlinAnnotation.toString());
    assertNull(actualKotlinAnnotation.getProcessingInfo());
    assertEquals(0, actualKotlinAnnotation.getProcessingFlags());
    assertTrue(actualKotlinAnnotation.arguments.isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Class Name}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KotlinAnnotation#KotlinAnnotation(String)}
   *   <li>{@link KotlinAnnotation#toString()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void KotlinAnnotation.<init>(String)",
    "void KotlinAnnotation.<init>(String, List)",
    "String KotlinAnnotation.toString()"
  })
  public void testGettersAndSetters_whenClassName() {
    // Arrange and Act
    KotlinAnnotation actualKotlinAnnotation = new KotlinAnnotation("Class Name");

    // Assert
    assertEquals("Class Name()", actualKotlinAnnotation.toString());
    assertNull(actualKotlinAnnotation.getProcessingInfo());
    assertEquals(0, actualKotlinAnnotation.getProcessingFlags());
    assertTrue(actualKotlinAnnotation.arguments.isEmpty());
  }

  /**
   * Test {@link KotlinAnnotation#equals(Object)}, and {@link KotlinAnnotation#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KotlinAnnotation#equals(Object)}
   *   <li>{@link KotlinAnnotation#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean KotlinAnnotation.equals(Object)", "int KotlinAnnotation.hashCode()"})
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
   * Test {@link KotlinAnnotation#equals(Object)}, and {@link KotlinAnnotation#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link KotlinAnnotation#equals(Object)}
   *   <li>{@link KotlinAnnotation#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean KotlinAnnotation.equals(Object)", "int KotlinAnnotation.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    KotlinAnnotation kotlinAnnotation = new KotlinAnnotation("Class Name");

    // Act and Assert
    assertEquals(kotlinAnnotation, kotlinAnnotation);
    int expectedHashCodeResult = kotlinAnnotation.hashCode();
    assertEquals(expectedHashCodeResult, kotlinAnnotation.hashCode());
  }

  /**
   * Test {@link KotlinAnnotation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link KotlinAnnotation#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean KotlinAnnotation.equals(Object)", "int KotlinAnnotation.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    KotlinAnnotation kotlinAnnotation =
        new KotlinAnnotation("proguard.classfile.kotlin.KotlinAnnotation");

    // Act and Assert
    assertNotEquals(kotlinAnnotation, new KotlinAnnotation("Class Name"));
  }

  /**
   * Test {@link KotlinAnnotation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link KotlinAnnotation#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean KotlinAnnotation.equals(Object)", "int KotlinAnnotation.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ArrayList<KotlinAnnotationArgument> arguments = new ArrayList<>();
    arguments.add(new KotlinAnnotationArgument("Name", new BooleanValue(true)));
    KotlinAnnotation kotlinAnnotation = new KotlinAnnotation("Class Name", arguments);

    // Act and Assert
    assertNotEquals(kotlinAnnotation, new KotlinAnnotation("Class Name"));
  }

  /**
   * Test {@link KotlinAnnotation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link KotlinAnnotation#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean KotlinAnnotation.equals(Object)", "int KotlinAnnotation.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new KotlinAnnotation("Class Name"), null);
  }

  /**
   * Test {@link KotlinAnnotation#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link KotlinAnnotation#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean KotlinAnnotation.equals(Object)", "int KotlinAnnotation.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new KotlinAnnotation("Class Name"), "Different type to KotlinAnnotation");
  }
}
