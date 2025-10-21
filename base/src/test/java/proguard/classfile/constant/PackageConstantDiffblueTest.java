package proguard.classfile.constant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class PackageConstantDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return toString is {@code Package(0)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PackageConstant#PackageConstant()}
   *   <li>{@link PackageConstant#toString()}
   *   <li>{@link PackageConstant#isCategory2()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void PackageConstant.<init>()",
    "void PackageConstant.<init>(int)",
    "boolean PackageConstant.isCategory2()",
    "String PackageConstant.toString()"
  })
  public void testGettersAndSetters_thenReturnToStringIsPackage0() {
    // Arrange and Act
    PackageConstant actualPackageConstant = new PackageConstant();
    String actualToStringResult = actualPackageConstant.toString();
    boolean actualIsCategory2Result = actualPackageConstant.isCategory2();

    // Assert
    assertEquals("Package(0)", actualToStringResult);
    assertNull(actualPackageConstant.getProcessingInfo());
    assertEquals(0, actualPackageConstant.getProcessingFlags());
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return toString is {@code Package(1)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PackageConstant#PackageConstant(int)}
   *   <li>{@link PackageConstant#toString()}
   *   <li>{@link PackageConstant#isCategory2()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void PackageConstant.<init>()",
    "void PackageConstant.<init>(int)",
    "boolean PackageConstant.isCategory2()",
    "String PackageConstant.toString()"
  })
  public void testGettersAndSetters_whenOne_thenReturnToStringIsPackage1() {
    // Arrange and Act
    PackageConstant actualPackageConstant = new PackageConstant(1);
    String actualToStringResult = actualPackageConstant.toString();
    boolean actualIsCategory2Result = actualPackageConstant.isCategory2();

    // Assert
    assertEquals("Package(1)", actualToStringResult);
    assertNull(actualPackageConstant.getProcessingInfo());
    assertEquals(0, actualPackageConstant.getProcessingFlags());
    assertFalse(actualIsCategory2Result);
  }

  /**
   * Test {@link PackageConstant#getTag()}.
   *
   * <p>Method under test: {@link PackageConstant#getTag()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int PackageConstant.getTag()"})
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(Constant.PACKAGE, (new PackageConstant(1)).getTag());
  }

  /**
   * Test {@link PackageConstant#equals(Object)}, and {@link PackageConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PackageConstant#equals(Object)}
   *   <li>{@link PackageConstant#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PackageConstant.equals(Object)", "int PackageConstant.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PackageConstant packageConstant = new PackageConstant(1);
    PackageConstant packageConstant2 = new PackageConstant(1);

    // Act and Assert
    assertEquals(packageConstant, packageConstant2);
    int expectedHashCodeResult = packageConstant.hashCode();
    assertEquals(expectedHashCodeResult, packageConstant2.hashCode());
  }

  /**
   * Test {@link PackageConstant#equals(Object)}, and {@link PackageConstant#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link PackageConstant#equals(Object)}
   *   <li>{@link PackageConstant#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PackageConstant.equals(Object)", "int PackageConstant.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PackageConstant packageConstant = new PackageConstant(1);

    // Act and Assert
    assertEquals(packageConstant, packageConstant);
    int expectedHashCodeResult = packageConstant.hashCode();
    assertEquals(expectedHashCodeResult, packageConstant.hashCode());
  }

  /**
   * Test {@link PackageConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PackageConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PackageConstant.equals(Object)", "int PackageConstant.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PackageConstant packageConstant = new PackageConstant(0);

    // Act and Assert
    assertNotEquals(packageConstant, new PackageConstant(1));
  }

  /**
   * Test {@link PackageConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PackageConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PackageConstant.equals(Object)", "int PackageConstant.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PackageConstant(1), null);
  }

  /**
   * Test {@link PackageConstant#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link PackageConstant#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean PackageConstant.equals(Object)", "int PackageConstant.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PackageConstant(1), "Different type to PackageConstant");
  }
}
