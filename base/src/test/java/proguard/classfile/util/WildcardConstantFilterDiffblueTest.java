package proguard.classfile.util;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.classfile.constant.ClassConstant;
import proguard.classfile.constant.FieldrefConstant;
import proguard.classfile.constant.InterfaceMethodrefConstant;
import proguard.classfile.constant.MethodTypeConstant;
import proguard.classfile.constant.MethodrefConstant;
import proguard.classfile.constant.ModuleConstant;
import proguard.classfile.constant.NameAndTypeConstant;
import proguard.classfile.constant.PackageConstant;
import proguard.classfile.constant.StringConstant;
import proguard.classfile.constant.visitor.BootstrapMethodHandleTraveler;
import proguard.classfile.constant.visitor.ConstantVisitor;

class WildcardConstantFilterDiffblueTest {
  /**
   * Test {@link WildcardConstantFilter#visitStringConstant(Clazz, StringConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link ConstantVisitor#visitStringConstant(Clazz, StringConstant)}.
   * </ul>
   *
   * <p>Method under test: {@link WildcardConstantFilter#visitStringConstant(Clazz, StringConstant)}
   */
  @Test
  @DisplayName(
      "Test visitStringConstant(Clazz, StringConstant); then calls visitStringConstant(Clazz, StringConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.WildcardConstantFilter.visitStringConstant(proguard.classfile.Clazz, proguard.classfile.constant.StringConstant)"
  })
  void testVisitStringConstant_thenCallsVisitStringConstant() {
    // Arrange
    BootstrapMethodHandleTraveler constantVisitor = mock(BootstrapMethodHandleTraveler.class);
    doNothing()
        .when(constantVisitor)
        .visitStringConstant(Mockito.<Clazz>any(), Mockito.<StringConstant>any());
    WildcardConstantFilter wildcardConstantFilter = new WildcardConstantFilter(constantVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    wildcardConstantFilter.visitStringConstant(clazz, new StringConstant());

    // Assert
    verify(constantVisitor).visitStringConstant(isA(Clazz.class), isA(StringConstant.class));
  }

  /**
   * Test {@link WildcardConstantFilter#visitFieldrefConstant(Clazz, FieldrefConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link ConstantVisitor#visitFieldrefConstant(Clazz, FieldrefConstant)}.
   * </ul>
   *
   * <p>Method under test: {@link WildcardConstantFilter#visitFieldrefConstant(Clazz,
   * FieldrefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitFieldrefConstant(Clazz, FieldrefConstant); then calls visitFieldrefConstant(Clazz, FieldrefConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.WildcardConstantFilter.visitFieldrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.FieldrefConstant)"
  })
  void testVisitFieldrefConstant_thenCallsVisitFieldrefConstant() {
    // Arrange
    BootstrapMethodHandleTraveler constantVisitor = mock(BootstrapMethodHandleTraveler.class);
    doNothing()
        .when(constantVisitor)
        .visitFieldrefConstant(Mockito.<Clazz>any(), Mockito.<FieldrefConstant>any());
    WildcardConstantFilter wildcardConstantFilter = new WildcardConstantFilter(constantVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    wildcardConstantFilter.visitFieldrefConstant(clazz, new FieldrefConstant());

    // Assert
    verify(constantVisitor).visitFieldrefConstant(isA(Clazz.class), isA(FieldrefConstant.class));
  }

  /**
   * Test {@link WildcardConstantFilter#visitFieldrefConstant(Clazz, FieldrefConstant)}.
   *
   * <ul>
   *   <li>When {@link FieldrefConstant} {@link FieldrefConstant#accept(Clazz, ConstantVisitor)}
   *       does nothing.
   *   <li>Then calls {@link FieldrefConstant#accept(Clazz, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link WildcardConstantFilter#visitFieldrefConstant(Clazz,
   * FieldrefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitFieldrefConstant(Clazz, FieldrefConstant); when FieldrefConstant accept(Clazz, ConstantVisitor) does nothing; then calls accept(Clazz, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.WildcardConstantFilter.visitFieldrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.FieldrefConstant)"
  })
  void testVisitFieldrefConstant_whenFieldrefConstantAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    BootstrapMethodHandleTraveler constantVisitor = mock(BootstrapMethodHandleTraveler.class);
    doNothing()
        .when(constantVisitor)
        .visitFieldrefConstant(Mockito.<Clazz>any(), Mockito.<FieldrefConstant>any());
    WildcardConstantFilter wildcardConstantFilter = new WildcardConstantFilter(constantVisitor);
    LibraryClass clazz = new LibraryClass();
    FieldrefConstant fieldrefConstant = mock(FieldrefConstant.class);
    doNothing().when(fieldrefConstant).accept(Mockito.<Clazz>any(), Mockito.<ConstantVisitor>any());

    // Act
    wildcardConstantFilter.visitFieldrefConstant(clazz, fieldrefConstant);

    // Assert
    verify(fieldrefConstant).accept(isA(Clazz.class), isA(ConstantVisitor.class));
    verify(constantVisitor).visitFieldrefConstant(isA(Clazz.class), isA(FieldrefConstant.class));
  }

  /**
   * Test {@link WildcardConstantFilter#visitInterfaceMethodrefConstant(Clazz,
   * InterfaceMethodrefConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link InterfaceMethodrefConstant#accept(Clazz, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link WildcardConstantFilter#visitInterfaceMethodrefConstant(Clazz,
   * InterfaceMethodrefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitInterfaceMethodrefConstant(Clazz, InterfaceMethodrefConstant); then calls accept(Clazz, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.WildcardConstantFilter.visitInterfaceMethodrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.InterfaceMethodrefConstant)"
  })
  void testVisitInterfaceMethodrefConstant_thenCallsAccept() {
    // Arrange
    BootstrapMethodHandleTraveler constantVisitor = mock(BootstrapMethodHandleTraveler.class);
    doNothing()
        .when(constantVisitor)
        .visitInterfaceMethodrefConstant(
            Mockito.<Clazz>any(), Mockito.<InterfaceMethodrefConstant>any());
    WildcardConstantFilter wildcardConstantFilter = new WildcardConstantFilter(constantVisitor);
    LibraryClass clazz = new LibraryClass();
    InterfaceMethodrefConstant interfaceMethodrefConstant = mock(InterfaceMethodrefConstant.class);
    doNothing()
        .when(interfaceMethodrefConstant)
        .accept(Mockito.<Clazz>any(), Mockito.<ConstantVisitor>any());

    // Act
    wildcardConstantFilter.visitInterfaceMethodrefConstant(clazz, interfaceMethodrefConstant);

    // Assert
    verify(interfaceMethodrefConstant).accept(isA(Clazz.class), isA(ConstantVisitor.class));
    verify(constantVisitor)
        .visitInterfaceMethodrefConstant(isA(Clazz.class), isA(InterfaceMethodrefConstant.class));
  }

  /**
   * Test {@link WildcardConstantFilter#visitInterfaceMethodrefConstant(Clazz,
   * InterfaceMethodrefConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link ConstantVisitor#visitInterfaceMethodrefConstant(Clazz,
   *       InterfaceMethodrefConstant)}.
   * </ul>
   *
   * <p>Method under test: {@link WildcardConstantFilter#visitInterfaceMethodrefConstant(Clazz,
   * InterfaceMethodrefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitInterfaceMethodrefConstant(Clazz, InterfaceMethodrefConstant); then calls visitInterfaceMethodrefConstant(Clazz, InterfaceMethodrefConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.WildcardConstantFilter.visitInterfaceMethodrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.InterfaceMethodrefConstant)"
  })
  void testVisitInterfaceMethodrefConstant_thenCallsVisitInterfaceMethodrefConstant() {
    // Arrange
    BootstrapMethodHandleTraveler constantVisitor = mock(BootstrapMethodHandleTraveler.class);
    doNothing()
        .when(constantVisitor)
        .visitInterfaceMethodrefConstant(
            Mockito.<Clazz>any(), Mockito.<InterfaceMethodrefConstant>any());
    WildcardConstantFilter wildcardConstantFilter = new WildcardConstantFilter(constantVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    wildcardConstantFilter.visitInterfaceMethodrefConstant(clazz, new InterfaceMethodrefConstant());

    // Assert
    verify(constantVisitor)
        .visitInterfaceMethodrefConstant(isA(Clazz.class), isA(InterfaceMethodrefConstant.class));
  }

  /**
   * Test {@link WildcardConstantFilter#visitMethodrefConstant(Clazz, MethodrefConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link MethodrefConstant#accept(Clazz, ConstantVisitor)}.
   * </ul>
   *
   * <p>Method under test: {@link WildcardConstantFilter#visitMethodrefConstant(Clazz,
   * MethodrefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitMethodrefConstant(Clazz, MethodrefConstant); then calls accept(Clazz, ConstantVisitor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.WildcardConstantFilter.visitMethodrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodrefConstant)"
  })
  void testVisitMethodrefConstant_thenCallsAccept() {
    // Arrange
    BootstrapMethodHandleTraveler constantVisitor = mock(BootstrapMethodHandleTraveler.class);
    doNothing()
        .when(constantVisitor)
        .visitMethodrefConstant(Mockito.<Clazz>any(), Mockito.<MethodrefConstant>any());
    WildcardConstantFilter wildcardConstantFilter = new WildcardConstantFilter(constantVisitor);
    LibraryClass clazz = new LibraryClass();
    MethodrefConstant methodrefConstant = mock(MethodrefConstant.class);
    doNothing()
        .when(methodrefConstant)
        .accept(Mockito.<Clazz>any(), Mockito.<ConstantVisitor>any());

    // Act
    wildcardConstantFilter.visitMethodrefConstant(clazz, methodrefConstant);

    // Assert
    verify(methodrefConstant).accept(isA(Clazz.class), isA(ConstantVisitor.class));
    verify(constantVisitor).visitMethodrefConstant(isA(Clazz.class), isA(MethodrefConstant.class));
  }

  /**
   * Test {@link WildcardConstantFilter#visitMethodrefConstant(Clazz, MethodrefConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link ConstantVisitor#visitMethodrefConstant(Clazz, MethodrefConstant)}.
   * </ul>
   *
   * <p>Method under test: {@link WildcardConstantFilter#visitMethodrefConstant(Clazz,
   * MethodrefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitMethodrefConstant(Clazz, MethodrefConstant); then calls visitMethodrefConstant(Clazz, MethodrefConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.WildcardConstantFilter.visitMethodrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodrefConstant)"
  })
  void testVisitMethodrefConstant_thenCallsVisitMethodrefConstant() {
    // Arrange
    BootstrapMethodHandleTraveler constantVisitor = mock(BootstrapMethodHandleTraveler.class);
    doNothing()
        .when(constantVisitor)
        .visitMethodrefConstant(Mockito.<Clazz>any(), Mockito.<MethodrefConstant>any());
    WildcardConstantFilter wildcardConstantFilter = new WildcardConstantFilter(constantVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    wildcardConstantFilter.visitMethodrefConstant(clazz, new MethodrefConstant());

    // Assert
    verify(constantVisitor).visitMethodrefConstant(isA(Clazz.class), isA(MethodrefConstant.class));
  }

  /**
   * Test {@link WildcardConstantFilter#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link ConstantVisitor#visitClassConstant(Clazz, ClassConstant)}.
   * </ul>
   *
   * <p>Method under test: {@link WildcardConstantFilter#visitClassConstant(Clazz, ClassConstant)}
   */
  @Test
  @DisplayName(
      "Test visitClassConstant(Clazz, ClassConstant); then calls visitClassConstant(Clazz, ClassConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.WildcardConstantFilter.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant_thenCallsVisitClassConstant() {
    // Arrange
    BootstrapMethodHandleTraveler constantVisitor = mock(BootstrapMethodHandleTraveler.class);
    doNothing()
        .when(constantVisitor)
        .visitClassConstant(Mockito.<Clazz>any(), Mockito.<ClassConstant>any());
    WildcardConstantFilter wildcardConstantFilter = new WildcardConstantFilter(constantVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    wildcardConstantFilter.visitClassConstant(clazz, new ClassConstant());

    // Assert
    verify(constantVisitor).visitClassConstant(isA(Clazz.class), isA(ClassConstant.class));
  }

  /**
   * Test {@link WildcardConstantFilter#visitMethodTypeConstant(Clazz, MethodTypeConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link ConstantVisitor#visitMethodTypeConstant(Clazz, MethodTypeConstant)}.
   * </ul>
   *
   * <p>Method under test: {@link WildcardConstantFilter#visitMethodTypeConstant(Clazz,
   * MethodTypeConstant)}
   */
  @Test
  @DisplayName(
      "Test visitMethodTypeConstant(Clazz, MethodTypeConstant); then calls visitMethodTypeConstant(Clazz, MethodTypeConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.WildcardConstantFilter.visitMethodTypeConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodTypeConstant)"
  })
  void testVisitMethodTypeConstant_thenCallsVisitMethodTypeConstant() {
    // Arrange
    BootstrapMethodHandleTraveler constantVisitor = mock(BootstrapMethodHandleTraveler.class);
    doNothing()
        .when(constantVisitor)
        .visitMethodTypeConstant(Mockito.<Clazz>any(), Mockito.<MethodTypeConstant>any());
    WildcardConstantFilter wildcardConstantFilter = new WildcardConstantFilter(constantVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    wildcardConstantFilter.visitMethodTypeConstant(clazz, new MethodTypeConstant());

    // Assert
    verify(constantVisitor)
        .visitMethodTypeConstant(isA(Clazz.class), isA(MethodTypeConstant.class));
  }

  /**
   * Test {@link WildcardConstantFilter#visitNameAndTypeConstant(Clazz, NameAndTypeConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link ConstantVisitor#visitNameAndTypeConstant(Clazz, NameAndTypeConstant)}.
   * </ul>
   *
   * <p>Method under test: {@link WildcardConstantFilter#visitNameAndTypeConstant(Clazz,
   * NameAndTypeConstant)}
   */
  @Test
  @DisplayName(
      "Test visitNameAndTypeConstant(Clazz, NameAndTypeConstant); then calls visitNameAndTypeConstant(Clazz, NameAndTypeConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.WildcardConstantFilter.visitNameAndTypeConstant(proguard.classfile.Clazz, proguard.classfile.constant.NameAndTypeConstant)"
  })
  void testVisitNameAndTypeConstant_thenCallsVisitNameAndTypeConstant() {
    // Arrange
    BootstrapMethodHandleTraveler constantVisitor = mock(BootstrapMethodHandleTraveler.class);
    doNothing()
        .when(constantVisitor)
        .visitNameAndTypeConstant(Mockito.<Clazz>any(), Mockito.<NameAndTypeConstant>any());
    WildcardConstantFilter wildcardConstantFilter = new WildcardConstantFilter(constantVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    wildcardConstantFilter.visitNameAndTypeConstant(clazz, new NameAndTypeConstant(1, 1));

    // Assert
    verify(constantVisitor)
        .visitNameAndTypeConstant(isA(Clazz.class), isA(NameAndTypeConstant.class));
  }

  /**
   * Test {@link WildcardConstantFilter#visitModuleConstant(Clazz, ModuleConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link ConstantVisitor#visitModuleConstant(Clazz, ModuleConstant)}.
   * </ul>
   *
   * <p>Method under test: {@link WildcardConstantFilter#visitModuleConstant(Clazz, ModuleConstant)}
   */
  @Test
  @DisplayName(
      "Test visitModuleConstant(Clazz, ModuleConstant); then calls visitModuleConstant(Clazz, ModuleConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.WildcardConstantFilter.visitModuleConstant(proguard.classfile.Clazz, proguard.classfile.constant.ModuleConstant)"
  })
  void testVisitModuleConstant_thenCallsVisitModuleConstant() {
    // Arrange
    BootstrapMethodHandleTraveler constantVisitor = mock(BootstrapMethodHandleTraveler.class);
    doNothing()
        .when(constantVisitor)
        .visitModuleConstant(Mockito.<Clazz>any(), Mockito.<ModuleConstant>any());
    WildcardConstantFilter wildcardConstantFilter = new WildcardConstantFilter(constantVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    wildcardConstantFilter.visitModuleConstant(clazz, new ModuleConstant(1));

    // Assert
    verify(constantVisitor).visitModuleConstant(isA(Clazz.class), isA(ModuleConstant.class));
  }

  /**
   * Test {@link WildcardConstantFilter#visitPackageConstant(Clazz, PackageConstant)}.
   *
   * <ul>
   *   <li>Then calls {@link ConstantVisitor#visitPackageConstant(Clazz, PackageConstant)}.
   * </ul>
   *
   * <p>Method under test: {@link WildcardConstantFilter#visitPackageConstant(Clazz,
   * PackageConstant)}
   */
  @Test
  @DisplayName(
      "Test visitPackageConstant(Clazz, PackageConstant); then calls visitPackageConstant(Clazz, PackageConstant)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.util.WildcardConstantFilter.visitPackageConstant(proguard.classfile.Clazz, proguard.classfile.constant.PackageConstant)"
  })
  void testVisitPackageConstant_thenCallsVisitPackageConstant() {
    // Arrange
    BootstrapMethodHandleTraveler constantVisitor = mock(BootstrapMethodHandleTraveler.class);
    doNothing()
        .when(constantVisitor)
        .visitPackageConstant(Mockito.<Clazz>any(), Mockito.<PackageConstant>any());
    WildcardConstantFilter wildcardConstantFilter = new WildcardConstantFilter(constantVisitor);
    LibraryClass clazz = new LibraryClass();

    // Act
    wildcardConstantFilter.visitPackageConstant(clazz, new PackageConstant(1));

    // Assert
    verify(constantVisitor).visitPackageConstant(isA(Clazz.class), isA(PackageConstant.class));
  }
}
