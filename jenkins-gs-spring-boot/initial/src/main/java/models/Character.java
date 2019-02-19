package models;

public class Character {
  public static int idCounter = 0;
  public int Id;
  public String Name;

  public Character(String _name){
    Id = idCounter++;
    Name = _name;
  }
}
