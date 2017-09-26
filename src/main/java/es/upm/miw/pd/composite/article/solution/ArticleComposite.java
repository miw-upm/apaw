package es.upm.miw.pd.composite.article.solution;

import java.util.ArrayList;
import java.util.List;

public class ArticleComposite extends ArticleComponent {

    List<ArticleComponent> articleComponentList;

    public ArticleComposite(String icon) {
        super(icon);
        articleComponentList = new ArrayList<>();
    }

    @Override
    public boolean isComposite() {
        return true;
    }

    @Override
    public void add(ArticleComponent articleComponent) {
        assert articleComponent != null;
        articleComponentList.add(articleComponent);
    }

    @Override
    public void remove(ArticleComponent articleComponent) {
        assert articleComponent != null;
        articleComponentList.remove(articleComponent);
    }

}
