package es.upm.miw.pd.composite.treenumbers.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TreeNumbersTest {

    private TreeNumbers root;

    private TreeNumbers sub11;

    private TreeNumbers leaf;

    @BeforeEach
    void ini() {
        TreeNumbers sub1;
        TreeNumbers sub12;
        this.root = new TreeNumbersComposite("raiz");

        this.leaf = new TreeNumbersLeaf(1);
        this.root.add(leaf);
        sub1 = new TreeNumbersComposite("sub1");
        this.root.add(sub1);
        this.root.add(new TreeNumbersLeaf(7));

        this.sub11 = new TreeNumbersComposite("sub11");
        sub1.add(sub11);
        sub1.add(new TreeNumbersLeaf(4));
        sub12 = new TreeNumbersComposite("sub12");
        sub1.add(sub12);

        this.sub11.add(new TreeNumbersLeaf(2));
        this.sub11.add(new TreeNumbersLeaf(3));

        sub12.add(new TreeNumbersLeaf(-5));
        sub12.add(new TreeNumbersLeaf(6));
    }

    @Test
    void testNumberOfTreeNumbersIfLeaf() {
        assertEquals(1, this.leaf.number());
    }

    @Test
    void testNumberOfTreeNumbersIfComposite() {
        assertEquals(3, this.root.number());
        assertEquals(2, this.sub11.number());
    }

    @Test
    void testSumIfLeaf() {
        assertEquals(1, this.leaf.sum());
    }

    @Test
    void testSumIfComposite() {
        assertEquals(18, this.root.sum());
    }

    @Test
    void testHigherIfLeaf() {
        assertEquals(1, this.leaf.higher());
    }

    @Test
    void testHigherIfComposite() {
        assertEquals(7, this.root.higher());
    }

    @Test
    void testAddLeaf() {
        assertThrows(UnsupportedOperationException.class, () -> this.leaf.add(new TreeNumbersLeaf(2)));
    }

}
