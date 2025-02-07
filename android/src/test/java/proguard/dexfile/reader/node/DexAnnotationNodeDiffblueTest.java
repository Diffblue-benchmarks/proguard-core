package proguard.dexfile.reader.node;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
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
import proguard.dexfile.reader.node.DexAnnotationNode.Item;
import proguard.dexfile.reader.visitors.DexAnnotationAble;
import proguard.dexfile.reader.visitors.DexAnnotationVisitor;

class DexAnnotationNodeDiffblueTest {
  /**
   * Test Item {@link Item#Item(String, Object)}.
   *
   * <p>Method under test: {@link Item#Item(String, Object)}
   */
  @Test
  @DisplayName("Test Item new Item(String, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexAnnotationNode$Item.<init>(java.lang.String, java.lang.Object)"
  })
  void testItemNewItem() {
    // Arrange, Act and Assert
    assertEquals("Name", (new Item("Name", Constant.Null)).name);
  }

  /**
   * Test {@link DexAnnotationNode#DexAnnotationNode(String, Visibility)}.
   *
   * <p>Method under test: {@link DexAnnotationNode#DexAnnotationNode(String, Visibility)}
   */
  @Test
  @DisplayName("Test new DexAnnotationNode(String, Visibility)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexAnnotationNode.<init>(java.lang.String, proguard.dexfile.reader.Visibility)"
  })
  void testNewDexAnnotationNode() {
    // Arrange and Act
    DexAnnotationNode actualDexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);

    // Assert
    assertEquals("Type", actualDexAnnotationNode.type);
    assertEquals(Visibility.BUILD, actualDexAnnotationNode.visibility);
    assertTrue(actualDexAnnotationNode.items.isEmpty());
  }

  /**
   * Test {@link DexAnnotationNode#accept(DexAnnotationAble)}.
   *
   * <p>Method under test: {@link DexAnnotationNode#accept(DexAnnotationAble)}
   */
  @Test
  @DisplayName("Test accept(DexAnnotationAble)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexAnnotationNode.accept(proguard.dexfile.reader.visitors.DexAnnotationAble)"
  })
  void testAccept() {
    // Arrange
    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(new Item("Name", Constant.Null));
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode.items = itemList;
    DexAnnotationAble av = mock(DexAnnotationAble.class);
    when(av.visitAnnotation(Mockito.<String>any(), Mockito.<Visibility>any()))
        .thenReturn(new DexAnnotationNode("Type", Visibility.BUILD));

    // Act
    dexAnnotationNode.accept(av);

    // Assert
    verify(av).visitAnnotation(eq("Type"), eq(Visibility.BUILD));
  }

  /**
   * Test {@link DexAnnotationNode#accept(DexAnnotationAble)}.
   *
   * <p>Method under test: {@link DexAnnotationNode#accept(DexAnnotationAble)}
   */
  @Test
  @DisplayName("Test accept(DexAnnotationAble)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexAnnotationNode.accept(proguard.dexfile.reader.visitors.DexAnnotationAble)"
  })
  void testAccept2() {
    // Arrange
    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(new Item("Name", new DexAnnotationNode("Type", Visibility.BUILD)));
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode.items = itemList;
    DexAnnotationAble av = mock(DexAnnotationAble.class);
    when(av.visitAnnotation(Mockito.<String>any(), Mockito.<Visibility>any()))
        .thenReturn(new DexAnnotationNode("Type", Visibility.BUILD));

    // Act
    dexAnnotationNode.accept(av);

    // Assert
    verify(av).visitAnnotation(eq("Type"), eq(Visibility.BUILD));
  }

  /**
   * Test {@link DexAnnotationNode#accept(DexAnnotationAble)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link Item#Item(String, Object)} with {@code
   *       Name} and value is {@link DexAnnotationNode#DexAnnotationNode(String, Visibility)}.
   * </ul>
   *
   * <p>Method under test: {@link DexAnnotationNode#accept(DexAnnotationAble)}
   */
  @Test
  @DisplayName(
      "Test accept(DexAnnotationAble); given ArrayList() add Item(String, Object) with 'Name' and value is DexAnnotationNode(String, Visibility)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexAnnotationNode.accept(proguard.dexfile.reader.visitors.DexAnnotationAble)"
  })
  void testAccept_givenArrayListAddItemWithNameAndValueIsDexAnnotationNode() {
    // Arrange
    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(new Item("Name", new DexAnnotationNode("Type", Visibility.BUILD)));
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode.items = itemList;
    DexAnnotationAble av = mock(DexAnnotationAble.class);
    when(av.visitAnnotation(Mockito.<String>any(), Mockito.<Visibility>any()))
        .thenReturn(new DexAnnotationVisitor());

    // Act
    dexAnnotationNode.accept(av);

    // Assert
    verify(av).visitAnnotation(eq("Type"), eq(Visibility.BUILD));
  }

  /**
   * Test {@link DexAnnotationNode#accept(DexAnnotationAble)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link Item#Item(String, Object)} with {@code
   *       Name} and value is {@link DexAnnotationNode#DexAnnotationNode(String, Visibility)}.
   * </ul>
   *
   * <p>Method under test: {@link DexAnnotationNode#accept(DexAnnotationAble)}
   */
  @Test
  @DisplayName(
      "Test accept(DexAnnotationAble); given ArrayList() add Item(String, Object) with 'Name' and value is DexAnnotationNode(String, Visibility)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexAnnotationNode.accept(proguard.dexfile.reader.visitors.DexAnnotationAble)"
  })
  void testAccept_givenArrayListAddItemWithNameAndValueIsDexAnnotationNode2() {
    // Arrange
    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(new Item("Name", new DexAnnotationNode("Type", Visibility.BUILD)));
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode.items = itemList;
    DexAnnotationAble av = mock(DexAnnotationAble.class);
    when(av.visitAnnotation(Mockito.<String>any(), Mockito.<Visibility>any()))
        .thenReturn(new DexAnnotationVisitor(new DexAnnotationVisitor()));

    // Act
    dexAnnotationNode.accept(av);

    // Assert
    verify(av).visitAnnotation(eq("Type"), eq(Visibility.BUILD));
  }

  /**
   * Test {@link DexAnnotationNode#accept(DexAnnotationAble)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link Item#Item(String, Object)} with {@code
   *       Name} and value is {@link Constant#Null}.
   * </ul>
   *
   * <p>Method under test: {@link DexAnnotationNode#accept(DexAnnotationAble)}
   */
  @Test
  @DisplayName(
      "Test accept(DexAnnotationAble); given ArrayList() add Item(String, Object) with 'Name' and value is Null")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexAnnotationNode.accept(proguard.dexfile.reader.visitors.DexAnnotationAble)"
  })
  void testAccept_givenArrayListAddItemWithNameAndValueIsNull() {
    // Arrange
    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(new Item("Name", Constant.Null));
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode.items = itemList;
    DexAnnotationAble av = mock(DexAnnotationAble.class);
    when(av.visitAnnotation(Mockito.<String>any(), Mockito.<Visibility>any()))
        .thenReturn(new DexAnnotationVisitor());

    // Act
    dexAnnotationNode.accept(av);

    // Assert
    verify(av).visitAnnotation(eq("Type"), eq(Visibility.BUILD));
  }

  /**
   * Test {@link DexAnnotationNode#accept(DexAnnotationAble)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link Item#Item(String, Object)} with {@code
   *       Name} and value is {@link Constant#Null}.
   * </ul>
   *
   * <p>Method under test: {@link DexAnnotationNode#accept(DexAnnotationAble)}
   */
  @Test
  @DisplayName(
      "Test accept(DexAnnotationAble); given ArrayList() add Item(String, Object) with 'Name' and value is Null")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexAnnotationNode.accept(proguard.dexfile.reader.visitors.DexAnnotationAble)"
  })
  void testAccept_givenArrayListAddItemWithNameAndValueIsNull2() {
    // Arrange
    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(new Item("Name", Constant.Null));
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode.items = itemList;
    DexAnnotationAble av = mock(DexAnnotationAble.class);
    when(av.visitAnnotation(Mockito.<String>any(), Mockito.<Visibility>any()))
        .thenReturn(new DexAnnotationVisitor(new DexAnnotationVisitor()));

    // Act
    dexAnnotationNode.accept(av);

    // Assert
    verify(av).visitAnnotation(eq("Type"), eq(Visibility.BUILD));
  }

  /**
   * Test {@link DexAnnotationNode#accept(DexAnnotationAble)}.
   *
   * <ul>
   *   <li>Given {@link DexAnnotationVisitor#DexAnnotationVisitor()}.
   * </ul>
   *
   * <p>Method under test: {@link DexAnnotationNode#accept(DexAnnotationAble)}
   */
  @Test
  @DisplayName("Test accept(DexAnnotationAble); given DexAnnotationVisitor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexAnnotationNode.accept(proguard.dexfile.reader.visitors.DexAnnotationAble)"
  })
  void testAccept_givenDexAnnotationVisitor() {
    // Arrange
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    DexAnnotationAble av = mock(DexAnnotationAble.class);
    when(av.visitAnnotation(Mockito.<String>any(), Mockito.<Visibility>any()))
        .thenReturn(new DexAnnotationVisitor());

    // Act
    dexAnnotationNode.accept(av);

    // Assert
    verify(av).visitAnnotation(eq("Type"), eq(Visibility.BUILD));
  }

  /**
   * Test {@link DexAnnotationNode#accept(DexAnnotationAble)}.
   *
   * <ul>
   *   <li>Given {@link DexAnnotationVisitor#DexAnnotationVisitor(DexAnnotationVisitor)} with
   *       visitor is {@link DexAnnotationNode#DexAnnotationNode(String, Visibility)}.
   * </ul>
   *
   * <p>Method under test: {@link DexAnnotationNode#accept(DexAnnotationAble)}
   */
  @Test
  @DisplayName(
      "Test accept(DexAnnotationAble); given DexAnnotationVisitor(DexAnnotationVisitor) with visitor is DexAnnotationNode(String, Visibility)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexAnnotationNode.accept(proguard.dexfile.reader.visitors.DexAnnotationAble)"
  })
  void testAccept_givenDexAnnotationVisitorWithVisitorIsDexAnnotationNode() {
    // Arrange
    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(new Item("Name", Constant.Null));
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode.items = itemList;
    DexAnnotationAble av = mock(DexAnnotationAble.class);
    when(av.visitAnnotation(Mockito.<String>any(), Mockito.<Visibility>any()))
        .thenReturn(new DexAnnotationVisitor(new DexAnnotationNode("Type", Visibility.BUILD)));

    // Act
    dexAnnotationNode.accept(av);

    // Assert
    verify(av).visitAnnotation(eq("Type"), eq(Visibility.BUILD));
  }

  /**
   * Test {@link DexAnnotationNode#accept(DexAnnotationAble)}.
   *
   * <ul>
   *   <li>Given {@link DexAnnotationVisitor#DexAnnotationVisitor(DexAnnotationVisitor)} with
   *       visitor is {@link DexAnnotationNode#DexAnnotationNode(String, Visibility)}.
   * </ul>
   *
   * <p>Method under test: {@link DexAnnotationNode#accept(DexAnnotationAble)}
   */
  @Test
  @DisplayName(
      "Test accept(DexAnnotationAble); given DexAnnotationVisitor(DexAnnotationVisitor) with visitor is DexAnnotationNode(String, Visibility)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexAnnotationNode.accept(proguard.dexfile.reader.visitors.DexAnnotationAble)"
  })
  void testAccept_givenDexAnnotationVisitorWithVisitorIsDexAnnotationNode2() {
    // Arrange
    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(new Item("Name", new DexAnnotationNode("Type", Visibility.BUILD)));
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode.items = itemList;
    DexAnnotationAble av = mock(DexAnnotationAble.class);
    when(av.visitAnnotation(Mockito.<String>any(), Mockito.<Visibility>any()))
        .thenReturn(new DexAnnotationVisitor(new DexAnnotationNode("Type", Visibility.BUILD)));

    // Act
    dexAnnotationNode.accept(av);

    // Assert
    verify(av).visitAnnotation(eq("Type"), eq(Visibility.BUILD));
  }

  /**
   * Test {@link DexAnnotationNode#accept(DexAnnotationAble)}.
   *
   * <ul>
   *   <li>Given {@link DexAnnotationVisitor#DexAnnotationVisitor(DexAnnotationVisitor)} with
   *       visitor is {@link DexAnnotationVisitor#DexAnnotationVisitor()}.
   * </ul>
   *
   * <p>Method under test: {@link DexAnnotationNode#accept(DexAnnotationAble)}
   */
  @Test
  @DisplayName(
      "Test accept(DexAnnotationAble); given DexAnnotationVisitor(DexAnnotationVisitor) with visitor is DexAnnotationVisitor()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexAnnotationNode.accept(proguard.dexfile.reader.visitors.DexAnnotationAble)"
  })
  void testAccept_givenDexAnnotationVisitorWithVisitorIsDexAnnotationVisitor() {
    // Arrange
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    DexAnnotationAble av = mock(DexAnnotationAble.class);
    when(av.visitAnnotation(Mockito.<String>any(), Mockito.<Visibility>any()))
        .thenReturn(new DexAnnotationVisitor(new DexAnnotationVisitor()));

    // Act
    dexAnnotationNode.accept(av);

    // Assert
    verify(av).visitAnnotation(eq("Type"), eq(Visibility.BUILD));
  }

  /**
   * Test {@link DexAnnotationNode#accept(DexAnnotationAble)}.
   *
   * <ul>
   *   <li>Given {@link Field#Field(String, String, String)} with {@code Owner} and {@code Name} and
   *       {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link DexAnnotationNode#accept(DexAnnotationAble)}
   */
  @Test
  @DisplayName(
      "Test accept(DexAnnotationAble); given Field(String, String, String) with 'Owner' and 'Name' and 'Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexAnnotationNode.accept(proguard.dexfile.reader.visitors.DexAnnotationAble)"
  })
  void testAccept_givenFieldWithOwnerAndNameAndType() {
    // Arrange
    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(new Item("Name", new Field("Owner", "Name", "Type")));
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode.items = itemList;
    DexAnnotationAble av = mock(DexAnnotationAble.class);
    when(av.visitAnnotation(Mockito.<String>any(), Mockito.<Visibility>any()))
        .thenReturn(new DexAnnotationVisitor());

    // Act
    dexAnnotationNode.accept(av);

    // Assert
    verify(av).visitAnnotation(eq("Type"), eq(Visibility.BUILD));
  }

  /**
   * Test {@link DexAnnotationNode#accept(DexAnnotationAble)}.
   *
   * <ul>
   *   <li>Given {@link Field#Field(String, String, String)} with {@code Owner} and {@code Name} and
   *       {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link DexAnnotationNode#accept(DexAnnotationAble)}
   */
  @Test
  @DisplayName(
      "Test accept(DexAnnotationAble); given Field(String, String, String) with 'Owner' and 'Name' and 'Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexAnnotationNode.accept(proguard.dexfile.reader.visitors.DexAnnotationAble)"
  })
  void testAccept_givenFieldWithOwnerAndNameAndType2() {
    // Arrange
    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(new Item("Name", new Field("Owner", "Name", "Type")));
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode.items = itemList;
    DexAnnotationAble av = mock(DexAnnotationAble.class);
    when(av.visitAnnotation(Mockito.<String>any(), Mockito.<Visibility>any()))
        .thenReturn(new DexAnnotationNode("Type", Visibility.BUILD));

    // Act
    dexAnnotationNode.accept(av);

    // Assert
    verify(av).visitAnnotation(eq("Type"), eq(Visibility.BUILD));
  }

  /**
   * Test {@link DexAnnotationNode#accept(DexAnnotationAble)}.
   *
   * <ul>
   *   <li>Given {@link Field#Field(String, String, String)} with {@code Owner} and {@code Name} and
   *       {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link DexAnnotationNode#accept(DexAnnotationAble)}
   */
  @Test
  @DisplayName(
      "Test accept(DexAnnotationAble); given Field(String, String, String) with 'Owner' and 'Name' and 'Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexAnnotationNode.accept(proguard.dexfile.reader.visitors.DexAnnotationAble)"
  })
  void testAccept_givenFieldWithOwnerAndNameAndType3() {
    // Arrange
    ArrayList<Item> itemList = new ArrayList<>();
    itemList.add(new Item("Name", new Field("Owner", "Name", "Type")));
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    dexAnnotationNode.items = itemList;
    DexAnnotationAble av = mock(DexAnnotationAble.class);
    when(av.visitAnnotation(Mockito.<String>any(), Mockito.<Visibility>any()))
        .thenReturn(new DexAnnotationVisitor(new DexAnnotationVisitor()));

    // Act
    dexAnnotationNode.accept(av);

    // Assert
    verify(av).visitAnnotation(eq("Type"), eq(Visibility.BUILD));
  }

  /**
   * Test {@link DexAnnotationNode#accept(DexAnnotationAble)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link DexAnnotationAble} {@link DexAnnotationAble#visitAnnotation(String,
   *       Visibility)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DexAnnotationNode#accept(DexAnnotationAble)}
   */
  @Test
  @DisplayName(
      "Test accept(DexAnnotationAble); given 'null'; when DexAnnotationAble visitAnnotation(String, Visibility) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexAnnotationNode.accept(proguard.dexfile.reader.visitors.DexAnnotationAble)"
  })
  void testAccept_givenNull_whenDexAnnotationAbleVisitAnnotationReturnNull() {
    // Arrange
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    DexAnnotationAble av = mock(DexAnnotationAble.class);
    when(av.visitAnnotation(Mockito.<String>any(), Mockito.<Visibility>any())).thenReturn(null);

    // Act
    dexAnnotationNode.accept(av);

    // Assert
    verify(av).visitAnnotation(eq("Type"), eq(Visibility.BUILD));
  }

  /**
   * Test {@link DexAnnotationNode#visit(String, Object)}.
   *
   * <ul>
   *   <li>Then {@link DexAnnotationNode#DexAnnotationNode(String, Visibility)} with {@code Type}
   *       and visibility is {@code BUILD} {@link DexAnnotationNode#items} size is one.
   * </ul>
   *
   * <p>Method under test: {@link DexAnnotationNode#visit(String, Object)}
   */
  @Test
  @DisplayName(
      "Test visit(String, Object); then DexAnnotationNode(String, Visibility) with 'Type' and visibility is 'BUILD' items size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexAnnotationNode.visit(java.lang.String, java.lang.Object)"
  })
  void testVisit_thenDexAnnotationNodeWithTypeAndVisibilityIsBuildItemsSizeIsOne() {
    // Arrange
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);
    Object object = Constant.Null;

    // Act
    dexAnnotationNode.visit("Name", object);

    // Assert
    List<Item> itemList = dexAnnotationNode.items;
    assertEquals(1, itemList.size());
    Item getResult = itemList.get(0);
    assertEquals("Name", getResult.name);
    assertSame(object, getResult.value);
  }

  /**
   * Test {@link DexAnnotationNode#visitAnnotation(String, String)}.
   *
   * <ul>
   *   <li>Then return {@link DexAnnotationNode}.
   * </ul>
   *
   * <p>Method under test: {@link DexAnnotationNode#visitAnnotation(String, String)}
   */
  @Test
  @DisplayName("Test visitAnnotation(String, String); then return DexAnnotationNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "proguard.dexfile.reader.visitors.DexAnnotationVisitor proguard.dexfile.reader.node.DexAnnotationNode.visitAnnotation(java.lang.String, java.lang.String)"
  })
  void testVisitAnnotation_thenReturnDexAnnotationNode() {
    // Arrange
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);

    // Act
    DexAnnotationVisitor actualVisitAnnotationResult =
        dexAnnotationNode.visitAnnotation("Name", "The characteristics of someone or something");

    // Assert
    assertTrue(actualVisitAnnotationResult instanceof DexAnnotationNode);
    List<Item> itemList = dexAnnotationNode.items;
    assertEquals(1, itemList.size());
    assertEquals("Name", itemList.get(0).name);
    assertEquals(
        "The characteristics of someone or something",
        ((DexAnnotationNode) actualVisitAnnotationResult).type);
    assertEquals(Visibility.RUNTIME, ((DexAnnotationNode) actualVisitAnnotationResult).visibility);
    assertTrue(((DexAnnotationNode) actualVisitAnnotationResult).items.isEmpty());
  }

  /**
   * Test {@link DexAnnotationNode#visitEnum(String, String, String)}.
   *
   * <ul>
   *   <li>Then {@link DexAnnotationNode#DexAnnotationNode(String, Visibility)} with {@code Type}
   *       and visibility is {@code BUILD} {@link DexAnnotationNode#items} size is one.
   * </ul>
   *
   * <p>Method under test: {@link DexAnnotationNode#visitEnum(String, String, String)}
   */
  @Test
  @DisplayName(
      "Test visitEnum(String, String, String); then DexAnnotationNode(String, Visibility) with 'Type' and visibility is 'BUILD' items size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void proguard.dexfile.reader.node.DexAnnotationNode.visitEnum(java.lang.String, java.lang.String, java.lang.String)"
  })
  void testVisitEnum_thenDexAnnotationNodeWithTypeAndVisibilityIsBuildItemsSizeIsOne() {
    // Arrange
    DexAnnotationNode dexAnnotationNode = new DexAnnotationNode("Type", Visibility.BUILD);

    // Act
    dexAnnotationNode.visitEnum("Name", "The characteristics of someone or something", "42");

    // Assert
    List<Item> itemList = dexAnnotationNode.items;
    assertEquals(1, itemList.size());
    Item getResult = itemList.get(0);
    Object object = getResult.value;
    assertTrue(object instanceof Field);
    assertEquals("42", ((Field) object).getName());
    assertEquals("Name", getResult.name);
    assertEquals("The characteristics of someone or something", ((Field) object).getOwner());
    assertEquals("The characteristics of someone or something", ((Field) object).getType());
  }
}
