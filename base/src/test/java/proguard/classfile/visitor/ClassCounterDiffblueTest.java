package proguard.classfile.visitor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.classfile.Clazz;
import proguard.classfile.LibraryClass;

class ClassCounterDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link ClassCounter}
   *   <li>{@link ClassCounter#visitAnyClass(Clazz)}
   *   <li>{@link ClassCounter#getCount()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.classfile.visitor.ClassCounter.<init>()",
    "int proguard.classfile.visitor.ClassCounter.getCount()",
    "void proguard.classfile.visitor.ClassCounter.visitAnyClass(proguard.classfile.Clazz)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ClassCounter actualClassCounter = new ClassCounter();
    actualClassCounter.visitAnyClass(new LibraryClass());

    // Assert
    assertEquals(1, actualClassCounter.getCount());
  }
}
