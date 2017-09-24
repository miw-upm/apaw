package es.upm.miw.pd.composite;

public class Composite extends Component {
    private java.util.List<Component> list;

    public Composite(String name) {
        super(name);
        this.list = new java.util.ArrayList<Component>();
    }

    @Override
    public String view(String head) {
        String result = "";
        result += head + "-" + this.getName() + ":" + "\n";
        for (Component item : list) {
            result += item.view(head + "  ");
        }
        return result;
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
