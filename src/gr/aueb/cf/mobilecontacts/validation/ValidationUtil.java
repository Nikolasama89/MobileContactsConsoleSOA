package gr.aueb.cf.mobilecontacts.validation;

import gr.aueb.cf.mobilecontacts.dto.MobileContactInsertDTO;
import gr.aueb.cf.mobilecontacts.dto.MobileContactUpdateDTO;

public class ValidationUtil {
    /**
     * No instances of this class should be available.
     */


    private ValidationUtil() {}

    public static String validateDTO(MobileContactInsertDTO insertDTO) {
        String errorResponse = "";

        if (insertDTO.getPhoneNumber().length() <= 5)
            errorResponse += "Phone number must have over 5 symbols\n";

        if (insertDTO.getFirstname().length() < 2)
            errorResponse += "Name should contain minimum 2 characters.\n";

        if (insertDTO.getLastname().length() < 2)
            errorResponse += "Last name should contain minimum 2 characters.\n";

        return errorResponse;
    }

    public static String validateDTO(MobileContactUpdateDTO updateDTO) {
        String errorResponse = "";

        if (updateDTO.getPhoneNumber().length() <= 5)
            errorResponse += "Phone number must have over 5 symbols\n";

        if (updateDTO.getFirstname().length() < 2)
            errorResponse += "Name should contain minimum 2 characters.\n";

        if (updateDTO.getLastname().length() < 2)
            errorResponse += "Last name should contain minimum 2 characters.\n";

        return errorResponse;
    }
}
