package proguard.classfile.util.renderer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.Constant;
import proguard.classfile.constant.DoubleConstant;

public class ConstantViewModelDiffblueTest {
  /**
   * Method under test:
   * {@link ConstantViewModel#ConstantViewModel(Clazz, Constant)}
   */
  @Test
  public void testNewConstantViewModel() {
    // Arrange
    LibraryClass clazz = new LibraryClass();

    // Act
    ConstantViewModel actualConstantViewModel = new ConstantViewModel(clazz, new ClassConstant());

    // Assert
    assertNull(actualConstantViewModel.processingInfo);
    assertTrue(actualConstantViewModel.processingFlags.isEmpty());
  }

  /**
   * Method under test: {@link ConstantViewModel#renderPreview()}
   */
  @Test
  public void testRenderPreview() {
    // Arrange
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertEquals("- Double [10.0]", (new ConstantViewModel(clazz, new DoubleConstant(10.0d))).renderPreview());
  }
}
