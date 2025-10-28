package proguard.classfile.visitor;

import static org.junit.Assert.assertThrows;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;

public class MemberAccessFlagCleanerDiffblueTest {
  /**
   * Method under test: {@link MemberAccessFlagCleaner#visitAnyClass(Clazz)}
   */
  @Test
  public void testVisitAnyClass() {
    // Arrange
    MemberAccessFlagCleaner memberAccessFlagCleaner = new MemberAccessFlagCleaner(1);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> memberAccessFlagCleaner.visitAnyClass(new LibraryClass()));
  }
}
