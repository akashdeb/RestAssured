package pojoLibraryForJira;

public class PojoClassForJosnObject2 {
	
	public Object project;
	public String summary;
	public Object description;
	
	public PojoClassForJosnObject2() {
		// TODO Auto-generated constructor stub
	}

	public PojoClassForJosnObject2(Object project, String summary, Object description) {
		super();
		this.project = project;
		this.summary = summary;
		this.description = description;
	}

	public Object getProject() {
		return project;
	}

	public void setProject(Object project) {
		this.project = project;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Object getDescription() {
		return description;
	}

	public void setDescription(Object description) {
		this.description = description;
	}

		
}
