package com.transporterapi.controller;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.transporterapi.Service.LeadsService;
import com.transporterapi.bean.Leads;
import com.transporterapi.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/lead")
public class LeadsController {
	
	@Autowired
	LeadsService leadsService;
	
	@PostMapping("/create")
	public ResponseEntity<Leads> createLeads(@RequestBody Leads leads) {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		leads.setLeadId(dbFirestore.collection("Leads").document().getId());
		leads=leadsService.createLeads(leads);
		return new ResponseEntity<Leads>(leads,HttpStatus.OK);
	}
	
	@GetMapping("/all-lead/{userId}")
	public ResponseEntity<ArrayList<Leads>> getAllLeads(@PathVariable("userId") String id) throws InterruptedException, ExecutionException{		
		ArrayList<Leads> al=leadsService.getAllLeads(id);
		return new ResponseEntity<ArrayList<Leads>>(al,HttpStatus.OK) ;
	}
	
	@GetMapping("/{leadId}")
	public ResponseEntity<Leads> getLeadById(@PathVariable("leadId") String id)throws ResourceNotFoundException, InterruptedException, ExecutionException {
		Leads lead=leadsService.getLeadById(id);
		return new ResponseEntity<Leads>(lead,HttpStatus.OK);
	}
	
	@GetMapping("/confirm-lead/{userId}")
	public ResponseEntity<ArrayList<Leads>> getConfirmLeads(@PathVariable("userId") String id) throws InterruptedException, ExecutionException{
		ArrayList<Leads>al=leadsService.getConfirmLeads(id);
		return new ResponseEntity<ArrayList<Leads>>(al,HttpStatus.OK);
	}
	
	@GetMapping("/completed-lead/{userId}")
	public ResponseEntity<ArrayList<Leads>> getCompletedLeads(@PathVariable("userId") String id) throws InterruptedException, ExecutionException{
		ArrayList<Leads>al=leadsService.getCompletedLeads(id);
		return new ResponseEntity<ArrayList<Leads>>(al,HttpStatus.OK);
	}
	
	@DeleteMapping("/{leadId}")
	public ResponseEntity<Leads> deleteLeadById(@PathVariable("leadId") String id)throws ResourceNotFoundException, InterruptedException, ExecutionException {
		Leads lead= leadsService.deleteLeadById(id);
		return new ResponseEntity<Leads>(lead,HttpStatus.OK) ;
	}
}