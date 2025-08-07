package es.upm.miw.apaw.model.composite.article.solution;

import java.util.ArrayList;
import java.util.List;

public class TreeArticlesComposite implements TreeArticles {

    private final int id;

    private final String reference;

    private final List<TreeArticles> treeArticlesList;

    public TreeArticlesComposite(int id, String reference) {
        this.id = id;
        this.reference = reference;
        this.treeArticlesList = new ArrayList<>();
    }

    @Override
    public int id() {
        return this.id;
    }

    @Override
    public String reference() {
        return this.reference;
    }

    @Override
    public boolean isComposite() {
        return true;
    }

    @Override
    public void add(TreeArticles treeArticles) {
        treeArticlesList.add(treeArticles);
    }

    @Override
    public void remove(TreeArticles treeArticles) {
        treeArticlesList.remove(treeArticles);
    }

}
