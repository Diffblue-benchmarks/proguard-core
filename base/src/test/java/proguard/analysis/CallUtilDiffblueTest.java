package proguard.analysis;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import java.util.Set;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.MethodSignature;

public class CallUtilDiffblueTest {
  /**
   * Test {@link CallUtil#resolveVirtual(Clazz, String, String)} with {@code thisPointerType},
   * {@code methodName}, {@code descriptor}.
   *
   * <p>Method under test: {@link CallUtil#resolveVirtual(Clazz, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set CallUtil.resolveVirtual(Clazz, String, String)"})
  public void testResolveVirtualWithThisPointerTypeMethodNameDescriptor() {
    // Arrange and Act
    Set<String> actualResolveVirtualResult =
        CallUtil.resolveVirtual(
            new LibraryClass(1, "This Class Name", "Super Class Name"),
            "Method Name",
            "Descriptor");

    // Assert
    assertTrue(actualResolveVirtualResult.isEmpty());
  }

  /**
   * Test {@link CallUtil#resolveVirtual(Clazz, String, String)} with {@code thisPointerType},
   * {@code methodName}, {@code descriptor}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CallUtil#resolveVirtual(Clazz, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set CallUtil.resolveVirtual(Clazz, String, String)"})
  public void testResolveVirtualWithThisPointerTypeMethodNameDescriptor_whenNull() {
    // Arrange and Act
    Set<String> actualResolveVirtualResult =
        CallUtil.resolveVirtual(null, "Method Name", "Descriptor");

    // Assert
    assertTrue(actualResolveVirtualResult.isEmpty());
  }

  /**
   * Test {@link CallUtil#resolveVirtualSignatures(Clazz, String, String)}.
   *
   * <p>Method under test: {@link CallUtil#resolveVirtualSignatures(Clazz, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set CallUtil.resolveVirtualSignatures(Clazz, String, String)"})
  public void testResolveVirtualSignatures() {
    // Arrange and Act
    Set<MethodSignature> actualResolveVirtualSignaturesResult =
        CallUtil.resolveVirtualSignatures(
            new LibraryClass(1, "This Class Name", "Super Class Name"),
            "Method Name",
            "Descriptor");

    // Assert
    assertTrue(actualResolveVirtualSignaturesResult.isEmpty());
  }

  /**
   * Test {@link CallUtil#resolveVirtualSignatures(Clazz, String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CallUtil#resolveVirtualSignatures(Clazz, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set CallUtil.resolveVirtualSignatures(Clazz, String, String)"})
  public void testResolveVirtualSignatures_whenNull_thenReturnEmpty() {
    // Arrange and Act
    Set<MethodSignature> actualResolveVirtualSignaturesResult =
        CallUtil.resolveVirtualSignatures(null, "Method Name", null);

    // Assert
    assertTrue(actualResolveVirtualSignaturesResult.isEmpty());
  }

  /**
   * Test {@link CallUtil#resolveFromSuperclasses(Clazz, String, String)}.
   *
   * <p>Method under test: {@link CallUtil#resolveFromSuperclasses(Clazz, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional CallUtil.resolveFromSuperclasses(Clazz, String, String)"})
  public void testResolveFromSuperclasses() {
    // Arrange and Act
    Optional<String> actualResolveFromSuperclassesResult =
        CallUtil.resolveFromSuperclasses(
            new LibraryClass(1, "This Class Name", "Super Class Name"), "Name", "Descriptor");

    // Assert
    assertFalse(actualResolveFromSuperclassesResult.isPresent());
  }

  /**
   * Test {@link CallUtil#resolveFromSuperclasses(Clazz, String, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link CallUtil#resolveFromSuperclasses(Clazz, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional CallUtil.resolveFromSuperclasses(Clazz, String, String)"})
  public void testResolveFromSuperclasses_whenNull_thenReturnNotPresent() {
    // Arrange and Act
    Optional<String> actualResolveFromSuperclassesResult =
        CallUtil.resolveFromSuperclasses(null, "Name", "Descriptor");

    // Assert
    assertFalse(actualResolveFromSuperclassesResult.isPresent());
  }

  /**
   * Test {@link CallUtil#resolveFromSuperinterfaces(Clazz, String, String)}.
   *
   * <ul>
   *   <li>Given {@link LibraryClass#LibraryClass()}.
   * </ul>
   *
   * <p>Method under test: {@link CallUtil#resolveFromSuperinterfaces(Clazz, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set CallUtil.resolveFromSuperinterfaces(Clazz, String, String)"})
  public void testResolveFromSuperinterfaces_givenLibraryClass() {
    // Arrange
    LibraryClass start = new LibraryClass();
    start.superClass = new LibraryClass();

    // Act
    Set<String> actualResolveFromSuperinterfacesResult =
        CallUtil.resolveFromSuperinterfaces(start, "Name", "Descriptor");

    // Assert
    assertTrue(actualResolveFromSuperinterfacesResult.isEmpty());
  }

  /**
   * Test {@link CallUtil#resolveFromSuperinterfaces(Clazz, String, String)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass#LibraryClass()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CallUtil#resolveFromSuperinterfaces(Clazz, String, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Set CallUtil.resolveFromSuperinterfaces(Clazz, String, String)"})
  public void testResolveFromSuperinterfaces_whenLibraryClass_thenReturnEmpty() {
    // Arrange and Act
    Set<String> actualResolveFromSuperinterfacesResult =
        CallUtil.resolveFromSuperinterfaces(new LibraryClass(), "Name", "Descriptor");

    // Assert
    assertTrue(actualResolveFromSuperinterfacesResult.isEmpty());
  }
}
