package proguard.classfile.constant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.constant.visitor.BootstrapMethodHandleTraveler;
import proguard.classfile.constant.visitor.ConstantVisitor;

class PackageConstantDiffblueTest {
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
  @DisplayName("Test getters and setters; then return toString is 'Package(0)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.PackageConstant.<init>()",
    "void proguard.classfile.constant.PackageConstant.<init>(int)",
    "boolean proguard.classfile.constant.PackageConstant.isCategory2()",
    "java.lang.String proguard.classfile.constant.PackageConstant.toString()"
  })
  void testGettersAndSetters_thenReturnToStringIsPackage0() {
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
  @DisplayName("Test getters and setters; when one; then return toString is 'Package(1)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.PackageConstant.<init>()",
    "void proguard.classfile.constant.PackageConstant.<init>(int)",
    "boolean proguard.classfile.constant.PackageConstant.isCategory2()",
    "java.lang.String proguard.classfile.constant.PackageConstant.toString()"
  })
  void testGettersAndSetters_whenOne_thenReturnToStringIsPackage1() {
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
   * Test {@link PackageConstant#getName(Clazz)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>When {@link LibraryClass} {@link LibraryClass#getString(int)} return {@code String}.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link PackageConstant#getName(Clazz)}
   */
  @Test
  @DisplayName(
      "Test getName(Clazz); given 'String'; when LibraryClass getString(int) return 'String'; then return 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.constant.PackageConstant.getName(proguard.classfile.Clazz)"
  })
  void testGetName_givenString_whenLibraryClassGetStringReturnString_thenReturnString() {
    // Arrange
    PackageConstant packageConstant = new PackageConstant(1);
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    String actualName = packageConstant.getName(clazz);

    // Assert
    verify(clazz).getString(eq(1));
    assertEquals("String", actualName);
  }

  /**
   * Test {@link PackageConstant#getTag()}.
   *
   * <p>Method under test: {@link PackageConstant#getTag()}
   */
  @Test
  @DisplayName("Test getTag()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.constant.PackageConstant.getTag()"})
  void testGetTag() {
    // Arrange, Act and Assert
    assertEquals(Constant.PACKAGE, (new PackageConstant(1)).getTag());
  }

  /**
   * Test {@link PackageConstant#accept(Clazz, ConstantVisitor)}.
   *
   * <ul>
   *   <li>Then calls {@link ConstantVisitor#visitPackageConstant(Clazz, PackageConstant)}.
   * </ul>
   *
   * <p>Method under test: {@link PackageConstant#accept(Clazz, ConstantVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(Clazz, ConstantVisitor); then calls visitPackageConstant(Clazz, PackageConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.PackageConstant.accept(proguard.classfile.Clazz, proguard.classfile.constant.visitor.ConstantVisitor)"
  })
  void testAccept_thenCallsVisitPackageConstant() {
    // Arrange
    PackageConstant packageConstant = new PackageConstant(1);
    LibraryClass clazz = new LibraryClass();
    BootstrapMethodHandleTraveler constantVisitor = mock(BootstrapMethodHandleTraveler.class);
    doNothing()
        .when(constantVisitor)
        .visitPackageConstant(Mockito.<Clazz>any(), Mockito.<PackageConstant>any());

    // Act
    packageConstant.accept(clazz, constantVisitor);

    // Assert
    verify(constantVisitor).visitPackageConstant(isA(Clazz.class), isA(PackageConstant.class));
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.PackageConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.PackageConstant.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.PackageConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.PackageConstant.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.PackageConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.PackageConstant.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.PackageConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.PackageConstant.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean proguard.classfile.constant.PackageConstant.equals(java.lang.Object)",
    "int proguard.classfile.constant.PackageConstant.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new PackageConstant(1), "Different type to PackageConstant");
  }
}
