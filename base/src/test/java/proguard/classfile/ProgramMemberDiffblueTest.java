package proguard.classfile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ProgramMemberDiffblueTest {
  /**
   * Test {@link ProgramMember#getAccessFlags()}.
   *
   * <p>Method under test: {@link ProgramMember#getAccessFlags()}
   */
  @Test
  @DisplayName("Test getAccessFlags()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int proguard.classfile.ProgramMember.getAccessFlags()"})
  void testGetAccessFlags() {
    // Arrange, Act and Assert
    assertEquals(0, (new ProgramField()).getAccessFlags());
  }

  /**
   * Test {@link ProgramMember#getName(Clazz)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>When {@link LibraryClass} {@link LibraryClass#getString(int)} return {@code String}.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramMember#getName(Clazz)}
   */
  @Test
  @DisplayName(
      "Test getName(Clazz); given 'String'; when LibraryClass getString(int) return 'String'; then return 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.ProgramMember.getName(proguard.classfile.Clazz)"
  })
  void testGetName_givenString_whenLibraryClassGetStringReturnString_thenReturnString() {
    // Arrange
    ProgramField programField = new ProgramField();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    String actualName = programField.getName(clazz);

    // Assert
    verify(clazz).getString(eq(0));
    assertEquals("String", actualName);
  }

  /**
   * Test {@link ProgramMember#getDescriptor(Clazz)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link ProgramMember#getDescriptor(Clazz)}
   */
  @Test
  @DisplayName("Test getDescriptor(Clazz); given 'String'; then return 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "java.lang.String proguard.classfile.ProgramMember.getDescriptor(proguard.classfile.Clazz)"
  })
  void testGetDescriptor_givenString_thenReturnString() {
    // Arrange
    ProgramField programField = new ProgramField();
    LibraryClass clazz = mock(LibraryClass.class);
    when(clazz.getString(anyInt())).thenReturn("String");

    // Act
    String actualDescriptor = programField.getDescriptor(clazz);

    // Assert
    verify(clazz).getString(eq(0));
    assertEquals("String", actualDescriptor);
  }
}
