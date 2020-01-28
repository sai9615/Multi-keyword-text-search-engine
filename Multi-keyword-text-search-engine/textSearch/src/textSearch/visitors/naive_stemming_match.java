package textSearch.visitors;

public class naive_stemming_match implements element{
    public void accept(visitor vis){
        vis.visit(this);
    }
}