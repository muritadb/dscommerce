package br.com.muritadb.dscommerce.entities;

import java.time.Instant;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant moment;
  private OrderStatus status;

  @ManyToOne
  @JoinColumn(name = "client_id")
  private User client;


  @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
  private Payment payment;
  
  public User getClient() {
    return client;
  }

  public void setClient(User client) {
    this.client = client;
  }

  public Order() {
    
  }


  public Order(Long id, Instant moment, OrderStatus status, User client,Payment payment) {
    this.id = id;
    this.moment = moment;
    this.status = status;
    this.client = client;
    this.payment = payment;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Instant getMoment() {
    return moment;
  }

  public void setMoment(Instant moment) {
    this.moment = moment;
  }

  public OrderStatus getStatus() {
    return status;
  }

  public void setStatus(OrderStatus status) {
    this.status = status;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((moment == null) ? 0 : moment.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Order other = (Order) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (moment == null) {
      if (other.moment != null)
        return false;
    } else if (!moment.equals(other.moment))
      return false;
    return true;
  }

}
