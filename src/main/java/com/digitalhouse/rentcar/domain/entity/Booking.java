package com.digitalhouse.rentcar.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("bookings")
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name="check_in")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private String checkInTime;

    @Column(name="check_out")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private String checkOutTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(length = 10)
    private Boolean isActive;

}
