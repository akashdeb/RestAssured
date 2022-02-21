package pojoLibraryForJira;

public class PojoClassForDescription {
	
	public String type;
	public int version;
	public Object content;
	
	public PojoClassForDescription() {
		// TODO Auto-generated constructor stub
	}

	public PojoClassForDescription(String type, int version, Object content) {
		super();
		this.type = type;
		this.version = version;
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	
}
