package proguard.classfile.attribute.annotation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import proguard.classfile.attribute.annotation.target.CatchTargetInfo;
import proguard.classfile.attribute.annotation.target.TargetInfo;

public class TypeAnnotationDiffblueTest {
  /**
   * Test {@link TypeAnnotation#TypeAnnotation()}.
   *
   * <p>Method under test: {@link TypeAnnotation#TypeAnnotation()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void TypeAnnotation.<init>()",
    "void TypeAnnotation.<init>(int, int, ElementValue[], TargetInfo, TypePathInfo[])"
  })
  public void testNewTypeAnnotation() {
    // Arrange and Act
    TypeAnnotation actualTypeAnnotation = new TypeAnnotation();

    // Assert
    assertNull(actualTypeAnnotation.getProcessingInfo());
    assertEquals(0, actualTypeAnnotation.getProcessingFlags());
  }

  /**
   * Test {@link TypeAnnotation#TypeAnnotation(int, int, ElementValue[], TargetInfo,
   * TypePathInfo[])}.
   *
   * <ul>
   *   <li>When one.
   * </ul>
   *
   * <p>Method under test: {@link TypeAnnotation#TypeAnnotation(int, int, ElementValue[],
   * TargetInfo, TypePathInfo[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void TypeAnnotation.<init>()",
    "void TypeAnnotation.<init>(int, int, ElementValue[], TargetInfo, TypePathInfo[])"
  })
  public void testNewTypeAnnotation_whenOne() {
    // Arrange
    CatchTargetInfo targetInfo = new CatchTargetInfo((byte) 'A');

    // Act
    TypeAnnotation actualTypeAnnotation =
        new TypeAnnotation(
            1,
            3,
            new ElementValue[] {new AnnotationElementValue()},
            targetInfo,
            new TypePathInfo[] {new TypePathInfo(1, 1)});

    // Assert
    assertNull(actualTypeAnnotation.getProcessingInfo());
    assertEquals(0, actualTypeAnnotation.getProcessingFlags());
  }
}
