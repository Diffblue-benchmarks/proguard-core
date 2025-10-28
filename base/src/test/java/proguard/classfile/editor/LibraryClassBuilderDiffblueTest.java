package proguard.classfile.editor;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.LibraryMethod;
import proguard.classfile.kotlin.KotlinClassKindMetadata;
import proguard.classfile.kotlin.KotlinMetadata;
import proguard.classfile.visitor.MemberVisitor;

public class LibraryClassBuilderDiffblueTest {
  /**
   * Method under test: {@link LibraryClassBuilder#getLibraryClass()}
   */
  @Test
  public void testGetLibraryClass() {
    // Arrange and Act
    LibraryClass actualLibraryClass = (new LibraryClassBuilder(1, "Class Name", "Superclass Name")).getLibraryClass();

    // Assert
    assertEquals("Class Name", actualLibraryClass.getName());
    assertEquals("Superclass Name", actualLibraryClass.getSuperName());
    assertNull(actualLibraryClass.getProcessingInfo());
    assertNull(actualLibraryClass.getFeatureName());
    assertNull(actualLibraryClass.getSuperClass());
    assertNull(actualLibraryClass.kotlinMetadata);
    assertEquals(0, actualLibraryClass.getInterfaceCount());
    assertEquals(0, actualLibraryClass.getProcessingFlags());
    assertEquals(0, actualLibraryClass.fields.length);
    assertEquals(0, actualLibraryClass.interfaceClasses.length);
    assertEquals(0, actualLibraryClass.interfaceNames.length);
    assertEquals(0, actualLibraryClass.methods.length);
    assertEquals(0, actualLibraryClass.subClasses.length);
    assertEquals(0, actualLibraryClass.subClassCount);
    assertEquals(1, actualLibraryClass.getAccessFlags());
    assertTrue(actualLibraryClass.getExtraFeatureNames().isEmpty());
  }

