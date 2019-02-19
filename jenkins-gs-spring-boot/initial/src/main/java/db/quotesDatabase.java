package db;

import models.Quote;
import models.Character;
import java.util.ArrayList;
import java.util.List;

public class quotesDatabase {

    public static List<Quote> quotes;
    private characterDatabase characterDb;

    public quotesDatabase() {
        this.characterDb = new characterDatabase();
        this.quotes = new ArrayList<Quote>();
        this.quotes.add(
          new Quote(
            this.characterDb.characters.get(0),
            "That's what I do, I drink and I know things."
          )
        );
        this.quotes.add(
          new Quote(
            this.characterDb.characters.get(1),
            "How do you plead... Lord Baelish?"
          )
        );
        this.quotes.add(
          new Quote(
            this.characterDb.characters.get(2),
            "The lion does not concern itself with the opinions of sheep."
          )
        );
    }

    public Quote getById(int id) {
      Quote selected = null;
      for(Quote quote : this.quotes) {
        if(quote.Id == id){
          selected = quote;
        }
      }
      return selected;
    }

    public void deleteById(int id){
      Quote toDelete = getById(id);
      int index = this.quotes.indexOf(toDelete);
      if(index != -1){
        this.quotes.remove(index);
      }
    }

    public Quote add(int id, String quoteString){
      Character character = this.characterDb.getById(id);
      Quote newQuote = new Quote(
        character,
        quoteString
      );
      this.quotes.add(newQuote);
      return newQuote;
    }
}
