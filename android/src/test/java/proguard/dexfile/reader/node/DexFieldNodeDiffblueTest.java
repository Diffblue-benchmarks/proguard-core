package proguard.dexfile.reader.node;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexFieldNode.<init>(int, proguard.dexfile.reader.Field, java.lang.Object)",
    "void proguard.dexfile.reader.node.DexFieldNode.<init>(proguard.dexfile.reader.visitors.DexFieldVisitor, int, proguard.dexfile.reader.Field, java.lang.Object)"
  })
  void testNewDexFieldNode_whenDexFieldVisitor() {
    // Arrange
    DexFieldVisitor visitor = new DexFieldVisitor();

    // Act and Assert
    Field field =
        (new DexFieldNode(visitor, 1, new Field("Owner", "Name", "Type"), Constant.Null)).field;
    assertEquals("Name", field.getName());
    assertEquals("Owner", field.getOwner());
    assertEquals("Type", field.getType());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexFieldNode.<init>(int, proguard.dexfile.reader.Field, java.lang.Object)",
    "void proguard.dexfile.reader.node.DexFieldNode.<init>(proguard.dexfile.reader.visitors.DexFieldVisitor, int, proguard.dexfile.reader.Field, java.lang.Object)"
  })
  void testNewDexFieldNode_whenFieldWithOwnerAndNameAndType() {
    // Arrange, Act and Assert
    Field field = (new DexFieldNode(1, new Field("Owner", "Name", "Type"), Constant.Null)).field;
    assertEquals("Name", field.getName());
    assertEquals("Owner", field.getOwner());
    assertEquals("Type", field.getType());
  }

  /**
   * Test {@link DexFieldNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexFieldNode#accept(DexClassVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexClassVisitor) with 'dcv'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexFieldNode.accept(proguard.dexfile.reader.visitors.DexClassVisitor)"
  })
  void testAcceptWithDcv() {
    // Arrange
    DexFieldNode dexFieldNode =
        new DexFieldNode(1, new Field("Owner", "Name", "Type"), Constant.Null);
    DexClassNode dcv =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexFieldNode.accept(proguard.dexfile.reader.visitors.DexClassVisitor)"
  })
  void testAcceptWithDcv2() {
    // Arrange
    DexFieldNode dexFieldNode =
        new DexFieldNode(1, new Field("Owner", "Name", "Type"), Constant.Null);
    dexFieldNode.visitAnnotation("Name", Visibility.BUILD);
    DexClassNode dcv =
        new DexClassNode(1, "Class Name", "Super Class", new String[] {"Interface Names"});

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
   * <ul>
   *   <li>Given {@link DexAnnotationNode} {@link DexAnnotationVisitor#visitEnd()} does nothing.
   *   <li>Then calls {@link DexAnnotationVisitor#visitEnd()}.
   * </ul>
   *
   * <p>Method under test: {@link DexFieldNode#accept(DexFieldVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexFieldVisitor) with 'fv'; given DexAnnotationNode visitEnd() does nothing; then calls visitEnd()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexFieldNode.accept(proguard.dexfile.reader.visitors.DexFieldVisitor)"
  })
  void testAcceptWithFv_givenDexAnnotationNodeVisitEndDoesNothing_thenCallsVisitEnd() {
    // Arrange
    DexFieldNode dexFieldNode =
        new DexFieldNode(1, new Field("Owner", "Name", "Type"), Constant.Null);
    dexFieldNode.visitAnnotation("Name", Visibility.BUILD);
    DexAnnotationNode dexAnnotationNode = mock(DexAnnotationNode.class);
    doNothing().when(dexAnnotationNode).visitEnd();
    DexFieldVisitor fv = mock(DexFieldVisitor.class);
    when(fv.visitAnnotation(Mockito.<String>any(), Mockito.<Visibility>any()))
        .thenReturn(dexAnnotationNode);

    // Act
    dexFieldNode.accept(fv);

    // Assert
    verify(dexAnnotationNode).visitEnd();
    verify(fv).visitAnnotation(eq("Name"), eq(Visibility.BUILD));
  }

  /**
   * Test {@link DexFieldNode#accept(DexFieldVisitor)} with {@code fv}.
   *
   * <ul>
   *   <li>Given {@link DexAnnotationVisitor#DexAnnotationVisitor()}.
   * </ul>
   *
   * <p>Method under test: {@link DexFieldNode#accept(DexFieldVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexFieldVisitor) with 'fv'; given DexAnnotationVisitor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexFieldNode.accept(proguard.dexfile.reader.visitors.DexFieldVisitor)"
  })
  void testAcceptWithFv_givenDexAnnotationVisitor() {
    // Arrange
    DexFieldNode dexFieldNode =
        new DexFieldNode(1, new Field("Owner", "Name", "Type"), Constant.Null);
    dexFieldNode.visitAnnotation("Name", Visibility.BUILD);
    DexFieldVisitor fv = mock(DexFieldVisitor.class);
    when(fv.visitAnnotation(Mockito.<String>any(), Mockito.<Visibility>any()))
        .thenReturn(new DexAnnotationVisitor());

    // Act
    dexFieldNode.accept(fv);

    // Assert
    verify(fv).visitAnnotation(eq("Name"), eq(Visibility.BUILD));
  }

  /**
   * Test {@link DexFieldNode#accept(DexFieldVisitor)} with {@code fv}.
   *
   * <ul>
   *   <li>Given {@link DexAnnotationVisitor#DexAnnotationVisitor(DexAnnotationVisitor)} with
   *       visitor is {@link DexAnnotationVisitor#DexAnnotationVisitor()}.
   * </ul>
   *
   * <p>Method under test: {@link DexFieldNode#accept(DexFieldVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexFieldVisitor) with 'fv'; given DexAnnotationVisitor(DexAnnotationVisitor) with visitor is DexAnnotationVisitor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexFieldNode.accept(proguard.dexfile.reader.visitors.DexFieldVisitor)"
  })
  void testAcceptWithFv_givenDexAnnotationVisitorWithVisitorIsDexAnnotationVisitor() {
    // Arrange
    DexFieldNode dexFieldNode =
        new DexFieldNode(1, new Field("Owner", "Name", "Type"), Constant.Null);
    dexFieldNode.visitAnnotation("Name", Visibility.BUILD);
    DexFieldVisitor fv = mock(DexFieldVisitor.class);
    when(fv.visitAnnotation(Mockito.<String>any(), Mockito.<Visibility>any()))
        .thenReturn(new DexAnnotationVisitor(new DexAnnotationVisitor()));

    // Act
    dexFieldNode.accept(fv);

    // Assert
    verify(fv).visitAnnotation(eq("Name"), eq(Visibility.BUILD));
  }

  /**
   * Test {@link DexFieldNode#visitAnnotation(String, Visibility)}.
   *
   * <p>Method under test: {@link DexFieldNode#visitAnnotation(String, Visibility)}
   */
  @Test
  @DisplayName("Test visitAnnotation(String, Visibility)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.reader.visitors.DexAnnotationVisitor proguard.dexfile.reader.node.DexFieldNode.visitAnnotation(java.lang.String, proguard.dexfile.reader.Visibility)"
  })
  void testVisitAnnotation() {
    // Arrange
    DexFieldNode dexFieldNode =
        new DexFieldNode(1, new Field("Owner", "Name", "Type"), Constant.Null);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.reader.visitors.DexAnnotationVisitor proguard.dexfile.reader.node.DexFieldNode.visitAnnotation(java.lang.String, proguard.dexfile.reader.Visibility)"
  })
  void testVisitAnnotation_givenDexFieldNodeWithAccessIsOneAndFieldIsFieldAndCstIsNull() {
    // Arrange
    DexFieldNode dexFieldNode =
        new DexFieldNode(1, new Field("Owner", "Name", "Type"), Constant.Null);

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
