package textSearch.visitors;

public class exact_match implements element{
    public void accept(visitor vis){
        vis.visit(this);
    }
}