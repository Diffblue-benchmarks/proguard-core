package proguard.classfile.util.renderer;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import proguard.classfile.Clazz;
import proguard.classfile.Field;
import proguard.classfile.LibraryClass;
import proguard.classfile.LibraryField;
import proguard.classfile.Member;

public class FieldViewModelDiffblueTest {
  /**
   * Method under test: {@link FieldViewModel#render(Clazz, Field)}
   */
  @Test
  public void testRender() {
    // Arrange
    LibraryClass clazz = new LibraryClass();
    LibraryField field = new LibraryField(1, "Name", "Descriptor");

    // Act
    FieldViewModel actualRenderResult = FieldViewModel.render(clazz, field);

    // Assert
    assertNull(actualRenderResult.processingInfo);
    assertTrue(actualRenderResult.processingFlags.isEmpty());
    MemberViewModel.Pair<Clazz, Member> pair = actualRenderResult.model;
    assertSame(clazz, pair.key);
    assertSame(field, pair.value);
  }
}
