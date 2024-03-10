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
@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CustomerEntity {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Room", nullable = false)
    private Integer room;

    @Column(name = "Name")
    private String name;

    @Column(name = "Phone")
    private Integer phone;

    @Column(name = "Email")
    private String email;

    @Column(name = "Address")
    private String address;

    @Column(name = "City")
    private String city;

    @Column(name = "Nationality")
    private String nationality;

    @Column(name = "ID")
    private Integer idNo;

    @Column(name = "CheckInDate")
    private java.sql.Date checkInDate;

    @Column(name = "CheckOutDate")
    private java.sql.Date checkOutDate;

}
