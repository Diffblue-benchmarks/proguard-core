package proguard.dexfile.reader.node;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import proguard.dexfile.ir.expr.Constant;
import proguard.dexfile.reader.Field;
import proguard.dexfile.reader.Visibility;
import proguard.dexfile.reader.visitors.DexAnnotationVisitor;
import proguard.dexfile.reader.visitors.DexClassVisitor;
import proguard.dexfile.reader.visitors.DexFieldVisitor;

class DexFieldNodeDiffblueTest {
  /**
   * Test {@link DexFieldNode#DexFieldNode(DexFieldVisitor, int, Field, Object)}.
   *
   * <ul>
   *   <li>When {@link DexFieldVisitor#DexFieldVisitor()}.
   * </ul>
   *
   * <p>Method under test: {@link DexFieldNode#DexFieldNode(DexFieldVisitor, int, Field, Object)}
   */
  @Test
  @DisplayName("Test new DexFieldNode(DexFieldVisitor, int, Field, Object); when DexFieldVisitor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DexFieldNode.<init>(int, Field, Object)",
    "void DexFieldNode.<init>(DexFieldVisitor, int, Field, Object)"
  })
  void testNewDexFieldNode_whenDexFieldVisitor() {
    // Arrange
    DexFieldVisitor visitor = new DexFieldVisitor();
    Field field = new Field("Owner", "Name", "Type");

    // Act and Assert
    Field field2 = new DexFieldNode(visitor, 1, field, Constant.Null).field;
    assertEquals("Name", field2.getName());
    assertEquals("Owner", field2.getOwner());
    assertEquals("Type", field2.getType());
  }

  /**
   * Test {@link DexFieldNode#DexFieldNode(int, Field, Object)}.
   *
   * <ul>
   *   <li>When {@link Field#Field(String, String, String)} with {@code Owner} and {@code Name} and
   *       {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link DexFieldNode#DexFieldNode(int, Field, Object)}
   */
  @Test
  @DisplayName(
      "Test new DexFieldNode(int, Field, Object); when Field(String, String, String) with 'Owner' and 'Name' and 'Type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DexFieldNode.<init>(int, Field, Object)",
    "void DexFieldNode.<init>(DexFieldVisitor, int, Field, Object)"
  })
  void testNewDexFieldNode_whenFieldWithOwnerAndNameAndType() {
    // Arrange
    Field field = new Field("Owner", "Name", "Type");

    // Act
    DexFieldNode actualDexFieldNode = new DexFieldNode(1, field, Constant.Null);

    // Assert
    Field field2 = actualDexFieldNode.field;
    assertEquals("Name", field2.getName());
    assertEquals("Owner", field2.getOwner());
    assertEquals("Type", field2.getType());
  }

  /**
   * Test {@link DexFieldNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexFieldNode#accept(DexClassVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexClassVisitor) with 'dcv'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexFieldNode.accept(DexClassVisitor)"})
  void testAcceptWithDcv() {
    // Arrange
    Field field = new Field("Owner", "Name", "Type");
    DexFieldNode dexFieldNode = new DexFieldNode(1, field, Constant.Null);
    String[] interfaceNames = new String[] {"Interface Names"};
    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);

    // Act
    dexFieldNode.accept(dcv);

    // Assert
    List<DexFieldNode> dexFieldNodeList = dcv.fields;
    assertEquals(1, dexFieldNodeList.size());
    DexFieldNode getResult = dexFieldNodeList.get(0);
    assertNull(getResult.anns);
    assertEquals(1, getResult.access);
    assertSame(dexFieldNode.cst, getResult.cst);
    assertSame(dexFieldNode.field, getResult.field);
  }

  /**
   * Test {@link DexFieldNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexFieldNode#accept(DexClassVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexClassVisitor) with 'dcv'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexFieldNode.accept(DexClassVisitor)"})
  void testAcceptWithDcv2() {
    // Arrange
    Field field = new Field("Owner", "Name", "Type");

    DexFieldNode dexFieldNode = new DexFieldNode(1, field, Constant.Null);
    dexFieldNode.visitAnnotation("Name", Visibility.BUILD);
    String[] interfaceNames = new String[] {"Interface Names"};
    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);

    // Act
    dexFieldNode.accept(dcv);

    // Assert
    List<DexFieldNode> dexFieldNodeList = dcv.fields;
    assertEquals(1, dexFieldNodeList.size());
    List<DexAnnotationNode> dexAnnotationNodeList = dexFieldNodeList.get(0).anns;
    assertEquals(1, dexAnnotationNodeList.size());
    DexAnnotationNode getResult = dexAnnotationNodeList.get(0);
    assertEquals("Name", getResult.type);
    assertEquals(Visibility.BUILD, getResult.visibility);
    assertTrue(getResult.items.isEmpty());
  }

  /**
   * Test {@link DexFieldNode#accept(DexFieldVisitor)} with {@code fv}.
   *
   * <p>Method under test: {@link DexFieldNode#accept(DexFieldVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexFieldVisitor) with 'fv'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexFieldNode.accept(DexFieldVisitor)"})
  void testAcceptWithFv() {
    // Arrange
    DexFieldVisitor visitor = new DexFieldVisitor();
    Field field = new Field("Owner", "Name", "Type");

    DexFieldNode dexFieldNode = new DexFieldNode(visitor, 1, field, Constant.Null);
    dexFieldNode.visitAnnotation("Name", Visibility.BUILD);
    Field field2 = new Field("Owner", "Name", "Type");
    DexFieldNode fv = new DexFieldNode(1, field2, Constant.Null);

    // Act
    dexFieldNode.accept(fv);

    // Assert
    List<DexAnnotationNode> dexAnnotationNodeList = fv.anns;
    assertEquals(1, dexAnnotationNodeList.size());
    DexAnnotationNode getResult = dexAnnotationNodeList.get(0);
    assertEquals("Name", getResult.type);
    assertEquals(Visibility.BUILD, getResult.visibility);
    assertTrue(getResult.items.isEmpty());
  }

  /**
   * Test {@link DexFieldNode#visitAnnotation(String, Visibility)}.
   *
   * <p>Method under test: {@link DexFieldNode#visitAnnotation(String, Visibility)}
   */
  @Test
  @DisplayName("Test visitAnnotation(String, Visibility)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DexAnnotationVisitor DexFieldNode.visitAnnotation(String, Visibility)"})
  void testVisitAnnotation() {
    // Arrange
    Field field = new Field("Owner", "Name", "Type");
    DexFieldNode dexFieldNode = new DexFieldNode(1, field, Constant.Null);
    dexFieldNode.anns = new ArrayList<>();

    // Act
    DexAnnotationVisitor actualVisitAnnotationResult =
        dexFieldNode.visitAnnotation("Name", Visibility.BUILD);

    // Assert
    assertTrue(actualVisitAnnotationResult instanceof DexAnnotationNode);
    assertEquals("Name", ((DexAnnotationNode) actualVisitAnnotationResult).type);
    assertEquals(1, dexFieldNode.anns.size());
    assertEquals(Visibility.BUILD, ((DexAnnotationNode) actualVisitAnnotationResult).visibility);
    assertTrue(((DexAnnotationNode) actualVisitAnnotationResult).items.isEmpty());
  }

  /**
   * Test {@link DexFieldNode#visitAnnotation(String, Visibility)}.
   *
   * <ul>
   *   <li>Given {@link DexFieldNode#DexFieldNode(int, Field, Object)} with access is one and field
   *       is {@link Field#Field(String, String, String)} and cst is {@link Constant#Null}.
   * </ul>
   *
   * <p>Method under test: {@link DexFieldNode#visitAnnotation(String, Visibility)}
   */
  @Test
  @DisplayName(
      "Test visitAnnotation(String, Visibility); given DexFieldNode(int, Field, Object) with access is one and field is Field(String, String, String) and cst is Null")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DexAnnotationVisitor DexFieldNode.visitAnnotation(String, Visibility)"})
  void testVisitAnnotation_givenDexFieldNodeWithAccessIsOneAndFieldIsFieldAndCstIsNull() {
    // Arrange
    Field field = new Field("Owner", "Name", "Type");
    DexFieldNode dexFieldNode = new DexFieldNode(1, field, Constant.Null);

    // Act
    DexAnnotationVisitor actualVisitAnnotationResult =
        dexFieldNode.visitAnnotation("Name", Visibility.BUILD);

    // Assert
    assertTrue(actualVisitAnnotationResult instanceof DexAnnotationNode);
    assertEquals("Name", ((DexAnnotationNode) actualVisitAnnotationResult).type);
    assertEquals(1, dexFieldNode.anns.size());
    assertEquals(Visibility.BUILD, ((DexAnnotationNode) actualVisitAnnotationResult).visibility);
    assertTrue(((DexAnnotationNode) actualVisitAnnotationResult).items.isEmpty());
  }
}
