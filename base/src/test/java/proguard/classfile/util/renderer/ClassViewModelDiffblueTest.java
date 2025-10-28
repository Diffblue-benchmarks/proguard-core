package proguard.classfile.util.renderer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.util.ProcessingFlags;

public class ClassViewModelDiffblueTest {
  /**
   * Method under test: {@link ClassViewModel#render(Clazz)}
   */
  @Test
  public void testRender() {
    // Arrange and Act
    ClassViewModel actualRenderResult = ClassViewModel
        .render(new LibraryClass(1, "This Class Name", "Super Class Name"));

    // Assert
    assertNull(actualRenderResult.processingInfo);
    assertTrue(actualRenderResult.processingFlags.isEmpty());
  }

  /**
   * Method under test: {@link ClassViewModel#render(Clazz, Class)}
   */
  @Test
  public void testRender2() {
    // Arrange
    LibraryClass clazz = new LibraryClass(1, "This Class Name", "Super Class Name");

    Class<ProcessingFlags> processingFlagsHolder = ProcessingFlags.class;

    // Act
    ClassViewModel actualRenderResult = ClassViewModel.render(clazz, processingFlagsHolder);

    // Assert
    assertNull(actualRenderResult.processingInfo);
    assertTrue(actualRenderResult.processingFlags.isEmpty());
  }

  /**
   * Method under test: {@link ClassViewModel#renderPreview(Clazz)}
   */
  @Test
  public void testRenderPreview() {
    // Arrange, Act and Assert
    assertEquals("class null", ClassViewModel.renderPreview(new LibraryClass()));
    assertEquals("interface class ", ClassViewModel.renderPreview(new LibraryClass(512, "class ", "class ")));
    assertEquals("private final class class ", ClassViewModel.renderPreview(new LibraryClass(50, "class ", "class ")));
    assertEquals("public class class ", ClassViewModel.renderPreview(new LibraryClass(1, "class ", "class ")));
    assertEquals("protected class class ", ClassViewModel.renderPreview(new LibraryClass(4, "class ", "class ")));
    assertEquals("static class class ", ClassViewModel.renderPreview(new LibraryClass(8, "class ", "class ")));
    assertEquals("public private protected static final @interface class ",
        ClassViewModel.renderPreview(new LibraryClass(-1, "class ", "class ")));
  }

  /**
   * Method under test: {@link ClassViewModel#renderSuperClass(Clazz)}
   */
  @Test
  public void testRenderSuperClass() {
    // Arrange, Act and Assert
    assertNull(ClassViewModel.renderSuperClass(new LibraryClass()));
  }

  /**
   * Method under test: {@link ClassViewModel#renderSuperClass(Clazz)}
   */
  @Test
  public void testRenderSuperClass2() {
    // Arrange
    LibraryClass model = new LibraryClass();
    model.superClass = new LibraryClass();

    // Act
    ClassViewModel actualRenderSuperClassResult = ClassViewModel.renderSuperClass(model);

    // Assert
    assertNull(actualRenderSuperClassResult.processingInfo);
    assertNull(actualRenderSuperClassResult.processingFlags);
  }

  /**
   * Method under test: {@link ClassViewModel#renderInterfaces(Clazz)}
   */
  @Test
  public void testRenderInterfaces() {
    // Arrange, Act and Assert
    assertEquals(0, ClassViewModel.renderInterfaces(new LibraryClass()).length);
  }

  /**
   * Method under test: {@link ClassViewModel#renderConstantPool(Clazz)}
   */
  @Test
  public void testRenderConstantPool() {
    // Arrange and Act
    ConstantViewModel[] actualRenderConstantPoolResult = ClassViewModel.renderConstantPool(new LibraryClass());

    // Assert
    assertNull(actualRenderConstantPoolResult[0]);
    assertEquals(1, actualRenderConstantPoolResult.length);
  }

  /**
   * Method under test: {@link ClassViewModel#renderFields(Clazz)}
   */
  @Test
  public void testRenderFields() {
    // Arrange, Act and Assert
    assertEquals(0, ClassViewModel.renderFields(new LibraryClass(1, "This Class Name", "Super Class Name")).length);
  }

  /**
   * Method under test: {@link ClassViewModel#renderMethods(Clazz)}
   */
  @Test
  public void testRenderMethods() {
    // Arrange, Act and Assert
    assertEquals(0, ClassViewModel.renderMethods(new LibraryClass(1, "This Class Name", "Super Class Name")).length);
  }
}
