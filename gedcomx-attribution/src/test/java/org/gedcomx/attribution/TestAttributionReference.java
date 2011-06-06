package org.gedcomx.attribution;

import org.testng.annotations.Test;

import java.net.URI;
import java.util.Date;

import static org.gedcomx.rt.SerializationUtil.processThroughJson;
import static org.gedcomx.rt.SerializationUtil.processThroughXml;
import static org.testng.AssertJUnit.assertEquals;

/**
 * @author Ryan Heaton
 */
@Test
public class TestAttributionReference {

  /**
   * tests attribution reference xml
   */
  public void testAttributionReferenceXml() throws Exception {
    Attribution attribution = new Attribution();
    attribution.setContributor(new ContributorReference());
    attribution.getContributor().setHref(URI.create("urn:someid"));
    attribution.setExplanation("hello, there.");
    Date ts = new Date();
    attribution.setTimestamp(ts);
    attribution = processThroughXml(attribution);
    assertEquals("urn:someid", attribution.getContributor().getHref().toString());
    assertEquals("hello, there.", attribution.getExplanation());
    assertEquals(ts, attribution.getTimestamp());
  }

  /**
   * tests attribution reference json
   */
  public void testAttributionReferenceJson() throws Exception {
    Attribution attribution = new Attribution();
    attribution.setContributor(new ContributorReference());
    attribution.getContributor().setHref(URI.create("urn:someid"));
    attribution.setExplanation("hello, there.");
    Date ts = new Date();
    attribution.setTimestamp(ts);
    attribution = processThroughJson(attribution);
    assertEquals("urn:someid", attribution.getContributor().getHref().toString());
    assertEquals("hello, there.", attribution.getExplanation());
    assertEquals(ts, attribution.getTimestamp());
  }

}