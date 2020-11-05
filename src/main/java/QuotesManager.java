import java.util.List;

public interface QuotesManager {
    List<Quote> all();
    Quote findOne(long id);
    void insert(Quote quote);
    void update(Quote quote);
    void destroy(Quote quote);
}
