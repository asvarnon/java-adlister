public class QuotesDAOFactory {
    private static QuotesManager quotesDAO;

    public static QuotesManager getQuotesManager(){
        if(quotesDAO == null) {
            quotesDAO = new ListQuotes();
        }
        return quotesDAO;
    }
}
