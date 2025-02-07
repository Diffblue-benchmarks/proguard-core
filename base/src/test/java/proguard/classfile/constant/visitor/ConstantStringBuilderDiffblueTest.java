package proguard.classfile.constant.visitor;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

class ConstantStringBuilderDiffblueTest {
  /**
   * Test {@link ConstantStringBuilder#visitStringConstant(Clazz, StringConstant)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass} {@link LibraryClass#getString(int)} return {@code String}.
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantStringBuilder#visitStringConstant(Clazz, StringConstant)}
   */
  @Test
  @DisplayName(
      "Test visitStringConstant(Clazz, StringConstant); when LibraryClass getString(int) return 'String'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.visitor.ConstantStringBuilder.visitStringConstant(proguard.classfile.Clazz, proguard.classfile.constant.StringConstant)"
  })
  void testVisitStringConstant_whenLibraryClassGetStringReturnString_thenCallsGetString() {
    // Arrange
    ConstantStringBuilder constantStringBuilder =
        new ConstantStringBuilder(new StringBuilder("foo"));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    constantStringBuilder.visitStringConstant(clazz, new StringConstant());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link ConstantStringBuilder#visitStringConstant(Clazz, StringConstant)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link StringConstant#getString(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantStringBuilder#visitStringConstant(Clazz, StringConstant)}
   */
  @Test
  @DisplayName(
      "Test visitStringConstant(Clazz, StringConstant); when LibraryClass; then calls getString(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.visitor.ConstantStringBuilder.visitStringConstant(proguard.classfile.Clazz, proguard.classfile.constant.StringConstant)"
  })
  void testVisitStringConstant_whenLibraryClass_thenCallsGetString() {
    // Arrange
    ConstantStringBuilder constantStringBuilder =
        new ConstantStringBuilder(new StringBuilder("foo"));
    LibraryClass clazz = mock(LibraryClass.class);
    StringConstant stringConstant = mock(StringConstant.class);
    when(stringConstant.getString(Mockito.<Clazz>any())).thenReturn("String");

    // Act
    constantStringBuilder.visitStringConstant(clazz, stringConstant);

    // Assert
    verify(stringConstant).getString(isA(Clazz.class));
  }

  /**
   * Test {@link ConstantStringBuilder#visitModuleConstant(Clazz, ModuleConstant)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link ModuleConstant#getName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantStringBuilder#visitModuleConstant(Clazz, ModuleConstant)}
   */
  @Test
  @DisplayName(
      "Test visitModuleConstant(Clazz, ModuleConstant); given 'Name'; when LibraryClass; then calls getName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.visitor.ConstantStringBuilder.visitModuleConstant(proguard.classfile.Clazz, proguard.classfile.constant.ModuleConstant)"
  })
  void testVisitModuleConstant_givenName_whenLibraryClass_thenCallsGetName() {
    // Arrange
    ConstantStringBuilder constantStringBuilder =
        new ConstantStringBuilder(new StringBuilder("foo"));
    LibraryClass clazz = mock(LibraryClass.class);
    ModuleConstant moduleConstant = mock(ModuleConstant.class);
    when(moduleConstant.getName(Mockito.<Clazz>any())).thenReturn("Name");

    // Act
    constantStringBuilder.visitModuleConstant(clazz, moduleConstant);

    // Assert
    verify(moduleConstant).getName(isA(Clazz.class));
  }

  /**
   * Test {@link ConstantStringBuilder#visitModuleConstant(Clazz, ModuleConstant)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantStringBuilder#visitModuleConstant(Clazz, ModuleConstant)}
   */
  @Test
  @DisplayName(
      "Test visitModuleConstant(Clazz, ModuleConstant); given 'String'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.visitor.ConstantStringBuilder.visitModuleConstant(proguard.classfile.Clazz, proguard.classfile.constant.ModuleConstant)"
  })
  void testVisitModuleConstant_givenString_thenCallsGetString() {
    // Arrange
    ConstantStringBuilder constantStringBuilder =
        new ConstantStringBuilder(new StringBuilder("foo"));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    constantStringBuilder.visitModuleConstant(clazz, new ModuleConstant(1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link ConstantStringBuilder#visitPackageConstant(Clazz, PackageConstant)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link PackageConstant#getName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantStringBuilder#visitPackageConstant(Clazz,
   * PackageConstant)}
   */
  @Test
  @DisplayName(
      "Test visitPackageConstant(Clazz, PackageConstant); given 'Name'; when LibraryClass; then calls getName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.visitor.ConstantStringBuilder.visitPackageConstant(proguard.classfile.Clazz, proguard.classfile.constant.PackageConstant)"
  })
  void testVisitPackageConstant_givenName_whenLibraryClass_thenCallsGetName() {
    // Arrange
    ConstantStringBuilder constantStringBuilder =
        new ConstantStringBuilder(new StringBuilder("foo"));
    LibraryClass clazz = mock(LibraryClass.class);
    PackageConstant packageConstant = mock(PackageConstant.class);
    when(packageConstant.getName(Mockito.<Clazz>any())).thenReturn("Name");

    // Act
    constantStringBuilder.visitPackageConstant(clazz, packageConstant);

    // Assert
    verify(packageConstant).getName(isA(Clazz.class));
  }

  /**
   * Test {@link ConstantStringBuilder#visitPackageConstant(Clazz, PackageConstant)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantStringBuilder#visitPackageConstant(Clazz,
   * PackageConstant)}
   */
  @Test
  @DisplayName(
      "Test visitPackageConstant(Clazz, PackageConstant); given 'String'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.visitor.ConstantStringBuilder.visitPackageConstant(proguard.classfile.Clazz, proguard.classfile.constant.PackageConstant)"
  })
  void testVisitPackageConstant_givenString_thenCallsGetString() {
    // Arrange
    ConstantStringBuilder constantStringBuilder =
        new ConstantStringBuilder(new StringBuilder("foo"));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    constantStringBuilder.visitPackageConstant(clazz, new PackageConstant(1));

    // Assert
    verify(clazz).getString(eq(1));
  }

  /**
   * Test {@link ConstantStringBuilder#visitFieldrefConstant(Clazz, FieldrefConstant)}.
   *
   * <ul>
   *   <li>Given {@code Class Name}.
   *   <li>Then calls {@link LibraryClass#getClassName(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantStringBuilder#visitFieldrefConstant(Clazz,
   * FieldrefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitFieldrefConstant(Clazz, FieldrefConstant); given 'Class Name'; then calls getClassName(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.visitor.ConstantStringBuilder.visitFieldrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.FieldrefConstant)"
  })
  void testVisitFieldrefConstant_givenClassName_thenCallsGetClassName() {
    // Arrange
    ConstantStringBuilder constantStringBuilder =
        new ConstantStringBuilder(new StringBuilder("foo"));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");
    when(clazz.getName(anyInt())).thenReturn("Name");
    when(clazz.getType(anyInt())).thenReturn("Type");

    // Act
    constantStringBuilder.visitFieldrefConstant(clazz, new FieldrefConstant());

    // Assert
    verify(clazz).getClassName(eq(0));
    verify(clazz).getName(eq(0));
    verify(clazz).getType(eq(0));
  }

  /**
   * Test {@link ConstantStringBuilder#visitInterfaceMethodrefConstant(Clazz,
   * InterfaceMethodrefConstant)}.
   *
   * <ul>
   *   <li>Given {@code Class Name}.
   *   <li>Then calls {@link LibraryClass#getClassName(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantStringBuilder#visitInterfaceMethodrefConstant(Clazz,
   * InterfaceMethodrefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitInterfaceMethodrefConstant(Clazz, InterfaceMethodrefConstant); given 'Class Name'; then calls getClassName(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.visitor.ConstantStringBuilder.visitInterfaceMethodrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.InterfaceMethodrefConstant)"
  })
  void testVisitInterfaceMethodrefConstant_givenClassName_thenCallsGetClassName() {
    // Arrange
    ConstantStringBuilder constantStringBuilder =
        new ConstantStringBuilder(new StringBuilder("foo"));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");
    when(clazz.getName(anyInt())).thenReturn("Name");
    when(clazz.getType(anyInt())).thenReturn("Type");

    // Act
    constantStringBuilder.visitInterfaceMethodrefConstant(clazz, new InterfaceMethodrefConstant());

    // Assert
    verify(clazz).getClassName(eq(0));
    verify(clazz).getName(eq(0));
    verify(clazz).getType(eq(0));
  }

  /**
   * Test {@link ConstantStringBuilder#visitMethodrefConstant(Clazz, MethodrefConstant)}.
   *
   * <ul>
   *   <li>Given {@code Class Name}.
   *   <li>Then calls {@link LibraryClass#getClassName(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantStringBuilder#visitMethodrefConstant(Clazz,
   * MethodrefConstant)}
   */
  @Test
  @DisplayName(
      "Test visitMethodrefConstant(Clazz, MethodrefConstant); given 'Class Name'; then calls getClassName(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.visitor.ConstantStringBuilder.visitMethodrefConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodrefConstant)"
  })
  void testVisitMethodrefConstant_givenClassName_thenCallsGetClassName() {
    // Arrange
    ConstantStringBuilder constantStringBuilder =
        new ConstantStringBuilder(new StringBuilder("foo"));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getClassName(anyInt())).thenReturn("Class Name");
    when(clazz.getName(anyInt())).thenReturn("Name");
    when(clazz.getType(anyInt())).thenReturn("Type");

    // Act
    constantStringBuilder.visitMethodrefConstant(clazz, new MethodrefConstant());

    // Assert
    verify(clazz).getClassName(eq(0));
    verify(clazz).getName(eq(0));
    verify(clazz).getType(eq(0));
  }

  /**
   * Test {@link ConstantStringBuilder#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link ClassConstant#getName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantStringBuilder#visitClassConstant(Clazz, ClassConstant)}
   */
  @Test
  @DisplayName(
      "Test visitClassConstant(Clazz, ClassConstant); given 'Name'; when LibraryClass; then calls getName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.visitor.ConstantStringBuilder.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant_givenName_whenLibraryClass_thenCallsGetName() {
    // Arrange
    ConstantStringBuilder constantStringBuilder =
        new ConstantStringBuilder(new StringBuilder("foo"));
    LibraryClass clazz = mock(LibraryClass.class);
    ClassConstant classConstant = mock(ClassConstant.class);
    when(classConstant.getName(Mockito.<Clazz>any())).thenReturn("Name");

    // Act
    constantStringBuilder.visitClassConstant(clazz, classConstant);

    // Assert
    verify(classConstant).getName(isA(Clazz.class));
  }

  /**
   * Test {@link ConstantStringBuilder#visitClassConstant(Clazz, ClassConstant)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantStringBuilder#visitClassConstant(Clazz, ClassConstant)}
   */
  @Test
  @DisplayName(
      "Test visitClassConstant(Clazz, ClassConstant); given 'String'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.visitor.ConstantStringBuilder.visitClassConstant(proguard.classfile.Clazz, proguard.classfile.constant.ClassConstant)"
  })
  void testVisitClassConstant_givenString_thenCallsGetString() {
    // Arrange
    ConstantStringBuilder constantStringBuilder =
        new ConstantStringBuilder(new StringBuilder("foo"));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    constantStringBuilder.visitClassConstant(clazz, new ClassConstant());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link ConstantStringBuilder#visitMethodTypeConstant(Clazz, MethodTypeConstant)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantStringBuilder#visitMethodTypeConstant(Clazz,
   * MethodTypeConstant)}
   */
  @Test
  @DisplayName(
      "Test visitMethodTypeConstant(Clazz, MethodTypeConstant); given 'String'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.visitor.ConstantStringBuilder.visitMethodTypeConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodTypeConstant)"
  })
  void testVisitMethodTypeConstant_givenString_thenCallsGetString() {
    // Arrange
    ConstantStringBuilder constantStringBuilder =
        new ConstantStringBuilder(new StringBuilder("foo"));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    constantStringBuilder.visitMethodTypeConstant(clazz, new MethodTypeConstant());

    // Assert
    verify(clazz).getString(eq(0));
  }

  /**
   * Test {@link ConstantStringBuilder#visitMethodTypeConstant(Clazz, MethodTypeConstant)}.
   *
   * <ul>
   *   <li>Given {@code Type}.
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link MethodTypeConstant#getType(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantStringBuilder#visitMethodTypeConstant(Clazz,
   * MethodTypeConstant)}
   */
  @Test
  @DisplayName(
      "Test visitMethodTypeConstant(Clazz, MethodTypeConstant); given 'Type'; when LibraryClass; then calls getType(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.visitor.ConstantStringBuilder.visitMethodTypeConstant(proguard.classfile.Clazz, proguard.classfile.constant.MethodTypeConstant)"
  })
  void testVisitMethodTypeConstant_givenType_whenLibraryClass_thenCallsGetType() {
    // Arrange
    ConstantStringBuilder constantStringBuilder =
        new ConstantStringBuilder(new StringBuilder("foo"));
    LibraryClass clazz = mock(LibraryClass.class);
    MethodTypeConstant methodTypeConstant = mock(MethodTypeConstant.class);
    when(methodTypeConstant.getType(Mockito.<Clazz>any())).thenReturn("Type");

    // Act
    constantStringBuilder.visitMethodTypeConstant(clazz, methodTypeConstant);

    // Assert
    verify(methodTypeConstant).getType(isA(Clazz.class));
  }

  /**
   * Test {@link ConstantStringBuilder#visitNameAndTypeConstant(Clazz, NameAndTypeConstant)}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>When {@link LibraryClass}.
   *   <li>Then calls {@link NameAndTypeConstant#getName(Clazz)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantStringBuilder#visitNameAndTypeConstant(Clazz,
   * NameAndTypeConstant)}
   */
  @Test
  @DisplayName(
      "Test visitNameAndTypeConstant(Clazz, NameAndTypeConstant); given 'Name'; when LibraryClass; then calls getName(Clazz)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.visitor.ConstantStringBuilder.visitNameAndTypeConstant(proguard.classfile.Clazz, proguard.classfile.constant.NameAndTypeConstant)"
  })
  void testVisitNameAndTypeConstant_givenName_whenLibraryClass_thenCallsGetName() {
    // Arrange
    ConstantStringBuilder constantStringBuilder =
        new ConstantStringBuilder(new StringBuilder("foo"));
    LibraryClass clazz = mock(LibraryClass.class);
    NameAndTypeConstant nameAndTypeConstant = mock(NameAndTypeConstant.class);
    when(nameAndTypeConstant.getName(Mockito.<Clazz>any())).thenReturn("Name");
    when(nameAndTypeConstant.getType(Mockito.<Clazz>any())).thenReturn("Type");

    // Act
    constantStringBuilder.visitNameAndTypeConstant(clazz, nameAndTypeConstant);

    // Assert
    verify(nameAndTypeConstant).getName(isA(Clazz.class));
    verify(nameAndTypeConstant).getType(isA(Clazz.class));
  }

  /**
   * Test {@link ConstantStringBuilder#visitNameAndTypeConstant(Clazz, NameAndTypeConstant)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then calls {@link LibraryClass#getString(int)}.
   * </ul>
   *
   * <p>Method under test: {@link ConstantStringBuilder#visitNameAndTypeConstant(Clazz,
   * NameAndTypeConstant)}
   */
  @Test
  @DisplayName(
      "Test visitNameAndTypeConstant(Clazz, NameAndTypeConstant); given 'String'; then calls getString(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.constant.visitor.ConstantStringBuilder.visitNameAndTypeConstant(proguard.classfile.Clazz, proguard.classfile.constant.NameAndTypeConstant)"
  })
  void testVisitNameAndTypeConstant_givenString_thenCallsGetString() {
    // Arrange
    ConstantStringBuilder constantStringBuilder =
        new ConstantStringBuilder(new StringBuilder("foo"));
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    constantStringBuilder.visitNameAndTypeConstant(clazz, new NameAndTypeConstant(1, 1));

    // Assert
    verify(clazz, atLeast(1)).getString(eq(1));
  }
}
