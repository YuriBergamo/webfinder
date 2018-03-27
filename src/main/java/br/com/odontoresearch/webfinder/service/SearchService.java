package br.com.odontoresearch.webfinder.service;

import br.com.odontoresearch.webfinder.external.PubMedConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class SearchService {

    @Autowired
    private PubMedConsumer pubMedConsumer;

    @RequestMapping(value = "/{term}", method = {RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getByTerm(@PathVariable(value = "term") String term){
        //TODO go to the service and bring back the metadatas by term searched
        try {
            return new ResponseEntity(pubMedConsumer.getAllByTerm(term), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
