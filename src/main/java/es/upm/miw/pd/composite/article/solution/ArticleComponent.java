package es.upm.miw.pd.composite.article.solution;

public abstract class ArticleComponent {
    
    private String icon;

    public ArticleComponent(String icon) {
        this.icon = icon;
    }
    
    public abstract boolean isComposite();
    
    public abstract void add(ArticleComponent articleComponent);
    
    public abstract void remove(ArticleComponent articleComponent);

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

}
