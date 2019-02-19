package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import models.Quote;
import models.Character;
import db.characterDatabase;
import java.util.List;

@RestController
public class CharacterController {

    public characterDatabase characterDB = new characterDatabase();

    @CrossOrigin()
    @RequestMapping(value = "/character/all", method = RequestMethod.GET)
    public ResponseEntity<List<Character>> getAllCharacters() {
        return new ResponseEntity<List<Character>>(this.characterDB.characters, HttpStatus.OK);
    }

    @CrossOrigin()
    @RequestMapping(value = "/character/add", method = RequestMethod.POST)
    public ResponseEntity<Character> addCharacter(@RequestBody String characterName) {
        Character newCharacter = this.characterDB.add(characterName);
        return new ResponseEntity<Character>(newCharacter, HttpStatus.OK);
      }

    @CrossOrigin()
    @RequestMapping(value = "character/delete/{characterId}", method = RequestMethod.POST)
    public HttpStatus deleteCharacter(@PathVariable("characterId") int id) {
      this.characterDB.deleteById(id);
      return HttpStatus.OK;
    }

}
