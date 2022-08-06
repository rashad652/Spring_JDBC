package com.application.school.service;

import com.application.school.constant.ContactConstants;
import com.application.school.model.Contact;
import com.application.school.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public ContactService() {
        System.out.println("Contact Service Bean initialized");
    }

    public boolean saveMessageDetails(Contact contact){
        boolean isSaved = false;

        //TODO - Need to persist the data into the DB table
        contact.setStatus(ContactConstants.OPEN);
        contact.setCreatedAt(LocalDateTime.now());
        contact.setCreatedBy(ContactConstants.ANONYMOUS);
        int result = contactRepository.saveContactMsg(contact);

        if (result > 0)
            isSaved = true;
        return isSaved;
    }
}
