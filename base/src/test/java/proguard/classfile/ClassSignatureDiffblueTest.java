package proguard.classfile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class ClassSignatureDiffblueTest {
  /**
   * Method under test: {@link ClassSignature#isIncomplete()}
   */
  @Test
  public void testIsIncomplete() {
    // Arrange, Act and Assert
    assertFalse((new ClassSignature("Class Name")).isIncomplete());
  }

  /**
   * Method under test: {@link ClassSignature#calculateFqn()}
   */
  @Test
  public void testCalculateFqn() {
    // Arrange, Act and Assert
    assertEquals("Class Name", (new ClassSignature("Class Name")).calculateFqn());
  }

  /**
   * Method under test: {@link ClassSignature#calculatePrettyFqn()}
   */
  @Test
  public void testCalculatePrettyFqn() {
    // Arrange, Act and Assert
    assertEquals("Class Name", (new ClassSignature("Class Name")).calculatePrettyFqn());
  }

  /**
   * Method under test: {@link ClassSignature#computeIfAbsent(Clazz)}
   */
  @Test
  public void testComputeIfAbsent() {
    // Arrange and Act
    ClassSignature actualComputeIfAbsentResult = ClassSignature
        .computeIfAbsent(new LibraryClass(1, "This Class Name", "Super Class Name"));

    // Assert
    assertEquals("", actualComputeIfAbsentResult.getExternalPackageName());
    assertEquals("", actualComputeIfAbsentResult.getPackageName());
    assertEquals("This Class Name", actualComputeIfAbsentResult.getClassName());
    assertEquals("This Class Name", actualComputeIfAbsentResult.getFqn());
    assertEquals("This Class Name", actualComputeIfAbsentResult.getPrettyFqn());
    assertEquals("This Class Name", actualComputeIfAbsentResult.fqn);
    assertEquals("This Class Name", actualComputeIfAbsentResult.prettyFqn);
    assertNull(actualComputeIfAbsentResult.getReferencedClass());
    assertEquals(-2060103915, actualComputeIfAbsentResult.hashCode);
    assertFalse(actualComputeIfAbsentResult.isIncomplete());
  }

  /**
   * Method under test: {@link ClassSignature#ClassSignature(String)}
   */
  @Test
  public void testNewClassSignature() {
    // Arrange and Act
    ClassSignature actualClassSignature = new ClassSignature("Class Name");

    // Assert
    assertEquals("", actualClassSignature.getExternalPackageName());
    assertEquals("", actualClassSignature.getPackageName());
    assertEquals("Class Name", actualClassSignature.getClassName());
    assertEquals("Class Name", actualClassSignature.getFqn());
    assertEquals("Class Name", actualClassSignature.getPrettyFqn());
    assertEquals("Class Name", actualClassSignature.fqn);
    assertEquals("Class Name", actualClassSignature.prettyFqn);
    assertNull(actualClassSignature.getReferencedClass());
    assertEquals(1643854963, actualClassSignature.hashCode);
    assertFalse(actualClassSignature.isIncomplete());
  }

  /**
   * Method under test: {@link ClassSignature#ClassSignature(Clazz)}
   */
  @Test
  public void testNewClassSignature2() {
    // Arrange and Act
    ClassSignature actualClassSignature = new ClassSignature(
        new LibraryClass(1, "This Class Name", "Super Class Name"));

    // Assert
    assertEquals("", actualClassSignature.getExternalPackageName());
    assertEquals("", actualClassSignature.getPackageName());
    assertEquals("This Class Name", actualClassSignature.getClassName());
    assertEquals("This Class Name", actualClassSignature.getFqn());
    assertEquals("This Class Name", actualClassSignature.getPrettyFqn());
    assertEquals("This Class Name", actualClassSignature.fqn);
    assertEquals("This Class Name", actualClassSignature.prettyFqn);
    assertNull(actualClassSignature.getReferencedClass());
    assertEquals(-2060103915, actualClassSignature.hashCode);
    assertFalse(actualClassSignature.isIncomplete());
  }
}
