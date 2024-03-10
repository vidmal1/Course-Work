package course.work.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roomcategory")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoomCategoryEntity {

    @Id
    @Column(name = "CategoryID")
    private String categoryId;

    @Column(name = "CategoryName")
    private String categoryName;

    @Column(name = "CategoryDescription")
    private String categoryDescription;

    @Column(name = "Price")
    private Double price;

}
