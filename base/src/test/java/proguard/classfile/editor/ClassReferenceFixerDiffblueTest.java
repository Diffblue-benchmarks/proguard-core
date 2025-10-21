package proguard.classfile.editor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.testutils.cpa.NamedClass;

public class ClassReferenceFixerDiffblueTest {
  /**
   * Test {@link ClassReferenceFixer#visitAnyClass(Clazz)}.
   *
   * <ul>
   *   <li>When {@link LibraryClass#LibraryClass()}.
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#visitAnyClass(Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ClassReferenceFixer.visitAnyClass(Clazz)"})
  public void testVisitAnyClass_whenLibraryClass_thenThrowUnsupportedOperationException() {
    // Arrange
    ClassReferenceFixer classReferenceFixer = new ClassReferenceFixer(true);

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> classReferenceFixer.visitAnyClass(new LibraryClass()));
  }

  /**
   * Test {@link ClassReferenceFixer#shortKotlinNestedClassName(String, String, Clazz)}.
   *
   * <p>Method under test: {@link ClassReferenceFixer#shortKotlinNestedClassName(String, String,
   * Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "String ClassReferenceFixer.shortKotlinNestedClassName(String, String, Clazz)"
  })
  public void testShortKotlinNestedClassName() {
    // Arrange, Act and Assert
    assertEquals(
        "",
        ClassReferenceFixer.shortKotlinNestedClassName(
            "Enclosing Class Name", "Short Inner Class Name", new LibraryClass(91, "$", "$")));
  }

  /**
   * Test {@link ClassReferenceFixer#shortKotlinNestedClassName(String, String, Clazz)}.
   *
   * <ul>
   *   <li>When {@link NamedClass#NamedClass(String)} with memberName is {@code $}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#shortKotlinNestedClassName(String, String,
   * Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "String ClassReferenceFixer.shortKotlinNestedClassName(String, String, Clazz)"
  })
  public void testShortKotlinNestedClassName_whenNamedClassWithMemberNameIsDollarSign() {
    // Arrange, Act and Assert
    assertEquals(
        "",
        ClassReferenceFixer.shortKotlinNestedClassName(
            "Enclosing Class Name", "Short Inner Class Name", new NamedClass("$")));
  }

  /**
   * Test {@link ClassReferenceFixer#shortKotlinNestedClassName(String, String, Clazz)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code Short Inner Class Name}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#shortKotlinNestedClassName(String, String,
   * Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "String ClassReferenceFixer.shortKotlinNestedClassName(String, String, Clazz)"
  })
  public void testShortKotlinNestedClassName_whenNull_thenReturnShortInnerClassName() {
    // Arrange, Act and Assert
    assertEquals(
        "Short Inner Class Name",
        ClassReferenceFixer.shortKotlinNestedClassName(
            "Enclosing Class Name", "Short Inner Class Name", null));
  }

  /**
   * Test {@link ClassReferenceFixer#newDescriptor(String, Clazz[])} with {@code descriptor}, {@code
   * referencedClasses}.
   *
   * <p>Method under test: {@link ClassReferenceFixer#newDescriptor(String, Clazz[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ClassReferenceFixer.newDescriptor(String, Clazz[])"})
  public void testNewDescriptorWithDescriptorReferencedClasses() {
    // Arrange, Act and Assert
    assertEquals(
        "Unexpected error while updating descriptor:",
        ClassReferenceFixer.newDescriptor(
            "Unexpected error while updating descriptor:", new Clazz[] {null}));
  }

  /**
   * Test {@link ClassReferenceFixer#newDescriptor(String, Clazz[])} with {@code descriptor}, {@code
   * referencedClasses}.
   *
   * <ul>
   *   <li>Then return {@code Descriptor}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#newDescriptor(String, Clazz[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ClassReferenceFixer.newDescriptor(String, Clazz[])"})
  public void testNewDescriptorWithDescriptorReferencedClasses_thenReturnDescriptor() {
    // Arrange, Act and Assert
    assertEquals(
        "Descriptor",
        ClassReferenceFixer.newDescriptor("Descriptor", new Clazz[] {new LibraryClass()}));
  }

  /**
   * Test {@link ClassReferenceFixer#newDescriptor(String, Clazz[])} with {@code descriptor}, {@code
   * referencedClasses}.
   *
   * <ul>
   *   <li>Then return {@code Descriptor}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#newDescriptor(String, Clazz[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ClassReferenceFixer.newDescriptor(String, Clazz[])"})
  public void testNewDescriptorWithDescriptorReferencedClasses_thenReturnDescriptor2() {
    // Arrange, Act and Assert
    assertEquals("Descriptor", ClassReferenceFixer.newDescriptor("Descriptor", null));
  }

  /**
   * Test {@link ClassReferenceFixer#newDescriptor(String, Clazz[])} with {@code descriptor}, {@code
   * referencedClasses}.
   *
   * <ul>
   *   <li>Then return {@code LMember Name;}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#newDescriptor(String, Clazz[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ClassReferenceFixer.newDescriptor(String, Clazz[])"})
  public void testNewDescriptorWithDescriptorReferencedClasses_thenReturnLMemberName() {
    // Arrange, Act and Assert
    assertEquals(
        "LMember Name;",
        ClassReferenceFixer.newDescriptor(
            "Lkotlin/jvm/JvmName;", new Clazz[] {new NamedClass("Member Name")}));
  }

  /**
   * Test {@link ClassReferenceFixer#newDescriptor(String, Clazz[])} with {@code descriptor}, {@code
   * referencedClasses}.
   *
   * <ul>
   *   <li>Then return {@code Lkotlin/jvm/JvmName;}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#newDescriptor(String, Clazz[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ClassReferenceFixer.newDescriptor(String, Clazz[])"})
  public void testNewDescriptorWithDescriptorReferencedClasses_thenReturnLkotlinJvmJvmName() {
    // Arrange, Act and Assert
    assertEquals(
        "Lkotlin/jvm/JvmName;",
        ClassReferenceFixer.newDescriptor("Lkotlin/jvm/JvmName;", new Clazz[] {null}));
  }

  /**
   * Test {@link ClassReferenceFixer#newDescriptor(String, Clazz[])} with {@code descriptor}, {@code
   * referencedClasses}.
   *
   * <ul>
   *   <li>Then return {@code Lnull;}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#newDescriptor(String, Clazz[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ClassReferenceFixer.newDescriptor(String, Clazz[])"})
  public void testNewDescriptorWithDescriptorReferencedClasses_thenReturnLnull() {
    // Arrange, Act and Assert
    assertEquals(
        "Lnull;",
        ClassReferenceFixer.newDescriptor(
            "Lkotlin/jvm/JvmName;", new Clazz[] {new LibraryClass()}));
  }

  /**
   * Test {@link ClassReferenceFixer#newDescriptor(String, Clazz[])} with {@code descriptor}, {@code
   * referencedClasses}.
   *
   * <ul>
   *   <li>When empty array of {@link Clazz}.
   * </ul>
   *
   * <p>Method under test: {@link ClassReferenceFixer#newDescriptor(String, Clazz[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ClassReferenceFixer.newDescriptor(String, Clazz[])"})
  public void testNewDescriptorWithDescriptorReferencedClasses_whenEmptyArrayOfClazz() {
    // Arrange, Act and Assert
    assertEquals("Descriptor", ClassReferenceFixer.newDescriptor("Descriptor", new Clazz[] {}));
  }
}
