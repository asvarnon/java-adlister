import java.io.Serializable;

public class Quote implements Serializable {

    private static long quoteCount = 0;
    private long id;
    private String authorFirstName;
    private String authorLastName;
    private String content;

    public Quote(){}

    public Quote(String first, String last, String quote){
        quoteCount++;
        this.id = quoteCount;
        this.authorFirstName = first;
        this.authorLastName = last;
        this.content = quote;

    }

    //getters
    public long getId(){
        return id;
    }
    public String getAuthorFirstName(){
        return authorFirstName;
    }
    public String getAuthorLastName(){
        return authorLastName;
    }
    public String getContent(){
        return content;
    }

    //setters
    public void setId(long id){
        this.id = id;
    }
    public void setAuthorFirstName(String authorFirstName){
        this.authorFirstName = authorFirstName;
    }
    public void setAuthorLastName(String authorLastName){
        this.authorLastName = authorLastName;
    }
    public void setContent(String content){
        this.content = content;
    }


}
