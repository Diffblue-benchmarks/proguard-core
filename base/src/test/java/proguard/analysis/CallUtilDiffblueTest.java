package proguard.analysis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryMethod;
import proguard.classfile.MethodSignature;
import proguard.classfile.constant.AnyMethodrefConstant;
import proguard.classfile.constant.InterfaceMethodrefConstant;

class CallUtilDiffblueTest {
  /**
   * Test {@link CallUtil#resolveVirtual(Clazz, Clazz, AnyMethodrefConstant)} with {@code
   * callingClass}, {@code thisPointerType}, {@code ref}.
   *
   * <p>Method under test: {@link CallUtil#resolveVirtual(Clazz, Clazz, AnyMethodrefConstant)}
   */
  @Test
  @DisplayName(
      "Test resolveVirtual(Clazz, Clazz, AnyMethodrefConstant) with 'callingClass', 'thisPointerType', 'ref'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Set proguard.analysis.CallUtil.resolveVirtual(proguard.classfile.Clazz, proguard.classfile.Clazz, proguard.classfile.constant.AnyMethodrefConstant)"
  })
  void testResolveVirtualWithCallingClassThisPointerTypeRef() {
    // Arrange
    LibraryClass callingClass = mock(LibraryClass.class);
    when(callingClass.getName(anyInt())).thenReturn("Name");
    when(callingClass.getType(anyInt())).thenReturn("Type");
    LibraryClass thisPointerType = new LibraryClass(1, "This Class Name", "Super Class Name");

    // Act
    Set<String> actualResolveVirtualResult =
        CallUtil.resolveVirtual(callingClass, thisPointerType, new InterfaceMethodrefConstant());

    // Assert
    verify(callingClass).getName(eq(0));
    verify(callingClass).getType(eq(0));
    assertTrue(actualResolveVirtualResult.isEmpty());
  }

  /**
   * Test {@link CallUtil#resolveVirtual(Clazz, Clazz, AnyMethodrefConstant)} with {@code
   * callingClass}, {@code thisPointerType}, {@code ref}.
   *
   * <p>Method under test: {@link CallUtil#resolveVirtual(Clazz, Clazz, AnyMethodrefConstant)}
   */
  @Test
  @DisplayName(
      "Test resolveVirtual(Clazz, Clazz, AnyMethodrefConstant) with 'callingClass', 'thisPointerType', 'ref'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Set proguard.analysis.CallUtil.resolveVirtual(proguard.classfile.Clazz, proguard.classfile.Clazz, proguard.classfile.constant.AnyMethodrefConstant)"
  })
  void testResolveVirtualWithCallingClassThisPointerTypeRef2() {
    // Arrange
    LibraryClass callingClass = mock(LibraryClass.class);
    when(callingClass.getName(anyInt())).thenReturn("Name");
    when(callingClass.getType(anyInt())).thenReturn("Type");
    LibraryClass thisPointerType = mock(LibraryClass.class);
    when(thisPointerType.getName()).thenReturn("Name");
    when(thisPointerType.findMethod(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new LibraryMethod(1, "Name", "Descriptor"));

    // Act
    Set<String> actualResolveVirtualResult =
        CallUtil.resolveVirtual(callingClass, thisPointerType, new InterfaceMethodrefConstant());

    // Assert
    verify(thisPointerType).findMethod(eq("Name"), eq("Type"));
    verify(thisPointerType).getName();
    verify(callingClass).getName(eq(0));
    verify(callingClass).getType(eq(0));
    assertEquals(1, actualResolveVirtualResult.size());
    assertTrue(actualResolveVirtualResult.contains("Name"));
  }

  /**
   * Test {@link CallUtil#resolveVirtual(Clazz, Clazz, AnyMethodrefConstant)} with {@code
   * callingClass}, {@code thisPointerType}, {@code ref}.
   *
   * <p>Method under test: {@link CallUtil#resolveVirtual(Clazz, Clazz, AnyMethodrefConstant)}
   */
  @Test
  @DisplayName(
      "Test resolveVirtual(Clazz, Clazz, AnyMethodrefConstant) with 'callingClass', 'thisPointerType', 'ref'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Set proguard.analysis.CallUtil.resolveVirtual(proguard.classfile.Clazz, proguard.classfile.Clazz, proguard.classfile.constant.AnyMethodrefConstant)"
  })
  void testResolveVirtualWithCallingClassThisPointerTypeRef3() {
    // Arrange
    LibraryClass callingClass = mock(LibraryClass.class);
    when(callingClass.getName(anyInt())).thenReturn("Name");
    when(callingClass.getType(anyInt())).thenReturn("Type");
    LibraryClass thisPointerType = mock(LibraryClass.class);
    when(thisPointerType.getInterface(anyInt())).thenReturn(null);
    when(thisPointerType.getInterfaceCount()).thenReturn(3);
    when(thisPointerType.getSuperClass()).thenReturn(null);
    when(thisPointerType.findMethod(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new LibraryMethod(1024, "Name", "Descriptor"));

    // Act
    Set<String> actualResolveVirtualResult =
        CallUtil.resolveVirtual(callingClass, thisPointerType, new InterfaceMethodrefConstant());

    // Assert
    verify(thisPointerType).findMethod(eq("Name"), eq("Type"));
    verify(thisPointerType, atLeast(1)).getInterface(anyInt());
    verify(thisPointerType, atLeast(1)).getInterfaceCount();
    verify(callingClass).getName(eq(0));
    verify(thisPointerType, atLeast(1)).getSuperClass();
    verify(callingClass).getType(eq(0));
    assertTrue(actualResolveVirtualResult.isEmpty());
  }

  /**
   * Test {@link CallUtil#resolveVirtual(Clazz, Clazz, AnyMethodrefConstant)} with {@code
   * callingClass}, {@code thisPointerType}, {@code ref}.
   *
   * <p>Method under test: {@link CallUtil#resolveVirtual(Clazz, Clazz, AnyMethodrefConstant)}
   */
  @Test
  @DisplayName(
      "Test resolveVirtual(Clazz, Clazz, AnyMethodrefConstant) with 'callingClass', 'thisPointerType', 'ref'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Set proguard.analysis.CallUtil.resolveVirtual(proguard.classfile.Clazz, proguard.classfile.Clazz, proguard.classfile.constant.AnyMethodrefConstant)"
  })
  void testResolveVirtualWithCallingClassThisPointerTypeRef4() {
    // Arrange
    LibraryClass callingClass = mock(LibraryClass.class);
    when(callingClass.getName(anyInt())).thenReturn("Name");
    when(callingClass.getType(anyInt())).thenReturn("Type");
    LibraryClass thisPointerType = mock(LibraryClass.class);
    when(thisPointerType.getInterface(anyInt()))
        .thenReturn(new LibraryClass(1024, "This Class Name", "Super Class Name"));
    when(thisPointerType.getInterfaceCount()).thenReturn(3);
    when(thisPointerType.getSuperClass()).thenReturn(null);
    when(thisPointerType.findMethod(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new LibraryMethod(1024, "Name", "Descriptor"));

    // Act
    Set<String> actualResolveVirtualResult =
        CallUtil.resolveVirtual(callingClass, thisPointerType, new InterfaceMethodrefConstant());

    // Assert
    verify(thisPointerType).findMethod(eq("Name"), eq("Type"));
    verify(thisPointerType, atLeast(1)).getInterface(anyInt());
    verify(thisPointerType, atLeast(1)).getInterfaceCount();
    verify(callingClass).getName(eq(0));
    verify(thisPointerType, atLeast(1)).getSuperClass();
    verify(callingClass).getType(eq(0));
    assertTrue(actualResolveVirtualResult.isEmpty());
  }

  /**
   * Test {@link CallUtil#resolveVirtual(Clazz, Clazz, AnyMethodrefConstant)} with {@code
   * callingClass}, {@code thisPointerType}, {@code ref}.
   *
   * <p>Method under test: {@link CallUtil#resolveVirtual(Clazz, Clazz, AnyMethodrefConstant)}
   */
  @Test
  @DisplayName(
      "Test resolveVirtual(Clazz, Clazz, AnyMethodrefConstant) with 'callingClass', 'thisPointerType', 'ref'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Set proguard.analysis.CallUtil.resolveVirtual(proguard.classfile.Clazz, proguard.classfile.Clazz, proguard.classfile.constant.AnyMethodrefConstant)"
  })
  void testResolveVirtualWithCallingClassThisPointerTypeRef5() {
    // Arrange
    LibraryClass callingClass = mock(LibraryClass.class);
    when(callingClass.getName(anyInt())).thenReturn("Name");
    when(callingClass.getType(anyInt())).thenReturn("Type");
    LibraryClass libraryClass = mock(LibraryClass.class);
    when(libraryClass.getName()).thenReturn("Name");
    when(libraryClass.getInterface(anyInt()))
        .thenReturn(new LibraryClass(1024, "This Class Name", "Super Class Name"));
    when(libraryClass.getInterfaceCount()).thenReturn(3);
    when(libraryClass.getSuperClass()).thenReturn(new LibraryClass());
    when(libraryClass.findMethod(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new LibraryMethod(1, "Name", "Descriptor"));
    LibraryClass thisPointerType = mock(LibraryClass.class);
    when(thisPointerType.getInterface(anyInt())).thenReturn(libraryClass);
    when(thisPointerType.getName()).thenReturn("Name");
    when(thisPointerType.getInterfaceCount()).thenReturn(3);
    when(thisPointerType.getSuperClass()).thenReturn(null);
    when(thisPointerType.findMethod(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new LibraryMethod(1024, "Name", "Descriptor"));

    // Act
    Set<String> actualResolveVirtualResult =
        CallUtil.resolveVirtual(callingClass, thisPointerType, new InterfaceMethodrefConstant());

    // Assert
    verify(thisPointerType).findMethod(eq("Name"), eq("Type"));
    verify(libraryClass).findMethod(eq("Name"), eq("Type"));
    verify(thisPointerType, atLeast(1)).getInterface(anyInt());
    verify(libraryClass, atLeast(1)).getInterface(anyInt());
    verify(thisPointerType, atLeast(1)).getInterfaceCount();
    verify(libraryClass, atLeast(1)).getInterfaceCount();
    verify(libraryClass).getName();
    verify(callingClass).getName(eq(0));
    verify(thisPointerType, atLeast(1)).getSuperClass();
    verify(libraryClass, atLeast(1)).getSuperClass();
    verify(callingClass).getType(eq(0));
    assertEquals(1, actualResolveVirtualResult.size());
    assertTrue(actualResolveVirtualResult.contains("Name"));
  }

  /**
   * Test {@link CallUtil#resolveVirtual(Clazz, Clazz, AnyMethodrefConstant)} with {@code
   * callingClass}, {@code thisPointerType}, {@code ref}.
   *
   * <p>Method under test: {@link CallUtil#resolveVirtual(Clazz, Clazz, AnyMethodrefConstant)}
   */
  @Test
  @DisplayName(
      "Test resolveVirtual(Clazz, Clazz, AnyMethodrefConstant) with 'callingClass', 'thisPointerType', 'ref'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Set proguard.analysis.CallUtil.resolveVirtual(proguard.classfile.Clazz, proguard.classfile.Clazz, proguard.classfile.constant.AnyMethodrefConstant)"
  })
  void testResolveVirtualWithCallingClassThisPointerTypeRef6() {
    // Arrange
    LibraryClass callingClass = mock(LibraryClass.class);
    when(callingClass.getName(anyInt())).thenReturn("Name");
    when(callingClass.getType(anyInt())).thenReturn("Type");
    LibraryClass libraryClass = mock(LibraryClass.class);
    when(libraryClass.getInterface(anyInt())).thenReturn(null);
    when(libraryClass.getInterfaceCount()).thenReturn(3);
    when(libraryClass.getSuperClass()).thenReturn(new LibraryClass());
    when(libraryClass.findMethod(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new LibraryMethod(1024, "Name", "Descriptor"));
    LibraryClass thisPointerType = mock(LibraryClass.class);
    when(thisPointerType.getInterface(anyInt())).thenReturn(libraryClass);
    when(thisPointerType.getInterfaceCount()).thenReturn(3);
    when(thisPointerType.getSuperClass()).thenReturn(null);
    when(thisPointerType.findMethod(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new LibraryMethod(1024, "Name", "Descriptor"));

    // Act
    Set<String> actualResolveVirtualResult =
        CallUtil.resolveVirtual(callingClass, thisPointerType, new InterfaceMethodrefConstant());

    // Assert
    verify(thisPointerType).findMethod(eq("Name"), eq("Type"));
    verify(libraryClass).findMethod(eq("Name"), eq("Type"));
    verify(thisPointerType, atLeast(1)).getInterface(anyInt());
    verify(libraryClass, atLeast(1)).getInterface(anyInt());
    verify(thisPointerType, atLeast(1)).getInterfaceCount();
    verify(libraryClass, atLeast(1)).getInterfaceCount();
    verify(callingClass).getName(eq(0));
    verify(thisPointerType, atLeast(1)).getSuperClass();
    verify(libraryClass, atLeast(1)).getSuperClass();
    verify(callingClass).getType(eq(0));
    assertTrue(actualResolveVirtualResult.isEmpty());
  }

  /**
   * Test {@link CallUtil#resolveVirtual(Clazz, Clazz, AnyMethodrefConstant)} with {@code
   * callingClass}, {@code thisPointerType}, {@code ref}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link CallUtil#resolveVirtual(Clazz, Clazz, AnyMethodrefConstant)}
   */
  @Test
  @DisplayName(
      "Test resolveVirtual(Clazz, Clazz, AnyMethodrefConstant) with 'callingClass', 'thisPointerType', 'ref'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Set proguard.analysis.CallUtil.resolveVirtual(proguard.classfile.Clazz, proguard.classfile.Clazz, proguard.classfile.constant.AnyMethodrefConstant)"
  })
  void testResolveVirtualWithCallingClassThisPointerTypeRef_thenReturnSizeIsOne() {
    // Arrange
    LibraryClass callingClass = mock(LibraryClass.class);
    when(callingClass.getName(anyInt())).thenReturn("Name");
    when(callingClass.getType(anyInt())).thenReturn("Type");
    LibraryClass libraryClass = mock(LibraryClass.class);
    when(libraryClass.getName()).thenReturn("Name");
    when(libraryClass.getInterface(anyInt())).thenReturn(null);
    when(libraryClass.getInterfaceCount()).thenReturn(3);
    when(libraryClass.getSuperClass()).thenReturn(new LibraryClass());
    when(libraryClass.findMethod(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new LibraryMethod(1, "Name", "Descriptor"));
    LibraryClass thisPointerType = mock(LibraryClass.class);
    when(thisPointerType.getInterface(anyInt())).thenReturn(libraryClass);
    when(thisPointerType.getName()).thenReturn("Name");
    when(thisPointerType.getInterfaceCount()).thenReturn(3);
    when(thisPointerType.getSuperClass()).thenReturn(null);
    when(thisPointerType.findMethod(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new LibraryMethod(1024, "Name", "Descriptor"));

    // Act
    Set<String> actualResolveVirtualResult =
        CallUtil.resolveVirtual(callingClass, thisPointerType, new InterfaceMethodrefConstant());

    // Assert
    verify(thisPointerType).findMethod(eq("Name"), eq("Type"));
    verify(libraryClass).findMethod(eq("Name"), eq("Type"));
    verify(thisPointerType, atLeast(1)).getInterface(anyInt());
    verify(libraryClass, atLeast(1)).getInterface(anyInt());
    verify(thisPointerType, atLeast(1)).getInterfaceCount();
    verify(libraryClass, atLeast(1)).getInterfaceCount();
    verify(libraryClass).getName();
    verify(callingClass).getName(eq(0));
    verify(thisPointerType, atLeast(1)).getSuperClass();
    verify(libraryClass, atLeast(1)).getSuperClass();
    verify(callingClass).getType(eq(0));
    assertEquals(1, actualResolveVirtualResult.size());
    assertTrue(actualResolveVirtualResult.contains("Name"));
  }

  /**
   * Test {@link CallUtil#resolveVirtual(Clazz, Clazz, AnyMethodrefConstant)} with {@code
   * callingClass}, {@code thisPointerType}, {@code ref}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CallUtil#resolveVirtual(Clazz, Clazz, AnyMethodrefConstant)}
   */
  @Test
  @DisplayName(
      "Test resolveVirtual(Clazz, Clazz, AnyMethodrefConstant) with 'callingClass', 'thisPointerType', 'ref'; when 'null'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Set proguard.analysis.CallUtil.resolveVirtual(proguard.classfile.Clazz, proguard.classfile.Clazz, proguard.classfile.constant.AnyMethodrefConstant)"
  })
  void testResolveVirtualWithCallingClassThisPointerTypeRef_whenNull_thenReturnEmpty() {
    // Arrange
    LibraryClass callingClass = mock(LibraryClass.class);
    when(callingClass.getName(anyInt())).thenReturn("Name");
    when(callingClass.getType(anyInt())).thenReturn("Type");

    // Act
    Set<String> actualResolveVirtualResult =
        CallUtil.resolveVirtual(callingClass, null, new InterfaceMethodrefConstant());

    // Assert
    verify(callingClass).getName(eq(0));
    verify(callingClass).getType(eq(0));
    assertTrue(actualResolveVirtualResult.isEmpty());
  }

  /**
   * Test {@link CallUtil#resolveVirtual(Clazz, String, String)} with {@code thisPointerType},
   * {@code methodName}, {@code descriptor}.
   *
   * <p>Method under test: {@link CallUtil#resolveVirtual(Clazz, String, String)}
   */
  @Test
  @DisplayName(
      "Test resolveVirtual(Clazz, String, String) with 'thisPointerType', 'methodName', 'descriptor'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Set proguard.analysis.CallUtil.resolveVirtual(proguard.classfile.Clazz, java.lang.String, java.lang.String)"
  })
  void testResolveVirtualWithThisPointerTypeMethodNameDescriptor() {
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
  @DisplayName(
      "Test resolveVirtual(Clazz, String, String) with 'thisPointerType', 'methodName', 'descriptor'; when 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Set proguard.analysis.CallUtil.resolveVirtual(proguard.classfile.Clazz, java.lang.String, java.lang.String)"
  })
  void testResolveVirtualWithThisPointerTypeMethodNameDescriptor_whenNull() {
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
  @DisplayName("Test resolveVirtualSignatures(Clazz, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Set proguard.analysis.CallUtil.resolveVirtualSignatures(proguard.classfile.Clazz, java.lang.String, java.lang.String)"
  })
  void testResolveVirtualSignatures() {
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
  @DisplayName(
      "Test resolveVirtualSignatures(Clazz, String, String); when 'null'; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Set proguard.analysis.CallUtil.resolveVirtualSignatures(proguard.classfile.Clazz, java.lang.String, java.lang.String)"
  })
  void testResolveVirtualSignatures_whenNull_thenReturnEmpty() {
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
  @DisplayName("Test resolveFromSuperclasses(Clazz, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Optional proguard.analysis.CallUtil.resolveFromSuperclasses(proguard.classfile.Clazz, java.lang.String, java.lang.String)"
  })
  void testResolveFromSuperclasses() {
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
  @DisplayName(
      "Test resolveFromSuperclasses(Clazz, String, String); when 'null'; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Optional proguard.analysis.CallUtil.resolveFromSuperclasses(proguard.classfile.Clazz, java.lang.String, java.lang.String)"
  })
  void testResolveFromSuperclasses_whenNull_thenReturnNotPresent() {
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
  @DisplayName("Test resolveFromSuperinterfaces(Clazz, String, String); given LibraryClass()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Set proguard.analysis.CallUtil.resolveFromSuperinterfaces(proguard.classfile.Clazz, java.lang.String, java.lang.String)"
  })
  void testResolveFromSuperinterfaces_givenLibraryClass() {
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
  @DisplayName(
      "Test resolveFromSuperinterfaces(Clazz, String, String); when LibraryClass(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.util.Set proguard.analysis.CallUtil.resolveFromSuperinterfaces(proguard.classfile.Clazz, java.lang.String, java.lang.String)"
  })
  void testResolveFromSuperinterfaces_whenLibraryClass_thenReturnEmpty() {
    // Arrange and Act
    Set<String> actualResolveFromSuperinterfacesResult =
        CallUtil.resolveFromSuperinterfaces(new LibraryClass(), "Name", "Descriptor");

    // Assert
    assertTrue(actualResolveFromSuperinterfacesResult.isEmpty());
  }

  /**
   * Test {@link CallUtil#getSuperinterfaces(Clazz, Set)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link LibraryClass} {@link LibraryClass#getInterface(int)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CallUtil#getSuperinterfaces(Clazz, Set)}
   */
  @Test
  @DisplayName(
      "Test getSuperinterfaces(Clazz, Set); given 'null'; when LibraryClass getInterface(int) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.CallUtil.getSuperinterfaces(proguard.classfile.Clazz, java.util.Set)"
  })
  void testGetSuperinterfaces_givenNull_whenLibraryClassGetInterfaceReturnNull() {
    // Arrange
    LibraryClass start = mock(LibraryClass.class);
    when(start.getInterface(anyInt())).thenReturn(null);
    when(start.getInterfaceCount()).thenReturn(3);
    when(start.getSuperClass()).thenReturn(new LibraryClass());
    HashSet<Clazz> accumulator = new HashSet<>();

    // Act
    CallUtil.getSuperinterfaces(start, accumulator);

    // Assert that nothing has changed
    verify(start, atLeast(1)).getInterface(anyInt());
    verify(start, atLeast(1)).getInterfaceCount();
    verify(start, atLeast(1)).getSuperClass();
    assertTrue(accumulator.isEmpty());
  }

  /**
   * Test {@link CallUtil#getSuperinterfaces(Clazz, Set)}.
   *
   * <ul>
   *   <li>Then {@link HashSet#HashSet()} size is one.
   * </ul>
   *
   * <p>Method under test: {@link CallUtil#getSuperinterfaces(Clazz, Set)}
   */
  @Test
  @DisplayName("Test getSuperinterfaces(Clazz, Set); then HashSet() size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.CallUtil.getSuperinterfaces(proguard.classfile.Clazz, java.util.Set)"
  })
  void testGetSuperinterfaces_thenHashSetSizeIsOne() {
    // Arrange
    LibraryClass start = mock(LibraryClass.class);
    when(start.getInterface(anyInt())).thenReturn(new LibraryClass());
    when(start.getInterfaceCount()).thenReturn(3);
    when(start.getSuperClass()).thenReturn(new LibraryClass());
    HashSet<Clazz> accumulator = new HashSet<>();

    // Act
    CallUtil.getSuperinterfaces(start, accumulator);

    // Assert
    verify(start, atLeast(1)).getInterface(anyInt());
    verify(start, atLeast(1)).getInterfaceCount();
    verify(start, atLeast(1)).getSuperClass();
    assertEquals(1, accumulator.size());
  }

  /**
   * Test {@link CallUtil#getSuperinterfaces(Clazz, Set)}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()} add {@link LibraryClass#LibraryClass()}.
   *   <li>Then {@link HashSet#HashSet()} size is two.
   * </ul>
   *
   * <p>Method under test: {@link CallUtil#getSuperinterfaces(Clazz, Set)}
   */
  @Test
  @DisplayName(
      "Test getSuperinterfaces(Clazz, Set); when HashSet() add LibraryClass(); then HashSet() size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.CallUtil.getSuperinterfaces(proguard.classfile.Clazz, java.util.Set)"
  })
  void testGetSuperinterfaces_whenHashSetAddLibraryClass_thenHashSetSizeIsTwo() {
    // Arrange
    LibraryClass start = mock(LibraryClass.class);
    when(start.getInterface(anyInt())).thenReturn(new LibraryClass());
    when(start.getInterfaceCount()).thenReturn(3);
    when(start.getSuperClass()).thenReturn(new LibraryClass());

    HashSet<Clazz> accumulator = new HashSet<>();
    accumulator.add(new LibraryClass());

    // Act
    CallUtil.getSuperinterfaces(start, accumulator);

    // Assert
    verify(start, atLeast(1)).getInterface(anyInt());
    verify(start, atLeast(1)).getInterfaceCount();
    verify(start, atLeast(1)).getSuperClass();
    assertEquals(2, accumulator.size());
  }

  /**
   * Test {@link CallUtil#getSuperinterfaces(Clazz, Set)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass#LibraryClass()} {@link LibraryClass#superClass} is {@link
   *       LibraryClass#LibraryClass()}.
   *   <li>Then {@link HashSet#HashSet()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link CallUtil#getSuperinterfaces(Clazz, Set)}
   */
  @Test
  @DisplayName(
      "Test getSuperinterfaces(Clazz, Set); when LibraryClass() superClass is LibraryClass(); then HashSet() Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.CallUtil.getSuperinterfaces(proguard.classfile.Clazz, java.util.Set)"
  })
  void testGetSuperinterfaces_whenLibraryClassSuperClassIsLibraryClass_thenHashSetEmpty() {
    // Arrange
    LibraryClass start = new LibraryClass();
    start.superClass = new LibraryClass();
    HashSet<Clazz> accumulator = new HashSet<>();

    // Act
    CallUtil.getSuperinterfaces(start, accumulator);

    // Assert that nothing has changed
    assertTrue(accumulator.isEmpty());
  }

  /**
   * Test {@link CallUtil#getSuperinterfaces(Clazz, Set)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass#LibraryClass()}.
   *   <li>Then {@link HashSet#HashSet()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link CallUtil#getSuperinterfaces(Clazz, Set)}
   */
  @Test
  @DisplayName("Test getSuperinterfaces(Clazz, Set); when LibraryClass(); then HashSet() Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.analysis.CallUtil.getSuperinterfaces(proguard.classfile.Clazz, java.util.Set)"
  })
  void testGetSuperinterfaces_whenLibraryClass_thenHashSetEmpty() {
    // Arrange
    LibraryClass start = new LibraryClass();
    HashSet<Clazz> accumulator = new HashSet<>();

    // Act
    CallUtil.getSuperinterfaces(start, accumulator);

    // Assert that nothing has changed
    assertTrue(accumulator.isEmpty());
  }
}
