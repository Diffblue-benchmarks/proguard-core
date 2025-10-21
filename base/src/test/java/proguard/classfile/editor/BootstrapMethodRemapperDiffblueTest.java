package proguard.classfile.editor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.constant.DynamicConstant;
import proguard.classfile.constant.InvokeDynamicConstant;

public class BootstrapMethodRemapperDiffblueTest {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BootstrapMethodRemapper.visitDynamicConstant(Clazz, DynamicConstant)"})
  public void testVisitDynamicConstant_thenDynamicConstantBootstrapMethodAttributeIndexIsOne() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BootstrapMethodRemapper.visitDynamicConstant(Clazz, DynamicConstant)"})
  public void testVisitDynamicConstant_thenDynamicConstantBootstrapMethodAttributeIndexIsZero() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BootstrapMethodRemapper.visitDynamicConstant(Clazz, DynamicConstant)"})
  public void testVisitDynamicConstant_thenThrowIllegalArgumentException() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void BootstrapMethodRemapper.visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant)"
  })
  public void testVisitInvokeDynamicConstant() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void BootstrapMethodRemapper.visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant)"
  })
  public void testVisitInvokeDynamicConstant2() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void BootstrapMethodRemapper.visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant)"
  })
  public void testVisitInvokeDynamicConstant_thenThrowIllegalArgumentException() {
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
