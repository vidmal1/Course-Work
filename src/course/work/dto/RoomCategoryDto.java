/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package course.work.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author ASUS
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RoomCategoryDto {

    private String categoryID;
    private String categoryName;
    private String categoryDescription;
    private double price;

}
