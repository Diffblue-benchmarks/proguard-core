package proguard.classfile.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.LibraryField;
import proguard.classfile.Member;

class MethodLinkerDiffblueTest {
  /**
   * Test {@link MethodLinker#lastMember(Member)}.
   *
   * <p>Method under test: {@link MethodLinker#lastMember(Member)}
   */
  @Test
  @DisplayName("Test lastMember(Member)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Member MethodLinker.lastMember(Member)"})
  void testLastMember() {
    // Arrange
    LibraryField libraryField = new LibraryField(1, "Name", "Descriptor");
    libraryField.setProcessingInfo(null);

    LibraryField member = new LibraryField(1, "Name", "Descriptor");
    member.setProcessingInfo(libraryField);

    // Act
    Member actualLastMemberResult = MethodLinker.lastMember(member);

    // Assert
    assertTrue(actualLastMemberResult instanceof LibraryField);
    assertEquals("Descriptor", ((LibraryField) actualLastMemberResult).descriptor);
    assertEquals("Name", ((LibraryField) actualLastMemberResult).name);
    assertNull(actualLastMemberResult.getProcessingInfo());
    assertNull(((LibraryField) actualLastMemberResult).referencedClass);
    assertEquals(0, actualLastMemberResult.getProcessingFlags());
    assertEquals(1, actualLastMemberResult.getAccessFlags());
  }

  /**
   * Test {@link MethodLinker#lastMember(Member)}.
   *
   * <ul>
   *   <li>Given {@code Member}.
   *   <li>Then return ProcessingInfo is {@code Member}.
   * </ul>
   *
   * <p>Method under test: {@link MethodLinker#lastMember(Member)}
   */
  @Test
  @DisplayName("Test lastMember(Member); given 'Member'; then return ProcessingInfo is 'Member'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Member MethodLinker.lastMember(Member)"})
  void testLastMember_givenMember_thenReturnProcessingInfoIsMember() {
    // Arrange
    LibraryField member = new LibraryField(1, "Name", "Descriptor");
    member.setProcessingInfo("Member");

    // Act
    Member actualLastMemberResult = MethodLinker.lastMember(member);

    // Assert
    assertTrue(actualLastMemberResult instanceof LibraryField);
    assertEquals("Descriptor", ((LibraryField) actualLastMemberResult).descriptor);
    assertEquals("Member", actualLastMemberResult.getProcessingInfo());
    assertEquals("Name", ((LibraryField) actualLastMemberResult).name);
    assertNull(((LibraryField) actualLastMemberResult).referencedClass);
    assertEquals(0, actualLastMemberResult.getProcessingFlags());
    assertEquals(1, actualLastMemberResult.getAccessFlags());
  }

  /**
   * Test {@link MethodLinker#lastMember(Member)}.
   *
   * <ul>
   *   <li>When {@link LibraryField#LibraryField(int, String, String)} with u2accessFlags is one and
   *       {@code Name} and {@code Descriptor}.
   * </ul>
   *
   * <p>Method under test: {@link MethodLinker#lastMember(Member)}
   */
  @Test
  @DisplayName(
      "Test lastMember(Member); when LibraryField(int, String, String) with u2accessFlags is one and 'Name' and 'Descriptor'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Member MethodLinker.lastMember(Member)"})
  void testLastMember_whenLibraryFieldWithU2accessFlagsIsOneAndNameAndDescriptor() {
    // Arrange
    LibraryField member = new LibraryField(1, "Name", "Descriptor");

    // Act
    Member actualLastMemberResult = MethodLinker.lastMember(member);

    // Assert
    assertTrue(actualLastMemberResult instanceof LibraryField);
    assertEquals("Descriptor", ((LibraryField) actualLastMemberResult).descriptor);
    assertEquals("Name", ((LibraryField) actualLastMemberResult).name);
    assertNull(actualLastMemberResult.getProcessingInfo());
    assertNull(((LibraryField) actualLastMemberResult).referencedClass);
    assertEquals(0, actualLastMemberResult.getProcessingFlags());
    assertEquals(1, actualLastMemberResult.getAccessFlags());
  }
}
