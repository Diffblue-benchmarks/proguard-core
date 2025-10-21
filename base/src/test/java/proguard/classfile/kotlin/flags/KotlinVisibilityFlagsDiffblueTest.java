package proguard.classfile.kotlin.flags;

import static org.junit.Assert.assertFalse;

import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class KotlinVisibilityFlagsDiffblueTest {
  /**
   * Test new {@link KotlinVisibilityFlags} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link KotlinVisibilityFlags}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void KotlinVisibilityFlags.<init>()"})
  public void testNewKotlinVisibilityFlags() {
    // Arrange and Act
    KotlinVisibilityFlags actualKotlinVisibilityFlags = new KotlinVisibilityFlags();

    // Assert
    assertFalse(actualKotlinVisibilityFlags.isInternal);
    assertFalse(actualKotlinVisibilityFlags.isLocal);
    assertFalse(actualKotlinVisibilityFlags.isPrivate);
    assertFalse(actualKotlinVisibilityFlags.isPrivateToThis);
    assertFalse(actualKotlinVisibilityFlags.isProtected);
    assertFalse(actualKotlinVisibilityFlags.isPublic);
  }
}
