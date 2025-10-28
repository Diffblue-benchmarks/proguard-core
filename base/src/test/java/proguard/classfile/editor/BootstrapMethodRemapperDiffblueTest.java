package proguard.classfile.editor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.constant.DynamicConstant;
import proguard.classfile.constant.InvokeDynamicConstant;

public class BootstrapMethodRemapperDiffblueTest {
  /**
   * Method under test:
   * {@link BootstrapMethodRemapper#visitDynamicConstant(Clazz, DynamicConstant)}
   */
  @Test
  public void testVisitDynamicConstant() {
    // Arrange
    BootstrapMethodRemapper bootstrapMethodRemapper = new BootstrapMethodRemapper(true);
    bootstrapMethodRemapper.setBootstrapMethodIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    DynamicConstant dynamicConstant = new DynamicConstant();

    // Act
    bootstrapMethodRemapper.visitDynamicConstant(clazz, dynamicConstant);

    // Assert
    assertEquals(1, dynamicConstant.getBootstrapMethodAttributeIndex());
  }

  /**
   * Method under test:
   * {@link BootstrapMethodRemapper#visitDynamicConstant(Clazz, DynamicConstant)}
   */
  @Test
  public void testVisitDynamicConstant2() {
    // Arrange
    BootstrapMethodRemapper bootstrapMethodRemapper = new BootstrapMethodRemapper(true);
    bootstrapMethodRemapper.setBootstrapMethodIndexMap(new int[]{-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    DynamicConstant dynamicConstant = new DynamicConstant();

    // Act
    bootstrapMethodRemapper.visitDynamicConstant(clazz, dynamicConstant);

    // Assert
    assertEquals(0, dynamicConstant.getBootstrapMethodAttributeIndex());
  }

  /**
   * Method under test:
   * {@link BootstrapMethodRemapper#visitDynamicConstant(Clazz, DynamicConstant)}
   */
  @Test
  public void testVisitDynamicConstant3() {
    // Arrange
    BootstrapMethodRemapper bootstrapMethodRemapper = new BootstrapMethodRemapper(false);
    bootstrapMethodRemapper.setBootstrapMethodIndexMap(new int[]{-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> bootstrapMethodRemapper.visitDynamicConstant(clazz, new DynamicConstant()));
  }

  /**
   * Method under test:
   * {@link BootstrapMethodRemapper#visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant)}
   */
  @Test
  public void testVisitInvokeDynamicConstant() {
    // Arrange
    BootstrapMethodRemapper bootstrapMethodRemapper = new BootstrapMethodRemapper(true);
    bootstrapMethodRemapper.setBootstrapMethodIndexMap(new int[]{1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    InvokeDynamicConstant invokeDynamicConstant = new InvokeDynamicConstant();

    // Act
    bootstrapMethodRemapper.visitInvokeDynamicConstant(clazz, invokeDynamicConstant);

    // Assert
    assertEquals(1, invokeDynamicConstant.getBootstrapMethodAttributeIndex());
  }

  /**
   * Method under test:
   * {@link BootstrapMethodRemapper#visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant)}
   */
  @Test
  public void testVisitInvokeDynamicConstant2() {
    // Arrange
    BootstrapMethodRemapper bootstrapMethodRemapper = new BootstrapMethodRemapper(true);
    bootstrapMethodRemapper.setBootstrapMethodIndexMap(new int[]{-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();
    InvokeDynamicConstant invokeDynamicConstant = new InvokeDynamicConstant();

    // Act
    bootstrapMethodRemapper.visitInvokeDynamicConstant(clazz, invokeDynamicConstant);

    // Assert
    assertEquals(0, invokeDynamicConstant.getBootstrapMethodAttributeIndex());
  }

  /**
   * Method under test:
   * {@link BootstrapMethodRemapper#visitInvokeDynamicConstant(Clazz, InvokeDynamicConstant)}
   */
  @Test
  public void testVisitInvokeDynamicConstant3() {
    // Arrange
    BootstrapMethodRemapper bootstrapMethodRemapper = new BootstrapMethodRemapper(false);
    bootstrapMethodRemapper.setBootstrapMethodIndexMap(new int[]{-1, 0, 1, 0});
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> bootstrapMethodRemapper.visitInvokeDynamicConstant(clazz, new InvokeDynamicConstant()));
  }
}
