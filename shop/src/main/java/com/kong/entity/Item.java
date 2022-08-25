package com.kong.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.kong.constant.ItemSellStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="item")
@Getter
@Setter
@ToString

public class Item {
	@Id
	@Column(name ="item_id")
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;   //상품코드
	@Column(nullable = false, length = 50)
	private String itemNm; // 상품명
	@Column(name = "price", nullable = false)
	private int price;
	@Column(nullable = false)
	private int stockNumber;
	@Lob
	@Column(nullable = false)
	private String itemDetail;
	@Enumerated(EnumType.STRING)
	private ItemSellStatus itemSellStatus;
	private LocalDateTime regTime;
	private LocalDateTime updateTime;

}
