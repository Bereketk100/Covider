package com.example.firebaselogin.classes;

import com.example.firebaselogin.enums.InstructStatus;
import com.example.firebaselogin.enums.Role;

public class Instructor extends User{
    private InstructStatus instructStatus;

    //constructors
    public Instructor(){}

    public Instructor(int userID, String email, String name, String username, String password){
        super(userID, email, name, username, password);
        role = Role.Instructor;
    }
    //class specific
    /*
    @Override
    public void userAddTest(Test test){

        CollectionReference mRecords = mUsers.collection("instructors").document(email).collection("testRecords");
        mRecords.document(test.getDate().toString()).set(test).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Log.d(TAG, "Document has been saved!"); }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w(TAG, "Document was not saved", e);
            }
        });

        if (testRecords == null){
            testRecords = new ArrayList<>();
        }
        testRecords.add(test);
    }*/
    public void changeInstructStatus(InstructStatus instructStatus){
        this.instructStatus = instructStatus;
    }
    public void checkClassHealth(){

    }

}
