package proguard.classfile;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LibraryMemberDiffblueTest {
  /**
   * Method under test: {@link LibraryMember#getAccessFlags()}
   */
  @Test
  public void testGetAccessFlags() {
    // Arrange, Act and Assert
    assertEquals(1, (new LibraryField(1, "Name", "Descriptor")).getAccessFlags());
  }

  /**
   * Method under test: {@link LibraryMember#getName(Clazz)}
   */
  @Test
  public void testGetName() {
    // Arrange
    LibraryField libraryField = new LibraryField(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals("Name", libraryField.getName(new LibraryClass()));
  }

  /**
   * Method under test: {@link LibraryMember#getDescriptor(Clazz)}
   */
  @Test
  public void testGetDescriptor() {
    // Arrange
    LibraryField libraryField = new LibraryField(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals("Descriptor", libraryField.getDescriptor(new LibraryClass()));
  }
}
