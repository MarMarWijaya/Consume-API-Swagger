/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entities.res;

import lombok.Data;

/**
 *
 * @author Mario Wijaya
 */
@Data
public class ProfileBasic {
    private String id;
    private String name;
    private String birthDate;
    private String gender;
    private String email;
}
