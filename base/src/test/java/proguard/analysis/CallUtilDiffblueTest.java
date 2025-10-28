package proguard.analysis;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.Optional;
import java.util.Set;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.MethodSignature;

public class CallUtilDiffblueTest {
  /**
   * Method under test: {@link CallUtil#resolveVirtual(Clazz, String, String)}
   */
  @Test
  public void testResolveVirtual() {
    // Arrange and Act
    Set<String> actualResolveVirtualResult = CallUtil.resolveVirtual(null, "Method Name", "Descriptor");

    // Assert
    assertTrue(actualResolveVirtualResult.isEmpty());
  }

  /**
   * Method under test: {@link CallUtil#resolveVirtual(Clazz, String, String)}
   */
  @Test
  public void testResolveVirtual2() {
    // Arrange and Act
    Set<String> actualResolveVirtualResult = CallUtil
        .resolveVirtual(new LibraryClass(1, "This Class Name", "Super Class Name"), "Method Name", "Descriptor");

    // Assert
    assertTrue(actualResolveVirtualResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link CallUtil#resolveVirtualSignatures(Clazz, String, String)}
   */
  @Test
  public void testResolveVirtualSignatures() {
    // Arrange and Act
    Set<MethodSignature> actualResolveVirtualSignaturesResult = CallUtil.resolveVirtualSignatures(null, "Method Name",
        null);

    // Assert
    assertTrue(actualResolveVirtualSignaturesResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link CallUtil#resolveVirtualSignatures(Clazz, String, String)}
   */
  @Test
  public void testResolveVirtualSignatures2() {
    // Arrange and Act
    Set<MethodSignature> actualResolveVirtualSignaturesResult = CallUtil.resolveVirtualSignatures(
        new LibraryClass(1, "This Class Name", "Super Class Name"), "Method Name", "Descriptor");

    // Assert
    assertTrue(actualResolveVirtualSignaturesResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link CallUtil#resolveFromSuperclasses(Clazz, String, String)}
   */
  @Test
  public void testResolveFromSuperclasses() {
    // Arrange and Act
    Optional<String> actualResolveFromSuperclassesResult = CallUtil.resolveFromSuperclasses(null, "Name", "Descriptor");

    // Assert
    assertFalse(actualResolveFromSuperclassesResult.isPresent());
  }

  /**
   * Method under test:
   * {@link CallUtil#resolveFromSuperclasses(Clazz, String, String)}
   */
  @Test
  public void testResolveFromSuperclasses2() {
    // Arrange and Act
    Optional<String> actualResolveFromSuperclassesResult = CallUtil
        .resolveFromSuperclasses(new LibraryClass(1, "This Class Name", "Super Class Name"), "Name", "Descriptor");

    // Assert
    assertFalse(actualResolveFromSuperclassesResult.isPresent());
  }

  /**
   * Method under test:
   * {@link CallUtil#resolveFromSuperinterfaces(Clazz, String, String)}
   */
  @Test
  public void testResolveFromSuperinterfaces() {
    // Arrange and Act
    Set<String> actualResolveFromSuperinterfacesResult = CallUtil.resolveFromSuperinterfaces(new LibraryClass(), "Name",
        "Descriptor");

    // Assert
    assertTrue(actualResolveFromSuperinterfacesResult.isEmpty());
  }

  /**
   * Method under test:
   * {@link CallUtil#resolveFromSuperinterfaces(Clazz, String, String)}
   */
  @Test
  public void testResolveFromSuperinterfaces2() {
    // Arrange
    LibraryClass start = new LibraryClass();
    start.superClass = new LibraryClass();

    // Act
    Set<String> actualResolveFromSuperinterfacesResult = CallUtil.resolveFromSuperinterfaces(start, "Name",
        "Descriptor");

    // Assert
    assertTrue(actualResolveFromSuperinterfacesResult.isEmpty());
  }
}
