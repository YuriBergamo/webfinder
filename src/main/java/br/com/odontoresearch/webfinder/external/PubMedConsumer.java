package br.com.odontoresearch.webfinder.external;

import br.com.odontoresearch.webfinder.data.SearchDomain;
import br.com.odontoresearch.webfinder.util.GetHandlerDTO;
import br.com.odontoresearch.webfinder.util.XMLConverter;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class PubMedConsumer {
    public PubMedConsumer() {
    }

    private final String PUB_MED_URL ="https://eutils.ncbi.nlm.nih.gov/entrez/eutils/esearch.fcgi?db=pubmed";

    public SearchDomain getAllByTerm(String term) throws Exception{

        GetHandlerDTO response = getHandler(generateUrl(term, null, null), getHeadersByReturnType(MediaType.APPLICATION_XML_VALUE));
        if (response != null || response.getErrorMessage() != null) {
            //TODO create a service that converts xml to SearchDomain
            return null;// XMLConverter.getMapFromXml(response.getObject());
        }else{
            throw new Exception(response.getErrorMessage());
        }
    }

    private String generateUrl(String term, String filter, Integer page){
        return PUB_MED_URL+"&term="+term;
    }

    private GetHandlerDTO getHandler(String url, HttpHeaders headers){
        try{
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            if ( response.getStatusCode() == HttpStatus.OK  && response.getBody() == null) {
                return null;
            }
            return new GetHandlerDTO(null, response.getBody(), 200) ;
        } catch ( HttpClientErrorException h ) {
            return new GetHandlerDTO(h.getMessage(), null, h.getStatusCode().value());

        } catch ( Exception e ) {
            return new GetHandlerDTO("FATAL ERROR - SEARCH " + url, null, 500);
        }
    }

    private HttpHeaders getHeadersByReturnType(String type){
        HttpHeaders headers = new HttpHeaders();

        if(MediaType.APPLICATION_JSON_VALUE.equals(type)){
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        }
        if(MediaType.APPLICATION_XML_VALUE.equals(type)){
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
        }
        return headers;
    }
}