  /**
   * Method under test: {@link LibraryClassBuilder#getConstantPoolEditor()}
   */
  @Test
  public void testGetConstantPoolEditor() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new LibraryClassBuilder(1, "Class Name", "Superclass Name")).getConstantPoolEditor());
  }

  /**
   * Method under test: {@link LibraryClassBuilder#addInterface(String)}
   */
  @Test
  public void testAddInterface() {
    // Arrange
    LibraryClassBuilder libraryClassBuilder = new LibraryClassBuilder(1, "Class Name", "Superclass Name");

    // Act and Assert
    assertSame(libraryClassBuilder, libraryClassBuilder.addInterface("Interface Name"));
  }

  /**
   * Method under test: {@link LibraryClassBuilder#addInterface(String, Clazz)}
   */
  @Test
  public void testAddInterface2() {
    // Arrange
    LibraryClassBuilder libraryClassBuilder = new LibraryClassBuilder(1, "Class Name", "Superclass Name");

    // Act and Assert
    assertSame(libraryClassBuilder, libraryClassBuilder.addInterface("Interface Name", new LibraryClass()));
  }

  /**
   * Method under test: {@link LibraryClassBuilder#addInterface(Clazz)}
   */
  @Test
  public void testAddInterface3() {
    // Arrange
    LibraryClassBuilder libraryClassBuilder = new LibraryClassBuilder(1, "Class Name", "Superclass Name");

    // Act and Assert
    assertSame(libraryClassBuilder, libraryClassBuilder.addInterface(new LibraryClass()));
  }

  /**
   * Method under test: {@link LibraryClassBuilder#addField(int, String, String)}
   */
  @Test
  public void testAddField() {
    // Arrange
    LibraryClassBuilder libraryClassBuilder = new LibraryClassBuilder(1, "Class Name", "Superclass Name");

    // Act and Assert
    assertSame(libraryClassBuilder, libraryClassBuilder.addField(2, "Field Name", "Field Descriptor"));
  }

  /**
   * Method under test:
   * {@link LibraryClassBuilder#addField(int, String, String, MemberVisitor)}
   */
  @Test
  public void testAddField2() {
    // Arrange
    LibraryClassBuilder libraryClassBuilder = new LibraryClassBuilder(1, "Class Name", "Superclass Name");

    // Act and Assert
    assertSame(libraryClassBuilder, libraryClassBuilder.addField(2, "Field Name", "Field Descriptor", null));
  }

  /**
   * Method under test:
   * {@link LibraryClassBuilder#addField(int, String, String, MemberVisitor)}
   */
  @Test
  public void testAddField3() {
    // Arrange
    LibraryClassBuilder libraryClassBuilder = new LibraryClassBuilder(1, "Class Name", "Superclass Name");

    // Act and Assert
    assertSame(libraryClassBuilder,
        libraryClassBuilder.addField(2, "Field Name", "Field Descriptor", new ConstantPoolRemapper()));
  }

  /**
   * Method under test:
   * {@link LibraryClassBuilder#addField(int, String, String, MemberVisitor)}
   */
  @Test
  public void testAddField4() {
    // Arrange
    LibraryClassBuilder libraryClassBuilder = new LibraryClassBuilder(1, "Class Name", "Superclass Name");

    // Act and Assert
    assertSame(libraryClassBuilder,
        libraryClassBuilder.addField(2, "Field Name", "Field Descriptor", new MemberRemover()));
  }

  /**
   * Method under test:
   * {@link LibraryClassBuilder#addAndReturnField(int, String, String)}
   */
  @Test
  public void testAddAndReturnField() {
    // Arrange
    LibraryClassBuilder libraryClassBuilder = new LibraryClassBuilder(1, "Class Name", "Superclass Name");

    // Act
    LibraryField actualAddAndReturnFieldResult = libraryClassBuilder.addAndReturnField(2, "Field Name",
        "Field Descriptor");

    // Assert
    assertEquals("Field Descriptor", actualAddAndReturnFieldResult.descriptor);
    assertEquals("Field Name", actualAddAndReturnFieldResult.name);
    assertNull(actualAddAndReturnFieldResult.getProcessingInfo());
    assertNull(actualAddAndReturnFieldResult.referencedClass);
    assertEquals(0, actualAddAndReturnFieldResult.getProcessingFlags());
    assertEquals(1, libraryClassBuilder.getLibraryClass().fields.length);
    assertEquals(2, actualAddAndReturnFieldResult.getAccessFlags());
  }

  /**
   * Method under test: {@link LibraryClassBuilder#addMethod(int, String, String)}
   */
  @Test
  public void testAddMethod() {
    // Arrange
    LibraryClassBuilder libraryClassBuilder = new LibraryClassBuilder(1, "Class Name", "Superclass Name");

    // Act and Assert
    assertSame(libraryClassBuilder, libraryClassBuilder.addMethod(2, "Method Name", "Method Descriptor"));
  }

  /**
   * Method under test:
   * {@link LibraryClassBuilder#addMethod(int, String, String, MemberVisitor)}
   */
  @Test
  public void testAddMethod2() {
    // Arrange
    LibraryClassBuilder libraryClassBuilder = new LibraryClassBuilder(1, "Class Name", "Superclass Name");

    // Act and Assert
    assertSame(libraryClassBuilder, libraryClassBuilder.addMethod(2, "Method Name", "Method Descriptor", null));
  }

  /**
   * Method under test:
   * {@link LibraryClassBuilder#addMethod(int, String, String, MemberVisitor)}
   */
  @Test
  public void testAddMethod3() {
    // Arrange
    LibraryClassBuilder libraryClassBuilder = new LibraryClassBuilder(1, "Class Name", "Superclass Name");

    // Act and Assert
    assertSame(libraryClassBuilder,
        libraryClassBuilder.addMethod(2, "Method Name", "Method Descriptor", new ConstantPoolRemapper()));
  }

  /**
   * Method under test:
   * {@link LibraryClassBuilder#addMethod(int, String, String, MemberVisitor)}
   */
  @Test
  public void testAddMethod4() {
    // Arrange
    LibraryClassBuilder libraryClassBuilder = new LibraryClassBuilder(1, "Class Name", "Superclass Name");

    // Act and Assert
    assertSame(libraryClassBuilder,
        libraryClassBuilder.addMethod(2, "Method Name", "Method Descriptor", new MemberRemover()));
  }

  /**
   * Method under test:
   * {@link LibraryClassBuilder#addAndReturnMethod(int, String, String)}
   */
  @Test
  public void testAddAndReturnMethod() {
    // Arrange
    LibraryClassBuilder libraryClassBuilder = new LibraryClassBuilder(1, "Class Name", "Superclass Name");

    // Act
    LibraryMethod actualAddAndReturnMethodResult = libraryClassBuilder.addAndReturnMethod(2, "Method Name",
        "Method Descriptor");

    // Assert
    assertEquals("Method Descriptor", actualAddAndReturnMethodResult.descriptor);
    assertEquals("Method Name", actualAddAndReturnMethodResult.name);
    assertNull(actualAddAndReturnMethodResult.referencedClasses);
    assertNull(actualAddAndReturnMethodResult.getProcessingInfo());
    assertEquals(0, actualAddAndReturnMethodResult.getProcessingFlags());
    assertEquals(1, libraryClassBuilder.getLibraryClass().methods.length);
    assertEquals(2, actualAddAndReturnMethodResult.getAccessFlags());
  }

  /**
   * Method under test:
   * {@link LibraryClassBuilder#LibraryClassBuilder(int, String, String)}
   */
  @Test
  public void testNewLibraryClassBuilder() {
    // Arrange, Act and Assert
    LibraryClass libraryClass = (new LibraryClassBuilder(1, "Class Name", "Superclass Name")).getLibraryClass();
    assertEquals("Class Name", libraryClass.getName());
    assertEquals("Superclass Name", libraryClass.getSuperName());
    assertNull(libraryClass.getProcessingInfo());
    assertNull(libraryClass.getFeatureName());
    assertNull(libraryClass.getSuperClass());
    assertNull(libraryClass.kotlinMetadata);
    assertEquals(0, libraryClass.getInterfaceCount());
    assertEquals(0, libraryClass.getProcessingFlags());
    assertEquals(0, libraryClass.fields.length);
    Clazz[] clazzArray = libraryClass.interfaceClasses;
    assertEquals(0, clazzArray.length);
    assertEquals(0, libraryClass.interfaceNames.length);
    assertEquals(0, libraryClass.methods.length);
    assertEquals(0, libraryClass.subClassCount);
    assertEquals(1, libraryClass.getAccessFlags());
    assertTrue(libraryClass.getExtraFeatureNames().isEmpty());
    assertSame(clazzArray, libraryClass.subClasses);
  }

  /**
   * Method under test:
   * {@link LibraryClassBuilder#LibraryClassBuilder(int, String, String, String[], Clazz[], int, Clazz[], LibraryField[], LibraryMethod[], KotlinMetadata)}
   */
  @Test
  public void testNewLibraryClassBuilder2() {
    // Arrange
    String[] interfaceNames = new String[]{"Interface Names"};
    Clazz[] interfaceClasses = new Clazz[]{new LibraryClass()};
    Clazz[] subClasses = new Clazz[]{new LibraryClass()};
    LibraryField[] fields = new LibraryField[]{new LibraryField(1, "Name", "Descriptor")};
    LibraryMethod[] methods = new LibraryMethod[]{new LibraryMethod(1, "Name", "Descriptor")};
    KotlinClassKindMetadata kotlinMetadata = new KotlinClassKindMetadata(new int[]{1, -1, 1, -1}, 1, "Xs", "Pn");

    // Act and Assert
    LibraryClass libraryClass = (new LibraryClassBuilder(1, "Class Name", "Superclass Name", interfaceNames,
        interfaceClasses, 3, subClasses, fields, methods, kotlinMetadata)).getLibraryClass();
    assertEquals("Class Name", libraryClass.getName());
    assertEquals("Superclass Name", libraryClass.getSuperName());
    assertNull(libraryClass.getProcessingInfo());
    assertNull(libraryClass.getFeatureName());
    assertNull(libraryClass.getSuperClass());
    assertEquals(0, libraryClass.getProcessingFlags());
    assertEquals(1, libraryClass.getAccessFlags());
    assertEquals(1, libraryClass.getInterfaceCount());
    assertEquals(3, libraryClass.subClassCount);
    assertTrue(libraryClass.getExtraFeatureNames().isEmpty());
    assertSame(kotlinMetadata, libraryClass.kotlinMetadata);
    String[] stringArray = libraryClass.interfaceNames;
    assertSame(interfaceNames, stringArray);
    assertSame(interfaceClasses, libraryClass.interfaceClasses);
    assertSame(subClasses, libraryClass.subClasses);
    assertSame(fields, libraryClass.fields);
    assertSame(methods, libraryClass.methods);
    assertArrayEquals(new String[]{"Interface Names"}, stringArray);
  }

  /**
   * Method under test:
   * {@link LibraryClassBuilder#LibraryClassBuilder(LibraryClass)}
   */
  @Test
  public void testNewLibraryClassBuilder3() {
    // Arrange
    LibraryClass libraryClass = new LibraryClass();

    // Act and Assert
    assertSame(libraryClass, (new LibraryClassBuilder(libraryClass)).getLibraryClass());
  }
}
