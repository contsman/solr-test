package brent.solrtest.query;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.SolrParams;
import org.junit.Before;
import org.junit.Test;

import brent.solrtest.beans.Person;

public class TestSolrQuery {
	private static  String serverUrl = "http://localhost:8080/solr/collection1";
	private SolrClient testSolr; 
	public static void main(String[] args) {
		SolrClient testSolr = new HttpSolrClient(serverUrl);
		SolrParams params = new SolrQuery("id:3 id:5");
		try {
			QueryResponse response = testSolr.query(params);
			SolrDocumentList list = response.getResults();
            for (int i = 0; i < list.size(); i++) {
            	SolrDocument document = list.get(i);
            	System.out.println(document);
                System.out.println(document.get("id"));
                System.out.println(document.get("title"));
                System.out.println(document.get("_version_"));
            }
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Before
	public void testBefore(){
		testSolr = new HttpSolrClient(serverUrl);
	}
	@Test
	public void testSolrAdd(){
		SolrInputDocument  document = new SolrInputDocument ();
		document.addField("id", 7);
		document.addField("title", "我用eclipse进行添加的，测试先关闭solrclient再commit");
		try {
			testSolr.add(document);
			testSolr.commit();
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(testSolr!=null){
				try {
					testSolr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@Test
	public void testSolrDel(){
		try {
			testSolr.deleteByQuery("id:1");
			testSolr.commit();
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(testSolr!=null){
				try {
					testSolr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	@Test
	public void testAddBean(){
		Person person = new Person(1,"brent","Beijing Changping Yuxinzhuang",13426057895l);
		try {
			testSolr.addBean(person);
			testSolr.commit();
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(testSolr!=null){
				try {
					testSolr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
