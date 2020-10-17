package com.transporterapi.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import com.transporterapi.bean.Bid;
import com.transporterapi.bean.User;

@Service
public class BidService {
	
	public static final String COL_NAME="Bids";
	
	public Bid createBid(Bid bid) {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		bid.setBidId(dbFirestore.collection(COL_NAME).document().getId());
		dbFirestore.collection(COL_NAME).document(bid.getBidId()).set(bid);
		return bid;
	}
	
	public Bid deleteBidById(String id) {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		DocumentReference documentReference =dbFirestore.collection(COL_NAME).document(id);
		ApiFuture<DocumentSnapshot> future = documentReference.get();
		Bid bid;
		try {
			DocumentSnapshot document = future.get();
			if(document.exists()) {
				bid=document.toObject(Bid.class);
				dbFirestore.collection(COL_NAME).document(id).delete();
				return bid;
			}
		}catch(Exception e) {
			
		}
		return null;
	}
	public ArrayList<Bid> getAllBidsByLeadId(String id){
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ArrayList<Bid> al=new ArrayList<Bid>();
		ApiFuture<QuerySnapshot> future =dbFirestore.collection(COL_NAME).whereEqualTo("leadId",id).get();
		List<QueryDocumentSnapshot> documents;
		try {
			documents = future.get().getDocuments();
			for (QueryDocumentSnapshot document : documents) {
				   al.add(document.toObject(Bid.class));
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
		return al;
	}

	public ArrayList<Bid> getAllBids(String id) {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ArrayList<Bid> al=new ArrayList<Bid>();
		ApiFuture<QuerySnapshot> future =dbFirestore.collection(COL_NAME).whereEqualTo("transporterId",id).get();
		List<QueryDocumentSnapshot> documents;
		try {
			documents = future.get().getDocuments();
			for (QueryDocumentSnapshot document : documents) {
				   al.add(document.toObject(Bid.class));
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
		return al;
	}
}
