package br.com.odontoresearch.webfinder.data;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class SearchDomain {
    private List<String> idList;
    private List<Term> termStack;

    public SearchDomain() {
    }

    public List<String> getIdList() {
        return idList;
    }

    public void setIdList(List<String> idList) {
        this.idList = idList;
    }

    public List<Term> getTermStack() {
        return termStack;
    }

    public void setTermStack(List<Term> termStack) {
        this.termStack = termStack;
    }
}
