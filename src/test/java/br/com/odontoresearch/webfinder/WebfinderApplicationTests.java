package br.com.odontoresearch.webfinder;

import br.com.odontoresearch.webfinder.util.XMLConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebfinderApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void xmlConverter(){
		Map map = XMLConverter.getMapFromXml("<?xml version='1.0' encoding='UTF-8' ?><!DOCTYPE eSearchResult PUBLIC '-//NLM//DTD esearch 20060628//EN' 'https://eutils.ncbi.nlm.nih.gov/eutils/dtd/20060628/esearch.dtd'><eSearchResult><Count>285915</Count><RetMax>20</RetMax><RetStart>0</RetStart><IdList><Id>29571092</Id><Id>29570976</Id><Id>29570929</Id><Id>29570877</Id></eSearchResult>");
		System.out.println(map);
	}

}
