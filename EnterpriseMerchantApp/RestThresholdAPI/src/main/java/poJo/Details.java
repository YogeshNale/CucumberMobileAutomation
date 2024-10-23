package poJo;

import java.util.List;

public class Details {


	private String action;
	private List<Apis> apis;
	private String resolver_name;
	private String Description;
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public List<Apis> getApis() {
		return apis;
	}
	public void setApis(List<Apis> apis) {
		this.apis = apis;
	}
	public String getResolver_name() {
		return resolver_name;
	}
	public void setResolver_name(String resolver_name) {
		this.resolver_name = resolver_name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	
}
