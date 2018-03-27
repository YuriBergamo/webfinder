package br.com.odontoresearch.webfinder.data;

public class Term {
    private String term;
    private String field;
    private Integer count;
    private String explode;

    public Term() {
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getExplode() {
        return explode;
    }

    public void setExplode(String explode) {
        this.explode = explode;
    }
}
