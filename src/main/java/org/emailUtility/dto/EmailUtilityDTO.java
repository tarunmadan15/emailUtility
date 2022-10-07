package org.emailUtility.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailUtilityDTO {

    private String toEmail;
    private String subject;
    private String messageBody;
}
