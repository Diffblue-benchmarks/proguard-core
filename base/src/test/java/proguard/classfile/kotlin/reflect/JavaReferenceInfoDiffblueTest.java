package proguard.classfile.kotlin.reflect;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.kotlin.reflect.visitor.CallableReferenceInfoVisitor;

class JavaReferenceInfoDiffblueTest {
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
  @DisplayName("Test getName(); then return 'Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.kotlin.reflect.JavaReferenceInfo.getName()"
  })
  void testGetName_thenReturnName() {
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
  @DisplayName("Test getSignature(); then return 'getName()Descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.kotlin.reflect.JavaReferenceInfo.getSignature()"
  })
  void testGetSignature_thenReturnGetNameDescriptor() {
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
  @DisplayName("Test getSignature(); then return 'NameDescriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.kotlin.reflect.JavaReferenceInfo.getSignature()"
  })
  void testGetSignature_thenReturnNameDescriptor() {
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
  @DisplayName("Test getOwner()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.classfile.kotlin.KotlinDeclarationContainerMetadata proguard.classfile.kotlin.reflect.JavaReferenceInfo.getOwner()"
  })
  void testGetOwner() {
    // Arrange
    LibraryClass ownerClass = new LibraryClass();
    LibraryClass clazz = new LibraryClass();

    // Act and Assert
    assertNull(
        (new JavaFieldReferenceInfo(ownerClass, clazz, new LibraryField(1, "Name", "Descriptor")))
            .getOwner());
  }

  /**
   * Test {@link JavaReferenceInfo#accept(CallableReferenceInfoVisitor)}.
   *
   * <p>Method under test: {@link JavaReferenceInfo#accept(CallableReferenceInfoVisitor)}
   */
  @Test
  @DisplayName("Test accept(CallableReferenceInfoVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.kotlin.reflect.JavaReferenceInfo.accept(proguard.classfile.kotlin.reflect.visitor.CallableReferenceInfoVisitor)"
  })
  void testAccept() {
    // Arrange
    LibraryClass ownerClass = new LibraryClass();
    LibraryClass clazz = new LibraryClass();
    JavaFieldReferenceInfo javaFieldReferenceInfo =
        new JavaFieldReferenceInfo(ownerClass, clazz, new LibraryField(1, "Name", "Descriptor"));
    CallableReferenceInfoVisitor callableReferenceInfoVisitor =
        mock(CallableReferenceInfoVisitor.class);
    doNothing()
        .when(callableReferenceInfoVisitor)
        .visitJavaReferenceInfo(Mockito.<JavaReferenceInfo>any());

    // Act
    javaFieldReferenceInfo.accept(callableReferenceInfoVisitor);

    // Assert
    verify(callableReferenceInfoVisitor).visitJavaReferenceInfo(isA(JavaReferenceInfo.class));
  }
}
