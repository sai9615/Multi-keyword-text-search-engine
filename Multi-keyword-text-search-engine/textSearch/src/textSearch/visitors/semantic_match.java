package textSearch.visitors;

public class semantic_match implements element{
    public void accept(visitor vis){
        vis.visit(this);
    }
}