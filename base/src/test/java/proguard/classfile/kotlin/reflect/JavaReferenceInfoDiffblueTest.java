package proguard.classfile.kotlin.reflect;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;

public class JavaReferenceInfoDiffblueTest {
  /**
   * Test {@link JavaReferenceInfo#getName()}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link JavaReferenceInfo#getName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String JavaReferenceInfo.getName()"})
  public void testGetName_thenReturnName() {
    // Arrange
    LibraryClass ownerClass = new LibraryClass();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertEquals(
        "Name",
        (new JavaFieldReferenceInfo(ownerClass, clazz, new LibraryField(1, "Name", "Descriptor")))
            .getName());
  }

  /**
   * Test {@link JavaReferenceInfo#getSignature()}.
   *
   * <ul>
   *   <li>Then return {@code getName()Descriptor}.
   * </ul>
   *
   * <p>Method under test: {@link JavaReferenceInfo#getSignature()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String JavaReferenceInfo.getSignature()"})
  public void testGetSignature_thenReturnGetNameDescriptor() {
    // Arrange
    LibraryClass ownerClass = new LibraryClass();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertEquals(
        "getName()Descriptor",
        (new JavaFieldReferenceInfo(ownerClass, clazz, new LibraryField(1, "Name", "Descriptor")))
            .getSignature());
  }

  /**
   * Test {@link JavaReferenceInfo#getSignature()}.
   *
   * <ul>
   *   <li>Then return {@code NameDescriptor}.
   * </ul>
   *
   * <p>Method under test: {@link JavaReferenceInfo#getSignature()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String JavaReferenceInfo.getSignature()"})
  public void testGetSignature_thenReturnNameDescriptor() {
    // Arrange
    LibraryClass ownerClass = new LibraryClass();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertEquals(
        "NameDescriptor",
        (new JavaMethodReferenceInfo(ownerClass, clazz, new LibraryField(1, "Name", "Descriptor")))
            .getSignature());
  }

  /**
   * Test {@link JavaReferenceInfo#getOwner()}.
   *
   * <p>Method under test: {@link JavaReferenceInfo#getOwner()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "proguard.classfile.kotlin.KotlinDeclarationContainerMetadata JavaReferenceInfo.getOwner()"
  })
  public void testGetOwner() {
    // Arrange
    LibraryClass ownerClass = new LibraryClass();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertNull(
        (new JavaFieldReferenceInfo(ownerClass, clazz, new LibraryField(1, "Name", "Descriptor")))
            .getOwner());
  }
}
