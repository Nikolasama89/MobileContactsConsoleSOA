package gr.aueb.cf.mobilecontacts.core.serializer;

import gr.aueb.cf.mobilecontacts.dto.MobileContactReadOnlyDTO;

public class Serializer {

    private Serializer() {}

    /**
     * No instances of this class should be available
     */
    public static String serializeDTO(MobileContactReadOnlyDTO readOnlyDTO) {
        return "ID: " + readOnlyDTO.getId() + ", Name: " + readOnlyDTO.getFirstname()
                + ", LastName: " + readOnlyDTO.getLastname() + ", Phone number: " + readOnlyDTO.getPhoneNumber();
    }
}
