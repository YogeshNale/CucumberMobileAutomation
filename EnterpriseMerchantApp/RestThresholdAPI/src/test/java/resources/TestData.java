package resources;

import java.util.ArrayList;
import java.util.List;

import poJo.Apis;
import poJo.Details;

public class TestData {

	public  Details data() {
		
		Apis ap = new Apis();
		ap.setEntity_ID("INDICO");
		ap.setApi_name("check_transaction_status");
		
		List<Apis> apiDetails = new ArrayList<>();
		apiDetails.add(ap);
		
		Details detail = new Details();
		detail.setAction("reset-api-threshold");
		detail.setApis(apiDetails);
		detail.setResolver_name("Yogesh Nale");
		detail.setDescription("Reset Axis Check status  API");
		return detail;
		
		
			
	}
	
}
