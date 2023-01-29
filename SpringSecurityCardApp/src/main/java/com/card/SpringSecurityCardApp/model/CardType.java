package com.card.SpringSecurityCardApp.model;

import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@Table(name = "cardType")
public class CardType {
	@Id // to set as primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // to set as auto-increment
	private int code_card;
	@Column(name = "bin_code")
	private String binCode;
	@Column(name = "description")
	private String description;
	@Column(name = "is_active")
	private String activeFlag;
	@Column(name = "createDate")
	private String createDate;
	@Column(name = "cardTypeName")
	private String cardTypeName;
	@Column(name = "validateFrom")
	private Timestamp validateFrom;
	@Column(name = "validateTo")
	private Timestamp validateTo;
	@Column(name = "monthlyLimit")
	private String monthlyLimit;
	@Column(name = "dailyLimit")
	private String dailyLimit;
	@Column(name = "instrumentId")
	private String instrumentId;

}
