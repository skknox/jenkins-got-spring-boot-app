package models;

public class Quote {

    public int Id;
    public static int idCounter = 0;
    public Character character;
    public String quote;

    public Quote(Character _character, String _quote) {
        this.character = _character;
        this.quote = _quote;
        this.Id = idCounter++;
    }

}
