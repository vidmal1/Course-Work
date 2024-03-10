package course.work.entity;

import javax.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.ToString;

@Entity
@Table(name = "rooms") // Assuming table name is "rooms"
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoomEntity {

    @Id
    @Column(name = "RoomNo")
    private Integer roomNo;

    @Column(name = "CustName")
    private String custName;

    @Column(name = "RoomType")
    private String roomType;

    @Column(name = "RoomPackage")
    private String roomPackage;

    @Column(name = "Status", nullable = true)
    private String status;

}
