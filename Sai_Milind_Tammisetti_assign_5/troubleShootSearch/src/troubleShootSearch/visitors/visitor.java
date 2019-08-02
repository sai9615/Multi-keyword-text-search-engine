package troubleShootSearch.visitors;

interface visitor {
    void visit(exact_match exm);
    void visit(naive_stemming_match nsm);
    void visit(semantic_match sm);
}