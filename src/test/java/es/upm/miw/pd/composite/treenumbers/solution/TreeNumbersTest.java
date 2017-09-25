package es.upm.miw.pd.composite.treenumbers.solution;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import es.upm.miw.pd.composite.treenumbers.solution.TreeNumbers;
import es.upm.miw.pd.composite.treenumbers.solution.TreeNumbersComposite;
import es.upm.miw.pd.composite.treenumbers.solution.TreeNumbersLeaf;

public class TreeNumbersTest {

    private TreeNumbers root;

    private TreeNumbers sub1;

    private TreeNumbers sub11;

    private TreeNumbers sub12;

    private TreeNumbers leaf;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void ini() {
        this.root = new TreeNumbersComposite("raiz");

        this.leaf = new TreeNumbersLeaf(1);
        this.root.add(leaf);
        this.sub1 = new TreeNumbersComposite("sub1");
        this.root.add(sub1);
        this.root.add(new TreeNumbersLeaf(7));

        this.sub11 = new TreeNumbersComposite("sub11");
        this.sub1.add(sub11);
        this.sub1.add(new TreeNumbersLeaf(4));
        this.sub12 = new TreeNumbersComposite("sub12");
        this.sub1.add(sub12);

        this.sub11.add(new TreeNumbersLeaf(2));
        this.sub11.add(new TreeNumbersLeaf(3));

        this.sub12.add(new TreeNumbersLeaf(-5));
        this.sub12.add(new TreeNumbersLeaf(6));
    }

    @Test
    public void testNumberOfTreeNumbersIfLeaf() {
        assertEquals(1, this.leaf.numberOfTreeNumbers());
    }

    @Test
    public void testNumberOfTreeNumbersIfComposite() {
        assertEquals(3, this.root.numberOfTreeNumbers());
        assertEquals(2, this.sub11.numberOfTreeNumbers());
    }

    @Test
    public void testSumIfLeaf() {
        assertEquals(1, this.leaf.sum());
    }

    @Test
    public void testSumIfComposite() {
        assertEquals(18, this.root.sum());
    }

    @Test
    public void testHigherIfLeaf() {
        assertEquals(1, this.leaf.higher());
    }

    @Test
    public void testHigherIfComposite() {
        assertEquals(7, this.root.higher());
    }

    @Test
    public void testAddLeaf() {
        exception.expect(UnsupportedOperationException.class);
        this.leaf.add(new TreeNumbersLeaf(2));
    }

}
