package com.transporterapi.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.transporterapi.bean.User;
	
@Service
public class UserService {
	public static final String COL_NAME="Users";
	public User createUser(User user) {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		user.setUserId(dbFirestore.collection(COL_NAME).document().getId());
		dbFirestore.collection(COL_NAME).document(user.getUserId()).set(user);
		return user;
	}
	public User getUserById(String id) {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(id);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        User user;
        
        try {
			DocumentSnapshot document = future.get();
			if(document.exists()) {
				user=document.toObject(User.class);
				
				return user;
			}
			
        }catch(Exception e) {
        }
        return null;
	}
	
}