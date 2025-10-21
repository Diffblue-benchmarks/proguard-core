package proguard.classfile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ClassSignatureDiffblueTest {
  /**
   * Test {@link ClassSignature#ClassSignature(String)}.
   *
   * <p>Method under test: {@link ClassSignature#ClassSignature(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassSignature.<init>(String)"})
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
   * Test {@link ClassSignature#ClassSignature(Clazz)}.
   *
   * <ul>
   *   <li>Then return ExternalPackageName is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ClassSignature#ClassSignature(Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassSignature.<init>(Clazz)"})
  public void testNewClassSignature_thenReturnExternalPackageNameIsEmptyString() {
    // Arrange and Act
    ClassSignature actualClassSignature =
        new ClassSignature(new LibraryClass(1, "This Class Name", "Super Class Name"));

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

  /**
   * Test {@link ClassSignature#isIncomplete()}.
   *
   * <p>Method under test: {@link ClassSignature#isIncomplete()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ClassSignature.isIncomplete()"})
  public void testIsIncomplete() {
    // Arrange, Act and Assert
    assertFalse((new ClassSignature("Class Name")).isIncomplete());
  }

  /**
   * Test {@link ClassSignature#calculateFqn()}.
   *
   * <p>Method under test: {@link ClassSignature#calculateFqn()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ClassSignature.calculateFqn()"})
  public void testCalculateFqn() {
    // Arrange, Act and Assert
    assertEquals("Class Name", (new ClassSignature("Class Name")).calculateFqn());
  }

  /**
   * Test {@link ClassSignature#calculatePrettyFqn()}.
   *
   * <p>Method under test: {@link ClassSignature#calculatePrettyFqn()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ClassSignature.calculatePrettyFqn()"})
  public void testCalculatePrettyFqn() {
    // Arrange, Act and Assert
    assertEquals("Class Name", (new ClassSignature("Class Name")).calculatePrettyFqn());
  }

  /**
   * Test {@link ClassSignature#computeIfAbsent(Clazz)} with {@code clazz}.
   *
   * <ul>
   *   <li>Then return ExternalPackageName is empty string.
   * </ul>
   *
   * <p>Method under test: {@link ClassSignature#computeIfAbsent(Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ClassSignature ClassSignature.computeIfAbsent(Clazz)"})
  public void testComputeIfAbsentWithClazz_thenReturnExternalPackageNameIsEmptyString() {
    // Arrange and Act
    ClassSignature actualComputeIfAbsentResult =
        ClassSignature.computeIfAbsent(new LibraryClass(1, "This Class Name", "Super Class Name"));

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
}
