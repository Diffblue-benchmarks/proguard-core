package proguard.classfile;

import static org.junit.Assert.assertEquals;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class LibraryMemberDiffblueTest {
  /**
   * Test {@link LibraryMember#getAccessFlags()}.
   *
   * <p>Method under test: {@link LibraryMember#getAccessFlags()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int LibraryMember.getAccessFlags()"})
  public void testGetAccessFlags() {
    // Arrange, Act and Assert
    assertEquals(1, (new LibraryField(1, "Name", "Descriptor")).getAccessFlags());
  }

  /**
   * Test {@link LibraryMember#getName(Clazz)}.
   *
   * <p>Method under test: {@link LibraryMember#getName(Clazz)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String LibraryMember.getName(Clazz)"})
  public void testGetName() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"java.lang.String LibraryMember.getDescriptor(Clazz)"})
  public void testGetDescriptor() {
    // Arrange
    LibraryField libraryField = new LibraryField(1, "Name", "Descriptor");

    // Act and Assert
    assertEquals("Descriptor", libraryField.getDescriptor(new LibraryClass()));
  }
}
