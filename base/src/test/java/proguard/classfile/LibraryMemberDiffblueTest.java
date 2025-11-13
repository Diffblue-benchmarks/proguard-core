package proguard.classfile;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LibraryMemberDiffblueTest {
  /**
   * Test {@link LibraryMember#getAccessFlags()}.
   *
   * <p>Method under test: {@link LibraryMember#getAccessFlags()}
   */
  @Test
  @DisplayName("Test getAccessFlags()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int LibraryMember.getAccessFlags()"})
  void testGetAccessFlags() {
    // Arrange
    LibraryField libraryField = new LibraryField(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals(1, libraryField.getAccessFlags());
  }

  /**
   * Test {@link LibraryMember#getName(Clazz)}.
   *
   * <p>Method under test: {@link LibraryMember#getName(Clazz)}
   */
  @Test
  @DisplayName("Test getName(Clazz)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String LibraryMember.getName(Clazz)"})
  void testGetName() {
    // Arrange
    LibraryField libraryField = new LibraryField(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals("Name", libraryField.getName(new LibraryClass()));
  }

  /**
   * Test {@link LibraryMember#getDescriptor(Clazz)}.
   *
   * <p>Method under test: {@link LibraryMember#getDescriptor(Clazz)}
   */
  @Test
  @DisplayName("Test getDescriptor(Clazz)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String LibraryMember.getDescriptor(Clazz)"})
  void testGetDescriptor() {
    // Arrange
    LibraryField libraryField = new LibraryField(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals("Descriptor", libraryField.getDescriptor(new LibraryClass()));
  }
}
