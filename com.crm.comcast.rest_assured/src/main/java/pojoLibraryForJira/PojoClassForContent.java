package pojoLibraryForJira;

public class PojoClassForContent {
	public String type;
	public Object content;
	
	
	public PojoClassForContent(String type, Object content) {
		super();
		this.type = type;
		this.content = content;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Object getContent() {
		return content;
	}
	public void setContent(Object content) {
		this.content = content;
	}
	
	
	
}
