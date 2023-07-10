package com.in28minutes.junittestservice.jsonassert;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {
	
	private String actualValue="{\"id\":1,\"name\":\"Ball\",\"price\":10.0,\"quantity\":100}";

	@Test
	public void jsonAssert_stricTrue() throws JSONException {
		String expectedValue="{\"id\":1,\"name\":\"Ball\",\"price\":10.0,\"quantity\":100}";
		JSONAssert.assertEquals(expectedValue, actualValue, true);
	}
	
	@Test
	public void jsonAssert_strictFalse() throws JSONException {
		String expectedValue="{\"id\":1,\"name\":\"Ball\",\"price\":10.0}";
		JSONAssert.assertEquals(expectedValue, actualValue, false);
	}
	
	@Test
	public void jsonAssert_withoutEscapeCharacter() throws JSONException {
		String expectedValue="{id:1,name:Ball,price:10.0}"; //"" is needed only when we have spaces in value
		JSONAssert.assertEquals(expectedValue, actualValue, false);
	}
}
