package proguard.classfile.constant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class PackageConstantDiffblueTest {
  /**
   * Method under test: {@link PackageConstant#getTag()}
   */
  @Test
  public void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(Constant.PACKAGE, (new PackageConstant(1)).getTag());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PackageConstant#equals(Object)}
   *   <li>{@link PackageConstant#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link PackageConstant#equals(Object)}
   *   <li>{@link PackageConstant#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PackageConstant packageConstant = new PackageConstant(1);

    // Act and Assert
    assertEquals(packageConstant, packageConstant);
    int expectedHashCodeResult = packageConstant.hashCode();
    assertEquals(expectedHashCodeResult, packageConstant.hashCode());
  }

  /**
   * Method under test: {@link PackageConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PackageConstant packageConstant = new PackageConstant(0);

    // Act and Assert
    assertNotEquals(packageConstant, new PackageConstant(1));
  }

  /**
   * Method under test: {@link PackageConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PackageConstant(1), null);
  }

  /**
   * Method under test: {@link PackageConstant#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PackageConstant(1), "Different type to PackageConstant");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PackageConstant#PackageConstant()}
   *   <li>{@link PackageConstant#toString()}
   *   <li>{@link PackageConstant#isCategory2()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
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
   * Methods under test:
   * <ul>
   *   <li>{@link PackageConstant#PackageConstant(int)}
   *   <li>{@link PackageConstant#toString()}
   *   <li>{@link PackageConstant#isCategory2()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters2() {
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
}
