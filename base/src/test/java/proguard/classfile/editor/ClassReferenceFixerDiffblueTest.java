package proguard.classfile.editor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;
import proguard.testutils.cpa.NamedClass;

public class ClassReferenceFixerDiffblueTest {
  /**
   * Method under test: {@link ClassReferenceFixer#visitAnyClass(Clazz)}
   */
  @Test
  public void testVisitAnyClass() {
    // Arrange
    ClassReferenceFixer classReferenceFixer = new ClassReferenceFixer(true);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> classReferenceFixer.visitAnyClass(new LibraryClass()));
  }

  /**
   * Method under test:
   * {@link ClassReferenceFixer#shortKotlinNestedClassName(String, String, Clazz)}
   */
  @Test
  public void testShortKotlinNestedClassName() {
    // Arrange, Act and Assert
    assertEquals("Short Inner Class Name",
        ClassReferenceFixer.shortKotlinNestedClassName("Enclosing Class Name", "Short Inner Class Name", null));
    assertEquals("", ClassReferenceFixer.shortKotlinNestedClassName("Enclosing Class Name", "Short Inner Class Name",
        new LibraryClass(91, "$", "$")));
    assertEquals("", ClassReferenceFixer.shortKotlinNestedClassName("Enclosing Class Name", "Short Inner Class Name",
        new NamedClass("$")));
  }

  /**
   * Method under test: {@link ClassReferenceFixer#newDescriptor(String, Clazz[])}
   */
  @Test
  public void testNewDescriptor() {
    // Arrange, Act and Assert
    assertEquals("Descriptor", ClassReferenceFixer.newDescriptor("Descriptor", new Clazz[]{new LibraryClass()}));
    assertEquals("Lnull;", ClassReferenceFixer.newDescriptor("Lkotlin/jvm/JvmName;", new Clazz[]{new LibraryClass()}));
    assertEquals("Descriptor", ClassReferenceFixer.newDescriptor("Descriptor", null));
    assertEquals("Descriptor", ClassReferenceFixer.newDescriptor("Descriptor", new Clazz[]{}));
    assertEquals("Lkotlin/jvm/JvmName;", ClassReferenceFixer.newDescriptor("Lkotlin/jvm/JvmName;", new Clazz[]{null}));
    assertEquals("LMember Name;",
        ClassReferenceFixer.newDescriptor("Lkotlin/jvm/JvmName;", new Clazz[]{new NamedClass("Member Name")}));
    assertEquals("Unexpected error while updating descriptor:",
        ClassReferenceFixer.newDescriptor("Unexpected error while updating descriptor:", new Clazz[]{null}));
  }
}
