package proguard.dexfile.reader.node;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
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
import proguard.dexfile.reader.Method;
import proguard.dexfile.reader.Proto;
import proguard.dexfile.reader.Visibility;
import proguard.dexfile.reader.visitors.DexClassVisitor;
import proguard.dexfile.reader.visitors.DexFileVisitor;

class DexFileNodeDiffblueTest {
  /**
   * Test {@link DexFileNode#visitDexFileVersion(int)}.
   *
   * <p>Method under test: {@link DexFileNode#visitDexFileVersion(int)}
   */
  @Test
  @DisplayName("Test visitDexFileVersion(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexFileNode.visitDexFileVersion(int)"})
  void testVisitDexFileVersion() {
    // Arrange
    DexFileNode dexFileNode = new DexFileNode();

    // Act
    dexFileNode.visitDexFileVersion(1);

    // Assert
    assertEquals(1, dexFileNode.dexVersion);
  }

  /**
   * Test {@link DexFileNode#visit(int, String, String, String[])}.
   *
   * <ul>
   *   <li>Given {@link DexFileNode} (default constructor).
   *   <li>Then return {@link DexClassNode}.
   * </ul>
   *
   * <p>Method under test: {@link DexFileNode#visit(int, String, String, String[])}
   */
  @Test
  @DisplayName(
      "Test visit(int, String, String, String[]); given DexFileNode (default constructor); then return DexClassNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DexClassVisitor DexFileNode.visit(int, String, String, String[])"})
  void testVisit_givenDexFileNode_thenReturnDexClassNode() {
    // Arrange
    DexFileNode dexFileNode = new DexFileNode();

    // Act
    DexClassVisitor actualVisitResult =
        dexFileNode.visit(1, "Class Name", "Super Class", new String[] {"Interface Names"});

    // Assert
    assertTrue(actualVisitResult instanceof DexClassNode);
    assertEquals("Class Name", ((DexClassNode) actualVisitResult).className);
    assertEquals("Super Class", ((DexClassNode) actualVisitResult).superClass);
    assertNull(((DexClassNode) actualVisitResult).source);
    assertNull(((DexClassNode) actualVisitResult).anns);
    assertNull(((DexClassNode) actualVisitResult).fields);
    assertNull(((DexClassNode) actualVisitResult).methods);
    assertEquals(1, dexFileNode.clzs.size());
    assertEquals(1, ((DexClassNode) actualVisitResult).access);
    assertArrayEquals(
        new String[] {"Interface Names"}, ((DexClassNode) actualVisitResult).interfaceNames);
  }

  /**
   * Test {@link DexFileNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexFileNode#accept(DexClassVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexClassVisitor) with 'dcv'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexFileNode.accept(DexClassVisitor)"})
  void testAcceptWithDcv() {
    // Arrange
    String[] interfaceNames = new String[] {"Interface Names"};

    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    dexClassNode.visitAnnotation("Name", Visibility.BUILD);

    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    dexClassNodeList.add(dexClassNode);
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;
    String[] interfaceNames2 = new String[] {"Interface Names"};
    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", interfaceNames2);

    // Act
    dexFileNode.accept(dcv);

    // Assert
    List<DexAnnotationNode> dexAnnotationNodeList = dcv.anns;
    assertEquals(1, dexAnnotationNodeList.size());
    DexAnnotationNode getResult = dexAnnotationNodeList.get(0);
    assertEquals("Name", getResult.type);
    assertEquals(Visibility.BUILD, getResult.visibility);
    assertTrue(getResult.items.isEmpty());
  }

  /**
   * Test {@link DexFileNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexFileNode#accept(DexClassVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexClassVisitor) with 'dcv'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexFileNode.accept(DexClassVisitor)"})
  void testAcceptWithDcv2() {
    // Arrange
    String[] interfaceNames = new String[] {"Interface Names"};

    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    Field field = new Field("Owner", "Name", "Type");
    dexClassNode.visitField(1, field, Constant.Null);

    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    dexClassNodeList.add(dexClassNode);
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;
    String[] interfaceNames2 = new String[] {"Interface Names"};
    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", interfaceNames2);

    // Act
    dexFileNode.accept(dcv);

    // Assert
    List<DexFieldNode> dexFieldNodeList = dcv.fields;
    assertEquals(1, dexFieldNodeList.size());
    DexFieldNode getResult = dexFieldNodeList.get(0);
    assertNull(getResult.anns);
    assertEquals(1, getResult.access);
    assertSame(field, getResult.field);
  }

  /**
   * Test {@link DexFileNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexFileNode#accept(DexClassVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexClassVisitor) with 'dcv'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexFileNode.accept(DexClassVisitor)"})
  void testAcceptWithDcv3() {
    // Arrange
    String[] interfaceNames = new String[] {"Interface Names"};

    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);
    dexClassNode.visitMethod(1, method);

    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    dexClassNodeList.add(dexClassNode);
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;
    String[] interfaceNames2 = new String[] {"Interface Names"};
    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", interfaceNames2);

    // Act
    dexFileNode.accept(dcv);

    // Assert
    List<DexMethodNode> dexMethodNodeList = dcv.methods;
    assertEquals(1, dexMethodNodeList.size());
    DexMethodNode getResult = dexMethodNodeList.get(0);
    assertNull(getResult.anns);
    assertNull(getResult.parameterAnns);
    assertNull(getResult.codeNode);
    assertEquals(1, getResult.access);
    assertSame(method, getResult.method);
  }

  /**
   * Test {@link DexFileNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexFileNode#accept(DexClassVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexClassVisitor) with 'dcv'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexFileNode.accept(DexClassVisitor)"})
  void testAcceptWithDcv4() {
    // Arrange
    String[] interfaceNames = new String[] {"Interface Names"};

    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    dexClassNode.visitSource("File");

    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    dexClassNodeList.add(dexClassNode);
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;
    String[] interfaceNames2 = new String[] {"Interface Names"};
    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", interfaceNames2);

    // Act
    dexFileNode.accept(dcv);

    // Assert
    assertEquals("File", dcv.source);
    assertNull(dcv.anns);
    assertNull(dcv.fields);
    assertNull(dcv.methods);
  }

  /**
   * Test {@link DexFileNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexFileNode#accept(DexClassVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexClassVisitor) with 'dcv'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexFileNode.accept(DexClassVisitor)"})
  void testAcceptWithDcv5() {
    // Arrange
    String[] interfaceNames = new String[] {"Interface Names"};

    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    dexClassNode.visitAnnotation("Name", Visibility.BUILD);

    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    dexClassNodeList.add(dexClassNode);
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;
    String[] interfaceNames2 = new String[] {"Interface Names"};

    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", interfaceNames2);
    dcv.visitAnnotation("Name", Visibility.BUILD);

    // Act
    dexFileNode.accept(dcv);

    // Assert
    List<DexAnnotationNode> dexAnnotationNodeList = dcv.anns;
    assertEquals(2, dexAnnotationNodeList.size());
    DexAnnotationNode getResult = dexAnnotationNodeList.get(1);
    assertEquals("Name", getResult.type);
    assertEquals(Visibility.BUILD, getResult.visibility);
    assertTrue(getResult.items.isEmpty());
  }

  /**
   * Test {@link DexFileNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexFileNode#accept(DexClassVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexClassVisitor) with 'dcv'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexFileNode.accept(DexClassVisitor)"})
  void testAcceptWithDcv6() {
    // Arrange
    String[] interfaceNames = new String[] {"Interface Names"};

    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    Field field = new Field("Owner", "Name", "Type");
    dexClassNode.visitField(1, field, Constant.Null);

    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    dexClassNodeList.add(dexClassNode);
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;
    String[] interfaceNames2 = new String[] {"Interface Names"};

    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", interfaceNames2);
    Field field2 = new Field("Owner", "Name", "Type");
    dcv.visitField(1, field2, Constant.Null);

    // Act
    dexFileNode.accept(dcv);

    // Assert
    List<DexFieldNode> dexFieldNodeList = dcv.fields;
    assertEquals(2, dexFieldNodeList.size());
    DexFieldNode getResult = dexFieldNodeList.get(1);
    assertNull(getResult.anns);
    assertEquals(1, getResult.access);
    assertSame(field, getResult.field);
  }

  /**
   * Test {@link DexFileNode#accept(DexClassVisitor)} with {@code dcv}.
   *
   * <p>Method under test: {@link DexFileNode#accept(DexClassVisitor)}
   */
  @Test
  @DisplayName("Test accept(DexClassVisitor) with 'dcv'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexFileNode.accept(DexClassVisitor)"})
  void testAcceptWithDcv7() {
    // Arrange
    String[] interfaceNames = new String[] {"Interface Names"};

    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);
    dexClassNode.visitMethod(1, method);

    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    dexClassNodeList.add(dexClassNode);
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;
    String[] interfaceNames2 = new String[] {"Interface Names"};

    DexClassNode dcv = new DexClassNode(1, "Class Name", "Super Class", interfaceNames2);
    String[] parameterTypes2 = new String[] {"Parameter Types"};
    Proto proto2 = new Proto(parameterTypes2, "Return Type");
    Method method2 = new Method("Owner", "Name", proto2);
    dcv.visitMethod(1, method2);

    // Act
    dexFileNode.accept(dcv);

    // Assert
    List<DexMethodNode> dexMethodNodeList = dcv.methods;
    assertEquals(2, dexMethodNodeList.size());
    DexMethodNode getResult = dexMethodNodeList.get(1);
    assertNull(getResult.anns);
    assertNull(getResult.parameterAnns);
    assertNull(getResult.codeNode);
    assertEquals(1, getResult.access);
    assertSame(method, getResult.method);
  }

  /**
   * Test {@link DexFileNode#accept(DexFileVisitor)} with {@code dfv}.
   *
   * <ul>
   *   <li>Given {@link DexFileNode} (default constructor).
   *   <li>When {@link DexFileVisitor#DexFileVisitor()}.
   *   <li>Then {@link DexFileNode} (default constructor) {@link DexFileNode#clzs} Empty.
   * </ul>
   *
   * <p>Method under test: {@link DexFileNode#accept(DexFileVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexFileVisitor) with 'dfv'; given DexFileNode (default constructor); when DexFileVisitor(); then DexFileNode (default constructor) clzs Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexFileNode.accept(DexFileVisitor)"})
  void testAcceptWithDfv_givenDexFileNode_whenDexFileVisitor_thenDexFileNodeClzsEmpty() {
    // Arrange
    DexFileNode dexFileNode = new DexFileNode();

    // Act
    dexFileNode.accept(new DexFileVisitor());

    // Assert that nothing has changed
    assertTrue(dexFileNode.clzs.isEmpty());
  }

  /**
   * Test {@link DexFileNode#accept(DexFileVisitor)} with {@code dfv}.
   *
   * <ul>
   *   <li>Then {@link DexFileNode} (default constructor) {@link DexFileNode#clzs} first {@link
   *       DexClassNode#anns} size is one.
   * </ul>
   *
   * <p>Method under test: {@link DexFileNode#accept(DexFileVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexFileVisitor) with 'dfv'; then DexFileNode (default constructor) clzs first anns size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexFileNode.accept(DexFileVisitor)"})
  void testAcceptWithDfv_thenDexFileNodeClzsFirstAnnsSizeIsOne() {
    // Arrange
    String[] interfaceNames = new String[] {"Interface Names"};

    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    dexClassNode.visitAnnotation("Name", Visibility.BUILD);

    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    dexClassNodeList.add(dexClassNode);
    String[] interfaceNames2 = new String[] {"Interface Names"};
    DexClassNode dexClassNode2 = new DexClassNode(1, "Class Name", "Super Class", interfaceNames2);
    dexClassNodeList.add(dexClassNode2);
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;
    DexFileNode dfv = new DexFileNode();

    // Act
    dexFileNode.accept(dfv);

    // Assert
    List<DexClassNode> dexClassNodeList2 = dfv.clzs;
    assertEquals(2, dexClassNodeList2.size());
    List<DexAnnotationNode> dexAnnotationNodeList = dexClassNodeList2.get(0).anns;
    assertEquals(1, dexAnnotationNodeList.size());
    DexAnnotationNode getResult = dexAnnotationNodeList.get(0);
    assertEquals("Name", getResult.type);
    assertEquals(Visibility.BUILD, getResult.visibility);
    assertTrue(getResult.items.isEmpty());
  }

  /**
   * Test {@link DexFileNode#accept(DexFileVisitor)} with {@code dfv}.
   *
   * <ul>
   *   <li>Then {@link DexFileNode} (default constructor) {@link DexFileNode#clzs} first {@link
   *       DexClassNode#fields} size is one.
   * </ul>
   *
   * <p>Method under test: {@link DexFileNode#accept(DexFileVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexFileVisitor) with 'dfv'; then DexFileNode (default constructor) clzs first fields size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexFileNode.accept(DexFileVisitor)"})
  void testAcceptWithDfv_thenDexFileNodeClzsFirstFieldsSizeIsOne() {
    // Arrange
    String[] interfaceNames = new String[] {"Interface Names"};

    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    Field field = new Field("Owner", "Name", "Type");
    dexClassNode.visitField(1, field, Constant.Null);

    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    dexClassNodeList.add(dexClassNode);
    String[] interfaceNames2 = new String[] {"Interface Names"};
    DexClassNode dexClassNode2 = new DexClassNode(1, "Class Name", "Super Class", interfaceNames2);
    dexClassNodeList.add(dexClassNode2);
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;
    DexFileNode dfv = new DexFileNode();

    // Act
    dexFileNode.accept(dfv);

    // Assert
    List<DexClassNode> dexClassNodeList2 = dfv.clzs;
    assertEquals(2, dexClassNodeList2.size());
    List<DexFieldNode> dexFieldNodeList = dexClassNodeList2.get(0).fields;
    assertEquals(1, dexFieldNodeList.size());
    DexFieldNode getResult = dexFieldNodeList.get(0);
    assertNull(getResult.anns);
    assertEquals(1, getResult.access);
    assertSame(field, getResult.field);
  }

  /**
   * Test {@link DexFileNode#accept(DexFileVisitor)} with {@code dfv}.
   *
   * <ul>
   *   <li>Then {@link DexFileNode} (default constructor) {@link DexFileNode#clzs} first {@link
   *       DexClassNode#methods} size is one.
   * </ul>
   *
   * <p>Method under test: {@link DexFileNode#accept(DexFileVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexFileVisitor) with 'dfv'; then DexFileNode (default constructor) clzs first methods size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexFileNode.accept(DexFileVisitor)"})
  void testAcceptWithDfv_thenDexFileNodeClzsFirstMethodsSizeIsOne() {
    // Arrange
    String[] interfaceNames = new String[] {"Interface Names"};

    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    String[] parameterTypes = new String[] {"Parameter Types"};
    Proto proto = new Proto(parameterTypes, "Return Type");
    Method method = new Method("Owner", "Name", proto);
    dexClassNode.visitMethod(1, method);

    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    dexClassNodeList.add(dexClassNode);
    String[] interfaceNames2 = new String[] {"Interface Names"};
    DexClassNode dexClassNode2 = new DexClassNode(1, "Class Name", "Super Class", interfaceNames2);
    dexClassNodeList.add(dexClassNode2);
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;
    DexFileNode dfv = new DexFileNode();

    // Act
    dexFileNode.accept(dfv);

    // Assert
    List<DexClassNode> dexClassNodeList2 = dfv.clzs;
    assertEquals(2, dexClassNodeList2.size());
    List<DexMethodNode> dexMethodNodeList = dexClassNodeList2.get(0).methods;
    assertEquals(1, dexMethodNodeList.size());
    DexMethodNode getResult = dexMethodNodeList.get(0);
    assertNull(getResult.anns);
    assertNull(getResult.parameterAnns);
    assertNull(getResult.codeNode);
    assertEquals(1, getResult.access);
    assertSame(method, getResult.method);
  }

  /**
   * Test {@link DexFileNode#accept(DexFileVisitor)} with {@code dfv}.
   *
   * <ul>
   *   <li>Then {@link DexFileNode} (default constructor) {@link DexFileNode#clzs} first {@link
   *       DexClassNode#source} is {@code File}.
   * </ul>
   *
   * <p>Method under test: {@link DexFileNode#accept(DexFileVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexFileVisitor) with 'dfv'; then DexFileNode (default constructor) clzs first source is 'File'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexFileNode.accept(DexFileVisitor)"})
  void testAcceptWithDfv_thenDexFileNodeClzsFirstSourceIsFile() {
    // Arrange
    String[] interfaceNames = new String[] {"Interface Names"};

    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    dexClassNode.visitSource("File");

    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    dexClassNodeList.add(dexClassNode);
    String[] interfaceNames2 = new String[] {"Interface Names"};
    DexClassNode dexClassNode2 = new DexClassNode(1, "Class Name", "Super Class", interfaceNames2);
    dexClassNodeList.add(dexClassNode2);
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;
    DexFileNode dfv = new DexFileNode();

    // Act
    dexFileNode.accept(dfv);

    // Assert
    List<DexClassNode> dexClassNodeList2 = dfv.clzs;
    assertEquals(2, dexClassNodeList2.size());
    DexClassNode getResult = dexClassNodeList2.get(0);
    assertEquals("File", getResult.source);
    assertNull(getResult.anns);
    assertNull(getResult.fields);
    assertNull(getResult.methods);
  }

  /**
   * Test {@link DexFileNode#accept(DexFileVisitor)} with {@code dfv}.
   *
   * <ul>
   *   <li>When {@link DexFileNode} (default constructor).
   *   <li>Then {@link DexFileNode} (default constructor) {@link DexFileNode#clzs} first {@link
   *       DexClassNode#source} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DexFileNode#accept(DexFileVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexFileVisitor) with 'dfv'; when DexFileNode (default constructor); then DexFileNode (default constructor) clzs first source is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexFileNode.accept(DexFileVisitor)"})
  void testAcceptWithDfv_whenDexFileNode_thenDexFileNodeClzsFirstSourceIsNull() {
    // Arrange
    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    String[] interfaceNames = new String[] {"Interface Names"};
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    dexClassNodeList.add(dexClassNode);
    String[] interfaceNames2 = new String[] {"Interface Names"};
    DexClassNode dexClassNode2 = new DexClassNode(1, "Class Name", "Super Class", interfaceNames2);
    dexClassNodeList.add(dexClassNode2);
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;
    DexFileNode dfv = new DexFileNode();

    // Act
    dexFileNode.accept(dfv);

    // Assert
    List<DexClassNode> dexClassNodeList2 = dfv.clzs;
    assertEquals(2, dexClassNodeList2.size());
    DexClassNode getResult = dexClassNodeList2.get(0);
    assertNull(getResult.source);
    assertNull(getResult.anns);
    assertNull(getResult.fields);
    assertNull(getResult.methods);
  }

  /**
   * Test {@link DexFileNode#accept(DexFileVisitor)} with {@code dfv}.
   *
   * <ul>
   *   <li>When {@link DexFileVisitor#DexFileVisitor(DexFileVisitor)} with visitor is {@link
   *       DexFileVisitor#DexFileVisitor()}.
   * </ul>
   *
   * <p>Method under test: {@link DexFileNode#accept(DexFileVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexFileVisitor) with 'dfv'; when DexFileVisitor(DexFileVisitor) with visitor is DexFileVisitor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexFileNode.accept(DexFileVisitor)"})
  void testAcceptWithDfv_whenDexFileVisitorWithVisitorIsDexFileVisitor() {
    // Arrange
    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    String[] interfaceNames = new String[] {"Interface Names"};
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    dexClassNodeList.add(dexClassNode);
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;

    // Act
    dexFileNode.accept(new DexFileVisitor(new DexFileVisitor()));

    // Assert that nothing has changed
    assertEquals(1, dexFileNode.clzs.size());
  }

  /**
   * Test {@link DexFileNode#accept(DexFileVisitor)} with {@code dfv}.
   *
   * <ul>
   *   <li>When {@link DexFileVisitor#DexFileVisitor()}.
   *   <li>Then {@link DexFileNode} (default constructor) {@link DexFileNode#clzs} size is one.
   * </ul>
   *
   * <p>Method under test: {@link DexFileNode#accept(DexFileVisitor)}
   */
  @Test
  @DisplayName(
      "Test accept(DexFileVisitor) with 'dfv'; when DexFileVisitor(); then DexFileNode (default constructor) clzs size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexFileNode.accept(DexFileVisitor)"})
  void testAcceptWithDfv_whenDexFileVisitor_thenDexFileNodeClzsSizeIsOne() {
    // Arrange
    ArrayList<DexClassNode> dexClassNodeList = new ArrayList<>();
    String[] interfaceNames = new String[] {"Interface Names"};
    DexClassNode dexClassNode = new DexClassNode(1, "Class Name", "Super Class", interfaceNames);
    dexClassNodeList.add(dexClassNode);
    DexFileNode dexFileNode = new DexFileNode();
    dexFileNode.clzs = dexClassNodeList;

    // Act
    dexFileNode.accept(new DexFileVisitor());

    // Assert that nothing has changed
    assertEquals(1, dexFileNode.clzs.size());
  }

  /**
   * Test new {@link DexFileNode} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link DexFileNode}
   */
  @Test
  @DisplayName("Test new DexFileNode (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DexFileNode.<init>()"})
  void testNewDexFileNode() {
    // Arrange, Act and Assert
    assertTrue(new DexFileNode().clzs.isEmpty());
  }
}
