package es.upm.miw.pd.composite.article.solution;

public class ArticleLeaf extends ArticleComponent {

    private Article article;

    public ArticleLeaf(String icon, Article article) {
        super(icon);
        this.article = article;
    }

    @Override
    public boolean isComposite() {
        return false;
    }

    @Override
    public void add(ArticleComponent articleComponent) {
     // Do nothing because is leaf
    }

    @Override
    public void remove(ArticleComponent articleComponent) {
        // Do nothing because is leaf
    }

    public Article getArticle() {
        return article;
    }

}
