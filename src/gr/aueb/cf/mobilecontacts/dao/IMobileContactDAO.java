package gr.aueb.cf.mobilecontacts.dao;

import gr.aueb.cf.mobilecontacts.model.MobileContact;

import java.util.List;

public interface IMobileContactDAO {
    //Basic CRUD
    MobileContact insert(MobileContact mobileContact);
    MobileContact update(Long id, MobileContact mobileContact);
    void deleteById(Long id);
    MobileContact getById(Long id);
    List<MobileContact> getAll();

    void deleteByPhoneNumber(String phoneNumber);

    // Queries
    MobileContact getByPhoneNumber(String phoneNumber);
    boolean userIDExists(Long id);
    boolean phoneNumberExists(String phoneNumber);


}
