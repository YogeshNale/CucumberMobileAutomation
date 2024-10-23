package resources;

public enum APIResources {
	
	AxisAPI("/ams/axis/bbps/reset-threshold");
	
	private String resource;
	
	 APIResources(String resource) {
		this.resource=resource;
	}
	 public String getResource() {
		 return resource;
	 }

}
