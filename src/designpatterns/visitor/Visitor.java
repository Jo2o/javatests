package designpatterns.visitor;

public interface Visitor {

    void visit(Book book);

// visit other concrete items
//    void visit(CD cd);
//    void visit(DVD dvd);

}
