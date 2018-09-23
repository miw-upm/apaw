package es.upm.miw.pd.composite.article.solution;

public abstract class ArticleComponent {

    private String name;

    public ArticleComponent(String name) {
        this.name = name;
    }

    public abstract boolean isComposite();

    public abstract void add(ArticleComponent articleComponent);

    public abstract void remove(ArticleComponent articleComponent);

}
