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
import db.quotesDatabase;
import java.util.List;

@RestController
public class QuoteController {

    public quotesDatabase quotesDB = new quotesDatabase();

    @CrossOrigin()
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Quote>> getAllQuotes() {
        return new ResponseEntity<List<Quote>>(this.quotesDB.quotes, HttpStatus.OK);
    }

    @CrossOrigin()
    @RequestMapping(value = "/add/{characterId}", method = RequestMethod.POST)
    public ResponseEntity<Quote> addQuote(@PathVariable("characterId") int id, @RequestBody String quoteString) {
        Quote newQuote = this.quotesDB.add(id, quoteString);
        return new ResponseEntity<Quote>(newQuote, HttpStatus.OK);
    }

    @CrossOrigin()
    @RequestMapping(value = "/delete/{quoteId}", method = RequestMethod.POST)
    public HttpStatus deleteQuote(@PathVariable("quoteId") int id) {
      this.quotesDB.deleteById(id);
      return HttpStatus.OK;
    }

}
