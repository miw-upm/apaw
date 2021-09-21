package es.upm.miw.pd.composite.article.solution;

import es.upm.miw.pd.composite.article.Article;

public class TreeArticlesLeaf implements TreeArticles {

    private final Article article;

    public TreeArticlesLeaf(Article article) {
        this.article = article;
    }

    @Override
    public int id() {
        return this.article.getId();
    }

    @Override
    public String reference() {
        return this.article.getReference();
    }

    @Override
    public boolean isComposite() {
        return false;
    }

    @Override
    public void add(TreeArticles treeArticles) {
        // Do nothing because it is a leaf
    }

    @Override
    public void remove(TreeArticles treeArticles) {
        // Do nothing because it is a leaf
    }

}
