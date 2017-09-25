package es.upm.miw.pd.composite;

public class Composite extends Component {
    private java.util.List<Component> list;

    public Composite(String name) {
        super(name);
        this.list = new java.util.ArrayList<>();
    }

    @Override
    public String view(String head) {
        StringBuilder result = new StringBuilder();
        result.append(head + "-" + this.getName() + ":" + "\n");
        for (Component item : list) {
            result.append(item.view(head + "  "));
        }
        return result.toString();
    }

    @Override
    public void add(Component cc) {
        list.add(cc);
    }

    @Override
    public void remove(Component cc) {
        list.remove(cc);
    }

    @Override
    public boolean isComposite() {
        return true;
    }

    @Override
    public String toString() {
        return "C:" + this.getName().toLowerCase();
    }

}
