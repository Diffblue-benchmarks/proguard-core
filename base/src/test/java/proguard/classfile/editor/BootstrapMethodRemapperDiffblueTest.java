package proguard.classfile.editor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.constant.DynamicConstant;
import proguard.classfile.constant.InvokeDynamicConstant;

class BootstrapMethodRemapperDiffblueTest {
  /**
   * Test {@link BootstrapMethodRemapper#visitDynamicConstant(Clazz, DynamicConstant)}.
   *
   * <ul>
   *   <li>Then {@link DynamicConstant#DynamicConstant()} BootstrapMethodAttributeIndex is one.
   * </ul>
   *
   * <p>Method under test: {@link BootstrapMethodRemapper#visitDynamicConstant(Clazz,
   * DynamicConstant)}
   */
  @Test
  @DisplayName(
      "Test visitDynamicConstant(Clazz, DynamicConstant); then DynamicConstant() BootstrapMethodAttributeIndex is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BootstrapMethodRemapper.visitDynamicConstant(Clazz, DynamicConstant)"})
  void testVisitDynamicConstant_thenDynamicConstantBootstrapMethodAttributeIndexIsOne() {
    // Arrange
    BootstrapMethodRemapper bootstrapMethodRemapper = new BootstrapMethodRemapper(true);
    bootstrapMethodRemapper.setBootstrapMethodIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    DynamicConstant dynamicConstant = new DynamicConstant();

    // Act
    bootstrapMethodRemapper.visitDynamicConstant(clazz, dynamicConstant);

    // Assert
    assertEquals(1, dynamicConstant.getBootstrapMethodAttributeIndex());
  }

  /**
   * Test {@link BootstrapMethodRemapper#visitDynamicConstant(Clazz, DynamicConstant)}.
   *
   * <ul>
   *   <li>Then {@link DynamicConstant#DynamicConstant()} BootstrapMethodAttributeIndex is zero.
   * </ul>
   *
   * <p>Method under test: {@link BootstrapMethodRemapper#visitDynamicConstant(Clazz,
   * DynamicConstant)}
   */
  @Test
  @DisplayName(
      "Test visitDynamicConstant(Clazz, DynamicConstant); then DynamicConstant() BootstrapMethodAttributeIndex is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BootstrapMethodRemapper.visitDynamicConstant(Clazz, DynamicConstant)"})
  void testVisitDynamicConstant_thenDynamicConstantBootstrapMethodAttributeIndexIsZero() {
    // Arrange
    BootstrapMethodRemapper bootstrapMethodRemapper = new BootstrapMethodRemapper(true);
    bootstrapMethodRemapper.setBootstrapMethodIndexMap(new int[] {-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    DynamicConstant dynamicConstant = new DynamicConstant();

    // Act
    bootstrapMethodRemapper.visitDynamicConstant(clazz, dynamicConstant);

    // Assert that nothing has changed
    assertEquals(0, dynamicConstant.getBootstrapMethodAttributeIndex());
  }

  /**
   * Test {@link BootstrapMethodRemapper#visitDynamicConstant(Clazz, DynamicConstant)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link BootstrapMethodRemapper#visitDynamicConstant(Clazz,
   * DynamicConstant)}
   */
  @Test
  @DisplayName(
      "Test visitDynamicConstant(Clazz, DynamicConstant); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BootstrapMethodRemapper.visitDynamicConstant(Clazz, DynamicConstant)"})
  void testVisitDynamicConstant_thenThrowIllegalArgumentException() {
    // Arrange
    BootstrapMethodRemapper bootstrapMethodRemapper = new BootstrapMethodRemapper(false);
    bootstrapMethodRemapper.setBootstrapMethodIndexMap(new int[] {-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> bootstrapMethodRemapper.visitDynamicConstant(clazz, new DynamicConstant()));
  }

  /**
   * Test {@link BootstrapMethodRemapper#visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant)}.
   *
   * <p>Method under test: {@link BootstrapMethodRemapper#visitInvokeDynamicConstant(Clazz,
   * InvokeDynamicConstant)}
   */
  @Test
  @DisplayName("Test visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BootstrapMethodRemapper.visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant)"
  })
  void testVisitInvokeDynamicConstant() {
    // Arrange
    BootstrapMethodRemapper bootstrapMethodRemapper = new BootstrapMethodRemapper(true);
    bootstrapMethodRemapper.setBootstrapMethodIndexMap(new int[] {1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    InvokeDynamicConstant invokeDynamicConstant = new InvokeDynamicConstant();

    // Act
    bootstrapMethodRemapper.visitInvokeDynamicConstant(clazz, invokeDynamicConstant);

    // Assert
    assertEquals(1, invokeDynamicConstant.getBootstrapMethodAttributeIndex());
  }

  /**
   * Test {@link BootstrapMethodRemapper#visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant)}.
   *
   * <p>Method under test: {@link BootstrapMethodRemapper#visitInvokeDynamicConstant(Clazz,
   * InvokeDynamicConstant)}
   */
  @Test
  @DisplayName("Test visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BootstrapMethodRemapper.visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant)"
  })
  void testVisitInvokeDynamicConstant2() {
    // Arrange
    BootstrapMethodRemapper bootstrapMethodRemapper = new BootstrapMethodRemapper(true);
    bootstrapMethodRemapper.setBootstrapMethodIndexMap(new int[] {-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    InvokeDynamicConstant invokeDynamicConstant = new InvokeDynamicConstant();

    // Act
    bootstrapMethodRemapper.visitInvokeDynamicConstant(clazz, invokeDynamicConstant);

    // Assert that nothing has changed
    assertEquals(0, invokeDynamicConstant.getBootstrapMethodAttributeIndex());
  }

  /**
   * Test {@link BootstrapMethodRemapper#visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link BootstrapMethodRemapper#visitInvokeDynamicConstant(Clazz,
   * InvokeDynamicConstant)}
   */
  @Test
  @DisplayName(
      "Test visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BootstrapMethodRemapper.visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant)"
  })
  void testVisitInvokeDynamicConstant_thenThrowIllegalArgumentException() {
    // Arrange
    BootstrapMethodRemapper bootstrapMethodRemapper = new BootstrapMethodRemapper(false);
    bootstrapMethodRemapper.setBootstrapMethodIndexMap(new int[] {-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            bootstrapMethodRemapper.visitInvokeDynamicConstant(clazz, new InvokeDynamicConstant()));
  }
}
