package db;

import models.Quote;
import models.Character;
import java.util.ArrayList;
import java.util.List;

public class characterDatabase {

    public static List<Character> characters;

    public characterDatabase() {
        this.characters = new ArrayList<Character>();
        this.characters.add(
          new Character("Tyrion Lannister")
        );
        this.characters.add(
          new Character("Sansa Stark")
        );
        this.characters.add(
          new Character("Tywin Lannister")
        );
        this.characters.add(
          new Character("Jon Snow")
        );
        this.characters.add(
          new Character("Daenarys Targaryen")
        );
    }

    public Character getById(int id) {
      Character selected = null;
      for(Character character : this.characters) {
        if(character.Id == id){
          selected = character;
        }
      }
      return selected;
    }

    public void deleteById(int id){
      Character toDelete = getById(id);
      int index = this.characters.indexOf(toDelete);
      if(index != -1){
        this.characters.remove(index);
      }
    }

    public Character add(String characterName){
      Character newChar = new Character(characterName);
      this.characters.add(newChar);
      return newChar;
    }
}
