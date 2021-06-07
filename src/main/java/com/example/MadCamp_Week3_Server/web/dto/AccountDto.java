package com.example.MadCamp_Week3_Server.web.dto;

import lombok.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class AccountDto {

    private String userId;

    private String password;
}
