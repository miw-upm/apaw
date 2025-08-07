package es.upm.miw.apaw.model.composite.article.solution;

public interface TreeArticles {

    int id();

    String reference();

    boolean isComposite();

    void add(TreeArticles treeArticles);

    void remove(TreeArticles treeArticles);

}
