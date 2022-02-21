package pojoLibraryForJira;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

public class callingpojo {
	@Test
	public void pojokabaap() throws JsonGenerationException, JsonMappingException, IOException {
		
		PojoClassForContent2 pcontent2=new PojoClassForContent2("text", "description");
		PojoClassForContent pcontent=new PojoClassForContent("paragraph", pcontent2);
		PojoClassForDescription pDesc=new PojoClassForDescription("doc",1,pcontent);
		PojoClassForKey pkey=new PojoClassForKey("VDEMO");
		PojoClassForJosnObject2 pObject2=new PojoClassForJosnObject2(pkey,"REST ye merry gentlemen.",pDesc);
		PojoClassForIssueType pIssueType=new PojoClassForIssueType("Bug");
		PojoClassForJosnObject1 pObject1=new PojoClassForJosnObject1(pObject2, pIssueType);
		
		ObjectMapper mapper = new ObjectMapper();
		
		mapper.writerWithDefaultPrettyPrinter().writeValue(new File ("./FileForJira.json"), mapper);
		
	}

}
