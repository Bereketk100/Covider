package com.example.firebaselogin.classes;

import com.example.firebaselogin.enums.Role;

public class Student extends User {
    public Student() {
    }

    public Student(int userID, String email, String name, String username, String password){
        super(userID, email, name, username, password);
        role = Role.Student;
    }

        /*
    @Override

    public void userAddTest(Test test){

        CollectionReference mRecords = mUsers.collection("students").document(email).collection("testRecords");
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
}
