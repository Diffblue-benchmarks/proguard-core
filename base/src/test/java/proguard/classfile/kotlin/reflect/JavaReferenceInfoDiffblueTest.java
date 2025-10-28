package proguard.classfile.kotlin.reflect;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;

public class JavaReferenceInfoDiffblueTest {
  /**
   * Method under test: {@link JavaReferenceInfo#getName()}
   */
  @Test
  public void testGetName() {
    // Arrange
    LibraryClass ownerClass = new LibraryClass();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertEquals("Name",
        (new JavaFieldReferenceInfo(ownerClass, clazz, new LibraryField(1, "Name", "Descriptor"))).getName());
  }

  /**
   * Method under test: {@link JavaReferenceInfo#getSignature()}
   */
  @Test
  public void testGetSignature() {
    // Arrange
    LibraryClass ownerClass = new LibraryClass();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertEquals("NameDescriptor",
        (new JavaMethodReferenceInfo(ownerClass, clazz, new LibraryField(1, "Name", "Descriptor"))).getSignature());
  }

  /**
   * Method under test: {@link JavaReferenceInfo#getSignature()}
   */
  @Test
  public void testGetSignature2() {
    // Arrange
    LibraryClass ownerClass = new LibraryClass();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertEquals("getName()Descriptor",
        (new JavaFieldReferenceInfo(ownerClass, clazz, new LibraryField(1, "Name", "Descriptor"))).getSignature());
  }

  /**
   * Method under test: {@link JavaReferenceInfo#getOwner()}
   */
  @Test
  public void testGetOwner() {
    // Arrange
    LibraryClass ownerClass = new LibraryClass();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertNull((new JavaFieldReferenceInfo(ownerClass, clazz, new LibraryField(1, "Name", "Descriptor"))).getOwner());
  }
}
